# see details in texts_export.py
# this imports from csv to text.*
import argparse
import os
import csv
import config

ENCODING = 'windows-1255'
SIERRA_TEXT_HEADER = b'\x83\0'


def texts_import(csvdir, patchesdir):
    with open(os.path.join(csvdir, config.texts_csv_filename), newline='', encoding='utf-8') as csvfile:
        texts = [{k: v for k, v in row.items()}
                 for row in csv.DictReader(csvfile, skipinitialspace=True)]
    rooms = list(set([entry['room'] for entry in texts if entry['room'] != '']))
    rooms.sort(key=float)
    for room in rooms:
        entries = [entry for entry in texts if entry['room'] == room]
        output_file = os.path.join(patchesdir, 'text.' + room.zfill(3))

        if set([entry['translated'] for entry in entries]) == {''}:
            # there is no translated entry, no need to create a text file
            continue

        with open(output_file, "wb") as out_file:
            out_file.write(SIERRA_TEXT_HEADER)
            for idx, entry in enumerate(entries):
                assert int(entry['idx']) == idx
                if entry['translated'].strip() != '':
                    txt = entry['translated']
                else:
                    txt = entry['original']

                out_file.write(str.encode(txt, ENCODING))
                out_file.write(b'\0')


if __name__ == "__main__":
    parser = argparse.ArgumentParser(formatter_class=argparse.ArgumentDefaultsHelpFormatter,
                                     description="Imports texts from csv file to old SCI 'text' files",)
    parser.add_argument("csvdir", help=f"directory to read {config.texts_csv_filename} from")
    parser.add_argument("patchesdir", help="directory to write the texts patches files to")
    args = parser.parse_args()

    texts_import(args.csvdir, args.patchesdir)



