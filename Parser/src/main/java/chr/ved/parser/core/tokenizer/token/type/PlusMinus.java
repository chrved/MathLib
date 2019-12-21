package chr.ved.parser.core.tokenizer.token.type;

import chr.ved.parser.core.tokenizer.token.TokenType;

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
