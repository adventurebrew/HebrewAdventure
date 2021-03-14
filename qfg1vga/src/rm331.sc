;;; Sierra Script 1.0 - (do not remove this comment)
(script# 331)
(include sci.sh)
(use Main)
(use Teller)
(use Ware)
(use n814)
(use Print)
(use PolyPath)
(use Polygon)
(use CueObj)
(use n958)
(use Rev)
(use Sound)
(use Cycle)
(use Game)
(use User)
(use View)
(use Obj)

(public
	rm331 0
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
	gEgoCycleSpeed
	gEgoMoveSpeed
	[local16 8] = [0 6 -23 27 25 22 -26 999]
	[local24 5] = [0 20 24 21 999]
	[local29 5]
	[local34 4] = [0 -23 999 3]
	[local38 6] = [0 3 4 6 5 999]
	[local44 8]
	[local52 2] = [0 999]
	[local54 6] = [0 34 4 6 5 999]
	[local60 8]
	[local68 2] = [0 999]
	[local70 12] = [0 22 40 41 25 46 47 44 42 43 45 999]
	[local82 4]
	[local86 2] = [0 999]
)
(instance rm331 of Rm
	(properties
		noun 20
		picture 331
		style $0002
	)
	
	(method (init)
		(self setRegions: 801)
		(gQg1Walkers add: self)
		(= [local29 0] @local16)
		(= [local29 1] @local24)
		(= [local29 2] 999)
		(= [local44 0] @local38)
		(= [local44 1] 999)
		(= [local60 0] @local54)
		(= [local60 1] 999)
		(= [local82 0] @local70)
		(= [local82 1] 999)
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
						306
						189
						306
						162
						197
						162
						181
						146
						143
						146
						137
						152
						88
						152
						51
						189
						0
						189
					yourself:
				)
		)
		(proc958_0 132 44 43)
		(barTune play:)
		(super init:)
		(= local11 0)
		(= local5 0)
		(if (>= global119 4) (windowShudder init:))
		(barKeepTeller init: bartender @local16 @local29 @local34)
		(bartender
			init:
			actions: barKeepTeller
			setScript: bartenderScript
		)
		(crusherTeller init: crusher @local70 @local82 @local86)
		(crusher init: posn: 31 164 stopUpd:)
		(proc0_6 113)
		(cond 
			(
				(or
					(>= global120 6)
					(and (> global120 0) (not (proc0_7 161)))
				)
				(proc0_5 113)
			)
			((proc0_7 261) (= global120 6) (proc0_5 113))
			((and (proc0_7 235) (== global120 3)) (= global120 4))
			((and (proc0_7 161) (<= global120 1)) (= global120 2))
			((== global120 3) (proc0_5 113))
		)
		(global2
			setFeatures:
				onWindow
				onFloor
				onTableBottom
				onRtTableTop
				onLtTable
				onKeg1
				onKeg2
				onKeg3
				onKeg4
				onFloor
				onWholeKeg
				onBar
		)
		(proc0_5 255)
		(proc0_6 254)
		(= local5 0)
		(= local4 0)
		(= local6 0)
		(if (not (proc0_7 113))
			(paper init: approachVerbs: 4 stopUpd:)
		)
		(rtStool init:)
		(guck init:)
		(puddle init:)
		(barb setPri: 6 ignoreActors: addToPic: init:)
		(ctrStool
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
			ignoreActors:
		)
		(player1Teller init: player1 @local54 @local60 @local68)
		(player1 init: actions: player1Teller setCycle: Fwd)
		(player2Teller init: player2 @local38 @local44 @local52)
		(player2 init: actions: player2Teller setCycle: Fwd)
		(smoke init: setPri: 4 setCycle: Fwd startUpd:)
		(trap init: setPri: 5)
		(caddy init:)
		(barSound number: 44 init:)
		(proc814_3)
		(switch gGModNum
			(332
				(ooze init: setScript: oozeDrip)
				(gEgo init: posn: 120 180 loop: 0)
			)
			(else  (self setScript: sEnter))
		)
	)
	
	(method (doit)
		(cond 
			(script)
			((gEgo script?) 0)
			((== (gEgo edgeHit?) 3) (global2 setScript: sExit))
		)
		(cond 
			(
			(and (gEgo inRect: 190 140 310 166) (not local10)) (= local10 1) (gEgo setScript: cardScript))
			(
			(and (not (gEgo inRect: 190 140 310 166)) local10) (= local10 0) (gEgo setScript: 0))
		)
		(super doit:)
	)
	
	(method (dispose)
		(= global451 0)
		(proc0_5 98)
		(gQg1Walkers delete: self)
		(super dispose:)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(3
				(if (proc0_7 254)
					(gEgo setScript: standUpScript)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(1
				(gEgo setScript: describeTavern)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (cue)
		(switch (++ local0)
			(1
				(paper hide:)
				(proc0_5 113)
				(= local9 1)
				(++ global120)
				(proc814_26 731 2)
				(gQg1Messager say: 18 4 0 1 self)
			)
			(2
				(gQg1Messager say: 20 0 71 1 self)
			)
			(3
				(cond 
					((== global120 1) (gQg1Messager say: 20 0 76))
					((== global120 3) (gQg1Messager say: 20 0 66))
					(else (gQg1Messager say: 20 0 68) (= global120 6))
				)
				(= local0 0)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(DisposeScript 342)
		(super newRoom: newRoomNumber)
	)
)

(instance egoOnChair of Feature
	(properties
		x 65
		y 142
		z 100
		nsTop 91
		nsLeft 137
		nsBottom 142
		nsRight 167
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
			(global2 setScript: standUpScript)
			(pEvent claimed: 1)
			(return)
		else
			(super handleEvent: pEvent)
		)
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 3)
			(gEgo setScript: standUpScript)
		else
			(chair doVerb: theVerb &rest)
		)
	)
)

(instance onWindow of Feature
	(properties
		x 23
		y 94
		noun 25
		nsTop 50
		nsBottom 94
		nsRight 63
	)
)

(instance onBar of Feature
	(properties
		x 164
		y 107
		noun 4
		nsTop 103
		nsLeft 70
		nsBottom 112
		nsRight 258
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (proc0_7 254) (head setCel: 1 stopUpd:))
				(gQg1Messager say: 4 1 33)
			)
			(else 
				(global2 doVerb: theVerb &rest)
			)
		)
	)
)

