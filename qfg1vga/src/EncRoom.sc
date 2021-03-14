;;; Sierra Script 1.0 - (do not remove this comment)
(script# 210)
(include sci.sh)
(use Main)
(use n101)
(use n102)
(use n104)
(use n106)
(use TargActor)
(use n814)
(use n816)
(use Print)
(use PChase)
(use PolyPath)
(use Cycle)
(use Game)
(use User)
(use Obj)

(public
	Encounter 0
	smallMonster 1
)

(local
	local0
	local1
	local2
	local3
	theSmallMonster
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	[theTheSmallMonsterX 30]
	[local44 12] = [500 40 40 40 60 50 30 35 40 50 30 40]
	[theGMonsterHealth 12] = [10000 133 186 53 86 113 60 140 93 186 60 100]
	local68
	local69
	local70
)
(procedure (localproc_00c6 param1 &tmp temp0)
	(return
		(if (and (<= 420 param1) (<= param1 470))
			(return (+ 1 (/ (- param1 420) 5)))
		else
			(return 0)
		)
	)
)

(procedure (localproc_00ea)
	(cond 
		((> gGEgoX 310) (= local1 2))
		((< gGEgoX 10) (= local1 4))
		((< gGEgoY 100) (= local1 1))
		(else (= local1 3))
	)
)

(procedure (localproc_0117 param1)
	(proc0_6 351)
	(= local7 1)
	(= local8 1)
	(if
		(or
			(not theSmallMonster)
			(not (gNewCast contains: theSmallMonster))
		)
		((= theSmallMonster smallMonster) init:)
	)
	(= local5 (+ global279 1))
	(proc814_16
		4
		(/ [theGMonsterHealth (localproc_00c6 global279)] 12)
	)
	(if param1
		(theSmallMonster setLoop: 1)
		(cond 
			((proc999_5 gModNum 19 43 75 92)
				(gEgo posn: 164 108)
				(if (!= global279 435)
					(theSmallMonster posn: 88 112)
				else
					(theSmallMonster posn: 150 100)
				)
			)
			((== gModNum 79) (gEgo posn: 120 120) (theSmallMonster posn: 220 120))
			(
			(and (proc999_5 gModNum 19 43 86) (== global279 465)) (gEgo posn: 140 120) (theSmallMonster posn: 60 120))
			((== global279 435) (gEgo posn: 150 120) (theSmallMonster posn: 150 100))
			((== global279 460) (gEgo posn: 120 120) (theSmallMonster posn: 293 128))
			((== global279 440) (gEgo posn: 150 120) (theSmallMonster posn: 235 134))
			(else (gEgo posn: 150 122) (theSmallMonster posn: 220 137))
		)
	)
	(gEgo
		loop: 1
		illegalBits: (global2 illBits?)
		ignoreControl: -32768
		ignoreActors:
		init:
	)
	(proc814_3)
	(proc814_2 0 0)
	(theSmallMonster setScript: killTheMonster)
)

(procedure (localproc_02d9 param1)
	(param1
		illegalBits: 0
		setMotion: PChase gEgo [local44 (localproc_00c6 global279)] Encounter
	)
	(= local68 1)
	(param1 setScript: 0)
)

(procedure (localproc_0ce7 param1 &tmp temp0 temp1)
	(if (and argc param1)
		(= temp1 param1)
	else
		(cond 
			((< [gStrength 13] 1000) (= temp0 (Random 0 3)))
			((< [gStrength 13] 2000) (= temp0 (Random 0 6)))
			(else (= temp0 (Random 2 6)))
		)
		(if global117 (= temp0 (+ temp0 2)))
		(= temp1
			(switch temp0
				(0 445)
				(1 430)
				(2 445)
				(3 465)
				(4 435)
				(5 440)
				(6 460)
				(else  450)
			)
		)
	)
	(if (proc999_5 gModNum 85 86 92)
		(if (or (<= temp0 4) (not global117))
			(= temp1 465)
		else
			(= temp1 450)
		)
	)
	(= global262 0)
	(cond 
		((== temp1 445) (= global262 (Random 1 10)))
		((== temp1 465) (= global262 (Random 5 25)))
		((== temp1 450) (= global262 (Random 20 50)))
		((== temp1 425) (= global262 50))
	)
	(= global425 (| global425 $0008))
	(return temp1)
)

(procedure (localproc_0e23 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 [temp5 40])
	(= temp2 (& (global2 entrances?) $000a))
	(= temp4 (& (global2 entrances?) $0008))
	(= temp3 (& (global2 entrances?) $0002))
	(param2 view: param1)
	(if (!= param1 435)
		(param2 xStep: 6 yStep: 4 cel: 0)
		(switch param1
			(430
				(param2 xStep: 5 yStep: 3 setCycle: Fwd)
			)
			(450
				(param2 xStep: 5 yStep: 3 setCycle: Walk)
			)
			(440
				(param2 xStep: 6 yStep: 3 setCycle: Fwd)
			)
			(445
				(param2 xStep: 4 yStep: 2 setCycle: Walk)
			)
			(465
				(param2 xStep: 3 yStep: 2 setCycle: Walk)
			)
			(460
				(param2 xStep: 8 yStep: 5 setCycle: Fwd)
			)
		)
		(if global186
			(param2
				xStep: (* (param2 xStep?) 2)
				yStep: (* (param2 yStep?) 2)
			)
		)
	)
	(cond 
		(local2
			(proc814_32 1)
			(if (== param1 435)
				(theSmallMonster
					setCycle: Walk
					z: 25
					xStep: (Random 4 8)
					yStep: (Random 3 5)
				)
			)
			(= local68 1)
			(switch local1
				(1
					(if
						(or
							(== param1 445)
							(== param1 450)
							(== param1 465)
							(== param1 455)
						)
						(gEgo setMotion: MoveTo gGEgoX (- gGEgoY 2))
						(theSmallMonster
							posn:
								(+ (gEgo x?) (Random 20 40))
								(+
									(gEgo y?)
									[local44 (localproc_00c6 param1)]
									(Random 20 30)
								)
							setCel: -1
							setLoop: 3
						)
						(theSmallMonster setScript: runDelay)
					else
						(gEgo setMotion: MoveTo 320 gGEgoY)
						(theSmallMonster
							posn:
								(-
									(gEgo x?)
									(+ [local44 (localproc_00c6 param1)] (Random 25 40))
								)
								(gEgo y?)
							setLoop: 0
							setCel: -1
						)
						(theSmallMonster setScript: runDelay)
					)
				)
				(3
					(if
						(or
							(== param1 445)
							(== param1 450)
							(== param1 465)
							(== param1 455)
						)
						(gEgo setMotion: MoveTo gGEgoX (+ gGEgoY 2))
						(switch (global2 picture?)
							(704
								(theSmallMonster posn: 209 87 setLoop: 2)
							)
							(705
								(theSmallMonster posn: 61 78 setLoop: 2)
							)
							(else 
								(theSmallMonster
									setLoop: 2
									posn:
										(- (gEgo x?) 10)
										(-
											(gEgo y?)
											(+ [local44 (localproc_00c6 param1)] (Random 20 30))
										)
								)
							)
						)
						(theSmallMonster setCel: -1)
						(theSmallMonster setScript: runDelay)
					else
						(gEgo setMotion: MoveTo 0 gGEgoY)
						(theSmallMonster
							posn:
								(+
									(gEgo x?)
									[local44 (localproc_00c6 param1)]
									(Random 25 40)
								)
								(gEgo y?)
							setLoop: 1
							setCel: -1
						)
						(theSmallMonster setScript: runDelay)
					)
				)
				(2
					(gEgo setMotion: MoveTo 320 gGEgoY)
					(theSmallMonster
						posn:
							(-
								(gEgo x?)
								(+ [local44 (localproc_00c6 param1)] (Random 25 40))
							)
							(gEgo y?)
						setLoop: 0
						setCel: -1
					)
					(theSmallMonster setScript: runDelay)
				)
				(4
					(gEgo setMotion: MoveTo 0 gGEgoY)
					(theSmallMonster
						posn:
							(+
								(gEgo x?)
								[local44 (localproc_00c6 param1)]
								(Random 25 40)
							)
							(gEgo y?)
						setLoop: 1
						setCel: -1
					)
					(theSmallMonster setScript: runDelay)
				)
			)
			(User canControl: 1)
		)
		(local3
			(if (== param1 435)
				(theSmallMonster
					setCycle: Walk
					z: 25
					xStep: (Random 4 8)
					yStep: (Random 3 5)
				)
			)
			(= local68 1)
			(switch local1
				(1
					(= local68 0)
					(gEgo setMotion: MoveTo gGEgoX 190)
					(if
						(or
							(== param1 445)
							(== param1 450)
							(== param1 465)
							(== param1 455)
						)
						(theSmallMonster setScript: northDelay)
					else
						(= param1 (= gMonsterHealth 0))
						(theSmallMonster dispose:)
						(= global279 0)
						(= local68 0)
					)
				)
				(3
					(gEgo setMotion: MoveTo gGEgoX 0)
					(if
						(or
							(== param1 445)
							(== param1 450)
							(== param1 465)
							(== param1 455)
						)
						(theSmallMonster setScript: southDelay)
					else
						(= global279 (= gMonsterHealth 0))
						(theSmallMonster dispose:)
						(= global279 0)
						(= local68 0)
					)
				)
				(2
					(gEgo setMotion: MoveTo 0 gGEgoY)
					(theSmallMonster
						posn: (- gGEgoX global114) (+ gGEgoY global115)
						loop: 1
						setCel: -1
						setLoop: -1
						setMotion: PChase gEgo [local44 (localproc_00c6 param1)] Encounter
					)
				)
				(4
					(gEgo setMotion: MoveTo 320 gGEgoY)
					(theSmallMonster
						posn: (- gGEgoX global114) (+ gGEgoY global115)
						loop: 0
						setCel: -1
						setLoop: -1
						setMotion: PChase gEgo [local44 (localproc_00c6 param1)] Encounter
					)
				)
			)
		)
		((== param1 435) (theSmallMonster setScript: (ScriptID 436 2)))
		((== temp2 10)
			(switch (= temp2 (if (< (Random 0 1000) 500) 8 else 2))
				(2 (param2 setScript: inEast))
				(8 (param2 setScript: inWest))
			)
		)
		(temp3 (param2 setScript: inEast))
		(temp4 (param2 setScript: inWest))
		(else
			(= temp0 (global2 ambushX?))
			(= temp1 (global2 ambushY?))
			(param2
				posn: temp0 temp1
				setMotion: PChase gEgo [local44 (localproc_00c6 param1)] Encounter
			)
		)
	)
)

(procedure (localproc_17cf &tmp [temp0 120] [temp120 70])
	(switch global262
		(0
			(gQg1Messager say: 2 0 13 0 0 210)
		)
		(1
			(proc921_0
				{אתה מוצא מטבע כסף בודדת, מבריק אותה בזהירות, ותוקע אותה בארנקך. גם זו דרך להתפרנס!}
			)
			(gEgo get: 0 1)
		)
		(else 
			(proc921_1
				@temp120
				{אתה מוצא %d מטבעות כסף, ומניח אותם בדקדקנות בארנקך.}
				global262
			)
			(gEgo get: 0 global262)
		)
	)
	(= global262 0)
)

(class EncRoom of Rm
	(properties
		script 0
		number 0
		modNum -1
		noun 0
		timer 0
		keep 0
		initialized 0
		picture 0
		style $ffff
		horizon 0
		controls 0
		north 0
		east 0
		south 0
		west 0
		curPic 0
		picAngle 0
		vanishingX 160
		vanishingY 0
		obstacles 0
		inset 0
		encChance 0
		entrances 15
		ambushX 160
		ambushY 100
		illBits -32768
	)
)

(instance smallMonster of TargActor
	(properties
		noun 3
		modNum 210
		view 435
		signal $6000
		illegalBits $0000
	)
	
	(method (init)
		(if (!= global279 465)
			(= global451 (+ global279 1000))
			(PalVary pvCHANGE_TARGET (+ global279 1000))
		)
		(cond 
			((== global279 435))
			(
				(or
					(== global279 455)
					(== global279 450)
					(== global279 465)
					(== global279 445)
				)
				(self looper: aLooper4)
			)
			(else (self looper: aLooper2))
		)
		(switch global279
			(425 (self targDeltaY: -35))
			(430
				(self targDeltaX: 5)
				(self targDeltaY: -32)
			)
			(435 (self targDeltaX: -40))
			(440
				(self targDeltaX: 7)
				(self targDeltaY: -22)
			)
			(445
				(self targDeltaX: -3)
				(self targDeltaY: -19)
			)
			(450
				(self targDeltaX: -5)
				(self targDeltaY: -32)
			)
			(455 (self targDeltaY: -30))
			(460
				(self targDeltaX: 7)
				(self targDeltaY: -28)
			)
			(465 (self targDeltaY: -27))
		)
		(super init: &rest)
	)
	
	(method (doVerb theVerb)
		(return
			(switch theVerb
				(12
					(if local7
						(proc814_5)
					else
						(global2 newRoom: global279)
					)
				)
				(20
					(if local7 (proc814_5) else (proc102_0 smallMonster))
				)
				(16
					(if local7 (proc814_5) else (proc101_0 smallMonster))
				)
				(1
					(if local7
						(gQg1Messager say: 3 1 20 0 0 210)
					else
						(switch global279
							(445
								(gQg1Messager say: 3 1 19 0 0 210)
							)
							(465
								(gQg1Messager say: 3 1 16 0 0 210)
							)
							(430
								(gQg1Messager say: 3 1 24 0 0 210)
							)
							(460
								(gQg1Messager say: 3 1 18 0 0 210)
							)
							(440
								(gQg1Messager say: 3 1 18 0 0 210)
							)
							(455
								(gQg1Messager say: 3 1 22 0 0 210)
							)
							(450
								(gQg1Messager say: 3 1 15 0 0 210)
							)
							(435
								(gQg1Messager say: 3 1 21 0 0 210)
							)
							(else 
								(gQg1Messager say: 3 1 21 0 0 210)
							)
						)
					)
				)
				(48
					(gQg1Messager say: 3 48 0 0 0 210)
				)
				(4
					(if local7
						(if local0
							(proc814_5)
						else
							(gEgo setScript: searchIt 0 theSmallMonster)
						)
					else
						(global2 newRoom: global279)
					)
					(return 1)
				)
				(else 
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
	
	(method (cue)
		(if local13 (= local13 0) (localproc_17cf))
	)
	
	(method (getHurt param1)
		(= local69 1)
		(= local70 0)
		(= gMonsterHealth (- gMonsterHealth param1))
	)
)

(instance Encounter of Rgn
	(properties
		modNum 210
		noun 1
	)
	
	(method (init &tmp temp0 temp1)
		(= local12 1)
		(gMH addToFront: self)
		(gKH addToFront: self)
		(proc0_3)
		(ScriptID 930)
		(Load rsSCRIPT 816)
		(super init: &rest)
		(= local3 (= local2 (= local69 0)))
		(= theSmallMonster 0)
		(cond 
			(
				(not
					(proc999_5
						gGModNum
						420
						425
						430
						435
						440
						445
						455
						450
						460
						465
						470
					)
				)
				(if global279
					(if (and (== global279 450) (not global117))
						(gEgo illegalBits: (global2 illBits?) init:)
						(= global279 (= gMonsterHealth 0))
						(Animate (gNewCast elements?) 0)
						(gQg1Messager say: 1 0 1 1 0 210)
					else
						(= local3 1)
						(gEgo illegalBits: (global2 illBits?) init:)
						(= local6 (= local7 0))
						(localproc_0ce7 global279)
					)
				else
					(= temp0 (global2 encChance?))
					(if global117 (= temp0 (* temp0 2)))
					(if (proc0_7 87) (= temp0 (* temp0 2)))
					(if (== gGModNum 45) (= temp0 0))
					(cond 
						((> (proc814_14) temp0))
						(
							(and
								(== global100 2)
								(proc814_15 8 temp0)
								(proc814_15 4 0 0)
							)
							(Animate (gNewCast elements?) 0)
							(gQg1Messager say: 1 0 3 2 0 210)
						)
						(else
							(= global279 (localproc_0ce7 0))
							(= gMonsterHealth
								[theGMonsterHealth (localproc_00c6 global279)]
							)
							(= local6 (= local7 0))
						)
					)
					(gEgo illegalBits: (global2 illBits?))
				)
			)
			((<= gMonsterHealth 0) (localproc_0117 1))
			(else
				(= local6 (= local7 0))
				(proc814_2 1 0)
				(= local2 1)
				(proc814_3)
				(gEgo
					illegalBits: (global2 illBits?)
					posn: 160 140
					init:
				)
				(localproc_0ce7 global279)
			)
		)
		(localproc_00ea)
	)
	
	(method (doit)
		(cond 
			(
				(and
					(not local6)
					(not local7)
					global279
					(or local3 (gEgo inRect: 40 40 260 160))
				)
				(= local6 1)
				((= theSmallMonster smallMonster) posn: 0 1000 init:)
				(localproc_0e23 global279 theSmallMonster)
			)
			((and (== global279 435) (proc0_7 351)) (localproc_0117 0))
			(
				(and
					local6
					global279
					(not local8)
					(<= gMonsterHealth 0)
					(not (proc0_7 351))
				)
				(localproc_0117 0)
			)
		)
		(super doit: &rest)
	)
	
	(method (dispose)
		(= global451 0)
		(= global425 0)
		(DisposeScript 930)
		(DisposeScript 816)
		(DisposeScript 436)
		(super dispose: &rest)
		(DisposeScript 210)
	)
	
	(method (doVerb theVerb)
		(return
			(switch theVerb
				(80
					(if (or local68 (== global279 435))
						(theSmallMonster setScript: spellDelay 0 22)
						(return 1)
					else
						(gQg1Messager say: 1 58 0 1 0 210)
						(return 1)
					)
				)
				(51
					(gQg1Messager say: 1 58 0 2 0 210)
					(return 1)
				)
				(50
					(gQg1Messager say: 1 58 0 3 0 210)
					(return 1)
				)
				(78
					(if (or local68 (== global279 435))
						(theSmallMonster setScript: spellDelay 0 20)
					else
						(gQg1Messager say: 1 58 0 4 0 210)
					)
					(return 1)
				)
				(79
					(= global229 (+ 5 (/ [gStrength 21] 10)))
					(if (or (gEgo has: 6) (gEgo has: 2))
						(gQg1Messager say: 1 58 0 5 0 210)
					else
						(gQg1Messager say: 1 58 0 6 0 210)
					)
					(return 1)
				)
				(82
					(if local6
						(gQg1Messager say: 1 58 0 7 0 210)
					else
						(gQg1Messager say: 1 58 0 8 0 210)
					)
					(return 1)
				)
				(else 
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
	
	(method (cue)
		(if (and local12 global279 (> gMonsterHealth 0))
			(= local12 0)
			(proc814_2 0 0)
			(if (and local12 (or local2 local3))
				(self setScript: checkProject 0 0)
			else
				(self setScript: checkProject 0 1)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(proc0_2)
		(if local6
			(= global114 (- (gEgo x?) (theSmallMonster x?)))
			(= global115 (- (gEgo y?) (theSmallMonster y?)))
		)
		(if
			(or
				local7
				(> global114 250)
				(> global115 180)
				(and
					(not
						(proc999_5
							newRoomNumber
							420
							425
							430
							435
							440
							445
							455
							450
							460
							465
							470
						)
					)
					(not
						(proc999_5
							newRoomNumber
							11
							12
							17
							18
							19
							23
							24
							25
							26
							27
							33
							34
							35
							36
							42
							43
							44
							51
							52
							56
							57
							61
							62
							63
							69
							71
							72
							74
							75
							79
							80
							81
							85
							86
							92
						)
					)
				)
			)
			(= global279 (= gMonsterHealth 0))
			(= global243 0)
		)
		(proc0_6 351)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance checkProject of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and global279 (> gMonsterHealth 0))
					(proc0_2)
					(if (not register)
						(gEgo setMotion: 0)
						(smallMonster setMotion: 0)
						(gQg1Messager say: 1 0 2 3 self 210)
					else
						(gEgo setMotion: 0)
						(smallMonster setMotion: 0)
						(gQg1Messager say: 1 0 4 4 self 210)
					)
				else
					(= ticks 1)
				)
			)
			(1 (proc0_2) (= ticks 20))
			(2
				(cond 
					((IsObject gClient) (-- state) (gClient dispose:) (= cycles 2))
					((and global279 (> gMonsterHealth 0))
						(if (IsObject gNarrator) (gNarrator dispose:))
						(if (IsObject gNewEventHandler)
							(gNewEventHandler dispose:)
						)
						(global2 newRoom: global279)
					)
					(else (proc0_3) (self dispose:))
				)
			)
		)
	)
)

(instance inWest of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					setLoop: 0
					posn: -100 106
					setMotion: MoveTo 0 106 self
				)
			)
			(1 (localproc_02d9 client))
		)
	)
)

(instance inEast of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					setLoop: 1
					posn: 400 106
					setMotion: MoveTo 310 106 self
				)
			)
			(1 (localproc_02d9 client))
		)
	)
)

