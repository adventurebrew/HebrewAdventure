;;; Sierra Script 1.0 - (do not remove this comment)
(script# 255)
(include sci.sh)
(use Main)
(use Obj)

(public
	proc255_0 0
	proc255_1 1
	proc255_2 2
	proc255_3 3
	proc255_4 4
	proc255_5 5
)

(procedure (proc255_0 param1 &tmp newDialog newDText newDIcon newDEdit temp4 temp5 temp6 temp7 temp8 theGTheNewDialog temp10 temp11 [newDButton 6] temp18 temp19 temp20 [temp21 1000])
	(= temp6 (= temp7 -1))
	(= theGTheNewDialog
		(= temp8
			(= temp18 (= newDIcon (= newDEdit (= temp19 0))))
		)
	)
	((= newDialog (Dialog new:))
		window: gSysWindow
		name: {PrintD}
	)
	(= newDText (DText new:))
	(cond 
		((u< [param1 0] 1000) (GetFarText [param1 0] [param1 1] @temp21) (= temp5 2))
		([param1 0] (StrCpy @temp21 [param1 0]) (= temp5 1))
		(else (= temp21 0) (= temp5 0))
	)
	(newDText
		text: @temp21
		moveTo: 4 4
		font: global22
		setSize:
	)
	(newDialog add: newDText)
	(= temp5 temp5)
	(while (< temp5 argc)
		(switch [param1 temp5]
			(30
				(++ temp5)
				(newDText mode: [param1 temp5])
			)
			(33
				(++ temp5)
				(newDText font: [param1 temp5] setSize: temp8)
			)
			(70
				(= temp8 [param1 (++ temp5)])
				(newDText setSize: temp8)
			)
			(25
				(++ temp5)
				(newDialog time: [param1 temp5])
			)
			(80
				(++ temp5)
				(newDialog text: [param1 temp5])
			)
			(67
				(= temp6 [param1 (++ temp5)])
				(= temp7 [param1 (++ temp5)])
			)
			(83
				(Animate (gCast elements?) 0)
			)
			;#edit
			(41
				(++ temp5)
				;Z move "Enter input" to the right:
				(if (== STRINGS_EQUAL (StrCmp @temp21 {Enter input}))
					(newDText moveTo: 210 4)
					(= newDText (DText new:))
					(newDText
						text: ''
						moveTo: 4 18
					)
					(newDialog add: newDText)
				)
				
				((= newDEdit (DEdit new:)) text: [param1 temp5])
				(++ temp5)
				(newDEdit max: [param1 temp5] setSize:)
			)
			(81
				((= [newDButton temp19] (DButton new:))
					text: [param1 (++ temp5)]
					value: [param1 (++ temp5)]
					setSize:
				)
				(= temp18 (+ temp18 ([newDButton temp19] nsRight?) 4))
				(++ temp19)
			)
			(82
				(if (IsObject [param1 (+ temp5 1)])
					((= newDIcon ([param1 (+ temp5 1)] new:)) setSize:)
					(= temp5 (+ temp5 1))
				else
					(= newDIcon (DIcon new:))
					(newDIcon
						view: [param1 (+ temp5 1)]
						loop: [param1 (+ temp5 2)]
						cel: [param1 (+ temp5 3)]
						setSize:
					)
					(= temp5 (+ temp5 3))
				)
			)
			(91
				(if gTheNewDialog (gTheNewDialog dispose:))
				(= theGTheNewDialog newDialog)
			)
			(35
				(++ temp5)
				(newDialog window: [param1 temp5])
			)
		)
		(++ temp5)
	)
	(if newDIcon
		(newDIcon moveTo: 4 4)
		(newDText
			moveTo: (+ 4 (newDIcon nsRight?)) (newDText nsTop?)
		)
		(newDialog add: newDIcon)
	)
	(newDialog setSize:)
	(if newDEdit
		(newDEdit
			moveTo: (newDText nsLeft?) (+ 4 (newDText nsBottom?))
		)
		(newDialog add: newDEdit setSize:)
	)
	;(= temp20
	;	(if (> temp18 (newDialog nsRight?))
	;		4
	;	else
	;		(- (newDialog nsRight?) temp18)
	;	)
	;)
	
	;Z always align buttons to the left
	(= temp20 4)

;	(= temp5 0)
;	(while (< temp5 temp19)
;		([newDButton temp5] moveTo: temp20 (newDialog nsBottom?))
;		(newDialog add: [newDButton temp5])
;		(= temp20 (+ 4 ([newDButton temp5] nsRight?)))
;		(++ temp5)
;	)

	;Z reverse the buttons order
	(= temp5 (- temp19 1))
	(while (> temp5 -1)
		([newDButton temp5] moveTo: temp20 (newDialog nsBottom?))
		(newDialog add: [newDButton temp5])
		(= temp20 (+ 4 ([newDButton temp5] nsRight?)))
		(-- temp5)
	)	
	(newDialog setSize: center:)
	(if (and newDIcon (not (StrLen @temp21)))
		(newDIcon
			moveTo:
				(/
					(-
						(- (newDialog nsRight?) (newDialog nsLeft?))
						(- (newDIcon nsRight?) (newDIcon nsLeft?))
					)
					2
				)
				4
		)
	)
	(newDialog
		moveTo:
			(if (== -1 temp6) (newDialog nsLeft?) else temp6)
			(if (== -1 temp7) (newDialog nsTop?) else temp7)
	)
	(= temp11 (GetPort))
	(newDialog
		open: (if (newDialog text?) 4 else 0) (if theGTheNewDialog 15 else -1)
	)
	(if theGTheNewDialog
		(= global62 (GetPort))
		(SetPort temp11)
		(return (= gTheNewDialog theGTheNewDialog))
	)
	(if
		(and
			(= temp10 (newDialog firstTrue: 149 1))
			(not (newDialog firstTrue: 149 2))
		)
		(temp10 state: (| (temp10 state?) $0002))
	)
	(if (== (= temp4 (newDialog doit: temp10)) -1)
		(= temp4 0)
	)
	(= temp5 0)
	(while (< temp5 temp19)
		(if (== temp4 [newDButton temp5])
			(= temp4 (temp4 value?))
			(break)
		)
		(++ temp5)
	)
	(if (not (newDialog theItem?)) (= temp4 1))
	(newDialog dispose:)
	(return temp4)
)

(procedure (proc255_1 param1 param2 param3 param4)
	(proc255_0 param1 82 param2 param3 param4 &rest)
)

(procedure (proc255_2 param1 param2 param3 &tmp [temp0 4])
	(if
		(proc255_0
			(if (>= argc 3) param3 else {})
			41
			param1
			param2
			&rest
		)
		(StrLen param1)
	)
)

(procedure (proc255_3 param1 param2 &tmp [temp0 40])
	(= temp0 0)
	(if (> argc 1) (Format @temp0 255 0 param2))
	(return
		(if (proc255_2 @temp0 5 param1)
			(ReadNumber @temp0)
		else
			-1
		)
	)
)

(procedure (proc255_4 &tmp [temp0 500])
	(Format @temp0 &rest)
	(proc255_0 @temp0)
)

(procedure (proc255_5 param1 param2 param3)
	(cond 
		(
			(or
				(!= (param2 type?) 1)
				(and
					(param1 respondsTo: 17)
					(& (param1 signal?) $0080)
				)
			)
			0
		)
		(
			(and
				(>= argc 3)
				param3
				(== (& (param2 modifiers?) param3) 0)
			)
			0
		)
		((param1 respondsTo: 10)
			(proc999_4
				(param1 nsLeft?)
				(param1 nsTop?)
				(param1 nsRight?)
				(param1 nsBottom?)
				param2
			)
		)
	)
)

(procedure (localproc_0016 &tmp newEvent temp1)
	(= temp1 (!= ((= newEvent (Event new:)) type?) 2))
	(newEvent dispose:)
	(return temp1)
)

(class Class_255_0 of Obj
	(properties
		state 0
	)
	
	(method (draw)
		(= state 1)
		(DrawMenuBar 1)
	)
	
	(method (hide)
		(DrawMenuBar 0)
	)
	
	(method (handleEvent param1 &tmp temp0 temp1)
		(= temp0 0)
		(if state
			(= temp1 (Joystick 12 30))
			(= temp0 (MenuSelect param1 &rest))
			(Joystick 12 temp1)
		)
		(return temp0)
	)
	
	(method (add)
		(AddMenu &rest)
	)
)

(class Class_255_1 of Obj
	(properties
		type 0
		state 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		key 0
		said 0
		value 0
	)
	
	(method (doit)
		(return value)
	)
	
	(method (enable param1)
		(if param1
			(= state (| state $0001))
		else
			(= state (& state $fffe))
		)
	)
	
	(method (select param1)
		(if param1
			(= state (| state $0008))
		else
			(= state (& state $fff7))
		)
		(self draw:)
	)
	
	(method (handleEvent param1 &tmp temp0 temp1 temp2)
		(if (param1 claimed?) (return 0))
		(= temp0 0)
		(if
			(and
				(& state $0001)
				(or
					(and (== (= temp1 (param1 type?)) 128) (Said said))
					(and (== temp1 4) (== (param1 message?) key))
					(and (== temp1 1) (self check: param1))
				)
			)
			(param1 claimed: 1)
			(= temp0 (self track: param1))
		)
		(return temp0)
	)
	
	(method (check param1)
		(return
			(if
				(and
					(>= (param1 x?) nsLeft)
					(>= (param1 y?) nsTop)
					(< (param1 x?) nsRight)
				)
				(< (param1 y?) nsBottom)
			else
				0
			)
		)
	)
	
	(method (track param1 &tmp temp0 temp1)
		(return
			(if (== 1 (param1 type?))
				(= temp1 0)
				(repeat
					(= param1 (Event new: -32768))
					(GlobalToLocal param1)
					(if (!= (= temp0 (self check: param1)) temp1)
						(HiliteControl self)
						(= temp1 temp0)
					)
					(param1 dispose:)
					(breakif (not (localproc_0016)))
				)
				(if temp0 (HiliteControl self))
				(return temp0)
			else
				(return self)
			)
		)
	)
	
	(method (setSize)
	)
	
	(method (move param1 param2)
		(= nsRight (+ nsRight param1))
		(= nsLeft (+ nsLeft param1))
		(= nsTop (+ nsTop param2))
		(= nsBottom (+ nsBottom param2))
	)
	
	(method (moveTo param1 param2)
		(self move: (- param1 nsLeft) (- param2 nsTop))
	)
	
	(method (draw)
		(DrawControl self)
	)
	
	(method (isType param1)
		(return (== type param1))
	)
	
	(method (checkState param1)
		(return (& state param1))
	)
	
	(method (cycle)
	)
)

(class DText of Class_255_1
	(properties
		type 2
		state 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		key 0
		said 0
		value 0
		text 0
		font 1
		mode 0
	)
	
	(method (new &tmp temp0)
		((super new:) font: global22 yourself:)
	)
	
	(method (setSize param1 &tmp [temp0 4])
		(TextSize @[temp0 0] text font (if argc param1 else 0))
		(= nsBottom (+ nsTop [temp0 2]))
		(= nsRight (+ nsLeft [temp0 3]))
	)
)

(class DIcon of Class_255_1
	(properties
		type 4
		state 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		key 0
		said 0
		value 0
		view 0
		loop 0
		cel 0
	)
	
	(method (setSize &tmp [temp0 4])
		(= nsRight (+ nsLeft (CelWide view loop cel)))
		(= nsBottom (+ nsTop (CelHigh view loop cel)))
	)
)

(class DButton of Class_255_1
	(properties
		type 1
		state 3
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		key 0
		said 0
		value 0
		text 0
		font 0
	)
	
	(method (setSize &tmp [temp0 4])
		(TextSize @[temp0 0] text font)
		(= [temp0 2] (+ [temp0 2] 2))
		(= [temp0 3] (+ [temp0 3] 2))
		(= nsBottom (+ nsTop [temp0 2]))
		(= [temp0 3] (* (/ (+ [temp0 3] 15) 16) 16))
		(= nsRight (+ [temp0 3] nsLeft))
	)
)

(class DEdit of Class_255_1
	(properties
		type 3
		state 1
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		key 0
		said 0
		value 0
		text 0
		font 0
		max 0
		cursor 0
	)
	
	(method (track param1)
		(EditControl self param1)
		(return self)
	)
	
	(method (setSize &tmp [temp0 4])
		(TextSize @[temp0 0] {M} font)
		(= nsBottom (+ nsTop [temp0 2]))
		(= nsRight (+ nsLeft (/ (* [temp0 3] max 3) 4)))
		(= cursor (StrLen text))
	)
)

(class DSelector of Class_255_1
	(properties
		type 6
		state 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		key 0
		said 0
		value 0
		font 0
		x 20
		y 6
		text 0
		cursor 0
		lsTop 0
		mark 0
	)
	
	(method (handleEvent param1 &tmp temp0 [temp1 3] temp4 [temp5 4])
		(if (param1 claimed?) (return 0))
		(if (== 64 (param1 type?))
			(param1 type: 4)
			(switch (param1 message?)
				(5 (param1 message: 20480))
				(1 (param1 message: 18432))
				(else  (param1 type: 64))
			)
		)
		(= temp0 0)
		(switch (param1 type?)
			(4
				(param1 claimed: 1)
				(switch (param1 message?)
					(18176 (self retreat: 50))
					(20224 (self advance: 50))
					(20736 (self advance: (- y 1)))
					(18688 (self retreat: (- y 1)))
					(20480 (self advance: 1))
					(18432 (self retreat: 1))
					(else  (param1 claimed: 0))
				)
			)
			(1
				(if (self check: param1)
					(param1 claimed: 1)
					(cond 
						((< (param1 y?) (+ nsTop 10))
							(repeat
								(self retreat: 1)
								(breakif (not (localproc_0016)))
							)
						)
						((> (param1 y?) (- nsBottom 10))
							(repeat
								(self advance: 1)
								(breakif (not (localproc_0016)))
							)
						)
						(else
							(TextSize @[temp5 0] {M} font)
							(if
								(>
									(= temp4 (/ (- (param1 y?) (+ nsTop 10)) [temp5 2]))
									mark
								)
								(self advance: (- temp4 mark))
							else
								(self retreat: (- mark temp4))
							)
						)
					)
				)
			)
		)
		(return
			(if (and (param1 claimed?) (& state $0002))
				self
			else
				0
			)
		)
	)
	
	(method (setSize &tmp [temp0 4])
		(TextSize @[temp0 0] {M} font)
		(= nsBottom (+ nsTop 20 (* [temp0 2] y)))
		(= nsRight (+ nsLeft (/ (* [temp0 3] x 3) 4)))
		(= lsTop (= cursor text))
		(= mark 0)
	)
	
	(method (indexOf param1 &tmp theText temp1)
		(= theText text)
		(= temp1 0)
		(return
			(while (< temp1 300)
				(if (== 0 (StrLen theText)) (return -1))
				(if (not (StrCmp param1 theText)) (return temp1))
				(= theText (+ theText x))
				(++ temp1)
			)
		)
	)
	
	(method (at param1)
		(return (+ text (* x param1)))
	)
	
	(method (advance param1 &tmp temp0)
		(= temp0 0)
		(while (and param1 (StrAt cursor x))
			(= temp0 1)
			(= cursor (+ cursor x))
			(if (< (+ mark 1) y)
				(++ mark)
			else
				(= lsTop (+ lsTop x))
			)
			(-- param1)
		)
		(if temp0 (self draw:))
	)
	
	(method (retreat param1 &tmp temp0)
		(= temp0 0)
		(while (and param1 (!= cursor text))
			(= temp0 1)
			(= cursor (- cursor x))
			(if mark (-- mark) else (= lsTop (- lsTop x)))
			(-- param1)
		)
		(if temp0 (self draw:))
	)
)

(class Dialog of List
	(properties
		elements 0
		size 0
		text 0
		window 0
		theItem 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		time 0
		busy 0
		seconds 0
		lastSeconds 0
	)
	
	(method (doit param1 &tmp temp0 newEvent temp2 temp3 temp4)
		(= temp0 0)
		(= busy 1)
		(self eachElementDo: 90)
		(if theItem (theItem select: 0))
		(= theItem
			(if (and argc param1)
				param1
			else
				(self firstTrue: 149 1)
			)
		)
		(if theItem (theItem select: 1))
		(if (not theItem)
			(= temp3 60)
			(= temp4 (GetTime))
		else
			(= temp3 0)
		)
		(= temp2 0)
		(while (not temp2)
			(self eachElementDo: 150)
			(GlobalToLocal (= newEvent (Event new:)))
			(if temp3
				(-- temp3)
				(if (== (newEvent type?) 1) (newEvent type: 0))
				(while (== temp4 (GetTime))
				)
				(= temp4 (GetTime))
			)
			(= temp2 (self handleEvent: newEvent))
			(newEvent dispose:)
			(self check:)
			(if (or (== temp2 -1) (not busy))
				(= temp2 0)
				(EditControl theItem 0)
				(break)
			)
			(Wait 1)
		)
		(= busy 0)
		(return temp2)
	)
	
	(method (dispose)
		(if (== self gTheNewDialog)
			(SetPort global62)
			(= gTheNewDialog 0)
			(= global62 0)
		)
		(if window (window dispose:))
		(= theItem (= window 0))
		(super dispose:)
	)
	
	(method (open param1 param2)
		(if (and (PicNotValid) gCast)
			(Animate (gCast elements?) 0)
		)
		(= window (window new:))
		(window
			top: nsTop
			left: nsLeft
			bottom: nsBottom
			right: nsRight
			title: text
			type: param1
			priority: param2
			open:
		)
		(= seconds time)
		(self draw:)
	)
	
	(method (draw)
		(self eachElementDo: 83)
	)
	
	(method (cue)
		(if (not busy) (self dispose:) else (= busy 0))
	)
	
	(method (advance &tmp temp0 dialogFirst)
		(if theItem
			(theItem select: 0)
			(= dialogFirst (self contains: theItem))
			(repeat
				(if (not (= dialogFirst (self next: dialogFirst)))
					(= dialogFirst (self first:))
				)
				(= theItem (NodeValue dialogFirst))
				(if (& (theItem state?) $0001) (break))
			)
			(theItem select: 1)
		)
	)
	
	(method (retreat &tmp temp0 dialogLast)
		(if theItem
			(theItem select: 0)
			(= dialogLast (self contains: theItem))
			(repeat
				(if (not (= dialogLast (self prev: dialogLast)))
					(= dialogLast (self last:))
				)
				(= theItem (NodeValue dialogLast))
				(if (& (theItem state?) $0001) (break))
			)
			(theItem select: 1)
		)
	)
	
	(method (move param1 param2)
		(= nsRight (+ nsRight param1))
		(= nsLeft (+ nsLeft param1))
		(= nsTop (+ nsTop param2))
		(= nsBottom (+ nsBottom param2))
	)
	
	(method (moveTo param1 param2)
		(self move: (- param1 nsLeft) (- param2 nsTop))
	)
	
	(method (center)
		(self
			moveTo:
				(+
					(window brLeft?)
					(/
						(-
							(- (window brRight?) (window brLeft?))
							(- nsRight nsLeft)
						)
						2
					)
				)
				(+
					(window brTop?)
					(/
						(-
							(- (window brBottom?) (window brTop?))
							(- nsBottom nsTop)
						)
						2
					)
				)
		)
	)
	
	(method (setSize &tmp dialogFirst temp1 [theNsTop 4])
		(if text
			(TextSize @[theNsTop 0] text 0 -1)
			(= nsTop [theNsTop 0])
			(= nsLeft [theNsTop 1])
			(= nsBottom [theNsTop 2])
			(= nsRight [theNsTop 3])
		else
			(= nsRight (= nsBottom (= nsLeft (= nsTop 0))))
		)
		(= dialogFirst (self first:))
		(while dialogFirst
			(if
			(< ((= temp1 (NodeValue dialogFirst)) nsLeft?) nsLeft)
				(= nsLeft (temp1 nsLeft?))
			)
			(if (< (temp1 nsTop?) nsTop) (= nsTop (temp1 nsTop?)))
			(if (> (temp1 nsRight?) nsRight)
				(= nsRight (temp1 nsRight?))
			)
			(if (> (temp1 nsBottom?) nsBottom)
				(= nsBottom (temp1 nsBottom?))
			)
			(= dialogFirst (self next: dialogFirst))
		)
		(= nsRight (+ nsRight 4))
		(= nsBottom (+ nsBottom 4))
		(self moveTo: 0 0)
	)
	
	(method (handleEvent param1 &tmp theTheItem)
		(if
			(or
				(param1 claimed?)
				(== (param1 type?) 0)
				(and
					(!= 1 (param1 type?))
					(!= 4 (param1 type?))
					(!= 64 (param1 type?))
					(!= 256 (param1 type?))
				)
			)
			(EditControl theItem param1)
			(return 0)
		)
		(if (= theTheItem (self firstTrue: 114 param1))
			(EditControl theItem 0)
			(if (not (theTheItem checkState: 2))
				(if theItem (theItem select: 0))
				((= theItem theTheItem) select: 1)
				(theTheItem doit:)
				(= theTheItem 0)
			)
		else
			(= theTheItem 0)
			(cond 
				(
					(and
						(or
							(== (param1 type?) 256)
							(and (== 4 (param1 type?)) (== 13 (param1 message?)))
						)
						theItem
						(theItem checkState: 1)
					)
					(= theTheItem theItem)
					(EditControl theItem 0)
					(param1 claimed: 1)
				)
				(
					(or
						(and
							(not (self firstTrue: 149 1))
							(or
								(and (== 4 (param1 type?)) (== 13 (param1 message?)))
								(== 1 (param1 type?))
								(== 256 (param1 type?))
							)
						)
						(and (== 4 (param1 type?)) (== 27 (param1 message?)))
					)
					(param1 claimed: 1)
					(= theTheItem -1)
				)
				(
				(and (== 4 (param1 type?)) (== 9 (param1 message?))) (param1 claimed: 1) (self advance:))
				(
					(and
						(== 4 (param1 type?))
						(== 3840 (param1 message?))
					)
					(param1 claimed: 1)
					(self retreat:)
				)
				(else (EditControl theItem param1))
			)
		)
		(return theTheItem)
	)
	
	(method (check &tmp theLastSeconds)
		(if
			(and
				seconds
				(!= lastSeconds (= theLastSeconds (GetTime 1)))
			)
			(= lastSeconds theLastSeconds)
			(if (not (-- seconds)) (self cue:))
		)
	)
)

(class Controls of List
	(properties
		elements 0
		size 0
	)
	
	(method (draw)
		(self eachElementDo: 144)
		(self eachElementDo: 83)
	)
	
	(method (handleEvent param1 &tmp temp0)
		(if (param1 claimed?) (return 0))
		(if
			(and
				(= temp0 (self firstTrue: 114 param1))
				(not (temp0 checkState: 2))
			)
			(temp0 doit:)
			(= temp0 0)
		)
		(return temp0)
	)
)
