from enum import Enum, unique

from misc import CONFIG_LOFSA_RELATIVE


@unique
class SciOpcodes(Enum):
    op_bnot = 0x00  # 000
    op_add = 0x01  # 001
    op_sub = 0x02  # 002
    op_mul = 0x03  # 003
    op_div = 0x04  # 004
    op_mod = 0x05  # 005
    op_shr = 0x06  # 006
    op_shl = 0x07  # 007
    op_xor = 0x08  # 008
    op_and = 0x09  # 009
    op_or = 0x0a  # 010
    op_neg = 0x0b  # 011
    op_not = 0x0c  # 012
    op_eq_ = 0x0d  # 013
    op_ne_ = 0x0e  # 014
    op_gt_ = 0x0f  # 015
    op_ge_ = 0x10  # 016
    op_lt_ = 0x11  # 017
    op_le_ = 0x12  # 018
    op_ugt_ = 0x13  # 019
    op_uge_ = 0x14  # 020
    op_ult_ = 0x15  # 021
    op_ule_ = 0x16  # 022
    op_bt = 0x17  # 023
    op_bnt = 0x18  # 024
    op_jmp = 0x19  # 025
    op_ldi = 0x1a  # 026
    op_push = 0x1b  # 027
    op_pushi = 0x1c  # 028
    op_toss = 0x1d  # 029
    op_dup = 0x1e  # 030
    op_link = 0x1f  # 031
    op_call = 0x20  # 032
    op_callk = 0x21  # 033
    op_callb = 0x22  # 034
    op_calle = 0x23  # 035
    op_ret = 0x24  # 036
    op_send = 0x25  # 037
    op_info = 0x26  # 038
    op_superP = 0x27  # 039
    op_class = 0x28  # 040
    # dummy      0x29	# 041
    op_self = 0x2a  # 042
    op_super = 0x2b  # 043
    op_rest = 0x2c  # 044
    op_lea = 0x2d  # 045
    op_selfID = 0x2e  # 046
    # dummy      0x2f	# 047
    op_pprev = 0x30  # 048
    op_pToa = 0x31  # 049
    op_aTop = 0x32  # 050
    op_pTos = 0x33  # 051
    op_sTop = 0x34  # 052
    op_ipToa = 0x35  # 053
    op_dpToa = 0x36  # 054
    op_ipTos = 0x37  # 055
    op_dpTos = 0x38  # 056
    op_lofsa = 0x39  # 057
    op_lofss = 0x3a  # 058
    op_push0 = 0x3b  # 059
    op_push1 = 0x3c  # 060
    op_push2 = 0x3d  # 061
    op_pushSelf = 0x3e  # 062
    op_line = 0x3f  # 063
    #
    op_lag = 0x40  # 064
    op_lal = 0x41  # 065
    op_lat = 0x42  # 066
    op_lap = 0x43  # 067
    op_lsg = 0x44  # 068
    op_lsl = 0x45  # 069
    op_lst = 0x46  # 070
    op_lsp = 0x47  # 071
    op_lagi = 0x48  # 072
    op_lali = 0x49  # 073
    op_lati = 0x4a  # 074
    op_lapi = 0x4b  # 075
    op_lsgi = 0x4c  # 076
    op_lsli = 0x4d  # 077
    op_lsti = 0x4e  # 078
    op_lspi = 0x4f  # 079
    #
    op_sag = 0x50  # 080
    op_sal = 0x51  # 081
    op_sat = 0x52  # 082
    op_sap = 0x53  # 083
    op_ssg = 0x54  # 084
    op_ssl = 0x55  # 085
    op_sst = 0x56  # 086
    op_ssp = 0x57  # 087
    op_sagi = 0x58  # 088
    op_sali = 0x59  # 089
    op_sati = 0x5a  # 090
    op_sapi = 0x5b  # 091
    op_ssgi = 0x5c  # 092
    op_ssli = 0x5d  # 093
    op_ssti = 0x5e  # 094
    op_sspi = 0x5f  # 095
    #
    op_plusag = 0x60  # 096
    op_plusal = 0x61  # 097
    op_plusat = 0x62  # 098
    op_plusap = 0x63  # 099
    op_plussg = 0x64  # 100
    op_plussl = 0x65  # 101
    op_plusst = 0x66  # 102
    op_plussp = 0x67  # 103
    op_plusagi = 0x68  # 104
    op_plusali = 0x69  # 105
    op_plusati = 0x6a  # 106
    op_plusapi = 0x6b  # 107
    op_plussgi = 0x6c  # 108
    op_plussli = 0x6d  # 109
    op_plussti = 0x6e  # 110
    op_plusspi = 0x6f  # 111
    #
    op_minusag = 0x70  # 112
    op_minusal = 0x71  # 113
    op_minusat = 0x72  # 114
    op_minusap = 0x73  # 115
    op_minussg = 0x74  # 116
    op_minussl = 0x75  # 117
    op_minusst = 0x76  # 118
    op_minussp = 0x77  # 119
    op_minusagi = 0x78  # 120
    op_minusali = 0x79  # 121
    op_minusati = 0x7a  # 122
    op_minusapi = 0x7b  # 123
    op_minussgi = 0x7c  # 124
    op_minussli = 0x7d  # 125
    op_minussti = 0x7e  # 126
    op_minusspi = 0x7f  # 127

    def is_relative(self):
        if self in [SciOpcodes.op_bt, SciOpcodes.op_bnt,
                    SciOpcodes.op_call, SciOpcodes.op_jmp, ]:
            return True
        elif self in [SciOpcodes.op_lofsa, SciOpcodes.op_lofss]:
            # TODO it's not constant behaviour :-(
            # according to https://wiki.scummvm.org/index.php?title=SCI/Specifications/SCI_virtual_machine/The_Sierra_PMachine
            # it should be relative
            # however, it depends on SCI generation. see ScummVM's vm.cpp findOffset(..)
            # currently supporting only abs, for SQ1VGA
            return CONFIG_LOFSA_RELATIVE
        else:
            return False

    def is_signed(self):
        return self.is_relative()

    def instruction_length_range(self):
        return {'min': instruction_length((self.value << 1) + 1),
                'max': instruction_length(self.value << 1)}

    def __repr__(self):
        result = self.name.replace('op_', '')
        if result.endswith('_'):
            result = result.rstrip('_') + '?'
        result = result.replace('minus', '-').replace('plus', '+')
        return result

    @classmethod
    def _missing_(cls, value):
        return SciOpcodes["op_" + value.replace("?", "_").replace("-", "minus").replace("+", "plus")]


