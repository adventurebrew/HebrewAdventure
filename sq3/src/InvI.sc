;;; Sierra Script 1.0 - (do not remove this comment)
(script# 995)
(include sci.sh)
(use Main)
(use Class_255_0)
(use SysWindow)
(use Obj)


(local
	newDButton
)
(class InvI of Obj
	(properties
		said 0
		description 0
		owner 0
		view 0
		loop 0
		cel 0
		script 0
	)
	
	(method (showSelf)
		(proc255_1 (if description else name) view loop cel)
	)
	
	(method (saidMe)
		(Said said)
	)
	
	(method (ownedBy param1)
		(return (== owner param1))
	)
	
	(method (moveTo theOwner)
		(= owner theOwner)
		(return self)
	)
	
	(method (changeState param1)
		(if script (script changeState: param1))
	)
)

(class Inv of Set
	(properties
		elements 0
		size 0
		carrying {You are carrying:}
		empty {You are carrying nothing!}
	)
	
	(method (init)
		(= gInv self)
	)
	
	(method (showSelf param1)
		(invD text: carrying doit: param1)
	)
	
	(method (saidMe)
		(self firstTrue: 248)
	)
	
	(method (ownedBy param1)
		(self firstTrue: 243 param1)
	)
)

(instance invD of Dialog
	(properties)
	
	(method (init param1 &tmp temp0 temp1 temp2 temp3 newDText gInvFirst temp6)
		(= temp2 (= temp0 (= temp1 4)))
		(= temp3 0)
		(= gInvFirst (gInv first:))
		(while gInvFirst
			(if
			((= temp6 (NodeValue gInvFirst)) ownedBy: param1)
				(++ temp3)
				(self
					add:
						((= newDText (DText new:))
							value: temp6
							text: (temp6 name?)
							nsLeft: temp0
							nsTop: temp1
							state: 3
							font: global23
							setSize:
							yourself:
						)
				)
				(if
				(< temp2 (- (newDText nsRight?) (newDText nsLeft?)))
					(= temp2 (- (newDText nsRight?) (newDText nsLeft?)))
				)
				(if
					(>
						(= temp1
							(+ temp1 (- (newDText nsBottom?) (newDText nsTop?)) 1)
						)
						140
					)
					(= temp1 4)
					(= temp0 (+ temp0 temp2 10))
					(= temp2 0)
				)
			)
			(= gInvFirst (gInv next: gInvFirst))
		)
		(if (not temp3) (self dispose:) (return 0))
		(= window SysWindow)
		(self setSize:)

		; Zvika - relocating to the right edge
		(= gInvFirst (self first:))
		(while gInvFirst
			(= newDText (NodeValue gInvFirst))	; it's not really a DText; I'm just reusing vars
			(newDText
				 move: (- nsRight 
				 	      (+ (newDText nsLeft?)
							 (- (newDText nsRight?) (newDText nsLeft?)))) 0
			)
			(= gInvFirst (self next: gInvFirst))
		)


		(= newDButton (DButton new:))
		(newDButton
			text: {OK}
			setSize:
			;original: moveTo: (- nsRight (+ 4 (newDButton nsRight?))) nsBottom
			moveTo: (+ nsLeft (+ 4 (newDButton nsLeft?))) nsBottom
		)
		; the following lines aren't required (for now?) in Hebrew
		;(newDButton
			;move: (- (newDButton nsLeft?) (newDButton nsRight?)) 0
		;)
		(self add: newDButton setSize: center:)
		(return temp3)
	)
	
	(method (doit param1 &tmp theNewDButton)
		(if (not (self init: param1))
			(proc255_0 (gInv empty?))
			(return)
		)
		(self open: 4 15)
		(= theNewDButton newDButton)
		(repeat
			(if
				(or
					(not (= theNewDButton (super doit: theNewDButton)))
					(== theNewDButton -1)
					(== theNewDButton newDButton)
				)
				(break)
			)
			((theNewDButton value?) showSelf:)
		)
		(self dispose:)
	)
	
	(method (handleEvent param1 &tmp temp0 temp1)
		(= temp0 (param1 message?))
		(switch (= temp1 (param1 type?))
			(4
				(switch temp0
					(18432 (= temp0 3840))
					(20480 (= temp0 9))
				)
			)
			(64
				(switch temp0
					(1 (= temp0 3840) (= temp1 4))
					(5 (= temp0 9) (= temp1 4))
				)
			)
		)
		(param1 type: temp1 message: temp0)
		(super handleEvent: param1)
	)
)
