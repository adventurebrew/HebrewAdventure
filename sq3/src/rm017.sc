;;; Sierra Script 1.0 - (do not remove this comment)
(script# 17)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Timer)
(use Sound)
(use Cycle)
(use Game)
(use User)
(use TheMenuBar)
(use Feature)
(use Obj)

(public
	rm017 0
)

(local
	local0
	local1
	local2
	[local3 5]
	[local8 25]
	local33
	[local34 49]
	local83
	[local84 49]
	local133
	[local134 49]
	local183
	[local184 49]
	local233
)
(procedure (localproc_0a2c param1 param2 param3)
	(if (< global598 16) (= param3 15))
	(Display
		param1
		dsFONT
		600
		dsWIDTH
		280
		dsCOLOR
		param3
		dsCOORD
		20
		param2
	)
	(proc0_10)
)

(procedure (localproc_0a59 param1 param2)
	(if param1
		(Display
			param1
			dsFONT
			600
			dsWIDTH
			280
			dsCOLOR
			0
			dsCOORD
			20
			param2
		)
	)
)

(procedure (localproc_0a78)
	(Display
        "מצב טיסה"
        dsCOORD 140 15
        dsCOLOUR clGREEN
        dsBACKGROUND clBLACK
        dsFONT 600
        dsALIGN alCENTER
	)
	(Display
        "הגנה"
        dsCOORD 255 15
        dsCOLOUR clGREEN
        dsBACKGROUND clBLACK
        dsFONT 600
        dsALIGN alCENTER
	)
	(engine
		cel: (cond 
			((!= gGGGGNorth 4) 2)
			((== global208 2) 1)
			(else 0)
		)
		draw:
	)
	(TLBut
		loop:
			(if
				(or
					(and (== global206 2) (!= global207 2))
					(== global206 0)
				)
				2
			else
				3
			)
		cel:
			(if
				(and
					(== global208 2)
					(!= global210 1)
					(not (== global214 62))
					(not global178)
				)
				0
			else
				2
			)
		draw:
	)
	(cruiseBut
		cel:
			(cond 
				((== global209 2) 1)
				((or (!= global208 2) (not global217)) 2)
				(else 0)
			)
		draw:
	)
	(LSpeedBut
		cel:
			(cond 
				((== global209 6) 1)
				(
				(or (not global217) global179 (!= global208 2)) 2)
				(else 0)
			)
		draw:
	)
	(ASpeedBut
		cel:
			(cond 
				((== global209 3) 1)
				(
					(or
						(and (not global217) (not global218))
						(!= global208 2)
					)
					2
				)
				(else 0)
			)
		draw:
	)
	(radarBut cel: (if global207 1 else 0) draw:)
	(navBut
		cel:
			(if
				(and
					(== global208 2)
					(== global206 3)
					(not global178)
					(not local2)
				)
				0
			else
				2
			)
		draw:
	)
	(weaponBut
		cel: (if (and (> global206 0) (not local2)) 0 else 2)
		draw:
	)
)

(instance rm017 of Rm
	(properties
		style 0
	)
	
	(method (init &tmp [temp0 50])
		(asm
			pushi    #setRegions
			pushi    1
			pushi    701
			self     6
			pushi    #hide
			pushi    0
			class    TheMenuBar
			send     4
			pushi    #disable
			pushi    0
			class    SL
			send     4
			lsg      global598
			ldi      16
			lt?     
			bnt      code_0050
			pushi    2
			pushi    129
			pushi    170
			callk    Load,  4
			pushi    #drawPic
			pushi    1
			pushi    170
			self     6
			pushi    2
			pushi    128
			pushi    141
			callk    Load,  4
			jmp      code_006a
code_0050:
			pushi    2
			pushi    129
			pushi    17
			callk    Load,  4
			pushi    #drawPic
			pushi    1
			pushi    17
			self     6
			pushi    2
			pushi    128
			pushi    41
			callk    Load,  4
code_006a:
			pushi    2
			pushi    132
			pushi    40
			callk    Load,  4
			pushi    2
			pushi    132
			pushi    83
			callk    Load,  4
			pushi    2
			pushi    132
			pushi    95
			callk    Load,  4
			pushi    2
			pushi    132
			pushi    96
			callk    Load,  4
			pushi    #init
			pushi    0
			super    Rm,  4
			pushi    0
			callb    proc0_2,  0
			pushi    #mapKeyToDir
			pushi    1
			pushi    0
			class    User
			send     6
			ldi      1
			sag      global592
			pushi    #setCursor
			pushi    2
			lsg      global20
			pushi    0
			callk    HaveMouse,  0
			push    
			lag      gGame
			send     8
			ldi      1
			sag      global193
			pushi    #add
			pushi    8
			lofsa    engine
			push    
			lofsa    navBut
			push    
			lofsa    TLBut
			push    
			lofsa    cruiseBut
			push    
			lofsa    LSpeedBut
			push    
			lofsa    ASpeedBut
			push    
			lofsa    radarBut
			push    
			lofsa    weaponBut
			push    
			pushi    101
			pushi    1
			pushi    90
			pushi    83
			pushi    0
			pToa     controls
			send     30
			lag      global167
			bnt      code_00fd
			lag      global178
			not     
			bnt      code_00fd
			pushi    #setScript
			pushi    1
			lofsa    arrivalScript
			push    
			self     6
code_00fd:
			pushi    0
			call     localproc_0a78,  0
			lsg      global206
			ldi      2
			eq?     
			bnt      code_0122
			lsg      global207
			ldi      2
			eq?     
			bnt      code_0122
			lofsa    {ASCENT HALTED DUE TO OBSTRUCTION}
			sal      local33
			pushi    3
			push    
			pushi    104
			pushi    14
			call     localproc_0a2c,  6
code_0122:
			pushi    3
			lag      global217
			bnt      code_013a
			dup     
			lea      @local8
			push    
			lofsa    {DESTINATION: SECTOR %d}
			push    
			lsg      global217
			callk    Format,  6
			jmp      code_013d
code_013a:
			lofsa    {NO COURSE SELECTED}
code_013d:
			push    
			pushi    154
			pushi    9
			call     localproc_0a2c,  6
			sal      local0
			pushi    11
			pushi    17
			pushi    0
			pushi    100
			pushi    20
			pushi    144
			pushi    105
			pushi    600
			pushi    106
			pushi    250
			pushi    102
			pushi    10
			callk    Display,  22
			pushi    11
			pushi    17
			pushi    1
			pushi    100
			pushi    97
			pushi    67
			pushi    105
			pushi    600
			pushi    106
			pushi    180
			pushi    102
			pushi    15
			callk    Display,  22
			lag      global179
			bnt      code_019f
			lag      global181
			not     
			bnt      code_019f
			pushi    2
			pushi    132
			pushi    27
			callk    Load,  4
			pushi    #setScript
			pushi    1
			lofsa    LightWarning
			push    
			self     6
code_019f:
			ret     
		)
	)
	
	(method (doit)
		(if (and global167 (not script))
			(self setScript: arrivalScript)
		)
		(Display
			(Format @local3 17 2 global214)
			dsCOORD
			100
			144
			dsWIDTH
			15
			dsCOLOR
			10
			dsBACKGROUND
			0
			dsFONT
			600
		)
		(super doit:)
	)
	
	(method (handleEvent param1)
		(super handleEvent: param1)
		(if (param1 claimed?) (return))
		(switch (param1 type?)
			(4
				(if
				(and (== (param1 message?) 16384) (not local2))
					(param1 claimed: 1)
					(= global193 0)
					(global2 newRoom: 14)
				)
			)
			(1
				(if
					(and
						(<= 95 (param1 x?))
						(<= (param1 x?) 222)
						(<= 60 (param1 y?))
						(<= (param1 y?) 77)
						(not local2)
					)
					(param1 claimed: 1)
					(= global193 0)
					(global2 newRoom: 14)
				)
			)
		)
	)
	
	(method (newRoom param1)
		(= local233 1)
		(proc0_10)
		(User mapKeyToDir: 1)
		(gTimers eachElementDo: 91 84)
		(= global193 0)
		(super newRoom: param1)
	)
)

(instance arrivalScript of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0
				(= global167 0)
				(proc0_2)
				(= local2 1)
				(= global209 1)
				(= global214 global217)
				(= global217 0)
				(localproc_0a78)
				(= local133
					(if (== global209 6)
						{CUTTING LIGHT ENGINES}
					else
						{THROTTLING ENGINES BACK}
					)
				)
				(localproc_0a2c local133 134 14)
				(= seconds 3)
			)
			(1
				(localproc_0a59 local133 134)
				(= cycles 2)
			)
			(2
				(= local133
					(cond 
						((== global214 39) {ORBITING PLANET PHLEEBHUT})
						((== global214 62) {APPROACHING MONOLITH BURGER})
						((== global214 82) {ORBITING PLANET ORTEGA})
						((== global214 69) {ORBITING PESTULON})
					)
				)
				(localproc_0a2c local133 134 3)
				(= seconds 3)
			)
			(3
				(localproc_0a59 local133 134)
				(cond 
					((== global214 62) (= global208 0) (= global193 0) (global2 newRoom: 27))
					((== global214 39) (= global210 4))
					((== global214 82) (= global210 3))
					((== global214 69) (= global210 7))
				)
				(= local2 0)
				(localproc_0a78)
				(global2 setScript: 0)
			)
		)
	)
)

