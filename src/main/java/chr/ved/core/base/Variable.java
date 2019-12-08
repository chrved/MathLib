package chr.ved.core.base;

public class Variable implements ExpressionType{
    private String name;
    private Constant value;
    public Variable(String name){
        this.name = name;
    }

    public void setValue(Double value){
        this.value = new Constant(value);
    }
    public Double getValue(){
        return this.value != null ? this.value.getValue() : null;
    }
    public Constant getConstant(){
        return this.value;
    }

    public String getName(){ return this.name; }

    @Override
    public Type getExpressionType() {
        return Type.VARIABLE;
    }

    @Override
    public Variable getObject() {
        return this;
    }
}
