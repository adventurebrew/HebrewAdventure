;;; Sierra Script 1.0 - (do not remove this comment)
(script# 18)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Wander)
(use Timer)
(use Sound)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	rm018 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	[local6 33]
	local39
	local40
	local41
)
(procedure (localproc_0e6a param1 param2 param3)
	(Display
		param1
		dsWIDTH
		50
		dsCOORD
		param2
		param3
		dsCOLOR
		14
		dsFONT
		600
	)
)

(procedure (localproc_0e85 param1 param2 param3)
	(if param1
		(Display
			param1
			dsWIDTH
			50
			dsCOORD
			param2
			param3
			dsFONT
			600
			dsCOLOR
			0
		)
		(vHair forceUpd:)
	)
)

(procedure (localproc_0eac)
	(FButton
		cel: (cond 
			((< global174 2) 2)
			((== global205 1) 1)
			(else 0)
		)
		draw:
	)
	(BButton
		cel: (cond 
			((< global174 2) 2)
			((== global205 2) 1)
			(else 0)
		)
		draw:
	)
	(switch global205
		(0
			(frontShield cel: 0)
			(backShield cel: 0)
		)
		(1
			(frontShield cel: (if (< global174 6) 1 else 2))
			(backShield cel: 0)
		)
		(2
			(frontShield cel: 0)
			(backShield cel: (if (< global174 6) 1 else 2))
		)
	)
)

