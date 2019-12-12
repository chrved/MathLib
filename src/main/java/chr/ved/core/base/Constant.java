package chr.ved.core.base;

import lombok.Getter;

@Getter
public class Constant implements BaseType{
    protected Double value;
    protected Double exponent;
    protected Type type;

    public Constant(){ this.type = Type.CONSTANT;}
    public Constant(Double value){
        this();
        this.value = value;
    }
    public Constant(Double value, Double exponent){
        this(value);
        this.exponent = exponent;
    }
    @Override
    public Double solve(){
        if(value != null && exponent != null){
            return Math.pow(value,exponent);
        }
        return value;
    }
}
