package chr.ved.parser.core.tokenizer.token.type;

import chr.ved.parser.core.tokenizer.token.TokenType;

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
