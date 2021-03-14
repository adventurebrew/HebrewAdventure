;;; Sierra Script 1.0 - (do not remove this comment)
(script# 65)
(include sci.sh)
(use Main)
(use Teller)
(use Ware)
(use TargActor)
(use n814)
(use RTRandCycle)
(use Polygon)
(use CueObj)
(use n958)
(use DPath)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	rm65 0
	bruno65Talker 1
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
	local10
	local11
	local12
	local13
	local14
	gEgoMoveSpeed
	gEgoCycleSpeed
	[local17 9] = [0 21 9 10 -20 -19 18 -17 999]
	[local26 9] = [0 13 23 14 24 22 15 -11 999]
	[local35 6] = [0 8 16 25 -12 999]
	[local41 11]
	[local52 4] = [0 -20 -17 999]
)
(procedure (localproc_00ae)
	(if (global2 obstacles?)
		((global2 obstacles?) dispose:)
		(global2 obstacles: 0)
	)
	(global2
		addObstacle:
			((Polygon new:)
				type: 2
				init:
					102
					157
					102
					189
					0
					189
					0
					0
					319
					0
					319
					108
					234
					104
					262
					41
					239
					41
					189
					86
					123
					83
					97
					96
					83
					95
					27
					125
				yourself:
			)
			((Polygon new:)
				type: 2
				init: 173 189 203 144 319 134 319 189
				yourself:
			)
	)
)

(instance rm65 of Rm
	(properties
		noun 4
		picture 65
		style $0008
	)
	
	(method (init)
		(= [local41 0] @local17)
		(= [local41 1] @local35)
		(= [local41 2] @local26)
		(= [local41 3] 999)
		(self
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						30
						90
						8
						98
						102
						157
						102
						189
						0
						189
						0
						0
						319
						0
						319
						108
						234
						104
						262
						41
						239
						41
						189
						86
						123
						83
						97
						96
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 173 189 203 144 319 134 319 189
					yourself:
				)
		)
		(proc958_0 128 65 165 1074)
		(Load rsSCRIPT 964)
		(super init: &rest)
		(if global117
			(proc0_6 293)
			(townGate cel: 0)
			(gOldATPs add: townGate eachElementDo: #init doit:)
		else
			(proc0_5 293)
			(onTownGate init:)
		)
		(self
			setFeatures: rock onTheWall onTownSign deadSquare onTheRoad onTheWhat
		)
		(= local5 0)
		(if
			(and
				(proc0_7 199)
				(or (== global119 2) (== global119 3))
				(or (not (proc0_7 161)) (proc0_7 235))
			)
			(Load rsVIEW 516)
			(brunoTeller init: bruno @local17 @local41 @local52)
			(bruno
				init:
				actions: brunoTeller
				setScript: brunoFlippingDagger
			)
		)
		(proc814_3)
		(gEgo init:)
		(if (not (proc0_7 293)) (gEgo illegalBits: -32640))
		(switch gGModNum
			(74
				(gEgo posn: 160 188 setScript: comeFromSouth)
			)
			(54
				(gEgo posn: 232 64 setMotion: MoveTo 220 83)
			)
			(66
				(gEgo posn: 318 140 setScript: comeFromEast)
			)
			(320
				(gEgo posn: 140 91 setHeading: 100)
			)
			(300
				(if (not (proc0_7 293))
					(proc0_3)
					(gEgo posn: 90 101 setHeading: 100)
				else
					(proc0_2)
					(gEgo posn: 31 91 setHeading: 100)
					(global2 setScript: sExitFromTown)
				)
			)
			(else 
				(proc0_3)
				(gEgo posn: 265 140)
			)
		)
	)
	
	(method (doit)
		(if (> global119 3) (localproc_00ae))
		(cond 
			(script)
			((and (< (gEgo y?) 47) (not (gEgo script?))) (global2 setScript: goToHealer))
			((and (> (gEgo y?) 187) (not (gEgo script?))) (global2 setScript: goSouth))
			((and (> (gEgo x?) 317) (not (gEgo script?))) (global2 setScript: goEast))
			(
			(and (& (gEgo onControl: 1) $0004) (proc0_7 293)) (proc0_2) (global2 setScript: goToTown))
		)
		(super doit:)
	)
	
	(method (dispose)
		(= global451 0)
		(proc0_5 55)
		(DisposeScript 964)
		(super dispose:)
	)
	
	(method (doVerb theVerb)
		(cond 
			((== theVerb 1) (= local14 1) (gQg1Messager say: 4 1 0 0 global2))
			((proc999_5 theVerb 51 50 77 78 80 81 82 79)
				(if (gNewCast contains: bruno)
					(= local10 1)
					(bruno setScript: knifeEgo)
				else
					(proc814_33 theVerb)
				)
			)
			(else (super doVerb: theVerb &rest))
		)
	)
	
	(method (cue)
		(switch local14
			(1
				(if global117
					(gQg1Messager say: 4 1 43)
				else
					(gQg1Messager say: 4 1 38)
				)
			)
		)
	)
)

