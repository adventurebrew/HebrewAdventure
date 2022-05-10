;;; Sierra Script 1.0 - (do not remove this comment)
(script# 25)
(include sci.sh)
(use Main)
(use Class_255_0)
(use DCIcon)
(use Wander)
(use RFeature)
(use Sound)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	Room25 0
)
(synonyms
	(bird owl)
)

(local
	local0
	local1
	local2
	local3
)
(instance Room25 of Rm
	(properties
		picture 25
	)
	
	(method (init)
		(= horizon 84)
		(= east 26)
		(= north 13)
		(super init:)
		(Load rsSOUND 82)
		(if global223
			(owlHead setScript: owl init:)
			(light1 setScript: showers init:)
			(light2 init:)
			(light3 init:)
			(flyCage left: -2 right: 82 bottom: 155 top: 100 init:)
			(Fly
				setLoop: 5
				cel: 0
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: 1
				setCycle: Fwd
				cycleSpeed: 2
				setMotion: Wander 5
				init:
			)
			(Fly2
				setLoop: 5
				cel: 1
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: 1
				setCycle: Fwd
				cycleSpeed: 2
				setMotion: Wander 5
				init:
			)
			(Fly3
				setLoop: 5
				cel: 2
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: 1
				setCycle: Fwd
				cycleSpeed: 2
				setMotion: Wander 5
				init:
			)
			(Fly4
				setLoop: 5
				cel: 3
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: 1
				setCycle: Fwd
				cycleSpeed: 2
				setMotion: Wander 5
				init:
			)
		else
			(owlHead loop: 4 cel: 2 addToPic:)
		)
		(self setRegions: 205 207 setFeatures: owlBody Barn House)
		(Load rsVIEW 35)
		(Thunder number: 17 loop: 0)
		(gAddToPics add: owlBody eachElementDo: #init doit:)
		(if (and (>= global165 2) (< global165 4))
			(self setRegions: 202)
		)
		(if
			(or
				(and (== global165 3) (!= global114 10))
				(and (== global165 6) (not (& global118 $0002)))
			)
			(self setRegions: 281)
		)
		(if (>= global165 4)
			(Foot ignoreActors: 1 init: stopUpd:)
		)
		(if
		(and (>= global165 4) (== ((gInv at: 4) owner?) 25))
			(Pin init: stopUpd:)
		)
		(switch gGNumber
			(20 (gEgo posn: 305 119))
			(13 (gEgo posn: 171 119))
		)
		(gEgo view: 0 illegalBits: -32768 init:)
		(proc0_4)
	)
	
	(method (doit)
		(if (proc0_20) (proc255_0 25 0))
		(if (& (gEgo onControl: 0) $0002)
			(global2 newRoom: 20)
		)
		(if (& (gEgo onControl: 0) $0004)
			(global2 newRoom: 13)
		)
		(if
		(and (& (gEgo onControl: 1) $0008) (== local0 0))
			(= local0 1)
			(self setScript: sink)
		)
		(super doit:)
	)
	
	(method (dispose)
		(DisposeScript 976)
		(super dispose:)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return 1))
		(return
			(if (== (pEvent type?) evSAID)
				(DisposeScript 990)
				(if (Said 'examine>')
					(cond 
						((Said '[<around,at][/room]') (proc255_0 25 0))
						((Said '/drive') (proc255_0 25 1))
						((Said '/bootprint')
							(if (== global165 4)
								(proc255_0 25 2)
							else
								(pEvent claimed: 0)
							)
						)
						((or (Said '/dirt') (Said '<down'))
							(cond 
								((gCast contains: Pin) (proc255_0 25 3))
								((== global165 4) (proc255_0 25 4))
								(else (pEvent claimed: 0))
							)
						)
					)
				)
			else
				0
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)
)

(instance showers of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (= state 3)))
			(1
				(light1 setCycle: Fwd)
				(light2 setCycle: Fwd)
				(light3 setCycle: Fwd)
				(= cycles 7)
			)
			(2
				(light1 setCycle: End)
				(light2 setCycle: End)
				(light3 setCycle: End self)
			)
			(3 (Thunder loop: 1 play: self))
			(4
				(if (< (Random 1 100) 20) (= state 0))
				(= cycles 7)
			)
			(5 (= state 3) (= seconds 5))
		)
	)
)

(instance sink of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_3)
				(myMusic number: 82 loop: 1 play:)
				(gEgo
					view: 35
					cel: 0
					xStep: 1
					setMotion:
						MoveTo
						(switch (gEgo loop?)
							(0 (+ (gEgo x?) 10))
							(1 (- (gEgo x?) 10))
							(else  (gEgo x?))
						)
						(switch (gEgo loop?)
							(2 (+ (gEgo y?) 3))
							(3 (- (gEgo y?) 3))
							(else  (gEgo y?))
						)
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(1 (gEgo hide:) (= seconds 3))
			(2
				(= gMyIcon myIcon)
				(= global129 5)
				(= gDeathIconLastCel 0)
				(= global132 1)
				(proc0_19 25 5)
			)
		)
	)
)

(instance owl of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 2 7)))
			(1
				(if (== (owlHead cel?) 0)
					(owlHead setCycle: End self)
					(= local2 (Random 0 3))
				else
					(owlHead setCycle: Beg self)
					(= state -1)
				)
			)
			(2
				(if local2 (= cycles 1) else (= seconds (Random 2 5)))
			)
			(3
				(if local2
					(owlHead loop: 4)
					(= seconds (Random 2 5))
				else
					(= state 0)
					(= cycles 1)
				)
			)
			(4
				(owlHead loop: 3)
				(= cycles 5)
			)
			(5
				(if (-- local2) (= state 2) else (= state 0))
				(= cycles 1)
			)
		)
	)
)

