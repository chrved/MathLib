package chr.ved.core;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConstantTest {

    @Test
    public void getValue() {
        Constant<Integer> a = new Constant<>(12);
        assertTrue(12 == a.getValue());
    }
}