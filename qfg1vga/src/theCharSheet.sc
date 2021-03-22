;;; Sierra Script 1.0 - (do not remove this comment)
(script# 204)
(include sci.sh)
(use Main)
(use n814)
(use User)
(use View)
(use Obj)

(public
	theCharSheet 0
)

(local
	[local0 2] = [10000]
	local2
	theGNewCast
	theGNewFeatures
	theGMH
	theGKH
	userInput
	userControls
)

;(procedure (ShowSkill xPlace yPlace statNum varColor &tmp bgColor fgColor theWidth [str 6])
(procedure (localproc_002e param1 param2 param3 param4 &tmp temp0 temp1 temp2 [temp3 6])
	(if (!= [gStrength param3] [gGStrength_2 param3])
		(= temp0 54)
		(= temp1 57)
	else
		(= temp0 91)
		(= temp1 (if (< param1 190) 215 else 192))
	)
	(if (not param4)
		(Format @temp3 {%d} [gStrength param3])
	else
		(Format @temp3 &rest)
	)
	(= temp2 (if param4 60 else 22))
	(Display
		@temp3
		dsCOORD
		param1
		param2
		dsALIGN
		0
		dsFONT
		123
		dsCOLOR
		temp1
		dsWIDTH
		temp2
	)
	(Display
		@temp3
		dsCOORD
		(- param1 1)
		param2
		dsALIGN
		0
		dsFONT
		123
		dsCOLOR
		temp0
		dsWIDTH
		temp2
	)
)

(procedure (localproc_00c8)
	(gNewCast eachElementDo: #perform hideMe)
	(= theGNewCast gNewCast)
	(= theGNewFeatures gNewFeatures)
	(= theGMH gMH)
	(= theGKH gKH)
	(= gMH (= gKH (= gNewCast (= gNewFeatures 0))))
	((= gNewCast newCast) add:)
	((= gNewFeatures newFeatures) add:)
	(myHero cel: gCel init:)
	((= gMH newMH) add: myHero)
	((= gKH newKH) add: myHero)
	(DrawPic 904 dpOPEN_NO_TRANSITION)
)

(procedure (localproc_0136)
	(gNewCast
		eachElementDo: #dispose
		eachElementDo: #delete
		release:
		dispose:
	)
	(gNewFeatures dispose:)
	(gMH dispose:)
	(gKH dispose:)
	(DrawPic (global2 picture?) dpOPEN_NO_TRANSITION)
	(= gNewCast theGNewCast)
	(= gNewFeatures theGNewFeatures)
	(= gMH theGMH)
	(= gKH theGKH)
	(gOldATPs doit:)
	(gNewCast eachElementDo: #perform showMe)
	(proc0_6 359)
	(proc0_6 360)
)

(instance newCast of EventHandler
	(properties)
)

(instance newFeatures of EventHandler
	(properties)
)

(instance newMH of EventHandler
	(properties)
)

(instance newKH of EventHandler
	(properties)
)

(instance hideMe of Code
	(properties)
	
	(method (doit param1)
		(param1 z: (+ (param1 z?) 1000))
	)
)

(instance showMe of Code
	(properties)
	
	(method (doit param1)
		(param1 z: (- (param1 z?) 1000))
	)
)

(instance theCharSheet of Code
	(properties)
	
	(method (doit &tmp [temp0 8])
		(= userInput (User input?))
		(= userControls (User controls?))
		(proc0_2)
		(= local2 global34)
		(localproc_00c8)
		
		; global428 = @userName
		;Z changed X 145/144 to 145/146
		;Z changed Y 22 to 21
		;Z changed second WIDTH from 175 to 170
		;Z changed 0 (teJustLeft) to -1 (teJustRight)
		(Display
			@global428
			dsCOORD
			118
			21
			dsCOLOR
			215
			dsWIDTH
			172
			dsALIGN
			0
			dsFONT
			123
		)
		(Display
			@global428
			dsCOORD
			119
			21
			dsCOLOR
			91
			dsWIDTH
			170
			dsALIGN
			0
			dsFONT
			123
		)
		;Z 175-> 210 ; 288 -> 100 ; 200 -> 160
		(localproc_002e 210 40 0 0)
		(localproc_002e 210 52 1 0)
		(localproc_002e 210 64 2 0)
		(localproc_002e 210 76 3 0)
		(localproc_002e 210 88 4 0)
		(localproc_002e 210 100 12 0)
		(localproc_002e 100 40 5 0)
		(localproc_002e 100 52 6 0)
		(localproc_002e 100 64 7 0)
		(localproc_002e 100 76 8 0)
		(localproc_002e 100 88 9 0)
		(localproc_002e 100 100 10 0)
		(localproc_002e 100 112 11 0)
		(localproc_002e
			160
			141
			13
			1
			(Format @temp0 {%d} [gStrength 13])
		)
		(localproc_002e
			160
			153
			14
			1
			(Format
				@temp0
				{%d / %d}
				(/ (+ [gStrength 14] 1) 2)
				(/ (+ (proc814_21) 1) 2)
			)
		)
		(localproc_002e
			160
			165
			15
			1
			(Format
				@temp0
				{%d / %d}
				(/ (+ [gStrength 15] 3) 4)
				(/ (+ (proc814_20) 3) 4)
			)
		)
		(localproc_002e
			160
			177
			16
			1
			(Format @temp0 {%d / %d} [gStrength 16] (proc814_22))
		)
	)
	
	(method (dispose &tmp temp0)
		(localproc_0136)
		(= global34 local2)
		(= temp0 0)
		(while (< temp0 25)
			(= [gGStrength_2 temp0] [gStrength temp0])
			(++ temp0)
		)
		(= global424 global15)
		(proc0_3)
		(User canInput: userInput canControl: userControls)
		(super dispose:)
		(gGame setCursor: gCursorNumber 1)
		(DisposeScript 204)
	)
)

(instance myHero of View
	(properties
		x 51
		y 145
		view 802
	)
	
	(method (handleEvent pEvent)
		(pEvent claimed: 1)
		(if
			(or
				(and
					(== (pEvent type?) evKEYBOARD)
					(proc999_5 (pEvent message?) 13 27)
				)
				(== (pEvent type?) evMOUSEBUTTON)
			)
			(theCharSheet dispose:)
		)
	)
)
