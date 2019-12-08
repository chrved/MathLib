package chr.ved.core;

public class Term {
    public enum Operator {
        PLUS, MINUS, DIV, MULT
    }
    private Operator operator;
    private Constant cofficient;
    private Constant constant;
    private Exponent exponent;
    private Variable variable;

    public Term(Constant constant){
        this.constant = constant;
        operator = Operator.PLUS;
    }
    public Term(Constant constant, Operator operator){
        this.constant = constant;
        this.operator = operator;
    }

    public Term(Constant constant, boolean negative){
        exponent = new Exponent(1d);
        this.constant = constant;
    }
}
