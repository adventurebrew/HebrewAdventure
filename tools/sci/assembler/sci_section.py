from enum import Enum

from misc import get_string_id


class SectionKind(Enum):
    OBJECT = 1
    CODE = 2
    SYNONYMS = 3
    SAID = 4
    STRINGS = 5
    CLASS = 6
    EXPORTS = 7
    RELOCATION = 8
    PRELOAD_TEXT = 9
    LOCAL_VARS = 10


class SciSection:
    def __init__(self, obj_type, obj_offset, obj_length=None, obj_data=None):
        self.kind = SectionKind(obj_type)
        self.obj_offset = obj_offset
        self.length = obj_length
        self.data = obj_data
        self.usages = []
        self.exported = False
        self.name = ""
        # to distinguish between two objects with same name (it's wrong, but exists, e.g. in SQ1VGA 49.scr or 255.scr)
        # it'll be added to self.name
        self.unique_extension = ""
        if self.kind in [SectionKind.OBJECT, SectionKind.CLASS]:
            self.func_selector_offset = None
        elif self.kind == SectionKind.RELOCATION:
            self.pointers = []

    def __repr__(self):
        if self.kind in [SectionKind.OBJECT, SectionKind.CLASS]:
            name = self.sanitize(self.name)
            try:
                superClass = hex(self.superClass)
            except TypeError:
                superClass = '0x' + self.superClass.hex()
            except AttributeError:
                superClass = self.superClass
            return f'{self.kind.name} {name} of {superClass}'
        return self.kind.name

    def sanitize(self, s):
        return s.replace(" ", "_").replace("-", "_").replace("&", "_")

    def get_id(self):
        return self.sanitize(str(self.name))

    def str_dump(self):
        result = '.' + self.__repr__()
        if self.exported:
            result += '\nExported'
        if self.kind in [SectionKind.OBJECT, SectionKind.CLASS]:
            result += f'\nFunction area offset: {hex(self.func_selector_offset)}'
            result += f'\nSelectors [{len(self.var_selector_vals)}]:'
            for i, selector in enumerate(self.var_selector_vals):
                if self.kind == SectionKind.CLASS:
                    id = hex(self.var_selector_ids[i])
                else:
                    id = f'#{i}'
                if isinstance(selector, str):
                    result += f'\n  [{id}] = "{selector}"'
                else:
                    try:
                        result += f'\n  [{id}] = {hex(selector)}'
                    except TypeError:
                        result += f'\n  [{id}] = {selector}'
            result += f'\nOverriden functions: {len(self.func_selectors)}'
            for func in self.func_selectors:
                result += f'\n  [{hex(func["id"])}]  = {func["label"]}   \t ; @{hex(func["pointer"])}'  # TODO add function name

        elif self.kind == SectionKind.CODE:
            result += '\n' + '\n'.join([i.str_dump() for i in self.instructions])
        elif self.kind == SectionKind.STRINGS:
            result += "\n"
            for s in self.strings:
                result += f'{get_string_id(s)}: "{s["str"]}"'
                if s['special']:
                    result += "\t\t ; special"
                result += "\n"
        elif self.kind == SectionKind.EXPORTS:
            result += '\n' + '\n'.join([repr(i) for i in self.exports])
        elif self.kind == SectionKind.RELOCATION:
            # TODO print pointers as (smart) labels
            result += '\n' + f'num of pointers: {len(self.pointers)}'
            result += '\n' + ', '.join([hex(i) for i in self.pointers.keys()])
        elif self.kind == SectionKind.PRELOAD_TEXT:
            pass
        elif self.kind == SectionKind.LOCAL_VARS:
            def safe_hex(a):
                try:
                    return hex(a)
                except TypeError:
                    return str(a)

            result += '\n' + ', '.join([safe_hex(i) for i in self.local_vars])
        else:
            print(self.kind)
            raise NotImplementedError
        return result


if __name__ == '__main__':
    print("This script shouldn't be directly called")
    import sys

    sys.exit(1)
