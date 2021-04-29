import argparse
import csv
import os
import re
import shutil

import config
from agi.config import messages_csv_filename
from agi.config import messages_keys


def update(s, index, translation):
    translation = translation.replace('\\', '\\\\')    # -> replace \ with \\
    translation = translation.replace('"', r'\"')
    lines = []
    for line in s.split('\n'):
        t = re.sub(f'#message {index} ".*"', f'#message {index} "{translation}"', line)
        lines.append(t)
    s_new = '\n'.join(lines)
    # if s_new == s:  # TODO remove this 'if' and printing, it's useless
    #     print(f"WARNING: failed to replace message index {index} to '{translation}'")
    return s_new


def get_number(entry, attr):
    return int(float(entry[messages_keys[attr]]))


def messages_import(srcdir, pattern, csvdir):
    sierra_orig_dir = os.path.join(srcdir, config.sierra_original)
    try:
        os.mkdir(sierra_orig_dir)
    except:
        pass

    with open(os.path.join(csvdir, messages_csv_filename), newline='', encoding='utf-8') as csvfile:
        texts = [{k: v for k, v in row.items()}
                 for row in csv.DictReader(csvfile, skipinitialspace=True)]
    rooms = sorted(list(set([get_number(entry, 'room') for entry in texts])))
    for room in rooms:
        entries = [entry for entry in texts if get_number(entry, 'room') == room]

        if set([entry[messages_keys['translation']] for entry in entries]) == {''}:
            # there is no translated entry, no need to do anything, skip this room
            continue

        # print(room)

        filename = f"Logic{room}.lgc"
        full_filename = os.path.join(srcdir, filename)

        sierra_orig_file = os.path.join(sierra_orig_dir, filename)
        if os.path.exists(sierra_orig_file):
            # there is a copy of the original file - let's copy it over, to start from clean, and have translation changes applied
            shutil.copy2(sierra_orig_file, srcdir)
        else:
            # save a copy of the original sierra file (because we haven't already done so)
            shutil.copy2(full_filename, sierra_orig_dir)

        with open(full_filename, encoding=config.encoding) as f:
            logic = f.read()

        for entry in entries:
            if entry[messages_keys['translation']]:
                if entry[messages_keys['original']].strip() != entry[messages_keys['original']]:
                    if entry[messages_keys['translation']].strip() == entry[messages_keys['translation']]:
                        print("WARNING: space problems at ", entry)
                logic = update(logic, get_number(entry, 'idx'), entry[messages_keys['translation']])

        with open(full_filename, 'w', encoding=config.encoding, newline='\n') as f:
            f.write(logic)


if __name__ == "__main__":
    parser = argparse.ArgumentParser(formatter_class=argparse.ArgumentDefaultsHelpFormatter,
                                     description='Imports text messages from csv file to logic files ',
                                     epilog='''
Logic files have all the texts messages (strings) at the end of the file.
You should have already run the export script, and translate the csv file.
This imports all these messages to from a csv file, back to the logic files. 
''')
    parser.add_argument("srcdir", help="src directory containing the logic files")
    parser.add_argument("--pattern", default='*.lgc', help="logic files pattern")
    parser.add_argument("csvdir", help="directory to read messages.csv")
    args = parser.parse_args()

    messages_import(args.srcdir, args.pattern, args.csvdir)

