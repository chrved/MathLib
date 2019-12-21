package chr.ved.parser.core.tokenizer;


import chr.ved.parser.core.tokenizer.token.Token;
import chr.ved.parser.core.tokenizer.token.TokenMatcher;
import chr.ved.parser.core.tokenizer.token.TokenType;
import chr.ved.parser.core.tokenizer.token.type.*;
import chr.ved.parser.exception.TokenizerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {
    private static Logger log = LoggerFactory.getLogger(Tokenizer.class);
    private List<TokenMatcher> tokenMatcher;
    private List<Token> tokens;

    public Tokenizer() {
        tokenMatcher = new ArrayList<>();
        tokens = new ArrayList<>();
        setupTokens();
    }

    private void setupTokens() {
        addTokenType("\\s", new WhiteSpace()); // Normal whitespace
        addTokenType("sin|cos|tan|sqrt", new Function()); // function
        addTokenType("\\(", new OpenBracket()); // open bracket
        addTokenType("\\)", new CloseBracket()); // close bracket
        addTokenType("[+-]", new PlusMinus()); // plus or minus
        addTokenType("[*/]", new MultDiv()); // mult or divide
        addTokenType("\\^", new Raised()); // raised
        addTokenType("[0-9]+", new Constant()); // integer number
        addTokenType("[a-zA-Z][a-zA-Z0-9_]*", new Variable()); // variable
    }

    public void tokenize(String input) {
        input = input.trim();
        tokens.clear();

        while (!input.equals("")){
            boolean foundMatch = false;
            for (TokenMatcher tokenMatcher : tokenMatcher) {
                Matcher match = tokenMatcher.getRegex().matcher(input);
                if (match.find()) {
                    foundMatch = true;

                    String tok = match.group().trim();
                    if(!tok.isEmpty()){
                        log.info("Found token: {} with value: {}", tokenMatcher.getToken().getType(), tok);
                        tokens.add(new Token(tokenMatcher.getToken(), tok));
                    }

                    input = match.replaceFirst("");
                    break;
                }
            }
            if (!foundMatch){
                throw new TokenizerException("Unexpected character in input: "+input);
            }
        }
    }

    public void addTokenType(String regex, TokenType token) {
        tokenMatcher.add(new TokenMatcher(Pattern.compile("^("+regex+")"), token));
    }

    public List<Token> getTokens() {
        return tokens;
    }
    public void reverseToken() { Collections.reverse(tokens); }

    @Override
    public String toString(){
        if(tokens.isEmpty()) return "[EMPTY]";
        String result = "[";
        for (Token token : tokens) {
            result += token.getToken()+":"+"\""+token.getSequence()+"\""+", ";
        }
        result = result.substring(0, result.length() - 2);
        result += "]";
        return result;
    }
}
