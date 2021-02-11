# export scripts strings (except 'said's) to csv

# it's based on Kawa's latest SCICompanion
# need to make some changes to the original src.english Main.sc:
# replace "" strings to {}
# add 'name {blah}' property to inventory items that miss it


import re
import os
import glob
import csv

INPUT_FILES = r"C:\Zvika\ScummVM-dev\HebrewAdventure\sq3.scripts\src.english\*.sc"
OUTPUT_FILE = r"C:\Zvika\ScummVM-dev\HebrewAdventure\sq3\patches\scripts_strings.csv"
KEYS = ('filename', 'idx', 'original', 'translation')

with open(OUTPUT_FILE, 'w', newline='') as output_file:
    dict_writer = csv.DictWriter(output_file, fieldnames=KEYS)
    dict_writer.writeheader()

    for filename in glob.iglob(INPUT_FILES):
        with open(filename) as f:
            basename = os.path.basename(filename)

            text = f.read().replace('\n', '\t')
            entries = re.findall(r'\{.*?\}', text)

            for idx, entry in enumerate(entries):
                if entry.strip():
                    dict_writer.writerow({KEYS[0]: basename, KEYS[1]: idx, KEYS[2]: entry.strip('{}'), KEYS[3]: ''})
