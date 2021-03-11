# based on http://sciprogramming.com/community/index.php?topic=1986.msg14363#msg14363
# also, CP437 is assumed, based on http://sciprogramming.com/community/index.php?topic=1790.msg11815#msg11815

import argparse
import csv
import glob
import os
import re

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
        # result += chr(lob[idx])
        idx += 1
    return result


def write_csv(csvdir, entries):
    with open(os.path.join(csvdir, config.messages_csv_filename), 'w', newline='', encoding='UTF-8-sig') as output_file:
        dict_writer = csv.DictWriter(output_file, fieldnames=config.messages_keys.values())
        dict_writer.writeheader()

        for room in sorted(entries.keys()):
            for entry in entries[room]:
                try:
                    dict_writer.writerow({
                        config.messages_keys['room']: entry['room'],
                        config.messages_keys['noun']: entry['noun'],
                        config.messages_keys['verb']: entry['verb'],
                        config.messages_keys['condition']: entry['condition'],
                        config.messages_keys['sequence']: entry['sequence'],
                        config.messages_keys['talker']: entry['talker'],
                        config.messages_keys['original']: entry['text'],
                    })
                except UnicodeEncodeError as e:
                    print(e, entry)


def messages_export(srcdir, csvdir):
    entries = {}
    for filename in glob.iglob(os.path.join(srcdir, MESSAGES_PATTERN)):
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
        elif version <=3411:
            kind = "ok"
        else:
            kind = "best"

        if kind == "lame":
            error(f"Unfortunately, {kind} isn't supported yet")

        if kind == "ok":
            index += 2
        elif kind == "best":
            index += 4

        amount = read_le(lob, index)
        index += 2

        # print(amount)
        for i in range(amount):
            noun = lob[index]
            verb = lob[index + 1]
            condition = lob[index + 2]
            sequence = lob[index + 3]
            talker = lob[index + 4]
            offset = read_le(lob, index + 5)
            index += 7
            if kind == "ok":
                # 3 bytes padding
                index += 3
            elif kind == "best":
                # 4 bytes of references - currently ignored
                index += 4

            text = read_string(lob, offset)
            entries[room].append({'room': room,
                                  'noun': noun,
                                  'verb': verb,
                                  'condition': condition,
                                  'sequence': sequence,
                                  'talker': talker,
                                  'text': text
                                 })
            # print(room, noun, verb, condition, sequence, talker, text)
    write_csv(csvdir, entries)


if __name__ == "__main__":
    parser = argparse.ArgumentParser(formatter_class=argparse.ArgumentDefaultsHelpFormatter,
                                     description='Exports text from messages files (*.msg) to csv file',)
    parser.add_argument("srcdir", help="src directory containing the logic files")
    parser.add_argument("csvdir", help="directory to write messages.csv")
    args = parser.parse_args()

    messages_export(args.srcdir, args.csvdir)
