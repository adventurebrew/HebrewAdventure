;;; Sierra Script 1.0 - (do not remove this comment)
(script# 19)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Timer)
(use Sound)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	rm019 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	[local6 49]
	[local55 50]
	[local105 50]
	local155
)
(procedure (localproc_0874 param1 param2)
	(if (< global598 16) (= param2 15))
	(= local1
		(Display
			param1
			dsWIDTH
			135
			dsALIGN
			1
			dsCOORD
			168
			12
			dsCOLOR
			param2
			dsFONT
			600
			dsSAVEPIXELS
		)
	)
)

(procedure (localproc_08a5 param1)
	(Display 19 1 108 param1)
	(proc0_10)
)

(instance rm019 of Rm
	(properties
		picture 19
		picAngle 1
	)
	
	(method (init &tmp [temp0 50])
		(proc0_2)
		(User mapKeyToDir: 0)
		(self setRegions: 701)
		(proc0_2)
		(if (> global598 4) (Load 129 191) else (Load 129 300))
		(Load 128 49)
		(Load 128 50)
		(Load 128 212)
		(Load 132 25)
		(super init:)
		(if (and (== global214 75) (not global217))
			(= global161 3)
			(= gGEgoY_5 7)
			(= global163 3)
			(= global164 7)
			(= global213 75)
		)
		(controls
			add: scanBut courseBut returnBut
			eachElementDo: 90
			draw:
		)
		(self setScript: rmScript)
		(scanner play:)
	)
	
	(method (doit)
		(if global167 (global2 newRoom: 17))
		(super doit:)
	)
	
	(method (handleEvent param1 &tmp [temp0 100])
		(super handleEvent: param1)
		(if
		(or (!= (param1 type?) 128) (param1 claimed?))
			(return)
		)
	)
	
	(method (newRoom param1)
		(scanner stop:)
		(proc0_3)
		(User mapKeyToDir: 1)
		(gTimers eachElementDo: 91 84)
		(if local2 (localproc_08a5 local2) (= local2 0))
		(if local1 (localproc_08a5 local1) (= local1 0))
		(if local3 (localproc_08a5 local3) (= local3 0))
		(if local4 (localproc_08a5 local4) (= local4 0))
		(super newRoom: param1)
	)
)

(instance rmScript of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0
				(scanBut state: 0 draw:)
				(courseBut state: 0 draw:)
				(returnBut state: 0 draw:)
				(= cycles 6)
			)
			(1
				(if (> global598 4)
					(global2 overlay: 191 1)
				else
					(global2 overlay: 300 1)
				)
				(= cycles 2)
			)
			(2
				(= local2
					(Display
						19
						0
						dsWIDTH
						135
						dsALIGN
						1
						dsCOORD
						168
						3
						dsCOLOR
						14
						dsFONT
						600
						dsSAVEPIXELS
					)
				)
				(scanBut state: 1 draw:)
				(courseBut draw:)
				(returnBut state: 1 draw:)
				(scanBox init:)
				(you init:)
				(= cycles 2)
			)
			(3
				(if global217
					(= local2
						(Display
							(Format @local55 {DESTINATION: SECTOR %d} global217)
							dsWIDTH
							135
							dsALIGN
							1
							dsCOORD
							168
							3
							dsCOLOR
							9
							dsFONT
							600
							dsSAVEPIXELS
						)
					)
				)
				(global2 setScript: 0)
			)
		)
	)
)

