package chr.ved.parser.core.expression.node;


import chr.ved.parser.core.ExpressionNode;

public class ExponentiationNode implements ExpressionNode {
    private ExpressionNode base;
    private ExpressionNode exponent;

    public ExponentiationNode(ExpressionNode base, ExpressionNode exponent) {
        this.base = base;
        this.exponent = exponent;
    }

    @Override
    public ExpressionNodeType getType() {
        return ExpressionNodeType.EXPONENTIATION_NODE;
    }

    @Override
    public double getValue() {
        return Math.pow(base.getValue(),exponent.getValue());
    }
}
