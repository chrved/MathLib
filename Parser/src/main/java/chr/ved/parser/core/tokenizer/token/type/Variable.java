package chr.ved.parser.core.tokenizer.token.type;

import chr.ved.parser.core.tokenizer.token.TokenType;

public class Variable extends TokenType {
    public Variable(){
        super("VARIABLE", "[a-zA-Z][a-zA-Z0-9_]*");
    }

}
