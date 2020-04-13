package chr.ved.parser.core.tokenizer.token.type;

import chr.ved.parser.core.tokenizer.token.TokenType;

public class Constant extends TokenType {
    public Constant(){
        super("CONSTANT", "([0-9]+)(\\.([0-9]+))?");
    }

}
