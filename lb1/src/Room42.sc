;;; Sierra Script 1.0 - (do not remove this comment)
(script# 42)
(include sci.sh)
(use Main)
(use ElevGate)
(use Class_255_0)
(use RFeature)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	Room42 0
)
(synonyms
	(mantel shelf)
	(drawer chest dresser)
	(room bedroom)
	(armoire armoire closet)
	(boy painting)
)

(local
	newPV
	newPV_2
)
(procedure (localproc_000c)
	(= global213 10)
	(proc0_1 1 &rest)
)

(instance Room42 of Rm
	(properties
		picture 42
	)
	
	(method (init)
		(= horizon 0)
		(= east 43)
		(super init:)
		(gAddToPics
			add: bed table1 table2 table3 sofa mirror stand vase flower cannon
		)
		(if global223
			(lamp1 setCycle: Fwd init:)
			(lamp2 setPri: 11 setCycle: Fwd init:)
			(logs setCycle: Fwd init:)
		else
			(logs init: stopUpd:)
			(lamp1 init: stopUpd:)
			(lamp2 setPri: 11 init: stopUpd:)
		)
		(gAddToPics eachElementDo: #init doit:)
		(self
			setRegions: 213
			setFeatures:
				table1
				table2
				table3
				bed
				sofa
				cannon
				vase
				flower
				mirror
				Armoire
				SDress
				Shaft
		)
		(if (& global123 $0040)
			(Dbag init: stopUpd:)
			(gAddToPics add: Chair eachElementDo: #init doit:)
			(self setFeatures: Chair)
		)
		(switch gGNumber
			(41 (gEgo posn: 56 121))
			(43 (gEgo posn: 315 149))
			(49 (gEgo posn: 252 167))
		)
		(gEgo view: 0 illegalBits: -32768 setPri: -1)
		(= global193 0)
		(if (not (& global109 $0030))
			(cond 
				((== global165 0)
					(= global193 1)
					(if
					(and (not (& global173 $0040)) (!= [global368 3] 1))
						(self setRegions: 231)
					else
						(self setRegions: 240)
					)
				)
				(
					(or
						(proc0_7 38)
						(and
							(< global187 3)
							(not (& global123 $0040))
							(not (proc0_7 37))
						)
					)
					(= global193 1)
					(self
						setRegions:
						(switch global165
							(4 270)
							(else  240)
						)
					)
				)
				((and (== global165 4) (== global187 3))
					(proc0_21 135 4 41)
					(proc0_21 132 29 94 95 96)
					(Load rsVIEW 642)
					(Load rsSCRIPT 406)
					(gAddToPics add: Chair eachElementDo: #init doit:)
					(self setFeatures: Chair setScript: missColo)
				)
			)
		)
		(if global193
			(= global111 42)
			((= newPV (PV new:))
				view: 242
				loop: 0
				cel: 0
				x: 296
				y: 126
			)
			((= newPV_2 (PV new:))
				view: 242
				loop: 2
				cel: 0
				x: 283
				y: 126
			)
			(gAddToPics add: newPV newPV_2 doit:)
			(gEgo init:)
			(= global109 (& global109 $fff7))
		else
			(if
				(and
					(not (& global109 $0030))
					(not (& global123 $0040))
				)
				(= global111
					(switch (Random 1 3)
						(1 32)
						(2 42)
						(3 75)
					)
				)
				(if (== global165 1) (= global111 75))
			)
			(= newPV_2 (ElevGate new:))
			(newPV_2
				chainID: chain
				elevatorID: elevator
				downID: down
				upID: up
				init:
			)
		)
	)
	
	(method (doit)
		(if (and (proc0_20) (not (& global109 $0010)))
			(if (== global111 gNumber)
				(proc255_0 42 0)
			else
				(proc255_0 42 1)
			)
		)
		(if (& (gEgo onControl: 1) $0004)
			(global2 newRoom: 41)
		)
		(if (not (& global109 $0020))
			(if (gEgo inRect: 137 144 176 161)
				(gEgo setPri: 14)
			else
				(gEgo setPri: -1)
			)
		)
		(cond 
			((< (gEgo x?) 140) (= vertAngle 44))
			((< (gEgo x?) 260) (= vertAngle 27))
			(else (= vertAngle 18))
		)
		(super doit:)
	)
	
	(method (dispose)
		(DisposeScript 201)
		(super dispose:)
	)
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
		(if (pEvent claimed?) (return))
		(if (== (pEvent type?) evSAID)
			(DisposeScript 990)
			(if
				(and
					global208
					(Said
						'ask,tell,hold,deliver,examine,get,kill,kiss,embrace,flirt>'
					)
				)
				(self setScript: (ScriptID 243 0))
				((self script?) handleEvent: pEvent)
				(if (pEvent claimed?) (return))
			)
			(cond 
				((Said 'examine>')
					(cond 
						((Said '[<around,at][/room]')
							(if (== global111 gNumber)
								(proc255_0 42 0)
							else
								(proc255_0 42 1)
							)
						)
						((Said '/mantel') (proc255_0 42 2))
						((Said '<in/elevator,lift')
							(if (not (& global109 $0010))
								(proc255_0 42 3)
							else
								(pEvent claimed: 0)
							)
						)
						((Said '/elevator,lift') (proc255_0 42 4))
						((Said '/archway') (proc255_0 42 5))
						((Said '/blind') (proc255_0 42 6))
						((and global193 (Said '/wheelchair')) (proc255_0 42 7))
						((Said '/eye,(boy<eye)') (proc255_0 42 8))
						((Said '<behind,below/boy') (proc255_0 42 9))
						((or (Said '/boy') (Said 'examine/boy/boy')) (proc255_0 42 10))
					)
				)
				((Said 'move,get/boy') (proc255_0 42 11))
				(
				(and (not global193) (Said 'get,move,press/wheelchair')) (proc255_0 42 12))
				((Said 'get>')
					(cond 
						((Said '/key[<brass]')
							(cond 
								((not ((gInv at: 18) ownedBy: 42)) (proc0_10))
								((& (gEgo onControl: 1) $0020)
									(if ((gInv at: 18) ownedBy: 42)
										(if (!= global193 1)
											(= global182 1)
											(gEgo get: 18)
											(proc255_0 42 13)
										else
											(localproc_000c 42 14)
										)
									else
										(proc0_18)
									)
								)
								(else (proc0_9))
							)
						)
						((Said '/cannon') (proc255_0 42 15))
					)
				)
				((and (not global193) (Said 'sit/wheelchair')) (proc255_0 42 16))
				(global193
					(cond 
						(
							(Said
								'open,enter,go/archway,elevator,lift[<elevator,lift]'
							)
							(localproc_000c 42 17)
						)
						((Said 'smoke/butt') (proc255_0 42 18))
						((Said 'sit[<down,in<in]/wheelchair') (proc255_0 42 19))
						((Said 'press,move/wheelchair,colonel') (proc255_0 42 20))
					)
				)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(if (and (!= newRoomNumber 41) (== global201 200))
			(++ global201)
			(= global123 (| global123 $0020))
		)
		(super newRoom: newRoomNumber)
	)
)

(instance missColo of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond 
					((not global216) (= state -1))
					((not (& global118 $0004))
						(= global118 (| global118 $0004))
						(self setScript: (ScriptID 406 0))
						(= state -1)
					)
					((self script?) (= state -1))
				)
				(= cycles 1)
			)
			(1
				(proc0_5 37)
				(client setScript: 0)
			)
		)
	)
)

