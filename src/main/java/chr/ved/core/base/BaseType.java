package chr.ved.core.base;

public interface BaseType {
    enum Type{
        VARIABLE, CONSTANT, OPERATOR
    }
    enum OperatorType{
        PLUS, MINUS, DIV, MULT, LEFT_BRACKET, RIGHT_BRACKET
    }
    Type getType();
}
