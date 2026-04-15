package ejercicio03;

import java.util.*;

public class MediaPlayer {
    private List<Media> media;

    public MediaPlayer(){
        this.media = new ArrayList<Media>();
    }

    public void play(){
        this.media.stream().forEach(m -> m.play());
    }
}
