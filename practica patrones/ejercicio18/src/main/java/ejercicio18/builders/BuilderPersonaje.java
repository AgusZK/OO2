package ejercicio18.builders;

import ejercicio18.Personaje;

public abstract class BuilderPersonaje {
    protected Personaje personaje;
    public abstract void equiparArmadura();
    public abstract void equiparArma();
    public abstract void equiparHabilidad();
}
