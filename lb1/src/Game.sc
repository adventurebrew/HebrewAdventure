;;; Sierra Script 1.0 - (do not remove this comment)
(script# 994)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Sound)
(use SRDialog)
(use Cycle)
(use InvI)
(use User)
(use Obj)


(procedure (localproc_0b7e param1 &tmp temp0 [temp1 40] [temp41 40] [temp81 40])
	(= temp0 1)
	(DeviceInfo 0 global30 @temp1)
	(DeviceInfo 1 @temp41)
	(if
		(and
			(DeviceInfo 2 @temp1 @temp41)
			(DeviceInfo 3 @temp41)
		)
		(Format
			@temp81
			994
			8
			(if param1 {SAVE GAME} else {GAME})
			@temp41
		)
		(if
			(==
				(= temp0
					(if param1
						(proc255_0
							@temp81
							33
							0
							81
							{OK}
							1
							81
							{Cancel}
							0
							81
							{Change Directory}
							2
						)
					else
						(proc255_0 @temp81 33 0 81 {OK} 1)
					)
				)
				2
			)
			(= temp0 (proc990_0 global30))
		)
	)
	(return temp0)
)

(instance cast of EventHandler
	(properties)
)

(instance features of EventHandler
	(properties)
)

(instance sFeatures of EventHandler
	(properties)
	
	(method (delete param1)
		(asm
			pushi    #delete
			pushi    1
			lsp      param1
			super    EventHandler,  6
			lag      global54
			bnt      code_0060
			pushi    #isKindOf
			pushi    1
			class    2
			push    
			lap      param1
			send     6
			bnt      code_0060
			pushi    #release
			pushi    0
			pushi    88
			pushi    0
			lap      param1
			send     8
code_0060:
			ret     
		)
	)
)

(instance sounds of EventHandler
	(properties)
)

(instance regions of EventHandler
	(properties)
)

(instance locales of EventHandler
	(properties)
)

(instance addToPics of EventHandler
	(properties)
	
	(method (doit)
		(AddToPic elements)
	)
)

(instance controls of Controls
	(properties)
)

(instance timers of Set
	(properties)
)

(class Game of Obj
	(properties
		script 0
	)
	
	(method (init &tmp theMotion)
		(= theMotion Motion)
		(= theMotion Sound)
		((= gCast cast) add:)
		((= gFeatures features) add:)
		((= gSFeatures sFeatures) add:)
		((= gSounds sounds) add:)
		((= gRegions regions) add:)
		((= gLocales locales) add:)
		((= gAddToPics addToPics) add:)
		((= gTimers timers) add:)
		(= global30 (GetSaveDir))
		(Inv init:)
		(User init:)
	)
	
	(method (doit)
		(gSounds eachElementDo: #check)
		(gTimers eachElementDo: #doit)
		(Animate (gCast elements?) 1)
		(if global58
			(= global58 0)
			(gCast eachElementDo: #motionCue)
		)
		(if script (script doit:))
		(gRegions eachElementDo: #doit)
		(User doit:)
		(if (!= gNewRoomNumber gNumber)
			(self newRoom: gNewRoomNumber)
		)
		(gTimers eachElementDo: #delete)
		(GameIsRestarting 0)
	)
	
	(method (showSelf)
		(gRegions showSelf:)
	)
	
	(method (play)
		(= gGame self)
		(= global30 (GetSaveDir))
		(if (not (GameIsRestarting)) (GetCWD global30))
		(self setCursor: global21 1 320 200)
		(self init:)
		(self setCursor: global20 (HaveMouse))
		(while (not global4)
			(self doit:)
			(= global18 (Wait gNewSpeed))
		)
	)
	
	(method (replay)
		(if gPEvent (gPEvent dispose:))
		(gSFeatures release:)
		(if gTheNewDialog (gTheNewDialog dispose:))
		(gCast eachElementDo: #perform RU)
		(gGame setCursor: global21 1)
		(DrawPic (global2 curPic?) 100 dpCLEAR global61)
		(if (!= gPicNumber -1)
			(DrawPic gPicNumber 100 dpNO_CLEAR global61)
		)
		(if (global2 controls?) ((global2 controls?) draw:))
		(gAddToPics doit:)
		(gGame setCursor: global20 (HaveMouse))
		(DoSound sndRESUME)
		(Sound pause: 0)
		(while (not global4)
			(self doit:)
			(= global18 (Wait gNewSpeed))
		)
	)
	
	(method (newRoom newRoomNumber &tmp [temp0 3] temp3 temp4)
		(gAddToPics dispose:)
		(gFeatures eachElementDo: #dispose release:)
		(gCast eachElementDo: #dispose eachElementDo: #delete)
		(gTimers eachElementDo: #delete)
		(gRegions eachElementDo: #perform DNKR release:)
		(gLocales eachElementDo: #dispose release:)
		(Animate 0)
		(= gGNumber gNumber)
		(= gNumber newRoomNumber)
		(= gNewRoomNumber newRoomNumber)
		(FlushResources newRoomNumber)
		(= temp3 (self setCursor: global21 1))
		(self
			startRoom: gNumber
			checkAni:
			setCursor: temp3 (HaveMouse)
		)
		(SetSynonyms gRegions)
		(while ((= temp4 (Event new: 3)) type?)
			(temp4 dispose:)
		)
		(temp4 dispose:)
	)
	
	(method (startRoom param1)
		(if global14 (SetDebug))
		(gRegions
			addToFront: ((= global2 (ScriptID param1)) init: yourself:)
		)
		(if (== (gEgo view?) 0) (gEgo view: 11))
	)
	
	(method (restart)
		(if gTheNewDialog (gTheNewDialog dispose:))
		(RestartGame)
	)
	
	(method (restore &tmp [temp0 20] temp20 temp21 temp22)
		(Load rsFONT global23)
		(= temp21 (self setCursor: global20))
		(= temp22 (Sound pause: 1))
		(if (localproc_0b7e 1)
			(if gTheNewDialog (gTheNewDialog dispose:))
			(if (!= (= temp20 (Restore doit: &rest)) -1)
				(self setCursor: global21 1)
				(if (CheckSaveGame name temp20 global28)
					(gCast eachElementDo: #dispose)
					(gCast eachElementDo: #delete)
					(RestoreGame name temp20 global28)
				else
					(proc255_0 994 1 33 0 81 {OK} 1)
					(self setCursor: temp21 (HaveMouse))
				)
			)
			(localproc_0b7e 0)
		)
		(Sound pause: temp22)
	)
	
	(method (save &tmp [temp0 20] temp20 temp21 temp22)
		(Load rsFONT global23)
		(Load rsCURSOR global21)
		(= temp22 (Sound pause: 1))
		(if (localproc_0b7e 1)
			(if gTheNewDialog (gTheNewDialog dispose:))
			(if (!= (= temp20 (Save doit: @temp0)) -1)
				(= temp21 (self setCursor: global21 1))
				(if (not (SaveGame name temp20 @temp0 global28))
					(proc255_0 994 0 33 0 81 {OK} 1)
				)
				(self setCursor: temp21 (HaveMouse))
			)
			(localproc_0b7e 0)
		)
		(Sound pause: temp22)
	)
	
	(method (changeScore param1)
		(= global15 (+ global15 param1))
	)
	
	(method (handleEvent pEvent)
		(cond 
			(
				(or
					(gRegions handleEvent: pEvent)
					(gLocales handleEvent: pEvent)
				)
			)
			(script (script handleEvent: pEvent))
		)
		(pEvent claimed?)
	)
	
	(method (showMem)
		(proc255_4
			{Free Heap: %u Bytes\nLargest ptr: %u Bytes\nFreeHunk: %u KBytes\nLargest hunk: %u Bytes}
			(MemoryInfo 1)
			(MemoryInfo 0)
			(>> (MemoryInfo 3) $0006)
			(MemoryInfo 2)
		)
	)
	
	(method (setSpeed newSpeed &tmp theGNewSpeed)
		(= theGNewSpeed gNewSpeed)
		(= gNewSpeed newSpeed)
		(return theGNewSpeed)
	)
	
	(method (setCursor cursorNumber param2 &tmp theGCursorNumber)
		(= theGCursorNumber gCursorNumber)
		(= gCursorNumber cursorNumber)
		(if (== argc 1)
			(SetCursor cursorNumber)
		else
			(SetCursor cursorNumber param2)
		)
		(return theGCursorNumber)
	)
	
	(method (checkAni &tmp temp0)
		(Animate (gCast elements?) 0)
		(Wait 0)
		(Animate (gCast elements?) 0)
		(while (> (Wait 0) global50)
			(breakif (== (= temp0 (gCast firstTrue: #isExtra)) 0))
			(temp0 addToPic:)
			(Animate (gCast elements?) 0)
			(gCast eachElementDo: #delete)
		)
	)
	
	(method (notify)
	)
	
	(method (setScript theScript)
		(if script (script dispose:))
		(if (= script theScript)
			((= script theScript) init: self &rest)
		)
	)
	
	(method (cue)
		(if script (script cue:))
	)
	
	(method (wordFail param1 &tmp [temp0 100])
		(proc255_0 (Format @temp0 994 2 param1))
		(return 0)
	)
	
	(method (syntaxFail)
		(proc255_0 994 3)
	)
	
	(method (semanticFail)
		(proc255_0 994 4)
	)
	
	(method (pragmaFail)
		(switch (Random 1 3)
			(1 (proc255_0 994 5))
			(2 (proc255_0 994 6))
			(3 (proc255_0 994 7))
		)
	)
)

(class Rgn of Obj
	(properties
		script 0
		number 0
		timer 0
		keep 0
		initialized 0
	)
	
	(method (init)
		(if (not initialized)
			(= initialized 1)
			(if (not (gRegions contains: self))
				(gRegions addToEnd: self)
			)
			(super init:)
		)
	)
	
	(method (doit)
		(if script (script doit:))
	)
	
	(method (dispose)
		(gRegions delete: self)
		(if (IsObject script) (script dispose:))
		(if (IsObject timer) (timer dispose:))
		(gSounds eachElementDo: #clean self)
		(DisposeScript number)
	)
	
	(method (handleEvent pEvent)
		(if script (script handleEvent: pEvent))
		(pEvent claimed?)
	)
	
	(method (setScript theScript)
		(if (IsObject script) (script dispose:))
		(if (= script theScript)
			((= script theScript) init: self &rest)
		)
	)
	
	(method (cue)
		(if script (script cue:))
	)
	
	(method (newRoom)
	)
	
	(method (notify)
	)
)

(class Rm of Rgn
	(properties
		script 0
		number 0
		timer 0
		keep 0
		initialized 0
		picture 0
		style $ffff
		horizon 0
		controls 0
		north 0
		east 0
		south 0
		west 0
		curPic 0
		picAngle 0
		vanishingX 160
		vanishingY -30000
		vertAngle 0
	)
	
	(method (init &tmp temp0 userAlterEgo)
		(= number gNumber)
		(= controls controls)
		(= gPicAngle picAngle)
		(if picture (self drawPic: picture))
		(switch ((= userAlterEgo (User alterEgo?)) edgeHit?)
			(1 (userAlterEgo y: 188))
			(4
				(userAlterEgo x: (- 319 (userAlterEgo xStep?)))
			)
			(3
				(userAlterEgo y: (+ horizon (userAlterEgo yStep?)))
			)
			(2 (userAlterEgo x: 1))
		)
		(userAlterEgo edgeHit: 0)
	)
	
	(method (doit &tmp temp0)
		(if script (script doit:))
		(if
			(= temp0
				(switch ((User alterEgo?) edgeHit?)
					(1 north)
					(2 east)
					(3 south)
					(4 west)
				)
			)
			(self newRoom: temp0)
		)
	)
	
	(method (dispose)
		(if controls (controls dispose:))
		(super dispose:)
	)
	
	(method (handleEvent pEvent)
		(cond 
			((super handleEvent: pEvent))
			(controls (controls handleEvent: pEvent))
		)
		(pEvent claimed?)
	)
	
	(method (newRoom newRoomNumber)
		(gRegions
			delete: self
			eachElementDo: #newRoom newRoomNumber
			addToFront: self
		)
		(= gNewRoomNumber newRoomNumber)
		(super newRoom: newRoomNumber)
	)
	
	(method (setRegions scriptNumbers &tmp temp0 theScriptNumbers temp2)
		(= temp0 0)
		(while (< temp0 argc)
			(= theScriptNumbers [scriptNumbers temp0])
			((= temp2 (ScriptID theScriptNumbers))
				number: theScriptNumbers
			)
			(gRegions add: temp2)
			(if (not (temp2 initialized?)) (temp2 init:))
			(++ temp0)
		)
	)
	
	(method (setFeatures theFeatures &tmp temp0 [temp1 2])
		(= temp0 0)
		(while (< temp0 argc)
			(gFeatures add: [theFeatures temp0])
			(++ temp0)
		)
	)
	
	(method (setLocales scriptNumbers &tmp temp0 theScriptNumbers temp2)
		(= temp0 0)
		(while (< temp0 argc)
			(= theScriptNumbers [scriptNumbers temp0])
			((= temp2 (ScriptID theScriptNumbers))
				number: theScriptNumbers
			)
			(gLocales add: temp2)
			(temp2 init:)
			(++ temp0)
		)
	)
	
	(method (drawPic picNumber picAnimation)
		(addToPics dispose:)
		(= curPic picNumber)
		(= gPicNumber -1)
		(DrawPic
			picNumber
			(cond 
				((== argc 2) picAnimation)
				((!= style -1) style)
				(else global17)
			)
			dpCLEAR
			global61
		)
	)
	
	(method (overlay picNumber picAnimation)
		(= gPicNumber picNumber)
		(DrawPic
			picNumber
			(cond 
				((== argc 2) picAnimation)
				((!= style -1) style)
				(else global17)
			)
			dpCLEAR
			global61
		)
	)
)

(class Locale of Obj
	(properties
		number 0
	)
	
	(method (dispose)
		(gLocales delete: self)
		(DisposeScript number)
	)
	
	(method (handleEvent pEvent)
		(pEvent claimed?)
	)
)

(instance RU of Code
	(properties)
	
	(method (doit param1 &tmp temp0)
		(if (param1 underBits?)
			(= temp0
				(&
					(= temp0 (| (= temp0 (param1 signal?)) $0001))
					$fffb
				)
			)
			(param1 underBits: 0 signal: temp0)
		)
	)
)

(instance DNKR of Code
	(properties)
	
	(method (doit param1)
		(if (not (param1 keep?)) (param1 dispose:))
	)
)
