package ejercicio07;

public class ClienteSubteWay {
    private SandwichBuilder builder;

    public ClienteSubteWay (SandwichBuilder builder){
        this.builder = builder;
    }

    public void setBuilder(SandwichBuilder builder) {
        this.builder = builder;
    }

    public SandwichBuilder getBuilder() {
        return builder;
    }

    public Sandwich armarSandwich(){
        this.builder.reset();
        this.builder.armarPan();
        this.builder.armarAderezo();
        this.builder.armarPrincipal();
        this.builder.armarAdicional();

        return this.builder.getSandwich();
    }
}
