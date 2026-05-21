package ejercicio16;

public abstract class Estado {
    private Excursion excursion;

    public Estado(Excursion e){
        this.excursion = e;
    }

    public Excursion getExcursion() {
        return excursion;
    }

    public String obtenerInformacion(){
        return this.excursion.toString() + this.infoAdicional();
    }

    public abstract String infoAdicional();
    public abstract void inscribir(Usuario usuario);
}
