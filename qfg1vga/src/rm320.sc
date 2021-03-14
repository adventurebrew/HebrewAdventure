;;; Sierra Script 1.0 - (do not remove this comment)
(script# 320)
(include sci.sh)
(use Main)
(use Teller)
(use Ware)
(use Door)
(use n814)
(use RTRandCycle)
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
	rm320 0
	hildeTalker 1
)

(local
	newProp
	local1
	local2
	local3
	[local4 2]
	[local6 6] = [0 -16 -11 -22 -8 999]
	[local12 7] = [0 12 14 13 15 10 999]
	[local19 6] = [0 12 14 13 15 999]
	[local25 7] = [0 7 9 19 17 21 999]
	[local32 4] = [0 18 20 999]
	[local36 8]
	[local44 6] = [0 -16 -11 -22 -8 999]
)
(instance rm320 of Rm
	(properties
		noun 7
		picture 320
	)
	
	(method (init)
		(self setRegions: 811 801)
		(= [local36 0] @local6)
		(= [local36 1] @local12)
		(= [local36 2] @local19)
		(= [local36 3] @local25)
		(= [local36 4] @local32)
		(= [local36 5] 999)
		(if (== gGModNum 330) (= style 12) else (= style 0))
		(super init:)
		(gEgo init: setScript: 0)
		(hildeTeller init: centaur @local6 @local36 @local44)
		(if (not global117)
			(centaur
				setPri: 6
				cycleSpeed: 1
				init:
				actions: hildeTeller
				approachVerbs: 4 10
				stopUpd:
			)
			(centaurBody
				setPri: 3
				init:
				actions: hildeTeller
				stopUpd:
				approachVerbs: 4 10
				addToPic:
			)
			(theApples setPri: 4 init: stopUpd: addToPic:)
			(scales setPri: 11 init: stopUpd: addToPic:)
			((= newProp (Prop new:))
				view: 325
				loop: 1
				cel: 0
				posn: 281 133
				setPri: (centaurBody priority?)
				init:
				actions: hildeTeller
				cycleSpeed: 1
				stopUpd:
				setScript: tailScript
			)
		)
		(= global111 0)
		(proc814_3)
		(switch gGModNum
			(0
				(gEgo posn: 226 182 setMotion: MoveTo 250 184)
			)
			(330
				(gEgo x: 21 setCycle: Walk setScript: comeIn)
			)
			(300
				(proc814_3)
				(gEgo posn: 275 250 setScript: comeFromTown)
			)
			(321
				(gEgo posn: 78 122 setMotion: PolyPath 40 170)
				(sheriffDoor close:)
			)
			(322
				(gEgo posn: 158 145 setScript: outOfStore)
			)
			(999
				(gEgo view: 515 setLoop: 3 cel: 5 setScript: egoWakes)
			)
			(else 
				(proc814_3)
				(gEgo posn: 275 188 setMotion: MoveTo 250 184)
			)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						0
						0
						319
						0
						319
						189
						298
						189
						159
						174
						160
						154
						124
						151
						102
						164
						48
						158
						59
						141
						80
						140
						80
						136
						43
						136
						42
						140
						55
						141
						43
						157
						0
						157
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 109 187 109 189 0 189 0 187
					yourself:
				)
		)
		(proc958_0 128 515 320 322 325)
		(if (and global117 [gStrength 9])
			(Load rsSOUND (proc814_25 35))
		)
		(gNewFeatures
			add:
				onBarrels
				sky
				leftFence
				rightFence
				roundStones
				squareStones
				aWindow
				rtWindow
				onSheriffHouse
				onStand
				onStable
				onGoodsStore
			eachElementDo: #init
		)
		(storeDoor
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
			locked: (if global117 1 else 0)
		)
		(sheriffDoor
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
			locked: 1
		)
		(if (not (gEgo script?)) (proc0_3))
	)
	
	(method (doit)
		(cond 
			(
				(and
					(< (gEgo x?) 3)
					(not (== (gEgo script?) comeIn))
					(not (== (gEgo script?) to330))
				)
				(= global110 0)
				(= style 11)
				(gEgo setScript: to330)
			)
			(
				(and
					(> (gEgo y?) 188)
					(not (== (gEgo script?) comeFromTown))
					(not (== (gEgo script?) backToTown))
					(not (== (centaur script?) centaurScript))
				)
				(= global110 0)
				(gEgo setScript: backToTown)
			)
			((gEgo script?) 0)
			(
			(and (not (gEgo inRect: 210 130 319 185)) local1) (= local1 0))
		)
		(super doit:)
	)
	
	(method (dispose)
		(= global451 0)
		(proc0_5 94)
		(super dispose:)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gQg1Messager say: 7 0 0 1))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (notify param1)
		(cond 
			((!= param1 1))
			((not (sheriffDoor locked?)) (self setScript: inToSheriff))
			((not (proc814_15 9 50 global175)) (gQg1Messager say: 7 0 0 3))
			((and (proc0_7 95) (< global107 global118)) (gQg1Messager say: 7 0 0 4))
			(else
				(lockSound number: (proc814_25 35) init: play:)
				(gQg1Messager say: 7 0 0 5)
				(sheriffDoor locked: 0)
				(self setScript: inToSheriff)
			)
		)
	)
)

