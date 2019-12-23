package chr.ved.parser;

import chr.ved.parser.core.BaseTest;
import chr.ved.parser.core.expression.ExpressionNode;
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
    public void test3(){
        Parser parser = new Parser(tokenizer, expressionParser);
        String str = "3*2+3";
        ExpressionNode result = parser.parse(str);

        assertEquals(9,result.getValue(),0.0);
    }

    @Test
    public void test11(){
        Parser parser = new Parser(tokenizer, expressionParser);
        String str = "3*2^4 + sqrt(1+3)";
        ExpressionNode result = parser.parse(str);

        assertEquals(50.0,result.getValue(),0.0);
    }

}