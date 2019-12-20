package chr.ved.parser.core;

public interface ExpressionNode {

    enum ExpressionNodeType {
        VARIABLE_NODE,
        CONSTANT_NODE,
        ADDITION_NODE,
        SUBTRACTION_NODE,
        MULTIPLICATION_NODE,
        DIVISION_NODE,
        EXPONENTIATION_NODE,
        FUNCTION_NODE
    }

    ExpressionNodeType getType();
    double getValue();
}