(instance LightWarning of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0
				(= global181 1)
				(localproc_0a2c {** LIGHT SPEED NON-FUNCTIONAL **} 174 14)
				(beeper play: self)
			)
			(1
				(proc255_0 17 3)
				(localproc_0a59 {** LIGHT SPEED NON-FUNCTIONAL **} 174)
				(client setScript: 0)
			)
		)
	)
)

(instance responseScript of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(1
				(if local83 (localproc_0a59 local83 local1))
				(= local83 {FULL THRUST NECESSARY BEFORE MANEUVERING})
				(= local1 84)
				(localproc_0a2c local83 local1 4)
				(self changeState: 13)
			)
			(2
				(if local83 (localproc_0a59 local83 local1))
				(= local83 {A COURSE MUST BE SET BEFORE SELECTING SPEED})
				(= local1 84)
				(localproc_0a2c local83 local1 4)
				(self changeState: 13)
			)
			(3
				(if local83 (localproc_0a59 local83 local1))
				(= local83 {NO LANDING SURFACE AVAILABLE})
				(= local1 84)
				(localproc_0a2c local83 local1 4)
				(self changeState: 13)
			)
			(4
				(if local83 (localproc_0a59 local83 local1))
				(= local83 {** LIGHT SPEED NON-FUNCTIONAL **})
				(= local1 164)
				(localproc_0a2c local83 local1 4)
				(self changeState: 13)
			)
			(5
				(if local83 (localproc_0a59 local83 local1))
				(= local83
					{WEAPONS SYSTEM INOPERABLE WHILE NOT IN FLIGHT}
				)
				(= local1 114)
				(localproc_0a2c local83 local1 6)
				(self changeState: 13)
			)
			(6
				(if local83 (localproc_0a59 local83 local1))
				(= local83 local33)
				(= local1 104)
				(localproc_0a2c local83 local1 2)
				(self changeState: 13)
			)
			(7
				(if local83 (localproc_0a59 local83 local1))
				(= local83
					{NAVIGATION SYSTEM INOPERABLE WHILE NOT IN FLIGHT}
				)
				(= local1 124)
				(localproc_0a2c local83 local1 2)
				(self changeState: 13)
			)
			(8
				(if local83 (localproc_0a59 local83 local1))
				(= local83
					{** ERROR DETECTED: CONSULT DIAGNOSTIC COMPUTER **}
				)
				(= local1 164)
				(localproc_0a2c local83 local1 4)
				(self changeState: 13)
			)
			(9
				(if local83 (localproc_0a59 local83 local1))
				(= local83 local183)
				(= local1 84)
				(localproc_0a2c local83 local1 2)
				(self changeState: 13)
			)
			(10
				(if local83 (localproc_0a59 local83 local1))
				(= local83 {THRUST GENERATION UNDERWAY})
				(= local1 94)
				(localproc_0a2c local83 local1 14)
				(self changeState: 13)
			)
			(11
				(if local83 (localproc_0a59 local83 local1))
				(= local83 {ADEQUATE THRUST ACHIEVED})
				(= local1 94)
				(localproc_0a2c local83 local1 2)
				(self changeState: 13)
			)
			(12
				(if local83 (localproc_0a59 local83 local1))
				(= local83 {** NAVIGATION SYSTEM NON-FUNCTIONAL **})
				(= local1 164)
				(localproc_0a2c local83 local1 4)
				(self changeState: 13)
			)
			(13 (Timer set: self 3))
			(14
				(localproc_0a59 local83 local1)
				(= global100 0)
				(= local2 0)
			)
		)
	)
)

