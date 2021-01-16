;;; Sierra Script 1.0 - (do not remove this comment)
(script# 290)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Rev)
(use Sound)
(use Cycle)
(use Game)
(use User)
(use TheMenuBar)
(use Feature)
(use Obj)

(public
	rm290 0
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
	local8
	chickenLoop
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
)
(procedure (localproc_0f30)
	(= local2 (Random 70 248))
)

(procedure (localproc_0f3c)
	(if (gEgo has: 8)
		(if (not (-- global154)) (gEgo put: 8 -1))
		(global2 drawPic: 292)
		(Display
			290
			13
			dsCOORD
			52
			180
			dsWIDTH
			91
			dsCOLOR
			0
			dsBACKGROUND
			0
			dsFONT
			600
		)
		(Display
			290
			17
			dsCOORD
			50
			180
			dsWIDTH
			55
			dsCOLOR
			15
			dsBACKGROUND
			0
			dsFONT
			600
		)
		(Display
			290
			12
			dsCOORD
			148
			180
			dsFONT
			600
			dsWIDTH
			90
			dsCOLOR
			0
		)
		(guysLeft init:)
		(localproc_0f30)
		(= local3 22)
		(= local0 local2)
		(= local1 local3)
		(= local4 1)
		(= local5 0)
		(= local7 0)
		(= local8 0)
		(= local6 100)
		(= local10 2)
		(= local11 3)
		(= local12 0)
		(= local13 0)
		(++ global589)
		(= local16 1)
		(= local15 0)
		(Chicken init:)
		(Csong play: loop: -1)
		(proc0_2)
		(= local17 (GetMenu 1282 113))
		(TheMenuBar hide: state: 0)
		(SL enable: state: 1)
		(global2 setScript: 0)
	else
		(proc255_0 290 18)
	)
)

(instance rm290 of Rm
	(properties
		style 7
	)
	
	(method (init)
		(Load 128 290)
		(Load 128 291)
		(Load 129 290)
		(Load 129 291)
		(Load 129 292)
		(Load 132 26)
		(Load 132 33)
		(super init:)
		(= global193 1)
		(self setScript: intro)
	)
	
	(method (doit &tmp [temp0 30])
		(super doit:)
		(if (== script 0)
			(Display
				(Format @temp0 290 0 local6)
				dsCOORD
				80
				180
				dsWIDTH
				15
				dsCOLOR
				15
				dsBACKGROUND
				0
				dsFONT
				600
			)
			(if (not local6)
				(proc0_2)
				(= local15 1)
				(= local5 0)
				(switch local10
					(2 (Chicken loop: 3))
					(0 (Chicken loop: 4))
					(1 (Chicken loop: 5))
				)
			)
			(if (== (Chicken onControl: 1) 16384)
				(= local15 1)
				(self setScript: blowUp)
			)
			(if (== (Chicken onControl: 1) 2048)
				(self setScript: tooHigh)
			)
			(if
			(and (== (Chicken onControl: 1) 4096) (== local13 0))
				(if (< (Abs local4) 6)
					(self setScript: landedOK)
				else
					(Chicken loop: 8 cel: 0)
					(= local5 0)
					(= local13 1)
					(= local4 (- local4 (* local4 2)))
					(if (== chickenLoop 0)
						(= chickenLoop 4)
						(= local10 0)
						(= local7 4)
						(Chicken setCycle: Fwd)
					else
						(= chickenLoop 5)
						(= local10 1)
						(= local7 -4)
						(Chicken setCycle: Rev)
					)
					(= local8 -10)
				)
			)
			(cond 
				((== local5 1) (if (< (-- local4) -10) (= local4 -10)) (-- local6))
				((> (++ local4) 10) (= local4 10))
			)
			(if (and (!= (Chicken loop?) 2) (== local5 1))
				(= local8 1)
				(= chickenLoop (Chicken loop?))
			)
			(if (!= local8 0)
				(if
					(or
						(== local5 0)
						(and (== local5 1) (== (Chicken loop?) 2))
					)
					(++ local8)
				)
				(cond 
					((== local8 12) (= local8 0) (= local7 0))
					((!= (Abs local7) 4) (if (== chickenLoop 1) (= local7 -2) else (= local7 2)))
				)
			)
			(if (< local0 52) (= local0 265))
			(if (> local0 265) (= local0 52))
			(Chicken
				x: (= local0 (+ local0 local7))
				y: (= local1 (+ local1 local4))
			)
		)
	)
	
	(method (handleEvent param1)
		(if (param1 claimed?) (return))
		(switch (param1 type?)
			(4
				(switch (param1 message?)
					(43
						(if (> global3 1) (gGame setSpeed: (-- global3)))
					)
					(45
						(if (< global3 16) (gGame setSpeed: (++ global3)))
					)
					(61 (gGame setSpeed: 5))
					(15360
						(if local17
							(= local17 0)
							(DoSound 4 0)
							(SetMenu 1282 113 0 110 {Turn on})
						else
							(= local17 1)
							(DoSound 4 1)
							(SetMenu 1282 113 1 110 {Turn off})
						)
					)
					(16384
						(param1 claimed: 1)
						(= global193 0)
						(= global159 0)
						(global2 newRoom: 29)
					)
				)
			)
			(128
				(cond 
					((Said 'play[/game,astro,astro]') (proc255_0 290 1))
					((Said 'aid[<get]') (proc255_0 290 2))
					((Said 'read,look,use/instruction') (proc255_0 290 3))
					((Said 'insert,use,drop[<in]/bill') (localproc_0f3c))
					(
					(or (Said 'disembark,quit[/game,device]') (Said '/bye')) (= global193 0) (= global159 0) (global2 newRoom: 29))
					((Said 'beat,tilt/game,device') (proc255_0 290 4))
					((Said 'cheat/game,device') (global2 setScript: youWon))	;Z my addition :-)
					((Said 'look[/area,around,game,device]') (proc255_0 290 5))
					((Said 'look/letter')
						(if local18
							(proc255_0 290 6)
							(if (gEgo has: 7)
								(proc255_0 290 7)
							else
								(proc255_0 290 8)
								(global2 setScript: intro)
							)
						else
							(proc255_0 290 9)
						)
					)
					(
					(or (Said 'use/decoder,relic') (Said 'decode/letter'))
						(= global159 1)
						(proc0_10)
						(if (gEgo has: 7)
							(if
							(and (< global590 120) (not global170) local18)
								(gGame changeScore: 20)
								(= global590 (+ global590 20))
								(= global170 1)
							)
							(= local14
								(proc255_0 290 10 33 603 82 242 0 5 70 240 67 -1 143)
							)
							(= local18 0)
							(= global193 0)
							(= global159 0)
							(self newRoom: 29)
						else
							(proc255_0 290 11)
							(global2 setScript: intro)
						)
					)
				)
			)
			(64
				(= local13 0)
				(switch (param1 message?)
					(1
						(if (== local15 0)
							(Chicken setCycle: Fwd)
							(= local7 0)
							(if (== local5 1)
								(= local5 0)
								(switch local10
									(2 (Chicken loop: 3))
									(0 (Chicken loop: 4))
									(1 (Chicken loop: 5))
								)
							else
								(= local5 1)
								(switch local10
									(2 (Chicken loop: 2))
									(0 (Chicken loop: 0))
									(1 (Chicken loop: 1))
								)
							)
						)
					)
					(5
						(if (== local15 0)
							(= local10 2)
							(Chicken loop: (if (== local5 1) 2 else 3) cel: 0)
						)
					)
					(3
						(if (== local15 0)
							(= local10 0)
							(Chicken loop: (if (== local5 1) 0 else 4) cel: 0)
						)
					)
					(7
						(if (== local15 0)
							(= local10 1)
							(Chicken loop: (if (== local5 1) 1 else 5) cel: 0)
						)
					)
					(8 (param1 claimed: 1) (return))
					(2 (param1 claimed: 1) (return))
					(6 (param1 claimed: 1) (return))
					(4 (param1 claimed: 1) (return))
					(0
						(if (== local15 0)
							(= local10 2)
							(Chicken loop: (if (== local5 1) 2 else 3) cel: 0)
						)
					)
				)
			)
			(256
				(if (== local15 0)
					(Chicken setCycle: Fwd)
					(= local7 0)
					(= local5 1)
					(switch local10
						(2 (Chicken loop: 2))
						(0 (Chicken loop: 0))
						(1 (Chicken loop: 1))
					)
				)
			)
			(512
				(if (== local15 0)
					(Chicken setCycle: Fwd)
					(= local7 0)
					(= local5 0)
					(switch local10
						(2 (Chicken loop: 3))
						(0 (Chicken loop: 4))
						(1 (Chicken loop: 5))
					)
				)
			)
			(1
				(if
					(and
						(<= 146 (param1 x?))
						(<= (param1 x?) 228)
						(<= 178 (param1 y?))
						(<= (param1 y?) 187)
					)
					(param1 claimed: 1)
					(= global193 0)
					(= global159 0)
					(global2 newRoom: 29)
				)
				(if
					(and
						(<= 39 (param1 x?))
						(<= (param1 x?) 142)
						(<= 175 (param1 y?))
						(<= (param1 y?) 189)
						(not local16)
					)
					(param1 claimed: 1)
					(localproc_0f3c)
				)
			)
		)
	)
)

