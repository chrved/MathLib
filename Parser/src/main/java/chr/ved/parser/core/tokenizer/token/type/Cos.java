package chr.ved.parser.core.tokenizer.token.type;

import chr.ved.parser.core.tokenizer.token.TokenType;

public class Cos implements TokenType {
    private final String type;
    public Cos(){
        type = "COS";
    }
    @Override
    public String getType() {
        return type;
    }
}
