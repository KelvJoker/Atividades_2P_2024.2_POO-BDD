public class Jogo extends bases {
    private String nome;
    private Player player;

    public Jogo(Long id, String nome, String status, Player player) {
        super(id, status);
        this.nome = nome;
        this.player = player;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public void validate() {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome do jogo obrigatório");
        }
    }
}