(instance onRtTableTop of Feature
	(properties
		x 243
		y 158
		z 27
		noun 22
		nsTop 124
		nsLeft 229
		nsBottom 138
		nsRight 258
	)
)

(instance onLtTable of Feature
	(properties
		x 96
		y 134
		noun 17
		nsTop 121
		nsLeft 68
		nsBottom 148
		nsRight 124
	)
)

(instance onTableBottom of Feature
	(properties
		x 250
		y 149
		noun 5
		nsTop 143
		nsLeft 235
		nsBottom 155
		nsRight 266
	)
)

(instance onKeg1 of Feature
	(properties
		x 97
		y 75
		noun 16
		nsTop 49
		nsLeft 83
		nsBottom 87
		nsRight 111
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gQg1Messager say: 16 1))
			(4
				(if local8
					(cond 
						((not (proc0_7 254)) (gQg1Messager say: 3 0 16))
						((> local5 0) (gQg1Messager say: 13 0 9))
						(else (gQg1Messager say: 3 0 8 2) (= local4 0))
					)
				else
					(gQg1Messager say: 16 0 9)
				)
			)
			(else 
				(global2 doVerb: theVerb &rest)
			)
		)
	)
)

(instance onKeg2 of Feature
	(properties
		x 165
		y 68
		noun 12
		nsTop 49
		nsLeft 149
		nsBottom 87
		nsRight 182
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gQg1Messager say: 12 1))
			(4
				(if local8
					(cond 
						((not (proc0_7 254)) (gQg1Messager say: 3 0 16))
						((> local5 0) (gQg1Messager say: 13 0 9))
						(else (gQg1Messager say: 3 0 8 2) (= local4 0))
					)
				else
					(gQg1Messager say: 12 0 9)
				)
			)
			(else 
				(global2 doVerb: theVerb &rest)
			)
		)
	)
)

(instance onKeg3 of Feature
	(properties
		x 239
		y 73
		noun 13
		nsTop 49
		nsLeft 222
		nsBottom 86
		nsRight 256
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gQg1Messager say: 13 1))
			(4
				(if local8
					(cond 
						((not (proc0_7 254)) (gQg1Messager say: 3 0 16))
						((> local5 0) (gQg1Messager say: 13 0 9))
						(else (gQg1Messager say: 3 0 8 2) (= local4 0))
					)
				else
					(gQg1Messager say: 13 0 9)
				)
			)
			(else 
				(global2 doVerb: theVerb &rest)
			)
		)
	)
)

