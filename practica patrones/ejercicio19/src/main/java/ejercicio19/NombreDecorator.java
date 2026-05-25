package ejercicio19;

public class NombreDecorator extends FileDecorator{
    public NombreDecorator(FileComponent component) {
        super(component);
    }

    @Override
    public String prettyPoint() {
        return super.getNombre();
    }
}
