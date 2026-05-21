package ejercicio16;

public class Completa extends Estado{
    public Completa(Excursion e) {
        super(e);
    }

    @Override
    public String infoAdicional() {
        return "";
    }

    @Override
    public void inscribir(Usuario usuario) {
        this.getExcursion().agregarAEspera(usuario);
    }
}