(instance scanScript of Script
	(properties)
	
	(method (changeState theState &tmp [temp0 50])
		(switch (= state theState)
			(0
				(if local2 (localproc_08a5 local2) (= local2 0))
				(cond 
					(
						(and
							(!= global213 39)
							(!= global213 62)
							(!= global213 82)
							(!= global213 69)
						)
						(self changeState: 2)
					)
					((and (== global213 69) (not global256)) (self changeState: 2))
					(local0 (= local0 0) (self changeState: 2))
					(else
						(if
							(!=
								local5
								(Format @local105 {SCANNING SECTOR %d} global213)
							)
							(= local5
								(Format @local105 {SCANNING SECTOR %d} global213)
							)
							(if local1 (localproc_08a5 local1) (= local1 0))
						)
						(scanBox setCycle: Fwd)
						(scanBut state: 0 cel: 2 draw:)
						(returnBut state: 0 cel: 1 draw:)
						(= cycles 10)
					)
				)
			)
			(1
				(localproc_0874
					(Format @local105 {SCANNING SECTOR %d} global213)
					14
				)
				(global2 setScript: zoomScript)
			)
			(2 (= cycles 1))
			(3
				(if (< global213 108)
					(++ global213)
				else
					(= global213 1)
				)
				(= global164 (/ global213 12))
				(if
				(> (= global163 (- global213 (* global164 12))) 0)
					(++ global164)
				else
					(= global163 12)
				)
				(self changeState: 0)
			)
		)
	)
)

(instance zoomScript of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0
				(scanBut cel: 2 state: 0 draw:)
				(returnBut cel: 1 state: 0 draw:)
				(courseBut cel: 1 state: 0 draw:)
				(scanBox
					setLoop:
						(cond 
							((== global213 82) 1)
							((== global213 39) 2)
							((== global213 62) 3)
							((== global213 69) 5)
						)
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
				(you hide:)
			)
			(1
				(returnBut cel: 0 state: 1 draw:)
				(courseBut cel: 0 state: 1 draw:)
				(scanBut cel: 1 state: 1 draw:)
				(Timer setCycle: self 2)
			)
			(2
				(if local1 (localproc_08a5 local1) (= local1 0))
				(= global193 1)
				(= local3
					(Display
						(cond 
							((== global213 39)
								{NAME:\n PLANET PHLEEBHUT\nSECTOR: 39\n\nLIGHT ATMOSPHERE\n1 KNOWN SETTLEMENT}
							)
							((== global213 62)
								{NAME:\n MONOLITH BURGER FAST FOOD DIVE\nSECTOR: 62\n\nA FINITE\nNUMBER SERVED}
							)
							((== global213 69)
								{NAME:\n PESTULON\nSECTOR: 69\nHABITANTS: UNKNOWN\nSURFACE UNCHARTED.\nIT FIGURES...}
							)
							((== global213 82)
								{NAME:\n PLANET ORTEGA\nSECTOR: 82\nHABITANTS: UNKNOWN\nVOLCANIC CRATER-STREWN\nSURFACE}
							)
						)
						dsWIDTH
						(if (< global163 7) 220 else 91)
						dsCOORD
						(if (< global163 7)
							(+ (* (- global163 1) 25) 25)
						else
							(- (* (- global163 1) 25) 111)
						)
						(+ (* (- global164 1) 18) 6)
						dsFONT
						600
						dsCOLOR
						12
						dsSAVEPIXELS
					)
				)
			)
			(3
				(scanBox setCycle: Beg self)
				(if local3 (localproc_08a5 local3) (= local3 0))
				(= global193 0)
			)
			(4
				(scanBox setLoop: 0)
				(= local0 1)
				(global2 setScript: scanScript)
				(you show:)
			)
		)
	)
)

