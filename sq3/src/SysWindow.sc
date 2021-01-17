;;; Sierra Script 1.0 - (do not remove this comment)

;;;;	SAVE.SC
;;;;	(c) Sierra On-Line, Inc, 1988
;;;;
;;;;	Author: Jeff Stephenson
;;;;
;;;;	Classes which create the save/restore game user interface.  Also
;;;;	contains a number of instances of Dialogs and associated DItems
;;;;	used in the interface.
;;;;
;;;;	Classes:
;;;;		SRDialog
;;;;		Save
;;;;		Restore



(script# 990)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Obj)

(public
	proc990_0 0
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 4] = [{טען} {שמור} {החלף} {החלף}]
	[local9 4] = [{בחר את המשחק שברצונך לטעון} {הקלד את תאור המשחק שברצונך לשמור}{אין עוד מקום לשמירת משחקים.\nעליך להחליף את אחד המשחקים.}{אין עוד מקום לשמירת משחקים.\nעליך להחליף את אחד המשחקים.}]
)
(procedure (proc990_0 param1 &tmp temp0 [temp1 33] [temp34 40])
	(asm
code_0748:
		pushi    13
		pushi    990
		pushi    1
		pushi    33
		pushi    0
		pushi    41
		pushi    2
		lea      @temp1
		push    
		lsp      param1
		callk    StrCpy,  4
		push    
		pushi    29
		pushi    81
		lofsa    {בסדר}
		push    
		pushi    1
		pushi    81
		lofsa    {בטל}
		push    
		pushi    0
		calle    proc255_0,  26
		sat      temp0
		not     
		bnt      code_077b
		ldi      0
		ret     
code_077b:
		pushi    1
		lea      @temp1
		push    
		callk    StrLen,  2
		not     
		bnt      code_078f
		pushi    1
		lea      @temp1
		push    
		callk    GetCWD,  2
code_078f:
		pushi    1
		lea      @temp1
		push    
		callk    ValidPath,  2
		bnt      code_07aa
		pushi    2
		lsp      param1
		lea      @temp1
		push    
		callk    StrCpy,  4
		ldi      1
		ret     
		jmp      code_0748
code_07aa:
		pushi    3
		pushi    4
		lea      @temp34
		push    
		pushi    990
		pushi    2
		lea      @temp1
		push    
		callk    Format,  8
		push    
		pushi    33
		pushi    0
		calle    proc255_0,  6
		jmp      code_0748
		ret     
	)
)

(procedure (localproc_049c)
	(return
		(cond 
			((== self Restore) 0)
			((localproc_07c9) 1)
			(local2 2)
			(else 3)
		)
	)
)

(procedure (localproc_07c9)
	(if (< local2 20) (CheckFreeSpace global30))
)

(procedure (localproc_07d8)
	(proc255_0 990 3 33 0)
)

(class SysWindow of Obj
	(properties
		top 0
		left 0
		bottom 0
		right 0
		color 0
		back 15
		priority -1
		window 0
		type 0
		title 0
		brTop 0
		brLeft 0
		brBottom 190
		brRight 320
	)
	
	(method (dispose)
		(if window (DisposeWindow window) (= window 0))
		(super dispose:)
	)
	
	(method (open)
		(= window
			(NewWindow
				top
				left
				bottom
				right
				title
				type
				priority
				color
				back
			)
		)
	)
)

