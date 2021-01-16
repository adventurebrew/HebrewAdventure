;;; Sierra Script 1.0 - (do not remove this comment)
(script# 280)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Game)
(use User)
(use Obj)

(public
	rm280 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5 =  30
	[local6 12] = [27 35 43 51 59 67 91 99 123 131 139 147]
	[local18 12] = [32 40 48 56 64 72 96 104 128 136 144 152]
)
(instance rm280 of Rm
	(properties
		picture 32
	)
	
	(method (init &tmp [temp0 50])
		(Load 129 32)
		(super init:)
		(= global193 1)
		(User canInput: 0 canControl: 0)
		(User mapKeyToDir: 0)
		(= global592 1)
		(gGame setCursor: global20 (HaveMouse))
		(Display
			280
			0
			dsCOORD
			10
			27
			dsWIDTH
			310
			dsCOLOR
			0
			dsFONT
			600
		)
		(Display
			280
			0
			dsCOORD
			11
			28
			dsWIDTH
			310
			dsCOLOR
			15
			dsFONT
			600
		)
		(if (== gNorth 25)
			(Display
				280
				1
				dsCOORD
				201
				175
				dsCOLOR
				0
				dsFONT
				600
			)
			(Display
				280
				1
				dsCOORD
				200
				176
				dsCOLOR
				15
				dsFONT
				600
			)
		)
		(Display
			280
			2
			dsCOORD
			31
			175
			dsCOLOR
			0
			dsFONT
			600
		)
		(Display
			280
			2
			dsCOORD
			30
			176
			dsCOLOR
			15
			dsFONT
			600
		)
	)
	
	(method (doit)
		(super doit:)
	)
	
	(method (handleEvent param1)
		(if (param1 claimed?) (return))
		(switch (param1 type?)
			(1
				(cond 
					((== gNorth 25)
						(cond 
							(
								(and
									(<= 190 (param1 x?))
									(<= (param1 x?) 275)
									(<= 170 (param1 y?))
									(<= (param1 y?) 183)
								)
								(param1 claimed: 1)
								(global2 setScript: Quitting)
							)
							(
								(and
									(<= local4 (param1 x?))
									(<= (param1 x?) local5)
									(<= [local6 0] (param1 y?))
									(<= (param1 y?) [local18 0])
								)
								(= local3 1)
								(global2 setScript: ChooseFood)
							)
							(
								(and
									(<= local4 (param1 x?))
									(<= (param1 x?) local5)
									(<= [local6 1] (param1 y?))
									(<= (param1 y?) [local18 1])
								)
								(= local3 2)
								(global2 setScript: ChooseFood)
							)
							(
								(and
									(<= local4 (param1 x?))
									(<= (param1 x?) local5)
									(<= [local6 2] (param1 y?))
									(<= (param1 y?) [local18 2])
								)
								(= local3 3)
								(global2 setScript: ChooseFood)
							)
							(
								(and
									(<= local4 (param1 x?))
									(<= (param1 x?) local5)
									(<= [local6 3] (param1 species?))
									(<= (param1 species?) [local18 3])
								)
								(= local3 4)
								(global2 setScript: ChooseFood)
							)
							(
								(and
									(<= local4 (param1 x?))
									(<= (param1 x?) local5)
									(<= [local6 4] (param1 y?))
									(<= (param1 y?) [local18 4])
								)
								(= local3 5)
								(global2 setScript: ChooseFood)
							)
							(
								(and
									(<= local4 (param1 x?))
									(<= (param1 x?) local5)
									(<= [local6 5] (param1 y?))
									(<= (param1 y?) [local18 5])
								)
								(= local3 6)
								(global2 setScript: ChooseFood)
							)
							(
								(and
									(<= local4 (param1 x?))
									(<= (param1 x?) local5)
									(<= [local6 6] (param1 y?))
									(<= (param1 y?) [local18 6])
								)
								(= local3 7)
								(global2 setScript: ChooseFood)
							)
							(
								(and
									(<= local4 (param1 x?))
									(<= (param1 x?) local5)
									(<= [local6 7] (param1 y?))
									(<= (param1 y?) [local18 7])
								)
								(= local3 8)
								(global2 setScript: ChooseFood)
							)
							(
								(and
									(<= local4 (param1 x?))
									(<= (param1 x?) local5)
									(<= [local6 8] (param1 y?))
									(<= (param1 y?) [local18 8])
								)
								(= local3 9)
								(global2 setScript: ChooseFood)
							)
							(
								(and
									(<= local4 (param1 x?))
									(<= (param1 x?) local5)
									(<= [local6 9] (param1 y?))
									(<= (param1 y?) [local18 9])
								)
								(= local3 10)
								(global2 setScript: ChooseFood)
							)
							(
								(and
									(<= local4 (param1 x?))
									(<= (param1 x?) local5)
									(<= [local6 10] (param1 y?))
									(<= (param1 y?) [local18 10])
								)
								(= local3 11)
								(global2 setScript: ChooseFood)
							)
							(
								(and
									(<= local4 (param1 x?))
									(<= (param1 x?) local5)
									(<= [local6 11] (param1 y?))
									(<= (param1 y?) [local18 11])
								)
								(= local3 12)
								(global2 setScript: ChooseFood)
							)
						)
					)
					(
						(and
							(<= 190 (param1 x?))
							(<= (param1 x?) 275)
							(<= 170 (param1 y?))
							(<= (param1 y?) 183)
						)
						(param1 claimed: 1)
						(global2 setScript: Quitting)
					)
				)
			)
			(4
				(cond 
					((== gNorth 25)
						(cond 
							(
								(or
									(== (param1 message?) 81) 	;Q
									(== (param1 message?) 113)	;q
									(== (param1 message?) 246)	;ö
								)
								(global2 setScript: Quitting)
							)
							(
								(and
									(>= (param1 message?) 49)	;1
									(<= (param1 message?) 57)	;9
								)
								(= local3 (- (param1 message?) 48))	; 1<=x<=9
								(global2 setScript: ChooseFood)
							)
							(
								(and
									(>= (param1 message?) 65)	;A
									(<= (param1 message?) 67)	;C
								)
								(= local3 (- (param1 message?) 55))	; 10<=x<=12
								(global2 setScript: ChooseFood)
							)
							(
								(and
									(>= (param1 message?) 97)	;a
									(<= (param1 message?) 99)	;c
								)
								(= local3 (- (param1 message?) 87))	; 10<=x<=12
								(global2 setScript: ChooseFood)
							)
							(
								(and
									(>= (param1 message?) 224)	;à
									(<= (param1 message?) 226)	;â
								)
								(= local3 (- (param1 message?) 214))	; 10<=x<=12
								(global2 setScript: ChooseFood)
							)
						)
					)
					(
						(or
							(== (param1 message?) 81)		;Q
							(== (param1 message?) 113)		;q
							(== (param1 message?) 246)		;ö
						)
						(global2 setScript: Quitting)
					)
				)
			)
		)
	)
)

(instance ChooseFood of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0
				(switch local3
					(0)
					(1
						(= global244 (+ global244 1))
						(= local2 1)
					)
					(2
						(= global244 (+ global244 2))
						(= local2 1)
					)
					(3
						(= global244 (+ global244 3))
						(= local2 1)
					)
					(4
						(= global244 (+ global244 2))
						(= local2 1)
					)
					(5
						(= global244 (+ global244 5))
						(= local2 1)
					)
					(6
						(= global244 (+ global244 9))
						(= local2 1)
						(= global101 1)
					)
					(7
						(= global244 (+ global244 7))
						(if (not (gEgo has: 7)) (= global249 1))
						(= local2 1)
					)
					(8
						(= global244 (+ global244 1))
						(= local2 1)
					)
					(9
						(= global244 (+ global244 1))
						(= local1 1)
					)
					(10
						(= global244 (+ global244 2))
						(= local1 1)
					)
					(11
						(= global244 (+ global244 3))
						(= local1 1)
					)
					(12
						(= global244 (+ global244 4))
						(= local1 1)
					)
				)
				(proc255_0 280 3 67 -1 95 70 50 33 600 91)
				(= cycles 30)
			)
			(1
				(proc0_12)
				(global2 setScript: 0)
			)
		)
	)
)

