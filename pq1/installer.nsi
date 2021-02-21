# "C:\Program Files (x86)\NSIS\Bin\GenPat.exe" C:\Zvika\Games\PoliceQuest\AGI.check\WORDS.TOK C:\Zvika\Games\PoliceQuest\AGI\WORDS.TOK WORDS.TOK.patch
# "C:\Program Files (x86)\NSIS\Bin\GenPat.exe" C:\Zvika\ames\PoliceQuest\AGI.check\LOGDIR C:\Zvika\Games\PoliceQuest\AGI\LOGDIR logdir.patch
# "C:\Program Files (x86)\NSIS\Bin\GenPat.exe" C:\Zvika\Games\PoliceQuest\AGI.check\VOL.0 C:\Zvika\Games\PoliceQuest\AGI\VOL.0 VOL.0.patch

!include MUI2.nsh


!define BACKUPDIR "SIERRA_ORIG_ENGLISH"
!define UNINSTALLER_NAME "pq1_heb_uninsaller.exe"

!macro BackupAndUpdateFile INSTDIR FILE 
    IfFileExists "${INSTDIR}\${BACKUPDIR}\*.*" +2
        CreateDirectory "${INSTDIR}\${BACKUPDIR}"
    IfFileExists "${INSTDIR}\${BACKUPDIR}\${FILE}" +2
        CopyFiles "${INSTDIR}\${FILE}" "${INSTDIR}\${BACKUPDIR}\${FILE}"

    DetailPrint "Updating ${FILE} using patch..."
    !insertmacro VPatchFile ${FILE}.patch "${INSTDIR}\${FILE}" "${INSTDIR}\${FILE}.tmp"

    IfErrors 0 +2
        abort
!macroend


; The name of the installer
Name "התרגום העברי של PQ1"

# define installer name
OutFile "pq1-hebrew-installer.exe"

BrandingText "הרפתקה עברית"
 
Unicode true

; The default installation directory
InstallDir "C:\Zvika\Games\PoliceQuest\AGI.check"  #TODO remove this

;TODO nicer message...
!define MUI_TEXT_WELCOME_INFO_TEXT "New text goes here$\r$\n \
and in new line" ;" ; gvim get's confused without that extra "

!define MUI_FINISHPAGE_TEXT  "ההתקנה השולמה בהצלחה.$\r$\n$\r$\n \
נשמח לשמור על קשר! $\r$\n \
חפשו 'הרפתקה עברית' בפייסבוק.$\r$\n \
נשמח לראותכם גם בערוץ הדיסקורד שלנו,$\r$\n \
(קישור בתחתית העמוד)." ;"

!define MUI_FINISHPAGE_LINK "הצטרפות לדיסקורד הרפתקה עברית"
!define MUI_FINISHPAGE_LINK_LOCATION https://discord.gg/yvr2m2jYRG

!insertmacro MUI_PAGE_WELCOME
!insertmacro MUI_PAGE_DIRECTORY
!insertmacro MUI_PAGE_INSTFILES
!insertmacro MUI_PAGE_FINISH
!insertmacro MUI_UNPAGE_WELCOME
!insertmacro MUI_UNPAGE_CONFIRM
!insertmacro MUI_UNPAGE_INSTFILES
!insertmacro MUI_UNPAGE_FINISH

!insertmacro MUI_LANGUAGE "Hebrew"

; The text to prompt the user to enter a directory
DirText "בחר את התיקייה שקבצי PQ1 נמצאים בה"

!include "VPatchLib.nsh"

Section "Update file"
    ; Set output path to the installation directory
    SetOutPath $INSTDIR

    !insertmacro BackupAndUpdateFile $INSTDIR VOL.0
    !insertmacro BackupAndUpdateFile $INSTDIR LOGDIR
    !insertmacro BackupAndUpdateFile $INSTDIR WORDS.TOK
    File agi-font-dos.bin
    File PQ1.WAG

    WriteUninstaller $INSTDIR\${UNINSTALLER_NAME}

    WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\PQ1_Hebrew" \
                     "DisplayName" "PQ1 Hebrew translation"
    WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\PQ1_Hebrew" \
                     "UninstallString" "$INSTDIR\${UNINSTALLER_NAME}"
    
SectionEnd

Section "Uninstall"
    Delete $INSTDIR\agi-font-dos.bin
    Delete $INSTDIR\PQ1.WAG
    CopyFiles "$INSTDIR\${BACKUPDIR}\*.*" $INSTDIR
    Rmdir /r "$INSTDIR\${BACKUPDIR}"
    Delete $INSTDIR\${UNINSTALLER_NAME}
    DeleteRegKey HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\PQ1_Hebrew"
SectionEnd
 
Function .onInit
    IfFileExists $INSTDIR\${UNINSTALLER_NAME} 0 +3
        MessageBox MB_OK "יש להסיר תחילה את ההתקנה הישנה"
        Exec $INSTDIR\${UNINSTALLER_NAME}
FunctionEnd

 

