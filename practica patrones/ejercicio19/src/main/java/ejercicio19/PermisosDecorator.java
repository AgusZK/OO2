package ejercicio19;

public class PermisosDecorator extends FileDecorator{
    public PermisosDecorator(FileComponent component) {
        super(component);
    }

    @Override
    public String prettyPoint() {
        return super.prettyPoint() + '-' + this.getPermisos();
    }
}
