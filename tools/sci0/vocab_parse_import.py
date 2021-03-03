import csv

INPUT_FILE = r"C:\Zvika\ScummVM-dev\HebrewAdventure\sq3\patches\vocab_parse.csv"
OUTPUT_FILE = r"C:\Zvika\ScummVM-dev\HebrewAdventure\sq3\patches\vocab.900"
SIERRA_VOCAB_HEADER = b'\x86\0'
ENCODING = 'windows-1255'


def write_le(l, word):
    assert 0 <= word <= 0xffff
    l.append(word % 256)
    l.append(word // 256)


def vocab_import():
    with open(INPUT_FILE, newline='') as csvfile:
        vocab = [{k: v for k, v in row.items()}
                 for row in csv.DictReader(csvfile, skipinitialspace=True)]

    binary_vocab = list(SIERRA_VOCAB_HEADER)
    for entry in vocab:
        write_le(binary_vocab, eval(entry['id']))
        data = eval(entry['data'])[:-1]     # we don't need the last item! it's always a zero, returned by the interperter
        for d in data:
            write_le(binary_vocab, eval(d))

    with open(OUTPUT_FILE, "wb") as out_file:
        out_file.write(bytes(binary_vocab))



if __name__ == "__main__":
    vocab_import()
