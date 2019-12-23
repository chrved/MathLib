package chr.ved.parser.core.expression.node;


import chr.ved.parser.core.expression.ExpressionNode;

public class ConstantNode implements ExpressionNode {
    private final double value;

    public ConstantNode(double value){ this.value = value;}
    public ConstantNode(String value){ this.value = Double.parseDouble(value);}

    @Override
    public ExpressionNodeType getType() {
        return ExpressionNodeType.CONSTANT_NODE;
    }

    @Override
    public double getValue() {
        return value;
    }
}
