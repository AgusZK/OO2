package ejercicio18.builders;

import ejercicio18.armaduras.*;
import ejercicio18.armas.*;
import ejercicio18.habilidades.*;

public class BuilderThoor extends BuilderPersonaje{
    @Override
    public void equiparArmadura() {
        this.personaje.setArmadura(new ArmaduraDeHierro());
    }

    @Override
    public void equiparArma() {
        this.personaje.setArma(new Martillo());
    }

    @Override
    public void equiparHabilidad() {
        this.personaje.setHabilidad(new Rayos());
        this.personaje.setHabilidad(new CombateADistancia());
    }
}
