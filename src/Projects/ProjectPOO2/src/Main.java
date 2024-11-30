import Bean.*;
import DAO.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        restauranteDAO resDAO = new restauranteDAO();
        produtoDAO prodDAO = new produtoDAO();
        forma_pagamentoDAO fpDAO = new forma_pagamentoDAO();
        enderecoDAO endDAO = new enderecoDAO();

        List<pedido_produto> carrinho = new ArrayList<>();
        endereco enderecoEntrega = null;
        forma_pagamento formaPagamento = null;

        // 1. Listar Restaurantes
        List<restaurante> restaurantes = resDAO.listarRestaurantes();
        if (restaurantes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum restaurante encontrado.");
            return;
        }

        String[] nomesRestaurantes = restaurantes.stream().map(restaurante::getNome).toArray(String[]::new);
        String restauranteEscolhido = (String) JOptionPane.showInputDialog(
                null, "Selecione um Restaurante:", "Restaurantes",
                JOptionPane.QUESTION_MESSAGE, null, nomesRestaurantes, nomesRestaurantes[0]);

        if (restauranteEscolhido == null) return;

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

        // 3. Mostrar o Carrinho
        StringBuilder resumoCarrinho = new StringBuilder("Carrinho:\n");
        for (pedido_produto pp : carrinho) {
            produto p = prodDAO.buscarProdutoPorId(pp.getId_produto());
            resumoCarrinho.append(p.getNome()).append(" - Quantidade: ").append(pp.getQuantidade()).append("\n");
        }
        JOptionPane.showMessageDialog(null, resumoCarrinho.toString(), "Carrinho", JOptionPane.INFORMATION_MESSAGE);

// 4. Cadastro de Endereço
        String cep = JOptionPane.showInputDialog("Digite o CEP:");
        enderecoEntrega = ViaCepService.buscarEnderecoPorCep(cep);

        if (enderecoEntrega == null) {
            JOptionPane.showMessageDialog(null, "CEP não encontrado. Cadastro manual.");
            enderecoEntrega = new endereco();
            enderecoEntrega.setRua(JOptionPane.showInputDialog("Rua:"));
            enderecoEntrega.setBairro(JOptionPane.showInputDialog("Bairro:"));
            enderecoEntrega.setCidade(JOptionPane.showInputDialog("Cidade:"));
            enderecoEntrega.setEstado(JOptionPane.showInputDialog("Estado:"));
        }
        enderecoEntrega.setNumero(String.valueOf(Long.parseLong(JOptionPane.showInputDialog("Número:"))));
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
        JOptionPane.showMessageDialog(null, "Pedido Finalizado!");

        // 7. Atualizar Status do Pedido com Threads
        new Thread(() -> {
            try {
                JOptionPane.showMessageDialog(null, "Status: Em Produção");
                Thread.sleep(3000);
                JOptionPane.showMessageDialog(null, "Status: Saiu para Entrega");
                Thread.sleep(3000);
                JOptionPane.showMessageDialog(null, "Status: Entregue!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // 8. Listar Pedidos Realizados (Simulação)
        JOptionPane.showMessageDialog(null, "Lista de Pedidos Realizados:\n1. Pedido X\n2. Pedido Y", "Pedidos",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
