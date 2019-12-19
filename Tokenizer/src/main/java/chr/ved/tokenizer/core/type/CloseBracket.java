package chr.ved.tokenizer.core.type;

import chr.ved.tokenizer.core.TokenType;

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
