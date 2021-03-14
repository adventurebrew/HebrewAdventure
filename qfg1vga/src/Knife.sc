;;; Sierra Script 1.0 - (do not remove this comment)
(script# 332)
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
	rm332 0
	chiefThiefTalker 1
	proc332_2 2
)

(local
	local0
	local1
	newKnife
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
	[local14 11] = [{מאד חסר אחריות מצידך לעמוד מול הסכין המתעופפת! או שהרב גנב השליך אותה לכיוונך בכוונה? או שבדיוק גילית באג מציק בתוכנה??? אולי לעולם לא תדע.} {אתה לא מאמין אלו רפלקסים יש לרב גנב כשהוא מגיב באוטומט לנסיון השליפה הפזיז שלך. פגיון טס במהירות הבזק ו...} {צרות עם חפצים חדים ודוקרים} {החבר'ה האלה קשוחים!} 250 40 75 30 25 100 35]
	[local25 7] = [0 -42 -34 35 -45 -44 999]
	[local32 4] = [0 41 -29 999]
	[local36 7] = [0 43 38 30 -32 37 999]
	[local43 4] = [0 39 36 999]
	[local47 3] = [0 -31 999]
	[local50 3] = [0 40 999]
	[local53 3] = [0 -28 999]
	[local56 3] = [0 -33 999]
	[local59 4] = [0 26 27 999]
	[local63 3] = [0 25 999]
	[local66 15]
	[local81 11] = [0 -42 -34 -45 -44 -29 -32 -31 -28 -33 999]
	[local92 5] = [0 -2 -6 1 999]
	[local97 3] = [0 4 999]
	[local100 4] = [0 5 3 999]
	[local104 5]
	[local109 4] = [0 -2 -6 999]
)
(procedure (proc332_2)
)

(procedure (localproc_0182)
	(gQg1Messager say: 7)
)

(procedure (localproc_018d)
	(return
		(if local4
			(return 0)
		else
			(knifeScript changeState: 1)
			(return 1)
		)
	)
)

(class Knife of View
	(properties
		x 0
		y 0
		z 0
		heading 0
		noun 13
		modNum -1
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		sightAngle 26505
		actions 0
		onMeCheck $6789
		approachX 0
		approachY 0
		approachDist 0
		_approachVerbs 0
		yStep 2
		view -1
		loop 0
		cel 0
		priority 0
		underBits 0
		signal $0101
		lsTop 0
		lsLeft 0
		lsBottom 0
		lsRight 0
		brTop 0
		brLeft 0
		brBottom 0
		brRight 0
		palette 0
		scaleSignal $0000
		scaleX 128
		scaleY 128
		maxScale 128
	)
)

(instance rm332 of Rm
	(properties
		noun 18
		picture 332
		style $0005
	)
	
	(method (init)
		(= [local66 0] @local25)
		(= [local66 1] @local32)
		(= [local66 2] @local36)
		(= [local66 3] @local43)
		(= [local66 4] @local47)
		(= [local66 5] @local50)
		(= [local66 6] @local53)
		(= [local66 7] @local56)
		(= [local66 8] @local63)
		(= [local66 9] @local59)
		(= [local66 10] 999)
		(= [local104 0] @local92)
		(= [local104 1] @local97)
		(= [local104 2] @local100)
		(= [local104 3] 999)
		(= local0 0)
		(global2
			addObstacle:
				((Polygon new:)
					type: 3
					init:
						80
						123
						84
						130
						142
						130
						147
						174
						61
						174
						63
						152
						56
						148
						51
						116
						14
						155
						0
						179
						192
						180
						179
						158
						284
						158
						189
						111
						146
						111
						133
						123
					yourself:
				)
		)
		(proc958_0 128 332 338 509 503)
		(proc958_0
			132
			(proc814_25 31)
			(proc814_25 29)
			(proc814_25 30)
		)
		(super init:)
		(proc814_26 638 5 2)
		(dagMusic number: (proc814_25 31) init:)
		(SL enable:)
		(= local5 100)
		(= local6 7)
		(= gPicAngle 70)
		(gNewFeatures
			add:
				onBoard
				onLadder
				onLightFixture1
				onLightFixture2
				onBoxes
				onTrap
				onDaggers
				onPottery
				onOneKnife
				onCrock
				onTable
			eachElementDo: #init
		)
		(onDoor init: approachVerbs: 4 1 10)
		(onTrunk init:)
		(onBarrels init:)
		(onCeiling init:)
		(chair init: actions: chiefTeller stopUpd: ignoreActors:)
		(chairArm
			init:
			ignoreActors:
			actions: chiefTeller
			setPri: (+ (chiefThief priority?) 1)
			stopUpd:
		)
		(fire1 init: setCycle: Fwd)
		(fire2 init: setCycle: Fwd)
		(borisTeller
			init: borisThief @local92 @local104 @local109
		)
		(chiefTeller init: chiefThief @local25 @local66 @local81)
		(chiefThief
			approachVerbs: 4 10
			actions: chiefTeller
			init:
		)
		(crusher init: ignoreActors: 1 stopUpd:)
		(crusherHead init: ignoreActors: 1 setCycle: Fwd)
		(crusherFoot
			init:
			ignoreActors: 1
			setCycle: Fwd
			cycleSpeed: 18
		)
		(knife
			ignoreActors:
			init:
			setPri: 13
			setLoop: 7
			setCycle: Fwd
			stopUpd:
			hide:
			setScript: knifeScript
		)
		(if (== gGModNum 340)
			(gLongSong fade: 127 20 5 0)
			(gEgo
				view: 4
				posn: 160 160
				loop: 3
				cel: 0
				ignoreActors:
				setCycle: Walk
				init:
			)
			(proc814_3)
			(chiefThief setScript: chiefBored)
		else
			(gLongSong number: 8 loop: -1 init: play:)
			(gEgo
				view: 4
				setLoop: 3
				cel: 0
				posn: 227 156
				ignoreActors:
				init:
			)
			(self setScript: rm332EntranceScript)
		)
	)
	
	(method (doit)
		(cond 
			(local4
				(if
					(<=
						(= local5
							(GetDistance
								(gEgo x?)
								(- (gEgo y?) 30)
								(knife x?)
								(knife y?)
								gPicAngle
							)
						)
						local6
					)
					(gEgo setScript: deathScript)
				)
			)
			(
			(and local9 (not local3) (== (knifeScript state?) 0)) (= local3 1) (localproc_018d))
		)
		(cond 
			(
				(and
					(not (borisThief script?))
					(not local1)
					(gEgo inRect: 139 109 212 127)
				)
				(= local1 1)
				(borisThief setScript: heComes)
			)
			(
				(and
					local1
					(not (borisThief script?))
					(not (gEgo inRect: 139 109 212 127))
				)
				(= local1 0)
				(borisThief setScript: heGoes)
			)
		)
		(super doit:)
	)
	
	(method (dispose)
		(= global451 0)
		(proc0_5 99)
		(super dispose:)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gQg1Messager say: 18 1 0))
			(4 (gQg1Messager say: 18 4 0))
			(16
				(proc0_2)
				(= local9 1)
				(gEgo setScript: uhOh)
			)
			(12
				(proc0_2)
				(= local9 1)
				(gEgo setScript: uhOh)
			)
			(20
				(proc0_2)
				(= local9 1)
				(gEgo setScript: uhOh)
			)
			(52
				(proc0_2)
				(gEgo setScript: throwEgoOut)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (cue)
		(switch local12
			(1 (gQg1Messager say: 4 1 8))
			(2 (gQg1Messager say: 4 1 7))
		)
	)
)

(instance onBoard of Feature
	(properties
		x 86
		y 55
		noun 3
		nsTop 55
		nsLeft 64
		nsBottom 92
		nsRight 108
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gQg1Messager say: 3 1 0 1)
				(if (> local8 5) (gQg1Messager say: 3 1 0 2))
			)
			(4
				(gQg1Messager say: 3 4)
				(if
					(and
						(gEgo has: 6)
						(or (>= (gEgo has: 0) 5) (>= (gEgo has: 38) 1))
					)
					(global2 setScript: goToDagnabit)
				)
			)
			(else 
				(global2 doVerb: theVerb &rest)
			)
		)
	)
)

