# Sierra's SCI vocab format has "old" version (used by vocab.000) - with 7 bits ascii
# and 8th bit used for string end
# while "new" version (used by vocab.900) has 8 bits ascii
#
# reference: http://sci.sierrahelp.com/Documentation/SCISpecifications/27-TheParser.html#AEN5794
# for Hebrew translation, we need to the vocab to be in the newer version

# this exports vocab file to a csv
# see also vocab_import.py
import argparse
import glob
import os
import pathlib
import csv
import re

import config

VOCAB_FILE = "vocab.000"

classes = {
    0x004: 'CONJUNCTION',
    0x008: 'ASSOCIATION',
    0x010: 'PREPOSITION',
    0x020: 'ARTICLE',
    0x040: 'ADJECTIVE',
    0x080: 'PRONOUN',
    0x100: 'NOUN',
    0x200: 'INDICATIVE_VERB',
    0x400: 'ADVERB',
    0x800: 'IMPERATIVE_VERB'
}

# TODO del?
def get_room_number(script):
    room = re.search(r'\(script#\s*(.+)\)', script).group(1)
    if room.isdigit():
        return room.zfill(3)
    else:
        print("strings_import: get_room_number need to add support to define: ", room)
        return room


def get_classes(i):
    result = []
    for k in classes.keys():
        if i & k != 0:
            result.append(classes[k])
    return result


def get_said_per_room(gamedir):
    result = {}
    srcdir = os.path.join(gamedir, 'src')
    for filename in glob.iglob(os.path.join(srcdir, '*.sc')):
        with open(filename) as f:
            text = f.read()
            text_dense = text.replace('\n', '').replace('\t','')
            room = get_room_number(text)
            saids = re.findall(r"\(Said\s'(.*?)'", text_dense)
            words_in_room = set([w for l in [re.split('\W+', said) for said in saids] for w in l if w])
            for word in words_in_room:
                cur = result.get(word, [])
                cur.append((room, [said for said in saids if word in said]))
                result[word] = cur
    return result


def vocab_export(gamedir, csvdir):
    in_vocab = list(pathlib.Path(os.path.join(gamedir, VOCAB_FILE)).read_bytes())
    said_per_room = get_said_per_room(gamedir)
    # TODO: automatic recognize file kind, and support exporting new kind
    kind = "old"
    if kind == "old":
        num_of_pointers_to_ignore = 26
    vocab = []
    bytes_until_word_text = 0
    at_start_of_word = True
    current_word = ""
    for idx, val in enumerate(in_vocab[(num_of_pointers_to_ignore * 2):]):
        if bytes_until_word_text == 0:
            if at_start_of_word:
                at_start_of_word = False
                current_word = current_word[:int(val)]
            elif val < 0x80:
                current_word += chr(val)
            else:
                current_word += chr(val - 0x80)
                bytes_until_word_text = 3
                at_start_of_word = True
                i = idx + num_of_pointers_to_ignore * 2
                entry = {
                    'word': current_word,
                    'class': get_classes(in_vocab[i + 1] * 256 + in_vocab[i + 2] >> 4),
                    'group': (in_vocab[i + 2] & 0b1111) * 256 + in_vocab[i + 3]
                }
                vocab.append(entry)
        else:
            bytes_until_word_text -= 1
    vocab_by_group = {}
    for entry in vocab:
        group = entry['group']
        if group in vocab_by_group:
            vocab_by_group[group]['words'].append(entry['word'])
            if sorted(vocab_by_group[group]['class']) != sorted(entry['class']):
                vocab_by_group[group]['class'].extend(entry['class'])
                vocab_by_group[group]['class'] = sorted(set(vocab_by_group[group]['class']))
                print("Warning: class mismatch: ", vocab_by_group[group])
        else:
            vocab_by_group[group] = {
                'words': [entry['word']],
                'class': entry['class']
            }
    sorted_vocab = []
    for k in sorted(vocab_by_group.keys()):
        entry = vocab_by_group[k]

        rooms = []
        for word in entry['words']:
            if word in said_per_room:
                said = said_per_room[word]
                rooms.extend([s[0].zfill(3) for s in said])
                rooms = list(set(rooms))
                rooms.sort(key=int)

        entry['group'] = k
        entry['words'] = " | ".join(entry['words'])
        entry['class'] = " | ".join(entry['class'])
        if rooms:
            # added 'in ' to force Excel treat it as text, and thus keeping the leading zeroes,
            # which will help in easy sort by room
            entry['rooms'] = "in " + ", ".join(rooms)
        else:
            entry['rooms'] = ''
        entry['comments'] = ''

        sorted_vocab.append(entry)
    sorted_vocab = sorted(sorted_vocab, key=lambda k: (k['rooms'] == "", k['rooms']))
    write_csv(csvdir, sorted_vocab, config.vocab_csv_filename)


def write_csv(csvdir, vocab, vocab_csv_filename):
    with open(os.path.join(csvdir, vocab_csv_filename), 'w', newline='') as output_file:
        dict_writer = csv.DictWriter(output_file, vocab[0].keys(), quoting=csv.QUOTE_ALL)
        dict_writer.writeheader()
        dict_writer.writerows(vocab)


if __name__ == '__main__':
    parser = argparse.ArgumentParser(formatter_class=argparse.ArgumentDefaultsHelpFormatter,
                                     description=f'Exports dictionary words for old SCI parser (from {VOCAB_FILE}) to csv file',)
    parser.add_argument("gamedir", help="directory containing the game files (as patches - see 'export_all.py' help)")
    parser.add_argument("csvdir", help=f"directory to write {config.vocab_csv_filename}")
    args = parser.parse_args()

    vocab_export(args.gamedir, args.csvdir)
