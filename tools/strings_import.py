# import scripts strings from csv
# sadly, this is NOT fully automatic
# after running the script, open SCICompanion, compile, and export patches
# this script prints the names of the files that were updated

import os
import csv

INPUT_CSV_FILE = r"C:\Zvika\ScummVM-dev\HebrewAdventure\sq3\patches\scripts_strings.csv"
INPUT_SCRIPTS_FOLDER = r"C:\Zvika\ScummVM-dev\HebrewAdventure\sq3.scripts\src.english"
OUTPUT_SCRIPTS_FOLDER = r"C:\Zvika\ScummVM-dev\HebrewAdventure\sq3.scripts\src"

ENCODING = 'windows-1255'

def check_replace(s, s_from, s_to):
    s_new = s.replace("{%s}" % s_from, "{%s}" % s_to, 1)
    if s_new == s:
        print("WARNING: failed to replace '%s' to '%s'" % (s_from, s_to))
    return s_new


with open(INPUT_CSV_FILE, newline='') as csvfile:
    texts = [{k: v for k, v in row.items()}
         for row in csv.DictReader(csvfile, skipinitialspace=True)]

filenames = sorted(list(set([entry['filename'] for entry in texts])))

for filename in filenames:
    entries = [entry for entry in texts if entry['filename'] == filename]

    if set([entry['translation'] for entry in entries]) == {''}:
        # there is no translated entry, no need to create a text file
        continue

    print(filename)
    with open(os.path.join(INPUT_SCRIPTS_FOLDER, filename)) as f:
        script = f.read()

    for entry in entries:
        if entry['translation']:
            script = check_replace(script, entry['original'], entry['translation'])

    with open(os.path.join(OUTPUT_SCRIPTS_FOLDER, filename), 'w') as f:
        f.write(script)

