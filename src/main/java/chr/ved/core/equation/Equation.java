package chr.ved.core.equation;

import chr.ved.core.base.Expression;
import chr.ved.core.base.ExpressionType;

public interface Equation {
    void addToLeftSide(ExpressionType element);
    void addToRightSide(ExpressionType element);
    Expression getLeftSide();
    Expression getRightSide();
    boolean solve();
    Solution getSoution();
}