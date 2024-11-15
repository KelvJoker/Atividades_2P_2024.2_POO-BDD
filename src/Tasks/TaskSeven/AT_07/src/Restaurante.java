package AT_07;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    String nome;
    List<Produto> produtos;

    public Restaurante(String nome) {
        this.nome = nome;
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    @Override
    public String toString() {
        return nome;
    }
}