(instance sky of Feature
	(properties
		x 279
		y 122
		z 112
		noun 9
		nsLeft 240
		nsBottom 20
		nsRight 318
		sightAngle 40
	)
)

(instance leftFence of Feature
	(properties
		x 22
		y 144
		z 14
		noun 4
		nsTop 115
		nsLeft 1
		nsBottom 146
		nsRight 43
		sightAngle 40
	)
)

(instance rightFence of Feature
	(properties
		x 90
		y 149
		z 14
		noun 4
		nsTop 126
		nsLeft 70
		nsBottom 145
		nsRight 110
		sightAngle 40
	)
)

(instance roundStones of Feature
	(properties
		x 152
		y 151
		noun 12
		nsTop 144
		nsLeft 137
		nsBottom 158
		nsRight 168
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gQg1Messager say: 12 0 0 1))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance squareStones of Feature
	(properties
		x 56
		y 139
		noun 12
		nsTop 132
		nsLeft 45
		nsBottom 147
		nsRight 68
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gQg1Messager say: 12 0 0 2))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance aWindow of Feature
	(properties
		x 41
		y 121
		z 41
		noun 14
		nsTop 67
		nsLeft 29
		nsBottom 94
		nsRight 53
		sightAngle 40
	)
)

(instance rtWindow of Feature
	(properties
		x 106
		y 127
		z 40
		noun 14
		nsTop 74
		nsLeft 99
		nsBottom 100
		nsRight 114
		sightAngle 40
	)
)

(instance onGoodsStore of Feature
	(properties
		y 36
		noun 13
		nsTop 9
		nsLeft 99
		nsBottom 135
		nsRight 212
		sightAngle 40
		onMeCheck $0002
	)
)

(instance onSheriffHouse of Feature
	(properties
		y 36
		noun 6
		nsTop 3
		nsLeft 2
		nsBottom 114
		nsRight 95
		sightAngle 40
		onMeCheck $0004
	)
)

(instance onStable of Feature
	(properties
		x 278
		y 94
		noun 10
		nsTop 36
		nsLeft 237
		nsBottom 153
		nsRight 319
		sightAngle 40
		onMeCheck $0010
	)
)

(instance onBarrels of Feature
	(properties
		x 247
		y 160
		noun 2
		nsTop 135
		nsLeft 177
		nsBottom 185
		nsRight 317
		sightAngle 40
		onMeCheck $0008
	)
)

(instance onStand of Feature
	(properties
		noun 11
		sightAngle 40
		onMeCheck $0080
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (>= global119 4)
					(gQg1Messager say: 11 0 1)
				else
					(gQg1Messager say: 11 0 0 1)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance storeDoor of Door
	(properties
		x 170
		y 146
		noun 3
		approachX 160
		approachY 156
		view 320
		priority 9
		entranceTo 322
		facingLoop 3
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if global117
					(gQg1Messager say: 3 0 0 3)
				else
					(gQg1Messager say: 3 0 0 2)
				)
			)
			(4
				(if global117
					(gQg1Messager say: 3 0 1 2)
				else
					(global2 setScript: enterToStore)
				)
			)
			(17
				((ScriptID 811 0) doVerb: theVerb)
			)
			(18
				((ScriptID 811 0) doVerb: theVerb)
			)
			(16
				(gQg1Messager say: 3 16 0 1)
			)
			(26
				(gQg1Messager say: 3 26 0 1)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sheriffDoor of Door
	(properties
		x 89
		y 127
		noun 3
		approachX 75
		approachY 136
		view 320
		loop 1
		priority 9
		entranceTo 321
		facingLoop 3
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (< global119 4)
					(gQg1Messager say: 3 0 1 4)
				else
					(gQg1Messager say: 3 0 1 3)
				)
			)
			(4
				(if (< global119 4)
					(gQg1Messager say: 3 0 1 2)
				else
					(gQg1Messager say: 3 0 0 1)
				)
			)
			(17
				((ScriptID 811 0) doVerb: theVerb)
			)
			(18
				((ScriptID 811 0) doVerb: theVerb)
			)
			(16
				(gQg1Messager say: 3 16 0 1)
			)
			(26
				(gQg1Messager say: 3 26 0 1)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theApples of View
	(properties
		x 230
		y 159
		noun 1
		view 320
		loop 4
	)
)

(instance scales of View
	(properties
		x 233
		y 89
		noun 8
		view 320
		loop 5
	)
)

(instance centaurBody of Prop
	(properties
		x 272
		y 141
		noun 5
		approachX 228
		approachY 186
		view 325
	)
	
	(method (init)
		(super init:)
	)
	
	(method (doVerb theVerb)
		(centaur doVerb: theVerb &rest)
	)
)

(instance hildeTeller of Teller
	(properties)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gQg1Messager say: 5 0 0 2))
			(4 (gQg1Messager say: 5 4))
			(2
				(proc814_26 729 1)
				(super doVerb: theVerb &rest)
			)
			(10
				((= gNewList (List new:))
					add:
						((Clone Ware) name: {תפוחים} price: {1})
						((Clone Ware) name: {ירקות} price: {1})
				)
				(switch ((ScriptID 551 0) doit:)
					(-1 (gQg1Messager say: 7 0 23))
					(1
						(proc814_26 728 3)
						(gEgo setScript: buyFruit)
					)
					(2
						(proc814_26 728 3)
						(gEgo setScript: buyVeg)
					)
				)
			)
			(36 (gQg1Messager say: 5 36))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
		(return 1)
	)
)

