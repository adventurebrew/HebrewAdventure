#TODO: drive - keep token

import os
import shutil
import argparse
import subprocess
import pathlib

import google_drive
import messages_import
import words_import
import object_import
import config


def create_installer(cleandir, gamedir, workingdir, wagfile):
    for p in config.files_to_be_patched:
        subprocess.run([config.GenPath_exe,
                        os.path.join(cleandir, p),
                        os.path.join(gamedir, p),
                        os.path.join(workingdir, p+".patch"),
                        '/r'])
    
    config.files_to_be_copied.append(os.path.basename(wagfile))
    for c in config.files_to_be_copied:
        shutil.copyfile(os.path.join(gamedir, c),
                        os.path.join(workingdir, c))

    subprocess.run([config.makensis_exe,
                    os.path.join(workingdir, 'installer.nsi')])



if __name__ == "__main__":
    parser = argparse.ArgumentParser(formatter_class=argparse.ArgumentDefaultsHelpFormatter,
                                     description="Downloads translation excel, runs all game's import scripts, compiles and creates an installer",)
    parser.add_argument("cleandir", help="directory containing the clean game files, as created by Sierra")
    parser.add_argument("gamedir", help="directory containing the updated game files")
    parser.add_argument("workingdir", help="directory to put csv files, and files required for installer")
    parser.add_argument("--pattern", default='*.lgc', help="logic files pattern")
    parser.add_argument("--src", default='src', help="source directory inside 'gamedir'")
    parser.add_argument("--skip_drive", action='store_true', help="Skip downloading from Google Drive")
    args = parser.parse_args()

    if args.skip_drive:
        print("\n*******************************************************************")
        print("Skipping download from Google Drive")
        print("*******************************************************************\n")
    else:
        print("\nUpdating the .csv files:")
        google_drive.update_local_csvs(args.workingdir)

    print("\nMessages import")
    messages_import.messages_import(os.path.join(args.gamedir, args.src), args.pattern, args.workingdir)

    print("\nWords import")
    words_import.words_import(args.gamedir, args.workingdir)

    print("\nObject import")
    object_import.object_import(args.gamedir, args.workingdir)

    wag_file = list(pathlib.Path(args.gamedir).glob('**/*.WAG'))[0]

    print("\nCompiling dirty scripts")

    #TODO: currently capture_output=True fails to capture the output. I've reported it
    #TODO: currently p.returncode is always zero. I'll report it after the output issue will be solved...
    #note: currently, when running from PyCharm, needs to enable Execution->Emulate terminal in output console, under script's configuration
    p = subprocess.run([config.conWAGI_exe, '/d', wag_file], check=True, capture_output=False)

    print("\nCreating installer")
    create_installer(args.cleandir, args.gamedir, args.workingdir, wag_file)

    if args.skip_drive:
        print("\n*******************************************************************")
        print("Skipped download from Google Drive")
        print("*******************************************************************\n")

