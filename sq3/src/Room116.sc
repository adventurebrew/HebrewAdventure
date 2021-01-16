;;; Sierra Script 1.0 - (do not remove this comment)
(script# 116)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Avoid)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	Room116 0
)

(local
	[local0 2]
	local2
)
(instance ship of Act
	(properties)
)

(instance shadow of Act
	(properties)
)

(instance cockPit of Prop
	(properties)
)

(instance Roger of Act
	(properties)
)

(instance Mark of Act
	(properties)
)

(instance Scott of Act
	(properties)
)

(instance ramp of Prop
	(properties)
)

(instance Ken of Act
	(properties)
)

(instance bigRoger of Act
	(properties)
)

(instance sMouth of Prop
	(properties)
)

(instance mMouth of Prop
	(properties)
)

(instance kMouth of Prop
	(properties)
)

(instance rMouth of Prop
	(properties)
)

(instance Room116 of Rm
	(properties
		picture 116
	)
	
	(method (init)
		(= local2 (DoSound 11))
		(Load 132 99)
		(Load 132 83)
		(Load 132 38)
		(Load 132 40)
		(if (== local2 1) (Load 132 16))
		(= horizon -4000)
		(gGame setSpeed: 5)
		(proc0_2)
		(= global159 1)
		(super init:)
		(self setScript: Actions)
	)
	
	(method (newRoom param1)
		(super newRoom: param1)
	)
)

