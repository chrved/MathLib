package chr.ved.tokenizer;

import chr.ved.tokenizer.core.Token;
import chr.ved.tokenizer.core.type.*;
import chr.ved.tokenizer.core.type.Number;
import chr.ved.tokenizer.exception.TokenizerException;
import org.junit.Before;
import org.junit.Test;

public class TokenizerTest {

    private Tokenizer tokenizer;
    @Before
    public void setUp() throws Exception {
        tokenizer = new Tokenizer();
        tokenizer.addTokenType("\\s", new WhiteSpace());
        tokenizer.addTokenType("sin|cos|exp|ln|sqrt", new Function()); // function
        tokenizer.addTokenType("\\(", new OpenBracket()); // open bracket
        tokenizer.addTokenType("\\)", new CloseBracket()); // close bracket
        tokenizer.addTokenType("[+-]", new PlusMinus()); // plus or minus
        tokenizer.addTokenType("[*/]", new PlusMinus()); // mult or divide
        tokenizer.addTokenType("\\^", new Pow()); // raised
        tokenizer.addTokenType("[0-9]+", new Number()); // integer number
        tokenizer.addTokenType("[a-zA-Z][a-zA-Z0-9_]*", new Variable()); // variable
    }

    @Test
    public void test1(){
        tokenizer.tokenize(" cos(x) * (1 + var_12)   ");

        for (Token tok : tokenizer.getTokens()) {
            System.out.println(tok.getToken() + " -> " + tok.getSequence());
        }
    }
    @Test
    public void test2(){
        tokenizer.tokenize("5x^2 -2x +3");

        for (Token tok : tokenizer.getTokens()) {
            System.out.println(tok.getToken() + " -> " + tok.getSequence());
        }
    }
    @Test(expected = TokenizerException.class)
    public void test3(){
        tokenizer.tokenize("cos(x) * (1 + var_12) &");
    }
}