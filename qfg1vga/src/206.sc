;;; Sierra Script 1.0 - (do not remove this comment)
;;; scc 0.1.0 (qfg1vga) - decompiled from 206.scr, 206.hep on 2026-08-04
;;; Verified: recompiling this file reproduces the original bytes,
;;; exactly. Edits are safe to recompile; the guarantee is the round
;;; trip, not the formatting.
;;; All 22 functions recovered as Sierra Script.
(script# 206)
(include scc.sh)

(public
	gloryInv 0
	pageCode 1
	dropInv 2
)

(local
	local0
	local1
)

(class QG1InvItem
	(properties)

	(method (select)
		(if (super select: &rest)
			((= cursor invCursor)
				view: 960
				loop: loop
				cel: cel
			)
		)
	)

	(method (dumpIt param1 &tmp temp0)
		(= temp0 (if (> param1 amount) amount else param1 ))
		(= amtDropped (+ amtDropped temp0))
		(global0 use: (gloryInv indexOf: self) temp0)
		(if (not amount)
			(= owner 0)
		)
		(dropInv addToFront: self)
	)

	(method (pickItUp param1 &tmp temp0 temp1 temp2)
		(= temp0 (if (> param1 amtDropped) amtDropped else param1 ))
		(= amtDropped (- amtDropped temp0))
		(global0 get: (gloryInv indexOf: self) temp0)
		(if (not amtDropped)
			(dropInv
				hide:
				delete: self
			)
			(if (> (dropInv size:) 4)
				(= local1 1)
				((= global9 dropInv) showSelf:)
			else
				((= global9 gloryInv) showSelf:)
			)
		)
	)

	(method (doVerb param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21 temp22 temp23 temp24 temp25 temp26 temp27 temp28 temp29 temp30 temp31 temp32 temp33 temp34 temp35 temp36 temp37 temp38 temp39 temp40 temp41 temp42 temp43 temp44 temp45 temp46 temp47 temp48 temp49 temp50 temp51 temp52 temp53 temp54 temp55 temp56 temp57 temp58 temp59 temp60 temp61 temp62 temp63 temp64 temp65 temp66 temp67 temp68 temp69 temp70 temp71 temp72 temp73 temp74 temp75 temp76 temp77 temp78 temp79 temp80 temp81 temp82 temp83 temp84 temp85 temp86 temp87 temp88 temp89 temp90 temp91 temp92 temp93 temp94 temp95 temp96 temp97 temp98 temp99 temp100 temp101 temp102 temp103 temp104 temp105 temp106 temp107 temp108 temp109 temp110 temp111 temp112)
		(if (== param1 9)
			(return 1)
		)
		(Unknown_Class_20
			font: global22
			mode: 1
		)
		;Z Choose the Hebrew item-name variant by amount: singular/plural.
		(Message msgGET 206 3 (self message:) (if (> (self amount:) 1) 1 else 0 ) 1 @temp93)
		(switch param1
			(1
				(if local1
					(if (== amtDropped 1)
						(Message msgGET 206 3 0 0 22 @temp53)
						;Z Use the Hebrew singular article form.
						(Message msgGET 206 3 (self message:) 2 1 @temp93)
						(Unknown_Class_20
							addTextF: @temp3 @temp53 @temp93
							init:
						)
					else
						(Message msgGET 206 3 0 0 23 @temp53)
						;Z Use the Hebrew plural article form.
						(Message msgGET 206 3 (self message:) 3 1 @temp93)
						(Unknown_Class_20
							addTextF: @temp3 @temp53 amtDropped @temp93
							init:
						)
					)
				else
					(= temp2 0)
					(= temp1 temp2)
					(= temp1 (/ weight 60))
					(= temp2 (/ (mod weight 60) 6))
					(if (and (not temp2) (not temp1))
						(= temp2 1)
					)
					(if (> (self amount:) 1)
						(Message msgGET 206 3 0 0 1 @temp53)
					else
						(Message msgGET 206 3 0 0 2 @temp53)
					)
					(Unknown_Class_20
						addTextF: @temp3 @temp53 amount @temp93 temp1 temp2
						init:
					)
				)
			)
			(73
				(if (and (== self dagger) (== (self amount:) 1) (not (global0 has: 2)))
					(Unknown_Class_20
						addText: 3 0 0 4 0 0 206
						init:
					)
				else
					(if (proc999_5 self sword shield disenchant thiefKit magicGem ring brassKey magicMirror seed acorn fairyDust greenFur)
						(Message msgGET 206 3 0 0 5 @temp53)
						;Z Use the Hebrew singular article form.
						(Message msgGET 206 3 (self message:) 2 1 @temp93)
						(Unknown_Class_20
							addTextF: @temp3 @temp53 @temp93
							init:
						)
					else
						(if (== global11 322)
							(Unknown_Class_20
								addText: 3 0 0 6 0 0 206
								init:
							)
						else
							(if (> amount 1)
								(self dumpIt: 1)
								(Message msgGET 206 3 0 0 7 @temp53)
								;Z Use the non-article singular form after dropping one item.
								(Message msgGET 206 3 (self message:) 0 1 @temp93)
								(Unknown_Class_20
									addTextF: @temp3 @temp53 @temp93
									init:
								)
							else
								(Message msgGET 206 3 0 0 8 @temp53)
								;Z Use the Hebrew singular article form.
								(Message msgGET 206 3 (self message:) 2 1 @temp93)
								(Unknown_Class_20
									addTextF: @temp3 @temp53 @temp93
									init:
								)
								(self dumpIt: 1)
								(if (== (global69 curInvIcon:) self)
									(global69 curInvIcon: 0)
								)
								(= temp0 0)
								(while (< temp0 40)
									(if (== ((global9 at: temp0) owner:) global0)
										(= temp0 41)
									)
									(++ temp0)
								)
								(global9 hide:)
								(if (> temp0 40)
									(global9
										curIcon: invDrop
										show:
									)
								else
									(= local0 1)
									(invPageUp select:)
								)
							)
						)
					)
				)
			)
			(77
				(if (not amtDropped)
					(Unknown_Class_20
						addText: 3 0 0 20 0 0 206
						init:
					)
				else
					(if (== amtDropped 1)
						;Z Use the Hebrew singular article form.
						(Message msgGET 206 3 (self message:) 2 1 @temp93)
						(Message msgGET 206 3 0 0 25 @temp53)
					else
						;Z Use the Hebrew plural article form.
						(Message msgGET 206 3 (self message:) 3 1 @temp93)
						(Message msgGET 206 3 0 0 24 @temp53)
					)
					(Unknown_Class_20
						addTextF: @temp3 @temp53 @temp93
						init:
					)
					(self pickItUp: 1)
				)
			)
			(9
				0
			)
			(else
				(Message msgGET 206 3 0 0 3 @temp53)
				(Message msgGET 206 3 param1 0 1 @temp83)
				;Z Use the Hebrew singular article form for the item name.
				(Message msgGET 206 3 (self message:) 2 1 @temp93)
				(Unknown_Class_20
					addTextF: @temp3 @temp53 @temp83 @temp93
					init:
				)
			)
		)
	)
)

(instance gloryInv of gloryInv_binding
	(properties)

	(method (init)
		((= global9 self)
			window: invWin
			helpIconItem: invHelp
			selectIcon: invSelect
			okButton: ok
			add: silver rations sword chainMail leather shield dagger lockPick thiefKit thiefLicense rock flask healingPotion manaPotion staminaPotion disenchant brassKey magicGem ring ghostOil magicMirror mandrake fruit vegetables acorn seed flowers greenFur fairyDust flyingWater mushroom vase candelabra musicBox candleSticks pearls cheetaurClaw trollBeard gold paper invPageDown invPageUp invLook invSelect invDrop invPickup invWeight ok invHelp
			eachElementDo: 211 -1
			eachElementDo: 212 -1
			eachElementDo: 110
			state: 2048
		)
		(global0
			get: 4
			get: 1 5
			get: 38 4
			get: 0 10
		)
		(dropInv init:)
	)

	(method (noClickHelp)
		(super noClickHelp: &rest)
		(= lsLeft invSelect)
		(global1 setCursor: (invSelect cursor:) 1)
	)

	(method (hide &tmp temp0)
		(super hide: &rest)
		(global1 setCursor: ((global69 curIcon:) cursor:) 1)
	)
)

(instance dropInv of dropInv_binding
	(properties)

	(method (hide &tmp temp0)
		(if (== global9 self)
			(= global9 gloryInv)
		)
		(= local1 0)
		(= temp0 0)
		(while (< temp0 (- nsTop 4))
			(if ((self at: temp0) amount:)
				((self at: temp0) owner: global0)
			)
			(++ temp0)
		)
		(super hide: &rest)
		(global1 setCursor: ((global69 curIcon:) cursor:) 1)
	)

	(method (showSelf &tmp temp0)
		(= temp0 0)
		(while (< temp0 (- nsTop 4))
			((self at: temp0) owner: global0)
			(++ temp0)
		)
		(super showSelf: &rest)
	)

	(method (show)
		(= lsLeft invPickup)
		(super show: &rest)
	)

	(method (noClickHelp)
		(super noClickHelp: &rest)
		(= lsLeft invPickup)
		(global1 setCursor: (invPickup cursor:) 1)
	)

	(method (init)
		(self
			window: invWin
			helpIconItem: invHelp
			okButton: ok
			add: invLook invPickup ok invHelp
			eachElementDo: 211 -1
			eachElementDo: 212 -1
			eachElementDo: 110
			state: 2048
		)
	)
)

(instance invWin of invWin_binding
	(properties)
)

(instance pageCode of pageCode_binding
	(properties)

	(method (init &tmp temp0 temp1)
		(if (proc0_7 361)
			(proc0_6 361)
			(= temp0 0)
			(while (< temp0 (- (dropInv size:) 4))
				((dropInv at: temp0) owner: global0)
				(++ temp0)
			)
			((= global9 dropInv)
				okButton: ok
				showSelf:
			)
		else
			(if (or (proc999_5 global11 420 425 430 435 440 445 455 450 460 465 470) (== global11 32))
				(return)
			)
			(invSelect message: -1)
			(= global423 0)
			(invPageUp owner: 0)
			(invPageDown owner: 0)
			(= temp0 0)
			(while (< temp0 40)
				((global9 at: temp0) owner: 0)
				(if (!= temp0 38)
					(if (and (or (> ((global9 at: temp0) amount:) 0) (== temp0 0)) (< (++ global423) 24))
						((global9 at: temp0) owner: global0)
					)
				)
				(++ temp0)
			)
			(if (> global423 23)
				(invPageDown
					highlightColor: -1
					owner: global0
				)
			)
			(global9 showSelf:)
		)
	)
)

(instance invPageDown of invPageDown_binding
	(properties)

	(method (show)
		(super show:)
		(DrawCel 991 7 0 (+ nsBottom (CelWide underBits nsTop nsLeft)) nsRight -1)
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(= temp0 0)
			(while (< temp0 40)
				(if (!= temp0 38)
					(if (or (> ((global9 at: temp0) amount:) 0) (== temp0 0))
						(if (== ((global9 at: temp0) owner:) global0)
							((global9 at: temp0) owner: 1)
						else
							((global9 at: temp0) owner: global0)
						)
					)
				)
				(++ temp0)
			)
			(invPageUp
				owner: global0
				highlightColor: -1
			)
			(= back 0)
			(global9
				hide:
				showSelf:
			)
			(return 0)
		)
	)
)