(instance toScript of Script
	(properties)
	
	(method (changeState theState &tmp [temp0 50])
		(switch (= state theState)
			(1
				(= local2 1)
				(if (== global206 2)
					(= local183 {TAKEOFF IN PROGRESS})
				else
					(= local183 {LANDING/DOCKING IN PROGRESS})
				)
				(responseScript changeState: 9)
				(switch global210
					(3
						(= global206 0)
						(= global208 0)
						(= global210 5)
					)
					(4
						(= global206 0)
						(= global208 0)
						(= global210 6)
					)
					(7
						(= global206 0)
						(= global208 0)
						(= global210 8)
					)
					(2 (= global208 0))
					(5
						(= global206 3)
						(= global210 3)
					)
					(6
						(= global206 3)
						(= global210 4)
					)
					(8
						(= global206 3)
						(= global210 7)
					)
				)
				(= global193 0)
				(global2
					newRoom:
						(cond 
							((== global210 2) (if (== global206 1) 28 else 31))
							(
								(or
									(== global210 0)
									(== global210 3)
									(== global210 4)
									(== global210 7)
								)
								14
							)
							(
							(or (== global210 6) (== global210 5) (== global210 8)) 21)
						)
				)
			)
		)
	)
)

(instance sbScript of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0 (= cycles 1))
			(1
				(= global100 1)
				(powerUp play:)
				(responseScript changeState: 10)
				(= seconds 5)
			)
			(2
				(standBy setLoop: 8 setCel: 3)
				(= cycles 2)
			)
			(3
				(gLongSong number: 59 loop: -1 priority: 0 play:)
				(responseScript changeState: 11)
				(= global208 2)
				(= global100 0)
				(localproc_0a78)
			)
		)
	)
)

