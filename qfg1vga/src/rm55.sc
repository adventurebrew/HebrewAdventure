;;; Sierra Script 1.0 - (do not remove this comment)
(script# 55)
(include sci.sh)
(use Main)
(use Teller)
(use Ware)
(use n814)
(use Print)
(use RTRandCycle)
(use PolyPath)
(use Polygon)
(use CueObj)
(use n958)
(use SysWindow)
(use Sound)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	rm55 0
	healerTalker 1
)

(local
	[local0 2]
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	[local10 7] = [0 -25 -34 -39 -13 -12 999]
	[local17 4] = [0 -33 -37 999]
	[local21 8] = [0 26 -43 28 -42 -16 -29 999]
	[local29 7] = [0 -11 -21 -14 20 30 999]
	[local36 5] = [0 10 38 15 999]
	[local41 4] = [0 19 27 999]
	[local45 3] = [0 35 999]
	[local48 3] = [0 36 999]
	[local51 3] = [0 41 999]
	[local54 4] = [0 44 40 999]
	[local58 7] = [0 17 22 9 24 31 999]
	[local65 4] = [0 18 23 999]
	[local69 3] = [0 32 999]
	[local72 18]
	[local90 14] = [0 -25 -34 -39 -13 -12 -33 -37 -43 -42 -16 -29 -21 999]
)
(procedure (localproc_00e4 &tmp [temp0 40] [temp40 11] [temp51 11] [temp62 20] [temp82 11] [temp93 11] [temp104 200])
	(if
	(and (not (proc0_7 223)) (not (proc0_7 224)))
		(cond 
			(
				(and
					(proc0_7 218)
					(proc0_7 219)
					(proc0_7 220)
					(proc0_7 221)
					(proc0_7 222)
				)
				(global2 setScript: waitForHealer)
				(proc0_5 223)
				(proc0_6 224)
				(proc0_6 218)
				(proc0_6 219)
				(proc0_6 220)
				(proc0_6 221)
				(proc0_6 222)
			)
			((proc0_7 334)
				(Message msgGET 55 5 0 7 1 @temp0)
				(Message msgGET 55 5 0 4 1 @temp40)
				(Message msgGET 55 5 0 5 1 @temp51)
				(Message msgGET 55 5 0 6 1 @temp62)
				(Message msgGET 55 5 0 3 1 @temp82)
				(Message msgGET 55 5 0 8 1 @temp93)
				(Print
					addTextF:
						@temp104
						@temp0
						(if (proc0_7 218) {} else @temp40)
						(if (proc0_7 219) {} else @temp51)
						(if (proc0_7 220) {} else @temp62)
						(if (proc0_7 222) {} else @temp93)
						(if (proc0_7 221) {} else @temp82)
					init:
				)
			)
		)
	)
)

(instance rm55 of Rm
	(properties
		noun 13
		picture 55
		style $0008
	)
	
	(method (init)
		(= [local72 0] @local10)
		(= [local72 1] @local17)
		(= [local72 2] @local21)
		(= [local72 3] @local29)
		(= [local72 4] @local36)
		(= [local72 5] @local41)
		(= [local72 6] @local45)
		(= [local72 7] @local48)
		(= [local72 8] @local51)
		(= [local72 9] @local54)
		(= [local72 10] @local58)
		(= [local72 11] @local65)
		(= [local72 12] @local69)
		(= [local72 13] 999)
		(global2
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
						319
						133
						179
						122
						270
						143
						234
						168
						115
						152
						75
						164
						0
						140
						0
						189
					yourself:
				)
		)
		(proc958_0 128 57 56 523 525)
		(Load rsSOUND 42)
		(super init:)
		(= global240 0)
		(self
			setFeatures:
				pots
				barrel
				cheeseCloth
				bed
				woodTable
				litterBox
				healerWindow
				ladder
				ingredients
				onThings
		)
		(stoneTable
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
		)
		(fire init: setCycle: Fwd)
		(kettle init: setCycle: Fwd)
		(bottles
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
		)
		(proc814_3)
		(bird init: setScript: preening)
		(gEgo init: posn: 137 243)
		(healerTeller init: healer @local10 @local72 @local90)
		(gLongSong number: 122 loop: -1 init: play:)
		(global2 setScript: egoEnters)
	)
	
	(method (doit)
		(cond 
			(script)
			(
				(or
					(== (gEgo edgeHit?) 3)
					(< (gEgo x?) 3)
					(> (gEgo x?) 318)
				)
				(proc0_2)
				(global2 setScript: sExitSouth)
			)
		)
		(super doit:)
	)
	
	(method (dispose)
		(= global451 0)
		(gLongSong fade:)
		(proc0_5 45)
		(super dispose:)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (gQg1Messager say: 13 4))
			(52 (gQg1Messager say: 13 52))
			(1 (gQg1Messager say: 13 1))
			(50 (gQg1Messager say: 13 50))
			(81 (gQg1Messager say: 13 81))
			(78 (gQg1Messager say: 13 81))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance healerWin of SysWindow
	(properties
		color 1
	)
	
	(method (open &tmp temp0)
		(= top (+ top (= temp0 (- 188 bottom))))
		(= bottom (+ bottom temp0))
		(super open:)
	)
)

