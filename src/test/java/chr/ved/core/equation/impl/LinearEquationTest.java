package chr.ved.core.equation.impl;

import chr.ved.core.base.Constant;
import chr.ved.core.base.Operator;
import chr.ved.core.base.Term;
import chr.ved.core.base.Variable;
import chr.ved.core.equation.Equation;
import chr.ved.core.rules.Exponent;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinearEquationTest {

    @Test
    public void test1(){
        //y=2x+1 x=2 y=?
        Equation eq = new LinearEquation();
        Variable y = new Variable("y");
        Term ty = new Term(y);
        eq.addToLeftSide(ty);

        Variable x = new Variable("x");
        x.setValue(2d);
        Constant cx = new Constant(2d);
        Term tx = new Term(cx, x);
        eq.addToRightSide(tx);

        Operator op = new Operator(Operator.OperatorType.ADD);
        eq.addToRightSide(op);

        Constant m = new Constant(1d);
        Term tm = new Term(m);
        eq.addToRightSide(tm);

        eq.solve();
        System.out.println("");

    }

}