(instance onDoor of Feature
	(properties
		x 166
		y 80
		noun 11
		nsTop 61
		nsLeft 143
		nsBottom 108
		nsRight 190
		sightAngle 40
		approachX 157
		approachY 116
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gQg1Messager say: 11 1))
			(4
				(gEgo setScript: toTheDoorScript)
			)
			(17 (gQg1Messager say: 11 17))
			(18 (gQg1Messager say: 11 17))
			(16
				(proc0_2)
				(= local9 1)
				(gEgo setScript: uhOh)
			)
			(else 
				(global2 doVerb: theVerb &rest)
			)
		)
	)
)

(instance onLadder of Feature
	(properties
		x 261
		y 78
		noun 14
		nsTop 9
		nsLeft 252
		nsBottom 147
		nsRight 271
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gQg1Messager say: 14 1))
			(4
				(gEgo setScript: leaveRoomScript)
			)
			(else 
				(global2 doVerb: theVerb &rest)
			)
		)
	)
)

(instance onLightFixture1 of Feature
	(properties
		x 22
		y 113
		noun 15
		nsTop 88
		nsLeft 12
		nsBottom 138
		nsRight 32
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 1)
			(gQg1Messager say: 15 1)
		else
			(global2 doVerb: theVerb &rest)
		)
	)
)

