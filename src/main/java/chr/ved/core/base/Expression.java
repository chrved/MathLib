package chr.ved.core.base;

import java.util.ArrayList;
import java.util.List;

public class Expression {
    private List<ExpressionType> expressions;
    public Expression(){
        expressions = new ArrayList<>();
    }
    public void addToExpression(ExpressionType part){
        expressions.add(part);
    }

    public List<ExpressionType> getExpressions(){
        return expressions;
    }
}
