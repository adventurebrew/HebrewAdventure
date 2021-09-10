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
    parser.add_argument('path', metavar='<path>', help='path to original game directory')
    parser.add_argument('reps', metavar='<reps>', help='path to replacement files to inject')
    parser.add_argument('output', metavar='<output>', help='path to output directory (will be automatically created if does not exists)')
    args = parser.parse_args()

    in_path = pathlib.Path(args.path)
    out_path = pathlib.Path(args.reps)
    res_out_path = pathlib.Path(args.output)

    os.makedirs(res_out_path, exist_ok=True)

    with open(in_path / 'RESOURCE.MAP', 'rb') as f, open(res_out_path / 'RESOURCE.MAP', 'wb') as map_out:
        hash_idx = f.read(4)
        file_count = UINT16LE.unpack(f.read(UINT16LE.size))[0]
        print(hash_idx, file_count)

        map_out.write(hash_idx + UINT16LE.pack(file_count))

        for i in range(file_count):
            name_b = f.read(13)
            name = name_b.split(b'\0')[0].decode()
            count = UINT16LE.unpack(f.read(UINT16LE.size))[0]
            files = [read_file_entry(f) for _ in range(count)]

            print(name, count, files)

            with open(in_path / name, 'rb') as res, open(res_out_path / name, 'wb') as out:
                offsets = []
                for hash, offset in files:
                    offsets += [(hash, out.tell())]
                    assert offset == res.tell(), (offset, res.tell())
                    res.seek(offset)
                    subname_b = res.read(13)
                    subname = subname_b.split(b'\0')[0].decode()
                    ln = UINT32LE.unpack(res.read(UINT32LE.size))[0]
                    content = res.read(ln)

                    if os.path.exists(out_path / name / subname):
                        print(out_path / name / subname)
                        with open(out_path / name / subname, 'rb') as rep:
                            content = rep.read()
                            ln = len(content)

                    out.write(subname_b)
                    out.write(UINT32LE.pack(ln))
                    out.write(content)

            map_out.write(name_b + UINT16LE.pack(len(offsets)) + b''.join(UINT32LE.pack(hash) + UINT32LE.pack(offset) for hash, offset in offsets))
