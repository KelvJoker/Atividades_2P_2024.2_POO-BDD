package DAO;

import Bean.status_entrega;
import Conexão.BDD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class status_entregaDAO {

    public List<status_entrega> read(){
        Connection con = BDD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<status_entrega>  listaStatusEntrega = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM status_entrega");
            rs = stmt.executeQuery();

            while (rs.next()) {
                status_entrega sten = new status_entrega();
                sten.setId(rs.getInt("id"));
                sten.setNome(rs.getString("nome"));
                listaStatusEntrega.add(sten);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listaStatusEntrega;
    }
}
