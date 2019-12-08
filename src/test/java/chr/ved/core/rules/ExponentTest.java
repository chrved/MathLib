package chr.ved.core.rules;

import chr.ved.core.base.Constant;
import chr.ved.core.base.Variable;
import chr.ved.core.exception.ValueMissingException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class ExponentTest {

    @Test
    public void solveWithConstant() {
        Constant c = new Constant(5d);
        Exponent e = new Exponent(c,2d);

        assertThat(25d, equalTo(e.solve()));
    }
    @Test(expected = ValueMissingException.class)
    public void solveException() {
        Exponent e = new Exponent(new Variable("d"),2d);

        assertThat(25d, equalTo(e.solve()));
    }
    @Test
    public void solveWithVariable() {
        Variable v = new Variable("X");
        v.setValue(5d);
        Exponent e = new Exponent(v.getConstant(),2d);

        assertThat(25d, equalTo(e.solve()));
    }
}