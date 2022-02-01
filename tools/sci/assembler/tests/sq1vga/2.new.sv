export002_0	= rm2

babbleIcon::method_107:
		pushi	$6b		; 107, 'k'
		push2
		pushSelf
		pushi	$14		; 20
		pushi	$6a		; 106, 'j'
		push0
		class	class_94
		send	$4
		aTop	property_16
		send	$8
		ret

instance babbleIcon of class_83
{
	property_???    = $4
	property_???    = $0
	property_???    = $0
	property_???    = $0
	property_???    = $0
	property_???    = $0
	property_???    = $0
	property_???    = $0
	property_???    = $0
	property_???    = $0
	property_???    = $0
	property_???    = $0
	property_???    = $0
	property_???    = $6
	property_???    = $0

	method_107()
}

code_005e:	link	$12f
		pushi	$b9		; 185
		push2
		lsg	global[$14]
		push1
		lag	global[$1]
		send	$8
		pushi	$14		; 20
		lofsa	string_0509	; "Thank you for playing Space Quest I. As usual, you've been most entertaining."
		push
		pushi	$43		; 67, 'C'
		pushi	$64		; 100, 'd'
		pushi	$3c		; 60, '<'
		pushi	$6a		; 106, 'j'
		pushi	$51		; 81, 'Q'
		lofsa	string_0557	; "Restore"
		push
		push1
		pushi	$6a		; 106, 'j'
		pushi	$51		; 81, 'Q'
		lofsa	string_055f	; "Restart"
		push
		push2
		pushi	$6a		; 106, 'j'
		pushi	$51		; 81, 'Q'
		lofsa	string_0567	; "Quit"
		push
		pushi	$3
		pushi	$52		; 82, 'R'
		lsp	param[$1]
		lsp	param[$2]
		lsp	param[$3]
		calle	export255_0, $28
		push
		dup
		ldi	$1
		eq?
		bnt	code_00b9
		pushi	$4f		; 79, 'O'
		push0
		lag	global[$1]
		send	$4
		pushi	$9b		; 155
		push1
		push0
		class	class_10
		send	$6
		jmp	code_00e8

code_00b9:	dup
		ldi	$2
		eq?
		bnt	code_00d2
		pushi	$68		; 104, 'h'
		push0
		lag	global[$1]
		send	$4
		pushi	$9b		; 155
		push1
		push0
		class	class_10
		send	$6
		jmp	code_00e8

code_00d2:	dup
		ldi	$3
		eq?
		bnt	code_00e0
		ldi	$1
		sag	global[$4]
		jmp	code_00e8

code_00e0:	pushi	$9b		; 155
		push1
		push0
		class	class_10
		send	$6
code_00e8:	toss
		pushi	$c7		; 199
		push0
		pushi	$69		; 105, 'i'
		push0
		lag	global[$45]
		send	$8
		pushi	$b9		; 185
		push2
		lsg	global[$15]
		push0
		lag	global[$1]
		send	$8
		ret

rm2::method_107:
		pushi	$5
		push1
		pushi	$3b2		; 946
		pushi	$d9		; 217
		push1
		lsg	global[$57]
		ldi	$1
		add
		push
		ldi	$4
		mul
		push
		lofsa	babbleIcon
		send	$c
		push2
		push1
		pushi	$3e7		; 999
		callk	kernel_111, $4
		pushi	$c7		; 199
		push0
		lag	global[$45]
		send	$4
		pushi	$66		; 102, 'f'
		push1
		push0
		lag	global[$64]
		send	$6
		pushi	$6b		; 107, 'k'
		push0
		super	class_67, $4
		pushi	$7d		; 125, '}'
		push1
		pushSelf
		lag	global[$48]
		send	$6
		pushi	$7d		; 125, '}'
		push1
		pushSelf
		lag	global[$49]
		send	$6
		pushi	$b9		; 185
		push2
		lsg	global[$15]
		push0
		lag	global[$1]
		send	$8
		pushi	$8c		; 140
		push1
		lofsa	finalCredits
		push
		self	$6
		ret

rm2::method_129:
		pushi	$22		; 34, '"'
		push0
		lap	param[$1]
		send	$4
		bnt	code_0198
		lsg	global[$b]
		lag	global[$d]
		eq?
		bnt	code_0198
		pushi	$4c		; 76, 'L'
		push1
		push1
		lap	param[$1]
		send	$6
		pushi	$9b		; 155
		push1
		push1
		class	class_10
		send	$6
		pushi	$c7		; 199
		push0
		lag	global[$45]
		send	$4
		pushi	$b9		; 185
		pushi	$4
		lsg	global[$14]
		push1
		pushi	$a0		; 160
		pushi	$64		; 100, 'd'
		lag	global[$1]
		send	$c
		pushi	$3
		push0
		push2
		push0
		call	code_005e, $6
