;;; Sierra Script 1.0 - (do not remove this comment)
(script# 322)
(include sci.sh)
(use Main)
(use Teller)
(use Ware)
(use n814)
(use RTRandCycle)
(use Polygon)
(use CueObj)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	rm322 0
	shopKeeperTalker 1
)

(local
	local0
	local1
	local2
	local3
	[local4 2]
	local6
	local7
	[local8 8] = [0 14 -6 -10 8 15 13 999]
	[local16 3] = [0 7 999]
	[local19 6] = [0 9 5 12 11 999]
	[local25 10]
	[local35 4] = [0 -6 -10 999]
)
(instance rm322 of Rm
	(properties
		noun 9
		picture 322
		style $0008
	)
	
	(method (init)
		(= [local25 0] @local8)
		(= [local25 1] @local16)
		(= [local25 2] @local19)
		(= [local25 3] 999)
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
						302
						189
						265
						168
						248
						167
						223
						158
						219
						150
						61
						150
						65
						167
						47
						169
						41
						174
						44
						181
						45
						189
						0
						189
					yourself:
				)
		)
		(Load rsVIEW 322)
		(super init:)
		(self
			setFeatures:
				woodenPole
				onBarrels
				onTeaPot
				onPole
				onWindow
				onSword
				onShield
				onEquipment
				onOddsNEnds
				onDrygoods
				onClothes1
				onClothes2
				onSack
				onTorch1
				onTorch2
				onRolledUpItems
				onCape
		)
		(if global117 (theWindow init:))
		(self setRegions: 801)
		(gLongSong priority: 0 number: 93 loop: -1 play:)
		(shopTeller init: proprietor @local8 @local25 @local35)
		(proprietor actions: shopTeller init:)
		(stove init: setCycle: Fwd)
		(gEgo loop: 3 posn: 163 188 init: setScript: enterTheShop)
	)
	
	(method (doit)
		(cond 
			((and (<= (gEgo y?) 155) (not local0)) (= local0 1))
			((and (> (gEgo y?) 155) local0)
				(= local0 0)
				(if local2 (= local2 0))
				(if (and local1 local3)
					(proprietor setCycle: Beg)
					(= local3 0)
				)
			)
			((and (> (gEgo y?) 187) (not (gEgo script?))) (gEgo setScript: outTo320))
		)
		(super doit:)
	)
	
	(method (dispose)
		(= global451 0)
		(proc0_5 96)
		(super dispose:)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gQg1Messager say: 9 1 2))
			(10 (gQg1Messager say: 9 10))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (cue)
		(switch local7
			(1 (gQg1Messager say: 14 10 16))
		)
	)
)

