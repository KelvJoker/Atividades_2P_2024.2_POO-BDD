package DAO;

import Bean.avaliacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Conexão.BDD;

public class avaliacaoDAO {

    public List<avaliacao> read() {
        Connection con = BDD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<avaliacao> avaliacoes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM avaliacao");
            rs = stmt.executeQuery();

            while (rs.next()) {
                avaliacao av = new avaliacao();
                av.setId(rs.getInt("id"));
                av.setNota(rs.getInt("nota"));
                av.setPedido(rs.getInt("pedido"));
                av.setRestaurante(rs.getInt("restaurante"));

                avaliacoes.add(av);
            }
        } catch (SQLException ex) {
            Logger.getLogger(avaliacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            BDD.closeConnection(con, stmt, rs);
        }

        return avaliacoes;
    }
}
