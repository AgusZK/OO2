public class Piedra implements Match{
    public Piedra(){}

    public String jugarContra (Match rival){
        return rival.jugarContraPiedra();
    }

    public String jugarContraPiedra(){
        return "Empate";
    }

    public String jugarContraPapel(){
        return "Gana papel";
    }

    public String jugarContraTijera(){
        return "Gana piedra";
    }

    public String jugarContraLagarto(){
        return "Gana piedra";
    }

    public String jugarContraSpock(){
        return "Gana spock";
    }
}
