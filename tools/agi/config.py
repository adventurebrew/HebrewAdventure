encoding = 'windows-1255'

sierra_original = "sierra.orig"

xoring_key = "Avis Durgan"

messages_csv_filename = "messages.csv"
# messages_keys = ('room', 'idx', 'original', 'translation', 'comments')
messages_keys = {'room': 'חדר', 'idx': 'אינדקס', 'original': 'מקור', 'translation': 'תרגום', 'comments': 'הערות'}

wordsfile = "WORDS.TOK"
words_extended_file = "WORDS.TOK.EXTENDED"
words_csv_filename = "words.csv"
words_keys = {'idx': 'אינדקס', 'original': 'מקור', 'translation': 'תרגום', 'comments': 'הערות'}

objectfile = "object"
object_csv_filename = "object.csv"
object_keys = {'room': 'חדר', 'original': 'מקור', 'translation': 'תרגום', 'comments': 'הערות'}

systemui_csv_filename = "systemui.csv"
systemui_keys = {'command': 'פקודה מקורית', 'original': 'מקור', 'translation': 'תרגום', 'comments': 'הערות'}

# google_drive:
csvs_info = (
    (u'הודעות', 'messages.csv'),
    (u'חפצים', 'object.csv'),
    (u'פקודות', 'words.csv'),
)

google_drive_file_id = '18uLIobIjoMCbrQ_kBk1yuKFf07nYFgCG3lBXyPGNNuc'

# import_all:
conWAGI_exe = r"C:\Program Files (x86)\WinAGI GDS\conWAGI.exe"
GenPath_exe = r"C:\Program Files (x86)\NSIS\Bin\GenPat.exe"
makensis_exe = r"C:\Program Files (x86)\NSIS\Bin\makensis.exe"

# import_all - installer:
files_to_be_patched = ('OBJECT', 'LOGDIR', 'VIEWDIR', 'VOL.0')
files_to_be_copied = ['WORDS.TOK.EXTENDED', 'agi-font-dos.bin']     # also .wag - will be added by import_all