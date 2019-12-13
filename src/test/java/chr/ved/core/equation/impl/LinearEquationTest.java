package chr.ved.core.equation.impl;

import chr.ved.core.base.impl.AbstractOperatorBaseType;
import chr.ved.core.base.impl.numeric.Constant;
import chr.ved.core.base.impl.numeric.Variable;
import chr.ved.core.base.impl.operator.Plus;
import chr.ved.core.equation.Equation;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class LinearEquationTest {

    @Test
    public void solveSimple() {
        Equation eq = new LinearEquation();
        //y(x) = x + 5
        Constant c = new Constant(5);
        Variable x = new Variable("x");
        Variable y = new Variable("y");
        AbstractOperatorBaseType op = new Plus();

        eq.addToLeftSide(y);
        eq.addToRightSide(x);
        eq.addToRightSide(op);
        eq.addToRightSide(c);

        assertThat(false, equalTo(eq.solve()));
        System.out.println(x);
        x.setValue(5d);
        assertThat(true, equalTo(eq.solve()));

        Map<String, Variable> s = eq.getSoution();
        assertThat(10d,equalTo(s.get("y").solve()));
    }
}