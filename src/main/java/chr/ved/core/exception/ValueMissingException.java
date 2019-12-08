package chr.ved.core.exception;

public class ValueMissingException extends RuntimeException{
    public ValueMissingException(String msg){
        super(msg);
    }
    public ValueMissingException(String msg, Throwable err){
        super(msg, err);
    }
}
