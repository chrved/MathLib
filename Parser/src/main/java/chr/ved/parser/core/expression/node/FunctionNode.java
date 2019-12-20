package chr.ved.parser.core.expression.node;

import chr.ved.parser.core.ExpressionNode;
import chr.ved.parser.exception.EvaluationException;
import chr.ved.parser.exception.ParserException;

public class FunctionNode implements ExpressionNode {
    public enum FunctionType{
        SIN,
        COS,
        TAN,
        ASIN,
        ACOS,
        ATAN,
        SQRT,
        EXP,
        LN,
        LOG,
        LOG2
    }

    private FunctionType function;
    private ExpressionNode argument;

    public FunctionNode(FunctionType function, ExpressionNode argument) {
        this.function = function;
        this.argument = argument;
    }

    @Override
    public ExpressionNodeType getType() {
        return ExpressionNodeType.FUNCTION_NODE;
    }

    @Override
    public double getValue() {

        switch (function) {
            case SIN:  return Math.sin(argument.getValue());
            case COS:  return Math.cos(argument.getValue());
            case TAN:  return Math.tan(argument.getValue());
            case ASIN: return Math.asin(argument.getValue());
            case ACOS: return Math.acos(argument.getValue());
            case ATAN: return Math.atan(argument.getValue());
            case SQRT:
                if (argument.getValue() < 0.0) throw new EvaluationException("Cant sqrt value: "+argument.getValue());
                return Math.sqrt(argument.getValue());
            case EXP:  return Math.exp(argument.getValue());
            case LN:   return Math.log(argument.getValue());
            case LOG:  return Math.log(argument.getValue())
                    * 0.43429448190325182765;
            case LOG2: return Math.log(argument.getValue())
                    * 1.442695040888963407360;
            default:
                throw new EvaluationException("Invalid function id "+function+"!");
        }
    }
    public static FunctionType stringToFunction(String str) {
        if (str.equals("sin")) return FunctionType.SIN;
        if (str.equals("cos")) return FunctionType.COS;
        if (str.equals("tan")) return FunctionType.TAN;

        if (str.equals("asin")) return FunctionType.ASIN;
        if (str.equals("acos")) return FunctionType.ACOS;
        if (str.equals("atan")) return FunctionType.ATAN;

        if (str.equals("sqrt")) return FunctionType.SQRT;
        if (str.equals("exp")) return FunctionType.EXP;

        if (str.equals("ln")) return FunctionType.LN;
        if (str.equals("log"))return FunctionType.LOG;
        if (str.equals("log2")) return FunctionType.LOG2;

        throw new ParserException("Unexpected Function "+str+" found!");
    }

    public static String getAllFunctions() {
        return "sin|cos|tan|asin|acos|atan|sqrt|exp|ln|log|log2";
    }
}
