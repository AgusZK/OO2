package ejercicio04;

public class Hoja implements Topografia{
    public double agua;

    public Hoja (double agua){
        this.agua = agua;
    }

    @Override
    public double getProporcion() {
        return this.agua;
    }

    @Override
    public boolean equals(Object t) {
        return ((Topografia)t).getProporcion() == this.getProporcion();
    }

    @Override
    // Una hoja nunca va a ser igual a una mixta
    public boolean esIgualMixta(Mixta t) {
        return false;
    }
}
