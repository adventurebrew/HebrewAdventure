;;; Sierra Script 1.0 - (do not remove this comment)
(script# 333)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Sound)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	scene48c 0
)

(local
	theCycles
	local1
	local2
)
(procedure (localproc_000c &tmp [temp0 500])
	(GetFarText &rest @temp0)
	(= theCycles (+ (/ (StrLen @temp0) 3) 1))
)

(procedure (localproc_002c)
	(localproc_000c &rest)
	(clarMouth setScript: cycleMouth)
	(proc255_0 &rest 67 160 110 33 4 70 140 30 1 88)
)

(procedure (localproc_005d)
	(localproc_000c &rest)
	(rudyMouth setScript: cycleMouth)
	(proc255_0 &rest 67 10 120 33 4 70 140 30 1 88)
)

(procedure (localproc_008d)
	(= global173 (| global173 $0008))
	(= [global368 2] 1)
	(proc0_5 23)
)

(instance scene48c of Rm
	(properties
		picture 62
		style $0007
	)
	
	(method (init)
		(super init:)
		(proc0_3)
		(if (& global173 $0008)
			(proc0_21 132 114 115)
			(snoring number: 114 loop: 1 play:)
			(Snoring
				setLoop: 0
				setPri: 1
				moveSpeed: 2
				setMotion: MoveTo 176 59 self
				init:
			)
			(proc255_0 333 0 70 240 88)
		else
			(Load rsFONT 4)
			(snoring number: 27 loop: -1 play:)
			(clarMouth setPri: 2 init:)
			(Clarence setPri: 1 ignoreActors: 1 init:)
			(clarEye setPri: 2 init: stopUpd: setScript: ClarsEye)
			(Rudy setPri: 1 init:)
			(rudyMouth setPri: 2 init:)
			(rudyEye setPri: 2 init: stopUpd: setScript: RudysEyes)
			(Hand
				setLoop: 7
				setPri: 3
				xStep: 5
				yStep: 5
				ignoreActors: 1
			)
			(self setScript: speech48c)
		)
	)
	
	(method (doit)
		(super doit:)
		(if
			(and
				(== (snoring prevSignal?) -1)
				(== (snoring number?) 114)
			)
			(snoring number: 115 loop: 1 prevSignal: 0 play:)
		)
	)
	
	(method (dispose)
		(localproc_008d)
		(super dispose:)
	)
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
	)
	
	(method (cue)
		(proc0_15)
		(global2 newRoom: gGNumber)
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

(instance RudysEyes of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(rudyEye cel: (Random 0 2) forceUpd:)
				(= state -1)
				(if (== (rudyEye cel?) 2)
					(= cycles 2)
				else
					(= seconds (Random 2 5))
				)
			)
		)
	)
)

(instance speech48c of Script
	(properties)
	
	(method (changeState newState)
		(if (cycleMouth client?)
			(= local1 1)
			(= cycles 1)
		else
			(switch (= state newState)
				(0
					(cond 
						((not global216) (= state -1))
						((not (& global118 $0004))
							(= global118 (| global118 $0004))
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
							333
							1
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
					(localproc_002c 333 2)
					(= seconds 10)
				)
				(2
					(localproc_005d 333 3)
					(= seconds 6)
				)
				(3 (= cycles 1))
				(4
					(localproc_005d 333 4)
					(= seconds 7)
				)
				(5
					(localproc_002c 333 5)
					(= seconds 7)
				)
				(6
					(localproc_005d 333 6)
					(= seconds 10)
				)
				(7
					(localproc_002c 333 7)
					(= seconds 8)
				)
				(8
					(Hand init: setMotion: MoveTo 161 100)
					(localproc_005d 333 8)
					(= seconds 10)
				)
				(9
					(Hand init: setMotion: MoveTo 161 130 self)
				)
				(10
					(proc0_15)
					(Rudy
						setLoop: 0
						setCycle: Walk
						setStep: 5 5
						setMotion: MoveTo 340 (Rudy y?) self
					)
					(rudyEye hide:)
					(rudyMouth stopUpd: hide:)
				)
				(11 (global2 newRoom: gGNumber))
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

(instance Rudy of Act
	(properties
		y 113
		x 103
		view 391
	)
)

(instance rudyMouth of Prop
	(properties
		y 97
		x 112
		view 391
		loop 2
	)
)

(instance rudyEye of Prop
	(properties
		y 74
		x 112
		view 391
		loop 8
	)
)

(instance Hand of Act
	(properties
		y 130
		x 161
		view 391
	)
)

(instance Clarence of Act
	(properties
		y 117
		x 217
		view 409
		loop 1
	)
)

(instance clarEye of Prop
	(properties
		y 74
		x 202
		view 409
		loop 9
	)
)

(instance clarMouth of Prop
	(properties
		y 96
		x 206
		view 409
		loop 3
	)
)

(instance Snoring of Act
	(properties
		y 164
		x 80
		view 146
		cel 12
	)
)

(instance snoring of Sound
	(properties)
)
