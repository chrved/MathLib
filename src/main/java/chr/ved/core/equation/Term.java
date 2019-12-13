package chr.ved.core.equation;

import chr.ved.core.base.BaseType;
import chr.ved.core.base.impl.numeric.Constant;
import chr.ved.core.base.impl.numeric.Variable;
import chr.ved.core.exception.UnsolvableException;
import chr.ved.core.exception.ValueMissingException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Term implements BaseType {

    private Constant cofficient;
    private Variable variable;
    private Constant constant;
    private Type type;

    public Term(Constant cofficient, Variable variable){
        this.variable = variable;
        this.cofficient = cofficient;
        this.type = Type.VARIABLE;
    }
    public Term(Constant constant){
        this.constant = constant;
        this.type = Type.CONSTANT;
    }
    public Term(Variable variable){
        this.variable = variable;
        this.type = Type.VARIABLE;
    }

//    @Override
//    public Double solve(){
//        if(constant != null){
//            if (constant.getValue() == null){
//                throw new ValueMissingException("Value missing in constant: "+getClass());
//            }
//            return constant.solve();
//        }else if (cofficient != null && variable != null && variable.getValue() != null){
//            return cofficient.getValue() * variable.solve();
//        }else if (variable != null && variable.getValue() != null){
//            return variable.solve();
//        }
//        throw new UnsolvableException("Cant solve term, variable is null: "+getClass());
//    }
//
//    @Override
//    public Double getValue() {
//        return null;
//    }


    public BaseType getObject() {
        return this;
    }
}
