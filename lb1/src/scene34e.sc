;;; Sierra Script 1.0 - (do not remove this comment)
(script# 306)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Sound)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	scene34e 0
)

(local
	local0
	local1
	theHand
)
(instance Hand of Act
	(properties
		y 136
		x 155
		view 386
	)
)

(instance Head of Prop
	(properties
		y 95
		x 114
		view 386
	)
)

(instance Shoulder of Prop
	(properties
		y 111
		x 106
		view 386
		loop 1
	)
)

(instance Mouth of Prop
	(properties
		y 94
		x 115
		view 386
		loop 4
	)
)

(instance Eye of Prop
	(properties
		y 72
		x 115
		view 386
		loop 5
	)
)

(instance myMusic of Sound
	(properties)
)

(instance scene34e of Rm
	(properties
		picture 62
		style $0007
	)
	
	(method (init)
		(super init:)
		(proc0_3)
		(myMusic number: 27 loop: -1 play:)
		(Head setPri: 0 ignoreActors: 1 init:)
		(Shoulder setPri: 0 ignoreActors: 1 init:)
		(Mouth setPri: 1 ignoreActors: 1 init: hide:)
		(Eye setPri: 1 ignoreActors: 1 init: hide:)
		(Hand
			setLoop: 2
			setCel: 0
			setPri: 3
			illegalBits: 0
			ignoreActors: 1
			init:
		)
		(self setScript: twice)
	)
	
	(method (doit)
		(super doit:)
	)
	
	(method (dispose)
		(super dispose:)
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
			(global2 newRoom: gGNumber)
		)
	)
)

(instance twice of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond 
					((not global216) (= state -1) (= cycles 1))
					((not (& global118 $0001))
						(= global118 (| global118 $0001))
						(self setScript: (ScriptID 406 0))
						(= state -1)
						(= cycles 1)
					)
					((self script?) (= state -1) (= cycles 1))
					(else
						(proc255_0 306 0 88)
						(Hand setMotion: MoveTo 135 120 self)
					)
				)
			)
			(1
				(Eye show: setScript: RudysEyes)
				(Hand setMotion: MoveTo 135 116 self)
				(Mouth show: loop: 3)
			)
			(2
				(Hand cel: 1 posn: 135 115)
				(= cycles 1)
			)
			(3
				(Hand cel: 2 setMotion: MoveTo 129 115 self)
			)
			(4
				(Hand setMotion: MoveTo 133 114 self)
			)
			(5
				(Mouth loop: 4 setCycle: Fwd)
				(Hand cel: 3 setMotion: MoveTo 136 114 self)
			)
			(6
				(Hand setMotion: MoveTo 155 136 self)
				(= seconds 5)
			)
			(7
				((= theHand Hand)
					setLoop: 7
					cel: 0
					posn: 88 137
					setCycle: 0
					setPri: 3
				)
				(Mouth setCycle: Beg self)
			)
			(8
				(theHand setMotion: MoveTo 108 118 self)
			)
			(9
				(theHand setMotion: MoveTo 108 114 self)
			)
			(10
				(theHand setCycle: End)
				(Eye hide:)
				(Head setCycle: End)
				(Mouth cycleSpeed: 1 setCycle: Fwd)
				(= seconds 2)
			)
			(11
				(Mouth hide:)
				(theHand setCycle: Beg self setMotion: MoveTo 108 118)
			)
			(12 (Head setCycle: Beg self))
			(13
				(Eye show:)
				(theHand setMotion: MoveTo 88 137 self)
			)
			(14 (global2 newRoom: gGNumber))
		)
	)
)

(instance RudysEyes of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(Eye setLoop: 6 setCel: 0 forceUpd:)
				(= seconds (Random 1 3))
			)
			(1
				(if (and (not local1) (== (Random 1 2) 1))
					(Eye setLoop: 6 setCel: 1 forceUpd:)
					(= local1 1)
					(= cycles 1)
				else
					(Eye setLoop: 5 setCel: 1 forceUpd:)
					(= local1 0)
					(= seconds (Random 1 3))
				)
				(= state -1)
			)
		)
	)
)
