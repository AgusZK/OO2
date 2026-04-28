package ejercicio04;

import java.util.ArrayList;
import java.util.List;

public class Mixta implements Topografia{
    public List<Topografia> topografias;

    public Mixta(){
        this.topografias = new ArrayList<Topografia>();
    }

    @Override
    public double getProporcion() {
        return this.topografias.stream().mapToDouble(t -> t.getProporcion()).sum()/4;
    }

    @Override
    public boolean esIgualMixta(Mixta t) {
        return this.topografias.equals(t.topografias);
    }

    @Override
    public boolean equals(Object t) {
        return ((Topografia)t).esIgualMixta(this);
    }

    // Creo add para los test
    public void add(Topografia t){
        if (this.topografias.size() < 4){
            this.topografias.add(t);
        }
    }
}
