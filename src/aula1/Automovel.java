package aula1;

public class Automovel {
    String modelo;
    String cor;
    String ano;
    int velocidade;
    boolean isUsado;

    boolean meuCarroEUsado(){
        return isUsado;
    }

    int qualMinhaVelocidade(){
        return velocidade;
    }

    void acelerar(int novaVelocidade) {
        velocidade = velocidade + novaVelocidade;
    }

    void qualMeuCarro(String ModeloCarro, String corCarro, String anoCarro){
        modelo = ModeloCarro;
        cor = corCarro;
        ano = anoCarro;
    }


    void reduzir(int novaVelocidade){
        velocidade = novaVelocidade;
    }
}
