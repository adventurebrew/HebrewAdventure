;;; Sierra Script 1.0 - (do not remove this comment)
(script# 209)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Path)
(use Sound)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	Dinner 0
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
	[local8 7] = [73 113 50 149 -20 149 -32768]
)
(procedure (localproc_000c)
	(gCast eachElementDo: #hide)
	(DrawPic 67 dpOPEN_CENTEREDGE)
	(CHead setPri: 1 init:)
	(FHead init: setScript: eyeball)
	(Mouth init:)
	(Eye cycleSpeed: 5 setCycle: Fwd init:)
	(Hand cycleSpeed: 5 init: setScript: handMotion)
)

(procedure (localproc_006b)
	(DrawPic 34 dpOPEN_EDGECENTER)
	(gAddToPics doit:)
	(gCast eachElementDo: #show)
	(CHead dispose:)
	(FHead dispose:)
	(Mouth dispose:)
	(Eye dispose:)
	(Hand dispose:)
)

; (procedure (ForeDisplay)	;;EricOakford
(procedure (localproc_00ad)
	(= local0
		(Display
			&rest
			105 ;dsFONT
			41
			dsALIGN
			1
			dsCOORD
			local3
			local4
			dsWIDTH
			260
			dsCOLOR
			15
			dsSAVEPIXELS
		)
	)
)

(procedure (localproc_00cf)
	(Display 209 0 108 local0)
)

(procedure (localproc_00dd)
	(= local1
		(Display
			&rest
			105 ; dsFONT
			41
			dsALIGN
			1
			dsCOORD
			local3
			local4
			dsWIDTH
			260
			dsCOLOR
			0
			dsSAVEPIXELS
		)
	)
)

(procedure (localproc_00fe)
	(Display 209 0 108 local1)
)

(instance wOPath of Path
	(properties)
	
	(method (at param1)
		(return [local8 param1])
	)
)

(instance Dinner of Rm
	(properties
		picture 34
	)
	
	(method (init)
		(super init:)
		(proc0_3)
		(gAddToPics
			add:
				tableTop
				chute
				Ethel
				Gertie
				Gloria
				Rudy
				Jeeves
				Clarence
				Wilbur
				chair4
				chair5
				coffee
				chandelier
				flowers
			doit:
		)
		(Load rsPIC 67)
		(proc0_21 128 0 500 800)
		(Load rsFONT 41)
		(RHead setPri: 14 init: stopUpd:)
		(lHead setPri: 10 init: stopUpd:)
		(yHead setPri: 10 init: stopUpd:)
		(cHead setPri: 10 init: stopUpd:)
		(grHead setPri: 10 init: stopUpd:)
		(eHead setPri: 10 init: stopUpd:)
		(glHead setPri: 10 init: stopUpd:)
		(wHead setPri: 7 init: stopUpd:)
		(You init: stopUpd:)
		(Lilian init: stopUpd:)
		(if global223
			(fire setCycle: Fwd init:)
			(gas setPri: 9 setCycle: Fwd init:)
		else
			(gas setPri: 9 init: stopUpd:)
			(fire init: stopUpd:)
		)
		(Colonel
			illegalBits: 0
			setCycle: Walk
			setPri: 10
			init:
			stopUpd:
		)
		(self setScript: speech)
	)
	
	(method (doit)
		(super doit:)
	)
	
	(method (dispose)
		(DisposeScript 983)
		(super dispose:)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return 1))
		(switch (pEvent type?)
			(evKEYBOARD
				(if
					(or
						(== (pEvent message?) KEY_S)
						(== (pEvent message?) KEY_s)
						(== (pEvent message?) KEY_RETURN)
						(== (pEvent message?) KEY_SPACE)
					)
					(proc0_5 50)
				)
			)
			(evMOUSEBUTTON (proc0_5 50))
		)
		(return
			(if (proc0_7 50)
				(pEvent claimed: 1)
				(global2 newRoom: 44)
			else
				0
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)
)

(instance speech of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if
		(and (== (myMusic prevSignal?) -1) (== state 20))
			(proc0_5 50)
			(global2 newRoom: 44)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 5))
			(1
				(myMusic number: 4 loop: -1 play:)
				(= local3 41)
				(= local4 32)
				(localproc_00dd 209 1)
				(= local3 40)
				(= local4 30)
				(localproc_00ad 209 1)
				(= seconds 8)
			)
			(2
				(localproc_00cf)
				(localproc_00fe)
				(= cycles 1)
			)
			(3
				(proc255_0 209 2 67 104 10 88)
				(Colonel setMotion: MoveTo 75 123 self)
				(cHead setCycle: End)
				(wHead setCycle: End)
				(eHead setCycle: End)
				(grHead setCycle: End)
				(RHead setCycle: End)
				(yHead setCycle: End)
				(lHead setCycle: End)
			)
			(4
				(proc0_15)
				(localproc_000c)
				(proc255_0 209 3 67 10 117 88)
				(= local7 5)
				(Mouth setScript: mouthCyc)
				(Eye loop: 2 setCycle: End)
				(= seconds 10)
			)
			(5
				(proc0_15)
				(Eye setCycle: Beg)
				(= local7 6)
				(Mouth setScript: mouthCyc)
				(proc255_0 209 4 67 10 117 88)
				(= seconds 10)
			)
			(6
				(proc0_15)
				(Eye loop: 1 cycleSpeed: 6 setCycle: Fwd)
				(= local7 5)
				(Mouth setScript: mouthCyc)
				(proc255_0 209 5 67 10 117 88)
				(= seconds 10)
			)
			(7
				(proc0_15)
				(= local7 3)
				(Mouth setScript: mouthCyc)
				(proc255_0 209 6 67 10 117 88)
				(= seconds 5)
			)
			(8
				(proc0_15)
				(= local7 1)
				(Mouth setScript: mouthCyc)
				(proc255_0 209 7 67 10 117 88)
				(= seconds 3)
			)
			(9
				(proc0_15)
				(= local7 5)
				(Mouth setScript: mouthCyc)
				(proc255_0 209 8 67 10 117 88)
				(= seconds 10)
			)
			(10
				(proc0_15)
				(Eye loop: 2 setCycle: End)
				(= local7 5)
				(Mouth setScript: mouthCyc)
				(proc255_0 209 9 67 10 117 88)
				(= seconds 10)
			)
			(11
				(proc0_15)
				(Eye setCycle: Beg)
				(= local7 3)
				(Mouth setScript: mouthCyc)
				(proc255_0 209 10 67 10 117 88)
				(= seconds 5)
			)
			(12
				(proc0_15)
				(= local7 1)
				(Mouth setScript: mouthCyc)
				(proc255_0 209 11 67 10 117 88)
				(Hand setCycle: 0)
				(= seconds 5)
			)
			(13
				(proc0_15)
				(localproc_006b)
				(Colonel
					setMotion: MoveTo (Colonel x?) (+ (Colonel y?) 20) self
				)
			)
			(14
				(Colonel setMotion: MoveTo -40 150 self)
			)
			(15
				(proc0_15)
				(cHead setCycle: Beg)
				(wHead setCycle: Beg)
				(eHead setCycle: Beg)
				(grHead setCycle: Beg)
				(RHead setCycle: Beg)
				(yHead setCycle: Beg)
				(lHead setCycle: Beg)
				(= cycles 4)
			)
			(16
				(proc0_15)
				(switch local2
					(0
						(proc255_0 209 12 67 73 145 88)
						(yHead loop: 4 setCycle: End)
						(lHead loop: 9 setCycle: End)
						(grHead setCycle: End)
					)
					(1
						(proc255_0 209 13 67 110 28 88)
						(wHead setCycle: Beg)
						(grHead setCycle: Beg)
						(eHead setCycle: End)
						(wHead loop: 1 setCycle: Fwd)
					)
					(2
						(proc255_0 209 14 67 73 145 88)
						(eHead setCycle: Beg)
						(RHead setCycle: End)
						(cHead loop: 8 setCycle: End)
						(wHead setCycle: 0)
					)
					(3
						(proc255_0 209 15 67 200 144 70 75 88)
						(RHead setCycle: Beg)
						(cHead setCycle: Beg)
						(grHead loop: 2 setCycle: End)
					)
					(4
						(proc255_0 209 16 67 149 15 70 100 88)
						(grHead setCycle: Beg)
						(wHead loop: 4 setCycle: End)
						(eHead loop: 3 setCycle: Fwd)
					)
					(5
						(proc255_0 209 17 67 110 25 88)
						(wHead setCycle: Beg)
						(eHead loop: 2 setCycle: End)
						(wHead loop: 1 setCycle: Fwd)
					)
					(6
						(proc255_0 209 18 67 200 144 70 100 88)
						(eHead setCycle: Beg)
						(grHead setCycle: End)
						(wHead loop: 1 setCycle: 0)
					)
					(7
						(proc255_0 209 19 67 204 10 70 95 88)
						(grHead setCycle: Beg)
						(eHead loop: 1 setCycle: End)
						(glHead setCycle: Fwd)
					)
					(8
						(proc255_0 209 20 67 149 15 70 100 88)
						(eHead setCycle: Beg)
						(wHead loop: 4 setCycle: End)
						(glHead setCycle: 0)
						(eHead loop: 3 setCycle: Fwd)
					)
					(9
						(proc255_0 209 21 67 144 147 88)
						(wHead setCycle: Beg)
						(grHead setCycle: End)
						(eHead setCycle: 0)
					)
					(10
						(proc255_0 209 22 67 224 15 70 75 88)
						(grHead setCycle: Beg)
						(eHead loop: 1 setCycle: End)
						(glHead setCycle: Fwd)
					)
				)
				(= seconds 3)
			)
			(17
				(proc0_15)
				(glHead setCycle: 0)
				(if (!= local2 10)
					(++ local2)
					(= state 15)
					(= cycles 1)
				else
					(yHead setCycle: Beg self)
				)
			)
			(18
				(chair addToPic:)
				(yHead loop: 3 setCycle: End)
				(cHead loop: 7 setCycle: End)
				(wHead loop: 5 setCycle: End)
				(eHead loop: 2 setCycle: End)
				(grHead loop: 1 setCycle: End)
				(RHead setCycle: End)
				(lHead dispose:)
				(Lilian
					startUpd:
					view: 800
					loop: 4
					cel: 0
					x: 100
					y: 118
					illegalBits: 0
					ignoreActors: 1
					setCycle: Fwd
				)
				(proc255_0 209 23 67 40 18 88)
				(= seconds 5)
			)
			(19
				(proc0_15)
				(Lilian
					view: 500
					loop: 2
					setCycle: Walk
					setMotion: (Clone wOPath)
				)
				(chair1 addToPic:)
				(yHead hide:)
				(You
					view: 0
					loop: 2
					x: 124
					y: 118
					startUpd:
					setCycle: Walk
					illegalBits: 0
					ignoreActors: 1
					setMotion: (Clone wOPath) self
				)
			)
			(20 (myMusic fade:))
			(21
				(client setScript: 0)
				(global2 newRoom: 44)
			)
		)
	)
)

