package ejercicio03;

public class VideoStreamAdapter extends Media{
    private VideoStream vs;

    public VideoStreamAdapter (VideoStream vs){
        this.vs = vs;
    }

    @Override
    public void play() {
        this.vs.reproduce();
    }
}
