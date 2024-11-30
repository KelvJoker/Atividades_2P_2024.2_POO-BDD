package DAO;

import Bean.promocao;
import Conexão.BDD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class promocaoDAO {

    public List<promocao> listarPromocoes() {
        Connection con = BDD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<promocao> listaPromocoes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM promocao");
            rs = stmt.executeQuery();

            while (rs.next()) {
                promocao promo = new promocao();
                promo.setId(rs.getInt("id"));
                promo.setNome(rs.getString("nome"));
                promo.setCodigo(rs.getString("codigo"));
                promo.setTipo(rs.getString("tipo"));
                promo.setValor(rs.getString("valor"));
                promo.setValidade(rs.getString("validade"));

                listaPromocoes.add(promo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(promocaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            BDD.closeConnection(con, stmt, rs);
        }
        return listaPromocoes;
    }
}