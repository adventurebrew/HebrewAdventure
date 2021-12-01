# "C:\Zvika\Games\heroquest1vga\qfg1vga-gog.Z\PATCHES\999.scr"
# -g SCI2 "C:\Zvika\Games\GK Hebrew\Gabriel Knight [GOG].patches\64962.scr"
# "C:\Zvika\ScummVM-dev\HebrewAdventure\sq3\PATCHES\script.001"

import argparse
import os
import pathlib

from opcodes import SciOpcodes, opcode_size

SIERRA_SCRIPT_HEADER = b'\x82\0'
SIERRA_HEAP_HEADER = b'\x91\0'

OBJ_CODE = 2
OBJ_STRINGS = 5

SCRIPT_OBJECT_MAGIC_NUMBER = 0x1234

def read_le(l, idx):
    return l[idx] + l[idx + 1] * 256


def disasm(generation, orig_script_file):
    in_script = pathlib.Path(orig_script_file).read_bytes()
    assert in_script[:2] == SIERRA_SCRIPT_HEADER
    in_script = in_script[2:]

    if generation == 'SCI0':
        # divide script file to objects
        objects = []
        idx = 0
        while True:
            obj_type = read_le(in_script, idx)
            if obj_type == 0:
                break
            obj_length = read_le(in_script, idx + 2)
            assert obj_length > 0
            obj_data = in_script[idx + 4:idx + obj_length]
            obj = [obj_type, idx + 4, obj_length, obj_data]
            objects.append(obj)
            idx += obj_length

    elif generation == 'SCI2':
        heap_file = os.path.splitext(orig_script_file)[0] + '.hep'
        heap = pathlib.Path(heap_file).read_bytes()
        assert heap[:2] == SIERRA_HEAP_HEADER
        heap = heap[2:]

        in_script += heap

        endOfStringOffset = read_le(heap, 0)
        objectStartOffset = read_le(heap, 2)  * 2 + 4

        assert endOfStringOffset <= len(heap)
        assert objectStartOffset <= len(heap)

        # divide script file to objects
        objects = []
        hep_idx = objectStartOffset
        scr_idx = 0
        while True:
            obj_type = read_le(heap, hep_idx)
            hep_idx += 2
            print("obj_type", hex(obj_type))
            if obj_type != SCRIPT_OBJECT_MAGIC_NUMBER:
                break
            offset = scr_idx - in_script[scr_idx] - 2   #TODO not good
            num_properties = read_le(heap, hep_idx)
            hep_idx += 2

            script_num = read_le(heap, hep_idx + 6)
            print(offset, num_properties, script_num)

            # obj_length = read_le(in_script, idx + 2)
            # assert obj_length > 0
            # obj_data = in_script[idx + 4:idx + obj_length]
            # obj = [obj_type, idx + 4, obj_length, obj_data]
            # objects.append(obj)
            # idx += obj_length

        print('heap', heap)

    else:
        assert False



    # scan strings objects
    for obj in objects:
        if obj[0] == OBJ_STRINGS:
            strings = bytes(obj[3]).split(b'\0')
            for idx, message in enumerate(strings):
                print(idx, message)

    # scan code objects
    for obj in objects:
        if obj[0] == OBJ_CODE:
            code = obj[3]
            idx = 0
            while idx < len(code):
                # print(hex(idx + 12), hex(code[idx]))

                opcode = SciOpcodes(code[idx] >> 1)
                num_of_operands = opcode_size(code[idx]) - 1
                operands = code[idx + 1:idx + 1 + num_of_operands]
                print(opcode, num_of_operands, operands, [hex(o) for o in operands])
                # operand_size_in_bytes = (code[idx] & 1) + 1

                # if opcode == SciOpcodes.op_lofsa:
                #     if code[idx] == 0x73:
                #         offset_from_pc = code[idx] + 1
                #     else:
                #         offset_from_pc = read_le(code, idx+1)
                #     offset = (offset_from_pc + obj[1] + idx + opcode_size(code[idx])) % 0x10000
                #     print("lofsa ", hex(offset))

                idx += opcode_size(code[idx])


if __name__ == "__main__":
    parser = argparse.ArgumentParser(formatter_class=argparse.ArgumentDefaultsHelpFormatter,
                                     description=f"'SCRIPT' disassembler - WIP",)
    parser.add_argument("--generation", "-g",
                        help="interpreter generation (Consult https://wiki.scummvm.org/index.php/Sierra_Game_Versions)\n"
                             "currently supported: 'SCI0', 'SCI2'",
                        choices=['SCI0', 'SCI2'],
                        required=True)
    parser.add_argument("scrfile", help="'script.N' or 'N.scr' file to disassemble; for SCI2 reading also a 'N.hep'")
    # parser.add_argument("csvdir", help=f"directory to write {config.texts_csv_filename}")
    args = parser.parse_args()

    disasm(args.generation, args.scrfile)


