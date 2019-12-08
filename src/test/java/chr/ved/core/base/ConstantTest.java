package chr.ved.core.base;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConstantTest {

    @Test
    public void getValue() {
        Constant a = new Constant(12d);
        assertTrue(12 == a.getValue());
        Constant d = new Constant();
        assertTrue(d.getValue() == null);
    }
}