# see https://pythonhosted.org/PyDrive/quickstart.html for instructions how to create client_secrets`.json
# actually, this is a better resource, since I moved to CommandLineAuth (because the local browser didn't work well for me)
# https://medium.com/analytics-vidhya/pydrive-to-download-from-google-drive-to-a-remote-machine-14c2d086e84e


from pydrive.auth import GoogleAuth
from pydrive.drive import GoogleDrive
import xlrd
import csv
import os

FILE_ID = '1DUBlucPTHk5tWpgg5KfZdb1WRL5TJAXwUjY1bnPn-Yw'
OUTPUT_FOLDER = r"C:\Zvika\ScummVM-dev\HebrewAdventure\sq3\patches"
EXCEL_FILE_NAME = r"sq3.xlsx"
CSVS_INFO = (
    (u'מילון לשורת פקודה', 'vocab.csv'),
    (u'טקסטים מסקריפטים', 'scripts_strings.csv'),
    (u'טקסטים לפי חדרים', 'texts.csv'),
)

def drive_init():
    gauth = GoogleAuth()
    gauth.CommandLineAuth()
    return GoogleDrive(gauth)


# this take time...
# use it once, and search in the output for your file, and copy its ID
def list_everything():
    drive = drive_init()
    file_list = drive.ListFile({'q': "trashed=false"}).GetList()
    for file1 in file_list:
        print('title: %s, id: %s' % (file1['title'], file1['id']))


def download_excel():
    drive = drive_init()
    file_obj = drive.CreateFile({'id': FILE_ID})
    file_obj.GetContentFile(os.path.join(OUTPUT_FOLDER, EXCEL_FILE_NAME), mimetype='application/vnd.openxmlformats-officedocument.spreadsheetml.sheet')


def convert_excel_to_csvs():
    with xlrd.open_workbook(os.path.join(OUTPUT_FOLDER, EXCEL_FILE_NAME)) as wb:
        for csv_info in CSVS_INFO:
            sh = wb.sheet_by_name(csv_info[0])
            with open(os.path.join(OUTPUT_FOLDER, csv_info[1]), 'w', newline="", encoding='utf-8') as f:
                c = csv.writer(f, quoting=csv.QUOTE_ALL)
                for r in range(sh.nrows):
                    c.writerow(sh.row_values(r))

def update_local_csvs():
    download_excel()
    convert_excel_to_csvs()
    #os.remove(os.path.join(OUTPUT_FOLDER, EXCEL_FILE_NAME))


if __name__ == "__main__":
    update_local_csvs()
