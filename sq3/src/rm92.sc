;;; Sierra Script 1.0 - (do not remove this comment)
(script# 92)
(include sci.sh)
(use Main)
(use Class_255_0)
(use TrashBasket)
(use Timer)
(use Sound)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	rm92 0
)

(instance rm92 of Rm
	(properties
		picture 92
		style 0
		east 91
		west 91
	)
	
	(method (init)
		(super init:)
		(self setRegions: 702)
		(trash1 init:)
		(trash2 init:)
		(trash3 init:)
		(trash4 init:)
		(trash5 init:)
		(trash6 init:)
		(trash7 init:)
		(trash8 init:)
		(nerd1 init:)
		(nerd2 init:)
		(nerd3 init:)
		(nerd4 init:)
		(nerd5 init:)
		(nerd6 init:)
		(nerd7 init:)
		(nerd8 init:)
		(if (proc0_13 14)
			(Load 128 103)
			(photoBoss init:)
			(if (not global233)
				(Load 132 49)
				(pictureSound init:)
				(fink1 init:)
				(copyBeam init:)
			)
		)
		(gEgo init:)
	)
	
	(method (doit)
		(super doit:)
		(if (gEgo has: 14)
			(if
				(and
					(not
						(if (<= 0 (finkScript state?))
							(<= (finkScript state?) 3)
						)
					)
					(> (gEgo x?) 120)
				)
				(fink1 setScript: finkScript)
			)
		)
	)
	
	(method (handleEvent param1 &tmp temp0)
		(if (param1 claimed?) (return))
		(switch (param1 type?)
			(128
				(if global233
					(proc255_0 92 0)
					(param1 claimed: 1)
					(return)
				)
				(= temp0 0)
				(cond 
					((Said 'look,explore>')
						(cond 
							((Said '/original')
								(cond 
									(
									(and (proc0_13 14) (gEgo inRect: 0 180 200 190)) (= temp0 1) (proc255_0 92 1 82 103 0 1 80 {the Boss}))
									((gEgo has: 14) (= temp0 1) ((gInv at: 14) showSelf:))
								)
							)
							((Said '/copier,device,machine[<photocopy]')
								(if (gEgo inRect: 0 147 90 190)
									(= temp0 1)
									(proc255_0 92 2)
								)
							)
							((Said '[/area,partition]')
								(if
								(and (gEgo inRect: 0 180 200 190) (not (gEgo has: 14)))
									(= temp0 1)
									(proc255_0 92 3)
								)
								(if (gEgo inRect: 0 147 90 190)
									(= temp0 1)
									(proc255_0 92 4)
								)
							)
						)
					)
					((Said 'get,remove/original')
						(= temp0 1)
						(cond 
							((gEgo has: 14) (proc255_0 92 5))
							((gEgo inRect: 83 180 111 183) (gEgo setScript: getPic))
							(else (proc255_0 92 6))
						)
					)
					((Said 'hang,drop,replace,replace/original')
						(if
						(and (gEgo inRect: 83 180 111 183) (gEgo has: 14))
							(= temp0 1)
							(gEgo setScript: putPic)
						)
					)
					((Said 'hang,drop,replace,replace/copy')
						(if
						(and (gEgo inRect: 83 180 111 183) (gEgo has: 15))
							(= temp0 1)
							(proc255_0 92 7)
						)
					)
					((Said 'converse/man')
						(if (< (gEgo distanceTo: fink1) 40)
							(= temp0 1)
							(proc255_0 92 8)
							(proc255_0 92 9)
						)
					)
					(
						(or
							(Said 'use,jog,begin,turn/copier,device,machine[<photocopy]')
							(Said 'copy[/original,elmo]')
							(Said 'make/copy[<original,elmo]')
						)
						(if (gEgo inRect: 22 154 43 157)
							(= temp0 1)
							(if (gEgo has: 14)
								(if (gEgo has: 15)
									(proc255_0 92 10)
								else
									(gEgo setScript: copyPic)
								)
							else
								(proc255_0 92 11)
							)
						)
					)
					((Said 'copy') (= temp0 1) (proc255_0 92 12))
				)
				(if (and (param1 claimed?) (not temp0))
					(param1 claimed: 0)
				)
			)
		)
	)
	
	(method (newRoom param1)
		(gTimers eachElementDo: 91 84)
		(super newRoom: param1)
	)
)

