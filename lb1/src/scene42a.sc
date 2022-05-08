;;; Sierra Script 1.0 - (do not remove this comment)
(script# 307)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Sound)
(use Game)
(use Feature)
(use Obj)

(public
	scene42a 0
)

(procedure (localproc_009a)
	(proc255_0 &rest 67 160 115 33 4 70 140 30 1 88)
)

(instance Fifi of Act
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
		(Fifi
			view: 305
			loop: 0
			cel: 5
			posn: 162 102
			setPri: 3
			cycleSpeed: 2
			init:
		)
		(self setScript: speech42a)
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
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_009a 307 0)
				(= seconds 4)
			)
			(1 (global2 newRoom: gGNumber))
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
			(global2 newRoom: gGNumber)
		)
	)
)
