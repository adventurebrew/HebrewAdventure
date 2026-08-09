;;; Sierra Script 1.0 - (do not remove this comment)
;;; scc 0.1.0 (qfg1vga) - decompiled from 550.scr, 550.hep on 2026-08-04
;;; Verified: recompiling this file reproduces the original bytes,
;;; exactly. Edits are safe to recompile; the guarantee is the round
;;; trip, not the formatting.
;;; 7 of 9 functions are Sierra Script. The other 2 could not be
;;; recovered and stay as (asm ...) -- each has its decompiled form,
;;; unverified, in a comment above it.
(script# 550)
(include scc.sh)

(public
	Teller 0
)

(local

)

(procedure (localproc_0 param1 param2 param3)
	(Memory 6 (+ param1 (* 2 param2)) param3)
)

(class Teller
	(properties)

	(method (init param1 param2 param3 param4)
		(= client param1)
		(= curArray param2)
		(= arrays param3)
		(if (> argc 3)
			(= keys param4)
		)
		(client actions: self)
		(super init:)
	)

	(method (doVerb)
		; decompiled form (param1):
		; (if (== param1 2)
		; 	(while 1
		; 		(contif (self respond:))
		; 	)
		; else
		; 	(client doVerb: param1)
		; )
		(asm
			(lsp.b 1)
			(ldi.b 2)
			(eq? )
			(bnt.b code_136)
		code_118:
			(ldi.b 1)
			(bnt.b code_146)
			(pushi.w 601)
			(push0 )
			(self 4)
			(bnt.b code_118)
			(jmp.b code_146)
			(jmp.b code_118)
			(jmp.b code_146)
		code_136:
			(pushi.w 300)
			(push1 )
			(lsp.b 1)
			(pToa.b 26)
			(send 6)
		code_146:
			(ret )
		)
	)

	(method (respond)
		(= query (self showDialog:))
		(if (== query 64537)
			(return 1)
		else
			(if (== query 999)
				(self doParent:)
				(return 0)
			else
				(if (and (< query 0) (not (self doChild: query)))
					(return 1)
				)
			)
		)
		(if (< query 0)
			(= query (- query))
		)
		(if (not (client noun:))
			(proc921_0 "You forgot to assign a noun property to your actor.")
		)
		(global91 say: (client noun:) 5 query 0)
		(return 1)
	)

	(method (showDialog)
		(self doDialog: (if (== (proc999_6 arrays 0) curArray) 1 else 0 ) &rest)
	)

	(method (doDialog param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21 temp22 temp23 temp24 temp25 temp26 temp27 temp28 temp29 temp30 temp31 temp32 temp33 temp34 temp35 temp36 temp37 temp38 temp39 temp40 temp41 temp42 temp43 temp44 temp45 temp46 temp47 temp48 temp49 temp50 temp51 temp52 temp53 temp54 temp55 temp56 temp57 temp58 temp59 temp60 temp61 temp62 temp63 temp64 temp65 temp66 temp67 temp68 temp69 temp70 temp71 temp72 temp73 temp74 temp75 temp76 temp77 temp78 temp79 temp80 temp81 temp82 temp83 temp84 temp85 temp86 temp87 temp88 temp89)
		(= temp2 0)
		(= temp0 [param1 temp2])
		(= temp6 0)
		(= temp9 1)
		((= temp4 (Unknown_Class_14 new:)) window: global38)
		((= temp5 (Unknown_Class_13 new:))
			;Z Hebrew dialog title.
			text: {שאל על:}
			font: global22
			setSize:
			moveTo: 4 (+ temp6 4)
		)
		(temp4 add: temp5)
		(= temp6 (temp5 nsBottom:))
		(= temp1 1)
		(while (!= (proc999_6 curArray temp1) 999)
			(= temp7 1)
			(= temp2 1)
			(while (and temp7 (< temp2 argc))
				(if (and (== (proc999_6 curArray temp1) [param1 temp2]) (not [param1 (+ temp2 1)]))
					(= temp7 0)
				)
				(= temp2 (+ temp2 2))
			)
			(if temp7
				(if (IsObject temp5)
					(= temp6 (temp5 nsBottom:))
				)
				(= temp8 (proc999_6 curArray temp1))
				(Message msgGET global11 (client noun:) 2 (if (< temp8 0) (- temp8) else temp8 ) 1 (switch temp9 (0 @temp10 ) (1 @temp20 ) (2 @temp30 ) (3 @temp40 ) (4 @temp50 ) (5 @temp60 ) (6 @temp70 ) (7 @temp80 ) ))
				((= temp5 (Unknown_Class_16 new:))
					text: (switch temp9 (0 @temp10 ) (1 @temp20 ) (2 @temp30 ) (3 @temp40 ) (4 @temp50 ) (5 @temp60 ) (6 @temp70 ) (7 @temp80 ) )
					value: temp8
					font: global22
					setSize:
					moveTo: 4 (+ temp6 4)
				)
				(temp4 add: temp5)
				(++ temp9)
			)
			(++ temp1)
		)
		(= temp6 (temp5 nsBottom:))
		(= temp5 (Unknown_Class_16 new:))
		(if (not temp0)
			(temp5
				;Z Hebrew button text.
				text: {משהו אחר}
				value: 999
			)
		else
			(temp5
				;Z Hebrew button text.
				text: {מספיק}
				value: 64537
			)
		)
		(temp5
			setSize:
			moveTo: 4 (+ temp6 4)
		)
		(temp4 add: temp5)
		;Z Right-align dialog children for Hebrew.
		(temp4 setSize:)
		(for ((= temp88 (temp4 first:)))
			temp88
			((= temp88 (temp4 next: temp88)))
			(= temp89 (NodeValue temp88))
			(temp89 move: (- (- (temp4 nsRight:) (temp89 nsRight:)) 4) 0)
		)
		;\Z
		(= temp3 (temp4 setSize: center: open: 0 -1 doit: 0))
		(if (IsObject temp3)
			(if (temp3 isKindOf: Unknown_Class_16)
				(= temp3 (temp3 value:))
			)
		else
			(if temp0
				(temp4 dispose:)
				(return 64537)
			else
				(= temp3 999)
			)
		)
		(temp4
			eachElementDo: 111 1
			dispose:
		)
		(return temp3)
	)

	(method (doChild param1 &tmp temp0)
		(= temp0 0)
		(asm
		code_967:
			(+at.b 0)
			(bnt.b code_1027)
			(push2 )
			(pTos.b 24)
			(push )
			(calle.w 999 6 4)
			(push )
			(lap.b 1)
			(eq? )
			(bnt.b code_1009)
			(pushi.w 606)
			(push2 )
			(push2 )
			(pTos.b 22)
			(lst.b 0)
			(calle.w 999 6 4)
			(push )
			(push1 )
			(self 8)
			(ldi.b 1)
			(ret )
		code_1009:
			(push2 )
			(pTos.b 24)
			(lst.b 0)
			(calle.w 999 6 4)
			(push )
			(ldi.w 999)
			(lt? )
			(jmp.b code_967)
		code_1027:
			(ldi.b 1)
			(ret )
		)
	)

	(method (doParent)
		(self stuffArray: (proc999_6 curArray 0) 0)
	)

	(method (stuffArray param1 param2)
		(if param2
			(localproc_0 param1 0 curArray)
		)
		(= curArray param1)
		(return param2)
	)
)
