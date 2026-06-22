public class Papel implements Match{
    public String jugarContra (Match rival){
        return rival.jugarContraPapel();
    }

    public String jugarContraPiedra(){
        return "Gana papel";
    }

    public String jugarContraPapel(){
        return "Empate";
    }

    public String jugarContraTijera(){
        return "Gana tijera";
    }

    public String jugarContraLagarto(){
        return "Gana lagarto";
    }

    public String jugarContraSpock(){
        return "Gana papel";
    }
}
