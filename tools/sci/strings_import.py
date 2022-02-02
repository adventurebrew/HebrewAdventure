# import scripts strings from csv

# TODO clean warnings failed to replace

import argparse
import os
import csv
import re
import shutil
from pathlib import Path

import config
from assembler.misc import escape_string

ENCODING = 'UTF-8'


def check_replace(filename, s, index, s_from, s_to):
    s_new = re.sub(rf'(^{index}:) "({escape_string(s_from)})"(.*)', fr'\1 "{escape_string(s_to)}"\3', s,
                   flags=re.MULTILINE)
    if s_new == s:
        print(f"WARNING: failed to replace '{s_from}' to '{s_to}' ({index} of {filename})")
    return s_new


def strings_import(csvdir):
    orig_asm_path = Path(csvdir) / 'asm' / 'orig'
    modified_asm_path = Path(csvdir) / 'asm' / 'modified'
    shutil.rmtree(modified_asm_path, ignore_errors=True)
    modified_asm_path.mkdir()

    with open(os.path.join(csvdir, config.scripts_strings_csv_filename), newline='', encoding='utf-8') as csvfile:
        texts = [{k: v for k, v in row.items()}
                 for row in csv.DictReader(csvfile, skipinitialspace=True)]
    filenames = sorted(list(set([entry[config.scripts_strings_keys['filename']] for entry in texts])))
    for file_index in filenames:
        entries = [entry for entry in texts if entry[config.scripts_strings_keys['filename']] == file_index]

        if set([entry[config.scripts_strings_keys['translation']] for entry in entries]) == {''}:
            # there is no translated entry, no need to change anything
            continue

        filename = f"{int(float(file_index))}.sca"
        asm = (orig_asm_path / filename).read_text(encoding=ENCODING)

        for entry in entries:
            if entry[config.scripts_strings_keys['translation']]:
                asm = check_replace(filename, asm,
                                    entry[config.scripts_strings_keys['idx']],
                                    entry[config.scripts_strings_keys['original']],
                                    entry[config.scripts_strings_keys['translation']])

        (modified_asm_path / filename).write_text(asm, encoding=ENCODING)


if __name__ == "__main__":
    parser = argparse.ArgumentParser(formatter_class=argparse.ArgumentDefaultsHelpFormatter,
                                     description="Imports scripts' strings from csv file", )
    parser.add_argument("csvdir", help=f"directory to read {config.scripts_strings_csv_filename} from")
    args = parser.parse_args()

    strings_import(args.csvdir)
