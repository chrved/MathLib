package chr.ved.parser;

import chr.ved.parser.core.BaseTest;
import chr.ved.parser.core.ExpressionNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest extends BaseTest {


    @Test
    public void test1(){
        Parser parser = new Parser(tokenizer, expressionParser);
        String str = "2";
        ExpressionNode result = parser.parse(str);

        assertEquals(2.0,result.getValue(),0.0);
    }
    @Test
    public void test2(){
        Parser parser = new Parser(tokenizer, expressionParser);
        String str = "2+2";
        ExpressionNode result = parser.parse(str);

        assertEquals(4.0,result.getValue(),0.0);
    }

    @Test
    public void test11(){
        Parser parser = new Parser(tokenizer, expressionParser);
        String str = "5x^2 -2x + 3";
        parser.parse(str);
    }

}