package chr.ved.parser.core.expression.node;

import chr.ved.parser.core.ExpressionNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExponentiationNodeTest {

    @Test
    public void getType() {
        ExponentiationNode ex = new ExponentiationNode(new ConstantNode(2),new ConstantNode(2));
        assertEquals(ExpressionNode.ExpressionNodeType.EXPONENTIATION_NODE, ex.getType());
        assertEquals(4.0,ex.getValue(),0.0);
    }
}