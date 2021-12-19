;;; Sierra Script 1.0 - (do not remove this comment)
(script# 65)
(include sci.sh)
(use Main)
(use Class_255_0)
(use RFeature)
(use Avoid)
(use Sound)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	Room65 0
)
(synonyms
	(monument monument)
	(room garden)
)

(local
	local0
	local1
)
(procedure (localproc_13a0)
	(if (& (gEgo onControl: 0) $0004)
		(= local0 1)
		(Room65 setScript: bend)
	else
		(proc0_9)
	)
)

(procedure (localproc_13c8)
	(proc0_5 48)
	(= global146 1)
	(Drop1
		loop: 7
		x: 161
		y: 125
		z: 2
		setCycle: Fwd
		setScript: 0
	)
	(if global223
		(water1 cycleSpeed: 1 setCycle: Fwd)
		(water2 cycleSpeed: 1 setCycle: Fwd)
	)
)

(procedure (localproc_141b)
	(proc0_6 48)
	(= global146 0)
	(Drop1 loop: 9 cel: 0 x: 152 y: 125 z: 2)
	(if global223
		(Drop1 cycleSpeed: 1 setScript: dripping)
		(water1 setPri: 3 cycleSpeed: 4)
		(water2 setPri: 3 cycleSpeed: 4)
	)
)

