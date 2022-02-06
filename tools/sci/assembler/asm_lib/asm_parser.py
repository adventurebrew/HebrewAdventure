import ply.yacc as yacc
import asm_lexer

from opcodes import SciOpcodes

# Get the token map from the lexer.  This is required.
from asm_lexer import tokens


def p_all_adding(p):
    """all : section all"""
    p[0] = [p[1]] + p[2]


def p_all_single(p):
    """all : section"""
    p[0] = [p[1]]


def p_section(p):
    """section : config
               | exports_section
               | code_section
               | object_section
               | class_section
               | preload_text_section
               | local_vars_section
               | relocation_section
               | strings_section
               """
    p[0] = p[1]


####################

def p_boolean(p):
    """boolean : TRUE
               | FALSE"""
    p[0] = p[1] == 'True'


def p_object_name(p):
    """object_name : OBJECT ID OF HEX
                   | OBJECT OPCODE OF HEX"""
    p[0] = (p[1], (p[2], p[4]))


def p_class_name(p):
    """class_name : CLASS ID OF HEX
                  | CLASS OPCODE OF HEX
                  | CLASS HEX OF HEX"""
    p[0] = (p[1], (p[2], p[4]))


def p_string(p):
    """string : DOUBLE_STRING
              | SINGLE_STRING """
    p[0] = p[1][1:-1]


def p_val_id(p):
    """val_id : LCURLY string COLON string COMMA string COLON string RCURLY """
    # TODO accept arbitrary strings (currently expects ID...)
    p[0] = ('VAL_ID', p[4], p[8])


#############

def p_config(p):
    """config : DOT CONFIG rules"""
    p[0] = (p[2], p[3])


def p_rules_adding(p):
    """rules : rule rules"""
    p[0] = [p[1]] + p[2]


def p_rules_single(p):
    """rules : rule"""
    p[0] = [p[1]]


def p_rule(p):
    """rule : ID EQUALS boolean"""
    p[0] = (p[1], p[3])


#############


def p_exports_section(p):
    """exports_section : DOT EXPORTS export_entries"""
    p[0] = (p[2], p[3])


def p_export_entries_adding(p):
    """export_entries : export_entry export_entries"""
    p[0] = [p[1]] + p[2]


def p_export_entries_single(p):
    """export_entries : export_entry"""
    p[0] = [p[1]]


def p_export_entry(p):
    """export_entry : object_name
                    | class_name
                    | ID
                    | NUMBER"""
    p[0] = p[1]


#############


def p_code_section(p):
    """code_section : DOT CODE code_entries"""
    p[0] = (p[2], p[3])


def p_code_entries_adding(p):
    """code_entries : code_entry_possible_label code_entries"""
    p[0] = [p[1]] + p[2]


def p_code_entries_single(p):
    """code_entries : code_entry_possible_label"""
    p[0] = [p[1]]


def p_code_entry_possible_label_1(p):
    """code_entry_possible_label : code_label code_entry"""
    p[0] = (p[1], p[2])


def p_code_entry_possible_label_2(p):
    """code_entry_possible_label :  code_entry"""
    p[0] = p[1]


def p_code_entry_opcode(p):
    """code_entry : OPCODE HEX COMMA HEX COMMA HEX COMMA HEX
                  | OPCODE HEX COMMA HEX COMMA HEX
                  | OPCODE HEX COMMA HEX
                  | OPCODE HEX
                  | OPCODE
                  """
    opcode = SciOpcodes(p[1])
    operands = [e for e in p[2:] if e != ',']
    if len(operands) != opcode.num_of_operands():
        print(
            f"Error: line {p.lexer.lineno} {p[1]} expects {opcode.num_of_operands()} operands, but got {len(operands)}")
        raise SyntaxError
    p[0] = [opcode] + operands


