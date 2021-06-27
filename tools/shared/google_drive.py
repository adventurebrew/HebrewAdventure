# see https://pythonhosted.org/PyDrive/quickstart.html for instructions how to create client_secrets`.json
# actually, this is a better resource, since I moved to CommandLineAuth (because the local browser didn't work well for me)
# https://medium.com/analytics-vidhya/pydrive-to-download-from-google-drive-to-a-remote-machine-14c2d086e84e
import re
import sys

import pydrive.settings
from pydrive.auth import GoogleAuth
from pydrive.drive import GoogleDrive
import pandas as pd
import csv
import os
import argparse


DRIVE_FILE_ID = 'google_drive_file_id.txt'
SCRIPT_PATH = os.path.dirname(os.path.realpath(__file__))
CLIENT_SECRETS_JSON_PATH = os.path.join(SCRIPT_PATH, 'client_secrets.json')


def drive_init():
    gauth = GoogleAuth()
    os.chdir(SCRIPT_PATH)
    try:
        gauth.CommandLineAuth()
    except pydrive.settings.InvalidConfigError:
        print(f"Couldn't find '{CLIENT_SECRETS_JSON_PATH}'\n"
              "Please create it, according to https://medium.com/analytics-vidhya/pydrive-to-download-from-google-drive-to-a-remote-machine-14c2d086e84e")
        sys.exit(1)
    return GoogleDrive(gauth)


def list_everything():
    drive = drive_init()
    file_list = drive.ListFile({'q': "trashed=false"}).GetList()
    for file1 in file_list:
        print('title: %s, id: %s' % (file1['title'], file1['id']))


def download_excel(output_folder, excel_file_name):
    drive = drive_init()
    drive_file_id_path = os.path.join(output_folder, DRIVE_FILE_ID)
    try:
        with open(drive_file_id_path) as f:
            id = f.read().strip()
    except FileNotFoundError:
        print(f"'{drive_file_id_path}' not found, please create it (read about '--list' in {__file__} --help)")
        sys.exit(1)

    file_obj = drive.CreateFile({'id': id})
    file_obj.GetContentFile(os.path.join(output_folder, excel_file_name), mimetype='application/vnd.openxmlformats-officedocument.spreadsheetml.sheet')


def convert_excel_to_csvs(output_folder, excel_file_name, config):
    dfs = pd.read_excel(os.path.join(output_folder, excel_file_name), engine='openpyxl', sheet_name=None)
    for key in dfs:
        csv_name = [c[1] for c in config.csvs_info if c[0] == key]
        if csv_name:
            df = dfs[key]
            # openpyxl replaces ascii<32 values, e.g. 18, to hex strings: '_x0012_' - replace it back
            df = df.applymap(lambda x:
                             re.sub(r'_x00(\d\w)_', lambda m: chr(int(m.group(1), 16)), x)
                             if isinstance(x, str) else x)

            df.to_csv(os.path.join(output_folder, csv_name[0]), index=False, quoting=csv.QUOTE_ALL)
            # print(csv_name, df)

    # with xlrd.open_workbook(os.path.join(output_folder, excel_file_name)) as wb:
    #     for csv_info in config.csvs_info:
    #         sh = wb.sheet_by_name(csv_info[0])
    #         with open(os.path.join(output_folder, csv_info[1]), 'w', newline="", encoding='utf-8') as f:
    #             c = csv.writer(f, quoting=csv.QUOTE_ALL)
    #             for r in range(sh.nrows):
    #                 c.writerow(sh.row_values(r))


def update_local_csvs(output_folder, skip_download, config, excel_file_name='translation.xlsx'):
    if not skip_download:
        download_excel(output_folder, excel_file_name)
    convert_excel_to_csvs(output_folder, excel_file_name, config)


if __name__ == "__main__":
    parser = argparse.ArgumentParser(formatter_class=argparse.RawTextHelpFormatter,
                                     description='Downloads excel file from Google Drive, and split it to CSVs')
    group = parser.add_mutually_exclusive_group(required=True)
    group.add_argument("--list", action='store_true', help="List all file names and IDs, and quits, without downloading+creating CSV files. \n"
                                                           f"Then, write the translation spreadsheet file id in 'csvdir' as '{DRIVE_FILE_ID}'")
    group.add_argument("--csvdir", help="directory to store .csv files")
    parser.add_argument("--skip_download", action='store_true', help="Skip downloading from Google Drive")
    args = parser.parse_args()

    if args.list:
        list_everything()
    else:
        update_local_csvs(args.csvdir, args.skip_download, None)
