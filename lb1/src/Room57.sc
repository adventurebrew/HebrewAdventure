;;; Sierra Script 1.0 - (do not remove this comment)
(script# 57)
(include sci.sh)
(use Main)
(use Class_255_0)
(use RFeature)
(use Avoid)
(use Sound)
(use Jump)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	Room57 0
)
(synonyms
	(diamond bag)
	(skeleton bone)
	(room crypt)
	(pry unlock)	;Z
)

(local
	local0
	local1
	theCycles
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	theMarysCover
	local11
	local12
	local13
	local14
	local15
)
(procedure (localproc_15be &tmp [temp0 250])
	(if (== global138 1)
		(proc255_4 57 33 57 34 @temp0)
	else
		(proc255_4 57 33 57 35 @temp0)
	)
)

(procedure (localproc_15f0 &tmp [temp0 50])
	(switch local0
		(4
			(if (gEgo has: 22)
				(proc255_0 57 24)
			else
				(proc255_0 57 25)
				(proc255_0 57 26)
			)
		)
		(8
			(proc255_4 57 36 57 37 @temp0)
		)
		(else 
			(proc255_4 57 36 57 38 @temp0)
		)
	)
)

(procedure (localproc_1659)
	(lantern
		view: 27
		loop: 3
		cel: 0
		posn: 157 77
		setPri: 7
		stopUpd:
		init:
	)
	((gInv at: 2) moveTo: gNumber)
)

