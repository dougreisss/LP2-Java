import java.sql.*;

public class Conexao {

    public Connection getConexao() {

        try {
            String url = "jdbc:sqlserver://localhost;databaseName=aulaJava;integratedSecurity=true";
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