(instance northDelay of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= ticks 90))
			(1
				(theSmallMonster
					posn:
						gGEgoX
						(cond 
							((> (global2 horizon?) (- gGEgoY global115)) (- (global2 horizon?) 20))
							((== global279 435) -10)
							(else (- gGEgoY global115))
						)
					setCel: -1
					setLoop: -1
					setMotion: PChase gEgo [local44 (localproc_00c6 global279)] Encounter
				)
				(= local68 1)
				(client setScript: 0)
			)
		)
	)
)

(instance southDelay of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= ticks 90))
			(1
				(theSmallMonster
					posn: gGEgoX (if (== global279 435) 235 else (- gGEgoY global115))
					setCel: -1
					setLoop: -1
					setMotion: PChase gEgo [local44 (localproc_00c6 global279)] Encounter
				)
				(= local68 1)
				(client setScript: 0)
			)
		)
	)
)

(instance runDelay of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: 0)
				(= ticks 90)
			)
			(1
				(client
					setCycle: Fwd
					setMotion: PChase gEgo [local44 (localproc_00c6 global279)] Encounter
				)
				(client setScript: 0)
			)
		)
	)
)

(instance spellDelay of Script
	(properties)
	
	(method (doit)
		(if (and seconds local69 (not local70))
			(= seconds 0)
			(= cycles 1)
		)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local68 0)
				(theSmallMonster setCycle: 0 setMotion: 0 ignoreActors: 0)
				(if (== register 22)
					(if (not (proc104_0 self self)) (self changeState: 4))
				else
					(self changeState: 2)
				)
			)
			(1
				(= state 3)
				(cond 
					((== global279 435)
						(proc921_0
							{לרוע המזל, המנטרי אינו מושפע כלל מלחשיך.}
						)
						(= ticks 1)
					)
					(local69
						(proc921_0
							{המפלצת אינה רגועה כלל וכלל. אולי היא לא אוהבת שמכאיבים לה.}
						)
						(= ticks 1)
					)
					(else (= seconds (+ 5 (/ [gStrength 22] 10))))
				)
			)
			(2
				(= local70 1)
				(if (not (proc106_0 self self)) (self changeState: 4))
			)
			(3
				(if (== global279 435)
					(proc921_0
						{לרוע המזל, המנטרי אינו מושפע כלל מלחשיך.}
					)
					(= ticks 1)
				else
					(= seconds (+ 3 (/ [gStrength 22] 10)))
				)
			)
			(4
				(if (not local8)
					(if
						(or
							(== global279 445)
							(== global279 450)
							(== global279 465)
							(== global279 455)
							(and
								(< -15 (- (gEgo x?) (theSmallMonster x?)))
								(< (- (gEgo x?) (theSmallMonster x?)) 15)
							)
						)
						(theSmallMonster setLoop: -1 setCycle: Walk)
					else
						(theSmallMonster setCycle: Fwd)
					)
					(theSmallMonster
						ignoreActors:
						setMotion: PChase gEgo [local44 (localproc_00c6 global279)] Encounter
					)
					(= local68 1)
				)
				(= local70 0)
				(self dispose:)
			)
		)
	)
)

