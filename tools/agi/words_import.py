import argparse
import os
import csv
import shutil

import config

config.words_extended_file = "WORDS.TOK.EXTENDED"


def write_words_file(gamedir, words_by_index):
    sierra_orig_dir = os.path.join(gamedir, config.sierra_original)
    try:
        os.mkdir(sierra_orig_dir)
    except:
        pass

    full_filename = os.path.join(gamedir, config.words_extended_file)

    # save a copy of the original sierra file (if we haven't already done so)
    if not os.path.exists(os.path.join(sierra_orig_dir, config.words_extended_file)):
        shutil.copy2(full_filename, sierra_orig_dir)

    sorted_words = []
    for index in words_by_index:
        for word in words_by_index[index]:
            if word.strip():
                sorted_words.append((word.strip(), index))
    sorted_words = sorted(sorted_words)

    with open(os.path.join(gamedir, config.words_extended_file), "w") as f:
        f.write("WORDS.TOK: Unofficial extended format to support ASCII range of 128-255\n")
        for (word, index) in sorted_words:
            f.write(f"{word}\0{index}\n")


def words_import(gamedir, csvdir):
    with open(os.path.join(csvdir, config.words_csv_filename), newline='', encoding='utf-8') as csvfile:
        entries = [{k: v for k, v in row.items()}
                 for row in csv.DictReader(csvfile, skipinitialspace=True)]
        words = {}
        for entry in entries:
            words[int(entry[config.words_keys['idx']])] = \
                entry[config.words_keys['original']].split('|') + entry[config.words_keys['translation']].split('|')

        write_words_file(gamedir, words)


if __name__ == "__main__":
    parser = argparse.ArgumentParser(formatter_class=argparse.ArgumentDefaultsHelpFormatter,
                                     description='Imports words (used by command parser) from csv file',
                                     epilog='''
Sierra's original WORDS.TOK file supports only ASCII codes <= 127, meaning that it cannot have characters
from the range of 128-255, required for Hebrew (and probably few other languages).
Therefore, this script creates a NON-STANDARD WORDS.TOK file, now supported by ScummVM
''')
    parser.add_argument("gamedir", help="directory containing the game files")
    parser.add_argument("csvdir", help="directory to write messages.csv")
    args = parser.parse_args()

    words_import(args.gamedir, args.csvdir)
