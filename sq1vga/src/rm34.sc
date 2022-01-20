;;; Sierra Script 1.0 - (do not remove this comment)
(script# 34)
(include sci.sh)
(use Main)
(use Class_255_0)
(use DScript)
(use Osc)
(use CueObj)
(use n958)
(use Cycle)
(use Game)
(use User)
(use PicView)
(use Obj)

(public
	rm34 0
)

(local
	local0
	local1
	local2
)
(instance rm34 of Rm
	(properties
		picture 99
	)
	
	(method (init &tmp temp0)
		(proc958_0 132 422 431 419)
		(proc958_0 128 24)
		(proc0_2)
		(gLongSong fade: loop: 0)
		(holodude init:)
		(super init:)
		(gEgo init: x: 180 y: 225)
		(proc0_1 3 1 61)
		(self setScript: startUp)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc255_0 34 0))
			(3 (proc255_0 34 1))
			(5 (proc255_0 34 2))
			(12 (proc255_0 34 3))
			(11 (proc255_0 34 4))
			(4
				(switch param2
					(8
						(gEgo setScript: egoDropOratPart)
					)
					(5 (proc255_0 34 5))
					(else  (proc255_0 34 6))
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance startUp of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 3))
			(1
				(gEgo setMotion: MoveTo 180 175 self)
			)
			(2 (= cycles 9))
			(3
				(if (not (proc0_6 6))
					(proc255_0 34 7 67 10 80 70 100)
					(proc255_0 34 8 67 10 80 70 100)
				)
				(= cycles 6)
			)
			(4
				(gLongSong
					number:
						(cond 
							((and (gEgo has: 8) (proc0_6 48)) 434)
							((and (proc0_6 48) (not (gEgo has: 8))) 422)
							(else 431)
						)
					loop: -1
					play:
				)
				(global2 overlay: 434 100)
				(= cycles 20)
			)
			(5
				(global2 overlay: 334 100)
				(= cycles 20)
			)
			(6
				(global2 overlay: 234 100)
				(= cycles 20)
			)
			(7
				(global2 overlay: 134 100)
				(= cycles 20)
			)
			(8
				(global2 drawPic: 34)
				(holoMouth init:)
				(= cycles 20)
			)
			(9
				(UnLoad 129 434)
				(UnLoad 129 334)
				(UnLoad 129 234)
				(UnLoad 129 134)
				(holoEyes init: setCycle: Fwd)
				(cond 
					((proc0_6 49)
						(if (proc0_6 48)
							(self setScript: translatorOn2 self)
						else
							(self setScript: translatorOff2 self)
						)
					)
					((proc0_6 48) (self setScript: translatorOn1 self))
					(else (self setScript: translatorOff1 self))
				)
			)
			(10 0)
		)
	)
)

(instance translatorOn1 of DScript
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc255_0 34 9 67 10 80 70 100)
				(= cycles 3)
			)
			(1
				(self
					save1:
						(Display
							34
							10
							dsALIGN
							1
							dsFONT
							0
							dsWIDTH
							150
							dsCOORD
							10
							40
							dsCOLOR
							global137
							dsSAVEPIXELS
						)
				)
				(= seconds 8)
			)
			(2
				(self restore:)
				(= seconds 2)
			)
			(3
				(self
					save1:
						(Display
							34
							11
							dsALIGN
							1
							dsFONT
							0
							dsWIDTH
							150
							dsCOORD
							10
							40
							dsCOLOR
							global137
							dsSAVEPIXELS
						)
				)
				(= seconds 8)
			)
			(4
				(self restore:)
				(= seconds 2)
			)
			(5
				(proc255_0 34 12)
				(= cycles 2)
			)
			(6
				(self
					save1:
						(Display
							34
							13
							dsALIGN
							1
							dsFONT
							0
							dsWIDTH
							150
							dsCOORD
							10
							40
							dsCOLOR
							global137
							dsSAVEPIXELS
						)
				)
				(= seconds 6)
			)
			(7
				(self restore:)
				(= seconds 2)
			)
			(8
				(self
					save1:
						(Display
							34
							14
							dsALIGN
							1
							dsFONT
							0
							dsWIDTH
							150
							dsCOORD
							10
							40
							dsCOLOR
							global137
							dsSAVEPIXELS
						)
				)
				(= seconds 6)
			)
			(9
				(self restore:)
				(= seconds 2)
			)
			(10
				(self
					save1:
						(Display
							34
							15
							dsALIGN
							1
							dsFONT
							0
							dsWIDTH
							150
							dsCOORD
							10
							40
							dsCOLOR
							global137
							dsSAVEPIXELS
						)
				)
				(= seconds 13)
			)
			(11
				(self restore:)
				(= seconds 2)
			)
			(12
				(self
					save1:
						(Display
							34
							16
							dsALIGN
							1
							dsFONT
							0
							dsWIDTH
							150
							dsCOORD
							10
							40
							dsCOLOR
							global137
							dsSAVEPIXELS
						)
				)
				(= seconds 6)
			)
			(13
				(self restore:)
				(proc0_7 (= cycles 6))
				(proc0_7 49)
			)
			(14
				(if (gEgo has: 8)
					(= seconds 10)
					(proc0_3)
					(User canControl: 0)
					(gIconBar disable: 0)
				else
					(proc255_0 34 17 67 10 80 70 100)
					(global2 newRoom: 22)
					(self dispose:)
				)
			)
			(15
				(if (= local2 0)
					(proc255_0 34 18 67 10 80 70 100)
					(global2 newRoom: 22)
				)
				(self dispose:)
			)
		)
	)
	
	(method (restore)
		(super restore: &rest)
		(= local1 0)
	)
)

