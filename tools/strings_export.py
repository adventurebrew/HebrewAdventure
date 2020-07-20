# export scripts strings (except 'said's) to csv

#TODO: missing some strings, with " (instead of expeted { )
#in Invent.sc
#and inventory names in Main.sc

import re
import os
import glob
import csv

INPUT_FILES = r"C:\Zvika\ScummVM-dev\SCI-Decompilation-Archive\sq3\src\*.sc"
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
                dict_writer.writerow({KEYS[0]: basename, KEYS[1]: idx, KEYS[2]: entry.strip('{}'), KEYS[3]: ''})
