package chr.ved.core.base.impl.numeric;

import chr.ved.core.base.impl.AbstractNumericBaseType;
import chr.ved.core.exception.UnsolvableException;

public class Variable extends AbstractNumericBaseType {
    private String name;

    private Variable(){ super(Type.VARIABLE);}
    public Variable(String name){
        this();
        this.name = name;
    }

    public Variable(String name, double value){
        this(name);
        this.value = value;
    }
    public Variable(String name, double value, Constant exponent){
        this(name, value);
        this.exponent = exponent;
    }
    public Variable(Constant cofficient, String name, double value, Constant exponent){
        this(name, value);
        this.exponent = exponent;
        this.cofficient = cofficient;
    }

    @Override
    public Double solve() {
        if(hasCofficient() && hasValue()){
            return calcValueOfCofAndVal();
        }
        if(hasValue()){
            return calcValueOfVal();
        }
        throw new UnsolvableException(name+" is unknown.");
    }

    private Double calcValueOfVal() {
        if (exponent != null) {
            return Math.pow(value,exponent.solve());
        }
        return value;
    }

    private Double calcValueOfCofAndVal() {
        if (exponent != null) {
            return cofficient.solve() * Math.pow(value,exponent.solve());
        }
        return cofficient.solve() * value;
    }

    public String getName(){ return name;}
}