def p_code_entry_opcode_label(p):
    """code_entry : OPCODE_LABEL ID
                  | OPCODE_LABEL ID COMMA NUMBER
                  | OPCODE_LABEL OPCODE
                  | OPCODE_LABEL HEX
                  | OPCODE_LABEL NUMBER
                  """
    # TODO replace this with exact num of operands matching and error report (like p_code_entry_opcode)
    try:
        p[0] = (SciOpcodes(p[1]), p[2], p[4])
    except IndexError:
        p[0] = (SciOpcodes(p[1]), p[2])


def p_code_entry_opcode_label_error(p):
    """code_entry : OPCODE_LABEL error"""
    print(f"\tline {p[2].lineno}: Syntax error in '{p[1]}', param isn't an identifier")
    p[0] = (p[1], p[2])


def p_code_entry_opcode_callk(p):
    """code_entry : OPCODE_CALLK ID COMMA HEX
                  """
    p[0] = (SciOpcodes(p[1]), p[2], p[4])


def p_code_entry_opcode_callk_error(p):
    """code_entry : OPCODE_CALLK error"""
    print(f"\tline {p[2].lineno}: Syntax error in '{p[1]}'")
    p[0] = (p[1], p[2])


def p_code_label(p):
    """code_label : ID COLON COLON NUMBER COLON
                  | NUMBER COLON COLON NUMBER COLON
                  | ID COLON
                  | OPCODE COLON COLON NUMBER COLON"""
    p[0] = ('LABEL', ''.join([str(s) for s in p[1:]]))


#############


def p_object_section(p):
    """object_section : DOT object_name object_entries"""
    p[0] = ('OBJECT', [p[2]] + p[3])


def p_object_entries_adding(p):
    """object_entries : object_entry object_entries"""
    p[0] = [p[1]] + p[2]


def p_object_entries_single(p):
    """object_entries : object_entry"""
    p[0] = [p[1]]


def p_object_entry(p):
    """object_entry : object_exported
                    | object_function_offset
                    | object_selectors
                    | object_functions
                    """
    p[0] = p[1]


def p_object_exported(p):
    """object_exported : EXPORTED"""
    p[0] = (p[1], True)


def p_object_function_offset(p):
    """object_function_offset : FUNCTION AREA OFFSET COLON HEX"""
    p[0] = ('function_offset', p[5])


##


def p_object_selectors(p):
    """object_selectors : SELECTORS LBRACKET NUMBER RBRACKET COLON object_selector_items """
    assert len(p[6]) == p[3]  # TODO nicer error message? (or even only warning?) - in all asserts
    p[0] = (p[1], p[6])


def p_object_selector_items_adding(p):
    """object_selector_items : object_selector_item object_selector_items"""
    p[0] = [p[1]] + p[2]


def p_object_selector_items_single(p):
    """object_selector_items : object_selector_item"""
    p[0] = [p[1]]


def p_object_selector_item(p):
    """object_selector_item : LBRACKET POUND NUMBER RBRACKET EQUALS HEX
                            | LBRACKET POUND NUMBER RBRACKET EQUALS val_id"""
    p[0] = ('SELECTOR', p[3], p[6])


##


def p_object_functions(p):
    """object_functions : OVERRIDEN FUNCTIONS COLON NUMBER object_function_items
                        | OVERRIDEN FUNCTIONS COLON NUMBER """
    num_of_items = p[4]

    if len(p) == 5:
        assert num_of_items == 0
        p[0] = (p[2], [])
    else:
        assert len(p[5]) == num_of_items
        p[0] = (p[2], p[5])


def p_object_function_items_adding(p):
    """object_function_items : object_function_item object_function_items"""
    p[0] = [p[1]] + p[2]


def p_object_function_items_single(p):
    """object_function_items : object_function_item"""
    p[0] = [p[1]]


def p_object_function_item(p):
    """object_function_item : LBRACKET HEX RBRACKET EQUALS ID
                            | LBRACKET HEX RBRACKET EQUALS ID COLON COLON NUMBER
                            | LBRACKET HEX RBRACKET EQUALS NUMBER COLON COLON NUMBER
                            | LBRACKET HEX RBRACKET EQUALS OPCODE COLON COLON NUMBER
                            """
    p[0] = ('FUNCTION', p[2], ''.join([str(s) for s in p[5:]]))


