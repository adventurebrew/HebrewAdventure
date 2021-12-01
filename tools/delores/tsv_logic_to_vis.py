import argparse
import csv

import pandas as pd
from bidi.algorithm import get_display

#TODO: we have problem when diffing to original English - some 's are lost
#TODO: solve wrapping of long lines
def tsv_logic_to_csv(input_path, output_path):
    df = pd.read_csv(input_path, sep='\t', quoting=csv.QUOTE_NONE)
    df = df.applymap(lambda x: get_display(x) if isinstance(x, str) else x)
    df.to_csv(output_path, sep='\t', index=False, quoting=csv.QUOTE_NONE)



if __name__ == "__main__":
    parser = argparse.ArgumentParser(formatter_class=argparse.ArgumentDefaultsHelpFormatter,
                                     description="Reads a delores 'Translations_he.tsv' file, with logical Hebrew, and changes the Hebrew column to visual Hebrew",)
    parser.add_argument("input_path", help="full path to input tsv file")
    parser.add_argument("output_path", help="full path to output tsv file")
    args = parser.parse_args()

    tsv_logic_to_csv(args.input_path, args.output_path)
