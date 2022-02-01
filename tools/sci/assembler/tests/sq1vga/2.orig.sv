export002_0	= rm2

babbleIcon::init:
		pushi	$6b		; 107, 'k', init
		push2
		pushSelf
		pushi	$14		; 20, brLeft
		pushi	$6a		; 106, 'j', new
		push0
		class	RandCycle
		send	$4
		aTop	cycler
		send	$8
		ret

instance babbleIcon of DCIcon
{
	type            = $4		; x
	state           = $0
	nsTop           = $0
	nsLeft          = $0
	nsBottom        = $0
	nsRight         = $0
	key             = $0
	said            = $0
	value           = $0
	view            = $0
	loop            = $0
	cel             = $0
	cycler          = $0
	cycleSpeed      = $6		; loop
	signal          = $0

	init()
}

code_005e:	link	$12f
		pushi	$b9		; 185, setCursor
		push2
		lsg	global[$14]
		push1
		lag	global[$1]
		send	$8
		pushi	$14		; 20, brLeft
		lofsa	string_0521	; "Thank you for playing Space Quest I. As usual, you've been most entertaining."
		push
		pushi	$43		; 67, 'C', at
		pushi	$64		; 100, 'd', moveDone
		pushi	$3c		; 60, '<', doit
		pushi	$6a		; 106, 'j', new
		pushi	$51		; 81, 'Q', button
		lofsa	string_056f	; "Restore"
		push
		push1
		pushi	$6a		; 106, 'j', new
		pushi	$51		; 81, 'Q', button
		lofsa	string_0577	; "Restart"
		push
		push2
		pushi	$6a		; 106, 'j', new
		pushi	$51		; 81, 'Q', button
		lofsa	string_057f	; "Quit"
		push
		pushi	$3		; y
		pushi	$52		; 82, 'R', icon
		lsp	param[$1]
		lsp	param[$2]
		lsp	param[$3]
		calle	export255_0, $28
		push
		dup
		ldi	$1
		eq?
		bnt	code_00bb
		pushi	$4f		; 79, 'O', restore
		push0
		lag	global[$1]
		send	$4
		pushi	$9b		; 155, pause
		push1
		push0
		class	Sound
		send	$6
		jmp	code_00ec

code_00bb:	dup
		ldi	$2
		eq?
		bnt	code_00d5
		pushi	$68		; 104, 'h', restart
		push0
		lag	global[$1]
		send	$4
		pushi	$9b		; 155, pause
		push1
		push0
		class	Sound
		send	$6
		jmp	code_00ec

code_00d5:	dup
		ldi	$3		; y
		eq?
		bnt	code_00e3
		ldi	$1
		sag	global[$4]
		jmp	code_00ec

code_00e3:	pushi	$9b		; 155, pause
		push1
		push0
		class	Sound
		send	$6
code_00ec:	toss
		pushi	$c7		; 199, disable
		push0
		pushi	$69		; 105, 'i', hide
		push0
		lag	global[$45]
		send	$8
		pushi	$b9		; 185, setCursor
		push2
		lsg	global[$15]
		push0
		lag	global[$1]
		send	$8
		ret

rm2::init:
		pushi	$5		; view
		push1
		pushi	$3b2		; 946
		pushi	$d9		; 217, cycleSpeed
		push1
		lsg	global[$57]
		ldi	$1
		add
		push
		ldi	$4		; x
		mul
		push
		lofsa	babbleIcon
		send	$c
		push2
		push1
		pushi	$3e7		; 999
		callk	Palette, $4
		pushi	$c7		; 199, disable
		push0
		lag	global[$45]
		send	$4
		pushi	$66		; 102, 'f', flags
		push1
		push0
		lag	global[$64]
		send	$6
		pushi	$6b		; 107, 'k', init
		push0
		super	Rm, $4
		pushi	$7d		; 125, '}', addToFront
		push1
		pushSelf
		lag	global[$48]
		send	$6
		pushi	$7d		; 125, '}', addToFront
		push1
		pushSelf
		lag	global[$49]
		send	$6
		pushi	$b9		; 185, setCursor
		push2
		lsg	global[$15]
		push0
		lag	global[$1]
		send	$8
		pushi	$8c		; 140, setScript
		push1
		lofsa	finalCredits
		push
		self	$6
		ret