(instance getPic of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0
				(if (gEgo has: 15)
					(proc255_0 92 13)
				else
					(proc255_0 92 14)
				)
				(proc0_2)
				(photoBoss hide:)
				(pictureSound play:)
				(gEgo
					x: (photoBoss x?)
					view: 103
					setLoop: 1
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(gEgo
					view: 113
					setLoop: -1
					setDirection: 1
					setCycle: Walk
					get: 14
				)
				(proc0_3)
			)
			(else  (self changeState: 0))
		)
	)
)

(instance putPic of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0
				(if (gEgo has: 15)
					(proc255_0 92 15)
				else
					(proc255_0 92 16)
				)
				(proc0_2)
				(pictureSound play:)
				(gEgo
					x: (photoBoss x?)
					view: 103
					setLoop: 1
					setCel: (gEgo lastCel:)
					setCycle: Beg self
				)
			)
			(1
				(photoBoss show:)
				(gEgo
					view: 113
					setLoop: -1
					setDirection: 1
					setCycle: Walk
					put: 14 gGNorth
				)
				(proc0_3)
			)
			(else  (self changeState: 0))
		)
	)
)

(instance copyPic of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0
				(proc0_2)
				(proc255_0 92 17)
				(gEgo
					view: 103
					posn: 32 155
					setLoop: 1
					setCel: (gEgo lastCel:)
					setCycle: Beg self
				)
			)
			(1
				(gEgo setPri: 15)
				(copyBeam
					show:
					setPri: 14
					posn: 41 135
					setMotion: MoveTo 29 135 self
				)
			)
			(2 (Timer setReal: self 2))
			(3
				(copyBeam posn: 41 135 setMotion: MoveTo 29 135 self)
			)
			(4
				(copyBeam dispose:)
				(gEgo setPri: -1)
				(proc255_0 92 18)
				(gEgo setCycle: End self)
			)
			(5
				(proc255_0 92 19)
				(gEgo setCycle: End self)
			)
			(6
				(gEgo
					view: 113
					setDirection: 1
					setLoop: 3
					setCel: -1
					setCycle: Walk
					get: 15
					forceUpd:
				)
				(gEgo setLoop: -1)
				(gGame changeScore: 5)
				(proc0_3)
			)
			(else  (self changeState: 0))
		)
	)
)

(instance finkScript of Script
	(properties)
	
	(method (changeState theState)
		(if global233 (return))
		(switch (= state theState)
			(0
				(= global243 1)
				(fink1
					setLoop: 7
					setCycle: Fwd
					setMotion: MoveTo 190 162 self
				)
			)
			(1
				(fink1 setMotion: MoveTo 128 185 self)
			)
			(2
				(if (gEgo has: 14)
					(fink1 setMotion: 0 setCycle: 0 seeProblem: 1)
				else
					(= cycles 1)
				)
			)
			(3
				(fink1 setLoop: 6 setMotion: MoveTo 190 162 self)
			)
			(4
				(if (gEgo has: 14)
					(self init:)
				else
					(fink1 setMotion: MoveTo 340 155 self)
				)
			)
			(5
				(= global243 0)
				(fink1 stopUpd:)
			)
			(else  (self init:))
		)
	)
)

(instance fink1 of Fink
	(properties)
	
	(method (init)
		(super init:)
		(self
			speakX: 118
			speakY: 156
			speakCel: 1
			posn: 340 155
			ignoreActors: 0
			ignoreControl: -1
			stopUpd:
		)
	)
	
	(method (doit)
		(super doit:)
		(if
			(and
				(< (self distanceTo: gEgo) 20)
				(gEgo has: 14)
				(== (gEgo view?) 113)
			)
			(self
				setMotion: 0
				setCycle: 0
				speakX: (- x 10)
				speakY: (- y 30)
				seeProblem: 1
				stopUpd:
			)
		)
	)
)

(instance photoBoss of View
	(properties)
	
	(method (init)
		(super init:)
		(self
			setPri: 14
			view: 103
			setLoop: 0
			setCel: 0
			posn: 97 171
			stopUpd:
		)
	)
)

