package ejercicio14;

public class Tecnico {
    private BuilderPC builder;

    public Tecnico(BuilderPC builder){
        this.builder = builder;
    }

    public void setBuilder(BuilderPC builder){
        this.builder = builder;
    }

    public Presupuesto build (String nombre){
        this.builder.reset();
        this.builder.setProcesador();
        this.builder.setRam();
        this.builder.setDisco();
        this.builder.setGrafica();
        this.builder.setGabinete();
        return this.builder.getPresupuesto();
    }
}