rm2::handleEvent:
		pushi	$22		; 34, '"', type
		push0
		lap	param[$1]
		send	$4
		bnt	code_01a6
		lsg	global[$b]
		lag	global[$d]
		eq?
		bnt	code_01a6
		pushi	$4c		; 76, 'L', claimed
		push1
		push1
		lap	param[$1]
		send	$6
		pushi	$9b		; 155, pause
		push1
		push1
		class	Sound
		send	$6
		pushi	$c7		; 199, disable
		push0
		lag	global[$45]
		send	$4
		pushi	$b9		; 185, setCursor
		pushi	$4		; x
		lsg	global[$14]
		push1
		pushi	$a0		; 160, setLoop
		pushi	$64		; 100, 'd', moveDone
		lag	global[$1]
		send	$c
		pushi	$3		; y
		push0
		push2
		push0
		call	code_005e, $6
code_01a6:	ret

rm2::newRoom:
		pushi	$66		; 102, 'f', flags
		push1
		push1
		pushi	$9d		; 157, fade
		push0
		lag	global[$64]
		send	$a
		pushi	$177		; 375, newRoom
		push1
		lsp	param[$1]
		super	Rm, $6
		ret

; export002_0
instance rm2 of Rm
{
	script          = $0
	number          = $0
	timer           = $0
	keep            = $0
	initialized     = $0
	lookStr         = $0
	picture         = $2
	style           = $8009		; -32759
	horizon         = $0
	controls        = $0
	north           = $0
	east            = $0
	south           = $0
	west            = $0
	curPic          = $0
	picAngle        = $0
	vanishingX      = $a0		; 160, setLoop
	vanishingY      = $8ad0		; -30000
	obstacles       = $0

	init()
	handleEvent()
	newRoom()
}

finalCredits::init:
		pushi	$6b		; 107, 'k', init
		push0
		&rest	$1
		super	DScript, $4
		ldi	$0
		aTop	clrByKey
		ret

finalCredits::changeState:
		lap	param[$1]
		aTop	state
		push
		dup
		ldi	$0
		eq?
		bnt	code_0254
		pushi	$25f		; 607, save1
		push1
		pushi	$d		; 13, lsTop
		lofsa	string_0588	; "Animators:\n"
		push
		pushi	$65		; 101, 'e', topString
		push1
		pushi	$69		; 105, 'i', hide
		pushi	$4		; x
		pushi	$6a		; 106, 'j', new
		pushi	$c8		; 200, noClickHelp
		pushi	$66		; 102, 'f', flags
		lsg	global[$8e]
		pushi	$64		; 100, 'd', moveDone
		pushi	$3c		; 60, '<', doit
		pushi	$14		; 20, brLeft
		pushi	$6b		; 107, 'k', init
		callk	Display, $1a
		push
		self	$6
		ldi	$f		; 15, lsBottom
		aTop	seconds
		jmp	code_04ce

code_0254:	dup
		ldi	$1
		eq?
		bnt	code_0267
		pushi	$4f		; 79, 'O', restore
		push0
		self	$4
		ldi	$3		; y
		aTop	cycles
		jmp	code_04ce

code_0267:	dup
		ldi	$2
		eq?
		bnt	code_029d
		pushi	$25f		; 607, save1
		push1
		pushi	$d		; 13, lsTop
		lofsa	string_0620	; "Background Artists:\n"
		push
		pushi	$65		; 101, 'e', topString
		push1
		pushi	$69		; 105, 'i', hide
		pushi	$4		; x
		pushi	$6a		; 106, 'j', new
		pushi	$c8		; 200, noClickHelp
		pushi	$66		; 102, 'f', flags
		lsg	global[$8e]
		pushi	$64		; 100, 'd', moveDone
		pushi	$3c		; 60, '<', doit
		pushi	$14		; 20, brLeft
		pushi	$6b		; 107, 'k', init
		callk	Display, $1a
		push
		self	$6
		ldi	$f		; 15, lsBottom
		aTop	seconds
		jmp	code_04ce

