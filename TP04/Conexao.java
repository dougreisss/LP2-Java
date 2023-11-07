import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public Connection getConexao() {

        try {

	String url =
"jdbc:sqlserver://DESKTOP-QPSJVKL\\SQLEXPRESS:56709;databaseName=AulaJava;integratedSecurity=true";

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
