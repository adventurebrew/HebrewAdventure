# import scripts strings from csv
# sadly, this is NOT fully automatic
# after running the script, open SCICompanion, and recompile
import argparse
import os
import csv
import re

import config

#TODO: del
# INPUT_CSV_FILE = r"C:\Zvika\ScummVM-dev\HebrewAdventure\sq3\patches\scripts_strings.csv"
# INPUT_SCRIPTS_FOLDER = r"C:\Zvika\ScummVM-dev\HebrewAdventure\sq3.scripts\src.english"
# OUTPUT_SCRIPTS_FOLDER = r"C:\Zvika\ScummVM-dev\HebrewAdventure\sq3.scripts\src"

# INPUT_CSV_FILE = r"C:\Users\Zvika\Downloads\QFG1 Hebrew - scripts_strings.csv"
# INPUT_SCRIPTS_FOLDER = r"C:\Zvika\Games\heroquest1vga\qfg1vga-gog.clean\src"
# OUTPUT_SCRIPTS_FOLDER = r"C:\Zvika\ScummVM-dev\HebrewAdventure\qfg1vga\src"

ENCODING_INPUT = 'windows-1252'
ENCODING_OUTPUT = 'windows-1255'


def check_replace(s, s_from, s_to):
    s_new = s.replace("{%s}" % s_from, "{%s}" % s_to, 1)
    if s_new == s:
        try:
            s_new = re.sub(r'{\s*%s\s*}|"\s*%s\s*"' % (s_from, s_from), '{%s}' % s_to, s)
            if s_new == s:
                print("WARNING: failed to replace '%s' to '%s'" % (s_from, s_to))
        except:
            print("WARNING (exception): failed to replace '%s' to '%s'" % (s_from, s_to))
    return s_new


def get_room_number(script):
    room = re.search(r'\(script#\s*(.+)\)', script).group(1)
    if room.isdigit():
        return room.zfill(3)
    else:
        print("strings_import: get_room_number need to add support to define: ", room)
        return room


def strings_import(csvdir, input_game_dir, output_game_dir):
    with open(os.path.join(csvdir, config.scripts_strings_csv_filename), newline='', encoding='utf-8') as csvfile:
        texts = [{k: v for k, v in row.items()}
                 for row in csv.DictReader(csvfile, skipinitialspace=True)]
    filenames = sorted(list(set([entry[config.scripts_strings_keys['filename']] for entry in texts])))
    for filename in filenames:
        entries = [entry for entry in texts if entry[config.scripts_strings_keys['filename']] == filename]

        if set([entry[config.scripts_strings_keys['translation']] for entry in entries]) == {''}:
            # there is no translated entry, no need to change anything
            continue

        with open(os.path.join(os.path.join(input_game_dir, 'src'), filename), encoding=ENCODING_INPUT, newline='\n') as f:
            script = f.read()

        for entry in entries:
            if entry[config.scripts_strings_keys['translation']]:
                script = check_replace(script, entry[config.scripts_strings_keys['original']], entry[config.scripts_strings_keys['translation']])

        with open(os.path.join(os.path.join(output_game_dir, 'src'), filename), 'w', encoding=ENCODING_OUTPUT, newline='\n') as f:
            f.write(script)


if __name__ == "__main__":
    parser = argparse.ArgumentParser(formatter_class=argparse.ArgumentDefaultsHelpFormatter,
                                     description="Imports scripts' strings from csv file",)
    parser.add_argument("csvdir", help=f"directory to read {config.scripts_strings_csv_filename} from")
    parser.add_argument("input_game_dir", help="directory containing CLEAN game dir (probably used for 'export_all') - won't be modified")
    parser.add_argument("output_game_dir", help="copy of 'input_game_dir', that will be modified by this script, and manually recompiled in SCICompanion")
    args = parser.parse_args()

    strings_import(args.csvdir, args.input_game_dir, args.output_game_dir)


