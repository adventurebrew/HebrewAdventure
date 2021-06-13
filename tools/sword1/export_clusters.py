import argparse
import csv
import os
import struct
from collections import namedtuple
import png

GRAY = 127
BLACK = 0
WHITE = 255

FONT_PNG = "font.png"

cluster_description_file = "swordres.rif"
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
    result = ""
    while l[idx] != 0:
        result += chr(l[idx])
        idx += 1
    return result


def read_sized_string(l, idx, size):
    result = ""
    for i in range(size):
        if l[idx] != 0:
            result += chr(l[idx])
        idx += 1
    return result


def open_clu_desc(gamedir):
    clustersdir = os.path.join(gamedir, "clusters")
    with open(os.path.join(clustersdir, cluster_description_file), "rb") as f:
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
            cluster['path'] = os.path.join(clustersdir, cluster['label'] + ".CLU")
            index += MAX_LABEL_SIZE
            cluster['num_of_groups'] = read_uint_le(lob, index)
            index += 4
            # print(cluster['label'], cluster['num_of_groups'])     #TODO
            groups_index = []
            for i in range(cluster['num_of_groups']):
                groups_index.append(read_uint_le(lob, index))
                index += 4
            # print(cluster['num_of_groups'], [hex(i) for i in groups_index])    #TODO
            cluster['groups'] = []
            for i in range(cluster['num_of_groups']):
                if groups_index[i] != 0:
                    group = {'i': i}
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
                            res = {}
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

    """TODO
    ignoring this code:
    
    	if (_prj.clu[3].grp[5].noRes == 29)
		for (uint8 cnt = 0; cnt < 29; cnt++)
			_srIdList[cnt] = 0x04050000 | cnt;

    """
    return clusters


def get_resource(clusters, id):
    #TODO: ignoring:
    # if ((id >> 16) == 0x0405)
    #     id = _srIdList[id & 0xFFFF];
    cluster = ((id >> 24) - 1) & 0xff
    group = (id >> 16) & 0xff
    res_id = id & 0xffff
    # print(cluster, group, res_id)
    res = clusters[cluster]['groups'][group]['resources'][res_id]
    with open(clusters[cluster]['path'], "rb") as f:
        f.seek(res['offset'])
        lob = list(f.read(res['length']))
    return lob


def get_frame(lob, number):
    assert number < read_uint_le(lob, SIZE_OF_HEADER)
    idx = read_uint_le(lob, SIZE_OF_HEADER + (number + 1) * 4)
    FrameHeader = namedtuple('FrameHeader', 'runTimeComp compSize width height offsetX offsetY')
    frame_header = FrameHeader._make(struct.unpack("4sIHHhh", bytes(lob[idx:idx + SIZE_OF_FRAME_HEADER])))
    return frame_header, idx + SIZE_OF_FRAME_HEADER


def write_font(clusters, workingdir):
    font = read_font(clusters)
    max_width = max([len(c[0]) for c in font])
    height = len(font[0])
    grid = []
    for row in range(14):
        first_char_in_row = row * 16
        for i in range(height):
            line = []
            for char in font[first_char_in_row:first_char_in_row+16]:
                line.extend([WHITE] * 8)
                line.extend(char[i])
                missing_width = max_width - len(char[i])
                line.extend([WHITE] * (missing_width + 8))
            grid.append(line)
        for i in range(8):
            grid.append([WHITE] * len(line))

    png.from_array(grid, 'L').save(os.path.join(workingdir, FONT_PNG))


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


def get_message(clusters, id):
    english_id = 0x03000000 + (id // 0x10000)
    lob = get_resource(clusters, english_id)
    idx = SIZE_OF_HEADER
    idx += read_uint_le(lob, idx + ((id & ITM_ID) + 1) * 4)

    return {'id': hex(id), 'msg': read_string(lob, idx)}


def write_messages(clusters, workingdir):
    with open(os.path.join(workingdir, 'messages.csv'), 'w', newline='') as output_file:
        dict_writer = csv.DictWriter(output_file, fieldnames=['id', 'msg', 'translation', 'comment'],
                                     quoting=csv.QUOTE_ALL)
        dict_writer.writeheader()

        # last char so far is 0x100430067
        for i in range(0xfffffffff):
            try:
                msg = get_message(clusters, i)
                dict_writer.writerow(msg)
            except:
                pass


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
        write_messages(clusters, args.workingdir)


