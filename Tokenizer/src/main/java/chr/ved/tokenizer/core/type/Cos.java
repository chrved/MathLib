package chr.ved.tokenizer.core.type;

import chr.ved.tokenizer.core.TokenType;

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
