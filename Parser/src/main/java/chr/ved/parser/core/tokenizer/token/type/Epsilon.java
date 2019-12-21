package chr.ved.parser.core.tokenizer.token.type;

import chr.ved.parser.core.tokenizer.token.TokenType;

public class Epsilon implements TokenType {
    private final String type;
    public Epsilon(){
        type = "EPSILON";
    }
    @Override
    public String getType() {
        return type;
    }
}
