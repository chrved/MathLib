package chr.ved.core.base;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConstantTest {

    @Test
    public void getValue() {
        BaseType a = new Constant();
        assertTrue(a.getValue() == null);
        assertTrue(a.solve() == null);
        assertTrue(a.getType() == BaseType.Type.CONSTANT);
//        assertTrue(a.getOperatorType() == null);

        Constant b = new Constant(-12d);
        assertTrue(-12 == b.getValue());
        assertTrue(-12 == b.solve());
//        assertTrue(b.getOperatorType() == BaseType.OperatorType.SUB);

        Constant d = new Constant(-12d, 2d);
        assertTrue(-12 == d.getValue());
        assertTrue(144 == d.solve());
//        assertTrue(d.getOperatorType() == BaseType.OperatorType.SUB);

        Constant c = new Constant(10d, 2d);
        assertTrue(10 == c.getValue());
        assertTrue(100 == c.solve());
//        assertTrue(c.getOperatorType() == BaseType.OperatorType.ADD);
    }
}