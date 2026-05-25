package ejercicio19;

public class ExtensionDecorator extends FileDecorator{

    public ExtensionDecorator(FileComponent component) {
        super(component);
    }

    @Override
    public String prettyPoint() {
        return super.prettyPoint() + "-" + this.getExtension();
    }
}
