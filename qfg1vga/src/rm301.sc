;;; Sierra Script 1.0 - (do not remove this comment)
(script# 301)
(include sci.sh)
(use Main)
(use Teller)
(use Ware)
(use n814)
(use Print)
(use RTRandCycle)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use CueObj)
(use n958)
(use Sound)
(use Cycle)
(use Game)
(use User)
(use View)
(use Obj)

(public
	rm301 0
	shameenTalker 1
	shemaTalker 2
	abdullaTalker 3
)

(local
	[local0 9] = [0 35 29 -9 -11 -38 31 -15 999]
	[local9 9] = [0 35 29 -33 -11 -38 31 -15 999]
	[local18 7] = [0 12 2 16 14 28 999]
	[local25 6] = [0 30 32 14 -27 999]
	[local31 5] = [0 37 36 34 999]
	[local36 9] = [0 35 29 23 47 -11 -9 -13 999]
	[local45 4] = [0 27 12 999]
	[local49 6] = [0 30 14 32 46 999]
	[local55 7] = [0 -12 11 -5 9 -3 999]
	[local62 4] = [0 -2 -16 999]
	[local66 5] = [0 15 13 14 999]
	[local71 7] = [0 8 10 7 17 6 999]
	[local78 3] = [0 -3 999]
	[local81 3] = [0 4 999]
	[local84 8]
	[local92 7]
	[local99 10]
	[local109 7] = [0 -9 -11 -27 -38 -15 999]
	[local116 7] = [0 -33 -11 -27 -38 -15 999]
	[local123 5] = [0 -11 -9 -13 999]
	[local128 8] = [0 -12 -2 -5 -16 -3 999]
	local136
	local137
	local138
	local139
	local140
	local141
	local142
	local143
	local144
	gEgoCycleSpeed
)
(procedure (localproc_0172 param1 param2)
	(return
		(switch param2
			(4
				(cond 
					((not (proc0_7 303)) (gQg1Messager say: 15 4) (return 1))
					((or (== local141 1) (== local142 1)) (gQg1Messager say: 15 71 25) (return 1))
					((== local141 2) (gQg1Messager say: 15 71 24) (return 1))
					((== local142 2) (gQg1Messager say: 15 71 23) (return 1))
					(else
						(gEgo setScript: egoStands)
						(if (== (shema script?) comingOut)
							(shema setScript: goingIn)
						)
					)
				)
			)
			(1
				(gQg1Messager say: param1 1)
				(return 1)
			)
			(else 
				(if (!= param2 3) (gQg1Messager say: 15 0 18))
				(return 1)
			)
		)
	)
)

