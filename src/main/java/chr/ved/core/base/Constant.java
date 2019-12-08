package chr.ved.core.base;


public class Constant implements ExpressionType{
    protected Double value;

    public Constant(Double value){
        this.value = value;
    }
    protected Constant(){}

    public Double getValue(){
        return this.value;
    }

    @Override
    public Type getExpressionType() {
        return Type.CONSTANT;
    }

    @Override
    public Constant getObject() {
        return this;
    }
}
