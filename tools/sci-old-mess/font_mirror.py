# SQ3 has a "mirrored" font - as seen on the terminator's glasses
# this takes an input font, and creates a mirrored font

# reference: http://sci.sierrahelp.com/Documentation/SCISpecifications/15-SCIFontResource.html
# note: there are font file signature 2 bytes at the beginning, not mentioned in that doc

import pathlib

INPUT_FILE = r"C:\Zvika\ScummVM-dev\HebrewAdventure\sq3\patches\font.600"
OUTPUT_FILE = r"C:\Zvika\ScummVM-dev\HebrewAdventure\sq3\patches\font.601"
INDEX_SHIFT = 2     # 2 first signature bytes are ignored


def get_offset(font, i):
    return INDEX_SHIFT + font[INDEX_SHIFT + 6 + i*2] + font[INDEX_SHIFT + 6 + 1 + i*2] * 256


def get_num_of_chars():
    # we have problems with the last chars, ignoring them, as they aren't interesting for me
    return min(INDEX_SHIFT + font[INDEX_SHIFT + 2] + font[INDEX_SHIFT + 2 + 1] * 256,
               255)


def get_data(font, index, width):
    assert width <= 16   # it's possible to handle more; but I don't need to now, so I'm being lazy here...
    if width <= 8:
        num_of_bytes = 1
        data = font[index]
    else:
        num_of_bytes = 2
        data = font[index] * 256 + font[index+1]
    bits = bin(data)[2:].zfill(num_of_bytes*8)
    bits = bits[:width]
    return (bits, num_of_bytes)


def write_data(font, index, binary_data, num_of_bytes):
    assert num_of_bytes in (1,2)
    while len(binary_data) < 8 * num_of_bytes:
        binary_data += "0"
    data = int(binary_data, 2)
    if num_of_bytes == 1:
        font[index] = data
    else:
        font[index] = data // 256
        font[index+1] = data % 256


def dump(data):
    print(data.replace("0", " ").replace("1", "*"))


font = list(pathlib.Path(INPUT_FILE).read_bytes())

num_of_chars = get_num_of_chars()
# general_height = font[INDEX_SHIFT + 4]                    # not interesting

for char_code in range(num_of_chars):
    index = get_offset(font, char_code)
    print("\n", hex(char_code), chr(char_code), index, font[index], font[index+1])
    width = font[index]
    index += 1
    lines = font[index]
    index += 1
    while lines:
        (data, num_of_bytes) = get_data(font, index, width)
        data = data[::-1]   # reverse (mirror) the string
        dump(data)
        orig = font[index]
        write_data(font, index, data, num_of_bytes)
        index += num_of_bytes
        lines -= 1


with open(OUTPUT_FILE, "wb") as out_file:
    out_file.write(bytes(font))

