;;; Sierra Script 1.0 - (do not remove this comment)
(script# 781)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Wander)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	dock 0
)

(local
	local0
	local1
	[local2 2]
)
(instance dock of Rm
	(properties
		picture 1
	)
	
	(method (init)
		(= horizon 84)
		(= global161 0)
		(super init:)
		(proc0_3)
		(Load rsFONT 4)
		(skiff
			view: 202
			loop: 0
			posn: -51 147
			setStep: 1 1
			setMotion: MoveTo 121 147 self
			setScript: Polling
			init:
		)
		(skiff cel: (- (NumCels skiff) 1))
		(Lillian
			view: 202
			loop: 3
			x: 95
			y: 115
			init:
			hide:
			stopUpd:
		)
		(Laura
			view: 202
			loop: 4
			x: 106
			y: 118
			init:
			hide:
			stopUpd:
		)
		(if global223
			(ripple
				view: 202
				loop: 1
				cel: 0
				setCycle: Fwd
				setStep: 1 1
				init:
			)
			(Turtle
				view: 101
				loop: 2
				cel: 0
				posn: 61 187
				setPri: 13
				init:
				stopUpd:
				setScript: turtleScript
			)
			(Frog
				view: 101
				loop: 3
				cel: 0
				posn: 74 123
				priority: 8
				init:
				stopUpd:
				setScript: frogScript
			)
			(flyCage left: -2 right: 321 bottom: 191 top: -2 init:)
			(fly1
				view: 101
				setLoop: 7
				cel: 0
				posn: (Random 60 260) (Random 40 150)
				setStep: 3 3
				observeBlocks: flyCage
				ignoreActors: 1
				ignoreHorizon: 1
				setMotion: Wander 5
				setCycle: Fwd
				cycleSpeed: 2
				setPri: 14
				init:
			)
			(fly2
				view: 101
				setLoop: 7
				cel: 1
				posn: (Random 60 260) (Random 40 150)
				setStep: 3 3
				observeBlocks: flyCage
				ignoreActors: 1
				ignoreHorizon: 1
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Fwd
				setPri: 14
				init:
			)
			(fly3
				view: 101
				setLoop: 7
				cel: 2
				posn: (Random 60 260) (Random 40 150)
				setStep: 3 3
				observeBlocks: flyCage
				ignoreActors: 1
				ignoreHorizon: 1
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Fwd
				setPri: 14
				init:
			)
			(fly4
				view: 101
				setLoop: 7
				cel: 3
				posn: (Random 60 260) (Random 40 150)
				setStep: 3 3
				observeBlocks: flyCage
				ignoreActors: 1
				ignoreHorizon: 1
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Fwd
				setPri: 14
				init:
			)
			(fly5
				view: 101
				setLoop: 7
				cel: 4
				posn: (Random 60 260) (Random 40 150)
				setStep: 3 3
				observeBlocks: flyCage
				ignoreActors: 1
				ignoreHorizon: 1
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Fwd
				setPri: 14
				init:
			)
			(fly6
				view: 101
				setLoop: 7
				cel: 5
				posn: (Random 60 260) (Random 40 150)
				setStep: 3 3
				observeBlocks: flyCage
				ignoreActors: 1
				ignoreHorizon: 1
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Fwd
				setPri: 14
				init:
			)
			(wave1
				view: 101
				loop: 0
				cel: 0
				posn: 261 123
				ignoreActors: 1
				cycleSpeed: 2
				setCycle: Fwd
				setPri: 2
				init:
			)
			(wave2
				view: 101
				loop: 1
				cel: 2
				posn: 260 186
				priority: 14
				ignoreActors: 1
				cycleSpeed: 2
				setCycle: Fwd
				setPri: 2
				init:
			)
		)
		(= local0
			(Display
				781
				0
				dsCOORD
				11
				12
				dsWIDTH
				240
				dsCOLOR
				0
				dsBACKGROUND
				-1
				dsFONT
				41
				dsSAVEPIXELS
			)
		)
		(= local1
			(Display
				781
				0
				dsCOORD
				10
				10
				dsWIDTH
				240
				dsCOLOR
				15
				dsBACKGROUND
				-1
				dsFONT
				41
				dsSAVEPIXELS
			)
		)
	)
	
	(method (doit)
		(if (== global161 1)
			(gConMusic fade:)
			(global2 newRoom: 782)
		)
		(if (and (== (skiff x?) 30) (== (skiff y?) 147))
			(Display 781 1 108 local1)
			(Display 781 1 108 local0)
		)
		(ripple posn: (+ (skiff x?) 37) (+ (skiff y?) 1))
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
							(== (pEvent message?) $e3)	;Z Hebrew Dalet (windows 1255)
						)
						(gConMusic stop:)
						(pEvent claimed: 1)
						(global2 newRoom: 782)
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
			(gConMusic stop:)
			(pEvent claimed: 1)
			(global2 newRoom: 44)
		)
	)
	
	(method (cue)
		(ShakeScreen 5 2)
		(skiff loop: 2 stopUpd: setScript: Heads)
		(ripple stopUpd: hide:)
		(Lillian show:)
		(Laura show:)
	)
	
	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)
)

(instance turtleScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 5 20)))
			(1 (Turtle setCycle: End self))
			(2 (client setScript: 0))
		)
	)
)

(instance Polling of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles (Random 45 65)))
			(1 (skiff setCycle: Beg self))
			(2
				(skiff setCycle: End self)
				(client setScript: 0)
			)
		)
	)
)

(instance frogScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (Frog setCycle: End self))
			(1 (= seconds (Random 3 8)))
			(2
				(Frog
					loop: 6
					posn: 112 106
					illegalBits: 1
					setCycle: Beg self
				)
			)
			(3
				(Frog loop: 5 setCycle: Fwd)
				(= seconds (Random 3 10))
			)
			(4
				(Frog loop: 6 setCycle: End self)
			)
			(5
				(Frog hide:)
				(client setScript: 0)
			)
		)
	)
)

(instance Heads of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(Lillian cycleSpeed: 2 setCycle: End self)
			)
			(1
				(proc255_0 781 2 67 10 65 33 4 70 100 30 1 83 88)
				(= cycles 1)
			)
			(2
				(Laura cycleSpeed: 2 setCycle: End self)
				(= global161 25)
				(client setScript: 0)
			)
		)
	)
)

(instance wave1 of Prop
	(properties)
)

(instance wave2 of Prop
	(properties)
)

(instance Lillian of Prop
	(properties)
)

(instance Laura of Prop
	(properties)
)

(instance Turtle of Prop
	(properties)
)

(instance Frog of Act
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

(instance flyCage of Cage
	(properties)
)
