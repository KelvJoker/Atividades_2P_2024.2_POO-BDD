package DAO;

import Bean.restaurante;
import Conexão.BDD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class restauranteDAO {

    public List<restaurante> listarRestaurantes() {
        Connection con = BDD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<restaurante> listaRestaurantes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM restaurante");
            rs = stmt.executeQuery();

            while (rs.next()) {
                restaurante res = new restaurante();
                res.setId(rs.getInt("id"));
                res.setEnd_id(rs.getInt("end_id"));
                res.setCat_id(rs.getInt("cat_id"));
                res.setIs_retirada(rs.getInt("is_retirada"));
                res.setNome(rs.getString("nome"));
                res.setTelefone(rs.getString("telefone"));
                res.setHora_funcio(rs.getString("hora_funcio"));

                listaRestaurantes.add(res);
            }
        } catch (SQLException ex) {
            Logger.getLogger(restauranteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            BDD.closeConnection(con, stmt, rs);
        }
        return listaRestaurantes;
    }
}