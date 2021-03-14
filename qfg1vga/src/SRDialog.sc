;;; Sierra Script 1.0 - (do not remove this comment)
(script# 990)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Print)
(use DIcon)
(use n932)
(use Class_993_0)

(public
	proc990_0 0
)

(local
	gGameParseLang
	local1
	local2
	local3
	local4
	local5
	[local6 4] = [{טעינה} {שמירה} {החלפה} {החלפה}]
	[local10 4] = [{בחר את השמירה שברצונך לטעון.} {הקש את תיאור המשחק השמור.} {This directory/disk can hold no more saved games. You must replace one of your saved games or use Change Directory to save on a different directory/disk.} {This directory/disk can hold no more saved games. You must replace one of your saved games or use Change Directory to save on a different directory/disk.}]
)
(procedure (proc990_0 param1 &tmp temp0 [temp1 33] [temp34 100] temp134 [temp135 100] [temp235 5] [temp240 5])
	(asm
code_07f0:
		pushi    #parseLang
		pushi    0
		lag      gGame
		send     4
		sat      temp134
		pushi    #parseLang
		pushi    1
		pushi    1
		lag      gGame
		send     6
		pushi    7
		pushi    0
		pushi    990
		pushi    1
		pushi    0
		pushi    0
		pushi    1
		lea      @temp135
		push    
		callk    Message,  14
		pushi    7
		pushi    0
		pushi    990
		pushi    4
		pushi    0
		pushi    0
		pushi    1
		lea      @temp235
		push    
		callk    Message,  14
		pushi    7
		pushi    0
		pushi    990
		pushi    5
		pushi    0
		pushi    0
		pushi    1
		lea      @temp240
		push    
		callk    Message,  14
		pushi    #font
		pushi    1
		pushi    0
		pushi    198
		pushi    1
		lea      @temp135
		push    
		pushi    200
		pushi    5
		pushi    2
		lea      @temp1
		push    
		lsp      param1
		callk    StrCpy,  4
		push    
		pushi    29
		pushi    0
		pushi    12
		lsp      param1
		pushi    205
		pushi    4
		pushi    1
		lea      @temp235
		push    
		pushi    0
		pushi    26
		pushi    205
		pushi    4
		pushi    0
		lea      @temp240
		push    
		pushi    50
		pushi    26
		pushi    110
		pushi    0
		class    Print
		send     54
		sat      temp0
		pushi    #parseLang
		pushi    1
		lst      temp134
		lag      gGame
		send     6
		lat      temp0
		not     
		bnt      code_088e
		ldi      0
		ret     
code_088e:
		pushi    1
		lea      @temp1
		push    
		callk    StrLen,  2
		not     
		bnt      code_08a1
		pushi    1
		lea      @temp1
		push    
		callk    GetCWD,  2
code_08a1:
		pushi    1
		lea      @temp1
		push    
		callk    ValidPath,  2
		bnt      code_08bb
		pushi    2
		lsp      param1
		lea      @temp1
		push    
		callk    StrCpy,  4
		ldi      1
		ret     
		jmp      code_07f0
code_08bb:
		pushi    7
		pushi    0
		pushi    990
		pushi    2
		pushi    0
		pushi    0
		pushi    1
		lea      @temp135
		push    
		callk    Message,  14
		pushi    3
		lea      @temp34
		push    
		lea      @temp135
		push    
		lea      @temp1
		push    
		callk    Format,  6
		pushi    #font
		pushi    1
		pushi    0
		pushi    198
		pushi    1
		lea      @temp34
		push    
		pushi    110
		pushi    0
		class    Print
		send     16
		jmp      code_07f0
		ret     
	)
)

(procedure (localproc_0676)
	(return
		(cond 
			((== self Restore) 0)
			((localproc_08f4) 1)
			(local3 2)
			(else 3)
		)
	)
)

(procedure (localproc_08f4)
	(if (< local3 20) (CheckFreeSpace global29))
)

(procedure (localproc_0902 &tmp [temp0 100])
	(Message msgGET 990 3 0 0 1 @temp0)
	(Print font: 0 addText: @temp0 init:)
)

(class SRDialog of Dialog
	(properties
		elements 0
		size 0
		text 0
		font 0
		window 0
		theItem 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		time 0
		caller 0
		seconds 0
		lastSeconds 0
		eatTheMice 0
		lastTicks 0
	)
	
	(method (init param1 param2 param3)
		(proc932_3)
		(= gGameParseLang (gGame parseLang?))
		(gGame parseLang: 1)
		(= window gHSW)
		(= nsBottom 0)
		(if
			(==
				(= local3 (GetSaveFiles (gGame name?) param2 param3))
				-1
			)
			(return 0)
		)
		(if (== (= local5 (localproc_0676)) 1)
			(editI
				text: (StrCpy param1 param2)
				font: global23
				setSize:
				moveTo: 4 4
			)
			(self add: editI setSize:)
		)
		;Z original code:
;		(selectorI
;			text: param2
;			font: global23
;			setSize:
;			moveTo: 4 (+ nsBottom 4)
;			state: 2
;		)
;		(= local2 (+ (selectorI nsRight?) 4))
;		(okI
;			text: [local6 local5]
;			setSize:
;			moveTo: local2 (selectorI nsTop?)
;			state:
;				(if
;				(or (and (== local5 0) (not local3)) (== local5 3))
;					0
;				else
;					3
;				)
;		)
;		(deleteI
;			setSize:
;			moveTo: local2 (+ (okI nsBottom?) 4)
;			state: (if (not local3) 0 else 3)
;		)
;		(changeDirI
;			setSize:
;			moveTo: local2 (+ (deleteI nsBottom?) 4)
;			state: (& (changeDirI state?) $fff7)
;		)
;		(cancelI
;			setSize:
;			moveTo: local2 (+ (changeDirI nsBottom?) 4)
;			state: (& (cancelI state?) $fff7)
;		)
;		(self
;			add: selectorI okI deleteI changeDirI cancelI
;			setSize:
;		)


		;Z I've changed it, to relocate the button to the left of the games list
		;Z and get rid of "Change Directory", as it's useless in ScummVM

		(okI
			text: [local6 local5]
			setSize:
			moveTo: 4 (+ nsBottom 4)
			state:
				(if
				(or (and (== local5 0) (not local3)) (== local5 3))
					0
				else
					3
				)
		)
		(deleteI
			setSize:
			moveTo: 4 (+ (okI nsBottom?) 4)
			state: (if (not local3) 0 else 3)
		)
		(cancelI
			setSize:
			moveTo: 4 (+ (deleteI nsBottom?) 4)
			state: (& (cancelI state?) $fff7)
		)

		(selectorI
			text: param2
			font: global23
			setSize:
			moveTo: (+ (okI nsRight?) 4) (okI nsTop?)
			state: 2
		)


		;Z move the edit line to be right aligned	(note that it's different than SQ3)
		(editI move: (- nsRight (editI nsRight?)) 0)


		(self
			add: selectorI okI deleteI cancelI
			setSize:
		)
		
		;Z end of changes


		(textI
			text: [local10 local5]
			setSize: (- (- nsRight nsLeft) 8)
			moveTo: 4 4
		)
		(= local2 (+ (textI nsBottom?) 4))
		(self eachElementDo: #move 0 local2)
		(self add: textI setSize: center: open: 4 -1)
		(return 1)
	)
	
	(method (doit param1 &tmp temp0 temp1 temp2 [temp3 361] [temp364 21] [temp385 140])
		(asm
			pushSelf
			class    Restore
			eq?     
			bnt      code_032c
			lap      argc
			bnt      code_032c
			lap      param1
			bnt      code_032c
			pushi    2
			pushi    0
			pushi    4
			lea      @temp385
			push    
			pushi    990
			pushi    0
			pushi    #name
			pushi    0
			lag      gGame
			send     4
			push    
			callk    Format,  8
			push    
			callk    FileIO,  4
			sat      temp0
			push    
			ldi      65535
			eq?     
			bnt      code_0325
			ret     
code_0325:
			pushi    2
			pushi    1
			lst      temp0
			callk    FileIO,  4
code_032c:
			pushi    #init
			pushi    3
			lsp      param1
			lea      @temp3
			push    
			lea      @temp364
			push    
			self     10
			not     
			bnt      code_0344
			ldi      65535
			ret     
code_0344:
			lsl      local5
			dup     
			ldi      0
			eq?     
			bnt      code_035a
			lal      local3
			bnt      code_0355
			lofsa    okI
			jmp      code_0373
code_0355:
			lofsa    changeDirI
			jmp      code_0373
code_035a:
			dup     
			ldi      1
			eq?     
			bnt      code_0365
			lofsa    editI
			jmp      code_0373
code_0365:
			dup     
			ldi      2
			eq?     
			bnt      code_0370
			lofsa    okI
			jmp      code_0373
code_0370:
			lofsa    changeDirI
code_0373:
			toss    
			sal      local1
			pushi    #doit
			pushi    1
			push    
			super    Dialog,  6
			sal      local2
			pushi    #indexOf
			pushi    1
			pushi    #cursor
			pushi    0
			lofsa    selectorI
			send     4
			push    
			lofsa    selectorI
			send     6
			sal      local4
			push    
			ldi      18
			mul     
			sat      temp2
			lsl      local2
			lofsa    changeDirI
			eq?     
			bnt      code_03ea
			pushi    #dispose
			pushi    0
			self     4
			pushi    1
			lsg      global29
			call     proc990_0,  2
			bnt      code_03d5
			pushi    3
			pushi    #name
			pushi    0
			lag      gGame
			send     4
			push    
			lea      @temp3
			push    
			lea      @temp364
			push    
			callk    GetSaveFiles,  6
			sal      local3
			push    
			ldi      65535
			eq?     
			bnt      code_03d5
			ldi      65535
			sat      temp1
			jmp      code_0660
code_03d5:
			pushi    #init
			pushi    3
			lsp      param1
			lea      @temp3
			push    
			lea      @temp364
			push    
			self     10
			jmp      code_0344
code_03ea:
			lsl      local5
			ldi      2
			eq?     
			bnt      code_0434
			lsl      local2
			lofsa    okI
			eq?     
			bnt      code_0434
			pushi    #dispose
			pushi    0
			self     4
			pushi    #doit
			pushi    1
			pushi    2
			lsp      param1
			lat      temp2
			leai     @temp3
			push    
			callk    StrCpy,  4
			push    
			lofsa    GetReplaceName
			send     6
			bnt      code_041f
			lal      local4
			lati     temp364
			sat      temp1
			jmp      code_0660
code_041f:
			pushi    #init
			pushi    3
			lsp      param1
			lea      @temp3
			push    
			lea      @temp364
			push    
			self     10
			jmp      code_0344
code_0434:
			lsl      local5
			ldi      1
			eq?     
			bnt      code_04f5
			lsl      local2
			lofsa    okI
			eq?     
			bt       code_044d
			lsl      local2
			lofsa    editI
			eq?     
			bnt      code_04f5
code_044d:
			pushi    1
			lsp      param1
			callk    StrLen,  2
			push    
			ldi      0
			eq?     
			bnt      code_0478
			pushi    #dispose
			pushi    0
			self     4
			pushi    0
			call     localproc_0902,  0
			pushi    #init
			pushi    3
			lsp      param1
			lea      @temp3
			push    
			lea      @temp364
			push    
			self     10
			jmp      code_0344
code_0478:
			ldi      65535
			sat      temp1
			ldi      0
			sal      local2
code_0480:
			lsl      local2
			lal      local3
			lt?     
			bnt      code_049f
			pushi    2
			lsp      param1
			lsl      local2
			ldi      18
			mul     
			leai     @temp3
			push    
			callk    StrCmp,  4
			sat      temp1
			not     
			bt       code_049f
			+al      local2
			jmp      code_0480
code_049f:
			lat      temp1
			not     
			bnt      code_04ae
			lal      local2
			lati     temp364
			sat      temp1
			jmp      code_0660
code_04ae:
			lsl      local3
			ldi      20
			eq?     
			bnt      code_04bf
			lal      local4
			lati     temp364
			sat      temp1
			jmp      code_0660
code_04bf:
			ldi      0
			sat      temp1
code_04c3:
			ldi      1
			bnt      code_0660
			ldi      0
			sal      local2
code_04cc:
			lsl      local2
			lal      local3
			lt?     
			bnt      code_04e1
			lst      temp1
			lal      local2
			lati     temp364
			eq?     
			bt       code_04e1
			+al      local2
			jmp      code_04cc
code_04e1:
			lsl      local2
			lal      local3
			eq?     
			bnt      code_04eb
			jmp      code_0660
code_04eb:
			+at      temp1
			jmp      code_04c3
			jmp      code_0660
			jmp      code_0344
code_04f5:
			lsl      local2
			lofsa    deleteI
			eq?     
			bnt      code_060c
			pushi    #dispose
			pushi    0
			self     4
			pushi    #addText
			pushi    1
			lofsa    {האם אתה בטוח שאתה רוצה למחוק את המשחק השמור הזה?}			push    
			pushi    205
			pushi    4
			pushi    0
			lofsa    {לא}
			push    
			pushi    15
			pushi    27
			pushi    205
			pushi    4
			pushi    1
			lofsa    {כן}
			push    
			pushi    70
			pushi    27
			pushi    110
			pushi    0
			class    Print
			send     34
			not     
			bnt      code_0546
			pushi    #init
			pushi    3
			lsp      param1
			lea      @temp3
			push    
			lea      @temp364
			push    
			self     10
			jmp      code_0344
code_0546:
			pushi    #name
			pushi    1
			pushi    3
			pushi    7
			lea      @temp385
			push    
			pushi    #name
			pushi    0
			lag      gGame
			send     4
			push    
			callk    DeviceInfo,  6
			push    
			pushi    189
			pushi    1
			pushi    2
			pushi    #new
			pushi    0
			class    Class_993_0
			send     4
			sat      temp0
			send     12
			ldi      2570
			sat      temp1
			ldi      0
			sal      local2
code_0578:
			lsl      local2
			lal      local3
			lt?     
			bnt      code_05b9
			lsl      local2
			lal      local4
			ne?     
			bnt      code_05b5
			pushi    #write
			pushi    2
			lal      local2
			leai     @temp364
			push    
			pushi    2
			lat      temp0
			send     8
			pushi    356
			pushi    #x
			lsl      local2
			ldi      18
			mul     
			leai     @temp3
			push    
			lat      temp0
			send     6
			pushi    #write
			pushi    2
			lea      @temp1
			push    
			pushi    1
			lat      temp0
			send     8
code_05b5:
			+al      local2
			jmp      code_0578
code_05b9:
			ldi      65535
			sat      temp1
			pushi    #write
			pushi    2
			lea      @temp1
			push    
			pushi    2
			pushi    360
			pushi    0
			pushi    111
			pushi    0
			lat      temp0
			send     16
			pushi    4
			pushi    8
			lea      @temp385
			push    
			pushi    #name
			pushi    0
			lag      gGame
			send     4
			push    
			lal      local4
			lsti     temp364
			callk    DeviceInfo,  8
			pushi    2
			pushi    4
			lea      @temp385
			push    
			callk    FileIO,  4
			pushi    #init
			pushi    3
			lsp      param1
			lea      @temp3
			push    
			lea      @temp364
			push    
			self     10
			jmp      code_0344
code_060c:
			lsl      local2
			lofsa    okI
			eq?     
			bnt      code_0620
			lal      local4
			lati     temp364
			sat      temp1
			jmp      code_0660
			jmp      code_0344
code_0620:
			lsl      local2
			ldi      65535
			eq?     
			bt       code_062f
			lsl      local2
			lofsa    cancelI
			eq?     
			bnt      code_0638
code_062f:
			ldi      65535
			sat      temp1
			jmp      code_0660
			jmp      code_0344
code_0638:
			lsl      local5
			ldi      1
			eq?     
			bnt      code_0344
			pushi    #cursor
			pushi    1
			pushi    1
			pushi    2
			lsp      param1
			lat      temp2
			leai     @temp3
			push    
			callk    StrCpy,  4
			push    
			callk    StrLen,  2
			push    
			pushi    80
			pushi    0
			lofsa    editI
			send     10
			jmp      code_0344
code_0660:
			pushi    1
			pushi    993
			callk    DisposeScript,  2
			pushi    #dispose
			pushi    0
			self     4
			pushi    1
			pushi    990
			callk    DisposeScript,  2
			lat      temp1
			ret     
		)
	)
	
	(method (dispose)
		(proc932_4)
		(gGame parseLang: gGameParseLang)
		(super dispose: &rest)
	)
)

(class Restore of SRDialog
	(properties
		elements 0
		size 0
		text {טעינת שמירה}
		font 0
		window 0
		theItem 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		time 0
		caller 0
		seconds 0
		lastSeconds 0
		eatTheMice 0
		lastTicks 0
	)
)

(class Save of SRDialog
	(properties
		elements 0
		size 0
		text {שמירת משחק}
		font 0
		window 0
		theItem 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		time 0
		caller 0
		seconds 0
		lastSeconds 0
		eatTheMice 0
		lastTicks 0
	)
)

(instance GetReplaceName of Dialog
	(properties)
	
	(method (doit param1 &tmp temp0 gGameParseLang_2)
		(= gGameParseLang_2 (gGame parseLang?))
		(gGame parseLang: 1)
		(= window gHSW)
		(text1 setSize: moveTo: 4 4)
		(self add: text1 setSize:)
		(oldName
			text: param1
			font: global23
			setSize:
			moveTo: 4 nsBottom
		)
		(self add: oldName setSize:)
		(text2 setSize: moveTo: 4 nsBottom)
		(self add: text2 setSize:)
		(newName
			text: param1
			font: global23
			setSize:
			moveTo: 4 nsBottom
		)
		(self add: newName setSize:)
		(button1 nsLeft: 0 nsTop: 0 setSize:)
		(button2 nsLeft: 0 nsTop: 0 setSize:)
		(button2
			moveTo: (- nsRight (+ (button2 nsRight?) 4)) nsBottom
		)
		(button1
			moveTo: (- (button2 nsLeft?) (+ (button1 nsRight?) 4)) nsBottom
		)
		(self add: button1 button2 setSize: center: open: 0 -1)
		(= temp0 (super doit: newName))
		(self dispose:)
		(if (not (StrLen param1))
			(localproc_0902)
			(= temp0 0)
		)
		(gGame parseLang: gGameParseLang_2)
		(return (if (== temp0 newName) else (== temp0 button1)))
	)
)

(instance selectorI of DSelector
	(properties
		x 36
		y 8
	)
)

(instance editI of DEdit
	(properties
		max 35
	)
)

(instance okI of DButton
	(properties)
	
	(method (dispose)
		(super dispose: 1)
	)
)

(instance cancelI of DButton
	(properties
		text {ביטול}
	)
	
	(method (dispose)
		(super dispose: 1)
	)
)

(instance changeDirI of DButton
	(properties
		text {החלפת ספריה}	)
	
	(method (dispose)
		(super dispose: 1)
	)
)

(instance deleteI of DButton
	(properties
		text {מחיקה}
	)
	
	(method (dispose)
		(super dispose: 1)
	)
)

(instance textI of DText
	(properties
		font 0
	)
	
	(method (dispose)
		(super dispose: 1)
	)
)

(instance text1 of DText
	(properties
		text {החלפה}
		font 0
	)
	
	(method (dispose)
		(super dispose: 1)
	)
)

(instance text2 of DText
	(properties
		text {עם:}
		font 0
	)
	
	(method (dispose)
		(super dispose: 1)
	)
)

(instance oldName of DText
	(properties)
	
	(method (dispose)
		(super dispose: 1)
	)
)

(instance newName of DEdit
	(properties
		max 35
	)
)

(instance button1 of DButton
	(properties
		text {החלפה}
	)
	
	(method (dispose)
		(super dispose: 1)
	)
)

(instance button2 of DButton
	(properties
		text {ביטול}
	)
	
	(method (dispose)
		(super dispose: 1)
	)
)
