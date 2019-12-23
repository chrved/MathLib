package chr.ved.parser.core.expressionparser.regularexpression;

import chr.ved.parser.core.expression.ExpressionNode;
import chr.ved.parser.core.expression.node.*;
import chr.ved.parser.core.expressionparser.AbstractParser;
import chr.ved.parser.core.tokenizer.token.Token;
import chr.ved.parser.exception.ParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;

import static chr.ved.parser.core.expression.ExpressionNode.ExpressionNodeType.ADDITION_NODE;
import static chr.ved.parser.core.expression.ExpressionNode.ExpressionNodeType.MULTIPLICATION_NODE;

public class RegularExpression extends AbstractParser {
    private static Logger log = LoggerFactory.getLogger(RegularExpression.class);

    @Override
    public ExpressionNode parseExpression(Stack<Token> tokens) {
        ExpressionNode expr = expression();

        if (!lookahead.getToken().equals("EPSILON")) {
            throw new ParserException("Unexpected symbol "+lookahead.getToken()+" "+lookahead.getSequence()+" found");
        }
        return expr;
    }

    private ExpressionNode expression() {
        //expression -> signed_term sum_operation
        log.info("Enter expression(). {} {}",lookahead.getToken(),lookahead.getSequence());
        ExpressionNode sigTerm = signedTerm();
        ExpressionNode sumOp = sumOperation(sigTerm);
        log.info("Exit expression().");
        return sumOp;
    }

    private ExpressionNode signedTerm() {
//        signed_term -> PLUSMINUS term
        log.info("Enter signedTerm(). {} {}",lookahead.getToken(),lookahead.getSequence());
        if (lookahead.getToken().equals("PLUSMINUS")) {
            boolean positive = lookahead.getSequence().equals("+");
            log.info("FOUND MATCH. {} {}",lookahead.getToken(),lookahead.getSequence());

            nextToken();
            ExpressionNode node = term();

            if (positive) {
                log.info("Exit signedTerm().");
                return node;
            } else {
                log.info("Exit signedTerm().");
                return new AdditionNode(node, false);
            }
        }
        log.info("Exit signedTerm().");
//        signed_term -> term
        return term();

    }

    private ExpressionNode term() {
        log.info("Enter term(). {} {}",lookahead.getToken(),lookahead.getSequence());
        ExpressionNode f = factor();
        ExpressionNode termOp = termOperator(f);
        log.info("Exit term().");
        return termOp;
    }

    private ExpressionNode termOperator(ExpressionNode factor) {
        //term_op -> MULTDIV signed_factor term_op
        log.info("Enter termOperator(). {} {}",lookahead.getToken(),lookahead.getSequence());
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
            log.info("Exit termOperator().");
            return termOperator(prod);
        }
        // term_op -> EPSILON
        log.info("Exit termOperator().");
        return factor;    }

    private ExpressionNode factor() {
        log.info("Enter factor(). {} {}",lookahead.getToken(),lookahead.getSequence());
        ExpressionNode expr = argument();
        ExpressionNode facOp = factorOperator(expr);
        log.info("Exit factor().");
        return facOp;
    }

    private ExpressionNode factorOperator(ExpressionNode expr) {
        log.info("Enter factorOperator(). {} {}",lookahead.getToken(),lookahead.getSequence());
        if (lookahead.getToken().equals("POW")) {
            log.info("FOUND MATCH. {} {}",lookahead.getToken(),lookahead.getSequence());
            // factor_op -> RAISED expression
            nextToken();
            ExpressionNode exponent = signedFactor();
            log.info("Exit factorOperator().");
            return new ExponentiationNode(expr,exponent);
        }
        log.info("Exit factorOperator().");
        return expr;
    }

    private ExpressionNode signedFactor() {
        log.info("Enter signedFactor(). {} {}",lookahead.getToken(),lookahead.getSequence());
        if (lookahead.getToken().equals("PLUSMINUS")) {
            log.info("FOUND MATCH. {} {}",lookahead.getToken(),lookahead.getSequence());
            // signed_factor -> PLUSMINUS factor
            boolean positive = lookahead.getSequence().equals("+");

            nextToken();

            ExpressionNode expr = factor();

            if (positive){
                log.info("Exit signedFactor().");
                return expr;
            }else{
                log.info("Exit signedFactor().");
                return new AdditionNode(expr,false);
            }
        }
        // signed_factor -> factor
        log.info("Exit signedFactor().");
        return factor();
    }

    private ExpressionNode argument() {
        log.info("Enter argument(). {} {}",lookahead.getToken(),lookahead.getSequence());
        if (lookahead.getToken().equals("FUNCTION")) {
            // argument -> FUNCTION argument
            log.info("FOUND MATCH. {} {}. Creating FunctionNode ",lookahead.getToken(),lookahead.getSequence());

            FunctionNode.FunctionType type = FunctionNode.stringToFunction(lookahead.getSequence());

            nextToken();

            ExpressionNode expr = argument();
            log.info("Exit argument().");
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
            log.info("Exit argument().");
            return expr;
        }
        // argument -> value
        log.info("Exit argument().");
        return value();

    }

    private ExpressionNode value() {
        log.info("Enter value(). {} {}",lookahead.getToken(),lookahead.getSequence());
        if (lookahead.getToken().equals("NUMBER")) {
            log.info("FOUND MATCH. {} {}. Creating ConstantNode",lookahead.getToken(),lookahead.getSequence());
            ExpressionNode expr = new ConstantNode(lookahead.getSequence());
            // argument -> NUMBER
            nextToken();
            log.info("Exit value().");
            return expr;
        }
        if (lookahead.getToken().equals("VARIABLE")) {
            log.info("FOUND MATCH. {} {}. Creating VariableNode",lookahead.getToken(),lookahead.getSequence());
            ExpressionNode expr = new VariableNode(lookahead.getSequence());
            // argument -> VARIABLE
            log.info("Exit value().");
            nextToken();
            return expr;
        }if (lookahead.getToken().equals("EPSILON")){
            throw new ParserException("Unexpected end of input");
        } else {
            throw new ParserException("Unexpected symbol "+lookahead.getSequence()+" found");
        }
    }

    private ExpressionNode sumOperation(ExpressionNode sigTerm) {
//        sum_operation -> PLUSMINUS term sum_op
//        sum_operation -> EPSILON
        log.info("Enter sumOperation(). {} {}",lookahead.getToken(),lookahead.getSequence());
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

            log.info("Exit sumOperation().");
            return sumOperation(sum);
        }
        //sum_op -> EPSILON
        log.info("Exit sumOperation().");
        return sigTerm;
    }

//    private void nextToken(){
//
//        if (tokens.isEmpty()){
//            lookahead = new Token(new Epsilon(), "EPSILON");
//        } else {
//            lookahead = tokens.pop();
//        }
//        log.info("Got a new token. {} {}",lookahead.getToken(),lookahead.getSequence());
//    }
}
