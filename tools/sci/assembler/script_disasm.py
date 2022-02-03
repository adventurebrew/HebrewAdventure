# TODO create lib
# fix 990.sca diff

# TODO other generations:
# said/synonym
# .hep

# https://wiki.scummvm.org/index.php?title=SCI/Specifications/SCI_virtual_machine/Introduction#Script_resources

# -g SCI0 C:\Zvika\ScummVM-dev\HebrewAdventure\sq1vga\PATCHES\103.scr
# -g SCI0 C:\Zvika\Games\Space_Quest_I_-_The_Sarien_Encounter_VGA_1991.dev\SQ1VGA.patches\103.scr
# "C:\Zvika\Games\heroquest1vga\qfg1vga-gog.Z\PATCHES\999.scr"
# -g SCI2 "C:\Zvika\Games\GK Hebrew\Gabriel Knight [GOG].patches\64962.scr"
# "C:\Zvika\ScummVM-dev\HebrewAdventure\sq3\PATCHES\script.001"

import argparse
import os
from pathlib import Path

from opcodes import SciOpcodes, instruction_length
from instruction import Instruction
from misc import *
from sci_section import SciSection, SectionKind


def get_pointers(objects):
    pointers_l = [o.pointers for o in objects if o.kind == SectionKind.RELOCATION]
    if pointers_l:
        assert len(pointers_l) == 1  # guessing, if it fails - adapt following code
        pointers = pointers_l[0]
        return pointers
    else:
        return []


############################################################################################################
#################################         FIRST   PASS         #############################################
############################################################################################################

def strings_first(obj):
    strings = bytes(obj.data).split(b'\0')
    offset = obj.obj_offset
    obj.strings = []
    for s in strings:
        str = escape_string(s.decode(ENCODING_OUTPUT))
        obj.strings.append({'offset': offset, 'str': str, 'id': strings_first.id, 'usages': [],
                            'special': False})
        offset += len(s) + 1
        strings_first.id += 1


def code_first(obj):
    code = obj.data
    obj.instructions = []
    idx = 0
    while idx < len(code):
        opcode = SciOpcodes(code[idx] >> 1)
        num_of_operands = instruction_length(code[idx]) - 1
        operands = code[idx + 1:idx + 1 + num_of_operands]
        obj.instructions.append(Instruction(opcode, operands, obj.obj_offset + idx))
        idx += instruction_length(code[idx])


def exports_first(obj):
    obj.exports = []
    idx = 0
    num_of_exports = read_le(obj.data, idx)
    idx += 2
    for i in range(num_of_exports):
        length = 4 if CONFIG_WIDE_EXPORTS else 2
        obj.exports.append(int.from_bytes(obj.data[idx:idx + length], byteorder='little', signed=False))
        idx += length


def object_first(obj):
    idx = 0
    assert read_le(obj.data, idx) == SCRIPT_OBJECT_MAGIC_NUMBER
    idx += 2
    # I'm not 100% sure about "local variable offset" being always 0; if it turns out to be wrong - needs further investigation
    assert read_le(obj.data, idx) == 0
    idx += 2
    obj.func_selector_offset = read_le(obj.data, idx)  # not important, mainly for testing stability
    idx += 2

    num_of_var_selectors = read_le(obj.data, idx)
    idx += 2
    obj.var_selector_vals = []
    for i in range(num_of_var_selectors):
        obj.var_selector_vals.append(read_le(obj.data, idx))
        idx += 2

    obj.species = obj.var_selector_vals[0]
    obj.superClass = obj.var_selector_vals[1]
    obj.name = obj.var_selector_vals[3]

    if obj.kind == SectionKind.CLASS:
        # TODO translate selector IDs to names, from vocab.997
        obj.var_selector_ids = []
        for i in range(num_of_var_selectors):
            obj.var_selector_ids.append(read_le(obj.data, idx))
            idx += 2

        obj.var_selectors = {}
        for i in range(num_of_var_selectors):
            obj.var_selectors[obj.var_selector_ids[i]] = obj.var_selector_vals[i]

    assert obj.func_selector_offset + 6 == idx
    obj.num_of_func_selectors = read_le(obj.data, idx)
    idx += 2

    func_selectors_ids = []
    for i in range(obj.num_of_func_selectors):
        func_selectors_ids.append(read_le(obj.data, idx))
        idx += 2

    assert read_le(obj.data, idx) == 0
    idx += 2

    func_selectors_pointers = []
    for i in range(obj.num_of_func_selectors):
        func_selectors_pointers.append(read_le(obj.data, idx))
        idx += 2

    obj.func_selectors = []
    for i in range(obj.num_of_func_selectors):
        obj.func_selectors.append({'id': func_selectors_ids[i], 'pointer': func_selectors_pointers[i]})

    assert idx == len(obj.data)


