public class Tijera implements Match{
    public String jugarContra (Match rival){
        return rival.jugarContraTijera();
    }

    public String jugarContraPiedra(){
        return "Gana piedra";
    }

    public String jugarContraPapel(){
        return "Gana tijera";
    }

    public String jugarContraTijera(){
        return "Empate";
    }

    public String jugarContraLagarto(){
        return "Gana tijera";
    }

    public String jugarContraSpock(){
        return "Gana spock";
    }
}
