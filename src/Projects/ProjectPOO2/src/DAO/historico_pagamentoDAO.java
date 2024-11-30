package DAO;

import Bean.historico_pagamento;
import Conexão.BDD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class historico_pagamentoDAO {

    // Método para listar registros do histórico de pagamento
    public List<historico_pagamento> listarHistoricoPagamento() {
        Connection con = BDD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<historico_pagamento> listahistorico_pagamento = new ArrayList<>();

        try {
            // Consulta SQL para buscar todos os registros do histórico de pagamento
            stmt = con.prepareStatement("SELECT * FROM historico_pagamento");
            rs = stmt.executeQuery();

            // Itera pelos resultados e mapeia para objetos historico_pagamento
            while (rs.next()) {
                historico_pagamento histPag = new historico_pagamento();
                histPag.setId(rs.getInt("id"));
                histPag.setValor(rs.getString("valor"));
                histPag.setId_forma(rs.getInt("id_forma"));
                histPag.setId_pedido(rs.getInt("id_pedido"));
                histPag.setData(rs.getString("data"));

                listahistorico_pagamento.add(histPag);
            }
        } catch (SQLException ex) {
            Logger.getLogger(historico_pagamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Fecha a conexão e outros recursos
            BDD.closeConnection(con, stmt, rs);
        }

        return listahistorico_pagamento;
    }
}