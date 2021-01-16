;;; Sierra Script 1.0 - (do not remove this comment)
(script# 69)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Sound)
(use Cycle)
(use Game)
(use User)
(use TheMenuBar)
(use Feature)
(use Obj)

(public
	rm069 0
)

(local
	local0
	local1
	local2
)
(instance rm069 of Rm
	(properties
		picture 69
		horizon 82
		north 66
		east 70
	)
	
	(method (init &tmp [temp0 50])
		(proc0_3)
		(self setRegions: 600)
		(Load 128 92)
		(if (not (gEgo has: 9)) (anemo init:) (pole init:))
		(if (not global253)
			(Load 128 93)
			(Load 132 38)
			(Load 132 44)
			(pirate1 init:)
			(pirate2 init:)
			(= local0 30)
		)
		(super init:)
		(switch gNorth
			(66 (gEgo posn: 81 84 init:))
			(70
				(gEgo
					posn: 317 (if (< (gEgo y?) 80) 83 else (gEgo y?))
					init:
				)
			)
			(690
				(gEgo view: 0 loop: 0 cel: 0 posn: 70 155 init:)
				(gEgo setLoop: -1)
			)
		)
		(TheMenuBar draw:)
		(SL enable:)
	)
	
	(method (doit &tmp gEgoOnControl [temp1 50])
		(super doit:)
		(if local1 (global2 newRoom: 690))
		(if global219 (-- local0))
		(if (and (== local0 1) (not script))
			(= local0 0)
			(global2 setScript: LeaveScript)
		)
		(if (not (global2 script?))
			(cond 
				((== (= gEgoOnControl (gEgo onControl:)) 3) (gEgo setPri: 3 illegalBits: 0) (= global180 1))
				((and (== gEgoOnControl 5) (not global253)) (global2 setScript: shootScript))
			)
		)
	)
	
	(method (handleEvent param1)
		(super handleEvent: param1)
		(if
		(or (!= (param1 type?) 128) (param1 claimed?))
			(return)
		)
		(cond 
			((Said 'look>')
				(cond 
					((Said '/gun') (if global253 (proc255_0 69 0) else (proc255_0 69 1)))
					((Said '/[around,area]') (if global253 (proc255_0 69 2) else (proc255_0 69 3)))
					((Said '/craft') (if local2 (proc255_0 69 4) else (param1 claimed: 0)))
					(
						(Said
							'/station,device,device,equipment[<seismic,research]'
						)
						(if (gEgo has: 9)
							(proc255_0 69 5)
						else
							(proc255_0 69 6)
						)
					)
					((Said '/pole')
						(if (proc0_13 9)
							(proc255_0 69 7)
						else
							(param1 claimed: 0)
						)
					)
					((Said '/anemometer,meter[<wind]') (proc255_0 69 8))
					((Said '/antenna') (proc255_0 69 9))
					((Said '/box')
						(if (gEgo inRect: 220 141 254 155)
							(proc255_0 69 10)
						else
							(proc255_0 69 11)
						)
					)
					((Said '<in,in,through/scope')
						(if (gEgo inRect: 56 139 76 159)
							(global2 setScript: ScopeScript)
						else
							(proc255_0 69 12)
						)
					)
					((Said '/scope') (proc255_0 69 13))
					((Said '/rock,boulder') (proc255_0 69 14))
				)
			)
			((Said 'get>')
				(cond 
					(
						(Said
							'/antenna,station,device,equipment[<seismic,research]'
						)
						(proc255_0 69 15)
					)
					((or (Said '/scope') (Said '/box')) (proc255_0 69 16))
					((Said '/anemometer,meter[<wind]')
						(cond 
							((gEgo has: 9) (proc255_0 69 17))
							((gEgo inRect: 230 129 260 143) (proc255_0 69 18))
							(else (proc0_5))
						)
					)
					((Said '/pole')
						(cond 
							((gEgo has: 9) (proc255_0 69 19))
							((gEgo inRect: 230 129 260 143)
								(proc255_0 69 20)
								(gEgo get: 9)
								(pole dispose:)
								(gGame changeScore: 10)
								(anemo dispose:)
							)
							(else (proc0_5))
						)
					)
					((Said '/detonator')
						(cond 
							((gEgo has: 10) (proc255_0 69 19))
							((gEgo inRect: 220 141 254 155) (proc255_0 69 21) (gGame changeScore: 10) (gEgo get: 10))
							(else (proc0_5))
						)
					)
				)
			)
			((Said 'conceal') (proc255_0 69 22))
			((Said 'use/scope')
				(if (gEgo inRect: 56 139 76 159)
					(global2 setScript: ScopeScript)
				else
					(proc255_0 69 12)
				)
			)
			((Said 'attack/man,flunky') (if global253 (proc255_0 69 23) else (proc255_0 69 24)))
			((Said 'converse[/man,flunky]') (if global253 (proc255_0 69 25) else (proc255_0 69 26)))
			((Said 'open/box') (proc255_0 69 27))
		)
	)
	
	(method (newRoom param1)
		(if (not script)
			(gTimers eachElementDo: 91)
			(if global256 (++ global593))
			(super newRoom: param1)
		)
	)
)

(instance ScopeScript of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0
				(proc0_2)
				(gEgo illegalBits: 0)
				(if (gEgo inRect: 67 139 76 149)
					(gEgo setMotion: MoveTo 63 155 self)
				else
					(= cycles 2)
				)
			)
			(1
				(gEgo setMotion: MoveTo 70 155 self)
			)
			(2
				(gEgo
					view: 92
					setLoop: 4
					cel: 0
					illegalBits: -32768
					setCycle: End self
				)
			)
			(3
				(= local1 1)
				(proc0_3)
				(global2 setScript: 0)
			)
		)
	)
)

