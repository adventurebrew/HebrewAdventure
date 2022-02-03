import ply.lex as lex

from opcodes import SciOpcodes
from misc import de_escape_string

reserved = {
    'of': 'OF',
    'False': 'FALSE',
    'True': 'TRUE',
    'CONFIG': 'CONFIG',
    'EXPORTS': 'EXPORTS',
    'CODE': 'CODE',
    'OBJECT': 'OBJECT',
    'CLASS': 'CLASS',
    'PRELOAD_TEXT': 'PRELOAD_TEXT',
    'LOCAL_VARS': 'LOCAL_VARS',
    'RELOCATION': 'RELOCATION',
    'STRINGS': 'STRINGS',
    'Exported': 'EXPORTED',
    'Function': 'FUNCTION',
    'area': 'AREA',
    'offset': 'OFFSET',
    'Selectors': 'SELECTORS',
    'functions': 'FUNCTIONS',
    'Overriden': 'OVERRIDEN',
    'num': 'NUM',
    'pointers': 'POINTERS',
}

# List of token names.   This is always required
tokens = [
             'SINGLE_STRING',
             'DOUBLE_STRING',
             'DOT',
             'COMMA',
             'COLON',
             'LBRACKET',
             'RBRACKET',
             'LCURLY',
             'RCURLY',
             'POUND',
             'NUMBER',
             'ID',
             'EQUALS',
             'HEX',
             'OPCODE',
             'OPCODE_LABEL',
         ] + list(reserved.values())

# Regular expression rules for simple tokens
t_DOT = r'\.'
t_COMMA = r','
t_COLON = r':'
t_EQUALS = r'='
t_LBRACKET = r'\['
t_RBRACKET = r'\]'
t_LCURLY = r'\{'
t_RCURLY = r'\}'
t_POUND = r'\#'


# A regular expression rule with some action codeL
def t_ID(t):
    r'[\+|-]?[a-zA-Z_][a-zA-Z_0-9]*[\?]?'
    t.type = reserved.get(t.value, 'ID')  # Check for reserved words
    try:
        opcode = SciOpcodes(t.value)
        if opcode in [SciOpcodes.op_lofsa, SciOpcodes.op_lofss] or opcode.is_relative():
            t.type = 'OPCODE_LABEL'
        else:
            t.type = 'OPCODE'
    except KeyError:
        pass
    return t


def t_HEX(t):
    r'0x[A-Fa-f0-9]+'
    val = t.value[2:]
    if len(val) % 2 == 1:
        val = '0' + val
    t.value = int(t.value, 16).to_bytes(length=len(val) // 2, byteorder='little')
    return t


def t_NUMBER(t):
    r'[-]?\d+'
    t.value = int(t.value)
    return t


def t_DOUBLE_STRING(t):
    r'\"([^\\\n]|(\\.))*?\"'
    t.value = de_escape_string(t.value)
    return t


def t_SINGLE_STRING(t):
    r"\'([^\\\n]|(\\.))*?\'"
    t.value = de_escape_string(t.value)
    return t


# Define a rule so we can track line numbers
def t_newline(t):
    r'\n+'
    t.lexer.lineno += len(t.value)


# A string containing ignored characters (spaces and tabs)
t_ignore = ' \t'

t_ignore_COMMENT = r';.*'


# Error handling rule
def t_error(t):
    print(f"ERROR: Illegal character '{t.value[0]}' at line {t.lineno}")
    t.lexer.skip(1)


def start():
    # Build the lexer
    return lex.lex()


if __name__ == '__main__':
    lexer = start()

    # Give the lexer some input
    data = """
    .CONFIG
    WIDE_EXPORTS = True     ;zvika
    LOFSA_RELATIVE = False
    .EXPORTS
    OBJECT rm103 of 0x43
    
    .CODE
code_6420:
		sat	0x5, 0x4
		pushi	0x6b
		push1	
		lea	0x2
		pushi 0x00
		bnot	
        calle	0x3be, 0x0000, 0x1e
		push	
		lofsa	threeBut
		send	0x6
		pushi	0x6b
		push1	
		lea	0x2
		bnot	
		push	
		lofsa	fourBut
		send	0x6
		pushi	0x6b
		push1	
		lea	0x2
		bnot	
		push	
		lofsa	fiveBut
		send	0x6
		pushi	0x6b
		push1	
		lea	0x2
		bnot	
		push	
		lofsa	sixBut
	
		add	
		push	
		pushi	0x3
		push1	
		pushi	0x3
		push0	
		lofsa	keyPad
		send	0x4
		push	
		ldi	0x14
		add	
	
	
		send	0x4
		pushi	0x6c
		push0	
		lofsa	nineBut
		send	0x4
		pushi	0x6c
		push0	

	
.OBJECT rm103 of 0x43
Exported
Function area offset: 0x30
Selectors [23]:
  [#0] = 0x43
  [#1] = 0x43
  [#2] = 0x0
  [#3] = {'val': 'rm103', 'id': 'string_232'}
  [#4] = 0x0
  [#5] = {'val': "These buttons allow ! you to enter a code into the computer.", 'id': 'string_294'}
  [#6] = 0x0
  [#7] = 0x0
  [#8] = {'val': 'These buttons allow ! you to enter a code into the computer.', 'id': 'string_294'}
  [#9] = 0x0
  [#10] = 0x67
  [#11] = 0xffff
  [#12] = 0x0
  [#13] = 0x0
  [#14] = 0x0
  [#15] = 0x0
  [#16] = 0x0
  [#17] = 0x0
  [#18] = 0x0
  [#19] = 0x0
  [#20] = 0xa0
  [#21] = 0x8ad0
  [#22] = 0x0
Overriden functions: 2
  [0x3c]  = Rev::60   	 ; @0x4
  [0xd7]  = Rev::215   	 ; @0x28


"""
    lexer.input(data)

    # Tokenize
    while True:
        tok = lexer.token()
        if not tok:
            break  # No more input
        print(tok)
