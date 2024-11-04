import java.util.ArrayList;
import java.util.List;

public class Player extends bases {
    private String nickname;
    private List<Jogo> jogos;

    public Player(Long id, String nickname, String status) {
        super(id, status);
        this.nickname = nickname;
        this.jogos = new ArrayList<>();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    public void adicionarJogo(Jogo jogo) {
        this.jogos.add(jogo);
    }

    @Override
    public void validate() {
        if (nickname == null || nickname.isEmpty()) {
            throw new IllegalArgumentException("Nickname obrigatório");
        }
    }
}