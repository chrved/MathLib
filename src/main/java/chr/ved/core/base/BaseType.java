package chr.ved.core.base;

public interface BaseType {
    enum Type{
        VARIABLE, CONSTANT
    }
    Type getType();
    Double solve();
    Double getValue();
}
