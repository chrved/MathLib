package chr.ved.tokenizer.core.type;

import chr.ved.tokenizer.core.TokenType;

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