def relocation_first(obj):
    idx = 0
    num_of_pointers = read_le(obj.data, idx)
    idx += 2
    # these two zeroes don't appear in the Wiki, but they are there in all of SQ1VGA scripts
    assert read_le(obj.data, idx) == 0
    idx += 2
    obj.pointers = {}
    for i in range(num_of_pointers):
        obj.pointers[(read_le(obj.data, idx))] = False
        idx += 2
    assert idx == len(obj.data)


def preload_first(obj):
    # this object is just a flag - contains no data; only its existence is of significance - but not for our needs
    assert obj.data == b''


def local_vars_first(obj):
    obj.local_vars = []
    idx = 0
    while True:
        try:
            obj.local_vars.append(read_le(obj.data, idx))
        except IndexError:
            break
        idx += 2


############################################################################################################
#################################         SECOND/THIRD  PASS         #######################################
############################################################################################################


# used also for third pass
def object_second(obj, objects, third_pass):
    # TODO work will all files, have all classes, and then match selectors to ids. now it's very partial and therefore pointless
    pointers = get_pointers(objects)
    strings = sum([o.strings for o in objects if o.kind == SectionKind.STRINGS], [])
    for i, selector in enumerate(obj.var_selector_vals):
        matches = [s for s in strings if s['offset'] == selector]
        pointer = obj.obj_offset + MAGIC_8 + i * 2
        if pointer in pointers and not pointers[pointer]:
            if matches:
                assert len(matches) == 1
                pointers[pointer] = True
                matches[0]['usages'].append({'obj': obj, 'selector_i': i})
                if i <= 3:
                    matches[0]['special'] = True
                obj.var_selector_vals[i] = {'val': matches[0]['str'], 'id': get_string_id(matches[0])}
            elif isinstance(selector, int) and third_pass:
                new_string = string_match_not_on_start(objects, strings, pointers, selector, pointer,
                                                       {'obj': obj, 'selector_i': i})
                if new_string:
                    pointers[pointer] = True
                    if i <= 3:
                        new_string['special'] = True
                    obj.var_selector_vals[i] = {'val': new_string['str'], 'id': get_string_id(new_string)}

    # update strings
    obj.species = obj.var_selector_vals[0]
    obj.superClass = obj.var_selector_vals[1]
    try:
        obj.name = obj.var_selector_vals[3]['val']
    except TypeError:
        if third_pass:
            obj.name = f"class_{obj.name}"
            print(f"Warning: unnamed object ({obj})")
    if third_pass:
        if obj.unique_extension:
            obj.name += obj.unique_extension

    if third_pass:
        instructions = sum([o.instructions for o in objects if o.kind == SectionKind.CODE], [])
        for selector in obj.func_selectors:
            # TODO replace selector['id'] with name from selector table (vocab.997)
            matches = [i for i in instructions if i.offset == selector['pointer']]
            # maybe the assertion is not accurate (in case there's a 'jmp' or 'bnt', etc. for the start of function)
            # however, it passed fine through all of SQ1VGA
            assert len(matches) == 1

            uniqify_name(obj, objects)
            assert matches[0].label is None
            matches[0].label = f'{obj.sanitize(str(obj.name))}::{selector["id"]}'
            selector['label'] = matches[0].label


def string_match_not_on_start(objects, strings, pointers, str_offset, pointer, usage_dict):
    if strings[0]['offset'] <= str_offset <= strings[-1]['offset']:
        match = [s for s in strings if s['offset'] <= str_offset][-1]
        assert str_offset >= match['offset']
        assert str_offset <= match['offset'] + len(match['str'])
        delta = str_offset - match['offset']
        strings_obj = [o for o in objects if o.kind == SectionKind.STRINGS][0]
        new_string = {'offset': str_offset,
                      'str': match['str'][delta:],
                      'id': f"{match['id']}_offset_{delta}",
                      'usages': [usage_dict],  # {'obj': obj, 'instr': instr}
                      'special': False,
                      }
        strings_obj.strings.append(new_string)
        strings_obj.strings = sorted(strings_obj.strings, key=lambda s: s['offset'])
        pointers[pointer] = True
        return new_string
    else:
        return None


def uniqify_name(instance, objects):
    matches = [o for o in objects if
               o.kind in [SectionKind.OBJECT, SectionKind.CLASS] and o.name == instance.name]
    assert matches
    if len(matches) > 1:
        instance.unique_extension += "_u"
        instance.name = f"{instance.name}_u"


