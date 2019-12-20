package chr.ved.parser.core.expressionparser.regularexpression;

import chr.ved.tokenizer.core.TokenType;

public class Epsilon implements TokenType {
    private final String type;

    public Epsilon(){
        type = "EPSILON";
    }

    @Override
    public String getType() {
        return type;
    }
}