package ejercicio18.armas;

import ejercicio18.Arma;

public class Baston implements Arma {
    @Override
    public int calcularDanioACuero() {
        return 2;
    }

    @Override
    public int calcularDanioAHierro() {
        return 1;
    }

    @Override
    public int calcularDanioAAcero() {
        return 1;
    }
}