#############


def p_class_section(p):
    """class_section : DOT class_name class_entries"""
    p[0] = ('CLASS', [p[2]] + p[3])


def p_class_entries_adding(p):
    """class_entries : class_entry class_entries"""
    p[0] = [p[1]] + p[2]


def p_class_entries_single(p):
    """class_entries : class_entry"""
    p[0] = [p[1]]


def p_class_entry(p):
    """class_entry : class_exported
                    | class_function_offset
                    | class_selectors
                    | class_functions
                    """
    p[0] = p[1]


def p_class_exported(p):
    """class_exported : EXPORTED"""
    p[0] = (p[1], True)


def p_class_function_offset(p):
    """class_function_offset : FUNCTION AREA OFFSET COLON HEX"""
    p[0] = ('function_offset', p[5])


##


def p_class_selectors(p):
    """class_selectors : SELECTORS LBRACKET NUMBER RBRACKET COLON class_selector_items """
    assert len(p[6]) == p[3]
    p[0] = (p[1], p[6])


def p_class_selector_items_adding(p):
    """class_selector_items : class_selector_item class_selector_items"""
    p[0] = [p[1]] + p[2]


def p_class_selector_items_single(p):
    """class_selector_items : class_selector_item"""
    p[0] = [p[1]]


def p_class_selector_item(p):
    """class_selector_item : LBRACKET HEX RBRACKET EQUALS HEX
                            | LBRACKET HEX RBRACKET EQUALS val_id"""
    p[0] = ('SELECTOR', p[2], p[5])


##


def p_class_functions(p):
    """class_functions : OVERRIDEN FUNCTIONS COLON NUMBER class_function_items
                       | OVERRIDEN FUNCTIONS COLON NUMBER  """
    num_of_items = p[4]

    if len(p) == 5:
        assert num_of_items == 0
        p[0] = (p[2], [])
    else:
        assert len(p[5]) == num_of_items
        p[0] = (p[2], p[5])


def p_class_function_items_adding(p):
    """class_function_items : class_function_item class_function_items"""
    p[0] = [p[1]] + p[2]


def p_class_function_items_single(p):
    """class_function_items : class_function_item"""
    p[0] = [p[1]]


def p_class_function_item(p):
    """class_function_item : LBRACKET HEX RBRACKET EQUALS ID
                           | LBRACKET HEX RBRACKET EQUALS ID COLON COLON NUMBER
                           | LBRACKET HEX RBRACKET EQUALS NUMBER COLON COLON NUMBER
                           | LBRACKET HEX RBRACKET EQUALS OPCODE COLON COLON NUMBER
                            """
    p[0] = ('FUNCTION', p[2], ''.join([str(s) for s in p[5:]]))


#############


def p_strings_section(p):
    """strings_section : DOT STRINGS string_entries"""
    p[0] = (p[2], p[3])


def p_string_entries_adding(p):
    """string_entries : string_entry string_entries"""
    p[0] = [p[1]] + p[2]


def p_string_entries_single(p):
    """string_entries : string_entry"""
    p[0] = [p[1]]


def p_string_regular_entry(p):
    """string_entry : ID COLON string"""
    p[0] = (p[1], p[3])


#############

def p_preload_text_section(p):
    """preload_text_section : DOT PRELOAD_TEXT"""
    p[0] = (p[2], ())


def p_relocation_section(p):
    """relocation_section : DOT RELOCATION NUM OF POINTERS COLON NUMBER """
    p[0] = (p[2], p[7])


def p_local_vars_section(p):
    """local_vars_section : DOT LOCAL_VARS vars_list """
    p[0] = (p[2], p[3])


def p_vars_list_adding(p):
    """vars_list : HEX COMMA vars_list
                 | val_id COMMA vars_list"""
    p[0] = [p[1]] + p[3]


def p_vars_list_single(p):
    """vars_list : HEX
                 | val_id"""
    p[0] = [p[1]]


#############


#

