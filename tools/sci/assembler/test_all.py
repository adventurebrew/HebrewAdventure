from script_disasm import disasm_all
from script_asm import asm_all

import shutil
from pathlib import Path
import re
import sys


def ignores(l):
    return [re.sub(r'string_.*\d+', 'string_NNN', s) for s in l]


games = [x for x in Path('tests').iterdir() if x.is_dir()]

for game in games:
    shutil.rmtree(game / 'disasm', ignore_errors=True)
    shutil.rmtree(game / 'bin', ignore_errors=True)
    asm_all(game / 'orig_sca', game / 'bin')
    disasm_all(game / 'bin', game / 'disasm')

    for orig in (game / 'orig_sca').iterdir():
        other = game / 'disasm' / orig.name
        orig_set = set(ignores(orig.read_text().splitlines()))
        other_set = set(ignores(other.read_text().splitlines()))
        diff = orig_set.symmetric_difference(other_set)

        diff.discard('\n')
        if diff:
            print("\n========================")
            print("Differences:")
            print("========================")
            print(f'Orig: {orig}\t\tDisassembly of assembly of orig: {other}')
            print('\n'.join(diff))
            print()
            sys.exit(1)