(instance intro of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0
				(proc0_3)
				(= global159 0)
				(guysLeft dispose:)
				(client drawPic: 291)
				(Display
					290
					12
					dsCOORD
					148
					180
					dsFONT
					600
					dsWIDTH
					90
					dsCOLOR
					0
				)
				(Display
					290
					13
					dsCOORD
					52
					180
					dsWIDTH
					91
					dsCOLOR
					15
					dsBACKGROUND
					0
					dsFONT
					600
				)
				(proc0_10)
				(= local16 0)
				(= seconds 5)
			)
			(1
				(client drawPic: 290)
				(Display
					290
					12
					dsCOORD
					148
					180
					dsFONT
					600
					dsWIDTH
					90
					dsCOLOR
					0
				)
				(Display
					290
					13
					dsCOORD
					52
					180
					dsWIDTH
					91
					dsCOLOR
					15
					dsBACKGROUND
					0
					dsFONT
					600
				)
				(Display
					290
					14
					dsCOORD
					60
					60
					dsWIDTH
					200
					dsCOLOR
					15
					dsBACKGROUND
					0
					dsFONT
					600
				)
				(= seconds 6)
			)
			(2
				(Display
					290
					12
					dsCOORD
					148
					180
					dsFONT
					600
					dsWIDTH
					90
					dsCOLOR
					0
				)
				(Display
					290
					13
					dsCOORD
					52
					180
					dsWIDTH
					91
					dsCOLOR
					15
					dsBACKGROUND
					0
					dsFONT
					600
				)
				(Display
					290
					14
					dsCOORD
					60
					60
					dsWIDTH
					200
					dsCOLOR
					0
					dsBACKGROUND
					0
					dsFONT
					600
				)
				(Display
					290
					15
					dsCOORD
					60
					30
					dsWIDTH
					200
					dsCOLOR
					15
					dsBACKGROUND
					0
					dsFONT
					600
				)
				(= seconds 15)
			)
			(3 (self changeState: 0))
		)
	)
)

