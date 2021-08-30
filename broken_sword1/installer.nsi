# In order to create the patches, run:
#
# "C:\Program Files (x86)\NSIS\Bin\GenPat.exe" "C:\Zvika\Games\Broken Sword - Shadow of the Templars - GOG.clean\clusters\general.clu" "C:\Zvika\Games\Broken Sword - The Shadow of the Templars\clusters\general.clu" general.clu.patch /r
# "C:\Program Files (x86)\NSIS\Bin\GenPat.exe" "C:\Zvika\Games\Broken Sword - Shadow of the Templars - GOG.clean\clusters\swordres.rif" "C:\Zvika\Games\Broken Sword - The Shadow of the Templars\clusters\swordres.rif" swordres.rif.patch /r
# "C:\Program Files (x86)\NSIS\Bin\GenPat.exe" "C:\Zvika\Games\Broken Sword - Shadow of the Templars - GOG.clean\clusters\text.clu" "C:\Zvika\Games\Broken Sword - The Shadow of the Templars\clusters\text.clu" text.clu.patch /r

!include MUI2.nsh

!define BACKUPDIR "ORIG_ENGLISH"
!define UNINSTALLER_NAME "bs1_heb_uninsaller.exe"

;;;;; this nsis file isn't standard, and shouldn't (usually) be used as a simple template for other files!!!

; note the unique 'clusters' for Broken Sword all over this file!!
!macro BackupAndUpdateFile FILE 
    IfFileExists "$INSTDIR\${BACKUPDIR}\clusters\*.*" +2
        CreateDirectory "$INSTDIR\${BACKUPDIR}\clusters"
		
    IfFileExists "$INSTDIR\${BACKUPDIR}\${FILE}" +2
        CopyFiles "$INSTDIR\clusters\${FILE}" "$INSTDIR\${BACKUPDIR}\clusters\${FILE}"

    DetailPrint "Updating ${FILE} using patch..."
    !insertmacro VPatchFile ${FILE}.patch "$INSTDIR\clusters\${FILE}" "$INSTDIR\clusters\${FILE}.tmp"

    IfErrors 0 +2
        abort
!macroend

Name "התרגום העברי של חרב שבורה"

OutFile "bs1-hebrew-installer.exe"

BrandingText "הרפתקה עברית"
 
Unicode true

!define MUI_TEXT_WELCOME_INFO_TEXT "ברוכים הבאים.$\r$\n \
$\r$\n \
לפני שנמשיך, יש לוודא כי:$\r$\n$\r$\n  \
• יש ברשותך עותק תקין של חרב שבורה 1 (ניתן לקנות ב GoG)$\r$\n \
• מותקנת גרסת Daily של ScummVM" ;" ; gvim get's confused without that extra "

!define MUI_FINISHPAGE_TEXT  "ההתקנה הושלמה בהצלחה.$\r$\n$\r$\n \
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
DirText "בחר את התיקייה שקבצי חרב שבורה נמצאים בה"

!include "VPatchLib.nsh"

Section "Update file"
    IfFileExists $INSTDIR\${UNINSTALLER_NAME} 0 +4
        MessageBox MB_OK "יש להסיר תחילה את ההתקנה הישנה"
        Exec $INSTDIR\${UNINSTALLER_NAME}
        MessageBox MB_OK "אשר סיום הסרת התקנה ישנה"

    ; Set output path to the installation directory
    SetOutPath $INSTDIR

    WriteUninstaller $INSTDIR\${UNINSTALLER_NAME}

    WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\BS1_Hebrew" \
                     "DisplayName" "BS1 Hebrew translation"
    WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\BS1_Hebrew" \
                     "UninstallString" "$INSTDIR\${UNINSTALLER_NAME}"


    !insertmacro BackupAndUpdateFile general.clu
    !insertmacro BackupAndUpdateFile swordres.rif
    !insertmacro BackupAndUpdateFile text.clu
	
	CreateDirectory "$INSTDIR\${BACKUPDIR}\video"
	CopyFiles $INSTDIR\video\*.txt "$INSTDIR\${BACKUPDIR}\video" 
	File /r video
SectionEnd

Section "Uninstall"
	Delete $INSTDIR\video\intro.txt
	Delete $INSTDIR\video\finale.txt
	Delete $INSTDIR\video\ferrari.txt
	Delete $INSTDIR\video\history.txt
	
	; note the unique 'clusters' for Broken Sword!!
    CopyFiles "$INSTDIR\${BACKUPDIR}\*.*" $INSTDIR
    Rmdir /r "$INSTDIR\${BACKUPDIR}"
    Delete $INSTDIR\${UNINSTALLER_NAME}
    DeleteRegKey HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\BS1_Hebrew"
SectionEnd
 