(instance Quitting of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0
				(if (and (== gNorth 25) global244)
					(if (not local1)
						(proc255_0
							280
							4
							82
							38
							4
							0
							30
							1
							80
							{Pushy Counter Clerk}
							81
							{ Yes_}
							1
							81
							{ Yes_}
							2
						)
					)
					(proc255_0
						280
						5
						82
						38
						4
						1
						30
						1
						80
						{Pushy Counter Clerk}
						81
						{ Yes_}
						1
						81
						{ Yes_}
						2
					)
					(proc255_0
						280
						6
						82
						38
						4
						2
						30
						1
						80
						{Pushy Counter Clerk}
						81
						{ Yes_}
						1
						81
						{ Yes_}
						2
					)
					(if (not local1)
						(proc255_0
							280
							7
							82
							38
							4
							0
							30
							1
							80
							{While Supplies Last}
							81
							{ Okay_}
							1
						)
					)
					(if (not local2)
						(proc255_0
							280
							8
							82
							38
							4
							0
							30
							1
							80
							{While Supplies Last}
							81
							{ Okay_}
							1
						)
					)
					(= global592 0)
					(= global193 0)
					(if (> global244 9999) (= global244 9999))
					(User mapKeyToDir: 1)
					(proc0_12)
					(global2 newRoom: 25)
				else
					(= global592 0)
					(= global193 0)
					(User mapKeyToDir: 1)
					(global2 newRoom: gNorth)
				)
			)
		)
	)
)
