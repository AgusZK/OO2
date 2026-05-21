package ejercicio18;

import ejercicio18.builders.BuilderPersonaje;

public class Juego {
    private BuilderPersonaje builder;

    public Juego(BuilderPersonaje builder){
        this.builder = builder;
    }

    // Puedo hacer que retorne el pj pero hay q agregar el getter
    public void crearPersonaje(){
        builder.equiparArmadura();;
        builder.equiparArma();
        builder.equiparHabilidad();
    }
}
