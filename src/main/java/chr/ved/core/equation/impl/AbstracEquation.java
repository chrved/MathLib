package chr.ved.core.equation.impl;

import chr.ved.core.equation.Equation;
import chr.ved.core.equation.Expression;
import chr.ved.core.equation.Solution;

public abstract class AbstracEquation implements Equation {
    protected Expression leftSide;
    protected Expression rightSide;
    protected Solution solution;
}
