package chr.ved.tokenizer.core.type;

import chr.ved.tokenizer.core.TokenType;

public class PlusMinus implements TokenType {
    private final String type;
    public PlusMinus(){
        type = "PLUSMINUS";
    }
    @Override
    public String getType() {
        return type;
    }
}
