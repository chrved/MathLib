package chr.ved.parser.core.expression.node;

import chr.ved.parser.core.Expression;
import chr.ved.parser.core.ExpressionNode;
import chr.ved.parser.exception.EvaluationException;

public class DivisionNode extends Expression {
    public DivisionNode() { super(); }
    public DivisionNode(ExpressionNode node, boolean positive) { super(node, positive); }

    @Override
    public ExpressionNodeType getType() {
        return ExpressionNodeType.DIVISION_NODE;
    }

    @Override
    public double getValue() {
        double dividend = terms.get(0).positive ? terms.get(0).expression.getValue() : -1*terms.get(0).expression.getValue();
        double divisor = terms.get(1).positive ? terms.get(1).expression.getValue() : -1*terms.get(1).expression.getValue();
        if(divisor == 0){
            throw new EvaluationException("Divide by 0 is not possible.");
        }
        return dividend/divisor;
    }
}
