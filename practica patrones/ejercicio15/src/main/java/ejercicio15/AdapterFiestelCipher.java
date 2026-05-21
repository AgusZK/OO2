package ejercicio15;

public class AdapterFiestelCipher implements Cifrado{
    private FeistelCipher fc;
    @Override
    public String cifrar(String mensaje) {
        return this.fc.encode(mensaje);
    }

    @Override
    public String descifrar(String mensaje) {
        return this.fc.encode(mensaje);
    }
}
