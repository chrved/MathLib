package chr.ved.core.base;

public interface ExpressionType {
    enum Type{
        TERM, OPERATOR, VARIABLE, CONSTANT
    }
    Type getExpressionType();
    Object getObject();
}
