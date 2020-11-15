import csv
import argparse
import os.path

import voice_export

def parse_args():
    parser = argparse.ArgumentParser(
        description="Imports .wav files to RESOURCE.AUD and updates corresponding .MAP files",
        formatter_class=argparse.RawTextHelpFormatter, epilog="""
Example csv file:
=================
room,   noun,   verb,   cond,   seq
230,    28,     0,      0,      1
0,      0,      0,      0,      1
230,    4,      1,      0,      1""")
    parser.add_argument('csv_file',
                        help='Path to .csv file with the messages voices to import. Should have the columns "room, noun, verb, cond, seq"')
    parser.add_argument('--input_dir', dest='input_dir', default='.',
                        help='Path to the input directory, with the .wav files (default: current dir)')
    parser.add_argument('--output_dir', dest='output_dir', default='.',
                        help='Path to the output directory, containing RESOURCE.AUD and the audio *.MAP files (default: current dir)')
    return parser.parse_args()


def import_single_wav(entry, input_dir, output_dir):
    wav_file_name = os.path.join(input_dir, entry['wav'])
    aud_file_name = os.path.join(output_dir, voice_export.RES_AUD_NAME)
    offset = os.path.getsize(aud_file_name)
    with open(aud_file_name, "ab") as aud_f, open(wav_file_name, "rb") as wav_f:
        aud_f.write(wav_f.read())
    return offset


def import_csv(csv_file, input_dir, output_dir):
    with open(csv_file, newline='') as csvfile:       #, encoding='utf-8'
        required_entries = [{k: v for k, v in row.items()}
                 for row in csv.DictReader(csvfile, skipinitialspace=True, quoting=csv.QUOTE_ALL)]
    rooms = set([d['room'] for d in required_entries])
    for room in rooms:
        map = voice_export.parse_single_map(room, output_dir)
        map = []    #TODO REMOVE ME!!!!!!!!!!!!!!!!!
        room_required_entries = [e for e in required_entries if e['room'] == room]
        for r in room_required_entries:
            offset = import_single_wav(r, input_dir, output_dir)
            update_internal_map(map, r, offset)
        write_map(map, output_dir)


def update_internal_map(map, r, offset):
    delete_old_entry(map, r)
    r['offset'] = offset
    map.append(r)


def write_map(map, output_dir):
    lob = []
    lob.extend(voice_export.MAP_FILE_HEADER)
    map = sorted(map, key= lambda x: x['offset'])
    first_offset = map[0]['offset']
    lob.extend(first_offset.to_bytes(4, 'little'))
    for entry in map:
        lob.append(int(entry['noun']))
        lob.append(int(entry['verb']))
        lob.append(int(entry['cond']))
        lob.append(int(entry['seq']))
        delta = entry['offset'] - first_offset
        lob.extend(delta.to_bytes(3, 'little'))
    for i in range(11):     # I don't really understand why 11, but it's critical...
        lob.append(voice_export.EndOfMapFlag)
    map_file_name = os.path.join(output_dir, map[0]['room']+".MAP")
    with open(map_file_name, "wb") as f:
        f.write(bytes(lob))


def delete_old_entry(map, r):
    entry = voice_export.get_entry(r, map)
    if entry:
        map.remove(entry)



if __name__ == "__main__":
    args = parse_args()
    import_csv(args.csv_file, args.input_dir, args.output_dir)
