package chr.ved.core;


public class Exponent<T>{
    private Constant<T> value;
    public Exponent(T value) {
        this.value = new Constant<>(value);
    }

    public T getValue(){
        return this.value.getValue();
    }
}
