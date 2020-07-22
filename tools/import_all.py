# runs all import scripts
# and create zip file

import os
import zipfile
import shutil

import google_drive
import vocab_import
import texts_import
import strings_import

ZIP_FILE = r"C:\Zvika\ScummVM-dev\HebrewAdventure\sq3_hebrew"
ZIP_ROOT_DIR = r"C:\Zvika\ScummVM-dev\HebrewAdventure\sq3"
PATCHES_DIR = "PATCHES"

def zipdir(path, ziph):
    # ziph is zipfile handle
    for root, dirs, files in os.walk(path):
        for file in files:
            ziph.write(os.path.join(root, file))

def zip_patches():
    zipf = zipfile.ZipFile(ZIP_FILE, 'w', zipfile.ZIP_DEFLATED)
    zipdir(PATCHES_DIR, zipf)
    zipf.close()


if __name__ == "__main__":
    print("\nUpdating the .csv files:")
    google_drive.update_local_csvs()

    print("\nVocab import")
    vocab_import.vocab_import()

    print("\nTexts import")
    texts_import.texts_import()

    print("\nScripts' strings import")
    scripts = strings_import.strings_import()

    if scripts:
        input("Please run SCICompanion, and press 'Enter' after the scripts patches have been exported...")

    shutil.make_archive(ZIP_FILE, format='zip', root_dir=ZIP_ROOT_DIR, base_dir=PATCHES_DIR)

    print('\nCreated ' + ZIP_FILE + ".zip")