(instance cheeseCloth of Feature
	(properties
		x 19
		y 128
		noun 3
		nsTop 123
		nsBottom 133
		nsRight 38
		sightAngle 40
	)
)

(instance bed of Feature
	(properties
		x 156
		y 104
		noun 2
		nsTop 89
		nsLeft 112
		nsBottom 119
		nsRight 200
		sightAngle 40
	)
)

(instance litterBox of Feature
	(properties
		x 121
		y 117
		z 65
		noun 10
		nsTop 44
		nsLeft 105
		nsBottom 61
		nsRight 138
		sightAngle 40
	)
)

(instance healerWindow of Feature
	(properties
		x 130
		y 77
		noun 17
		nsTop 70
		nsLeft 120
		nsBottom 84
		nsRight 141
		sightAngle 40
	)
)

(instance ingredients of Feature
	(properties
		x 249
		y 83
		noun 7
		nsTop 78
		nsLeft 215
		nsBottom 89
		nsRight 284
		sightAngle 40
	)
)

(instance woodTable of Feature
	(properties
		x 81
		y 147
		noun 15
		nsTop 124
		nsLeft 39
		nsBottom 147
		nsRight 123
		sightAngle 40
	)
)

(instance ladder of Feature
	(properties
		x 70
		y 92
		noun 9
		nsTop 55
		nsLeft 54
		nsBottom 129
		nsRight 86
		sightAngle 40
	)
)

(instance stoneTable of Feature
	(properties
		x 195
		y 159
		noun 14
		onMeCheck $0002
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gQg1Messager say: 14 1))
			(4
				(cond 
					((proc0_7 226) (gQg1Messager say: 14 4 68))
					(local2
						(gQg1Messager say: 14 4 66)
						(bottles hide:)
						(proc0_5 226)
						(= local9 3)
						(gEgo setScript: cueItScript)
					)
					(else (gQg1Messager say: 14 4 67))
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pots of Feature
	(properties
		x 219
		y 135
		noun 11
		onMeCheck $0004
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gQg1Messager say: 11 1))
			(4 (gQg1Messager say: 11 4))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance onThings of Feature
	(properties
		x 18
		y 144
		z 50
		noun 16
		nsTop 73
		nsBottom 116
		nsRight 36
	)
)

