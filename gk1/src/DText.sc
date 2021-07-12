;;; Sierra Script 1.0 - (do not remove this comment)
(script# 64915)
(include sci.sh)
(use Main)
(use Class_64916_0)
(use Array)
(use Obj)


(class DText of Class_64916_0
	(properties
		heading 0
		noun 0
		case 0
		modNum -1
		nsLeft 0
		nsTop 0
		nsRight 0
		nsBottom 0
		sightAngle 26505
		actions 0
		onMeCheck $0000
		state $0000
		approachX 0
		approachY 0
		approachDist 0
		_approachVerbs 0
		plane 0
		x 0
		y 0
		z 0
		scaleX 128
		scaleY 128
		maxScale 128
		scaleType 0
		priority 0
		fixPriority 0
		inLeft 0
		inTop 0
		inRight 0
		inBottom 0
		useInsetRect 0
		view -1
		loop 0
		cel 0
		bitmap 0
		yStep 2
		signal $0000
		lsLeft 0
		lsTop 0
		lsRight 0
		lsBottom 0
		brLeft 0
		brTop 0
		brRight 0
		brBottom 0
		scaleSignal $0000
		magnifier 0
		type $0002
		key 0
		value 0
		object 0
		selector 0
		textLeft 0
		textTop 0
		textRight 0
		textBottom 0
		text 0
		mode 0
		fore 0
		back 254
		skip 254
		font 1
		borderColor -1
		dimmed 0
		rects 0
	)
	
	(method (new)
		((super new:) font: gFont yourself:)
	)
	
	(method (init)
		(self draw:)
		(super init: &rest)
	)
	
	(method (dispose param1 &tmp theBitmap)
		(if (or (not argc) (not param1)) (String 4 text))
		(if rects (rects dispose:) (= rects 0))
		(= theBitmap 0)
		(if bitmap (= theBitmap bitmap) (= bitmap 0))
		(super dispose:)
		(if theBitmap (DisposeTextBitmap theBitmap))
	)
	
	(method (handleEvent pEvent &tmp temp0 temp1 temp2 temp3 temp4)
		(asm
			lag      global17
			bnt      code_0334
			pToa     rects
			bnt      code_0334
			pushi    3
			pushi    #type
			pushi    0
			lap      pEvent
			send     4
			push    
			pushi    1
			pushi    32
			calle    proc64999_5,  6
			bt       code_0295
			pushi    #type
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      4
			eq?     
			bnt      code_0334
			pushi    #message
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      13
			eq?     
			bnt      code_0334
code_0295:
			ldi      65535
			sat      temp0
			pushi    #globalize
			pushi    0
			pushi    84
			pushi    1
			pushi    1
			lap      pEvent
			send     10
code_02a6:
			pushi    75
			pushi    #x
			lst      temp0
			ldi      1
			add     
			push    
			pToa     rects
			send     6
			push    
			ldi      30583
			ne?     
			bnt      code_0334
			pushi    #at
			pushi    1
			+at      temp0
			push    
			pToa     rects
			send     6
			sat      temp2
			pushi    #at
			pushi    1
			+at      temp0
			push    
			pToa     rects
			send     6
			sat      temp1
			pushi    #at
			pushi    1
			+at      temp0
			push    
			pToa     rects
			send     6
			sat      temp4
			pushi    #at
			pushi    1
			+at      temp0
			push    
			pToa     rects
			send     6
			sat      temp3
			lst      temp2
			pushi    #x
			pushi    0
			lap      pEvent
			send     4
			le?     
			bnt      code_02a6
			pprev   
			lat      temp4
			le?     
			bnt      code_02a6
			lst      temp1
			pushi    #y
			pushi    0
			lap      pEvent
			send     4
			le?     
			bnt      code_02a6
			pprev   
			lat      temp3
			le?     
			bnt      code_02a6
			pushi    69
			pushi    #x
			lst      temp0
			ldi      4
			div     
			push    
			lag      global17
			send     6
			pushi    #type
			pushi    1
			pushi    0
			pushi    84
			pushi    1
			pushi    0
			lap      pEvent
			send     12
			jmp      code_0334
			jmp      code_02a6
code_0334:
			pushi    #handleEvent
			pushi    1
			lsp      pEvent
			super    Class_64916_0,  6
			ret     
		)
	)
	
	(method (setSize param1 &tmp temp0 temp1 temp2 temp3 temp4)
		;
		; Calculate the size of the nsRect if there is no bitmap associated
		;	with us.  If 'w' is present it is the fixed width of the text
		;	rectangle.
		; w == param1
		
		(= temp1 (if (!= borderColor -1) 3 else 0))

		; The width is either 'w', the width of my bitmap (if any), or 0
		;	(which defaults to 190)
		; theWidth == temp4
		(= temp4
			(cond 
				((!= view -1) (- (CelWide view loop cel) (* temp1 2)))
				(argc param1)
				(else 0)
			)
		)
		
		; Start by calculating the textRect as the size of the text
		;D ;Z (= textLeft 0)
		;D (= textRight temp4)	;Z
		(= textLeft 0)
		(= textTop 0)
		(= temp0 (IntArray with: 0 0 0 0))
		(TextSize (temp0 data?) text font temp4)
		;Z (= textRight (+ textLeft (temp0 at: 2)))
		;D (= textLeft (- temp4 (temp0 at: 2)))	;Z
		(= textRight (+ textLeft (temp0 at: 2)))
		(if (> temp4 textRight) (= textRight temp4))	;Z
		;D(if (< textLeft 0) (= textLeft 0)) ;Z
		(= textBottom (+ textTop (temp0 at: 3)))
		(temp0 dispose:)
		
		; Now calculate the nsRect by either adding a margin (if no bitmap)
		;	or by the size of the bitmap
		(= nsLeft 0)
		(= nsTop 0)
		(if (== view -1)
			(= textLeft (+ textLeft temp1))
			(= textTop (+ textTop temp1))
			(= textRight (+ textRight temp1))
			(= textBottom (+ textBottom temp1))
			(= nsRight (+ textRight temp1))
			(= nsBottom (+ textBottom temp1))
		else
			(= temp2 (CelWide view loop cel))
			(= temp3 (CelHigh view loop cel))
			(= nsRight (+ nsLeft (- temp2 1)))
			(= nsBottom (+ nsTop (- temp3 1)))
			(= textLeft
				(+
					textLeft
					(= temp1 (/ (- temp2 (+ (- textRight textLeft) 1)) 2))
				)
			)
			(= textRight (+ textRight temp1))
			(= textTop
				(+
					textTop
					(= temp1 (/ (- temp3 (+ (- textBottom textTop) 1)) 2))
				)
			)
			(= textBottom (+ textBottom temp1))
		)
	)
	
	(method (draw &tmp theBitmap)
		(if (= theBitmap bitmap)
			(DeleteScreenItem self)
			(DisposeTextBitmap bitmap)
		)
		(= bitmap
			(if (!= view -1)
				(CreateTextBitmap 1 self)
			else
				(CreateTextBitmap
					0
					(+ (- nsRight nsLeft) 1)
					(+ (- nsBottom nsTop) 1)
					self
				)
			)
		)
		(if theBitmap (AddScreenItem self))
	)
)
