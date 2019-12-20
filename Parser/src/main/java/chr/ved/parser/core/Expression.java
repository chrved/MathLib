package chr.ved.parser.core;

import java.util.ArrayList;
import java.util.List;

public abstract class Expression implements ExpressionNode{
    protected List<Term> terms;

    public Expression(){
        this.terms = new ArrayList<>();
    }

    public Expression(ExpressionNode node, boolean positive){
        this();
        this.terms.add(new Term(positive,node));
    }

    public void add(ExpressionNode node, boolean positive){
        this.terms.add(new Term(positive,node));
    }
}
