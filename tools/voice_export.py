"""
currently supports only Freddy Pharkas (and probably few others)
based on ScummVM resource_audio.cpp
   int ResourceManager::readAudioMapSCI11(IntMapResourceSource *map)
"""

import pathlib
import os.path
import subprocess
import csv
import argparse

RES_AUD_NAME = "RESOURCE.AUD"
MAP_FILE_HEADER = [0x90, 0x00]
EndOfMapFlag = 0xff
SIERRA_AUDIO_TYPE = 0x8d


def parse_args():
    parser = argparse.ArgumentParser(
        description="Exports .wav files from RESOURCE.AUD (using 'ffmpeg.exe' in current directory)",
        formatter_class=argparse.RawTextHelpFormatter, epilog="""
Example csv file:
=================
room,   noun,   verb,   cond,   seq
230,    28,     0,      0,      1
0,      0,      0,      0,      1
230,    4,      1,      0,      1""")
    parser.add_argument('csv_file',
                        help='Path to .csv file with the messages voices to export. Should have the columns "room, noun, verb, cond, seq"')
    parser.add_argument('--input_dir', dest='input_dir', default='.',
                        help='Path to the input directory, containing RESOURCE.AUD and the audio *.MAP files (default: current dir)')
    parser.add_argument('--output_dir', dest='output_dir', default='.',
                        help='Path to the output directory (default: current dir)')
    parser.add_argument('--sol', action='store_true', help="keep .sol files, don't convert them to .wav")
    return parser.parse_args()


def read_32le(l, idx):
    return l[idx + 3] * pow(2, 24) + l[idx + 2] * pow(2, 16) + l[idx + 1] * 256 + l[idx]


def read_24le(l, idx):
    return l[idx + 2] * pow(2, 16) + l[idx + 1] * 256 + l[idx]


def file_read_string(fp, length):
    b = fp.read(length)
    result = b.decode('cp1250').strip('\0')
    return result


def parse_single_map(map, input_dir):
    input_file = os.path.join(input_dir, str(map) + ".MAP")
    in_vocab = list(pathlib.Path(input_file).read_bytes())
    assert in_vocab[0] == MAP_FILE_HEADER[0]
    assert in_vocab[1] == MAP_FILE_HEADER[1]
    in_vocab = in_vocab[2:]

    index = 0
    offset = read_32le(in_vocab, index)
    index += 4

    result = []
    while index < len(in_vocab):
        entry = {}
        entry['room'] = map
        entry['noun'] = in_vocab[index]
        entry['verb'] = in_vocab[index + 1]
        entry['cond'] = in_vocab[index + 2]
        entry['seq'] = in_vocab[index + 3]
        if entry['seq'] == EndOfMapFlag:
            break
        index += 4
        delta = read_24le(in_vocab, index)
        index += 3
        offset += delta
        entry['offset'] = offset
        result.append(entry)
    return result


def export_single_voice(entry, input_dir, output_dir):
    input_file = os.path.join(input_dir, RES_AUD_NAME)
    fp = open(input_file, 'rb')
    fp.seek(entry['offset'])

    riff_tag = get_tag(fp)
    size = get_size(fp, riff_tag)
    data = fp.read(size)
    save_data(output_dir, entry, data, riff_tag)


def get_tag(fp):
    riff_tag = file_read_string(fp, 4)
    if riff_tag == 'RIFF':
        fp.seek(-4, os.SEEK_CUR)
    else:
        fp.seek(-4, os.SEEK_CUR)
        type = ord(fp.read(1))
        assert type == SIERRA_AUDIO_TYPE
        header_size = ord(fp.read(1))
        assert header_size == 12        # other values are legal, but not supported yet
        riff_tag = file_read_string(fp, 4)
        fp.seek(-6, os.SEEK_CUR)

    return riff_tag


def get_size(fp, riff_tag=None):
    if riff_tag is None:
        riff_tag = get_tag(fp)

    if riff_tag == 'RIFF':
        fp.seek(4, os.SEEK_CUR)
        size = int.from_bytes(fp.read(4), 'little') + 8
        fp.seek(-8, os.SEEK_CUR)
    elif riff_tag == 'SOL':
        header_size = 12
        ResourceHeaderSize = 2
        fp.seek(9, os.SEEK_CUR)
        chunk_size = int.from_bytes(fp.read(4), 'little')
        size = chunk_size + header_size + ResourceHeaderSize
        fp.seek(-13, os.SEEK_CUR)
    else:
        print('get_size: Unsupported riff_tag: ', riff_tag)
    return size


def save_data(output_dir, entry, data, riff_tag):
    output_file_name_wo_extension = os.path.join(output_dir, "%s_%s_%s_%s_%s" %
                               (entry['room'],
                                entry['noun'],
                                entry['verb'],
                                entry['cond'],
                                entry['seq']))

    if riff_tag == 'SOL':
        output_file_name = output_file_name_wo_extension + '.sol'
        with open(output_file_name, 'wb') as of:
            of.write(data)

        if not args.sol:
            try:
                wav_output = output_file_name_wo_extension + ".wav"
                subprocess.check_output(['ffmpeg.exe', '-loglevel', 'fatal', '-y', '-i', output_file_name, wav_output])
                os.remove(output_file_name)
            except:
                print("You might want to copy 'ffmpeg.exe' to current directory, to auto convert .sol to .wav")
    elif riff_tag == 'RIFF':
        output_file_name = output_file_name_wo_extension + '.wav'
        with open(output_file_name, 'wb') as of:
            of.write(data)
    else:
        print('Unknown riff_tag')


def export_csv(csv_file, input_dir, output_dir):
    with open(csv_file, newline='') as csvfile:       #, encoding='utf-8'
        required_entries = [{k: v for k, v in row.items()}
                 for row in csv.DictReader(csvfile, skipinitialspace=True, quoting=csv.QUOTE_ALL)]
    rooms = set([d['room'] for d in required_entries])
    maps = {}
    for room in rooms:
        maps[room] = parse_single_map(room, input_dir)
    for r in required_entries:
        room_maps = maps[r['room']]
        entry = get_entry(r, room_maps)
        if entry:
            export_single_voice(entry, input_dir, output_dir)


def get_entry(entry, maps):
    relevant = [e for e in maps if entry_equal(e, entry)]
    assert len(relevant) in (0, 1)
    try:
        return relevant[0]
    except:
        return None


def entry_equal(e1, e2):
    return \
        int(e1['room']) == int(e2['room']) and\
        int(e1['noun']) == int(e2['noun']) and\
        int(e1['verb']) == int(e2['verb']) and\
        int(e1['cond']) == int(e2['cond']) and\
        int(e1['seq']) == int(e2['seq'])


def export_all(args):
    # usually not used - for debugging
    rooms = [os.path.splitext(os.path.basename(r))[0] for r in pathlib.Path(args.input_dir).glob('*.MAP')]
    for room in rooms:
        export_room(args, room)


def export_room(args, room):
    # usually not used - for debugging
    map = parse_single_map(room, args.input_dir)
    for entry in map:
        export_single_voice(entry, args.input_dir, args.output_dir)


if __name__ == "__main__":
    args = parse_args()
    # export_all(args)
    # export_room(args, 260)
    export_csv(args.csv_file, args.input_dir, args.output_dir)

