;;; Sierra Script 1.0 - (do not remove this comment)
(script# 948)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Print)
(use DIcon)
(use CueObj)
(use SysWindow)
(use Class_993_0)
(use View)
(use Obj)


(local
	[local0 50]
	[local50 30]
	[local80 100]
	[local180 100]
	[local280 100]
	local380 =  {ללכת}
	[local381 6] = [{להסתכל} {לעשות} {לדבר} {לשאול} {עזרה} {}]
	local387
	local388 =  1
	local389
	local390
	local391
	theGHSW
	newClass_993_0
)
(procedure (localproc_0282 param1)
	(param1 sightAngle: (proc255_1 {sight angle?} 40))
)

(procedure (localproc_0297 param1 &tmp newEvent temp1 temp2 newEventY newEventX newEventY_2 newEventX_2)
	(proc921_0 {Click left mouse button on top left corner})
	(while (!= ((= newEvent (Event new:)) type?) 1)
		(newEvent dispose:)
	)
	(GlobalToLocal newEvent)
	(= newEventY (newEvent y?))
	(= newEventX (newEvent x?))
	(newEvent dispose:)
	(proc921_0
		{Click left mouse button on bottom right corner}
	)
	(while (!= ((= newEvent (Event new:)) type?) 1)
		(newEvent dispose:)
	)
	(GlobalToLocal newEvent)
	(= newEventY_2 (newEvent y?))
	(= newEventX_2 (newEvent x?))
	(newEvent dispose:)
	(= temp1 (+ (/ (- newEventX_2 newEventX) 2) newEventX))
	(= temp2 (+ (/ (- newEventY_2 newEventY) 2) newEventY))
	(param1
		x: temp1
		y: temp2
		nsLeft: newEventX
		nsTop: newEventY
		nsBottom: newEventY_2
		nsRight: newEventX_2
	)
	(if local388
		(Graph
			grDRAW_LINE
			newEventY
			newEventX
			newEventY
			newEventX_2
			1
			0
		)
		(Graph
			grDRAW_LINE
			newEventY_2
			newEventX
			newEventY_2
			newEventX_2
			1
			0
		)
		(Graph
			grDRAW_LINE
			newEventY
			newEventX
			newEventY_2
			newEventX
			1
			0
		)
		(Graph
			grDRAW_LINE
			newEventY
			newEventX_2
			newEventY_2
			newEventX_2
			1
			0
		)
		(Graph
			grUPDATE_BOX
			newEventY
			newEventX
			(+ newEventY_2 1)
			(+ newEventX_2 1)
			1
		)
	)
)

(procedure (localproc_03c2 param1 &tmp newEvent)
	(param1
		view: (proc255_1 {View?} (global2 curPic?))
		loop: (proc255_1 {Loop?} 0)
		cel: (proc255_1 {Cel?} 0)
		signal: 16400
		priority: 15
		init:
	)
	(if (param1 respondsTo: #illegalBits)
		(param1 illegalBits: 0)
	)
	(while (!= ((= newEvent (Event new:)) type?) 1)
		(GlobalToLocal newEvent)
		(param1 posn: (newEvent x?) (newEvent y?))
		(Animate (gNewCast elements?) 0)
		(newEvent dispose:)
	)
	(newEvent dispose:)
)

(procedure (localproc_0468 param1 &tmp newEvent newEventX newEventY [temp3 10] temp13)
	(if
		(Print
			addText: {Where should the approach point be?}
			addButton: 1 {Select with mouse} 0 12
			addButton: 0 {Default to x, y} 0 24
			init:
		)
		(while (!= ((= newEvent (Event new:)) type?) 1)
			(newEvent dispose:)
		)
		(GlobalToLocal newEvent)
		(param1
			approachX: (= newEventX (newEvent x?))
			approachY: (= newEventY (newEvent y?))
		)
		(newEvent dispose:)
		(Graph
			grDRAW_LINE
			(- newEventY 1)
			(- newEventX 1)
			(- newEventY 1)
			(+ newEventX 1)
			7
		)
		(Graph
			grDRAW_LINE
			newEventY
			(- newEventX 1)
			newEventY
			(+ newEventX 1)
			7
		)
		(Graph
			grDRAW_LINE
			(+ newEventY 1)
			(- newEventX 1)
			(+ newEventY 1)
			(+ newEventX 1)
			7
		)
		(Graph
			grDRAW_LINE
			newEventY
			newEventX
			newEventY
			newEventX
			0
		)
		(Graph
			grUPDATE_BOX
			(- newEventY 1)
			(- newEventX 1)
			(+ newEventY 2)
			(+ newEventX 2)
			1
		)
	else
		(param1 approachX: (param1 x?) approachY: (param1 y?))
	)
	(= temp3 0)
	(= temp13
		(Print
			addText: {How far away must ego be before}
			addText: {he tries to approach?} 0 12
			addEdit: @temp3 5 -113 13
			addButton: 1 {Select with mouse} 0 24
			addButton: 0 {Always approach} 0 36
			init:
		)
	)
	(cond 
		(temp3 (param1 approachDist: (ReadNumber @temp3)))
		((not temp13) (param1 approachDist: 0))
		(else
			(while (!= ((= newEvent (Event new:)) type?) 1)
				(newEvent dispose:)
			)
			(GlobalToLocal newEvent)
			(= newEventX (newEvent x?))
			(= newEventY (newEvent y?))
			(param1
				approachDist: (GetDistance
					(param1 x?)
					(param1 y?)
					newEventX
					newEventY
				)
			)
			(newEvent dispose:)
			(Graph
				grDRAW_LINE
				(- newEventY 1)
				(- newEventX 1)
				(- newEventY 1)
				(+ newEventX 1)
				28
			)
			(Graph
				grDRAW_LINE
				newEventY
				(- newEventX 1)
				newEventY
				(+ newEventX 1)
				28
			)
			(Graph
				grDRAW_LINE
				(+ newEventY 1)
				(- newEventX 1)
				(+ newEventY 1)
				(+ newEventX 1)
				28
			)
			(Graph
				grDRAW_LINE
				newEventY
				newEventX
				newEventY
				newEventX
				52
			)
			(Graph
				grUPDATE_BOX
				(- newEventY 1)
				(- newEventX 1)
				(+ newEventY 2)
				(+ newEventX 2)
				1
			)
		)
	)
)

(procedure (localproc_06df)
	(= local391
		(Print
			addText: {doVerb method?}
			addButton: 1 {YES} 0 12
			addButton: 0 {NO} 50 12
			init:
		)
	)
)

(procedure (localproc_070d param1)
	(newClass_993_0
		name: @global42
		writeString: param1
		close:
	)
)

(class Class_948_0
	(properties)
	
	(method (doit &tmp [temp0 15] temp15 newEvent)
		(gGame setCursor: 999)
		(= theGHSW gHSW)
		(= gHSW wfWin)
		(if (not local389)
			(= temp0 0)
			(Format @temp0 {%d.fea} (global2 curPic?))
			(if
			(not (proc921_2 @temp0 30 {Enter path and filename}))
				(return)
			else
				(Format @global42 @temp0)
				(= local388
					(Print
						addText: {Outline Features?}
						title: {Feature Write V1.0}
						addButton: 1 {YES} 0 12
						addButton: 0 {NO} 50 12
						init:
					)
				)
				(= local387
					(Print
						addText: {Display code to screen? (but not doVerb)}
						title: {Feature Write V1.0}
						addButton: 0 {NO} 0 12
						addButton: 1 {YES} 50 12
						init:
					)
				)
				(= local389 1)
			)
		)
		(if
			(not
				(= local390
					(Print
						addText: {Class?}
						title: {Feature Writer V1.0}
						addButton: Feature {Feature} 0 12
						addButton: View {View} 141 12
						addButton: Prop {Prop} 180 12
						addButton: Actor {Actor} 220 12
						init:
					)
				)
			)
			(return)
		)
		(= temp15 (local390 new:))
		(= local0 0)
		(proc921_2 @local0 30 {Name?})
		(= local50 0)
		(proc921_2 @local50 16 {Noun?})
		(localproc_0282 temp15)
		(if (== local390 Feature)
			(localproc_0297 temp15)
		else
			(localproc_03c2 temp15)
		)
		(localproc_0468 temp15)
		(if
			(Print
				addText: {Z property}
				title: {Feature Writer V1.0}
				addButton: 0 {NO} 0 12
				addButton: 1 {YES} 50 12
				init:
			)
			(Print
				addText: {Click mouse on object's projection}
				addText: {onto the ground} 0 12
				init:
			)
			(while (!= ((= newEvent (Event new:)) type?) 1)
				(newEvent dispose:)
			)
			(GlobalToLocal newEvent)
			(temp15 z: (- (newEvent y?) (temp15 y?)))
			(temp15 y: (newEvent y?))
			(newEvent dispose:)
		)
		(localproc_06df)
		(Class_948_1 doit: temp15)
		(= gHSW theGHSW)
	)
)

(class Class_948_1
	(properties)
	
	(method (doit param1 &tmp [temp0 400] [temp400 40] [temp440 50] temp490 temp491 [temp492 60])
		(if (FileIO fiEXISTS @global42)
			(Format @temp492 {The file '%s' already exists} @global42)
			(if
				(not
					(= temp491
						(Print
							addText: @temp492
							addButton: 1 {Replace} 0 12
							addButton: 2 {Append} 73 12
							addButton: 0 {Cancel} 133 12
							init:
						)
					)
				)
				(return 0)
			)
		)
		(= temp490 (if (== temp491 1) 2 else 0))
		(if
			(not
				((= newClass_993_0 (Class_993_0 new:))
					name: @global42
					open: temp490
				)
			)
			(Format @temp0 {Error opening '%s'} @global42)
			(proc921_0 @temp0)
			(newClass_993_0 dispose:)
			(return 0)
		)
		(= temp0 0)
		(if (param1 isMemberOf: Feature)
			(Format
				@temp400
				{ \t\tnsLeft\t\t\t%d\0D\n\t\tnsTop\t\t\t\t%d\0D\n\t\tnsBottom\t\t\t%d\0D\n\t\tnsRight\t\t\t%d\0D\n}
				(param1 nsLeft?)
				(param1 nsTop?)
				(param1 nsBottom?)
				(param1 nsRight?)
			)
		else
			(Format
				@temp400
				{ \t\tview\t\t\t%d\0D\n\t\tloop\t\t\t%d\0D\n\t\tcel\t\t\t%d\0D\n}
				(param1 view?)
				(param1 loop?)
				(param1 cel?)
			)
		)
		(Format
			@temp440
			{ \t\tapproachX\t\t%d\0D\n\t\tapproachY\t\t%d\0D\n\t\tapproachDist\t%d\0D\n\t\t\_approachVerbs\t$%x\0D\n}
			(param1 approachX?)
			(param1 approachY?)
			(param1 approachDist?)
			(param1 _approachVerbs?)
		)
		(Format
			@temp0
			{ \0D\n(instance %s of %s\0D\n\t(properties\0D\n\t\tx\t\t\t\t\t%d\0D\n\t\ty\t\t\t\t\t%d\0D\n\t\tz\t\t\t\t\t%d\0D\n\t\theading\t\t\t%d\0D\n%s \t\tsightAngle\t\t%d\0D\n%s \t\tnoun\t\t\t\t%s\0D\n\t)\0D\n}
			@local0
			((param1 -super-?) name?)
			(param1 x?)
			(param1 y?)
			(param1 z?)
			(param1 heading?)
			@temp400
			(param1 sightAngle?)
			@temp440
			@local50
		)
		(if local387
			(Print
				font: 999
				addText: @temp0
				title: {Feature Writer V1.0}
				init:
			)
		)
		(localproc_070d @temp0)
		(if local391
			(Format
				@temp0
				{ \t(method (doVerb theVerb)\0D\n\t\t(switch theVerb\0D\n}
			)
			(localproc_070d @temp0)
			(if [local180 0]
				(Format @temp0 { \t\t\t(LOOK\0D\n\t\t\t)\0D\n} @local180)
				(localproc_070d @temp0)
			)
			(if [local80 0]
				(Format @temp0 { \t\t\t(DO\0D\n\t\t\t)\0D\n} @local80)
				(localproc_070d @temp0)
			)
			(if [local280 0]
				(Format @temp0 { \t\t\t(TALK\0D\n\t\t\t)\0D\n} @local280)
				(localproc_070d @temp0)
			)
			(Format
				@temp0
				{ \t\t\t(else\0D\n\t\t\t\t(super doVerb: theVerb)\0D\n\t\t\t)\0D\n\t\t)\0D\n\t)\0D\n}
			)
			(localproc_070d @temp0)
		)
		(StrCpy @temp0 {)\0D\n})
		(localproc_070d @temp0)
		(if (param1 isMemberOf: Feature)
			(param1 dispose:)
		else
			(param1 addToPic:)
		)
		(newClass_993_0 close: dispose:)
		(return (DisposeScript 993))
	)
	
	(method (writeList param1)
		(param1 eachElementDo: #perform self)
		(Class_948_0 doit:)
		(DisposeScript 948)
	)
)

(instance selectorI of DSelector
	(properties
		x 18
	)
	
	(method (handleEvent pEvent &tmp pEventType pEventMessage)
		(super handleEvent: pEvent)
		(= pEventType (pEvent type?))
		(= pEventMessage (pEvent message?))
		(if
			(or
				(and (== pEventType evMOUSEBUTTON) (pEvent claimed?))
				(and
					(== pEventType evKEYBOARD)
					(== pEventMessage KEY_SPACE)
				)
			)
			(if (== (StrAt cursor 0) 62)
				(StrAt cursor 0 32)
			else
				(StrAt cursor 0 62)
			)
			(self draw:)
			(pEvent claimed: 1)
		)
		(pEvent claimed?)
	)
)

(instance clearBut of DButton
	(properties
		state $0001
		text {Clear}
	)
	
	(method (doit &tmp temp0)
		(= temp0 0)
		(while (< temp0 6)
			(StrAt local380 (* temp0 18) 32)
			(++ temp0)
		)
		(selectorI draw:)
	)
)

(instance allBut of DButton
	(properties
		state $0001
		value 2
		text {__All__}
	)
	
	(method (doit &tmp temp0)
		(= temp0 0)
		(while (< temp0 6)
			(StrAt local380 (* temp0 18) 62)
			(++ temp0)
		)
		(selectorI draw:)
	)
)

(instance doneBut of DButton
	(properties
		value 1
		text { Done_}
	)
)

(instance wfWin of Window
	(properties)
)
