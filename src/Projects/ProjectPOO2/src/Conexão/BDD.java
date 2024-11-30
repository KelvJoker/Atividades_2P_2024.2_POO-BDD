package Conexão;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BDD {

    // Configurações de conexão
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/projetoif?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "kbdd2";

    // Método para obter conexão
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER); // Carrega o driver
            return DriverManager.getConnection(URL, USER, PASS); // Retorna a conexão
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão:", ex);
        }
    }

    // Fechar conexão, PreparedStatement e ResultSet
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (con != null) con.close();
        } catch (SQLException ex) {
            Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, "Erro ao fechar conexão", ex);
        }
    }

    // Fechar conexão e PreparedStatement
    public static void closeConnection(Connection con, PreparedStatement stmt) {
        closeConnection(con, stmt, null);
    }

    // Fechar apenas conexão
    public static void closeConnection(Connection con) {
        closeConnection(con, null, null);
    }
}

