package ejercicio18.armas;

import ejercicio18.Arma;

public class Martillo implements Arma {
    // Pongo danios arbitrariamente porque no estan
    @Override
    public int calcularDanioACuero() {
        return 10;
    }

    @Override
    public int calcularDanioAHierro() {
        return 7;
    }

    @Override
    public int calcularDanioAAcero() {
        return 5;
    }
}
