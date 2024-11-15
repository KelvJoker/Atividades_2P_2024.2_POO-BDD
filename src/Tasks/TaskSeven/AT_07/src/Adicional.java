package AT_07;

public class Adicional {
    String nome;
    double preco;

    public Adicional(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return nome + " - R$ " + preco;
    }
}
