package chr.ved.parser.core.expressionparser;

import chr.ved.parser.core.tokenizer.token.Token;
import chr.ved.parser.core.tokenizer.token.type.Epsilon;

import java.util.Stack;

public abstract class AbstractParser implements ExpressionParser{
    protected Stack<Token> tokens;
    protected Token lookahead;

    protected void nextToken(){

        if (tokens.isEmpty()){
//            lookahead = new Token(new Epsilon(), "EPSILON");
        } else {
            lookahead = tokens.pop();
        }
    }
}
