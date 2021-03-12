# based on http://sciprogramming.com/community/index.php?topic=1986.msg14363#msg14363
# also, CP437 is assumed, based on http://sciprogramming.com/community/index.php?topic=1790.msg11815#msg11815

import argparse
import csv
import glob
import io
import os
import re
import shutil
import binascii
from sys import byteorder


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


def update_msg(original, entries):
    assert bytes(original[:2]) == SIERRA_MESSAGE_HEADER
    lob = original[2:]
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
    assert amount == len(entries)

    padding_size = 0
    if kind == 'ok':
        # 3 bytes padding
        padding_size = 3
    if kind == 'best':
        # 4 bytes of references - currently ignored
        padding_size = 4

    with io.BytesIO() as ostr, io.BytesIO() as mstr:
        offs = []
        base = index + (7 + padding_size) * amount
        extra = base + 2
        ostr.write(SIERRA_MESSAGE_HEADER + lob[:index])
        keys = [config.messages_keys[x] for x in ('noun', 'verb', 'condition', 'sequence', 'talker')]
        for entry in entries:
            offs.append(mstr.tell() + base)
            message = entry[config.messages_keys['translation']].encode('windows-1255')
            origm = entry[config.messages_keys['original']].encode(SIERRA_CODEPAGE)
            if not message:
                message = origm
            mstr.write(message + b'\0')
            extra += len(origm) + 1
        for idx, (off, entry) in enumerate(zip(offs, entries)):
            index_entry = (
                bytes([int(entry[key]) for key in keys]) +
                off.to_bytes(2, byteorder='little', signed=False) +
                binascii.unhexlify(entry[config.messages_keys['padding']])
            )
            ostr.write(index_entry)
            # assert original.startswith(ostr.getvalue()), (
            #     idx,
            #     off,
            #     entry,
            #     index_entry,
            #     original[index + 11 * idx: index + 12 * idx]
            # )
        ostr.write(mstr.getvalue())
        # assert extra == ostr.tell(), (extra, ostr.tell())
        # assert ostr.getvalue() == original[:extra], (original[:extra], ostr.getvalue())
        return ostr.getvalue() + original[extra:]

def messages_import(srcdir, pattern, csvdir):

    patchdir = os.path.join(srcdir, 'PATCHES')
    os.makedirs(patchdir, exist_ok=True)

    with open(os.path.join(csvdir, config.messages_csv_filename), newline='', encoding='utf-8-sig') as csvfile:
        texts = [{k: v for k, v in row.items()}
                 for row in csv.DictReader(csvfile, skipinitialspace=True)]
    rooms = sorted(list(set([entry[config.messages_keys['room']] for entry in texts])))
    for room in rooms:
        entries = [entry for entry in texts if entry[config.messages_keys['room']] == room]

        # if set([entry[config.messages_keys['translation']] for entry in entries]) == {''}:
        #     # there is no translated entry, no need to do anything, skip this room
        #     continue

        print(room)

        filename = f"{room}.MSG"
        orig_filename = os.path.join(srcdir, filename)
        patch_filename = os.path.join(patchdir, filename)

        with open(orig_filename, 'rb') as f:
            original = f.read()

        content = update_msg(original, entries)
        # assert content == original
        with open(patch_filename, 'wb') as output:
            output.write(content)

if __name__ == "__main__":
    parser = argparse.ArgumentParser(formatter_class=argparse.ArgumentDefaultsHelpFormatter,
                                     description='Impors text messages from csv file to messages files (*.msg)',)
    parser.add_argument("srcdir", help="src directory containing the logic files")
    parser.add_argument("--pattern", default='*.msg', help="logic files pattern")
    parser.add_argument("csvdir", help="directory to read messages.csv")
    args = parser.parse_args()

    messages_import(args.srcdir, args.pattern, args.csvdir)
