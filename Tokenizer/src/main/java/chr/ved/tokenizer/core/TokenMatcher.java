package chr.ved.tokenizer.core;

import lombok.Getter;

import java.util.regex.Pattern;

@Getter
public class TokenMatcher {
    private final Pattern regex;
    private final TokenType token;

    public TokenMatcher(Pattern regex, TokenType token) {
        this.regex = regex;
        this.token = token;
    }
}