(instance invPageUp of invPageUp_binding
	(properties)

	(method (show)
		(super show:)
		(DrawCel 991 7 0 (+ nsBottom (CelWide underBits nsTop nsLeft)) nsRight -1)
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(= temp0 0)
			(while (< temp0 40)
				(if (!= temp0 38)
					(if (or (> ((global9 at: temp0) amount:) 0) (== temp0 0))
						(if (== ((global9 at: temp0) owner:) 1)
							((global9 at: temp0) owner: global0)
						else
							((global9 at: temp0) owner: 0)
						)
					)
				)
				(++ temp0)
			)
			(global9 hide:)
			(= back 0)
			(if (not local0)
				(invPageDown
					owner: global0
					highlightColor: -1
				)
				(= back 0)
			)
			(= local0 0)
			(global9 showSelf:)
			(return 0)
		)
	)
)

(instance invLook of invLook_binding
	(properties)
)

(instance invSelect of invSelect_binding
	(properties)
)

(instance invPickup of invPickup_binding
	(properties)

	(method (select &tmp temp0 temp1)
		(if (super select: &rest)
			(= temp0 0)
			(= temp1 0)
			(while (< temp1 40)
				(if ((gloryInv at: temp1) amtDropped:)
					(= temp0 1)
				)
				(++ temp1)
			)
			(if (= local1 temp0)
				(if (== global9 gloryInv)
					(proc0_5 361)
					(global9 hide:)
				)
				(return 1)
			else
				(Unknown_Class_20
					addText: 3 0 0 20 0 0 206
					init:
				)
				(return 0)
			)
		)
	)
)