(instance onKeg4 of Feature
	(properties
		x 199
		y 82
		noun 14
		nsTop 77
		nsLeft 187
		nsBottom 96
		nsRight 211
	)
)

(instance onWholeKeg of Feature
	(properties
		x 166
		y 48
		noun 15
		nsTop 21
		nsLeft 64
		nsBottom 75
		nsRight 268
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (proc0_7 254) (head setCel: 2 stopUpd:))
				(gQg1Messager say: 15 1)
			)
			(else 
				(global2 doVerb: theVerb &rest)
			)
		)
	)
)

(instance onFloor of Feature
	(properties
		x 171
		y 169
		noun 10
		onMeCheck $0004
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if
					(and
						(gEgo inRect: 137 138 180 155)
						(not (proc0_7 113))
					)
					(gQg1Messager say: 18 1 48)
				else
					(gQg1Messager say: 10 1 9)
				)
			)
			(4
				(if (proc0_7 254)
					(gEgo setScript: standUpScript)
				else
					(gQg1Messager say: 10 4 9)
				)
			)
			(53
				(if (not (proc0_7 254))
					(gEgo setScript: putItBack)
				else
					(gQg1Messager say: 8 4 33)
				)
			)
			(else 
				(global2 doVerb: theVerb &rest)
			)
		)
	)
)

(instance deadMug of View
	(properties
		x 168
		y 106
		noun 26
		view 331
		cel 1
		priority 14
		signal $4010
	)
)

(instance ctrStool of View
	(properties
		x 151
		y 143
		noun 9
		approachX 151
		approachY 155
		view 331
		loop 3
		signal $4000
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (proc0_7 254)
					(gQg1Messager say: 9 1 33)
				else
					(gQg1Messager say: 9 1 9)
				)
			)
			(4
				(if (proc0_7 254)
					(gQg1Messager say: 9 4 33)
				else
					(gEgo setScript: sitDown)
				)
			)
			(else 
				(global2 doVerb: theVerb &rest)
			)
		)
	)
)

(instance rtStool of View
	(properties
		x 197
		y 143
		noun 21
		view 331
		loop 3
		signal $4000
	)
)

(instance guck of View
	(properties
		x 191
		y 118
		noun 11
		view 331
		loop 3
		cel 3
		priority 11
		signal $4010
	)
)

(instance puddle of View
	(properties
		x 197
		y 144
		z 1
		noun 11
		view 331
		loop 3
		cel 2
		priority 10
		signal $4010
	)
)

(instance caddy of View
	(properties
		x 240
		y 126
		view 331
		loop 8
		priority 12
		signal $0011
	)
)

(instance windowShudder of View
	(properties
		x 23
		y 95
		noun 25
		view 331
		loop 9
		signal $0001
	)
)

(instance barb of View
	(properties
		x 72
		y 240
		z 100
		noun 2
		view 331
		loop 3
		cel 1
		signal $4000
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (proc0_7 254) (head setCel: 1 stopUpd:))
				(gQg1Messager say: 2 1)
			)
			(2 (gQg1Messager say: 2 2))
			(else 
				(global2 doVerb: theVerb &rest)
			)
		)
	)
)

(instance paper of View
	(properties
		x 137
		y 143
		noun 18
		approachX 137
		approachY 150
		view 331
		priority 11
		signal $4011
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gQg1Messager say: 18 1 48))
			(4
				(if (not (proc0_7 254))
					(gEgo get: 39)
					(= local9 1)
					(if local1
						(cond 
							((== global120 1) (gQg1Messager say: 20 0 76))
							((== global120 3) (gQg1Messager say: 20 0 66))
							(else (gQg1Messager say: 20 0 68) (= global120 6))
						)
					else
						(global2 cue:)
					)
				else
					(gQg1Messager say: 8 4 33)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance deck of View
	(properties
		x 240
		y 126
		view 331
		loop 8
		priority 12
		signal $4010
	)
)

(instance head of Prop
	(properties
		x 150
		y 100
		view 504
		loop 2
		cel 3
		priority 15
		signal $4010
		cycleSpeed 1
	)
)

(instance chair of Prop
	(properties
		x 34
		y 163
		view 338
		loop 2
		signal $4000
	)
)

(instance smoke of Prop
	(properties
		x 170
		y 139
		z 92
		noun 23
		view 331
		loop 1
		signal $4000
		cycleSpeed 12
		detailLevel 2
	)
)

(instance ooze of Prop
	(properties
		x 191
		y 118
		view 331
		loop 4
		priority 11
		signal $4010
		detailLevel 2
	)
)

(instance trap of View
	(properties
		x 12
		y 163
		noun 24
		view 331
		loop 2
	)
)

(instance dB of Prop
	(properties
		view 337
		loop 2
		priority 3
		signal $4010
		cycleSpeed 12
		detailLevel 2
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if local8
					(cond 
						((not (proc0_7 254)) (gQg1Messager say: 3 0 16))
						((> local5 0) (gQg1Messager say: 13 0 9))
						(else (gQg1Messager say: 3 0 8 2) (= local4 0))
					)
				else
					(gQg1Messager say: 12 0 9)
				)
			)
			(else 
				(global2 doVerb: theVerb &rest)
			)
		)
	)
)

