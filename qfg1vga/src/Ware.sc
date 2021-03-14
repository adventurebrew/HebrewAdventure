;;; Sierra Script 1.0 - (do not remove this comment)
(script# 551)
(include sci.sh)
(use Main)
(use Class_255_0)
(use DIcon)

(public
	buy 0
)

(local
	theGCursorNumber
)
(class Ware
	(properties
		price 0
	)
	
	(method (dispose)
		(DisposeClone self)
	)
)

(instance buy of Dialog
	(properties)
	
	(method (init &tmp temp0 temp1 temp2 temp3 newDText gNewListFirst temp6)
		(= theGCursorNumber gCursorNumber)
		(gGame setCursor: 999)
		(= temp0 (= temp1 4))
		(= temp3 0)
		(if (!= gModNum 65)
			((= gNewDText (DText new:))
				text: {אולי תרצה לקנות:}
				setSize:
				moveTo: 4 temp1
			)
		else
			((= gNewDText (DText new:))
				text: {אולי תרצה לתת:}
				setSize:
				moveTo: 4 temp1
			)
		)
		(self add: gNewDText setSize:)
		(= temp1
			(+
				temp1
				(- (gNewDText nsBottom?) (gNewDText nsTop?))
				1
			)
		)
		(= gNewListFirst (gNewList first:))
		(while gNewListFirst
			(= temp6 (NodeValue gNewListFirst))
			(++ temp3)
			(self
				add:
					((= newDText (DText new:))
						value: temp3
						text: (temp6 name?)
						nsLeft: temp0
						nsTop: temp1
						state: 3
						setSize:
						yourself:
					)
			)
			(if (!= gModNum 65)
				(self
					add:
						((DText new:)
							text: (temp6 price?)
							nsLeft: (+ temp0 120)
							nsTop: temp1
							setSize:
							yourself:
						)
				)
				(self
					add:
						((DText new:)
							text: (if (StrCmp (temp6 price?) {1}) {מטבעות כסף} else {מטבע כסף})
							nsLeft: (+ temp0 140)
							nsTop: temp1
							setSize:
							yourself:
						)
				)
			)
			(= temp1
				(+ temp1 (- (newDText nsBottom?) (newDText nsTop?)) 1)
			)
			(= gNewListFirst (gNewList next: gNewListFirst))
		)
		(= window gHSW)
		(self setSize:)
		(= gNewDText (DButton new:))
		(if (!= gModNum 65)
			(gNewDText
				text: {אל תקנה דבר}
				setSize:
				moveTo: (- nsRight (+ 4 (gNewDText nsRight?))) nsBottom
			)
		else
			(gNewDText
				text: {אל תתן דבר}
				setSize:
				moveTo: (- nsRight (+ 4 (gNewDText nsRight?))) nsBottom
			)
		)
		(gNewDText
			move: (- (gNewDText nsLeft?) (gNewDText nsRight?)) 0
		)
		(self add: gNewDText setSize: center:)
		(return temp3)
	)
	
	(method (doit &tmp theGNewDText temp1 temp2 temp3 temp4 temp5)
		(self init:)
		(self open: 4 15)
		(= temp2 ((gDropInv at: 0) amount?))
		(= temp4 (/ ((gDropInv at: 0) amount?) 10))
		(= temp1 (* ((gDropInv at: 38) amount?) 10))
		(= theGNewDText gNewDText)
		(= theGNewDText (super doit: theGNewDText))
		(if
			(or
				(not (IsObject theGNewDText))
				(== theGNewDText gNewDText)
			)
			(self dispose: 0)
		else
			(= temp5
				(not
					(mod
						(= temp3
							(ReadNumber
								((gNewList at: (- (theGNewDText value?) 1)) price?)
							)
						)
						10
					)
				)
			)
			(cond 
				((< (+ temp1 temp2) temp3) (self dispose: -1))
				((== (+ temp1 temp2) temp3)
					((gDropInv at: 0) amount: 0)
					((gDropInv at: 38) amount: 0)
					(gEgo use: 0 0)
					(self dispose: (theGNewDText value?))
				)
				((> temp2 temp3)
					((gDropInv at: 0)
						amount: (- ((gDropInv at: 0) amount?) temp3)
					)
					(self dispose: (theGNewDText value?))
				)
				(temp4
					((gDropInv at: 0)
						amount: (- ((gDropInv at: 0) amount?) (* temp4 10))
					)
					(= temp3 (- temp3 (* temp4 10)))
					((gDropInv at: 38)
						amount:
							(-
								((gDropInv at: 38) amount?)
								(+ (/ temp3 10) (if temp5 0 else 1))
							)
					)
					(if (not temp5)
						((gDropInv at: 0)
							amount: (+ ((gDropInv at: 0) amount?) (- 10 (mod temp3 10)))
						)
					)
					(cond 
						(
							(and
								(== ((gDropInv at: 0) amount?) 0)
								(== ((gDropInv at: 38) amount?) 0)
							)
							(gEgo use: 0 0)
						)
						(
							(and
								(== ((gDropInv at: 0) amount?) 0)
								(> ((gDropInv at: 38) amount?) 0)
							)
							((gDropInv at: 0) amount: 10)
							((gDropInv at: 38)
								amount: (- ((gDropInv at: 38) amount?) 1)
							)
						)
					)
					(self dispose: (theGNewDText value?))
				)
				(else
					((gDropInv at: 38)
						amount:
							(-
								((gDropInv at: 38) amount?)
								(+ (/ temp3 10) (if temp5 0 else 1))
							)
					)
					(if (not temp5)
						((gDropInv at: 0)
							amount: (+ ((gDropInv at: 0) amount?) (- 10 (mod temp3 10)))
						)
					)
					(cond 
						(
							(and
								(== ((gDropInv at: 0) amount?) 0)
								(== ((gDropInv at: 38) amount?) 0)
							)
							(gEgo use: 0 0)
						)
						(
							(and
								(== ((gDropInv at: 0) amount?) 0)
								(> ((gDropInv at: 38) amount?) 0)
							)
							((gDropInv at: 0) amount: 10)
							((gDropInv at: 38)
								amount: (- ((gDropInv at: 38) amount?) 1)
							)
						)
					)
					(self dispose: (theGNewDText value?))
				)
			)
		)
	)
	
	(method (dispose param1)
		(self eachElementDo: #dispose 1)
		(super dispose:)
		(gNewList dispose:)
		(gGame setCursor: theGCursorNumber)
		(return param1)
	)
	
	(method (handleEvent pEvent &tmp pEventMessage pEventType)
		(= pEventMessage (pEvent message?))
		(switch (= pEventType (pEvent type?))
			(4
				(switch pEventMessage
					(KEY_UP (= pEventMessage 3840))
					(KEY_NUMPAD2
						(= pEventMessage 9)
					)
				)
			)
			(64
				(switch pEventMessage
					(JOY_UP
						(= pEventMessage 3840)
						(= pEventType 4)
					)
					(JOY_DOWN
						(= pEventMessage 9)
						(= pEventType 4)
					)
				)
			)
		)
		(pEvent type: pEventType message: pEventMessage)
		(super handleEvent: pEvent)
	)
)
