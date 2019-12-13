package chr.ved.core.base.impl;

import chr.ved.core.base.BaseType;
import chr.ved.core.base.impl.numeric.Constant;

public abstract class AbstractNumericBaseType implements BaseType {
    protected Type type;
    protected Double value;
    protected Constant exponent;
    protected Constant cofficient;

    protected AbstractNumericBaseType(Type type){this.type = type;}
    public abstract Double solve();

    public Type getType() { return type; }

    public Double getValue(){ return value; }
    public void setValue(double value){ this.value = value;}
    public boolean hasValue(){ return value != null; }

    public Constant getExponent(){ return exponent;}
    public void setExponent(Constant exponent){this.exponent = exponent;}
    public boolean hasExponent(){ return exponent != null;}

    public Constant getCofficient(){ return cofficient; }
    public void setCofficient(Constant cofficient){ this.cofficient = cofficient; }
    public boolean hasCofficient(){ return cofficient != null; }

}
