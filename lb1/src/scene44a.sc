;;; Sierra Script 1.0 - (do not remove this comment)
(script# 330)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Sound)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	scene44a 0
)

(local
	theCycles
	local1
	local2
)
(procedure (localproc_000c &tmp [temp0 500])
	(GetFarText &rest @temp0)
	(= theCycles (+ (/ (StrLen @temp0) 2) 1))
)

(procedure (localproc_002c)
	(localproc_000c &rest)
	(LilMouth setScript: cycleMouth)
	(proc255_0 &rest 67 20 115 33 4 70 140 30 1 83 88)
)

(procedure (localproc_005e)
	(localproc_000c &rest)
	(EthMouth setScript: cycleMouth)
	(proc255_0 &rest 67 160 115 33 4 70 140 30 1 83 88)
)

(instance scene44a of Rm
	(properties
		picture 62
		style $0007
	)
	
	(method (init)
		(super init:)
		(Load rsFONT 4)
		(proc0_3)
		(myMusic number: 27 loop: -1 play:)
		(Lillian setPri: 1 init:)
		(LilMouth setPri: 2 init: hide:)
		(LilEyes
			setLoop: (Random 2 4)
			setPri: 2
			init:
			stopUpd:
			setScript: LillsEyes
		)
		(Ethel setPri: 1 init:)
		(EthMouth setPri: 2 init: hide:)
		(EthArm
			setLoop: 2
			setCel: 0
			setPri: 3
			ignoreActors: 1
			init:
		)
		(if (not (& global173 $0080))
			(self setScript: speech44a)
		else
			(EthArm setScript: TakeASip)
			(LilEyes setScript: LillsEyes)
		)
	)
	
	(method (doit)
		(super doit:)
	)
	
	(method (dispose)
		(if (and (not (& global173 $0080)) global125)
			(= global173 (| global173 $0080))
		)
		(super dispose:)
	)
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
	)
)

(instance LillsEyes of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(LilEyes setLoop: (+ 4 (* (Random 0 2) 2)) stopUpd:)
				(= seconds (Random 2 5))
			)
			(1
				(LilEyes startUpd: setCycle: Beg self)
				(= state -1)
			)
		)
	)
)

(instance speech44a of Script
	(properties)
	
	(method (changeState newState)
		(if (cycleMouth client?)
			(= local1 1)
			(= cycles 1)
		else
			(switch (= state newState)
				(0 (= cycles 7))
				(1
					(= local2
						(Display
							330
							0
							dsCOORD
							48
							8
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
					(localproc_005e 330 1)
					(= seconds 7)
				)
				(2
					(localproc_002c 330 2)
					(EthArm setScript: TakeASip)
					(= seconds 5)
				)
				(3
					(if
					(and (EthArm script?) (< (TakeASip state?) 3))
						(-- state)
						(= cycles 1)
					else
						(localproc_005e 330 3)
						(= seconds 7)
					)
				)
				(4
					(localproc_002c 330 4)
					(EthArm setScript: TakeASip)
					(= seconds 5)
				)
				(5
					(if
					(and (EthArm script?) (< (TakeASip state?) 3))
						(-- state)
						(= cycles 1)
					else
						(localproc_005e 330 5)
						(= seconds 7)
					)
				)
				(6
					(EthArm setScript: TakeASip)
					(proc0_15)
					(= seconds 7)
				)
				(7
					(if
					(and (EthArm script?) (< (TakeASip state?) 3))
						(-- state)
						(= cycles 1)
					else
						(global2 newRoom: gGNumber)
					)
				)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
		(if
			(and
				(not (pEvent claimed?))
				(== evKEYBOARD (pEvent type?))
				(or
					(== (pEvent message?) KEY_S)
					(== (pEvent message?) KEY_s)
				)
			)
			(proc0_15)
			(global2 newRoom: gGNumber)
		)
	)
)

(instance TakeASip of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (& global173 $0080) (proc255_0 330 6 88))
				(EthArm moveSpeed: 1 setMotion: MoveTo 191 113 self)
			)
			(1 (EthArm setCycle: End self))
			(2
				(EthMouth cel: 0 setCycle: Fwd show:)
				(= seconds 2)
			)
			(3
				(EthArm setCycle: Beg self)
				(EthMouth cel: 0 setCycle: 0 hide:)
			)
			(4
				(EthArm setMotion: MoveTo 165 136 self)
			)
			(5
				(client setScript: 0)
				(if (& global173 $0080) (global2 newRoom: gGNumber))
			)
		)
	)
)

(instance cycleMouth of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if local1 (= local1 0) (= cycles 1))
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 0 setCycle: Fwd show:)
				(= cycles theCycles)
			)
			(1
				(client setScript: 0 hide:)
				(self client: 0)
			)
		)
	)
)

(instance Lillian of Prop
	(properties
		y 110
		x 96
		view 517
	)
)

(instance Ethel of Prop
	(properties
		y 110
		x 233
		view 324
	)
)

(instance LilMouth of Prop
	(properties
		y 88
		x 99
		view 517
		loop 2
		cycleSpeed 1
	)
)

(instance LilEyes of Prop
	(properties
		y 75
		x 98
		view 517
		loop 4
		cycleSpeed 1
	)
)

(instance EthMouth of Prop
	(properties
		y 94
		x 212
		view 324
		loop 1
		cycleSpeed 1
	)
)

(instance EthArm of Act
	(properties
		y 136
		x 165
		yStep 5
		view 324
		illegalBits $0000
	)
)

(instance myMusic of Sound
	(properties)
)
