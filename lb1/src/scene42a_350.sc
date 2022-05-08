;;; Sierra Script 1.0 - (do not remove this comment)
(script# 350)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Sound)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	scene42a 0
)

(local
	theCycles
	local1
	local2
	theFifi
	local4 =  1
	local5
)
(procedure (localproc_0284 &tmp [temp0 500])
	(GetFarText &rest @temp0)
	(= theCycles (+ (/ (StrLen @temp0) 3) 1))
)

(procedure (localproc_02a4 param1)
	(if (= local4 param1)
		(coloEyes hide:)
	else
		(coloEyes show:)
	)
)

(procedure (localproc_02c1)
	(localproc_0284 &rest)
	(fifiMouth setScript: cycleMouth)
	(proc255_0 &rest 67 160 115 33 4 70 140 30 1 88)
)

(procedure (localproc_02f2)
	(localproc_0284 &rest)
	(= theCycles (+ theCycles (/ theCycles 4)))
	(coloMouth setScript: cycleMouth)
	(proc255_0 &rest 67 20 115 33 4 70 140 30 1 88)
)

(instance Fifi of Act
	(properties)
)

(instance Smoke of Act
	(properties)
)

(instance fifiMouth of Prop
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

(instance scene42a of Rm
	(properties
		picture 62
		style $0007
	)
	
	(method (init)
		(super init:)
		(Load rsFONT 4)
		(proc0_3)
		(myMusic number: 27 loop: -1 play:)
		(if
		(and (not (& global173 $0040)) (!= [global368 3] 1))
			(= global173 (| global173 $0040))
			(= global124 1)
			(Load rsFONT 41)
			(proc0_21 143 406)
			(Load rsVIEW 642)
			(proc0_21 132 94 95 96 29)
			(coloEyes
				view: 303
				loop: 4
				cel: 0
				posn: 147 80
				setPri: 5
				cycleSpeed: 2
				init:
				hide:
			)
			(coloMouth
				view: 303
				loop: 3
				cel: 0
				posn: 145 88
				setPri: 2
				init:
				hide:
			)
			(coloFace
				view: 303
				loop: 5
				cel: 0
				posn: 146 88
				setPri: 3
				cycleSpeed: 1
				init:
				hide:
			)
			(Colonel
				view: 305
				posn: 140 102
				loop: 2
				cel: 0
				setPri: 1
				cycleSpeed: 1
				ignoreActors: 1
				init:
			)
			(Fifi
				view: 305
				loop: 0
				cel: 0
				posn: 162 102
				setPri: 3
				cycleSpeed: 2
				init:
			)
			(fifiMouth
				view: 303
				loop: 2
				cel: 0
				posn: 173 85
				cycleSpeed: 1
				setPri: 4
				init:
				hide:
			)
			(self setScript: speech42a)
		else
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
			((= theFifi Fifi)
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

(instance speech42a of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (and (not local4) (<= (-- local5) 0))
			(= local5 (Random 10 30))
			(if (coloEyes cycler?)
				(coloEyes setCycle: 0 hide:)
			else
				(coloEyes setCycle: Fwd show:)
			)
		)
		(if (== state 14)
			(cond 
				(
				(and (not (fifiMouth script?)) (not (Fifi mover?)))
					(Fifi view: 305 setLoop: 1 x: (+ (Fifi x?) 43))
					(Fifi
						setCel: (Fifi lastCel:)
						setCycle: Walk
						setMotion: MoveTo 325 102 self
					)
				)
				((> (Fifi x?) 245) (proc0_15))
			)
		)
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
						((not (& global118 $0008))
							(= global118 (| global118 $0008))
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
							350
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
					(Colonel setCycle: End)
					(Fifi setCycle: End self)
				)
				(2
					(localproc_02a4 0)
					(Colonel view: 303 loop: 1 cel: 0)
					(Fifi view: 303 loop: 0 cel: 0)
					(localproc_02c1 350 1)
					(= seconds 7)
				)
				(3
					(localproc_02a4 1)
					(proc0_15)
					(Colonel setCycle: End self)
				)
				(4
					(coloFace cel: 0 show: setCycle: End)
					(Fifi setCycle: End self)
				)
				(5
					(Fifi setCycle: Beg self)
					(coloFace hide:)
				)
				(6 (Colonel setCycle: Beg self))
				(7
					(localproc_02a4 0)
					(localproc_02f2 350 2)
					(= seconds 7)
				)
				(8
					(localproc_02c1 350 3)
					(= seconds 7)
				)
				(9
					(localproc_02a4 1)
					(proc0_15)
					(Colonel setCycle: End self)
				)
				(10
					(coloFace cel: 0 show: setCycle: End)
					(Fifi setCycle: End self)
				)
				(11
					(Fifi setCycle: Beg self)
					(coloFace hide:)
				)
				(12
					(Colonel setCycle: Beg self)
				)
				(13
					(localproc_02a4 0)
					(localproc_02f2 350 4)
					(= seconds 10)
				)
				(14
					(Colonel stopUpd:)
					(localproc_02c1 350 5)
				)
				(15
					(++ global192)
					(= global173 (| global173 $0040))
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
			(0
				(= state -1)
				(if (= local4 (^ local4 $0001))
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
				(proc255_0 350 6 88)
				(coloFace cel: 0 forceUpd:)
				(coloEyes y: (- (coloFace y?) 15) forceUpd:)
				(theFifi show: setMotion: MoveTo 116 116 self)
			)
			(1
				(theFifi stopUpd:)
				(coloMouth show: setCycle: Fwd)
				(= seconds 3)
			)
			(2
				(coloMouth setCycle: End)
				(theFifi setMotion: MoveTo 128 136 self)
			)
			(3
				(theFifi hide:)
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
			(4 (global2 newRoom: gGNumber))
		)
	)
)
