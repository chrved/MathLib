package chr.ved.core.equation.impl;

import chr.ved.core.base.BaseType;

import java.util.ArrayList;
import java.util.List;

public class Expression {
    private List<BaseType> expressions;
    public Expression(){
        expressions = new ArrayList<>();
    }
    public void addToExpression(BaseType part){
        expressions.add(part);
    }

    public List<BaseType> getExpressions(){
        return expressions;
    }
}