(instance Room57 of Rm
	(properties
		picture 57
	)
	
	(method (init)
		(= horizon 0)
		(super init:)
		(gAddToPics add: skeleton casket skeletons doit:)
		(self setFeatures: Box Window1 Window2)
		(proc0_21 128 27 28 29 30)
		(proc0_21 130 985 991)
		(proc0_21 132 60 71 122 123 124)
		(if (== gGNumber 2)
			(= local13 1)
			(gEgo view: 0 posn: 43 148 init:)
		)
		(lid
			view: 157
			loop: 0
			posn: 228 84
			setPri: 8
			ignoreActors: 1
			init:
		)
		(if (== ((gInv at: 2) owner?) gNumber)
			(localproc_1659)
		)
		(if (not (gEgo has: 22))
			(pouch setPri: 1 stopUpd: init:)
		)
		(marysCover
			view: 157
			loop: 2
			ignoreActors: 1
			stopUpd:
			init:
		)
		(if (& global169 $0002)
			(marysCover cel: (- (NumCels marysCover) 1) posn: 32 87)
		else
			(marysCover loop: 1 cel: 0 posn: 46 87)
		)
		(rubysCover
			view: 157
			loop: 2
			ignoreActors: 1
			stopUpd:
			init:
		)
		(if (& global169 $0004)
			(rubysCover
				cel: (- (NumCels rubysCover) 1)
				posn: 116 69
			)
		else
			(rubysCover loop: 1 cel: 1 posn: 130 70)
		)
		(tomsCover
			view: 157
			loop: 3
			ignoreActors: 1
			stopUpd:
			init:
		)
		(if (& global169 $0008)
			(tomsCover cel: (- (NumCels tomsCover) 1) posn: 192 71)
		else
			(tomsCover loop: 1 cel: 2 posn: 177 71)
		)
		(claudesCover
			view: 157
			loop: 3
			ignoreActors: 1
			stopUpd:
			init:
		)
		(if (& global169 $0010)
			(claudesCover
				cel: (- (NumCels claudesCover) 1)
				posn: 281 91
			)
		else
			(claudesCover loop: 1 cel: 3 posn: 266 91)
		)
		(skull
			view: 157
			illegalBits: 0
			ignoreActors: 1
			priority: 1
		)
		(if (& global169 $0200)
			(skull loop: 6)
			(skull cel: (- (NumCels skull) 1) posn: 75 117)
		else
			(skull setLoop: 5 cel: 0 posn: 53 79)
		)
		(skull stopUpd: init:)
		(if (proc0_20)
			(= local14 1)
			(myMusic number: 71 loop: 1 play:)
			(lid cel: 0 cycleSpeed: 4 setCycle: End self)
		else
			(gEgo init:)
			(lid cel: (- (NumCels lid) 1) stopUpd:)
			(if (!= gGNumber 2) (self setScript: GettingOut))
		)
	)
	
	(method (doit)
		(cond 
			((== global138 1) (if (& (gEgo onControl: 1) $0200) (global2 newRoom: 2)))
			((& (gEgo onControl: 1) $0200) (if (not local12) (= local12 1) (proc255_0 57 0)))
			(else (= local12 0))
		)
		(if (and (& (gEgo onControl: 1) $0020) local13)
			(cond 
				(global137 (self setScript: GettingIn))
				((not local15) (= local15 1) (proc255_0 57 1))
			)
		)
		(if (& (gEgo onControl: 1) $0001) (= local15 0))
		(super doit:)
	)
	
	(method (dispose)
		(DisposeScript 985)
		(DisposeScript 991)
		(super dispose:)
	)
	
	(method (handleEvent pEvent &tmp temp0)
		(if (pEvent claimed?) (return))
		(if (== (pEvent type?) evSAID)
			(cond 
				((Said '(examine<in),get,open/casket>')
					(if (& global169 $0008)
						(proc255_0 57 2)
					else
						(proc0_18)
					)
					(pEvent claimed: 1)
				)
				((or (Said 'latch,bar/*') (Said 'lower/bar')) (proc255_0 57 3))
				(
					(and
						(not (gEgo has: 7))
						(or
							(Said '*/crowbar')
							(Said '*/*/crowbar')
							(Said '*<use<crowbar')
						)
					)
					(proc0_13)
				)
				(
				(or (Said 'examine,read/nameplate') (Said 'read/vault'))
					(cond 
						((& (gEgo onControl: 0) $0002) (proc255_0 57 4))
						((& (gEgo onControl: 0) $0004) (proc255_0 57 5))
						((& (gEgo onControl: 0) $0008) (proc255_0 57 6))
						((& (gEgo onControl: 0) $0010) (proc255_0 57 7))
						(else (proc0_9))
					)
				)
				(
					(or
						(Said '/vault,(door<vault)>')
						(and (Said '/door>') (Said '/vault>'))
						(Said '//vault,(door<vault)>')
						(and (Said '//door>') (Said '//vault>'))
					)
					(= local0 2)
					(while (<= local0 16)
						(if (& (gEgo onControl: 1) local0)
							(= temp0 2)
							(if gGInvSaidMe
								(if (not global224) (return))
								(= temp0 (!= global171 7))
							)
							(if (Said 'examine>')
								(if (not (& global169 local0))
									(proc255_0 57 8)
									(pEvent claimed: 1)
									(break)
								)
								(if (Said '<in') (localproc_15f0) (break))
								(proc255_0 57 9)
								(pEvent claimed: 1)
								(break)
							)
							(if
								(or
									(Said '(break,force)[<(open,up)]//cane')
									(Said '(break,lift,force)<use<cane')
									(Said 'open//cane')
								)
								(if (gEgo has: 21) (proc255_0 57 10) (break))
								(proc0_13)
								(break)
							)
							(if
								(or
									(Said '(break,force)[<(open,up)]//poker')
									(Said '(break,lift,force)<use<poker')
									(Said 'open//poker')
								)
								(if (gEgo has: 6) (proc255_0 57 11) (break))
								(proc0_13)
								(break)
							)
							(if
								(and
									(!= temp0 1)
									(not (& global169 local0))
									(or
										(Said '(break,force)[<(open,up)]//crowbar')
										(Said '(break,lift,force)<use<crowbar')
										(Said 'open//crowbar')
										(Said 'open<use<crowbar')
									)
								)
								(if (gEgo has: 7) (self setScript: OpenVault) (break))
								(proc255_0 57 12)
								(break)
							)
							(if (Said 'break,force,open')
								(if (& global169 local0) (proc0_16) (break))
								(if (not (& global169 (<< local0 $0008)))
									(proc255_0 57 13)
									(break)
								)
								(self setScript: OpenVault)
								(break)
							)
							(if (Said 'close')
								(if (not (& global169 local0)) (proc0_17) (break))
								(gEgo illegalBits: 0)
								(self setScript: CloseVault)
								(break)
							)
							(if (Said 'unbar')
								(if (not (& global169 local0))
									(proc255_0 57 14)
									(break)
								)
								(proc0_16)
								(break)
							)
						)
						(= local0 (<< local0 $0001))
					)
					(if (> local0 16) (proc0_9) (pEvent claimed: 1))
				)
				(
					(or
						(Said '/bar,door[<room]>')
						(and (Said '/door>') (Said '/room>'))
					)
					(cond 
						((Said 'examine')
							(if (== global138 0)
								(proc255_0 57 0)
							else
								(proc255_0 57 15)
							)
						)
						((Said 'open')
							(if (== global138 0)
								(proc255_0 57 0)
							else
								(proc255_0 57 15)
							)
						)
						((Said 'unbar,unbar,detach,lift,lift,move')
							(if
								(or
									(& (gEgo onControl: 0) $0200)
									(& (gEgo onControl: 0) $0040)
								)
								(if (== global138 0)
									(= global138 1)
									(proc255_0 57 16)
								else
									(proc255_0 57 17)
								)
							else
								(proc0_9)
							)
						)
					)
				)
				((Said 'examine>')
					(cond 
						((Said '[<around,at][/room]') (localproc_15be))
						((Said '/stair') (proc255_0 57 18))
						((Said '/wall') (proc255_0 57 19))
						((or (Said '/dirt') (Said '<down')) (proc255_0 57 20))
						((or (Said '/ceiling') (Said '<up')) (proc255_0 57 21))
						((Said '/frances,(crouton<frances)')
							(cond 
								((not (& global169 $0002)) (proc255_0 57 22))
								((not (& (gEgo onControl: 1) $0002)) (proc0_9))
								(else (proc255_0 57 23))
							)
						)
						((Said '/s,(crouton<s)')
							(cond 
								((not (& global169 $0008)) (proc255_0 57 22))
								((not (& (gEgo onControl: 1) $0008)) (proc0_9))
								(else (proc255_0 57 23))
							)
						)
						((Said '/claude,(crouton<claude)')
							(cond 
								((not (& global169 $0010)) (proc255_0 57 22))
								((not (& (gEgo onControl: 1) $0010)) (proc0_9))
								(else (proc255_0 57 23))
							)
						)
						((Said '/ruby,(crouton<ruby)')
							(cond 
								((not (& global169 $0004)) (proc255_0 57 22))
								((not (& (gEgo onControl: 1) $0004)) (proc0_9))
								((gEgo has: 22) (proc255_0 57 24))
								(else
									(proc255_0 57 25)
									(myMusic number: 60 loop: 1 play:)
									(proc255_0 57 26)
								)
							)
						)
						((Said '/skeleton,casket>')
							(= local0 2)
							(while (<= local0 16)
								(if
									(and
										(& (gEgo onControl: 1) local0)
										(& global169 local0)
									)
									(if (== local0 4) (proc0_18) (break))
									(if (Said '/skeleton')
										(if (== local0 8) (proc0_18) (break))
										(proc255_0 57 23)
										(break)
									)
									(if (!= local0 8) (proc0_18) (break))
									(proc255_0 57 27)
									(break)
								)
								(= local0 (<< local0 $0001))
							)
							(if (> local0 16)
								(if global169
									(if
										(or
											(and (Said '/skeleton') (& global169 $0012))
											(and (Said '/casket') (& global169 $0008))
										)
										(proc0_9)
									else
										(proc0_18)
									)
								else
									(proc0_18)
								)
							)
							(pEvent claimed: 1)
						)
					)
				)
				((Said '(move,get)>')
					(cond 
						((Said '/skeleton,casket>')
							(if
								(or
									(and (Said '/skeleton') (& global169 $0012))
									(and (Said '/casket') (& global169 $0008))
								)
								(proc255_0 57 2)
							else
								(proc0_18)
								(pEvent claimed: 1)
							)
						)
						((Said '/lantern')
							(if (gEgo has: 2)
								(proc0_10)
							else
								(proc0_3)
								(gEgo
									setAvoider: (Avoid new:)
									setMotion: MoveTo 144 112 self
								)
							)
						)
					)
				)
				((Said 'open/window') (proc255_0 57 28))
				((Said 'break/window') (proc255_0 57 29))
				((Said '(close,cover)>')
					(if
						(or
							(Said '/sarcophagus,(lid<sarcophagus)')
							(and (Said '/lid>') (Said '/sarcophagus'))
						)
						(proc255_0 57 30)
					)
				)
				((Said 'extinguish,extinguish,(rotate<off)') (proc255_0 57 31))
			)
		)
	)
	
	(method (cue)
		(if (gEgo has: 2)
			(lid stopUpd:)
			(gEgo init:)
			(self setScript: GettingOut)
		else
			(lantern hide:)
			(gEgo loop: 0 setAvoider: 0)
			((gInv at: 2) moveTo: gEgo)
			(proc0_4)
		)
	)
	
	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)
)

