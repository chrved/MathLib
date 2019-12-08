package chr.ved.core.rules;

import chr.ved.core.base.Constant;

public interface Rule {
    Double solve();
    Constant getConstant();
}
