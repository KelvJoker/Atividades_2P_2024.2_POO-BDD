package AT_04;

public class class_car { 
    private String modelo;
    private String marca;
    private int ano;
    private String cor;
    private double preco;
    private String tipoCombustivel;
    private int quilometragem;
    private boolean vendido;

    public class_car(String modelo, String marca, int ano) {
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.cor = "Desconhecida";
        this.preco = 0.0;
        this.tipoCombustivel = "Gasolina";
        this.quilometragem = 0;
        this.vendido = false;
    }

    public class_car(String modelo, String marca, int ano, String cor, double preco) {
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.cor = cor;
        this.preco = preco;
        this.tipoCombustivel = "Gasolina";
        this.quilometragem = 0;
        this.vendido = false;
    }

    public class_car(String modelo, String marca, int ano, String cor, double preco, String tipoCombustivel, int quilometragem) {
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.cor = cor;
        this.preco = preco;
        this.tipoCombustivel = tipoCombustivel;
        this.quilometragem = quilometragem;
        this.vendido = false;
    }

    public void vender() {
        this.vendido = true;
    }

    public void abastecer(double litros) {
    }

    public void dirigir(int km) {
        this.quilometragem += km;
    }

    public void trocarCor(String novaCor) {
        this.cor = novaCor;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public int getAno() {
        return ano;
    }

    public String getCor() {
        return cor;
    }

    public double getPreco() {
        return preco;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public boolean isVendido() {
        return vendido;
    }

    public static void main(String[] args) {
        class_car carro1 = new class_car("Civic", "Honda", 2020);
        class_car carro2 = new class_car("Fusca", "Volkswagen", 1969, "Azul", 20000);
        
        carro1.dirigir(100);
        carro2.vender();
        
        System.out.println("Modelo: " + carro1.getModelo() + ", Quilometragem: " + carro1.getQuilometragem());
        System.out.println("Modelo: " + carro2.getModelo() + ", Vendido: " + carro2.isVendido());
    }
}