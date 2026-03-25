import java.util.*;
import java.util.stream.Collectors;

public class Usuario {
    private String screenName;
    private List<Post> tweets;

    public Usuario (String screenName){
        this.screenName = screenName;
        this.tweets = new ArrayList<Post>();
    }

    public Post twittear (String texto){
        Post nuevoTweet = null;
        if (this.checkCaracteres(texto)){
            nuevoTweet = new Tweet(texto);
            this.tweets.add(nuevoTweet);
        }
        return nuevoTweet;
    }

    public boolean checkCaracteres (String texto){
        if (texto.length() >= 1 && texto.length() <= 280){
            return true;
        }
        return false;
    }

    public Post retwittear (Tweet tweetDeOrigen){
        Retweet r = new Retweet(tweetDeOrigen);
        this.tweets.add(r);
        return r;
    }

    public String getScreenName(){
        return this.screenName;
    }

    public List<Post> getPosts(){
        return this.tweets;
    }

    public void borrarTweets(){
        this.tweets.clear();
    }


    public List<Tweet> getTweets(){
        return this.tweets.stream().filter( p -> !p.esRetweet()).map(p -> (Tweet) p).collect(Collectors.toList());
    }
}
