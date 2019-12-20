package chr.ved.parser.core.expression.node;

import chr.ved.parser.core.ExpressionNode;
import chr.ved.parser.exception.EvaluationException;
import org.junit.Test;

import static org.junit.Assert.*;

public class DivisionNodeTest {

    @Test
    public void getType() {
        DivisionNode d = new DivisionNode();
        assertEquals(ExpressionNode.ExpressionNodeType.DIVISION_NODE, d.getType());
    }

    @Test
    public void getValue() {
        DivisionNode d = new DivisionNode();
        d.add(new ConstantNode(4),true);
        d.add(new ConstantNode(2),true);
        assertEquals(2.0,d.getValue(),0.0);
    }
    @Test
    public void getValue1() {
        DivisionNode d = new DivisionNode();
        d.add(new ConstantNode(0),true);
        d.add(new ConstantNode(2),true);
        assertEquals(0,d.getValue(),0.0);
    }
    @Test(expected = EvaluationException.class)
    public void getValue2() {
        DivisionNode d = new DivisionNode();
        d.add(new ConstantNode(2),true);
        d.add(new ConstantNode(0),true);
        assertEquals(0,d.getValue(),0.0);
    }
    @Test
    public void getValue3() {
        DivisionNode d = new DivisionNode();
        d.add(new ConstantNode(-2),true);
        d.add(new ConstantNode(1),true);
        assertEquals(-2,d.getValue(),0.0);
    }
    @Test
    public void getValue4() {
        DivisionNode d = new DivisionNode();
        d.add(new ConstantNode(-2),true);
        d.add(new ConstantNode(-1),true);
        assertEquals(2,d.getValue(),0.0);
    }
    @Test
    public void getValue5() {
        DivisionNode d = new DivisionNode();
        d.add(new ConstantNode(2),true);
        d.add(new ConstantNode(-1),true);
        assertEquals(-2,d.getValue(),0.0);
    }
    @Test
    public void getValue6() {
        DivisionNode d = new DivisionNode();
        d.add(new ConstantNode(2),false);
        d.add(new ConstantNode(-1),true);
        assertEquals(2,d.getValue(),0.0);
    }
}