(instance copyBeam of Act
	(properties)
	
	(method (init)
		(super init:)
		(self view: 115 setLoop: 9 setCel: 2 moveSpeed: 2 hide:)
	)
)

(instance trash1 of TrashBasket
	(properties
		myID 13
		nearWest 85
		nearNorth 148
		nearEast 190
		nearSouth 179
	)
	
	(method (init)
		(super init:)
		(self posn: 120 150 myNerd: nerd1)
	)
)

(instance trash2 of TrashBasket
	(properties
		myID 14
		nearWest 21
		nearNorth 115
		nearEast 122
		nearSouth 147
	)
	
	(method (init)
		(super init:)
		(self posn: 48 118 myNerd: nerd2)
	)
)

(instance trash3 of TrashBasket
	(properties
		myID 15
		nearWest 122
		nearNorth 117
		nearEast 191
		nearSouth 147
	)
	
	(method (init)
		(super init:)
		(self posn: 153 118 myNerd: nerd3)
	)
)

(instance trash4 of TrashBasket
	(properties
		myID 16
		nearWest 193
		nearNorth 116
		nearEast 253
		nearSouth 148
	)
	
	(method (init)
		(super init:)
		(self posn: 221 128 myNerd: nerd4)
	)
)

(instance trash5 of TrashBasket
	(properties
		myID 17
		nearWest 123
		nearNorth 85
		nearEast 187
		nearSouth 115
	)
	
	(method (init)
		(super init:)
		(self posn: 158 87 myNerd: nerd5)
	)
)

(instance trash6 of TrashBasket
	(properties
		myID 18
		nearWest 21
		nearNorth 53
		nearEast 66
		nearSouth 85
	)
	
	(method (init)
		(super init:)
		(self posn: 43 56 myNerd: nerd6)
	)
)

(instance trash7 of TrashBasket
	(properties
		myID 19
		nearWest 76
		nearNorth 23
		nearEast 156
		nearSouth 83
	)
	
	(method (init)
		(super init:)
		(self posn: 106 54 myNerd: nerd7)
	)
)

(instance trash8 of TrashBasket
	(properties
		myID 20
		nearWest 183
		nearNorth 54
		nearEast 246
		nearSouth 115
	)
	
	(method (init)
		(super init:)
		(self posn: 210 68 myNerd: nerd8)
	)
)

(instance nerd1 of Nerd
	(properties)
	
	(method (init)
		(super init:)
		(self
			setLoop: 0
			posn: 101 153
			speakX: 110
			speakY: 137
			speakCel: 0
		)
	)
)

(instance nerd2 of Nerd
	(properties)
	
	(method (init)
		(super init:)
		(self
			setLoop: 2
			posn: 66 116
			speakX: 92
			speakY: 105
			speakCel: 0
		)
	)
)

(instance nerd3 of Nerd
	(properties)
	
	(method (init)
		(super init:)
		(self
			setLoop: 3
			posn: 182 118
			setPri: 11
			speakX: 160
			speakY: 102
			speakCel: 1
		)
	)
)

(instance nerd4 of Nerd
	(properties)
	
	(method (init)
		(super init:)
		(self
			setLoop: 2
			posn: 201 112
			setPri: 8
			speakX: 228
			speakY: 93
			speakCel: 0
		)
	)
)

(instance nerd5 of Nerd
	(properties)
	
	(method (init)
		(super init:)
		(self
			setLoop: 1
			posn: 170 89
			speakX: 159
			speakY: 68
			speakCel: 1
		)
	)
)

(instance nerd6 of Nerd
	(properties)
	
	(method (init)
		(super init:)
		(self
			setPri: 3
			setLoop: 1
			posn: 55 59
			speakX: 69
			speakY: 38
			speakCel: 0
		)
	)
)

(instance nerd7 of Nerd
	(properties)
	
	(method (init)
		(super init:)
		(self
			setLoop: 0
			posn: 91 58
			speakX: 99
			speakY: 38
			speakCel: 0
		)
	)
)

(instance nerd8 of Nerd
	(properties)
	
	(method (init)
		(super init:)
		(self
			setLoop: 2
			posn: 196 55
			speakX: 184
			speakY: 42
			speakCel: 1
		)
	)
)

(instance pictureSound of Sound
	(properties
		number 49
		priority 1
	)
)