(instance translatorOff1 of DScript
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc255_0 34 19 67 10 80 70 100)
				(= cycles 3)
			)
			(1
				(self
					save1:
						(Display
							34
							20
							dsALIGN
							1
							dsFONT
							0
							dsWIDTH
							150
							dsCOORD
							10
							40
							dsCOLOR
							global137
							dsSAVEPIXELS
						)
				)
				(= seconds 4)
			)
			(2
				(self restore:)
				(= seconds 2)
			)
			(3
				(self
					save1:
						(Display
							34
							21
							dsALIGN
							1
							dsFONT
							0
							dsWIDTH
							150
							dsCOORD
							10
							40
							dsCOLOR
							global137
							dsSAVEPIXELS
						)
				)
				(= seconds 5)
			)
			(4
				(self restore:)
				(= seconds 2)
			)
			(5
				(self
					save1:
						(Display
							34
							22
							dsALIGN
							1
							dsFONT
							0
							dsWIDTH
							150
							dsCOORD
							10
							40
							dsCOLOR
							global137
							dsSAVEPIXELS
						)
				)
				(= seconds 5)
			)
			(6
				(self restore:)
				(= seconds 2)
			)
			(7
				(self
					save1:
						(Display
							34
							23
							dsALIGN
							1
							dsFONT
							0
							dsWIDTH
							150
							dsCOORD
							10
							40
							dsCOLOR
							global137
							dsSAVEPIXELS
						)
				)
				(= seconds 5)
			)
			(8
				(self restore:)
				(= seconds 2)
			)
			(9
				(proc255_0 34 24 67 10 80 70 100)
				(= cycles 3)
			)
			(10
				(global2 newRoom: 22)
				(proc0_7 6)
				(self dispose:)
			)
		)
	)
	
	(method (restore)
		(super restore: &rest)
		(= local1 0)
	)
)

(instance translatorOn2 of DScript
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc255_0 34 25 67 10 80 70 100)
				(= cycles 3)
			)
			(1
				(self
					save1:
						(Display
							34
							26
							dsALIGN
							1
							dsFONT
							0
							dsWIDTH
							150
							dsCOORD
							10
							40
							dsCOLOR
							global137
							dsSAVEPIXELS
						)
				)
				(= seconds 3)
			)
			(2
				(if (gEgo has: 8)
					(= seconds 6)
					(proc0_3)
					(User canControl: 0)
					(gIconBar disable: 0)
				else
					(proc255_0 34 27 67 10 80 70 100)
					(global2 newRoom: 22)
					(self dispose:)
				)
			)
			(3
				(self restore:)
				(= cycles 6)
			)
			(4
				(if (= local2 0)
					(proc255_0 34 28 67 10 80 70 100)
					(global2 newRoom: 22)
				)
			)
		)
	)
	
	(method (restore)
		(super restore: &rest)
		(= local1 0)
	)
)