(instance rm018 of Rm
	(properties
		style 0
	)
	
	(method (init &tmp [temp0 50])
		(if (> global598 4)
			(self picture: 18)
		else
			(self picture: 180)
		)
		(self setRegions: 701)
		(if (> global598 4) (Load 128 46) else (Load 128 146))
		(Load 128 45)
		(Load 128 47)
		(Load 128 48)
		(Load 128 51)
		(Load 128 55)
		(Load 129 121)
		(Load 132 27)
		(Load 132 39)
		(Load 132 31)
		(Load 132 33)
		(Load 132 200)
		(Load 132 201)
		(gEgo
			view: 45
			setLoop: 3
			setCel: 2
			setCycle: 0
			setStep: 4 4
			setPri: 10
			ignoreActors: 1
			posn: 160 88
			illegalBits: 16384
			init:
			setCycle: 0
		)
		(hHair init: stopUpd:)
		(vHair init: stopUpd:)
		(engage init:)
		(super init:)
		(proc0_2)
		(= global592 1)
		(= local5 {NEGATIVE})
		(gGame setCursor: global20 (HaveMouse))
		(gAddToPics add: shipShape eachElementDo: 90)
		(gAddToPics doit:)
		(frontShield init:)
		(backShield init:)
		(controls
			add: FButton BButton HButton fire exit
			eachElementDo: 90
			draw:
		)
		(localproc_0eac)
		(Display
			18
			0
			dsCOORD
			44
			110
			dsFONT
			600
			dsWIDTH
			50
			dsCOLOR
			10
		)
		(= local3 0)
		(if global594 (= global175 2))
	)
	
	(method (doit &tmp [temp0 20])
		(if (and (< global174 2) (not local4))
			(= local4 1)
			(= global205 0)
			(localproc_0eac)
			(Depleted changeState: 1)
		)
		(if (== global175 1)
			(= global175 0)
			(zoomShip init: posn: 0 0)
			(global2
				setScript:
					(switch global594
						(0 ZoomScript)
						(1 ZoomScript)
						(2 ZScript)
					)
			)
		)
		(if local3
			(if (or (== local3 4) (== local3 5))
				(gEgo posn: (targShip x?) (targShip y?))
			)
			(if
				(and
					(gCast contains: targShip)
					(gEgo
						inRect:
							(- (targShip x?) 5)
							(- (targShip y?) 4)
							(+ (targShip x?) 5)
							(+ (targShip y?) 4)
					)
					(== local3 3)
					(== global209 3)
				)
				(proc0_2)
				(= local3 4)
				(global2 setScript: CenterScript)
			)
		)
		(if (== local3 3)
			(if global219 (-- local0))
			(if (not local0)
				(trackSound stop:)
				(global2 setScript: OutOfRange)
			)
		)
		(if (== local3 5)
			(if global219 (-- local1))
			(if (not local1)
				(lockSound stop:)
				(global2 setScript: OutOfRange)
			)
		)
		(super doit:)
	)

;Zvika - disabled this, and replaced with my cheat ;-)	
;Z I probably should've merged them; but this code here looks useless to me...
;	(method (handleEvent param1)
;		(super handleEvent: param1)
;		(if
;		(or (!= (param1 type?) 128) (param1 claimed?))
;			(return)
;		)
;		(if (Said 'look[/area]') (global2 newRoom: 17))
;	)

	(method (handleEvent param1)
		(super handleEvent: param1)
		(if (param1 claimed?) (return))
		(switch (param1 type?)
			(4
				(cond 
					(
						(== (param1 message?) `@r)
						(= global176 5)
						(localproc_0e85 local5 40 125)
						(= local5 {שלילי})
						(RadarScript changeState: 0)
						(proc255_0 18 1)
						(global2 setScript: 0)
						(gGame changeScore: 100)
						(= global218 0)
						(= global175 0)
						(= global594 0)
						(= global167 0)
					)
				)
			)
		)
	)

	
	(method (newRoom param1)
		(User canControl: 1)
		(if (and global218 (< global175 10)) (= global175 10))
		(gTimers eachElementDo: 91 84)
		(super newRoom: param1)
	)
)

(instance OutOfRange of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0
				(proc0_2)
				(= local3 1)
				(= local39 1)
				(lockSign setCel: 3 init: forceUpd:)
				(engage setCel: 0 stopUpd:)
				(targShip
					view: 48
					setLoop: 4
					setCel: 5
					setMotion: 0
					cycleSpeed: 0
					setCycle: Beg self
				)
			)
			(1
				(targShip dispose:)
				(topArrow dispose:)
				(bottomArrow dispose:)
				(leftArrow dispose:)
				(rightArrow dispose:)
				(gEgo setMotion: MoveTo 160 88 self)
			)
			(2
				(lockSign dispose:)
				(gEgo posn: 160 88 stopUpd:)
				(proc0_2)
				(vHair posn: 160 88 stopUpd:)
				(hHair posn: 160 88 stopUpd:)
				(= local39 0)
				(global2 setScript: ZScript)
			)
		)
	)
)

(instance ZoomScript of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0
				(= global594 1)
				(localproc_0e85 local5 40 125)
				(if global207
					(= local5 { IN REAR})
				else
					(= local5 {NEGATIVE})
				)
				(RadarScript changeState: 0)
				(= seconds 3)
			)
			(1
				(boom play:)
				(ShakeScreen 5 3)
				(if (or (not (-- global174)) (!= global205 2))
					(client setScript: BlowShip)
				else
					(zoomShip
						posn: 135 79
						setLoop: 2
						cel: 0
						cycleSpeed: 0
						setCycle: End self
					)
				)
			)
			(2
				(localproc_0e85 local5 40 125)
				(if global207
					(= local5 {IN FRONT})
				else
					(= local5 {NEGATIVE})
				)
				(RadarScript changeState: 0)
				(= global594 2)
				(global2 setScript: TrackScript)
			)
		)
	)
)

(instance ZScript of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0
				(= global594 2)
				(= seconds 4)
			)
			(1
				(localproc_0e85 local5 40 125)
				(if global207
					(= local5 {IN FRONT})
				else
					(= local5 {NEGATIVE})
				)
				(RadarScript changeState: 0)
				(if (not (gCast contains: zoomShip)) (zoomShip init:))
				(zoomShip
					cel: 0
					setLoop: 0
					posn: 185 72
					cycleSpeed: 0
					setCycle: End self
				)
			)
			(2
				(zoomShip
					cel: 0
					setLoop: 1
					posn: 195 80
					setCycle: End self
				)
			)
			(3
				(zoomShip cel: 0 setCycle: End self)
			)
			(4
				(zoomShip cel: 0 setCycle: End self)
			)
			(5
				(zoomShip dispose:)
				(proc0_10)
				(boom play:)
				(ShakeScreen 5 3)
				(if (or (not (-- global174)) (!= global205 1))
					(client setScript: BlowShip)
				else
					(localproc_0e85 local5 40 125)
					(= local5 {NEGATIVE})
					(RadarScript changeState: 0)
				)
				(= global594 0)
				(= global175 10)
			)
		)
	)
)

(instance TrackScript of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0
				(proc0_2)
				(engage setCycle: Fwd)
				(trackSound play:)
				(zoomShip
					setLoop: 4
					cel: 0
					posn: 140 70
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(1
				(targShip
					view: 47
					illegalBits: 16384
					setPri: 8
					setStep: 4 4
					cel: 5
					ignoreActors: 1
					setCycle: 0
					setMotion: Wander 30
					posn: (zoomShip x?) (zoomShip y?)
					init:
				)
				(zoomShip dispose:)
				(proc0_3)
				(= local3 3)
				(= local0 10)
				(vHair startUpd:)
				(hHair startUpd:)
				(lockSign setCel: 1 init: stopUpd:)
				(global2 setScript: 0)
			)
		)
	)
)

(instance CenterScript of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0
				(proc0_2)
				(targShip setMotion: MoveTo 160 88 self)
			)
			(1
				(trackSound stop:)
				(lockSound play:)
				(= local3 5)
				(= local1 5)
				(lockSign setCel: 0 forceUpd:)
				(topArrow init: stopUpd:)
				(bottomArrow init: stopUpd:)
				(leftArrow init: stopUpd:)
				(rightArrow init: stopUpd:)
				(targShip
					setStep: 2 2
					setMotion: Wander 10
					illegalBits: -33
				)
				(global2 setScript: 0)
			)
		)
	)
)

(instance shotScript of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0
				(proc0_2)
				(if (== local3 5) (targShip setMotion: 0 stopUpd:))
				(if
				(not (= local2 (/ (Abs (- (gEgo y?) 88)) 4)))
					(= local2 1)
				)
				(if
				(not (= local40 (Abs (/ (- (gEgo x?) 120) 3))))
					(= local40 1)
				)
				(if
				(not (= local41 (Abs (/ (- 198 (gEgo x?)) 3))))
					(= local41 1)
				)
				(rShot cel: 255 init:)
				(lShot cel: 255 init:)
				(lockSound stop:)
				(proc0_10)
				(laser play:)
				(lShot
					setStep: local40 local2
					setCycle: End
					setMotion: MoveTo (gEgo x?) (gEgo y?) self
				)
				(rShot
					setStep: local41 local2
					setCycle: End
					setMotion: MoveTo (gEgo x?) (gEgo y?)
				)
			)
			(1
				(lShot dispose:)
				(rShot dispose:)
				(engage setCel: 0 stopUpd:)
				(if (== local3 5)
					(= local1 -1)
					(targShip dispose:)
					(blast init: setCycle: End self)
					(lockSound stop:)
					(enemyBoom play:)
				else
					(if (== global210 0) (global2 newRoom: 20))
					(fire cel: 0 state: 1 draw:)
					(= local39 0)
					(if (== local3 3) (proc0_3))
				)
			)
			(2
				(blast dispose:)
				(lockSign setCel: 2 forceUpd:)
				(fire cel: 0 state: 1 draw:)
				(= local3 2)
				(topArrow dispose:)
				(bottomArrow dispose:)
				(leftArrow dispose:)
				(rightArrow dispose:)
				(gEgo setMotion: MoveTo 160 88 self)
			)
			(3
				(= local39 0)
				(= local3 1)
				(lockSign dispose:)
				(gEgo posn: 160 88 stopUpd:)
				(vHair posn: 160 88 stopUpd:)
				(hHair posn: 160 88 stopUpd:)
				(if (== (++ global176) 5)
					(localproc_0e85 local5 40 125)
					(= local5 {NEGATIVE})
					(RadarScript changeState: 0)
					(proc255_0 18 1)
					(global2 setScript: 0)
					(gGame changeScore: 100)
					(= global218 0)
					(= global175 0)
					(= global594 0)
					(= global167 0)
				else
					(global2 setScript: ZScript)
				)
			)
		)
	)
)

(instance BlowShip of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0
				(boom play:)
				(ShakeScreen 20 3)
				(RadarScript changeState: 3)
				(localproc_0e85 local5 40 125)
				(gCast eachElementDo: 91)
				(proc0_12)
				(global2 drawPic: 121)
				(if (not global174)
					(proc255_0 18 2)
				else
					(proc255_0 18 3)
				)
				(proc0_17 0 0 4 5)
			)
		)
	)
)

(instance RadarScript of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0
				(localproc_0e6a local5 40 125)
				(Timer setCycle: self 5)
			)
			(1
				(localproc_0e85 local5 40 125)
				(Timer setCycle: self 5)
			)
			(2 (self changeState: 0))
		)
	)
)

(instance Depleted of Script
	(properties)
	
	(method (doit)
		(if
		(and (== (shWarn state?) -1) (!= (self state?) 2))
			(self changeState: 2)
		)
		(super doit:)
	)
	
	(method (changeState theState)
		(switch (= state theState)
			(0)
			(1
				(shWarn play:)
				(depleted init: setCycle: Fwd)
			)
			(2
				(depleted setCel: 0 stopUpd:)
				(shWarn dispose:)
			)
		)
	)
)

(instance zoomShip of Act
	(properties)
	
	(method (init)
		(super init:)
		(self view: 48 ignoreActors: 1 setPri: 6 illegalBits: 0)
	)
)

(instance frontShield of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: (if (> global598 4) 46 else 146)
			loop: 6
			posn: 258 119
			setPri: 15
			ignoreActors: 1
		)
	)
)

(instance backShield of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: (if (> global598 4) 46 else 146)
			loop: 7
			posn: 258 127
			setPri: 15
			ignoreActors: 1
		)
	)
)

(instance targShip of Act
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 47
			illegalBits: 16384
			setPri: 8
			setStep: 4 4
			cel: 5
			ignoreActors: 1
			setCycle: 0
			setMotion: Wander 30
		)
	)
	
	(method (doit)
		(if (!= (self view?) 48)
			(switch (self onControl: 1)
				(2 (self cel: 1))
				(4 (self cel: 2))
				(8 (self cel: 3))
				(16 (self cel: 4))
				(32 (self cel: 5))
				(64 (self cel: 6))
				(128 (self cel: 7))
				(256 (self cel: 8))
				(512 (self cel: 9))
			)
		)
		(super doit:)
	)
)

(instance hHair of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 45
			setLoop: 3
			setCel: 0
			posn: 160 88
			setPri: 9
			ignoreActors: 1
			setCycle: 0
		)
	)
	
	(method (doit)
		(if local3 (self y: (gEgo y?)))
		(super doit:)
	)
)

(instance vHair of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 45
			setLoop: 3
			setCel: 1
			posn: 160 88
			setPri: 9
			ignoreActors: 1
			setCycle: 0
		)
	)
	
	(method (doit)
		(if local3 (self x: (gEgo x?)))
		(super doit:)
	)
)

(instance lockSign of View
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 45
			loop: 1
			posn: 159 43
			setPri: 15
			ignoreActors: 1
		)
	)
)

(instance topArrow of View
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 45
			setLoop: 2
			setCel: 0
			posn: 160 61
			setPri: 9
			ignoreActors: 1
		)
	)
)

(instance bottomArrow of View
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 45
			setLoop: 2
			setCel: 1
			posn: 160 126
			setPri: 9
			ignoreActors: 1
		)
	)
)

(instance leftArrow of View
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 45
			setLoop: 2
			setCel: 2
			posn: 110 98
			setPri: 9
			ignoreActors: 1
		)
	)
)

(instance rightArrow of View
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 45
			setLoop: 2
			setCel: 3
			setPri: 9
			ignoreActors: 1
			posn: 207 98
		)
	)
)

(instance lShot of Act
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 45
			setLoop: 0
			setCel: 0
			setPri: 14
			ignoreActors: 1
			posn: 120 88
		)
	)
)

(instance rShot of Act
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 45
			setLoop: 0
			setCel: 0
			setPri: 14
			ignoreActors: 1
			posn: 198 88
		)
	)
)

(instance blast of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 55
			setCel: 0
			posn: (gEgo x?) (gEgo y?)
			setPri: 9
			cycleSpeed: 1
			ignoreActors: 1
		)
	)
)

(instance depleted of Prop
	(properties)
	
	(method (init)
		(super init:)
		(= view (if (> global598 4) 46 else 146))
		(self
			setLoop: 0
			setCel: 0
			posn: 259 70
			setPri: 15
			ignoreActors: 1
		)
	)
)

(instance engage of Prop
	(properties)
	
	(method (init)
		(super init:)
		(= view (if (> global598 4) 46 else 146))
		(self
			setLoop: 4
			setCel: 0
			x: 67
			y: 70
			setPri: 15
			ignoreActors: 1
		)
	)
)

(instance shipShape of PV
	(properties
		y 127
		x 258
		loop 5
		priority 14
		signal 16384
	)
	
	(method (init)
		(= view (if (> global598 4) 46 else 146))
		(super init:)
	)
)

(instance shWarn of Sound
	(properties
		number 27
		priority 1
	)
)

(instance laser of Sound
	(properties
		number 39
		priority 3
	)
)

(instance trackSound of Sound
	(properties
		number 200
		priority 1
		loop -1
	)
)

(instance lockSound of Sound
	(properties
		number 201
		priority 2
		loop -1
	)
)

(instance boom of Sound
	(properties
		number 33
		priority 1
	)
)

(instance enemyBoom of Sound
	(properties
		number 31
		priority 1
	)
)

(instance HButton of DIcon
	(properties
		state 1
		nsTop 44
		nsLeft 47
		key 242 ; ע ;104
		loop 3
	)
	
	(method (init)
		(= view (if (> global598 4) 46 else 146))
		(Display
	        "ע"
	        dsCOORD 40 48
	        dsCOLOUR clLIME
	        dsBACKGROUND clBLACK
	        dsFONT 600
	        dsALIGN alCENTER
		)		
		(super init:)
	)
	
	(method (doit)
		(proc255_0 18 4)
	)
)

(instance exit of DIcon
	(properties
		state 1
		nsTop 72
		nsLeft 47
		key 235 ; כ  ; 111
		loop 9
	)
	
	(method (init)
		(= view (if (> global598 4) 46 else 146))
		(Display
	        "כ"
	        dsCOORD 40 75
	        dsCOLOUR clLIME
	        dsBACKGROUND clBLACK
	        dsFONT 600
	        dsALIGN alCENTER
		)		
		(super init:)
	)
	
	(method (doit)
		(self cel: 1 draw:)
		(global2 newRoom: 17)
	)
)

(instance FButton of DIcon
	(properties
		state 1
		nsTop 44
		nsLeft 245
		key 231 ; ח  ; 102
		loop 1
	)
	
	(method (init)
		(= view (if (> global598 4) 46 else 146))
		(Display
	        "ח"
	        dsCOORD 238 48
	        dsCOLOUR clLIME
	        dsBACKGROUND clBLACK
	        dsFONT 600
	        dsALIGN alCENTER
		)		
		(super init:)
	)
	
	(method (doit)
		(switch (self cel?)
			(0 (= global205 1))
			(1 (= global205 0))
			(2 (return))
		)
		(localproc_0eac)
	)
)

(instance BButton of DIcon
	(properties
		state 1
		nsTop 72
		nsLeft 245
		key 224 ; א ;98
		loop 2
	)
	
	(method (init)
		(= view (if (> global598 4) 46 else 146))
		(Display
	        "א"
	        dsCOORD 238 75
	        dsCOLOUR clLIME
	        dsBACKGROUND clBLACK
	        dsFONT 600
	        dsALIGN alCENTER
		)		
		(super init:)
	)
	
	(method (doit)
		(switch (self cel?)
			(0 (= global205 2))
			(1 (= global205 0))
			(2 (return))
		)
		(localproc_0eac)
	)
)

(instance fire of DIcon
	(properties
		state 1
		nsTop 135
		nsLeft 137
		key 32
		loop 8
	)
	
	(method (init)
		(= view (if (> global598 4) 46 else 146))
		(Display
	        "מקש רווח"
	        dsCOORD 143 146
	        dsCOLOUR clLIME
	        dsBACKGROUND clNAVY
	        dsFONT 600
	        dsALIGN alCENTER
		)	
		(super init:)
	)
	
	(method (doit)
		(if (not local39)
			(= local39 1)
			(self cel: 1 draw:)
			(gEgo setScript: shotScript)
		)
	)
)
