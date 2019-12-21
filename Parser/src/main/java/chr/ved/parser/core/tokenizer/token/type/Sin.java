package chr.ved.parser.core.tokenizer.token.type;

import chr.ved.parser.core.tokenizer.token.TokenType;

public class Sin implements TokenType {
    private final String type;
    public Sin(){
        type = "SIN";
    }
    @Override
    public String getType() {
        return type;
    }
}