code_0198:	ret

rm2::method_375:
		pushi	$66		; 102, 'f'
		push1
		push1
		pushi	$9d		; 157
		push0
		lag	global[$64]
		send	$a
		pushi	$177		; 375
		push1
		lsp	param[$1]
		super	class_67, $6
		ret

		bnot
		bnot
; export002_0
instance rm2 of class_67
{
	property_???    = $0
	property_???    = $0
	property_???    = $0
	property_???    = $0
	property_???    = $0
	property_???    = $0
	property_???    = $2
	property_???    = $8009		; -32759
	property_???    = $0
	property_???    = $0
	property_???    = $0
	property_???    = $0
	property_???    = $0
	property_???    = $0
	property_???    = $0
	property_???    = $0
	property_???    = $a0		; 160
	property_???    = $8ad0		; -30000
	property_???    = $0

	method_107()
	method_129()
	method_375()
}

finalCredits::method_107:
		pushi	$6b		; 107, 'k'
		push0
		&rest	$1
		super	class_128, $4
		ldi	$0
		aTop	property_20
		ret

finalCredits::method_138:
		lap	param[$1]
		aTop	property_5
		push
		dup
		ldi	$0
		eq?
		bnt	code_0245
		pushi	$25f		; 607
		push1
		pushi	$d		; 13
		lofsa	string_0570	; "Animators:\\n\\nDouglas Herring\\nVasken Nokhoudian\\nNathan Larsen\\nArturo Sinclair\\nDeena Krutak\\nDesie Hartman\\nJerry Jessurun\\nRussell Truelove\\nDiana R. Wilson\\n"
		push
		pushi	$65		; 101, 'e'
		push1
		pushi	$69		; 105, 'i'
		pushi	$4
		pushi	$6a		; 106, 'j'
		pushi	$c8		; 200
		pushi	$66		; 102, 'f'
		lsg	global[$8e]
		pushi	$64		; 100, 'd'
		pushi	$3c		; 60, '<'
		pushi	$14		; 20
		pushi	$6b		; 107, 'k'
		callk	kernel_27, $1a
		push
		self	$6
		ldi	$f		; 15
		aTop	property_9
		jmp	code_04b6

code_0245:	dup
		ldi	$1
		eq?
		bnt	code_0258
		pushi	$4f		; 79, 'O'
		push0
		self	$4
		ldi	$3
		aTop	property_8
		jmp	code_04b6

code_0258:	dup
		ldi	$2
		eq?
		bnt	code_028d
		pushi	$25f		; 607
		push1
		pushi	$d		; 13
		lofsa	string_0613	; "Background Artists:\\n\\nDouglas Herring\\nNathan Larsen\\nArturo Sinclair\\nEric Kasner\\nWillis Wong\\nJay Allan Friedmann\\nJennifer Shontz\\nAndy Hoyos\\nJane Cardinal\\nMaurice F. Morgan\\n"
		push
		pushi	$65		; 101, 'e'
		push1
		pushi	$69		; 105, 'i'
		pushi	$4
		pushi	$6a		; 106, 'j'
		pushi	$c8		; 200
		pushi	$66		; 102, 'f'
		lsg	global[$8e]
		pushi	$64		; 100, 'd'
		pushi	$3c		; 60, '<'
		pushi	$14		; 20
		pushi	$6b		; 107, 'k'
		callk	kernel_27, $1a
		push
		self	$6
		ldi	$f		; 15
		aTop	property_9
		jmp	code_04b6

code_028d:	dup
		ldi	$3
		eq?
		bnt	code_02a0
		pushi	$4f		; 79, 'O'
		push0
		self	$4
		ldi	$3
		aTop	property_8
		jmp	code_04b6

code_02a0:	dup
		ldi	$4
		eq?
		bnt	code_02d5
		pushi	$25f		; 607
		push1
		pushi	$d		; 13
		lofsa	string_06ca	; "Programmers:\\n\\nJerry Shaw\\nRandy MacNeill\\nDave Jamriska\\nHugh Diedrichs\\nChristopher Carr\\n"
		push
		pushi	$65		; 101, 'e'
		push1
		pushi	$69		; 105, 'i'
		pushi	$4
		pushi	$6a		; 106, 'j'
		pushi	$c8		; 200
		pushi	$66		; 102, 'f'
		lsg	global[$8e]
		pushi	$64		; 100, 'd'
		pushi	$3c		; 60, '<'
		pushi	$14		; 20
		pushi	$6b		; 107, 'k'
		callk	kernel_27, $1a
		push
		self	$6
		ldi	$c		; 12
		aTop	property_9
		jmp	code_04b6

