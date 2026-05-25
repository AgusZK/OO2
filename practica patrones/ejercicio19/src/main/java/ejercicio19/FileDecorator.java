package ejercicio19;

import java.time.LocalDate;

public class FileDecorator implements FileComponent {
    private FileComponent component;

    public FileDecorator(FileComponent component){
        this.component = component;
    }

    protected FileComponent getComponent() {
        return component;
    }

    @Override
    public String prettyPoint() {
        return this.component.prettyPoint();
    }

    @Override
    public String getNombre() {
        return this.component.getNombre();
    }

    @Override
    public String getExtension() {
        return this.component.getExtension();
    }

    @Override
    public String getTamanio() {
        return this.component.getTamanio();
    }

    @Override
    public LocalDate getFechaCreacion() {
        return this.component.getFechaCreacion();
    }

    @Override
    public LocalDate getFechaModificacion() {
        return this.component.getFechaModificacion();
    }

    @Override
    public String getPermisos() {
        return this.component.getPermisos();
    }
}
