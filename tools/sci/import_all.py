# C:\Zvika\ScummVM-dev\HebrewAdventure\gk1 "C:\Zvika\Games\GK Hebrew\Gabriel Knight [GOG].patches" "C:\Zvika\Games\GK Hebrew\gk1.trans" -d

#TODO: fail on asm-ing errors

# TODO: drive - keep token
# TODO: check if can remove some patches from SVM

import argparse
import glob
import os
import subprocess
import sys
from pathlib import Path

sys.path.append("..")
from shared import google_drive

import config
import vocab_import
import texts_import
import strings_import
import messages_import
import assembler.script_asm


def create_installer(workingdir):
    nsis_path = os.path.join(workingdir, 'installer.nsi')
    if not os.path.exists(nsis_path):
        print(f"⚠️ Couldn't find {nsis_path}. You might want to run ./create_nsis.py")
    else:
        subprocess.run([config.makensis_exe, nsis_path])


def run_installer(workingdir):
    installers = glob.glob(os.path.join(workingdir, "*-hebrew-installer.exe"))
    if len(installers) == 0:
        print("Couldn't find the created installer. Not running it")
    elif len(installers) > 1:
        print(f"Found too many potential installers: {installers} . Ignoring them all")
    else:
        subprocess.run([installers[0]], shell=True)


if __name__ == "__main__":
    parser = argparse.ArgumentParser(formatter_class=argparse.ArgumentDefaultsHelpFormatter,
                                     description="Downloads translation excel, runs all game's import scripts, compiles and creates an installer.", )
    parser.add_argument("input_game_dir",
                        help="directory containing CLEAN game dir (probably used for 'export_all') - won't be modified")
    parser.add_argument("workingdir", help="directory to put excel, csv and patches files, and installer")
    parser.add_argument("--skip_download", "-s", action='store_true', help="Skip downloading from Google Drive")
    parser.add_argument("--debug", action='store_true', help="create debug files")
    args = parser.parse_args()

    if args.skip_download:
        print("\n*******************************************************************")
        print("Skipping download from Google Drive")
        print("*******************************************************************\n")

    print("\n**** Updating the .csv files ****")
    google_drive.update_local_csvs(args.workingdir, args.skip_download, config)

    patches_dir = os.path.join(args.workingdir, "PATCHES")
    os.makedirs(patches_dir, exist_ok=True)

    for filename in glob.glob(os.path.join(args.workingdir, "*.csv")):
        csvname = os.path.splitext(os.path.split(filename)[1])[0]
        if csvname == 'messages':
            print("\n**** Messages import ****")
            messages_import.messages_import(args.workingdir, args.input_game_dir, patches_dir)
        elif csvname == 'texts':
            print("\n**** Texts import ****")
            texts_import.texts_import(args.workingdir, patches_dir)
        elif csvname == 'scripts_strings':
            print("\n**** Scripts' strings import: ****")
            strings_import.strings_import(args.workingdir)
            assembler.script_asm.asm_all(Path(args.workingdir) / 'asm' / 'modified', patches_dir)
        elif csvname == 'vocab':
            print("\n**** Vocab import: ****")
            vocab_import.vocab_import(args.workingdir, patches_dir, args.output_game_dir, args.debug)
        else:
            print(f"\n*************    Not implemented yet '{csvname}' import   ********************")

    print("\n**** Creating installer ****")
    create_installer(args.workingdir)

    if args.skip_download:
        print("\n*******************************************************************")
        print("Skipped download from Google Drive")
        print("*******************************************************************\n")

    run_installer(args.workingdir)