(instance OpenVault of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if
			(and
				(not (& global169 $0200))
				(== state 4)
				(== (marysCover cel?) 1)
				(== (skull script?) 0)
			)
			(skull setScript: RollSkull)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_5 2)
				(if (not (& global169 (= local1 local0)))
					(proc0_3)
					(if (not (& global169 (<< local1 $0008)))
						(proc255_0 57 32 67 90 110 30 1)
						(= theCycles 10)
					else
						(proc0_22)
						(= theCycles 3)
					)
					(switch local1
						(2
							(= local3 78)
							(= local4 108)
							(= local5 0)
							(= theMarysCover marysCover)
						)
						(4
							(= local3 99)
							(= local4 103)
							(= local5 1)
							(= theMarysCover rubysCover)
						)
						(8
							(= local3 209)
							(= local4 104)
							(= local5 0)
							(= theMarysCover tomsCover)
						)
						(16
							(= local3 234)
							(= local4 111)
							(= local5 1)
							(= theMarysCover claudesCover)
						)
					)
					(gEgo illegalBits: 0 setMotion: MoveTo local3 local4 self)
				else
					(proc0_16)
					(client setScript: 0)
				)
			)
			(1
				(gEgo view: 29 loop: local5 cel: 0 setCycle: End self)
			)
			(2
				(gEgo loop: (+ local5 2) cel: 0 setCycle: End self)
			)
			(3
				(gEgo loop: (+ local5 4) cel: 0 setCycle: Fwd)
				(= cycles theCycles)
			)
			(4
				(switch local1
					(2
						(theMarysCover loop: 2 posn: 32 87)
					)
					(4
						(theMarysCover loop: 2 posn: 116 69)
					)
					(8
						(theMarysCover loop: 3 posn: 192 71)
					)
					(16
						(theMarysCover loop: 3 posn: 281 91)
					)
				)
				(theMarysCover cel: 0 setCycle: End)
				(myMusic number: 123 loop: 1 play:)
				(gEgo loop: (+ local5 2))
				(gEgo cel: (- (NumCels gEgo) 1) setCycle: Beg self)
			)
			(5
				(gEgo loop: 0)
				(gEgo cel: (- (NumCels gEgo) 1) setCycle: Beg self)
			)
			(6
				(gEgo
					view: 0
					loop: 2
					cel: 6
					setCycle: Walk
					illegalBits: -32768
				)
				(= global169 (| global169 (<< local1 $0008) local1))
				(proc0_15)
				(proc0_4)
				(client setScript: 0)
			)
		)
	)
)

