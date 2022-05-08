;;; Sierra Script 1.0 - (do not remove this comment)
(script# 354)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Sound)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	scene42e 0
)

(local
	theCycles
	local1
	local2
	local3 =  1
)
(procedure (localproc_0236 &tmp [temp0 500])
	(GetFarText &rest @temp0)
	(= theCycles (+ (/ (StrLen @temp0) 3) 1))
)

(procedure (localproc_0256)
	(localproc_0236 &rest)
	(= theCycles (+ theCycles (/ theCycles 4)))
	(lillMouth setScript: cycleMouth)
	(proc255_0 &rest 67 160 115 33 4 70 140 30 1 88)
)

(procedure (localproc_0290)
	(localproc_0236 &rest)
	(= theCycles (+ theCycles (/ theCycles 2)))
	(coloMouth loop: 5 setScript: cycleMouth)
	(proc255_0 &rest 67 20 115 33 4 70 140 30 1 88)
)

(instance Hand of Act
	(properties)
)

(instance Smoke of Act
	(properties)
)

(instance Colonel of Prop
	(properties)
)

(instance coloFace of Prop
	(properties)
)

(instance coloMouth of Prop
	(properties)
)

(instance coloEyes of Prop
	(properties)
)

(instance myMusic of Sound
	(properties)
)

(instance scene42e of Rm
	(properties
		picture 62
		style $0007
	)
	
	(method (init)
		(super init:)
		(Load rsFONT 4)
		(proc0_3)
		(myMusic number: 27 loop: -1 play:)
		(Colonel
			view: 311
			posn: 101 105
			loop: 1
			cel: 0
			setPri: 1
			init:
			stopUpd:
		)
		(coloFace
			view: 311
			posn: 114 88
			loop: 0
			cel: 0
			setPri: 2
			init:
			stopUpd:
		)
		(coloEyes
			view: 311
			posn: 114 (- (coloFace y?) 15)
			loop: 2
			cel: 0
			setPri: 3
			setScript: ColoEyes
			init:
			stopUpd:
		)
		(coloMouth
			view: 311
			posn: 114 88
			loop: 4
			cel: 0
			setPri: 2
			cycleSpeed: 1
			init:
			hide:
		)
		(Hand
			view: 311
			posn: 128 136
			setLoop: 1
			setCel: 1
			setPri: 3
			moveSpeed: 1
			illegalBits: 0
			ignoreActors: 1
			init:
			hide:
		)
		(Smoke
			view: 311
			setLoop: 3
			setCycle: Walk
			setPri: 3
			illegalBits: 0
			ignoreActors: 1
			init:
			hide:
		)
		(if
		(and (not (& global173 $0040)) (!= [global368 1] 1))
			(= [global368 1] 1)
			(= global173 (| global173 $0040))
			(Load rsFONT 41)
			(proc0_21 143 406)
			(Load rsVIEW 642)
			(proc0_21 132 94 95 96 29)
			(Lillian setPri: 3 cycleSpeed: 2 init:)
			(lillMouth cycleSpeed: 1 setPri: 4 init: hide:)
			(lillEye setPri: 4 init: setScript: LillEyes)
			(proc0_5 38)
			(self setScript: speech42e)
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

(instance speech42e of Script
	(properties)
	
	(method (doit)
		(super doit:)
	)
	
	(method (changeState newState)
		(if (cycleMouth client?)
			(= local1 1)
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
					(= local2
						(Display
							354
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
					(localproc_0256 354 1)
					(= seconds 10)
				)
				(2
					(localproc_0290 354 2)
					(= seconds 8)
				)
				(3
					(Colonel setScript: twice)
					(localproc_0256 354 3)
					(= seconds 10)
				)
				(4
					(if (Colonel script?)
						(= state 3)
						(= cycles 1)
					else
						(localproc_0290 354 4)
						(= seconds 5)
					)
				)
				(5
					(localproc_0256 354 5)
					(= seconds 8)
				)
				(6
					(localproc_0290 354 6)
					(= seconds 10)
				)
				(7
					(Colonel setScript: twice)
					(localproc_0256 354 7)
					(= seconds 10)
				)
				(8
					(if (Colonel script?)
						(= state 7)
						(= cycles 1)
					else
						(localproc_0256 354 8)
						(= seconds 5)
					)
				)
				(9
					(Lillian
						setLoop: 4
						setCycle: Walk
						setMotion: MoveTo 300 (Lillian y?) self
					)
					(lillEye dispose:)
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
				)
			)
			(proc0_15)
			(global2 newRoom: gGNumber)
		)
	)
)

(instance cycleMouth of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if local1 (= local1 0) (= cycles 1))
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

(instance ColoEyes of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 7))
			(1
				(= state 0)
				(if (= local3 (^ local3 $0001))
					(coloEyes hide:)
					(= seconds (Random 2 3))
				else
					(coloEyes
						cel: (/ (Random 1 29999) 10000)
						forceUpd:
						show:
					)
					(= cycles 3)
				)
			)
		)
	)
)

(instance LillEyes of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 7))
			(1
				(= state 0)
				(lillEye loop: (Random 2 3) cel: 0 setCycle: Beg)
				(= seconds (Random 3 8))
			)
		)
	)
)

(instance twice of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if
			(and
				(== state 3)
				(== (Smoke cel?) (- (NumCels Smoke) 1))
			)
			(Smoke hide:)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== client scene42e) (proc255_0 354 9 88))
				(coloFace cel: 0 forceUpd:)
				(coloEyes y: (- (coloFace y?) 15) forceUpd:)
				(Hand show: setMotion: MoveTo 116 116 self)
			)
			(1
				(Hand stopUpd:)
				(coloMouth show: loop: 4 setCycle: Fwd)
				(= seconds 3)
			)
			(2
				(coloMouth setCycle: End)
				(Hand setMotion: MoveTo 128 136 self)
			)
			(3
				(Hand hide:)
				(coloFace cel: 1 forceUpd:)
				(coloMouth hide:)
				(coloEyes y: (- (coloFace y?) 16) forceUpd:)
				(Smoke
					show:
					cel: 0
					posn: 113 79
					setMotion: MoveTo 128 101 self
				)
			)
			(4
				(if (== client scene42e)
					(global2 newRoom: gGNumber)
				else
					(coloFace cel: 0 forceUpd:)
					(coloEyes y: (- (coloFace y?) 15) forceUpd:)
					(client setScript: 0)
					(self client: 0)
				)
			)
		)
	)
)

(instance Lillian of Act
	(properties
		y 107
		x 227
		view 504
	)
)

(instance lillMouth of Prop
	(properties
		y 85
		x 214
		view 504
		loop 1
	)
)

(instance lillEye of Prop
	(properties
		y 72
		x 207
		view 504
		loop 2
	)
)