(instance woodenPole of Feature
	(properties
		x 305
		y 161
		z 26
		noun 8
		nsTop 114
		nsLeft 294
		nsBottom 156
		nsRight 316
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (gQg1Messager say: 9 4))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance onPole of Feature
	(properties
		x 42
		y 133
		noun 7
		nsTop 103
		nsLeft 32
		nsBottom 163
		nsRight 53
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (gQg1Messager say: 9 4))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance onTeaPot of Feature
	(properties
		x 123
		y 151
		z 38
		noun 17
		nsTop 108
		nsLeft 118
		nsBottom 119
		nsRight 129
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (gQg1Messager say: 9 4))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance onBarrels of Feature
	(properties
		x 260
		y 139
		noun 13
		nsTop 127
		nsLeft 233
		nsBottom 151
		nsRight 288
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (gQg1Messager say: 9 4))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance onWindow of Feature
	(properties
		x 266
		y 153
		z 79
		noun 18
		nsTop 61
		nsLeft 245
		nsBottom 87
		nsRight 287
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if global117
					(gQg1Messager say: 18 1 20)
				else
					(gQg1Messager say: 18 1)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance onSword of Feature
	(properties
		x 42
		y 143
		z 70
		noun 16
		nsTop 55
		nsLeft 38
		nsBottom 92
		nsRight 47
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (gQg1Messager say: 9 4))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance onShield of Feature
	(properties
		x 116
		y 149
		z 104
		noun 12
		nsTop 33
		nsLeft 88
		nsBottom 57
		nsRight 145
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (gQg1Messager say: 9 4))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance onEquipment of Feature
	(properties
		x 176
		y 144
		z 64
		noun 3
		nsTop 59
		nsLeft 161
		nsBottom 101
		nsRight 192
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (gQg1Messager say: 9 4))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance onOddsNEnds of Feature
	(properties
		x 84
		y 131
		z 45
		noun 4
		nsTop 58
		nsLeft 64
		nsBottom 115
		nsRight 105
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (gQg1Messager say: 9 4))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance onDrygoods of Feature
	(properties
		x 132
		y 102
		noun 6
		nsTop 58
		nsLeft 107
		nsBottom 102
		nsRight 158
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (gQg1Messager say: 9 4))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance onTorch1 of Feature
	(properties
		x 82
		y 121
		z 70
		nsTop 46
		nsLeft 73
		nsBottom 56
		nsRight 91
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(onDrygoods doVerb: theVerb &rest)
	)
)

(instance onTorch2 of Feature
	(properties
		x 174
		y 124
		z 72
		nsTop 47
		nsLeft 159
		nsBottom 57
		nsRight 189
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(onDrygoods doVerb: theVerb &rest)
	)
)

(instance onSack of Feature
	(properties
		x 21
		y 160
		noun 11
		nsTop 138
		nsLeft 11
		nsBottom 183
		nsRight 32
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (gQg1Messager say: 9 4))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance onClothes1 of Feature
	(properties
		x 13
		y 162
		z 78
		noun 1
		nsTop 56
		nsBottom 113
		nsRight 26
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (gQg1Messager say: 9 4))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance onClothes2 of Feature
	(properties
		x 307
		y 166
		z 84
		noun 2
		nsTop 58
		nsLeft 295
		nsBottom 107
		nsRight 319
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (gQg1Messager say: 9 4))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance onRolledUpItems of Feature
	(properties
		x 221
		y 134
		z 41
		noun 10
		nsTop 71
		nsLeft 200
		nsBottom 115
		nsRight 242
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (gQg1Messager say: 9 4))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance onCape of Feature
	(properties
		x 193
		y 130
		noun 5
		nsTop 116
		nsLeft 176
		nsBottom 145
		nsRight 211
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (gQg1Messager say: 9 4))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theWindow of View
	(properties
		x 288
		y 89
		noun 18
		view 322
		loop 6
		signal $0001
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if global117
					(gQg1Messager say: 18 1 20)
				else
					(gQg1Messager say: 18 1)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stove of Prop
	(properties
		x 306
		y 166
		noun 15
		view 322
	)
	
	(method (init)
		(= global451 1322)
		(PalVary pvCHANGE_TARGET 1322)
		(kernel_128 322)
		(super init:)
	)
)

(instance proprietor of Prop
	(properties
		x 151
		y 119
		noun 14
		view 322
		loop 4
	)
	
	(method (init)
		(PalVary pvCHANGE_TARGET 1322)
		(kernel_128 322)
		(super init:)
	)
	
	(method (doit)
		(if (and local0 local1 (not local3))
			(self setCycle: End)
			(= local3 1)
		)
		(super doit:)
	)
)

(instance shopTeller of Teller
	(properties)
	
	(method (doVerb theVerb)
		(return
			(switch theVerb
				(1
					(gQg1Messager say: 14 1)
					(return 1)
				)
				(2
					(if (not local0)
						(gQg1Messager say: 14 1 19)
					else
						(= local6 1)
						(proc814_26 730 1)
						(super doVerb: theVerb &rest)
					)
					(return 1)
				)
				(10
					((= gNewList (List new:))
						add:
							((Clone Ware) name: {בקבוקון} price: {2})
							((Clone Ware) name: {אוכל} price: {5})
							((Clone Ware) name: {פגיון} price: {20})
							((Clone Ware) name: {שריון} price: {500})
					)
					(switch ((ScriptID 551 0) doit:)
						(-1
							(gQg1Messager say: 14 10 18)
						)
						(1
							(proc0_5 120)
							(gEgo setScript: buyFlask)
						)
						(2
							(proc0_5 120)
							(gEgo setScript: buyFood)
						)
						(3
							(proc0_5 120)
							(gEgo setScript: buyDagger)
						)
						(4
							(proc814_26 610 3 0)
							(proc0_5 120)
							(gEgo setScript: buyArmor)
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

(instance buyFlask of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gQg1Messager say: 14 10 16 1 self)
			)
			(1
				(proc0_3)
				(gEgo get: 11 1)
				(self cue:)
			)
			(2 (proc0_3) (self dispose:))
		)
	)
)

(instance buyFood of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gQg1Messager say: 14 10 16 1 self)
			)
			(1
				(proc0_3)
				(gEgo get: 1 10)
				(self cue:)
			)
			(2 (proc0_3) (self dispose:))
		)
	)
)

(instance buyDagger of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gQg1Messager say: 14 10 16 1 self)
			)
			(1
				(proc0_3)
				(gEgo get: 6 1)
				(self cue:)
			)
			(2 (proc0_3) (self dispose:))
		)
	)
)

