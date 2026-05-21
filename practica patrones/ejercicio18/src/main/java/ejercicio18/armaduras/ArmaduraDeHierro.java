package ejercicio18.armaduras;

import ejercicio18.Arma;
import ejercicio18.Armadura;

public class ArmaduraDeHierro implements Armadura {
    @Override
    public int calcularDanio(Arma a) {
        return a.calcularDanioAHierro();
    }
}
