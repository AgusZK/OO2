package ejercicio18.builders;

import ejercicio18.armaduras.ArmaduraDeCuero;
import ejercicio18.armas.Baston;
import ejercicio18.habilidades.CombateADistancia;
import ejercicio18.habilidades.Magia;

public class BuilderMago extends BuilderPersonaje {
    @Override
    public void equiparArmadura() {
        this.personaje.setArmadura(new ArmaduraDeCuero());
    }

    @Override
    public void equiparArma() {
        this.personaje.setArma(new Baston());
    }

    @Override
    public void equiparHabilidad() {
        this.personaje.setHabilidad(new Magia());
        this.personaje.setHabilidad(new CombateADistancia());
    }
}
