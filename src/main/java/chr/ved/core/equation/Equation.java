package chr.ved.core.equation;

import chr.ved.core.base.BaseType;

public interface Equation {
    void addToLeftSide(BaseType element);
    void addToRightSide(BaseType element);
    Expression getLeftSide();
    Expression getRightSide();
    boolean solve();
    Solution getSoution();
}