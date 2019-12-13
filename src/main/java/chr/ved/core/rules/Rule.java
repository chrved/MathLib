package chr.ved.core.rules;

import chr.ved.core.base.impl.numeric.Constant;

public interface Rule {
    Double solve();
    Constant getConstant();
}
