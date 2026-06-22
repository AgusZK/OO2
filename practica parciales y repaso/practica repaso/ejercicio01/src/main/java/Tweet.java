public class Tweet implements Post{
    public String texto;

    public Tweet (String texto){
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    // Identificador de si es rt o no
    public boolean esRetweet(){
        return false;
    }
}