(instance Room65 of Rm
	(properties
		picture 65
	)
	
	(method (init)
		(= south 18)
		(super init:)
		(gConMusic stop:)
		(proc0_21 132 78 125)
		(fountain init: stopUpd:)
		(gAddToPics add: urn urn1 eachElementDo: #init doit:)
		(self setFeatures: urn urn1)
		(Splash1 ignoreActors: 1 init: hide:)
		(Splash2 ignoreActors: 1 init: hide:)
		(Drop1 init:)
		(water1 init:)
		(water2 init:)
		(if (proc0_7 48)
			(localproc_13c8)
		else
			(localproc_141b)
		)
		(Trap ignoreActors: 1 init:)
		(if ((gInv at: 13) ownedBy: 65)
			(shaft setPri: 8 ignoreActors: 1 init: stopUpd:)
		)
		(statue setPri: 7 ignoreActors: 1 init: stopUpd:)
		(gEgo view: 0 illegalBits: -32768 init:)
		(if (== gGNumber 51)
			(gEgo posn: 273 138)
		else
			(gEgo posn: 50 186)
		)
		(if global147
			(Trap cel: (- (NumCels Trap) 1) setPri: 9 stopUpd:)
			(statue cel: 2)
			(gEgo observeControl: 2 64)
		else
			(Trap setPri: 4)
		)
		(if (== global165 7)
			(self setRegions: 280)
			(gEgo observeControl: 256)
		)
	)
	
	(method (doit)
		(if (proc0_20) (proc255_0 65 0))
		(if
			(and
				global147
				(& (gEgo onControl: 1) $0008)
				(not script)
			)
			(gEgo ignoreControl: 64)
			(self setScript: goDown)
		)
		(if
			(and
				(& (gEgo onControl: 1) $0010)
				(!= (gEgo mover?) 0)
				global223
			)
			(switch (gEgo loop?)
				(2
					(if (== (gEgo cel?) 2)
						(Splash1
							posn: (+ (gEgo x?) 5) (gEgo y?)
							cel: 0
							show:
							setCycle: End
						)
					)
					(if (== (gEgo cel?) 5)
						(Splash2
							posn: (+ (gEgo x?) 5) (gEgo y?)
							cel: 0
							show:
							setCycle: End
						)
					)
				)
				(3
					(if (== (gEgo cel?) 2)
						(Splash1
							posn: (+ (gEgo x?) 5) (gEgo y?)
							cel: 0
							show:
							setCycle: End
						)
					)
					(if (== (gEgo cel?) 5)
						(Splash2
							posn: (+ (gEgo x?) 5) (gEgo y?)
							cel: 0
							show:
							setCycle: End
						)
					)
				)
				(else 
					(if (== (gEgo cel?) 0)
						(Splash1
							posn: (- (gEgo x?) 2) (gEgo y?)
							cel: 0
							show:
							setCycle: End
						)
					)
					(if (== (gEgo cel?) 4)
						(Splash2
							posn: (- (gEgo x?) 2) (gEgo y?)
							cel: 0
							show:
							setCycle: End
						)
					)
				)
			)
		)
		(super doit:)
	)
	
	(method (dispose)
		(DisposeScript 985)
		(super dispose:)
	)
	
	(method (handleEvent pEvent &tmp temp0)
		(if (pEvent claimed?) (return 1))
		(return
			(if (== (pEvent type?) evSAID)
				(cond 
					((Said 'examine>')
						(cond 
							((Said '[<around,at][/room]') (proc255_0 65 0))
							((Said '/archway') (proc255_0 65 1))
							((Said '/water') (proc255_0 65 2))
							((Said '/bush,bush') (proc255_0 65 3))
							((Said '/stair') (if global147 (proc255_0 65 4) else (proc255_0 65 5)))
							((Said '/passage') (if global147 (proc255_0 65 6) else (proc255_0 65 5)))
							((Said '/shaft')
								(if (gEgo inRect: 205 111 276 200)
									(if (== (gInv at: 13) 65)
										(proc255_0 65 7)
									else
										(proc255_0 65 8)
									)
								else
									(proc0_9)
								)
							)
						)
					)
					((Said 'attach,attach,attach/control/shaft') (if (gEgo has: 20) (proc255_0 65 9) else (proc0_13)))
					((Said 'attach,attach/valve,handle/shaft')
						(if (gEgo has: 13)
							(if (& (gEgo onControl: 0) $0004)
								(= local1 1)
								(self setScript: bend)
								((gInv at: 13) moveTo: gNumber)
							else
								(proc0_9)
							)
						else
							(proc0_13)
						)
					)
					((Said 'attach,attach/control/shaft')
						(if (gEgo has: 20)
							(if (& (gEgo onControl: 0) $0004)
								(proc255_0 65 10)
							else
								(proc0_9)
							)
						else
							(proc0_13)
						)
					)
					(
					(and (gEgo has: 13) (Said 'rotate,rotate/valve,handle')) (proc255_0 65 11))
					((Said 'rotate,rotate/valve,handle')
						(if (== ((gInv at: 13) owner?) 65)
							(localproc_13a0)
						else
							(proc0_13)
						)
					)
					(
						(or
							(Said 'rotate<on/fountain')
							(Said 'rotate/fountain<on')
						)
						(cond 
							((proc0_7 48) (proc255_0 65 12))
							((== ((gInv at: 13) owner?) 65) (localproc_13a0))
							(else (proc255_0 65 13))
						)
					)
					(
						(or
							(Said 'rotate<off/fountain')
							(Said 'rotate/fountain<off')
						)
						(cond 
							((not (proc0_7 48)) (proc255_0 65 14))
							((== ((gInv at: 13) owner?) 65) (localproc_13a0))
							(else (proc255_0 65 13))
						)
					)
					((Said 'feel,(attach<deliver)/fountain,water')
						(if (gEgo inRect: 101 99 241 165)
							(proc255_0 65 15)
						else
							(proc0_9)
						)
					)
					((Said 'move,press,drag,rotate/fountain') (proc255_0 65 16))
					((Said 'close/archway') (proc255_0 65 17))
					((Said 'open/archway') (proc255_0 65 18))
					(
					(Said 'enter,go,(get<in),wade,climb/water,fountain') (proc255_0 65 19))
					((Said 'get/water') (proc255_0 65 20))
					((Said 'get/shaft')
						(if (& (gEgo onControl: 0) $0004)
							(proc255_0 65 21)
						else
							(proc0_9)
						)
					)
					((Said 'press,move,drag/shaft,square')
						(if (& (gEgo onControl: 0) $0004)
							(proc255_0 65 22)
						else
							(proc0_9)
						)
					)
					((Said 'rotate,rotate,spin,rotate/shaft')
						(if (& (gEgo onControl: 0) $0004)
							(proc255_0 65 23)
						else
							(proc0_9)
						)
					)
					((Said 'get,detach/valve,handle')
						(cond 
							((== ((gInv at: 13) owner?) 65) (proc255_0 65 24))
							((gEgo has: 13) (proc255_0 65 25))
							(else (proc255_0 65 26))
						)
					)
					(
					(or (Said 'drink/water,fountain') (Said 'get/drink')) (proc255_0 65 27))
					((Said 'oil/shaft')
						(if (gEgo has: 3)
							(proc255_0 65 28)
						else
							(proc255_0 65 29)
						)
					)
					((Said 'force/shaft')
						(if (gEgo has: 7)
							(proc255_0 65 30)
						else
							(proc255_0 65 31)
						)
					)
				)
			else
				0
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 51) (gConMusic stop:))
		(super newRoom: newRoomNumber)
	)
)

(instance goDown of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_3)
				(gEgo setMotion: MoveTo 260 133 self)
			)
			(1 (global2 newRoom: 51))
		)
	)
)