(instance CloseVault of Script
	(properties)
	
	(method (doit &tmp gEgoCel)
		(super doit:)
		(if (== state 2)
			(cond 
				(
				(and (> (= gEgoCel (gEgo cel?)) 2) (< gEgoCel 6)) (theMarysCover cel: (- 5 gEgoCel)))
				((== gEgoCel 6)
					(switch local1
						(2
							(= local6 46)
							(= local7 87)
							(= local9 0)
						)
						(4
							(= local6 130)
							(= local7 70)
							(= local9 1)
						)
						(8
							(= local6 177)
							(= local7 71)
							(= local9 2)
						)
						(16
							(= local6 266)
							(= local7 91)
							(= local9 3)
						)
					)
					(theMarysCover loop: 1 cel: local9 posn: local6 local7)
				)
			)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (& global169 local0)
					(proc0_3)
					(= local1 local0)
					(= global169 (& global169 (~ local0)))
					(proc0_22)
					(switch local1
						(2
							(= local6 53)
							(= local7 115)
							(= local8 0)
							(= theMarysCover marysCover)
							(= local11 15)
						)
						(4
							(= local6 146)
							(= local7 99)
							(= local8 0)
							(= theMarysCover rubysCover)
							(= local11 15)
						)
						(8
							(= local6 169)
							(= local7 100)
							(= local8 1)
							(= theMarysCover tomsCover)
							(= local11 -15)
						)
						(16
							(= local6 260)
							(= local7 121)
							(= local8 1)
							(= theMarysCover claudesCover)
							(= local11 -15)
						)
					)
					(gEgo setMotion: MoveTo local6 local7 self)
				else
					(gEgo illegalBits: -32768)
					(proc0_17)
					(client setScript: 0)
				)
			)
			(1
				(gEgo view: 0 loop: 3 cel: 0)
				(= cycles 1)
			)
			(2
				(gEgo view: 30 loop: local8 cel: 0 setCycle: End self)
				(myMusic number: 123 loop: 1 play:)
			)
			(3
				(gEgo
					view: 0
					loop: 2
					cel: 6
					posn: (+ (gEgo x?) local11) (+ (gEgo y?) 3)
					setCycle: Walk
					illegalBits: -32768
				)
				(proc0_4)
				(client setScript: 0)
			)
		)
	)
)

