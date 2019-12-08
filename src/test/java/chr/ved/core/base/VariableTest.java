package chr.ved.core.base;

import org.junit.Test;

import static org.junit.Assert.*;

public class VariableTest {
    @Test
    public void variable() {
        Variable a = new Variable("x");
        assertTrue("x".equals(a.getName()));
        assertTrue(a.getValue() == null);

        Variable b = new Variable("y");
        assertTrue("y".equals(b.getName()));
        assertTrue(b.getValue() == null);
        b.setValue(3d);
        assertTrue(b.getValue() == 3d);
    }

}