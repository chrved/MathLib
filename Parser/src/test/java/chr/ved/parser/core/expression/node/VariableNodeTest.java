package chr.ved.parser.core.expression.node;

import chr.ved.parser.core.ExpressionNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class VariableNodeTest {

    @Test
    public void setValue() {
    }

    @Test
    public void getType() {
        VariableNode a = new VariableNode("x");
        assertEquals(ExpressionNode.ExpressionNodeType.VARIABLE_NODE, a.getType());
    }

    @Test
    public void getValue1() {
        //1+3
        VariableNode sum = new VariableNode("x");
        sum.setValue(1);
        assertEquals(1.0,sum.getValue(),0.0);
        assertEquals("x", sum.getName());
    }
}