def instruction_length(opcode):
    extra = 1 - opcode % 2
    if opcode <= 0x2d:
        result = 1
    elif opcode <= 0x35:
        result = 2 + extra
    elif opcode <= 0x37:
        result = 1
    elif opcode <= 0x39:
        result = 2 + extra
    elif opcode <= 0x3d:
        result = 1
    elif opcode <= 0x3f:
        result = 2 + extra
    elif opcode <= 0x45:
        result = 3 + extra
    elif opcode <= 0x47:
        if extra == 0:
            result = 4
        else:
            result = 6
    elif opcode <= 0x49:
        result = 1
    elif opcode <= 0x4b:
        result = 2
    elif opcode <= 0x51:
        result = 2 + extra
    elif opcode <= 0x55:
        result = 2
    elif opcode <= 0x57:
        result = 3 + extra
    elif opcode <= 0x59:
        result = 2 + extra
    elif opcode <= 0x5b:
        # 'lea' is weird. it's documentation isn't clear regarding the param number
        # TODO it's sort of a guess, it's used in SQ1VGA 704.scr and 57.scr
        # with this, it sort of matches - only there is one instruction following 'lea' here, that doesn't appear in SCI Viewer
        result = 3 + extra
    elif opcode <= 0x61:
        result = 1
    elif opcode <= 0x75:
        result = 2 + extra
    elif opcode <= 0x7d:
        result = 1
    else:
        result = 2 + extra
    return result


if __name__ == '__main__':
    print("This script shouldn't be directly called")
    import sys

    sys.exit(1)