(instance player1 of Prop
	(properties
		x 226
		y 151
		noun 6
		view 331
		loop 5
		priority 12
		signal $0010
		cycleSpeed 40
		detailLevel 2
	)
	
	(method (cue)
		(super cue:)
		(self doVerb: 2)
	)
)

(instance player1Teller of Teller
	(properties)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (proc0_7 254) (head setCel: 2 stopUpd:))
				(gQg1Messager say: 6 1)
				(return 1)
			)
			(2
				(if (and (!= (gEgo x?) 252) (!= (gEgo y?) 162))
					(if (not (proc0_7 254))
						(gEgo setMotion: PolyPath 252 162 player1)
					)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else 
				(global2 doVerb: theVerb &rest)
			)
		)
		(return 1)
	)
)

(instance player2 of Prop
	(properties
		x 262
		y 148
		noun 1
		view 331
		loop 7
		cel 12
		priority 12
		signal $0010
		cycleSpeed 48
		detailLevel 2
	)
	
	(method (cue)
		(super cue:)
		(self doVerb: 2)
	)
)

(instance player2Teller of Teller
	(properties)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (proc0_7 254) (head setCel: 2 stopUpd:))
				(gQg1Messager say: 1 1)
				(return 1)
			)
			(2
				(if (and (!= (gEgo x?) 252) (!= (gEgo y?) 162))
					(if (not (proc0_7 254))
						(gEgo setMotion: PolyPath 252 162 player2)
					)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else 
				(global2 doVerb: theVerb &rest)
			)
		)
		(return 1)
	)
)

(instance barKeepTeller of Teller
	(properties)
	
	(method (showDialog &tmp temp0)
		(if
		(== (= temp0 (super showDialog: -26 (== gCel 2))) -26)
			(= temp0 (Abs temp0))
		)
		(return temp0)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (proc0_7 254)
					(if (> (bartender x?) (gEgo x?))
						(head setCel: 2 stopUpd:)
					else
						(head setCel: 1 stopUpd:)
					)
				)
				(gQg1Messager say: 3 1)
			)
			(2
				(if (proc0_7 254)
					(bartender setScript: 0)
					(super doVerb: theVerb &rest)
				else
					(gQg1Messager say: 3 2 28)
				)
			)
			(4
				(if local8
					(if (== gCel 2)
						(gQg1Messager say: 3 4 28)
					else
						(gQg1Messager say: 3 4)
					)
				else
					(gQg1Messager say: 3 4 9)
				)
			)
			(10
				(if (proc0_7 254)
					((= gNewList (List new:))
						add:
							((Clone Ware) name: {שיכר} price: {1})
							((Clone Ware) name: {זיעה} price: {5})
							((Clone Ware) name: {נשימה} price: {25})
					)
					(switch ((ScriptID 551 0) doit:)
						(-1 (gQg1Messager say: 3 10 30))
						(1
							(gQg1Messager say: 3 10 32)
							(= local4 1)
							(bartender setScript: getAMug)
						)
						(2
							(= local4 2)
							(gQg1Messager say: 3 10 31)
							(bartender setScript: getAMug)
						)
						(3
							(gQg1Messager say: 3 10 29)
							(= local4 3)
							(bartender setScript: getAMug)
						)
					)
				else
					(gQg1Messager say: 3 10 9)
				)
			)
			(else 
				(global2 doVerb: theVerb &rest)
			)
		)
		(return 1)
	)
)

(instance bartender of Actor
	(properties
		x 162
		y 102
		noun 3
		view 336
		loop 2
		priority 5
		signal $4010
	)
	
	(method (doit)
		(cond 
			(
				(and
					(< (gEgo y?) 113)
					(not (proc0_7 254))
					(not local7)
				)
				(= local7 1)
				(bartender setScript: askEgo)
			)
			((and (> (gEgo y?) 113) local7) (= local7 0) (bartender setScript: bartenderScript))
			((or local7 (proc0_7 254)) (= local8 1))
			((and (not local7) (not (proc0_7 254))) (= local8 0))
		)
		(super doit: &rest)
	)
)

