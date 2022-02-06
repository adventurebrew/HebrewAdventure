import argparse
from pathlib import Path

from asm_lib import asm_parser, asm_lexer

from asm_lib.misc import *
from asm_lib.instruction import Instruction
from asm_lib.opcodes import SciOpcodes
from asm_lib.sci_section import SciSection, SectionKind

HEADER_SIZE = 4


def get_instructions(sections):
    return sum([o.instructions for o in sections if o.kind == SectionKind.CODE], [])


def get_strings(sections):
    return sum([o.strings for o in sections if o.kind == SectionKind.STRINGS], [])


def add_pointer(sections, pointer):
    pointers_section = [o for o in sections if o.kind == SectionKind.RELOCATION]
    assert len(pointers_section) == 1
    pointers_section[0].pointers.append(pointer)


#####################################################


def first_config(section, offset):
    assert dict(section) == {'WIDE_EXPORTS': CONFIG_WIDE_EXPORTS,
                             'LOFSA_RELATIVE': CONFIG_LOFSA_RELATIVE}, \
        "This configuration isn't supported (currently): " + str(section)


def first_exports(section, offset):
    entry_length = 4 if CONFIG_WIDE_EXPORTS else 2
    result = SciSection(SectionKind.EXPORTS, offset)
    result.exports = []
    result.length = HEADER_SIZE + 2 + entry_length * len(section)
    for export in section:
        if isinstance(export, int):
            result.exports.append({'kind': 'int', 'id': export})
        elif isinstance(export, str):
            result.exports.append({'kind': 'ID', 'id': export})
        elif export[0] == 'OBJECT':
            result.exports.append({'kind': SectionKind.OBJECT, 'id': export[1]})
        elif export[0] == 'CLASS':
            result.exports.append({'kind': SectionKind.CLASS, 'id': export[1]})
        else:
            raise NotImplementedError
    return result


def first_code(section, offset):
    start_offset = offset
    result = SciSection(SectionKind.CODE, offset)
    offset += HEADER_SIZE
    result.instructions = []
    for item in section:
        if type(item[0]) is tuple:
            label = item[0][1]
            item = item[1]
        else:
            label = None
        opcode = item[0]
        try:
            operands = item[1:]
        except IndexError:
            operands = None
        instr = Instruction(opcode, operands, offset, mode='asm', label=label)
        result.instructions.append(instr)
        offset += instr.length
    result.length = offset - start_offset
    if result.length % 2 == 1:
        result.length += 1
    return result


def first_preload_text(section, offset):
    return SciSection(SectionKind.PRELOAD_TEXT, offset, obj_length=HEADER_SIZE)


def first_relocation(section, offset):
    pass


def first_local_vars(section, offset):
    result = SciSection(SectionKind.LOCAL_VARS, offset,
                        obj_length=HEADER_SIZE + len(section) * 2)
    result.local_vars = section
    return result


def first_strings(section, offset):
    start_offset = offset
    result = SciSection(SectionKind.STRINGS, offset)
    result.strings = []
    offset += HEADER_SIZE
    for s in section:
        result.strings.append({
            'id': s[0],
            'str': s[1],
            'offset': offset
        })
        offset += len(s[1]) + 1
    result.length = offset - start_offset - 1
    if result.length % 2 == 1:
        result.length += 1
    return result


def first_object(section, offset):
    result = SciSection(SectionKind.OBJECT, offset)
    for kind, items in section:
        if kind == 'OBJECT':
            result.name = items[0]
            result.superClass = items[1]
        elif kind == 'function_offset':
            result.func_selector_offset = items
        elif kind == 'Exported':
            result.exported = items
        elif kind == 'Selectors':
            result.var_selectors = items
        elif kind == 'functions':
            result.func_selectors = items
        else:
            print(kind, items)
            raise NotImplementedError
    before_selector_list = 8
    zeroes_between = 2
    number_of_func_selectors = 2
    result.length = HEADER_SIZE + before_selector_list + len(result.var_selectors) * 2 + zeroes_between + \
                    len(result.func_selectors) * 4 + number_of_func_selectors
    assert result.func_selector_offset is not None
    return result