(instance landedOK of Script
	(properties)
	
	(method (changeState theState &tmp [temp0 5])
		(switch (= state theState)
			(0
				(= local15 1)
				(Chicken loop: 6 cel: 0 setCycle: End self)
			)
			(1
				(Bacock init: setCycle: End self)
			)
			(2 (= seconds 2))
			(3
				(Bacock dispose:)
				(proc0_10)
				(++ local12)
				(if (< global590 50)
					(gGame changeScore: 5)
					(= global590 (+ global590 5))
				)
				(if
				(or (== local12 3) (== local12 6) (== local12 9))
					(++ local11)
				)
				(if (== local12 10)
					(client setScript: youWon)
					(= local15 1)
				else
					(= cycles 2)
				)
			)
			(4
				(localproc_0f30)
				(= local0 local2)
				(= local1 local3)
				(= local4 1)
				(= local5 0)
				(= local7 0)
				(= local8 0)
				(= local10 2)
				(= local6 100)
				(Chicken x: local2 y: local3 loop: 3 setCycle: Fwd)
				(= local15 0)
				(client setScript: 0)
			)
		)
	)
)

(instance youWon of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0
				(Csong stop:)
				(Chicken dispose:)
				(if (< global590 100)
					(gGame changeScore: 50)
					(= global590 (+ global590 50))
				)
				(client drawPic: 290)
				(Display
					290
					12
					dsCOORD
					148
					180
					dsFONT
					600
					dsWIDTH
					90
					dsCOLOR
					0
				)
				(= local18 1)
				(= global159 1)
				(TheMenuBar draw: state: 1)
				(User canInput: 1)
				(= local14
					(Display
						290
						16
						dsCOORD
						60
						30
						dsWIDTH
						200
						dsCOLOR
						15
						dsBACKGROUND
						0
						dsFONT
						603
					)
				)
			)
		)
	)
)

