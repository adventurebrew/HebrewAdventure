;;; Sierra Script 1.0 - (do not remove this comment)
(script# 314)
(include sci.sh)
(use Main)
(use Teller)
(use Ware)
(use n814)
(use RTRandCycle)
(use PolyPath)
(use Polygon)
(use CueObj)
(use n958)
(use Sound)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	rm314 0
	zaraTalker 1
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	[local10 7] = [0 -46 -16 29 -27 -40 999]
	[local17 4] = [0 21 34 999]
	[local21 3] = [0 22 999]
	[local24 6] = [0 -44 35 28 25 999]
	[local30 5] = [0 -41 -42 -38 999]
	[local35 3] = [0 20 999]
	[local38 3] = [0 -12 999]
	[local41 4] = [0 20 -13 999]
	[local45 5] = [0 32 -39 -33 999]
	[local50 3] = [0 19 999]
	[local53 5] = [0 -26 -15 14 999]
	[local58 8] = [0 17 23 30 45 37 -31 999]
	[local66 5] = [0 35 24 43 999]
	[local71 3] = [0 36 999]
	[local74 3] = [0 18 999]
	[local77 3] = [0 19 999]
	[local80 21]
	[local101 17] = [0 -46 -16 -27 -40 -44 -41 -42 -38 -12 -13 -39 -33 -26 -15 -31 999]
)
(procedure (localproc_00ac param1)
	(switch param1
		(24 (gEgo get: 0 40))
		(23 (gEgo get: 0 60))
		(17 (gEgo get: 0 30))
	)
)

(procedure (localproc_00e7 param1)
	(return
		(cond 
			((and param1 (not [gStrength 12])) (localproc_00ac param1) (gQg1Messager say: 28 10))
			((and param1 (gEgo knows: param1)) (localproc_00ac param1) (gQg1Messager say: 22 10 8))
			(else
				(if param1
					(gQg1Messager say: 22 10 9)
					(switch param1
						(24 (gEgo learn: 24 5))
						(23 (gEgo learn: 23 5))
						(17 (gEgo learn: 17 5))
					)
				)
				(return 1)
			)
		)
	)
)

(instance rm314 of Rm
	(properties
		noun 22
		picture 314
		style $0008
		east 310
	)
	
	(method (init)
		(= [local80 0] @local10)
		(= [local80 1] @local17)
		(= [local80 2] @local21)
		(= [local80 3] @local24)
		(= [local80 4] @local30)
		(= [local80 5] @local35)
		(= [local80 6] @local38)
		(= [local80 7] @local41)
		(= [local80 8] @local45)
		(= [local80 9] @local50)
		(= [local80 10] @local53)
		(= [local80 11] @local58)
		(= [local80 12] @local66)
		(= [local80 13] @local71)
		(= [local80 14] @local74)
		(= [local80 15] @local77)
		(= [local80 16] 999)
		(self
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						0
						189
						0
						0
						319
						0
						319
						189
						152
						189
						277
						168
						191
						132
						181
						131
						161
						130
						113
						141
						51
						163
						36
						178
						0
						180
					yourself:
				)
		)
		(Load rsVIEW 314)
		(Load rsVIEW 315)
		(proc958_0 132 67 (proc814_25 45) (proc814_25 28))
		(super init:)
		(proc814_3)
		(gEgo posn: 60 240 init: hide:)
		(self setRegions: 801)
		(proc0_2)
		(self setScript: firstScript)
		(shopMusic init: play:)
		(= local9 1)
		(self
			setFeatures:
				onClouds
				onScroll
				onBat
				onBottles
				onBooks
				onCrystalBall
				onMagicBall
				onBalanceScale
				onFloor
				onPentagon
				onBrownJar
				onGreenJar
				onAGreenJar
				onRedJar
				onBlueBottle
				onCeiling
				onMortar
		)
		(zaraTeller init: zara @local10 @local80 @local101)
		(onFloor init:)
	)
	
	(method (doit)
		(super doit:)
		(cond 
			((global2 script?) 0)
			((and (> (gEgo x?) 160) (not local5)) (= local5 1) (familiar setScript: familiarScript))
			(
				(and
					(not (gEgo script?))
					local4
					(or (< (gEgo x?) 10) (> (gEgo y?) 185))
				)
				(= local4 0)
				(gEgo setScript: exitScript)
			)
			(
				(and
					(not (gEgo script?))
					(or (< (gEgo x?) 10) (> (gEgo y?) 185))
				)
				(gEgo setScript: egoExitScript)
			)
		)
		(if local6
			(cond 
				((> (gEgo x?) 170) (if local7 (= local7 0) (familiarScript changeState: 2)))
				((not local7) (= local7 1) (familiarScript changeState: 5))
			)
		)
	)
	
	(method (dispose)
		(= global451 0)
		(proc0_5 93)
		(super dispose:)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(global2 setScript: lookAtRoom)
			)
			(4 (gQg1Messager say: 22 4))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance onClouds of Feature
	(properties
		x 300
		y 80
		noun 9
		nsTop 8
		nsLeft 252
		nsBottom 85
		nsRight 306
	)
)

