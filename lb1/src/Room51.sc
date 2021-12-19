;;; Sierra Script 1.0 - (do not remove this comment)
(script# 51)
(include sci.sh)
(use Main)
(use HighLite)
(use Class_255_0)
(use RFeature)
(use Sound)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	Room51 0
)
(synonyms
	(stair upstair)
	(room room passage)
)

(local
	local0
)
(instance glow of HighLite
	(properties)
)

(instance Room51 of Rm
	(properties
		picture 51
	)
	
	(method (init)
		(= horizon 0)
		(= west 55)
		(= global189 51)
		(super init:)
		(self setRegions: 242 setFeatures: trapdoor)
		(gAddToPics add: trapdoor eachElementDo: #init doit:)
		(if global137
			(if (== gGNumber 65)
				(= local0 0)
				(proc0_3)
				(gEgo
					loop: 1
					posn: 222 91
					illegalBits: 0
					setMotion: MoveTo 116 170 self
				)
			else
				(= local0 1)
				(gEgo loop: 0 y: 170)
			)
			(gEgo view: 7 xStep: 3 init:)
			(glow deltaX: 8 deltaY: 8 ignoreCast: 1 init:)
			(rat
				view: 151
				setLoop: 3
				setStep: 5 5
				illegalBits: 0
				ignoreActors: 1
				posn: 139 171
				setCycle: Walk
				init:
				setScript: Scurry
			)
		else
			(proc0_3)
			(gEgo
				view: 49
				loop: 1
				posn: 222 91
				illegalBits: 0
				init:
				setScript: tumble
			)
		)
	)
	
	(method (doit)
		(if (and (proc0_20) global137) (proc255_0 51 0))
		(if (and (not local0) (< (gEgo x?) 117))
			(= local0 1)
		)
		(if (and local0 (& (gEgo onControl: 1) $0008))
			(proc0_3)
			(gEgo illegalBits: 0 setMotion: MoveTo 244 80)
		)
		(if (& (gEgo onControl: 1) $0002)
			(gEgo illegalBits: -32768)
			(global2 newRoom: 65)
		)
		(super doit:)
	)
	
	(method (dispose)
		(DisposeScript 214)
		(super dispose:)
	)
	
	(method (handleEvent pEvent &tmp temp0)
		(if (pEvent claimed?) (return))
		(if (== (pEvent type?) evSAID)
			(cond 
				((Said '*/dinosaur') (proc255_0 51 1))
				((Said '*/bone') (proc255_0 51 2))
				((Said 'examine>')
					(cond 
						((Said '[<around,at][/room]') (proc255_0 51 0))
						((Said '/stair') (proc255_0 51 3))
						((Said '/boulder') (proc255_0 51 4))
					)
				)
				;Z ((Said 'open/trapdoor') (proc255_0 51 5))
				((Said 'open/door<starim') (proc255_0 51 5))
				;Z ((Said 'close/trapdoor') (proc255_0 51 6))
				((Said 'close/door<starim') (proc255_0 51 6))
				((Said 'climb/stair') (proc255_0 51 7))
			)
		)
	)
	
	(method (cue)
		(proc0_4)
		(gEgo illegalBits: -32768)
	)
	
	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)
)

(instance tumble of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(Falling priority: 5 play:)
				(gEgo setCycle: End self)
			)
			(1
				(gEgo
					setLoop: 3
					setCycle: Fwd
					xStep: 8
					yStep: 8
					setMotion: MoveTo 100 158 self
				)
			)
			(2
				(gEgo posn: 103 171 setLoop: 5 cel: 0 setCycle: End self)
				(ShakeScreen 5 5)
			)
			(3
				(= gMyIcon 49)
				(= global129 5)
				(= gDeathIconLastCel 4)
				(proc0_19 51 8)
			)
		)
	)
)

(instance Scurry of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 3 5)))
			(1
				(rat setMotion: MoveTo -10 169 self)
				(ratNoise play:)
			)
			(2
				(rat dispose:)
				(client setScript: 0)
			)
		)
	)
)

(instance rat of Act
	(properties)
	
	(method (handleEvent pEvent)
		(cond 
			((Said '/mouse>')
				(cond 
					((Said 'examine') (if (rat mover?) (proc255_0 51 9) else (proc0_18)))
					((Said 'get,capture') (if (rat mover?) (proc255_0 51 10) else (proc0_18)))
					((Said 'kill') (if (rat mover?) (proc255_0 51 11) else (proc0_18)))
				)
			)
			((and (rat mover?) (proc255_5 self pEvent 3)) (pEvent claimed: 1) (proc255_0 51 9))
		)
	)
)

(instance Falling of Sound
	(properties
		number 70
	)
)

(instance ratNoise of Sound
	(properties
		number 58
	)
)

(instance trapdoor of RPicView
	(properties
		y 55
		x 239
		view 151
		priority 3
	)
	
	(method (handleEvent pEvent)
		(if
			(or
				(proc255_5 self pEvent 3)
				;Z (Said 'examine/trapdoor')
				(Said 'examine/door<starim')
				(Said 'examine<up')
			)
			(pEvent claimed: 1)
			(proc255_0 51 12)
		)
	)
)
