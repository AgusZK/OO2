package ejercicio18.armaduras;

import ejercicio18.Arma;
import ejercicio18.Armadura;

public class ArmaduraDeCuero implements Armadura {
    @Override
    public int calcularDanio(Arma a) {
        return a.calcularDanioACuero();
    }
}
