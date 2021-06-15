import argparse
import csv
import os

from clusters_export import open_clu_desc, ENGLISH_GROUP, SIZE_OF_HEADER
from clusters_export import get_message     #TODO remove


def messages_import(gamedir, workingdir):
    clusters = open_clu_desc(gamedir)
    cluster = clusters[2]
    assert cluster['label'] == 'text'

    with open(os.path.join(workingdir, "messages.csv"), newline='', encoding='utf-8') as csvfile:
        texts = [{k: v for k, v in row.items()}
                 for row in csv.DictReader(csvfile, skipinitialspace=True)]
    read_resources = sorted(list(set([int(r['res']) for r in texts])))

    group_lob = b''
    group_prefix = b''

    for res in read_resources:
        res_texts = [r for r in texts if r['res'] == str(res)]
        offsets = []
        prev_id = -1
        lob = b''
        for text in res_texts:
            assert int(text['id']) > prev_id
            prev_id = int(text['id'])

            offsets.append({'id': text['id'], 'offset': len(lob)})

            if text['translation']:
                lob += str.encode(text['translation'], encoding='cp1255') + b'\0'
            else:
                lob += str.encode(text['msg'], encoding='latin1') + b'\0'
        #TODO save group_prefix
        group_prefix += to_uint(len(group_lob)) + to_uint(len(offsets) + len(lob))
        group_lob += b'\0' * (SIZE_OF_HEADER + 4)
        max_id = max([int(e['id']) for e in offsets])
        for id in range(max_id + 1):
            try:
                entry = [e for e in offsets if e['id'] == str(id)][0]
                group_lob += to_uint(entry['offset'] + (max_id + 2) * 4)
            except:
                group_lob += to_uint(0)
        group_lob += lob

    with open(os.path.join(gamedir, cluster['path']), "wb") as f:
        f.write(group_lob)



def to_uint(i):
    return i.to_bytes(4, byteorder='little', signed=False)


if __name__ == '__main__':
    parser = argparse.ArgumentParser(formatter_class=argparse.ArgumentDefaultsHelpFormatter,
                                     description="Writes messages to cluster files", )
    parser.add_argument("gamedir", help="directory containing the game files")
    parser.add_argument("workingdir", help="directory to put csv files, and files required for installer")
    args = parser.parse_args()

    messages_import(args.gamedir, args.workingdir)

    clusters = open_clu_desc(args.gamedir)
    print(get_message(clusters, 1))
    print(get_message(clusters, 2))
    print(get_message(clusters, 0x40002))
    print(get_message(clusters, 0x40003))
