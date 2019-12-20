package chr.ved.parser.core.expression.node;

import chr.ved.parser.core.ExpressionNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubtractionNodeTest {

    @Test
    public void getType() {
        SubtractionNode a = new SubtractionNode();
        assertEquals(ExpressionNode.ExpressionNodeType.SUBTRACTION_NODE, a.getType());
    }

    @Test
    public void getValue1() {
        //1-3
        SubtractionNode sum = new SubtractionNode();
        sum.add(new ConstantNode(1),true);
        sum.add(new ConstantNode(3),true);
        assertEquals(-2.0,sum.getValue(),0.0);
    }

    @Test
    public void getValue2() {
        //-1-3
        SubtractionNode sum = new SubtractionNode();
        sum.add(new ConstantNode(1),false);
        sum.add(new ConstantNode(3),true);
        assertEquals(-4.0,sum.getValue(),0.0);
    }
    @Test
    public void getValue3() {
        //-1-3
        SubtractionNode sum = new SubtractionNode();
        sum.add(new ConstantNode(-1),true);
        sum.add(new ConstantNode(3),false);
        assertEquals(-4.0,sum.getValue(),0.0);
    }
    @Test
    public void getValue4() {
        //1--3
        SubtractionNode sum = new SubtractionNode();
        sum.add(new ConstantNode(1),true);
        sum.add(new ConstantNode(-3),true);
        assertEquals(4.0,sum.getValue(),0.0);
    }

}