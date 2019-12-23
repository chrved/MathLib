package chr.ved.parser.core.expressionparser.addsubmultdiv;

import chr.ved.parser.core.expression.ExpressionNode;
import chr.ved.parser.core.expression.node.AdditionNode;
import chr.ved.parser.core.expression.node.ConstantNode;
import chr.ved.parser.core.expression.node.DivisionNode;
import chr.ved.parser.core.expression.node.MultiplicationNode;
import chr.ved.parser.core.expressionparser.AbstractParser;
import chr.ved.parser.core.tokenizer.token.Token;
import chr.ved.parser.exception.ParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;

import static chr.ved.parser.core.expression.ExpressionNode.ExpressionNodeType.*;

public class AddSubMultDivParser extends AbstractParser {
    private static final Logger log = LoggerFactory.getLogger(AddSubMultDivParser.class);
    private static final String CONSTANT = "CONSTANT";
    private static final String EPSILON = "EPSILON";
    private static final String PLUSMINUS = "PLUSMINUS";
    private static final String MULTDIV = "MULTDIV";
    private static final String RAISED = "RAISED";
    @Override
    public ExpressionNode parseExpression(Stack<Token> tokens) {
        this.tokens = tokens;
        lookahead = tokens.pop();
        ExpressionNode expression = expression();
        if (!lookahead.getToken().equals("EPSILON")) {
            throw new ParserException("Unexpected symbol "+lookahead.getToken()+" "+lookahead.getSequence()+" found");
        }
        return expression;
    }
    private ExpressionNode expression(){
        log.debug("Enter expression(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
        ExpressionNode signedTerm = signedTerm();
        ExpressionNode sum = sumOperation(signedTerm);
        log.debug("Exit expression(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
        return sum;
    }

    private ExpressionNode sumOperation(ExpressionNode sumOp) {
        log.debug("Enter sumOperation(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
        if (PLUSMINUS.equals(lookahead.getToken())) {
            log.info("FOUND MATCH. {} {}", lookahead.getToken(), lookahead.getSequence());
            AdditionNode sum;
            if (sumOp.getType() == ADDITION_NODE)
                sum = (AdditionNode) sumOp;
            else
                sum = new AdditionNode(sumOp, true);

            boolean positive = lookahead.getSequence().equals("+");
            nextToken();
            log.debug("Got a new token. {} {}", lookahead.getToken(), lookahead.getSequence());
            ExpressionNode term = term();
            sum.add(term, positive);

            log.debug("Exit sumOperation(). With: {} {}", lookahead.getToken(), lookahead.getSequence());
            return sumOperation(sum);
        }

        log.debug("Exit sumOperation(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
        return sumOp;
    }

    private ExpressionNode term() {
        log.debug("Enter term(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
        ExpressionNode term = factor();
        ExpressionNode termOp = termOperator(term);
        return termOp;
    }

    private ExpressionNode signedTerm(){
        log.debug("Enter signedTerm(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
        if (lookahead.getToken().equals("PLUSMINUS")) {
            boolean positive = lookahead.getSequence().equals("+");
            log.info("FOUND MATCH. {} {}",lookahead.getToken(),lookahead.getSequence());

            nextToken();
            log.debug("Got a new token. {} {}",lookahead.getToken(),lookahead.getSequence());
            ExpressionNode node = term();

            if (positive) {
                log.debug("Exit signedTerm(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
                return node;
            } else {
                log.debug("Exit signedTerm(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
                return new AdditionNode(node, false);
            }
        }
        log.debug("Exit signedTerm(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
        return term();
    }

    private ExpressionNode termOperator(ExpressionNode term) {
        log.debug("Enter termOperator(). With: {} {}",lookahead.getToken(),lookahead.getSequence());

        if (MULTDIV.equals(lookahead.getToken())) {
            log.info("FOUND MATCH. {} {}", lookahead.getToken(), lookahead.getSequence());
            String type = lookahead.getSequence();
            nextToken();
            log.debug("Got a new token. {} {}", lookahead.getToken(), lookahead.getSequence());
            ExpressionNode MULTDIVterm = term();
            if (type.equals("*")) {
                MultiplicationNode mult = new MultiplicationNode(term, true);
                mult.add(MULTDIVterm, true);
                log.debug("Exit sumOperation(). With: {} {}", lookahead.getToken(), lookahead.getSequence());
                return sumOperation(mult);
            } else {
                DivisionNode div = new DivisionNode(term, true);
                log.debug("Exit sumOperation(). With: {} {}", lookahead.getToken(), lookahead.getSequence());
                div.add(MULTDIVterm, true);
                return sumOperation(div);
            }
        }
        log.debug("Exit termOperator(). With: {} {}",lookahead.getToken(),lookahead.getSequence());

        return term;
    }

    private ExpressionNode factor(){
        log.debug("Enter factor(). With: {} {}",lookahead.getToken(),lookahead.getSequence());

        ExpressionNode argument = argument();
        ExpressionNode factorOperator = factorOperator(argument);
        log.debug("Exit factor(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
        return factorOperator;
    }

    private ExpressionNode signedFactor(){
        log.debug("Enter signedFactor(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
        if (lookahead.getToken().equals("PLUSMINUS")) {
            boolean positive = lookahead.getSequence().equals("+");

            nextToken();
            log.debug("Got a new token. {} {}",lookahead.getToken(),lookahead.getSequence());
            ExpressionNode factor = factor();

            if (positive){
                return factor;
            }else{
                return new AdditionNode(factor,false);
            }
        }

        log.debug("Exit signedFactor(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
        return factor();
    }

    private ExpressionNode factorOperator(ExpressionNode factor){
        log.debug("Enter factorOperator(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
        if (RAISED.equals(lookahead.getToken())) {
            log.info("FOUND MATCH. {} {}", lookahead.getToken(), lookahead.getSequence());

            //TODO Fill in the rest...
            return null;
        }

        log.debug("Exit factorOperator(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
        return factor;

    }

    private ExpressionNode argument(){
        log.debug("Enter argument(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
        ExpressionNode value = value();
        log.debug("Exit argument(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
        return value;
    }

    private ExpressionNode value(){
        log.debug("Enter value(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
        if(lookahead.getToken().equals(CONSTANT)){
            log.info("FOUND MATCH. {} {}. Creating ConstantNode",lookahead.getToken(),lookahead.getSequence());
            ExpressionNode constantNode = new ConstantNode(lookahead.getSequence());
            nextToken();
            log.debug("Got a new token. {} {}",lookahead.getToken(),lookahead.getSequence());
            log.debug("Exit value(). With: {} {}",lookahead.getToken(),lookahead.getSequence());

            return constantNode;
        }
        if (lookahead.getToken().equals(EPSILON)){
            throw new ParserException("Unexpected end of input");
        } else {
            throw new ParserException("Unexpected symbol "+lookahead.getSequence()+" found");
        }
    }


//    ExpressionNode result = null;
//        switch (lookahead.getToken()){
//        case PLUSMINUS:
//            log.info("FOUND MATCH. {} {}",lookahead.getToken(),lookahead.getSequence());
//            boolean positive = lookahead.getSequence().equals("+");
//
//            nextToken();
//            log.debug("Got a new token. {} {}",lookahead.getToken(),lookahead.getSequence());
//
//            result = term();
//
//            log.debug("Exit term(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
//            if (!positive) {
//                result = new AdditionNode(result, false);
//            }
//
//        case CONSTANT:
//            result = factor();
//        default:
//            break;
//    }








//    private ExpressionNode expression(){
//        log.debug("Enter expression(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
//        ExpressionNode signfactor = signedFactor();
//        log.debug("Exit expression(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
//        return sumOperation(signfactor);
//    }
//    private ExpressionNode sumOperation(ExpressionNode sigTerm){
//        log.debug("Enter sumOperation(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
//        if (lookahead.getToken().equals("PLUSMINUS")){
//            log.info("FOUND MATCH. {} {}",lookahead.getToken(),lookahead.getSequence());
//            AdditionNode sum;
//            if (sigTerm.getType() == ADDITION_NODE)
//                sum = (AdditionNode)sigTerm;
//            else
//                sum = new AdditionNode(sigTerm, true);
//
//            boolean positive = lookahead.getSequence().equals("+");
//            nextToken();
//            ExpressionNode t = signedFactor();
//            sum.add(t, positive);
//
//            log.debug("Exit sumOperation(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
//            return sumOperation(sum);
//        }
//        log.debug("Exit sumOperation(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
//        return sigTerm;
//    }
//    private ExpressionNode signedFactor(){
//        log.debug("Enter signedFactor(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
//        if (lookahead.getToken().equals(PLUSMINUS)) {
//            boolean positive = lookahead.getSequence().equals("+");
//            nextToken();
//            log.debug("Got a new token. {} {}",lookahead.getToken(),lookahead.getSequence());
//            ExpressionNode factor = factor();
//
//            if (positive) {
//                log.debug("Exit signedFactor(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
//                return factor;
//            } else {
//                log.debug("Exit signedFactor(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
//                return new AdditionNode(factor, false);
//            }
//        }
//        log.debug("Exit signedFactor(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
//        return factor();
//    }
//    private ExpressionNode factor(){
//        log.debug("Enter factor(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
//
//        ExpressionNode argument = argument();
//        //ExpressionNode facOpr = factorOperator(argument);
//        log.debug("Exit factor(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
//        return argument;
//    }
//
//
//    private ExpressionNode argument(){
//        log.debug("Enter argument(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
//        ExpressionNode value = value();
//        log.debug("Exit argument(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
//        return value;
//    }
//    private ExpressionNode value(){
//        log.debug("Enter value(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
//        if(lookahead.getToken().equals(CONSTANT)){
//            log.info("FOUND MATCH. {} {}. Creating ConstantNode",lookahead.getToken(),lookahead.getSequence());
//            ExpressionNode constantNode = new ConstantNode(lookahead.getSequence());
//            nextToken();
//            log.debug("Got a new token. {} {}",lookahead.getToken(),lookahead.getSequence());
//            log.debug("Exit value(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
//
//            return constantNode;
//        }
//        if (lookahead.getToken().equals(EPSILON)){
//            throw new ParserException("Unexpected end of input");
//        } else {
//            throw new ParserException("Unexpected symbol "+lookahead.getSequence()+" found");
//        }
//    }
//


//    private ExpressionNode signedTerm(){
//        log.debug("Enter signedTerm(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
//        if (lookahead.getToken().equals("PLUSMINUS")) {
//            log.info("FOUND MATCH. {} {}",lookahead.getToken(),lookahead.getSequence());
//            boolean positive = lookahead.getSequence().equals("+");
//
//            nextToken();
//            log.debug("Got a new token. {} {}",lookahead.getToken(),lookahead.getSequence());
//            ExpressionNode termNode = term();
//
//            if (positive) {
//                log.debug("Exit signedTerm(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
//                return termNode;
//            } else {
//                log.debug("Exit signedTerm(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
//                return new AdditionNode(termNode, false);
//            }
//        }
//        return term();
//    }
//    private ExpressionNode term(){
//        log.debug("Enter term(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
//        ExpressionNode signFactor = signedFactor();
//        log.debug("Exit term(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
//        return signFactor;
//    }
//
//    private ExpressionNode factorOperator(ExpressionNode arg){
//        log.debug("Enter factorOperator(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
//        if(lookahead.getToken().equals(PLUSMINUS)){
//            log.info("FOUND MATCH. {} {}",lookahead.getToken(),lookahead.getSequence());
//            // signed_factor -> PLUSMINUS factor
//            boolean positive = lookahead.getSequence().equals("+");
//
//            nextToken();
//            log.debug("Got a new token. {} {}",lookahead.getToken(),lookahead.getSequence());
//            ExpressionNode expr = factor();
//
//            if (positive){
//                log.info("Exit signedFactor().");
//                return expr;
//            }else{
//                log.info("Exit signedFactor().");
//                return new AdditionNode(expr,false);
//            }
//        }
//
//        log.debug("Exit factorOperator(). With: {} {}",lookahead.getToken(),lookahead.getSequence());
//        return arg;
//    }

//


}
