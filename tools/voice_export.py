import pathlib
import os.path
import subprocess
import csv

""" 
currently supports only Freddy Pharkas (and probably few others)
based on ScummVM resource_audio.cpp
   int ResourceManager::readAudioMapSCI11(IntMapResourceSource *map)
"""

INPUT_CSV_FILE = r"C:\Zvika\Games\Freddy Pharkas - Frontier Pharmacist\WAV\export.csv"
INPUT_PATH = r"C:\Zvika\Games\Freddy Pharkas - Frontier Pharmacist\AUDIO"
OUTPUT_PATH = r"C:\Zvika\Games\Freddy Pharkas - Frontier Pharmacist\WAV"
RES_AUD_NAME = "RESOURCE.AUD"
EndOfMapFlag = 0xff
SIERRA_AUDIO_TYPE = 0x8d


def read_32le(l, idx):
    return l[idx + 3] * pow(2, 24) + l[idx + 2] * pow(2, 16) + l[idx + 1] * 256 + l[idx]


def read_24le(l, idx):
    return l[idx + 2] * pow(2, 16) + l[idx + 1] * 256 + l[idx]


def file_read_string(fp, length):
    b = fp.read(length)
    result = b.decode('cp1250').strip('\0')
    return result


def parse_single_map(map):
    input_file = os.path.join(INPUT_PATH, str(map) + ".MAP")
    in_vocab = list(pathlib.Path(input_file).read_bytes())
    assert in_vocab[0] == 0x90
    assert in_vocab[1] == 0x00
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


def export_single_wav(entry):
    input_file = os.path.join(INPUT_PATH, RES_AUD_NAME)
    fp = open(input_file, 'rb')
    fp.seek(entry['offset'])

    riffTag = file_read_string(fp, 4)
    if riffTag == 'RIFF':
        print("Wave chunk, currently not supported")
        pass
    else:
        fp.seek(-4, os.SEEK_CUR)
        type = ord(fp.read(1))
        assert type == SIERRA_AUDIO_TYPE
        header_size = ord(fp.read(1))
        assert header_size == 12        # other values are legal, but not supported yet
        riffTag = file_read_string(fp, 4)
        if riffTag == 'SOL':
            export_sol(entry, fp, header_size)
        else:
            print("Unknown chunk: ", riffTag)


def export_sol(entry, fp, header_size):
    ResourceHeaderSize = 2
    fp.seek(3, os.SEEK_CUR)
    chunk_size = int.from_bytes(fp.read(4), 'little')
    size = chunk_size + header_size + ResourceHeaderSize
    fp.seek(-13, os.SEEK_CUR)
    data = fp.read(size)
    output_file_name_wo_extension = os.path.join(OUTPUT_PATH, "%s_%s_%s_%s_%s" %
                               (entry['room'],
                                entry['noun'],
                                entry['verb'],
                                entry['cond'],
                                entry['seq']))
    output_file_name = output_file_name_wo_extension + '.sol'
    with open(output_file_name, 'wb') as of:
        of.write(data)

    wav_output = output_file_name_wo_extension + ".wav"
    try:
        subprocess.check_output(['ffmpeg.exe', '-y', '-i', output_file_name, wav_output])
        os.remove(output_file_name)
    except:
        print("You might want to copy 'ffmpeg.exe' to current directory, to auto convert .sol to .wav")


def export_csv():
    with open(INPUT_CSV_FILE, newline='') as csvfile:       #, encoding='utf-8'
        required_entries = [{k: v for k, v in row.items()}
                 for row in csv.DictReader(csvfile, skipinitialspace=True, quoting=csv.QUOTE_ALL)]
    rooms = set([d['room'] for d in required_entries])
    maps = {}
    for room in rooms:
        maps[room] = parse_single_map(room)
    for r in required_entries:
        room_maps = maps[r['room']]
        relevant = [e for e in room_maps if
                    e['noun'] == int(r['noun']) and
                    e['verb'] == int(r['verb']) and
                    e['cond'] == int(r['cond']) and
                    e['seq'] == int(r['seq'])]
        assert len(relevant) in (0, 1)
        if relevant:
            export_single_wav(relevant[0])


if __name__ == "__main__":
    export_csv()