(instance barrel of Feature
	(properties
		x 7
		y 131
		z 93
		noun 1
		nsTop 24
		nsBottom 53
		nsRight 15
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 1)
			(if (not local7)
				(gQg1Messager say: 1 1 1)
				(= local7 1)
			else
				(gQg1Messager say: 1 1 2)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance bottles of View
	(properties
		x 145
		y 135
		noun 14
		approachX 144
		approachY 162
		view 56
		loop 1
		priority 11
		signal $0011
	)
	
	(method (doVerb theVerb)
		(stoneTable doVerb: theVerb &rest)
	)
)

(instance kettle of Prop
	(properties
		x 203
		y 120
		noun 8
		nsTop 111
		nsLeft 190
		nsBottom 126
		nsRight 207
		view 56
		loop 7
		priority 9
		signal $0010
		cycleSpeed 20
	)
)

(instance fire of Prop
	(properties
		x 199
		y 146
		noun 4
		nsTop 111
		nsLeft 190
		nsBottom 146
		nsRight 199
		view 56
		priority 10
		signal $0010
		cycleSpeed 4
	)
	
	(method (doVerb theVerb)
		(pots doVerb: theVerb &rest)
	)
)

(instance bird of Prop
	(properties
		x 45
		y 52
		noun 12
		nsTop 73
		nsLeft 65
		nsBottom 82
		nsRight 87
		view 56
		loop 2
		cycleSpeed 2
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 20)
			(gQg1Messager say: 6 16)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance healer of Actor
	(properties
		noun 6
		approachX 105
		approachY 157
		view 57
		loop 2
		illegalBits $0000
	)
	
	(method (doit)
		(if (and local4 (!= script healerKisses))
			(= local4 0)
			(healer setScript: healerKisses)
		)
		(super doit:)
	)
)

(instance healerTeller of Teller
	(properties)
	
	(method (showDialog)
		(super
			showDialog:
				-37
				(if (or (proc0_7 91) (proc0_7 45))
					(not (proc0_7 230))
				else
					0
				)
				-16
				(gEgo has: 24)
		)
	)
	
	(method (doChild)
		(return
			(switch query
				(-14 (proc0_5 350))
				(-11 (proc0_5 308))
				(-12
					(if (or (proc0_7 94) (proc0_7 43))
						(super doChild: query)
					else
						(return 1)
					)
				)
				(-29
					(if (or (proc0_7 60) (proc0_7 66))
						(super doChild: query)
					else
						(return 1)
					)
				)
				(else  (super doChild: query))
			)
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gQg1Messager say: 6 4 0 1))
			(4
				(if (proc0_7 230)
					(gQg1Messager say: 6 4 37 2)
				else
					(gQg1Messager say: 6 4 37 1)
				)
			)
			(2
				(proc814_26 668 2)
				(super doVerb: theVerb &rest)
			)
			(10
				((= gNewList (List new:))
					add:
						((Clone Ware) name: {סיבולת} price: {20})
						((Clone Ware) name: {רפואה} price: {40})
						((Clone Ware) name: {מאנה} price: {60})
						((Clone Ware) name: {אלמוות} price: {100})
				)
				(switch ((ScriptID 551 0) doit:)
					(-1 (gQg1Messager say: 6 10 52))
					(1
						(gQg1Messager say: 6 10 56)
						(= local9 4)
						(gEgo setScript: cueItScript)
					)
					(2
						(gQg1Messager say: 6 10 56)
						(= local9 5)
						(gEgo setScript: cueItScript)
					)
					(3
						(gQg1Messager say: 6 10 56)
						(= local9 6)
						(gEgo setScript: cueItScript)
					)
					(4
						(gQg1Messager say: 6 10 56)
						(= local9 7)
						(gEgo setScript: cueItScript)
					)
				)
			)
			(28
				(proc0_5 230)
				(proc814_26 669 10)
				(gQg1Messager say: 6 28 37)
				((gDropInv at: 38)
					amount: (+ ((gDropInv at: 38) amount?) 6)
				)
				(= local9 1)
				(gEgo setScript: cueItScript)
				(= local4 1)
				(if (<= (+ (* (gEgo y?) 3) (gEgo x?) -615) 0)
					(= local5 20)
					(healer setScript: healerPleased)
				)
			)
			(36
				(if (> global240 2)
					(gQg1Messager say: 6 36 45)
				else
					(gEgo setScript: flowersScript)
				)
			)
			(37
				(gEgo setScript: giveGreenFur)
			)
			(34 (gEgo setScript: giveAcorn))
			(35 (gQg1Messager say: 6 35 51))
			(40
				(gEgo setScript: giveMushroom)
			)
			(46 (gEgo setScript: giveClaws))
			(47 (gEgo setScript: giveBeard))
			(38 (gEgo setScript: giveDust))
			(39
				(cond 
					((not (gEgo has: 29)) (proc814_7))
					(global242 (gQg1Messager say: 6 39 16))
					((not (proc0_7 334)) (gQg1Messager say: 6 39 47))
					((not (proc0_7 329)) (gQg1Messager say: 6 39 48))
					(else (gEgo setScript: giveWater))
				)
			)
			(20 (gQg1Messager say: 6 16))
			(21
				(= local5 6)
				(healer setScript: healerPleased)
				(gQg1Messager say: 6 21)
				(= local9 2)
				(gEgo setScript: cueItScript)
			)
			(16 (gQg1Messager say: 6 16))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
		(return 1)
	)
)

