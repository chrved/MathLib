package chr.ved.core;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExponentTest {
    @Test
    public void getValue() {
        Exponent<Integer> a = new Exponent<>(12);
        assertTrue(12 == a.getValue());
    }
}