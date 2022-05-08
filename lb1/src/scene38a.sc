;;; Sierra Script 1.0 - (do not remove this comment)
(script# 301)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Sound)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	scene38a 0
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
	(if (< (= theCycles (/ (StrLen @temp0) 2)) 20)
		(= theCycles 20)
	)
)

(procedure (localproc_0033)
	(localproc_000c &rest)
	(gertMouth setScript: cycleMouth)
	(proc255_0 &rest 67 140 110 33 4 70 160 30 1 88)
)

(procedure (localproc_0064)
	(localproc_000c &rest)
	(= theCycles (/ theCycles 2))
	(clarMouth setScript: cycleMouth)
	(proc255_0 &rest 67 10 110 33 4 70 160 30 1 88)
)

(procedure (localproc_009b)
	(= global173 (| global173 $0002))
	(= [global368 1] 0)
	(++ global197)
	(proc0_5 16)
	(proc0_5 18)
	(proc0_5 21)
)

(instance scene38a of Rm
	(properties
		picture 62
		style $0007
	)
	
	(method (init)
		(super init:)
		(proc0_21 135 4 41)
		(proc0_21 143 406)
		(Load rsVIEW 642)
		(proc0_21 132 29 94 95 96)
		(proc0_3)
		(Clarence setPri: 1 init:)
		(clarMouth setPri: 2 init: hide:)
		(clarEye
			setLoop: 8
			setPri: 2
			init:
			stopUpd:
			setScript: ClarsEye
		)
		(Hand setLoop: 0 setCel: 1 setPri: 1 init:)
		(Smoke setPri: 2 init: hide:)
		(myMusic number: 27 loop: -1 play:)
		(if (not (& global173 $0002))
			(localproc_009b)
			(if (!= [global368 1] 1)
				(gertEye setPri: 2 init: stopUpd: setScript: GertsEye)
				(gertMouth setPri: 2 init: hide:)
				(Gertie setPri: 1 init:)
				(gertGlass
					setLoop: 3
					setCel: 0
					setPri: 3
					ignoreActors: 1
					init:
				)
			)
			(self setScript: speech38a)
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

(instance GertsEye of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gertEye cel: (^ (gertEye cel?) $0001) forceUpd:)
				(= state -1)
				(= seconds (Random 1 6))
			)
		)
	)
)

(instance speech38a of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (>= state 1)
			(if (== (mod state 2) 0)
				(gertGlass setMotion: MoveTo 222 118)
				(if (and (== (Hand x?) 122) (== (Hand y?) 135))
					(Smoke show: setCycle: End)
				)
				(Hand setMotion: MoveTo 122 135)
			else
				(gertGlass setMotion: MoveTo 246 138)
				(Hand setMotion: MoveTo 140 190)
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
					(= local4
						(Display
							301
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
					(localproc_0064 301 1)
					(= seconds 10)
				)
				(2
					(localproc_0033 301 2)
					(= seconds 10)
				)
				(3
					(localproc_0064 301 3)
					(= seconds 10)
				)
				(4
					(localproc_0033 301 4)
					(= seconds 3)
				)
				(5
					(localproc_0064 301 5)
					(= seconds 10)
				)
				(6
					(localproc_0033 301 6)
					(= seconds 10)
				)
				(7
					(localproc_0064 301 7)
					(= seconds 10)
				)
				(8
					(localproc_0033 301 8)
					(= seconds 10)
				)
				(9
					(localproc_0064 301 9)
					(= seconds 4)
				)
				(10
					(localproc_0033 301 10)
					(= seconds 4)
				)
				(11
					(gertEye hide:)
					(gertGlass hide:)
					(Gertie
						setLoop: 0
						setCel: 1
						setStep: 5 5
						setMotion: MoveTo 340 (Gertie y?) self
					)
				)
				(12
					(proc0_15)
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
			(if (not (& global173 $0002)) (localproc_009b))
			(global2 newRoom: gGNumber)
		)
	)
)

(instance twice of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(Hand setMotion: MoveTo 122 135 self)
				(proc255_0 301 11 88)
				(clarMouth cycleSpeed: 1)
			)
			(1
				(= theCycles 4)
				(clarMouth setScript: cycleMouth)
				(= cycles 1)
			)
			(2
				(if (clarMouth script?)
					(= cycles (= state 1))
				else
					(Smoke show: setCycle: End self)
					(if (< (++ local1) 2) (= state 0))
				)
			)
			(3
				(Hand setMotion: MoveTo 140 190)
				(= cycles 10)
			)
			(4 (global2 newRoom: gGNumber))
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

(instance Gertie of Act
	(properties
		y 104
		x 213
		view 345
	)
)

(instance Clarence of Prop
	(properties
		y 115
		x 102
		view 409
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

(instance clarMouth of Prop
	(properties
		y 94
		x 114
		view 409
		loop 2
	)
)

(instance gertMouth of Prop
	(properties
		y 85
		x 213
		view 345
		loop 2
	)
)

(instance gertEye of Prop
	(properties
		y 66
		x 219
		view 345
		loop 1
	)
)

(instance gertGlass of Act
	(properties
		y 138
		x 246
		yStep 5
		view 345
		xStep 5
	)
)

(instance Hand of Act
	(properties
		y 190
		x 140
		yStep 5
		view 409
	)
)

(instance clarEye of Prop
	(properties
		y 72
		x 118
		view 409
	)
)

(instance myMusic of Sound
	(properties)
)