(instance eyeball of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(FHead setCycle: End)
				(= seconds (Random 1 6))
			)
			(1
				(= state -1)
				(= seconds (Random 1 6))
			)
		)
	)
)

(instance handMotion of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(Hand setCycle: End)
				(= seconds (Random 1 6))
			)
			(1
				(= state -1)
				(= seconds (Random 1 6))
			)
		)
	)
)

(instance mouthCyc of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (client setCycle: End self))
			(1
				(if (== local7 (++ local6))
					(= local6 0)
					(client cel: 0 setScript: 0)
				else
					(= state -1)
					(= cycles 1)
				)
			)
		)
	)
)

(instance tableTop of PV
	(properties
		y 107
		x 151
		view 167
		loop 6
		priority 9
	)
)

(instance chute of PV
	(properties
		y 121
		x 23
		view 134
		loop 2
	)
)

(instance Wilbur of PV
	(properties
		y 118
		x 152
		view 421
		priority 7
	)
)

(instance Jeeves of PV
	(properties
		y 105
		x 175
		view 450
		priority 7
	)
)

(instance Clarence of PV
	(properties
		y 135
		x 132
		view 401
		cel 5
		priority 10
	)
)

(instance Ethel of PV
	(properties
		y 118
		x 178
		view 321
		cel 2
		priority 7
	)
)

