;;; Sierra Script 1.0 - (do not remove this comment)
(script# 236)
(include sci.sh)
(use Main)
(use atsgl)
(use Class_255_0)
(use Path)
(use Avoid)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	celiBrea 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	[local8 11] = [190 154 186 154 105 154 24 123 -12 123 -32768]
	[local19 7] = [105 154 186 154 190 154 -32768]
	local26
)
(procedure (localproc_0094)
	(Celie loop: 5 setCycle: Fwd)
	(Lillian loop: 3 cel: 2 setCycle: Beg)
	(LHead cel: 0 stopUpd:)
	(proc255_0 &rest 67 20 10 33 4 70 125 30 1 88)
)

(procedure (localproc_00e1)
	(Lillian loop: 4 setCycle: Fwd)
	(LHead loop: 2 setCycle: Fwd)
	(Celie setCycle: 0)
	(proc255_0 &rest 67 160 145 33 4 70 140 30 1 88)
)

(instance PathOut of Path
	(properties)
	
	(method (at param1)
		(return [local8 param1])
	)
)

(instance PathIn of Path
	(properties)
	
	(method (at param1)
		(return [local19 param1])
	)
)

(instance celiBrea of Rgn
	(properties)
	
	(method (init)
		(super init:)
		(if (not (& global118 $0004))
			(proc0_21 135 4 41)
			(proc0_21 132 29 94 95 96)
			(Load rsVIEW 642)
			(Load rsSCRIPT 406)
		)
		(proc0_21 128 480 499)
		(proc0_21 143 243 254 251)
		(proc0_21 142 2 6)
		(= global208 34)
		(= [global377 1] 254)
		(= [global377 5] 251)
		(roller ignoreActors: 1 setPri: 10 init: stopUpd: hide:)
		(pot ignoreActors: 1 setPri: 10 init: stopUpd:)
		(sprinkles
			ignoreActors: 1
			setPri: 10
			init:
			stopUpd:
			hide:
		)
		(Celie
			illegalBits: 0
			setPri: 10
			ignoreActors: 1
			setAvoider: (Avoid new:)
			init:
		)
		(Lillian setPri: 10 ignoreActors: 1 init: stopUpd:)
		(LHead setPri: 10 ignoreActors: 1 init: stopUpd:)
		(if (and (< global187 3) (== global155 0))
			(proc0_3)
			(Jeeves
				setAvoider: (Avoid new:)
				setScript: jeevActions
				init:
			)
		)
		(self setScript: bread)
	)
	
	(method (doit)
		(cond 
			((gCast contains: Jeeves) (User canInput: 0))
			((and (not local26) (not (gEgo script?))) (User canInput: 1))
		)
		(DisposeScript 990)
		(if (and (< local2 70) (< gGNumber_5 5)) (++ local2))
		(if (and local3 local4) (self setScript: casTalk))
		(if (and local5 local3)
			(= local3 0)
			(Celie setScript: celieActions)
		)
		(if local6
			(= local6 0)
			(= local2 70)
			(Lillian setScript: lillActions)
		)
		(super doit:)
	)
	
	(method (dispose)
		(super dispose:)
		(DisposeScript 983)
		(DisposeScript 985)
	)
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
		(if (pEvent claimed?) (return))
	)
)

