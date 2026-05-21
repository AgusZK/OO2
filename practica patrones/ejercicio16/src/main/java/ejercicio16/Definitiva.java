package ejercicio16;

public class Definitiva extends Estado{
    public Definitiva(Excursion e) {
        super(e);
    }

    @Override
    public String infoAdicional() {
        return this.getExcursion().mostrarMails() + "Cantidad de usuarios que faltan para cupo maximo:" + this.getExcursion().faltasParaMaximo();
    }

    @Override
    public void inscribir(Usuario usuario) {
        Excursion e = this.getExcursion();
        e.agregarInscripto(usuario);
        if (e.faltasParaMaximo() == 0){
            e.changeState(new Completa(e));
        }
    }
}