(instance crusher of Actor
	(properties
		noun 8
		approachX 63
		approachY 163
		view 331
		loop 6
	)
	
	(method (init)
		(= global451 1331)
		(PalVary pvCHANGE_TARGET 1331)
		(super init:)
	)
	
	(method (cue param1 &tmp gEgoPriority)
		(super cue:)
		(if param1
			(proc0_2)
			(gNewCast eachElementDo: #stopUpd)
			(crusher view: 338 loop: 0 cycleSpeed: 18 setCycle: End)
			(if (<= (gEgo distanceTo: crusher) 25)
				(if
					(==
						(= gEgoPriority (gEgo priority?))
						(crusher priority?)
					)
					(++ gEgoPriority)
				)
				(gEgo
					setPri: gEgoPriority
					setLoop: 1
					setCycle: Rev
					ignoreActors: 1
					setMotion: MoveTo 125 163 param1
				)
			else
				(param1 cue:)
			)
		)
	)
)

(instance crusherTeller of Teller
	(properties)
	
	(method (showDialog &tmp temp0)
		(if
			(==
				(= temp0
					(super
						showDialog:
							22
							(== local11 1)
							40
							(== local11 2)
							41
							(== local11 3)
							25
							(== local11 1)
							46
							(== local11 2)
							47
							(== local11 3)
							44
							(== local11 1)
							42
							(== local11 2)
							43
							(== local11 3)
					)
				)
				41
			)
			(gEgo setScript: 0)
			(proc0_2)
			(crusher setScript: crusherThrows)
		)
		(if (== temp0 47)
			(gEgo setScript: 0)
			(proc0_2)
			(crusher setScript: crusherThrows)
		)
		(if (== temp0 43)
			(gEgo setScript: 0)
			(proc0_2)
			(crusher setScript: crusherThrows)
		)
		(if (== temp0 45) (global2 setScript: talkToHeroScript))
		(return temp0)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (proc0_7 254) (head setCel: 1 stopUpd:))
				(gQg1Messager say: 8 1)
			)
			(4
				(if (proc0_7 254)
					(gQg1Messager say: 8 4 33)
				else
					(gEgo setScript: moveToCrusher)
				)
			)
			(2
				(if (proc0_7 254)
					(gQg1Messager say: 8 4 33)
				else
					(if (< local11 3) (++ local11))
					(super doVerb: theVerb &rest)
				)
			)
			(else 
				(global2 doVerb: theVerb &rest)
			)
		)
		(return 1)
	)
)

(instance oozeDrip of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(ooze cycleSpeed: (* global87 6) setCycle: CT 7 1 self)
			)
			(1
				(dripSound play:)
				(ooze cycleSpeed: (* global87 2) setCycle: End)
				(= cycles (Random 30 50))
			)
			(2 (self init:))
		)
	)
)

(instance sitDown of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_5 254)
				(proc0_2)
				(gEgo setMotion: MoveTo 162 (gEgo y?) self)
			)
			(1
				(gEgo setMotion: MoveTo 162 148 self)
			)
			(2
				(egoOnChair init:)
				(bartender ignoreActors:)
				(ctrStool
					x: 151
					y: 143
					signal: (| (ctrStool signal?) $4000)
				)
				(gEgo
					view: 504
					loop: 0
					setCel: 0
					signal: (| (gEgo signal?) $4000)
					setPri: 14
				)
				(self cue:)
			)
			(3
				(gEgo
					signal: (| (gEgo signal?) $4000)
					setCycle: End self
				)
			)
			(4
				(gEgo loop: 2 posn: 150 140 cel: 0 stopUpd:)
				(head init: setScript: headMove)
				(bartender setScript: askEgo)
				(= local8 1)
				(= ticks 30)
			)
			(5 (self dispose:))
		)
	)
)

(instance standUpScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(egoOnChair dispose:)
				(head dispose: setScript: 0)
				(bartender ignoreActors:)
				(gEgo posn: 162 148 setLoop: 0 setCycle: Beg self)
			)
			(1
				(proc814_3)
				(gEgo posn: 162 148 setMotion: MoveTo 162 160 self)
			)
			(2
				(proc0_6 254)
				(= local8 0)
				(proc0_3)
				(bartender setScript: bartenderScript)
				(= ticks 6)
			)
			(3 (self dispose:))
		)
	)
)

