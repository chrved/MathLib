package chr.ved.core;

import org.junit.Test;

import static org.junit.Assert.*;

public class VariableTest {

    @Test
    public void variable() {
        Variable<Double> a = new Variable<>("x");
        assertTrue("x".equals(a.getName()));
        assertTrue(1.0 == a.getExponent());
        assertTrue(a.getValue() == null);

        Variable<Double> b = new Variable<>("y",2d);
        assertTrue("y".equals(b.getName()));
        assertTrue(2.0 == b.getExponent());
        assertTrue(b.getValue() == null);
        b.setValue(3d);
        assertTrue(b.getValue() == 3d);
    }
}