(instance Gertie of PV
	(properties
		y 135
		x 161
		view 341
		cel 1
		priority 10
	)
)

(instance Gloria of PV
	(properties
		y 119
		x 218
		view 361
		cel 1
		priority 8
	)
)

(instance Rudy of PV
	(properties
		y 135
		x 199
		view 381
		cel 1
		priority 10
	)
)

(instance chair4 of PV
	(properties
		y 90
		x 205
		view 134
		loop 6
		cel 1
		priority 5
	)
)

(instance chair5 of PV
	(properties
		y 90
		x 50
		view 134
		loop 6
		priority 5
	)
)

(instance coffee of PV
	(properties
		y 138
		x 301
		view 134
		priority 12
	)
)

(instance chandelier of PV
	(properties
		y 42
		x 144
		view 134
		cel 3
		priority 9
	)
)

(instance flowers of PV
	(properties
		y 55
		x 129
		view 134
		cel 2
		priority 9
	)
)

(instance yHead of Prop
	(properties
		y 82
		x 123
		view 2
		loop 3
	)
)

(instance lHead of Prop
	(properties
		y 82
		x 99
		view 501
		loop 8
	)
)

(instance cHead of Prop
	(properties
		y 101
		x 135
		view 401
		loop 7
	)
)

(instance grHead of Prop
	(properties
		y 101
		x 163
		view 341
		loop 1
	)
)

