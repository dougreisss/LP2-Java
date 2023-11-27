import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public Connection getConexao() {

        try {
<<<<<<< HEAD
            String url = "jdbc:sqlserver://DESKTOP-LKHA5RN\\SQLEXPRESS;databaseName=aulajava;integratedSecurity=true;Trusted_Connection=true";
            Connection con;
=======

	String url =
"jdbc:sqlserver://DESKTOP-QPSJVKL\\SQLEXPRESS:56709;databaseName=AulaJava;integratedSecurity=true";

            	Connection con;
>>>>>>> 35c4eaa2b32d98083c3199b10eeb3e4d4b145b0c

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
