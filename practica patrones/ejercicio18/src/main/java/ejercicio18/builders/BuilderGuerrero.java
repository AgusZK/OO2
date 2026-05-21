package ejercicio18.builders;

import ejercicio18.armaduras.ArmaduraDeAcero;
import ejercicio18.armas.Espada;

public class BuilderGuerrero extends BuilderPersonaje {
    @Override
    public void equiparArmadura() {
        this.personaje.setArmadura(new ArmaduraDeAcero());
    }

    @Override
    public void equiparArma() {
        this.personaje.setArma(new Espada());
    }

    @Override
    public void equiparHabilidad() {}
}
