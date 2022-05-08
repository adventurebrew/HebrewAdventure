;;; Sierra Script 1.0 - (do not remove this comment)
(script# 779)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Wander)
(use Path)
(use Sound)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	Tulane 0
)

(local
	local0 =  1
	local1
	local2
	local3
	[local4 5] = [98 101 324 101 -32768]
	[local9 21] = [93 135 138 132 175 125 220 126 247 124 277 132 288 133 304 150 320 161 332 161 -32768]
	[local30 21] = [320 161 304 150 288 133 277 132 247 124 220 126 175 125 138 132 93 135 14 130 -32768]
	[local51 11] = [317 131 298 137 304 150 320 161 332 161 -32768]
)
(procedure (localproc_011c param1 param2 param3)
	(proc255_0
		&rest
		67
		param1
		param2
		33
		4
		70
		param3
		30
		1
		83
		88
	)
)

(instance tinyLRPath of Path
	(properties)
	
	(method (at param1)
		(return [local4 param1])
	)
)

(instance largeLRPath of Path
	(properties)
	
	(method (at param1)
		(return [local9 param1])
	)
)

(instance largeRLPath of Path
	(properties)
	
	(method (at param1)
		(return [local30 param1])
	)
)

(instance largeTBPath of Path
	(properties)
	
	(method (at param1)
		(return [local51 param1])
	)
)

(instance statue of PV
	(properties
		y 112
		x 226
		view 178
		priority 11
		signal $4000
	)
)

(instance bench of PV
	(properties
		y 183
		x 104
		view 178
		cel 1
		priority 13
		signal $4000
	)
)

(instance LilysHead of PV
	(properties
		y 140
		x 127
		view 513
		loop 1
		priority 12
		signal $4000
	)
)

(instance LilysLegs of PV
	(properties
		y 183
		x 128
		view 513
		loop 1
		cel 1
		signal $4000
	)
)

(instance LaurasHead of Prop
	(properties)
)

(instance LaurasArms of Prop
	(properties)
)

(instance squirrel of Prop
	(properties)
)

(instance pigeon of Act
	(properties)
)

(instance tiny of Act
	(properties)
)

(instance small of Act
	(properties)
)

(instance large of Act
	(properties)
)

(instance Lillian of Act
	(properties)
)

(instance bFly of Act
	(properties)
)

(instance picWindow of Cage
	(properties)
)

(instance campusRag of Sound
	(properties)
)

(instance Tulane of Rm
	(properties
		picture 78
		style $0004
	)
	
	(method (init)
		(super init:)
		(= global161 (= local3 0))
		(proc0_3)
		(Load rsVIEW 278)
		(Load rsVIEW 513)
		(Load rsVIEW 524)
		(Load rsVIEW 528)
		(Load rsSOUND 3)
		(Load rsFONT 4)
		(Load rsFONT 40)
		(Load rsFONT 41)
		(gAddToPics add: bench statue doit:)
		(LaurasHead
			view: 178
			loop: 1
			cel: 0
			posn: 100 142
			setPri: 12
			ignoreActors: 1
			stopUpd:
			setScript: LauraReading
			init:
		)
		(LaurasArms
			view: 178
			loop: 3
			cel: 0
			posn: 101 165
			setPri: 14
			ignoreActors: 1
			stopUpd:
			init:
		)
		(large view: 530 posn: 10 130 setCycle: Walk init:)
		(small
			view: 529
			setLoop: 3
			posn: 320 110
			setStep: 1 1
			setCycle: Walk
			init:
			hide:
		)
		(tiny
			view: 529
			setLoop: 0
			posn: 12 107
			setPri: 5
			setStep: 1 1
			moveSpeed: 1
			cycleSpeed: 1
			setCycle: Walk
			init:
			hide:
		)
		(Lillian ignoreActors: 1 init: stopUpd: hide:)
		(picWindow left: -2 right: 321 bottom: 191 top: -2 init:)
		(bFly
			view: 378
			posn: 61 162
			setStep: 3 3
			setPri: 14
			observeBlocks: picWindow
			ignoreHorizon: 1
			setMotion: Wander
			cycleSpeed: 0
			setCycle: Walk
			init:
		)
		(squirrel
			view: 206
			loop: 0
			cel: 0
			posn: 18 159
			setPri: 15
			stopUpd:
			init:
		)
		(pigeon
			view: 278
			setLoop: 0
			posn: 26 12
			setPri: 14
			setCycle: Walk
			stopUpd:
			init:
		)
		(self setScript: campusLife)
	)
	
	(method (dispose)
		(DisposeScript 976)
		(DisposeScript 983)
		(super dispose:)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(switch (pEvent type?)
			(evKEYBOARD
				(cond 
					(
						(or
							(== (pEvent message?) KEY_S)
							(== (pEvent message?) KEY_s)
							(== (pEvent message?) $e3)	;Z Hebrew Dalet (windows 1255)
						)
						(LaurasHead setScript: 0)
						(LaurasArms setScript: 0)
						(Lillian setScript: 0)
						(global2 newRoom: 780)
					)
					(
						(or
							(== (pEvent message?) KEY_RETURN)
							(== (pEvent message?) KEY_SPACE)
						)
						(proc0_5 50)
					)
				)
			)
			(evMOUSEBUTTON (proc0_5 50))
		)
		(if (proc0_7 50)
			(pEvent claimed: 1)
			(LaurasHead setScript: 0)
			(LaurasArms setScript: 0)
			(Lillian setScript: 0)
			(global2 newRoom: 44)
		)
	)
	
	(method (newRoom newRoomNumber)
		(= global161 0)
		(super newRoom: newRoomNumber)
	)
)

