package chr.ved.core.equation.impl;

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

import chr.ved.core.base.BaseType;
import chr.ved.core.base.impl.AbstractOperatorBaseType;
import chr.ved.core.base.impl.numeric.Constant;
import chr.ved.core.base.impl.numeric.Variable;

import java.util.HashMap;

public class LinearEquation extends AbstracEquation {
    // Form: y = kx + m
    private Variable y;
    private Constant m;
    private Variable x;
    private AbstractOperatorBaseType operator;


    @Override
    public boolean solve() {
        // Get all varible
        parseEquation();
        // Check if solvable
        if (iSSolvable()){
            calcEquation();
            return true;
        }
        return false;
    }

    private void calcEquation() {
        switch (operator.getOperatorType()){
            case PLUS:
                y.setValue(x.solve()+m.solve());
                break;
        }

        addAllValuesToSolution();
    }

    private void addAllValuesToSolution() {
        solution = new HashMap<>();
        solution.put("y",y);
        solution.put("m",new Variable("m",m.solve()));
        solution.put("x",x);
    }

    @Override
    protected void parseEquation() {
        parseLeftSide();
        parseRightSide();
    }

    @Override
    protected boolean iSSolvable() {
        return x.hasValue();
    }

    private void parseRightSide() {
        for(BaseType part : rightSide.getExpressions()){
            switch (part.getType()){
                case VARIABLE:
                    Variable tmpVar = (Variable) part;
                    if("x".equalsIgnoreCase(tmpVar.getName())){
                        x = tmpVar;
                        System.out.println(x);
                    }else {
                        y = tmpVar;
                    }
                    break;
                case CONSTANT:
                    m = (Constant) part;
                    break;
                case OPERATOR:
                    operator = (AbstractOperatorBaseType) part;
                    break;
            }
        }
    }

    private void parseLeftSide() {
        for(BaseType part : leftSide.getExpressions()){
            switch (part.getType()){
                case VARIABLE:
                    Variable tmpVar = (Variable) part;
                    if("x".equalsIgnoreCase(tmpVar.getName())){
                        x = tmpVar;
                    }else {
                        y = tmpVar;
                    }
                    break;
                case CONSTANT:
                    m = (Constant) part;
                    break;
                case OPERATOR:
                    operator = (AbstractOperatorBaseType) part;
                    break;
            }
        }
    }
}
