package chr.ved.parser.core.expression.node;

import chr.ved.parser.core.expression.ExpressionNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConstantNodeTest {

    @Test
    public void getType() {
        ConstantNode c = new ConstantNode("1");
        assertEquals(ExpressionNode.ExpressionNodeType.CONSTANT_NODE, c.getType());
        assertEquals(1.0,c.getValue(),0.0);
    }

    @Test
    public void getValue() {
        ConstantNode c = new ConstantNode(4);
        assertEquals(4.0,c.getValue(),0.0);
    }
}