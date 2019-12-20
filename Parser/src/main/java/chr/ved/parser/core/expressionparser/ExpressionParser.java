package chr.ved.parser.core.expressionparser;

import chr.ved.parser.core.ExpressionNode;
import chr.ved.tokenizer.core.Token;

import java.util.Stack;

public interface ExpressionParser {
    ExpressionNode parseExpression(Stack<Token> tokens);
}