(instance searchIt of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				((= theSmallMonster register) ignoreActors:)
				(= local10
					(switch global279
						(430 -1)
						(440 1)
						(460 71)
						(445 -26)
						(435 33)
						(465 19)
						(425 38)
						(455 -34)
						(450 11)
						(else  13)
					)
				)
				(= local11
					(switch global279
						(430 -7)
						(440 -17)
						(460 -20)
						(445 -15)
						(435 -7)
						(465 -10)
						(425 -16)
						(455 -17)
						(450 -17)
						(else  -14)
					)
				)
				(if
				(and (== global279 460) (theSmallMonster loop?))
					(= local10 -58)
				)
				(proc0_2)
				(gEgo
					ignoreActors:
					setMotion:
						PolyPath
						(+ (theSmallMonster x?) local10)
						(+ (theSmallMonster y?) local11)
						self
				)
			)
			(1
				(gEgo
					view: 510
					setLoop:
						(cond 
							((== global279 445) 0)
							((== global279 465) 1)
							(else (mod (gEgo loop?) 2))
						)
					setCycle: End self
				)
			)
			(2 (gEgo setCycle: Beg self))
			(3
				(gQg1Messager say: 2 0 0 1 self 210)
			)
			(4
				(cond 
					((== global279 450)
						(if (proc0_7 308)
							(gEgo get: 37)
							(= local13 1)
							(gQg1Messager say: 2 0 6 2 smallMonster 210)
						else
							(localproc_17cf)
						)
					)
					((== global279 440)
						(if (proc0_7 350)
							(gEgo get: 36 (Random 4 10))
							(gQg1Messager say: 2 60 14 1 0 210)
						else
							(localproc_17cf)
						)
					)
					(else (localproc_17cf))
				)
				(gEgo
					view: 0
					setLoop: -1
					setCycle: Walk
					setMotion:
						PolyPath
						185
						(if (< (gEgo x?) (theSmallMonster x?)) 140 else 160)
						self
				)
			)
			(5
				(if (and (== global279 450) (not (proc0_7 308)))
					(gQg1Messager say: 2 60 15 1 0 210)
				)
				(= local0 1)
				(proc814_3 2 4)
				(gEgo illegalBits: (global2 illBits?))
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance killTheMonster of Script
	(properties)
	
	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(proc0_2)
				(= global425 0)
				(if (!= global279 435)
					(theSmallMonster
						view: local5
						setLoop:
							(if (> (theSmallMonster loop?) 1)
								0
							else
								(theSmallMonster loop?)
							)
						cel: 0
						ignoreActors:
						setMotion: 0
						cycleSpeed: 8
					)
					(if (== theSmallMonster 450)
						(theSmallMonster setLoop: 0)
					)
					(if (!= global279 445)
						(theSmallMonster setCycle: End self)
					else
						(= ticks 1)
					)
				else
					(self setScript: (ScriptID 436 3) self theSmallMonster)
				)
			)
			(1
				(= temp0 (theSmallMonster x?))
				(= temp1 (theSmallMonster y?))
				(theSmallMonster stopUpd:)
				(gEgo ignoreActors:)
				(proc0_3)
				(switch global279
					(445
						(if (not (theSmallMonster loop?))
							(= [theTheSmallMonsterX 0] (+ temp0 31))
							(= [theTheSmallMonsterX 1] (- temp1 17))
							(= [theTheSmallMonsterX 2] (+ temp0 11))
							(= [theTheSmallMonsterX 3] (+ temp1 4))
							(= [theTheSmallMonsterX 4] (- temp0 20))
							(= [theTheSmallMonsterX 5] (+ temp1 5))
							(= [theTheSmallMonsterX 6] (- temp0 26))
							(= [theTheSmallMonsterX 7] (- temp1 15))
							(= [theTheSmallMonsterX 8] temp0)
							(= [theTheSmallMonsterX 9] (- temp1 30))
							(= [theTheSmallMonsterX 10] 30583)
							(= [theTheSmallMonsterX 11] 0)
							(proc816_0 @theTheSmallMonsterX 2)
						else
							(= [theTheSmallMonsterX 0] (+ temp0 4))
							(= [theTheSmallMonsterX 1] (- temp1 20))
							(= [theTheSmallMonsterX 2] (+ temp0 31))
							(= [theTheSmallMonsterX 3] (- temp1 14))
							(= [theTheSmallMonsterX 4] (+ temp0 27))
							(= [theTheSmallMonsterX 5] (- temp1 5))
							(= [theTheSmallMonsterX 6] (- temp0 17))
							(= [theTheSmallMonsterX 7] (+ temp1 5))
							(= [theTheSmallMonsterX 8] (- temp0 27))
							(= [theTheSmallMonsterX 9] (- temp1 16))
							(= [theTheSmallMonsterX 10] (- temp0 13))
							(= [theTheSmallMonsterX 11] (- temp1 28))
							(= [theTheSmallMonsterX 12] 30583)
							(= [theTheSmallMonsterX 13] 0)
							(proc816_0 @theTheSmallMonsterX 2)
						)
					)
					(435
						(if (== (theSmallMonster loop?) 6)
							(= [theTheSmallMonsterX 0] (- temp0 8))
							(= [theTheSmallMonsterX 1] (- temp1 8))
							(= [theTheSmallMonsterX 2] (- temp0 16))
							(= [theTheSmallMonsterX 3] (+ temp1 12))
							(= [theTheSmallMonsterX 4] (- temp0 26))
							(= [theTheSmallMonsterX 5] (+ temp1 25))
							(= [theTheSmallMonsterX 6] (- temp0 48))
							(= [theTheSmallMonsterX 7] (+ temp1 20))
							(= [theTheSmallMonsterX 8] (- temp0 56))
							(= [theTheSmallMonsterX 9] (- temp1 5))
							(= [theTheSmallMonsterX 10] 30583)
							(= [theTheSmallMonsterX 11] 0)
							(proc816_0 @theTheSmallMonsterX 2)
						else
							(= [theTheSmallMonsterX 0] (+ temp0 8))
							(= [theTheSmallMonsterX 1] (- temp1 8))
							(= [theTheSmallMonsterX 2] (+ temp0 66))
							(= [theTheSmallMonsterX 3] (- temp1 5))
							(= [theTheSmallMonsterX 4] (+ temp0 49))
							(= [theTheSmallMonsterX 5] (+ temp1 19))
							(= [theTheSmallMonsterX 6] (+ temp0 27))
							(= [theTheSmallMonsterX 7] (+ temp1 25))
							(= [theTheSmallMonsterX 8] (+ temp0 17))
							(= [theTheSmallMonsterX 9] (+ temp1 13))
							(= [theTheSmallMonsterX 10] 30583)
							(= [theTheSmallMonsterX 11] 0)
							(proc816_0 @theTheSmallMonsterX 2)
						)
					)
					(430
						(if (not (theSmallMonster loop?))
							(= [theTheSmallMonsterX 0] (- temp0 28))
							(= [theTheSmallMonsterX 1] (- temp1 11))
							(= [theTheSmallMonsterX 2] (+ temp0 24))
							(= [theTheSmallMonsterX 3] (- temp1 11))
							(= [theTheSmallMonsterX 4] (+ temp0 38))
							(= [theTheSmallMonsterX 5] (- temp1 4))
							(= [theTheSmallMonsterX 6] (+ temp0 33))
							(= [theTheSmallMonsterX 7] (+ temp1 8))
							(= [theTheSmallMonsterX 8] (+ temp0 4))
							(= [theTheSmallMonsterX 9] (+ temp1 8))
							(= [theTheSmallMonsterX 10] (+ temp0 4))
							(= [theTheSmallMonsterX 11] (+ temp1 5))
							(= [theTheSmallMonsterX 12] (- temp0 15))
							(= [theTheSmallMonsterX 13] (+ temp1 5))
							(= [theTheSmallMonsterX 14] (- temp0 15))
							(= [theTheSmallMonsterX 15] (+ temp1 11))
							(= [theTheSmallMonsterX 16] (- temp0 34))
							(= [theTheSmallMonsterX 17] (+ temp1 11))
							(= [theTheSmallMonsterX 18] (- temp0 34))
							(= [theTheSmallMonsterX 19] (+ temp1 4))
							(= [theTheSmallMonsterX 20] (- temp0 58))
							(= [theTheSmallMonsterX 21] (+ temp1 6))
							(= [theTheSmallMonsterX 22] (- temp0 60))
							(= [theTheSmallMonsterX 23] temp1)
							(= [theTheSmallMonsterX 24] 30583)
							(= [theTheSmallMonsterX 25] 0)
							(proc816_0 @theTheSmallMonsterX 2)
						else
							(= [theTheSmallMonsterX 0] (- temp0 25))
							(= [theTheSmallMonsterX 1] (- temp1 11))
							(= [theTheSmallMonsterX 2] (+ temp0 30))
							(= [theTheSmallMonsterX 3] (- temp1 11))
							(= [theTheSmallMonsterX 4] (+ temp0 61))
							(= [theTheSmallMonsterX 5] (+ temp1 1))
							(= [theTheSmallMonsterX 6] (+ temp0 59))
							(= [theTheSmallMonsterX 7] (+ temp1 5))
							(= [theTheSmallMonsterX 8] (+ temp0 35))
							(= [theTheSmallMonsterX 9] (+ temp1 4))
							(= [theTheSmallMonsterX 10] (+ temp0 34))
							(= [theTheSmallMonsterX 11] (+ temp1 10))
							(= [theTheSmallMonsterX 12] (+ temp0 16))
							(= [theTheSmallMonsterX 13] (+ temp1 10))
							(= [theTheSmallMonsterX 14] (+ temp0 15))
							(= [theTheSmallMonsterX 15] (+ temp1 5))
							(= [theTheSmallMonsterX 16] (- temp0 4))
							(= [theTheSmallMonsterX 17] (+ temp1 5))
							(= [theTheSmallMonsterX 18] (- temp0 3))
							(= [theTheSmallMonsterX 19] (+ temp1 8))
							(= [theTheSmallMonsterX 20] (- temp0 32))
							(= [theTheSmallMonsterX 21] (+ temp1 8))
							(= [theTheSmallMonsterX 22] (- temp0 37))
							(= [theTheSmallMonsterX 23] (- temp1 4))
							(= [theTheSmallMonsterX 24] 30583)
							(= [theTheSmallMonsterX 25] 0)
							(proc816_0 @theTheSmallMonsterX 2)
						)
					)
					(440
						(if (not (theSmallMonster loop?))
							(= [theTheSmallMonsterX 0] (+ temp0 32))
							(= [theTheSmallMonsterX 1] (- temp1 17))
							(= [theTheSmallMonsterX 2] (+ temp0 48))
							(= [theTheSmallMonsterX 3] (- temp1 12))
							(= [theTheSmallMonsterX 4] (+ temp0 28))
							(= [theTheSmallMonsterX 5] (+ temp1 4))
							(= [theTheSmallMonsterX 6] (- temp0 6))
							(= [theTheSmallMonsterX 7] (+ temp1 4))
							(= [theTheSmallMonsterX 8] (- temp0 12))
							(= [theTheSmallMonsterX 9] (+ temp1 1))
							(= [theTheSmallMonsterX 10] (- temp0 31))
							(= [theTheSmallMonsterX 11] (+ temp1 1))
							(= [theTheSmallMonsterX 12] (- temp0 31))
							(= [theTheSmallMonsterX 13] (- temp1 3))
							(= [theTheSmallMonsterX 14] (- temp0 21))
							(= [theTheSmallMonsterX 15] (- temp1 15))
							(= [theTheSmallMonsterX 16] 30583)
							(= [theTheSmallMonsterX 17] 0)
							(proc816_0 @theTheSmallMonsterX 2)
						else
							(= [theTheSmallMonsterX 0] (- temp0 24))
							(= [theTheSmallMonsterX 1] (- temp1 19))
							(= [theTheSmallMonsterX 2] (+ temp0 20))
							(= [theTheSmallMonsterX 3] (- temp1 15))
							(= [theTheSmallMonsterX 4] (+ temp0 31))
							(= [theTheSmallMonsterX 5] (+ temp1 1))
							(= [theTheSmallMonsterX 6] (+ temp0 11))
							(= [theTheSmallMonsterX 7] (+ temp1 1))
							(= [theTheSmallMonsterX 8] (+ temp0 7))
							(= [theTheSmallMonsterX 9] (+ temp1 4))
							(= [theTheSmallMonsterX 10] (- temp0 28))
							(= [theTheSmallMonsterX 11] (+ temp1 3))
							(= [theTheSmallMonsterX 12] (- temp0 47))
							(= [theTheSmallMonsterX 13] (- temp1 12))
							(= [theTheSmallMonsterX 14] 30583)
							(= [theTheSmallMonsterX 15] 0)
							(proc816_0 @theTheSmallMonsterX 2)
						)
					)
					(465
						(if (not (theSmallMonster loop?))
							(= [theTheSmallMonsterX 0] (- temp0 22))
							(= [theTheSmallMonsterX 1] (- temp1 18))
							(= [theTheSmallMonsterX 2] (- temp0 7))
							(= [theTheSmallMonsterX 3] (- temp1 23))
							(= [theTheSmallMonsterX 4] (+ temp0 15))
							(= [theTheSmallMonsterX 5] (- temp1 10))
							(= [theTheSmallMonsterX 6] (+ temp0 43))
							(= [theTheSmallMonsterX 7] (- temp1 16))
							(= [theTheSmallMonsterX 8] (+ temp0 54))
							(= [theTheSmallMonsterX 9] (- temp1 9))
							(= [theTheSmallMonsterX 10] (+ temp0 57))
							(= [theTheSmallMonsterX 11] (- temp1 2))
							(= [theTheSmallMonsterX 12] (+ temp0 33))
							(= [theTheSmallMonsterX 13] (+ temp1 5))
							(= [theTheSmallMonsterX 14] (- temp0 1))
							(= [theTheSmallMonsterX 15] (+ temp1 9))
							(= [theTheSmallMonsterX 16] (- temp0 26))
							(= [theTheSmallMonsterX 17] (- temp1 9))
							(= [theTheSmallMonsterX 18] 30583)
							(= [theTheSmallMonsterX 19] 0)
							(proc816_0 @theTheSmallMonsterX 2)
						else
							(= [theTheSmallMonsterX 0] (- temp0 42))
							(= [theTheSmallMonsterX 1] (- temp1 16))
							(= [theTheSmallMonsterX 2] (- temp0 15))
							(= [theTheSmallMonsterX 3] (- temp1 10))
							(= [theTheSmallMonsterX 4] (+ temp0 8))
							(= [theTheSmallMonsterX 5] (- temp1 22))
							(= [theTheSmallMonsterX 6] (+ temp0 22))
							(= [theTheSmallMonsterX 7] (- temp1 18))
							(= [theTheSmallMonsterX 8] (+ temp0 27))
							(= [theTheSmallMonsterX 9] (- temp1 9))
							(= [theTheSmallMonsterX 10] (+ temp0 3))
							(= [theTheSmallMonsterX 11] (+ temp1 8))
							(= [theTheSmallMonsterX 12] (- temp0 56))
							(= [theTheSmallMonsterX 13] (- temp1 2))
							(= [theTheSmallMonsterX 14] 30583)
							(= [theTheSmallMonsterX 15] 0)
							(proc816_0 @theTheSmallMonsterX 2)
						)
					)
					(460
						(if (not (theSmallMonster loop?))
							(= [theTheSmallMonsterX 0] (- temp0 7))
							(= [theTheSmallMonsterX 1] (- temp1 13))
							(= [theTheSmallMonsterX 2] (+ temp0 25))
							(= [theTheSmallMonsterX 3] (- temp1 21))
							(= [theTheSmallMonsterX 4] (+ temp0 124))
							(= [theTheSmallMonsterX 5] (- temp1 21))
							(= [theTheSmallMonsterX 6] (+ temp0 142))
							(= [theTheSmallMonsterX 7] (- temp1 2))
							(= [theTheSmallMonsterX 8] (+ temp0 132))
							(= [theTheSmallMonsterX 9] (+ temp1 8))
							(= [theTheSmallMonsterX 10] (+ temp0 35))
							(= [theTheSmallMonsterX 11] (+ temp1 7))
							(= [theTheSmallMonsterX 12] (+ temp0 30))
							(= [theTheSmallMonsterX 13] (+ temp1 1))
							(= [theTheSmallMonsterX 14] (- temp0 7))
							(= [theTheSmallMonsterX 15] (+ temp1 1))
							(= [theTheSmallMonsterX 16] 30583)
							(= [theTheSmallMonsterX 17] 0)
							(proc816_0 @theTheSmallMonsterX 2)
						else
							(= [theTheSmallMonsterX 0] (- temp0 123))
							(= [theTheSmallMonsterX 1] (- temp1 20))
							(= [theTheSmallMonsterX 2] (- temp0 24))
							(= [theTheSmallMonsterX 3] (- temp1 20))
							(= [theTheSmallMonsterX 4] (+ temp0 8))
							(= [theTheSmallMonsterX 5] (- temp1 14))
							(= [theTheSmallMonsterX 6] (+ temp0 8))
							(= [theTheSmallMonsterX 7] (+ temp1 1))
							(= [theTheSmallMonsterX 8] (- temp0 30))
							(= [theTheSmallMonsterX 9] (+ temp1 1))
							(= [theTheSmallMonsterX 10] (- temp0 35))
							(= [theTheSmallMonsterX 11] (+ temp1 7))
							(= [theTheSmallMonsterX 12] (- temp0 131))
							(= [theTheSmallMonsterX 13] (+ temp1 7))
							(= [theTheSmallMonsterX 14] (- temp0 141))
							(= [theTheSmallMonsterX 15] (- temp1 2))
							(= [theTheSmallMonsterX 16] 30583)
							(= [theTheSmallMonsterX 17] 0)
							(proc816_0 @theTheSmallMonsterX 2)
						)
					)
					(450
						(= [theTheSmallMonsterX 0] (- temp0 8))
						(= [theTheSmallMonsterX 1] (- temp1 30))
						(= [theTheSmallMonsterX 2] (+ temp0 25))
						(= [theTheSmallMonsterX 3] (- temp1 13))
						(= [theTheSmallMonsterX 4] (+ temp0 26))
						(= [theTheSmallMonsterX 5] (- temp1 3))
						(= [theTheSmallMonsterX 6] (+ temp0 1))
						(= [theTheSmallMonsterX 7] (+ temp1 6))
						(= [theTheSmallMonsterX 8] (- temp0 16))
						(= [theTheSmallMonsterX 9] (- temp1 9))
						(= [theTheSmallMonsterX 10] (- temp0 22))
						(= [theTheSmallMonsterX 11] (- temp1 7))
						(= [theTheSmallMonsterX 12] (- temp0 32))
						(= [theTheSmallMonsterX 13] (- temp1 14))
						(= [theTheSmallMonsterX 14] (- temp0 32))
						(= [theTheSmallMonsterX 15] (- temp1 26))
						(= [theTheSmallMonsterX 16] 30583)
						(= [theTheSmallMonsterX 17] 0)
						(proc816_0 @theTheSmallMonsterX 2)
					)
				)
			)
		)
	)
)

(instance aLooper4 of Code
	(properties)
	
	(method (doit param1 param2)
		(param1
			setLoop:
				(cond 
					((and (<= 30 param2) (<= param2 150)) 0)
					((and (<= 151 param2) (<= param2 210)) 2)
					((and (<= 211 param2) (<= param2 330)) 1)
					(else 3)
				)
		)
	)
)

(instance aLooper2 of Code
	(properties)
	
	(method (doit param1 param2)
		(param1
			setLoop: (if (and (<= 0 param2) (<= param2 180)) 0 else 1)
		)
	)
)
