package chr.ved.tokenizer.core.type;

import chr.ved.tokenizer.core.TokenType;

public class Pow implements TokenType {
    private final String type;
    public Pow(){
        type = "POW";
    }
    @Override
    public String getType() {
        return type;
    }
}
