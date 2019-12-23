package chr.ved.parser.core.expression.node;

import chr.ved.parser.core.expression.Expression;
import chr.ved.parser.core.expression.ExpressionNode;

public class MultiplicationNode extends Expression {

    public MultiplicationNode() { super(); }
    public MultiplicationNode(ExpressionNode node, boolean positive) { super(node, positive); }

    @Override
    public ExpressionNodeType getType() {
        return ExpressionNodeType.MULTIPLICATION_NODE;
    }

    @Override
    public double getValue() {
        double prod = 1.0;
        for (Term t : terms) {
            if (t.positive)
                prod *= t.expression.getValue();
            else
                prod *= -1*t.expression.getValue(); //prod /= t.expression.getValue();
        }
        return prod;
    }
}
