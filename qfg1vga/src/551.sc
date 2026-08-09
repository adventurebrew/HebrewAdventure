;;; Sierra Script 1.0 - (do not remove this comment)
;;; scc 0.1.0 (qfg1vga) - decompiled from 551.scr, 551.hep on 2026-08-05
;;; Verified: recompiling this file reproduces the original bytes,
;;; exactly. Edits are safe to recompile; the guarantee is the round
;;; trip, not the formatting.
;;; 4 of 5 functions are Sierra Script. The other 1 could not be
;;; recovered and stay as (asm ...) -- each has its decompiled form,
;;; unverified, in a comment above it.
(script# 551)

(public
	buy 0
)

(local
	local0
)

(class Ware
	(properties)

	(method (dispose)
		(DisposeClone self)
	)
)

(instance buy of buy_binding
	(properties)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10)
		(= local0 global19)
		(global1 setCursor: 999)
		(= temp1 4)
		(= temp0 temp1)
		(= temp3 0)
		(if (!= global11 65)
			((= global192 (Unknown_Class_13 new:))
				;Z Hebrew buy-list heading.
				text: {אולי תרצה לקנות:}
				setSize:
				moveTo: 4 temp1
			)
		else
			((= global192 (Unknown_Class_13 new:))
				;Z Hebrew give-list heading.
				text: {אולי תרצה לתת:}
				setSize:
				moveTo: 4 temp1
			)
		)
		(= temp1 (+ temp1 (+ (- (global192 nsBottom:) (global192 nsTop:)) 1)))
		(= temp5 (global193 first:))
		(while temp5
			(= temp6 (NodeValue temp5))
			(++ temp3)
			(self
				add:
					((= temp4 (Unknown_Class_13 new:))
						value: temp3
						text: (temp6 name:)
						;Z Start item names from the right side.
						nsLeft: (+ temp0 220)
						nsTop: temp1
						setSize:
						state: 3
						yourself:
					)
			)
			;Z Right-align the item name text.
			(TextSize @[temp7 0] (temp4 text:) (temp4 font:))
			(temp4 move: (- 0 [temp7 3]) 0)
			(if (!= global11 65)
				(self
					add:
						((Unknown_Class_13 new:)
							text: (temp6 price:)
							;Z Move price column for Hebrew layout.
							nsLeft: (+ temp0 95)
							nsTop: temp1
							setSize:
							yourself:
						)
				)
			else
				(self
					add:
						((Unknown_Class_13 new:)
							text: (if (StrCmp (temp6 price:) {1}) {מטבעות כסף} else {מטבע כסף} )
							;Z Move silver-coin label column for Hebrew layout.
							nsLeft: temp0
							nsTop: temp1
							setSize:
							yourself:
						)
				)
			)
			(= temp1 (+ temp1 (- (temp4 nsBottom:) (temp4 nsTop:)) 1))
			(= temp5 (global193 next: temp5))
		)
		(= nsRight global38)
		(self setSize:)
		;Z Right-align and add the heading after dialog width is known.
		(global192 moveTo: (- nsRight (global192 nsRight:)) (global192 nsTop:))
		(self add: global192 setSize:)
		(= global192 (Unknown_Class_16 new:))
		(if (!= global11 65)
			(global192
				;Z Hebrew buy-cancel button text.
				text: {אל תקנה דבר}
				setSize:
				moveTo: temp0 nsBottom
			)
		else
			(global192
				;Z Hebrew give-cancel button text.
				text: {אל תתן דבר}
				setSize:
				moveTo: (- nsRight (+ 4 (global192 nsRight:))) nsBottom
			)
		)
		(self add: global192 setSize: center:)
		(return temp3)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(self init:)
		(self open: 4 15)
		(= temp2 ((global9 at: 0) amount:))
		(= temp4 (/ ((global9 at: 0) amount:) 10))
		(= temp1 (* ((global9 at: 38) amount:) 10))
		(= temp0 global192)
		(= temp0 (super doit: temp0))
		(if (or (not (IsObject temp0)) (== temp0 global192))
			(self dispose: 0)
		else
			(= temp3 (ReadNumber ((global193 at: (- (temp0 value:) 1)) price:)))
			(= temp5 (not (mod temp3 10)))
			(if (< (+ temp1 temp2) temp3)
				(self dispose: -1)
			else
				(if (== (+ temp1 temp2) temp3)
					((global9 at: 0) amount: 0)
					((global9 at: 38) amount: 0)
					(global0 use: 0 0)
					(self dispose: (temp0 value:))
				else
					(if (> temp2 temp3)
						((global9 at: 0) amount: (- ((global9 at: 0) amount:) temp3))
						(self dispose: (temp0 value:))
					else
						(if temp4
							((global9 at: 0) amount: (- ((global9 at: 0) amount:) (* temp4 10)))
							(= temp3 (- temp3 (* temp4 10)))
							((global9 at: 38) amount: (- ((global9 at: 38) amount:) (+ (/ temp3 10) (if temp5 0 else 1 ))))
							(if (not temp5)
								((global9 at: 0) amount: (+ ((global9 at: 0) amount:) (- 10 (mod temp3 10))))
							)
							(if (and (== ((global9 at: 0) amount:) 0) (== ((global9 at: 38) amount:) 0))
								(global0 use: 0 0)
							else
								(if (and (== ((global9 at: 0) amount:) 0) (> ((global9 at: 38) amount:) 0))
									((global9 at: 0) amount: 10)
									((global9 at: 38) amount: (- ((global9 at: 38) amount:) 1))
								)
							)
							(self dispose: (temp0 value:))
						else
							((global9 at: 38) amount: (- ((global9 at: 38) amount:) (+ (/ temp3 10) (if temp5 0 else 1 ))))
							(if (not temp5)
								((global9 at: 0) amount: (+ ((global9 at: 0) amount:) (- 10 (mod temp3 10))))
							)
							(if (and (== ((global9 at: 0) amount:) 0) (== ((global9 at: 38) amount:) 0))
								(global0 use: 0 0)
							else
								(if (and (== ((global9 at: 0) amount:) 0) (> ((global9 at: 38) amount:) 0))
									((global9 at: 0) amount: 10)
									((global9 at: 38) amount: (- ((global9 at: 38) amount:) 1))
								)
							)
							(self dispose: (temp0 value:))
						)
					)
				)
			)
		)
	)

	(method (dispose param1)
		(self eachElementDo: 111 1)
		(super dispose:)
		(global193 dispose:)
		(global1 setCursor: local0)
		(return param1)
	)

	(method (handleEvent param1 &tmp temp0 temp1)
		(= temp0 (param1 message:))
		(= temp1 (param1 type:))
		(switch temp1
			(4
				(switch temp0
					(18432
						(= temp0 3840)
					)
					(20480
						(= temp0 9)
					)
				)
			)
			(64
				(switch temp0
					(1
						(= temp0 3840)
						(= temp1 4)
					)
					(5
						(= temp0 9)
						(= temp1 4)
					)
				)
			)
		)
		(param1
			type: temp1
			message: temp0
		)
		(super handleEvent: param1)
	)
)
