;;; Sierra Script 1.0 - (do not remove this comment)
(script# 323)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Sound)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	scene36b 0
)

(local
	local0
	theCycles
	local2
	local3
)
(procedure (localproc_000c &tmp [temp0 500])
	(GetFarText &rest @temp0)
	(= theCycles (+ (/ (StrLen @temp0) 3) 1))
)

(procedure (localproc_002c)
	(puff cel: 0 setCycle: End show:)
	(localproc_000c &rest)
	(= theCycles (+ theCycles (/ theCycles 4)))
	(glorMouth setScript: cycleMouth)
	(proc255_0 &rest 67 140 115 33 4 70 140 30 1 83 88)
)

(procedure (localproc_007b)
	(puff hide:)
	(localproc_000c &rest)
	(= theCycles (+ theCycles (/ theCycles 2)))
	(clarMouth setScript: cycleMouth)
	(proc255_0 &rest 67 10 115 33 4 70 140 30 1 83 88)
)

(procedure (localproc_00bf)
	(= global173 (| global173 $0001))
	(= [global368 1] 0)
	(proc0_5 23)
)

(instance scene36b of Rm
	(properties
		picture 62
		style $0007
	)
	
	(method (init)
		(super init:)
		(Load rsFONT 4)
		(proc0_3)
		(myMusic number: 27 loop: -1 play:)
		(glorSmoke
			setLoop: 4
			setPri: 2
			ignoreActors: 1
			init:
			stopUpd:
			hide:
		)
		(glow init: stopUpd: hide:)
		(glorMouth setPri: 2 init:)
		(glorEye setPri: 2 init: stopUpd: setScript: GlorsEyes)
		(Gloria setPri: 1 ignoreActors: 1 init:)
		(puff setPri: 1 init: hide:)
		(glorHand
			setLoop: 1
			setCel: 0
			setPri: 3
			xStep: 5
			yStep: 5
			ignoreActors: 1
			init:
		)
		(if (== global154 4)
			(Load rsFONT 41)
			(proc0_21 143 406)
			(Load rsVIEW 642)
			(proc0_21 132 29 94 95 96)
			(= global154 5)
			(Clarence setPri: 1 init:)
			(clarMouth setPri: 2 init:)
			(clarEye
				setLoop: 8
				setPri: 2
				init:
				stopUpd:
				setScript: ClarsEye
			)
			(Hand setLoop: 0 setCel: 1 setPri: 1 yStep: 5 init:)
			(Smoke setPri: 2 init: hide:)
			(self setScript: speech36b)
		else
			(self setScript: twice)
		)
	)
	
	(method (doit)
		(super doit:)
	)
	
	(method (dispose)
		(super dispose:)
	)
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
	)
)

(instance ClarsEye of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(clarEye cel: (^ (clarEye cel?) $0001) forceUpd:)
				(= state -1)
				(if (clarEye cel?)
					(= cycles 2)
				else
					(= seconds (Random 2 5))
				)
			)
		)
	)
)

(instance GlorsEyes of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(glorEye stopUpd:)
				(= seconds (Random 2 5))
			)
			(1
				(glorEye startUpd: setCycle: Beg self)
				(= state -1)
			)
		)
	)
)

