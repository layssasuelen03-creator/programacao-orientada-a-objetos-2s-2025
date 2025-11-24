package br.estoque.database;
import java.sql.*;
public class ConexaoBD {
    private static final String URL = "jdbc:mysql://localhost:3306/estoque?serverTimezone=UTC&useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "";
    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