(instance RollSkull of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(skull
					startUpd:
					setPri: 15
					setStep: 6 4
					setCycle: Fwd
					moveSpeed: 0
					cycleSpeed: 0
					setMotion: MoveTo 75 117 self
				)
			)
			(1
				(myMusic number: 122 loop: 1 play:)
				(skull setMotion: JumpTo 90 117 self)
			)
			(2
				(myMusic number: 124 loop: 1 play:)
				(skull loop: 6 cel: 0 setPri: -1 setCycle: End self)
			)
			(3
				(skull stopUpd:)
				(client setScript: 0)
			)
		)
	)
)

(instance GettingIn of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local13 0)
				(proc0_3)
				(gEgo illegalBits: 0 setMotion: MoveTo 176 109 self)
			)
			(1
				(gEgo
					view: 28
					loop: 0
					cel: 0
					posn: 176 107
					setPri: 8
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(2
				(gEgo view: 27 posn: 167 81)
				(if (gEgo has: 2)
					(self cue:)
				else
					(gEgo loop: 0 cycleSpeed: 1)
					(gEgo cel: (- (NumCels gEgo) 1) setCycle: Beg self)
					(gEgo get: 2)
					(lantern hide:)
				)
			)
			(3
				(gEgo loop: 4 cycleSpeed: 2)
				(gEgo cel: (- (NumCels gEgo) 1) setCycle: Beg self)
			)
			(4
				(gEgo
					setPri: -1
					cycleSpeed: 0
					illegalBits: -32768
					setCycle: Walk
				)
				(proc0_4)
				(client setScript: 0)
				(global2 newRoom: 56)
			)
		)
	)
)