(instance onScroll of Feature
	(properties
		x 136
		y 133
		z 68
		noun 25
		nsTop 61
		nsLeft 122
		nsBottom 70
		nsRight 151
	)
)

(instance onMagicBall of Feature
	(properties
		x 304
		y 129
		z 53
		noun 2
		nsTop 68
		nsLeft 294
		nsBottom 84
		nsRight 315
	)
)

(instance onCrystalBall of Feature
	(properties
		x 131
		y 134
		z 47
		noun 11
		nsTop 80
		nsLeft 124
		nsBottom 95
		nsRight 138
	)
)

(instance onBalanceScale of Feature
	(properties
		x 82
		y 146
		z 47
		noun 23
		nsTop 85
		nsLeft 64
		nsBottom 114
		nsRight 100
	)
)

(instance onFloor of Feature
	(properties
		x 143
		y 154
		noun 14
		onMeCheck $0002
	)
)

(instance onPentagon of Feature
	(properties
		x 257
		y 95
		noun 20
		nsTop 87
		nsLeft 223
		nsBottom 104
		nsRight 291
	)
)

(instance onBrownJar of Feature
	(properties
		x 289
		y 171
		noun 7
		nsTop 158
		nsLeft 270
		nsBottom 185
		nsRight 310
	)
)

(instance onGreenJar of Feature
	(properties
		x 171
		y 115
		noun 15
		nsTop 104
		nsLeft 162
		nsBottom 127
		nsRight 181
	)
)

(instance onAGreenJar of Feature
	(properties
		x 171
		y 115
		noun 15
		nsTop 111
		nsLeft 282
		nsBottom 140
		nsRight 295
	)
)

(instance onBlueBottle of Feature
	(properties
		x 245
		y 173
		noun 4
		nsTop 159
		nsLeft 228
		nsBottom 187
		nsRight 263
	)
)

(instance onRedJar of Feature
	(properties
		x 22
		y 160
		noun 21
		nsTop 151
		nsLeft 8
		nsBottom 169
		nsRight 37
	)
)

(instance onCeiling of Feature
	(properties
		x 237
		y 136
		z 119
		noun 8
		nsTop 3
		nsLeft 161
		nsBottom 32
		nsRight 313
	)
)

(instance onToaster of Feature
	(properties
		noun 27
		nsTop 88
		nsLeft 102
		nsBottom 99
		nsRight 115
	)
)

(instance onManta of Feature
	(properties
		noun 17
		nsTop 72
		nsLeft 230
		nsBottom 90
		nsRight 252
	)
)

(instance onTinsel1 of Feature
	(properties
		noun 26
		nsTop 107
		nsLeft 209
		nsBottom 122
		nsRight 219
	)
)

(instance onTinsel2 of Feature
	(properties
		noun 26
		nsTop 118
		nsLeft 230
		nsBottom 139
		nsRight 250
	)
)

(instance onBottles of Feature
	(properties
		x 130
		y 134
		z 91
		noun 6
		nsTop 34
		nsLeft 108
		nsBottom 53
		nsRight 152
	)
)

(instance onBooks of Feature
	(properties
		x 148
		y 134
		z 50
		noun 5
		nsTop 76
		nsLeft 142
		nsBottom 92
		nsRight 155
	)
)

(instance onMortar of Feature
	(properties
		x 207
		y 179
		noun 18
		nsTop 170
		nsLeft 189
		nsBottom 188
		nsRight 225
	)
)

(instance onAccoutrements of Feature
	(properties
		noun 1
		nsTop 51
		nsLeft 230
		nsBottom 68
		nsRight 251
	)
)

