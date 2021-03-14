;;; Sierra Script 1.0 - (do not remove this comment)
(script# 814)
(include sci.sh)
(use Main)
(use n104)
(use n105)
(use n106)
(use Print)
(use PolyPath)
(use StopWalk)
(use InvI)
(use User)
(use Obj)

(public
	proc814_0 0
	proc814_1 1
	proc814_2 2
	proc814_3 3
	proc814_5 5
	proc814_6 6
	proc814_7 7
	proc814_8 8
	proc814_9 9
	proc814_10 10
	proc814_11 11
	proc814_12 12
	proc814_13 13
	proc814_14 14
	proc814_15 15
	proc814_16 16
	proc814_17 17
	proc814_18 18
	proc814_19 19
	proc814_20 20
	proc814_21 21
	proc814_22 22
	proc814_23 23
	proc814_24 24
	proc814_25 25
	proc814_26 26
	proc814_27 27
	proc814_28 28
	proc814_29 29
	proc814_30 30
	proc814_31 31
	proc814_32 32
	proc814_33 33
)

(local
	local0
)
(procedure (proc814_0 param1 param2 param3 param4 param5 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 [temp8 120] [temp128 50] [temp178 4] [temp182 4])
	(asm
		lap      argc
		bnt      code_005a
		lap      param1
		bnt      code_005a
		lap      param1
		jmp      code_005c
code_005a:
		ldi      82
code_005c:
		sat      temp0
		lsp      argc
		ldi      1
		gt?     
		bnt      code_006d
		lap      param2
		bnt      code_006d
		lap      param2
		jmp      code_006f
code_006d:
		ldi      83
code_006f:
		sat      temp1
		pushi    2
		pushi    0
		pushi    2
		callk    Random,  4
		sat      temp2
		ldi      0
		sat      temp3
		ldi      800
		sat      temp4
		lsp      argc
		ldi      3
		ge?     
		bnt      code_00a3
		lap      param3
		sat      temp2
		lsp      argc
		ldi      4
		ge?     
		bnt      code_00a3
		lap      param4
		sat      temp3
		lsp      argc
		ldi      5
		ge?     
		bnt      code_00a3
		lap      param5
		sat      temp4
code_00a3:
		pushi    0
		callb    proc0_2,  0
		pushi    1
		pushi    100
		callk    Wait,  2
		pushi    #setCursor
		pushi    2
		lsg      global20
		pushi    1
		lag      gGame
		send     8
		pushi    #eachElementDo
		pushi    1
		pushi    167
		lag      gSounds
		send     6
		lag      global275
		bnt      code_00dd
		pushi    #number
		pushi    1
		push    
		pushi    60
		pushi    1
		pushi    15
		pushi    3
		pushi    2
		pushi    1
		pushi    110
		pushi    39
		pushi    0
		lag      gLongSong
		send     24
code_00dd:
		pushi    3
		lst      temp4
		lst      temp3
		lst      temp2
		callk    CelWide,  6
		push    
		ldi      10
		add     
		sat      temp6
		pushi    7
		pushi    0
		pushi    815
		pushi    1
		pushi    0
		lst      temp1
		pushi    1
		lea      @temp128
		push    
		callk    Message,  14
		pushi    4
		lea      @temp182
		push    
		lea      @temp128
		push    
		pushi    123
		pushi    260
		callk    TextSize,  8
		pushi    7
		pushi    0
		pushi    815
		pushi    1
		pushi    0
		lst      temp0
		pushi    1
		lea      @temp8
		push    
		callk    Message,  14
		pushi    4
		lea      @temp178
		push    
		lea      @temp8
		push    
		lsg      gFont
		pushi    260
		lat      temp6
		sub     
		push    
		callk    TextSize,  8
		ldi      2
		lsti     temp182
		ldi      0
		lati     temp182
		sub     
		push    
		ldi      10
		add     
		sat      temp5
		pushi    2
		ldi      2
		lsti     temp178
		ldi      0
		lati     temp178
		sub     
		push    
		ldi      10
		add     
		push    
		pushi    3
		lst      temp4
		lst      temp3
		lst      temp2
		callk    CelHigh,  6
		push    
		calle    proc999_3,  4
		push    
		lst      temp5
		ldi      10
		add     
		add     
		sat      temp7
code_0173:
		pushi    67
		pushi    #x
		pushi    260
		pushi    30
		pushi    1
		pushi    123
		pushi    198
		pushi    3
		lea      @temp128
		push    
		pushi    0
		pushi    0
		pushi    30
		pushi    1
		lsg      gFont
		pushi    27
		pushi    1
		pushi    1
		pushi    206
		pushi    5
		lst      temp4
		lst      temp3
		lst      temp2
		pushi    0
		lst      temp5
		pushi    67
		pushi    1
		pushi    260
		lat      temp6
		sub     
		push    
		pushi    198
		pushi    3
		lea      @temp8
		push    
		lst      temp6
		lst      temp5
		pushi    205
		pushi    4
		pushi    1
		lofsa    {שחזור}
		push    
		pushi    0
		lst      temp7
		pushi    205
		pushi    4
		pushi    2
		lofsa    {אתחול}
		push    
		pushi    70
		lst      temp7
		pushi    205
		pushi    4
		pushi    3
		lofsa    {____יציאה____}
		push    
		pushi    140
		lst      temp7
		pushi    110
		pushi    0
		class    Print
		send     104
		push    
		dup     
		ldi      1
		eq?     
		bnt      code_01f9
		pushi    #restore
		pushi    0
		lag      gGame
		send     4
		jmp      code_0214
code_01f9:
		dup     
		ldi      2
		eq?     
		bnt      code_0208
		pushi    #restart
		pushi    0
		lag      gGame
		send     4
		jmp      code_0214
code_0208:
		dup     
		ldi      3
		eq?     
		bnt      code_0214
		ldi      1
		sag      global4
		jmp      code_0218
code_0214:
		toss    
		jmp      code_0173
code_0218:
		ret     
	)
)

;Z that's the original:
;(procedure (proc814_1 &tmp temp0 [temp1 20] [temp21 30])
;	(= temp0 global118)
;	(Format
;		@temp1
;		(switch global119
;			(0 {Day is dawning})
;			(1 {It is mid-morning})
;			(2 {It is midday})
;			(3 {It is mid-afternoon})
;			(4 {Sunset approaches})
;			(5 {The night is still young})
;			(6
;				{It is the middle of the night}
;			)
;			(7 {It is not yet dawn})
;		)
;	)
;	(if (or (!= global119 6) (> global116 500))
;		(++ temp0)
;	)
;	(Print
;		font: gFont
;		addTextF: @temp21 {%s on day %d.} @temp1 temp0
;		init:
;	)
;)


;Z modified - see orig above
(procedure (proc814_1 &tmp temp0 [temp1 20] [temp21 30])
	(= temp0 global118)
	(if (or (!= global119 6) (> global116 500))
		(++ temp0)
	)
	(Format
		@temp1
		(switch global119
			(0 {יום %d, החמה זה עתה הפציעה.})
			(1 {יום %d, הבוקר עוד בעיצומו.})
			(2 {חצות יום %d.})
			(3 {אחר הצהריים, יום %d.})
			(4 {יום %d, צללי ערב מתחילים לנטות.})
			(5 {יום %d, הערב עוד צעיר.})
			(6 {חצות ליל יום %d.})
			(7 {יום %d, אפלולית הלילה נמוגה לאיטה.})
		)
		temp0
	)
	(Print
		font: gFont
		addTextF: @temp21 {%s} @temp1 temp0
		init:
	)
)

(procedure (proc814_2 param1 param2 &tmp temp0)
	(if (and param2 (not (User canControl:)))
		(gQg1Messager say: 1 0 0 4 0 814)
		(return)
	)
	(if (!= param1 -1) (= global100 param1))
	(switch global100
		(1
			(gEgo view: 5 setStep: 8 4 setCycle: StopWalk 4)
			((gMainIconBar at: 1) loop: 6 cursor: 937)
		)
		(2
			(gEgo view: 6 setStep: 3 2 setCycle: StopWalk 8)
			((gMainIconBar at: 1) loop: 8 cursor: 947)
		)
		(else 
			(gEgo
				view: 0
				setStep: 3 2
				cycleSpeed: (gEgo moveSpeed?)
				setCycle: StopWalk 4
			)
			((gMainIconBar at: 1) loop: 0 cursor: 940)
		)
	)
	(if
		(and
			(IsObject (gEgo mover?))
			((gEgo mover?) isKindOf: PolyPath)
		)
		(gEgo
			setMotion: PolyPath ((gEgo mover?) finalX?) ((gEgo mover?) finalY?)
		)
	)
)

(procedure (proc814_3 param1 param2 param3 &tmp temp0 temp1 temp2)
	(= temp0
		(switch global100
			(1 5)
			(2 6)
			(else  0)
		))
	(= temp1 (if (== global100 2) 8 else 4))
	(proc814_2 -1 0)
	(if (not (User controls?)) (gGame setCursor: global21))
	(if argc
		(gEgo loop: param1)
		(if (> argc 1)
			(= temp0 param2)
			(if (> argc 2) (= temp1 param3))
		)
	)
	(= temp2
		(switch (gEgo loop?)
			(3 0)
			(6 45)
			(0 90)
			(4 135)
			(2 180)
			(5 225)
			(1 270)
			(7 315)
		)
	)
	(gEgo
		setPri: -1
		view: temp0
		setLoop: -1
		setLoop: (ScriptID 0 1)
		setCycle: StopWalk temp1
		illegalBits: -32768
		ignoreHorizon:
		ignoreActors: 0
		heading: temp2
	)
)

(procedure (proc814_5)
	(gQg1Messager say: 1 0 0 5 0 814)
)

(procedure (proc814_6)
	(gQg1Messager say: 1 0 0 6 0 814)
)

(procedure (proc814_7)
	(gQg1Messager say: 1 0 0 7 0 814)
)

(procedure (proc814_8)
	(Animate (gNewCast elements?) 0)
)

(procedure (proc814_9 param1)
	(return (> (MemoryInfo 0) param1))
)

(procedure (proc814_10 param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3)
	(= temp3 0)
	(if (IsObject param2)
		(= temp1 (param2 x?))
		(= temp2 (param2 y?))
		(if (== argc 3) (= temp3 param3))
	else
		(= temp1 param2)
		(= temp2 param3)
		(if (== argc 4) (= temp3 param4))
	)
	(= temp0
		(GetAngle (param1 x?) (param1 y?) temp1 temp2)
	)
	(cond 
		((> (Abs (- temp0 (gEgo heading?))) 23)
			(param1
				setHeading: temp0 (if (IsObject temp3) temp3 else 0)
			)
		)
		((IsObject temp3) (temp3 cue:))
	)
)

(procedure (proc814_11 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(= temp0 param1)
	(= temp1 1)
	(= temp3 ((gDropInv at: 0) amount?))
	(= temp4 (/ ((gDropInv at: 0) amount?) 10))
	(= temp2 (* ((gDropInv at: 38) amount?) 10))
	(= temp5 (not (mod temp0 10)))
	(cond 
		((< (+ temp2 temp3) temp0) (= temp1 0))
		((== (+ temp2 temp3) temp0)
			((gDropInv at: 0) amount: 0)
			((gDropInv at: 38) amount: 0)
		)
		((> temp3 temp0)
			((gDropInv at: 0)
				amount: (- ((gDropInv at: 0) amount?) temp0)
			)
		)
		(temp4
			((gDropInv at: 0)
				amount: (- ((gDropInv at: 0) amount?) (* temp4 10))
			)
			(= temp0 (- temp0 (* temp4 10)))
			((gDropInv at: 38)
				amount:
					(-
						((gDropInv at: 38) amount?)
						(+ (/ temp0 10) (if temp5 0 else 1))
					)
			)
			(if (not temp5)
				((gDropInv at: 0)
					amount: (+ ((gDropInv at: 0) amount?) (- 10 (mod temp0 10)))
				)
			)
		)
		(else
			((gDropInv at: 38)
				amount:
					(-
						((gDropInv at: 38) amount?)
						(+ (/ temp0 10) (if temp5 0 else 1))
					)
			)
			(if (not temp5)
				((gDropInv at: 0)
					amount: (+ ((gDropInv at: 0) amount?) (- 10 (mod temp0 10)))
				)
			)
		)
	)
	(return temp1)
)

(procedure (proc814_12 param1 param2 &tmp temp0 temp1 temp2)
	(= temp1 (^ global116 $0001))
	(if (>= argc 1)
		(= global116 (* 150 param1))
		(= global121 (GetTime 1))
		(if (>= argc 2)
			(= global116 (+ global116 (/ (* 150 param2) 60)))
		)
	)
	(= global116 (^ global116 $0001))
	(= temp0 global119)
	(cond 
		((< global116 300) (= global119 6))
		((< global116 750) (= global119 7))
		((< global116 1200) (= global119 0))
		((< global116 1650) (= global119 1))
		((< global116 2100) (= global119 2))
		((< global116 2550) (= global119 3))
		((< global116 3000) (= global119 4))
		((< global116 3450) (= global119 5))
		(else (= global119 6))
	)
	(if (> global119 4)
		(= global117 1)
		(proc0_6 217)
		(PalVary pvINIT (global2 picture?) 1)
		(if global451 (PalVary pvCHANGE_TARGET global451))
	else
		(= global117 0)
		(PalVary pvREVERSE 1)
	)
)

(procedure (proc814_13)
	(++ global118)
	(proc0_6 217)
)

(procedure (proc814_14)
	(return (+ 1 (/ (Random 0 999) 10)))
)

(procedure (proc814_15 param1 param2 param3 &tmp theGStrength temp1 temp2 temp3)
	(if (not (= theGStrength [gStrength param1]))
		(return 0)
	)
	(if (== argc 3)
		(= theGStrength (+ theGStrength param3))
	)
	(if param2
		(if (>= param1 5) (proc814_17 (/ param2 10)))
	else
		(if (>= param1 5) (proc814_17 (Random 1 6)))
		(= param2 (proc814_14))
	)
	(if (>= (localproc_0e56 4 1) (Random 1 200))
		(= theGStrength (+ theGStrength (Random 1 20)))
	)
	(= temp3 (<= param2 theGStrength))
	(= temp1
		(cond 
			(
			(<= (= temp1 (Abs (- param2 theGStrength))) 10) 2)
			((<= temp1 30) 4)
			((<= temp1 50) 6)
			(else (return temp3))
		)
	)
	(= temp2
		(cond 
			((== param1 5) (/ (+ (localproc_0e56 2 2) (localproc_0e56 0 2)) 16))
			(
			(or (== param1 6) (== param1 7) (== param1 8)) (/ (+ (localproc_0e56 2 3) (localproc_0e56 1 1)) 8))
			((== param1 9) (/ (+ (localproc_0e56 2 3) (localproc_0e56 1 1)) 4))
			((or (== param1 10) (== param1 11)) (/ (+ (localproc_0e56 2 3) (localproc_0e56 0 2)) 5))
			((>= param1 17) (/ (+ (localproc_0e56 12 4) (localproc_0e56 1 2)) 6))
			(else 10)
		)
	)
	(proc814_16 param1 (/ temp2 temp1))
	(return temp3)
)

(procedure (proc814_16 param1 theGStrength)
	(if (not [gStrength param1]) (return 0))
	(if
		(>
			(= theGStrength (Abs theGStrength))
			[gStrength param1]
		)
		(= theGStrength [gStrength param1])
	)
	(= [gStrength 13] (+ [gStrength 13] (/ theGStrength 4)))
	(if
		(>=
			[global150 param1]
			[gStrength (= [global150 param1]
				(+ [global150 param1] theGStrength)
			)]
		)
		(= [global150 param1]
			(- [global150 param1] [gStrength param1])
		)
		(if
			(>
				(= [gStrength param1]
					(+ [gStrength param1] (Random 1 3))
				)
				100
			)
			(= [gStrength param1] 100)
		)
		(return 1)
	)
	(return 0)
)

(procedure (proc814_17 param1 &tmp temp0)
	(if (> param1 0) (proc814_16 3 (/ (+ param1 3) 4)))
	(cond 
		(
			(<
				(= temp0 (= [gStrength 15] (- [gStrength 15] param1)))
				0
			)
			(proc814_19 (/ (- -3 [gStrength 15]) 4))
			(= [gStrength 15] 0)
			(if (not gNewEventHandler)
				(cond 
					((not (proc0_7 110))
						(proc0_5 110)
						(Wait 10)
						(gQg1Messager say: 1 0 0 10 0 814)
					)
					((<= [gStrength 14] 0) (proc814_0 64 65))
				)
			)
		)
		((> temp0 4)
			(proc0_6 110)
			(if (> temp0 (proc814_20))
				(= [gStrength 15] (proc814_20))
			)
		)
	)
)

(procedure (proc814_18 param1)
	(if [gStrength 12]
		(if
		(< (= [gStrength 16] (- [gStrength 16] param1)) 0)
			(= [gStrength 16] 0)
		)
		(if (> [gStrength 16] (proc814_22))
			(= [gStrength 16] (proc814_22))
		)
		(if (> param1 0)
			(proc814_16 1 (/ param1 5))
			(proc814_16 12 (/ param1 2))
		)
	)
)

(procedure (proc814_19 param1)
	(if (> param1 0) (proc814_16 3 (/ (+ param1 1) 2)))
	(if
	(< (= [gStrength 14] (- [gStrength 14] param1)) 0)
		(= [gStrength 14] 0)
	)
	(if (> [gStrength 14] (proc814_21))
		(= [gStrength 14] (proc814_21))
	)
	(return (> [gStrength 14] 0))
)

(procedure (proc814_20)
	(return (* (+ [gStrength 2] [gStrength 3]) 2))
)

(procedure (proc814_21 &tmp temp0)
	(return
		(+
			(= temp0
				(/ (+ [gStrength 0] [gStrength 3] [gStrength 3]) 3)
			)
			temp0
		)
	)
)

(procedure (proc814_22 &tmp theGStrength)
	(return
		(if (= theGStrength [gStrength 12])
			(return (/ (+ [gStrength 1] theGStrength theGStrength) 3))
		else
			(return 0)
		)
	)
)

(procedure (proc814_23)
	(return (+ 40 (/ [gStrength 0] 2)))
)

(procedure (proc814_24 param1 &tmp temp0)
	(if
	(< [gStrength 16] [global176 (+ (- param1 17) 1)])
		(gQg1Messager say: 1 0 0 11 0 814)
		(Wait 30)
		(= temp0 0)
	else
		(proc814_15 param1 0)
		(proc814_18 [global176 (+ (- param1 17) 1)])
		(= temp0 1)
	)
	(return temp0)
)

(procedure (proc814_25 param1)
	(return param1)
)

(procedure (proc814_26 param1 param2 param3)
	(if (and (>= argc 3) (!= gCel param3)) (return))
	(if (not (proc0_7 param1))
		(proc0_5 param1)
		(= global15 (+ global15 param2))
		((ScriptID 0 9) doit: gModNum)
		(proc814_16 1 param2)
	)
)

(procedure (proc814_27)
	(cond 
		(global199 (-- global199))
		(((gDropInv at: 1) amount?)
			(if
				(not
					((gDropInv at: 1)
						amount: (- ((gDropInv at: 1) amount?) 1)
					)
				)
				(gQg1Messager say: 1 0 0 12 0 814)
			)
		)
		((proc0_7 124)
			(proc0_5 125)
			(gQg1Messager say: 1 0 0 13 0 814)
			(proc814_19 1)
		)
		(else (proc0_5 124) (gQg1Messager say: 1 0 0 14 0 814))
	)
)

(procedure (proc814_28 &tmp temp0 temp1)
	(= temp1 0)
	(= temp0 0)
	(while (< temp1 40)
		(= temp0
			(+
				temp0
				(*
					(((ScriptID 206 0) at: temp1) amount?)
					(((ScriptID 206 0) at: temp1) weight?)
				)
			)
		)
		(++ temp1)
	)
	(= temp0 (/ (+ temp0 59) 60))
)

(procedure (proc814_29)
	(if [gStrength 9]
		(if (gEgo has: 7) else (gEgo has: 8))
	)
)

(procedure (proc814_30)
	(if (not gGMainIconBarCurIcon)
		(= gGMainIconBarCurIcon (gMainIconBar curIcon?))
	)
)

(procedure (proc814_31)
	(if gGMainIconBarCurIcon
		(gMainIconBar curIcon: gGMainIconBarCurIcon)
		(gGame setCursor: ((gMainIconBar curIcon?) cursor?))
		(= gGMainIconBarCurIcon 0)
		(if
			(and
				(== (gMainIconBar curIcon?) (gMainIconBar at: 7))
				(not (gMainIconBar curInvIcon?))
			)
			(gMainIconBar advanceCurIcon:)
		)
	)
)

(procedure (proc814_32 param1 &tmp temp0)
	(if (>= argc 2)
		(= temp0 (Inv at: param1))
		(gMainIconBar
			select: (gMainIconBar at: 7)
			curInvIcon: temp0
		)
	else
		(= temp0 (gMainIconBar at: param1))
		(gMainIconBar select: temp0)
	)
	(gGame setCursor: (temp0 cursor?) 1)
)

(procedure (proc814_33 param1)
	(return
		(switch param1
			(81 (return 0))
			(51 (proc105_0))
			(50
				(gQg1Messager say: 1 0 0 15 0 814)
			)
			(77
				(gQg1Messager say: 1 0 0 16 0 814)
			)
			(78 (proc106_0))
			(80 (proc104_0))
			(82
				(gQg1Messager say: 1 0 0 17 0 814)
			)
			(79
				(if (or (gEgo has: 2) (gEgo has: 6))
					(= global229 (+ 5 (/ [gStrength 21] 10)))
					(gQg1Messager say: 1 0 0 18 0 814)
				else
					(gQg1Messager say: 1 0 0 19 0 814)
				)
			)
			(else 
				(gQg1Messager say: 1 0 0 20 0 814)
			)
		)
	)
)

(procedure (localproc_0e56 param1 param2)
	(proc814_16 param1 param2)
	(return (* [gStrength param1] param2))
)
