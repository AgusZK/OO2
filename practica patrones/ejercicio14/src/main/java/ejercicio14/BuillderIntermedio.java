package ejercicio14;

public class BuillderIntermedio extends BuilderPC{
    public BuillderIntermedio(Presupuesto p) {
        super(p);
    }

    @Override
    public void setProcesador() {
        this.getPresupuesto().setProcesador(Catalogo.getComponente("Procesador Intermedio"));
    }

    @Override
    public void setRam() {
        this.getPresupuesto().setRam(Catalogo.getComponente("16 GB"));
    }

    @Override
    public void setDisco() {
        this.getPresupuesto().setDisco(Catalogo.getComponente("SSD 500 GB"));
    }

    @Override
    public void setGrafica() {
        this.getPresupuesto().setDisco(Catalogo.getComponente("GTX 1650"));
    }

    @Override
    public void setGabinete() {
        this.getPresupuesto().setDisco(Catalogo.getComponente("Gabinete Intermedio"));
        this.getPresupuesto().add(Catalogo.getComponente("Fuente 800w"));
    }
}
