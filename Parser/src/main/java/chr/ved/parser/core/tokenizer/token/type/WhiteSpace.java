package chr.ved.parser.core.tokenizer.token.type;

import chr.ved.parser.core.tokenizer.token.TokenType;

public class WhiteSpace implements TokenType {
    private final String type;
    public WhiteSpace(){
        type = "WHITESPACE";
    }
    @Override
    public String getType() {
        return type;
    }
}