(instance dripping of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(Drop1 cel: 0 setCycle: End self)
			)
			(1
				(water1 cel: 0 setCycle: End)
				(water2 cel: 0 setCycle: End self)
			)
			(2
				(if (not (proc0_7 48))
					(= state -1)
					(= seconds 2)
				else
					(client setScript: 0)
				)
			)
		)
	)
)

(instance bend of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_3)
				(gEgo illegalBits: 0 setMotion: MoveTo 250 116 self)
			)
			(1
				(gEgo view: 165 cel: 0 loop: 6)
				(= seconds 2)
			)
			(2
				(if local0
					(= local0 0)
					(shaft hide:)
					(gEgo setCycle: End self)
					(myMusic number: 125 loop: 1 play:)
					(if (not global146)
						(proc255_0 65 32)
						(localproc_13c8)
					else
						(proc255_0 65 33)
						(localproc_141b)
					)
				)
				(if local1
					(proc255_0 65 34)
					(shaft setPri: 8 ignoreActors: 1 init: stopUpd:)
					(= local1 0)
					(= cycles 1)
				)
			)
			(3
				(shaft show:)
				(gEgo view: 0 illegalBits: -32768 loop: 1 setCycle: Walk)
				(proc0_4)
				(client setScript: 0)
			)
		)
	)
)

(instance myDoor of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_3)
				(if global147
					(gEgo
						illegalBits: 0
						setAvoider: (Avoid new:)
						setMotion: MoveTo 237 91 self
					)
				else
					(gEgo
						illegalBits: 0
						setAvoider: (Avoid new:)
						setMotion: MoveTo 202 90 self
					)
				)
			)
			(1
				(gEgo loop: 2 hide:)
				(if global147
					(statue loop: 1 cel: 0 cycleSpeed: 1 setCycle: End self)
					(Trap setPri: 9 cycleSpeed: 1 setCycle: End)
				else
					(statue loop: 8 cel: 0 cycleSpeed: 1 setCycle: End self)
					(Trap cycleSpeed: 1 setCycle: Beg)
				)
				(myMusic number: 78 loop: 1 play:)
			)
			(2
				(if global147
					(statue loop: 2 cel: 2 stopUpd:)
				else
					(statue loop: 2 cel: 1 stopUpd:)
				)
				(gEgo
					show:
					view: 165
					loop: 5
					cel: 0
					illegalBits: -32768
					setCycle: End self
				)
			)
			(3
				(if global147
					(proc255_0 65 35)
					(gEgo
						view: 0
						loop: 2
						setCycle: Walk
						setAvoider: 0
						observeControl: 2 64
					)
					(= global147 1)
				else
					(gEgo
						view: 0
						loop: 2
						setCycle: Walk
						setAvoider: 0
						ignoreControl: 2
					)
					(Trap cel: 0 setPri: 4 ignoreActors: 1 init: stopUpd:)
					(= global147 0)
				)
				(proc0_4)
				(client setScript: 0)
			)
		)
	)
)

