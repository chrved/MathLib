package chr.ved.tokenizer.core;


public class Token {
    private final TokenType token;
    private final String sequence;

    public Token(TokenType token, String sequence) {
        this.token = token;
        this.sequence = sequence;
    }

    public String getSequence(){
        return this.sequence;
    }
    public String getToken(){
        return this.token.getType();
    }

    @Override
    public String toString(){
        return getToken()+":"+getSequence();
    }
}
