package chr.ved.parser.core.expressionparser.regularexpression;

import chr.ved.parser.core.ExpressionNode;
import chr.ved.parser.core.expression.node.*;
import chr.ved.parser.core.expressionparser.ExpressionParser;
import chr.ved.parser.exception.ParserException;
import chr.ved.tokenizer.core.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;

import static chr.ved.parser.core.ExpressionNode.ExpressionNodeType.ADDITION_NODE;
import static chr.ved.parser.core.ExpressionNode.ExpressionNodeType.MULTIPLICATION_NODE;

public class RegularExpression implements ExpressionParser {
    private static Logger log = LoggerFactory.getLogger(RegularExpression.class);
    private Stack<Token> tokens;
    private Token lookahead;

    @Override
    public ExpressionNode parseExpression(Stack<Token> tokens) {
        this.tokens = tokens;

        lookahead = tokens.pop();

        ExpressionNode expr = expression();

        if (!"EPSILON".equals(lookahead.getToken())) {
            throw new ParserException("Unexpected symbol "+lookahead.getToken()+" "+lookahead.getSequence()+" found");
        }

        return expr;
    }

    private ExpressionNode expression() {
        //expression -> signed_term sum_operation
        ExpressionNode sigTerm = signedTerm();
        ExpressionNode sumOp = sumOperation(sigTerm);
        return sumOp;
    }

    private ExpressionNode signedTerm() {
//        signed_term -> PLUSMINUS term

        if (lookahead.getToken().equals("PLUSMINUS")) {
            boolean positive = lookahead.getSequence().equals("+");
            log.info("FOUND MATCH. {} {}",lookahead.getToken(),lookahead.getSequence());

            nextToken();
            ExpressionNode node = term();

            if (positive)
                return node;
            else
                return new AdditionNode(node, false);
        }
//        signed_term -> term
        return term();

    }

    private ExpressionNode term() {
        ExpressionNode f = factor();
        ExpressionNode termOp = termOperator(f);
        return termOp;
    }

    private ExpressionNode termOperator(ExpressionNode factor) {
        //term_op -> MULTDIV signed_factor term_op
        if(lookahead.getToken().equals("MULTDIV")){
            MultiplicationNode prod;
            log.info("FOUND MATCH. {} {}",lookahead.getToken(),lookahead.getSequence());
            if (factor.getType() == MULTIPLICATION_NODE)
                prod = (MultiplicationNode)factor;
            else
                prod = new MultiplicationNode(factor, true);

            boolean positive = lookahead.getSequence().equals("*");
            nextToken();
            ExpressionNode f = signedFactor();
            prod.add(f, positive);

            return termOperator(prod);
        }
        // term_op -> EPSILON
        return factor;    }

    private ExpressionNode factor() {
        ExpressionNode expr = argument();
        ExpressionNode facOp = factorOperator(expr);
        return facOp;
    }

    private ExpressionNode factorOperator(ExpressionNode expr) {
        if (lookahead.getToken().equals("RAISED")) {
            log.info("FOUND MATCH. {} {}",lookahead.getToken(),lookahead.getSequence());
            // factor_op -> RAISED expression
            nextToken();
            ExpressionNode exponent = signedFactor();
            return new ExponentiationNode(expr,exponent);
        }
        return expr;
    }

    private ExpressionNode signedFactor() {
        return null;
    }

    private ExpressionNode argument() {
        if (lookahead.getToken().equals("FUNCTION")) {
            // argument -> FUNCTION argument
            log.info("FOUND MATCH. {} {}. Creating ConstantNode",lookahead.getToken(),lookahead.getSequence());

            FunctionNode.FunctionType type = FunctionNode.stringToFunction(lookahead.getSequence());

            nextToken();

            ExpressionNode expr = argument();
            return new FunctionNode(type, expr);

        } else if (lookahead.getToken().equals("OPEN_BRACKET")) {
            // argument -> OPEN_BRACKET sum CLOSE_BRACKET
            log.info("FOUND MATCH. {} {}",lookahead.getToken(),lookahead.getSequence());
            nextToken();

            ExpressionNode expr = expression();

            if (!lookahead.getToken().equals("CLOSE_BRACKET")) {
                throw new ParserException("Closing brackets expected and " + lookahead.getSequence() + " found instead");
            }

            nextToken();
            return expr;
        }
        // argument -> value
        return value();

    }

    private ExpressionNode value() {
        if (lookahead.getToken().equals("NUMBER")) {
            log.info("FOUND MATCH. {} {}. Creating ConstantNode",lookahead.getToken(),lookahead.getSequence());
            ExpressionNode expr = new ConstantNode(lookahead.getSequence());
            // argument -> NUMBER
            nextToken();
            return expr;
        }
        if (lookahead.getToken().equals("VARIABLE")) {
            log.info("FOUND MATCH. {} {}. Creating VariableNode",lookahead.getToken(),lookahead.getSequence());
            ExpressionNode expr = new VariableNode(lookahead.getSequence());
            // argument -> VARIABLE
            nextToken();
            return expr;
        }if (lookahead.getToken().equals("EPSILON")){
            throw new ParserException("Unexpected end of input");
        } else {
            throw new ParserException("Unexpected symbol "+lookahead.getSequence()+" found");
        }    }

    private ExpressionNode sumOperation(ExpressionNode sigTerm) {
//        sum_operation -> PLUSMINUS term sum_op
//        sum_operation -> EPSILON
        if (lookahead.getToken().equals("PLUSMINUS")){
            log.info("FOUND MATCH. {} {}",lookahead.getToken(),lookahead.getSequence());
            //sum_op -> PLUSMINUS term sum_op
            AdditionNode sum;
            if (sigTerm.getType() == ADDITION_NODE)
                sum = (AdditionNode)sigTerm;
            else
                sum = new AdditionNode(sigTerm, true);

            boolean positive = lookahead.getSequence().equals("+");
            nextToken();
            ExpressionNode t = term();
            sum.add(t, positive);

            return sumOperation(sum);
        }
        //sum_op -> EPSILON
        return sigTerm;
    }

    private void nextToken(){

        if (tokens.isEmpty()){
            lookahead = new Token(new Epsilon(), "EPSILON");
        } else {
            lookahead = tokens.pop();
        }
        log.info("Got a new token. {} {}",lookahead.getToken(),lookahead.getSequence());
    }
}
