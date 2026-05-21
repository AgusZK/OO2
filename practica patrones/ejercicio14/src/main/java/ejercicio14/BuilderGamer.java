package ejercicio14;

public class BuilderGamer extends BuilderPC{
    public BuilderGamer(Presupuesto p) {
        super(p);
    }

    @Override
    public void setProcesador() {
        this.getPresupuesto().setProcesador(Catalogo.getComponente("Procesador Gamer"));
        this.getPresupuesto().add(Catalogo.getComponente("Pad termico"));
        this.getPresupuesto().add(Catalogo.getComponente("Cooler"));
    }

    @Override
    public void setRam() {
        this.getPresupuesto().setRam(Catalogo.getComponente("32 GB"));
        this.getPresupuesto().setRam(Catalogo.getComponente("32 GB"));
    }

    @Override
    public void setDisco() {
        this.getPresupuesto().setDisco(Catalogo.getComponente("SSD 500 GB"));
        this.getPresupuesto().setDisco(Catalogo.getComponente("SSD 1 TB"));
    }

    @Override
    public void setGrafica() {
        this.getPresupuesto().setGrafica(Catalogo.getComponente("RTX 4090"));
    }

    @Override
    public void setGabinete() {
        this.getPresupuesto().setGabinete(Catalogo.getComponente("Gabinete Gamer"));
        double suma = this.getPresupuesto().calcularConsumo();
        suma += suma * 0.5;
        String fuenteCalculada = "Fuente" + suma + "W";
        this.getPresupuesto().add(Catalogo.getComponente(fuenteCalculada));
    }
}