(instance egoEnters of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setMotion: MoveTo (gEgo x?) 185 self)
				(healer
					loop: 9
					init:
					posn: 151 142
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
						2
					setCycle: Fwd
				)
			)
			(1 (= ticks 4))
			(2
				(cond 
					((not (proc0_7 225)) (gQg1Messager say: 13 0 63 1 self))
					(
						(and
							(not (proc0_7 223))
							(or (not (proc0_7 201)) (proc0_7 334))
						)
						(gQg1Messager say: 13 0 62 1 self)
					)
					(else (self cue:))
				)
			)
			(3
				(if (not (proc0_7 225))
					(gQg1Messager say: 13 0 65 0 self)
				else
					(self cue:)
				)
			)
			(4
				(if
				(and (proc0_7 201) (gEgo has: 24) (not (proc0_7 334)))
					(gQg1Messager say: 13 0 57 1 self)
				else
					(self cue:)
				)
			)
			(5
				(if
				(and (proc0_7 201) (gEgo has: 24) (not (proc0_7 334)))
					(gQg1Messager say: 6 34 0 1 self)
					(proc0_5 334)
				else
					(self cue:)
				)
			)
			(6
				(if (proc0_7 223)
					(global2 setScript: giveDispel)
				else
					(self cue:)
				)
			)
			(7
				(healer setMotion: MoveTo 92 139 self)
			)
			(8
				(healer setLoop: 5 setCycle: End self)
			)
			(9
				(healer
					setLoop: 5
					setCycle: Fwd
					setScript: healerPuttering
				)
				(proc0_3)
				(global2 setScript: 0)
				(self dispose:)
			)
		)
	)
)

(instance preening of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(lizSound play: 50)
				(bird cel: 2 setCycle: End self)
			)
			(1
				(= ticks (* 2 (Random 9 27)))
			)
			(2
				(lizSound play: 50)
				(bird setCycle: Beg self)
			)
			(3
				(= ticks (* 2 (Random 100 200)))
			)
			(4 (self changeState: 0))
		)
	)
)

(instance healerPuttering of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (* 2 (Random 90 200)))
			)
			(1
				(healer setLoop: 4 cel: 2 setCycle: Beg self)
			)
			(2
				(= local2 1)
				(healer
					loop: 1
					setCycle: Walk
					setMotion: MoveTo 87 138 self
				)
			)
			(3
				(healer loop: 3)
				(= seconds 3)
			)
			(4
				(= local2 0)
				(healer
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 151 142 self
				)
			)
			(5
				(healer
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 90 139 self
				)
			)
			(6
				(healer setLoop: 4 cel: 0 setCycle: End self)
			)
			(7
				(healer setLoop: 5 cel: 0 setCycle: Fwd)
				(self changeState: 0)
			)
		)
	)
)

(instance healerPleased of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(healer setMotion: 0 loop: 2)
				(= ticks 4)
			)
			(1
				(healer setLoop: 6 cel: 0 setCycle: End self)
			)
			(2 (= ticks (* 2 local5)))
			(3
				(switch local3
					(0
						(healer
							setLoop: -1
							setCycle: Walk
							setMotion: MoveTo 164 130 self
						)
					)
					(1
						(healer
							setLoop: -1
							setCycle: Walk
							setMotion: MoveTo 164 130 self
						)
					)
				)
			)
			(4
				(healer setLoop: 5 setCycle: End self)
			)
			(5
				(healer
					setLoop: 5
					setCycle: Fwd
					setScript: healerPuttering
				)
			)
		)
	)
)

