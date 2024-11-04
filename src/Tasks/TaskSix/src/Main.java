public class Main {
    public static void main(String[] args) {

        Player player1 = new Player(1L, "Kelvin", bases.STATUS_ACTIVE);

        Jogo jogo1 = new Jogo(101L, "Aventura Épica das épicas.", bases.STATUS_AVAILABLE, player1);
        Jogo jogo2 = new Jogo(102L, "Corrida Maluca, não é o desenho.", bases.STATUS_AVAILABLE, player1);

        player1.adicionarJogo(jogo1);
        player1.adicionarJogo(jogo2);

        System.out.println("Player: " + player1.getNickname() + " (Status: " + player1.getStatus() + ")");
        System.out.println("Jogos no inventário do Player " + player1.getNickname() + ":");
        for (Jogo jogo : player1.getJogos()) {
            System.out.println("- " + jogo.getNome() + " (Status: " + jogo.getStatus() + ")");
        }
    }
}