(instance blowUp of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0
				(boom play:)
				(explosion
					loop: 0
					cel: 0
					x: (Chicken x?)
					y: (+ (Chicken y?) 10)
					init:
					setCycle: End self
				)
				(Chicken hide:)
			)
			(1
				(explosion loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(rm290 setScript: death)
				(explosion dispose:)
			)
		)
	)
)

(instance tooHigh of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0
				(= local4 1)
				(= local5 0)
				(= local7 0)
				(= local8 0)
				(= local10 2)
				(= local15 0)
				(= local13 0)
				(Chicken loop: 3)
				(client setScript: 0)
			)
		)
	)
)

(instance death of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0
				(if (== (-- local11) 0)
					(client setScript: byeBye)
				else
					(= cycles 2)
				)
			)
			(1
				(localproc_0f30)
				(Chicken x: local2 y: local3 show:)
				(= local0 local2)
				(= local1 local3)
				(= local4 1)
				(= local5 0)
				(= local7 0)
				(= local8 0)
				(= local10 2)
				(= local6 100)
				(= local15 0)
				(= local13 0)
				(Chicken loop: 3)
				(client setScript: 0)
			)
		)
	)
)

(instance byeBye of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0
				(Csong stop:)
				(gameOver init: setCycle: Fwd)
				(TheMenuBar draw: state: 1)
				(SL enable: state: 1)
				(= seconds 4)
			)
			(1
				(gameOver dispose:)
				(if (== global589 10)
					(global2 setScript: youWon)
				else
					(Chicken dispose:)
					(global2 setScript: intro)
				)
			)
		)
	)
)

(instance Chicken of Act
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 290
			ignoreActors:
			setLoop: 3
			setCel: 0
			setPri: 13
			x: local0
			y: local1
			setStep: 1
		)
	)
)

(instance guysLeft of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 290
			setLoop: 7
			setCel: 0
			setPri: 15
			x: 100
			y: 189
			stopUpd:
		)
	)
	
	(method (doit)
		(super doit:)
		(self setCel: (- local11 1))
	)
)

(instance Bacock of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 291
			setPri: 14
			setLoop: 2
			posn: (- (Chicken x?) 2) (- (Chicken y?) 21)
		)
	)
)

(instance gameOver of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self view: 291 setLoop: 3 setPri: 14 posn: 155 91)
	)
)

(instance explosion of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self view: 291 setPri: 14 setLoop: 0 setCel: 0)
	)
)

(instance Csong of Sound
	(properties
		number 26
		loop -1
	)
)

(instance boom of Sound
	(properties
		number 33
		priority 1
	)
)
