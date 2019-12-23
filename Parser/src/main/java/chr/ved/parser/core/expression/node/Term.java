package chr.ved.parser.core.expression.node;

import chr.ved.parser.core.expression.ExpressionNode;

public class Term {
    public final boolean positive;
    public final ExpressionNode expression;

    public Term(ExpressionNode expression) {
        this.positive = true;
        this.expression = expression;
    }

    public Term(boolean positive, ExpressionNode expression) {
        this.positive = positive;
        this.expression = expression;
    }
}
