;;; Sierra Script 1.0 - (do not remove this comment)
(script# 25)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	rm25 0
)

(local
	local0
	local1
	local2
)
(instance rm25 of Rm
	(properties
		picture 25
	)
	
	(method (init &tmp [temp0 50])
		(User canInput: 1 canControl: 1)
		(Load 128 38)
		(eyes init: setScript: BoredEyes)
		(mouth init: setScript: BoredMouth)
		(super init:)
		(gAddToPics add: sine)
		(gAddToPics doit:)
		(Display
			25
			0
			dsCOORD
			121
			183
			dsFONT
			600
			dsWIDTH
			90
			dsCOLOR
			0
		)
		(switch gNorth
			(29
				(global2 setScript: Welcome)
			)
			(280
				(if (> global244 0) (global2 setScript: PayUp))
			)
		)
	)
	
	(method (doit)
		(super doit:)
	)
	
	(method (handleEvent param1 &tmp [temp0 50])
		(if (param1 claimed?) (return))
		(switch (param1 type?)
			(128
				(cond 
					(
						(or
							(Said 'pay[/dinner,alien,man,clerk,him,bill]')
							(Said 'give/bill')
						)
						(cond 
							((or (!= gNorth 280) (not global244)) (proc255_0 25 1))
							((>= global154 global244)
								(if (not (= global154 (- global154 global244)))
									(gEgo put: 8 -1)
								)
								(= global247 1)
								(= global244 0)
								(= global248 1)
								(if global249 (gGame changeScore: 10))
								(= global193 0)
								(global2 setScript: LeaveRoom)
							)
							(else (global2 setScript: noMoney))
						)
					)
					((Said 'give,trade/crystal[/dinner]') (proc255_0 25 2))
					((or (Said 'disembark[/area]') (Said '/bye'))
						(= global244 0)
						(= global248 0)
						(= global193 0)
						(= global101 0)
						(global2 newRoom: 29)
					)
					((Said 'look[/area]') (proc255_0 25 3))
					((Said 'look/up,down,deck,ceiling') (proc255_0 25 4))
					((Said 'look,read/menace') (proc255_0 25 5))
					((Said 'look/attire,cap') (proc255_0 25 6))
					((Said '/bitch,her') (proc255_0 25 7))
					(
					(Said 'look/man,clerk,alien,him,bystander,animal') (proc255_0 25 8))
					((Said 'look/eye') (proc255_0 25 9))
					((Said 'look/lip') (proc255_0 25 10))
					((Said 'look/cavity') (proc255_0 25 11))
					(
					(Said 'converse[/man,clerk,alien,him,bystander,animal]') (proc255_0 25 12))
					(
					(Said 'kiss/man,clerk,alien,him,bystander,animal') (proc255_0 25 13))
					(
					(Said 'smell[/man,clerk,alien,him,bystander,animal]') (proc255_0 25 14))
					((Said 'eat') (proc255_0 25 15))
					(
						(or
							(Said 'look,read/menu')
							(Said 'order')
							(Said 'order,buy/dinner')
							(Said 'converse/clerk')
						)
						(global2 newRoom: 280)
					)
				)
			)
			(4
				(if (== (param1 message?) 16384)
					(param1 claimed: 1)
					(= global193 0)
					(= global101 0)
					(global2 setScript: LeaveRoom)
				)
			)
			(1
				(if
					(and
						(<= 119 (param1 x?))
						(<= (param1 x?) 202)
						(<= 163 (param1 y?))
						(<= (param1 y?) 190)
					)
					(param1 claimed: 1)
					(= global193 0)
					(= global101 0)
					(global2 setScript: LeaveRoom)
				)
			)
		)
	)
)

(instance Welcome of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0
				(= global193 1)
				(balloon init: setCel: 1 stopUpd:)
				(mouth setLoop: 0 setCycle: Fwd)
				(= seconds 4)
			)
			(1
				(balloon setCel: 2)
				(= seconds 4)
			)
			(2
				(mouth setCel: 0 stopUpd:)
				(balloon dispose:)
				(global2 setScript: 0)
				(= global193 0)
			)
		)
	)
)

(instance noMoney of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0
				(= global193 1)
				(if (== local0 1)
					(= local0 0)
					(eyes setMotion: MoveTo 155 74)
				)
				(balloon init: setCel: 4 stopUpd:)
				(mouth setLoop: 0 setCycle: Fwd)
				(= seconds 7)
			)
			(1
				(= global244 0)
				(= global247 0)
				(= global193 0)
				(= global101 0)
				(global2 newRoom: 29)
			)
		)
	)
)

(instance LeaveRoom of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0
				(balloon dispose:)
				(= cycles 1)
			)
			(1
				(Display 25 16 108 local1)
				(global2 newRoom: 29)
			)
		)
	)
)

(instance PayUp of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0
				(= global193 1)
				(balloon init: setCel: 3 stopUpd:)
				(= local1
					(Display
						(Format @global402 25 17 global244)
						dsCOORD
						202  ;Z original: 207
						98
						dsWIDTH
						30
						dsCOLOR
						0
						dsBACKGROUND
						15
						dsFONT
						600
						dsSAVEPIXELS
					)
				)
				(mouth setLoop: 0 setCycle: Fwd)
				(= seconds 7)
			)
			(1
				(mouth setCel: 0 stopUpd:)
				(balloon dispose:)
				(= cycles 2)
			)
			(2
				(Display 25 16 108 local1)
				(= global193 0)
				(global2 setScript: 0)
			)
		)
	)
)

(instance BoredMouth of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0 (= seconds (Random 5 15)))
			(1
				(if (!= (rm25 script?) 0)
					(self changeState: 0)
				else
					(mouth setLoop: 1 setCel: (Random 0 2))
				)
				(self changeState: 0)
			)
		)
	)
)

(instance BoredEyes of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0 (= seconds (Random 3 12)))
			(1
				(cond 
					((!= (rm25 script?) 0) (self changeState: 0))
					((== local0 0)
						(= local0 1)
						(switch (Random 1 3)
							(1
								(eyes setMotion: MoveTo 155 61 self)
							)
							(2
								(eyes setMotion: MoveTo 172 71 self)
							)
							(3
								(eyes setMotion: MoveTo 139 71 self)
							)
						)
					)
					(else (= local0 0) (eyes setMotion: MoveTo 155 71 self))
				)
			)
			(2 (self changeState: 0))
		)
	)
)

(instance eyes of Act
	(properties)
	
	(method (init)
		(super init:)
		(self view: 38 setLoop: 2 posn: 155 71 ignoreActors: 1)
	)
)

(instance mouth of Act
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 38
			setLoop: 1
			setCel: 0
			posn: 155 137
			ignoreActors: 1
			cycleSpeed: 2
		)
	)
)

(instance balloon of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 38
			setLoop: 3
			setCel: 3
			posn: 206 119
			setPri: 15
		)
	)
)

(instance sine of PV
	(properties
		y 89
		x 290
		view 38
		loop 3
		priority 15
		signal 16384
	)
)