(instance healerKisses of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(healer setLoop: 6 setCel: 0 setCycle: End self)
			)
			(1
				(if
					(not
						(if
							(and
								(<= 138 (healer x?))
								(<= (healer x?) 140)
								(<= 138 (healer y?))
							)
							(<= (healer y?) 140)
						)
					)
					(switch local3
						(0
							(healer
								setLoop: -1
								setCycle: Walk
								illegalBits: 0
								setMotion: MoveTo 139 139 self
							)
						)
						(1
							(healer
								setLoop: 2
								setCycle: Walk
								setMotion: MoveTo 139 139 self
							)
						)
					)
				else
					(= ticks 4)
				)
			)
			(2
				(healer setLoop: 2 setMotion: MoveTo 121 152)
				(gEgo illegalBits: 0 setMotion: MoveTo 146 154 self)
			)
			(3
				(gEgo setLoop: 1 ignoreActors:)
				(= ticks 4)
			)
			(4
				(healer
					setLoop: 7
					cel: 0
					ignoreActors:
					setCycle: CT 2 1 self
				)
			)
			(5
				(gEgo hide:)
				(healer
					setLoop: 7
					posn: (+ (healer x?) 2) (+ (healer y?) 5)
					setCycle: CT 6 1 self
				)
			)
			(6 (kiss init: play: self))
			(7
				(healer setLoop: 7 setCycle: CT 3 -1 self)
			)
			(8
				(gEgo show:)
				(healer setLoop: 7 setCycle: CT 0 -1 self)
			)
			(9
				(gEgo
					view: 525
					loop: 2
					cel: 0
					posn: (+ (gEgo x?) 5) (+ (gEgo y?) 3)
					setPri: 11
					setCycle: Fwd
					setMotion: MoveTo 137 175 self
				)
			)
			(10
				(gQg1Messager say: 13 0 64 1 self)
			)
			(11
				(healer
					setLoop: -1
					setCycle: Walk
					setPri: 12
					moveSpeed: 12
					setMotion: MoveTo 135 210 self
				)
				(proc814_3)
				(gEgo
					view: 0
					setLoop: 2
					setCycle: Walk
					setMotion: MoveTo 155 210 self
				)
			)
			(12 (self dispose:))
		)
	)
)

(instance waitForHealer of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 5))
			(1
				(gQg1Messager say: 13 0 61)
				(= seconds 3)
			)
			(2 (self dispose:))
		)
	)
)

(instance sExitSouth of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setMotion: MoveTo (gEgo x?) 243 self)
			)
			(1
				(if
				(and (not (proc0_7 225)) (not (proc0_7 230)))
					(gQg1Messager say: 13 0 58 1 self)
				else
					(self cue:)
				)
			)
			(2
				(proc0_5 225)
				(global2 newRoom: 54)
			)
		)
	)
)

(instance flowersScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(= local5 10)
				(gQg1Messager say: 6 36 46 1 self)
			)
			(1
				(proc0_5 220)
				(++ global240)
				(gEgo use: 26 5)
				(proc814_26 673 1)
				(localproc_00e4)
				(= seconds 2)
			)
			(2
				(proc0_3)
				(gEgo get: 0 5)
				(healer setScript: healerPleased)
			)
		)
	)
)

(instance giveGreenFur of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(= local5 10)
				(gEgo use: 27)
				(proc0_5 219)
				(proc814_26 676 2)
				(healer setScript: healerPleased)
				(= ticks 60)
			)
			(1
				(if (proc0_7 334)
					(gQg1Messager say: 6 37 16 1 self)
				else
					(gQg1Messager say: 6 37 0 1 self)
				)
			)
			(2
				(localproc_00e4)
				(= seconds 2)
			)
			(3 (proc0_3) (self dispose:))
		)
	)
)

(instance giveAcorn of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(proc0_5 334)
				(= local5 10)
				(healer setScript: healerPleased)
				(gQg1Messager say: 6 34 0 1 self)
			)
			(1
				(proc0_5 221)
				(proc814_26 675 5)
				(localproc_00e4)
				(= seconds 2)
			)
			(2
				(proc0_3)
				(gEgo use: 24)
				(self dispose:)
			)
		)
	)
)

