;;; Sierra Script 1.0 - (do not remove this comment)
(script# 783)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Sound)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	frontDoor 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)
(procedure (localproc_000c)
	(= local0
		(Display
			&rest
			105 ; dsFONT
			41
			dsALIGN
			1
			dsCOORD
			local2
			local3
			dsWIDTH
			300
			dsCOLOR
			15
			dsSAVEPIXELS
		)
	)
)

(procedure (localproc_002e)
	(Display 783 0 108 local0)
)

(procedure (localproc_003c)
	(= local1
		(Display
			&rest
			105 ; dsFONT
			41
			dsALIGN
			1
			dsCOORD
			local2
			local3
			dsWIDTH
			300
			dsCOLOR
			0
			dsSAVEPIXELS
		)
	)
)

(procedure (localproc_005d)
	(Display 783 0 108 local1)
)

(instance Laura of Prop
	(properties)
)

(instance frontDoor of Rm
	(properties
		picture 80
	)
	
	(method (init)
		(super init:)
		(gAddToPics add: knocker eachElementDo: #init doit:)
		(proc0_21 132 6 16 121)
		(Load rsFONT 41)
		(Door setPri: 14 init: stopUpd:)
		(Jeeves setLoop: 0 init: stopUpd:)
		(Eye setLoop: 3 setPri: 14)
		(Mouth setPri: 14 init: stopUpd: hide:)
		(light1 setPri: 15 init: stopUpd:)
		(Laura
			view: 280
			loop: 0
			cel: 0
			setPri: 14
			ignoreActors: 1
			posn: 70 163
			init:
			stopUpd:
		)
		(Lillian setPri: 14 init: stopUpd:)
		(self setScript: openning)
	)
	
	(method (doit)
		(super doit:)
	)
	
	(method (dispose)
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
						(pEvent claimed: 1)
						(global2 newRoom: 209)
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
			(global2 newRoom: 44)
		)
	)
)

(instance openning of Script
	(properties)
	
	(method (doit)
		(if (== (Jeeves x?) 167) (Jeeves setCycle: End))
		(if (== state 4)
			(cond 
				((> local6 -1)
					(if (== (mod local6 2) 1)
						(Door cel: 0)
						(Jeeves cel: 0)
						(light1 cel: 0)
						(Laura cel: 1)
						(Lillian cel: 1)
					else
						(if (== local6 4) (Thunder number: 121 loop: 1 play:))
						(Door cel: 1)
						(Jeeves cel: 1)
						(light1 cel: 1)
						(Laura cel: 0)
						(Lillian cel: 0)
					)
					(-- local6)
				)
				((== local6 -1) (= local6 -2) (= cycles 1))
			)
		)
		(if
			(and
				(== (Thunder number?) 16)
				(== (Thunder prevSignal?) -1)
				(== state 12)
			)
			(client setScript: 0)
			(global2 newRoom: 209)
		)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_3) (= cycles 7))
			(1
				(= local2 11)
				(Thunder number: 6 loop: 1 play:)
				(= local3 52)
				(localproc_003c 783 1)
				(= local2 10)
				(= local3 50)
				(localproc_000c 783 1)
				(= seconds 5)
			)
			(2
				(localproc_002e)
				(localproc_005d)
				(Door cycleSpeed: 2 setCycle: End self)
			)
			(3
				(Door
					loop: 3
					cycleSpeed: 0
					posn: 89 165
					setPri: 15
					hide:
					stopUpd:
				)
				(Jeeves setMotion: MoveTo 131 164 self)
			)
			(4
				(Thunder stop:)
				(Lillian startUpd:)
				(Laura startUpd:)
				(Jeeves loop: 1)
				(Door show: startUpd:)
				(light1 show: startUpd:)
				(= local6 6)
			)
			(5
				(Thunder stop:)
				(Thunder number: 16 loop: -1 play:)
				(Lillian cel: 0 stopUpd:)
				(Door hide:)
				(light1 hide:)
				(= cycles 5)
			)
			(6
				(Eye init: setScript: (Clone eyeball))
				(LEye setPri: 15 init: setScript: (Clone eyeball))
				(EEye setPri: 15 init: setScript: (Clone eyeball))
				(Mouth show: setCycle: End)
				(proc255_0 783 2 67 105 30 30 1 83 88)
				(= seconds 4)
			)
			(7
				(Mouth setCycle: 0 cel: 0)
				(proc0_15)
				(proc255_0 783 3 67 105 140 83 88)
				(= seconds 5)
			)
			(8
				(proc0_15)
				(proc255_0 783 4 67 105 30 30 1 83 88)
				(= local4 2)
				(Mouth setScript: mouthCyc)
				(= seconds 3)
			)
			(9
				(proc0_15)
				(proc255_0 783 5 67 63 30 30 1 83 88)
				(= local4 5)
				(Mouth setScript: mouthCyc)
				(= seconds 5)
			)
			(10
				(proc0_15)
				(proc255_0 783 6 67 78 30 30 1 83 88)
				(= local4 6)
				(Mouth setScript: mouthCyc)
				(= seconds 5)
			)
			(11
				(proc0_15)
				(proc255_0 783 7 67 75 30 30 1 83 88)
				(= local4 6)
				(Mouth setScript: mouthCyc)
				(= seconds 5)
			)
			(12
				(proc0_15)
				(Mouth setCycle: 0 cel: 0)
				(Thunder fade: self)
			)
			(13
				(client setScript: 0)
				(global2 newRoom: 209)
			)
		)
	)
)

(instance eyeball of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: Beg)
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
				(if (== local4 (++ local5))
					(= local5 0)
					(client cel: 0 setScript: 0)
				else
					(= state -1)
					(= cycles 1)
				)
			)
		)
	)
)

(instance knocker of PV
	(properties
		y 138
		x 203
		view 180
		loop 1
		priority 15
		signal $4000
	)
)

(instance Jeeves of Act
	(properties
		y 164
		x 200
		view 455
	)
)

(instance Eye of Prop
	(properties
		y 88
		x 127
		view 455
	)
)

(instance Mouth of Prop
	(properties
		y 105
		x 127
		view 455
		loop 2
	)
)

(instance Lillian of Prop
	(properties
		y 163
		x 250
		view 280
		loop 1
	)
)

(instance LEye of Prop
	(properties
		y 122
		x 253
		view 280
		loop 3
	)
)

(instance EEye of Prop
	(properties
		y 126
		x 73
		view 280
		loop 2
	)
)

(instance light1 of Prop
	(properties
		y 165
		x 206
		view 180
		loop 2
		cel 1
	)
)

(instance Door of Prop
	(properties
		y 164
		x 75
		view 180
	)
)

(instance Thunder of Sound
	(properties)
)
