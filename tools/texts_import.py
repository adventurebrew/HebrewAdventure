# see details in texts_export.py
# this imports from csv to text.*

import os
import csv

INPUT_FILE = r"C:\Zvika\ScummVM-dev\HebrewAdventure\sq3\patches\texts.csv"
OUTPUT_FOLDER = r"C:\Zvika\ScummVM-dev\HebrewAdventure\sq3\PATCHES"

ENCODING = 'windows-1255'
SIERRA_TEXT_HEADER = b'\x83\0'


def texts_import():
    with open(INPUT_FILE, newline='', encoding='utf-8') as csvfile:
        texts = [{k: v for k, v in row.items()}
                 for row in csv.DictReader(csvfile, skipinitialspace=True)]
    rooms = list(set([entry['room'] for entry in texts]))
    rooms.sort(key=int)
    for room in rooms:
        entries = [entry for entry in texts if entry['room'] == room]
        output_file = os.path.join(OUTPUT_FOLDER, 'text.' + room.zfill(3))

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
    texts_import()



