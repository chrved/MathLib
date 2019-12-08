package chr.ved.core.base;

public class Operator implements ExpressionType {
    public enum OperatorType {
        ADD,SUB,MULT,DIV
    }
    private OperatorType type;

    public Operator(OperatorType type){
        this.type = type;
    }

    public OperatorType getType() {
        return type;
    }

    @Override
    public Type getExpressionType() {
        return Type.OPERATOR;
    }

    @Override
    public Operator getObject() {
        return this;
    }

}
