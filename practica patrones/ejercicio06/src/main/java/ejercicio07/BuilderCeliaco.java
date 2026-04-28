package ejercicio07;

public class BuilderCeliaco extends SandwichBuilder{
    @Override
    public void armarPan() {
        this.getSandwich().setPan("Pan de chipa");
        this.getSandwich().setPrecioPan(150);
    }

    @Override
    public void armarAderezo() {
        this.getSandwich().setAderezo("Salsa de tartara");
        this.getSandwich().setPrecioAderezo(18);
    }

    @Override
    public void armarPrincipal() {
        this.getSandwich().setPrincipal("Carne de pollo");
        this.getSandwich().setPrecioPrincipal(250);
    }

    @Override
    public void armarAdicional() {
        this.getSandwich().setAdicional("Verduras grilladas");
        this.getSandwich().setPrecioAdicional(200);
    }
}