def first_class(section, offset):
    result = SciSection(SectionKind.CLASS, offset)
    for kind, items in section:
        if kind == 'CLASS':
            result.name = items[0]
            result.superClass = items[1]
        elif kind == 'function_offset':
            result.func_selector_offset = items
        elif kind == 'Exported':
            result.exported = items
        elif kind == 'Selectors':
            result.var_selectors = items
        elif kind == 'functions':
            result.func_selectors = items
        else:
            print(kind, items)
            raise NotImplementedError
    before_selector_list = 8
    zeroes_between = 2
    number_of_func_selectors = 2
    result.length = HEADER_SIZE + before_selector_list + len(result.var_selectors) * 2 * 2 + zeroes_between + \
                    len(result.func_selectors) * 4 + number_of_func_selectors
    assert result.func_selector_offset is not None
    return result


#########################################


def second_exports(section, sections):
    result = len(section.exports).to_bytes(length=2, byteorder='little')
    length = 4 if CONFIG_WIDE_EXPORTS else 2
    for export in section.exports:
        if export['kind'] in [SectionKind.OBJECT, SectionKind.CLASS]:
            matches = [s for s in sections if s.kind == export['kind'] and s.name == export['id'][0]]
            assert len(matches) == 1  # TODO nice error message in all asserts
            value = matches[0].obj_offset + HEADER_SIZE + MAGIC_8
        elif export['kind'] == 'ID' and export['id'].startswith('code_'):
            instructions = get_instructions(sections)
            matches = [i for i in instructions if i.label == export['id'] + ':']
            assert len(matches) == 1
            value = matches[0].offset
        elif export['kind'] == 'int':
            value = export['id']
        else:
            print(export)
            raise NotImplementedError
        result += value.to_bytes(length=length, byteorder='little')
    assert section.length == HEADER_SIZE + len(result)
    return result


def second_code(section, sections):
    result = b''
    for instr in section.instructions:
        opcode = (instr.opcode.value << 1) + instr.extra
        result += opcode.to_bytes(length=1, byteorder='little')
        # print(hex(instr.offset), instr, "\t", hex(result[-1]))
        if instr.opcode.is_relative():
            for i, operand in enumerate(instr.operands):
                if isinstance(operand, str):
                    instructions = get_instructions(sections)
                    matches = [ins for ins in instructions if ins.label == operand + ':']
                    assert len(matches) == 1
                    value = matches[0].offset - (instr.offset + instr.length)
                elif i == 0:
                    value = operand - (instr.offset + instr.length)
                else:
                    value = operand
                result += value.to_bytes(length=instr.operands_lens[i], byteorder='little',
                                         signed=instr.opcode.is_signed())
        elif instr.opcode in [SciOpcodes.op_lofsa, SciOpcodes.op_lofss]:
            assert len(instr.operands) == 1
            operand = instr.operands[0]
            assert type(operand) is str
            if operand.startswith('string_'):
                strings = get_strings(sections)
                matches = [s for s in strings if s['id'] == operand]
                assert len(matches) == 1
                value = matches[0]['offset']
                result += value.to_bytes(length=2, byteorder='little', signed=instr.opcode.is_signed())
                add_pointer(sections, instr.offset + 1)
            else:
                matches = [s for s in sections if
                           s.kind in [SectionKind.OBJECT, SectionKind.CLASS] and s.name == operand]
                assert len(matches) == 1
                value = matches[0].obj_offset + MAGIC_8 + 4  # TODO why +4 ??
                result += value.to_bytes(length=instr.operands_lens[0], byteorder='little',
                                         signed=instr.opcode.is_signed())
                add_pointer(sections, instr.offset + 1)
        else:
            for i, operand in enumerate(instr.operands):
                result += wordize(operand, instr.operands_lens[i])
    if len(result) % 2 == 1:
        # sections should be 16-bit aligned
        # so, add some NOP
        # but there isn't such opcode...
        # so, adding '0' (seems that Sierra also did that); assuming it should never be reached anyway
        result += b'\0'
    assert section.length == HEADER_SIZE + len(result)
    return result


def second_class(section, sections):
    return second_object(section, sections, is_class=True)