(instance Actions of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0
				(ship
					view: 215
					setLoop: 0
					posn: 0 -10
					setCel: 0
					setPri: 13
					ignoreActors:
					setMotion: MoveTo 0 39 self
					init:
				)
			)
			(1
				(gLongSong number: 83 loop: 1 play:)
				(ship setCel: 1 setMotion: MoveTo 0 92 self)
			)
			(2
				(ship setCel: 2 setMotion: MoveTo 0 132 self)
			)
			(3
				(shadow
					view: 215
					setLoop: 1
					setCel: 0
					posn: 5 191
					ignoreActors:
					setPri: 0
					setStep: 2 1
					setMotion: MoveTo 5 165
					init:
				)
				(ship setStep: 2 1 setMotion: MoveTo 0 158 self)
			)
			(4
				(gLongSong fade:)
				(shadow setMotion: 0)
				(= seconds 5)
			)
			(5
				(ship stopUpd:)
				(shadow stopUpd:)
				(ramp
					view: 215
					setLoop: 3
					posn: 67 169
					cel: 255
					ignoreActors:
					setPri: 11
					setCycle: End self
					init:
				)
			)
			(6
				(gLongSong number: 99 loop: -1 play:)
				(Mark
					view: 215
					setLoop: 4
					setCycle: Walk
					setStep: 1 1
					setPri: 12
					posn: 54 157
					setMotion: MoveTo 87 176 self
					init:
				)
			)
			(7
				(Mark setMotion: MoveTo 117 172)
				(Scott
					view: 215
					setLoop: 5
					setCycle: Walk
					setStep: 1 1
					setPri: 12
					posn: 54 157
					setMotion: MoveTo 79 174 self
					init:
				)
			)
			(8
				(cockPit
					view: 215
					setLoop: 2
					cel: 255
					cycleSpeed: 3
					setPri: 13
					posn: 70 157
					setCycle: End
					init:
				)
				(Scott setMotion: MoveTo 109 166)
				(Ken
					view: 215
					setLoop: 6
					posn: 180 132
					setPri: 0
					setStep: 1 1
					setCycle: Walk
					setMotion: MoveTo 130 162 self
					init:
				)
			)
			(9 (= seconds 2))
			(10
				(global2 drawPic: 117 8)
				(gCast eachElementDo: 140)
				(proc0_10)
				(mMouth view: 136 loop: 0 posn: 42 74 setPri: 5 init:)
				(sMouth view: 136 loop: 1 posn: 158 109 setPri: 5 init:)
				(kMouth view: 136 loop: 2 posn: 237 157 setPri: 5 init:)
				(bigRoger
					view: 136
					setLoop: 3
					posn: -23 87
					setPri: 3
					ignoreActors:
					setMotion: MoveTo 19 87
					init:
				)
				(= seconds 3)
			)
			(11
				(if (== local2 1)
					(gLongSong stop:)
					(gLongSong number: 16 loop: -1 play:)
				)
				(mMouth setCycle: Fwd)
				(proc255_0 116 0 80 {Mark} 91 67 -1 156 70 310)
				(= seconds 8)
			)
			(12
				(proc0_12)
				(proc0_10)
				(mMouth setCel: 0)
				(rMouth
					view: 136
					setLoop: 4
					posn: (bigRoger x?) (bigRoger y?)
					setPri: 4
					ignoreActors:
					setCycle: Fwd
					init:
				)
				(proc255_0 116 1 80 {Roger} 91 67 -1 156 70 310)
				(= seconds 8)
			)
			(13
				(proc0_12)
				(proc0_10)
				(rMouth setCel: 0)
				(kMouth setCycle: Fwd)
				(proc255_0 116 2 80 {Ken Williams} 91 67 -1 156 70 310)
				(= seconds 10)
			)
			(14
				(proc0_12)
				(proc0_10)
				(kMouth setCel: 0)
				(sMouth setCycle: Fwd)
				(proc255_0 116 3 80 {Scott} 91 67 -1 170)
				(= seconds 5)
			)
			(15
				(proc0_12)
				(proc0_10)
				(sMouth setCel: 0)
				(kMouth cel: 255 setCycle: End self)
				(proc255_0 116 4 80 {Ken Williams} 91 67 -1 170 30 1)
			)
			(16
				(proc0_12)
				(proc0_10)
				(mMouth setCel: 0)
				(sMouth cel: 255 setCycle: End self)
				(proc255_0 116 5 80 {Scott} 91 67 -1 170 30 1)
			)
			(17
				(proc0_12)
				(proc0_10)
				(sMouth setCel: 0)
				(kMouth setCycle: Fwd)
				(proc255_0 116 6 80 {Ken Williams} 91 67 -1 170)
				(= seconds 8)
			)
			(18
				(proc0_12)
				(proc0_10)
				(kMouth setCel: 0)
				(mMouth setCycle: Fwd)
				(sMouth setCycle: Fwd)
				(proc255_0
					116
					7
					80
					{Scott and Mark}
					91
					67
					-1
					156
					70
					310
					30
					1
				)
				(= seconds 5)
			)
			(19
				(proc0_12)
				(proc0_10)
				(sMouth setCel: 0)
				(mMouth setCel: 0)
				(kMouth cel: 255 setCycle: End self)
				(proc255_0 116 8 80 {Ken Williams} 91 67 -1 170)
			)
			(20
				(proc0_12)
				(proc0_10)
				(kMouth setCel: 0)
				(rMouth setCycle: Fwd)
				(proc255_0 116 9 80 {Roger} 91 67 -1 170)
				(= seconds 7)
			)
			(21
				(proc0_12)
				(proc0_10)
				(rMouth setCel: 0)
				(kMouth cel: 255 setCycle: End self)
				(proc255_0 116 4 80 {Ken Williams} 91 67 -1 170 30 1)
			)
			(22
				(proc0_12)
				(proc0_10)
				(mMouth dispose:)
				(rMouth dispose:)
				(sMouth dispose:)
				(kMouth dispose:)
				(= cycles 2)
			)
			(23
				(gLongSong fade:)
				(gCast eachElementDo: 206)
				(bigRoger dispose:)
				(global2 drawPic: 116 8)
				(gEgo
					view: 68
					setStep: 1 1
					posn: 110 176
					setPri: 12
					setLoop: -1
					loop: 0
					setCel: -1
					setCycle: Walk
					setAvoider: Avoid
					init:
				)
				(proc0_10)
				(Ken setScript: KenMoveIntoBuilding)
				(= seconds 1)
			)
			(24
				(Mark setScript: MarkMoveIntoBuilding)
				(= seconds 1)
			)
			(25
				(Scott setScript: ScottMoveIntoBuilding)
				(proc255_0 116 10 67 -1 10 70 310 91)
				(gEgo setMotion: MoveTo 87 176 self)
			)
			(26
				(gEgo setMotion: MoveTo 54 157 self)
			)
			(27 (= seconds 7))
			(28
				(cockPit setCycle: Beg self)
			)
			(29
				(proc0_12)
				(gEgo dispose:)
				(ramp setCycle: Beg)
				(= seconds 2)
			)
			(30
				(ramp dispose:)
				(cockPit dispose:)
				(ship setMotion: MoveTo 0 132 self)
				(proc255_0 116 11 67 -1 10 70 310 25 12)
				(gLongSong number: 40 loop: 1 play:)
				(shadow setMotion: MoveTo 5 199)
			)
			(31
				(shadow dispose:)
				(ship setStep: 1 5 setMotion: MoveTo 0 92 self)
			)
			(32
				(ship setCel: 1 setMotion: MoveTo 0 39 self)
			)
			(33
				(ship setCel: 0 setMotion: MoveTo 0 -20 self)
			)
			(34
				(gLongSong number: 38 loop: 1 play:)
				(ship
					setLoop: 8
					setCel: 0
					posn: 279 -14
					setStep: 4 6
					setMotion: MoveTo 243 15 self
				)
			)
			(35
				(proc0_12)
				(ship setCycle: End setMotion: MoveTo 215 43 self)
			)
			(36
				(ship setMotion: MoveTo 215 -5 self)
			)
			(37 (= seconds 2))
			(38 (global2 newRoom: 117))
		)
	)
)

(instance KenMoveIntoBuilding of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0
				(Ken setLoop: 7 setMotion: MoveTo 180 132 self)
			)
			(1
				(Ken setMotion: MoveTo 182 115)
			)
		)
	)
)

(instance MarkMoveIntoBuilding of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0
				(Mark setMotion: MoveTo 180 132 self)
			)
			(1
				(Mark setMotion: MoveTo 182 115)
			)
		)
	)
)

(instance ScottMoveIntoBuilding of Script
	(properties)
	
	(method (changeState theState)
		(switch (= state theState)
			(0
				(Scott setMotion: MoveTo 180 132 self)
			)
			(1
				(Scott setMotion: MoveTo 182 115)
			)
		)
	)
)
