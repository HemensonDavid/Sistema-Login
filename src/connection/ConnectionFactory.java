package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String DATABASE = "dbgerenciamento";
    private static final String URL="jdbc:mysql://localhost:3306/"+DATABASE;
    private static final String USER="root";
    private static final String PASS="";

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("ERRO AO ABRIR CONEXÃO", ex);
        }
    }
    
    public static void closeConnection(Connection con){
        if(con != null){
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println("ERRO AO FECHAR CONEXÃO:\n "+ex);
            }
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt){
        closeConnection(con);
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.err.println("ERRO AO FECHAR CONEXÃO -preparedStatement:\n "+ex);
            }
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        closeConnection(con, stmt);
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println("ERRO AO FECHAR CONEXÃO -resultSet:\n "+ex);
            }
        }
    }
}