code_029d:	dup
		ldi	$3		; y
		eq?
		bnt	code_02b0
		pushi	$4f		; 79, 'O', restore
		push0
		self	$4
		ldi	$3		; y
		aTop	cycles
		jmp	code_04ce

code_02b0:	dup
		ldi	$4		; x
		eq?
		bnt	code_02e6
		pushi	$25f		; 607, save1
		push1
		pushi	$d		; 13, lsTop
		lofsa	string_06cb	; "Programmers:\n"
		push
		pushi	$65		; 101, 'e', topString
		push1
		pushi	$69		; 105, 'i', hide
		pushi	$4		; x
		pushi	$6a		; 106, 'j', new
		pushi	$c8		; 200, noClickHelp
		pushi	$66		; 102, 'f', flags
		lsg	global[$8e]
		pushi	$64		; 100, 'd', moveDone
		pushi	$3c		; 60, '<', doit
		pushi	$14		; 20, brLeft
		pushi	$6b		; 107, 'k', init
		callk	Display, $1a
		push
		self	$6
		ldi	$c		; 12, nsRight
		aTop	seconds
		jmp	code_04ce

code_02e6:	dup
		ldi	$5		; view
		eq?
		bnt	code_02f9
		pushi	$4f		; 79, 'O', restore
		push0
		self	$4
		ldi	$3		; y
		aTop	cycles
		jmp	code_04ce

code_02f9:	dup
		ldi	$6		; loop
		eq?
		bnt	code_032f
		pushi	$25f		; 607, save1
		push1
		pushi	$d		; 13, lsTop
		lofsa	string_0722	; "Music Director:\n"
		push
		pushi	$65		; 101, 'e', topString
		push1
		pushi	$69		; 105, 'i', hide
		pushi	$4		; x
		pushi	$6a		; 106, 'j', new
		pushi	$c8		; 200, noClickHelp
		pushi	$66		; 102, 'f', flags
		lsg	global[$8e]
		pushi	$64		; 100, 'd', moveDone
		pushi	$3c		; 60, '<', doit
		pushi	$14		; 20, brLeft
		pushi	$6b		; 107, 'k', init
		callk	Display, $1a
		push
		self	$6
		ldi	$8		; underBits
		aTop	seconds
		jmp	code_04ce

code_032f:	dup
		ldi	$7		; cel
		eq?
		bnt	code_0342
		pushi	$4f		; 79, 'O', restore
		push0
		self	$4
		ldi	$3		; y
		aTop	cycles
		jmp	code_04ce

code_0342:	dup
		ldi	$8		; underBits
		eq?
		bnt	code_0378
		pushi	$25f		; 607, save1
		push1
		pushi	$d		; 13, lsTop
		lofsa	string_0741	; "System Development:\n"
		push
		pushi	$65		; 101, 'e', topString
		push1
		pushi	$69		; 105, 'i', hide
		pushi	$4		; x
		pushi	$6a		; 106, 'j', new
		pushi	$c8		; 200, noClickHelp
		pushi	$66		; 102, 'f', flags
		lsg	global[$8e]
		pushi	$64		; 100, 'd', moveDone
		pushi	$3c		; 60, '<', doit
		pushi	$14		; 20, brLeft
		pushi	$6b		; 107, 'k', init
		callk	Display, $1a
		push
		self	$6
		ldi	$f		; 15, lsBottom
		aTop	seconds
		jmp	code_04ce

code_0378:	dup
		ldi	$9		; nsTop
		eq?
		bnt	code_038b
		pushi	$4f		; 79, 'O', restore
		push0
		self	$4
		ldi	$3		; y
		aTop	cycles
		jmp	code_04ce

