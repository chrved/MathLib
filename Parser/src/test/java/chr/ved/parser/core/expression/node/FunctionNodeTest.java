package chr.ved.parser.core.expression.node;

import chr.ved.parser.core.expression.ExpressionNode;
import chr.ved.parser.exception.EvaluationException;
import org.junit.Test;

import static org.junit.Assert.*;

public class FunctionNodeTest {

    @Test
    public void getType() {
        FunctionNode fun = new FunctionNode(FunctionNode.FunctionType.SQRT, new ConstantNode(4));
        assertEquals(ExpressionNode.ExpressionNodeType.FUNCTION_NODE, fun.getType());
    }

    @Test
    public void getValue() {
        FunctionNode fun = new FunctionNode(FunctionNode.FunctionType.SQRT, new ConstantNode(4));
        assertEquals(ExpressionNode.ExpressionNodeType.FUNCTION_NODE, fun.getType());
        assertEquals(2.0,fun.getValue(),0.0);
    }
    @Test(expected = EvaluationException.class)
    public void getNegValue() {
        FunctionNode fun = new FunctionNode(FunctionNode.FunctionType.SQRT, new ConstantNode(-4));
        assertEquals(11.0,fun.getValue(),0.0);
    }
}