def code_third(obj, objects):
    pointers = get_pointers(objects)
    strings = sum([o.strings for o in objects if o.kind == SectionKind.STRINGS], [])
    all_instructions = sum([o.instructions for o in objects if o.kind == SectionKind.CODE], [])

    for i, instr in enumerate(obj.instructions):
        if instr.opcode.is_relative():
            try:
                offset = instr.operands[0]
            except TypeError:
                offset = instr.operands
            matches = [ins for ins in all_instructions if ins.offset == offset]
            if matches:
                assert len(matches) == 1
                matches[0].set_label()
                if type(instr.operands) is list:
                    instr.operands[0] = matches[0].label
                else:
                    instr.operands = matches[0].label

    for i, instr in enumerate(obj.instructions):
        if instr.offset + 1 in pointers:
            matches = [s for s in strings if s['offset'] == instr.operands]
            if matches:
                assert len(matches) == 1
                pointers[instr.offset + 1] = True
                matches[0]['usages'].append({'obj': obj, 'instr': instr})
                instr.operands = get_string_id(matches[0])
                instr.str = matches[0]['str']
            else:
                new_string = string_match_not_on_start(objects, strings, pointers, instr.operands, instr.offset + 1,
                                                       {'obj': obj, 'instr': instr})
                if new_string is not None:
                    instr.operands = get_string_id(new_string)
                    instr.str = new_string['str']

    for i, instr in enumerate(obj.instructions):
        matches = [o for o in objects if
                   o.kind in [SectionKind.OBJECT, SectionKind.CLASS] and instr.operands == o.obj_offset + MAGIC_8]
        if matches:
            assert len(matches) == 1
            uniqify_name(matches[0], objects)
            if instr.offset + 1 in pointers:
                pointers[instr.offset + 1] = True
                matches[0].usages.append({'obj': obj, 'instr': instr})
                instr.operands = matches[0].get_id()
                instr.obj = matches[0]


def local_vars_third(obj, objects):
    pointers = get_pointers(objects)
    strings = sum([o.strings for o in objects if o.kind == SectionKind.STRINGS], [])
    for i, var in enumerate(obj.local_vars):
        pointer = obj.obj_offset + i * 2
        if pointer in pointers:
            matches = [s for s in strings if s['offset'] == var]
            if matches:
                assert len(matches) == 1
                pointers[pointer] = True
                matches[0]['usages'].append({'obj': obj, 'var': var, 'i': i})
                obj.local_vars[i] = {'val': matches[0]['str'], 'id': get_string_id(matches[0])}
            # TODO do we need inaccuate string match for local vars?
            # else:
            #     new_string = string_match_not_on_start(objects, strings, pointers, instr.operands, instr.offset + 1,
            #                                            {'obj': obj, 'instr': instr})
            #     if new_string is not None:
            #         instr.operands = get_string_id(new_string)
            #         instr.str = new_string['str']

    # TODO do we need object matches for local vars?
    # for i, instr in enumerate(obj.instructions):
    #     matches = [o for o in objects if
    #                o.kind in [ObjectKind.OBJECT, ObjectKind.CLASS] and instr.operands == o.obj_offset + MAGIC_8]
    #     if matches:
    #         assert len(matches) == 1
    #         if instr.offset + 1 in pointers:
    #             pointers[instr.offset + 1] = True
    #             matches[0].usages.append({'obj': obj, 'instr': instr})
    #             instr.operands = matches[0].get_id()
    #             instr.obj = matches[0]


############################################################################################################
#################################         FOURTH PASS           ############################################
############################################################################################################

def strings_fourth(obj, objects):
    for s in obj.strings:
        if len(s['usages']) == 0 and s['str'] and \
                len([str(s1['id']) for s1 in obj.strings if str(s1['id']).startswith(str(s['id']) + "_offset_")]) == 0:
            print('Warning, unused string: ', end='')
            print(s)


def exports_fourth(obj, objects):
    for i, exp in enumerate(obj.exports):
        if exp != 0:
            instructions = sum([o.instructions for o in objects if o.kind == SectionKind.CODE], [])
            matches = [inst for inst in instructions if inst.offset == exp]
            if matches:
                assert len(matches) == 1
                matches[0].exported = True
                matches[0].set_label()
                obj.exports[i] = matches[0]
            else:
                matches = [o for o in objects if
                           o.kind in [SectionKind.OBJECT, SectionKind.CLASS] and exp == o.obj_offset + MAGIC_8]
                assert len(matches) == 1
                matches[0].exported = True
                obj.exports[i] = matches[0]


def relocation_fourth(obj, objects):
    unused = 0
    for p, used in obj.pointers.items():
        if not used:
            unused += 1
    if unused > 0:
        print(f"Warning: {unused} unused pointers out of {len(obj.pointers)}")