code_038b:	dup
		ldi	$a		; 10, nsLeft
		eq?
		bnt	code_03c1
		pushi	$25f		; 607, save1
		push1
		pushi	$d		; 13, lsTop
		lofsa	string_07d2	; "Sound Effects:\n"
		push
		pushi	$65		; 101, 'e', topString
		push1
		pushi	$69		; 105, 'i', hide
		pushi	$4		; x
		pushi	$6a		; 106, 'j', new
		pushi	$c8		; 200, noClickHelp
		pushi	$66		; 102, 'f', flags
		lsg	global[$8e]
		pushi	$64		; 100, 'd', moveDone
		pushi	$3c		; 60, '<', doit
		pushi	$14		; 20, brLeft
		pushi	$6b		; 107, 'k', init
		callk	Display, $1a
		push
		self	$6
		ldi	$a		; 10, nsLeft
		aTop	seconds
		jmp	code_04ce

code_03c1:	dup
		ldi	$b		; 11, nsBottom
		eq?
		bnt	code_03d4
		pushi	$4f		; 79, 'O', restore
		push0
		self	$4
		ldi	$3		; y
		aTop	cycles
		jmp	code_04ce

code_03d4:	dup
		ldi	$c		; 12, nsRight
		eq?
		bnt	code_040a
		pushi	$25f		; 607, save1
		push1
		pushi	$d		; 13, lsTop
		lofsa	string_0809	; "Additional Written Material:\n"
		push
		pushi	$65		; 101, 'e', topString
		push1
		pushi	$69		; 105, 'i', hide
		pushi	$4		; x
		pushi	$6a		; 106, 'j', new
		pushi	$c8		; 200, noClickHelp
		pushi	$66		; 102, 'f', flags
		lsg	global[$8e]
		pushi	$64		; 100, 'd', moveDone
		pushi	$3c		; 60, '<', doit
		pushi	$14		; 20, brLeft
		pushi	$6b		; 107, 'k', init
		callk	Display, $1a
		push
		self	$6
		ldi	$a		; 10, nsLeft
		aTop	seconds
		jmp	code_04ce

code_040a:	dup
		ldi	$d		; 13, lsTop
		eq?
		bnt	code_041d
		pushi	$4f		; 79, 'O', restore
		push0
		self	$4
		ldi	$3		; y
		aTop	cycles
		jmp	code_04ce

code_041d:	dup
		ldi	$e		; 14, lsLeft
		eq?
		bnt	code_0453
		pushi	$25f		; 607, save1
		push1
		pushi	$d		; 13, lsTop
		lofsa	string_0843	; "Space Quest 1 Theme Based on the\n"
		push
		pushi	$65		; 101, 'e', topString
		push1
		pushi	$69		; 105, 'i', hide
		pushi	$4		; x
		pushi	$6a		; 106, 'j', new
		pushi	$c8		; 200, noClickHelp
		pushi	$66		; 102, 'f', flags
		lsg	global[$8e]
		pushi	$64		; 100, 'd', moveDone
		pushi	$3c		; 60, '<', doit
		pushi	$14		; 20, brLeft
		pushi	$6b		; 107, 'k', init
		callk	Display, $1a
		push
		self	$6
		ldi	$a		; 10, nsLeft
		aTop	seconds
		jmp	code_04ce

code_0453:	dup
		ldi	$f		; 15, lsBottom
		eq?
		bnt	code_0466
		pushi	$4f		; 79, 'O', restore
		push0
		self	$4
		ldi	$3		; y
		aTop	cycles
		jmp	code_04ce

code_0466:	dup
		ldi	$10		; 16, lsRight
		eq?
		bnt	code_049c
		pushi	$25f		; 607, save1
		push1
		pushi	$d		; 13, lsTop
		lofsa	string_0888	; "Quality Assurance:\n"
		push
		pushi	$65		; 101, 'e', topString
		push1
		pushi	$69		; 105, 'i', hide
		pushi	$4		; x
		pushi	$6a		; 106, 'j', new
		pushi	$c8		; 200, noClickHelp
		pushi	$66		; 102, 'f', flags
		lsg	global[$8e]
		pushi	$64		; 100, 'd', moveDone
		pushi	$3c		; 60, '<', doit
		pushi	$14		; 20, brLeft
		pushi	$6b		; 107, 'k', init
		callk	Display, $1a
		push
		self	$6
		ldi	$a		; 10, nsLeft
		aTop	seconds
		jmp	code_04ce