(instance rm301 of Rm
	(properties
		noun 15
		picture 301
		south 300
	)
	
	(method (init)
		(gQg1Walkers add: self)
		(if (or (== global119 4) (== global119 5))
			(if (not (proc0_7 115))
				(= local144 1)
			else
				(= local144 (Random 0 1))
			)
		)
		(if local144
			(proc0_5 176)
			(= [local84 0] @local9)
		else
			(= [local84 0] @local0)
		)
		(= [local84 1] @local18)
		(= [local84 2] @local25)
		(= [local84 3] @local18)
		(= [local84 4] @local31)
		(= [local84 5] @local25)
		(= [local84 6] 999)
		(= [local92 0] @local36)
		(= [local92 1] @local49)
		(= [local92 2] @local45)
		(= [local92 3] @local49)
		(= [local92 4] 999)
		(= [local99 0] @local55)
		(= [local99 1] @local62)
		(= [local99 2] @local71)
		(= [local99 3] @local66)
		(= [local99 4] @local78)
		(= [local99 5] @local81)
		(= [local99 6] 999)
		(self
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						3
						162
						3
						189
						0
						189
						0
						0
						319
						0
						319
						189
						315
						189
						313
						184
						293
						185
						253
						145
						219
						145
						201
						111
						242
						111
						224
						92
						204
						93
						197
						89
						85
						89
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 65 138 56 127 76 110 145 110 136 138
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 204 146 210 174 180 180 80 180 99 146
					yourself:
				)
		)
		(proc958_0 128 1301 302 301 303 304)
		(proc958_0 132 21 50)
		(rm301 style: (if (== gGModNum 302) -32761 else 2))
		(super init:)
		(= global425 (| global425 $0006))
		(self
			setFeatures:
				onSleepDoor
				onLargeTable
				onFireplace
				onKitchenDoor
				onPlates
				onPots
				onGenieLamp
				onMask
				onTable
		)
		(self setRegions: 801)
		(proc0_6 254)
		(proc0_6 303)
		(proc0_6 112)
		(proc0_6 302)
		(proc0_6 300)
		(proc0_6 301)
		(proc0_6 111)
		(gMainIconBar enable:)
		(proc814_3)
		(gEgo actions: egoActions init: ignoreActors:)
		(proc814_2 0 0)
		(theFire init:)
		(floorReflectLite init:)
		(leftCandle init:)
		(rightCandle init:)
		(tools init:)
		(Chair
			init:
			approachVerbs:
				4
				34
				42
				44
				46
				16
				38
				21
				36
				39
				32
				29
				37
				22
				26
				14
				17
				27
				23
				31
				30
				40
				43
				45
				53
				11
				28
				20
				35
				15
				10
				24
				12
				18
				19
				47
				41
				33
			stopUpd:
		)
		(SwDoor init: stopUpd:)
		(if (proc0_7 176)
			(proc0_5 115)
			(merchantTeller
				init: merchant @local55 @local99 @local128
			)
			(merchant actions: merchantTeller init:)
			(shameenTeller init: shameen @local9 @local84 @local116)
		else
			(shameenTeller init: shameen @local0 @local84 @local109)
		)
		(shameen actions: shameenTeller init:)
		(shemaTeller init: shema @local36 @local92 @local123)
		(shema init: actions: shemaTeller)
		(switch gGModNum
			(302
				(gEgo loop: 0 posn: 100 100 setMotion: PolyPath 150 110)
			)
			(else 
				(gEgo posn: 235 183 setMotion: MoveTo 235 175)
			)
		)
		(gLongSong number: 21 setLoop: 1 play:)
		(pillow init:)
	)
	
	(method (dispose)
		(= global451 0)
		(if (gNewCast contains: merchant) (merchant dispose:))
		(proc0_6 176)
		(gQg1Walkers delete: self)
		(= global425 0)
		(super dispose:)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(52 (gQg1Messager say: 15 52))
			(3
				(cond 
					((not (proc0_7 303)) (super doVerb: theVerb &rest))
					((or (== local141 1) (== local142 1)) (gQg1Messager say: 15 71 25))
					((== local141 2) (gQg1Messager say: 15 71 24))
					((== local142 2) (gQg1Messager say: 15 71 23))
					(else
						(gEgo setScript: egoStands)
						(if (== (shema script?) comingOut)
							(shema setScript: goingIn)
						)
					)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance merchant of Actor
	(properties
		x 101
		y 262
		z 100
		noun 1
		view 302
		loop 1
	)
	
	(method (init &tmp temp0)
		(self setPri: 14 ignoreActors: signal: 16 stopUpd:)
		(mLegs addToPic:)
		(mMug addToPic:)
		(super init:)
	)
	
	(method (dispose)
		(mLegs dispose:)
		(mMug dispose:)
		(super dispose:)
	)
)

(instance merchantTeller of Teller
	(properties)
	
	(method (showDialog &tmp temp0)
		(return
			(if
				(and
					(== (= temp0 (super showDialog: -3 (proc0_7 347))) -16)
					(not (proc0_7 347))
				)
				(return (- temp0))
			else
				(return temp0)
			)
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (not local138)
					(gEgo setScript: sitScript)
				else
					(proc814_26 720 5)
					(super doVerb: theVerb &rest)
				)
			)
			(11
				(gEgo setScript: feedMerchant)
			)
			(10
				(cond 
					((or (== local144 3) (== local144 2)) (gQg1Messager say: 1 10 0 6))
					((== (shema script?) comingOut)
						((= gNewList (List new:))
							add:
								((Clone Ware) name: {ארוחה לעבדולה} price: {4})
								((Clone Ware) name: {שתיה לעבדולה} price: {2})
						)
						(switch ((ScriptID 551 0) doit:)
							(-1
								(gQg1Messager say: 1 10 0 3)
							)
							(0 (gQg1Messager say: 18 10 51))
							(1
								(proc814_26 736 2)
								(= local144 3)
								(merchant setScript: giveThanks)
							)
							(2
								(= local144 2)
								(merchant setScript: giveThanks)
							)
						)
					)
					(else (gQg1Messager say: 1 10 0 2))
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
		(return 1)
	)
)

(instance shema of Actor
	(properties
		noun 18
		view 303
	)
	
	(method (init &tmp temp0)
		(super init:)
		(self
			illegalBits: 0
			ignoreActors:
			posn: 500 500
			setCycle: Walk
		)
	)
)

(instance shemaTeller of Teller
	(properties)
	
	(method (doVerb theVerb)
		(return
			(switch theVerb
				(10
					((= gNewList (List new:))
						add:
							((Clone Ware) name: {ארוחה לעצמך} price: {3})
							((Clone Ware) name: {שתיה לעצמך} price: {1})
					)
					(switch ((ScriptID 551 0) doit:)
						(-1
							(gQg1Messager say: 18 10 39)
						)
						(0 (gQg1Messager say: 18 10 51))
						(1
							(proc814_26 721 1)
							(cond 
								((proc0_7 125)
									(gQg1Messager say: 18 10 41)
									(proc0_6 125)
									(proc0_6 124)
									(= local141 1)
									(if (== (shema script?) comingOut)
										(comingOut changeState: 7)
									)
								)
								((proc0_7 124)
									(gQg1Messager say: 18 10 50)
									(proc0_6 124)
									(= global199 1)
									(= local141 1)
									(if (== (shema script?) comingOut)
										(comingOut changeState: 7)
									)
								)
								(global199 (gQg1Messager say: 18 10 18))
								(else
									(= global199 2)
									(gQg1Messager say: 18 10 50)
									(= local141 1)
									(if (== (shema script?) comingOut)
										(comingOut changeState: 7)
									)
								)
							)
						)
						(2
							(if local140
								(gQg1Messager say: 18 10 48)
							else
								(gQg1Messager say: 18 10 49)
								(= local142 1)
								(if (== (shema script?) comingOut)
									(comingOut changeState: 7)
								)
							)
						)
					)
					(return 1)
				)
				(else 
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance shameen of Prop
	(properties
		noun 17
		view 302
		loop 2
	)
	
	(method (init &tmp temp0)
		(= global451 1302)
		(PalVary pvCHANGE_TARGET 1302)
		(kernel_128 302)
		(self x: 232 y: 132 ignoreActors:)
		(self setScript: shameensIntro)
		(super init:)
	)
)

(instance shameenTeller of Teller
	(properties)
	
	(method (showDialog)
		(super
			showDialog: -9 (not (proc0_7 115)) -33 (proc0_7 176) -27 (proc0_7 115)
		)
	)
	
	(method (doVerb theVerb)
		(return
			(switch theVerb
				(2
					(if (not local137)
						(gQg1Messager say: 17 5 29)
						(++ local137)
					else
						(proc814_26 719 1)
						(super doVerb: theVerb)
					)
					(return 1)
				)
				(10
					(if (or local141 local142)
						(gQg1Messager say: 17 10 40 2)
					else
						((= gNewList (List new:))
							add: ((Clone Ware) name: {שנת לילה} price: {5})
						)
						(switch ((ScriptID 551 0) doit:)
							(-1
								(gQg1Messager say: 17 10 39)
							)
							(1
								(cond 
									((proc0_7 110) (proc0_5 122) (shameen setScript: rentARoom))
									((and (< 750 global116) (< global116 2550)) (gQg1Messager say: 17 10 40 1))
									((proc0_7 125) (gQg1Messager say: 17 10 41))
									(else (proc0_5 122) (shameen setScript: rentARoom))
								)
							)
						)
					)
					(return 1)
				)
				(else 
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance Food of View
	(properties
		x 160
		y 150
		noun 7
		view 304
		loop 6
		priority 14
		signal $0010
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(4 (gEgo setScript: eatIt))
			(2 (gEgo setScript: eatIt))
			(1
				(if (or (proc0_7 302) (== local141 3))
					(gQg1Messager say: 7 1 19)
					(= local141 3)
					(gEgo setScript: eatIt)
				else
					(gQg1Messager say: 7 1 20)
					(proc0_5 302)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance movingFood of View
	(properties
		view 304
		loop 4
	)
	
	(method (doit)
		(movingFood
			x: (shema x?)
			y: (shema y?)
			cel: (shema cel?)
			priority: (+ 1 (shema priority?))
		)
		(super doit:)
	)
)

(instance Drink of View
	(properties
		x 161
		y 150
		noun 22
		view 304
		loop 7
		priority 14
		signal $0010
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (gEgo setScript: eatIt))
			(1
				(if (or (== local142 2) (== local141 2))
					(gQg1Messager say: 22 1 20)
					(= local140 1)
				)
			)
			(else 
				(proc921_0 {in else of Drink})
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mLegs of View
	(properties
		x 103
		y 160
		view 302
		loop 7
		priority 12
		signal $0010
	)
)

(instance tools of Prop
	(properties
		x 265
		y 134
		noun 23
		view 301
		loop 4
	)
	
	(method (doVerb theVerb)
		(localproc_0172 noun theVerb)
	)
)

(instance mMug of View
	(properties
		x 125
		y 157
		noun 11
		view 301
		loop 4
		cel 3
		priority 14
	)
	
	(method (doVerb theVerb)
		(localproc_0172 noun theVerb)
	)
)

(instance pillow of Prop
	(properties
		x 229
		y 125
		noun 12
		view 302
		loop 3
	)
	
	(method (doVerb theVerb)
		(localproc_0172 noun theVerb)
	)
)

(instance InnMusic of Sound
	(properties
		flags $ffff
		number 21
	)
)

(instance clapSound of Sound
	(properties
		number 118
	)
)

(instance onTable of Feature
	(properties
		x 100
		y 120
		noun 21
		nsTop 104
		nsLeft 63
		nsBottom 138
		nsRight 138
	)
	
	(method (doVerb theVerb)
		(localproc_0172 noun theVerb)
	)
)

(instance onKitchenDoor of Feature
	(properties
		x 158
		y 56
		noun 3
		nsTop 21
		nsLeft 134
		nsBottom 90
		nsRight 181
	)
	
	(method (doVerb theVerb)
		(localproc_0172 noun theVerb)
	)
)

(instance onPlates of Feature
	(properties
		x 241
		y 52
		noun 13
		nsTop 32
		nsLeft 224
		nsBottom 72
		nsRight 257
	)
	
	(method (doVerb theVerb)
		(localproc_0172 noun theVerb)
	)
)

(instance onMask of Feature
	(properties
		x 27
		y 71
		noun 10
		nsTop 54
		nsLeft 16
		nsBottom 87
		nsRight 37
	)
	
	(method (doVerb theVerb)
		(localproc_0172 noun theVerb)
	)
)

(instance onPots of Feature
	(properties
		x 16
		y 112
		noun 14
		nsTop 96
		nsLeft 3
		nsBottom 128
		nsRight 28
	)
	
	(method (doVerb theVerb)
		(localproc_0172 noun theVerb)
	)
)

(instance onGenieLamp of Feature
	(properties
		x 255
		y 80
		noun 8
		nsTop 74
		nsLeft 245
		nsBottom 86
		nsRight 264
	)
	
	(method (doVerb theVerb)
		(localproc_0172 noun theVerb)
	)
)

(instance onFireplace of Feature
	(properties
		x 288
		y 130
		noun 4
		nsTop 87
		nsLeft 276
		nsBottom 181
		nsRight 319
	)
	
	(method (doVerb theVerb)
		(localproc_0172 noun theVerb)
	)
)

(instance onLargeTable of Feature
	(properties
		x 134
		y 171
		z 10
		noun 21
		nsTop 137
		nsLeft 87
		nsBottom 183
		nsRight 181
	)
	
	(method (doVerb theVerb)
		(return
			(switch theVerb
				(16
					(gQg1Messager say: 15 16)
					(return 1)
				)
				(20
					(gQg1Messager say: 15 16)
					(return 1)
				)
				(12
					(gQg1Messager say: 15 16)
					(return 1)
				)
				(4
					(if (or (== local141 2) (== local142 2))
						(gEgo setScript: eatIt)
					else
						(gQg1Messager say: 21 4)
						(return 1)
					)
				)
				(2
					(if (or (== local141 2) (== local142 2))
						(gEgo setScript: eatIt)
					else
						(gQg1Messager say: 21 4 18)
						(return 1)
					)
				)
				(1
					(cond 
						((or (proc0_7 302) (== local141 3)) (gQg1Messager say: 7 1 19) (return 1) (= local141 3))
						((== local141 2) (gQg1Messager say: 7 1 20) (return 1) (proc0_5 302))
						((== local142 2) (gQg1Messager say: 22 1 20) (= local140 1))
						(else (gQg1Messager say: 21 1) (return 1))
					)
				)
				(else 
					(gQg1Messager say: 15 0 18)
					(return 1)
				)
			)
		)
	)
)

(instance onSleepDoor of Feature
	(properties
		x 67
		y 66
		noun 19
		nsTop 29
		nsLeft 47
		nsBottom 103
		nsRight 86
	)
	
	(method (doVerb theVerb)
		(localproc_0172 noun theVerb)
	)
)

(instance shameenTalker of Talker
	(properties
		x 10
		y 10
		view 1301
		talkWidth 260
		textX 15
		textY 110
	)
	
	(method (init)
		(= global451 2301)
		(PalVary pvCHANGE_TARGET 2301)
		(kernel_128 1301)
		(= font gFont)
		(super init: shameenBust shameenEye shameenMouth &rest)
		(brows init: setCycle: Blink)
	)
	
	(method (dispose)
		(brows dispose:)
		(super dispose:)
	)
)

(instance shemaTalker of Talker
	(properties
		x 10
		y 10
		view 1302
		talkWidth 260
		textX 15
		textY 110
	)
	
	(method (init)
		(= global451 2302)
		(PalVary pvCHANGE_TARGET 2302)
		(kernel_128 1302)
		(= font gFont)
		(super init: shemaBust shemaEye shemaMouth &rest)
	)
)

(instance abdullaTalker of Talker
	(properties
		x 10
		y 10
		view 1303
		talkWidth 260
		textX 15
		textY 110
	)
	
	(method (init)
		(= global451 2303)
		(PalVary pvCHANGE_TARGET 2303)
		(kernel_128 1303)
		(= font gFont)
		(super init: abdullaBust abdullaEye abdullaMouth &rest)
	)
)

(instance shemaBust of Prop
	(properties
		view 1302
	)
)

(instance shemaMouth of Prop
	(properties
		nsTop 47
		nsLeft 48
		view 1302
		loop 1
	)
)

(instance shemaEye of Prop
	(properties
		nsTop 33
		nsLeft 40
		view 1302
		loop 2
	)
)

(instance shameenBust of Prop
	(properties
		view 1301
	)
)

(instance shameenMouth of Prop
	(properties
		nsTop 52
		nsLeft 43
		view 1301
		loop 1
	)
)

(instance shameenEye of Prop
	(properties
		nsTop 32
		nsLeft 38
		view 1301
		loop 2
	)
)

(instance brows of Prop
	(properties
		nsTop 30
		nsLeft 39
		view 1301
		loop 3
	)
)

(instance SwDoor of Prop
	(properties
		x 160
		y 23
		noun 20
		view 301
		priority 5
		signal $4010
		cycleSpeed 12
	)
	
	(method (doVerb theVerb)
		(localproc_0172 noun theVerb)
	)
)

(instance leftCandle of Prop
	(properties
		x 109
		y 54
		noun 9
		view 301
		loop 1
		cycleSpeed 9
		detailLevel 2
	)
	
	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)
	
	(method (doVerb theVerb)
		(localproc_0172 noun theVerb)
	)
)

(instance rightCandle of Prop
	(properties
		x 207
		y 54
		noun 16
		view 301
		loop 2
		cycleSpeed 9
		detailLevel 2
	)
	
	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)
	
	(method (doVerb theVerb)
		(localproc_0172 noun theVerb)
	)
)

(instance floorReflectLite of Prop
	(properties
		x 237
		y 133
		noun 6
		view 301
		loop 7
		signal $0010
		cycleSpeed 9
		detailLevel 2
	)
	
	(method (init)
		(self setCycle: RandCycle)
		(super init:)
	)
	
	(method (doVerb theVerb)
		(localproc_0172 noun theVerb)
	)
)

(instance theFire of Prop
	(properties
		x 281
		y 143
		noun 5
		view 301
		loop 3
		cycleSpeed 9
		detailLevel 2
	)
	
	(method (init)
		(self setCycle: RandCycle)
		(super init:)
	)
	
	(method (doVerb theVerb)
		(localproc_0172 noun theVerb)
	)
)

(instance Chair of Prop
	(properties
		x 194
		y 169
		noun 2
		approachX 225
		approachY 175
		view 301
		loop 4
		cel 4
		signal $4000
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (not (proc0_7 303)) (gEgo setScript: sitScript))
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance abdullaBust of Prop
	(properties
		view 1303
	)
)

(instance abdullaMouth of Prop
	(properties
		nsTop 46
		nsLeft 56
		view 1303
		loop 1
	)
)

(instance abdullaEye of Prop
	(properties
		nsTop 33
		nsLeft 53
		view 1303
		loop 2
	)
)

(instance egoActions of Actions
	(properties)
	
	(method (doVerb theVerb)
		(return
			(if (or (== theVerb 16) (== theVerb 12))
				(gQg1Messager say: 1 16 0 1)
				(return 1)
			else
				(return 0)
			)
		)
	)
)

(instance eatIt of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(if (gNewCast contains: Food) (Food setCel: 5))
				(if (== local141 2)
					(= local141 3)
					(gQg1Messager say: 15 0 21 1 self)
				else
					(self cue:)
				)
			)
			(1
				(if (== local142 2)
					(= local142 3)
					(gQg1Messager say: 15 0 21 2 self)
				else
					(self cue:)
				)
			)
			(2
				(shema setScript: comingToClear)
				(self dispose:)
			)
		)
	)
)

(instance feedMerchant of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gQg1Messager say: 1 11 0 1 self)
				(proc814_26 736 2)
			)
			(1
				(gEgo use: 1 1)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance LickIt of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(++ local136)
				(shameen
					setLoop: 2
					cel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(1
				(if (< local136 (Random 2 5))
					(self changeState: 0)
				else
					(= local136 0)
					(shameen setLoop: 4 cel: 0 cycleSpeed: 6 stopUpd:)
					(= seconds (Random 5 15))
				)
			)
			(2 (self changeState: 0))
		)
	)
)

(instance shameensIntro of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(if (not (proc0_7 89))
					(shameen setLoop: 4 cel: 0 cycleSpeed: 6)
					(proc0_5 89)
					(= ticks 30)
				else
					(proc0_3)
					(proc0_6 300)
					(shameen setScript: LickIt)
				)
			)
			(1 (shameen setCycle: End self))
			(2
				(shameen loop: 6 cel: 0 cycleSpeed: 12 setCycle: End self)
			)
			(3 (= ticks 120))
			(4 (shameen setCycle: Beg self))
			(5
				(proc0_5 300)
				(shameen stopUpd:)
				(gQg1Messager say: 17)
				(= ticks 180)
			)
			(6
				(shameen
					setLoop: 4
					cel: 5
					cycleSpeed: 6
					setCycle: Beg self
				)
			)
			(7
				(proc0_3)
				(proc0_6 300)
				(shameen setLoop: 2 setScript: LickIt)
			)
		)
	)
)

(instance shameenClaps of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (proc0_7 115) (not (proc0_7 116)))
					(= seconds 2)
				else
					(= ticks 1)
				)
			)
			(1
				(if (and (proc0_7 115) (not (proc0_7 116)))
					(self changeState: 0)
				else
					(= ticks 1)
				)
			)
			(2
				(if (proc0_7 300)
					(self cue:)
				else
					(shameen
						setLoop: 4
						cel: 0
						cycleSpeed: 6
						setCycle: End self
					)
				)
			)
			(3
				(shameen
					setLoop: 5
					cycleSpeed: 12
					cel: 0
					setCycle: CT 3 1 self
				)
			)
			(4 (= ticks 40))
			(5
				(shameen cel: 4)
				(= cycles 1)
			)
			(6
				(clapSound play:)
				(= ticks 20)
			)
			(7
				(shameen cel: 3)
				(= ticks 40)
			)
			(8
				(shameen cel: 4)
				(= cycles 1)
			)
			(9
				(clapSound play:)
				(= ticks 20)
			)
			(10
				(shameen cel: 3)
				(= ticks 40)
			)
			(11
				(shameen cel: 4)
				(= cycles 1)
			)
			(12
				(clapSound play:)
				(= ticks 20)
			)
			(13 (= ticks 60))
			(14
				(shema setScript: comingOut)
				(= ticks 1)
			)
			(15
				(shameen setCycle: Beg self)
			)
			(16
				(shameen setLoop: 4 cel: 5 setCycle: 0 cycleSpeed: 6)
				(= ticks 20)
			)
			(17
				(shameen setCycle: Beg self)
			)
			(18
				(proc0_6 300)
				(shameen stopUpd: setScript: LickIt)
			)
		)
	)
)

