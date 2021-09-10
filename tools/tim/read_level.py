import os
import pathlib
import struct
import glob
import functools
import itertools

UINT16LE = struct.Struct('<H')
UINT32LE = struct.Struct('<I')

def readcstr(f):
    toeof = iter(functools.partial(f.read, 1), b'')
    return b''.join(itertools.takewhile(b'\0'.__ne__, toeof))

def read_lev(fname, start='.'):
    base = os.path.relpath(fname, start=start)
    with open(fname, 'rb') as f:
        magic = UINT16LE.unpack(f.read(UINT16LE.size))[0]
        version = UINT16LE.unpack(f.read(UINT16LE.size))[0]

        title = readcstr(f).decode()
        objective = readcstr(f).decode()

        bonus1 = UINT16LE.unpack(f.read(UINT16LE.size))[0]
        bonus2 = UINT16LE.unpack(f.read(UINT16LE.size))[0]

        
        air_pressure = UINT16LE.unpack(f.read(UINT16LE.size))[0]
        gravity = UINT16LE.unpack(f.read(UINT16LE.size))[0]

        # print(magic, version, title, objective, bonus1, bonus2, air_pressure, gravity)
        print(base, title, objective, sep='\t')


if __name__ == '__main__':


    import argparse

    parser = argparse.ArgumentParser(description='extract TIM resources.')
    parser.add_argument('path', metavar='<path>', help='path to extracted resource directory')
    args = parser.parse_args()

    out_path = pathlib.Path(args.path)

    fnames = sorted(glob.iglob(str(out_path / '*/*.LEV')))
    for fname in fnames:
        fname = pathlib.Path(fname)
        read_lev(fname, out_path)
