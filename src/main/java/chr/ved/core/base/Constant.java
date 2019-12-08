package chr.ved.core.base;


public class Constant {
    protected Double value;

    public Constant(Double value){
        this.value = value;
    }
    protected Constant(){}

    public Double getValue(){
        return this.value;
    }
}
