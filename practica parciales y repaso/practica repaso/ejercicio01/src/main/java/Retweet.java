public class Retweet implements Post{
    public Tweet tweetDeOrigen;

    public Retweet (Tweet tweetDeOrigen){
        this.tweetDeOrigen = tweetDeOrigen;
    }

    // Texto del tweet orginal
    public String getTexto(){
        return this.tweetDeOrigen.getTexto();
    }

    // Identificador de si es rt o no
    public boolean esRetweet(){
        return true;
    }

    public Tweet getTweetDeOrigen(){
        return this.tweetDeOrigen;
    }

}
