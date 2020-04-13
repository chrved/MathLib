package chr.ved.parser.core.tokenizer.token.type;

import chr.ved.parser.core.tokenizer.token.TokenType;

public class Function extends TokenType {

    public Function() {
        super("FUNCTION", "sin|cos|tan|sqrt");;
    }
}
