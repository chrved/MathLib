package chr.ved.tokenizer.core.type;

import chr.ved.tokenizer.core.TokenType;

public class Function implements TokenType {
    private final String type;

    public Function() {
        type = "FUNCTION";
    }

    @Override
    public String getType() {
        return type;
    }
}