code_049c:	dup
		ldi	$11		; 17, signal
		eq?
		bnt	code_04af
		pushi	$4f		; 79, 'O', restore
		push0
		self	$4
		ldi	$3		; y
		aTop	cycles
		jmp	code_04ce

code_04af:	dup
		ldi	$12		; 18, illegalBits
		eq?
		bnt	code_04ce
		pushi	$b9		; 185, setCursor
		push2
		lsg	global[$13]
		push0
		callk	HaveMouse, $0
		push
		lag	global[$1]
		send	$8
		pushi	$3		; y
		push0
		push2
		push0
		call	code_005e, $6
code_04ce:	toss
		ret

instance finalCredits of DScript
{
	client          = $0
	state           = $ffff		; -1
	start           = $0
	timer           = $0
	cycles          = $0
	seconds         = $0
	lastSeconds     = $0
	ticks           = $0
	lastTicks       = $0
	register        = $0
	script          = $0
	caller          = $0
	next            = $0
	save1           = $0
	DTimer          = $a		; 10, nsLeft
	counter         = $0
	clrByKey        = $1

	init()
	changeState()
}

string_0516	= "babbleIcon"
string_0521	= "Thank you for playing Space Quest I. As usual, you've been most entertaining."
string_056f	= "Restore"
string_0577	= "Restart"
string_057f	= "Quit"
string_0584	= "rm2"
string_0588	= "Animators:\n" \
		  "\n" \
		  "Douglas Herring\n" \
		  "Vasken Nokhoudian\n" \
		  "Nathan Larsen\n" \
		  "Arturo Sinclair\n" \
		  "Deena Krutak\n" \
		  "Desie Hartman\n" \
		  "Jerry Jessurun\n" \
		  "Russell Truelove\n" \
		  "Diana R. Wilson\n"
string_0620	= "Background Artists:\n" \
		  "\n" \
		  "Douglas Herring\n" \
		  "Nathan Larsen\n" \
		  "Arturo Sinclair\n" \
		  "Eric Kasner\n" \
		  "Willis Wong\n" \
		  "Jay Allan Friedmann\n" \
		  "Jennifer Shontz\n" \
		  "Andy Hoyos\n" \
		  "Jane Cardinal\n" \
		  "Maurice F. Morgan\n"
string_06cb	= "Programmers:\n" \
		  "\n" \
		  "Jerry Shaw\n" \
		  "Randy MacNeill\n" \
		  "Dave Jamriska\n" \
		  "Hugh Diedrichs\n" \
		  "Christopher Carr\n"
string_0722	= "Music Director:\n" \
		  "\n" \
		  "Mark Seibert\n"
string_0741	= "System Development:\n" \
		  "\n" \
		  "Chris Smith\n" \
		  "Jeff Stephenson\n" \
		  "Robert E. Heitman\n" \
		  "Pablo Ghenis\n" \
		  "Dan Foy\n" \
		  "Larry Scott\n" \
		  "J. Mark Hood\n" \
		  "Mark Wilden\n" \
		  "Eric Hart\n" \
		  "Chad Bye\n"
string_07d2	= "Sound Effects:\n" \
		  "\n" \
		  "Ken Allen\n" \
		  "Mark Seibert\n" \
		  "Orpheus Hanley\n"
string_0809	= "Additional Written Material:\n" \
		  "\n" \
		  "Bridget McKenna\n" \
		  "Gano Haine\n"
string_0843	= "Space Quest 1 Theme Based on the\n" \
		  "Original Composition by Mark Crowe "
string_0888	= "Quality Assurance:\n" \
		  "\n" \
		  "Sharon Simmons "
string_08ac	= "finalCredits"

local[$3] =
{
	$0, $0, $0
}

