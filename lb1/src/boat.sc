;;; Sierra Script 1.0 - (do not remove this comment)
(script# 780)
(include sci.sh)
(use Main)
(use Wander)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	boat 0
)

(local
	local0
)
(instance boat of Rm
	(properties
		picture 79
		style $0007
	)
	
	(method (init)
		(super init:)
		(proc0_3)
		(Load rsVIEW 202)
		(Load rsFONT 41)
		(skiff
			view: 202
			loop: 0
			posn: 11 150
			setPri: 13
			setStep: 1 1
			setMotion: MoveTo 310 150 self
			setScript: Polling
			init:
		)
		(skiff cel: (- (NumCels skiff) 1))
		(if global223
			(ripple
				view: 202
				loop: 1
				cel: 0
				setPri: 12
				setCycle: Fwd
				setStep: 1 1
				init:
			)
			(reflection
				view: 202
				loop: 5
				posn: 143 134
				setCycle: Fwd
				cycleSpeed: 2
				ignoreActors: 1
				init:
			)
			(fly1
				view: 202
				setLoop: 6
				cel: 0
				posn: (Random 60 260) (Random 40 150)
				setStep: 3 3
				observeBlocks: picWindow
				ignoreActors: 1
				ignoreHorizon: 1
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Fwd
				init:
			)
			(fly2
				view: 202
				setLoop: 6
				cel: 1
				posn: (Random 60 260) (Random 40 150)
				setStep: 3 3
				observeBlocks: picWindow
				ignoreActors: 1
				ignoreHorizon: 1
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Fwd
				init:
			)
			(fly3
				view: 202
				setLoop: 6
				cel: 2
				posn: (Random 60 260) (Random 40 150)
				setStep: 3 3
				observeBlocks: picWindow
				ignoreActors: 1
				ignoreHorizon: 1
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Fwd
				init:
			)
			(fly4
				view: 202
				setLoop: 6
				cel: 3
				posn: (Random 60 260) (Random 40 150)
				setStep: 3 3
				observeBlocks: picWindow
				ignoreActors: 1
				ignoreHorizon: 1
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Fwd
				init:
			)
			(fly5
				view: 202
				setLoop: 6
				cel: 4
				posn: (Random 60 260) (Random 40 150)
				setStep: 3 3
				observeBlocks: picWindow
				ignoreActors: 1
				ignoreHorizon: 1
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Fwd
				init:
			)
			(fly6
				view: 202
				setLoop: 6
				cel: 5
				posn: (Random 60 260) (Random 40 150)
				setStep: 3 3
				observeBlocks: picWindow
				ignoreActors: 1
				ignoreHorizon: 1
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Fwd
				init:
			)
		)
		(picWindow left: 60 right: 260 bottom: 150 top: 40 init:)
		(Display
			780
			0
			
			;Z added:
			dsALIGN
			1


			dsCOORD
			100
			30
			dsWIDTH
			;Z 240
			120
			dsCOLOR
			15
			dsBACKGROUND
			-1
			dsFONT
			0
		)
		(gConMusic number: 5 loop: -1 play:)
	)
	
	(method (doit &tmp skiffX)
		(ripple
			posn: (+ (= skiffX (skiff x?)) 37) (+ (skiff y?) 1)
		)
		(if (and (not local0) (> skiffX 60))
			(Display
				780
				1
				dsCOORD
				61
				44
				dsWIDTH
				240
				dsCOLOR
				0
				dsBACKGROUND
				-1
				dsFONT
				41
			)
			(Display
				780
				1
				dsCOORD
				60
				43
				dsWIDTH
				240
				dsCOLOR
				15
				dsBACKGROUND
				-1
				dsFONT
				41
			)
			(= local0 1)
		)
	)
	
	(method (dispose)
		(DisposeScript 976)
		(super dispose:)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(switch (pEvent type?)
			(evKEYBOARD
				(cond 
					(
						(or
							(== (pEvent message?) KEY_S)
							(== (pEvent message?) KEY_s)
						)
						(proc0_15)
						(pEvent claimed: 1)
						(global2 newRoom: 781)
					)
					(
						(or
							(== (pEvent message?) KEY_RETURN)
							(== (pEvent message?) KEY_SPACE)
						)
						(proc0_5 50)
					)
				)
			)
			(evMOUSEBUTTON (proc0_5 50))
		)
		(if (proc0_7 50)
			(proc0_15)
			(pEvent claimed: 1)
			(global2 newRoom: 44)
		)
	)
	
	(method (cue)
		(proc0_15)
		(global2 newRoom: 781)
	)
)

(instance Polling of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles (Random 15 50)))
			(1
				(if (skiff cel?)
					(skiff setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(2
				(skiff setCycle: End self)
				(= state -1)
			)
		)
	)
)

(instance reflection of Prop
	(properties)
)

(instance skiff of Act
	(properties)
)

(instance ripple of Act
	(properties)
)

(instance fly1 of Act
	(properties)
)

(instance fly2 of Act
	(properties)
)

(instance fly3 of Act
	(properties)
)

(instance fly4 of Act
	(properties)
)

(instance fly5 of Act
	(properties)
)

(instance fly6 of Act
	(properties)
)

(instance picWindow of Cage
	(properties)
)