(instance bartenderScript of Script
	(properties)
	
	(method (doit)
		(cond 
			((> local12 1)
				(-- local12)
				(if local13
					(bartender posn: (bartender x?) 102)
				else
					(bartender posn: (bartender x?) 102)
				)
			)
			((== local12 1)
				(= local12 0)
				(self cue:)
				(if local13 (= local13 0) else (= local13 1))
			)
		)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_3)
				(= ticks (Random 20 80))
			)
			(1
				(= cycles 0)
				(bartender
					setCycle: Walk
					loop: 0
					setMotion: MoveTo 240 102 self
				)
			)
			(2
				(bartender loop: 2 cel: 0 setCycle: End self)
			)
			(3 (= ticks (Random 150 300)))
			(4
				(bartender
					setCycle: Walk
					loop: 1
					cel: -1
					setMotion: MoveTo 105 102 self
				)
			)
			(5
				(bartender loop: 2 cel: 0 setCycle: End self)
			)
			(6 (= ticks (Random 150 300)))
			(7 (self changeState: 1))
		)
	)
)

(instance askEgo of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 0)
				(proc0_2)
				(if (> (bartender distanceTo: gEgo) 15)
					(bartender
						setCycle: Walk
						loop: (if (< (gEgo x?) (bartender x?)) 1 else 0)
						cel: -1
						setMotion:
							MoveTo
							(if (proc0_7 254) (+ (gEgo x?) 15) else (gEgo x?))
							102
							self
					)
				else
					(self cue:)
				)
			)
			(1
				(bartender loop: 2 cel: 2 stopUpd:)
				(if (proc0_7 254) (head setCel: 2))
				(= cycles 2)
			)
			(2
				(gQg1Messager say: 3 0 14)
				(proc0_3)
				(User canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance getAMug of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(deadMug hide:)
				(if (== (gEgo loop?) 3)
					(gEgo loop: 2 cel: 0 stopUpd:)
					(head show:)
				)
				(switch local4
					(2
						(bartender
							setLoop: (if (proc0_7 255) 1 else 6)
							setCycle: Walk
							ignoreActors:
							setMotion: MoveTo 96 102 self
						)
					)
					(else 
						(bartender
							setLoop: (if (proc0_7 255) 0 else 5)
							setCycle: Walk
							ignoreActors:
							setMotion: MoveTo 236 102 self
						)
					)
				)
			)
			(1
				(head hide:)
				(gEgo setLoop: 3 setCel: 0)
				(if (proc0_7 255)
					(bartender setLoop: 4 cel: 2 setPri: 5 setCycle: End self)
				else
					(self cue:)
				)
			)
			(2
				(proc0_6 255)
				(switch local4
					(1 (self cue:))
					(2 (self cue:))
					(3
						(User canInput: 1)
						(dB setScript: breathScript)
					)
				)
			)
			(3
				(bartender setLoop: 7 setCel: 0 setCycle: End self)
			)
			(4
				(bartender
					posn: (if (== local4 2) 96 else 236) 102
					setLoop: 3
					setCel: 0
					setCycle: End self
				)
			)
			(5
				(bartender setCycle: Beg self)
			)
			(6
				(bartender
					setCycle: Walk
					setLoop: (if (== local4 2) 5 else 6)
					setCel: -1
					setMotion: MoveTo 167 102 self
				)
			)
			(7
				(bartender setLoop: (if (== local4 2) 0 else 1) cel: 0)
				(gQg1Messager say: 3 0 13)
				(User canInput: 1)
				(= local5 local4)
				(= local4 0)
				(= ticks 36)
			)
			(8
				(if (proc0_7 254) (gEgo loop: 3 cel: 0))
				(bartender loop: 2 cel: 2 stopUpd:)
				(if 1 (++ local6))
				(gEgo setScript: drinkDown)
			)
		)
	)
)