(instance courseScript of Script
	(properties)
	
	(method (changeState theState &tmp temp0 [temp1 49])
		(switch (= state theState)
			(0
				(if local2 (localproc_08a5 local2) (= local2 0))
				(= gGEgoY_5 (/ global214 12))
				(if
				(> (= global161 (- global214 (* gGEgoY_5 12))) 0)
					(++ gGEgoY_5)
				else
					(= global161 12)
				)
				(if (> global163 global161) (= global165 1))
				(if (< global163 global161) (= global165 -1))
				(if (== global163 global161) (= global165 0))
				(if (> global164 gGEgoY_5) (= global166 1))
				(if (< global164 gGEgoY_5) (= global166 -1))
				(if (== global164 gGEgoY_5) (= global166 0))
				(= seconds 2)
			)
			(1
				(= temp0
					(if (== global213 global214)
						{COURSE ALREADY ACHIEVED}
					else
						{STANDBY\nCALCULATING COURSE}
					)
				)
				(if (!= global213 global214) (= global217 global213))
				(if local1 (localproc_08a5 local1) (= local1 0))
				(= local4
					(Display
						temp0
						dsWIDTH
						135
						dsALIGN
						1
						dsCOORD
						168
						3
						dsCOLOR
						14
						dsFONT
						600
						dsSAVEPIXELS
					)
				)
				(if (== temp0 {COURSE ALREADY ACHIEVED})
					(scanBut state: 0)
					(global2 newRoom: 17)
				)
				(= seconds 3)
			)
			(2
				(if local4 (localproc_08a5 local4) (= local4 0))
				(if (!= global213 global214) (= cycles 2))
			)
			(3
				(= local4
					(Display
						{COURSE LOCKED}
						dsWIDTH
						135
						dsALIGN
						1
						dsCOORD
						168
						3
						dsCOLOR
						9
						dsFONT
						600
						dsSAVEPIXELS
					)
				)
				(= seconds 3)
			)
			(4
				(if local4 (localproc_08a5 local4) (= local4 0))
				(= cycles 1)
			)
			(5
				(localproc_08a5
					(Format @local55 {DESTINATION: SECTOR %d} global217)
				)
				(= global220 local155)
				(global2 newRoom: 17)
			)
		)
	)
)

(instance scanBut of DIcon
	(properties
		state 1
		nsTop 3
		nsLeft 7
		key 49
	)
	
	(method (init)
		(super init:)
		(= view (if (> global598 4) 49 else 149))
	)
	
	(method (doit)
		(self cel: 3 state: 0 draw:)
		(courseBut state: 0 cel: 1 draw:)
		(returnBut state: 0 cel: 1 draw:)
		(if (< (scanBox cel?) 2)
			(scanBox startUpd: setLoop: 0 setCel: 0 setCycle: 0)
			(= local155 global220)
			(= global220 0)
			(global2 setScript: scanScript)
		else
			(zoomScript changeState: 3)
		)
	)
)

(instance courseBut of DIcon
	(properties
		nsTop 3
		nsLeft 60
		key 50
		loop 3
		cel 1
	)
	
	(method (init)
		(super init:)
		(= view (if (> global598 4) 49 else 149))
	)
	
	(method (doit)
		(if (!= global213 global214)
			(self cel: 2 state: 0 draw:)
			(scanBut state: 0 cel: 2 draw:)
			(returnBut state: 0 cel: 1 draw:)
		)
		(global2 setScript: courseScript)
	)
)

(instance returnBut of DIcon
	(properties
		state 1
		nsTop 3
		nsLeft 113
		key 51
		loop 4
	)
	
	(method (init)
		(super init:)
		(= view (if (> global598 4) 49 else 149))
	)
	
	(method (doit)
		(self cel: 2 state: 0 draw:)
		(courseBut state: 0 cel: 1 draw:)
		(scanBut state: 0 cel: 2 draw:)
		(global2 newRoom: 17)
	)
)

(instance scanBox of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 50
			posn: (+ (* (- global163 1) 25) 22) (+ (* (- global164 1) 18) 32)
			setPri: 13
			setCel: 0
			setLoop: 0
			ignoreActors: 1
		)
	)
	
	(method (doit)
		(super doit:)
		(self
			posn: (+ (* (- global163 1) 25) 22) (+ (* (- global164 1) 18) 32)
		)
	)
)

(instance you of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 50
			posn: (+ (* (- global161 1) 25) 22) (+ (* (- gGEgoY_5 1) 18) 32)
			setPri: 14
			setLoop: 4
			ignoreActors: 1
		)
	)
	
	(method (doit)
		(super doit:)
		(self
			posn: (+ (* (- global161 1) 25) 22) (+ (* (- gGEgoY_5 1) 18) 32)
		)
	)
)

(instance scanner of Sound
	(properties
		number 25
		priority 1
		loop -1
	)
)
