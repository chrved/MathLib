package chr.ved.core.rules;


import chr.ved.core.base.Constant;
import chr.ved.core.base.Variable;
import chr.ved.core.exception.ValueMissingException;

public class Exponent implements Rule {
    private Constant value;
    private Constant exponent;

    public Exponent(Constant value, Double exponent) {
        this.value = value;
        this.exponent = new Constant(exponent);
    }
    public Exponent(Variable value, Double exponent) {
        this.value = value.getConstant();
        this.exponent = new Constant(exponent);
    }
    @Override
    public Double solve() {
        if (value == null || exponent == null){
            throw new ValueMissingException("Value or exponent are missing in: "+getClass());
        }
        return Math.pow(value.getValue(), exponent.getValue());
    }

    @Override
    public Constant getConstant() {
        return value;
    }
}
