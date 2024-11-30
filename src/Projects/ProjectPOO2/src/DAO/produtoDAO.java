package DAO;

import Bean.produto;
import Conexão.BDD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class produtoDAO {

    public List<produto> listarProdutosPorRestaurante(int restauranteId) {
        Connection con = BDD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM produto WHERE restaurante_id = ?");
            stmt.setInt(1, restauranteId);
            rs = stmt.executeQuery();

            while (rs.next()) {
                produto prod = new produto();
                prod.setId(rs.getInt("id"));
                prod.setNome(rs.getString("nome"));
                prod.setPreco((int) rs.getDouble("preco"));
                prod.setCategoria_id(rs.getInt("categoria_id"));
                prod.setRestaurante_id(rs.getInt("restaurante_id"));
                prod.setDescricao(rs.getString("descricao"));
                produtos.add(prod);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            BDD.closeConnection(con, stmt, rs);
        }
        return produtos;
    }

    public produto buscarProdutoPorId(int produtoId) {
        Connection con = BDD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        produto prod = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM produto WHERE id = ?");
            stmt.setInt(1, produtoId);
            rs = stmt.executeQuery();

            if (rs.next()) {
                prod = new produto();
                prod.setId(rs.getInt("id"));
                prod.setNome(rs.getString("nome"));
                prod.setPreco((int) rs.getDouble("preco"));
                prod.setCategoria_id(rs.getInt("categoria_id"));
                prod.setRestaurante_id(rs.getInt("restaurante_id"));
                prod.setDescricao(rs.getString("descricao"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            BDD.closeConnection(con, stmt, rs);
        }
        return prod;
    }
}