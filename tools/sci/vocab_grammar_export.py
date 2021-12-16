# see http://sci.sierrahelp.com/Documentation/SCISpecifications/27-TheParser.html

import argparse
import json
from pathlib import Path

from vocab_export import classes

JSON_FILE_NAME = "vocab_grammar.json"
SIERRA_VOCAB_HEADER = b'\x86\0'

# first rule is 0x13f (at least in SQ3 and LB1). I guess that it stands for 'S'
ID_DELTA = 0x13f - ord('S')


semantics = {
    0x141: "verb",
    0x142: "dobj",  # direct object
    0x143: "iobj",  # indirect object
    0x144: "ref",
    0x145: "unk",   # unknown to me...
    0x146: "class",
    0x14d: "GROUP-UNHANDLED!",  # can be handled, but why bother, if it doesn't exist
    0x154: "debug", # "Force storage": Apparently, this was only used for debugging.
}


def read_string(lob, idx):
    result = ""
    while lob[idx] != 0:
        result += chr(lob[idx])
        idx += 1
    return result


def read_le(l, idx):
    return l[idx + 1] * 256 + l[idx]


def chop_zeroes(lst):
    if not lst or lst[-1] != 0:
        return lst
    else:
        return chop_zeroes(lst[:-1])


def id_to_letter(entry_id):
    result = chr(entry_id - ID_DELTA)
    if result <= 'A' or result >= 'Z':
        print(f"WARNING: problematic entry_id {hex(entry_id)}: {result}")
    return result


def read_vocab_file(gamedir, vocab):
    in_vocab = list((Path(gamedir) / vocab).read_bytes())
    assert bytes(in_vocab[:2]) == SIERRA_VOCAB_HEADER
    in_vocab = in_vocab[2:]

    idx = 0
    data = []
    assert len(data) % 20 == 0
    while idx < len(in_vocab):
        entry_id = read_le(in_vocab, idx)
        idx += 2
        raw_data = []
        for i in range(9):
            raw_data.append(read_le(in_vocab, idx))
            idx += 2
        # raw_data.append(0)  # always terminate (taken from ScummVM)
        raw_data = chop_zeroes(raw_data)
        if raw_data:
            assert len(raw_data) % 2 == 0
            it = iter(raw_data)
            entry_data = []
            for semantic, symbol in zip(it, it):
                if semantics[semantic] == 'class':
                    symbol = classes[symbol]
                else:
                    symbol = id_to_letter(symbol)
                entry_data.append((semantics[semantic], symbol))

            data.append({'num_id': hex(entry_id), 'id': id_to_letter(entry_id), 'data': entry_data})

    return data


def write_json_file(data, csvdir):
    with open(Path(csvdir) / JSON_FILE_NAME, 'w') as file:
        for entry in data:
            file.write(json.dumps(entry))
            file.write('\n')


def vocab_grammar_export(gamedir, csvdir, vocab):
    data = read_vocab_file(gamedir, vocab)
    write_json_file(data, csvdir)


if __name__ == '__main__':
    parser = argparse.ArgumentParser(formatter_class=argparse.ArgumentDefaultsHelpFormatter,
                                     description='Exports grammar rules ("parse tree branches") for SCI parser to json file', )
    parser.add_argument("gamedir", help="directory containing the game files (as patches - see 'export_all.py' help)")
    parser.add_argument("csvdir", help=f"directory to write {JSON_FILE_NAME}")
    parser.add_argument("--vocab", default='vocab.900',
                        help=r"'parse tree branches' file name. See comment at start of ScummVM's sci\engine\kernel.h for details")
    args = parser.parse_args()

    vocab_grammar_export(args.gamedir, args.csvdir, args.vocab)
