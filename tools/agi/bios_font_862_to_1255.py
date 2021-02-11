import argparse
import pathlib
import sys

NUM_OF_CHARS_IN_FONT = 256
LINES_FOR_CHAR = 8
ALEPH_862 = 0x80
ALEPH_1255 = 0xe0
NUM_OF_HEBREW_CHARS = 27


def error(err):
    print(err)
    sys.exit(1)


if __name__ == "__main__":
    parser = argparse.ArgumentParser(formatter_class=argparse.RawDescriptionHelpFormatter,
                                     description='Transforms an original BIOS font, code page 862, to support Windows 1255 encoding',
                                     epilog='''
In the original BIOS (code page 862), Aleph is at 0x80. In modern Windows 1255, Aleph is at 0xe0.
This tools copies Aleph-Tav to their Windows 1255 location (leaving them duplicated).                                
''')
    parser.add_argument("fontfile", help="file to process in place (no backup is created!)")
    args = parser.parse_args()

    font = list(pathlib.Path(args.fontfile).read_bytes())
    if len(font) != NUM_OF_CHARS_IN_FONT * LINES_FOR_CHAR:
        error("Unexpected size")

    for index in range(NUM_OF_HEBREW_CHARS * LINES_FOR_CHAR):
        font[ALEPH_1255 * LINES_FOR_CHAR + index] = font[ALEPH_862 * LINES_FOR_CHAR + index]

    with open(args.fontfile, "wb") as out_file:
        out_file.write(bytes(font))



