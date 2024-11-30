package DAO;

import Bean.pedido;
import Conexão.BDD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class pedidoDAO {

    // Método para listar registros de pedidos
    public List<pedido> listarPedidos() {
        Connection con = BDD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<pedido> listaPedidos = new ArrayList<>();

        try {
            // Consulta SQL para buscar todos os registros de pedidos
            stmt = con.prepareStatement("SELECT * FROM pedido");
            rs = stmt.executeQuery();

            // Itera pelos resultados e mapeia para objetos pedido
            while (rs.next()) {
                pedido ped = new pedido();
                ped.setId(rs.getInt("id"));
                ped.setId_restaurante(rs.getInt("id_restaurante"));
                ped.setValor(rs.getInt("valor"));
                ped.setTaxa_entrega(rs.getInt("taxa_entrega"));
                ped.setId_promocao(rs.getInt("id_promocao"));
                ped.setId_status_entrega(rs.getInt("id_status_entrega"));
                ped.setId_forma_pagamento(rs.getInt("id_forma_pagamento"));
                ped.setTroco(rs.getInt("troco"));
                ped.setId_endereco(rs.getInt("id_endereco"));
                ped.setData(rs.getString("data"));
                ped.setObservacao(rs.getString("observacao"));

                listaPedidos.add(ped);
            }
        } catch (SQLException ex) {
            Logger.getLogger(pedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Fecha a conexão e outros recursos
            BDD.closeConnection(con, stmt, rs);
        }

        return listaPedidos;
    }
}