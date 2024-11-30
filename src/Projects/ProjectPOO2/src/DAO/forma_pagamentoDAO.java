package DAO;

import Bean.forma_pagamento;
import Conexão.BDD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class forma_pagamentoDAO {

    public List<forma_pagamento> read() {
        Connection con = BDD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<forma_pagamento> listaFormaPagamento = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM forma_pagamento");
            rs = stmt.executeQuery();

            while (rs.next()) {
                forma_pagamento fpg = new forma_pagamento();
                fpg.setId(rs.getInt("id"));
                fpg.setTipo_pagamento(rs.getString("tipo_de_pagamento"));
                listaFormaPagamento.add(fpg);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Melhor que RuntimeException, ajuda a debugar
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return listaFormaPagamento;
    }
}
