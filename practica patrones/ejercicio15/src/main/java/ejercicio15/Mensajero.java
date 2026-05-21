package ejercicio15;

public class Mensajero {
    private Cifrado cifrador;

    public Mensajero(Cifrado c){
        this.cifrador = c;
    }

    public void enviar(String mensaje){
        this.cifrador.cifrar(mensaje);
    }

    public void recibir(String mensaje){
        this.cifrador.descifrar(mensaje);
    }

    public void setCifrador(Cifrado cifrador){
        this.cifrador = cifrador;
    }
}
