;;; Sierra Script 1.0 - (do not remove this comment)
;;; decompiled from 750.scr: verified rung 1
(script# 750)
(include scc.sh)

(public
	rm750 0
	rogTalker 15
)

(local
	local0
	local1 = 1
	local2
	local3 = 1
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	local19
	local20
	local21
	local22
	local23
	local24
	local25
	local26
	local27
	local28
	local29
	local30
	local31
	local32
	local33
	local34
	local35
	local36
	local37
	local38
	local39
	local40
	local41
	local42
	local43
	local44
	local45
	local46
	local47
	local48
	local49
	local50
	local51
	local52
	local53
	local54
	local55
	local56
	local57
	local58
	local59
	local60
	local61
	local62
	local63
	local64
	local65
	local66
	local67
	local68
	local69
	local70
	local71
	local72
	local73
	local74
	local75
	local76
	local77
	local78
	local79
	local80
	local81
	local82
	local83
	local84
	local85
	local86
	local87
	local88
	local89
	local90
	local91
	local92
	local93
	local94
	local95
	local96
	local97
	local98
	local99
	local100
	local101
	local102
	local103
	local104
	local105
	local106
	local107
	local108 = 46
	local109 = 180
	local110 = 240
	local111 = 300
	local112 = 40
	local113 = 49
	local114 = 58
	local115 = 67
	local116 = 76
	local117 = 85
	local118 = 94
	local119 = 103
	local120 = 112
	local121 = 121
	local122 = 130
	local123 = 139
	local124 = 148
	local125 = 157
	local126 = 166
	local127 = 45
	local128 = 115
	local129 = 300
)

(procedure (localproc_0 param1 param2 param3 param4 param5)
	(Graph grDRAW_LINE param2 param1 param4 param3 param5 -1 -1)
	(Graph grUPDATE_BOX param2 param1 param4 param3 1)
)

(procedure (localproc_1 param1 param2 param3 param4 param5)
	(localproc_0 param1 param2 param3 param2 param5)
	(localproc_0 param3 param2 param3 param4 param5)
	(localproc_0 param3 param4 param1 param4 param5)
	(localproc_0 param1 param4 param1 param2 param5)
)

(procedure (localproc_2 param1 param2)
	(proc999_4 (+ (param2 nsLeft:) 1) (+ (param2 nsTop:) 1) (- (param2 nsRight:) 1) (- (param2 nsBottom:) 1) param1)
)

(procedure (localproc_3)
	(return (not (or (camera1 script:) (camera2 script:) (camera3 script:) (mainBW script:) (global2 script:))))
)

(procedure (localproc_4 param1 &tmp temp0 temp1 temp2 temp3)
	(= temp2 0)
	(= temp0 0)
	(while (< temp0 12)
		(= temp1 0)
		(while (< temp1 3)
			(= temp3 (switch temp1 (0 130 ) (1 100 ) (2 80 ) ))
			(localproc_7 [local108 temp1] [local112 temp0] 751 1 0 param1 (++ temp2) 20 temp3)
			(++ temp1)
		)
		(++ temp0)
	)
)

(procedure (localproc_5 param1 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp2 0)
	(= temp0 0)
	(while (< temp0 14)
		(= temp1 0)
		(while (< temp1 2)
			(= temp3 (switch temp1 (0 56 ) (1 230 ) ))
			(localproc_7 [local127 temp1] [local112 temp0] 750 4 0 param1 (++ temp2) 20 temp3)
			(if (> temp2 27)
				(= temp0 50)
				(= temp1 50)
			)
			(++ temp1)
		)
		(++ temp0)
	)
)

(procedure (localproc_6 param1 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp2 0)
	(= temp0 0)
	(while (< temp0 12)
		(localproc_7 50 [local112 temp0] 752 3 0 param1 (++ temp2) 20 270)
		(++ temp0)
	)
)


(procedure (localproc_7 param1 param2 param3 param4 param5 param6 param7 param8 param9 param10)
	(Message msgGET param3 param4 param5 param6 param7 @local8)
	(if (== argc 10)
		(Display 
			@local8 
			dsALIGN alRIGHT		;Z fix lines mis-alignment
			dsCOORD param1 param2 
			dsFONT 1605 
			dsWIDTH param9 
			dsCOLOR param8 
			dsBACKGROUND param10)
	else
		(Display 
			@local8 
			dsALIGN alRIGHT		;Z fix lines mis-alignment
			dsCOORD param1 param2 
			dsFONT 1605 
			dsWIDTH param9 
			dsCOLOR param8)
	)
)

(instance rm750 of Rm
	(properties)

	(method (init)
		(proc958_0 143 number)
		(self setRegions: 31)
		(proc0_10 231 10)
		(if (proc0_1 22)
			(global0
				view: 617
				signal: 16384
				init:
				setLoop: -1
				illegalBits: 0
				setPri: 15
				noun: 19
				moveSpeed: 6
				setScale: 0
				setCycle: Walk
				setStep: 6 6
				cycleSpeed: 2
				setLoop: Grooper
			)
			(if (not (proc0_1 121))
				(global0 posn: 50 50)
				(proc0_2 121)
			)
			(global93 addToFront: self)
		)
		(camera1 signal: 16400)
		(camera2 signal: 16400)
		(camera3 signal: 16400)
		(= local5 0)
		(while (< local5 (global10 size:))
			(= local6 (global10 at: local5))
			(local6 signal: (& (local6 signal:) -33))
			(++ local5)
		)
		(global10 delete: global0)
		(global10 eachElementDo: 111)
		(global1 handsOn:)
		(= picture (switch global162 (0 119 ) (4 118 ) (5 119 ) (6 119 ) (7 119 ) (8 119 ) (1 113 ) (2 110 ) (3 112 ) ))
		(= noun (switch global162 (0 7 ) (4 7 ) (5 7 ) (6 7 ) (7 7 ) (8 7 ) (1 8 ) (2 8 ) (3 8 ) ))
		(= style 32868)
		(super init:)
		(if (not (proc0_1 22))
			(global69 curIcon: (global69 at: 2))
			(global1 setCursor: 982)
			(global69 disable: 4 7 5 6 0 3)
		else
			(global69 disable: 4 7 5 2 6 3)
		)
		(if (and (== picture 119) (!= global162 0))
			(header
				init:
				cel: (switch global162 (5 0 ) (6 1 ) (7 3 ) (8 2 ) )
			)
		)
		(if (proc999_5 picture 110 112 113)
			(Palette 1 (global2 picture:) 2)
		)
		(switch global162
			(0
				(proc958_0 128 625)
				(global2 setScript: sDanger)
			)
			(4
				(if (proc0_1 120)
					(global2 setScript: sDoMainMenu)
					(= local3 1)
				else
					(proc0_2 120)
					(global2 setScript: sReboot)
				)
			)
			(5
				(global2 setScript: sDoSystems)
			)
			(6
				(global2 setScript: sDoLog)
			)
			(7
				(global2 setScript: sDoProjects)
			)
			(8
				(global2 setScript: sDoAccounting)
			)
			(1
				(global2 setScript: sDoSecurity3)
			)
			(2
				(global2 setScript: sDoSecurity2)
			)
			(3
				(global2 setScript: sDoSecurity1)
			)
		)
	)

	(method (doit)
		(switch global162
			(3
				(Palette 6 225 233 -1)
				(Palette 6 234 240 -1)
			)
			(0
				(Palette 6 241 243 20 243 245 20)
			)
		)
		(if (== (global69 at: 0) (global69 curIcon:))
			(if (proc999_4 10 10 296 188 global70 global71)
				(if (== (((global69 curIcon:) cursor:) view:) 987)
					(((global69 curIcon:) cursor:) view: 980)
					(global1 setCursor: ((global69 curIcon:) cursor:))
				)
			else
				(if (!= (((global69 curIcon:) cursor:) view:) 987)
					(((global69 curIcon:) cursor:) view: 987)
					(global1 setCursor: ((global69 curIcon:) cursor:))
				)
			)
		)
		(if (== (global69 at: 2) (global69 curIcon:))
			(if (proc999_4 10 10 296 188 global70 global71)
				(if (== ((global69 curIcon:) cursor:) 988)
					((global69 curIcon:) cursor: 982)
					(global1 setCursor: ((global69 curIcon:) cursor:))
				)
			else
				(if (!= ((global69 curIcon:) cursor:) 988)
					((global69 curIcon:) cursor: 988)
					(global1 setCursor: ((global69 curIcon:) cursor:))
				)
			)
		)
		(super doit:)
	)

	(method (doVerb param1)
		(switch param1
			(3
				(if (== (((global69 curIcon:) cursor:) view:) 987)
					(global80 canControl: 1)
					(global80 canInput: 1)
					(global2 newRoom: 790)
				else
					(global0 setMotion: MoveTo global70 global71)
					(++ local1)
				)
			)
			(4
				(if (== ((global69 curIcon:) cursor:) 988)
					(global2 newRoom: 790)
				)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)

	(method (dispose)
		(global93 delete: self)
		(if (proc0_1 22)
			(((global69 at: 0) cursor:) view: 980)
		else
			((global69 at: 2) cursor: 982)
		)
		(super dispose: &rest)
	)
)

(instance sDanger of Script
	(properties)

	(method (changeState param1)
		(= state param1)
		(switch state
			(0
				(restartIcon init:)
				(Graph grFILL_BOX 103 40 165 313 1 9 -1 -1)
				(Graph grREDRAW_BOX 103 40 165 313)
				(= cycles 5)
			)
			(1
				(Message msgGET 750 2 0 0 2 @local8)
				(Display @local8 dsALIGN 1 dsCOORD 33 60 dsFONT 2407 dsWIDTH 280 dsCOLOR 12)
				(Message msgGET 750 2 0 0 3 @local8)
				(Display @local8 dsALIGN 1 dsCOORD 28 109 dsFONT 2510 dsWIDTH 290 dsCOLOR 12)
				(Message msgGET 750 2 0 0 4 @local8)
				(Display @local8 dsALIGN 1 dsCOORD 62 125 dsFONT 4115 dsWIDTH 220 dsCOLOR 12)
				(Message msgGET 750 2 0 0 5 @local8)
				(Display @local8 dsALIGN 1 dsCOORD 61 145 dsFONT 2510 dsWIDTH 220 dsCOLOR 12)
				(= cycles 1)
			)
			(2
				(= cycles 4)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sSelectButton of Script
	(properties)

	(method (changeState param1)
		(= state param1)
		(switch state
			(0
				(= local2 1)
				(client setCel: 1)
				(= seconds 2)
			)
			(1
				(client setCel: 0)
				(= cycles 1)
			)
			(2
				(= local2 0)
				(global2 setScript: sDoNextScreen 0 register)
				(self dispose:)
			)
		)
	)
)

(instance sReboot of Script
	(properties)

	(method (changeState param1)
		(= state param1)
		(switch state
			(0
				(= local7 1)
				(global120 pause: 1)
				(global121
					number: 618
					setLoop: 1
					play: self
				)
				(swoosh init:)
				(weplygod init:)
				(soYoudo init:)
			)
			(1
				(global120 pause: 0)
				(starBurst
					init:
					setCycle: End self
				)
			)
			(2
				(wEyes
					init:
					setCycle: End self
				)
			)
			(3
				(= seconds 1)
			)
			(4
				(swoosh setCycle: End self)
				(starBurst dispose:)
				(wEyes dispose:)
			)
			(5
				(swoosh setMotion: MoveTo 340 48 self)
			)
			(6
				(= seconds 1)
			)
			(7
				(DrawPic 118 9)
				(swoosh dispose:)
				(weplygod dispose:)
				(soYoudo dispose:)
				(= cycles 5)
			)
			(8
				(global2 setScript: sDoMainMenu)
				(self dispose:)
			)
		)
	)
)

(instance sDoNextScreen of Script
	(properties)

	(method (changeState param1)
		(= state param1)
		(switch state
			(0
				(global121
					number: 124
					setLoop: 1
					play:
				)
				(global5 delete: dome1)
				(global5 delete: dome2)
				(global5 delete: dome3)
				(global5 eachElementDo: 303)
				(global5 eachElementDo: 111)
				(= global162 register)
				(= cycles 1)
			)
			(1
				(global2 init:)
				(self dispose:)
			)
		)
	)
)

(instance sDoSystems of Script
	(properties)

	(method (changeState param1)
		(= state param1)
		(switch state
			(0
				(backToMain init:)
				(leftTop
					init:
					addToPic:
				)
				(piece1
					init:
					addToPic:
				)
				(dome1
					init:
					hide:
				)
				(dome2
					init:
					hide:
				)
				(dome3
					init:
					hide:
				)
				(rightBottom
					init:
					addToPic:
				)
				(leftBottom
					init:
					addToPic:
				)
				(self dispose:)
			)
		)
	)
)

(instance sSelectDome of Script
	(properties)

	(method (changeState param1)
		(= state param1)
		(switch state
			(0
				(securityIcon dispose:)
				(dome1 hide:)
				(dome2 hide:)
				(dome3 hide:)
				(= ticks 5)
			)
			(1
				(switch register
					(dome1
						(dome1 show:)
						(localproc_7 49 131 752 1 0 0 1 31 86 67)
					)
					(dome2
						(dome2 show:)
						(localproc_7 49 131 752 1 0 0 2 31 86 67)
					)
					(dome3
						(dome3 show:)
						(securityIcon init:)
						(localproc_7 49 131 752 1 0 0 3 31 86 67)
					)
				)
				(global121
					number: 124
					setLoop: 1
					play:
				)
				(= ticks 5)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sDoSecurity1 of Script
	(properties)

	(method (changeState param1)
		(= state param1)
		(switch state
			(0
				(global80 canControl: 0)
				(global80 canInput: 0)
				(camera2 init:)
				(camera1 init:)
				(mainBW init:)
				(bigDoor
					init:
					addToPic:
				)
				(= ticks 1)
			)
			(1
				(if (proc0_1 22)
					(= ticks 1)
				else
					(cliffy
						init:
						setCycle: End
					)
					(global80 canControl: 1)
					(global80 canInput: 1)
					(self dispose:)
					(= seconds 2)
				)
			)
			(2
				(if (proc0_1 26)
					(myWD40
						init:
						loop: 3
					)
					(myWD40Head
						init:
						cycleSpeed: 12
						setScript: sWoscillate
					)
					(myCliffy
						init:
						loop: 2
						cycleSpeed: 6
						setScript: sCycleCliffy
					)
					(= cycles 2)
				else
					(myWD40
						init:
						cycleSpeed: 6
						setCycle: End self
					)
					(myCliffy
						init:
						cycleSpeed: 20
						setCycle: End
					)
				)
			)
			(3
				(if (proc0_1 26)
					(global80 canControl: 1)
					(global80 canInput: 1)
					(self dispose:)
				else
					(myWD40Head
						init:
						cycleSpeed: 12
						setScript: sWoscillate
					)
					(myWD40 loop: 3)
					(myCliffy
						loop: 2
						cycleSpeed: 6
						setScript: sCycleCliffy
					)
					(= seconds 1)
				)
			)
			(4
				(global0 setMotion: MoveTo 100 160 self)
			)
			(5
				(global0 setMotion: MoveTo 170 85 self)
			)
			(6
				(global91 say: 1 0 0 0 self 753)
			)
			(7
				(proc0_2 26)
				(global80 canControl: 1)
				(global80 canInput: 1)
				(self dispose:)
			)
		)
	)
)

(instance sDoSecurity2 of Script
	(properties)

	(method (changeState param1)
		(= state param1)
		(switch state
			(0
				(Palette 1 (global2 picture:) 2)
				(global80 canControl: 0)
				(global80 canInput: 0)
				(camera1 init:)
				(camera3 init:)
				(if (not (global0 has: 10))
					(comm init:)
				)
				(mainBW init:)
				(= ticks 1)
			)
			(1
				(Palette 1 (global2 picture:) 2)
				(global80 canControl: 1)
				(global80 canInput: 1)
				(self dispose:)
			)
		)
	)
)

(instance sDoSecurity3 of Script
	(properties)

	(method (changeState param1)
		(= state param1)
		(switch state
			(0
				(Palette 1 (global2 picture:) 2)
				(global80 canControl: 0)
				(global80 canInput: 0)
				(camera3 init:)
				(camera2 init:)
				(lever init:)
				(mainBW init:)
				(if (proc0_1 27)
					(global80 canControl: 1)
					(global80 canInput: 1)
					(self dispose:)
				else
					(rogTrashFly init:)
				)
				(= ticks 1)
			)
			(1
				(Palette 1 (global2 picture:) 2)
				(rogTrashFly setCycle: End self)
			)
			(2
				(proc0_2 27)
				(rogTrashFly dispose:)
				(global80 canControl: 1)
				(global80 canInput: 1)
				(self dispose:)
			)
		)
	)
)

(instance sDoProjects of Script
	(properties)

	(method (changeState param1)
		(= state param1)
		(switch state
			(0
				(backToMain init:)
				(localproc_1 44 20 308 34 15)
				(localproc_1 44 36 308 146 15)
				(localproc_1 42 18 310 148 15)
				(localproc_7 57 24 752 2 0 0 local3 15 200)
				(localproc_6 local3)
				(if (!= local3 1)
					(prefIcon init:)
				)
				(if (== local3 9)
					(proc0_2 82)
					(proc0_2 102)
					(proc0_10 233 20)
				)
				(if (!= local3 10)
					(nextIcon init:)
				)
				(= cycles 2)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance sDoAccounting of Script
	(properties)

	(method (changeState param1)
		(= state param1)
		(switch state
			(0
				(backToMain init:)
				(localproc_1 44 20 308 34 15)
				(localproc_1 44 36 171 146 15)
				(localproc_1 171 36 222 146 15)
				(localproc_1 222 36 308 146 15)
				(localproc_1 42 18 310 148 15)
				(localproc_7 100 24 751 1 0 0 2 15 200)
				(proc0_10 232 15)
				(localproc_4 local3)
				(if (!= local3 1)
					(prefIcon init:)
				)
				(if (!= local3 3)
					(nextIcon init:)
				)
				(= cycles 2)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance sDoLog of Script
	(properties)

	(method (changeState param1)
		(= state param1)
		(switch state
			(0
				(backToMain init:)
				(localproc_1 44 36 81 176 15)
				(localproc_1 81 36 308 176 15)
				(localproc_1 42 18 310 178 15)
				(localproc_1 44 20 308 34 15)
				(localproc_7 57 24 750 3 0 0 1 15 100)
				(localproc_7 157 24 750 3 0 0 2 15 100)
				(localproc_5 local3)
				(if (!= local3 1)
					(prefIcon init:)
				)
				(if (!= local3 4)
					(nextIcon init:)
				)
				(self dispose:)
			)
		)
	)
)

(instance sDoMainMenu of Script
	(properties)

	(method (changeState param1)
		(= state param1)
		(switch state
			(0
				(but1 init:)
				(but2 init:)
				(but3 init:)
				(but4 init:)
				(= cycles 3)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance swoosh of Actor
	(properties)
)

(instance starBurst of Prop
	(properties)
)

(instance security of Prop
	(properties)
)

(instance backToMain of Prop
	(properties)

	(method (doVerb param1)
		(if (not (proc0_1 22))
			(switch param1
				(4
					(global2 setScript: sDoNextScreen 0 4)
				)
			)
		)
	)

	(method (doit)
		(if (and (proc0_1 22) (not local2) (localproc_2 global0 self 1))
			(self setScript: sSelectButton 0 4)
		)
		(super doit:)
	)
)

(instance wEyes of Prop
	(properties)
)

(instance piece1 of View
	(properties)
)

(instance leftTop of View
	(properties)
)

(instance rightBottom of View
	(properties)
)

(instance leftBottom of View
	(properties)
)

(instance topWords of View
	(properties)
)

(instance securityIcon of Prop
	(properties)

	(method (doVerb param1)
		(if (not (proc0_1 22))
			(switch param1
				(4
					(self setScript: sSelectButton 0 1)
				)
			)
		)
	)

	(method (doit)
		(if (and (proc0_1 22) (not local2) (localproc_2 global0 self 1))
			(self setScript: sSelectButton 0 1)
		)
		(super doit:)
	)
)

(instance sideWord3 of View
	(properties)
)

(instance but1 of Prop
	(properties)

	(method (doit)
		(if (and (proc0_1 22) (not local2))
			(if (localproc_2 global0 but1 1)
				(but1 setScript: sSelectButton 0 5)
			)
			(if (localproc_2 global0 but2 1)
				(but2 setScript: sSelectButton 0 6)
			)
			(if (localproc_2 global0 but3 1)
				(but3 setScript: sSelectButton 0 7)
			)
			(if (localproc_2 global0 but4 1)
				(but4 setScript: sSelectButton 0 8)
			)
		)
		(super doit:)
	)

	(method (doVerb param1)
		(if (not (proc0_1 22))
			(switch param1
				(4
					(but1 setScript: sSelectButton 0 5)
				)
			)
		)
	)
)

(instance but2 of Prop
	(properties)

	(method (doVerb param1)
		(if (not (proc0_1 22))
			(switch param1
				(4
					(but2 setScript: sSelectButton 0 6)
				)
			)
		)
	)
)

(instance but3 of Prop
	(properties)

	(method (doVerb param1)
		(if (not (proc0_1 22))
			(switch param1
				(4
					(but3 setScript: sSelectButton 0 7)
				)
			)
		)
	)
)

(instance but4 of Prop
	(properties)

	(method (doVerb param1)
		(if (not (proc0_1 22))
			(switch param1
				(4
					(but4 setScript: sSelectButton 0 8)
				)
			)
		)
	)
)

(instance bigDoor of View
	(properties)
)

(instance weplygod of Prop
	(properties)
)

(instance soYoudo of Prop
	(properties)
)

(instance camera1 of Prop
	(properties)

	(method (doVerb param1)
		(if (not (proc0_1 22))
			(switch param1
				(4
					(self setScript: sSelectButton 0 1)
				)
			)
		)
	)

	(method (doit)
		(if (and (proc0_1 22) (localproc_3) (not local2) (localproc_2 global0 self 1))
			(self setScript: sSelectButton 0 1)
		)
		(super doit:)
	)
)

(instance camera2 of Prop
	(properties)

	(method (doVerb param1)
		(if (not (proc0_1 22))
			(switch param1
				(4
					(self setScript: sSelectButton 0 2)
				)
			)
		)
	)

	(method (doit)
		(if (and (proc0_1 22) (localproc_3) (not local2) (localproc_2 global0 self 1))
			(self setScript: sSelectButton 0 2)
		)
		(super doit:)
	)
)

(instance camera3 of Prop
	(properties)

	(method (doVerb param1)
		(if (not (proc0_1 22))
			(switch param1
				(4
					(self setScript: sSelectButton 0 3)
				)
			)
		)
	)

	(method (doit)
		(if (and (proc0_1 22) (localproc_3) (not local2) (localproc_2 global0 self 1))
			(self setScript: sSelectButton 0 3)
		)
		(super doit:)
	)
)

(instance mainBW of Prop
	(properties)

	(method (doVerb param1)
		(if (not (proc0_1 22))
			(switch param1
				(4
					(self setScript: sSelectButton 0 4)
				)
			)
		)
	)

	(method (doit)
		(if (and (proc0_1 22) (localproc_3) (not local2) (localproc_2 global0 self 1))
			(self setScript: sSelectButton 0 4)
		)
		(super doit:)
	)
)

(instance myWD40Head of Prop
	(properties)

	(method (init)
		(super init:)
		(self setScale: Scaler 124 55 167 80)
	)
)

(instance myCliffy of Prop
	(properties)

	(method (init)
		(super init:)
		(self setScale: Scaler 124 55 167 80)
	)
)

(instance myWD40 of Actor
	(properties)

	(method (init)
		(super init:)
		(self setScale: Scaler 124 55 167 80)
	)
)

(instance rogTrashFly of Prop
	(properties)
)

(instance prefIcon of Actor
	(properties)

	(method (doVerb param1)
		(if (not (proc0_1 22))
			(switch param1
				(4
					(-- local3)
					(global2 setScript: sDoNextScreen 0 global162)
				)
			)
		)
	)

	(method (doit)
		(if (and (proc0_1 22) (localproc_2 global0 self 1) (< 1 local1) (not (global2 script:)) (not local2))
			(-- local3)
			(self setScript: sSelectButton 0 global162)
			(= local1 0)
		)
		(super doit:)
	)
)

(instance nextIcon of Actor
	(properties)

	(method (doVerb param1)
		(switch param1
			(4
				(++ local3)
				(global2 setScript: sDoNextScreen 0 global162)
			)
		)
	)

	(method (doit)
		(if (and (proc0_1 22) (localproc_2 global0 self 1) (< 1 local1) (not (global2 script:)) (not local2))
			(= local1 0)
			(++ local3)
			(self setScript: sSelectButton 0 global162)
		)
		(super doit:)
	)
)

(instance restartIcon of Prop
	(properties)

	(method (doVerb param1)
		(if (not (proc0_1 22))
			(switch param1
				(4
					(self setScript: sSelectButton 0 4)
				)
			)
		)
	)

	(method (doit)
		(if (and (proc0_1 22) (not local2) (localproc_2 global0 self 1))
			(self setScript: sSelectButton 0 4)
		)
		(super doit:)
	)
)

(instance dome1 of Prop
	(properties)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(if (<= nsLeft temp0 nsRight)
			(<= nsTop temp1 nsBottom)
		)
	)

	(method (handleEvent param1)
		(if (and (global80 canControl:) (self onMe: param1) (& (param1 type:) 16384))
			(self doVerb: (param1 message:))
			(return (param1 claimed: 1))
		else
			(return 0)
		)
	)

	(method (doVerb param1)
		(switch param1
			(4
				(if (and (& (self signal:) 128) (not (global2 script:)))
					(global2 setScript: sSelectDome 0 self)
				)
			)
			(1
				(proc921_1 "%d %d %d %d" (proc0_1 22) (not (global2 script:)) (& (self signal:) 128) (& onMeCheck (global0 onControl: 1)))
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)

	(method (doit)
		(if (and (proc0_1 22) (not (global2 script:)) (& (self signal:) 128) (& onMeCheck (global0 onControl: 1)))
			(global2 setScript: sSelectDome 0 self)
		)
		(super doit:)
	)
)

(instance dome2 of Prop
	(properties)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(if (<= nsLeft temp0 nsRight)
			(<= nsTop temp1 nsBottom)
		)
	)

	(method (handleEvent param1)
		(if (and (global80 canControl:) (self onMe: param1) (& (param1 type:) 16384))
			(self doVerb: (param1 message:))
			(return (param1 claimed: 1))
		else
			(return 0)
		)
	)

	(method (doVerb param1)
		(switch param1
			(4
				(if (and (& (self signal:) 128) (not (global2 script:)))
					(global2 setScript: sSelectDome 0 self)
				)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)

	(method (doit)
		(if (and (proc0_1 22) (not (global2 script:)) (& (self signal:) 128) (& onMeCheck (global0 onControl: 1)))
			(global2 setScript: sSelectDome 0 self)
		)
		(super doit:)
	)
)

(instance dome3 of Prop
	(properties)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(if (<= nsLeft temp0 nsRight)
			(<= nsTop temp1 nsBottom)
		)
	)

	(method (handleEvent param1)
		(if (and (global80 canControl:) (self onMe: param1) (& (param1 type:) 16384))
			(self doVerb: (param1 message:))
			(return (param1 claimed: 1))
		else
			(return 0)
		)
	)

	(method (doVerb param1)
		(switch param1
			(4
				(if (and (& (self signal:) 128) (not (global2 script:)))
					(global2 setScript: sSelectDome 0 self)
				)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)

	(method (doit)
		(if (and (proc0_1 22) (not (global2 script:)) (& (self signal:) 128) (& onMeCheck (global0 onControl: 1)))
			(global2 setScript: sSelectDome 0 self)
		)
		(super doit:)
	)
)

(instance header of View
	(properties)
)

(instance lever of Prop
	(properties)
)

(instance rogTalker of Narrator
	(properties)

	(method (init)
		(= font global22)
		(= global38 global116)
		(global38
			tailX: 150
			tailY: 90
			xOffset: -5
			isBottom: 0
		)
		(super init: &rest)
	)

	(method (dispose)
		(= global38 global117)
		(super dispose: &rest)
	)
)

(instance sWoscillate of Script
	(properties)

	(method (changeState param1)
		(= state param1)
		(switch state
			(0
				(= seconds 2)
			)
			(1
				(client setCycle: End self)
			)
			(2
				(= seconds 2)
			)
			(3
				(client setCycle: Beg self)
			)
			(4
				(= cycles 1)
				(= state -1)
			)
		)
	)
)

(instance sCycleCliffy of Script
	(properties)

	(method (changeState param1)
		(= state param1)
		(switch state
			(0
				(= seconds 2)
			)
			(1
				(client setCycle: CT 3 1 self)
			)
			(2
				(= seconds 2)
			)
			(3
				(client setCycle: End self)
			)
			(4
				(= seconds 2)
			)
			(5
				(client setCycle: CT 3 -1 self)
			)
			(6
				(= seconds 2)
			)
			(7
				(client setCycle: Beg self)
			)
			(8
				(= cycles 2)
				(= state -1)
			)
		)
	)
)

(instance comm of Prop
	(properties)
)

(instance cliffy of Actor
	(properties)
)
