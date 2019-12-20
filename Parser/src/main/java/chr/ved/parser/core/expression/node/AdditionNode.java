package chr.ved.parser.core.expression.node;

import chr.ved.parser.core.Expression;
import chr.ved.parser.core.ExpressionNode;
import chr.ved.parser.core.Term;

public class AdditionNode extends Expression {

    public AdditionNode(){ super();}
    public AdditionNode(ExpressionNode node, boolean positive){
        super(node, positive);
    }

    @Override
    public ExpressionNodeType getType() {
        return ExpressionNodeType.ADDITION_NODE;
    }

    @Override
    public double getValue() {
        double sum = 0;
        for (Term t : terms){
            if(t.positive){
                sum += t.expression.getValue();
            } else {
                sum -= t.expression.getValue();
            }
        }
        return sum;
    }
}
