package chr.ved.tokenizer.core.type;

import chr.ved.tokenizer.core.TokenType;

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
