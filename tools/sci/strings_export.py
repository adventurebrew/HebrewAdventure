# TODO check spaces in 36.sca

import argparse
import re
import os
import csv
from pathlib import Path

from assembler.misc import de_escape_string
from config import scripts_strings_csv_filename, scripts_strings_keys


def strings_export(asm_path, csvdir):
    if not asm_path.exists():
        print(f"ERROR: strings_export: {asm_path} doesn't exist")

    with open(os.path.join(csvdir, scripts_strings_csv_filename), 'w', newline='', encoding='UTF-8') as output_file:
        dict_writer = csv.DictWriter(output_file, fieldnames=scripts_strings_keys.values())
        dict_writer.writeheader()

        for filename in asm_path.glob('*.sca'):
            text = filename.read_text().splitlines()

            entries = [l for l in text if l.startswith('string_')]
            entries = [e for e in entries if not e.endswith('; special') and not e.startswith('string_unused_')]

            for entry in entries:
                if entry.strip():
                    s = re.split('(.*): "(.*)"', entry)
                    assert len(s) == 4
                    assert s[0] == s[3] == ''
                    dict_writer.writerow({
                        scripts_strings_keys['filename']: filename.stem,
                        scripts_strings_keys['idx']: s[1],
                        scripts_strings_keys['original']: de_escape_string(s[2])
                    })


if __name__ == "__main__":
    parser = argparse.ArgumentParser(formatter_class=argparse.ArgumentDefaultsHelpFormatter,
                                     description='Exports text strings from script files to csv file',
                                     epilog='''
Some scripts file have strings hard wired into them.
This exports all these messages to a csv file, to be translated.
''')
    parser.add_argument("asmdir",
                        help="src directory containing the assembly (.sca) files (created by disassembling the .scr files)")
    parser.add_argument("csvdir", help="directory to write .csv file, and intermediate assembly (.sca) files")
    args = parser.parse_args()

    strings_export(Path(args.asmdir), args.csvdir)
