package chr.ved.parser.core.expression.node;

import chr.ved.parser.core.ExpressionNode;
import chr.ved.parser.exception.EvaluationException;

public class VariableNode implements ExpressionNode {
    private String name;
    private double value;
    private boolean valueSet;

    public VariableNode(String name) {
        this.name = name;
        valueSet = false;
    }
    public void setValue(double value) {
        this.value = value;
        this.valueSet = true;
    }
    public String getName(){return name;}

    @Override
    public ExpressionNodeType getType() {
        return ExpressionNodeType.VARIABLE_NODE;
    }

    @Override
    public double getValue() {
        if (valueSet) {
            return value;
        } else {
            throw new EvaluationException("Variable '" + name + "' was not initialized.");
        }
    }
}
