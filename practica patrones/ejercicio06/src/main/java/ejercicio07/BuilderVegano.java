package ejercicio07;

public class BuilderVegano extends SandwichBuilder{
    @Override
    public void armarPan() {
        this.getSandwich().setPan("Integral");
        this.getSandwich().setPrecioPan(100);
    }

    @Override
    public void armarAderezo() {
        this.getSandwich().setAderezo("Salsa criolla");
        this.getSandwich().setPrecioAderezo(20);
    }

    @Override
    public void armarPrincipal() {
        this.getSandwich().setPrincipal("Milanesa de girgolas");
        this.getSandwich().setPrecioPrincipal(500);
    }

    @Override
    public void armarAdicional() {
        this.getSandwich().setAdicional("Sin adicional");
        this.getSandwich().setPrecioAdicional(0);
    }
}
