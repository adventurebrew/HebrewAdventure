;;; Sierra Script 1.0 - (do not remove this comment)
(script# 240)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	coloroom 0
)
(synonyms
	(butt cigarette)
	(colonel person fellow)
)

(local
	local0
	local1
)
(instance Colonel of Prop
	(properties)
	
	(method (handleEvent pEvent)
		(cond 
			(
				(and
					(proc255_5 self pEvent 3)
					(not (& global207 $0200))
				)
				(pEvent claimed: 1)
				(proc0_25 {colonel})
			)
			(
				(and
					(& global207 $0200)
					(or (proc255_5 self pEvent 3) (Said 'examine/colonel'))
				)
				(pEvent claimed: 1)
				(proc255_0 240 0)
			)
		)
	)
)

(instance smoke1 of Prop
	(properties)
)

(instance smoke2 of Prop
	(properties)
)

(instance coloroom of Rgn
	(properties)
	
	(method (init &tmp temp0 temp1 temp2)
		(super init:)
		(= temp1 175)
		(= temp2 140)
		(switch global165
			(1
				(= temp0 253)
				(= temp1 133)
				(= temp2 98)
			)
			(2 (= temp0 285))
			(3
				(= temp0 292)
				(= temp1 229)
				(= temp2 95)
			)
			(5 (= temp0 374))
			(6 (= temp0 375))
			(else  (= temp0 376))
		)
		(Load rsFONT 4)
		(proc0_21 143 243 temp0)
		(Load rsVIEW 909)
		(= global208 512)
		(= [global377 9] temp0)
		(Colonel
			view: 304
			x: temp1
			y: temp2
			init:
			stopUpd:
			setScript: colonelActions
		)
		(smoke1
			view: 304
			loop: 2
			cel: 0
			posn: (+ (Colonel x?) 6) (- (Colonel y?) 30)
			setPri: (CoordPri (Colonel y?))
			init:
			hide:
		)
		(smoke2
			view: 304
			loop: 3
			cel: 0
			posn: (+ (Colonel x?) 11) (- (Colonel y?) 24)
			setPri: (CoordPri (Colonel y?))
			init:
			hide:
		)
		(Glow
			posn: (+ (Colonel x?) 10) (Colonel y?)
			z: 29
			init:
			hide:
		)
	)
	
	(method (doit)
		(super doit:)
	)
	
	(method (dispose)
		(super dispose:)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return 1))
		(return
			(if (== (pEvent type?) evSAID)
				(cond 
					;Z ((Said 'get,move,press/wheelchair') (proc255_0 240 1))
					((Said 'get,move,press/chair<wheel') (proc255_0 240 1))
					((Said 'examine/butt') (proc0_5 13) (proc255_0 240 2))
					((Said 'hear/colonel') (proc255_0 240 3))
					((Said 'get/butt') (proc255_0 240 4))
					((and (Said 'converse>') (Said '/colonel'))
						(= global213 10)
						(switch global165
							(7
								(switch local1
									(0 (proc0_1 1 240 5))
									(1 (proc0_1 1 240 6))
									(else  (proc255_0 240 7))
								)
							)
							(else 
								(switch local1
									(0 (proc0_1 1 240 8))
									(1 (proc0_1 1 240 9))
									(2 (proc0_1 1 240 10))
									(else  (proc255_0 240 11))
								)
							)
						)
						(++ local1)
					)
				)
			else
				0
			)
		)
	)
)

(instance colonelActions of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(smoke2 cel: 0 hide:)
				(Colonel loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(Glow show: loop: 1 cel: 0 setCycle: Fwd)
				(= cycles 18)
			)
			(2
				(Glow hide:)
				(Colonel
					loop: 0
					cel: (- (NumCels Colonel) 1)
					setCycle: Beg self
				)
			)
			(3
				(smoke2 setCycle: Fwd show:)
				(smoke1 show: setCycle: End self)
			)
			(4
				(smoke1 cel: 0 hide:)
				(= cycles 1)
			)
			(5
				(if (< (Random 1 100) 30)
					(= state -1)
				else
					(= state 4)
				)
				(= seconds 5)
			)
		)
	)
)

(instance Glow of Prop
	(properties
		view 304
		loop 1
	)
)
