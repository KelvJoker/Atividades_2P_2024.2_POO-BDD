import java.util.Scanner;

public class Gato {

    String nome;
    String genero;
    int idade;
    int peso;
    String cor;

    boolean estaDormindo;

    public Gato(String nome, String genero, int idade, int peso, String cor) {
        this.nome = nome;
        this.genero = genero;
        this.idade = idade;
        this.peso = peso;
        this.cor = cor;
        this.estaDormindo = false; 
    }

    public void respirar() {
        System.out.println(nome + " está respirando.");
    }

    public void comer() {
        if (estaDormindo) {
            System.out.println(nome + " está dormindo e não pode comer.");
        } else {
            System.out.println(nome + " está comendo.");
        }
    }

    public void dormir() {
        estaDormindo = true;
        System.out.println(nome + " está dormindo.");
    }

    public void acordar() {
        estaDormindo = false;
        System.out.println(nome + " acordou.");
    }

    public String executar(String comando) {
        if (estaDormindo) {
            return nome + " está dormindo e não pode executar o comando: " + comando;
        } else {
            return nome + " está executando o comando: " + comando;
        }
    }

    public String miar() {
        return nome + " diz: Miau!";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do gato: ");
        String nome = scanner.nextLine();

        String genero = "Desconhecido";
        int idade = 2; 
        int peso = 4; 
        String cor = "Preto"; 

        Gato meuGato = new Gato(nome, genero, idade, peso, cor);

        meuGato.respirar();
        meuGato.dormir();
        meuGato.comer(); 
        meuGato.acordar();
        meuGato.comer(); 
        System.out.println(meuGato.executar("pular"));
        System.out.println(meuGato.miar());

        scanner.close();
    }
}