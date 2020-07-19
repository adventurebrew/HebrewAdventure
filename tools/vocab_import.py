# see details in vocab_export.py
# this imports from csv to fake vocab.000

INPUT_FILE = r"vocab.csv"
OUTPUT_FILE = r"vocab.000"

import csv

classes = {
    'CONJUNCTION': 0x004,
    'ASSOCIATION': 0x008,
    'PREPOSITION': 0x010,
    'ARTICLE': 0x020,
    'ADJECTIVE': 0x040,
    'PRONOUN': 0x080,
    'NOUN': 0x100,
    'INDICATIVE_VERB': 0x200,
    'ADVERB': 0x400,
    'IMPERATIVE_VERB': 0x800
}

def get_class(l):
    if l.strip() == '':
        return 0

    result = 0
    for c in l.split('|'):
        result += classes[c.strip()]
    return result

with open(INPUT_FILE, newline='') as csvfile:
    vocab = [{k: v for k, v in row.items()}
         for row in csv.DictReader(csvfile, skipinitialspace=True)]

# for duplicate word checking
words = []

# group number to be used for new entries without group number, start after current maximum
next_group = max([int(e['group']) for e in vocab if e['group'] != '']) + 1

binary_vocab = [0x86, 0x00]     # vocab signature

# vocab.900 starts with 255 16-bit pointers
# they aren't interesting...
binary_vocab.extend([0] * (255*2))

for entry in vocab:
    cls = get_class(entry['class'])
    if entry['group'] == '':
        group = next_group
        next_group += 1
    else:
        group = int(entry['group'])
    byte1 = cls >> 4
    byte2 = (cls & 0x0f) << 4
    byte2 += group >> 8
    byte3 = group & 0xff

    for w in entry['words'].split('|'):
        # don't bother with the useless compression
        binary_vocab.append(0)

        word = w.strip()
        chars = str.encode(word, 'windows-1255')
        for char in chars:
            assert char >= 0 and char <= 255
            binary_vocab.append(char)
        binary_vocab.append(0)      # end of string (only on newer format!)
        binary_vocab.append(byte1)
        binary_vocab.append(byte2)
        binary_vocab.append(byte3)

        if word == '':
            # empty word, it's OK - just a redundant |
            pass
        elif len(word.split()) > 1:
            print("Warning: multy word '%s' at: " % word.strip())
            print(entry)
        elif word not in words:
            words.append(word)
        else:
            print("Warning: duplicate word '%s' at: " % word.strip())
            print(entry)

with open(OUTPUT_FILE, "wb") as out_file:
    out_file.write(bytes(binary_vocab))



