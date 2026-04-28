package ejercicio07;

public class BuilderClasico extends SandwichBuilder{
    @Override
    public void armarPan() {
        this.getSandwich().setPan("Brioche");
        this.getSandwich().setPrecioPan(100);
    }

    @Override
    public void armarAderezo() {
        this.getSandwich().setAderezo("Mayonesa");
        this.getSandwich().setPrecioAderezo(20);
    }

    @Override
    public void armarPrincipal() {
        this.getSandwich().setPrincipal("Carne Ternera");
        this.getSandwich().setPrecioPrincipal(300);
    }

    @Override
    public void armarAdicional() {
        this.getSandwich().setAdicional("Tomate");
        this.getSandwich().setPrecioAdicional(80);
    }
}
