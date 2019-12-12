package chr.ved.core.base;

import chr.ved.core.exception.UnsolvableException;
import chr.ved.core.exception.ValueMissingException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class TermTest {
    @Test
    public void testConstant(){
        Constant c = new Constant(5d);
        Term t = new Term(c);
        assertThat(5d, equalTo(t.solve()));
        assertThat(BaseType.Type.CONSTANT, equalTo(t.getType()));
    }
    @Test(expected = ValueMissingException.class)
    public void testNullConstant(){
        Constant c = new Constant();
        Term t = new Term(c);
        assertThat(5d, equalTo(t.solve()));
    }
    @Test
    public void testConstantAndExponent(){
        Constant c = new Constant(5d,2d);
        Term t = new Term(c);
        assertThat(25d, equalTo(t.solve()));
        assertThat(BaseType.Type.CONSTANT, equalTo(t.getType()));
    }
    @Test
    public void testVariable(){
        Variable v = new Variable("X", 5d);
        Term t = new Term(v);
        assertThat(5d, equalTo(t.solve()));
        assertThat(BaseType.Type.VARIABLE, equalTo(t.getType()));
    }
    @Test
    public void testVariableAndExponent(){
        Variable v = new Variable("X", 5d,2d);
        Term t = new Term(v);
        assertThat(25d, equalTo(t.solve()));
        assertThat(BaseType.Type.VARIABLE, equalTo(t.getType()));
    }
    @Test
    public void testVariableCofficienceAndExponent(){
        Variable v = new Variable("X",5d,2d);
        Constant c = new Constant(4d);
        Term t = new Term(c,v);
        assertThat(100d, equalTo(t.solve()));
    }
    @Test(expected = UnsolvableException.class)
    public void testVariableCofficienceAndExponentValuNull(){
        Variable v = new Variable("X",null,2d);
        Constant c = new Constant(4d);
        Term t = new Term(c,v);
        assertThat(100d, equalTo(t.solve()));
    }
}