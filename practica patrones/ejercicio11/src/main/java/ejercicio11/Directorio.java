package ejercicio11;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Directorio extends FileSystem {
    private LocalDate fechaCreacion;
    private List<FileSystem> elementos;

    public Directorio(String nom, LocalDate fechaCreacion, List<FileSystem> elementos) {
        super(nom);
        this.fechaCreacion = fechaCreacion;
        this.elementos = elementos;
    }


    @Override
    public int tamanoTotalOcupado() {
        return this.elementos.stream()
                .mapToInt(e -> e.tamanoTotalOcupado())
                .sum();
    }

    @Override
    public Archivo archivoMasGrande() {
        return this.elementos.stream()
                .map(f -> f.archivoMasGrande())
                .max(Comparator.comparingInt(a -> a.getTamanio()))
                .orElse(null);
    }

    @Override
    public Archivo archivoMasNuevo() {
        return this.elementos.stream()
                .map(f -> f.archivoMasNuevo())
                .filter(a -> a!= null)
                .max(Comparator.comparing( a -> a.getFechaCreacion()))
                .orElse(null);
    }

    @Override
    public FileSystem buscar(String nombre) {
        if (this.getNombre().equals(nombre)){
            return this;
        }

        return this.elementos.stream()
                .map( e ->e .buscar(nombre))
                .filter( e -> e != null)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<FileSystem> buscarTodos(String nombre) {
        return this.elementos.stream()
                .filter( e -> e.getNombre().equals(nombre))
                .collect(Collectors.toList());
    }

    @Override
    public String listadoDeContenido(String path) {
        String pathNuevo = path + "/" + this.getNombre();
        return pathNuevo + "\n" + this.elementos.stream()
                .map(e -> e.listadoDeContenido(pathNuevo))
                .collect(Collectors.joining());
    }
}
