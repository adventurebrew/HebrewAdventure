!include MUI2.nsh

!define BACKUPDIR "SIERRA_ORIG_ENGLISH"
!define UNINSTALLER_NAME "~GAME~_heb_uninstaller.exe"

# actually, it's not used in this script instance; but its kept here for future scripts...
!macro BackupAndUpdateFile FILE 
    IfFileExists "$INSTDIR\${BACKUPDIR}\*.*" +2
        CreateDirectory "$INSTDIR\${BACKUPDIR}"
    IfFileExists "$INSTDIR\${BACKUPDIR}\${FILE}" +2
        CopyFiles "$INSTDIR\${FILE}" "$INSTDIR\${BACKUPDIR}\${FILE}"

    DetailPrint "Updating ${FILE} using patch..."
    !insertmacro VPatchFile ${FILE}.patch "$INSTDIR\${FILE}" "$INSTDIR\${FILE}.tmp"

    IfErrors 0 +2
        abort
!macroend

Name "~FULL-HEB~"

OutFile "~game~-hebrew-installer.exe"

BrandingText "הרפתקה עברית"
 
Unicode true

!define MUI_TEXT_WELCOME_INFO_TEXT "ברוכים הבאים.$\r$\n \
$\r$\n \
לפני שנמשיך, יש לוודא כי:$\r$\n$\r$\n  \
• יש ברשותך עותק תקין של ~DESC~ (ניתן לקנות ב GoG)$\r$\n \
• מותקנת גרסת Daily של ScummVM" ;" ; gvim get's confused without that extra "

!define MUI_FINISHPAGE_TEXT  "ההתקנה הושלמה בהצלחה.$\r$\n$\r$\n \
• כעת ניתן להוסיף את המשחק ל ScummVM, והוא יזוהה כ ~GAME~ בעברית.$\r$\n \
• על מנת לתת שמות בעברית למשחקים השמורים, יש להגדיר $\r$\n \
 Edit Game -> Engine -> Use original save/load screens $\r$\n \
• אם התפריט בעברית: $\r$\n \
עריכת משחק -> מנוע -> השתמש במסכי שמירה/טעינה מקוריים$\r$\n$\r$\n \
נשמח לשמור על קשר! $\r$\n \
חפשו 'הרפתקה עברית' בפייסבוק.$\r$\n \
מוזמנים להצטרף לדיונים, או סתם לראות איך דברים נראים מאחורי הקלעים, בערוץ הדיסקורד שלנו:" ;"

!define MUI_TEXT_ABORT_SUBTITLE "ההתקנה לא הושלמה במלואה"

!define MUI_FINISHPAGE_LINK "הצטרפות לדיסקורד 'הרפתקה עברית'"
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

; The text to prompt the user to enter game's directory
DirText "בחר את התיקייה שקבצי ~GAME~ נמצאים בה"

!include "VPatchLib.nsh"

Section "Update file"
    IfFileExists $INSTDIR\${UNINSTALLER_NAME} 0 +4
        MessageBox MB_OK "יש להסיר תחילה את ההתקנה הישנה"
        Exec $INSTDIR\${UNINSTALLER_NAME}
        MessageBox MB_OK "אשר סיום הסרת התקנה ישנה"


    IfFileExists $INSTDIR\PATCHES 0 +3
        MessageBox MB_ICONSTOP "נראה כי זו לא התקנה נקיה של ~GAME~! יש להתחיל מהתקנה נקיה"
		abort


    ; Set output path to the installation directory
    SetOutPath $INSTDIR

    WriteUninstaller $INSTDIR\${UNINSTALLER_NAME}

    WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\~GAME~_Hebrew" \
                     "DisplayName" "~GAME~ Hebrew translation"
    WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\~GAME~_Hebrew" \
                     "UninstallString" "$INSTDIR\${UNINSTALLER_NAME}"


    SetOutPath $INSTDIR\PATCHES
    File "PATCHES\"
SectionEnd

Section "Uninstall"
    Rmdir /r $INSTDIR\PATCHES
    CopyFiles "$INSTDIR\${BACKUPDIR}\*.*" $INSTDIR
    Rmdir /r "$INSTDIR\${BACKUPDIR}"
    Delete $INSTDIR\${UNINSTALLER_NAME}
    DeleteRegKey HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\~GAME~_Hebrew"
SectionEnd
 
