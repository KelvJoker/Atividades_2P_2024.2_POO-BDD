package DAO;

import Bean.categoria;
import Conexão.BDD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class categoriaDAO {

    public List<categoria> listarCategorias() {
        Connection con = BDD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<categoria> listaCategorias = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT * FROM categoria");
            rs = stmt.executeQuery();

            while (rs.next()) {
                categoria cat = new categoria();
                cat.setId(rs.getInt("id"));
                cat.setNome(rs.getString("nome"));
                cat.setTipo(rs.getString("tipo"));
                cat.setDescricao(rs.getString("descricao"));
                listaCategorias.add(cat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(categoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            BDD.closeConnection(con, stmt, rs);
        }
        return listaCategorias;
    }
}