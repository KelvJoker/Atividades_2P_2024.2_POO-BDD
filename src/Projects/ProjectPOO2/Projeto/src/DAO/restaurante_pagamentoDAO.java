package DAO;

import Bean.restaurante_pagamento;
import Conexão.BDD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class restaurante_pagamentoDAO {

    public List<restaurante_pagamento> listarRestaurantesPagamentos() {
        Connection con = BDD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<restaurante_pagamento> listaRestaurantePagamento = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM restaurante_pagamento");
            rs = stmt.executeQuery();

            while (rs.next()) {
                restaurante_pagamento rp = new restaurante_pagamento();
                rp.setId_restaurante(rs.getInt("id_restaurante"));
                rp.setId_pagamento(rs.getInt("id_pagamento"));

                listaRestaurantePagamento.add(rp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(restaurante_pagamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            BDD.closeConnection(con, stmt, rs);
        }
        return listaRestaurantePagamento;
    }
}