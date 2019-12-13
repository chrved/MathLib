package chr.ved.core.base.impl.numeric;

import chr.ved.core.base.BaseType;
import chr.ved.core.exception.UnsolvableException;
import org.junit.Test;

import static org.junit.Assert.*;

public class VariableTest {
    @Test
    public void testOne(){
        Variable a = new Variable("x");
        assertTrue("x".equals(a.getName()));
        assertTrue(a.getValue() == null);
        assertTrue(a.getExponent() == null);
        assertTrue(a.getType() == BaseType.Type.VARIABLE);
        assertTrue(a.getCofficient() == null);
        assertFalse(a.hasValue());
        assertFalse(a.hasExponent());
        assertFalse(a.hasCofficient());

    }
    @Test(expected = UnsolvableException.class)
    public void testOneException1(){
        Variable a = new Variable("x");
        a.solve();
    }
    @Test(expected = UnsolvableException.class)
    public void testOneException2(){
        Variable a = new Variable("x");
        a.setCofficient(new Constant(2));
        a.solve();
    }
    @Test(expected = UnsolvableException.class)
    public void testOneException3(){
        Variable a = new Variable("x");
        a.setCofficient(new Constant(2));
        a.setExponent(new Constant(3));
        a.solve();
    }
    @Test
    public void testVar(){
        Variable a = new Variable("x");
        a.setValue(2);
        assertTrue(a.solve() == 2);
    }
    @Test
    public void testVarAndCoff(){
        Variable a = new Variable("x");
        a.setValue(2);
        a.setCofficient(new Constant(3));
        assertTrue(a.solve() == 6);
    }
    @Test
    public void testVarAndCoffAndExp(){
        Variable a = new Variable("x");
        a.setValue(2);
        a.setCofficient(new Constant(3));
        a.setExponent(new Constant(2));
        assertTrue(a.solve() == 12);
    }
}