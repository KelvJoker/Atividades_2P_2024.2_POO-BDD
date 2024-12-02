import Bean.*;
import DAO.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        restauranteDAO resDAO = new restauranteDAO();
        produtoDAO prodDAO = new produtoDAO();
        forma_pagamentoDAO fpDAO = new forma_pagamentoDAO();
        enderecoDAO endDAO = new enderecoDAO();

        List<pedido_produto> carrinho = new ArrayList<>();
        List<String> pedidosRealizados = new ArrayList<>();

        while (true) {  
            carrinho.clear();
            endereco enderecoEntrega = null;
            forma_pagamento formaPagamento = null;

            // Menu Inicial
            String[] opcoesMenu = {"1. Fazer Pedido", "2. Visualizar Pedidos Realizados", "3. Sair"};
            int escolhaMenu = JOptionPane.showOptionDialog(null,
                    "Bem-vindo ao Sistema de Pedidos!",
                    "Menu Principal",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opcoesMenu,
                    opcoesMenu[0]);

            if (escolhaMenu == 2 || escolhaMenu == JOptionPane.CLOSED_OPTION) {
                JOptionPane.showMessageDialog(null, "Saindo do sistema. Até mais!");
                break;
            }

            if (escolhaMenu == 0) {
                // 1. Listar Restaurantes
                List<restaurante> restaurantes = resDAO.listarRestaurantes();
                if (restaurantes.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhum restaurante encontrado.");
                    continue;
                }

                String[] nomesRestaurantes = restaurantes.stream().map(restaurante::getNome).toArray(String[]::new);
                String restauranteEscolhido = (String) JOptionPane.showInputDialog(
                        null, "Selecione um Restaurante:", "Restaurantes",
                        JOptionPane.QUESTION_MESSAGE, null, nomesRestaurantes, nomesRestaurantes[0]);

                if (restauranteEscolhido == null) continue;

                restaurante restauranteSelecionado = restaurantes.stream()
                        .filter(r -> r.getNome().equals(restauranteEscolhido))
                        .findFirst()
                        .orElse(null);

                // 2. Listar Produtos do Restaurante
                while (true) {
                    List<produto> produtos = prodDAO.listarProdutosPorRestaurante(restauranteSelecionado.getId());
                    if (produtos.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nenhum produto encontrado para este restaurante.");
                        break;
                    }

                    String[] nomesProdutos = produtos.stream().map(produto::getNome).toArray(String[]::new);
                    String produtoEscolhido = (String) JOptionPane.showInputDialog(
                            null, "Selecione um Produto:", "Produtos",
                            JOptionPane.QUESTION_MESSAGE, null, nomesProdutos, nomesProdutos[0]);

                    if (produtoEscolhido == null) break;

                    produto produtoSelecionado = produtos.stream()
                            .filter(p -> p.getNome().equals(produtoEscolhido))
                            .findFirst()
                            .orElse(null);

                    String quantidadeStr = JOptionPane.showInputDialog("Informe a quantidade:");
                    if (quantidadeStr == null || quantidadeStr.isEmpty()) break;
                    int quantidade = Integer.parseInt(quantidadeStr);

                    pedido_produto itemCarrinho = new pedido_produto();
                    itemCarrinho.setId_produto(produtoSelecionado.getId());
                    itemCarrinho.setQuantidade(quantidade);
                    carrinho.add(itemCarrinho);

                    int continuar = JOptionPane.showConfirmDialog(null, "Deseja adicionar mais produtos?", "Carrinho",
                            JOptionPane.YES_NO_OPTION);
                    if (continuar == JOptionPane.NO_OPTION) break;
                }

                // 3. Mostrar o Carrinho com Total
                StringBuilder resumoCarrinho = new StringBuilder("Carrinho:\n");
                double totalCarrinho = 0.0;

                for (pedido_produto pp : carrinho) {
                    produto p = prodDAO.buscarProdutoPorId(pp.getId_produto());
                    double subtotal = p.getPreco() * pp.getQuantidade();
                    totalCarrinho += subtotal;

                    resumoCarrinho.append(String.format(
                            "%s - Quantidade: %d - Preço Unitário: R$ %.2f - Subtotal: R$ %.2f\n",
                            p.getNome(),
                            pp.getQuantidade(),
                            p.getPreco(),
                            subtotal
                    ));
                }

                resumoCarrinho.append(String.format("\nTotal do Carrinho: R$ %.2f", totalCarrinho)); // Exibe o total corretamente

                JOptionPane.showMessageDialog(null, resumoCarrinho.toString(), "Carrinho", JOptionPane.INFORMATION_MESSAGE);

                // 4. Cadastro de Endereço
                String cep = JOptionPane.showInputDialog("Digite o CEP:");
                enderecoEntrega = ViaCepService.buscarEnderecoPorCep(cep);

                if (enderecoEntrega == null) {
                    JOptionPane.showMessageDialog(null, "CEP não encontrado. Fassa cadastro manual.");
                    enderecoEntrega = new endereco();
                    enderecoEntrega.setRua(JOptionPane.showInputDialog("Rua:"));
                    enderecoEntrega.setBairro(JOptionPane.showInputDialog("Bairro:"));
                    enderecoEntrega.setCidade(JOptionPane.showInputDialog("Cidade:"));
                    enderecoEntrega.setEstado(JOptionPane.showInputDialog("Estado:"));
                }
                String numeroStr = JOptionPane.showInputDialog("Número:");
                if (numeroStr == null || numeroStr.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Número inválido. Por favor, insira um número válido.");
                    continue;
                }

                long numero = Long.parseLong(numeroStr.trim());
                enderecoEntrega.setNumero(String.valueOf(numero));
                endDAO.cadastrarEndereco(enderecoEntrega);

                // 5. Listar Formas de Pagamento
                List<forma_pagamento> formasPagamento = fpDAO.read();
                String[] formasPagamentoNomes = formasPagamento.stream().map(forma_pagamento::getTipo_pagamento).toArray(String[]::new);
                String formaPagamentoEscolhida = (String) JOptionPane.showInputDialog(
                        null, "Selecione uma Forma de Pagamento:", "Pagamento",
                        JOptionPane.QUESTION_MESSAGE, null, formasPagamentoNomes, formasPagamentoNomes[0]);

                formaPagamento = formasPagamento.stream()
                        .filter(fp -> fp.getTipo_pagamento().equals(formaPagamentoEscolhida))
                        .findFirst()
                        .orElse(null);

                // 6. Finalizar Pedido
                String enderecoResumo = String.format(
                        "\nEndereço de Entrega:\n\nRua: %s\nBairro: %s\nCidade: %s\nEstado: %s\nNúmero: %s",
                        enderecoEntrega.getRua(),
                        enderecoEntrega.getBairro(),
                        enderecoEntrega.getCidade(),
                        enderecoEntrega.getEstado(),
                        enderecoEntrega.getNumero()
                );

                String pedidoResumo = String.format(
                        "Pedido do Restaurante: %s\n%s\n%s",
                        restauranteSelecionado.getNome(),
                        resumoCarrinho.toString(),
                        enderecoResumo
                );

                pedidosRealizados.add(pedidoResumo);

                // Inicia a thread para atualizar o status do pedido
                Thread statusThread = new Thread(new PedidoStatus(pedidoResumo, pedidosRealizados));
                statusThread.start();

                JOptionPane.showMessageDialog(null, "Pedido Finalizado!\n" + enderecoResumo);

            // Visualizar Pedidos
            } else if (escolhaMenu == 1) {
                StringBuilder resumoPedidos = new StringBuilder("Pedidos Realizados:\n");
                for (String pedido : pedidosRealizados) {
                    resumoPedidos.append(pedido).append("\n===================================================================================\n");
                }

                JTextArea textArea = new JTextArea(resumoPedidos.toString());
                textArea.setEditable(false);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(600, 400));
                JOptionPane.showMessageDialog(null, scrollPane, "Pedidos Realizados", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}