(instance emotionalMerchant of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(merchant setLoop: 1 cel: 0 setCycle: End self)
			)
			(1
				(merchant setLoop: 0 cel: 0 setCycle: End self)
			)
			(2
				(merchant setLoop: 0 cel: 2)
				(= ticks 18)
			)
			(3
				(merchant setLoop: 0 cel: 3)
				(= ticks 18)
			)
			(4
				(merchant setCycle: Beg self)
			)
			(5
				(merchant stopUpd:)
				(= ticks 60)
			)
			(6
				(if (not (proc0_7 116))
					(gQg1Messager say: 1 0 1 4 self)
					(proc0_5 116)
				else
					(gQg1Messager say: 1 0 1 5 self)
				)
			)
			(7
				(shameen setScript: shameenClaps)
				(self dispose:)
			)
		)
	)
)

(instance rentARoom of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (proc0_7 303)
					(gEgo setScript: egoStands)
					(proc0_2)
					(if (== (shema script?) comingOut)
						(comingOut changeState: 11)
					)
				else
					(= ticks 1)
				)
			)
			(1
				(if (proc0_7 303) (= seconds 15) else (= ticks 1))
				(if (proc0_7 128)
					(self changeState: 5)
				else
					(proc814_26 722 1)
					(if (proc0_7 300)
						(self cue:)
					else
						(shameen
							setLoop: 4
							cel: 0
							cycleSpeed: 6
							setCycle: End self
						)
						(proc0_5 300)
					)
				)
			)
			(2
				(proc0_2)
				(gQg1Messager say: 17 0 26)
				(shameen setCycle: Beg self)
			)
			(3
				(proc0_6 300)
				(proc814_3)
				(gEgo ignoreActors: illegalBits: 0)
				(if (gEgo inRect: 239 25 319 133)
					(gEgo setMotion: PolyPath (gEgo x?) 120 self)
				else
					(= cycles 1)
				)
			)
			(4
				(gEgo setMotion: PolyPath 105 100 self)
			)
			(5
				(proc0_5 128)
				(gNewCast eachElementDo: #dispose)
				(global2 drawPic: 400 -32761)
				(self cue:)
			)
			(6
				(proc0_6 122)
				(global2 newRoom: 302)
			)
		)
	)
)

