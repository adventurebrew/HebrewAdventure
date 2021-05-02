# tried to base on https://github.com/barryharmsen/ExtractAGI/blob/master/export_words_tok.py
# but it has bugs!
# in PQ1, it replaced:
# sw9764912 -> s2
# pr24 -> pr4
# i'm -> im
#
# therefore, ditched that, and rewrote

import struct
import argparse
import os
import csv

import config


def read_be(l, idx):
    return l[idx] * 256 + l[idx + 1]


def words_export(gamedir, csvdir):
    with open(os.path.join(gamedir, config.wordsfile), "rb") as f:
        lob = list(f.read())

    # first 52 bytes are indices - not interesting
    index = 52

    words = {}
    previous_word = ''
    try:
        while index < len(lob):
            reused_letters = lob[index]
            index += 1
            word = previous_word[:reused_letters]
            while lob[index] < 0x80:
                word += chr(lob[index] ^ 0x7f)
                index += 1
            word += chr(lob[index] ^ 0xff)
            index += 1
            number = read_be(lob, index)
            index += 2

            previous_word = word
            if number not in words:
                words[number] = []
            words[number].append(word)

    except IndexError:
        pass

    with open(os.path.join(csvdir, config.words_csv_filename), 'w', newline='') as output_file:
        dict_writer = csv.DictWriter(output_file, fieldnames=config.words_keys.values(), quoting=csv.QUOTE_ALL)
        dict_writer.writeheader()

        for entry in sorted(words):
            dict_writer.writerow({
                config.words_keys['idx']: entry,
                config.words_keys['original']: " | ".join(words[entry])
            })


if __name__ == "__main__":
    parser = argparse.ArgumentParser(formatter_class=argparse.ArgumentDefaultsHelpFormatter,
                                     description='Exports words (used by command parser) to csv file')
    parser.add_argument("gamedir", help="directory containing the game files")
    parser.add_argument("csvdir", help="directory to write {}".format(config.words_csv_filename))
    args = parser.parse_args()

    words_export(args.gamedir, args.csvdir)