(instance onLightFixture2 of Feature
	(properties
		x 295
		y 134
		noun 15
		nsTop 110
		nsLeft 284
		nsBottom 158
		nsRight 306
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 1)
			(gQg1Messager say: 15 1)
		else
			(global2 doVerb: theVerb &rest)
		)
	)
)

(instance onCeiling of Feature
	(properties
		x 180
		y 38
		noun 6
		nsBottom 38
		nsRight 319
		sightAngle 40
		onMeCheck $0008
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 1)
			(gQg1Messager say: 6 1)
		else
			(global2 doVerb: theVerb &rest)
		)
	)
)

(instance onTrunk of Feature
	(properties
		x 218
		y 105
		noun 22
		nsTop 105
		nsLeft 202
		nsBottom 137
		nsRight 252
		sightAngle 40
		onMeCheck $0004
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 1)
			(gQg1Messager say: 22 1)
		else
			(global2 doVerb: theVerb &rest)
		)
	)
)

(instance onBarrels of Feature
	(properties
		x 218
		y 137
		noun 2
		nsTop 137
		nsLeft 166
		nsBottom 179
		nsRight 319
		sightAngle 40
		onMeCheck $0002
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 1)
			(gQg1Messager say: 2 1)
		else
			(global2 doVerb: theVerb &rest)
		)
	)
)

(instance onBoxes of Feature
	(properties
		x 83
		y 171
		noun 5
		nsTop 164
		nsBottom 178
		nsRight 167
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 1)
			(gQg1Messager say: 5 1)
		else
			(global2 doVerb: theVerb &rest)
		)
	)
)

(instance onTrap of Feature
	(properties
		x 251
		y 4
		noun 21
		nsLeft 246
		nsBottom 8
		nsRight 257
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 1)
			(gQg1Messager say: 21 1)
		else
			(global2 doVerb: theVerb &rest)
		)
	)
)

(instance onDaggers of Feature
	(properties
		x 232
		y 124
		z 65
		noun 10
		nsTop 45
		nsLeft 213
		nsBottom 73
		nsRight 251
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gQg1Messager say: 10 1))
			(4 (gQg1Messager say: 10 4))
			(else 
				(global2 doVerb: theVerb &rest)
			)
		)
	)
)

(instance onPottery of Feature
	(properties
		x 232
		y 154
		noun 17
		nsTop 80
		nsLeft 217
		nsBottom 104
		nsRight 248
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 1)
			(gQg1Messager say: 17 1)
		else
			(global2 doVerb: theVerb &rest)
		)
	)
)

(instance onTable of Feature
	(properties
		x 108
		y 119
		noun 19
		nsTop 119
		nsLeft 76
		nsBottom 156
		nsRight 140
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 1)
			(gQg1Messager say: 19 1)
		else
			(global2 doVerb: theVerb &rest)
		)
	)
)

