package chr.ved.tokenizer.core.type;

import chr.ved.tokenizer.core.TokenType;

public class Number implements TokenType {
    private final String type;
    public Number(){
        type = "NUMBER";
    }
    @Override
    public String getType() {
        return type;
    }
}
