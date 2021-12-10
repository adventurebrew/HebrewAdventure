# see http://sci.sierrahelp.com/Documentation/SCISpecifications/27-TheParser.html

import argparse
from pathlib import Path
import csv

# INPUT_FILE = r"C:\Zvika\ScummVM-dev\HebrewAdventure\sq3.scripts\vocab.900"
# OUTPUT_FILE = r"C:\Zvika\ScummVM-dev\HebrewAdventure\sq3\patches\vocab_parse.csv"
CSV_FILE_NAME = "vocab_grammar.csv"
SIERRA_VOCAB_HEADER = b'\x86\0'


def read_string(lob, idx):
    result = ""
    while lob[idx] != 0:
        result += chr(lob[idx])
        idx += 1
    return result


def read_le(l, idx):
    return l[idx + 1] * 256 + l[idx]


def read_vocab_file(gamedir, vocab):
    in_vocab = list((Path(gamedir) / vocab).read_bytes())
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
        entry_data.append(hex(0))  # always terminate (taken from ScummVM)
        data.append((entry_id, entry_data))

    return data


def write_csv_file(data, csvdir):
    keys = ['id', 'data']
    with open(Path(csvdir) / CSV_FILE_NAME, 'w', newline='') as output_file:
        writer = csv.writer(output_file, keys)
        writer.writerow(keys)
        writer.writerows(data)


def vocab_grammar_export(gamedir, csvdir, vocab):
    data = read_vocab_file(gamedir, vocab)
    write_csv_file(data, csvdir)


if __name__ == '__main__':
    parser = argparse.ArgumentParser(formatter_class=argparse.ArgumentDefaultsHelpFormatter,
                                     description='Exports grammar rules ("parse tree branches") for SCI parser to csv file', )
    parser.add_argument("gamedir", help="directory containing the game files (as patches - see 'export_all.py' help)")
    parser.add_argument("csvdir", help=f"directory to write {CSV_FILE_NAME}")
    parser.add_argument("--vocab", default='vocab.900',
                        help="'parse tree branches' file name. See comment at start of ScummVM's sci\engine\kernel.h for details")
    args = parser.parse_args()

    vocab_grammar_export(args.gamedir, args.csvdir, args.vocab)
