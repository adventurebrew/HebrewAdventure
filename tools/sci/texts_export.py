# this exports all texts file to a csv (similarly to vocab_export.py)
# based on https://github.com/BLooperZ/poppy/blob/master/read_text.py
import argparse
import glob
import csv
import operator
import os
from functools import partial
from itertools import takewhile

import config

KEYS = ('room', 'idx', 'original', 'translated', 'comments')
ENCODING_IN = 'windows-1252'
ENCODING_OUT = 'utf-8'
SIERRA_TEXT_HEADER = b'\x83'
TEXTS_PATTERN = "text.*"


def read_char(stream):
    c = stream.read(1)
    if not c:
        raise EOFError('Got Nothing')
    return c


def safe_readcstr(stream):
    bound_read = iter(partial(read_char, stream), b'')
    return b''.join(takewhile(partial(operator.ne, b'\00'), bound_read))


def loop_strings(stream):
    while True:
        try:
            yield safe_readcstr(stream).decode(ENCODING_IN)
        except EOFError as e:
            break


def texts_export(gamedir, csvdir):
    with open(os.path.join(csvdir, config.texts_csv_filename) , 'w', newline='', encoding=ENCODING_OUT) as output_file:
        dict_writer = csv.DictWriter(output_file, fieldnames=KEYS)
        dict_writer.writeheader()

        for filename in glob.iglob(os.path.join(gamedir, TEXTS_PATTERN)):
            room = os.path.basename(filename).split('.')[1]
            with open(filename, 'rb') as f:
                for idx, message in enumerate(loop_strings(f)):
                    if idx == 0:
                        assert message.encode(ENCODING_IN) == SIERRA_TEXT_HEADER
                    else:
                        dict_writer.writerow({KEYS[0]: room, KEYS[1]: idx - 1, KEYS[2]: message, KEYS[3]: ''})


if __name__ == "__main__":
    parser = argparse.ArgumentParser(formatter_class=argparse.ArgumentDefaultsHelpFormatter,
                                     description=f'Exports texts from old SCI text files ({TEXTS_PATTERN}) to csv file',)
    parser.add_argument("gamedir", help="directory containing the game files (as patches - see 'export_all.py' help)")
    parser.add_argument("csvdir", help=f"directory to write {config.texts_csv_filename}")
    args = parser.parse_args()

    texts_export(args.gamedir, args.csvdir)



