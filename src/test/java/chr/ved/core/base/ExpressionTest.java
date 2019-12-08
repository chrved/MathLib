package chr.ved.core.base;

import chr.ved.core.rules.Exponent;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class ExpressionTest {

    @Test
    public void testExpression(){
        Expression expression = new Expression();

        Variable v = new Variable("X");
        v.setValue(5d);
        Exponent e = new Exponent(v,2d);
        Constant c = new Constant(4d);
        Term t = new Term(c,v,e);

        expression.addToExpression(t);

        assertThat(1, equalTo(expression.getExpressions().size()));
    }
}