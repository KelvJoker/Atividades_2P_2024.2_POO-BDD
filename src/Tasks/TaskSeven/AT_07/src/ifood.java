package AT_07;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ifood {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Carrinho carrinho = new Carrinho();

        List<Restaurante> restaurantes = criarRestaurantes();

        try {
            while (true) {
                System.out.println("\n--- MENU ---");
                System.out.println("1. Listar Restaurantes");
                System.out.println("2. Exibir Carrinho");
                System.out.println("3. Sair");
                System.out.print("Escolha uma opção: ");

                int opcao = scanner.nextInt();
                scanner.nextLine();

                if (opcao == 1) {
                    System.out.println("\n--- Restaurantes ---");
                    for (int i = 0; i < restaurantes.size(); i++) {
                        System.out.println((i + 1) + ". " + restaurantes.get(i));
                    }
                    System.out.print("Selecione um restaurante: ");
                    int restauranteIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (restauranteIndex < 0 || restauranteIndex >= restaurantes.size()) {
                        System.out.println("Restaurante inválido.");
                        continue;
                    }

                    Restaurante restauranteSelecionado = restaurantes.get(restauranteIndex);

                    System.out.println("\n--- Produtos de " + restauranteSelecionado + " ---");
                    for (int i = 0; i < restauranteSelecionado.produtos.size(); i++) {
                        System.out.println((i + 1) + ". " + restauranteSelecionado.produtos.get(i));
                    }
                    System.out.print("Selecione um produto: ");
                    int produtoIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (produtoIndex < 0 || produtoIndex >= restauranteSelecionado.produtos.size()) {
                        System.out.println("Produto inválido.");
                        continue;
                    }

                    Produto produtoSelecionado = restauranteSelecionado.produtos.get(produtoIndex);
                    carrinho.adicionarProduto(produtoSelecionado);

                    if (!produtoSelecionado.adicionais.isEmpty()) {
                        System.out.println("\n--- Adicionais para " + produtoSelecionado + " ---");
                        for (int i = 0; i < produtoSelecionado.adicionais.size(); i++) {
                            System.out.println((i + 1) + ". " + produtoSelecionado.adicionais.get(i));
                        }
                        System.out.print("Selecione um adicional (ou 0 para pular): ");
                        int adicionalIndex = scanner.nextInt() - 1;
                        scanner.nextLine();

                        if (adicionalIndex >= 0 && adicionalIndex < produtoSelecionado.adicionais.size()) {
                            Adicional adicionalSelecionado = produtoSelecionado.adicionais.get(adicionalIndex);
                            carrinho.adicionarAdicional(adicionalSelecionado);
                        }
                    }

                    System.out.println("Produto adicionado ao carrinho!");

                } else if (opcao == 2) {
                    carrinho.exibirCarrinho();
                } else if (opcao == 3) {
                    System.out.println("Saindo...");
                    break;
                } else {
                    System.out.println("Opção inválida.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida, por favor insira um número.");
            scanner.next();
        } finally {
            scanner.close();
        }
    }

    private static List<Restaurante> criarRestaurantes() {
        List<Restaurante> restaurantes = new ArrayList<>();

        // Restaurante 1
        Restaurante restaurante1 = new Restaurante("Delícias do Norte");
        Produto prato1 = new Produto("Tacacá", 20.00);
        Produto prato2 = new Produto("Pato no Tucupi", 35.00);
        Produto prato3 = new Produto("Maniçoba", 30.00);
        prato1.adicionarAdicional(new Adicional("Goma extra", 3.00));
        prato2.adicionarAdicional(new Adicional("Farinha crocante", 2.50));
        restaurante1.adicionarProduto(prato1);
        restaurante1.adicionarProduto(prato2);
        restaurante1.adicionarProduto(prato3);

        // Restaurante 2
        Restaurante restaurante2 = new Restaurante("Sabor Paulista");
        Produto prato4 = new Produto("Coxinha", 7.00);
        Produto prato5 = new Produto("Virado à Paulista", 25.00);
        Produto prato6 = new Produto("Pão de Queijo", 10.00);
        Produto prato7 = new Produto("Feijoada", 28.00);
        prato6.adicionarAdicional(new Adicional("Recheio de Catupiry", 4.00));
        prato7.adicionarAdicional(new Adicional("Torresmo", 5.00));
        restaurante2.adicionarProduto(prato4);
        restaurante2.adicionarProduto(prato5);
        restaurante2.adicionarProduto(prato6);
        restaurante2.adicionarProduto(prato7);

        // Restaurante 3
        Restaurante restaurante3 = new Restaurante("Bistrô Gourmet");
        Produto prato8 = new Produto("Filé ao molho madeira", 50.00);
        Produto prato9 = new Produto("Risoto de camarão", 60.00);
        Produto prato10 = new Produto("Salada Caesar", 25.00);
        Produto prato11 = new Produto("Sobremesa Brownie", 15.00);
        Produto prato12 = new Produto("Tábua de queijos", 40.00);
        prato9.adicionarAdicional(new Adicional("Camarão extra", 10.00));
        restaurante3.adicionarProduto(prato8);
        restaurante3.adicionarProduto(prato9);
        restaurante3.adicionarProduto(prato10);
        restaurante3.adicionarProduto(prato11);
        restaurante3.adicionarProduto(prato12);

        restaurantes.add(restaurante1);
        restaurantes.add(restaurante2);
        restaurantes.add(restaurante3);

        return restaurantes;
    }
}