code_02d5:	dup
		ldi	$5
		eq?
		bnt	code_02e8
		pushi	$4f		; 79, 'O'
		push0
		self	$4
		ldi	$3
		aTop	property_8
		jmp	code_04b6

code_02e8:	dup
		ldi	$6
		eq?
		bnt	code_031d
		pushi	$25f		; 607
		push1
		pushi	$d		; 13
		lofsa	string_0728	; "Music Director:\\n\\nMark Seibert\\n"
		push
		pushi	$65		; 101, 'e'
		push1
		pushi	$69		; 105, 'i'
		pushi	$4
		pushi	$6a		; 106, 'j'
		pushi	$c8		; 200
		pushi	$66		; 102, 'f'
		lsg	global[$8e]
		pushi	$64		; 100, 'd'
		pushi	$3c		; 60, '<'
		pushi	$14		; 20
		pushi	$6b		; 107, 'k'
		callk	kernel_27, $1a
		push
		self	$6
		ldi	$8
		aTop	property_9
		jmp	code_04b6

code_031d:	dup
		ldi	$7
		eq?
		bnt	code_0330
		pushi	$4f		; 79, 'O'
		push0
		self	$4
		ldi	$3
		aTop	property_8
		jmp	code_04b6

code_0330:	dup
		ldi	$8
		eq?
		bnt	code_0365
		pushi	$25f		; 607
		push1
		pushi	$d		; 13
		lofsa	string_074a	; "System Development:\\n\\nChris Smith\\nJeff Stephenson\\nRobert E. Heitman\\nPablo Ghenis\\nDan Foy\\nLarry Scott\\nJ. Mark Hood\\nMark Wilden\\nEric Hart\\nChad Bye\\n"
		push
		pushi	$65		; 101, 'e'
		push1
		pushi	$69		; 105, 'i'
		pushi	$4
		pushi	$6a		; 106, 'j'
		pushi	$c8		; 200
		pushi	$66		; 102, 'f'
		lsg	global[$8e]
		pushi	$64		; 100, 'd'
		pushi	$3c		; 60, '<'
		pushi	$14		; 20
		pushi	$6b		; 107, 'k'
		callk	kernel_27, $1a
		push
		self	$6
		ldi	$f		; 15
		aTop	property_9
		jmp	code_04b6

code_0365:	dup
		ldi	$9
		eq?
		bnt	code_0378
		pushi	$4f		; 79, 'O'
		push0
		self	$4
		ldi	$3
		aTop	property_8
		jmp	code_04b6

code_0378:	dup
		ldi	$a		; 10
		eq?
		bnt	code_03ad
		pushi	$25f		; 607
		push1
		pushi	$d		; 13
		lofsa	string_07e7	; "Sound Effects:\\n\\nKen Allen\\nMark Seibert\\nOrpheus Hanley\\n"
		push
		pushi	$65		; 101, 'e'
		push1
		pushi	$69		; 105, 'i'
		pushi	$4
		pushi	$6a		; 106, 'j'
		pushi	$c8		; 200
		pushi	$66		; 102, 'f'
		lsg	global[$8e]
		pushi	$64		; 100, 'd'
		pushi	$3c		; 60, '<'
		pushi	$14		; 20
		pushi	$6b		; 107, 'k'
		callk	kernel_27, $1a
		push
		self	$6
		ldi	$a		; 10
		aTop	property_9
		jmp	code_04b6

code_03ad:	dup
		ldi	$b		; 11
		eq?
		bnt	code_03c0
		pushi	$4f		; 79, 'O'
		push0
		self	$4
		ldi	$3
		aTop	property_8
		jmp	code_04b6

code_03c0:	dup
		ldi	$c		; 12
		eq?
		bnt	code_03f5
		pushi	$25f		; 607
		push1
		pushi	$d		; 13
		lofsa	string_0823	; "Additional Written Material:\\n\\nBridget McKenna\\nGano Haine\\n"
		push
		pushi	$65		; 101, 'e'
		push1
		pushi	$69		; 105, 'i'
		pushi	$4
		pushi	$6a		; 106, 'j'
		pushi	$c8		; 200
		pushi	$66		; 102, 'f'
		lsg	global[$8e]
		pushi	$64		; 100, 'd'
		pushi	$3c		; 60, '<'
		pushi	$14		; 20
		pushi	$6b		; 107, 'k'
		callk	kernel_27, $1a
		push
		self	$6
		ldi	$a		; 10
		aTop	property_9
		jmp	code_04b6

code_03f5:	dup
		ldi	$d		; 13
		eq?
		bnt	code_0408
		pushi	$4f		; 79, 'O'
		push0
		self	$4
		ldi	$3
		aTop	property_8
		jmp	code_04b6