(instance comingOut of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond 
					((== local141 1) (shema view: 304) (movingFood init:))
					((== local142 1) (shema view: 304))
					(else (shema view: 303))
				)
				(shema posn: 160 77 setLoop: 0)
				(proc0_2)
				(InnMusic stop: number: 50 play:)
				(SwDoor cel: 0 setCycle: End self)
			)
			(1
				(shema setMotion: MoveTo 160 122 self)
				(proc0_5 301)
			)
			(2
				(SwDoor setCycle: Beg)
				(shema setMotion: MoveTo 163 149 self)
			)
			(3
				(SwDoor cel: 0 stopUpd:)
				(= ticks 1)
			)
			(4
				(if (and (== local141 0) (== local142 0))
					(gQg1Messager say: 18 0 44)
					(proc0_3)
					(User canControl: 0)
				else
					(gQg1Messager say: 18 0 43)
					(cond 
						((== local141 1)
							(= local141 2)
							(shema loop: 2 cel: 0 setCycle: CT 3 1 self)
						)
						((== local142 1)
							(= local142 2)
							(shema loop: 2 cel: 0 setCycle: CT 3 1 self)
						)
						(else (= ticks 1))
					)
				)
			)
			(5
				(shema cel: 4)
				(if (== local141 2)
					(Food ignoreActors: setPri: 14 cel: 1 init: stopUpd:)
					(movingFood hide:)
				)
				(if (== local142 2)
					(Drink ignoreActors: setPri: 14 init: stopUpd:)
				)
				(proc0_5 112)
				(= seconds 3)
			)
			(6
				(if (or (== local141 2) (== local142 2))
					(shema setCycle: End self)
				)
			)
			(7
				(proc0_2)
				(shema
					view: 304
					loop: 3
					cel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(8 (= ticks 90))
			(9 (shema setCycle: Beg self))
			(10 (= ticks 60))
			(11
				(client
					view: 303
					cycleSpeed: 6
					setCycle: Walk
					setScript: goingIn
				)
				(self dispose:)
			)
		)
	)
)

