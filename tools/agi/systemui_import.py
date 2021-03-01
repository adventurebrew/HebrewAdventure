import argparse
import csv
import os

import config


def escape(s):
    result = bytes(s, encoding='windows-1255')
    result = str(result).lstrip('b').strip("'")
    result = result.replace(r"\\n", r"\n")
    return result


def systemui_import(csvdir):
    with open(os.path.join(csvdir, config.systemui_csv_filename), newline='', encoding='utf-8') as csvfile:
        entries = [{k: v for k, v in row.items()}
                 for row in csv.DictReader(csvfile, skipinitialspace=True)]

    for entry in entries:
        if entry[config.systemui_keys['command']] and entry[config.systemui_keys['translation']]:
            command = entry[config.systemui_keys['command']]
            orig = entry[config.systemui_keys['original']]
            trans = entry[config.systemui_keys['translation']]
            command = command.replace(orig, trans)
            command = escape(command)
            print(command)


if __name__ == "__main__":
    parser = argparse.ArgumentParser(formatter_class=argparse.ArgumentDefaultsHelpFormatter,
                                     description='Imports translations for systemui from csv file',
                                     epilog='''Some strings are hard coded in the interpreter itself.
In ScummVM, that's 'systemui.cpp'. This script imports a translation csv file, and prints to the screen the translated
commands (with escaped extended charachters)''')
    parser.add_argument("csvdir", help="directory to read {}".format(config.object_csv_filename))
    args = parser.parse_args()

    systemui_import(args.csvdir)