code_0408:	dup
		ldi	$e		; 14
		eq?
		bnt	code_043d
		pushi	$25f		; 607
		push1
		pushi	$d		; 13
		lofsa	string_0861	; "Space Quest 1 Theme Based on the\\nOriginal Composition by Mark Crowe "
		push
		pushi	$65		; 101, 'e'
		push1
		pushi	$69		; 105, 'i'
		pushi	$4
		pushi	$6a		; 106, 'j'
		pushi	$c8		; 200
		pushi	$66		; 102, 'f'
		lsg	global[$8e]
		pushi	$64		; 100, 'd'
		pushi	$3c		; 60, '<'
		pushi	$14		; 20
		pushi	$6b		; 107, 'k'
		callk	kernel_27, $1a
		push
		self	$6
		ldi	$a		; 10
		aTop	property_9
		jmp	code_04b6

code_043d:	dup
		ldi	$f		; 15
		eq?
		bnt	code_0450
		pushi	$4f		; 79, 'O'
		push0
		self	$4
		ldi	$3
		aTop	property_8
		jmp	code_04b6

code_0450:	dup
		ldi	$10		; 16
		eq?
		bnt	code_0485
		pushi	$25f		; 607
		push1
		pushi	$d		; 13
		lofsa	string_08a7	; "Quality Assurance:\\n\\nSharon Simmons "
		push
		pushi	$65		; 101, 'e'
		push1
		pushi	$69		; 105, 'i'
		pushi	$4
		pushi	$6a		; 106, 'j'
		pushi	$c8		; 200
		pushi	$66		; 102, 'f'
		lsg	global[$8e]
		pushi	$64		; 100, 'd'
		pushi	$3c		; 60, '<'
		pushi	$14		; 20
		pushi	$6b		; 107, 'k'
		callk	kernel_27, $1a
		push
		self	$6
		ldi	$a		; 10
		aTop	property_9
		jmp	code_04b6

code_0485:	dup
		ldi	$11		; 17
		eq?
		bnt	code_0498
		pushi	$4f		; 79, 'O'
		push0
		self	$4
		ldi	$3
		aTop	property_8
		jmp	code_04b6

code_0498:	dup
		ldi	$12		; 18
		eq?
		bnt	code_04b6
		pushi	$b9		; 185
		push2
		lsg	global[$13]
		push0
		callk	kernel_39, $0
		push
		lag	global[$1]
		send	$8
		pushi	$3
		push0
		push2
		push0
		call	code_005e, $6
code_04b6:	toss
		ret

instance finalCredits of class_128
{
	property_???    = $0
	property_???    = $ffff		; -1
	property_???    = $0
	property_???    = $0
	property_???    = $0
	property_???    = $0
	property_???    = $0
	property_???    = $0
	property_???    = $0
	property_???    = $0
	property_???    = $0
	property_???    = $0
	property_???    = $0
	property_???    = $0
	property_???    = $a		; 10
	property_???    = $0
	property_???    = $1

	method_107()
	method_138()
}

string_04fe	= "babbleIcon"
string_0509	= "Thank you for playing Space Quest I. As usual, you've been most entertaining."
string_0557	= "Restore"
string_055f	= "Restart"
string_0567	= "Quit"
string_056c	= "rm2"
string_0570	= "Animators:\\n\\nDouglas Herring\\nVasken Nokhoudian\\nNathan Larsen\\nArturo Sinclair\\nDeena Krutak\\nDesie Hartman\\nJerry Jessurun\\nRussell Truelove\\nDiana R. Wilson\\n"
string_0613	= "Background Artists:\\n\\nDouglas Herring\\nNathan Larsen\\nArturo Sinclair\\nEric Kasner\\nWillis Wong\\nJay Allan Friedmann\\nJennifer Shontz\\nAndy Hoyos\\nJane Cardinal\\nMaurice F. Morgan\\n"
string_06ca	= "Programmers:\\n\\nJerry Shaw\\nRandy MacNeill\\nDave Jamriska\\nHugh Diedrichs\\nChristopher Carr\\n"
string_0728	= "Music Director:\\n\\nMark Seibert\\n"
string_074a	= "System Development:\\n\\nChris Smith\\nJeff Stephenson\\nRobert E. Heitman\\nPablo Ghenis\\nDan Foy\\nLarry Scott\\nJ. Mark Hood\\nMark Wilden\\nEric Hart\\nChad Bye\\n"
string_07e7	= "Sound Effects:\\n\\nKen Allen\\nMark Seibert\\nOrpheus Hanley\\n"
string_0823	= "Additional Written Material:\\n\\nBridget McKenna\\nGano Haine\\n"
string_0861	= "Space Quest 1 Theme Based on the\\nOriginal Composition by Mark Crowe "
string_08a7	= "Quality Assurance:\\n\\nSharon Simmons "
string_08cd	= "finalCredits"

local[$3] =
{
	$0, $0, $0
}

