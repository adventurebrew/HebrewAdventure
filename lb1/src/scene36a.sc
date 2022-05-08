;;; Sierra Script 1.0 - (do not remove this comment)
(script# 321)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Sound)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	scene36a 0
)

(local
	local0
	local1
	theCycles
	local3
	local4
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
	(proc255_0 &rest 67 160 120 33 4 70 140 30 1 88)
)

(procedure (localproc_0079)
	(puff hide:)
	(localproc_000c &rest)
	(rudyMouth setScript: cycleMouth)
	(proc255_0 &rest 67 20 120 33 4 70 140 30 1 88)
)

(procedure (localproc_00b2)
	(= global173 (| global173 $0001))
	(= [global368 0] 0)
	(= [global368 2] 1800)
	(proc0_5 23)
	(proc0_5 24)
)

(instance scene36a of Rm
	(properties
		picture 62
		style $0007
	)
	
	(method (init)
		(super init:)
		(Load rsFONT 4)
		(proc0_3)
		(myMusic number: 27 loop: -1 play:)
		(if (not (& global173 $0001))
			(if (== [global368 0] 1)
				(localproc_00b2)
				(= global199 1)
			else
				(Load rsFONT 41)
				(proc0_21 143 406)
				(Load rsVIEW 642)
				(proc0_21 132 29 94 95 96)
				(Rudy setPri: 1 init: stopUpd:)
				(rudyMouth setPri: 2 init: hide:)
				(rudyEye setPri: 2 init: stopUpd: setScript: RudysEyes)
				(self setScript: speech36a)
			)
		)
		(if (== global199 1)
			(self setScript: noOne)
		else
			(Smoke
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
			(Gloria setPri: 1 init:)
			(puff setPri: 1 init: hide:)
			(Hand
				setLoop: 1
				setCel: 0
				setPri: 3
				ignoreActors: 1
				init:
				stopUpd:
			)
			(if (& global173 $0001) (self setScript: twice))
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

(instance RudysEyes of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(rudyEye setLoop: 8 setCel: 0 forceUpd:)
				(= seconds (Random 1 3))
			)
			(1
				(if (and (not local1) (== (Random 1 2) 1))
					(rudyEye setLoop: 7 setCel: 1 forceUpd:)
					(= local1 1)
					(= cycles 1)
				else
					(rudyEye setLoop: 8 setCel: 1 forceUpd:)
					(= local1 0)
					(= seconds (Random 1 3))
				)
				(= state -1)
			)
		)
	)
)

(instance GlorsEyes of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 2 5)))
			(1
				(glorEye setCycle: Beg self)
				(= state -1)
			)
		)
	)
)

(instance speech36a of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (>= state 1)
			(cond 
				(
				(and (== (mod state 2) 0) state (!= state 12))
					(= local0 0)
					(glorMouth loop: 3 cycleSpeed: 0)
					(Hand setMotion: MoveTo 167 111)
					(glow hide:)
					(if (and (== (Hand x?) 167) (== (Hand y?) 111))
						(Smoke posn: 148 89 show: setCycle: Fwd)
					)
				)
				(
					(and
						(== (Hand x?) 186)
						(== (Hand y?) 111)
						(== local0 0)
					)
					(= local0 1)
					(glow show:)
					(glorMouth loop: 2 cycleSpeed: 3 setCycle: Fwd show:)
					(Smoke hide:)
				)
				((not local0)
					(Hand setMotion: MoveTo 186 111)
					(Smoke setMotion: MoveTo 169 89)
					(glorMouth setCycle: End)
				)
			)
		)
	)
	
	(method (changeState newState)
		(if (cycleMouth client?)
			(= local3 1)
			(= cycles 1)
		else
			(switch (= state newState)
				(0
					(cond 
						((not global216) (= state -1))
						((not (& global118 $0001))
							(= global118 (| global118 $0001))
							(self setScript: (ScriptID 406 0))
							(= state -1)
						)
						((self script?) (= state -1))
					)
					(= cycles 1)
				)
				(1
					(= local4
						(Display
							321
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
					(localproc_0079 321 1)
					(= seconds 10)
				)
				(2
					(localproc_002c 321 2)
					(= seconds 4)
				)
				(3
					(localproc_0079 321 3)
					(= seconds 7)
				)
				(4
					(localproc_002c 321 4)
					(= seconds 10)
				)
				(5
					(localproc_0079 321 5)
					(= seconds 8)
				)
				(6
					(localproc_002c 321 6)
					(= seconds 10)
				)
				(7
					(localproc_0079 321 7)
					(= seconds 8)
				)
				(8
					(localproc_002c 321 8)
					(= seconds 10)
				)
				(9
					(localproc_0079 321 9)
					(= seconds 8)
				)
				(10
					(localproc_002c 321 10)
					(= seconds 10)
				)
				(11
					(localproc_0079 321 11)
					(= seconds 8)
				)
				(12
					(proc0_15)
					(Rudy
						setLoop: 1
						setStep: 5 5
						setMotion: MoveTo -40 (Rudy y?) self
					)
					(rudyEye hide:)
				)
				(13
					(localproc_00b2)
					(global2 newRoom: gGNumber)
				)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
		(if
			(and
				(not (pEvent claimed?))
				(== evKEYBOARD (pEvent type?))
				(or
					(== (pEvent message?) KEY_S)
					(== (pEvent message?) KEY_s)
				)
			)
			(proc0_15)
			(if (not (& global173 $0001)) (localproc_00b2))
			(global2 newRoom: gGNumber)
		)
	)
)

(instance twice of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(Smoke posn: 148 89 show: setCycle: Fwd)
				(= cycles 1)
			)
			(1
				(if (== global199 2)
					(proc255_0 321 12 88)
				else
					(proc255_0 321 13 88)
				)
				(= seconds 4)
			)
			(2
				(proc0_15)
				(Smoke setMotion: MoveTo 169 89)
				(Hand setMotion: MoveTo 186 111 self)
			)
			(3 (global2 newRoom: gGNumber))
		)
	)
)

(instance noOne of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc255_0 321 14 67 65 67 88)
				(= seconds 5)
			)
			(1 (global2 newRoom: gGNumber))
		)
	)
)

(instance cycleMouth of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if local3 (= local3 0) (= cycles 1))
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

(instance Gloria of Prop
	(properties
		y 110
		x 231
		view 367
		signal $4000
	)
)

(instance Rudy of Act
	(properties
		y 111
		x 97
		view 391
	)
)

(instance Smoke of Act
	(properties
		y 89
		x 148
		yStep 5
		view 367
		xStep 5
	)
)

(instance rudyMouth of Prop
	(properties
		y 95
		x 106
		view 391
		loop 2
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

(instance rudyEye of Prop
	(properties
		y 72
		x 106
		view 391
		loop 8
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

(instance Hand of Act
	(properties
		y 111
		x 167
		yStep 5
		view 367
		xStep 5
	)
)

(instance myMusic of Sound
	(properties)
)
