package chr.ved.parser.core.expression.node;

import chr.ved.parser.core.expression.Expression;
import chr.ved.parser.core.expression.ExpressionNode;

public class SubtractionNode extends Expression {
    public SubtractionNode(){ super();}
    public SubtractionNode(ExpressionNode node, boolean positive){
        super(node, positive);
    }

    @Override
    public ExpressionNodeType getType() {
        return ExpressionNodeType.SUBTRACTION_NODE;
    }

    @Override
    public double getValue() {
        double sum = terms.get(0).positive ? terms.get(0).expression.getValue() : -1*terms.get(0).expression.getValue();
        for (int i=1;i<terms.size();i++){
            Term t = terms.get(i);
            if(t.positive){
                sum -= t.expression.getValue();
            } else {
                sum -= t.expression.getValue();
            }
        }
        return sum;
    }
}
