package chr.ved.parser;


import chr.ved.tokenizer.Tokenizer;
import chr.ved.tokenizer.core.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.Stack;


public class Parser {
    private static Logger log = LoggerFactory.getLogger(Parser.class);

    private Stack<Token> tokens = new Stack<>();
    private Token lookahead;
    private Tokenizer tokenizer;

    public Parser(Tokenizer tokenizer){
        this.tokenizer = tokenizer;
    }

    public void parse(String strToParse){
        log.info("Start parsing: {}",strToParse);
        tokenizeString(strToParse);
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