(instance onBat of Feature
	(properties
		x 82
		y 149
		z 133
		noun 3
		nsTop 11
		nsLeft 73
		nsBottom 22
		nsRight 91
	)
)

(instance onHead of Feature
	(properties
		noun 16
		nsTop 94
		nsLeft 66
		nsBottom 113
		nsRight 92
	)
)

(instance onOdds1 of Feature
	(properties
		noun 19
		nsTop 72
		nsLeft 67
		nsBottom 88
		nsRight 92
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(switch (Random 1 5)
					(1 (gQg1Messager say: 19 1 2))
					(2 (gQg1Messager say: 19 1 3))
					(3 (gQg1Messager say: 19 1 4))
					(4 (gQg1Messager say: 19 1 5))
					(5 (gQg1Messager say: 19 1 6))
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance onOdds2 of Feature
	(properties
		noun 19
		nsTop 109
		nsLeft 102
		nsBottom 121
		nsRight 111
	)
)

(instance onOdds3 of Feature
	(properties
		noun 19
		nsTop 53
		nsLeft 201
		nsBottom 86
		nsRight 219
	)
)

(instance familiarFoot of View
	(properties
		x 193
		y 51
		noun 12
		view 314
		loop 8
		priority 9
		signal $4011
	)
	
	(method (doVerb theVerb)
		(familiar doVerb: theVerb &rest)
	)
)

(instance familiar of Prop
	(properties
		x 202
		y 59
		noun 12
		view 314
		loop 6
		signal $4000
		cycleSpeed 12
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (not local5)
					(gQg1Messager say: 12 1)
				else
					(gQg1Messager say: 12 1 1)
				)
			)
			(2 (gQg1Messager say: 12 2))
			(4 (gQg1Messager say: 12 4))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance glowCoals of Prop
	(properties
		x 240
		y 115
		noun 10
		view 314
		loop 4
		cel 1
	)
)

(instance fishBowl of Prop
	(properties
		x 308
		y 149
		noun 13
		view 314
		loop 3
		cel 2
	)
)

(instance burnSent of Prop
	(properties
		x 58
		y 123
		noun 24
		view 314
		loop 2
		priority 6
		signal $0010
	)
)

(instance magicFlash of Prop
	(properties
		x 295
		y 80
		view 314
		loop 5
		priority 15
		signal $0010
		cycleSpeed 8
	)
)

(instance zara of Prop
	(properties
		x 259
		y 100
		noun 28
		view 315
	)
	
	(method (init)
		(= global451 1315)
		(PalVary pvCHANGE_TARGET 1315)
		(super init:)
	)
)

(instance zaraTeller of Teller
	(properties)
	
	(method (doVerb theVerb)
		(return
			(switch theVerb
				(2
					(proc814_26 727 1)
					(super doVerb: theVerb &rest)
				)
				(10
					((= gNewList (List new:))
						add:
							((Clone Ware) name: {לחש תפיסה} price: {40})
							((Clone Ware) name: {לחש חץ להבה} price: {60})
							((Clone Ware) name: {לחש פתיחה} price: {30})
							((Clone Ware) name: {שיקוי רפואה} price: {50})
							((Clone Ware) name: {שיקוי כוח} price: {75})
							((Clone Ware) name: {שיקוי מרץ} price: {25})
					)
					(switch ((ScriptID 551 0) doit:)
						(-1 (gQg1Messager say: 28 10 7))
						(1
							(proc814_26 620 2 1)
							(localproc_00e7 24)
						)
						(2
							(proc814_26 622 2 1)
							(localproc_00e7 23)
						)
						(3
							(localproc_00e7 17)
							(proc814_26 621 2 1)
						)
						(4
							(= local0 1)
							(gQg1Messager say: 28 10 47)
							(gEgo setScript: cuedIt)
						)
						(5
							(= local0 2)
							(gQg1Messager say: 28 10 47)
							(gEgo setScript: cuedIt)
						)
						(6
							(= local0 3)
							(gQg1Messager say: 28 10 47)
							(gEgo setScript: cuedIt)
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

(instance firstScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo show: setCycle: Walk setMotion: MoveTo 91 176 self)
				(familiar init: stopUpd:)
				(glowCoals init: setCycle: Fwd)
				(fishBowl init: setCycle: Fwd)
				(burnSent init: setCycle: Fwd)
			)
			(1
				(gEgo loop: 6 cel: 0 posn: 91 176)
				(= cycles 4)
			)
			(2
				(proc0_3)
				(proc814_3)
				(self dispose:)
			)
		)
	)
)

(instance exitScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(theTeleport play:)
				(self cue:)
			)
			(1 (self cue:))
			(2
				(zara loop: 2 cel: 0 setCycle: End self)
			)
			(3
				(zara loop: 3 cel: 0 setCycle: End self)
			)
			(4
				(theThunder play:)
				(= ticks 20)
			)
			(5
				(gEgo setMotion: PolyPath 60 240 self)
				(zara dispose:)
			)
			(6
				(proc0_3)
				(global2 newRoom: 310)
			)
		)
	)
)

(instance egoExitScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setMotion: PolyPath 60 240 self)
			)
			(1
				(gEgo setMotion: PolyPath -20 (gEgo y?) self)
			)
			(2 (global2 newRoom: 310))
		)
	)
)

