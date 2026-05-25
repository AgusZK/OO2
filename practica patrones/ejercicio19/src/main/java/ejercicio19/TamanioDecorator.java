package ejercicio19;

public class TamanioDecorator extends FileDecorator{

    public TamanioDecorator(FileComponent component) {
        super(component);
    }

    @Override
    public String prettyPoint() {
        return super.prettyPoint() + "-" + this.getTamanio();
    }
}