(instance comingToClear of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= ticks 180))
			(1
				(shema
					view: 303
					setLoop: 0
					setCycle: Walk
					posn: 160 77
					cel: 0
				)
				(proc0_2)
				(InnMusic stop: number: 50 play:)
				(SwDoor cel: 0 setCycle: End self)
			)
			(2
				(shema setMotion: MoveTo 160 122 self)
				(proc0_5 301)
			)
			(3
				(SwDoor setCycle: Beg)
				(shema setMotion: MoveTo 163 149 self)
			)
			(4
				(SwDoor cel: 0 stopUpd:)
				(= ticks 1)
			)
			(5
				(gQg1Messager say: 18 0 45)
				(shema view: 304 loop: 2 cel: 5 setCycle: CT 3 -1 self)
			)
			(6
				(if (== local141 3)
					(Food dispose:)
					(movingFood loop: 5 cel: 2 show:)
				else
					(Drink dispose:)
				)
				(shema setCycle: Beg self)
			)
			(7
				(shema
					view: 304
					loop: 0
					cel: 0
					cycleSpeed: 6
					setCycle: Walk
				)
				(if (== local141 3) (= local141 4) else (= local142 4))
				(shema setScript: goingIn)
			)
		)
	)
)

(instance goingIn of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(proc0_5 112)
				(proc0_5 111)
				(InnMusic stop: number: 50 play:)
				(if (== local141 4)
					(movingFood dispose:)
					(= local141 0)
				)
				(if (== local142 4) (= local142 0))
				(shema
					loop: 1
					ignoreActors:
					setCycle: Walk
					setMotion: PolyPath 160 99 self
				)
			)
			(1
				(SwDoor cel: 0 setCycle: End self)
			)
			(2
				(shema setMotion: MoveTo 160 77 self)
			)
			(3
				(proc0_6 111)
				(SwDoor setCycle: Beg self)
			)
			(4
				(shema loop: 0)
				(proc0_6 112)
				(SwDoor cel: 0 stopUpd:)
				(proc0_3)
				(shema posn: 500 500)
				(if (proc0_7 303) (User canControl: 0))
				(if (or (== local141 1) (== local142 1))
					(= seconds 15)
				else
					(= ticks 1)
				)
			)
			(5
				(if (or (== local141 1) (== local142 1))
					(shema setScript: comingOut)
				)
				(= ticks 1)
			)
			(6
				(if (or (== local141 1) (== local142 1))
					(shema setScript: comingOut)
				else
					(shema stopUpd: setScript: 0)
					(proc0_3)
					(User canControl: 1)
					(User canInput: 1)
				)
				(= ticks 1)
			)
		)
	)
)

