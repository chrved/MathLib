package chr.ved.core.base.impl.numeric;

import chr.ved.core.base.impl.AbstractNumericBaseType;

public class Constant extends AbstractNumericBaseType {

    public Constant(){ super(Type.CONSTANT);}

    public Constant(double value){
        this();
        setValue(value);
    }
    public Constant(double value, Constant exponent){
        this(value);
        this.exponent = exponent;
    }

    @Override
    public Double solve(){
        if(value != null && exponent != null){
            return Math.pow(value,exponent.solve());
        }
        return value;
    }
}
