package ejercicio15;

public class AdapterRC4 implements Cifrado{
    private RC4 rc4;
    private String clave;
    @Override
    public String cifrar(String mensaje) {
        return rc4.encriptar(mensaje, this.clave);
    }

    public String descifrar(String mensaje){
        return rc4.desencriptar(mensaje,this.clave);
    }
}