(instance bread of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local26 1)
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
				(User canInput: 0)
				(if (< global172 10)
					(++ global172)
				else
					(= global172 4)
				)
				(switch global172
					(1
						(localproc_0094 236 0)
						(= seconds 7)
					)
					(2
						(localproc_00e1 236 1)
						(= seconds 3)
					)
					(3
						(localproc_00e1 236 2)
						(= seconds 3)
					)
					(4
						(localproc_0094 236 3)
						(= seconds 5)
					)
					(5
						(localproc_00e1 236 4)
						(= seconds 5)
					)
					(6
						(localproc_00e1 236 5)
						(= seconds 4)
					)
					(7
						(localproc_00e1 236 6)
						(= seconds 3)
					)
					(8
						(localproc_0094 236 7)
						(= seconds 4)
					)
					(9
						(localproc_0094 236 8)
						(= seconds 3)
					)
					(else 
						(localproc_0094 236 9)
						(= seconds 4)
					)
				)
			)
			(2
				(proc0_15)
				(Lillian stopUpd:)
				(LHead stopUpd:)
				(Celie stopUpd:)
				(switch global172
					(1
						(localproc_00e1 236 10)
						(= seconds 5)
					)
					(2
						(localproc_0094 236 11)
						(= seconds 5)
					)
					(5
						(localproc_0094 236 12)
						(= seconds 4)
					)
					(6
						(localproc_0094 236 13)
						(= seconds 3)
					)
					(8
						(localproc_00e1 236 14)
						(= seconds 3)
					)
					(9
						(localproc_00e1 236 15)
						(= seconds 3)
					)
					(else 
						(= seconds 0)
						(= cycles 1)
					)
				)
			)
			(3
				(proc0_15)
				(Lillian stopUpd:)
				(LHead stopUpd:)
				(Celie stopUpd:)
				(if (== global172 1)
					(localproc_00e1 236 16)
					(= seconds 3)
				else
					(= cycles 1)
				)
			)
			(4
				(proc0_15)
				(LHead stopUpd:)
				(= local26 0)
				(if (not (gEgo script?)) (User canInput: 1))
				(= local2 0)
				(Lillian stopUpd: setScript: lillActions)
				(Celie setScript: celieActions)
				(client setScript: 0)
			)
		)
	)
)

(instance lillActions of Script
	(properties)
	
	(method (doit)
		(if (and local5 (self client?))
			(client setScript: 0)
			(= local4 0)
		)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(Lillian ignoreActors: 1 loop: 5 setCycle: Fwd)
				(= seconds 5)
			)
			(1
				(Lillian loop: 5 setCycle: Beg)
				(= seconds (Random 6 12))
			)
			(2
				(Lillian loop: 6 setCycle: End)
				(= seconds (Random 6 12))
			)
			(3
				(Lillian loop: 6 setCycle: Beg)
				(if (== local2 70) (client setScript: 0) (= local4 1))
				(= seconds (Random 6 12))
				(= state -1)
			)
		)
	)
)

(instance celieActions of Script
	(properties)
	
	(method (doit)
		(if (not local7)
			(switch state
				(2 (sprinkles show:))
				(4 (roller show:))
			)
		)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(Celie loop: 0 setCycle: Fwd)
				(roller hide:)
				(= seconds (Random 3 6))
			)
			(1
				(Celie cel: 0 loop: 2 setCycle: End self)
			)
			(2
				(Celie cel: 0 loop: 3 setCycle: Fwd)
				(if (not local7) (sprinkles show:))
				(sprinkles setCycle: Fwd)
				(= cycles 14)
			)
			(3
				(sprinkles cel: 0 hide:)
				(Celie cel: 0 stopUpd:)
				(if (and (== local2 70) (not local5))
					(client loop: 5 setScript: 0)
					(= local3 1)
				)
				(if (> (Random 1 100) 35) (= state -1))
				(= seconds (Random 3 5))
			)
			(4
				(Celie
					view: 480
					setPri: -1
					loop: 2
					posn: 153 126
					ignoreActors: 0
					setCycle: Walk
					illegalBits: -32764
					setMotion: MoveTo 119 93 self
				)
				(if (not local7) (roller show:))
			)
			(5
				(Celie loop: 3)
				(= seconds 3)
			)
			(6
				(Celie setMotion: MoveTo 145 131 self)
			)
			(7
				(Celie
					view: 485
					loop: 0
					cel: 0
					illegalBits: 0
					posn: 146 113
					ignoreActors: 1
					setPri: 10
				)
				(= state -1)
				(= seconds 1)
			)
		)
	)
)

