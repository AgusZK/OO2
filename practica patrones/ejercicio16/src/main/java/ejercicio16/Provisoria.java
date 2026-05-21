package ejercicio16;

public class Provisoria extends Estado {
    public Provisoria(Excursion e){
        super(e);
    }

    @Override
    public String infoAdicional() {
        return "Cantidad de usuarios faltantes para cupo minimo:" + this.getExcursion().faltasParaMinimo();
    }

    @Override
    public void inscribir(Usuario usuario) {
        Excursion e = this.getExcursion();
        e.agregarInscripto(usuario);
        if (e.faltasParaMinimo() == 0){
            e.changeState(new Definitiva(e));
        }
    }
}