(instance shootScript of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0
				(proc0_2)
				(gEgo setMotion: MoveTo 108 123 self)
				(pirate1 setScript: 0 setLoop: 3 setCycle: End)
			)
			(1
				(gEgo setCycle: 0)
				(jello play:)
				(pirate1 setLoop: 4 setCycle: End self)
			)
			(2
				(blast init: setCycle: End self)
				(pirate1 setLoop: 3 setCel: 5 setCycle: Beg)
			)
			(3
				(pirate1 stopUpd:)
				(blast dispose:)
				(gEgo view: 92 setLoop: 2 setCycle: Fwd)
				(= seconds 5)
			)
			(4
				(proc255_0 69 28)
				(proc0_17 0 0 7 15)
			)
		)
	)
)

(instance LeaveScript of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0
				(User canControl: 0 canInput: 1)
				(gEgo setCycle: 0 setMotion: 0)
				(pirate2
					setScript: 0
					setLoop: 0
					setCycle: Walk
					ignoreControl: 1
					setMotion: MoveTo 71 158 self
				)
				(pirate1
					setScript: 0
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 329 (pirate1 y?)
				)
			)
			(1
				(pirate2 setMotion: MoveTo 329 (pirate2 y?) self)
			)
			(2
				(pirate1 dispose:)
				(pirate2 dispose:)
				(proc255_0 69 29)
				(zoom play:)
				(= global253 1)
				(= seconds 3)
			)
			(3
				(= local2 1)
				(ship init: setMotion: MoveTo 290 25 self)
			)
			(4
				(ship setCel: 1 setMotion: MoveTo 241 25 self)
			)
			(5
				(ship setCel: 2 setMotion: MoveTo 228 24 self)
			)
			(6
				(ship setCel: 3 setMotion: MoveTo 230 17 self)
			)
			(7
				(ship setCel: 4 setMotion: MoveTo 238 13 self)
			)
			(8
				(ship setCel: 5 setMotion: MoveTo 245 10 self)
			)
			(9
				(ship setCel: 6 setMotion: MoveTo 255 0 self)
			)
			(10
				(= local2 0)
				(ship dispose:)
				(gEgo setCycle: Walk)
				(proc0_3)
				(global2 setScript: 0)
			)
		)
	)
)

(instance p1Script of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0 (= seconds (Random 5 10)))
			(1 (client setCycle: End self))
			(2
				(client stopUpd:)
				(self changeState: 0)
			)
		)
	)
)

(instance p2Script of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0 (= seconds (Random 5 10)))
			(1 (client setCycle: End self))
			(2
				(client stopUpd:)
				(self changeState: 0)
			)
		)
	)
)

(instance pirate1 of Act
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 93
			setLoop: 2
			setCel: 0
			setPri: -1
			posn: 215 126
			ignoreActors: 1
			setScript: p1Script
		)
	)
)

(instance pirate2 of Act
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 93
			setLoop: 6
			setCel: 0
			setPri: -1
			posn: 75 154
			ignoreActors: 1
			setScript: p2Script
		)
	)
	
	(method (handleEvent param1)
		(super handleEvent: param1)
		(if
		(or (!= (param1 type?) 128) (param1 claimed?))
			(return)
		)
		(if (Said 'look/flunky,man,clerk') (proc255_0 69 30))
	)
)

(instance ship of Act
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 92
			setLoop: 3
			setCel: 0
			setStep: 10 5
			setPri: 15
			x: 332
			y: 25
			ignoreActors: 1
			ignoreHorizon: 1
			ignoreControl: 1
		)
	)
)

(instance blast of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 93
			setLoop: 5
			setCel: 0
			setPri: 8
			posn: 153 110
			ignoreActors: 1
		)
	)
)

(instance pole of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 92
			posn: 248 134
			setLoop: 1
			setCel: 0
			setPri: 10
			ignoreActors: 1
		)
	)
)

(instance anemo of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 92
			setLoop: 0
			setCel: 0
			setPri: 11
			posn: 247 99
			ignoreActors: 1
			setCycle: Fwd
			cycleSpeed: 0
		)
	)
)

(instance jello of Sound
	(properties
		number 44
		priority 1
	)
)

(instance zoom of Sound
	(properties
		number 38
		priority 1
	)
)