def second_object(section, sections, is_class=False):
    result = b''
    offset = section.obj_offset
    result += SCRIPT_OBJECT_MAGIC_NUMBER.to_bytes(length=2, byteorder='little')
    result += b'\0\0'
    result += wordize(section.func_selector_offset)
    result += len(section.var_selectors).to_bytes(length=2, byteorder='little')
    offset += 8
    for selector in section.var_selectors:
        # TODO handle names
        if type(selector[2]) is tuple:  # "VAL_ID"
            location = selector[2][2]
            if location.startswith('string_'):
                strings = get_strings(sections)
                matches = [s for s in strings if s['id'] == location]
                assert len(matches) == 1
                value = matches[0]['offset']
                result += value.to_bytes(length=2, byteorder='little', signed=False)
                add_pointer(sections, offset + 4)  # TODO why +4?
            else:
                raise NotImplementedError
        else:
            result += wordize(selector[2])
        offset += 2
    if is_class:
        for selector in section.var_selectors:
            result += wordize(selector[1])
    # we dont care for offset from here on
    result += len(section.func_selectors).to_bytes(length=2, byteorder='little')
    for func in section.func_selectors:
        # TODO handle names
        result += wordize(func[1])
    result += b'\0\0'
    for func in section.func_selectors:
        instructions = get_instructions(sections)
        matches = [ins for ins in instructions if ins.label == func[2] + ':']
        assert len(matches) == 1
        result += matches[0].offset.to_bytes(length=2, byteorder='little')

    assert section.length == HEADER_SIZE + len(result)
    return result


def second_preload_text(section, sections):
    return b''


def second_strings(section, sections):
    result = b'\0'.join([s['str'].encode(ENCODING_OUTPUT) for s in section.strings])
    if len(result) % 2 == 1:
        result += b'\0'

    assert section.length == HEADER_SIZE + len(result)
    return result


def second_local_vars(section, sections):
    result = b''
    offset = section.obj_offset + HEADER_SIZE
    for var in section.local_vars:
        if type(var) is tuple:  # "VAL_ID"
            location = var[2]
            if location.startswith('string_'):
                strings = get_strings(sections)
                matches = [s for s in strings if s['id'] == location]
                assert len(matches) == 1
                value = matches[0]['offset']
                result += value.to_bytes(length=2, byteorder='little', signed=False)
                add_pointer(sections, offset)
            else:
                raise NotImplementedError
        else:
            result += wordize(var)
        offset += 2
    assert section.length == HEADER_SIZE + len(result)
    return result


def update_relocation(section, sections):
    if section.pointers:
        section.length = HEADER_SIZE + len(section.pointers) * 2 + 4  # 4: 2 for length, 2 for beginning zeroes
        return True
    else:
        return False


def second_relocation(section, sections):
    result = b''
    result += len(section.pointers).to_bytes(length=2, byteorder='little')
    result += b'\0\0'  # see comment at script_asm.py, relocation_first
    for pointer in section.pointers:
        result += pointer.to_bytes(length=2, byteorder='little')
    return result


#########################################

def first_pass(tree):
    sections = []
    offset = 0
    for node in tree:
        assert len(node) == 2
        handler = globals()[f'first_{node[0].lower()}']
        section = handler(node[1], offset)
        if section:
            sections.append(section)
            assert section.length % 2 == 0
            offset += section.length
    sections.append(SciSection(SectionKind.RELOCATION, offset))
    return sections


def second_pass(sections):
    result = SIERRA_SCRIPT_HEADER
    for section in sections:
        try:
            ok = True
            if section.kind == SectionKind.RELOCATION:
                ok = update_relocation(section, sections)
            if ok:
                handler = globals()[f'second_{section.kind.name.lower()}']
                result += section.kind.value.to_bytes(length=2, byteorder='little')
                result += section.length.to_bytes(length=2, byteorder='little')
                result += handler(section, sections)
        except KeyError:
            print("Unhandled", section.kind)
            result += b'\xCC' * section.length
    result += b'\0\0'
    return result


def asm(p):
    asm_lexer.start()
    text = p.read_text(encoding=ENCODING_INPUT)
    tree = asm_parser.parser.parse(text)
    sections = first_pass(tree)
    result = second_pass(sections)
    return result


def asm_all(src, compiledir):
    compile_path = Path(compiledir)
    compile_path.mkdir(exist_ok=True)
    if Path(src).is_dir():
        asm_files = Path(src).glob('*.sca')
    else:
        asm_files = [Path(src)]
    for p in asm_files:
        out = compile_path / f'{p.stem}.scr'
        print("--------")
        print(f'Assembling {p} to {out}')
        result = asm(p)
        out.write_bytes(result)


if __name__ == "__main__":
    arg_parser = argparse.ArgumentParser(formatter_class=argparse.ArgumentDefaultsHelpFormatter,
                                         description=f"Sierra 'SCRIPT' assembler - WIP", )
    arg_parser.add_argument("src", help="assmebly (.sca) file or directory to read the assembly (.sca) files")
    arg_parser.add_argument("compiledir", help="directory to write the compiled scripts (.scr, maybe also .hep) files")
    args = arg_parser.parse_args()

    asm_all(args.src, args.compiledir)
