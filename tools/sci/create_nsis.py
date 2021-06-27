import argparse
import os

SCRIPT_PATH = os.path.dirname(os.path.realpath(__file__))


if __name__ == "__main__":
    parser = argparse.ArgumentParser(formatter_class=argparse.ArgumentDefaultsHelpFormatter,
                                     description="Create 'installer.nsi' to be used by 'import_all' to create an installer",)
    parser.add_argument("workingdir", help="directory to put installer")
    parser.add_argument("short", help="short game name, in English lowercase. e.g.: 'qfg1'")
    parser.add_argument("desc", help="game description. e.g.: 'QFG1 בגרסה המחודשת - VGA'")
    parser.add_argument("full", help="full Hebrew name. e.g.: 'הרצון לעוצמה 1: אז אתה רוצה להיות גיבור'")
    args = parser.parse_args()

    with open(os.path.join(SCRIPT_PATH, 'installer.nsi'), encoding='utf-8') as f:
        text = f.read()

    text = text.replace('~game~', args.short)
    text = text.replace('~GAME~', args.short.upper())
    text = text.replace('~DESC~', args.desc)
    text = text.replace('~FULL-HEB~', args.full)

    with open(os.path.join(args.workingdir, 'installer.nsi'), 'w', encoding='utf-8') as f:
        f.write(text)

