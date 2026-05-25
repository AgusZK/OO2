package ejercicio19;

public class FechaCreacionDecorator extends FileDecorator{
    public FechaCreacionDecorator(FileComponent component) {
        super(component);
    }

    @Override
    public String prettyPoint() {
        return super.prettyPoint() + "-" + this.getFechaCreacion();
    }
}
