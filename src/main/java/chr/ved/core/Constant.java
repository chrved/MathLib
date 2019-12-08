package chr.ved.core;


public class Constant<T> {
    private T value;
    private Exponent exponent;

    public Constant(T value){
        this.value = value;
        this.exponent = new Exponent<>(1d);
    }
    public Constant(T value, Exponent exponent){
        this.value = value;
        this.exponent = exponent;
    }

    public T getValue(){
        return this.value;
    }
    public Exponent getExponent(){
        return this.exponent;
    }
}
