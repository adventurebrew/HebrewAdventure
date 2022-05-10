;;; Sierra Script 1.0 - (do not remove this comment)
(script# 997)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Sound)
(use InvI)
(use User)

(public
	proc997_2 2
)

(procedure (proc997_2 param1 &tmp temp0)
	(= temp0 (proc255_3 {Teleport to room:}))
	(param1 newRoom: (if (< temp0 1) 1 else temp0))
)

(procedure (localproc_04fd)
	(proc255_0 997 7 33 4 70 275)
)

(class TheMenuBar of Class_255_0
	(properties
		state $0000
	)
	
	(method (init)
		(= global215 1)
		(AddMenu { \01_} {About Bequest:Help`#1})
		(AddMenu
			{ File_}
			{Save`#5:Restore`#7:-!:Restart`#9:Quit`^q}
		)
		(AddMenu
			{ Action_}
			{Pause`^p:Inventory`^i:Retype`#3:Ask about...`^a:Tell about...`^t:Show...`^s:Give...`^g:Look at...`^l}
		)
		(AddMenu { Speed_} {Faster`+:Normal`=:Slower`-})
		(AddMenu { Sound_} {Volume`^v:-!:Turn Off=1`#2})
		(SetMenu
			1283
			110
			(if (DoSound sndSET_SOUND) {Turn Off} else {Turn On})
		)
		(SetMenu 258 109 'help[/game]')
		(SetMenu 513 109 'save[/game]')
		(SetMenu 514 109 'restore[/game]')
		(SetMenu 516 109 'restart[/game]')
		(SetMenu 517 109 'quit[/game]')
		(SetMenu 769 109 'pause[/game]')
		(SetMenu 770 109 'inventory')
	)
	
	(method (handleEvent pEvent &tmp temp0 temp1 [temp2 3] temp5 [temp6 255])
		(= global221 999)
		(gGame setCursor: 999 1)
		(switch (= temp0 (super handleEvent: pEvent))
			(257
				(= temp5 (Sound pause: 1))
				(proc255_0 997 0 33 global23 67 10 10 70 290)
				(Sound pause: temp5)
			)
			(258
				(= temp5 (Sound pause: 1))
				(localproc_04fd)
				(Sound pause: temp5)
			)
			(513
				(if global190 (proc255_0 997 1) else (gGame save:))
			)
			(514
				(if global190 (proc255_0 997 2) else (gGame restore:))
			)
			(516
				(= temp5 (Sound pause: 1))
				(if
					(proc255_0
						997
						3
						33
						0
						81
						{__Restart__}
						1
						81
						{ Continue_}
						0
					)
					(gGame restart:)
				)
				(Sound pause: temp5)
			)
			(517
				(= temp5 (Sound pause: 1))
				(= global4
					(proc255_0
						997
						4
						33
						0
						81
						{____Quit____}
						1
						81
						{ Continue_}
						0
					)
				)
				(Sound pause: temp5)
			)
			(769
				(= temp5 (Sound pause: 1))
				(proc255_0 997 5 33 0 81 {__Continue__} 0)
				(Sound pause: temp5)
			)
			(770
				(if (not (proc0_8 2048))
					(proc255_0 997 6)
				else
					(= temp5 (Sound pause: 1))
					(Inv showSelf: gEgo)
					(Sound pause: temp5)
				)
			)
			(771
				(pEvent claimed: 0 type: 4 message: (User echo?))
			)
			(772
				(pEvent claimed: 0 type: 4 message: (User echo?))
				(StrCpy (User inputLineAddr?) {Ask about_})
			)
			(773
				(pEvent claimed: 0 type: 4 message: (User echo?))
				(StrCpy (User inputLineAddr?) {Tell about_})
			)
			(774
				(pEvent claimed: 0 type: 4 message: (User echo?))
				(StrCpy (User inputLineAddr?) {Show_})
			)
			(775
				(pEvent claimed: 0 type: 4 message: (User echo?))
				(StrCpy (User inputLineAddr?) {Give_})
			)
			(776
				(pEvent claimed: 0 type: 4 message: (User echo?))
				(StrCpy (User inputLineAddr?) {Look at_})
			)
			(1025
				(if (> gNewSpeed 1) (gGame setSpeed: (-- gNewSpeed)))
			)
			(1026 (gGame setSpeed: 6))
			(1027
				(gGame setSpeed: (++ gNewSpeed))
			)
			(1281
				(if
					(and
						(!= gNumber 74)
						(!= gNumber 64)
						(!=
							(= temp1
								(proc255_3 {Volume (1 - 16)?} (+ 1 (DoSound sndVOLUME)))
							)
							-1
						)
					)
					(if (< (-- temp1) 0) (= temp1 0))
					(if (> temp1 15) (= temp1 15))
					(DoSound sndVOLUME temp1)
				)
			)
			(1283
				(if (= temp1 (DoSound sndSET_SOUND))
					(SetMenu 1283 110 {Turn On})
				else
					(SetMenu 1283 110 {Turn Off})
				)
				(DoSound sndSET_SOUND (not temp1))
			)
			(else 
				(if global392 (global392 doit: temp0))
			)
		)
	)
)