(instance onOneKnife of Feature
	(properties
		x 82
		y 125
		noun 16
		nsTop 121
		nsLeft 79
		nsBottom 129
		nsRight 85
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gQg1Messager say: 16 1))
			(4 (gQg1Messager say: 16 4))
			(else 
				(global2 doVerb: theVerb &rest)
			)
		)
	)
)

(instance onCrock of Feature
	(properties
		x 122
		y 122
		noun 8
		nsTop 116
		nsLeft 108
		nsBottom 129
		nsRight 137
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 1)
			(gQg1Messager say: 8 1)
		else
			(global2 doVerb: theVerb &rest)
		)
	)
)

(instance onWindow of Feature
	(properties
		x 173
		y 81
		z 30
		noun 23
		nsTop 70
		nsLeft 164
		nsBottom 86
		nsRight 182
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 1)
			(gQg1Messager say: 23 1)
		else
			(global2 doVerb: theVerb &rest)
		)
	)
)

(instance chairArm of View
	(properties
		x 76
		y 148
		noun 7
		view 332
		loop 3
		cel 1
		priority 10
	)
	
	(method (doVerb theVerb)
		(chiefThief doVerb: theVerb &rest)
	)
)

(instance chair of View
	(properties
		x 72
		y 148
		noun 7
		view 332
		loop 3
		priority 5
		signal $0010
	)
	
	(method (doVerb theVerb)
		(chiefThief doVerb: theVerb &rest)
	)
)

(instance crusher of Prop
	(properties
		x 124
		y 119
		noun 9
		view 332
		loop 3
		cel 2
		priority 7
		signal $0010
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gQg1Messager say: 9 1))
			(4 (gQg1Messager say: 9 4))
			(2 (gQg1Messager say: 9 2))
			(else 
				(global2 doVerb: theVerb &rest)
			)
		)
	)
)

(instance fire1 of Prop
	(properties
		x 31
		y 96
		noun 15
		view 332
		loop 8
		cel 6
	)
	
	(method (doVerb theVerb)
		(onLightFixture1 doVerb: theVerb &rest)
	)
)

(instance fire2 of Prop
	(properties
		x 306
		y 110
		noun 15
		view 332
		loop 9
		cel 2
	)
	
	(method (doVerb theVerb)
		(onLightFixture1 doVerb: theVerb &rest)
	)
)

(instance crusherHead of Prop
	(properties
		x 116
		y 75
		noun 9
		view 332
		loop 4
		priority 8
		signal $0010
		cycleSpeed 36
	)
	
	(method (doVerb theVerb)
		(crusher doVerb: theVerb &rest)
	)
)

(instance crusherFoot of Prop
	(properties
		x 127
		y 117
		noun 9
		view 332
		loop 13
		cel 1
		signal $4000
		cycleSpeed 2
	)
	
	(method (doVerb theVerb)
		(crusher doVerb: theVerb &rest)
	)
)

(instance knife of Actor
	(properties
		x 91
		y 124
		noun 13
		yStep 7
		view 332
		loop 7
		cycleSpeed 1
		illegalBits $0000
		xStep 6
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 1)
			(gQg1Messager say: 13 1)
		else
			(global2 doVerb: theVerb &rest)
		)
	)
)

(instance chiefThief of Actor
	(properties
		x 91
		y 145
		noun 7
		view 332
		loop 5
		priority 10
		signal $4010
		illegalBits $0000
	)
	
	(method (init)
		(= global451 1332)
		(PalVary pvCHANGE_TARGET 1332)
		(kernel_128 332)
		(super init:)
	)
)

(instance borisThief of Actor
	(properties
		x 182
		y 87
		noun 4
		approachX 157
		approachY 116
		view 332
		loop 12
	)
)

