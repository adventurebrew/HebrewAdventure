import pathlib
import csv

INPUT_FILE = r"C:\Zvika\ScummVM-dev\HebrewAdventure\sq3.scripts\vocab.901"
OUTPUT_FILE = r"C:\Zvika\ScummVM-dev\HebrewAdventure\sq3\patches\vocab_suffix.csv"
SIERRA_VOCAB_HEADER = b'\x86\0'


def read_string(lob, idx):
    result = ""
    while lob[idx] != 0:
        result += chr(lob[idx])
        idx += 1
    return result


def read_be(l, idx):
    return l[idx] * 256 + l[idx + 1]


def read_vocab_file():
    in_vocab = list(pathlib.Path(INPUT_FILE).read_bytes())
    assert bytes(in_vocab[:2]) == SIERRA_VOCAB_HEADER
    in_vocab = in_vocab[2:]

    idx = 0
    data = []
    while idx < len(in_vocab) and in_vocab[idx+1] != 0xff:
        suffix_string = read_string(in_vocab, idx)
        idx += len(suffix_string) + 1
        class_mask = read_be(in_vocab, idx)
        idx += 2
        reduced_string = read_string(in_vocab, idx)
        idx += len(reduced_string) + 1
        output_class = read_be(in_vocab, idx)
        idx += 2
        data.append((suffix_string, class_mask, reduced_string, output_class))

    return data


def write_csv_file(data):
    keys = ['alt_suffix', 'result_class', 'word_suffix', 'class_mask']
    with open(OUTPUT_FILE, 'w', newline='') as output_file:
        writer = csv.writer(output_file, keys, quoting=csv.QUOTE_ALL)
        writer.writerow(keys)
        writer.writerows(data)


def vocab_suffix_export():
    data = read_vocab_file()
    write_csv_file(data)


if __name__ == "__main__":
    vocab_suffix_export()
