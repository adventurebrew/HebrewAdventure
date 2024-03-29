;;; Sierra Script 1.0 - (do not remove this comment)
(script# 414)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Sound)
(use Cycle)
(use Game)
(use TheMenuBar)
(use Feature)
(use Obj)

(public
	myCopy 0
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 48] = [0 36 40 52 0 62 59 85 0 89 37 107 0 116 54 137 0 129 65 161 34 164 107 182 129 164 204 182 219 164 298 182 250 31 303 53 250 60 303 84 250 90 303 118 250 126 303 154]
	[local53 24] = [0 1 5 2 3 4 7 6 8 11 9 10 3 0 7 1 6 5 11 2 4 8 10 9]
	[local77 24] = [10 39 10 68 10 94 10 120 10 143 62 168 159 168 255 168 266 39 266 67 266 97 266 133]
	local101
	local102
	local103
	local104
)
(procedure (localproc_0136)
	(SetCursor
		1
		1
		[local77 (* local101 2)]
		[local77 (+ (* local101 2) 1)]
	)
)

(procedure (localproc_0150 param1 param2 &tmp temp0)
	(= temp0 0)
	(while (< temp0 12)
		(if
			(and
				(> param1 [local5 (* temp0 4)])
				(> param2 [local5 (+ (* temp0 4) 1)])
				(< param1 [local5 (+ (* temp0 4) 2)])
				(< param2 [local5 (+ (* temp0 4) 3)])
			)
			(return temp0)
		)
		(++ temp0)
	)
	(return 13)
)

