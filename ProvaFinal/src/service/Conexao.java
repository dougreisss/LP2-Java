package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public Connection getConexao() {
        try {
            String url = "jdbc:sqlserver://DESKTOP-LKHA5RN\\SQLEXPRESS;databaseName=aulajava;integratedSecurity=true;Trusted_Connection=true";
            Connection con;

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            con = DriverManager.getConnection(url);
            return con;

        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC não encontrado.");
            return null;
        } catch (SQLException e) {
            System.err.println("Erro ao estabelecer a conexão: " + e.getMessage());
            return null;
        }
    }
}
