package chr.ved.core.equation.impl;

import chr.ved.core.base.*;
import chr.ved.core.equation.Solution;
/*
    One variable:
    ax+b=0 and it has a unique solution x=-b/a with a ≠ 0
    Two variables:
    ax+by+c=0 is a linear equation in the single variable y for every value of x.
    It has therefore a unique solution for y, which is given by
    y=-(a/b)*x -c/b. With slope -a/b and  y-intercept -c/b

y=2x+1
-1=2x
x = -1/2
 */

public class LinearEquation extends AbstracEquation {

    public LinearEquation(){
        leftSide = new Expression();
        rightSide = new Expression();
    }
    @Override
    public boolean solve() {
        Term t = (Term) leftSide.getExpressions().get(0).getObject();
        Variable y = (Variable) ((Term) leftSide.getExpressions().get(0).getObject()).getVariable();
        Constant cx = (Constant) rightSide.getExpressions().get(0).getObject();
        Variable x = (Variable) rightSide.getExpressions().get(1).getObject();
        Operator op = (Operator) rightSide.getExpressions().get(2).getObject();
        Constant m = (Constant) rightSide.getExpressions().get(3).getObject();

            return false;
    }

    @Override
    public void addToLeftSide(ExpressionType element) {
        leftSide.addToExpression(element);
    }

    @Override
    public void addToRightSide(ExpressionType element) {
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
    public Solution getSoution() {
        return null;
    }
}