# Error rule for syntax errors      #TODO better errors
def p_error(p):
    try:
        print(f"Line {p.lineno} ", end='')
    except (TypeError, AttributeError):
        pass
    print("Syntax error in input!\t", end='')
    try:
        print(f"'{p.value}'\t", end='')
    except AttributeError:
        pass
    print(p)


# Build the parser
parser = yacc.yacc()

if __name__ == '__main__':

    data = """
.EXPORTS
OBJECT sq1 of 0x41
code_6420
code_6576
code_6725
code_6874
code_6884
code_6904
code_6922
code_6961
code_7001
code_7047
code_7250
code_7287
code_7584
code_7700
code_7830
code_8675
code_8792
OBJECT SpiderList of 0x3

.CODE
ego::266:
		lsp	0x1
		dup	
		ldi    0x3
		lofsa	Gadget
		push	
		lofsa	Survival_Kit
		push	
		lofsa	Knife
		
.STRINGS
string_1: "zvika"		
		
.RELOCATION
num of pointers: 187
;0x50, 0x5c, 0x68, 0x74, 0x80, 0x8c, 0x98, 0xa4, 0xb0, 0xbc, 0xc8, 0xcc, 0xd8, 0xdc, 0xed, 0xfd, 0x107, 0x110, 0x118, 0x120, 0x128, 0x130, 0x138, 0x140, 0x148, 0x150, 0x158, 0x160, 0x168, 0x170, 0x1e7, 0x1ef, 0x1f7, 0x254, 0x260, 0x269, 0x26d, 0x271, 0x275, 0x279, 0x27d, 0x29b, 0x2cf, 0x328, 0x398, 0x3da, 0x42a, 0x499, 0x4c2, 0x506, 0x525, 0x53a, 0x583, 0x58f, 0x5ab, 0x5c6, 0x5f4, 0x65b, 0x671, 0x687, 0x69d, 0x6b3, 0x6c9, 0x6df, 0x6f5, 0x70b, 0x721, 0x737, 0x74d, 0x763, 0x779, 0x78f, 0x7a5, 0x7bb, 0x7d1, 0x7e7, 0x7fd, 0x98a, 0x9d4, 0xa0f, 0xa28, 0xa37, 0xa76, 0xaba, 0xac5, 0xb03, 0xb0e, 0xb28, 0xb45, 0xb60, 0xbaa, 0xc1c, 0xc66, 0xc8f, 0xcb0, 0xce6, 0xd0a, 0xd60, 0xd84, 0xe1e, 0xe32, 0xe42, 0xe81, 0xe91, 0xebc, 0xee6, 0xefa, 0xf0a, 0xf54, 0xfb0, 0xfc6, 0x101c, 0x1030, 0x105c, 0x1070, 0x1080, 0x1098, 0x10c2, 0x10d6, 0x10e6, 0x1102, 0x1116, 0x1126, 0x113e, 0x1152, 0x1162, 0x117a, 0x11a4, 0x11b8, 0x11c8, 0x11e4, 0x12fc, 0x13c0, 0x13d4, 0x13e4, 0x1480, 0x14b9, 0x14c6, 0x1502, 0x1516, 0x1526, 0x15e2, 0x15f6, 0x1606, 0x1654, 0x1668, 0x1678, 0x16c6, 0x16da, 0x16ea, 0x1718, 0x1738, 0x174c, 0x175c, 0x178a, 0x17aa, 0x17be, 0x17ce, 0x17fc, 0x181c, 0x1830, 0x1840, 0x186e, 0x188e, 0x18a2, 0x18b2, 0x18e0, 0x1900, 0x1914, 0x1924, 0x1952, 0x1972, 0x1986, 0x1996, 0x19c4, 0x19e4, 0x19f8, 0x1a08, 0x1a36, 0x1a56, 0x1a6a, 0x1a7a, 0x1aa8, 0x1ac8, 0x1adc, 0x1aec, 0x1b1a
		
		"""

    asm_lexer.start()
    result = parser.parse(data, debug=False)
    for a in result:
        print(a)