(instance sitScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= gEgoCycleSpeed (gEgo cycleSpeed?))
				(proc0_2)
				(gQg1Messager say: 15 0 22 1 self)
			)
			(1
				(gEgo setMotion: PolyPath 185 173 self)
			)
			(2
				(gEgo
					view: 301
					setLoop: 5
					cel: 0
					priority: 14
					cycleSpeed: 12
					signal: 16
				)
				(= ticks 18)
			)
			(3
				(gEgo setCycle: End self)
				(proc0_5 303)
				(User canControl: 0)
				(if (and (proc0_7 176) (not local138))
					(= local138 1)
					(merchant setScript: emotionalMerchant)
				else
					(shameen setScript: shameenClaps)
				)
				(egoOnChair init:)
			)
			(4
				(gEgo setCycle: 0)
				(self dispose:)
			)
		)
	)
)

(instance egoStands of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo view: 301 loop: 5 cel: 7 priority: 14)
				(= ticks 1)
			)
			(1
				(gEgo setCycle: Beg self)
				(egoOnChair dispose:)
			)
			(2
				(proc814_3 7)
				(proc814_2 0 0)
				(= ticks 1)
			)
			(3
				(gEgo
					cycleSpeed: gEgoCycleSpeed
					moveSpeed: gEgoCycleSpeed
					setMotion: PolyPath 235 175 self
				)
			)
			(4
				(proc0_6 303)
				(= local141 0)
				(= local142 0)
				(= local140 0)
				(if (!= (shema script?) goingIn)
					(proc0_3)
					(User canControl: 1)
					(User canInput: 1)
				)
				(gEgo illegalBits: -32768 ignoreActors: 0 setScript: 0)
				(if (== (shameen script?) rentARoom) (rentARoom cue:))
			)
		)
	)
)

