;;; Written by scc. Kernel sub-command names used by the decompiled
;;; sources in this directory. Matches SCI Companion's sci.sh, and is
;;; cross-checked against ScummVM's own tables.

;;; Display sub-commands, and the values dsALIGN takes
(define alRIGHT -1)
(define alLEFT 0)
(define alCENTER 1)
(define dsCOORD 100)
(define dsALIGN 101)
(define dsCOLOR 102)
(define dsBACKGROUND 103)
(define dsDISABLED 104)
(define dsFONT 105)
(define dsWIDTH 106)
(define dsSAVEPIXELS 107)
(define dsRESTOREPIXELS 108)

;;; Graph sub-commands
(define grGET_COLOURS 2)
(define grDRAW_LINE 4)
(define grSAVE_BOX 7)
(define grRESTORE_BOX 8)
(define grFILL_BOX_BACKGROUND 9)
(define grFILL_BOX_FOREGROUND 10)
(define grFILL_BOX 11)
(define grUPDATE_BOX 12)
(define grREDRAW_BOX 13)
(define grADJUST_PRIORITY 14)

;;; Message sub-commands
(define msgGET 0)
(define msgNEXT 1)
(define msgSIZE 2)
(define msgREF_NOUN 3)
(define msgREF_VERB 4)
(define msgREF_COND 5)
(define msgPUSH 6)
(define msgPOP 7)
(define msgLAST_MESSAGE 8)