(instance translatorOff2 of DScript
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc255_0 34 25)
				(= cycles 3)
			)
			(1
				(self
					save1:
						(Display
							34
							29
							dsALIGN
							1
							dsFONT
							0
							dsWIDTH
							150
							dsCOORD
							10
							40
							dsCOLOR
							global137
							dsSAVEPIXELS
						)
				)
				(= seconds 3)
			)
			(2
				(self restore:)
				(= cycles 6)
			)
			(3
				(proc255_0 34 30)
				(global2 newRoom: 22)
			)
		)
	)
	
	(method (restore)
		(super restore: &rest)
		(= local1 0)
	)
)

(instance egoDropOratPart of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(= local2 1)
				(= cycles 3)
				(= local0 1)
			)
			(1
				(gEgo
					view: 24
					cel: 0
					cycleSpeed: 10
					setCycle: CT 4 1 self
				)
			)
			(2
				(gSoundEffects number: 419 loop: 0 play:)
				(gEgo put: 8 34 setCycle: End self)
			)
			(3
				(proc255_0 34 31 67 10 80 70 100)
				;Z that's the original decompilation. but it got the game to stuck here
				;Z(proc0_1
				;Z	(oratPart posn: (gEgo x?) (gEgo y?) init:)
				;Z	1
				;Z	61
				;Z)
				;Z
				;Z fixing according to EricOakford's code:
				;Z 
				;Z (NormalEgo 1 1 61)
				;Z (oratPart init: posn: (ego x?) (ego y?))
				;Z(= cycles 3)
				(proc0_1 1 1 61)
				(oratPart init: posn: (gEgo x?) (gEgo y?))
				(= cycles 3)
			)
			(4
				(proc255_0 34 32)
				(= cycles 3)
			)
			(5
				(gSoundEffects number: 433 loop: 1 play:)
				(door init: posn: 82 106 cycleSpeed: 8 setCycle: End self)
			)
			(6
				(gSoundEffects stop:)
				(gEgo setPri: 10 setMotion: MoveTo 88 112 self)
				(gLongSong fade:)
			)
			(7 (global2 newRoom: 35))
		)
	)
)

(instance holoMouth of Prop
	(properties
		x 216
		y 123
		view 134
		loop 1
		priority 8
		signal $0010
		cycleSpeed 6
	)
	
	(method (doit)
		(super doit:)
		(if
			(and
				(== local1 0)
				(startUp script?)
				((startUp script?) save1?)
				(not cycler)
			)
			(self setCycle: Osc 3)
			(= local1 1)
		)
	)
	
	(method (doVerb theVerb param2)
		(holodude doVerb: theVerb param2)
	)
)

(instance holoEyes of Prop
	(properties
		x 216
		y 71
		view 134
		priority 1
		signal $4010
		cycleSpeed 6
	)
	
	(method (init)
		(super init: &rest)
		(self setCycle: Osc)
	)
	
	(method (doit)
		(super doit:)
		(if (holoMouth cel?) (self show:) else (self hide:))
	)
	
	(method (doVerb theVerb param2)
		(holodude doVerb: theVerb param2)
	)
)

(instance head of Prop
	(properties
		x 218
		y 146
		view 61
		loop 8
		cycleSpeed 6
	)
	
	(method (doVerb theVerb param2)
		(holodude doVerb: theVerb param2)
	)
)

(instance holodude of Feature
	(properties
		x 219
		y 55
		description {holodude}
		sightAngle 45
		onMeCheck $0400
		lookStr {holodude look string}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc255_0 34 33))
			(3 (proc255_0 34 34))
			(12 (proc255_0 34 35))
			(11 (proc255_0 34 36))
			(5 (proc255_0 34 37))
			(4
				(switch param2
					(8
						(gEgo setScript: egoDropOratPart)
					)
					(10 (proc255_0 34 38))
					(0 (proc255_0 34 39))
					(15 (proc255_0 34 40))
					(6 (proc255_0 34 41))
					(5 (proc255_0 34 5))
					(4 (proc255_0 34 42))
					(else 
						(super doVerb: theVerb param2)
					)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance door of Prop
	(properties
		view 234
		signal $4800
		cycleSpeed 10
	)
)

(instance oratPart of View
	(properties
		view 134
		loop 2
		signal $4000
	)
)
