# see details in vocab_export.py
import argparse
import os
import shutil
import csv
from pathlib import Path

import config
from vocab_export import write_csv

VOCAB_NEW = 'vocab.900'
VOCAB_OLD = 'vocab.000'
ENCODING = 'windows-1255'


classes = {
    'CONJUNCTION': 0x004,
    'ASSOCIATION': 0x008,
    'PREPOSITION': 0x010,
    'ARTICLE': 0x020,
    'ADJECTIVE': 0x040,
    'PRONOUN': 0x080,
    'NOUN': 0x100,
    'INDICATIVE_VERB': 0x200,
    'ADVERB': 0x400,
    'IMPERATIVE_VERB': 0x800
}


def get_class(l):
    if l.strip() == '':
        return 0

    result = 0
    for c in l.split('|'):
        result += classes[c.strip()]
    return result


def get_entry_with_word(entries, word):
    for entry in entries:
        if word in entry['words']:
            return entry


def my_int(s):
    return int(float(s))


def read_csv_file(csvdir):
    with open(os.path.join(csvdir, config.vocab_csv_filename), newline='', encoding='utf-8') as csvfile:
        vocab = [{k: v for k, v in row.items()}
                 for row in csv.DictReader(csvfile, skipinitialspace=True)]
    # for duplicate word checking
    words = []
    # group number to be used for new entries without group number, start after current maximum
    next_group = max([my_int(e['group']) for e in vocab if e['group'] != '']) + 1

    warnings_multi_words = []
    warnings_duplicates = []
    entries = []
    for entry in vocab:
        new_entry = {'rooms': set([int(room) for room in entry['rooms'].replace("in ", "").split(',')] if entry['rooms'] else []),
                     'cls': get_class(entry['class'])}
        if entry['group'] == '':
            new_entry['group'] = next_group
            next_group += 1
        else:
            new_entry['group'] = my_int(entry['group'])

        new_entry['words'] = []
        duplicated = None
        for w in entry['words'].split('|'):
            word = w.strip()
            if word == '':
                # empty word, it's OK - just a redundant |
                pass
            elif len(word.split()) > 1:
                warnings_multi_words.append(word.strip())
            elif word not in words:
                words.append(word)
                new_entry['words'].append(word)
            elif entry['rooms']:    # ignore duplicated that aren't used in any room
                duplicated = word

        if duplicated:
            # this word already appears in an existing entry
            # we combine the two entries
            # note - we don't do `new_entry['words'].append(duplicated)` - because `duplicated` already exists in existing_entry
            existing_entry = get_entry_with_word(entries, duplicated.strip())
            common_rooms = existing_entry['rooms'].intersection(new_entry['rooms'])
            if common_rooms:
                warnings_duplicates.append((duplicated.strip(), sorted(common_rooms)))
            if existing_entry['cls'] != new_entry['cls']:
                existing_entry['cls'] = existing_entry['cls'] | new_entry['cls']
            existing_entry['words'].extend(new_entry['words'])
            assert duplicated in existing_entry['words']
        else:
            entries.append(new_entry)

    if warnings_multi_words:
        print(f"There are {len(warnings_multi_words)} multi words:")
        print(warnings_multi_words)
    if warnings_duplicates:
        print(f"There are {len(warnings_duplicates)} duplicates:")
        print('\n'.join([word + "\t" + str(rooms) for word, rooms in warnings_duplicates]))
    return entries


def write_vocab_file(entries, patchesdir, output_game_dir):
    binary_vocab = [0x86, 0x00]  # vocab signature
    # vocab.900 starts with 255 16-bit pointers
    # save place for them, we'll return to them later
    binary_vocab.extend([0] * (255 * 2))
    pointers = [0] * 255
    current_char = None
    previous_word = ''

    words = {}
    for entry in entries:
        for word in entry['words']:
            words[word] = entry

    for word in sorted(words.keys()):
        if word[0] != current_char:
            current_char = word[0]
            pointers[ord(current_char)] = len(binary_vocab) - 2     # magic number is ignored
        entry = words[word]
        byte1 = entry['cls'] >> 4
        byte2 = (entry['cls'] & 0x0f) << 4
        byte2 += entry['group'] >> 8
        byte3 = entry['group'] & 0xff

        # "compression"
        same_letters = 0
        for p, c in zip(previous_word, word):
            if p == c:
                same_letters += 1
            else:
                break
        # print(previous_word, word, same_letters, end='\t')
        binary_vocab.append(same_letters)
        previous_word = word

        chars = str.encode(word[same_letters:], ENCODING)
        # print(chars)
        for char in chars:
            assert 0 <= char <= 255
            binary_vocab.append(char)
        binary_vocab.append(0)  # end of string (only on newer format!)
        binary_vocab.append(byte1)
        binary_vocab.append(byte2)
        binary_vocab.append(byte3)

    i = 2
    for pointer in pointers:
        binary_vocab[i] = pointer % 0x100
        binary_vocab[i+1] = pointer // 0x100
        i += 2

    output_file1 = os.path.join(patchesdir, VOCAB_OLD)
    (Path(output_game_dir) / VOCAB_OLD).unlink(missing_ok=True)
    output_file2 = os.path.join(output_game_dir, VOCAB_NEW)
    with open(output_file1, "wb") as out_file:
        out_file.write(bytes(binary_vocab))
    shutil.copyfile(output_file1, output_file2)


def vocab_import(csvdir, patchesdir, output_game_dir, debug):
    entries = read_csv_file(csvdir)
    write_vocab_file(entries, patchesdir, output_game_dir)
    if debug:
        def expand(e):
            e['hex_group'] = hex(e['group'])
            return e
        entries = [expand(e) for e in entries]
        write_csv(csvdir, entries, "vocab_debug.csv")


if __name__ == "__main__":
    parser = argparse.ArgumentParser(formatter_class=argparse.ArgumentDefaultsHelpFormatter,
                                     description="Imports scripts' strings from csv file",)
    parser.add_argument("csvdir", help=f"directory to read {config.vocab_csv_filename} from")
    parser.add_argument("patchesdir", help="directory to write the texts patches files to")
    parser.add_argument("output_game_dir", help="copy of 'input_game_dir', that will be modified by this script, and manually recompiled in SCICompanion")
    parser.add_argument("--debug", action='store_true', help="create debug files")
    args = parser.parse_args()

    vocab_import(args.csvdir, args.patchesdir, args.output_game_dir, args.debug)



