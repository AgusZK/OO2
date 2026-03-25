public class Spock implements Match{
    public String jugarContra (Match rival){
        return rival.jugarContraSpock();
    }

    public String jugarContraPiedra(){
        return "Gana spock";
    }

    public String jugarContraPapel(){
        return "Gana papel";
    }

    public String jugarContraTijera(){
        return "Gana spock";
    }

    public String jugarContraLagarto(){
        return "Gana lagarto";
    }

    public String jugarContraSpock(){
        return "Empate";
    }
}
