package chr.ved.core.base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Variable extends Constant{
    private String name;

    public Variable(String name){
        super();
        this.name = name;
        this.type = Type.VARIABLE;
    }

    public Variable(String name, Double constant){
        this(name);
        this.value = constant;
//        setOperatorType(constant);
    }
    public Variable(String name, Double constant, Double exponent){
        this(name, constant);
        this.exponent = exponent;
    }
}