(instance RHead of Prop
	(properties
		y 99
		x 201
		view 381
		loop 7
	)
)

(instance glHead of Prop
	(properties
		y 84
		x 221
		view 361
		loop 1
	)
)

(instance eHead of Prop
	(properties
		y 83
		x 180
		view 321
		loop 2
		priority 10
	)
)

(instance wHead of Prop
	(properties
		y 83
		x 152
		view 421
		loop 8
		priority 10
	)
)

(instance fire of Prop
	(properties
		y 85
		x 131
		view 232
		cel 1
		priority 5
	)
)

(instance Colonel of Act
	(properties
		y 150
		x -10
		view 306
	)
)

(instance You of Act
	(properties
		y 118
		x 124
		view 2
	)
)

(instance Lilian of Act
	(properties
		y 118
		x 100
		view 501
		cel 1
	)
)

(instance chair of Prop
	(properties
		y 114
		x 94
		view 134
		loop 5
		cel 4
		priority 6
	)
)

(instance chair1 of Prop
	(properties
		y 116
		x 118
		view 134
		loop 5
		cel 3
		priority 6
	)
)

(instance myMusic of Sound
	(properties)
)

(instance gas of Prop
	(properties
		y 82
		x 24
		view 134
		loop 3
		cel 1
		priority 9
	)
)

(instance CHead of Prop
	(properties
		y 96
		x 173
		view 167
		priority 1
	)
)

(instance FHead of Prop
	(properties
		y 39
		x 109
		view 167
		loop 5
		cel 1
		priority 1
	)
)

(instance Eye of Prop
	(properties
		y 85
		x 180
		view 167
		loop 1
	)
)

(instance Mouth of Prop
	(properties
		y 106
		x 177
		view 167
		loop 3
	)
)

(instance Hand of Prop
	(properties
		y 147
		x 186
		view 167
		loop 4
		priority 1
	)
)