(instance invDrop of invDrop_binding
	(properties)
)

(instance invWeight of invWeight_binding
	(properties)

	(method (select &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21 temp22 temp23 temp24 temp25 temp26 temp27 temp28 temp29 temp30 temp31 temp32 temp33 temp34 temp35 temp36 temp37 temp38 temp39 temp40 temp41 temp42 temp43 temp44 temp45 temp46 temp47 temp48 temp49 temp50 temp51 temp52 temp53 temp54 temp55 temp56 temp57 temp58 temp59 temp60 temp61 temp62 temp63 temp64 temp65 temp66 temp67 temp68 temp69 temp70 temp71 temp72 temp73 temp74 temp75 temp76 temp77 temp78 temp79 temp80 temp81 temp82 temp83 temp84 temp85 temp86 temp87 temp88 temp89 temp90 temp91 temp92 temp93 temp94 temp95 temp96 temp97 temp98 temp99 temp100 temp101 temp102 temp103 temp104 temp105 temp106 temp107 temp108 temp109 temp110 temp111 temp112 temp113 temp114 temp115 temp116 temp117 temp118 temp119 temp120)
		(if (super select: &rest)
			(= temp0 (proc814_28))
			(Message msgGET 206 9 0 0 1 @temp1)
			(Unknown_Class_20
				font: global22
				mode: 1
				addTextF: @temp61 @temp1 temp0 (if (== temp0 1) "" else "s" )
				init: youOnlyLoveMeForMyCueMethod
			)
			(return 0)
		)
	)
)

