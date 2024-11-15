package AT_07;

import java.util.ArrayList;
import java.util.List;

public class Produto {
    String nome;
    double preco;
    List<Adicional> adicionais;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
        this.adicionais = new ArrayList<>();
    }

    public void adicionarAdicional(Adicional adicional) {
        adicionais.add(adicional);
    }

    @Override
    public String toString() {
        return nome + " - R$ " + preco;
    }
}
