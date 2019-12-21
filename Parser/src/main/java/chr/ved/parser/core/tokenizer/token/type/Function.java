package chr.ved.parser.core.tokenizer.token.type;

import chr.ved.parser.core.tokenizer.token.TokenType;

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
