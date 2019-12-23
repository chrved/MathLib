package chr.ved.parser.core.expressionparser.addsubmultdiv;

import chr.ved.parser.Parser;
import chr.ved.parser.core.expression.ExpressionNode;
import chr.ved.parser.core.expressionparser.ExpressionParser;
import chr.ved.parser.core.tokenizer.Tokenizer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddSubMultDivParserTest {
    private Parser parser;
    private Tokenizer tokenizer;
    private ExpressionParser add;

    @Before
    public void setup(){
        add = new AddSubMultDivParser();
        tokenizer = new Tokenizer();
        parser = new Parser(tokenizer,add);
    }

    @Test
    public void simpleTestAdd2Constants(){
        String str = "1+2";
        ExpressionNode node = parser.parse(str);
        assertNotNull(node);
        double a = node.getValue();
        assertEquals(3.0, node.getValue(),0.0);
    }
    @Test
    public void simpleTestAdd3Constants(){
        String str = "1+2-3+3";
        ExpressionNode node = parser.parse(str);
        assertNotNull(node);
        double a = node.getValue();
        assertEquals(3.0, node.getValue(),0.0);
    }
    @Test
    public void simpleTestMult(){
        String str = "2*3";
        ExpressionNode node = parser.parse(str);
        assertNotNull(node);
        double a = node.getValue();
        assertEquals(6.0, node.getValue(),0.0);
    }
    @Test
    public void simpleTestMult2(){
        String str = "2*3*2";
        ExpressionNode node = parser.parse(str);
        assertNotNull(node);
        double a = node.getValue();
        assertEquals(12.0, node.getValue(),0.0);
    }
    @Test
    public void simpleTest3(){
        String str = "6/2*3";
        ExpressionNode node = parser.parse(str);
        assertNotNull(node);
        double a = node.getValue();
        assertEquals(1.0, node.getValue(),0.0);
    }
    @Test
    public void simpleTest4(){
        String str = "1+2*3";
        ExpressionNode node = parser.parse(str);
        double a = node.getValue();
        assertEquals(7.0, node.getValue(),0.0);
    }
    @Test
    public void simpleTest5(){
        String str = "1*2+3";
        ExpressionNode node = parser.parse(str);
        double a = node.getValue();
        assertEquals(5.0, node.getValue(),0.0);
    }

}