(instance casTalk of Script
	(properties)
	
	(method (doit)
		(if local5 (client setScript: 0))
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local26 1)
				(User canInput: 0)
				(= local4 0)
				(= local3 0)
				(switch (++ gGNumber_5)
					(1
						(localproc_0094 236 17)
						(= seconds 5)
					)
					(2
						(localproc_00e1 236 18)
						(= seconds 5)
					)
					(3
						(localproc_00e1 236 19)
						(= seconds 4)
					)
					(4
						(localproc_00e1 236 20)
						(= seconds 5)
					)
					(5
						(localproc_00e1 236 21)
						(= seconds 7)
					)
					(else  (= cycles 1))
				)
			)
			(1
				(proc0_15)
				(Lillian stopUpd:)
				(Celie stopUpd:)
				(LHead stopUpd:)
				(Celie stopUpd:)
				(switch gGNumber_5
					(1
						(localproc_00e1 236 22)
						(= seconds 3)
					)
					(2
						(localproc_0094 236 23)
						(= seconds 4)
					)
					(3
						(localproc_0094 236 24)
						(= seconds 6)
					)
					(4
						(localproc_0094 236 25)
						(= seconds 4)
					)
					(5
						(localproc_0094 236 26)
						(= seconds 7)
					)
					(else  (= cycles 1))
				)
			)
			(2
				(proc0_15)
				(LHead stopUpd:)
				(Celie stopUpd:)
				(Lillian stopUpd:)
				(Celie stopUpd:)
				(Lillian setScript: lillActions)
				(Celie setScript: celieActions)
				(= local26 0)
				(User canInput: 1)
				(= local2 0)
				(client setScript: 0)
			)
		)
	)
)

(instance jeevActions of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(Jeeves loop: 4 setCycle: End self)
			)
			(1
				(Jeeves setCycle: Walk setMotion: MoveTo 221 119 self)
			)
			(2
				(gDoor setCycle: End)
				(gMySound setCycle: End self)
			)
			(3
				(Jeeves setCycle: Walk setMotion: MoveTo 251 119 self)
			)
			(4
				(gDoor setCycle: Beg)
				(gMySound setCycle: Beg self)
			)
			(5
				(gDoor stopUpd:)
				(gMySound stopUpd:)
				(User canControl: 1)
				(= [global368 2] 1800)
				(= global155 1)
				(Jeeves setAvoider: 0 dispose:)
			)
		)
	)
)

(instance goSee of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global213 6)
				(proc0_1 1 236 27)
				(if (gEgo inRect: 180 145 200 150)
					(gEgo setMotion: MoveTo 212 160 self)
				else
					(= cycles 1)
				)
			)
			(1
				(Lillian
					view: 499
					loop: 0
					cel: 0
					posn: 193 143
					ignoreActors: 0
					setAvoider: ((Avoid new:) offScreenOK: 1)
					setCycle: End self
				)
				(LHead hide: dispose:)
				(if (gEgo inRect: 0 120 24 125)
					(gEgo setMotion: MoveTo (+ (gEgo x?) 40) (gEgo y?))
				)
			)
			(2
				(Lillian view: 500 setCycle: Walk setMotion: PathOut self)
			)
			(3
				(= global202 1)
				(= local7 1)
				(= seconds 2)
			)
			(4
				(= global202 2)
				(sprinkles hide:)
				(roller hide:)
				(= local7 0)
				(= cycles 2)
			)
			(5
				(proc255_0 236 28 88)
				(Lillian setMotion: MoveTo 24 123 self)
			)
			(6
				(proc0_15)
				(= global213 6)
				(proc0_1 1 236 29)
				(Lillian setMotion: PathIn self)
			)
			(7
				(Lillian illegalBits: 0 setMotion: MoveTo 193 143 self)
			)
			(8
				(Lillian view: 499)
				(Lillian
					cel: (Lillian lastCel:)
					setAvoider: 0
					setCycle: Beg self
				)
			)
			(9
				(Lillian view: 515 posn: 201 132)
				(LHead setPri: 10 ignoreActors: 1 init: stopUpd:)
				(proc0_4)
				(= local5 0)
				(= local6 1)
				(client setScript: 0)
			)
		)
	)
)

(instance roller of Prop
	(properties
		y 113
		x 147
		view 485
		loop 1
	)
	
	(method (handleEvent)
		(cond 
			((Said 'get/rolling[<pin]') (proc255_0 236 30))
			((Said 'examine/rolling[<pin]') (proc255_0 236 31))
		)
	)
)

(instance pot of Prop
	(properties
		y 112
		x 133
		view 485
		loop 1
		cel 1
	)
)

(instance sprinkles of Prop
	(properties
		y 126
		x 145
		z 20
		view 485
		loop 4
	)
)