(instance invHelp of invHelp_binding
	(properties)

	(method (show)
		(super show:)
		(DrawCel 991 7 0 (+ nsBottom (CelWide underBits nsTop nsLeft)) nsRight -1)
	)
)

(instance ok of ok_binding
	(properties)
)

(instance silver of QG1InvItem
	(properties)

	(method (doVerb param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21 temp22 temp23 temp24 temp25 temp26 temp27 temp28 temp29 temp30 temp31 temp32 temp33 temp34 temp35 temp36 temp37 temp38 temp39 temp40 temp41 temp42 temp43 temp44 temp45 temp46 temp47 temp48 temp49 temp50 temp51 temp52 temp53 temp54 temp55 temp56 temp57 temp58 temp59 temp60 temp61 temp62 temp63 temp64 temp65 temp66 temp67 temp68 temp69 temp70 temp71 temp72 temp73 temp74 temp75 temp76 temp77 temp78 temp79 temp80 temp81 temp82 temp83 temp84 temp85 temp86 temp87 temp88 temp89 temp90 temp91)
		(if (== param1 9)
			(return 1)
		)
		(Unknown_Class_20
			font: global22
			mode: 1
		)
		(switch param1
			(1
				(if local1
					(Message msgGET 206 3 0 0 21 @temp40)
					(Unknown_Class_20
						;Z Hebrew plural suffix for coins.
						addTextF: @temp0 @temp40 amtDropped (if (> amtDropped 1) {ות} else {})
						init:
					)
				else
					(= temp91 0)
					(= temp90 temp91)
					(= temp91 (/ (+ (gold amount:) amount) 6))
					(= temp90 (/ temp91 10))
					(= temp91 (mod temp91 10))
					(if (and (not temp91) (not temp90))
						(= temp91 1)
					)
					(if (and amount (gold amount:))
						(Message msgGET 206 3 0 0 9 @temp40)
						(Unknown_Class_20
							;Z Hebrew plural suffix for coins.
							addTextF: @temp0 @temp40 (gold amount:) (if (> (gold amount:) 1) {ות} else {}) amount (if (> amount 1) {ות} else {}) temp90 temp91
							init:
						)
					else
						(if amount
							(Message msgGET 206 3 0 0 10 @temp40)
							(Unknown_Class_20
								;Z Hebrew plural suffix for coins.
								addTextF: @temp0 @temp40 amount (if (> amount 1) {ות} else {}) temp90 temp91
								init:
							)
						else
							(if (gold amount:)
								(Message msgGET 206 3 0 0 11 @temp40)
								(Unknown_Class_20
									;Z Hebrew plural suffix for coins.
									addTextF: @temp0 @temp40 (gold amount:) (if (> (gold amount:) 1) {ות} else {}) temp90 temp91
									init:
								)
							else
								(switch (Random 0 5)
									(0
										(Unknown_Class_20
											addText: 3 0 0 12 0 0 206
											init:
										)
									)
									(1
										(Unknown_Class_20
											addText: 3 0 0 13 0 0 206
											init:
										)
									)
									(else
										(Unknown_Class_20
											addText: 3 0 0 14 0 0 206
											init:
										)
									)
								)
							)
						)
					)
				)
			)
			(73
				(if (== global11 322)
					(Unknown_Class_20
						addText: 3 0 0 6 0 0 206
						init:
					)
				else
					(if (> amount 10)
						(Unknown_Class_20
							addText: 3 0 0 15 0 0 206
							init:
						)
						(self dumpIt: 10)
					else
						(if (> amount 1)
							(Unknown_Class_20
								addText: 3 0 0 16 0 0 206
								init:
							)
							(self dumpIt: (- amount 1))
						else
							(Unknown_Class_20
								addText: 3 0 0 17 0 0 206
								init:
							)
						)
					)
				)
			)
			(77
				(if (> amtDropped 10)
					(Unknown_Class_20
						addText: 3 0 0 18 0 0 206
						init:
					)
					(self pickItUp: 10)
				else
					(if (not amtDropped)
						(Unknown_Class_20
							addText: 3 0 0 20 0 0 206
							init:
						)
					else
						(Unknown_Class_20
							addText: 3 0 0 19 0 0 206
							init:
						)
						(self pickItUp: amtDropped)
					)
				)
			)
			(9
				0
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance gold of QG1InvItem
	(properties)
)

(instance rations of QG1InvItem
	(properties)
)

(instance sword of QG1InvItem
	(properties)
)

(instance chainMail of QG1InvItem
	(properties)
)

(instance leather of QG1InvItem
	(properties)
)

(instance shield of QG1InvItem
	(properties)
)

(instance dagger of QG1InvItem
	(properties)
)

(instance lockPick of QG1InvItem
	(properties)
)

(instance thiefKit of QG1InvItem
	(properties)
)

(instance thiefLicense of QG1InvItem
	(properties)
)

(instance rock of QG1InvItem
	(properties)
)

(instance flask of QG1InvItem
	(properties)
)

(instance healingPotion of QG1InvItem
	(properties)
)

(instance manaPotion of QG1InvItem
	(properties)
)

(instance staminaPotion of QG1InvItem
	(properties)
)

(instance disenchant of QG1InvItem
	(properties)
)

(instance brassKey of QG1InvItem
	(properties)
)

(instance magicGem of QG1InvItem
	(properties)
)

(instance ring of QG1InvItem
	(properties)
)

(instance ghostOil of QG1InvItem
	(properties)
)

(instance magicMirror of QG1InvItem
	(properties)
)

(instance mandrake of QG1InvItem
	(properties)
)

(instance fruit of QG1InvItem
	(properties)
)

(instance vegetables of QG1InvItem
	(properties)
)

(instance acorn of QG1InvItem
	(properties)
)

(instance seed of QG1InvItem
	(properties)
)

(instance flowers of QG1InvItem
	(properties)
)

(instance greenFur of QG1InvItem
	(properties)
)

(instance fairyDust of QG1InvItem
	(properties)
)

(instance flyingWater of QG1InvItem
	(properties)
)

(instance mushroom of QG1InvItem
	(properties)
)

(instance vase of QG1InvItem
	(properties)
)

(instance candelabra of QG1InvItem
	(properties)
)

(instance musicBox of QG1InvItem
	(properties)
)

(instance candleSticks of QG1InvItem
	(properties)
)

(instance pearls of QG1InvItem
	(properties)
)

(instance cheetaurClaw of QG1InvItem
	(properties)
)

(instance trollBeard of QG1InvItem
	(properties)
)

(instance paper of QG1InvItem
	(properties)
)

(instance invCursor of invCursor_binding
	(properties)
)

(instance youOnlyLoveMeForMyCueMethod of youOnlyLoveMeForMyCueMethod_binding
	(properties)

	(method (cue &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21 temp22 temp23 temp24 temp25 temp26 temp27 temp28 temp29 temp30 temp31 temp32 temp33 temp34 temp35 temp36 temp37 temp38 temp39 temp40 temp41 temp42 temp43 temp44 temp45 temp46 temp47 temp48 temp49 temp50 temp51 temp52 temp53 temp54 temp55 temp56 temp57 temp58 temp59 temp60 temp61 temp62 temp63 temp64 temp65 temp66 temp67 temp68 temp69 temp70 temp71 temp72 temp73 temp74 temp75 temp76 temp77 temp78 temp79 temp80 temp81 temp82 temp83 temp84 temp85 temp86 temp87 temp88 temp89 temp90 temp91 temp92 temp93 temp94 temp95 temp96 temp97 temp98 temp99 temp100 temp101 temp102 temp103 temp104 temp105 temp106 temp107 temp108 temp109 temp110 temp111 temp112 temp113 temp114 temp115 temp116 temp117 temp118 temp119 temp120)
		(= temp0 (proc814_23))
		(Message msgGET 206 9 0 0 2 @temp1)
		(Unknown_Class_20
			font: global22
			mode: 1
			addTextF: @temp61 @temp1 temp0 (if (== temp0 1) "" else "s" )
			init:
		)
	)
)