(instance chiefTeller of Teller
	(properties)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gQg1Messager say: 7 1))
			(2
				(if (not (gEgo has: 9))
					(gEgo setScript: getTheLicense)
				else
					(proc814_10 gEgo chiefThief)
					(super doVerb: theVerb &rest)
				)
			)
			(10
				(if
					(and
						(gEgo has: 6)
						(or (>= (gEgo has: 0) 5) (>= (gEgo has: 38) 1))
					)
					(gLongSong fade: 63 20 5 0)
					(global2 newRoom: 340)
				else
					(gQg1Messager say: 7 4)
				)
			)
			(16
				(proc0_2)
				(= local9 1)
				(gEgo setScript: uhOh)
			)
			(12
				(proc0_2)
				(= local9 1)
				(gEgo setScript: uhOh)
			)
			(20
				(proc0_2)
				(= local9 1)
				(gEgo setScript: uhOh)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
		(return 1)
	)
)

(instance borisTeller of Teller
	(properties)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gQg1Messager say: 4 1 0 1 global2)
				(if (not (gEgo has: 9))
					(= local12 1)
				else
					(= local12 2)
				)
			)
			(4
				(cond 
					((not (gEgo has: 9)) (gQg1Messager say: 4 4 8))
					(
						(or
							(proc0_7 131)
							(proc0_7 133)
							(proc0_7 179)
							(proc0_7 181)
							(proc0_7 182)
						)
						(gQg1Messager say: 4 4 9)
					)
					(else (gQg1Messager say: 4 4 7))
				)
			)
			(2
				(if (not (gEgo has: 9))
					(gQg1Messager say: 4 2 8)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(10
				((= gNewList (List new:))
					add:
						((Clone Ware) name: {רישיון} price: {25})
						((Clone Ware) name: {פורץ מנעולים} price: {15})
						((Clone Ware) name: {ארגז כלים} price: {100})
				)
				(switch ((ScriptID 551 0) doit:)
					(-1 (gQg1Messager say: 4 10 12))
					(1
						(if (gEgo has: 9)
							(gQg1Messager say: 4 10 11)
							(= local13 1)
							(gEgo setScript: cueItScript)
						else
							(gQg1Messager say: 4 10 10)
							(proc814_26 639 3 2)
							(= local13 2)
							(gEgo setScript: cueItScript)
						)
					)
					(2
						(if (not (gEgo has: 7)) (= global175 10))
						(gQg1Messager say: 4 10 13)
						(= local13 3)
						(gEgo setScript: cueItScript)
					)
					(3
						(if (not (gEgo has: 8))
							(= global175 35)
							(proc814_26 640 3 2)
						)
						(gQg1Messager say: 4 10 13)
						(= local13 4)
						(gEgo setScript: cueItScript)
					)
				)
				(return 1)
			)
			(45
				(if (not (gEgo has: 9))
					(gQg1Messager say: 4 45 8)
				else
					(gQg1Messager say: 4 45 7)
					(proc814_26 641 3 2)
					(= local13 5)
					(gEgo setScript: cueItScript)
				)
			)
			(16
				(proc0_2)
				(= local9 1)
				(gEgo setScript: uhOh)
			)
			(41
				(if (not (gEgo has: 9))
					(gQg1Messager say: 4 41 8)
				else
					(gQg1Messager say: 4 41 7)
					(proc814_26 641 3 2)
					(= local13 6)
					(gEgo setScript: cueItScript)
				)
			)
			(43
				(if (not (gEgo has: 9))
					(gQg1Messager say: 4 43 8)
				else
					(gQg1Messager say: 4 43 7)
					(proc814_26 641 3 2)
					(= local13 7)
					(gEgo setScript: cueItScript)
				)
			)
			(44
				(if (not (gEgo has: 9))
					(gQg1Messager say: 4 44 8)
				else
					(gQg1Messager say: 4 44 7)
					(proc814_26 641 3 2)
					(= local13 8)
					(gEgo setScript: cueItScript)
				)
			)
			(42
				(if (not (gEgo has: 9))
					(gQg1Messager say: 4 42 8)
				else
					(gQg1Messager say: 4 42 7)
					(proc814_26 641 3 2)
					(= local13 9)
					(gEgo setScript: cueItScript)
				)
			)
			(28 (gQg1Messager say: 18 28))
			(12
				(proc0_2)
				(= local9 1)
				(gEgo setScript: uhOh)
			)
			(20
				(proc0_2)
				(= local9 1)
				(gEgo setScript: uhOh)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
		(return 1)
	)
)

(instance rm332EntranceScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_2) (= ticks 120))
			(1
				(if (not (proc0_7 99))
					(crusherFoot setCycle: 0)
					(crusherHead setCycle: 0)
					(gQg1Messager say: 18 0 46 0 self)
				else
					(= ticks 120)
				)
			)
			(2
				(crusherFoot setCycle: Fwd)
				(crusherHead setCycle: Fwd)
				(= ticks 30)
			)
			(3
				(proc814_3)
				(gGame setCursor: global21)
				(gEgo
					view: 0
					loop: 0
					cel: 0
					setCycle: Walk
					setMotion: PolyPath 155 157 self
				)
			)
			(4
				(if (proc0_7 99)
					(self changeState: 40)
					(= ticks 1)
				else
					(self cue:)
				)
			)
			(5
				(knife hide:)
				(gQg1Messager say: 7 0 22)
				(gEgo view: 4 setLoop: 3)
				(chiefThief setLoop: 2 setCycle: End self)
			)
			(6
				(chiefThief
					setLoop: 0
					setCel: 0
					setCycle: Walk
					setMotion: MoveTo 210 136 self
				)
			)
			(7
				(chiefThief setLoop: 1 setMotion: MoveTo 180 136 self)
				(gQg1Messager say: 7 0 24)
			)
			(8
				(chiefThief setLoop: 1 setMotion: MoveTo 150 136 self)
			)
			(9
				(chiefThief setLoop: 0 setMotion: MoveTo 190 136 self)
			)
			(10
				(chiefThief setLoop: 1 setMotion: MoveTo 100 136 self)
			)
			(11
				(chiefThief setLoop: 0 setMotion: MoveTo 94 136 self)
			)
			(12
				(chiefThief
					setLoop: 2
					posn: 91 145
					cel: 9
					setCycle: Beg self
				)
			)
			(13
				(chiefThief setLoop: 5 setCel: 0)
				(= seconds 3)
			)
			(14
				(gQg1Messager say: 7 0 23)
				(proc0_5 99)
				(self cue:)
			)
			(15
				(localproc_018d)
				(self changeState: 40)
			)
			(40
				(gEgo setPri: -1)
				(proc814_3)
				(proc0_3)
				(chiefThief setScript: chiefBored)
				(self dispose:)
			)
		)
	)
)

