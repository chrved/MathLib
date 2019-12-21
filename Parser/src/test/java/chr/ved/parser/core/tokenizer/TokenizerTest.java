package chr.ved.parser.core.tokenizer;


import chr.ved.parser.core.tokenizer.token.Token;
import chr.ved.parser.core.tokenizer.token.type.*;
import chr.ved.parser.core.tokenizer.token.type.Constant;
import chr.ved.parser.exception.TokenizerException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TokenizerTest {
    private Tokenizer tokenizer;
    @Before
    public void setUp() throws Exception {
        tokenizer = new Tokenizer();
    }
    @Test
    public void tokenizeToString() {
        assertTrue(tokenizer.toString().equals("[EMPTY]"));

        tokenizer.tokenize(" cos(x) * (1 + var_12)   ");

        assertTrue(tokenizer.toString().equals("[FUNCTION:\"cos\", " +
                "OPEN_BRACKET:\"(\", " +
                "VARIABLE:\"x\", " +
                "CLOSE_BRACKET:\")\", " +
                "MULTDIV:\"*\", " +
                "OPEN_BRACKET:\"(\", " +
                "CONSTANT:\"1\", " +
                "PLUSMINUS:\"+\", " +
                "VARIABLE:\"var_12\", " +
                "CLOSE_BRACKET:\")\"]"));
        System.out.println(tokenizer.toString());
        tokenizer.reverseToken();
        assertTrue(tokenizer.toString().equals("[CLOSE_BRACKET:\")\", " +
                "VARIABLE:\"var_12\", " +
                "PLUSMINUS:\"+\", " +
                "CONSTANT:\"1\", " +
                "OPEN_BRACKET:\"(\", " +
                "MULTDIV:\"*\", " +
                "CLOSE_BRACKET:\")\", " +
                "VARIABLE:\"x\", " +
                "OPEN_BRACKET:\"(\", " +
                "FUNCTION:\"cos\"]"));
        System.out.println(tokenizer.toString());
    }

    @Test
    public void test2(){
        tokenizer.tokenize("5x^2 -2x +3");
        System.out.println(tokenizer.toString());
    }
    @Test(expected = TokenizerException.class)
    public void test3(){
        tokenizer.tokenize("cos(x) * (1 + var_12) &");
    }
}