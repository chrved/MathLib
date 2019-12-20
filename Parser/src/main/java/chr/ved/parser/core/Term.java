package chr.ved.parser.core;

public class Term {
    public boolean positive;
    public ExpressionNode expression;

    public Term(ExpressionNode expression) {
        this.positive = true;
        this.expression = expression;
    }

    public Term(boolean positive, ExpressionNode expression) {
        this.positive = positive;
        this.expression = expression;
    }
}
