package chr.ved.parser.core;

import chr.ved.tokenizer.Tokenizer;
import chr.ved.tokenizer.core.type.*;
import chr.ved.tokenizer.core.type.Number;
import org.junit.Before;

public class BaseTest {
    protected Tokenizer tokenizer;
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
}
