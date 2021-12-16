import argparse
import json
from pathlib import Path

from vocab_grammar_export import JSON_FILE_NAME, ID_DELTA
from vocab_import import classes

SIERRA_VOCAB_HEADER = b'\x86\0'
ENCODING = 'windows-1255'

semantics = {
    "verb": 0x141,
    "dobj": 0x142,
    "iobj": 0x143,
    "ref": 0x144,
    "unk": 0x145,
    "class": 0x146,
    "GROUP-UNHANDLED:": 0x14d,
    "debug": 0x154,
}


def write_le(l, word):
    assert 0 <= word <= 0xffff
    l.append(word % 256)
    l.append(word // 256)


def vocab_grammar_import(csvdir, patchesdir, vocab_file):
    vocab = []
    with open(Path(csvdir) / JSON_FILE_NAME) as f:
        for entry in f:
            vocab.append(json.loads(entry))

    binary_vocab = list(SIERRA_VOCAB_HEADER)
    for entry in vocab:
        write_le(binary_vocab, eval(entry['num_id']))
        for meaning, name in entry['data']:
            write_le(binary_vocab, semantics[meaning])
            try:
                write_le(binary_vocab, ord(name) + ID_DELTA)
            except TypeError:
                assert meaning == 'class'
                write_le(binary_vocab, classes[name])
        for _ in range(9 - len(entry['data']) * 2):
            write_le(binary_vocab, 0)

    for _ in range(10):
        write_le(binary_vocab, 0)

    with open(Path(patchesdir) / vocab_file, "wb") as out_file:
        out_file.write(bytes(binary_vocab))


if __name__ == '__main__':
    parser = argparse.ArgumentParser(formatter_class=argparse.ArgumentDefaultsHelpFormatter,
                                     description='Import grammar rules ("parse tree branches") for SCI parser from json file', )
    parser.add_argument("csvdir", help=f"directory to read {JSON_FILE_NAME} from")
    parser.add_argument("patchesdir", help="directory to write the patches files to")
    parser.add_argument("--vocab", default='vocab.900',
                        help=r"'parse tree branches' file name. See comment at start of ScummVM's sci\engine\kernel.h for details")
    args = parser.parse_args()

    vocab_grammar_import(args.csvdir, args.patchesdir, args.vocab)
