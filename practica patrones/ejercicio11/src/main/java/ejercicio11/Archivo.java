package ejercicio11;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Archivo extends FileSystem{
    private int tamanio;
    private LocalDate fechaCreacion;

    public Archivo(String nom, int tamanio, LocalDate fechaCreacion) {
        super(nom);
        this.tamanio = tamanio;
        this.fechaCreacion = fechaCreacion;
    }

    public int getTamanio() {
        return tamanio;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    @Override
    public int tamanoTotalOcupado() {
        return this.tamanio;
    }

    @Override
    public Archivo archivoMasGrande() {
        return this;
    }

    @Override
    public Archivo archivoMasNuevo() {
        return this;
    }

    @Override
    public FileSystem buscar(String nombre) {
        if (this.getNombre().equals(nombre)){
            return this;
        }
        return null;
    }

    @Override
    public List<FileSystem> buscarTodos(String nombre) {
        List<FileSystem> lista = new ArrayList<FileSystem>();
        if (this.getNombre().equals(nombre)){
            lista.add(this);
        }

        return lista;
    }

    @Override
    public String listadoDeContenido(String path) {
        return path + "/" + this.getNombre() + "\n";
    }
}
