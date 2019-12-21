package chr.ved.parser.core.tokenizer.token.type;

import chr.ved.parser.core.tokenizer.token.TokenType;

public class Variable implements TokenType {
    private final String type;
    public Variable(){
        type = "VARIABLE";
    }
    @Override
    public String getType() {
        return type;
    }

}
