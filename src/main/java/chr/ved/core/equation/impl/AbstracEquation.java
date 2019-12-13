package chr.ved.core.equation.impl;

import chr.ved.core.base.BaseType;
import chr.ved.core.base.impl.numeric.Variable;
import chr.ved.core.equation.Equation;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstracEquation implements Equation {
    protected Expression leftSide;
    protected Expression rightSide;
    protected Map<String, Variable> solution;

    protected AbstracEquation(){
        leftSide = new Expression();
        rightSide = new Expression();
        solution = new HashMap<>();
    }

    @Override
    public void addToLeftSide(BaseType element) {
        leftSide.addToExpression(element);
    }

    @Override
    public void addToRightSide(BaseType element) {
        rightSide.addToExpression(element);
    }

    @Override
    public Expression getLeftSide() {
        return leftSide;
    }

    @Override
    public Expression getRightSide() {
        return rightSide;
    }

    @Override
    public Map<String, Variable> getSoution(){return solution;}

    @Override
    public abstract boolean solve();

    protected abstract void parseEquation();
    protected abstract boolean iSSolvable();


}
