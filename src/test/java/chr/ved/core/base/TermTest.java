package chr.ved.core.base;

import chr.ved.core.rules.Exponent;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class TermTest {
    @Test
    public void testConstant(){
        Constant c = new Constant(5d);
        Term t = new Term(c);
        assertThat(5d, equalTo(t.solve()));
    }
    @Test
    public void testConstantAndExponent(){
        Constant c = new Constant(5d);
        Exponent e = new Exponent(c,2d);
        Term t = new Term(c,e);
        assertThat(25d, equalTo(t.solve()));
    }
    @Test
    public void testConstantAndExponentNeg(){
        Constant c = new Constant(-5d);
        Exponent e = new Exponent(c,2d);
        Term t = new Term(c,e);
        assertThat(25d, equalTo(t.solve()));
    }


    @Test
    public void testVariable(){
        Variable v = new Variable("X");
        v.setValue(5d);

        Term t = new Term(v);
        assertThat(5d, equalTo(t.solve()));
    }
    @Test
    public void testVariableAndExponent(){
        Variable v = new Variable("X");
        v.setValue(5d);
        Exponent e = new Exponent(v,2d);
        Term t = new Term(v,e);
        assertThat(25d, equalTo(t.solve()));
    }
    @Test
    public void testVariableCofficienceAndExponent(){
        Variable v = new Variable("X");
        v.setValue(5d);
        Exponent e = new Exponent(v,2d);
        Constant c = new Constant(4d);
        Term t = new Term(c,v,e);
        assertThat(100d, equalTo(t.solve()));
    }
}