package AT_07;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    List<Produto> produtos;
    List<Adicional> adicionais;

    public Carrinho() {
        this.produtos = new ArrayList<>();
        this.adicionais = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void adicionarAdicional(Adicional adicional) {
        adicionais.add(adicional);
    }

    public void exibirCarrinho() {
        System.out.println("\n--- Carrinho ---");
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
        for (Adicional adicional : adicionais) {
            System.out.println("  + " + adicional);
        }
        System.out.println("-------------------");
    }
}