import argparse
import csv
import os

import config
from object_export import xor_lob


def write_le(l, word):
    assert 0 <= word <= 0xffff
    l.append(word % 256)
    l.append(word // 256)


def write_string(l, s):
    l.extend(str.encode(s, config.encoding))
    l.append(0)


def object_import(gamedir, csvdir):
    with open(os.path.join(csvdir, config.object_csv_filename), newline='', encoding='utf-8') as csvfile:
        entries = [{k: v for k, v in row.items()}
                 for row in csv.DictReader(csvfile, skipinitialspace=True)]

        lob = []
        num_of_objects = len(entries) - 1   # first entry isn't an object, but 'max_num_of_animated'
        names_offset = num_of_objects * 3
        write_le(lob, names_offset)

        assert entries[0][config.object_keys['room']] == 'max_num_of_animated'
        max_num_of_animated = int(entries[0][config.object_keys['original']])
        assert 0 <= max_num_of_animated <= 255
        lob.append(max_num_of_animated)

        names = []

        for entry in entries[1:]:
            write_le(lob, names_offset)
            lob.append(int(entry[config.object_keys['room']]))
            if entry[config.object_keys['translation']]:
                name = entry[config.object_keys['translation']]
            else:
                name = entry[config.object_keys['original']]
            name = name.strip()
            names_offset += len(name) + 1   # using NULL terminated strings
            names.append(name)

        for name in names:
            write_string(lob, name)

    lob = xor_lob(lob)

    with open(os.path.join(gamedir, config.objectfile), "wb") as f:
        f.write(bytes(lob))


if __name__ == "__main__":
    parser = argparse.ArgumentParser(formatter_class=argparse.ArgumentDefaultsHelpFormatter,
                                     description='Imports object file content from csv file',)
    parser.add_argument("gamedir", help="directory containing the game files")
    parser.add_argument("csvdir", help="directory to read {}".format(config.object_csv_filename))
    args = parser.parse_args()

    object_import(args.gamedir, args.csvdir)