(instance breathScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(bartender
					setLoop: 6
					setCycle: Walk
					setMotion: MoveTo 177 102 self
				)
			)
			(1
				(bartender
					view: 337
					setLoop: 0
					cel: 0
					posn: 164 102
					ignoreActors:
					setCycle: CT 5 1 self
				)
			)
			(2
				(smoke hide:)
				(dB
					init:
					setLoop: 2
					posn: 166 86
					ignoreActors:
					setCycle: CT 6 1 self
				)
			)
			(3
				(barSound number: 44 play:)
				(bartender setCycle: CT 8 1 self)
				(dB setCycle: End self)
			)
			(4)
			(5
				(dB loop: 3 cel: 0 posn: 169 50)
				(bartender setCycle: End self)
			)
			(6
				(barSound number: 43 play:)
				(dB setCycle: End self)
			)
			(7
				(smoke show:)
				(bartender cel: 2 setCycle: Beg self)
			)
			(8
				(bartender view: 336 posn: 169 102 loop: 2 cel: 0)
				(self cue:)
			)
			(9
				(bartender setCycle: End self)
				(gQg1Messager say: 3 0 13)
			)
			(10
				(if (proc0_7 254) (head hide:) (gEgo loop: 3 cel: 0))
				(= local4 0)
				(= local5 3)
				(gEgo setScript: drinkDown)
				(self dispose:)
			)
		)
	)
)

(instance drinkDown of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setCycle: End self)
			)
			(1
				(switch local5
					(1
						(switch local6
							(1
								(gQg1Messager say: 20 0 52 1 self)
							)
							(2
								(gQg1Messager say: 20 0 53 1 self)
							)
							(3
								(gQg1Messager say: 20 0 54 1)
								(client setScript: tooDrunk)
							)
						)
					)
					(2
						(gQg1Messager say: 20 0 81)
						(client setScript: tooDrunk)
					)
					(3
						(gQg1Messager say: 20 0 51 1 self)
					)
				)
			)
			(2
				(if (== local5 3)
					(client setScript: breathDeath)
				else
					(gEgo setCycle: Beg self)
				)
			)
			(3
				(= local5 0)
				(User canInput: 1)
				(deadMug init: show:)
				(if 1 (head show:) (gEgo loop: 2 cel: 0))
				(proc0_3)
				(User canControl: 0)
				(client setScript: 0)
			)
		)
	)
)

(instance tooDrunk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setCycle: Beg)
				(= cycles 15)
			)
			(1
				(deadMug show:)
				(= ticks 18)
			)
			(2
				(switch local5
					(1 (gQg1Messager say: 20 0 82))
					(2 (gQg1Messager say: 20 0 83))
				)
				(= ticks 18)
			)
			(3
				(gEgo loop: 6 cel: 0 posn: 152 155 setCycle: End self)
			)
			(4
				(bartenderScript dispose:)
				(gNewCast eachElementDo: #dispose)
				(global2 drawPic: 400 -32761)
				(self cue:)
			)
			(5
				(proc814_26 605 -5)
				(proc0_5 118)
				(global2 newRoom: 330)
			)
		)
	)
)

(instance breathDeath of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo moveSpeed: 6 cycleSpeed: 6)
				(= seconds 2)
			)
			(1
				(deadMug show:)
				(gQg1Messager say: 20 0 55 1 self)
				(gEgo loop: 5 cel: 0 posn: 151 136)
			)
			(2
				(barSound number: 44 play:)
				(gEgo cycleSpeed: (* global87 3) setCycle: End self)
			)
			(3 (= seconds 2))
			(4 (proc814_0 140 141 2 3 337))
		)
	)
)

(instance crusherThrows of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(crusher cue: self)
			)
			(1
				(gEgo setCycle: Walk)
				(chair init: ignoreActors: setCycle: End)
				(crusher
					view: 338
					ignoreActors:
					loop: 1
					cel: 0
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(2
				(crusher cel: 2)
				(= cycles 3)
			)
			(3
				(barSound number: 106 loop: -1 play:)
				(crusher setCycle: Fwd)
				(= seconds 3)
			)
			(4
				(gNewCast eachElementDo: #dispose)
				(global2 drawPic: 400 -32762)
				(proc0_5 117)
				(global2 newRoom: 330)
			)
		)
	)
)

(instance crusherEscorts of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setCycle: Walk setMotion: PolyPath 50 175)
				(= ticks 30)
			)
			(1 (crusher cue: self))
			(2
				(chair init: ignoreActors: setCycle: End)
				(crusher
					ignoreActors:
					setLoop: 1
					setCel: 0
					setCycle: 0
					stopUpd:
				)
				(= ticks 180)
			)
			(3
				(gNewCast eachElementDo: #dispose)
				(global2 drawPic: 400 -32762)
				(global2 newRoom: 332)
			)
		)
	)
)