(instance bed of RPicView
	(properties
		y 167
		x 121
		view 142
		loop 1
		cel 2
		signal $4000
	)
	
	(method (handleEvent pEvent)
		(if
		(or (proc255_5 self pEvent 3) (Said 'examine[<!*]/bed'))
			(proc255_0 42 21)
			(pEvent claimed: 1)
		)
	)
)

(instance table1 of RPicView
	(properties
		y 167
		x 148
		view 142
		loop 1
		cel 3
		priority 15
	)
	
	(method (handleEvent pEvent)
		(if (proc255_5 self pEvent 3)
			(pEvent claimed: 1)
			(proc0_25 {table})
		)
	)
)

(instance table2 of RPicView
	(properties
		y 167
		x 69
		view 142
		loop 1
		cel 3
		priority 15
	)
	
	(method (handleEvent pEvent)
		(if (proc255_5 self pEvent 3)
			(pEvent claimed: 1)
			(proc0_25 {table})
		)
	)
)

(instance sofa of RPicView
	(properties
		y 125
		x 158
		view 142
		loop 1
		priority 8
	)
	
	(method (handleEvent pEvent)
		(if (proc255_5 self pEvent 3)
			(pEvent claimed: 1)
			(proc0_25 {couch})
		)
	)
)

(instance mirror of RPicView
	(properties
		y 141
		x 41
		view 142
		loop 1
		cel 1
		priority 9
		signal $4000
	)
	
	(method (handleEvent pEvent)
		(cond 
			(
				(or
					(Said 'examine[<at]/reflection')
					(Said 'examine<in/mirror')
				)
				(if (< (gEgo distanceTo: mirror) 60)
					(= global213 12)
					(proc0_1 0 42 22)
				else
					(proc0_9)
				)
			)
			((Said 'examine<behind,below/mirror') (proc255_0 42 23))
			((Said 'get,move/mirror') (proc255_0 42 24))
			((Said 'examine/mirror') (proc255_0 42 25))
			(
			(Said 'open,(examine<in)/vanity,(nightstand<dressing)') (proc255_0 42 26))
			(
				(or
					(proc255_5 self pEvent 3)
					(Said 'examine/vanity,(nightstand<dressing)')
				)
				(proc255_0 42 27)
				(pEvent claimed: 1)
			)
		)
	)
)

