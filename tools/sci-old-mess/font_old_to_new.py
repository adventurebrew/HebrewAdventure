# SQ3 original fonts had only 128 characters
# for Hebrew translation, we need 255 characters in a font

# reference: http://sci.sierrahelp.com/Documentation/SCISpecifications/15-SCIFontResource.html
# note: there are 2 font file signature (?) bytes at the beginning, not mentioned in that doc

import pathlib

INPUT_FILE = r"C:\Zvika\Games\sq3ega.hebrew\sq3ega\font.000.orig"
OUTPUT_FILE = r"C:\Zvika\Games\sq3ega.hebrew\sq3ega\font.000"

font = list(pathlib.Path(INPUT_FILE).read_bytes())
additional_chars = 255 - 128

font[4] = 128 + additional_chars      # Number of characters
height = font[6]

# update existing pointers
index = 8       # start of pointers table
for i in range(128):
    offset = font[index] + font[index+1]*256
    print("index: ", hex(index), "orig offset: ", hex(offset), end='')
    offset += 2 * additional_chars
    print(", changed to: ", hex(offset))
    font[index] = offset % 256
    font[index+1] = offset // 256
    index += 2

# insert additional_chars pointers at the end of the original pointer list table
# we increase it by the the number of additional characters
# each empty char takes 10 bytes (2 for height and width info, 8 for bitmask: HEIGHT * round_up(WIDTH / 8))

offset = len(font) + additional_chars * 2
pointers = []
for i in range(additional_chars):
    print("new offset: ", hex(offset))
    pointers.extend(list(offset.to_bytes(2, byteorder="little")))
    offset += 10

font[index:index] = pointers

for i in range(additional_chars):
    # define as 8*8
    font.append(8)
    font.append(8)
    # empty bitmask
    for j in range(8):
        font.append(0)

with open(OUTPUT_FILE, "wb") as out_file:
    out_file.write(bytes(font))
