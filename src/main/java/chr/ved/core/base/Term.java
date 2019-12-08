package chr.ved.core.base;

import chr.ved.core.exception.ValueMissingException;
import chr.ved.core.rules.Exponent;

public class Term implements ExpressionType {
    private Variable variable;
    private Constant cofficient;

    private Constant constant;
    private Exponent exponent;

    public Term(Constant constant){
        this.constant = constant;
    }
    public Term(Constant constant, Exponent exponent){
        this.constant = constant;
        this.exponent = exponent;
    }
    public Term(Variable variable){
        this.variable = variable;
    }
    public Term(Variable variable, Exponent exponent){
        this.variable = variable;
        this.exponent = exponent;
    }
    public Term(Constant cofficient, Variable variable){
        this.cofficient = cofficient;
        this.variable = variable;
    }
    public Term(Constant cofficient, Variable variable, Exponent exponent){
        this.cofficient = cofficient;
        this.variable = variable;
        this.exponent = exponent;
    }

    public Double solve(){
        if(constant != null && exponent != null){
            return exponent.solve();
        }else if (constant != null){
            return constant.getValue();
        }else if (cofficient != null && variable != null && exponent != null){
            return cofficient.getValue() * exponent.solve();
        }else if (variable != null && exponent != null){
            return exponent.solve();
        }else if (variable != null){
            return variable.getValue();
        }
        throw new ValueMissingException("Value or exponent are missing in: "+getClass());
    }

    @Override
    public Type getExpressionType() {
        return Type.TERM;
    }
}
