package ejercicio14;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private static List<Componente> componentes;

    public Catalogo(){
        this.componentes = new ArrayList<Componente>();
    }

    public static Componente getComponente(String nombre){
        return componentes.stream()
                .filter(c -> c.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);
    }
}
