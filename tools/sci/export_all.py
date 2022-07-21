import argparse
import glob
import os
import pandas as pd
import xlsxwriter
from pathlib import Path

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

Some preparations:
1. You need to work with Kawa's latest SCICompanion 
    (at lease 3.2.3.2, from http://helmet.kafuka.org/sci/SCICompanion.exe)
2. Enable Game->Properties->Manage resources as patch files->Yes
3. Script->Manage decompilation->Decompile->Yes
4. Make sure that 'Script->Compile all' succeeds. 
    If encountering problems, you can report at https://github.com/Kawa-oneechan/SCICompanion/issues
    Or, debug with comparing to https://github.com/EricOakford/SCI-Decompilation-Archive 
5. For SCI0: Make some changes to Main.sc:
    add 'name {blah}' property to inventory items that miss it

''')
    parser.add_argument("gamedir", help="directory containing the game files (as patches - see below)")
    parser.add_argument("csvdir", help="directory to write .csv and combined .xlsx files")
    args = parser.parse_args()

    Path(args.csvdir).mkdir(exist_ok=True)

    strings_export.strings_export(os.path.join(args.gamedir, 'src'), args.csvdir)
    texts_export.texts_export(args.gamedir, args.csvdir)
    try:
        vocab_export.vocab_export(args.gamedir, args.csvdir)
    except FileNotFoundError as e:
        if Path(e.filename).stem != 'vocab':
            print("export_all.py: ", e)
    messages_export.messages_export(args.gamedir, args.csvdir)

    write_excel(args.csvdir)

