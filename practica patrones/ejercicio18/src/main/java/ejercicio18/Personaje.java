package ejercicio18;

public class Personaje {
    private int vida;
    private String nombre;
    private Armadura armadura;
    private Arma arma;
    private Habilidad habilidad;

    public Personaje (String nombre){
        this.nombre = nombre;
        this.vida = 100;
    }

    public void setArmadura(Armadura armadura) {
        this.armadura = armadura;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public void setHabilidad(Habilidad habilidad) {
        this.habilidad = habilidad;
    }

    public void atacar (Personaje p){
        p.recibirAtaque(this.arma);
    }

    public void recibirAtaque(Arma a){
        this.vida -= this.armadura.calcularDanio(a);
    }
}
