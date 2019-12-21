package chr.ved.parser.core.tokenizer.token.type;

import chr.ved.parser.core.tokenizer.token.TokenType;

public class OpenBracket implements TokenType {
    private final String type;
    public OpenBracket(){
        type = "OPEN_BRACKET";
    }
    @Override
    public String getType() {
        return type;
    }
}
