package chr.ved.tokenizer;

import chr.ved.tokenizer.core.Token;
import chr.ved.tokenizer.core.TokenMatcher;
import chr.ved.tokenizer.core.TokenType;
import chr.ved.tokenizer.exception.TokenizerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
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
}
