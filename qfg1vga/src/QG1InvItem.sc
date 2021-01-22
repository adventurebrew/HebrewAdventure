;;; Sierra Script 1.0 - (do not remove this comment)
(script# 206)
(include sci.sh)
(use Main)
(use GloryWindow)
(use n814)
(use Print)
(use IconI)
(use InvI)
(use Obj)

(public
	gloryInv 0
	pageCode 1
	dropInv 2
)

(local
	local0
	local1
)
(class QG1InvItem of InvI
	(properties
		view 950
		loop 0
		cel 0
		nsLeft 0
		nsTop 0
		nsRight 0
		nsBottom 0
		state $0000
		cursor 999
		type $4000
		message 0
		modifiers $0000
		signal $0002
		maskView 0
		maskLoop 0
		maskCel 0
		highlightColor 0
		lowlightColor 0
		noun 0
		modNum 206
		helpVerb 0
		owner 0
		script 0
		value 0
		weight 0
		amount 0
		amtDropped 0
	)
	
	(method (select)
		(if (super select: &rest)
			((= cursor invCursor) view: 960 loop: loop cel: cel)
		)
	)
	
	(method (doVerb theVerb &tmp temp0 temp1 temp2 [temp3 50] [temp53 30] [temp83 10] [temp93 20])
		(if (== theVerb 9) (return 1))
		(Print font: gFont mode: 1)
		;Z original: (Message msgGET 206 3 (self message?) 0 1 @temp93)
		(Message msgGET 206 3 (self message?)  
			(if (> (self amount?) 1)
				1	; plural
			else
				0	; singular
			)
			1 @temp93)
		(return
			(switch theVerb
				(1
					(if local1
						(if (== amtDropped 1)
							(Message msgGET 206 3 0 0 22 @temp53)
							(Message msgGET 206 3 (self message?) 2 1 @temp93)		;Z The Singular
							(Print addTextF: @temp3 @temp53 @temp93 init:)
						else
							(Message msgGET 206 3 0 0 23 @temp53)
							(Message msgGET 206 3 (self message?) 3 1 @temp93)		;Z The Plural
							(Print addTextF: @temp3 @temp53 amtDropped @temp93 init:)
						)
					else
						(= temp1 (= temp2 0))
						(= temp1 (/ weight 60))
						(if
							(and
								(not (= temp2 (/ (mod weight 60) 6)))
								(not temp1)
							)
							(= temp2 1)
						)
						(if (> (self amount?) 1)
							(Message msgGET 206 3 0 0 1 @temp53)
						else
							(Message msgGET 206 3 0 0 2 @temp53)
						)
						(Print
							addTextF: @temp3 @temp53 amount @temp93 temp1 temp2
							init:
						)
					)
				)
				(73
					(cond 
						(
							(and
								(== self dagger)
								(== (self amount?) 1)
								(not (gEgo has: 2))
							)
							(Print addText: 3 0 0 4 0 0 206 init:)
						)
						(
							(proc999_5
								self
								sword
								shield
								disenchant
								thiefKit
								magicGem
								ring
								brassKey
								magicMirror
								seed
								acorn
								fairyDust
								greenFur
							)
							(Message msgGET 206 3 0 0 5 @temp53)
							(Message msgGET 206 3 (self message?) 2 1 @temp93)		;Z The Singular
							(Print addTextF: @temp3 @temp53 @temp93 init:)
						)
						((== gModNum 322) (Print addText: 3 0 0 6 0 0 206 init:))
						((> amount 1)
							(self dumpIt: 1)
							(Message msgGET 206 3 0 0 7 @temp53)
							;Z currently changed message formatting (Message msgGET 206 3 (self message?) 3 1 @temp93)		;Z The Plural
							(Message msgGET 206 3 (self message?) 0 1 @temp93)		;Z non-the Singular
							(Print addTextF: @temp3 @temp53 @temp93 init:)
						)
						(else
							(Message msgGET 206 3 0 0 8 @temp53)
							(Message msgGET 206 3 (self message?) 2 1 @temp93)		;Z The Singular
							(Print addTextF: @temp3 @temp53 @temp93 init:)
							(self dumpIt: 1)
							(if (== (gMainIconBar curInvIcon?) self)
								(gMainIconBar curInvIcon: 0)
							)
							(= temp0 0)
							(while (< temp0 40)
								(if (== ((gDropInv at: temp0) owner?) gEgo)
									(= temp0 41)
								)
								(++ temp0)
							)
							(gDropInv hide:)
							(if (> temp0 40)
								(gDropInv curIcon: invDrop show:)
							else
								(= local0 1)
								(invPageUp select:)
							)
						)
					)
				)
				(77
					(if (not amtDropped)
						(Print addText: 3 0 0 20 0 0 206 init:)
					else
						(if (== amtDropped 1)
							(Message msgGET 206 3 (self message?) 2 1 @temp93)		;Z The Singular
							(Message msgGET 206 3 0 0 25 @temp53)
						else
						    (Message msgGET 206 3 (self message?) 3 1 @temp93)		;Z The Plural
							(Message msgGET 206 3 0 0 24 @temp53)
						)
						(Print addTextF: @temp3 @temp53 @temp93 init:)
						(self pickItUp: 1)
					)
				)
				(9 0)
				(else 
					(Message msgGET 206 3 0 0 3 @temp53)
					(Message msgGET 206 3 theVerb 0 1 @temp83)
					(Message msgGET 206 3 (self message?) 2 1 @temp93)		;Z The Singular		TODO split to singular/ploral?
					(Print addTextF: @temp3 @temp53 @temp83 @temp93 init:)
				)
			)
		)
	)
	
	(method (dumpIt param1 &tmp temp0)
		(= amtDropped
			(+
				amtDropped
				(= temp0 (if (> param1 amount) amount else param1))
			)
		)
		(gEgo use: (gloryInv indexOf: self) temp0)
		(if (not amount) (= owner 0))
		(dropInv addToFront: self)
	)
	
	(method (pickItUp param1 &tmp temp0 [temp1 2])
		(= amtDropped
			(-
				amtDropped
				(= temp0
					(if (> param1 amtDropped) amtDropped else param1)
				)
			)
		)
		(gEgo get: (gloryInv indexOf: self) temp0)
		(if (not amtDropped)
			(dropInv hide: delete: self)
			(if (> (dropInv size?) 4)
				(= local1 1)
				((= gDropInv dropInv) showSelf:)
			else
				((= gDropInv gloryInv) showSelf:)
			)
		)
	)
)

(instance gloryInv of Inv
	(properties
		normalHeading 3819
		empty 3837
	)
	
	(method (init)
		((= gDropInv self)
			window: invWin
			helpIconItem: invHelp
			selectIcon: invSelect
			okButton: ok
			add:
				silver
				rations
				sword
				chainMail
				leather
				shield
				dagger
				lockPick
				thiefKit
				thiefLicense
				rock
				flask
				healingPotion
				manaPotion
				staminaPotion
				disenchant
				brassKey
				magicGem
				ring
				ghostOil
				magicMirror
				mandrake
				fruit
				vegetables
				acorn
				seed
				flowers
				greenFur
				fairyDust
				flyingWater
				mushroom
				vase
				candelabra
				musicBox
				candleSticks
				pearls
				cheetaurClaw
				trollBeard
				gold
				paper
				invPageDown
				invPageUp
				invLook
				invSelect
				invDrop
				invPickup
				invWeight
				ok
				invHelp
			eachElementDo: #highlightColor -1
			eachElementDo: #lowlightColor -1
			eachElementDo: #init
			state: 2048
		)
		(gEgo get: 4 get: 1 5 get: 38 4 get: 0 10)
		(dropInv init:)
	)
	
	(method (hide &tmp temp0)
		(super hide: &rest)
		(gGame setCursor: ((gMainIconBar curIcon?) cursor?) 1)
	)
	
	(method (noClickHelp)
		(super noClickHelp: &rest)
		(= curIcon invSelect)
		(gGame setCursor: (invSelect cursor?) 1)
	)
)

(instance dropInv of Inv
	(properties
		normalHeading 3819
		empty 3837
	)
	
	(method (init)
		(self
			window: invWin
			helpIconItem: invHelp
			okButton: ok
			add: invLook invPickup ok invHelp
			eachElementDo: #highlightColor -1
			eachElementDo: #lowlightColor -1
			eachElementDo: #init
			state: 2048
		)
	)
	
	(method (showSelf &tmp temp0)
		(= temp0 0)
		(while (< temp0 (- size 4))
			((self at: temp0) owner: gEgo)
			(++ temp0)
		)
		(super showSelf: &rest)
	)
	
	(method (show)
		(= curIcon invPickup)
		(super show: &rest)
	)
	
	(method (hide &tmp temp0)
		(if (== gDropInv self) (= gDropInv gloryInv))
		(= local1 0)
		(= temp0 0)
		(while (< temp0 (- size 4))
			(if ((self at: temp0) amount?)
				((self at: temp0) owner: gEgo)
			)
			(++ temp0)
		)
		(super hide: &rest)
		(gGame setCursor: ((gMainIconBar curIcon?) cursor?) 1)
	)
	
	(method (noClickHelp)
		(super noClickHelp: &rest)
		(= curIcon invPickup)
		(gGame setCursor: (invPickup cursor?) 1)
	)
)

(instance invWin of GloryWindow
	(properties
		yOffset 28
	)
)

(instance pageCode of Code
	(properties)
	
	(method (init &tmp temp0 temp1)
		(if (proc0_7 361)
			(proc0_6 361)
			(= temp0 0)
			(while (< temp0 (- (dropInv size?) 4))
				((dropInv at: temp0) owner: gEgo)
				(++ temp0)
			)
			((= gDropInv dropInv) okButton: ok showSelf:)
		else
			(if
				(or
					(proc999_5
						gModNum
						420
						425
						430
						435
						440
						445
						455
						450
						460
						465
						470
					)
					(== gModNum 32)
				)
				(return)
			)
			(invSelect message: -1)
			(= global423 0)
			(invPageUp owner: 0)
			(invPageDown owner: 0)
			(= temp0 0)
			(while (< temp0 40)
				((gDropInv at: temp0) owner: 0)
				(if
					(and
						(!= temp0 38)
						(or (> ((gDropInv at: temp0) amount?) 0) (== temp0 0))
						(< (++ global423) 24)
					)
					((gDropInv at: temp0) owner: gEgo)
				)
				(++ temp0)
			)
			(if (> global423 23)
				(invPageDown highlightColor: -1 owner: gEgo)
			)
			(gDropInv showSelf:)
		)
	)
)

(instance invPageDown of InvI
	(properties
		view 991
		loop 5
		message 75
		signal $0003
		noun 6
		modNum 206
		helpVerb 9
	)
	
	(method (show)
		(super show:)
		(DrawCel
			991
			7
			0
			(+ nsLeft (CelWide view loop cel))
			nsTop
			-1
		)
	)
	
	(method (select &tmp temp0)
		(return
			(if (super select: &rest)
				(= temp0 0)
				(while (< temp0 40)
					(if
						(and
							(!= temp0 38)
							(or (> ((gDropInv at: temp0) amount?) 0) (== temp0 0))
						)
						(if (== ((gDropInv at: temp0) owner?) gEgo)
							((gDropInv at: temp0) owner: 1)
						else
							((gDropInv at: temp0) owner: gEgo)
						)
					)
					(++ temp0)
				)
				(invPageUp owner: gEgo highlightColor: -1)
				(= owner 0)
				(gDropInv hide: showSelf:)
				(return 0)
			else
				0
			)
		)
	)
)

(instance invPageUp of InvI
	(properties
		view 991
		loop 5
		message 75
		signal $0003
		noun 6
		modNum 206
		helpVerb 9
	)
	
	(method (show)
		(super show:)
		(DrawCel
			991
			7
			0
			(+ nsLeft (CelWide view loop cel))
			nsTop
			-1
		)
	)
	
	(method (select &tmp temp0)
		(return
			(if (super select: &rest)
				(= temp0 0)
				(while (< temp0 40)
					(if
						(and
							(!= temp0 38)
							(or (> ((gDropInv at: temp0) amount?) 0) (== temp0 0))
						)
						(if (== ((gDropInv at: temp0) owner?) 1)
							((gDropInv at: temp0) owner: gEgo)
						else
							((gDropInv at: temp0) owner: 0)
						)
					)
					(++ temp0)
				)
				(gDropInv hide:)
				(= owner 0)
				(if (not local0)
					(invPageDown owner: gEgo highlightColor: -1)
					(= owner 0)
				)
				(= local0 0)
				(gDropInv showSelf:)
				(return 0)
			else
				0
			)
		)
	)
)

(instance invLook of IconI
	(properties
		view 991
		loop 2
		cel 0
		cursor 941
		message 1
		signal $0081
		noun 4
		modNum 206
		helpVerb 9
	)
)

(instance invSelect of IconI
	(properties
		view 991
		loop 0
		cel 0
		cursor 942
		message 4
		noun 8
		modNum 206
		helpVerb 9
	)
)

(instance invPickup of IconI
	(properties
		view 991
		loop 8
		cel 0
		cursor 938
		message 77
		noun 7
		modNum 206
		helpVerb 9
	)
	
	(method (select &tmp temp0 temp1)
		(return
			(if (super select: &rest)
				(= temp0 0)
				(= temp1 0)
				(while (< temp1 40)
					(if ((gloryInv at: temp1) amtDropped?) (= temp0 1))
					(++ temp1)
				)
				(if (= local1 temp0)
					(if (== gDropInv gloryInv)
						(proc0_5 361)
						(gDropInv hide:)
					)
					(return 1)
				else
					(Print addText: 3 0 0 20 0 0 206 init:)
					(return 0)
				)
			else
				0
			)
		)
	)
)

(instance invDrop of IconI
	(properties
		view 991
		loop 6
		cel 0
		cursor 939
		message 73
		noun 1
		modNum 206
		helpVerb 9
	)
)

(instance invWeight of IconI
	(properties
		view 991
		loop 4
		cel 0
		cursor 949
		message 9
		signal $0043
		noun 9
		modNum 206
		helpVerb 9
	)
	
	(method (select &tmp temp0 [temp1 60] [temp61 60])
		(return
			(if (super select: &rest)
				(= temp0 (proc814_28))
				(Message msgGET 206 9 0 0 1 @temp1)
				(Print
					font: gFont
					mode: 1
					addTextF: @temp61 @temp1 temp0 (if (== temp0 1) {} else {s})
					init: youOnlyLoveMeForMyCueMethod
				)
				(return 0)
			else
				0
			)
		)
	)
)

(instance invHelp of IconI
	(properties
		view 991
		loop 1
		cel 0
		cursor 949
		message 9
		noun 2
		modNum 206
		helpVerb 9
	)
	
	(method (show)
		(super show:)
		(DrawCel
			991
			7
			0
			(+ nsLeft (CelWide view loop cel))
			nsTop
			-1
		)
	)
)

(instance ok of IconI
	(properties
		view 991
		loop 3
		cel 0
		cursor 949
		message 9
		signal $0043
		noun 5
		modNum 206
		helpVerb 9
	)
)

(instance silver of QG1InvItem
	(properties
		message 10
		weight 1
	)
	
	(method (doVerb theVerb &tmp [temp0 40] [temp40 50] temp90 temp91)
		(if (== theVerb 9) (return 1))
		(Print font: gFont mode: 1)
		(return
			(switch theVerb
				(1
					(if local1
						(Message msgGET 206 3 0 0 21 @temp40)
						(Print
							addTextF: @temp0 @temp40 amtDropped (if (> amtDropped 1) {ות} else {})
							init:
						)
					else
						(= temp90 (= temp91 0))
						(= temp90
							(/ (= temp91 (/ (+ (gold amount?) amount) 6)) 10)
						)
						(if
						(and (not (= temp91 (mod temp91 10))) (not temp90))
							(= temp91 1)
						)
						(cond 
							((and amount (gold amount?))
								(Message msgGET 206 3 0 0 9 @temp40)
								(Print
									addTextF:
										@temp0
										@temp40
										(gold amount?)
										(if (> (gold amount?) 1) {ות} else {})
										amount
										(if (> amount 1) {ות} else {})
										temp90
										temp91
									init:
								)
							)
							(amount
								(Message msgGET 206 3 0 0 10 @temp40)
								(Print
									addTextF:
										@temp0
										@temp40
										amount
										(if (> amount 1) {ות} else {})
										temp90
										temp91
									init:
								)
							)
							((gold amount?)
								(Message msgGET 206 3 0 0 11 @temp40)
								(Print
									addTextF:
										@temp0
										@temp40
										(gold amount?)
										(if (> (gold amount?) 1) {ות} else {})
										temp90
										temp91
									init:
								)
							)
							(else
								(switch (Random 0 5)
									(0
										(Print addText: 3 0 0 12 0 0 206 init:)
									)
									(1
										(Print addText: 3 0 0 13 0 0 206 init:)
									)
									(else 
										(Print addText: 3 0 0 14 0 0 206 init:)
									)
								)
							)
						)
					)
				)
				(73
					(cond 
						((== gModNum 322) (Print addText: 3 0 0 6 0 0 206 init:))
						((> amount 10) (Print addText: 3 0 0 15 0 0 206 init:) (self dumpIt: 10))
						((> amount 1)
							(Print addText: 3 0 0 16 0 0 206 init:)
							(self dumpIt: (- amount 1))
						)
						(else (Print addText: 3 0 0 17 0 0 206 init:))
					)
				)
				(77
					(cond 
						((> amtDropped 10)
							(Print addText: 3 0 0 18 0 0 206 init:)
							(self pickItUp: 10)
						)
						((not amtDropped) (Print addText: 3 0 0 20 0 0 206 init:))
						(else
							(Print addText: 3 0 0 19 0 0 206 init:)
							(self pickItUp: amtDropped)
						)
					)
				)
				(9 0)
				(else  (super doVerb: theVerb))
			)
		)
	)
)

(instance gold of QG1InvItem
	(properties
		loop 6
		message 49
		weight 1
	)
)

(instance rations of QG1InvItem
	(properties
		cel 1
		message 11
		weight 20
	)
)

(instance sword of QG1InvItem
	(properties
		cel 4
		message 12
		weight 420
	)
)

(instance chainMail of QG1InvItem
	(properties
		loop 2
		cel 14
		message 13
		weight 2100
	)
)

(instance leather of QG1InvItem
	(properties
		cel 6
		message 14
		weight 1200
	)
)

(instance shield of QG1InvItem
	(properties
		cel 7
		message 15
		weight 720
	)
)

(instance dagger of QG1InvItem
	(properties
		cel 5
		message 16
		weight 120
	)
)

(instance lockPick of QG1InvItem
	(properties
		loop 2
		cel 4
		message 17
		weight 5
	)
)

(instance thiefKit of QG1InvItem
	(properties
		loop 2
		cel 5
		message 18
		weight 30
	)
)

(instance thiefLicense of QG1InvItem
	(properties
		loop 2
		cel 6
		message 19
		weight 2
	)
)

(instance rock of QG1InvItem
	(properties
		loop 2
		cel 2
		message 20
		weight 30
	)
)

(instance flask of QG1InvItem
	(properties
		loop 2
		cel 7
		message 21
		weight 10
	)
)

(instance healingPotion of QG1InvItem
	(properties
		loop 4
		message 22
		weight 40
	)
)

(instance manaPotion of QG1InvItem
	(properties
		loop 4
		cel 1
		message 23
		weight 40
	)
)

(instance staminaPotion of QG1InvItem
	(properties
		loop 4
		cel 2
		message 24
		weight 40
	)
)

(instance disenchant of QG1InvItem
	(properties
		loop 4
		cel 3
		message 25
		weight 40
	)
)

(instance brassKey of QG1InvItem
	(properties
		cel 3
		message 26
		weight 15
	)
)

(instance magicGem of QG1InvItem
	(properties
		cel 10
		message 27
		weight 6
	)
)

(instance ring of QG1InvItem
	(properties
		loop 2
		message 28
		weight 10
	)
)

(instance ghostOil of QG1InvItem
	(properties
		loop 4
		cel 4
		message 29
		weight 40
	)
)

(instance magicMirror of QG1InvItem
	(properties
		loop 4
		cel 5
		message 30
		weight 30
	)
)

(instance mandrake of QG1InvItem
	(properties
		cel 2
		message 31
		weight 30
	)
)

(instance fruit of QG1InvItem
	(properties
		cel 9
		message 32
		weight 15
	)
)

(instance vegetables of QG1InvItem
	(properties
		loop 2
		cel 15
		message 33
		weight 30
	)
)

(instance acorn of QG1InvItem
	(properties
		loop 4
		cel 6
		message 34
		weight 3
	)
)

(instance seed of QG1InvItem
	(properties
		loop 2
		cel 1
		message 35
		weight 60
	)
)

(instance flowers of QG1InvItem
	(properties
		loop 2
		cel 3
		message 36
		weight 1
	)
)

(instance greenFur of QG1InvItem
	(properties
		loop 2
		cel 8
		message 37
		weight 3
	)
)

(instance fairyDust of QG1InvItem
	(properties
		loop 2
		cel 9
		message 38
		weight 10
	)
)

(instance flyingWater of QG1InvItem
	(properties
		loop 2
		cel 10
		message 39
		weight 40
	)
)

(instance mushroom of QG1InvItem
	(properties
		loop 2
		cel 11
		message 40
		weight 10
	)
)

(instance vase of QG1InvItem
	(properties
		cel 11
		message 41
		weight 30
	)
)

(instance candelabra of QG1InvItem
	(properties
		cel 12
		message 42
		weight 180
	)
)

(instance musicBox of QG1InvItem
	(properties
		cel 13
		message 43
		weight 45
	)
)

(instance candleSticks of QG1InvItem
	(properties
		cel 14
		message 44
		weight 60
	)
)

(instance pearls of QG1InvItem
	(properties
		cel 15
		message 45
		weight 30
	)
)

(instance cheetaurClaw of QG1InvItem
	(properties
		loop 2
		cel 12
		message 46
		weight 20
	)
)

(instance trollBeard of QG1InvItem
	(properties
		loop 2
		cel 13
		message 47
		weight 60
	)
)

(instance paper of QG1InvItem
	(properties
		cel 8
		message 53
		weight 1
	)
)

(instance invCursor of Cursor
	(properties
		view 950
	)
)

(instance youOnlyLoveMeForMyCueMethod of Script
	(properties)
	
	(method (cue &tmp temp0 [temp1 60] [temp61 60])
		(= temp0 (proc814_23))
		(Message msgGET 206 9 0 0 2 @temp1)
		(Print
			font: gFont
			mode: 1
			addTextF: @temp61 @temp1 temp0 (if (== temp0 1) {} else {s})
			init:
		)
	)
)
