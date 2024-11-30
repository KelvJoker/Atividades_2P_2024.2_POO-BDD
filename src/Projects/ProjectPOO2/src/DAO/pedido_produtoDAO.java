package DAO;

import Bean.pedido_produto;
import Conexão.BDD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class pedido_produtoDAO {

    // Método para listar registros de pedido_produto
    public List<pedido_produto> listarPedidoProduto() {
        Connection con = BDD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<pedido_produto> listaPedidoProduto = new ArrayList<>();

        try {
            // Consulta SQL para buscar todos os registros de pedido_produto
            stmt = con.prepareStatement("SELECT * FROM pedido_produto");
            rs = stmt.executeQuery();

            // Itera pelos resultados e mapeia para objetos pedido_produto
            while (rs.next()) {
                pedido_produto pedProd = new pedido_produto();
                pedProd.setId(rs.getInt("id"));
                pedProd.setId_pedido(rs.getInt("id_pedido"));
                pedProd.setId_produto(rs.getInt("id_produto"));
                pedProd.setQuantidade(rs.getInt("quantidade"));

                listaPedidoProduto.add(pedProd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(pedido_produtoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Fecha a conexão e outros recursos
            BDD.closeConnection(con, stmt, rs);
        }

        return listaPedidoProduto;
    }
}