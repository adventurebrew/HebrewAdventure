;;; Sierra Script 1.0 - (do not remove this comment)
(script# 601)
(include sci.sh)
(use Main)
(use Print)
(use Class_993_0)
(use Game)
(use User)
(use View)
(use Obj)

(public
	CharSave 0
)

(local
	local0 =  83
	theGCel
	local2
	local3
	local4
	local5
	[theGStrength 25]
	local31
	local32
	local33
	local34
	local35
	local36 =  121
	local37 =  134
	local38
	local39
	local40 =  67
	local41 =  136
	local42 =  173
	local43 =  240
	local44 =  206
	[local45 7]
	[local52 16]
	[local68 400]
	local468
	[local469 40]
)
(instance CharSave of Rm
	(properties
		noun 1
		picture 750
		style $0007
	)
	
	(method (init)
		(SL enable:)
		(super init: &rest)
		(gMH add: self)
		(gKH add: self)
		(self setScript: saveHero)
	)
	
	(method (dispose)
		(super dispose:)
	)
)

(instance glory1_sav of Class_993_0
	(properties
		name "glory1.sav"
	)
)

(instance saveHero of Script
	(properties)
	
	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				0
				(Format @local52 601 0)
				(if (>= global15 500)
					(gQg1Messager say: 1 0 8 1 self)
				else
					(gQg1Messager say: 1 0 4 1 self)
				)
			)
			(1
				1
				(gQg1Messager say: 1 0 5 0 self)
			)
			(2
				2
				(if
					(Print
						mode: 1
						addText: {הקובץ שבו שמרת את הגיבור שלך.}
						addEdit: @local52 30 0 30 @local52
						init:
					)
					(glory1_sav name: @local52)
					(= cycles 2)
				else
					(self changeState: 6)
				)
			)
			(3
				3
				(if (glory1_sav open: 2)
					(glory1_sav close:)
					(= seconds 2)
				else
					(self changeState: 6)
				)
			)
			(4
				4
				(if (not (glory1_sav open: 0))
					(self changeState: 6)
					(return)
				)
				(= temp0 0)
				(while (< temp0 25)
					(= [theGStrength temp0] [gStrength temp0])
					(++ temp0)
				)
				(= temp1 (/ ((gDropInv at: 0) amount?) 10))
				(= theGCel gCel)
				(= local2 (/ temp1 100))
				(= local3 (mod temp1 100))
				(= local4 global15)
				(= local5 0)
				(if (gEgo has: 2) (= local5 (| local5 $0001)))
				(if (gEgo has: 3) (= local5 (| local5 $0002)))
				(if (gEgo has: 7) (= local5 (| local5 $0004)))
				(if (gEgo has: 8) (= local5 (| local5 $0008)))
				(if (gEgo has: 20) (= local5 (| local5 $0010)))
				(if (proc0_7 325) (= local5 (| local5 $0020)))
				(if (< 255 global15) (= local5 (| local5 $0040)))
				(= local31 ((gDropInv at: 6) amount?))
				(= local32 ((gDropInv at: 12) amount?))
				(= local33 ((gDropInv at: 13) amount?))
				(= local34 ((gDropInv at: 14) amount?))
				(= local35 ((gDropInv at: 19) amount?))
				(= local38 local44)
				(= temp0 0)
				(while (< temp0 35)
					(= [local0 (+ temp0 1)] (& [local0 (+ temp0 1)] $007f))
					(= local38 (+ local38 [local0 (+ temp0 1)]))
					(= temp0 (+ temp0 2))
				)
				(= local39 0)
				(= temp0 1)
				(while (< temp0 35)
					(= [local0 (+ temp0 1)] (& [local0 (+ temp0 1)] $007f))
					(= local39 (+ local39 [local0 (+ temp0 1)]))
					(= temp0 (+ temp0 2))
				)
				(= local38 (& local38 $007f))
				(= local39 (& local39 $007f))
				(= temp0 0)
				(while (< temp0 43)
					(= [local0 (+ temp0 1)] (& [local0 (+ temp0 1)] $007f))
					(= [local0 (+ temp0 1)]
						(^ [local0 (+ temp0 1)] [local0 temp0])
					)
					(++ temp0)
				)
				(glory1_sav writeString: @global428)
				(glory1_sav writeString: {\n})
				(= temp0 1)
				(while (< temp0 44)
					(Format @local68 601 1 [local0 temp0])
					(glory1_sav writeString: @local68)
					(++ temp0)
				)
				(glory1_sav writeString: {\n})
				(glory1_sav close:)
				(= seconds 2)
			)
			(5
				5
				(gQg1Messager say: 1 0 1)
				(= local468 1)
				(= cycles 2)
			)
			(6
				6
				(switch
					(= temp3
						(Print
							mode: 1
							addText: {התאבה לנסות לשמור את דמותך בשנית?}
							addButton: 0 {לא_} 55 30
							addButton: 1 {כן_} 95 30
							init:
						)
					)
					(0
						(gQg1Messager say: 1 0 (= state 7) 1 self)
					)
					(1
						(= temp3 2)
						(= local36 121)
						(= local37 134)
						(= local40 67)
						(= local41 136)
						(= local42 173)
						(= local43 240)
						(self changeState: temp3)
					)
				)
			)
			(7
				(gQg1Messager say: 1 0 7 1 self)
			)
			(8
				(global2 drawPic: 903 10)
				(= seconds 3)
			)
			(9
				(User canControl: 1 canInput: 1)
				(global2 drawPic: 903 9)
				(animators init:)
				(= seconds 8)
			)
			(10
				(global2 drawPic: 903 9)
				(animators dispose:)
				(artists init:)
				(= seconds 8)
			)
			(11
				(global2 drawPic: 903 9)
				(artists dispose:)
				(programmers init:)
				(= seconds 8)
			)
			(12
				(global2 drawPic: 903 9)
				(programmers dispose:)
				(musicDirector init:)
				(= seconds 8)
			)
			(13
				(global2 drawPic: 903 9)
				(musicDirector dispose:)
				(developmentSys init:)
				(= seconds 8)
			)
			(14
				(global2 drawPic: 903 9)
				(developmentSys dispose:)
				(soundEffects init:)
				(= seconds 8)
			)
			(15
				(global2 drawPic: 903 9)
				(soundEffects dispose:)
				(qualityDudes init:)
				(= seconds 8)
			)
			(16
				(gGameControls window: (ScriptID 0 10) show:)
				(= ticks 10)
			)
			(17 (= global4 1))
		)
	)
	
	(method (handleEvent pEvent)
		(if
			(and
				(>= state 9)
				(or
					(== (pEvent type?) evKEYBOARD)
					(== (pEvent type?) evMOUSEBUTTON)
					(== (pEvent message?) KEY_RETURN)
				)
			)
			(pEvent claimed: 1)
			(gGameControls window: (ScriptID 0 10) show:)
		)
	)
)

(instance endStatus of Code
	(properties)
	
	(method (doit param1)
		(Format param1 601 2 global15)
	)
)

(instance animators of View
	(properties
		x 170
		y 167
		view 902
		loop 1
	)
)

(instance artists of View
	(properties
		x 161
		y 135
		view 902
		loop 2
	)
)

(instance programmers of View
	(properties
		x 158
		y 110
		view 902
		loop 3
	)
)

(instance musicDirector of View
	(properties
		x 105
		y 65
		view 902
		loop 4
	)
)

(instance developmentSys of View
	(properties
		x 85
		y 165
		view 902
		loop 5
	)
)

(instance soundEffects of View
	(properties
		x 95
		y 65
		view 902
		loop 6
	)
)

(instance qualityDudes of View
	(properties
		x 94
		y 65
		view 902
		loop 7
	)
)
