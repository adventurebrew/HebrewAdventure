import argparse
import os
import csv
import shutil

import config


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
        real_index = index  # because of possible duplicates
        for word in words_by_index[index]:
            w = word.strip()
            if w:
                l = [{'word': sw, 'index': ind} for (sw, ind) in sorted_words if w == sw]
                if l:
                    real_index = l[0]['index']
                    print(w, real_index, index)

        for word in words_by_index[index]:
            w = word.strip()
            if w:
                if w not in [sw for (sw, _) in sorted_words]:
                    sorted_words.append((w, real_index))
    sorted_words = sorted(sorted_words)

    write_extended_words_tok(gamedir, sorted_words)
    write_legacy_words_tok(gamedir, sorted_words)


def write_extended_words_tok(gamedir, sorted_words):
    with open(os.path.join(gamedir, config.words_extended_file), "w") as f:
        f.write("WORDS.TOK: Unofficial extended format to support ASCII range of 128-255\n")
        for (word, index) in sorted_words:
            f.write(f"{word}\0{index}\n")


def write_legacy_words_tok(gamedir, sorted_words):
    """ needed because of duplicates - some word numbers have changed, and we need WinAGI to recompile scripts correctly
    we don't bother with making it 100% as legacy - no need to implement the "compressing" scheme (reuse letters from previous word)
    """
    sorted_words = [(word, number) for (word, number) in sorted_words if word.isascii()]
    # reserve place for letters indices
    lob = [0] * 52
    current_letter = None
    previous_word = ""
    for (word, number) in sorted_words:
        if word[0] != current_letter:
            current_letter = word[0]
            assert 'a' <= current_letter <= 'z'
            letter_index = (ord(current_letter) - ord('a')) * 2
            lob[letter_index] = len(lob) // 256
            lob[letter_index+1] = len(lob) % 256
        prefix = os.path.commonprefix([word, previous_word])
        previous_word = word
        word = word[len(prefix):]               # skip reused letters
        lob.append(len(prefix))                 # use letters from previous word - 'compression'
        for letter in word[:-1]:                # handle all but last letter, which has MSB set
            lob.append(ord(letter) ^ 0x7f)      # 'encryption'
        lob.append(ord(word[-1]) ^ 0xff)        # set MSB of last letter
        lob.append(number // 256)
        lob.append(number % 256)

	# TODO: why exactly is it needed? anyway, without it WinAGI complains
    lob.append(0)

    with open(os.path.join(gamedir, config.wordsfile), "wb") as f:
        f.write(bytes(lob))


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
Therefore, this script creates a NON-STANDARD WORDS.TOK file, now supported by ScummVM.
It also creates a standard WORDS.TOK, with ONLY the ENGLISH words. It's needed because we might have 
duplicated words, therefore, the word groups are united, and we need to recompile the scripts.
''')
    parser.add_argument("gamedir", help="directory containing the game files")
    parser.add_argument("csvdir", help="directory to write messages.csv")
    args = parser.parse_args()

    words_import(args.gamedir, args.csvdir)
