import argparse
import csv
import os
import struct
from collections import namedtuple
from shared.font_grid import save_font

ENGLISH_GROUP = 0

GRAY = 127
BLACK = 0
WHITE = 255

FONT_PNG = "font.png"

CLUSTER_DESCRIPTION_FILE = "swordres.rif"
MAX_LABEL_SIZE = (31+1)
GAME_FONT = 0x04000000
SIZE_OF_HEADER = 0x14
SIZE_OF_FRAME_HEADER = 16
ITM_ID = 0xFFFF


def read_le(l, idx):
    return l[idx + 1] * 256 + l[idx]


def read_uint_le(l, idx):
    return read_le(l, idx + 2) * 65536 + read_le(l, idx)


def read_string(l, idx):
    return bytes(l[idx:]).partition(b'\0')[0].decode(encoding='latin1')


def read_sized_string(l, idx, size):
    result = ""
    for i in range(size):
        if l[idx] != 0:
            result += chr(l[idx])
        idx += 1
    return result


def open_clu_desc(gamedir):
    clustersdir = os.path.join(gamedir, "clusters")
    with open(os.path.join(clustersdir, CLUSTER_DESCRIPTION_FILE), "rb") as f:
        lob = list(f.read())
    index = 0
    num_of_clusters = read_uint_le(lob, 0)
    index += 4

    clusters_index = []
    for i in range(num_of_clusters):
        clusters_index.append(read_uint_le(lob, index))
        index += 4

    clusters = []
    for i in range(num_of_clusters):
        if clusters_index[i] != 0:
            cluster = {}
            cluster['label'] = read_sized_string(lob, index, MAX_LABEL_SIZE)
            cluster['index'] = clusters_index[i]
            cluster['path'] = os.path.join(clustersdir, cluster['label'] + ".CLU")
            index += MAX_LABEL_SIZE
            cluster['num_of_groups'] = read_uint_le(lob, index)
            index += 4
            groups_index = []
            for i in range(cluster['num_of_groups']):
                groups_index.append(read_uint_le(lob, index))
                index += 4
            cluster['groups'] = []
            for i in range(cluster['num_of_groups']):
                if groups_index[i] != 0:
                    group = {'i': i, 'index': groups_index[i]}
                    group['num_of_res'] = read_uint_le(lob, index)
                    index += 4
                    group['resources'] = []
                    res_id_index = []
                    for i in range(group['num_of_res']):
                        res_id_index.append(read_uint_le(lob, index))
                        index += 4
                    for i in range(group['num_of_res']):
                        res = {'i': i, 'index': res_id_index[i]}
                        if res_id_index[i] != 0:
                            res['offset'] = read_uint_le(lob, index)
                            index += 4
                            res['length'] = read_uint_le(lob, index)
                            index += 4
                        else:
                            res['offset'] = None
                            res['length'] = 0
                        group['resources'].append(res)
                    cluster['groups'].append(group)
            clusters.append(cluster)
    return clusters


def get_resource(clusters, id):
    cluster, group, res_id = split_id(id)
    res = clusters[cluster]['groups'][group]['resources'][res_id]
    with open(clusters[cluster]['path'], "rb") as f:
        f.seek(res['offset'])
        lob = list(f.read(res['length']))
    return lob


def split_id(id):
    cluster = ((id >> 24) - 1) & 0xff
    group = (id >> 16) & 0xff
    res_id = id & 0xffff
    return cluster, group, res_id


def get_frame(lob, number):
    assert number < read_uint_le(lob, SIZE_OF_HEADER)
    idx = read_uint_le(lob, SIZE_OF_HEADER + (number + 1) * 4)
    FrameHeader = namedtuple('FrameHeader', 'runTimeComp compSize width height offsetX offsetY')
    frame_header = FrameHeader._make(struct.unpack("4sIHHhh", bytes(lob[idx:idx + SIZE_OF_FRAME_HEADER])))
    return frame_header, idx + SIZE_OF_FRAME_HEADER


def write_font(clusters, workingdir):
    font = read_font(clusters)
    chars = range(32, 255 + 1)
    save_font(chars, font, os.path.join(workingdir, FONT_PNG))


def read_font(clusters):
    lob = get_resource(clusters, GAME_FONT)
    font = []
    for i in range(224):
        frame_header, idx = get_frame(lob, i)
        assert frame_header.height == 26
        char = []
        for i in range(frame_header.height):
            line = []
            for j in range(frame_header.width):
                if lob[idx] == 0:
                    # transparent
                    line.append(WHITE)
                elif lob[idx] == 200:
                    # border
                    line.append(BLACK)
                elif lob[idx] == 193:
                    # letter
                    line.append(GRAY)
                else:
                    assert False
                idx += 1
            char.append(line)
        font.append(char)
    return font


# it's not really used now, but it's nice for debugging
def get_message(clusters, msg_id):
    id = get_id_from_msg_id(msg_id)
    lob = get_resource(clusters, id)
    idx = read_uint_le(lob, get_msg_idx(msg_id))
    if idx != 0:
        return {'id': hex(msg_id), 'msg': read_string(lob, idx + SIZE_OF_HEADER)}
    else:
        return {'id': hex(msg_id), 'msg': None}


def get_msg_idx(msg_id):
    return SIZE_OF_HEADER + ((msg_id & ITM_ID) + 1) * 4


def get_id_from_msg_id(msg_id):
    return 0x03000000 + (msg_id // 0x10000)


def export_messages(clusters, workingdir):
    cluster = clusters[2]
    assert cluster['label'] == 'text'
    with open(cluster['path'], "rb") as f:
        with open(os.path.join(workingdir, 'messages.csv'), 'w', newline='', encoding='utf-8') as output_file:
            dict_writer = csv.DictWriter(output_file, fieldnames=['res', 'id', 'msg', 'translation', 'comment'],
                                         quoting=csv.QUOTE_ALL)
            dict_writer.writeheader()

            group = cluster['groups'][ENGLISH_GROUP]
            for res in group['resources']:
                f.seek(res['offset'])
                lob = list(f.read(res['length']))
                i = 0
                while True:
                    idx = read_uint_le(lob, get_msg_idx(i))
                    if idx > len(lob):
                        break
                    elif idx != 0:
                        msg = {'res': res['i'], 'id': i, 'msg': read_string(lob, idx + SIZE_OF_HEADER)}
                        print(msg)
                        dict_writer.writerow(msg)
                    i += 1


if __name__ == '__main__':
    parser = argparse.ArgumentParser(formatter_class=argparse.ArgumentDefaultsHelpFormatter,
                                     description="Extracts from clusters file: font and messages", )
    parser.add_argument("gamedir", help="directory containing the game files")
    parser.add_argument("workingdir", help="directory to put csv files, and files required for installer")
    parser.add_argument("--skip_messages", "-s",  action='store_true', help="Skip extracting message file")
    args = parser.parse_args()
    clusters = open_clu_desc(args.gamedir)

    write_font(clusters, args.workingdir)
    if not args.skip_messages:
        export_messages(clusters, args.workingdir)


