#TODO: -- change ADJECTIVE/NOUN order: e.g., room 6, "look bad cable" in Hebrew the order is "look cable bad" : I think it's already working...
#TODO: drive - keep token
#TODO: check if can remove some patches from SVM

# runs all import scripts
# and create zip file

import os
import shutil

import misc
import google_drive
import vocab_import
import texts_import
import strings_import

ZIP_FILE = r"C:\Zvika\ScummVM-dev\HebrewAdventure\sq3_hebrew"
ZIP_ROOT_DIR = r"C:\Zvika\ScummVM-dev\HebrewAdventure\sq3"
PATCHES_DIR = "PATCHES"



def copy_compiled_scripts(rooms_to_recompile):
    for room in rooms_to_recompile:
        file_name = 'script.' + room
        shutil.copyfile(os.path.join(misc.compiled_scripts_dir, file_name),
                        os.path.join(misc.patches_dir, file_name))



if __name__ == "__main__":
    print("\nUpdating the .csv files:")
    google_drive.update_local_csvs()

    print("\nVocab import")
    rooms_to_recompile_from_vocab = vocab_import.vocab_import()

    print("\nTexts import")
    texts_import.texts_import()

    print("\nScripts' strings import")
    rooms_to_recompile = strings_import.strings_import(rooms_to_recompile_from_vocab)

    if rooms_to_recompile:
        print("Please run SCICompanion, and compile the following scripts\n", rooms_to_recompile)
        input("\n\nPress Enter when ready...\n")
        print("... continuing")
        copy_compiled_scripts(rooms_to_recompile)

    shutil.make_archive(ZIP_FILE, format='zip', root_dir=ZIP_ROOT_DIR, base_dir=PATCHES_DIR)

    print('\nCreated ' + ZIP_FILE + ".zip")
