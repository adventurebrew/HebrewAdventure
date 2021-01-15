;;; Sierra Script 1.0 - (do not remove this comment)
(script# 203)
(include sci.sh)
(use Main)
(use n814)
(use Print)
(use IconI)
(use GameControls)
(use Game)
(use View)
(use Obj)

(public
	chAlloc 0
)

(local
	[local0 14] = [999 0 1 2 3 4 12 5 6 7 8 9 10 11]
	[local14 14] = [28 40 52 64 76 88 100 40 52 64 76 88 100 112]
	[local28 14] = [100 100 100 100 100 100 100 204 204 204 204 204 204 204]
	[local42 14] = [0 1 2 3 4 5 6 7 9 10 1 9 11 12]
	[theTheGStrength 49] = [0 25 10 15 15 10 0 20 15 10 0 0 10 0 0 10 25 15 15 10 25 10 0 15 0 0 0 0 0 10 15 25 10 10 0 10 0 5 10 10 5 5 67 78 68 20 23 27 1]
	local105
	local106 =  50
	[theGStrength 14]
	[theTheTheGStrength 14]
	local135
)
(procedure (localproc_095b param1)
	(Display
		&rest
		100
		220
		param1
		102
		215
		106
		30
		101
		1
		105
		123
	)
	(Display &rest 100 219 param1 102 91 106 30 101 1 105 123)
)

(procedure (localproc_0997 &tmp [temp0 4] temp4)
	(= temp4 1)
	(while (< temp4 14)
		(= [gStrength [local0 temp4]] [theGStrength temp4])
		(++ temp4)
	)
	(DrawCel 802 8 1 215 142 15)
	(Format @temp0 {%d} local106)
	(if local106
		(Display @temp0 100 220 141 102 215 106 30 101 1 105 123)
		(Display @temp0 100 219 141 102 50 106 30 101 1 105 123)
	else
		(localproc_095b 141 @temp0)
	)
	(DrawCel 802 8 1 215 154 15)
	(localproc_095b
		153
		(Format
			@temp0
			{%d}
			(= [gStrength 14] (/ (+ (proc814_21) 1) 2))
		)
	)
	(DrawCel 802 8 1 215 166 15)
	(localproc_095b
		165
		(Format
			@temp0
			{%d}
			(= [gStrength 15] (/ (+ (proc814_20) 3) 4))
		)
	)
	(DrawCel 802 8 1 215 178 15)
	(localproc_095b
		177
		(Format @temp0 {%d} (= [gStrength 16] (proc814_22)))
	)
)

(instance chAlloc of Rm
	(properties
		picture 904
	)
	
	(method (init)
		(super init: &rest)
		(pointsAvail init:)
		(= global428 0)
		(self setScript: selectChar)
	)
	
	(method (dispose &tmp temp0)
		(startControls eachElementDo: #dispose dispose: release:)
		(= [gStrength 14] (proc814_21))
		(= [gStrength 15] (proc814_20))
		(= [gStrength 16] (proc814_22))
		(= temp0 0)
		(while (< temp0 25)
			(= [gGStrength_2 temp0] [gStrength temp0])
			(++ temp0)
		)
		(= global424 global15)
		(super dispose:)
	)
)

(instance selectChar of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMainIconBar disable:)
				(= cycles 2)
			)
			(1
				(theChar cel: gCel init:)
				(global2 drawPic: (global2 picture?) 9)
				(= ticks 60)
			)
			(2
				(startControls init: show:)
				(gMainIconBar enable:)
				(self dispose:)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(pEvent claimed: 1)
	)
)