(instance StupidCrash of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0
				(proc0_2)
				(= local2 1)
				(= seconds 3)
			)
			(1
				(ShakeScreen 10 3)
				(proc255_0 17 4)
				(proc0_17 0 0 5 7)
			)
		)
	)
)

(instance engine of DIcon
	(properties
		state 1
		nsTop 23
		nsLeft 26
		key 49
	)
	
	(method (init)
		(= view (if (> global598 4) 41 else 141))
	)
	
	(method (doit)
		(if (or global100 local233) (return))
		(switch (self cel?)
			(2
				(responseScript changeState: 8)
				(badBlip play:)
			)
			(1
				(goodBlip play:)
				(if (> global206 1)
					(= global220 0)
					(= global209 1)
					(= global206 3)
				)
				(= global208 0)
				(if (and (== global210 0) (== global207 2))
					(global2 setScript: StupidCrash)
				)
				(gLongSong stop:)
				(powerDown play:)
			)
			(0
				(standBy dispose:)
				(goodBlip play:)
				(= global208 1)
				(standBy
					posn: (engine nsLeft?) (engine nsTop?)
					init:
					setScript: sbScript
				)
			)
		)
		(localproc_0a78)
	)
)

(instance cruiseBut of DIcon
	(properties
		state 1
		nsTop 41
		nsLeft 99
		key 52
		loop 4
	)
	
	(method (init)
		(= view (if (> global598 4) 41 else 141))
	)
	
	(method (doit &tmp [temp0 50])
		(if (or global100 local233) (return))
		(switch (self cel?)
			(0
				(self cel: 1 draw:)
				(goodBlip play:)
				(if
					(and
						(or
							(and (== global213 69) (== global214 82))
							(and (== global213 82) (== global214 69))
						)
						(not global218)
					)
					(= global220 10)
				else
					(= global220 180)
				)
				(= global209 2)
				(= global210 1)
				(= global193 0)
				(global2 newRoom: (if global151 14 else 31))
			)
			(1
				(= global209 0)
				(goodBlip play:)
				(localproc_0a78)
			)
			(2
				(badBlip play:)
				(responseScript changeState: 2)
			)
		)
	)
)

(instance ASpeedBut of DIcon
	(properties
		state 1
		nsTop 41
		nsLeft 160
		key 54
		loop 6
	)
	
	(method (init)
		(= view (if (> global598 4) 41 else 141))
	)
	
	(method (doit)
		(if (or global100 local233) (return))
		(switch (self cel?)
			(0
				(self cel: 1 draw:)
				(goodBlip play:)
				(if
					(and
						(or
							(and (== global213 69) (== global214 82))
							(and (== global213 82) (== global214 69))
						)
						(not global218)
					)
					(= global220 10)
				else
					(= global220 90)
				)
				(= global209 3)
				(= global210 1)
				(= global193 0)
				(if (not global218)
					(global2 newRoom: (if global151 14 else 31))
				)
			)
			(1
				(goodBlip play:)
				(= global209 0)
				(localproc_0a78)
			)
			(2
				(badBlip play:)
				(responseScript changeState: 2)
			)
		)
	)
)