(procedure (localproc_01a9)
	(gCast eachElementDo: #hide)
	(DrawPic 88 dpOPEN_BOTTOM dpCLEAR 1)
)

(procedure (localproc_01bf)
	(localproc_01a9)
	(proc255_0 414 0 30 1)
	(= global4 1)
)

(instance Logo of Prop
	(properties)
)

(instance Finger of Prop
	(properties)
)

(instance Glass of Act
	(properties)
)

(instance Mood of Sound
	(properties)
)

(instance myCopy of Rm
	(properties
		picture 88
		style $0008
	)
	
	(method (init)
		(super init:)
		(TheMenuBar state: 0)
		(= local102 1)
		(gConMusic number: 52 loop: -1 play:)
		(= local0 (/ (Random 0 600) 100))
		(= local1 (/ (Random 1 1000) 250))
		(SetCursor 1 1 320 20)
		(Logo
			view: 553
			loop: 4
			cel: 1
			posn: 161 120
			init:
			stopUpd:
		)
		(Finger
			view: 553
			loop: local1
			cel: local0
			posn: 161 110
			init:
			hide:
		)
		(Glass
			view: 553
			setLoop: 5
			setCel: 0
			setStep:
			(switch global223
				(1 6)
				(else  3)
			) 3
			posn: 161 140
			init:
		)
		(self setScript: identify)
	)
	
	(method (doit)
		(super doit:)
	)
	
	(method (dispose)
		(super dispose:)
	)
	
	(method (handleEvent pEvent &tmp temp0)
		(if (not local104)
			(if local102
				(switch (pEvent type?)
					(evKEYBOARD
						(cond 
							((== (pEvent message?) KEY_RETURN)
								(Logo dispose:)
								(Glass posn: 162 140 setMotion: 0 stopUpd:)
								(Finger show: stopUpd:)
								(identify state: 4 seconds: 0 cycles: 0)
								(self cue:)
							)
							((== (pEvent message?) KEY_F2)
								(= temp0 (DoSound sndSET_SOUND))
								(DoSound sndSET_SOUND (not temp0))
							)
						)
					)
				)
				(pEvent claimed: 1)
				(return)
			)
			(switch (pEvent type?)
				(evJOYDOWN
					(= local104 1)
					(= local102 1)
					(if
						(==
							(= local4 (localproc_0150 (pEvent x?) (pEvent y?)))
							[local53 (+ (* local1 6) local0)]
						)
						(self cue:)
					else
						(localproc_01bf)
					)
					(pEvent claimed: 1)
				)
				(evMOUSEBUTTON
					(= local104 1)
					(= local102 1)
					(if
						(==
							(= local4 (localproc_0150 (pEvent x?) (pEvent y?)))
							[local53 (+ (* local1 6) local0)]
						)
						(self cue:)
					else
						(localproc_01bf)
					)
					(pEvent claimed: 1)
				)
				(evJOYSTICK
					(switch (pEvent message?)
						(JOY_UP
							(if (and (!= local101 0) (!= local101 8))
								(if (== local101 7) (= local101 11) else (-- local101))
							)
						)
						(JOY_DOWN
							(if (or (< local101 5) (> local101 7))
								(if (== local101 11) (= local101 7) else (++ local101))
							)
						)
						(JOY_RIGHT
							(if (< local101 7)
								(cond 
									((< local101 4) (= local101 (+ local101 8)))
									((> local101 4) (++ local101))
									(else (= local101 11))
								)
							)
						)
						(JOY_LEFT
							(if (> local101 5)
								(if (> local101 7)
									(= local101 (- local101 8))
								else
									(-- local101)
								)
							)
						)
					)
					(localproc_0136)
					(pEvent claimed: 1)
				)
				(evKEYBOARD
					(cond 
						((== (pEvent message?) KEY_RETURN)
							(= local102 1)
							(= local104 1)
							(if
								(==
									(= local4 (localproc_0150 (pEvent x?) (pEvent y?)))
									[local53 (+ (* local1 6) local0)]
								)
								(self cue:)
							else
								(localproc_01bf)
							)
						)
						((== (pEvent message?) KEY_F2)
							(= temp0 (DoSound sndSET_SOUND))
							(DoSound sndSET_SOUND (not temp0))
						)
					)
					(localproc_0136)
					(pEvent claimed: 1)
				)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(gConMusic stop:)
		(super newRoom: newRoomNumber)
	)
)

(instance identify of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 25])
		(switch (= state newState)
			(0
				(= local3
					(Display
						414
						1
						
						;Z added:
						dsALIGN
						1

						dsCOORD
						;Z 90
						35
						16
						dsWIDTH
						256
						dsCOLOR
						15
						dsBACKGROUND
						-1
						dsFONT
						0
						dsSAVEPIXELS
					)
				)
				(= cycles 20)
			)
			(1
				(= local2
					(Display
						(Format @temp0 414 2 global28)
						dsALIGN
						1
						dsCOORD
						35
						155
						dsWIDTH
						250
						dsCOLOR
						15
						dsBACKGROUND
						-1
						dsFONT
						0
						dsSAVEPIXELS
					)
				)
				(= seconds 4)
			)
			(2
				(if global223
					(Glass setMotion: MoveTo 240 140 self)
				else
					(= cycles 1)
				)
			)
			(3
				(Logo dispose:)
				(= cycles 1)
			)
			(4
				(Finger show: stopUpd:)
				(if global223
					(Glass setMotion: MoveTo 163 140 self)
				else
					(= cycles 1)
				)
			)
			(5
				;we now skip the copy protection automatically		;;EricOakford
				(self cue:)
				
;				(SetCursor 1 1 10 39)
;				(= local102 0)
;				(Display 414 3 108 local2)
;				(Display 414 3 108 local3)
;				(Display
;					414
;					4
;					dsCOORD
;					32
;					8
;					dsWIDTH
;					256
;					dsCOLOR
;					15
;					dsBACKGROUND
;					-1
;					dsFONT
;					4
;					dsALIGN
;					1
;					dsSAVEPIXELS
;				)
;				(Display
;					414
;					5
;					dsCOORD
;					5
;					40
;					dsWIDTH
;					101
;					dsCOLOR
;					15
;					dsBACKGROUND
;					-1
;					dsFONT
;					4
;					dsSAVEPIXELS
;				)
;				(Display
;					414
;					6
;					dsCOORD
;					40
;					170
;					dsWIDTH
;					320
;					dsCOLOR
;					15
;					dsBACKGROUND
;					-1
;					dsFONT
;					4
;					dsSAVEPIXELS
;				)
;				(Display
;					414
;					7
;					dsCOORD
;					140
;					170
;					dsWIDTH
;					320
;					dsCOLOR
;					15
;					dsBACKGROUND
;					-1
;					dsFONT
;					4
;					dsSAVEPIXELS
;				)
;				(Display
;					414
;					8
;					dsCOORD
;					230
;					170
;					dsWIDTH
;					320
;					dsCOLOR
;					15
;					dsBACKGROUND
;					-1
;					dsFONT
;					4
;					dsSAVEPIXELS
;				)
;				(Display
;					414
;					9
;					dsCOORD
;					255
;					40
;					dsWIDTH
;					101
;					dsCOLOR
;					15
;					dsBACKGROUND
;					-1
;					dsFONT
;					4
;					dsSAVEPIXELS
;				)
			)
			(6
				(= local104 1)
				(= local102 1)
				(localproc_01a9)
				(proc255_0 414 10 30 1)
				(SetCursor 997 1 300 0)
				(self setScript: (ScriptID 409 0))
			)
		)
	)
)
