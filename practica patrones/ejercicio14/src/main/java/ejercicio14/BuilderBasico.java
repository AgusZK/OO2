package ejercicio14;

public class BuilderBasico extends BuilderPC{

    public BuilderBasico(Presupuesto p) {
        super(p);
    }

    @Override
    public void setProcesador() {
        this.getPresupuesto().setProcesador(Catalogo.getComponente("Procesador Basico"));
    }

    @Override
    public void setRam() {
        this.getPresupuesto().setRam(Catalogo.getComponente("8 GB"));
    }

    @Override
    public void setDisco() {
        this.getPresupuesto().setDisco(Catalogo.getComponente("HDD 500 GB"));
    }

    @Override
    public void setGrafica(){}

    @Override
    public void setGabinete() {
        this.getPresupuesto().setGabinete(Catalogo.getComponente("Gabinete Estandar"));
    }
}
