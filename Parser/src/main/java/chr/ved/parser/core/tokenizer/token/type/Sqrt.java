package chr.ved.parser.core.tokenizer.token.type;

import chr.ved.parser.core.tokenizer.token.TokenType;

public class Sqrt implements TokenType {
    private final String type;
    public Sqrt(){
        type = "SQRT";
    }
    @Override
    public String getType() {
        return type;
    }
}
