# this exports all texts file to a csv (similarly to vocab_export.py)
# based on https://github.com/BLooperZ/poppy/blob/master/read_text.py

import glob
import csv
import operator
import os
from functools import partial
from itertools import takewhile

INPUT_FILES = r"C:\Zvika\ScummVM-dev\HebrewAdventure\sq3\ORIG_TEXTS\text.*"
OUTPUT_FILE = r"C:\Zvika\ScummVM-dev\HebrewAdventure\sq3\patches\texts.csv"

KEYS = ('room', 'idx', 'original', 'translated')
ENCODING = 'windows-1255'
SIERRA_TEXT_HEADER = b'\x83'


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
            yield safe_readcstr(stream).decode(ENCODING)
        except EOFError as e:
            break

if __name__ == "__main__":
    with open(OUTPUT_FILE, 'w', newline='') as output_file:
        dict_writer = csv.DictWriter(output_file, fieldnames=KEYS)
        dict_writer.writeheader()

        for filename in glob.iglob(INPUT_FILES):
            room = os.path.basename(filename).split('.')[1]
            with open(filename, 'rb') as f:
                for idx, message in enumerate(loop_strings(f)):
                    if idx == 0:
                        assert message.encode(ENCODING) == SIERRA_TEXT_HEADER
                    else:
                        dict_writer.writerow({KEYS[0]: room, KEYS[1]: idx - 1, KEYS[2]: message, KEYS[3]: ''})



