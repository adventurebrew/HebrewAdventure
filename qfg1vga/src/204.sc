;;; Sierra Script 1.0 - (do not remove this comment)
;;; scc 0.1.0 (qfg1vga) - decompiled from 204.scr, 204.hep on 2026-08-04
;;; Verified: recompiling this file reproduces the original bytes,
;;; exactly. Edits are safe to recompile; the guarantee is the round
;;; trip, not the formatting.
;;; All 8 functions recovered as Sierra Script.
(script# 204)
(include scc.sh)

(public
	theCharSheet 0
)

(local
	local0 = 10000
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
)

(procedure (localproc_0 param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
	(if (!= [global125 param3] [global201 param3])
		(= temp0 54)
		(= temp1 57)
	else
		(= temp0 91)
		(= temp1 (if (< param1 190) 215 else 192 ))
	)
	(if (not param4)
		(Format @temp3 "%d" [global125 param3])
	else
		(Format @temp3 &rest)
	)
	(= temp2 (if param4 60 else 22 ))
	(Display @temp3 dsCOORD param1 param2 dsALIGN 0 dsFONT 123 dsCOLOR temp1 dsWIDTH temp2)
	(Display @temp3 dsCOORD (- param1 1) param2 dsALIGN 0 dsFONT 123 dsCOLOR temp0 dsWIDTH temp2)
)

(procedure (localproc_1)
	(global5 eachElementDo: 96 hideMe)
	(= local3 global5)
	(= local4 global32)
	(= local5 global73)
	(= local6 global72)
	(= global32 0)
	(= global5 global32)
	(= global72 global5)
	(= global73 global72)
	((= global5 newCast) add:)
	((= global32 newFeatures) add:)
	(myHero
		cel: global122
		init:
	)
	((= global73 newMH) add: myHero)
	((= global72 newKH) add: myHero)
	(DrawPic 904 100)
)

(procedure (localproc_2)
	(global5
		eachElementDo: 111
		eachElementDo: 81
		release:
		dispose:
	)
	(global32 dispose:)
	(global73 dispose:)
	(global72 dispose:)
	(DrawPic (global2 picture:) 100)
	(= global5 local3)
	(= global32 local4)
	(= global73 local5)
	(= global72 local6)
	(global10 doit:)
	(global5 eachElementDo: 96 showMe)
	(proc0_6 359)
	(proc0_6 360)
)

(instance newCast of newCast_binding
	(properties)
)

(instance newFeatures of newFeatures_binding
	(properties)
)

(instance newMH of newMH_binding
	(properties)
)

(instance newKH of newKH_binding
	(properties)
)

(instance hideMe of hideMe_binding
	(properties)

	(method (doit param1)
		(param1 z: (+ (param1 z:) 1000))
	)
)

(instance showMe of showMe_binding
	(properties)

	(method (doit param1)
		(param1 z: (- (param1 z:) 1000))
	)
)

(instance theCharSheet of theCharSheet_binding
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= local7 (Unknown_Class_51 input:))
		(= local8 (Unknown_Class_51 controls:))
		(proc0_2)
		(= local2 global34)
		(localproc_1)
		;Z Hebrew/RTL character sheet layout.
		;Z Move the character name and stat values to the mirrored positions used by the Hebrew UI.
		(Display @global428 dsCOORD 118 21 dsCOLOR 215 dsWIDTH 172 dsALIGN 0 dsFONT 123)
		(Display @global428 dsCOORD 119 21 dsCOLOR 91 dsWIDTH 170 dsALIGN 0 dsFONT 123)
		(localproc_0 210 40 0 0)
		(localproc_0 210 52 1 0)
		(localproc_0 210 64 2 0)
		(localproc_0 210 76 3 0)
		(localproc_0 210 88 4 0)
		(localproc_0 210 100 12 0)
		(localproc_0 100 40 5 0)
		(localproc_0 100 52 6 0)
		(localproc_0 100 64 7 0)
		(localproc_0 100 76 8 0)
		(localproc_0 100 88 9 0)
		(localproc_0 100 100 10 0)
		(localproc_0 100 112 11 0)
		(localproc_0 160 141 13 1 (Format @temp0 "%d" [global125 13]))
		(localproc_0 160 153 14 1 (Format @temp0 "%d / %d" (/ (+ [global125 14] 1) 2) (/ (+ (proc814_21) 1) 2)))
		(localproc_0 160 165 15 1 (Format @temp0 "%d / %d" (/ (+ [global125 15] 3) 4) (/ (+ (proc814_20) 3) 4)))
		(localproc_0 160 177 16 1 (Format @temp0 "%d / %d" [global125 16] (proc814_22)))
		;Z End Hebrew/RTL character sheet layout.
	)

	(method (dispose &tmp temp0)
		(localproc_2)
		(= global34 local2)
		(= temp0 0)
		(while (< temp0 25)
			(= [global201 temp0] [global125 temp0])
			(++ temp0)
		)
		(= global424 global15)
		(proc0_3)
		(Unknown_Class_51
			canInput: local7
			canControl: local8
		)
		(super dispose:)
		(global1 setCursor: global19 1)
		(DisposeScript 204)
	)
)

(instance myHero of myHero_binding
	(properties)

	(method (handleEvent param1)
		(param1 claimed: 1)
		(if (or (and (== (param1 type:) 4) (proc999_5 (param1 message:) 13 27)) (== (param1 type:) 1))
			(theCharSheet dispose:)
		)
	)
)
