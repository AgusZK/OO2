package ejercicio19;

import java.time.LocalDate;

public interface FileComponent {
    public String prettyPoint();
    public String getNombre();
    public String getExtension();
    public String getTamanio();
    public LocalDate getFechaCreacion();
    public LocalDate getFechaModificacion();
    public String getPermisos();
}