(instance startControls of GameControls
	(properties)
	
	(method (init &tmp temp0)
		(self add: namePlate)
		(= temp0 1)
		(while (< temp0 14)
			(self
				add:
					((selectionIcon new:)
						nsLeft: [local28 temp0]
						nsTop: [local14 temp0]
						cel: [local42 temp0]
						maskCel: [local42 temp0]
						state: temp0
						yourself:
					)
			)
			(= [theTheTheGStrength temp0]
				[theTheGStrength (+ temp0 (* gCel 14))]
			)
			(= [theGStrength temp0]
				[theTheGStrength (+ temp0 (* gCel 14))]
			)
			(++ temp0)
		)
		(self
			add:
				(startIcon theObj: startCode selector: 57 yourself:)
				(cancelIcon theObj: cancelCode selector: 57 yourself:)
		)
		(super init: &rest)
	)
	
	(method (show)
		(= state (| state $0020))
		(self eachElementDo: #show)
		((= curIcon (= highlightedIcon (self at: 0)))
			highlight: 1
		)
		(DrawCel 802 5 0 1 148 15)
		(localproc_0997)
		(proc0_6 359)
		(gGame
			setCursor: 999 1 (+ (curIcon nsLeft?) 5) (- (curIcon nsBottom?) 2)
		)
		(self doit: hide:)
	)
	
	(method (dispatchEvent pEvent &tmp pEventX pEventY pEventType pEventMessage temp4 pEventModifiers temp6 highlightedIconState)
		(if local135
			(global2 newRoom: local135)
			(pEvent dispose:)
			(return 1)
		)
		(= pEventX (pEvent x?))
		(= pEventY (pEvent y?))
		(= pEventType (pEvent type?))
		(= pEventMessage (pEvent message?))
		(= temp4 0)
		(= pEventModifiers (pEvent modifiers?))
		(= temp6 (self firstTrue: #onMe pEvent))
		(pEvent dispose:)
		(cond 
			((& pEventType evJOYSTICK)
				(switch pEventMessage
					(JOY_RIGHT
						(if (and highlightedIcon (highlightedIcon state?))
							(self select: temp6 1)
							(gLongSong2 number: 63 loop: 1 play:)
						)
					)
					(JOY_LEFT
						(if (and highlightedIcon (highlightedIcon state?))
							(self select: temp6 0)
							(gLongSong2 number: 63 loop: 1 play:)
						)
					)
					(JOY_UP
						(if (not highlightedIcon)
							(= highlightedIcon (self at: (- size 1)))
						)
						(self retreat:)
					)
					(JOY_DOWN
						(if (not highlightedIcon)
							(= highlightedIcon (self at: 0))
						)
						(self advance:)
					)
					(JOY_UPRIGHT
						(if (temp6 state?)
							(self select: temp6 3)
							(gLongSong2 number: 63 loop: 1 play:)
						)
					)
					(JOY_DOWNRIGHT
						(if (temp6 state?)
							(self select: temp6 2)
							(gLongSong2 number: 63 loop: 1 play:)
						)
					)
				)
			)
			((== pEventType evNULL)
				(cond 
					((not (IsObject temp6))
						(if (IsObject highlightedIcon)
							(highlightedIcon highlight: 0)
							(= highlightedIcon 0)
						)
					)
					((and temp6 (!= temp6 highlightedIcon)) (= oldMouseY 0) (self highlight: temp6))
				)
			)
			((not (IsObject highlightedIcon)) 0)
			((== pEventType evMOUSEBUTTON)
				(cond 
					((== highlightedIcon namePlate) 0)
					((not (temp6 state?))
						(cond 
							((== temp6 startIcon) (startCode doit:))
							((== temp6 cancelIcon) (cancelCode doit:))
							(else (self select: temp6 1))
						)
					)
					((== pEventModifiers emSHIFT)
						(self select: temp6 1)
						(gLongSong2 number: 63 loop: 1 play:)
					)
					(else
						(self select: temp6 0)
						(gLongSong2 number: 63 loop: 1 play:)
					)
				)
			)
			((== pEventType evKEYBOARD)
				(switch pEventMessage
					(KEY_ESCAPE (cancelCode doit:))
					(KEY_RETURN
						(cond 
							((== highlightedIcon startIcon) (startCode doit:))
							((== highlightedIcon cancelIcon) (cancelCode doit:))
						)
					)
					(KEY_TAB
						(cond 
							(
							(< (= highlightedIconState (highlightedIcon state?)) 1) 0)
							(
							(< (= highlightedIconState (highlightedIcon state?)) 7)
								(highlightedIcon highlight: 0)
								(= highlightedIcon
									(self at: (+ highlightedIconState 5))
								)
								(self advance:)
							)
							((< highlightedIconState 13)
								(highlightedIcon highlight: 0)
								(= highlightedIcon
									(self at: (- highlightedIconState 5))
								)
								(self retreat:)
							)
						)
					)
					(else 
						(cond 
							((!= highlightedIcon namePlate) 0)
							(
								(or
									(and (<= KEY_a pEventMessage) (<= pEventMessage KEY_z))
									(and (<= KEY_A pEventMessage) (<= pEventMessage KEY_Z))
									(and (<= KEY_0 pEventMessage) (<= pEventMessage KEY_9))
									(and (<= 224 pEventMessage) (<= pEventMessage 250))			;Z aleph - tav
								)
								(self select: namePlate pEventMessage)
							)
							((== pEventMessage KEY_SPACE) (self select: namePlate pEventMessage))
							((and (== pEventMessage JOY_UPLEFT) local105) (self select: namePlate pEventMessage))
						)
					)
				)
			)
		)
		(return temp4)
	)
)

(instance selectionIcon of IconI
	(properties
		view 802
		loop 1
		maskView 802
		maskLoop 2
		highlightColor 9
		lowlightColor 91
	)
	
	(method (show)
		(self highlight: 0)
		(= nsRight (+ nsLeft (if (< state 7) 102 else 111)))
		(= nsBottom (+ nsTop 12))
	)
	
	(method (select param1)
		(return
			(if (super select: &rest)
				(switch param1
					(1
						(cond 
							((not local106) 0)
							((< local106 5)
								(= [theGStrength state]
									(+ [theGStrength state] local106)
								)
								(= local106 0)
							)
							((not [theGStrength state])
								(if (>= local106 15)
									(= [theGStrength state] (+ [theGStrength state] 5))
									(= local106 (- local106 15))
								)
							)
							(else
								(= [theGStrength state] (+ [theGStrength state] 5))
								(= local106 (- local106 5))
							)
						)
					)
					(0
						(cond 
							(
							(== [theGStrength state] [theTheTheGStrength state]) 0)
							(
								(and
									(== [theGStrength state] 5)
									(not [theTheTheGStrength state])
								)
								(= [theGStrength state] 0)
								(= local106 (+ local106 15))
							)
							(else
								(= [theGStrength state] (- [theGStrength state] 5))
								(= local106 (+ local106 5))
							)
						)
					)
					(3
						(cond 
							((not local106) 0)
							((not [theGStrength state]) 0)
							(else
								(= [theGStrength state] (+ [theGStrength state] 1))
								(= local106 (- local106 1))
							)
						)
					)
					(2
						(cond 
							(
							(== [theGStrength state] [theTheTheGStrength state]) 0)
							(
								(and
									(== [theGStrength state] 5)
									(not [theTheTheGStrength state])
								)
								(= [theGStrength state] 0)
								(= local106 (+ local106 15))
							)
							(else
								(= [theGStrength state] (- [theGStrength state] 1))
								(= local106 (+ local106 1))
							)
						)
					)
				)
				(self highlight: 1)
				(localproc_0997)
				(return 1)
			else
				(return 0)
			)
		)
	)
	
	(method (highlight param1 &tmp temp0 [temp1 4] temp5 temp6)
		(= temp0
			(if (< state 7) (+ nsLeft 71) else (+ nsLeft 80))
		)
		(DrawCel
			view
			8
			(if (< state 7) 0 else 1)
			temp0
			(+ nsTop 1)
			15
		)
		(if param1
			(DrawCel view loop cel nsLeft nsTop 15)
			(= temp5 50)
			(= temp6 215)
		else
			(DrawCel maskView maskLoop maskCel nsLeft nsTop 15)
			(= temp5 91)
			(= temp6 215)
		)
		(Display
			(Format @temp1 {%d} [theGStrength state])
			100
			(+ temp0 1)
			nsTop
			102
			temp6
			106
			25
			101
			-1
			105
			123
		)
		(Display
			(Format @temp1 {%d} [theGStrength state])
			100
			temp0
			nsTop
			102
			temp5
			106
			25
			101
			-1
			105
			123
		)
	)
)

(instance startIcon of ControlIcon
	(properties
		view 802
		loop 3
		cel 0
		nsLeft 9
		nsTop 157
	)
	
	(method (highlight param1)
		(if param1
			(DrawCel view loop 2 nsLeft nsTop 15)
		else
			(DrawCel view loop 0 nsLeft nsTop 15)
		)
	)
)

(instance cancelIcon of ControlIcon
	(properties
		view 802
		loop 4
		cel 0
		nsLeft 9
		nsTop 170
	)
	
	(method (highlight param1)
		(if param1
			(DrawCel view loop 2 nsLeft nsTop 15)
		else
			(DrawCel view loop 0 nsLeft nsTop 15)
		)
	)
)

(instance namePlate of IconI
	(properties
		view 802
		loop 1
		cel 0
		nsLeft 100
		nsTop 22
		nsRight 300
		nsBottom 34
		maskView 802
		maskLoop 9
	)
	
	(method (show)
	)
	
	(method (select param1 &tmp [temp0 4])
		(return
			(if (super select: &rest)
				(TextSize @[temp0 0] @global428 123 0)
				(cond 
					((and (== param1 8) local105)
						(StrAt @global428 (-- local105) 0)
						(DrawCel
							maskView
							maskLoop
							maskCel
							(+ nsLeft 46)
							nsTop
							15
						)
						(self highlight: 1)
					)
					((<= [temp0 3] 150)
						(StrAt @global428 local105 param1)
						(StrAt @global428 (++ local105) 0)

						;Z always clean the name plate before printing it again
						;Z needed to support English on RTL//
						(DrawCel
							maskView
							maskLoop
							maskCel
							(+ nsLeft 46)
							nsTop
							15
						)
						(self highlight: 1)


						(self highlight: 1)
					)
					(else (return 1))
				)
				(return 1)
			else
				(return 0)
			)
		)
	)
	
	(method (highlight param1 &tmp temp0 temp1 theLoop)
		(if param1
			(= theLoop loop)
			(= temp0 50)
			(= temp1 215)
		else
			(= theLoop 2)
			(= temp0 91)
			(= temp1 215)
		)
		(DrawCel view theLoop cel nsLeft nsTop 15)
;		(Display
;			@global428
;			100
;			(+ nsLeft 47)
;			nsTop
;			102
;			temp1
;			106
;			172
;			101
;			0
;			105
;			123
;		)
		(Display
			@global428
			100
			(+ nsLeft 46)
			nsTop
			102
			temp0
			106
			172
			101
			0
			105
			123
		)
	)
)

(instance theChar of View
	(properties
		x 48
		y 145
		view 802
		priority 14
		signal $0010
	)
)

(instance pointsAvail of View
	(properties
		x 102
		y 140
		view 802
		loop 7
		priority 15
		signal $0010
	)
)

(instance cancelCode of Code
	(properties)
	
	(method (doit &tmp temp0 temp1 startControlsCurIcon)
		(if
			(= temp0
				(Print
					font: gFont
					mode: 1
					addText: 1 0 1 1 0 0 203
					addButton: 0 1 0 1 2 37 30 203
					addButton: 1 1 0 1 3 87 30 203
					init:
				)
			)
			(= local135 202)
		else
			(= startControlsCurIcon (startControls curIcon?))
			(= temp1 1)
			(while (< temp1 14)
				(= [theTheTheGStrength temp1]
					[theTheGStrength (+ temp1 (* gCel 14))]
				)
				(= [theGStrength temp1]
					[theTheGStrength (+ temp1 (* gCel 14))]
				)
				(++ temp1)
			)
			(= local105 (= global428 0))
			(DrawCel 802 9 0 146 22 15)
			(= local106 50)
			(localproc_0997)
			(startControls eachElementDo: #highlight 0)
			(gGame
				setCursor:
					999
					1
					(+ (startControlsCurIcon nsLeft?) 5)
					(- (startControlsCurIcon nsBottom?) 2)
			)
			(startControlsCurIcon highlight: 1)
		)
	)
)

(instance startCode of Code
	(properties)
	
	(method (doit &tmp temp0)
		(= temp0 1)
		(if local106
			(= temp0
				(Print
					font: gFont
					mode: 1
					addText: 1 0 2 1 0 0 203
					addButton: 0 1 0 2 2 37 20 203
					addButton: 1 1 0 2 3 45 40 203
					init:
				)
			)
		)
		(if temp0
			(= local135 300)
			(switch gCel
				(0 (gEgo get: 2 get: 5))
				(1 (gEgo get: 6 learn: 21 10))
				(2
					(gEgo get: 6 get: 7)
					(= global175 10)
				)
			)
		)
	)
)