(class SRDialog of Dialog
	(properties
		elements 0
		size 0
		text 0
		window 0
		theItem 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		time 0
		busy 0
		seconds 0
		lastSeconds 0
	)
	
	(method (init param1 param2 param3)
		(= window SysWindow)
		(= nsBottom 0)
		(if
			(==
				(= local2 (GetSaveFiles (gGame name?) param2 param3))
				-1
			)
			(return 0)
		)
		(if (== (= local4 (localproc_049c)) 1)
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
;		(= local1 (+ (selectorI nsRight?) 4))
;		(okI
;			text: [local5 local4]
;			setSize:
;			moveTo: local1 (selectorI nsTop?)
;			state: (if (== local4 3) 0 else 3)
;		)
;		(cancelI
;			setSize:
;			moveTo: local1 (+ (okI nsBottom?) 4)
;			state: (& (cancelI state?) $fff7)
;		)
;		(changeDirI
;			setSize:
;			moveTo: local1 (+ (cancelI nsBottom?) 4)
;			state: (& (changeDirI state?) $fff7)
;		)

		;Z I've changed it, to relocate the button to the left of the games list
		(okI
			text: [local5 local4]
			setSize:
			moveTo: 4 (+ nsBottom 4)
			state: (if (== local4 3) 0 else 3)
		)
		(cancelI
			setSize:
			moveTo: 4 (+ (okI nsBottom?) 4)
			state: (& (cancelI state?) $fff7)
		)
		(changeDirI
			setSize:
			moveTo: 4 (+ (cancelI nsBottom?) 4)
			state: (& (changeDirI state?) $fff7)
		)

		(selectorI
			text: param2
			font: global23
			setSize:
			moveTo: (+ (okI nsRight?) 4) (okI nsTop?)
			state: 2
		)
		
		;Z move the edit line to be right aligned
		(editI move: (+ (okI nsRight?) 4) 0)

		;Z original: (self add: selectorI okI cancelI changeDirI setSize:)
		(self add: selectorI okI cancelI setSize:) ;Z removed changeDir, as it is useless and ugly
		
		(textI
			text: [local9 local4]
			setSize: (- (- nsRight nsLeft) 8)
			moveTo: 4 4
		)
		(= local1 (+ (textI nsBottom?) 4))
		(self eachElementDo: 145 0 local1)
		(self add: textI setSize: center: open: 4 15)
		(return 1)
	)
	
	(method (doit param1 &tmp temp0 temp1 temp2 temp3 [temp4 361] [temp365 21] [temp386 40])
		(asm
			pushSelf
			lofsa    Restore
			eq?     
			bnt      code_026d
			lap      argc
			bnt      code_026d
			lap      param1
			bnt      code_026d
			pushi    1
			pushi    4
			lea      @temp386
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
			callk    FOpen,  2
			sat      temp1
			push    
			ldi      65535
			eq?     
			bnt      code_0267
			ret     
code_0267:
			pushi    1
			lst      temp1
			callk    FClose,  2
code_026d:
			pushi    #init
			pushi    3
			lsp      param1
			lea      @temp4
			push    
			lea      @temp365
			push    
			self     10
			not     
			bnt      code_0286
			ldi      65535
			ret     
code_0286:
			lsl      local4
			dup     
			ldi      0
			eq?     
			bnt      code_02a0
			lal      local2
			bnt      code_02bd
			lofsa    okI
			jmp      code_02bd
			lofsa    changeDirI
			jmp      code_02bd
code_02a0:
			dup     
			ldi      1
			eq?     
			bnt      code_02ad
			lofsa    editI
			jmp      code_02bd
code_02ad:
			dup     
			ldi      2
			eq?     
			bnt      code_02ba
			lofsa    okI
			jmp      code_02bd
code_02ba:
			lofsa    changeDirI
code_02bd:
			toss    
			sal      local0
			pushi    #doit
			pushi    1
			push    
			super    Dialog,  6
			sal      local1
			pushi    #indexOf
			pushi    1
			pushi    #cursor
			pushi    0
			lofsa    selectorI
			send     4
			push    
			lofsa    selectorI
			send     6
			sal      local3
			push    
			ldi      18
			mul     
			sat      temp3
			lsl      local1
			lofsa    changeDirI
			eq?     
			bnt      code_0384
			pushi    1
			lsg      global30
			call     proc990_0,  2
			bnt      code_0286
			pushi    3
			pushi    #name
			pushi    0
			lag      gGame
			send     4
			push    
			lea      @temp4
			push    
			lea      @temp365
			push    
			callk    GetSaveFiles,  6
			sal      local2
			push    
			ldi      65535
			eq?     
			bnt      code_031c
			ldi      65535
			sat      temp2
			jmp      code_0494
code_031c:
			lal      local4
			sat      temp0
			pushi    0
			call     localproc_049c,  0
			sal      local4
			push    
			dup     
			ldi      0
			eq?     
			bnt      code_0332
			jmp      code_0378
code_0332:
			dup     
			lat      temp0
			eq?     
			bnt      code_0363
			pushi    #contains
			pushi    1
			lofsa    editI
			push    
			self     6
			bnt      code_0378
			pushi    #cursor
			pushi    1
			pushi    1
			pushi    2
			lsp      param1
			lea      @temp4
			push    
			callk    StrCpy,  4
			push    
			callk    StrLen,  2
			push    
			pushi    83
			pushi    0
			lofsa    editI
			send     10
			jmp      code_0378
code_0363:
			pushi    #dispose
			pushi    0
			pushi    90
			pushi    3
			lsp      param1
			lea      @temp4
			push    
			lea      @temp365
			push    
			self     14
code_0378:
			toss    
			pushi    #draw
			pushi    0
			lofsa    selectorI
			send     4
			jmp      code_0286
code_0384:
			lsl      local4
			ldi      2
			eq?     
			bnt      code_03ba
			lsl      local1
			lofsa    okI
			eq?     
			bnt      code_03ba
			pushi    #doit
			pushi    1
			pushi    2
			lsp      param1
			lat      temp3
			leai     @temp4
			push    
			callk    StrCpy,  4
			push    
			lofsa    GetReplaceName
			send     6
			bnt      code_0286
			lal      local3
			lati     temp365
			sat      temp2
			jmp      code_0494
			jmp      code_0286
code_03ba:
			lsl      local4
			ldi      1
			eq?     
			bnt      code_043b
			lsl      local1
			lofsa    okI
			eq?     
			bt       code_03d4
			lsl      local1
			lofsa    editI
			eq?     
			bnt      code_043b
code_03d4:
			pushi    1
			lsp      param1
			callk    StrLen,  2
			push    
			ldi      0
			eq?     
			bnt      code_03e9
			pushi    0
			call     localproc_07d8,  0
			jmp      code_0286
code_03e9:
			ldi      65535
			sat      temp2
			ldi      0
			sal      local1
code_03f1:
			lsl      local1
			lal      local2
			lt?     
			bnt      code_0413
			pushi    2
			lsp      param1
			lsl      local1
			ldi      18
			mul     
			leai     @temp4
			push    
			callk    StrCmp,  4
			sat      temp2
			not     
			bnt      code_040e
code_040e:
			+al      local1
			jmp      code_03f1
code_0413:
			lat      temp2
			not     
			bnt      code_0421
			lal      local1
			lati     temp365
			jmp      code_0433
code_0421:
			lsl      local2
			ldi      20
			eq?     
			bnt      code_0431
			lal      local3
			lati     temp365
			jmp      code_0433
code_0431:
			lal      local2
code_0433:
			sat      temp2
			jmp      code_0494
			jmp      code_0286
code_043b:
			lsl      local1
			lofsa    okI
			eq?     
			bnt      code_0451
			lal      local3
			lati     temp365
			sat      temp2
			jmp      code_0494
			jmp      code_0286
code_0451:
			lsl      local1
			ldi      0
			eq?     
			bt       code_0462
			lsl      local1
			lofsa    cancelI
			eq?     
			bnt      code_046c
code_0462:
			ldi      65535
			sat      temp2
			jmp      code_0494
			jmp      code_0286
code_046c:
			lsl      local4
			ldi      1
			eq?     
			bnt      code_0286
			pushi    #cursor
			pushi    1
			pushi    1
			pushi    2
			lsp      param1
			lat      temp3
			leai     @temp4
			push    
			callk    StrCpy,  4
			push    
			callk    StrLen,  2
			push    
			pushi    83
			pushi    0
			lofsa    editI
			send     10
			jmp      code_0286
code_0494:
			pushi    #dispose
			pushi    0
			self     4
			lat      temp2
			ret     
		)
	)
)

(class Restore of SRDialog
	(properties
		elements 0
		size 0
		text {טען משחק}
		window 0
		theItem 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		time 0
		busy 0
		seconds 0
		lastSeconds 0
	)
)

(class Save of SRDialog
	(properties
		elements 0
		size 0
		text {שמור משחק}
		window 0
		theItem 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		time 0
		busy 0
		seconds 0
		lastSeconds 0
	)
)

(instance GetReplaceName of Dialog
	(properties)
	
	(method (doit param1 &tmp temp0)
		(= window SysWindow)
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
			;Z original: moveTo: (- nsRight (+ (button2 nsRight?) 4)) nsBottom
			moveTo: 4 nsBottom
		)
		(button1
			;Z original: moveTo: (- (button2 nsLeft?) (+ (button1 nsRight?) 4)) nsBottom
			moveTo: (+ 4 (button2 nsRight?)) nsBottom
		)
		(self add: button1 button2 setSize: center: open: 0 15)
		
				
		(= temp0 (super doit: newName))
		(self dispose:)
		(if (not (StrLen param1))
			(localproc_07d8)
			(= temp0 0)
		)
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
)

(instance cancelI of DButton
	(properties
		text {בטל}
	)
)

(instance changeDirI of DButton
	(properties
		text {החלף\0D\nתיקייה} ;{Change\0D\nDirectory}
	)
)

(instance textI of DText
	(properties
		font 0
	)
)

(instance text1 of DText
	(properties
		text {החלף}
		font 0
	)
)

(instance text2 of DText
	(properties
		text {עם:}
		font 0
	)
)

(instance oldName of DText
	(properties)
)

(instance newName of DEdit
	(properties
		max 35
	)
)

(instance button1 of DButton
	(properties
		text {החלף}
	)
)

(instance button2 of DButton
	(properties
		text {בטל}
	)
)