(instance campusLife of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (== (campusRag prevSignal?) -1)
			(client setScript: 0)
			(global2 newRoom: 780)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(campusRag number: 3 loop: -1 play:)
				(= cycles 2)
			)
			(1
				(proc255_0 779 0 67 80 20 33 40 70 160 30 1 83 88)
				(= seconds 6)
			)
			(2
				(proc0_15)
				(pigeon setScript: Pigeon)
				(large setMotion: largeLRPath self)
				(small show: setMotion: MoveTo -4 110)
			)
			(3
				(tiny show: setMotion: tinyLRPath)
				(= local1
					(Display
						779
						1
						dsCOORD
						11
						12
						dsWIDTH
						240
						dsCOLOR
						0
						dsBACKGROUND
						-1
						dsFONT
						41
						dsSAVEPIXELS
					)
				)
				(= local2
					(Display
						779
						1
						dsCOORD
						10
						10
						dsWIDTH
						240
						dsCOLOR
						14
						dsBACKGROUND
						-1
						dsFONT
						41
						dsSAVEPIXELS
					)
				)
				(= seconds 5)
			)
			(4
				(large view: 524 y: 131 setMotion: largeTBPath)
				(= seconds 5)
			)
			(5
				(squirrel startUpd:)
				(Display 779 2 108 local2)
				(Display 779 2 108 local1)
				(Lillian
					view: 513
					setLoop: 0
					cel: 7
					posn: 320 188
					show:
					setCycle: Walk
					startUpd:
					setMotion: MoveTo 127 183 self
				)
			)
			(6
				(gAddToPics add: LilysHead LilysLegs doit:)
				(Lillian
					loop: 2
					cel: 0
					x: (- (Lillian x?) 3)
					y: (- (Lillian y?) 26)
					stopUpd:
				)
				(LaurasHead setScript: 0 setCycle: End)
				(LaurasArms loop: 4 cel: 0 setCycle: End)
				(squirrel cycleSpeed: 1 setCycle: End self)
			)
			(7
				(squirrel
					loop: 2
					cel: 0
					posn: 41 159
					cycleSpeed: 8
					setCycle: Fwd
				)
				(LaurasArms loop: 5 cel: 0 setCycle: End)
				(Lillian setScript: LillianSpeaking)
				(localproc_011c 170 25 130 779 3)
				(= seconds 8)
			)
			(8
				(squirrel loop: 3)
				(large view: 528 setMotion: largeRLPath)
				(= local3 1)
				(LaurasHead loop: 2 cel: 0 stopUpd:)
				(LaurasArms loop: 6 stopUpd: setScript: LauraSpeaking)
				(localproc_011c 10 75 100 779 4)
				(= seconds 8)
			)
			(9
				(squirrel
					loop: 1
					cel: 0
					setPri: -1
					cycleSpeed: 1
					setCycle: End
				)
				(small view: 529 setLoop: 6 setMotion: MoveTo 320 110)
				(LaurasHead cel: 0 forceUpd:)
				(= local3 0)
				(localproc_011c 170 40 130 779 5)
				(= seconds 8)
			)
			(10
				(squirrel stopUpd:)
				(= local3 1)
				(localproc_011c 10 60 100 779 6)
				(= seconds 5)
			)
			(11
				(LaurasHead cel: 0 forceUpd:)
				(LaurasArms setScript: 0)
				(Lillian setScript: 0)
				(campusRag fade:)
			)
		)
	)
)

(instance LauraReading of Script
	(properties)
	
	(method (changeState newState)
		(if (not (LaurasArms script?))
			(switch (= state newState)
				(0 (= cycles (Random 20 50)))
				(1
					(LaurasArms setCycle: End self)
				)
				(2
					(LaurasArms stopUpd:)
					(= cycles 1)
					(= state -1)
				)
			)
		)
	)
)

(instance LauraSpeaking of Script
	(properties)
	
	(method (changeState newState)
		(if local3
			(if (== global161 0)
				(= global161 (Random 10 20))
				(switch (= state newState)
					(0
						(LaurasHead setCycle: Fwd)
						(LaurasArms setCycle: End self)
					)
					(1 (LaurasArms setCycle: Beg))
				)
			)
		else
			(switch (= state newState)
				(0
					(if (LaurasArms cel?)
						(LaurasArms setCycle: Beg self)
						(LaurasHead cel: 0 setCycle: 0 stopUpd:)
					else
						(= cycles 1)
					)
				)
				(1 (LaurasArms stopUpd:))
			)
		)
		(= state -1)
		(= cycles 1)
	)
)

(instance LillianSpeaking of Script
	(properties)
	
	(method (changeState newState)
		(if (not local3)
			(if (== global161 0)
				(= global161 (Random 10 20))
				(switch (= state newState)
					(0 (Lillian setCycle: End self))
					(1 (Lillian setCycle: Beg))
				)
			)
		else
			(switch (= state newState)
				(0
					(if (Lillian cel?)
						(Lillian setCycle: Beg self)
					else
						(= cycles 1)
					)
				)
				(1 (Lillian stopUpd:))
			)
		)
		(= state -1)
		(= cycles 1)
	)
)

(instance Pigeon of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(pigeon startUpd: setMotion: MoveTo 205 40 self)
			)
			(1
				(pigeon setCel: 0 setMotion: MoveTo 220 36 self)
			)
			(2
				(pigeon setCel: -1 setMotion: MoveTo 225 38 self)
			)
			(3 (pigeon setCycle: Beg self))
			(4
				(pigeon loop: 1 posn: 219 46 setCycle: End self)
			)
			(5
				(pigeon addToPic:)
				(client setScript: 0)
			)
		)
	)
)