(instance Celie of Act
	(properties
		y 113
		x 146
		view 485
	)
	
	(method (handleEvent pEvent)
		(if
		(< (gEgo distanceTo: Celie) (gEgo distanceTo: Lillian))
			(= global214 2)
		else
			(= global214 32)
		)
		(= global213 2)
		(cond 
			((Said 'examine/girl')
				(pEvent claimed: 1)
				(if (== global214 2)
					(proc0_25 {celie})
				else
					(proc0_25 {lillian})
				)
			)
			(
				(and
					(proc255_5 self pEvent 3)
					(not (& global207 $0002))
				)
				(pEvent claimed: 1)
				(proc0_25 {celie})
			)
			(
				(and
					(& global207 $0002)
					(or (proc255_5 self pEvent 3) (Said 'examine/celie'))
				)
				(pEvent claimed: 1)
				(proc255_0 236 32)
			)
			(
				(or
					(Said 'converse/celie')
					(and (== global214 2) (Said 'converse/girl'))
				)
				(switch local0
					(0 (proc0_1 1 236 33))
					(1 (proc0_1 1 236 34))
					(else  (proc255_0 236 35))
				)
				(++ local0)
			)
			((Said 'ask[/celie]/lil<about')
				(= global212 1)
				(= global209 pEvent)
				(proc243_1 15 236 36)
			)
			((Said 'hear/celie,lil') (proc255_0 236 37))
			((Said 'examine/bread,dough') (proc255_0 236 38))
			((Said 'get,eat/bread,dough') (proc255_0 236 39))
			((Said 'deliver,hold/necklace')
				(if (gEgo has: 0)
					(if (< (gEgo distanceTo: Celie) 60)
						(proc0_1 1 236 40)
						(gEgo put: 0)
						(= global135 1)
					else
						(proc0_9)
					)
				else
					(proc0_13)
				)
			)
		)
	)
)

(instance LHead of Prop
	(properties
		y 98
		x 205
		view 515
		loop 1
	)
)

(instance Lillian of Act
	(properties
		y 132
		x 201
		view 515
		loop 3
	)
	
	(method (handleEvent pEvent)
		(= global213 6)
		(cond 
			((Said 'examine/people') (proc255_0 236 32))
			(
				(and
					(not (& global207 $0020))
					(proc255_5 self pEvent 3)
				)
				(pEvent claimed: 1)
				(proc0_25 {lillian})
			)
			(
				(and
					(& global207 $0020)
					(or
						(proc255_5 self pEvent 3)
						(Said 'examine/lil,people')
					)
				)
				(pEvent claimed: 1)
				(proc255_0 236 32)
			)
			((Said 'examine,converse/person,girl') (proc255_0 236 41))
			((Said 'converse/people') (proc255_0 236 42))
			(
			(and (proc0_7 51) (Said 'tell[/lil]/gertie<about'))
				(= global213 6)
				(proc0_15)
				(if (& global123 $0001)
					(if (& global145 $0001)
						(proc0_1 1 236 43)
					else
						(proc0_3)
						(= global145 (| global145 $0001))
						(= local5 1)
						(if (Lillian script?)
							(((Lillian script?) client?) setScript: 0)
						)
						(Lillian startUpd: setScript: goSee)
					)
				else
					(pEvent claimed: 0)
				)
			)
			((Said 'converse/lil,girl')
				(switch local1
					(0 (proc0_1 1 236 44))
					(1 (proc0_1 1 236 45))
					(2 (proc0_1 1 236 46))
					(3 (proc0_1 1 236 47))
					(else  (proc255_0 236 48))
				)
				(++ local1)
			)
			((Said 'ask[/lil]/celie<about')
				(= global212 1)
				(= global209 pEvent)
				(proc243_1 5 236 49)
			)
		)
	)
)

(instance Jeeves of Act
	(properties
		y 144
		x 157
		view 451
		loop 4
	)
	
	(method (handleEvent pEvent)
		(= global213 11)
		(cond 
			(
				(and
					(not (& global207 $0400))
					(proc255_5 self pEvent 3)
				)
				(pEvent claimed: 1)
				(proc0_25 {jeeves})
			)
			(
				(and
					(& global207 $0400)
					(or (proc255_5 self pEvent 3) (Said 'examine/butler'))
				)
				(pEvent claimed: 1)
				(proc255_0 236 32)
			)
		)
	)
)