(instance lookFoot of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (gEgo loop?) 3)
					(gEgo view: 125 cel: 0 loop: 7 setCycle: End self)
				else
					(gEgo view: 125 cel: 0 loop: 6 setCycle: End self)
				)
			)
			(1
				(proc255_0 25 6 82 640 0 0)
				(proc0_5 4)
				(= cycles 1)
			)
			(2 (gEgo setCycle: Beg self))
			(3
				(gEgo view: 0 setCycle: Walk)
				(proc0_4)
				(client setScript: 0)
			)
		)
	)
)

(instance pickUp of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_3)
				(proc0_2 gEgo Pin)
				(= cycles 2)
			)
			(1
				(if (== (gEgo loop?) 3)
					(gEgo view: 125 cel: 0 loop: 7 setCycle: End self)
				else
					(gEgo view: 125 cel: 0 loop: 6 setCycle: End self)
				)
			)
			(2
				(proc255_0 25 7)
				(Pin hide:)
				(= global182 1)
				(gEgo get: 4)
				(= cycles 2)
			)
			(3 (gEgo setCycle: Beg self))
			(4
				(proc0_4)
				(gEgo view: 0 setCycle: Walk)
				(client dispose: setScript: 0)
			)
		)
	)
)

(instance owlBody of RPicView
	(properties
		y 117
		x 88
		view 125
		loop 4
		cel 1
		priority 15
	)
	
	(method (handleEvent pEvent)
		(if (proc255_5 self pEvent 3)
			(pEvent claimed: 1)
			(proc0_25 {owl})
		)
	)
)

(instance light1 of Prop
	(properties
		y 47
		x 28
		view 125
		cel 1
	)
)

(instance light2 of Prop
	(properties
		y 102
		x 28
		view 125
		loop 1
		cel 1
	)
)

(instance light3 of Prop
	(properties
		y 68
		x 106
		view 125
		loop 2
		cel 1
	)
)

(instance owlHead of Prop
	(properties
		y 93
		x 96
		view 125
		loop 3
		priority 15
		signal $0010
		cycleSpeed 2
	)
	
	(method (handleEvent pEvent)
		(cond 
			((Said 'deliver,feed,hold>')
				(if
				(or (Said '/*<bird') (Said '/bird') (Said '/*/bird'))
					(pEvent claimed: 1)
					(if gGInvSaidMe
						(if global224 (proc255_0 25 8) else (proc0_13))
					else
						(proc255_0 25 8)
					)
				)
			)
			((Said 'converse/bird') (proc255_0 25 9))
			((Said 'capture,get/bird') (proc255_0 25 10))
			(
			(or (proc255_5 self pEvent 3) (Said 'examine/bird')) (pEvent claimed: 1) (proc255_0 25 11))
		)
	)
)

(instance Foot of Prop
	(properties
		y 128
		x 210
		view 125
		loop 8
	)
	
	(method (handleEvent pEvent)
		(cond 
			(
				(or
					(Said 'examine<use<monocle/bootprint')
					(Said '(examine<at),examine/bootprint/monocle<with')
				)
				(if (gEgo has: 1)
					(if (< (gEgo distanceTo: Foot) 10)
						(if (>= global165 4)
							(proc0_3)
							(= local3 1)
							(self setScript: lookFoot)
						else
							(proc255_0 25 12)
						)
					else
						(proc0_9)
					)
				else
					(proc0_13)
				)
			)
			(
				(or
					(proc255_5 self pEvent 3)
					(Said 'examine/bootprint')
				)
				(pEvent claimed: 1)
				(proc255_0 25 4)
			)
		)
	)
)

(instance Pin of Prop
	(properties
		y 128
		x 190
		view 125
		loop 4
	)
	
	(method (handleEvent pEvent)
		(cond 
			(
				(or
					(proc255_5 self pEvent 3)
					(Said 'examine/rolling[<pin]')
				)
				(pEvent claimed: 1)
				(proc255_0 25 13)
			)
			((Said 'get/rolling[<pin]')
				(if (< (gEgo distanceTo: Pin) 20)
					(self setScript: pickUp)
				else
					(proc0_9)
				)
			)
		)
	)
)

(instance Thunder of Sound
	(properties)
)

(instance myMusic of Sound
	(properties)
)

(instance myIcon of DCIcon
	(properties
		view 13
		loop 5
	)
	
	(method (init)
		((= cycler (End new:)) init: self)
	)
)

(instance Fly of Act
	(properties
		y 123
		x 74
		view 125
	)
)

(instance Fly2 of Act
	(properties
		y 150
		x 37
		view 125
	)
)

(instance Fly3 of Act
	(properties
		y 139
		x 17
		view 125
	)
)

(instance Fly4 of Act
	(properties
		y 130
		x 67
		view 125
	)
)

(instance flyCage of Cage
	(properties)
)

(instance Barn of RFeature
	(properties
		nsTop 47
		nsLeft 101
		nsBottom 76
		nsRight 144
	)
	
	(method (handleEvent pEvent)
		(if
		(or (proc255_5 self pEvent 3) (Said 'examine/barn'))
			(pEvent claimed: 1)
			(proc255_0 25 14)
		)
	)
)

(instance House of RFeature
	(properties
		nsTop 63
		nsLeft 292
		nsBottom 93
		nsRight 319
	)
	
	(method (handleEvent pEvent)
		(if
		(or (proc255_5 self pEvent 3) (Said 'examine/cabin'))
			(pEvent claimed: 1)
			(proc255_0 25 15)
		)
	)
)