def code_fourth(obj, objects):
    for i, instr in enumerate(obj.instructions):
        if instr.opcode in [SciOpcodes.op_lofsa, SciOpcodes.op_lofss]:
            if not isinstance(instr.operands, str):
                print(f"Error: illegal param at: {instr.str_dump()}")
                instr.legal = False


############################################################################################################
#################################         GENERAL              #############################################
############################################################################################################


def split_objects(orig_script_file):
    in_script = Path(orig_script_file).read_bytes()
    assert in_script[:2] == SIERRA_SCRIPT_HEADER
    in_script = in_script[2:]

    # divide script file to objects
    objects = []
    idx = 0
    while True:
        obj_type = read_le(in_script, idx)
        if obj_type == 0:
            break
        obj_length = read_le(in_script, idx + 2)
        assert obj_length > 0
        assert obj_length % 2 == 0
        obj_data = in_script[idx + 4:idx + obj_length]
        objects.append(SciSection(obj_type, idx + 4, obj_length, obj_data))
        idx += obj_length

    if False:  # start of work on SCI2
        heap_file = os.path.splitext(orig_script_file)[0] + '.hep'
        heap = Path(heap_file).read_bytes()
        assert heap[:2] == SIERRA_HEAP_HEADER
        heap = heap[2:]

        in_script += heap

        endOfStringOffset = read_le(heap, 0)
        objectStartOffset = read_le(heap, 2) * 2 + 4

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
            offset = scr_idx - in_script[scr_idx] - 2  # TODO not good
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

    return objects


def get_configs():
    return f""".CONFIG
WIDE_EXPORTS = {CONFIG_WIDE_EXPORTS}
LOFSA_RELATIVE = {CONFIG_LOFSA_RELATIVE}

"""


def disasm(orig_script_file):
    objects = split_objects(orig_script_file)
    strings_first.id = 0

    # first pass
    new_objects = []
    for obj in objects:
        if obj.kind in [SectionKind.OBJECT, SectionKind.CLASS]:
            object_first(obj)
        elif obj.kind == SectionKind.CODE:
            code_first(obj)
        elif obj.kind == SectionKind.STRINGS:
            strings_first(obj)
        elif obj.kind == SectionKind.EXPORTS:
            exports_first(obj)
        elif obj.kind == SectionKind.RELOCATION:
            relocation_first(obj)
        elif obj.kind == SectionKind.PRELOAD_TEXT:
            preload_first(obj)
        elif obj.kind == SectionKind.LOCAL_VARS:
            local_vars_first(obj)
        else:
            raise NotImplementedError
        new_objects.append(obj)
    objects = new_objects

    # second pass
    for obj in objects:
        if obj.kind in [SectionKind.OBJECT, SectionKind.CLASS]:
            object_second(obj, objects, third_pass=False)

    # third pass (calling again some second pass functions)
    for obj in objects:
        if obj.kind in [SectionKind.OBJECT, SectionKind.CLASS]:
            object_second(obj, objects, third_pass=True)
        elif obj.kind == SectionKind.CODE:
            code_third(obj, objects)
        elif obj.kind == SectionKind.LOCAL_VARS:
            local_vars_third(obj, objects)

    # fourth pass
    for obj in objects:
        if obj.kind == SectionKind.STRINGS:
            strings_fourth(obj, objects)
        elif obj.kind == SectionKind.EXPORTS:
            exports_fourth(obj, objects)
        elif obj.kind == SectionKind.RELOCATION:
            relocation_fourth(obj, objects)
        elif obj.kind == SectionKind.CODE:
            code_fourth(obj, objects)

    return get_configs() + '\n\n'.join([obj.str_dump() for obj in objects]) + '\n'


def disasm_all(srcdir, asmdir):
    scr_files = Path(srcdir).glob('*.scr')
    asm_path = Path(asmdir)
    asm_path.mkdir(exist_ok=True, parents=True)
    for scr in scr_files:
        if scr.name.lower() != 'install.scr':
            print("--------")
            print(scr)
            result = disasm(scr)
            (asm_path / f'{scr.stem}.sca').write_text(result)


if __name__ == "__main__":
    parser = argparse.ArgumentParser(formatter_class=argparse.ArgumentDefaultsHelpFormatter,
                                     description=f"Sierra 'SCRIPT' disassembler - WIP", )
    parser.add_argument("srcdir", help="src directory containing the scripts (.scr, maybe also .hep) files")
    parser.add_argument("asmdir", help="directory to write the assembly (.sca) files")
    args = parser.parse_args()

    disasm_all(args.srcdir, args.asmdir)
