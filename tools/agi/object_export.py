import argparse
import csv
import os

import config


def read_le(l, idx):
    return l[idx] + l[idx + 1] * 256


def read_string(l, idx):
    result = ""
    idx += 3
    while l[idx]:
        result += chr(l[idx])
        idx += 1
    return result


def xor_lob(lob):
    return [b^ord((config.xoring_key[idx % len(config.xoring_key)])) for (idx, b) in enumerate(lob)]


def read_objects(gamedir):
    objects = []
    with open(os.path.join(gamedir, config.objectfile), "rb") as f:
        lob = list(f.read())
    lob = xor_lob(lob)
    index = 0
    names_offset = read_le(lob, index)
    index += 2
    max_num_of_animated = lob[index]
    index += 1
    while index <= names_offset:
        offset = read_le(lob, index)
        index += 2
        room = lob[index]
        index += 1
        name = read_string(lob, offset)
        objects.append({'room': room, 'name': name})
    return (objects, max_num_of_animated)


def object_export(gamedir, csvdir):
    (objects, max_num_of_animated) = read_objects(gamedir)
    with open(os.path.join(csvdir, config.object_csv_filename), 'w', newline='') as output_file:
        dict_writer = csv.DictWriter(output_file, fieldnames=config.object_keys.values())
        dict_writer.writeheader()

        dict_writer.writerow({
            config.object_keys['room']: 'max_num_of_animated',
            config.object_keys['original']: max_num_of_animated,
            config.object_keys['comments']: "אין לשנות שורה זו",
        })

        for entry in objects:
            dict_writer.writerow({
                config.object_keys['room']: entry['room'],
                config.object_keys['original']: entry['name']
            })


if __name__ == "__main__":
    parser = argparse.ArgumentParser(formatter_class=argparse.ArgumentDefaultsHelpFormatter,
                                     description='Exports object file content to csv file',)
    parser.add_argument("gamedir", help="directory containing the game files")
    parser.add_argument("csvdir", help="directory to write {}".format(config.object_csv_filename))
    args = parser.parse_args()

    object_export(args.gamedir, args.csvdir)

