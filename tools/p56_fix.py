import sys
import pathlib

SIERRA_P56_TYPE = 0x81

def write_file(filename, lob):
    with open(filename, "wb") as f:
        f.write(bytes(lob))



try:
    input_file = sys.argv[1]
except:
    print("Please provide input file as command line argument")
    sys.exit(1)

in_vocab = list(pathlib.Path(input_file).read_bytes())
assert in_vocab[0] == SIERRA_P56_TYPE, "Not a .p56 file type"

if in_vocab[1] == 0x80 and in_vocab[26] == 0x26:
    print("File is already well formatted")
elif in_vocab[1] == 0x81 and in_vocab[26] == 0x26:
    in_vocab[1] = 0x80
    write_file(input_file, in_vocab)
elif in_vocab[1] == 0x81 and in_vocab[4] == 0x26:
    in_vocab = [0x81, 0x80, 0x00, 0x00, 0x40, 0x01, 0xC8, 0x00, 0x05, 0x00, 0x06, 0x00,
	            0x00, 0x01, 0x00, 0x00, 0x00, 0x00, 0x02, 0x00, 0xCA, 0xFF, 0x2F, 0x00,
	            0x00, 0x00] + in_vocab[4:]
    write_file(input_file, in_vocab)
