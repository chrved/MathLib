package chr.ved.core.equation;

import chr.ved.core.base.BaseType;

import java.util.Map;

public interface Equation {
    void addToLeftSide(BaseType element);
    void addToRightSide(BaseType element);
    Expression getLeftSide();
    Expression getRightSide();
    boolean solve();
    Map<String, Double> getSoution();
}