package chr.ved.parser.core.expression.node;


import chr.ved.parser.core.expression.ExpressionNode;

public class ExponentiationNode implements ExpressionNode {
    private final ExpressionNode base;
    private final ExpressionNode exponent;

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
