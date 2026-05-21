package ejercicio14;

public abstract class BuilderPC {
    private Presupuesto presupuesto;

    public BuilderPC(Presupuesto p){
        this.presupuesto = p;
    }

    public void reset(){
        this.presupuesto = new Presupuesto();
    }

    public abstract void setProcesador();
    public abstract void setRam();
    public abstract void setDisco();
    public abstract void setGrafica();
    public abstract void setGabinete();

    public Presupuesto getPresupuesto() {
        return presupuesto;
    }
}
