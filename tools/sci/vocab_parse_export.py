# see http://sci.sierrahelp.com/Documentation/SCISpecifications/27-TheParser.html

import pathlib
import csv

INPUT_FILE = r"C:\Zvika\ScummVM-dev\HebrewAdventure\sq3.scripts\vocab.900"
OUTPUT_FILE = r"C:\Zvika\ScummVM-dev\HebrewAdventure\sq3\patches\vocab_parse.csv"
SIERRA_VOCAB_HEADER = b'\x86\0'


def read_string(lob, idx):
    result = ""
    while lob[idx] != 0:
        result += chr(lob[idx])
        idx += 1
    return result


def read_le(l, idx):
    return l[idx + 1] * 256 + l[idx]


def read_vocab_file():
    in_vocab = list(pathlib.Path(INPUT_FILE).read_bytes())
    assert bytes(in_vocab[:2]) == SIERRA_VOCAB_HEADER
    in_vocab = in_vocab[2:]

    idx = 0
    data = []
    assert len(data) % 20 == 0
    while idx < len(in_vocab):
        entry_id = hex(read_le(in_vocab, idx))
        idx += 2
        entry_data = []
        for i in range(9):
            entry_data.append(hex(read_le(in_vocab, idx)))
            idx += 2
        entry_data.append(hex(0))     # always terminate (taken from ScummVM)
        data.append((entry_id, entry_data))

    return data


def write_csv_file(data):
    keys = ['id', 'data']
    with open(OUTPUT_FILE, 'w', newline='') as output_file:
        writer = csv.writer(output_file, keys)
        writer.writerow(keys)
        writer.writerows(data)


def vocab_suffix_export():
    data = read_vocab_file()
    write_csv_file(data)


if __name__ == "__main__":
    vocab_suffix_export()
