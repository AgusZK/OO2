package ejercicio19;

public class FechaModificacionDecorator extends FileDecorator{

    public FechaModificacionDecorator(FileComponent component) {
        super(component);
    }

    @Override
    public String prettyPoint() {
        return super.prettyPoint() + "-" + this.getFechaModificacion();
    }
}
