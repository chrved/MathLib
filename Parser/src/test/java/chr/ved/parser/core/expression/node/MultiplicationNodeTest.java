package chr.ved.parser.core.expression.node;

import chr.ved.parser.core.ExpressionNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class MultiplicationNodeTest {

    @Test
    public void getType() {
        MultiplicationNode d = new MultiplicationNode();
        assertEquals(ExpressionNode.ExpressionNodeType.MULTIPLICATION_NODE, d.getType());
    }

    @Test
    public void getValue() {
        MultiplicationNode d = new MultiplicationNode();
        d.add(new ConstantNode(4),true);
        d.add(new ConstantNode(2),true);
        assertEquals(8.0,d.getValue(),0.0);
    }
    @Test
    public void getValue1() {
        MultiplicationNode d = new MultiplicationNode();
        d.add(new ConstantNode(4),false);
        d.add(new ConstantNode(2),true);
        assertEquals(-8.0,d.getValue(),0.0);
    }
    @Test
    public void getValue2() {
        MultiplicationNode d = new MultiplicationNode();
        d.add(new ConstantNode(-4),false);
        d.add(new ConstantNode(2),true);
        assertEquals(8.0,d.getValue(),0.0);
    }
}