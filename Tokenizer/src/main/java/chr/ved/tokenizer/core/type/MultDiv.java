package chr.ved.tokenizer.core.type;

import chr.ved.tokenizer.core.TokenType;

public class MultDiv implements TokenType {
    private final String type;
    public MultDiv(){
        type = "MULTDIV";
    }
    @Override
    public String getType() {
        return type;
    }
}
