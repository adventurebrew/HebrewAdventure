# see https://pythonhosted.org/PyDrive/quickstart.html for instructions how to create client_secrets`.json
# actually, this is a better resource, since I moved to CommandLineAuth (because the local browser didn't work well for me)
# https://medium.com/analytics-vidhya/pydrive-to-download-from-google-drive-to-a-remote-machine-14c2d086e84e


from pydrive.auth import GoogleAuth
from pydrive.drive import GoogleDrive
import xlrd
import csv
import os
import config
import argparse


def drive_init():
    gauth = GoogleAuth()
    gauth.CommandLineAuth()
    return GoogleDrive(gauth)


def list_everything():
    drive = drive_init()
    file_list = drive.ListFile({'q': "trashed=false"}).GetList()
    for file1 in file_list:
        print('title: %s, id: %s' % (file1['title'], file1['id']))


def download_excel(output_folder, excel_file_name):
    drive = drive_init()
    file_obj = drive.CreateFile({'id': config.google_drive_file_id})
    file_obj.GetContentFile(os.path.join(output_folder, excel_file_name), mimetype='application/vnd.openxmlformats-officedocument.spreadsheetml.sheet')


def convert_excel_to_csvs(output_folder, excel_file_name):
    with xlrd.open_workbook(os.path.join(output_folder, excel_file_name)) as wb:
        for csv_info in config.csvs_info:
            sh = wb.sheet_by_name(csv_info[0])
            with open(os.path.join(output_folder, csv_info[1]), 'w', newline="", encoding='utf-8') as f:
                c = csv.writer(f, quoting=csv.QUOTE_ALL)
                for r in range(sh.nrows):
                    c.writerow(sh.row_values(r))


def update_local_csvs(output_folder, skip_download, excel_file_name='translation.xlsx'):
    if not skip_download:
        download_excel(output_folder, excel_file_name)
    convert_excel_to_csvs(output_folder, excel_file_name)


if __name__ == "__main__":
    parser = argparse.ArgumentParser(formatter_class=argparse.ArgumentDefaultsHelpFormatter,
                                     description='Downloads excel file from Google Drive, and split it to CSVs')
    group = parser.add_mutually_exclusive_group(required=True)
    group.add_argument("--list", action='store_true', help="List all file names and IDs, and quits, without downloading+creating CSV files. Then, manually update the id in config.py google_drive_file_id")
    group.add_argument("--csvdir", help="directory to store .csv files")
    parser.add_argument("--skip_download", action='store_true', help="Skip downloading from Google Drive")
    args = parser.parse_args()

    if args.list:
        list_everything()
    else:
        update_local_csvs(args.csvdir, args.skip_download)
