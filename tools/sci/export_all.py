# C:\Zvika\Games\sq3ega\sq3ega.checking C:\Zvika\Games\sq3ega\TEMP -g SCI0
# C:\Zvika\Games\gk1 "C:\Zvika\Games\GK mess" -g SCI32

import argparse
import glob
import os
import pandas as pd
import xlsxwriter

import strings_export
import messages_export
import texts_export
import vocab_export

import config


def write_excel(csvdir):
    # Sierra is using ASCII codes below 32 for special symbols.
    # the default engine, Openpyxl, refuses to cooperate with this
    # Googling revealed that xlsxwriter is less conservative about that.
    writer = pd.ExcelWriter(os.path.join(csvdir, "translation.xlsx"), engine='xlsxwriter')

    for filename in glob.glob(os.path.join(csvdir, "*.csv")):
        df_csv = pd.read_csv(filename)

        (_, f_name) = os.path.split(filename)
        # (f_shortname, _) = os.path.splitext(f_name)
        tab_name = [e for e in config.csvs_info if e[1] == f_name][0][0]

        df_csv.to_excel(writer, tab_name, index=False)

    writer.save()


if __name__ == "__main__":
    parser = argparse.ArgumentParser(formatter_class=argparse.RawTextHelpFormatter,
                                     description='Exports resources for translation',
                                     epilog='''

1. You need to work with Kawa's latest SCICompanion 
    (at lease 3.2.3.2, from http://helmet.kafuka.org/sci/SCICompanion.exe)
2. Enable Game->Properties->Manage resources as patch files->Yes
3. Script->Manage decompilation->Decompile->Yes
4. Make sure that 'Script->Compile all' succeeds. 
    If encountering problems, you can report at https://github.com/Kawa-oneechan/SCICompanion/issues
    Or, debug with comparing to https://github.com/EricOakford/SCI-Decompilation-Archive 
5. For SCI0: Make some changes to Main.sc:
    replace "" strings to {}
    add 'name {blah}' property to inventory items that miss it

''')
    parser.add_argument("--generation", "-g",
                        help="interpreter generation (Consult https://wiki.scummvm.org/index.php/Sierra_Game_Versions)\n"
                             "currently supported: 'SCI0', 'SCI32' (for SCI2/SCI3)",
                        choices=['SCI0', 'SCI32'],
                        required=True)
    parser.add_argument("gamedir", help="directory containing the game files (as patches - see below)")
    parser.add_argument("csvdir", help="directory to write .csv and combined .xlsx files")
    args = parser.parse_args()

    strings_export.strings_export(os.path.join(args.gamedir, 'src'), args.csvdir)

    if args.generation == "SCI0":
        texts_export.texts_export(args.gamedir, args.csvdir)
        try:
            vocab_export.vocab_export(args.gamedir, args.csvdir)
        except FileNotFoundError:
            print("Missing vocab file. Have you followed the instructions at this script's help?")
    elif args.generation == "SCI32":
        messages_export.messages_export(args.gamedir, args.csvdir)
    else:
        assert False

    write_excel(args.csvdir)

