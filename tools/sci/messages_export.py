# based on http://sciprogramming.com/community/index.php?topic=1986.msg14363#msg14363
# also, CP437 is assumed, based on http://sciprogramming.com/community/index.php?topic=1790.msg11815#msg11815

#TODO: verify that it's still working well for OK and BEST (after adding support to LAME)

import argparse
import csv
import glob
import os
import binascii

import config

MESSAGES_PATTERN = "*.msg"
SIERRA_MESSAGE_HEADER = b'\x8f\00'
SIERRA_CODEPAGE = 'CP437'


def error(s):
    import sys
    print("ERROR: ", s)
    sys.exit(1)


def read_le(l, idx):
    return l[idx] + l[idx + 1] * 256


def read_string(lob, idx):
    result = ""
    while lob[idx] != 0:
        result += (lob[idx]).to_bytes(1, "little").decode(SIERRA_CODEPAGE)
        idx += 1
    return result


def write_csv(kind, csvdir, entries):
    with open(os.path.join(csvdir, config.messages_csv_filename), 'w', newline='', encoding='UTF-8-sig') as output_file:
        keys = ['room', 'noun', 'verb', ]
        if kind in ['ok', 'best']:
            keys.extend(['condition', 'sequence', 'talker', 'padding'])
        keys.extend(['original', 'translation', 'comments'])
        dict_writer = csv.DictWriter(output_file, fieldnames=[config.messages_keys[key] for key in keys])
        dict_writer.writeheader()

        for room in sorted(entries.keys()):
            for entry in entries[room]:
                row = {config.messages_keys[key]: entry[key] for key in keys}
                try:
                    dict_writer.writerow(row)
                except UnicodeEncodeError as e:
                    print(e, entry)


def messages_export(gamedir, csvdir):
    entries = {}
    for filename in glob.iglob(os.path.join(gamedir, MESSAGES_PATTERN)):
        try:
            room = int(os.path.basename(filename).split('.')[0])
        except:
            continue

        entries[room] = []

        with open(filename, "rb") as f:
            lob = list(f.read())

        assert bytes(lob[:2]) == SIERRA_MESSAGE_HEADER
        lob = lob[2:]
        index = 0
        version = read_le(lob, index)
        index += 2

        # pad bytes
        index += 2

        # Kawa's taxonomy :-)
        if version <= 2101:
            kind = "lame"
        elif version <= 3411:
            kind = "ok"
        else:
            kind = "best"

        if kind == "ok":
            index += 2
        elif kind == "best":
            index += 4

        amount = read_le(lob, index)
        index += 2

        padding_size = 0
        if kind == 'ok':
            # 3 bytes padding
            padding_size = 3
        if kind == 'best':
            # 4 bytes of references - currently ignored
            padding_size = 4

        # print(amount)
        for i in range(amount):
            entry = {'room': room,
                     'translation': '',
                     'comments': ''}
            entry['noun'] = lob[index]
            entry['verb'] = lob[index + 1]
            if kind == 'lame':
                entry['offset'] = read_le(lob, index + 2)
                index += 4
            else:
                entry['condition'] = lob[index + 2]
                entry['sequence'] = lob[index + 3]
                entry['talker'] = lob[index + 4]
                entry['offset'] = read_le(lob, index + 5)
                entry['padding'] = binascii.hexlify(bytes(lob[index + 7: index + 7 + padding_size])).decode('UTF-8-sig')
                index += 7 + padding_size

            entry['original'] = read_string(lob, entry['offset'])
            entries[room].append(entry)
            # print(entry)
    write_csv(kind, csvdir, entries)


if __name__ == "__main__":
    parser = argparse.ArgumentParser(formatter_class=argparse.ArgumentDefaultsHelpFormatter,
                                     description='Exports text from messages files (*.msg) to csv file', )
    parser.add_argument("gamedir", help="directory containing the game files (as patches - see below)")
    parser.add_argument("csvdir", help="directory to write messages.csv")
    args = parser.parse_args()

    messages_export(args.gamedir, args.csvdir)
