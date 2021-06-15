import argparse
import os
import struct

from clusters_export import open_clu_desc, WHITE, GRAY, BLACK, SIZE_OF_HEADER

from shared.font_grid import load_font
from sword1.messages_import import to_uint, write_clu_desc

FONT_SIZE = 224


def to_byte(i):
    return i.to_bytes(1, byteorder='little', signed=False)


def get_font(workingdir):
    # from clusters_export import read_font, open_clu_desc
    # clusters = open_clu_desc(args.gamedir)
    # font = read_font(clusters)
    # font[-32:] = font[65-32:65]
    # return font
    # chars = range(32, 255 + 1)
    # from shared.font_grid import save_font
    # save_font(chars, font, os.path.join(workingdir, 'temp.png'))

    # return load_font(os.path.join(workingdir, 'temp.png'))
    return load_font(os.path.join(workingdir, 'font.png'))


def from_color(pixel):
    if pixel == WHITE:
        return 0
    if pixel == BLACK:
        return 200
    if pixel == GRAY:
        return 193
    assert False


def font_import(gamedir, workingdir):
    clusters = open_clu_desc(gamedir)
    cluster = clusters[3]
    assert cluster['label'] == 'general'

    prefix = b'\0' * SIZE_OF_HEADER
    prefix += to_uint(FONT_SIZE)

    font = get_font(workingdir)[32:]
    assert len(font) == FONT_SIZE

    offsets = []

    lob = b'\0'
    i = 0
    for char in font:
        print(i)
        i += 1
        offsets.append(len(lob))

        assert char[0]['x1'] == char[0]['y1'] == 0
        width = char[0]['x2']
        height = char[0]['y2']
        assert height == 26
        lob += struct.pack("4sIHHhh", b"NONE", width * height, width, height, 0, 0)

        for line in char[1]:
            for pixel in line:
                lob += to_byte(from_color(pixel))

    for offset in offsets:
        prefix += to_uint(offset + SIZE_OF_HEADER + FONT_SIZE * 4 + 4)


    with open(os.path.join(gamedir, cluster['path']), "rb") as f:
        f.seek(cluster['groups'][0]['resources'][1]['offset'])
        rest = f.read()

    with open(os.path.join(gamedir, cluster['path']), "wb") as f:
        f.write(prefix + lob + rest)

    delta = len(prefix + lob) - cluster['groups'][0]['resources'][0]['length']
    for group in cluster['groups']:
        for res in group['resources']:
            if res['offset'] > 0:
                res['offset'] += delta
            else:
                res['length'] += delta
            assert res['offset'] >= 0
            assert res['length'] >= 0

    write_clu_desc(clusters, gamedir)




if __name__ == '__main__':
    parser = argparse.ArgumentParser(formatter_class=argparse.ArgumentDefaultsHelpFormatter,
                                     description="Writes font to cluster files", )
    parser.add_argument("gamedir", help="directory containing the game files")
    parser.add_argument("workingdir", help="directory containing the new font file")
    args = parser.parse_args()

    font_import(args.gamedir, args.workingdir)
