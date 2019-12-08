package chr.ved.core.equation.impl;

import chr.ved.core.base.Expression;
import chr.ved.core.base.ExpressionType;
import chr.ved.core.equation.Solution;
/*
    One variable:
    ax+b=0 and it has a unique solution x=-b/a with a ≠ 0
    Two variables:
    ax+by+c=0 is a linear equation in the single variable y for every value of x.
    It has therefore a unique solution for y, which is given by
    y=-(a/b)*x -c/b. With slope -a/b and  y-intercept -c/b

 */
public class LinearEquation extends AbstracEquation {

    public LinearEquation(){
        leftSide = new Expression();
        rightSide = new Expression();
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
    public boolean solve() {
        if()
        return false;
    }

    @Override
    public Solution getSoution() {
        return null;
    }
}
