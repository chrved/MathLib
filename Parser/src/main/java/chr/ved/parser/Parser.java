package chr.ved.parser;


import chr.ved.parser.core.ExpressionNode;
import chr.ved.parser.core.expressionparser.ExpressionParser;
import chr.ved.parser.core.tokenizer.Tokenizer;
import chr.ved.parser.core.tokenizer.token.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.Stack;


public class Parser {
    private static Logger log = LoggerFactory.getLogger(Parser.class);

    private Stack<Token> tokens = new Stack<>();
    private Token lookahead;
    private final Tokenizer tokenizer;
    private final ExpressionParser expressionParser;

    public Parser(Tokenizer tokenizer, ExpressionParser expressionParser){
        this.tokenizer = tokenizer;
        this.expressionParser = expressionParser;
    }

    public ExpressionNode parse(String strToParse){
        log.info("Start parsing: {}",strToParse);
        tokenizeString(strToParse);

        return expressionParser.parseExpression(tokens);
    }

    private void tokenizeString(String str){
        this.tokens.clear();
        tokenizer.tokenize(str);
        List<Token> tmpToken = tokenizer.getTokens();
        Collections.reverse(tmpToken);
        this.tokens.addAll(tmpToken);
        log.info("Tokens after tokenize: {}",tokens.toString());
    }

}
