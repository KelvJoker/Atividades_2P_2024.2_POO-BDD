package aula1;

public class aula1 {
    public static void main(String[] args){
        Automovel carro = new Automovel();
        carro.modelo = "Ford";
        carro.velocidade = 50;
//        carro.acelerar(50);
////        System.out.println(" Impressão 1 -> " + carro.velocidade);
//
//        carro.reduzir(30);
////        System.out.println(" Impressão 2 -> " + carro.velocidade);
//
//
//        carro.qualMeuCarro("Celta", "Azul", "1980");
//        System.out.println(carro.cor + " , " + carro.modelo);



//        System.out.println(" Impressão 1 -> " +carro.velocidade);
//        carro.acelerar(50);
//        System.out.println(" Impressão 2 -> " + carro.velocidade);
//
////        int velocidadeCarro = carro.qualMinhaVelocidade();
//
//        System.out.println(" Impressão 3 -> " + carro.qualMinhaVelocidade());



//
//        Automovel moto;
//        moto = new Automovel();
//
//        // GITHUB
//
//        carro.reduzir();
//        System.out.println(carro.modelo);

        Calculadora cal = new Calculadora();
        double resultado = cal.somar(10, 2);
        System.out.println(resultado);


        cal.subtracao(10, 2);
        double resultado2 = cal.valorUm;
        System.out.println(resultado2);


    }
}
