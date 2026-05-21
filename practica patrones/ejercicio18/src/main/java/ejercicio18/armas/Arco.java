package ejercicio18.armas;

import ejercicio18.Arma;

public class Arco implements Arma {
    @Override
    public int calcularDanioACuero() {
        return 5;
    }

    @Override
    public int calcularDanioAHierro() {
        return 3;
    }

    @Override
    public int calcularDanioAAcero() {
        return 2;
    }
}
