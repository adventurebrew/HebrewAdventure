# based on https://github.com/barryharmsen/ExtractAGI/blob/master/export_words_tok.py

import struct
import argparse
import os
import csv

import config

WORDSFILE = "WORDS.TOK.EXTENDED"

def words_export(gamedir, csvdir):
    words = {}
    with open(os.path.join(gamedir, WORDSFILE), "rb") as f:
        f.seek(52, 0)

        PreviousWord = ''
        CurrentWord = ''

        while True:
            PreviousWord = CurrentWord
            CurrentWord = ''

            b = f.read(1)

            # Break if EOF
            if not b:
                break

            byte = struct.unpack('B', b)[0]

            CurrentWord = PreviousWord[0:byte]

            # Get characters
            while True:
                b = f.read(1)

                if not b:
                    break

                byte = struct.unpack('B', b)[0]

                if byte < 32:
                    CurrentWord = CurrentWord + chr(byte ^ 127)
                elif byte > 127:
                    CurrentWord = CurrentWord + chr((byte - 128) ^ 127)
                    break
                elif byte == 95:
                    CurrentWord = CurrentWord + ' '

            # Get word number
            b = f.read(2)
            if not b:
                break
            wordno = struct.unpack('>H', b)[0]

            if wordno in words:
                words[wordno].append(CurrentWord)
            else:
                words[wordno] = []
                words[wordno].append(CurrentWord)


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
    parser.add_argument("csvdir", help="directory to write messages.csv")
    args = parser.parse_args()

    words_export(args.gamedir, args.csvdir)
