;;; Sierra Script 1.0 - (do not remove this comment)
(script# 782)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Sound)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	approach 0
)

(local
	local0
	local1
	local2
	local3
)
(procedure (localproc_020a)
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

(procedure (localproc_022c)
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

(procedure (localproc_024d)
	(proc255_0 &rest 67 10 94 33 4 70 145 30 0 88)
)

(procedure (localproc_026a)
	(proc255_0 &rest 67 160 94 33 4 70 142 30 0 88)
)

(instance Laura of Prop
	(properties)
)

(instance Lillian of Prop
	(properties)
)

(instance lHead of Prop
	(properties)
)

(instance eHead of Prop
	(properties)
)

(instance light1 of Prop
	(properties)
)

(instance light2 of Prop
	(properties)
)

(instance Thunder of Sound
	(properties)
)

(instance approach of Rm
	(properties
		picture 28
	)
	
	(method (init)
		(super init:)
		(proc0_21 135 4 41)
		(Load rsSOUND 18)
		(gAddToPics add: Sign Bird1 Bird2 doit:)
		(Thunder number: 18 loop: -1 play:)
		(light1 view: 128 loop: 2 cel: 1 posn: 86 42 init:)
		(light2 view: 128 loop: 3 cel: 1 posn: 157 51 init:)
		(Laura view: 128 loop: 4 cel: 0 posn: 148 187 init:)
		(Lillian view: 128 loop: 4 cel: 1 posn: 180 187 init:)
		(lHead
			view: 128
			loop: 5
			cel: 0
			setPri: 15
			posn: 179 147
			init:
		)
		(eHead
			view: 128
			loop: 6
			cel: 0
			setPri: 15
			posn: 148 148
			init:
		)
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
						)
						(pEvent claimed: 1)
						(global2 newRoom: 783)
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
		(super doit:)
		(if
			(or
				(and (== (Thunder prevSignal?) 50) (== state 0))
				(and (== (Thunder prevSignal?) 60) (== state 6))
				(and (== (Thunder prevSignal?) -1) (== state 11))
			)
			(Thunder prevSignal: 0)
			(= cycles 1)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_3))
			(1
				(light1 setCycle: Fwd)
				(light2 setCycle: Fwd)
				(= cycles 6)
			)
			(2
				(light1 setCycle: End)
				(light2 setCycle: End)
				(= seconds 2)
			)
			(3
				(= local2 11)
				(= local3 10)
				(localproc_022c 782 0)
				(= local2 10)
				(= local3 12)
				(localproc_020a 782 0)
				(= seconds 6)
			)
			(4 (lHead setCycle: End self))
			(5
				(Display 782 1 108 local0)
				(Display 782 1 108 local1)
				(localproc_026a 782 2)
				(= seconds 4)
			)
			(6
				(proc0_15)
				(lHead setCycle: Beg)
			)
			(7
				(light1 setCycle: Fwd)
				(light2 setCycle: Fwd)
				(= cycles 6)
			)
			(8
				(proc0_15)
				(light1 setCycle: End)
				(light2 setCycle: End)
				(= seconds 3)
			)
			(9
				(eHead setCycle: End)
				(localproc_024d 782 3)
				(= seconds 5)
			)
			(10
				(proc0_15)
				(lHead setCycle: End)
				(localproc_026a 782 4)
				(= seconds 5)
			)
			(11
				(proc0_15)
				(lHead setCycle: Beg)
				(eHead setCycle: Beg)
				(Thunder fade: self)
			)
			(12
				(if
				(and (== (lHead cel?) 0) (== (eHead cel?) 0))
					(client setScript: 0)
					(global2 newRoom: 783)
				else
					(= state 11)
					(= cycles 1)
				)
			)
		)
	)
)

(instance Sign of PV
	(properties
		y 135
		x 145
		view 128
		loop 1
		cel 1
		priority 12
	)
)

(instance Bird1 of PV
	(properties
		y 103
		x 111
		view 128
		loop 1
		priority 12
	)
)

(instance Bird2 of PV
	(properties
		y 103
		x 207
		view 128
		loop 1
		priority 12
	)
)
