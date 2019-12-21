package chr.ved.parser.core.tokenizer.token.type;

import chr.ved.parser.core.tokenizer.token.TokenType;

public class Constant implements TokenType {
    private final String type;
    public Constant(){
        type = "CONSTANT";
    }
    @Override
    public String getType() {
        return type;
    }
}
