import struct
import pathlib
import os

## https://moddingwiki.shikadi.net/wiki/TIM_Resource_Format

UINT16LE = struct.Struct('<H')
UINT32LE = struct.Struct('<I')

def read_file_entry(stream):
    hash = UINT32LE.unpack(stream.read(UINT32LE.size))[0]
    offset = UINT32LE.unpack(stream.read(UINT32LE.size))[0]
    return hash, offset


if __name__ == '__main__':

    import argparse

    parser = argparse.ArgumentParser(description='extract TIM resources.')
    parser.add_argument('path', metavar='<path>', help='path to game directory')
    parser.add_argument('output', metavar='<output>', help='path to output directory (will be automatically created if does not exists)')
    args = parser.parse_args()

    in_path = pathlib.Path(args.path)
    out_path = pathlib.Path(args.output)

    with open(in_path / 'RESOURCE.MAP', 'rb') as f:
        hash_idx = f.read(4)
        file_count = UINT16LE.unpack(f.read(UINT16LE.size))[0]
        print(hash_idx, file_count)

        for i in range(file_count):
            name = f.read(13).split(b'\0')[0].decode()
            count = UINT16LE.unpack(f.read(UINT16LE.size))[0]
            files = [read_file_entry(f) for _ in range(count)]

            print(name, count, files)

            os.makedirs(out_path / name, exist_ok=True)

            with open(in_path / name, 'rb') as res:
                for hash, offset in files:
                    assert offset == res.tell(), (offset, res.tell())
                    res.seek(offset)
                    subname = res.read(13).split(b'\0')[0].decode()
                    ln = UINT32LE.unpack(res.read(UINT32LE.size))[0]
                    content = res.read(ln)

                    with open(out_path / name / subname, 'wb') as out:
                        out.write(content)
