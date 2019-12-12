package chr.ved.core.exception;

public class UnsolvableException extends RuntimeException{
    public UnsolvableException(String msg){
        super(msg);
    }
    public UnsolvableException(String msg, Throwable err){
        super(msg, err);
    }
}
