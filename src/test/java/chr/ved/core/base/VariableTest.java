package chr.ved.core.base;

import org.junit.Test;

import static org.junit.Assert.*;

public class VariableTest {
    @Test
    public void variable() {
        Variable a = new Variable("x");
        assertTrue("x".equals(a.getName()));
        assertTrue(a.getValue() == null);
        assertTrue(a.getExponent() == null);
        assertTrue(a.solve() == null);
        assertTrue(a.getType() == BaseType.Type.VARIABLE);

        Variable b = new Variable("y",2d);
        assertTrue("y".equals(b.getName()));
        assertTrue(b.getValue() == 2);
        assertTrue(b.getExponent() == null);
        assertTrue(b.solve() == 2);
        assertTrue(a.getType() == BaseType.Type.VARIABLE);

        Variable c = new Variable("z",-2d,5d);
        assertTrue("z".equals(c.getName()));
        assertTrue(c.getValue() == -2);
        assertTrue(c.getExponent() == 5);
        assertTrue(c.solve() == -32);
        assertTrue(c.getType() == BaseType.Type.VARIABLE);

    }

}