public class Lagarto implements Match{
    public String jugarContra (Match rival){
        return rival.jugarContraLagarto();
    }

    public String jugarContraPiedra(){
        return "Gana piedra";
    }

    public String jugarContraPapel(){
        return "Gana lagarto";
    }

    public String jugarContraTijera(){
        return "Gana tijera";
    }

    public String jugarContraLagarto(){
        return "Empate";
    }

    public String jugarContraSpock(){
        return "Gana lagarto";
    }
}