(instance Trap of Prop
	(properties
		y 128
		x 282
		view 165
		cel 4
	)
	
	(method (handleEvent pEvent)
		(cond 
			((Said 'close/trapdoor') (if global147 (proc255_0 65 36) else (proc255_0 65 37)))
			((Said 'open/trapdoor') (if global147 (proc0_16) else (proc255_0 65 37)))
			((Said 'examine<(in,down)/trapdoor')
				(if global147
					(if (< (gEgo distanceTo: Trap) 60)
						(proc255_0 65 38)
					else
						(proc0_9)
					)
				else
					(proc255_0 65 5)
				)
			)
			((Said 'examine<down')
				(if (and global147 (< (gEgo distanceTo: Trap) 60))
					(proc255_0 65 38)
				else
					(pEvent claimed: 0)
				)
			)
			(
				(or
					(Said 'examine,find/trapdoor')
					(proc255_5 self pEvent 3)
				)
				(pEvent claimed: 1)
				(if global147 (proc255_0 65 39) else (proc255_0 65 5))
			)
		)
	)
)

(instance statue of Prop
	(properties
		y 78
		x 224
		view 165
		loop 2
		cel 1
	)
	
	(method (handleEvent pEvent)
		(cond 
			((Said 'lift,get/monument') (proc255_0 65 40))
			((Said 'move,press,drag,rotate,rotate/monument')
				(if (& (gEgo onControl: 0) $0020)
					(if (== global146 1)
						(if (not global147)
							(= global147 1)
						else
							(= global147 0)
						)
						(statue setScript: myDoor)
					else
						(proc255_0 65 41)
					)
				else
					(proc0_9)
				)
			)
			(
				(or
					(proc255_5 self pEvent 3)
					(Said 'examine/base,monument,monument')
				)
				(pEvent claimed: 1)
				(if (gEgo inRect: 205 111 276 200)
					(if (== ((gInv at: 13) owner?) gNumber)
						(proc255_4 65 42 65 7)
					else
						(proc255_4 65 42 65 43)
					)
				else
					(proc255_4 65 42 65 44)
				)
			)
		)
	)
)

(instance urn of RPicView
	(properties
		y 46
		x 98
		view 165
		loop 2
		priority 3
	)
	
	(method (handleEvent pEvent)
		(cond 
			((Said 'get/urn') (proc255_0 65 45))
			((Said 'move/urn') (proc255_0 65 46))
			((Said 'examine<in/urn')
				(cond 
					((< (gEgo distanceTo: urn) 30) (proc255_0 65 47))
					((< (gEgo distanceTo: urn1) 25) (proc255_0 65 47))
					(else (proc0_9))
				)
			)
			(
				(or
					(proc255_5 self pEvent 3)
					(Said 'examine/urn,pedestal')
				)
				(pEvent claimed: 1)
				(proc255_0 65 48)
			)
		)
	)
)

(instance urn1 of RPicView
	(properties
		y 153
		x 286
		view 165
		loop 2
		priority 14
		signal $4000
	)
	
	(method (handleEvent pEvent)
		(if (proc255_5 self pEvent 3)
			(pEvent claimed: 1)
			(proc255_0 65 48)
		)
	)
)

(instance fountain of Prop
	(properties
		y 124
		x 161
		view 165
		loop 2
		cel 4
	)
	
	(method (handleEvent pEvent)
		(cond 
			((Said 'examine<in/fountain,water')
				(if (gEgo inRect: 75 89 251 166)
					(proc255_0 65 49)
				else
					(proc0_9)
				)
			)
			(
			(or (proc255_5 self pEvent 3) (Said 'examine/fountain')) (proc255_0 65 50) (pEvent claimed: 1))
		)
	)
)

(instance Drop1 of Prop
	(properties
		y 125
		x 152
		z 2
		view 165
		loop 9
	)
)

(instance water1 of Prop
	(properties
		y 132
		x 162
		view 165
		loop 3
	)
)

(instance water2 of Prop
	(properties
		y 132
		x 162
		view 165
		loop 4
	)
)

(instance Splash1 of Prop
	(properties
		view 1
		loop 6
	)
)

(instance Splash2 of Prop
	(properties
		view 1
		loop 6
	)
)

(instance shaft of Prop
	(properties
		y 95
		x 243
		view 165
		loop 2
		cel 3
	)
)

(instance myMusic of Sound
	(properties)
)
