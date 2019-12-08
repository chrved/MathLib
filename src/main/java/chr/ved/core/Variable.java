package chr.ved.core;

public class Variable<T> {
    private String name;
    private Constant<T> value;
    private Exponent<Double> exponent;
    public Variable(String name){
        this.name = name;
        this.exponent = new Exponent<>(1d);
    }
    public Variable(String name, Double exponent){
        this.name = name;
        this.exponent = new Exponent<>(exponent);
    }

    public void setValue(T value){
        this.value = new Constant<>(value);
    }
    public T getValue(){
        return this.value != null ? this.value.getValue() : null;
    }
    public String getName(){ return this.name; }
    public Double getExponent(){ return this.exponent.getValue(); }
}
