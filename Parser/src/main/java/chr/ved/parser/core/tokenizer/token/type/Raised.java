package chr.ved.parser.core.tokenizer.token.type;

import chr.ved.parser.core.tokenizer.token.TokenType;

public class Raised implements TokenType {
    private final String type;
    public Raised(){
        type = "RAISED";
    }
    @Override
    public String getType() {
        return type;
    }
}
