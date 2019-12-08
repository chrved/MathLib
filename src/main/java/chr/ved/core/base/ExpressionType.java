package chr.ved.core.base;

public interface ExpressionType {
    enum Type{
        TERM, OPERATOR
    }
    Type getExpressionType();
}