(instance LSpeedBut of DIcon
	(properties
		state 1
		nsTop 23
		nsLeft 160
		key 53
		loop 5
	)
	
	(method (init)
		(= view (if (> global598 4) 41 else 141))
	)
	
	(method (doit)
		(if (or global100 local233) (return))
		(switch (self cel?)
			(0
				(goodBlip play:)
				(self cel: 1 draw:)
				(= global220 2)
				(= global209 6)
				(= global210 1)
				(= global193 0)
				(global2 newRoom: 31)
			)
			(1
				(goodBlip play:)
				(= global209 0)
				(localproc_0a78)
			)
			(2
				(badBlip play:)
				(if global179
					(responseScript changeState: 4)
				else
					(responseScript changeState: 2)
				)
			)
		)
	)
)

(instance navBut of DIcon
	(properties
		state 1
		nsTop 41
		nsLeft 26
		key 50
		loop 1
	)
	
	(method (init)
		(= view (if (> global598 4) 41 else 141))
	)
	
	(method (doit)
		(if (or global100 local233) (return))
		(switch (self cel?)
			(0
				(goodBlip play:)
				(self cel: 1 draw:)
				(= global193 0)
				(global2 newRoom: 19)
			)
			(2
				(badBlip play:)
				(cond 
					((!= global208 2) (responseScript changeState: 1))
					((or global218 (== global176 5)) (responseScript changeState: 12))
					(else (responseScript changeState: 7))
				)
			)
		)
	)
)

(instance radarBut of DIcon
	(properties
		state 1
		nsTop 23
		nsLeft 231
		key 55
		loop 7
	)
	
	(method (init)
		(= view (if (> global598 4) 41 else 141))
	)
	
	(method (doit)
		(if (or global100 local233) (return))
		(switch (self cel?)
			(0
				(goodBlip play:)
				(self cel: 1 draw:)
				(= local33 {RADAR IS NOW IN OPERATION})
				(= global207 1)
				(responseScript changeState: 6)
			)
			(1
				(if global206
					(badBlip play:)
					(proc255_0 17 5)
				else
					(goodBlip play:)
					(self cel: 0 draw:)
					(= local33 {RADAR IS NOW INOPERATIVE})
					(= global207 0)
					(responseScript changeState: 6)
				)
			)
		)
	)
)

(instance weaponBut of DIcon
	(properties
		state 1
		nsTop 41
		nsLeft 231
		key 56
		loop 8
	)
	
	(method (init)
		(= view (if (> global598 4) 41 else 141))
	)
	
	(method (doit)
		(if (or global100 local233) (return))
		(switch (self cel?)
			(0
				(goodBlip play:)
				(self cel: 1 draw:)
				(= global193 0)
				(global2 newRoom: 18)
			)
			(2
				(badBlip play:)
				(responseScript changeState: 5)
			)
		)
	)
)

(instance TLBut of DIcon
	(properties
		state 1
		nsTop 23
		nsLeft 99
		key 51
		loop 2
	)
	
	(method (init)
		(= view (if (> global598 4) 41 else 141))
	)
	
	(method (doit)
		(if (or global100 local233) (return))
		(switch (self cel?)
			(0
				(goodBlip play:)
				(if (== (self loop?) 2)
					(self cel: 1 draw:)
					(= global206 2)
					(toScript changeState: 1)
					(= global194 1)
				else
					(self cel: 1 draw:)
					(= global206 1)
					(= global209 0)
					(if (== global207 2)
						(= global207 1)
						(if local33 (localproc_0a59 local33 104))
					)
					(toScript changeState: 1)
				)
			)
			(2
				(badBlip play:)
				(if (!= global208 2)
					(responseScript changeState: 1)
				else
					(responseScript changeState: 3)
				)
			)
		)
	)
)

(instance standBy of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: (if (> global598 4) 41 else 141)
			setLoop: 9
			cel: 0
			priority: 15
			cycleSpeed: 2
			setCycle: Fwd
		)
	)
)

(instance beeper of Sound
	(properties
		number 27
		priority 2
		loop 2
	)
)

(instance powerUp of Sound
	(properties
		number 40
		priority 2
	)
)

(instance powerDown of Sound
	(properties
		number 83
		priority 2
	)
)

(instance goodBlip of Sound
	(properties
		number 95
		priority 2
	)
)

(instance badBlip of Sound
	(properties
		number 96
		priority 2
	)
)