(instance rock of Feature
	(properties
		x 181
		y 75
		z 6
		noun 6
		nsTop 64
		nsLeft 167
		nsBottom 75
		nsRight 196
		sightAngle 40
	)
)

(instance onTownGate of Feature
	(properties
		x 51
		y 58
		noun 3
		nsTop 8
		nsLeft 18
		nsBottom 109
		nsRight 84
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (not (proc0_7 293))
					(gQg1Messager say: 3 1 39)
				else
					(gQg1Messager say: 3 1 38)
				)
			)
			(4 (gQg1Messager say: 3 4))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance onTownSign of Feature
	(properties
		x 278
		y 150
		noun 7
		nsTop 114
		nsLeft 241
		nsBottom 187
		nsRight 316
		sightAngle 40
		onMeCheck $0008
	)
)

(instance onTheWall of Feature
	(properties
		x 118
		y 12
		noun 9
		nsBottom 75
		nsRight 236
		sightAngle 40
		onMeCheck $0002
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gQg1Messager say: 9 1))
			(4
				(if (>= global119 4)
					(gEgo setScript: climbTheWall)
				else
					(gQg1Messager say: 9 4)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance onTheWhat of Feature
	(properties
		x 118
		y 180
		noun 10
		sightAngle 40
		onMeCheck $0020
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 1)
			(switch (Random 1 6)
				(1 (gQg1Messager say: 10 1 47))
				(2 (gQg1Messager say: 10 1 50))
				(3 (gQg1Messager say: 10 1 49))
				(4 (gQg1Messager say: 10 1 46))
				(5 (gQg1Messager say: 10 1 45))
				(6 (gQg1Messager say: 10 1 48))
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance onTheRoad of Feature
	(properties
		x 118
		y 20
		noun 5
		sightAngle 40
		onMeCheck $0040
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 1)
			(switch (++ local13)
				(1 (gQg1Messager say: 5 1 47))
				(2 (gQg1Messager say: 5 1 50))
				(3 (gQg1Messager say: 5 1 49))
				(4 (gQg1Messager say: 5 1 46))
				(5 (gQg1Messager say: 5 1 45))
				(6 (gQg1Messager say: 5 1 48))
			)
			(if (== local13 7) (= local13 0))
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance deadSquare of Feature
	(properties
		x 117
		y 74
		noun 2
		onMeCheck $0010
	)
)

(instance townGate of View
	(properties
		x 20
		y 114
		noun 8
		view 165
		loop 1
		priority 4
		signal $4011
	)
)

(instance knife1 of Actor
	(properties
		view 65
		loop 6
	)
)

(instance knife2 of Actor
	(properties
		view 65
		loop 7
	)
)

(instance bruno of TargActor
	(properties
		x 99
		y 89
		noun 1
		approachX 94
		approachY 104
		view 65
	)
	
	(method (doit)
		(cond 
			((== script knifeEgo) 0)
			(
				(and
					local4
					(or
						(gEgo inRect: 212 53 256 68)
						(gEgo inRect: 283 107 319 130)
						(gEgo inRect: 123 171 172 188)
					)
				)
				(self setScript: knifeEgo)
			)
		)
		(super doit:)
	)
)

(instance brunoTeller of Teller
	(properties)
	
	(method (showDialog)
		(super
			showDialog: -17 local2 -19 local2 -12 local3 -11 local1
		)
	)
	
	(method (doChild)
		(if (== query -19) (proc0_5 356))
		(return
			(if
				(not
					(if (or (== query -19) (== query -11))
					else
						(== query -12)
					)
				)
				(super doChild: query)
			else
				(return 1)
			)
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (== local12 0)
					(gQg1Messager say: 1 1 29)
					(= local12 1)
				else
					(gQg1Messager say: 1 1 30)
				)
			)
			(2
				(cond 
					((not local9) (= local7 1) (gQg1Messager say: 1 2 33))
					(local7
						(switch (= local8 (Random 1 2))
							(1 (gQg1Messager say: 1 2 36))
							(2 (gQg1Messager say: 1 2 36))
						)
					)
					(else (super doVerb: theVerb &rest))
				)
			)
			(4
				(cond 
					((== local11 0) (gQg1Messager say: 1 4 27) (= local11 1))
					(
						(or
							(gEgo inRect: 212 53 256 68)
							(gEgo inRect: 283 107 319 130)
							(gEgo inRect: 123 171 172 188)
						)
						(bruno setScript: knifeEgo)
					)
					(else
						(if (gEgo inRect: 93 76 125 100)
							(bruno setScript: whiner)
						else
							(gQg1Messager say: 1 4 28)
						)
						(= local4 1)
					)
				)
			)
			(16 (bruno setScript: knifeEgo))
			(10
				(gEgo setMotion: MoveTo 92 104)
				((= gNewList (List new:))
					add:
						((Clone Ware) name: {מטבע כסף אחת} price: {1})
						((Clone Ware) name: {שתי מטבעות כסף} price: {2})
						((Clone Ware) name: {שתי מטבעות זהב} price: {20})
						((Clone Ware) name: {עשר מטבעות זהב} price: {100})
				)
				(switch ((ScriptID 551 0) doit:)
					(-1
						(proc0_2)
						(gQg1Messager say: 1 10 31)
					)
					(1
						(proc0_2)
						(= local6 1)
						(= local0 1)
						(= local9 1)
						(= local7 0)
						(gQg1Messager say: 1 10 32)
					)
					(2
						(proc0_2)
						(= local9 1)
						(= local7 0)
						(= local6 1)
						(= local0 1)
						(= local1 1)
						(gQg1Messager say: 1 10 9)
					)
					(3
						(proc0_2)
						(= local9 1)
						(= local7 0)
						(= local6 1)
						(= local0 1)
						(= local1 1)
						(= local2 1)
						(gQg1Messager say: 1 10 9)
					)
					(4
						(proc0_2)
						(= local9 1)
						(= local7 0)
						(= local6 1)
						(= local0 1)
						(= local1 1)
						(= local2 1)
						(= local3 1)
						(gQg1Messager say: 1 10 9)
					)
				)
				(proc0_3)
			)
			(else 
				(if (== theVerb 81)
					(global2 doVerb: theVerb &rest)
				else
					(super doVerb: theVerb &rest)
				)
			)
		)
		(return 1)
	)
)

