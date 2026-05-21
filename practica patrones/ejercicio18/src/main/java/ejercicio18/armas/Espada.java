package ejercicio18.armas;

import ejercicio18.Arma;

public class Espada implements Arma {
    @Override
    public int calcularDanioACuero() {
        return 8;
    }

    @Override
    public int calcularDanioAHierro() {
        return 5;
    }

    @Override
    public int calcularDanioAAcero() {
        return 3;
    }
}
