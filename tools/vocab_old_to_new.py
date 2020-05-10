# Sierra's SCI vocab format has "old" version (used by vocab.0) - with 7 bits ascii
# and 8th bit used for string end
# while "new" version (used by vocab.900) has 8 bits ascii
#
# reference: http://sci.sierrahelp.com/Documentation/SCISpecifications/27-TheParser.html#AEN5794
# for Hebrew translation, we need to the vocab to be in the newer version

import pathlib

INPUT_FILE = r"C:\Zvika\ScummVM-dev\HebrewAdventure\sq3\vocab.000.orig"
OUTPUT_FILE1 = r"C:\Zvika\ScummVM-dev\HebrewAdventure\Quest for Glory 2\VOCAB.900"
#OUTPUT_FILE2 = r"C:\Zvika\Games\sq3ega.hebrew\sq3ega\VOCAB.000"

in_vocab = list(pathlib.Path(INPUT_FILE).read_bytes())
out_vocab = in_vocab[0:2]   # vocab signature

# vocab.900 starts with 255 16-bit pointers
# they aren't interesting...
out_vocab.extend([0] * (256*2))

bytes_until_word_text = 0
for idx, val in enumerate(in_vocab[(26*2):]):
    if bytes_until_word_text == 0:
        if val < 0x80:
            out_vocab.append(val)
        else:
            out_vocab.append(val - 0x80)
            out_vocab.append(0)
            bytes_until_word_text = 3
    else:
        out_vocab.append(val)
        bytes_until_word_text -= 1

with open(OUTPUT_FILE1, "wb") as out_file:
    out_file.write(bytes(out_vocab))

#with open(OUTPUT_FILE2, "wb") as out_file:
#    out_file.write(bytes(out_vocab))