(instance centaur of Prop
	(properties
		x 268
		y 136
		noun 5
		approachX 228
		approachY 186
		view 325
		loop 2
	)
	
	(method (init)
		(super init:)
		(self setScript: centaurScript)
	)
)

(instance lockSound of Sound
	(properties
		number 35
	)
)

(instance tailScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles (Random 40 100)))
			(1
				(newProp setCycle: End)
				(= state -1)
			)
		)
	)
)

(instance centaurScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_2) (= seconds 3))
			(1
				(if (not (proc0_7 94))
					(User canControl: 0)
					(gQg1Messager say: 7 0 24 0 self)
				else
					(= cycles 2)
				)
			)
			(2
				(if (not (proc0_7 94))
					(gQg1Messager say: 5 0 0 3 self)
					(User canControl: 1)
					(= local1 1)
				else
					(= ticks 30)
				)
			)
			(3
				(if (not (gEgo script?)) (proc0_3))
				(self dispose:)
			)
		)
	)
)

(instance egoWakes of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 7))
			(1
				(proc0_2)
				(gEgo setCycle: Beg self)
			)
			(2
				(proc814_3)
				(gQg1Messager say: 7 0 0 11 self)
			)
			(3
				(if local3
					(gQg1Messager say: 5 0 5 17 self)
				else
					(self cue:)
				)
			)
			(4
				(proc0_3)
				((gDropInv at: 0) amount: 1)
				((gDropInv at: 38) amount: 0)
				(gEgo use: 0 1)
				(= ticks 30)
			)
			(5 (self dispose:))
		)
	)
)

(instance to330 of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setMotion: MoveTo -20 (gEgo y?) self)
			)
			(1 (global2 newRoom: 330))
		)
	)
)

(instance backToTown of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setMotion: MoveTo (gEgo x?) 275 self)
			)
			(1 (global2 newRoom: 300))
		)
	)
)

(instance comeIn of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setMotion: MoveTo 45 174 self)
			)
			(1 (= seconds 1))
			(2
				(proc814_3)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance enterToStore of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(storeDoor setCycle: End self)
			)
			(1
				(gEgo setMotion: PolyPath 167 140 self)
			)
			(2 (global2 newRoom: 322))
		)
	)
)

(instance inToSheriff of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(sheriffDoor setCycle: End self)
			)
			(1
				(gEgo setMotion: MoveTo 89 120 self)
			)
			(2 (global2 newRoom: 321))
		)
	)
)

(instance outOfStore of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setMotion: MoveTo 158 170 self)
			)
			(1
				(storeDoor close:)
				(= ticks 30)
			)
			(2 (proc0_3) (self dispose:))
		)
	)
)

(instance comeFromTown of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setMotion: MoveTo 250 184 self)
			)
			(1 (= seconds 1))
			(2 (proc0_3) (self dispose:))
		)
	)
)

(instance buyFruit of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gQg1Messager say: 7 0 26 1 self)
			)
			(1
				(proc0_3)
				(gEgo get: 22 10)
				(= ticks 30)
			)
			(2 (self dispose:))
		)
	)
)

(instance buyVeg of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gQg1Messager say: 7 0 25 1 self)
			)
			(1
				(proc0_3)
				(gEgo get: 23 5)
				(= ticks 30)
			)
			(2 (self dispose:))
		)
	)
)

(instance hildeTalker of Talker
	(properties
		x 10
		y 10
		view 1320
		talkWidth 260
		textX 15
		textY 110
	)
	
	(method (init)
		(= global451 2320)
		(PalVary pvCHANGE_TARGET 2320)
		(kernel_128 1320)
		(= font gFont)
		(super init: hildeBust hildeEye hildeMouth &rest)
	)
)

(instance hildeBust of Prop
	(properties
		view 1320
	)
)

(instance hildeMouth of Prop
	(properties
		nsTop 43
		nsLeft 41
		view 1320
		loop 1
	)
)

(instance hildeEye of Prop
	(properties
		nsTop 30
		nsLeft 36
		view 1320
		loop 2
	)
)
