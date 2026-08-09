;;; Sierra Script 1.0 - (do not remove this comment)
;;; scc 0.1.0 (qfg1vga) - decompiled from 203.scr, 203.hep on 2026-08-04
;;; Verified: recompiling this file reproduces the original bytes,
;;; exactly. Edits are safe to recompile; the guarantee is the round
;;; trip, not the formatting.
;;; All 19 functions recovered as Sierra Script.
(script# 203)
(include scc.sh)

(public
	chAlloc 0
)

(local
	local0 = 999
	local1
	local2 = 1
	local3 = 2
	local4 = 3
	local5 = 4
	local6 = 12
	local7 = 5
	local8 = 6
	local9 = 7
	local10 = 8
	local11 = 9
	local12 = 10
	local13 = 11
	;Z Hebrew/RTL stat row Y coordinates.
	local14 = 30
	local15 = 42
	local16 = 54
	local17 = 66
	local18 = 78
	local19 = 90
	local20 = 102
	local21 = 42
	local22 = 54
	local23 = 66
	local24 = 78
	local25 = 90
	local26 = 102
	local27 = 113
	;Z Hebrew/RTL stat row X coordinates.
	local28 = 303
	local29 = 303
	local30 = 301
	local31 = 306
	local32 = 304
	local33 = 302
	local34 = 304
	local35 = 197
	local36 = 199
	local37 = 199
	local38 = 198
	local39 = 199
	local40 = 200
	local41 = 199
	;Z Hebrew/RTL stat number X positions used by selectionIcon::highlight.
	local42 = 215
	local43 = 215
	local44 = 215
	local45 = 215
	local46 = 215
	local47 = 215
	local48 = 215
	local49 = 100
	local50 = 100
	local51 = 100
	local52 = 100
	local53 = 100
	local54 = 100
	local55 = 100
	;Z Hebrew/RTL large-letter cell mapping.
	local56
	local57 = 1
	local58 = 2
	local59 = 3
	local60 = 4
	local61 = 5
	local62 = 6
	local63 = 2
	local64 = 7
	local65 = 7
	local66 = 8
	local67 = 9
	local68 = 6
	local69 = 10
	local70
	local71 = 25
	local72 = 10
	local73 = 15
	local74 = 15
	local75 = 10
	local76
	local77 = 20
	local78 = 15
	local79 = 10
	local80
	local81
	local82 = 10
	local83
	local84
	local85 = 10
	local86 = 25
	local87 = 15
	local88 = 15
	local89 = 10
	local90 = 25
	local91 = 10
	local92
	local93 = 15
	local94
	local95
	local96
	local97
	local98
	local99 = 10
	local100 = 15
	local101 = 25
	local102 = 10
	local103 = 10
	local104
	local105 = 10
	local106
	local107 = 5
	local108 = 10
	local109 = 10
	local110 = 5
	local111 = 5
	local112 = 67
	local113 = 78
	local114 = 68
	local115 = 20
	local116 = 23
	local117 = 27
	local118 = 1
	local119
	local120 = 50
	local121
	local122
	local123
	local124
	local125
	local126
	local127
	local128
	local129
	local130
	local131
	local132
	local133
	local134
	local135
	local136
	local137
	local138
	local139
	local140
	local141
	local142
	local143
	local144
	local145
	local146
	local147
	local148
	local149
)

(procedure (localproc_0 param1)
	;Z Hebrew/RTL points display moved left.
	(Display &rest dsCOORD 190 param1 dsCOLOR 215 dsWIDTH 30 dsALIGN 1 dsFONT 123)
	(Display &rest dsCOORD 189 param1 dsCOLOR 91 dsWIDTH 30 dsALIGN 1 dsFONT 123)
)

(procedure (localproc_1 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp4 1)
	(while (< temp4 14)
		(= [global125 [local0 temp4]] [local121 temp4])
		(++ temp4)
	)
	;Z Hebrew/RTL points display moved left.
	(DrawCel 802 8 1 185 142 15)
	(Format @temp0 "%d" local120)
	(if local120
		(Display @temp0 dsCOORD 190 141 dsCOLOR 215 dsWIDTH 30 dsALIGN 1 dsFONT 123)
		(Display @temp0 dsCOORD 189 141 dsCOLOR 50 dsWIDTH 30 dsALIGN 1 dsFONT 123)
	else
		(localproc_0 141 @temp0)
	)
	(DrawCel 802 8 1 185 154 15)
	(localproc_0 153 (Format @temp0 "%d" (= [global125 14] (/ (+ (proc814_21) 1) 2))))
	(DrawCel 802 8 1 185 166 15)
	(localproc_0 165 (Format @temp0 "%d" (= [global125 15] (/ (+ (proc814_20) 3) 4))))
	(DrawCel 802 8 1 185 178 15)
	(localproc_0 177 (Format @temp0 "%d" (= [global125 16] (proc814_22))))
)

(instance chAlloc of Rm
	(properties)

	(method (init)
		(super init: &rest)
		(pointsAvail init:)
		(= global428 0)
		(self setScript: selectChar)
	)

	(method (dispose &tmp temp0)
		(startControls
			eachElementDo: 111
			dispose:
			release:
		)
		(= [global125 14] (proc814_21))
		(= [global125 15] (proc814_20))
		(= [global125 16] (proc814_22))
		(= temp0 0)
		(while (< temp0 25)
			(= [global201 temp0] [global125 temp0])
			(++ temp0)
		)
		(= global424 global15)
		(super dispose:)
	)
)

(instance selectChar of Script
	(properties)

	(method (changeState param1)
		(= nsTop param1)
		(switch nsTop
			(0
				(global69 disable:)
				(= nsRight 2)
			)
			(1
				(theChar
					cel: global122
					init:
				)
				(global2 drawPic: (global2 picture:) 9)
				(= lsBottom 60)
			)
			(2
				(startControls
					init:
					show:
				)
				(global69 enable:)
				(self dispose:)
			)
		)
	)

	(method (handleEvent param1)
		(param1 claimed: 1)
	)
)

(instance startControls of GameControls
	(properties)

	(method (init &tmp temp0)
		(self add: namePlate)
		(= temp0 1)
		(while (< temp0 14)
			(self add: ((selectionIcon new:) nsLeft: [local28 temp0] nsTop: [local14 temp0] cel: [local56 temp0] maskCel: [local56 temp0] state: temp0 yourself:))
			(= [local135 temp0] [local70 (+ temp0 (* global122 14))])
			(= [local121 temp0] [local70 (+ temp0 (* global122 14))])
			(++ temp0)
		)
		(self add: (startIcon theObj: startCode selector: 57 yourself:) (cancelIcon theObj: cancelCode selector: 57 yourself:))
		(super init: &rest)
	)

	(method (show)
		(= name (| name 32))
		(self eachElementDo: 216)
		((= lsLeft (= lsBottom (self at: 0))) highlight: 1)
		(DrawCel 802 5 0 1 148 15)
		(localproc_1)
		(proc0_6 359)
		(global1 setCursor: 999 1 (+ (lsLeft nsLeft:) 5) (- (lsLeft nsBottom:) 2))
		(self
			doit:
			hide:
		)
	)

	(method (dispatchEvent param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(if local149
			(global2 newRoom: local149)
			(param1 dispose:)
			(return 1)
		)
		(= temp0 (param1 x:))
		(= temp1 (param1 y:))
		(= temp2 (param1 type:))
		(= temp3 (param1 message:))
		(= temp4 0)
		(= temp5 (param1 modifiers:))
		(= temp6 (self firstTrue: 218 param1))
		(param1 dispose:)
		(if (& temp2 64)
			(switch temp3
				(3
					(if lsBottom
						(if (lsBottom state:)
							(self select: temp6 1)
							(global416
								number: 63
								loop: 1
								play:
							)
						)
					)
				)
				(7
					(if lsBottom
						(if (lsBottom state:)
							(self select: temp6 0)
							(global416
								number: 63
								loop: 1
								play:
							)
						)
					)
				)
				(1
					(if (not lsBottom)
						(= lsBottom (self at: (- nsTop 1)))
					)
					(self retreat:)
				)
				(5
					(if (not lsBottom)
						(= lsBottom (self at: 0))
					)
					(self advance:)
				)
				(2
					(if (temp6 state:)
						(self select: temp6 3)
						(global416
							number: 63
							loop: 1
							play:
						)
					)
				)
				(4
					(if (temp6 state:)
						(self select: temp6 2)
						(global416
							number: 63
							loop: 1
							play:
						)
					)
				)
			)
		else
			(if (== temp2 0)
				(if (not (IsObject temp6))
					(if (IsObject lsBottom)
						(lsBottom highlight: 0)
						(= lsBottom 0)
					)
				else
					(if temp6
						(if (!= temp6 lsBottom)
							(= lsTop 0)
							(self highlight: temp6)
						)
					)
				)
			else
				(if (not (IsObject lsBottom))
					0
				else
					(if (== temp2 1)
						(if (== lsBottom namePlate)
							0
						else
							(if (not (temp6 state:))
								(if (== temp6 startIcon)
									(startCode doit:)
								else
									(if (== temp6 cancelIcon)
										(cancelCode doit:)
									else
										(self select: temp6 1)
									)
								)
							else
								(if (== temp5 3)
									(self select: temp6 1)
									(global416
										number: 63
										loop: 1
										play:
									)
								else
									(self select: temp6 0)
									(global416
										number: 63
										loop: 1
										play:
									)
								)
							)
						)
					else
						(if (== temp2 4)
							(switch temp3
								(27
									(cancelCode doit:)
								)
								(13
									(if (== lsBottom startIcon)
										(startCode doit:)
									else
										(if (== lsBottom cancelIcon)
											(cancelCode doit:)
										)
									)
								)
								(9
									(= temp7 (lsBottom state:))
									(if (< temp7 1)
										0
									else
										(= temp7 (lsBottom state:))
										(if (< temp7 7)
											(lsBottom highlight: 0)
											(= lsBottom (self at: (+ temp7 5)))
											(self advance:)
										else
											(if (< temp7 13)
												(lsBottom highlight: 0)
												(= lsBottom (self at: (- temp7 5)))
												(self retreat:)
											)
										)
									)
								)
								(else
									(if (!= lsBottom namePlate)
										0
									else
										;Z Accept Hebrew letter keycodes during character-name entry.
										(if (or (<= 97 temp3 122) (<= 65 temp3 90) (<= 48 temp3 57) (<= 224 temp3 250))
											(self select: namePlate temp3)
										else
											(if (== temp3 32)
												(self select: namePlate temp3)
											else
												(if (and (== temp3 8) local119)
													(self select: namePlate temp3)
												)
											)
										)
									)
								)
							)
						)
					)
				)
			)
		)
		(return temp4)
	)
)

(instance selectionIcon of selectionIcon_binding
	(properties)

	(method (show)
		(self highlight: 0)
		(= lsTop (+ nsBottom (if (< lsBottom 7) 102 else 111 )))
		(= lsLeft (+ nsRight 12))
	)

	;Z Expand hit testing leftward so the mirrored large letter selects the row.
	(method (onMe param1)
		(return
			(if
				(and
					(>= (param1 x:) (- nsBottom 95))
					(>= (param1 y:) nsRight)
					(<= (param1 x:) (+ nsBottom 10))
				)
				(<= (param1 y:) lsLeft)
			else
				0
			)
		)
	)

	(method (select param1)
		(if (super select: &rest)
			(switch param1
				(1
					(if (not local120)
						0
					else
						(if (< local120 5)
							(= [local121 lsBottom] (+ [local121 lsBottom] local120))
							(= local120 0)
						else
							(if (not [local121 lsBottom])
								(if (>= local120 15)
									(= [local121 lsBottom] (+ [local121 lsBottom] 5))
									(= local120 (- local120 15))
								)
							else
								(= [local121 lsBottom] (+ [local121 lsBottom] 5))
								(= local120 (- local120 5))
							)
						)
					)
				)
				(0
					(if (== [local121 lsBottom] [local135 lsBottom])
						0
					else
						(if (and (== [local121 lsBottom] 5) (not [local135 lsBottom]))
							(= [local121 lsBottom] 0)
							(= local120 (+ local120 15))
						else
							(= [local121 lsBottom] (- [local121 lsBottom] 5))
							(= local120 (+ local120 5))
						)
					)
				)
				(3
					(if (not local120)
						0
					else
						(if (not [local121 lsBottom])
							0
						else
							(= [local121 lsBottom] (+ [local121 lsBottom] 1))
							(= local120 (- local120 1))
						)
					)
				)
				(2
					(if (== [local121 lsBottom] [local135 lsBottom])
						0
					else
						(if (and (== [local121 lsBottom] 5) (not [local135 lsBottom]))
							(= [local121 lsBottom] 0)
							(= local120 (+ local120 15))
						else
							(= [local121 lsBottom] (- [local121 lsBottom] 1))
							(= local120 (+ local120 1))
						)
					)
				)
			)
			(self highlight: 1)
			(localproc_1)
			(return 1)
		else
			(return 0)
		)
	)

	(method (highlight param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		;Z Hebrew/RTL stat numbers are centered at mirrored fixed positions.
		(= temp0 [local42 lsBottom])
		(DrawCel underBits 8 (if (< lsBottom 7) 0 else 1 ) temp0 (+ nsRight 1) 15)
		(if param1
			(DrawCel underBits nsTop nsLeft nsBottom nsRight 15)
			(= temp5 50)
			(= temp6 215)
		else
			(DrawCel brBottom brRight name nsBottom nsRight 15)
			(= temp5 91)
			(= temp6 215)
		)
		(Display (Format @temp1 "%d" [local121 lsBottom]) dsCOORD (+ temp0 1) nsRight dsCOLOR temp6 dsWIDTH 25 dsALIGN 1 dsFONT 123)
		(Display (Format @temp1 "%d" [local121 lsBottom]) dsCOORD temp0 nsRight dsCOLOR temp5 dsWIDTH 25 dsALIGN 1 dsFONT 123)
	)
)

(instance startIcon of startIcon_binding
	(properties)

	(method (highlight param1)
		(if param1
			(DrawCel underBits nsTop 2 nsBottom nsRight 15)
		else
			(DrawCel underBits nsTop 0 nsBottom nsRight 15)
		)
	)
)

(instance cancelIcon of cancelIcon_binding
	(properties)

	(method (highlight param1)
		(if param1
			(DrawCel underBits nsTop 2 nsBottom nsRight 15)
		else
			(DrawCel underBits nsTop 0 nsBottom nsRight 15)
		)
	)
)

(instance namePlate of namePlate_binding
	(properties
		;Z Hebrew/RTL nameplate moved up by one pixel.
		nsRight 21
	)

	(method (show)
	)

	(method (select param1 &tmp temp0 temp1 temp2 temp3)
		(if (super select: &rest)
			(TextSize @[temp0 0] @global428 123 0)
			(if (and (== param1 8) local119)
				(StrAt @global428 (-- local119) 0)
				(DrawCel brBottom brRight name (+ nsBottom 11) nsRight 15)
				(self highlight: 1)
			else
				(if (<= [temp0 3] 150)
					(StrAt @global428 local119 param1)
					(StrAt @global428 (++ local119) 0)
					;Z Clear the mirrored nameplate text area before redrawing.
					(DrawCel brBottom brRight name (+ nsBottom 11) nsRight 15)
					(self highlight: 1)
					(self highlight: 1)
				else
					(return 1)
				)
			)
			(return 1)
		else
			(return 0)
		)
	)

	(method (highlight param1 &tmp temp0 temp1 temp2)
		(if param1
			(= temp2 nsTop)
			(= temp0 50)
			(= temp1 215)
		else
			(= temp2 2)
			(= temp0 91)
			(= temp1 215)
		)
		;Z Draw the large letter and name text in mirrored positions.
		(DrawCel underBits temp2 nsLeft (+ lsTop 2) (+ nsRight 2) 15)
		(Display @global428 dsCOORD (+ nsBottom 12) nsRight dsCOLOR temp1 dsWIDTH 172 dsALIGN 0 dsFONT 123)
		(Display @global428 dsCOORD (+ nsBottom 11) nsRight dsCOLOR temp0 dsWIDTH 172 dsALIGN 0 dsFONT 123)
	)
)

(instance theChar of theChar_binding
	(properties)
)

(instance pointsAvail of pointsAvail_binding
	(properties
		;Z Hebrew/RTL points-available icon position.
		underBits 195
		nsTop 142
	)
)

(instance cancelCode of cancelCode_binding
	(properties)

	(method (doit &tmp temp0 temp1 temp2)
		(if (= temp0 (Unknown_Class_20 font: global22 mode: 1 addText: 1 0 1 1 0 0 203 addButton: 0 1 0 1 2 37 30 203 addButton: 1 1 0 1 3 87 30 203 init:))
			(= local149 202)
		else
			(= temp2 (startControls curIcon:))
			(= temp1 1)
			(while (< temp1 14)
				(= [local135 temp1] [local70 (+ temp1 (* global122 14))])
				(= [local121 temp1] [local70 (+ temp1 (* global122 14))])
				(++ temp1)
			)
			(= global428 0)
			(= local119 global428)
			(DrawCel 802 9 0 146 22 15)
			(= local120 50)
			(localproc_1)
			(startControls eachElementDo: 217 0)
			(global1 setCursor: 999 1 (+ (temp2 nsLeft:) 5) (- (temp2 nsBottom:) 2))
			(temp2 highlight: 1)
		)
	)
)

(instance startCode of startCode_binding
	(properties)

	(method (doit &tmp temp0)
		(= temp0 1)
		(if local120
			(= temp0 (Unknown_Class_20 font: global22 mode: 1 addText: 1 0 2 1 0 0 203 addButton: 0 1 0 2 2 37 20 203 addButton: 1 1 0 2 3 45 40 203 init:))
		)
		(if temp0
			(= local149 300)
			(switch global122
				(0
					(global0
						get: 2
						get: 5
					)
				)
				(1
					(global0
						get: 6
						learn: 21 10
					)
				)
				(2
					(global0
						get: 6
						get: 7
					)
					(= global175 10)
				)
			)
		)
	)
)

