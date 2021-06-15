import argparse
import csv
import os

from clusters_export import open_clu_desc, SIZE_OF_HEADER, ENGLISH_GROUP, CLUSTER_DESCRIPTION_FILE, MAX_LABEL_SIZE


def write_clu_desc(clusters, gamedir):
    lob = b''
    lob += to_uint(len(clusters))
    for cluster in clusters:
        lob += to_uint(cluster['index'])
    for cluster in clusters:
        if cluster['index'] != 0:
            lob += str.encode(cluster['label'], encoding='latin1')
            lob += b'\0' * (MAX_LABEL_SIZE - len(cluster['label']))
            lob += to_uint(cluster['num_of_groups'])
            for group in cluster['groups']:
                lob += to_uint(group['index'])
            for group in cluster['groups']:
                if group['index'] != 0:
                    lob += to_uint(group['num_of_res'])
                    for res in group['resources']:
                        lob += to_uint(res['index'])
                    for res in group['resources']:
                        if res['index'] != 0:
                            lob += to_uint(res['offset'])
                            lob += to_uint(res['length'])

    clustersdir = os.path.join(gamedir, "clusters")
    with open(os.path.join(clustersdir, CLUSTER_DESCRIPTION_FILE), "wb") as f:
        f.write(lob)


# it saves the messages as English group (0)
def messages_import(gamedir, workingdir):
    clusters = open_clu_desc(gamedir)
    cluster = clusters[2]
    assert cluster['label'] == 'text'
    group_resources = cluster['groups'][ENGLISH_GROUP]['resources']

    with open(os.path.join(workingdir, "messages.csv"), newline='', encoding='utf-8') as csvfile:
        texts = [{k: v for k, v in row.items()}
                 for row in csv.DictReader(csvfile, skipinitialspace=True)]
    resources = sorted(list(set([int(r['res']) for r in texts])))

    group_lob = b''
    group_prefix = b''

    for res in resources:
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
        group_resources[res]['offset'] = len(group_lob)
        group_lob += b'\0' * (SIZE_OF_HEADER)
        num_of_texts = max([int(e['id']) for e in offsets]) + 1
        group_lob += to_uint(num_of_texts)
        for id in range(num_of_texts):
            try:
                entry = [e for e in offsets if e['id'] == str(id)][0]
                group_lob += to_uint(entry['offset'] + (num_of_texts + 1) * 4)
            except:
                group_lob += to_uint(0)
        group_lob += lob
        group_resources[res]['length'] = len(group_lob) - group_resources[res]['offset']

    with open(os.path.join(gamedir, cluster['path']), "wb") as f:
        f.write(group_lob)

    write_clu_desc(clusters, gamedir)


def to_uint(i):
    return i.to_bytes(4, byteorder='little', signed=False)


if __name__ == '__main__':
    parser = argparse.ArgumentParser(formatter_class=argparse.ArgumentDefaultsHelpFormatter,
                                     description="Writes messages to cluster files", )
    parser.add_argument("gamedir", help="directory containing the game files")
    parser.add_argument("workingdir", help="directory to put csv files, and files required for installer")
    args = parser.parse_args()

    messages_import(args.gamedir, args.workingdir)
