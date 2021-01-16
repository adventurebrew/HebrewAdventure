;;; Sierra Script 1.0 - (do not remove this comment)
(script# 0)
(include sci.sh)
(use Class_255_0)
(use n958)
(use Sound)
(use SysWindow)
(use Jump)
(use Cycle)
(use gamefile)
(use Game)
(use InvI)
(use User)
(use TheMenuBar)
(use Feature)
(use Obj)

(public
	SQ3 0
	proc0_1 1
	proc0_2 2
	proc0_3 3
	proc0_4 4
	proc0_5 5
	proc0_6 6
	proc0_7 7
	proc0_8 8
	proc0_9 9
	proc0_10 10
	proc0_11 11
	proc0_12 12
	proc0_13 13
	proc0_14 14
	proc0_15 15
	proc0_16 16
	proc0_17 17
)

(local
	gEgo
	gGame
	global2
	global3 =  6
	global4
	gCast
	gRegions
	gTimers
	gSounds
	gInv
	gAddToPics
	gGNorth
	gNorth
	gTheGGNorth
	global14
	global15
	global16
	global17 =  7
	global18
	global19
	global20 =  999
	global21 =  997
	global22 =  1
	global23 =  4
	global24
	gTheNewDialog
	global26 =  1
	global27 =  12
	global28 =  {Space Quest \0B}
	gLocales
	global30
	global31
	global32
	global33
	global34
	global35
	global36
	global37
	global38
	global39
	global40
	global41
	global42
	global43
	global44
	global45
	global46
	global47
	global48
	global49
	global50 =  10
	gPicAngle
	gFeatures
	gSFeatures
	global54
	global55
	global56
	global57 =  -1
	global58
	gSysWindow
	global60 =  3
	global61
	global62
	global63
	global64
	global65
	global66
	global67
	global68
	global69
	global70
	global71
	global72
	global73
	global74
	global75
	global76
	global77
	global78
	global79
	global80
	global81
	global82
	global83
	global84
	global85
	global86
	global87
	global88
	global89
	global90
	global91
	global92
	global93
	global94
	global95
	global96
	global97
	global98
	global99
	global100
	global101
	global102
	global103
	global104
	global105
	global106
	gGEgoX_5
	gGEgoY_4
	global109
	global110
	gNewAct
	gGEgoX_4
	gGEgoY_3
	gSeconds
	global115
	global116
	global117
	global118
	global119
	global120
	global121 =  1000
	global122
	global123
	global124
	global125
	global126
	gNewView
	gNewView_2
	global129
	global130
	global131
	global132
	global133
	global134
	gGGGGNorth =  1
	global136
	global137
	global138
	global139
	global140
	global141
	global142
	global143
	global144
	global145
	global146
	gGGGNorth
	global148
	gGGNorth =  2
	global150
	global151
	global152
	gLongSong
	global154
	global155
	global156
	global157
	global158
	global159 =  1
	gGEgoX_2
	global161
	gGEgoY_5
	global163
	global164
	global165
	global166
	global167
	global168
	global169
	global170
	global171
	global172
	global173
	global174 =  12
	global175
	global176
	global177
	global178
	global179
	global180
	global181
	global182
	global183
	global184
	global185
	global186
	global187
	global188
	global189
	global190
	global191
	global192
	global193
	global194
	global195
	global196
	global197
	global198
	global199
	global200
	gGEgoX
	gGEgoY
	global203
	global204
	global205
	global206
	global207
	global208
	global209
	global210
	global211
	global212
	global213
	global214 =  75
	global215
	global216
	global217
	global218
	global219
	global220
	global221
	global222
	global223
	global224
	global225
	global226
	global227
	global228
	global229
	global230
	global231
	global232
	global233
	global234
	global235
	gShadowDroidX
	gShadowDroidY
	global238
	global239
	global240
	global241
	global242
	global243
	global244
	gGEgoX_3
	gGEgoY_2
	global247
	global248
	global249
	global250
	global251
	global252
	global253
	global254
	global255
	global256
	global257
	global258
	global259
	global260
	global261
	global262
	global263
	global264
	global265
	global266
	global267
	global268
	global269
	global270
	global271
	global272
	global273
	global274
	global275
	global276
	global277
	global278
	global279
	global280
	global281
	global282
	global283
	global284
	global285
	global286
	global287
	global288
	global289
	global290
	global291
	global292
	global293
	global294
	global295
	global296
	global297
	global298
	global299
	global300
	global301
	global302
	global303
	global304
	global305
	global306
	global307
	global308
	global309
	global310
	global311
	global312
	global313
	global314
	global315
	global316
	global317
	global318
	global319
	global320
	global321
	global322
	global323
	global324
	global325
	global326
	global327
	global328
	global329
	global330
	global331
	global332
	global333
	global334
	global335
	global336
	global337
	global338
	global339
	global340
	global341
	global342
	global343
	global344
	global345
	global346
	global347
	global348
	global349
	global350
	global351
	global352
	global353
	global354
	global355
	global356
	global357
	global358
	global359
	global360
	global361
	global362
	global363
	global364
	global365
	global366
	global367
	global368
	global369
	global370
	global371
	global372
	global373
	global374
	global375
	global376
	global377
	global378
	global379
	global380
	global381
	global382
	global383
	global384
	global385
	global386
	global387
	global388
	global389
	global390
	global391
	global392
	global393
	global394
	global395
	global396
	global397
	global398
	global399
	global400
	global401
	global402
	global403
	global404
	global405
	global406
	global407
	global408
	global409
	global410
	global411
	global412
	global413
	global414
	global415
	global416
	global417
	global418
	global419
	global420
	global421
	global422
	global423
	global424
	global425
	global426
	global427
	global428
	global429
	global430
	global431
	global432
	global433
	global434
	global435
	global436
	global437
	global438
	global439
	global440
	global441
	global442
	global443
	global444
	global445
	global446
	global447
	global448
	global449
	global450
	global451
	global452
	global453
	global454
	global455
	global456
	global457
	global458
	global459
	global460
	global461
	global462
	global463
	global464
	global465
	global466
	global467
	global468
	global469
	global470
	global471
	global472
	global473
	global474
	global475
	global476
	global477
	global478
	global479
	global480
	global481
	global482
	global483
	global484
	global485
	global486
	global487
	global488
	global489
	global490
	global491
	global492
	global493
	global494
	global495
	global496
	global497
	global498
	global499
	global500
	global501
	global502
	global503
	global504
	global505
	global506
	global507
	global508
	global509
	global510
	global511
	global512
	global513
	global514
	global515
	global516
	global517
	global518
	global519
	global520
	global521
	global522
	global523
	global524
	global525
	global526
	global527
	global528
	global529
	global530
	global531
	global532
	global533
	global534
	global535
	global536
	global537
	global538
	global539
	global540
	global541
	global542
	global543
	global544
	global545
	global546
	global547
	global548
	global549
	global550
	global551
	global552
	global553
	global554
	global555
	global556
	global557
	global558
	global559
	global560
	global561
	global562
	global563
	global564
	global565
	global566
	global567
	global568
	global569
	global570
	global571
	global572
	global573
	global574
	global575
	global576
	global577
	global578
	global579
	global580
	global581
	global582
	global583
	global584
	global585
	global586
	global587
	global588
	global589
	global590
	global591
	global592
	global593
	global594
	global595
	global596
	global597
	global598
	global599
	global600
	global601
)
(procedure (proc0_1 param1 param2)
	(if (> argc 0)
		(gEgo loop: param1)
		(if (> argc 1) (gEgo view: param2))
	)
	(gEgo
		setLoop: -1
		setPri: -1
		setMotion: 0
		setCycle: Walk
		setStep: 3 2
		looper: 0
		illegalBits: -32768
		cycleSpeed: 0
		moveSpeed: 0
		ignoreActors: 0
	)
)

(procedure (proc0_2)
	(User canControl: 0 canInput: 0)
	(gEgo setMotion: 0)
	(= global155 1)
)

(procedure (proc0_3)
	(User canControl: 1 canInput: 1)
	(= global155 0)
)

(procedure (proc0_4 param1)
	(return (> (MemoryInfo 1) param1))
)

(procedure (proc0_5)
	(proc255_0 0 35)
)

(procedure (proc0_6)
	(proc255_0 0 36)
)

(procedure (proc0_7)
	(proc255_0 0 37)
)

(procedure (proc0_8)
	(proc255_0 0 38)
)

(procedure (proc0_9)
	(proc255_0 0 39)
)

(procedure (proc0_10)
	(Animate (gCast elements?) 0)
)

(procedure (proc0_11 param1 param2)
	(param1 loop: param2 changeState:)
)

(procedure (proc0_12)
	(if gTheNewDialog (gTheNewDialog dispose:))
)

(procedure (proc0_13 param1 param2)
	(return
		(==
			((gInv at: param1) owner?)
			(if (== argc 1) gGNorth else param2)
		)
	)
)

(procedure (proc0_14 param1 param2)
	((gInv at: param1)
		owner: (if (== argc 1) gGNorth else param2)
	)
)

(procedure (proc0_15 param1 param2)
	(if (< argc 2) (= param2 5))
	(OnControl
		(- (param1 x?) param2)
		(- (param1 y?) param2)
		(+ (param1 x?) param2)
		(+ (param1 y?) param2)
	)
)

(procedure (proc0_16)
)

(procedure (proc0_17 param1 param2 param3 param4)
	(proc0_2)
	(= global197 1)
	(if (not param1)
		(= global190 901)
	else
		(= global190 param1)
	)
	(= global191 param2)
	(= global192 param3)
	(= global188 param4)
)

(instance statusCode of Code
	(properties)
	
	(method (doit param1)
		(Format
			param1
			0
			0
			global15
			global16
			0
			1
			{Space Quest \0B}
			0
			1
		)
	)
)

(instance ego of Ego
	(properties)
)

(instance longSong of Sound
	(properties
		number 1
	)
)

(instance logFile of gamefile
	(properties)
)

(instance SQ3 of Game
	(properties)
	
	(method (init &tmp temp0)
		(super init:)
		(= global598 (Graph 2))
		(= global28 {0.000.001})
		(= temp0 (FOpen {version} 1))
		(FGets global28 6 temp0)
		(FClose temp0)
		(= global193 1)
		(longSong owner: self init:)
		(= gLongSong longSong)
		(User blocks: 0 canControl: 0 x: -1 y: 160)
		(= gEgo ego)
		(User alterEgo: gEgo)
		(SL code: statusCode)
		(gGame setSpeed: 5)
		(= gSysWindow sysWindow)
		(TheMenuBar init:)
		(proc0_3)
		(= global54 1)
		(ScriptID 984)
		(= global16 738)
		(= global22 300)
		(gInv
			add:
				Glowing_Gem
				Wire
				Ladder
				Reactor
				Orat_on_a_Stick
				ThermoWeave_Underwear
				Astro_Chicken_Flight_Hat
				Monolith_Decoder_Ring
				Buckazoids
				Metal_Pole
				Thermal_Detonator
				Keycard
				Coveralls
				Vaporizer
				Elmo_s_picture
				a_copy_of_Elmo_s_picture
				Invisibility_Belt
				Bag_of_Fast_Food
		)
		(if (GameIsRestarting)
			(TheMenuBar draw:)
			(SL enable:)
			(= global125 2)
			(self newRoom: 777)
		else
			(TheMenuBar state: 1)
			(= global125 900)
			(self newRoom: 777)
		)
	)
	
	(method (doit &tmp temp0)
		(asm
			lsg      gGNorth
			ldi      900
			ne?     
			bnt      code_02dc
			lsg      gGNorth
			ldi      1
			ne?     
			bnt      code_02dc
			lsg      gGNorth
			ldi      155
			ne?     
			bnt      code_02dc
			pushi    0
			callk    HaveMouse,  0
			sat      temp0
			lag      global592
			not     
			bnt      code_02dc
			lag      global159
			bnt      code_02ac
			ldi      69
			sag      global230
			jmp      code_02ca
code_02ac:
			pushi    #controls
			pushi    0
			class    User
			send     4
			push    
			ldi      0
			eq?     
			bnt      code_02c6
			ldi      1
			sat      temp0
			lag      global21
			sag      global230
			jmp      code_02ca
code_02c6:
			lag      global20
			sag      global230
code_02ca:
			lsg      global19
			lag      global230
			ne?     
			bnt      code_02dc
			pushi    #setCursor
			pushi    2
			lsg      global230
			lst      temp0
			self     8
code_02dc:
			lsg      global251
			ldi      1
			eq?     
			bnt      code_02f4
			ldi      0
			sag      global251
			ldi      1
			sag      global252
			pushi    #init
			pushi    0
			lofsa    calc
			send     4
code_02f4:
			lag      global197
			bnt      code_04f1
			ldi      0
			sag      global159
			pushi    #number
			pushi    1
			pushi    2
			pushi    23
			pushi    24
			callk    Random,  4
			push    
			pushi    6
			pushi    1
			pushi    1
			pushi    63
			pushi    1
			pushi    500
			pushi    42
			pushi    0
			lag      gLongSong
			send     22
code_031a:
			lsg      global188
			dup     
			ldi      1
			eq?     
			bnt      code_0332
			lofsa    {Deceleration Trauma}
			sag      global320
			lofsa    {It wouldn't be so bad, except for the sudden stop at the end.__Next time, don't get so close to the edge.}
			sag      global259
			jmp      code_0488
code_0332:
			dup     
			ldi      2
			eq?     
			bnt      code_0348
			lofsa    {New, Improved Quick Tanning Method}
			sag      global320
			lofsa    {You never did care for fondue.__Next time, don't get so close to the edge.}
			sag      global259
			jmp      code_0488
code_0348:
			dup     
			ldi      3
			eq?     
			bnt      code_035e
			lofsa    {Rats!}
			sag      global320
			lofsa    {You may not be Purina Rat Chow, but you'll do!}
			sag      global259
			jmp      code_0488
code_035e:
			dup     
			ldi      4
			eq?     
			bnt      code_0374
			lofsa    {It Slices, It Dices...}
			sag      global320
			lofsa    {You're a less-than-choice cut, Wilco!}
			sag      global259
			jmp      code_0488
code_0374:
			dup     
			ldi      5
			eq?     
			bnt      code_038a
			lofsa    {Decompression Blues}
			sag      global320
			lofsa    {Sudden Decompression Sucks!}
			sag      global259
			jmp      code_0488
code_038a:
			dup     
			ldi      6
			eq?     
			bnt      code_03a0
			lofsa    {A Slimmer, Trimmer You!}
			sag      global320
			lofsa    {A quick, but painful, way to shed those extra inches.}
			sag      global259
			jmp      code_0488
code_03a0:
			dup     
			ldi      7
			eq?     
			bnt      code_03b6
			lofsa    {Learn to Drive That Thing!}
			sag      global320
			lofsa    {Your radar is designed to avoid just such an occurrence.}
			sag      global259
			jmp      code_0488
code_03b6:
			dup     
			ldi      8
			eq?     
			bnt      code_03cc
			lofsa    {One Way to Lower Your Blood Pressure.}
			sag      global320
			lofsa    {A brave but fatal attempt at arterial art.}
			sag      global259
			jmp      code_0488
code_03cc:
			dup     
			ldi      9
			eq?     
			bnt      code_03e2
			lofsa    {You have blown your `cover'.}
			sag      global320
			lofsa    {You have demonstrated a surprising lack of janitorial skill.__Perhaps this would be an opportune time to `brush up' on your technique with Space Quest I and II.}
			sag      global259
			jmp      code_0488
code_03e2:
			dup     
			ldi      10
			eq?     
			bnt      code_03f8
			lofsa    {You have taken the big plunge.}
			sag      global320
			lofsa    {That's one small step for man... One giant leap for janitor-kind.}
			sag      global259
			jmp      code_0488
code_03f8:
			dup     
			ldi      11
			eq?     
			bnt      code_040e
			lofsa    {Sunbathing Not Recommended}
			sag      global320
			lofsa    {It's so hot you could fry a Vorlian phlegmsnake egg.}
			sag      global259
			jmp      code_0488
code_040e:
			dup     
			ldi      12
			eq?     
			bnt      code_0424
			lofsa    {Don't Trust Guys in Black Spacesuits}
			sag      global320
			lofsa    {A pulselaser blast to the forehead is not your idea of fun.__Fortunately, it didn't hit anything important.}
			sag      global259
			jmp      code_0488
code_0424:
			dup     
			ldi      13
			eq?     
			bnt      code_043a
			lofsa    {Down for the Count}
			sag      global320
			lofsa    {Better hang out at the gym more often.}
			sag      global259
			jmp      code_0488
code_043a:
			dup     
			ldi      14
			eq?     
			bnt      code_0450
			lofsa    {Hole In One!}
			sag      global320
			lofsa    {Hope you enjoy your new flow-through ventilation system.}
			sag      global259
			jmp      code_0488
code_0450:
			dup     
			ldi      15
			eq?     
			bnt      code_0466
			lofsa    {Just Like Mom Used to Make}
			sag      global320
			lofsa    {As your life sputters to a close, you decide to cut down on desserts.}
			sag      global259
			jmp      code_0488
code_0466:
			dup     
			ldi      20
			eq?     
			bnt      code_047c
			lofsa    {Be More Careful With Explosives}
			sag      global320
			lofsa    {Didn't mom always tell you not to play with firecrackers?}
			sag      global259
			jmp      code_0488
code_047c:
			lofsa    {Congratulations On Your Recent Death !}
			sag      global320
			lofsa    {Thanks for playing Space Quest ]I[. As usual, you've been a real hoot.}
			sag      global259
code_0488:
			toss    
			pushi    18
			lsg      global259
			pushi    82
			lsg      global190
			lsg      global191
			lsg      global192
			pushi    30
			pushi    1
			pushi    80
			lsg      global320
			pushi    81
			lofsa    {Restore}
			push    
			pushi    1
			pushi    81
			lofsa    {Restart}
			push    
			pushi    2
			pushi    81
			lofsa    {____Quit____}
			push    
			pushi    3
			calle    proc255_0,  36
			push    
			dup     
			ldi      1
			eq?     
			bnt      code_04ca
			pushi    #restore
			pushi    0
			lag      gGame
			send     4
			jmp      code_04ea
code_04ca:
			dup     
			ldi      2
			eq?     
			bnt      code_04dc
			pushi    #restart
			pushi    0
			lag      gGame
			send     4
			jmp      code_04ea
code_04dc:
			dup     
			ldi      3
			eq?     
			bnt      code_04ea
			ldi      1
			sag      global4
			jmp      code_0536
code_04ea:
			toss    
			jmp      code_031a
			jmp      code_0536
code_04f1:
			ldi      0
			sag      global219
			ldi      0
			sag      global223
			pushi    1
			pushi    1
			callk    GetTime,  2
			sag      global198
			push    
			lag      global199
			ne?     
			bnt      code_0536
			lag      global198
			sag      global199
			lsg      global226
			ldi      1
			add     
			sag      global226
			ldi      1
			sag      global219
			lsg      global226
			ldi      60
			ge?     
			bnt      code_0536
			+ag      global227
			ldi      0
			sag      global226
			ldi      1
			sag      global223
			lsg      global227
			ldi      60
			eq?     
			bnt      code_0536
			+ag      global228
			ldi      0
			sag      global227
code_0536:
			pushi    #doit
			pushi    0
			super    Game,  4
			ret     
		)
	)
	
	(method (replay)
		(TheMenuBar draw:)
		(SL enable:)
		(SetMenu
			1282
			110
			(if (DoSound 4) {Turn Off} else {Turn On})
		)
		(super replay:)
	)
	
	(method (startRoom param1)
		(proc958_0
			0
			963
			973
			977
			978
			962
			964
			968
			965
			952
			971
			961
			967
			970
			979
			957
			959
			966
			976
			954
			956
			972
			974
			953
			960
			980
			986
			975
			981
			955
			985
			982
			969
		)
		(if global14 (= global14 0) (SetDebug))
		(if
			(and
				(u> (MemoryInfo 1) (+ 20 (MemoryInfo 0)))
				global200
				(proc255_0 0 2 81 {Debug} 1)
			)
			(SetDebug)
		)
		(super startRoom: param1)
	)
	
	(method (handleEvent param1 &tmp temp0 temp1 newEvent temp3 temp4 temp5 temp6 temp7 temp8 [temp9 50])
		(if (param1 claimed?) (return))
		(super handleEvent: param1)
		(if (== global252 1)
			(param1 claimed: 1)
			(= global252 0)
			(calc dispose:)
		)
		(switch (param1 type?)
			(128
				(cond 
					((Said 'tp')
						(if (not global200)
							(param1 claimed: 0)
						else
							(User canControl: 1)
							(= global100 0)
							(if
								(and
									(!= (= temp4 (proc255_3 {Teleport to:})) 1)
									(!= temp4 900)
									(!= temp4 155)
								)
								(gLongSong stop:)
								(= global159 0)
								(= global230 global20)
								(gGame setCursor: global20 (HaveMouse))
							)
							(= global189 temp4)
							(= global193 0)
							(global2 newRoom: temp4)
						)
					)
					((Said 'pump,backstage/shark,pass') (proc255_0 0 3) (= global200 1))
					((Said 'wait') (proc255_0 0 4))
					((or (Said 'wear/belt') (Said 'drop<on/belt'))
						(if (gEgo has: 16)
							(if (not global126)
								(proc255_0 0 5)
								(= global126 1)
							else
								(proc255_0 0 6)
							)
						else
							(proc0_9)
						)
					)
					(
						(or
							(Said 'use,activate/belt,invisibility')
							(Said 'turn<on/belt')
							(Said 'press/button/belt')
							(Said 'switch<on/belt')
						)
						(cond 
							((not (gEgo has: 16)) (proc0_9))
							((not global126) (proc255_0 0 7))
							((== global120 2) (proc255_0 0 8))
							(else (proc255_0 0 9))
						)
					)
					((Said 'wear,(drop<on)/panties')
						(cond 
							((not (gEgo has: 5)) (proc0_9))
							(global182 (proc255_0 0 10))
							(else (proc255_0 0 11))
						)
					)
					((Said 'wear,(drop<on)/decoder')
						(if (not (gEgo has: 7))
							(proc0_9)
						else
							(proc255_0 0 12)
						)
					)
					(
						(or
							(Said 'remove/attire')
							(Said 'get/naked')
							(Said 'undress')
							(Said 'remove/panties')
						)
						(proc255_0 0 13)
					)
					((Said 'wear/cap') (if (gEgo has: 6) (proc255_0 0 14) else (proc0_9)))
					((Said 'look/anemometer') (if (gEgo has: 9) (proc255_0 0 15) else (proc0_9)))
					((Said 'look/belt')
						(cond 
							((not (gEgo has: 16)) (proc0_9))
							((!= global120 2) (proc255_0 0 16))
							(else (proc255_0 0 17))
						)
					)
					(
					(and (Said 'look>') (= temp0 (gInv firstTrue: 248)))
						(if (temp0 ownedBy: gEgo)
							(temp0 showSelf:)
						else
							(proc255_0 0 18)
						)
					)
					((Said 'eat,drop,use') (proc255_0 0 19))
					((Said 'get')
						(cond 
							(
								(or
									(not global200)
									(not (= temp0 (gInv firstTrue: 248)))
								)
								(proc255_0 0 20)
							)
							((temp0 ownedBy: gEgo) (proc255_0 0 21))
							(else (param1 claimed: 0))
						)
					)
					((Said 'smell') (proc255_0 0 22))
					((Said 'throw') (proc255_0 0 23))
					((Said 'press') (proc255_0 0 24))
					((Said 'jump') (proc255_0 0 25))
					((Said 'jog') (proc255_0 0 26))
					((Said 'ass')
						(if (> (++ global185) 25)
							(proc255_0 0 27)
						else
							(proc255_0 0 28)
						)
					)
					(
					(or (Said 'inventory') (Said 'look,get/inventory')) (gInv showSelf: gEgo))
				)
			)
			(1
				(if global200
					(= temp5 (param1 x?))
					(= temp6 (param1 y?))
					(cond 
						((== (= temp7 (param1 modifiers?)) 10)
							(param1 claimed: 1)
							((User alterEgo?) setMotion: JumpTo temp5 temp6)
						)
						((& temp7 $0003)
							(param1 claimed: 1)
							(= temp1
								(proc255_0
									(Format @temp9 0 29 temp5 temp6)
									67
									(cond 
										((< temp5 20) temp5)
										((< 300 temp5) (- temp5 40))
										(else (- temp5 20))
									)
									(if (< temp6 16) temp6 else (- temp6 6))
									33
									999
									91
								)
							)
							(while (!= 2 ((= newEvent (Event new:)) type?))
								(newEvent dispose:)
							)
							(temp1 dispose:)
							(newEvent dispose:)
						)
						((& temp7 $0004)
							(param1 claimed: 1)
							(while (!= 2 ((= newEvent (Event new:)) type?))
								((User alterEgo?)
									posn: (newEvent x?) (- (newEvent y?) 10)
									setMotion: 0
								)
								(Animate (gCast elements?) 0)
								(newEvent dispose:)
							)
							(newEvent dispose:)
						)
						((& temp7 $0008) (param1 claimed: 1) ((User alterEgo?) showSelf:))
					)
				)
			)
			(4
				(if (not global200) (return))
				(switch (param1 message?)
					(9728
						(if (== printLang 1)
							(= printLang 49)
							(= subtitleLang 1)
						else
							(= printLang 1)
							(= subtitleLang 49)
						)
					)
					(11264
						(if global200 (param1 claimed: 1) (= global4 1))
					)
					(4608
						(proc255_0
							(Format
								@temp9
								{view: %d loop: %d cel: %d posn: %d %d pri: %d OnControl: $%x Origin on: $%x}
								(gEgo view?)
								(gEgo loop?)
								(gEgo cel?)
								(gEgo x?)
								(gEgo y?)
								(gEgo priority?)
								(gEgo onControl:)
								(gEgo onControl: 1)
							)
							82
							(gEgo view?)
							(gEgo loop?)
							(gEgo cel?)
						)
					)
					(8960
						(gGame showMem:)
						(param1 claimed: 1)
					)
					(4864
						(proc255_0 (Format @temp9 0 30 gGNorth))
					)
					(12032 (Show 1))
					(6400 (Show 2))
					(5376
						(= global402 0)
						(proc255_2 @global402 8 {Inv. Object})
						(= global351 (ReadNumber @global402))
						(= global402 0)
						(proc255_2 @global402 12 {Owner})
						(if (not (StrCmp {ego} @global402))
							((gInv at: global351) moveTo: gEgo)
						else
							((gInv at: global351) moveTo: (ReadNumber @global402))
						)
						(= global402 0)
					)
					(11776
						(Show 4)
						(Animate (gCast elements?))
						(while
						(== 0 ((= newEvent (Event new: 32765)) type?))
							(newEvent dispose:)
						)
						(newEvent dispose:)
						(Show 1)
					)
				)
			)
		)
	)
	
	(method (wordFail param1 &tmp [temp0 100])
		(proc255_0 (Format @temp0 0 31 param1))
	)
	
	(method (syntaxFail)
		(proc255_0 0 32)
	)
	
	(method (pragmaFail &tmp [temp0 100])
		(proc255_0 0 33)
	)
)

(instance Glowing_Gem of InvI
	(properties
		said '/crystal[<glowing]/'
		description {You are still carrying the piece of orium you picked up on Labion during your last adventure. However, it has long since lost its glow.}
		view 242
		name {Glowing Gem}
	)
)

(instance Wire of InvI
	(properties
		said '/cable'
		description {It's a piece of SQ-approved electrical wire.}
		owner 6
		view 242
		cel 1
		name {Wire}
	)
)

(instance Ladder of InvI
	(properties
		said '/ladder/'
		description {This is a ladder. The evenly spaced rungs allow altitude adjustment.}
		owner 15
		view 242
		cel 2
		name {Ladder}
	)
)

(instance Reactor of InvI
	(properties
		said '/generator/'
		description {This is an auxiliary reactor.}
		owner 15
		view 242
		cel 3
		name {Reactor}
	)
)

(instance Orat_on_a_Stick of InvI
	(properties
		said '/orat,stick'
		description {Orat on a Stick! You can open his mouth, and close his mouth! Hours of fun for all!}
		owner 470
		view 242
		cel 8
		name {Orat on a Stick}
	)
)

(instance ThermoWeave_Underwear of InvI
	(properties
		said '/panties'
		description {ThermoWeave Shorts.__They keep you cool, and they're oh, so stylish.}
		owner 470
		view 242
		cel 9
		name {ThermoWeave Underwear}
	)
)

(instance Astro_Chicken_Flight_Hat of InvI
	(properties
		said '/cap'
		description {Wow! Your Official Astro Chicken Flight Hat!__Man, the babes'll really dig you in this!}
		owner 470
		view 242
		cel 6
		name {Astro Chicken Flight Hat}
	)
)

(instance Monolith_Decoder_Ring of InvI
	(properties
		said '/decoder,prize'
		description {With this ring, you can decode any secret message!__Well, almost any secret message.}
		owner 29
		view 242
		cel 5
		name {Monolith Decoder Ring}
	)
)

(instance Buckazoids of InvI
	(properties
		said '/bill'
		view 242
		cel 7
		name {Buckazoids}
	)
	
	(method (showSelf)
		(proc255_0
			(Format @global402 0 34 global154)
			82
			view
			loop
			cel
		)
	)
)

(instance Metal_Pole of InvI
	(properties
		said '/pole'
		description {A handy metal pole.}
		owner 69
		view 242
		cel 11
		name {Metal Pole}
	)
)

(instance Thermal_Detonator of InvI
	(properties
		said '/detonator'
		description {Used for blowing stuff to little bits.___It has an impact switch, so in other words...DON'T DROP IT!}
		owner 69
		view 242
		cel 12
		name {Thermal Detonator}
	)
)

(instance Keycard of InvI
	(properties
		said '/card'
		description {Elmo Pug's personal keycard for opening locked doors.}
		owner 93
		view 242
		loop 1
		name {Keycard}
	)
)

(instance Coveralls of InvI
	(properties
		said '/attire'
		description {A pair of janitor's coveralls. Used for looking the part.}
		owner 90
		view 242
		cel 14
		name {Coveralls}
	)
)

(instance Vaporizer of InvI
	(properties
		said '/mrgarbage'
		description {Mr. Garbage: a janitor's best friend. Designed to vaporize all nonorganic biodegradable matter (i.e. trash).}
		owner 90
		view 242
		cel 15
		name {Vaporizer}
	)
)

(instance Elmo_s_picture of InvI
	(properties
		said '/original'
		description {A fine likeness of Elmo Pug's mug. Elmo Pug is the dashing young owner of ScumSoft, Inc.}
		owner 92
		view 242
		cel 13
		name {Elmo's picture}
	)
)

(instance a_copy_of_Elmo_s_picture of InvI
	(properties
		said '/copy'
		description {A fine likeness of a likeness of Elmo Pug's mug.}
		owner 92
		view 242
		cel 13
		name {a copy of Elmo's picture}
	)
)

(instance Invisibility_Belt of InvI
	(properties
		said '/belt'
		description {Terminator's invisibility belt.}
		owner -1
		view 242
		cel 10
		name {Invisibility Belt}
	)
)

(instance Bag_of_Fast_Food of InvI
	(properties
		said '/bag,dinner'
		description {A bag chock-full of gastric delights!}
		owner -1
		view 242
		cel 4
		name {Bag of Fast Food}
	)
)

(instance calc of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 27
			setLoop: 0
			setCel: 0
			ignoreActors: 1
			setPri: 15
			posn: 159 94
			stopUpd:
		)
	)
)

(instance sysWindow of SysWindow
	(properties)
)
