# this file should import strings from csv to scripts file
# it's complicated, and WIP

# decided to drop it, and use SCICompanion for compilation instead
# anyway, leaving it for reference, as it's a nice scripts parser (not full, but working)

import os
import pathlib

SIERRA_SCRIPT_HEADER = b'\x82\0'
OBJ_CODE = 2
OBJ_STRINGS = 5

ORIG_SCRIPT_FOLDER = r"C:\Zvika\ScummVM-dev\HebrewAdventure\sq3\ORIG_RESOURCES"


def read_le(l, idx):
    return l[idx] + l[idx + 1] * 256

def opcode_size(opcode):
    extra = 1 - opcode % 2
    if opcode <= 0x2d:
        return 1
    elif opcode <= 0x35:
        return 2 + extra
    elif opcode <= 0x37:
        return 1
    elif opcode <= 0x39:
        return 2 + extra
    elif opcode <= 0x3d:
        return 1
    elif opcode <= 0x3f:
        return 2 + extra
    elif opcode <= 0x45:
        return 3 + extra
    elif opcode <= 0x47:
        return 4 + extra
    elif opcode <= 0x49:
        return 1
    elif opcode <= 0x4b:
        return 2
    elif opcode <= 0x51:
        return 2 + extra
    elif opcode <= 0x55:
        return 2
    elif opcode <= 0x57:
        return 3 + extra
    elif opcode <= 0x59:
        return 2 + extra
    elif opcode <= 0x5b:
        return 2 + extra    # I'm not 100% sure...
    elif opcode <= 0x61:
        return 1
    elif opcode <= 0x75:
        return 2 + extra
    elif opcode <= 0x7d:
        return 1
    else:
        return 2 + extra

orig_script_file = os.path.join(ORIG_SCRIPT_FOLDER, 'script.001')
in_script = list(pathlib.Path(orig_script_file).read_bytes())

assert bytes(in_script[:2]) == SIERRA_SCRIPT_HEADER
in_script = in_script[2:]

# divide script file to objects
objects = []
idx = 0
while True:
    obj_type = read_le(in_script, idx)
    if obj_type == 0:
        break
    obj_length = read_le(in_script, idx + 2)
    obj_data = in_script[idx+4:idx+obj_length]
    obj = [obj_type, idx+4, obj_length, obj_data]
    objects.append(obj)
    idx += obj_length

# scan strings objects
for obj in objects:
    if obj[0] == OBJ_STRINGS:
        strings = bytes(obj[3]).split(b'\0')
        for idx, message in enumerate(strings):
            print(idx, message)


# scan code objects, search for `lofsa`s
for obj in objects:
    if obj[0] == OBJ_CODE:
        code = obj[3]
        idx = 0
        while idx < len(code):
            # print(hex(idx + 12), hex(code[idx]))

            if code[idx] in (0x72, 0x73):
                if code[idx] == 0x73:
                    offset_from_pc = code[idx] + 1
                else:
                    offset_from_pc = read_le(code, idx+1)
                offset = (offset_from_pc + obj[1] + idx + opcode_size(code[idx])) % 0x10000
                print("lofsa ", hex(offset))


            idx += opcode_size(code[idx])


