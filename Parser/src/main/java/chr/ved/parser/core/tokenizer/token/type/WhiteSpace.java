package chr.ved.parser.core.tokenizer.token.type;

import chr.ved.parser.core.tokenizer.token.TokenType;

public class WhiteSpace extends TokenType {

    public WhiteSpace(){
        super("WHITESPACE", "\\s");
    }
}
