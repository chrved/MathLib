package chr.ved.parser.core;

import chr.ved.parser.core.expressionparser.ExpressionParser;
import chr.ved.parser.core.expressionparser.regularexpression.RegularExpression;
import chr.ved.parser.core.tokenizer.Tokenizer;
import org.junit.Before;

public class BaseTest {
    protected Tokenizer tokenizer;
    protected ExpressionParser expressionParser;
    @Before
    public void setUp() throws Exception {
        expressionParser = new RegularExpression();

        tokenizer = new Tokenizer();
    }
}