(instance table3 of RPicView
	(properties
		y 123
		x 202
		view 142
		loop 1
		cel 4
		priority 8
	)
	
	(method (handleEvent pEvent)
		(if (proc255_5 self pEvent 3)
			(pEvent claimed: 1)
			(proc0_25 {table})
		)
	)
)

(instance cannon of RPicView
	(properties
		y 52
		x 190
		view 142
		loop 1
		cel 5
	)
	
	(method (handleEvent pEvent)
		(cond 
			(
			(Said 'search,(examine<(in,in,in))/cannon,barrel')
				(if (& (gEgo onControl: 1) $0020)
					(if ((gInv at: 18) ownedBy: 42)
						(proc255_0 42 28)
					else
						(proc255_0 42 29)
					)
				else
					(proc0_9)
				)
			)
			((Said 'attach/key/cannon') (proc255_0 42 30))
			(
			(or (proc255_5 self pEvent 3) (Said 'examine/cannon')) (pEvent claimed: 1) (proc255_0 42 31))
		)
	)
)

(instance vase of RPicView
	(properties
		y 52
		x 210
		view 142
		loop 1
		cel 7
	)
	
	(method (handleEvent pEvent)
		(if (proc255_5 self pEvent 3)
			(pEvent claimed: 1)
			(proc0_25 {vase})
		)
	)
)

(instance flower of RPicView
	(properties
		y 52
		x 170
		view 142
		loop 1
		cel 8
	)
	
	(method (handleEvent pEvent)
		(if (proc255_5 self pEvent 3)
			(pEvent claimed: 1)
			(proc0_25 {vase})
		)
	)
)

(instance Chair of RPicView
	(properties
		y 150
		x 217
		view 142
		loop 1
		cel 9
	)
	
	(method (handleEvent pEvent)
		(if
			(or
				(proc255_5 self pEvent 3)
				(Said 'examine/wheelchair')
			)
			(pEvent claimed: 1)
			(proc255_0 42 32)
		)
	)
)