(instance brunoFlippingDagger of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(bruno setLoop: 4 cel: 0 setCycle: Fwd)
				(= seconds (Random 1 3))
			)
			(1
				(bruno setCycle: End)
				(= seconds (Random 2 6))
			)
			(2 (self changeState: 0))
		)
	)
)

(instance knifeEgo of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setMotion: 0)
				(bruno setLoop: 5 cel: 0 setCycle: CT 3 1 self)
			)
			(1
				(knife1
					setLoop: 7
					illegalBits: 0
					ignoreActors:
					ignoreHorizon:
					xStep: 6
					yStep: 7
					init:
					setCycle: Fwd
					posn: (+ (bruno x?) 41) (- (bruno y?) 24)
					setMotion: MoveTo (gEgo x?) (- (gEgo y?) 22)
				)
				(bruno setCycle: CT 5 1 self)
			)
			(2 (= ticks (Random 30 90)))
			(3
				(bruno setCel: 0 setCycle: End self)
			)
			(4
				(knife2
					setLoop: 7
					illegalBits: 0
					ignoreActors:
					ignoreHorizon:
					xStep: 6
					yStep: 7
					init:
					setCycle: Fwd
					posn: (+ (bruno x?) 41) (- (bruno y?) 27)
					setMotion: MoveTo (gEgo x?) (- (gEgo y?) 25) self
				)
			)
			(5
				(knife1 dispose:)
				(knife2 dispose:)
				(gEgo
					view: 516
					posn: (- (gEgo x?) 7) (- (gEgo y?) 7)
					setLoop: 1
					setMotion: 0
					setCycle: End self
				)
			)
			(6 (= seconds 3))
			(7
				(if local10
					(proc814_0 153 154 2 5 517)
				else
					(proc814_0 104 105 2 5 517)
				)
			)
		)
	)
)

