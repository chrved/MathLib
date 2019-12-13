package chr.ved.core.base.impl.numeric;

import chr.ved.core.base.BaseType;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConstantTest {
    @Test
    public void getValue() {
        Constant a = new Constant();
        assertTrue(a.getValue() == null);
        assertFalse(a.hasValue());
        assertTrue(a.solve() == null);
        assertFalse(a.hasExponent());
        assertTrue(a.getExponent() == null);
        assertTrue(a.getType() == BaseType.Type.CONSTANT);

        Constant b = new Constant(-12);
        assertTrue(-12 == b.getValue());
        assertTrue(-12 == b.solve());
        assertTrue(b.hasValue());
        assertFalse(b.hasExponent());

        Constant c = new Constant(10, new Constant(2));
        assertTrue(10 == c.getValue());
        assertTrue(c.hasValue());
        assertTrue(c.hasExponent());
        assertTrue(100 == c.solve());

        Constant d = new Constant(-12, new Constant(2));
        assertTrue(-12 == d.getValue());
        assertTrue(144 == d.solve());
    }
}