MAGIC_8 = 8  # TODO why is it needed??
SIERRA_SCRIPT_HEADER = b'\x82\0'
SIERRA_HEAP_HEADER = b'\x91\0'
SCRIPT_OBJECT_MAGIC_NUMBER = 0x1234
ENCODING_INPUT = 'UTF-8'
ENCODING_OUTPUT = 'windows-1255'  # TODO let user control this

CONFIG_LOFSA_RELATIVE = False
CONFIG_WIDE_EXPORTS = True


def read_le(l, idx):
    return l[idx] + l[idx + 1] * 256


def wordize(b, size=2):
    if size == 0:
        assert b == b''
    elif size == 1:
        assert len(b) == 1
    elif size == 2:
        if len(b) == 1:
            b += b'\0'  # little endian
        assert len(b) == 2
    else:
        raise NotImplementedError
    return b


def get_string_id(s):
    if s['usages']:
        return f"string_{s['id']}"
    else:
        return f"string_unused_{s['id']}"


def escape_string(s):
    return s.replace("\r\n", r"\n").replace("\n", r"\n").replace('\t', r'\t').replace('"', r'\"')


def de_escape_string(s):
    return s.replace(r'\"', '"').replace(r"\n", "\n").replace(r"\t", "\t")


if __name__ == '__main__':
    print("This script shouldn't be directly called")
    import sys

    sys.exit(1)