(instance giveMushroom of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(cond 
					((> global241 2) (gQg1Messager say: 6 40 45 1 self))
					((proc0_7 148) (gQg1Messager say: 6 40 50 1 self))
					(else
						(= local5 10)
						(healer setScript: healerPleased)
						(gQg1Messager say: 6 40 46 1 self)
						(++ global241)
					)
				)
			)
			(1
				(if (not (proc0_7 148))
					(gEgo get: 38 1)
					(gEgo use: 30 3)
				)
				(self cue:)
			)
			(2
				(proc0_3)
				(if (and (> global241 2) (not (proc0_7 148)))
					(proc814_26 670 1)
				)
				(self dispose:)
			)
		)
	)
)

(instance giveClaws of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(= local5 10)
				(healer setScript: healerPleased)
				(= ticks 60)
			)
			(1
				(if (== local8 1)
					(self cue:)
				else
					(= local8 1)
					(gQg1Messager say: 6 46 0 1 self)
				)
			)
			(2
				(gQg1Messager say: 6 46 0 2 self)
			)
			(3
				(proc814_26 671 2)
				(= ticks 30)
			)
			(4
				(proc0_3)
				(gEgo get: 0 5 use: 36)
				(self dispose:)
			)
		)
	)
)

(instance giveBeard of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(= local5 10)
				(healer setScript: healerPleased)
				(= ticks 60)
			)
			(1
				(gQg1Messager say: 6 47 0 0 self)
			)
			(2 (gEgo use: 37) (= ticks 60))
			(3
				(proc0_3)
				(gEgo get: 12)
				(gEgo get: 12)
				(proc814_26 672 2)
				(self dispose:)
			)
		)
	)
)

(instance giveDust of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(= local5 10)
				(healer setScript: healerPleased)
				(= ticks 30)
			)
			(1
				(if (and (not (proc0_7 223)) (proc0_7 334))
					(gQg1Messager say: 6 38 16 1 self)
				else
					(gQg1Messager say: 6 38 16 2 self)
				)
			)
			(2
				(proc0_5 218)
				(proc814_26 677 2)
				(localproc_00e4)
				(= seconds 2)
			)
			(3
				(gEgo use: 28)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance giveWater of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gQg1Messager say: 6 39 49 0 self)
			)
			(1
				(= local5 10)
				(healer setScript: healerPleased)
				(++ global242)
				(proc0_5 222)
				(proc814_26 674 2)
				(localproc_00e4)
				(= ticks 60)
			)
			(2
				(gEgo use: 29)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance giveDispel of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(healer setMotion: MoveTo 92 139 self)
			)
			(1
				(gEgo get: 15)
				(proc0_6 223)
				(proc0_5 224)
				(proc814_26 678 7)
				(healer setLoop: 5 setCycle: End self)
			)
			(2
				(gEgo setMotion: PolyPath 105 157 self)
			)
			(3
				(gQg1Messager say: 13 0 59 1 self)
			)
			(4
				(healer
					setLoop: 5
					setCycle: Fwd
					setScript: healerPuttering
				)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance cueItScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= ticks 60))
			(1
				(switch local9
					(1
						(gEgo use: 18)
						(gEgo get: 12)
						(gEgo get: 12)
					)
					(2
						(gEgo use: 11)
						(gEgo get: 0 1)
					)
					(3 (gEgo get: 12 2))
					(4 (gEgo get: 14))
					(5 (gEgo get: 12))
					(6 (gEgo get: 13))
					(7 (gEgo get: 19))
				)
				(self cue:)
			)
			(2 (self dispose:))
		)
	)
)

(instance lizSound of Sound
	(properties
		number 74
		vol 45
	)
)

(instance kiss of Sound
	(properties
		number 42
		priority 5
	)
)

(instance healerTalker of Talker
	(properties
		x 10
		y 10
		view 1055
		talkWidth 260
		textX 15
		textY 110
	)
	
	(method (init)
		(= global451 2055)
		(PalVary pvCHANGE_TARGET 2055)
		(kernel_128 1055)
		(= font gFont)
		(super init: healerBust healerEye healerMouth &rest)
	)
)

(instance healerBust of Prop
	(properties
		view 1055
	)
)

(instance healerMouth of Prop
	(properties
		nsTop 52
		nsLeft 40
		view 1055
		loop 1
	)
)

(instance healerEye of Prop
	(properties
		nsTop 41
		nsLeft 39
		view 1055
		loop 2
	)
)