(instance speech36b of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (>= state 1)
			(if (and (== (mod state 2) 0) (!= state 8))
				(= local0 0)
				(glorMouth loop: 3 cycleSpeed: 0 setCycle: Fwd)
				(glorHand setMotion: MoveTo 167 111)
				(glow hide:)
				(if
				(and (== (glorHand x?) 167) (== (glorHand y?) 111))
					(glorSmoke posn: 148 89 show: setCycle: Fwd)
				)
				(clarMouth stopUpd:)
				(if (and (== (Hand x?) 122) (== (Hand y?) 135))
					(Smoke show: setCycle: End)
				)
				(Hand setMotion: MoveTo 122 135)
			else
				(clarMouth setCycle: Fwd)
				(Hand setMotion: MoveTo 140 190)
				(cond 
					(
						(and
							(== (glorHand x?) 186)
							(== (glorHand y?) 111)
							(== local0 0)
						)
						(= local0 1)
						(glow show:)
						(glorMouth loop: 2 setCycle: Fwd cycleSpeed: 3)
						(glorSmoke hide:)
					)
					((not local0)
						(glorHand setMotion: MoveTo 186 111)
						(glorSmoke setMotion: MoveTo 169 89)
						(glorMouth setCycle: End)
					)
				)
			)
		)
	)
	
	(method (changeState newState)
		(if (cycleMouth client?)
			(= local2 1)
			(= cycles 1)
		else
			(switch (= state newState)
				(0
					(cond 
						((not global216) (= state -1))
						((not (& global118 $0002))
							(= global118 (| global118 $0002))
							(self setScript: (ScriptID 406 0))
							(= state -1)
						)
						((self script?) (= state -1))
					)
					(= cycles 1)
				)
				(1
					(= local3
						(Display
							323
							0
							dsCOORD
							48
							8
							dsWIDTH
							256
							dsCOLOR
							15
							dsBACKGROUND
							-1
							dsFONT
							0
							dsSAVEPIXELS
						)
					)
					(localproc_007b 323 1)
					(= seconds 10)
				)
				(2
					(localproc_002c 323 2)
					(= seconds 4)
				)
				(3
					(localproc_007b 323 3)
					(= seconds 7)
				)
				(4
					(localproc_002c 323 4)
					(= seconds 10)
				)
				(5
					(localproc_007b 323 5)
					(= seconds 8)
				)
				(6
					(localproc_002c 323 6)
					(= seconds 10)
				)
				(7
					(localproc_007b 323 7)
					(= seconds 8)
				)
				(8
					(localproc_007b 323 8)
					(= seconds 8)
				)
				(9
					(proc0_15)
					(clarMouth hide:)
					(clarEye hide:)
					(glorMouth hide:)
					(Clarence
						setLoop: 7
						setStep: 5 5
						setMotion: MoveTo -40 (Clarence y?) self
					)
				)
				(10 (global2 newRoom: gGNumber))
			)
		)
	)
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
		(if
			(and
				(not (pEvent claimed?))
				(not script)
				(== evKEYBOARD (pEvent type?))
				(or
					(== (pEvent message?) KEY_S)
					(== (pEvent message?) KEY_s)
					(== (pEvent message?) $e3)	;Z Hebrew Dalet (windows 1255)
				)
			)
			(proc0_15)
			(if (not (& global173 $0001)) (localproc_00bf))
			(global2 newRoom: gGNumber)
		)
	)
)

(instance twice of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(glorSmoke posn: 148 89 show: setCycle: Fwd)
				(= cycles 1)
			)
			(1
				(proc255_0 323 9 88)
				(= seconds 4)
			)
			(2
				(proc0_15)
				(glorSmoke setMotion: MoveTo 169 89)
				(glorHand setMotion: MoveTo 186 111 self)
			)
			(3 (global2 newRoom: gGNumber))
		)
	)
)

(instance cycleMouth of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if local2 (= local2 0) (= cycles 1))
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 0 setCycle: Fwd show:)
				(= cycles theCycles)
			)
			(1
				(client setScript: 0 hide:)
				(self client: 0)
			)
		)
	)
)

(instance Clarence of Act
	(properties
		y 115
		x 102
		view 409
	)
)

(instance clarMouth of Prop
	(properties
		y 94
		x 114
		view 409
		loop 2
	)
)

(instance Smoke of Prop
	(properties
		y 82
		x 116
		view 409
		loop 4
	)
)

(instance Hand of Act
	(properties
		y 190
		x 140
		view 409
	)
)

(instance Gloria of Prop
	(properties
		y 110
		x 231
		view 367
	)
)

(instance glorMouth of Prop
	(properties
		y 96
		x 211
		view 367
		loop 3
	)
)

(instance clarEye of Prop
	(properties
		y 72
		x 118
		view 409
	)
)

(instance glorSmoke of Act
	(properties
		y 89
		x 148
		yStep 5
		view 367
		xStep 5
	)
)

(instance glorEye of Prop
	(properties
		y 76
		x 204
		view 367
		loop 7
	)
)

(instance glow of Prop
	(properties
		y 89
		x 170
		view 367
		loop 1
		cel 1
	)
)

(instance puff of Prop
	(properties
		y 88
		x 196
		view 367
		loop 8
		signal $4000
	)
)

(instance glorHand of Act
	(properties
		y 111
		x 167
		view 367
	)
)

(instance myMusic of Sound
	(properties)
)
