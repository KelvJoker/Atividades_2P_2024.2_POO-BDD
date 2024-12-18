package DAO;

import Bean.historico_entrega;
import Conexão.BDD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class historico_entregaDAO {

    public List<historico_entrega> listarHistoricoEntrega() {
        Connection con = BDD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<historico_entrega> listaHistorico = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT * FROM historico_entrega");
            rs = stmt.executeQuery();

            while (rs.next()) {
                historico_entrega hist = new historico_entrega();
                hist.setId(rs.getInt("id"));
                hist.setId_status_ent(rs.getInt("id_status_ent"));
                hist.setId_pedido(rs.getInt("id_pedido"));
                hist.setDatetime(rs.getString("datetime"));

                listaHistorico.add(hist);
            }
        } catch (SQLException ex) {
            Logger.getLogger(historico_entregaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            BDD.closeConnection(con, stmt, rs);
        }
        return listaHistorico;
    }
}