(instance familiarScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(familiar setCycle: End self)
			)
			(1
				(familiarFoot init:)
				(familiar setLoop: 7 posn: 200 61 cel: 0)
				(= local6 1)
				(if (> (gEgo x?) 170)
					(self cue:)
				else
					(familiar stopUpd:)
				)
			)
			(2
				(familiar setCycle: End self)
			)
			(3
				(familiar stopUpd:)
				(if (not local4)
					(magicFlash init: setCycle: CT 7 1 self)
				else
					(self cue:)
				)
			)
			(4
				(if (not local4)
					(theThunder number: (proc814_25 45) init: play:)
					(magicFlash init: setCycle: End self)
				else
					(self cue:)
				)
			)
			(5
				(magicFlash dispose:)
				(zara loop: 0 init: setCycle: End self)
				(= local4 1)
			)
			(6
				(familiar loop: 7 setCycle: Beg self)
			)
			(7
				(familiar stopUpd:)
				(if (not (proc0_7 93))
					(self cue:)
				else
					(= local2 1)
					(gQg1Messager say: 28 0 11 1 self)
				)
			)
			(8
				(if (== local2 0)
					(gQg1Messager say: 28 0 10 1 self)
				else
					(self cue:)
				)
				(= local2 1)
			)
			(9 (proc0_3) (self dispose:))
		)
	)
)

(instance lookAtRoom of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_2) (= ticks 30))
			(1
				(gQg1Messager say: 22 1 7 1 self)
			)
			(2
				(switch (++ local1)
					(1
						(gQg1Messager say: 22 1 7 2 self)
					)
					(2
						(gQg1Messager say: 22 1 7 3 self)
					)
					(3
						(gQg1Messager say: 22 1 7 4 self)
					)
					(4
						(gQg1Messager say: 22 1 7 5 self)
					)
					(5
						(gQg1Messager say: 22 1 7 6 self)
					)
					(6
						(gQg1Messager say: 22 1 7 7 self)
					)
					(7
						(gQg1Messager say: 22 1 7 8 self)
					)
					(8
						(gQg1Messager say: 22 1 7 9 self)
					)
					(9
						(gQg1Messager say: 22 1 7 10 self)
					)
				)
				(if (== local1 9) (= local1 0))
			)
			(3 (proc0_3) (self dispose:))
		)
	)
)

(instance cuedIt of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= ticks 60))
			(1
				(switch local0
					(1 (gEgo get: 12))
					(2 (gEgo get: 13))
					(3 (gEgo get: 14))
				)
				(self cue:)
			)
			(2 (self dispose:))
		)
	)
)

(instance shopMusic of Sound
	(properties
		flags $ffff
		number 67
		loop -1
	)
)

(instance theThunder of Sound
	(properties
		number 45
	)
)

(instance theTeleport of Sound
	(properties
		number 28
	)
)

(instance zaraTalker of Talker
	(properties
		x 10
		y 10
		view 1314
		talkWidth 260
		textX 15
		textY 110
	)
	
	(method (init)
		(= global451 2314)
		(PalVary pvCHANGE_TARGET 2314)
		(= font gFont)
		(super init: zaraBust zaraEye zaraMouth &rest)
	)
)

(instance zaraBust of Prop
	(properties
		view 1314
	)
)

(instance zaraMouth of Prop
	(properties
		nsTop 36
		nsLeft 45
		view 1314
		loop 1
	)
)

(instance zaraEye of Prop
	(properties
		nsTop 21
		nsLeft 44
		view 1314
		loop 2
	)
)
