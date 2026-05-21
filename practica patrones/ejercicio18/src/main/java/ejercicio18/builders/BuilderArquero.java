package ejercicio18.builders;

import ejercicio18.armas.Arco;
import ejercicio18.armaduras.ArmaduraDeCuero;

public class BuilderArquero extends BuilderPersonaje {
    @Override
    public void equiparArmadura() {
        this.personaje.setArmadura(new ArmaduraDeCuero());
    }

    @Override
    public void equiparArma() {
        this.personaje.setArma(new Arco());
    }

    @Override
    public void equiparHabilidad() {}
}