(instance whiner of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(bruno setCycle: End)
				(= local5 (Random 1 7))
				(self cue:)
			)
			(1
				(if (not (gEgo inRect: 93 76 125 100))
					(self dispose:)
				else
					(self cue:)
				)
			)
			(2
				(switch local5
					(1
						(gQg1Messager say: 1 0 4 1 self)
					)
					(2
						(gQg1Messager say: 1 0 7 1 self)
					)
					(3
						(gQg1Messager say: 1 0 6 1 self)
					)
					(4
						(gQg1Messager say: 1 0 3 1 self)
					)
					(5
						(gQg1Messager say: 1 0 2 1 self)
					)
					(6
						(gQg1Messager say: 1 0 5 1 self)
					)
					(7
						(gQg1Messager say: 1 4 26 1 self)
					)
				)
			)
			(3 (self dispose:))
		)
	)
)

(instance sExitFromTown of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (proc0_7 191))
					(proc0_5 191)
					(++ state)
					(self cue:)
				else
					(gEgo setMotion: MoveTo 120 114 self)
					(proc0_5 199)
				)
			)
			(1 (proc0_3) (self dispose:))
			(2
				(gLongSong number: 22 loop: 1 priority: 0 play:)
				(proc814_26 684 1)
				(gEgo setMotion: MoveTo 75 114 self)
			)
			(3
				(gQg1Messager say: 4 0 42 1 self)
			)
			(4 (proc0_3) (self dispose:))
		)
	)
)

(instance climbTheWall of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(= gEgoMoveSpeed (gEgo moveSpeed?))
				(= gEgoCycleSpeed (gEgo cycleSpeed?))
				(gEgo
					moveSpeed: 6
					cycleSpeed: 6
					setMotion: MoveTo 86 92 self
				)
			)
			(1
				(if (proc814_15 11 35 0)
					(gEgo setScript: goForIt)
				else
					(gQg1Messager say: 4 0 40)
				)
				(self cue:)
			)
			(2
				(gEgo moveSpeed: gEgoMoveSpeed cycleSpeed: gEgoCycleSpeed)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance goForIt of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo
					view: 517
					loop: 0
					cel: 0
					posn: 83 62
					signal: (| (gEgo signal?) $2000)
				)
				(gQg1Messager say: 4 0 41 1 self)
			)
			(1
				(gEgo
					setPri: 15
					setLoop: 0
					moveSpeed: gEgoMoveSpeed
					cycleSpeed: gEgoCycleSpeed
					setCycle: Fwd
					setMotion: DPath 82 50 81 47 self
				)
			)
			(2 (global2 newRoom: 300))
		)
	)
)

(instance goToTown of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(if local6
					(proc814_26 685 2)
					(gQg1Messager say: 1 0 1 1 self)
				else
					(self cue:)
				)
			)
			(1 (global2 newRoom: 300))
		)
	)
)

(instance goToHealer of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(if local6
					(proc814_26 685 2)
					(gQg1Messager say: 1 0 1 1 self)
				else
					(self cue:)
				)
			)
			(1 (global2 newRoom: 54))
		)
	)
)

(instance goSouth of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(if local6
					(proc814_26 685 2)
					(gQg1Messager say: 1 0 1 1 self)
				else
					(self cue:)
				)
			)
			(1
				(gEgo setMotion: MoveTo (gEgo x?) 240 self)
			)
			(2 (global2 newRoom: 74))
		)
	)
)

(instance goEast of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(if local6
					(proc814_26 685 2)
					(gQg1Messager say: 1 0 1 1 self)
				else
					(self cue:)
				)
			)
			(1
				(gEgo setMotion: MoveTo 340 (gEgo y?) self)
			)
			(2 (global2 newRoom: 66))
		)
	)
)

(instance comeFromEast of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setMotion: MoveTo 265 140 self)
			)
			(1 (proc0_3) (self dispose:))
		)
	)
)

(instance comeFromSouth of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setMotion: MoveTo 160 170 self)
			)
			(1 (proc0_3) (self dispose:))
		)
	)
)

(instance bruno65Talker of Talker
	(properties
		x 10
		y 10
		view 1074
		talkWidth 260
		textX 15
		textY 110
	)
	
	(method (init)
		(= global451 2074)
		(PalVary pvCHANGE_TARGET 2074)
		(kernel_128 1074)
		(= font gFont)
		(super init: brunoBust brunoEye brunoMouth &rest)
	)
)

(instance brunoBust of Prop
	(properties
		view 1074
	)
)

(instance brunoMouth of Prop
	(properties
		nsTop 47
		nsLeft 43
		view 1074
		loop 1
	)
)

(instance brunoEye of Prop
	(properties
		nsTop 26
		nsLeft 43
		view 1074
		loop 3
	)
)
