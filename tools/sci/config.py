messages_csv_filename = "messages.csv"
messages_keys = {'room': 'חדר',
                 'noun': 'שם', 'verb': 'פועל', 'condition': 'תנאי', 'sequence': 'רצף', 'talker': 'דובר',
                 'original': 'מקור', 'translation': 'תרגום', 'comments': 'הערות', 'padding': 'ריפוד'}
scripts_strings_csv_filename = "scripts_strings.csv"
scripts_strings_keys = {'filename': 'קובץ', 'idx': 'אינדקס', 'original': 'מקור', 'translation': 'תרגום', 'comments': 'הערות'}

texts_csv_filename = "texts.csv"
vocab_csv_filename = "vocab.csv"

csvs_info = (
    (u'הודעות לפי חדרים', 'messages.csv'),
    (u'טקסטים לפי חדרים', 'texts.csv'),
    (u'טקסטים מסקריפטים', 'scripts_strings.csv'),
    (u'מילון לשורת פקודה', 'vocab.csv'),
)
