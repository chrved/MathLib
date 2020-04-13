package chr.ved.parser.core.tokenizer.token;

import java.util.regex.Pattern;

public abstract class TokenType {
    private final String type;
    private final String regex_str;
    private final Pattern regex;
    protected TokenType(String type, String regex){
        this.type = type;
        this.regex_str = regex;
        this.regex = Pattern.compile("^("+regex+")");
    }
    public String getType() { return type;}
    public Pattern getRegex() { return regex;}
}
