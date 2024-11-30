package DAO;

import Bean.endereco;
import Conexão.BDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class enderecoDAO {

    public endereco buscarEnderecoPorCep(String cep) {
        Connection con = BDD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        endereco end = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM endereco WHERE cep = ?");
            stmt.setString(1, cep);
            rs = stmt.executeQuery();

            if (rs.next()) {
                end = new endereco();
                end.setId(rs.getInt("id"));
                end.setRua(rs.getString("rua"));
                end.setNumero(rs.getString("numero"));
                end.setBairro(rs.getString("bairro"));
                end.setCidade(rs.getString("cidade"));
                end.setEstado(rs.getString("estado"));
                end.setComplemento(rs.getString("complemento"));
                end.setPontoReferencia(rs.getString("ponto_referencia"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            BDD.closeConnection(con, stmt, rs);
        }

        return end;
    }

    public void cadastrarEndereco(endereco end) {
        Connection con = BDD.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO endereco (rua, numero, bairro, cidade, estado, complemento, ponto_referencia) VALUES (?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, end.getRua());
            stmt.setString(2, end.getNumero());
            stmt.setString(3, end.getBairro());
            stmt.setString(4, end.getCidade());
            stmt.setString(5, end.getEstado());
            stmt.setString(6, end.getComplemento());
            stmt.setString(7, end.getPontoReferencia());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            BDD.closeConnection(con, stmt);
        }
    }
}