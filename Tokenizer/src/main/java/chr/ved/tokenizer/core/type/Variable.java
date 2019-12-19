package chr.ved.tokenizer.core.type;

import chr.ved.tokenizer.core.TokenType;

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
