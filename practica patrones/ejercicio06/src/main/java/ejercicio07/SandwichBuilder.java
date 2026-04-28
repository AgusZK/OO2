package ejercicio07;

public abstract class SandwichBuilder {
    private Sandwich sandwich;

    // Armo el reset para armar un builder de 0
    public void reset(){
        this.sandwich = new Sandwich();
    }

    public abstract void armarPan();
    public abstract void armarPrincipal();
    public abstract void armarAderezo();
    public abstract void armarAdicional();

    public Sandwich getSandwich() {
        return sandwich;
    }
}
