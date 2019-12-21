package chr.ved.parser.core.tokenizer.token.type;

import chr.ved.parser.core.tokenizer.token.TokenType;

public class Tan implements TokenType {
    private final String type;
    public Tan(){
        type = "TAN";
    }
    @Override
    public String getType() {
        return type;
    }
}
