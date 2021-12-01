
import argparse
import re
import os
import glob
import csv

from config import scripts_strings_csv_filename, scripts_strings_keys


def strings_export(srcdir, csvdir, pattern='*.sc'):
    with open(os.path.join(csvdir, scripts_strings_csv_filename), 'w', newline='', encoding='UTF-8') as output_file:
        dict_writer = csv.DictWriter(output_file, fieldnames=scripts_strings_keys.values())
        dict_writer.writeheader()

        for filename in glob.iglob(os.path.join(srcdir, pattern)):
            with open(filename) as f:
                basename = os.path.basename(filename)

                text = f.read().replace('\n', '\t')
                entries = re.findall(r'\{(.*?)\}', text) + re.findall(r'"(.*?)"', text)
                if '\\"' in text or '\\{' in text or '\\}' in text:
                    print("WARNING: unsupported (yet) escaped string delimiter in text! ", filename)

                for idx, entry in enumerate(entries):
                    if entry.strip():
                        dict_writer.writerow({
                            scripts_strings_keys['filename']: basename,
                            scripts_strings_keys['idx']: idx,
                            scripts_strings_keys['original']: entry,
                        })


if __name__ == "__main__":
    parser = argparse.ArgumentParser(formatter_class=argparse.ArgumentDefaultsHelpFormatter,
                                     description='Exports text strings from script files to csv file',
                                     epilog='''
Some scripts file have strings hard wired into them.
This exports all these messages to a csv file, to be translated.

Notes for SCI0:
===============
export scripts strings (except 'said's) to csv

it's based on Kawa's latest SCICompanion
might need to make some changes to the original Main.sc:
add 'name {blah}' property to inventory items that miss it  (otherwise the item's name will be in English)

''')
    parser.add_argument("srcdir", help="src directory containing the scripts files")
    parser.add_argument("--pattern", default='*.sc', help="scripts files pattern")
    parser.add_argument("csvdir", help="directory to write .csv file")
    args = parser.parse_args()

    strings_export(args.srcdir, args.csvdir, args.pattern)