(instance giveThanks of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== local144 3)
					(gQg1Messager say: 1 10 0 1 self)
				else
					(gQg1Messager say: 1 10 0 7 self)
				)
			)
			(1
				(if (== local144 3)
					(gQg1Messager say: 1 10 0 4 self)
				else
					(gQg1Messager say: 1 10 0 5 self)
				)
			)
			(2
				(gQg1Messager say: 1 0 1 1 self)
			)
			(3
				(gQg1Messager say: 1 0 1 2 self)
			)
			(4
				(gQg1Messager say: 1 0 1 3 self)
			)
			(5
				(client setScript: 0)
				(self dispose:)
			)
		)
	)
)

(instance egoOnChair of Feature
	(properties
		x 187
		y 255
		z 100
		nsTop 134
		nsLeft 172
		nsBottom 181
		nsRight 201
	)
	
	(method (init)
		(super init: &rest)
		(gDH add: self)
	)
	
	(method (dispose)
		(gDH delete: self)
		(super dispose:)
	)
	
	(method (handleEvent pEvent)
		(if
			(and
				(not (== (pEvent message?) JOY_NULL))
				(==
					(gMainIconBar curIcon?)
					(gMainIconBar walkIconItem?)
				)
				(& (pEvent type?) evJOYSTICK)
			)
			(if (and (!= local142 1) (!= local141 1))
				(gEgo setScript: egoStands)
				(if (== (shema script?) comingOut)
					(shema setScript: goingIn)
				)
			else
				(gQg1Messager say: 15 71 25)
			)
			(pEvent claimed: 1)
			(return)
		else
			(super handleEvent: pEvent)
		)
	)
	
	(method (doVerb theVerb)
		(return
			(if (== theVerb 3)
				(gEgo setScript: egoStands)
				(if (== (shema script?) comingOut)
					(shema setScript: goingIn)
				)
				(return 1)
			else
				(return 0)
			)
		)
	)
)