(instance GettingOut of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local13 0)
				(proc0_3)
				(gEgo
					view: 27
					loop: 4
					cel: 0
					illegalBits: 0
					posn: 167 81
					setPri: 8
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(1
				(gEgo loop: 0 cel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(2
				(gEgo view: 28 loop: 0 posn: 176 107 cycleSpeed: 2)
				(gEgo cel: (- (NumCels gEgo) 1) setCycle: Beg self)
				(localproc_1659)
			)
			(3
				(gEgo
					view: 0
					loop: 3
					cel: 0
					posn: 176 109
					setPri: -1
					cycleSpeed: 0
					setCycle: Walk
					setMotion: MoveTo 155 124 self
				)
			)
			(4
				(gEgo illegalBits: -32768)
				(proc0_4)
				(if local14 (localproc_15be))
				(= local13 1)
				(= local14 0)
				(client setScript: 0)
			)
		)
	)
)

(instance lid of Prop
	(properties)
)

(instance marysCover of Prop
	(properties)
	
	(method (handleEvent pEvent)
		(if (proc255_5 self pEvent 3)
			(pEvent claimed: 1)
			(proc255_0 57 4)
		)
	)
)

(instance rubysCover of Prop
	(properties)
	
	(method (handleEvent pEvent)
		(if (proc255_5 self pEvent 3)
			(pEvent claimed: 1)
			(proc255_0 57 5)
		)
	)
)

(instance tomsCover of Prop
	(properties)
	
	(method (handleEvent pEvent)
		(if (proc255_5 self pEvent 3)
			(pEvent claimed: 1)
			(proc255_0 57 6)
		)
	)
)

(instance claudesCover of Prop
	(properties)
	
	(method (handleEvent pEvent)
		(if (proc255_5 self pEvent 3)
			(pEvent claimed: 1)
			(proc255_0 57 7)
		)
	)
)

(instance pouch of Prop
	(properties
		y 63
		x 124
		view 157
		loop 4
		cel 1
	)
	
	(method (handleEvent pEvent)
		(cond 
			((Said 'get/diamond')
				(cond 
					((& (gEgo onControl: 0) $0004)
						(= global182 1)
						(gEgo get: 22)
						(pouch dispose:)
						(proc255_0 57 39)
					)
					((& global169 $0004) (proc0_9))
					(else (proc0_18))
				)
			)
			((proc255_5 self pEvent 3) (pEvent claimed: 1) (proc255_0 57 26))
		)
	)
)

(instance lantern of Prop
	(properties)
)

(instance skull of Act
	(properties)
)

(instance skeleton of PV
	(properties
		y 81
		x 40
		view 157
		loop 4
		priority 1
	)
)

(instance casket of PV
	(properties
		y 66
		x 182
		view 157
		loop 4
		cel 2
		priority 1
	)
)

(instance skeletons of PV
	(properties
		y 87
		x 272
		view 157
		loop 4
		cel 3
		priority 1
	)
)

(instance Window1 of RFeature
	(properties
		nsTop 13
		nsLeft 72
		nsBottom 59
		nsRight 105
	)
	
	(method (handleEvent pEvent)
		(if
			(or
				(Said 'examine/window')
				(Said 'examine/glass<stained')
				(proc255_5 self pEvent 3)
			)
			(proc255_0 57 40)
			(pEvent claimed: 1)
		)
	)
)

(instance Window2 of RFeature
	(properties
		nsTop 12
		nsLeft 203
		nsBottom 61
		nsRight 240
	)
	
	(method (handleEvent pEvent)
		(if (proc255_5 self pEvent 3)
			(proc255_0 57 40)
			(pEvent claimed: 1)
		)
	)
)

(instance Box of RFeature
	(properties
		nsTop 75
		nsLeft 153
		nsBottom 119
		nsRight 28
	)
	
	(method (handleEvent pEvent)
		(if
			(or
				(proc255_5 self pEvent 3)
				(Said 'examine/sarcophagus')
			)
			(proc255_0 57 41)
			(pEvent claimed: 1)
		)
	)
)

(instance myMusic of Sound
	(properties)
)