(instance leaveRoomScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setCycle: Walk setMotion: PolyPath 240 150 self)
			)
			(1
				(gNewCast eachElementDo: #dispose)
				(global2 drawPic: 400 -32762)
				(self cue:)
			)
			(2 (global2 newRoom: 331))
		)
	)
)

(instance throwEgoOut of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc814_3 3 0 4)
				(proc0_2)
				(gEgo
					setMotion: PolyPath (crusher x?) (+ (crusher y?) 30) self
				)
			)
			(1
				(crusherHead hide: dispose:)
				(crusher view: 338 loop: 0 setCycle: End self)
			)
			(2
				(crusher cel: 2)
				(= cycles 3)
			)
			(3 (crusher setCycle: End self))
			(4
				(gNewCast eachElementDo: #dispose)
				(global2 drawPic: 400 -32761)
				(self cue:)
			)
			(5
				(proc0_5 117)
				(global2 newRoom: 330)
			)
		)
	)
)

(instance chiefBored of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 5 12)))
			(1
				(localproc_018d)
				(self changeState: 0)
			)
		)
	)
)

(instance knifeScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(knife posn: 91 124 cel: 0)
				(chiefThief setLoop: 5 cel: 0)
			)
			(1
				(knife show:)
				(chiefThief setLoop: 5 cel: 0 setCycle: End)
				(= cycles 1)
			)
			(2
				(= local4 1)
				(dagMusic number: (proc814_25 31) play:)
				(if local9
					(knife setMotion: MoveTo (gEgo x?) (- (gEgo y?) 30))
				else
					(knife setMotion: MoveTo 91 95)
				)
				(= cycles 12)
			)
			(3
				(knife setMotion: MoveTo 91 124 self)
			)
			(4
				(chiefThief loop: 6 cel: 0 posn: 91 145)
				(knife hide:)
				(= seconds 2)
			)
			(5
				(chiefThief setCycle: End)
				(if local9
					(knife
						show:
						setMotion: MoveTo (gEgo x?) (- (gEgo y?) 30) self
					)
				else
					(knife
						show:
						setMotion: MoveTo (Random 80 95) (Random 67 85) self
					)
				)
			)
			(6
				(dagMusic stop:)
				(dagMusic
					number: (if (Random 0 1) (proc814_25 30) else (proc814_25 29))
					play:
				)
				(= local4 0)
				(if (< local10 12)
					(++ local0)
					((= newKnife (Knife new:))
						view: 332
						loop: 7
						cel: 1
						posn: (knife x?) (knife y?)
						init:
						stopUpd:
					)
					(++ local10)
				)
				(knife hide:)
				(= cycles 2)
			)
			(7 (self changeState: 0))
		)
	)
)

