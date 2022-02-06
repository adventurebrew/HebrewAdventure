from pathlib import Path

MAGIC_8 = 8  # TODO why is it needed??
SIERRA_SCRIPT_HEADER = b'\x82\0'
SIERRA_VOCAB_HEADER = b'\x86\0'
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


class Kernels:
    def __init__(self, srcdir, target, mode):
        if mode == 'disasm':
            kernels_file = Path(srcdir) / '999.voc'
            kernels_b = kernels_file.read_bytes()
            assert kernels_b[0:2] == SIERRA_VOCAB_HEADER
            self.kernels = [k.decode() for k in kernels_b[2:].split(b'\0') if k]
            (target / 'kernels.csv').write_text('\n'.join([f'{id}, {k}' for id, k in enumerate(self.kernels)]))
        else:
            kernels_file = Path(srcdir) / 'kernels.csv'
            kernels_csv = kernels_file.read_text().splitlines()
            self.kernels = [k.split(',')[1].strip() for k in kernels_csv]
            (target / '999.voc').write_bytes(
                SIERRA_VOCAB_HEADER + b'\0'.join([k.encode() for k in self.kernels]) + b'\0')

    def get_kernel(self, i):
        try:
            return self.kernels[i]
        except IndexError:
            print(f"Warning: undefined kernel #{i}")
            return f'kernel_{i}'

    def get_index(self, kernel):
        try:
            return self.kernels.index(kernel)
        except ValueError:
            assert kernel.startswith('kernel_')
            return int(kernel.replace('kernel_', ''))


if __name__ == '__main__':
    print("This script shouldn't be directly called")
    import sys

    sys.exit(1)