(instance buyArmor of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(if (gEgo has: 4)
					(gQg1Messager say: 14 10 17 1 self)
				else
					(self cue:)
				)
			)
			(1
				(if (gEgo has: 4)
					(gEgo use: 4)
					(gEgo get: 0 50)
					(= ticks 30)
				else
					(self cue:)
				)
			)
			(2
				(gQg1Messager say: 14 10 16 1 self)
			)
			(3
				(proc0_3)
				(gEgo get: 3 1)
				(self cue:)
			)
			(4 (self dispose:))
		)
	)
)

(instance proprietorScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proprietor cycleSpeed: 1 stopUpd:)
				(= ticks 60)
			)
			(1
				(proprietor setCycle: End self)
				(= local3 1)
			)
			(2
				(= local1 1)
				(= local2 1)
				(gQg1Messager say: 14 0 3 1 self)
			)
			(3 (proc0_5 119) (= ticks 10))
			(4
				(gQg1Messager say: 14 0 4)
				(self cue:)
			)
			(5 (self cue:))
			(6 (self dispose:) (proc0_3))
		)
	)
)

(instance secondEntrance of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proprietor cycleSpeed: 1 stopUpd:)
				(= ticks 60)
			)
			(1
				(proprietor setCycle: End self)
				(= local3 1)
			)
			(2
				(= local1 1)
				(= local2 1)
				(gQg1Messager say: 14 0 3 1 self)
			)
			(3 (self dispose:) (proc0_3))
		)
	)
)

(instance enterTheShop of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setMotion: MoveTo 163 155 self)
			)
			(1 (proc814_3) (= cycles 6))
			(2
				(if (proc0_7 96)
					(self cue:)
				else
					(gQg1Messager say: 9 0 1 1 self)
				)
			)
			(3
				(if (proc0_7 96)
					(gEgo setScript: secondEntrance)
				else
					(gEgo setScript: proprietorScript)
				)
			)
		)
	)
)

(instance outTo320 of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setMotion: MoveTo (gEgo x?) 240 self)
			)
			(1 (global2 newRoom: 320))
		)
	)
)

(instance shopKeeperTalker of Talker
	(properties
		x 10
		y 10
		view 1322
		talkWidth 260
		textX 15
		textY 110
	)
	
	(method (init)
		(= global451 2322)
		(PalVary pvCHANGE_TARGET 2322)
		(kernel_128 1322)
		(= font gFont)
		(super init: shopBust shopEye shopMouth &rest)
	)
	
	(method (dispose)
		(super dispose:)
	)
)

(instance shopBust of Prop
	(properties
		view 1322
	)
)

(instance shopMouth of Prop
	(properties
		nsTop 50
		nsLeft 31
		view 1322
		loop 1
	)
)

(instance shopEye of Prop
	(properties
		nsTop 35
		nsLeft 30
		view 1322
		loop 2
	)
)