(instance toTheDoorScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setMotion: PolyPath 157 116 self)
			)
			(1
				(gQg1Messager say: 18 0 47)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance deathScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(knife setMotion: 0 hide:)
				(gEgo
					view: 503
					posn: (+ (gEgo x?) 5) (gEgo y?)
					setLoop: 0
					cel: 0
					setCycle: CT 5 1
				)
				(= cycles 15)
			)
			(1 (gEgo setCycle: End self))
			(2 (proc814_0 47 48 0 0 800))
		)
	)
)

(instance uhOh of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(proc814_10 gEgo chiefThief self)
			)
			(1 (= seconds 2))
			(2 (proc814_0 47 48 0 0 800))
		)
	)
)

(instance heComes of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(borisThief
					approachVerbs: 4 10
					init:
					loop: 12
					cel: 0
					setCycle: End self
				)
			)
			(1
				(borisThief setLoop: 10 setCel: 0)
				(self cue:)
			)
			(2 (self dispose:))
		)
	)
)

(instance heGoes of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(borisThief loop: 11 cel: 0 setCycle: End self)
			)
			(1
				(borisThief dispose: delete:)
				(self dispose:)
			)
		)
	)
)

(instance getTheLicense of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(proc814_10 gEgo chiefThief)
				(= seconds 3)
			)
			(1
				(localproc_0182)
				(self cue:)
			)
			(2 (proc0_3) (self dispose:))
		)
	)
)

(instance goToDagnabit of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_2) (= ticks 60))
			(1
				(gLongSong fade: 63 20 5 0)
				(global2 newRoom: 340)
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
				(switch local13
					(1 (gEgo get: 0 25))
					(2 (gEgo get: 9))
					(3 (gEgo get: 7))
					(4 (gEgo get: 8))
					(5
						(gEgo get: 38 50)
						(gEgo use: 35)
					)
					(6
						(gEgo use: 31)
						(gEgo get: 38 4)
					)
					(7
						(gEgo use: 33)
						(gEgo get: 38 9)
					)
					(8
						(gEgo use: 34)
						(gEgo get: 38 10)
					)
					(9
						(gEgo use: 32)
						(gEgo get: 38 15)
					)
				)
				(self cue:)
			)
			(2 (self dispose:))
		)
	)
)

(instance dagMusic of Sound
	(properties
		number 31
	)
)

(instance chiefThiefTalker of Talker
	(properties
		x 10
		y 10
		view 1332
		talkWidth 260
		textX 15
		textY 110
	)
	
	(method (init)
		(= global451 2332)
		(PalVary pvCHANGE_TARGET 2332)
		(kernel_128 1332)
		(= font gFont)
		(super
			init: chiefThiefBust chiefThiefEye chiefThiefMouth &rest
		)
	)
)

(instance chiefThiefBust of Prop
	(properties
		view 1332
	)
)

(instance chiefThiefMouth of Prop
	(properties
		nsTop 45
		nsLeft 41
		view 1332
		loop 1
	)
)

(instance chiefThiefEye of Prop
	(properties
		nsTop 14
		nsLeft 41
		view 1332
		loop 2
	)
)
