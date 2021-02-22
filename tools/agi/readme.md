# AGI Translation tools

## Translation flow

Assuming translation of PQ1.

### TL;DR
- WinAGI: Tools -> Settings -> Logics(2): Enable "Show message arguments by number"
- WinAGI: change .wag file name to PQ1 (from WinAGI menus), and change inside 'GameID' to 'pq1' (lower!)
- Logic101 (at least for PQ1):
    set.string(inputPrompt, ">")
- Copy agi-font-dos.bin  (run it through bios_font_862_to_1255.py, if needed)
- Run export_all.py
- Translate the Excel file (probably on Google Drive)
- Run all import_all.py


### WinAGI

- Make sure the following is enabled: Tools -> Settings -> Logics(2):  `Show message arguments by number`
- Game -> Import Game  
- Edit game properties, and change GameID to PQ1. Then open `PQ1.wag` and change  'GameID' to 'pq1' (lower case)


### Font

You might need a different font than the default (e.g., for Hebrew).
AGI games used the computer's built in (BIOS/DOS) font.

You can put your font in the game directory, with the name `agi-font-dos.bin` and ScummVM will use it.

A great resource of BIOS fonts is at https://github.com/viler-int10h/vga-text-mode-fonts.
You'll need one of the .F08 fonts, as AGI is looking for 8x8 font.

Nice Hebrew font is https://github.com/viler-int10h/vga-text-mode-fonts/blob/master/PREVIEWS/BIGPILE/HEBIBM83.F08.png 
(preview), and the actual font file is https://github.com/viler-int10h/vga-text-mode-fonts/blob/master/FONTS/BIGPILE/HEBIBM83.F08

For Hebrew, the BIOS font is using the old Code Page 862 encoding, while in order to use ScummVM's BiDI algorithm it's 
better to use the newer Windows 1255 encoding. In order to fix the font, use `./bios_font_862_to_1255.py`


### Export
Run `export_all.py` to export everything to an Excel file.
Upload that file to Google Drive.

### Translate
Now you can share and translate the Google Drive file.

### Import
Run `import_all.py` to import everything from the Excel file.

### Distribute
When everything is ready, create an 'installer.nsi' in the game directory, based on this file.
Then compile it with NSIS to create a nice (un/)installer.


## Tools files summary
- `export_all.py`: exports all required resources from game files to an excel file
- `import_all.py`: imports all required resources to from excel file to game files
- `messages_export.py`: exports all text messages from logic files to csv file
- `messages_import.py`: imports all text messages from csv file to logic files
- `words_export.py`: exports words (used by command parser) to csv file
- `words_import.py`: imports words (used by command parser) from csv file to NON-STANDARD WORDS.TOK.EXTENDED file!
- `object_export.py`: exports object file to csv file
- `object_import.py`: imports object file from csv file
- `bios_font_862_to_1255.py` : fix BIOS font to support modern Hebrew encoding
- `config.py`: contains some common configs for the tools
- `installer.nsi`: template for NSIS installer (to distribute binary diff)
