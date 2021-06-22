import csv

INPUT_FILE = r"C:\Zvika\ScummVM-dev\HebrewAdventure\sq3\patches\vocab_suffix.csv"
OUTPUT_FILE = r"C:\Zvika\ScummVM-dev\HebrewAdventure\sq3\patches\vocab.901"
SIERRA_VOCAB_HEADER = b'\x86\0'
ENCODING = 'windows-1255'


def write_be(l, word):
    assert 0 <= word <= 0xffff
    l.append(word // 256)
    l.append(word % 256)


def write_string(l, s):
    l.extend(str.encode(s, ENCODING))
    l.append(0)


def vocab_import():
    with open(INPUT_FILE, newline='') as csvfile:
        vocab = [{k: v for k, v in row.items()}
                 for row in csv.DictReader(csvfile, skipinitialspace=True)]

    binary_vocab = list(SIERRA_VOCAB_HEADER)
    for entry in vocab:
        write_string(binary_vocab, entry['alt_suffix'])
        write_be(binary_vocab, int(entry['result_class']))
        write_string(binary_vocab, entry['word_suffix'])
        write_be(binary_vocab, int(entry['class_mask']))

    with open(OUTPUT_FILE, "wb") as out_file:
        out_file.write(bytes(binary_vocab))



if __name__ == "__main__":
    vocab_import()
