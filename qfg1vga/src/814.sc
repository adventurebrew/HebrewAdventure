;;; Sierra Script 1.0 - (do not remove this comment)
;;; scc 0.1.0 (qfg1vga) - decompiled from 814.scr, 814.hep on 2026-08-05
;;; Verified: recompiling this file reproduces the original bytes,
;;; exactly. Edits are safe to recompile; the guarantee is the round
;;; trip, not the formatting.
;;; All 34 functions recovered as Sierra Script.
(script# 814)
(include scc.sh)

(public
	localproc_0 0
	localproc_1 1
	localproc_2 2
	localproc_3 3
	localproc_4 5
	localproc_5 6
	localproc_6 7
	localproc_7 8
	localproc_8 9
	localproc_9 10
	localproc_10 11
	localproc_11 12
	localproc_12 13
	localproc_13 14
	localproc_14 15
	localproc_15 16
	localproc_16 17
	localproc_17 18
	localproc_18 19
	localproc_19 20
	localproc_20 21
	localproc_21 22
	localproc_22 23
	localproc_23 24
	localproc_24 25
	localproc_25 26
	localproc_26 27
	localproc_27 28
	localproc_28 29
	localproc_29 30
	localproc_30 31
	localproc_31 32
	localproc_33 33
)

(local
	local0
)

(procedure (localproc_0 param1 param2 param3 param4 param5 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21 temp22 temp23 temp24 temp25 temp26 temp27 temp28 temp29 temp30 temp31 temp32 temp33 temp34 temp35 temp36 temp37 temp38 temp39 temp40 temp41 temp42 temp43 temp44 temp45 temp46 temp47 temp48 temp49 temp50 temp51 temp52 temp53 temp54 temp55 temp56 temp57 temp58 temp59 temp60 temp61 temp62 temp63 temp64 temp65 temp66 temp67 temp68 temp69 temp70 temp71 temp72 temp73 temp74 temp75 temp76 temp77 temp78 temp79 temp80 temp81 temp82 temp83 temp84 temp85 temp86 temp87 temp88 temp89 temp90 temp91 temp92 temp93 temp94 temp95 temp96 temp97 temp98 temp99 temp100 temp101 temp102 temp103 temp104 temp105 temp106 temp107 temp108 temp109 temp110 temp111 temp112 temp113 temp114 temp115 temp116 temp117 temp118 temp119 temp120 temp121 temp122 temp123 temp124 temp125 temp126 temp127 temp128 temp129 temp130 temp131 temp132 temp133 temp134 temp135 temp136 temp137 temp138 temp139 temp140 temp141 temp142 temp143 temp144 temp145 temp146 temp147 temp148 temp149 temp150 temp151 temp152 temp153 temp154 temp155 temp156 temp157 temp158 temp159 temp160 temp161 temp162 temp163 temp164 temp165 temp166 temp167 temp168 temp169 temp170 temp171 temp172 temp173 temp174 temp175 temp176 temp177 temp178 temp179 temp180 temp181 temp182 temp183 temp184 temp185)
	(= temp0 (if (and argc param1) param1 else 82 ))
	(= temp1 (if (and (> argc 1) param2) param2 else 83 ))
	(= temp2 (Random 0 2))
	(= temp3 0)
	(= temp4 800)
	(if (>= argc 3)
		(= temp2 param3)
		(if (>= argc 4)
			(= temp3 param4)
			(if (>= argc 5)
				(= temp4 param5)
			)
		)
	)
	(proc0_2)
	(Wait 100)
	(global1 setCursor: global20 1)
	(global8 eachElementDo: 167)
	(if global275
		(global106
			number: global275
			priority: 15
			loop: 1 110
			play:
		)
	)
	(= temp6 (+ (CelWide temp4 temp3 temp2) 10))
	(Message msgGET 815 1 0 temp1 1 @temp128)
	(TextSize @temp182 @temp128 123 260)
	(Message msgGET 815 1 0 temp0 1 @temp8)
	(TextSize @temp178 @temp8 global22 (- 260 temp6))
	(= temp5 (+ (- [temp182 2] [temp182 0]) 10))
	(= temp7 (+ (proc999_3 (+ (- [temp178 2] [temp178 0]) 10) (CelHigh temp4 temp3 temp2)) (+ temp5 10)))
	(repeat
		;Z Hebrew restart/restore/quit buttons, mirrored horizontally.
		(switch (Unknown_Class_20 width: 260 font: 123 addText: @temp128 0 0 font: global22 mode: 1 addIcon: temp4 temp3 temp2 0 temp5 width: (- 260 temp6) addText: @temp8 temp6 temp5 addButton: 1 {שחזור} 205 temp7 addButton: 2 {אתחול} 135 temp7 addButton: 3 {____יציאה____} 32 temp7 init:)
			(1
				(global1 restore:)
			)
			(2
				(global1 restart:)
			)
			(3
				(= global4 1)
				(break)
			)
		)
	)
)

(procedure (localproc_1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21 temp22 temp23 temp24 temp25 temp26 temp27 temp28 temp29 temp30 temp31 temp32 temp33 temp34 temp35 temp36 temp37 temp38 temp39 temp40 temp41 temp42 temp43 temp44 temp45 temp46 temp47 temp48 temp49 temp50)
	(= temp0 global118)
	(if (or (!= global119 6) (> global116 500))
		(++ temp0)
	)
	;Z Hebrew time-of-day text includes the day number in the main phrase.
	(Format @temp1 (switch global119 (0 {יום %d, החמה זה עתה הפציעה.} ) (1 {יום %d, הבוקר עוד בעיצומו.} ) (2 {חצות יום %d.} ) (3 {אחר הצהריים, יום %d.} ) (4 {יום %d, צללי ערב מתחילים לנטות.} ) (5 {יום %d, הערב עוד צעיר.} ) (6 {חצות ליל יום %d.} ) (7 {יום %d, אפלולית הלילה נמוגה לאיטה.} ) ) temp0)
	(Unknown_Class_20
		font: global22
		addTextF: @temp21 {%s} @temp1 temp0
		init:
	)
)

(procedure (localproc_2 param1 param2 &tmp temp0)
	(if (and param2 (not (Unknown_Class_51 canControl:)))
		(return (global91 say: 1 0 0 4 0 814))
	)
	(if (!= param1 -1)
		(= global100 param1)
	)
	(switch global100
		(1
			(global0
				view: 5
				setStep: 8 4
				setCycle: Unknown_Class_80 4
			)
			((global69 at: 1)
				loop: 6
				cursor: 937
			)
		)
		(2
			(global0
				view: 6
				setStep: 3 2
				setCycle: Unknown_Class_80 8
			)
			((global69 at: 1)
				loop: 8
				cursor: 947
			)
		)
		(else
			(global0
				view: 0
				setStep: 3 2
				cycleSpeed: (global0 moveSpeed:)
				setCycle: Unknown_Class_80 4
			)
			((global69 at: 1)
				loop: 0
				cursor: 940
			)
		)
	)
	(if (and (IsObject (global0 mover:)) ((global0 mover:) isKindOf: Unknown_Class_37))
		(global0 setMotion: Unknown_Class_37 ((global0 mover:) finalX:) ((global0 mover:) finalY:))
	)
)

(procedure (localproc_3 param1 param2 param3 &tmp temp0 temp1 temp2)
	(= temp0 (switch global100 (1 5 ) (2 6 ) (else 0 ) ))
	(= temp1 (if (== global100 2) 8 else 4 ))
	(localproc_2 -1 0)
	(if (not (Unknown_Class_51 controls:))
		(global1 setCursor: global21)
	)
	(if argc
		(global0 loop: param1)
		(if (> argc 1)
			(= temp0 param2)
			(if (> argc 2)
				(= temp1 param3)
			)
		)
	)
	(= temp2 (switch (global0 loop:) (3 0 ) (6 45 ) (0 90 ) (4 135 ) (2 180 ) (5 225 ) (1 270 ) (7 315 ) ))
	(global0
		setPri: -1
		view: temp0
		setLoop: -1
		setLoop: (ScriptID 0 1)
		setCycle: Unknown_Class_80 temp1
		illegalBits: 32768
		ignoreHorizon:
		ignoreActors: 0
		heading: temp2
	)
)

(procedure (localproc_4)
	(global91 say: 1 0 0 5 0 814)
)

(procedure (localproc_5)
	(global91 say: 1 0 0 6 0 814)
)

(procedure (localproc_6)
	(global91 say: 1 0 0 7 0 814)
)

(procedure (localproc_7)
	(Animate (global5 elements:) 0)
)

(procedure (localproc_8 param1)
	(return (> (MemoryInfo 0) param1))
)

(procedure (localproc_9 param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3)
	(= temp3 0)
	(if (IsObject param2)
		(= temp1 (param2 x:))
		(= temp2 (param2 y:))
		(if (== argc 3)
			(= temp3 param3)
		)
	else
		(= temp1 param2)
		(= temp2 param3)
		(if (== argc 4)
			(= temp3 param4)
		)
	)
	(= temp0 (GetAngle (param1 x:) (param1 y:) temp1 temp2))
	(if (> (Abs (- temp0 (global0 heading:))) 23)
		(param1 setHeading: temp0 (and (IsObject temp3) temp3))
	else
		(if (IsObject temp3)
			(temp3 cue:)
		)
	)
)

(procedure (localproc_10 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(= temp0 param1)
	(= temp1 1)
	(= temp3 ((global9 at: 0) amount:))
	(= temp4 (/ ((global9 at: 0) amount:) 10))
	(= temp2 (* ((global9 at: 38) amount:) 10))
	(= temp5 (not (mod temp0 10)))
	(if (< (+ temp2 temp3) temp0)
		(= temp1 0)
	else
		(if (== (+ temp2 temp3) temp0)
			((global9 at: 0) amount: 0)
			((global9 at: 38) amount: 0)
		else
			(if (> temp3 temp0)
				((global9 at: 0) amount: (- ((global9 at: 0) amount:) temp0))
			else
				(if temp4
					((global9 at: 0) amount: (- ((global9 at: 0) amount:) (* temp4 10)))
					(= temp0 (- temp0 (* temp4 10)))
					((global9 at: 38) amount: (- ((global9 at: 38) amount:) (+ (/ temp0 10) (if temp5 0 else 1 ))))
					(if (not temp5)
						((global9 at: 0) amount: (+ ((global9 at: 0) amount:) (- 10 (mod temp0 10))))
					)
				else
					((global9 at: 38) amount: (- ((global9 at: 38) amount:) (+ (/ temp0 10) (if temp5 0 else 1 ))))
					(if (not temp5)
						((global9 at: 0) amount: (+ ((global9 at: 0) amount:) (- 10 (mod temp0 10))))
					)
				)
			)
		)
	)
	(return temp1)
)

(procedure (localproc_11 param1 param2 &tmp temp0 temp1 temp2)
	(= temp1 (^ global116 1))
	(if (>= argc 1)
		(= global116 (* 150 param1))
		(= global121 (GetTime 1))
		(if (>= argc 2)
			(= global116 (+ global116 (/ (* 150 param2) 60)))
		)
	)
	(= global116 (^ global116 1))
	(= temp0 global119)
	(if (< global116 300)
		(= global119 6)
	else
		(if (< global116 750)
			(= global119 7)
		else
			(if (< global116 1200)
				(= global119 0)
			else
				(if (< global116 1650)
					(= global119 1)
				else
					(if (< global116 2100)
						(= global119 2)
					else
						(if (< global116 2550)
							(= global119 3)
						else
							(if (< global116 3000)
								(= global119 4)
							else
								(if (< global116 3450)
									(= global119 5)
								else
									(= global119 6)
								)
							)
						)
					)
				)
			)
		)
	)
	(if (> global119 4)
		(= global117 1)
		(proc0_6 217)
		(PalVary 0 (global2 picture:) 1)
		(if global451
			(PalVary 4 global451)
		)
	else
		(= global117 0)
		(PalVary 1 1)
	)
)

(procedure (localproc_12)
	(++ global118)
	(proc0_6 217)
)

(procedure (localproc_13)
	(return (+ 1 (/ (Random 0 999) 10)))
)

(procedure (localproc_14 param1 param2 param3 &tmp temp0 temp1 temp2 temp3)
	(= temp0 [global125 param1])
	(if (not temp0)
		(return 0)
	)
	(if (== argc 3)
		(= temp0 (+ temp0 param3))
	)
	(if param2
		(if (>= param1 5)
			(localproc_16 (/ param2 10))
		)
	else
		(if (>= param1 5)
			(localproc_16 (Random 1 6))
		)
		(= param2 (localproc_13))
	)
	(if (>= (localproc_32 4 1) (Random 1 200))
		(= temp0 (+ temp0 (Random 1 20)))
	)
	(= temp3 (<= param2 temp0))
	(= temp1 (Abs (- param2 temp0)))
	(= temp1 (if (<= temp1 10) 2 else (if (<= temp1 30) 4 else (if (<= temp1 50) 6 else (return temp3) ) ) ))
	(= temp2 (if (== param1 5) (/ (+ (localproc_32 2 2) (localproc_32 0 2)) 16) else (if (or (== param1 6) (== param1 7) (== param1 8)) (/ (+ (localproc_32 2 3) (localproc_32 1 1)) 8) else (if (== param1 9) (/ (+ (localproc_32 2 3) (localproc_32 1 1)) 4) else (if (or (== param1 10) (== param1 11)) (/ (+ (localproc_32 2 3) (localproc_32 0 2)) 5) else (if (>= param1 17) (/ (+ (localproc_32 12 4) (localproc_32 1 2)) 6) else 10 ) ) ) ) ))
	(localproc_15 param1 (/ temp2 temp1))
	(return temp3)
)

(procedure (localproc_15 param1 param2)
	(if (not [global125 param1])
		(return 0)
	)
	(= param2 (Abs param2))
	(if (> param2 [global125 param1])
		(= param2 [global125 param1])
	)
	(= [global125 13] (+ [global125 13] (/ param2 4)))
	(= [global150 param1] (+ [global150 param1] param2))
	(if (>= [global150 param1] [global125 param1])
		(= [global150 param1] (- [global150 param1] [global125 param1]))
		(if (> (= [global125 param1] (+ [global125 param1] (Random 1 3))) 100)
			(= [global125 param1] 100)
		)
		(return 1)
	)
	(return 0)
)

(procedure (localproc_16 param1 &tmp temp0)
	(if (> param1 0)
		(localproc_15 3 (/ (+ param1 3) 4))
	)
	(= temp0 (= [global125 15] (- [global125 15] param1)))
	(if (< temp0 0)
		(localproc_18 (/ (- -3 [global125 15]) 4))
		(= [global125 15] 0)
		(if (not global84)
			(if (not (proc0_7 110))
				(proc0_5 110)
				(Wait 10)
				(global91 say: 1 0 0 10 0 814)
			else
				(if (<= [global125 14] 0)
					(localproc_0 64 65)
				)
			)
		)
	else
		(if (> temp0 4)
			(proc0_6 110)
			(if (> temp0 (localproc_19))
				(= [global125 15] (localproc_19))
			)
		)
	)
)

(procedure (localproc_17 param1)
	(if [global125 12]
		(if (< (= [global125 16] (- [global125 16] param1)) 0)
			(= [global125 16] 0)
		)
		(if (> [global125 16] (localproc_21))
			(= [global125 16] (localproc_21))
		)
		(if (> param1 0)
			(localproc_15 1 (/ param1 5))
			(localproc_15 12 (/ param1 2))
		)
	)
)

(procedure (localproc_18 param1)
	(if (> param1 0)
		(localproc_15 3 (/ (+ param1 1) 2))
	)
	(if (< (= [global125 14] (- [global125 14] param1)) 0)
		(= [global125 14] 0)
	)
	(if (> [global125 14] (localproc_20))
		(= [global125 14] (localproc_20))
	)
	(return (> [global125 14] 0))
)

(procedure (localproc_19)
	(return (* (+ [global125 2] [global125 3]) 2))
)

(procedure (localproc_20 &tmp temp0)
	(= temp0 (/ (+ [global125 0] [global125 3] [global125 3]) 3))
	(return (+ temp0 temp0))
)

(procedure (localproc_21 &tmp temp0)
	(if (= temp0 [global125 12])
		(return (/ (+ [global125 1] temp0 temp0) 3))
	else
		(return 0)
	)
)

(procedure (localproc_22)
	(return (+ 40 (/ [global125 0] 2)))
)

(procedure (localproc_23 param1 &tmp temp0)
	(if (< [global125 16] [global176 (+ (- param1 17) 1)])
		(global91 say: 1 0 0 11 0 814)
		(Wait 30)
		(= temp0 0)
	else
		(localproc_14 param1 0)
		(localproc_17 [global176 (+ (- param1 17) 1)])
		(= temp0 1)
	)
	(return temp0)
)

(procedure (localproc_24 param1)
	(return param1)
)

(procedure (localproc_25 param1 param2 param3)
	(if (and (>= argc 3) (!= global122 param3))
		(return)
	)
	(if (not (proc0_7 param1))
		(proc0_5 param1)
		(= global15 (+ global15 param2))
		((ScriptID 0 9) doit: global11)
		(localproc_15 1 param2)
	)
)

(procedure (localproc_26)
	(if global199
		(-- global199)
	else
		(if ((global9 at: 1) amount:)
			(if (not ((global9 at: 1) amount: (- ((global9 at: 1) amount:) 1)))
				(global91 say: 1 0 0 12 0 814)
			)
		else
			(if (proc0_7 124)
				(proc0_5 125)
				(global91 say: 1 0 0 13 0 814)
				(localproc_18 1)
			else
				(proc0_5 124)
				(global91 say: 1 0 0 14 0 814)
			)
		)
	)
)

(procedure (localproc_27 &tmp temp0 temp1)
	(= temp1 0)
	(= temp0 0)
	(while (< temp1 40)
		(= temp0 (+ temp0 (* (((ScriptID 206 0) at: temp1) amount:) (((ScriptID 206 0) at: temp1) weight:))))
		(++ temp1)
	)
	(= temp0 (/ (+ temp0 59) 60))
)

(procedure (localproc_28)
	(if [global125 9]
		(or (global0 has: 7) (global0 has: 8))
	)
)

(procedure (localproc_29)
	(if (not global422)
		(= global422 (global69 curIcon:))
	)
)

(procedure (localproc_30)
	(if global422
		(global69 curIcon: global422)
		(global1 setCursor: ((global69 curIcon:) cursor:))
		(= global422 0)
		(if (and (== (global69 curIcon:) (global69 at: 7)) (not (global69 curInvIcon:)))
			(global69 advanceCurIcon:)
		)
	)
)

(procedure (localproc_31 param1 &tmp temp0)
	(if (>= argc 2)
		(= temp0 (Unknown_Class_66 at: param1))
		(global69
			select: (global69 at: 7)
			curInvIcon: temp0
		)
	else
		(= temp0 (global69 at: param1))
		(global69 select: temp0)
	)
	(global1 setCursor: (temp0 cursor:) 1)
)

(procedure (localproc_32 param1 param2)
	(localproc_15 param1 param2)
	(return (* [global125 param1] param2))
)

(procedure (localproc_33 param1)
	(switch param1
		(81
			(return 0)
		)
		(51
			(proc105_0)
		)
		(50
			(global91 say: 1 0 0 15 0 814)
		)
		(77
			(global91 say: 1 0 0 16 0 814)
		)
		(78
			(proc106_0)
		)
		(80
			(proc104_0)
		)
		(82
			(global91 say: 1 0 0 17 0 814)
		)
		(79
			(if (or (global0 has: 2) (global0 has: 6))
				(= global229 (+ 5 (/ [global125 21] 10)))
				(global91 say: 1 0 0 18 0 814)
			else
				(global91 say: 1 0 0 19 0 814)
			)
		)
		(else
			(global91 say: 1 0 0 20 0 814)
		)
	)
)
