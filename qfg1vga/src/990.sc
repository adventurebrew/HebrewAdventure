;;; Sierra Script 1.0 - (do not remove this comment)
;;; scc 0.1.0 (qfg1vga) - decompiled from 990.scr, 990.hep on 2026-08-05
;;; Verified: recompiling this file reproduces the original bytes,
;;; exactly. Edits are safe to recompile; the guarantee is the round
;;; trip, not the formatting.
;;; 17 of 18 functions are Sierra Script. The other 1 could not be
;;; recovered and stay as (asm ...) -- each has its decompiled form,
;;; unverified, in a comment above it.
(script# 990)
(include scc.sh)

(public
	localproc_1 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	;Z Hebrew save/restore dialog labels.
	local6 = {טעינה}
	local7 = {שמירה}
	local8 = {החלפה}
	local9 = {החלפה}
	local10 = {בחר את השמירה שברצונך לטעון.}
	local11 = {הקש את תיאור המשחק השמור.}
	local12 = "This directory/disk can hold no more saved games. You must replace one of your saved games or use Change Directory to save on a different directory/disk."
	local13 = "This directory/disk can hold no more saved games. You must replace one of your saved games or use Change Directory to save on a different directory/disk."
)

(procedure (localproc_0)
	(if (== self Unknown_Class_61)
		0
	else
		(if (localproc_2)
			1
		else
			(if local3
				2
			else
				3
			)
		)
	)
)

(procedure (localproc_1 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21 temp22 temp23 temp24 temp25 temp26 temp27 temp28 temp29 temp30 temp31 temp32 temp33 temp34 temp35 temp36 temp37 temp38 temp39 temp40 temp41 temp42 temp43 temp44 temp45 temp46 temp47 temp48 temp49 temp50 temp51 temp52 temp53 temp54 temp55 temp56 temp57 temp58 temp59 temp60 temp61 temp62 temp63 temp64 temp65 temp66 temp67 temp68 temp69 temp70 temp71 temp72 temp73 temp74 temp75 temp76 temp77 temp78 temp79 temp80 temp81 temp82 temp83 temp84 temp85 temp86 temp87 temp88 temp89 temp90 temp91 temp92 temp93 temp94 temp95 temp96 temp97 temp98 temp99 temp100 temp101 temp102 temp103 temp104 temp105 temp106 temp107 temp108 temp109 temp110 temp111 temp112 temp113 temp114 temp115 temp116 temp117 temp118 temp119 temp120 temp121 temp122 temp123 temp124 temp125 temp126 temp127 temp128 temp129 temp130 temp131 temp132 temp133 temp134 temp135 temp136 temp137 temp138 temp139 temp140 temp141 temp142 temp143 temp144 temp145 temp146 temp147 temp148 temp149 temp150 temp151 temp152 temp153 temp154 temp155 temp156 temp157 temp158 temp159 temp160 temp161 temp162 temp163 temp164 temp165 temp166 temp167 temp168 temp169 temp170 temp171 temp172 temp173 temp174 temp175 temp176 temp177 temp178 temp179 temp180 temp181 temp182 temp183 temp184 temp185 temp186 temp187 temp188 temp189 temp190 temp191 temp192 temp193 temp194 temp195 temp196 temp197 temp198 temp199 temp200 temp201 temp202 temp203 temp204 temp205 temp206 temp207 temp208 temp209 temp210 temp211 temp212 temp213 temp214 temp215 temp216 temp217 temp218 temp219 temp220 temp221 temp222 temp223 temp224 temp225 temp226 temp227 temp228 temp229 temp230 temp231 temp232 temp233 temp234 temp235 temp236 temp237 temp238 temp239 temp240 temp241 temp242 temp243 temp244)
	(repeat
		(= temp134 (global1 parseLang:))
		(global1 parseLang: 1)
		(Message msgGET 990 1 0 0 1 @temp135)
		(Message msgGET 990 4 0 0 1 @temp235)
		(Message msgGET 990 5 0 0 1 @temp240)
		(= temp0 (Unknown_Class_20 font: 0 addText: @temp135 addEdit: (StrCpy @temp1 param1) 29 0 12 param1 addButton: 1 @temp235 0 26 addButton: 0 @temp240 50 26 init:))
		(global1 parseLang: temp134)
		(if (not temp0)
			(return 0)
		)
		(if (not (StrLen @temp1))
			(GetCWD @temp1)
		)
		(if (ValidPath @temp1)
			(StrCpy param1 @temp1)
			(return 1)
		else
			(Message msgGET 990 2 0 0 1 @temp135)
			(Format @temp34 @temp135 @temp1)
			(Unknown_Class_20
				font: 0
				addText: @temp34
				init:
			)
		)
	)
)

(procedure (localproc_2)
	(if (< local3 20)
		(CheckFreeSpace global29)
	)
)

(procedure (localproc_3 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21 temp22 temp23 temp24 temp25 temp26 temp27 temp28 temp29 temp30 temp31 temp32 temp33 temp34 temp35 temp36 temp37 temp38 temp39 temp40 temp41 temp42 temp43 temp44 temp45 temp46 temp47 temp48 temp49 temp50 temp51 temp52 temp53 temp54 temp55 temp56 temp57 temp58 temp59 temp60 temp61 temp62 temp63 temp64 temp65 temp66 temp67 temp68 temp69 temp70 temp71 temp72 temp73 temp74 temp75 temp76 temp77 temp78 temp79 temp80 temp81 temp82 temp83 temp84 temp85 temp86 temp87 temp88 temp89 temp90 temp91 temp92 temp93 temp94 temp95 temp96 temp97 temp98 temp99)
	(Message msgGET 990 3 0 0 1 @temp0)
	(Unknown_Class_20
		font: 0
		addText: @temp0
		init:
	)
)

(class SRDialog
	(properties)

	(method (dispose)
		(proc932_4)
		(global1 parseLang: local0)
		(super dispose: &rest)
	)

	(method (init param1 param2 param3)
		(proc932_3)
		(= local0 (global1 parseLang:))
		(global1 parseLang: 1)
		(= window global38)
		(= nsBottom 0)
		(= local3 (GetSaveFiles (global1 name:) param2 param3))
		(if (== local3 -1)
			(return 0)
		)
		(= local5 (localproc_0))
		(if (== local5 1)
			(editI
				text: (StrCpy param1 param2)
				font: global23
				setSize:
				moveTo: 4 4
			)
			(self
				add: editI
				setSize:
			)
		)
		;Z Relocate the action buttons to the left of the saves list and omit
		;Z Change Directory, which is not useful in ScummVM.
		(okI
			text: [local6 local5]
			setSize:
			moveTo: 4 (+ nsBottom 4)
			state: (if (or (and (== local5 0) (not local3)) (== local5 3)) 0 else 3 )
		)
		(deleteI
			setSize:
			moveTo: 4 (+ (okI nsBottom:) 4)
			state: (if (not local3) 0 else 3 )
		)
		(cancelI
			setSize:
			moveTo: 4 (+ (deleteI nsBottom:) 4)
			state: (& (cancelI state:) -9)
		)
		(selectorI
			text: param2
			font: global23
			setSize:
			moveTo: (+ (okI nsRight:) 4) (okI nsTop:)
			state: 2
		)
		;Z Right-align the edit line for Hebrew.
		(editI move: (- nsRight (editI nsRight:)) 0)
		(self
			add: selectorI okI deleteI cancelI
			setSize:
		)
		(textI
			text: [local10 local5]
			setSize: (- nsRight nsLeft 8)
			moveTo: 4 4
		)
		(= local2 (+ (textI nsBottom:) 4))
		(self eachElementDo: 181 0 local2)
		(self
			add: textI
			setSize:
			center:
			open: 4 -1
		)
		(return 1)
	)

	(method (doit param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21 temp22 temp23 temp24 temp25 temp26 temp27 temp28 temp29 temp30 temp31 temp32 temp33 temp34 temp35 temp36 temp37 temp38 temp39 temp40 temp41 temp42 temp43 temp44 temp45 temp46 temp47 temp48 temp49 temp50 temp51 temp52 temp53 temp54 temp55 temp56 temp57 temp58 temp59 temp60 temp61 temp62 temp63 temp64 temp65 temp66 temp67 temp68 temp69 temp70 temp71 temp72 temp73 temp74 temp75 temp76 temp77 temp78 temp79 temp80 temp81 temp82 temp83 temp84 temp85 temp86 temp87 temp88 temp89 temp90 temp91 temp92 temp93 temp94 temp95 temp96 temp97 temp98 temp99 temp100 temp101 temp102 temp103 temp104 temp105 temp106 temp107 temp108 temp109 temp110 temp111 temp112 temp113 temp114 temp115 temp116 temp117 temp118 temp119 temp120 temp121 temp122 temp123 temp124 temp125 temp126 temp127 temp128 temp129 temp130 temp131 temp132 temp133 temp134 temp135 temp136 temp137 temp138 temp139 temp140 temp141 temp142 temp143 temp144 temp145 temp146 temp147 temp148 temp149 temp150 temp151 temp152 temp153 temp154 temp155 temp156 temp157 temp158 temp159 temp160 temp161 temp162 temp163 temp164 temp165 temp166 temp167 temp168 temp169 temp170 temp171 temp172 temp173 temp174 temp175 temp176 temp177 temp178 temp179 temp180 temp181 temp182 temp183 temp184 temp185 temp186 temp187 temp188 temp189 temp190 temp191 temp192 temp193 temp194 temp195 temp196 temp197 temp198 temp199 temp200 temp201 temp202 temp203 temp204 temp205 temp206 temp207 temp208 temp209 temp210 temp211 temp212 temp213 temp214 temp215 temp216 temp217 temp218 temp219 temp220 temp221 temp222 temp223 temp224 temp225 temp226 temp227 temp228 temp229 temp230 temp231 temp232 temp233 temp234 temp235 temp236 temp237 temp238 temp239 temp240 temp241 temp242 temp243 temp244 temp245 temp246 temp247 temp248 temp249 temp250 temp251 temp252 temp253 temp254 temp255 temp256 temp257 temp258 temp259 temp260 temp261 temp262 temp263 temp264 temp265 temp266 temp267 temp268 temp269 temp270 temp271 temp272 temp273 temp274 temp275 temp276 temp277 temp278 temp279 temp280 temp281 temp282 temp283 temp284 temp285 temp286 temp287 temp288 temp289 temp290 temp291 temp292 temp293 temp294 temp295 temp296 temp297 temp298 temp299 temp300 temp301 temp302 temp303 temp304 temp305 temp306 temp307 temp308 temp309 temp310 temp311 temp312 temp313 temp314 temp315 temp316 temp317 temp318 temp319 temp320 temp321 temp322 temp323 temp324 temp325 temp326 temp327 temp328 temp329 temp330 temp331 temp332 temp333 temp334 temp335 temp336 temp337 temp338 temp339 temp340 temp341 temp342 temp343 temp344 temp345 temp346 temp347 temp348 temp349 temp350 temp351 temp352 temp353 temp354 temp355 temp356 temp357 temp358 temp359 temp360 temp361 temp362 temp363 temp364 temp365 temp366 temp367 temp368 temp369 temp370 temp371 temp372 temp373 temp374 temp375 temp376 temp377 temp378 temp379 temp380 temp381 temp382 temp383 temp384 temp385 temp386 temp387 temp388 temp389 temp390 temp391 temp392 temp393 temp394 temp395 temp396 temp397 temp398 temp399 temp400 temp401 temp402 temp403 temp404 temp405 temp406 temp407 temp408 temp409 temp410 temp411 temp412 temp413 temp414 temp415 temp416 temp417 temp418 temp419 temp420 temp421 temp422 temp423 temp424 temp425 temp426 temp427 temp428 temp429 temp430 temp431 temp432 temp433 temp434 temp435 temp436 temp437 temp438 temp439 temp440 temp441 temp442 temp443 temp444 temp445 temp446 temp447 temp448 temp449 temp450 temp451 temp452 temp453 temp454 temp455 temp456 temp457 temp458 temp459 temp460 temp461 temp462 temp463 temp464 temp465 temp466 temp467 temp468 temp469 temp470 temp471 temp472 temp473 temp474 temp475 temp476 temp477 temp478 temp479 temp480 temp481 temp482 temp483 temp484 temp485 temp486 temp487 temp488 temp489 temp490 temp491 temp492 temp493 temp494 temp495 temp496 temp497 temp498 temp499 temp500 temp501 temp502 temp503 temp504 temp505 temp506 temp507 temp508 temp509 temp510 temp511 temp512 temp513 temp514 temp515 temp516 temp517 temp518 temp519 temp520 temp521 temp522 temp523 temp524)
		(if (and (== self Unknown_Class_61) argc param1)
			(= temp0 (FileIO 0 (Format @temp385 990 0 (global1 name:))))
			(if (== temp0 -1)
				(return)
			)
			(FileIO 1 temp0)
		)
		(if (not (self init: param1 @temp3 @temp364))
			(return -1)
		)
		(asm
		code_836:
			(lsl.b 5)
			(dup )
			(ldi.b 0)
			(eq? )
			(bnt.b code_858)
			(lal.b 3)
			(bnt.b code_853)
			(lofsa.w okI)
			(jmp.b code_883)
		code_853:
			(lofsa.w changeDirI)
			(jmp.b code_883)
		code_858:
			(dup )
			(ldi.b 1)
			(eq? )
			(bnt.b code_869)
			(lofsa.w editI)
			(jmp.b code_883)
		code_869:
			(dup )
			(ldi.b 2)
			(eq? )
			(bnt.b code_880)
			(lofsa.w okI)
			(jmp.b code_883)
		code_880:
			(lofsa.w changeDirI)
		code_883:
			(toss )
			(sal.b 1)
			(pushi.b 57)
			(push1 )
			(push )
			(super.b 14 6)
			(sal.b 2)
			(pushi.w 132)
			(push1 )
			(pushi.b 33)
			(push0 )
			(lofsa.w selectorI)
			(send 4)
			(push )
			(lofsa.w selectorI)
			(send 6)
			(sal.b 4)
			(push )
			(ldi.b 18)
			(mul )
			(sat.b 2)
			(lsl.b 2)
			(lofsa.w changeDirI)
			(eq? )
			(bnt.b code_1002)
			(pushi.b 111)
			(push0 )
			(self 4)
			(push1 )
			(lsg.b 29)
			(call.w localproc_1 2)
			(bnt.b code_981)
			(pushi.b 3)
			(pushi.b 20)
			(push0 )
			(lag.b 1)
			(send 4)
			(push )
			(lea.b 4 3)
			(push )
			(lea.w 4 364)
			(push )
			(callk.b GetSaveFiles 6)
			(sal.b 3)
			(push )
			(ldi.b 255)
			(eq? )
			(bnt.b code_981)
			(ldi.b 255)
			(sat.b 1)
			(jmp.w code_1632)
		code_981:
			(pushi.b 110)
			(pushi.b 3)
			(lsp.b 1)
			(lea.b 4 3)
			(push )
			(lea.w 4 364)
			(push )
			(self 10)
			(jmp.w code_836)
		code_1002:
			(lsl.b 5)
			(ldi.b 2)
			(eq? )
			(bnt.b code_1076)
			(lsl.b 2)
			(lofsa.w okI)
			(eq? )
			(bnt.b code_1076)
			(pushi.b 111)
			(push0 )
			(self 4)
			(pushi.b 57)
			(push1 )
			(push2 )
			(lsp.b 1)
			(lat.b 2)
			(lea.b 20 3)
			(push )
			(callk.b StrCpy 4)
			(push )
			(lofsa.w GetReplaceName)
			(send 6)
			(bnt.b code_1055)
			(lal.b 4)
			(lati.w 364)
			(sat.b 1)
			(jmp.w code_1632)
		code_1055:
			(pushi.b 110)
			(pushi.b 3)
			(lsp.b 1)
			(lea.b 4 3)
			(push )
			(lea.w 4 364)
			(push )
			(self 10)
			(jmp.w code_836)
		code_1076:
			(lsl.b 5)
			(ldi.b 1)
			(eq? )
			(bnt.w code_1269)
			(lsl.b 2)
			(lofsa.w okI)
			(eq? )
			(bt.b code_1098)
			(lsl.b 2)
			(lofsa.w editI)
			(eq? )
		code_1098:
			(bnt.w code_1269)
			(push1 )
			(lsp.b 1)
			(callk.b StrLen 2)
			(push )
			(ldi.b 0)
			(eq? )
			(bnt.b code_1144)
			(pushi.b 111)
			(push0 )
			(self 4)
			(push0 )
			(call.w localproc_3 0)
			(pushi.b 110)
			(pushi.b 3)
			(lsp.b 1)
			(lea.b 4 3)
			(push )
			(lea.w 4 364)
			(push )
			(self 10)
			(jmp.w code_836)
		code_1144:
			(ldi.b 255)
			(sat.b 1)
			(ldi.b 0)
			(sal.b 2)
		code_1152:
			(lsl.b 2)
			(lal.b 3)
			(lt? )
			(bnt.b code_1183)
			(push2 )
			(lsp.b 1)
			(lsl.b 2)
			(ldi.b 18)
			(mul )
			(lea.b 20 3)
			(push )
			(callk.b StrCmp 4)
			(sat.b 1)
			(not )
			(bt.b code_1183)
			(+al.b 2)
			(jmp.b code_1152)
		code_1183:
			(lat.b 1)
			(not )
			(bnt.b code_1198)
			(lal.b 2)
			(lati.w 364)
			(sat.b 1)
			(jmp.w code_1632)
		code_1198:
			(lsl.b 3)
			(ldi.b 20)
			(eq? )
			(bnt.b code_1215)
			(lal.b 4)
			(lati.w 364)
			(sat.b 1)
			(jmp.w code_1632)
		code_1215:
			(ldi.b 0)
			(sat.b 1)
		code_1219:
			(ldi.b 1)
			(bnt.w code_1632)
			(ldi.b 0)
			(sal.b 2)
		code_1228:
			(lsl.b 2)
			(lal.b 3)
			(lt? )
			(bnt.b code_1249)
			(lst.b 1)
			(lal.b 2)
			(lati.w 364)
			(eq? )
			(bt.b code_1249)
			(+al.b 2)
			(jmp.b code_1228)
		code_1249:
			(lsl.b 2)
			(lal.b 3)
			(eq? )
			(bnt.b code_1259)
			(jmp.w code_1632)
		code_1259:
			(+at.b 1)
			(jmp.b code_1219)
			(jmp.w code_1632)
			(jmp.w code_836)
		code_1269:
			(lsl.b 2)
			(lofsa.w deleteI)
			(eq? )
			(bnt.w code_1548)
			(pushi.b 111)
			(push0 )
			(self 4)
			(pushi.w 198)
			(push1 )
			;Z Hebrew delete-confirmation prompt.
			(lofsa.w {האם אתה בטוח שאתה רוצה למחוק את המשחק השמור הזה?})
			(push )
			(pushi.w 205)
			(pushi.b 4)
			(push0 )
			;Z Hebrew no button.
			(lofsa.w {לא})
			(push )
			(pushi.b 15)
			(pushi.b 27)
			(pushi.w 205)
			(pushi.b 4)
			(push1 )
			;Z Hebrew yes button.
			(lofsa.w {כן})
			(push )
			(pushi.b 70)
			(pushi.b 27)
			(pushi.b 110)
			(push0 )
			(class.b 20)
			(send 34)
			(not )
			(bnt.b code_1350)
			(pushi.b 110)
			(pushi.b 3)
			(lsp.b 1)
			(lea.b 4 3)
			(push )
			(lea.w 4 364)
			(push )
			(self 10)
			(jmp.w code_836)
		code_1350:
			(pushi.b 20)
			(push1 )
			(pushi.b 3)
			(pushi.b 7)
			(lea.w 4 385)
			(push )
			(pushi.b 20)
			(push0 )
			(lag.b 1)
			(send 4)
			(push )
			(callk.b DeviceInfo 6)
			(push )
			(pushi.w 189)
			(push1 )
			(push2 )
			(pushi.b 109)
			(push0 )
			(class.b 56)
			(send 4)
			(sat.b 0)
			(send 12)
			(ldi.w 2570)
			(sat.b 1)
			(ldi.b 0)
			(sal.b 2)
		code_1400:
			(lsl.b 2)
			(lal.b 3)
			(lt? )
			(bnt.b code_1465)
			(lsl.b 2)
			(lal.b 4)
			(ne? )
			(bnt.b code_1461)
			(pushi.w 357)
			(push2 )
			(lal.b 2)
			(lea.w 20 364)
			(push )
			(push2 )
			(lat.b 0)
			(send 8)
			(pushi.w 356)
			(push1 )
			(lsl.b 2)
			(ldi.b 18)
			(mul )
			(lea.b 20 3)
			(push )
			(lat.b 0)
			(send 6)
			(pushi.w 357)
			(push2 )
			(lea.b 4 1)
			(push )
			(push1 )
			(lat.b 0)
			(send 8)
		code_1461:
			(+al.b 2)
			(jmp.b code_1400)
		code_1465:
			(ldi.b 255)
			(sat.b 1)
			(pushi.w 357)
			(push2 )
			(lea.b 4 1)
			(push )
			(push2 )
			(pushi.w 360)
			(push0 )
			(pushi.b 111)
			(push0 )
			(lat.b 0)
			(send 16)
			(pushi.b 4)
			(pushi.b 8)
			(lea.w 4 385)
			(push )
			(pushi.b 20)
			(push0 )
			(lag.b 1)
			(send 4)
			(push )
			(lal.b 4)
			(lsti.w 364)
			(callk.b DeviceInfo 8)
			(push2 )
			(pushi.b 4)
			(lea.w 4 385)
			(push )
			(callk.b FileIO 4)
			(pushi.b 110)
			(pushi.b 3)
			(lsp.b 1)
			(lea.b 4 3)
			(push )
			(lea.w 4 364)
			(push )
			(self 10)
			(jmp.w code_836)
		code_1548:
			(lsl.b 2)
			(lofsa.w okI)
			(eq? )
			(bnt.b code_1568)
			(lal.b 4)
			(lati.w 364)
			(sat.b 1)
			(jmp.b code_1632)
			(jmp.w code_836)
		code_1568:
			(lsl.b 2)
			(ldi.b 255)
			(eq? )
			(bt.b code_1581)
			(lsl.b 2)
			(lofsa.w cancelI)
			(eq? )
		code_1581:
			(bnt.b code_1592)
			(ldi.b 255)
			(sat.b 1)
			(jmp.b code_1632)
			(jmp.w code_836)
		code_1592:
			(lsl.b 5)
			(ldi.b 1)
			(eq? )
			(bnt.w code_836)
			(pushi.b 33)
			(push1 )
			(push1 )
			(push2 )
			(lsp.b 1)
			(lat.b 2)
			(lea.b 20 3)
			(push )
			(callk.b StrCpy 4)
			(push )
			(callk.b StrLen 2)
			(push )
			(pushi.b 80)
			(push0 )
			(lofsa.w editI)
			(send 10)
			(jmp.w code_836)
		code_1632:
			(push1 )
			(pushi.w 993)
			(callk.b DisposeScript 2)
			(pushi.b 111)
			(push0 )
			(self 4)
			(push1 )
			(pushi.w 990)
			(callk.b DisposeScript 2)
			(lat.b 1)
			(ret )
		)
	)
)

(class Restore
	(properties
		;Z Hebrew restore dialog title.
		text {טעינת שמירה}
	)
)

(class Save
	(properties
		;Z Hebrew save dialog title.
		text {שמירת משחק}
	)
)

(instance GetReplaceName of GetReplaceName_binding
	(properties)

	(method (doit param1 &tmp temp0 temp1)
		(= temp1 (global1 parseLang:))
		(global1 parseLang: 1)
		(= nsRight global38)
		(text1
			setSize:
			moveTo: 4 4
		)
		(self
			add: text1
			setSize:
		)
		(oldName
			text: param1
			font: global23
			setSize:
			moveTo: 4 lsRight
		)
		(self
			add: oldName
			setSize:
		)
		(text2
			setSize:
			moveTo: 4 lsRight
		)
		(self
			add: text2
			setSize:
		)
		(newName
			text: param1
			font: global23
			setSize:
			moveTo: 4 lsRight
		)
		(self
			add: newName
			setSize:
		)
		(button1
			nsLeft: 0
			nsTop: 0
			setSize:
		)
		(button2
			nsLeft: 0
			nsTop: 0
			setSize:
		)
		(button2 moveTo: (- signal (+ (button2 nsRight:) 4)) lsRight)
		(button1 moveTo: (- (button2 nsLeft:) (+ (button1 nsRight:) 4)) lsRight)
		(self
			add: button1 button2
			setSize:
			center:
			open: 0 -1
		)
		(= temp0 (super doit: newName))
		(self dispose:)
		(if (not (StrLen param1))
			(localproc_3)
			(= temp0 0)
		)
		(global1 parseLang: temp1)
		(return (or (== temp0 newName) (== temp0 button1)))
	)
)

(instance selectorI of selectorI_binding
	(properties)
)

(instance editI of editI_binding
	(properties)
)

(instance okI of okI_binding
	(properties)

	(method (dispose)
		(super dispose: 1)
	)
)

(instance cancelI of cancelI_binding
	(properties
		;Z Hebrew cancel button text.
		signal {ביטול}
	)

	(method (dispose)
		(super dispose: 1)
	)
)

(instance changeDirI of changeDirI_binding
	(properties
		;Z Hebrew change-directory button text.
		signal {החלפת ספריה}
	)

	(method (dispose)
		(super dispose: 1)
	)
)

(instance deleteI of deleteI_binding
	(properties
		;Z Hebrew delete button text.
		signal {מחיקה}
	)

	(method (dispose)
		(super dispose: 1)
	)
)

(instance textI of textI_binding
	(properties)

	(method (dispose)
		(super dispose: 1)
	)
)

(instance text1 of text1_binding
	(properties
		;Z Hebrew replace dialog label.
		signal {החלפה}
	)

	(method (dispose)
		(super dispose: 1)
	)
)

(instance text2 of text2_binding
	(properties
		;Z Hebrew replacement target label.
		signal {עם:}
	)

	(method (dispose)
		(super dispose: 1)
	)
)

(instance oldName of oldName_binding
	(properties)

	(method (dispose)
		(super dispose: 1)
	)
)

(instance newName of newName_binding
	(properties)
)

(instance button1 of button1_binding
	(properties
		;Z Hebrew replace button text.
		signal {החלפה}
	)

	(method (dispose)
		(super dispose: 1)
	)
)

(instance button2 of button2_binding
	(properties
		;Z Hebrew cancel button text.
		signal {ביטול}
	)

	(method (dispose)
		(super dispose: 1)
	)
)