(instance moveToCrusher of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(= gEgoCycleSpeed (gEgo cycleSpeed?))
				(= gEgoMoveSpeed (gEgo moveSpeed?))
				(gEgo cycleSpeed: 6 moveSpeed: 6)
				(= ticks 30)
			)
			(1
				(gEgo setMotion: MoveTo 79 165 self)
			)
			(2
				(gQg1Messager say: 20 0 79 1 self)
			)
			(3
				(gEgo cycleSpeed: gEgoCycleSpeed moveSpeed: gEgoMoveSpeed)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance talkToHeroScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gMainIconBar disable: 1 4 3 7 2 8 5)
				(= seconds 1)
			)
			(1
				(if gDialog (gDialog dispose:))
				(gGame setCursor: 999 1 140 80)
				(if (proc0_7 123)
					(switch
						(Print
							addText: 19 0 50 1 0 0 331
							addButton: 1 19 0 49 1 0 14 331
							addButton: 2 19 0 49 2 0 30 331
							addButton: 3 19 0 49 3 0 46 331
							addButton: 4 19 0 49 4 0 62 331
							addButton: 5 19 0 49 5 0 78 331
							addButton: 6 19 0 49 6 0 94 331
							init:
						)
						(1 (self cue:))
						(2 (self cue:))
						(3 (self cue:))
						(4 (self cue:))
						(5
							(if (and (not [gStrength 8]) (not [gStrength 9]))
								(gQg1Messager say: 20 0 77)
								(self setScript: crusherThrows)
							else
								(self setScript: crusherEscorts)
							)
						)
						(6 (self cue:))
					)
				else
					(Print
						addText: 19 0 50 1 0 0 331
						addButton: 1 19 0 49 1 0 14 331
						addButton: 2 19 0 49 2 0 30 331
						addButton: 3 19 0 49 3 0 46 331
						addButton: 4 19 0 49 4 0 62 331
						addButton: 5 19 0 49 7 0 78 331
						addButton: 6 19 0 49 6 0 94 331
						init:
					)
					(self cue:)
				)
			)
			(2
				(switch local11
					(1
						(gQg1Messager say: 8 0 37 1 self)
					)
					(2
						(gQg1Messager say: 8 0 36 1 self)
					)
					(3
						(gQg1Messager say: 8 0 35 1)
						(gEgo setScript: 0)
						(proc0_2)
						(self setScript: crusherThrows)
					)
				)
			)
			(3
				(User canControl: 1 canInput: 1)
				(gGame setCursor: 943 1 140 80)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance headMove of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(head cel: (Random 1 3))
				(-- state)
				(= ticks 120)
			)
		)
	)
)

(instance describeTavern of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gQg1Messager say: 20 1 86 0 self)
			)
			(1
				(if (not local2)
					(gQg1Messager say: 20 1 85 1 self)
					(= local2 1)
				else
					(self cue:)
				)
			)
			(2 (self dispose:))
		)
	)
)

(instance putItBack of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo use: 39)
				(= ticks 30)
				(proc0_2)
			)
			(1 (= ticks 60))
			(2
				(paper show:)
				(= local9 0)
				(proc0_6 113)
				(gQg1Messager say: 20 0 78 1 self)
			)
			(3 (self dispose:) (proc0_3))
		)
	)
)

(instance sEnter of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(proc814_3)
				(gEgo init: posn: 162 240 setMotion: MoveTo 156 175 self)
			)
			(1 (proc814_3) (= cycles 2))
			(2
				(if (not (proc0_7 98))
					(crusher setScript: describeTavern)
				)
				(proc0_3)
				(ooze init: setScript: oozeDrip)
				(self dispose:)
			)
		)
	)
)

(instance sExit of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(barTune fade:)
				(gEgo setMotion: MoveTo (gEgo x?) 240 self)
			)
			(1 (global2 newRoom: 330))
		)
	)
)

(instance cardScript of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 30] temp30)
		(switch (= state newState)
			(0 (= ticks (Random 250 400)))
			(1
				(proc921_1
					@temp0
					(Format @temp0 331 0 (= temp30 (Random 1 1000)))
				)
				(= ticks (Random 250 350))
			)
			(2
				(switch (Random 1 2)
					(1 (gQg1Messager say: 1 0 1))
					(2 (gQg1Messager say: 6 0 1))
				)
				(self init:)
			)
		)
	)
)

(instance dripSound of Sound
	(properties
		number 116
	)
)

(instance barSound of Sound
	(properties
		number 44
	)
)

(instance barTune of Sound
	(properties
		flags $ffff
		number 127
		loop -1
	)
)
