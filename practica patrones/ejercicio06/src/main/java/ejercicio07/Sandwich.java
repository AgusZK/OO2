package ejercicio07;

public class Sandwich {
    private String pan;
    private double precioPan;
    private String aderezo;
    private double precioAderezo;
    private String principal;
    private double precioPrincipal;
    private String adicional;
    private double precioAdicional;

    public double getPrecio(){
        return this.precioPan + this.precioAderezo + this.precioPrincipal + this.precioAdicional;
    }

   public void setPan(String pan){
        this.pan = pan;
   }

    public void setPrecioPan(double precioPan) {
        this.precioPan = precioPan;
    }

    public void setAderezo(String aderezo) {
        this.aderezo = aderezo;
    }

    public void setPrecioAderezo(double precioAderezo) {
        this.precioAderezo = precioAderezo;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public void setPrecioPrincipal(double precioPrincipal) {
        this.precioPrincipal = precioPrincipal;
    }

    public void setAdicional(String adicional) {
        this.adicional = adicional;
    }

    public void setPrecioAdicional(double precioAdicional) {
        this.precioAdicional = precioAdicional;
    }
}