(instance stand of PV
	(properties
		y 90
		x 169
		view 142
		loop 1
		cel 6
	)
)

(instance logs of Prop
	(properties
		y 86
		x 189
		view 142
		loop 2
		priority 5
		cycleSpeed 1
	)
	
	(method (handleEvent pEvent)
		(if
		(or (proc255_5 self pEvent 3) (Said 'examine/oak,log'))
			(pEvent claimed: 1)
			(proc0_25 {fire})
		)
	)
)

(instance lamp1 of Prop
	(properties
		y 44
		x 80
		view 142
	)
	
	(method (handleEvent pEvent)
		(if (proc255_5 self pEvent 3)
			(pEvent claimed: 1)
			(proc0_25 {lamp})
		)
	)
)

(instance lamp2 of Prop
	(properties
		y 76
		x 15
		view 142
		cel 1
	)
	
	(method (handleEvent pEvent)
		(if (proc255_5 self pEvent 3)
			(pEvent claimed: 1)
			(proc0_25 {lamp})
		)
	)
)

(instance Dbag of Prop
	(properties
		y 120
		x 220
		view 142
		loop 1
		cel 10
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(cond 
			((Said 'get/bag') (proc255_0 42 33))
			((Said 'open/bag') (proc0_16))
			((Said 'examine<in/bag')
				(if (< (gEgo distanceTo: Dbag) 10)
					(proc255_0 42 34)
				else
					(proc0_9)
				)
			)
			(
				(or
					(proc255_5 self pEvent 3)
					(Said 'examine/bag,dirt')
					(Said 'examine<down')
				)
				(pEvent claimed: 1)
				(proc255_0 42 35)
			)
		)
		(if (pEvent claimed?) (proc0_5 32))
	)
)

(instance chain of Act
	(properties)
)

(instance elevator of Act
	(properties
		y -10
	)
)

(instance down of View
	(properties)
)

(instance up of View
	(properties)
)

(instance Shaft of RFeature
	(properties
		nsTop 65
		nsLeft 284
		nsBottom 126
		nsRight 311
	)
	
	(method (handleEvent pEvent)
		(if (proc255_5 self pEvent 3)
			(pEvent claimed: 1)
			(proc0_25 {elevator})
		)
	)
)

(instance SDress of RFeature
	(properties
		nsTop 53
		nsLeft 92
		nsBottom 87
		nsRight 124
	)
	
	(method (handleEvent pEvent)
		(cond 
			((Said '(examine<in),open/drawer') (proc255_0 42 36))
			(
			(or (proc255_5 self pEvent 3) (Said 'examine/drawer')) (pEvent claimed: 1) (proc255_0 42 37))
		)
	)
)

(instance Armoire of RFeature
	(properties
		nsTop 67
		nsLeft 256
		nsBottom 127
		nsRight 274
	)
	
	(method (handleEvent pEvent)
		(cond 
			((Said '/panel,(door<hidden)>')
				(cond 
					((Said 'examine')
						(if (& global175 $0010)
							(proc255_0 42 38)
						else
							(proc255_0 42 39)
						)
					)
					((and (& global175 $0010) (Said 'open,move'))
						(if (not global193)
							(if (& (gEgo onControl: 1) $0080)
								(global2 newRoom: 49)
							else
								(proc0_9)
							)
						else
							(proc255_0 42 40)
						)
					)
				)
			)
			((Said 'move/armoire') (proc255_0 42 41))
			(
				(or
					(Said 'examine<(in,in,in)/armoire')
					(Said 'open/armoire,(door<armoire)')
				)
				(proc255_0 42 42)
			)
			(
			(or (proc255_5 self pEvent 3) (Said 'examine/armoire')) (pEvent claimed: 1) (proc255_0 42 43))
		)
	)
)
