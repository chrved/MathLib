package chr.ved.parser.core.tokenizer.token.type;

import chr.ved.parser.core.tokenizer.token.TokenType;

public class CloseBracket implements TokenType {
    private final String type;
    public CloseBracket(){
        type = "CLOSE_BRACKET";
    }
    @Override
    public String getType() {
        return type;
    }
}
