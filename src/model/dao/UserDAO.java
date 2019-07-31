package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.User;
import model.util.PrivilegeEnum;

public abstract class UserDAO {

    /**
     * Retorna todos os registros encontrados na tabela do banco de dados
     * 
     * @return
     */
    public static List<User> findALL() {
        String sql = "SELECT * FROM tbuser";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<User> users = new ArrayList<>();

        try(Connection con = ConnectionFactory.getConnection()) {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                User user = new User();

                //Definindo o usuario para posteriomente adicionar na lista
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("user_password"));
                user.setTsData(rs.getTimestamp("create_time"));
                user.setPrivilege(rs.getString("typeprivilege"));

                //adicionando na lista
                users.add(user);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("ERRO: " + ex);
        }finally{
            ConnectionFactory.closeConnection(null, stmt, rs);
        }
        
        return users;
    }

    /**
     * Método responsável por inserir um usuario
     * 
     * @param user
     * @return
     */
    public static boolean add(User user) {
        String sql = "INSERT INTO tbuser(username, email, user_password) VALUES (?, ?, ?)";

        PreparedStatement stmt = null;
        int linhasAft = 0;
        
        try (Connection con = ConnectionFactory.getConnection()){
            stmt = con.prepareStatement(sql);
            
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            
            linhasAft = stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("ERRO: " + ex);
        } finally {
            ConnectionFactory.closeConnection(null, stmt);
        }
        
        return linhasAft>0;
    }

    /**
     * Método responsável por inserir um administrador no banco
     * 
     * @param adm
     * @return
     */
    public static boolean addADM(User adm) {
        String sql = "INSERT INTO tbuser(username, email, user_password, typePrivilege) "
                + "VALUES (?, ?, ?, ?)";

        PreparedStatement stmt = null;
        int linhasAft = 0;
        
        try(Connection con = ConnectionFactory.getConnection()) {
            stmt = con.prepareStatement(sql);
            
            stmt.setString(1, adm.getUsername());
            stmt.setString(2, adm.getEmail());
            stmt.setString(3, adm.getPassword());
            stmt.setString(4, PrivilegeEnum.ADMINISTRADOR.name());
            
            linhasAft = stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("ERRO: " + ex);
        } finally {
            ConnectionFactory.closeConnection(null, stmt);
        }
        
        return linhasAft>0;
    }

    /**
     * Atualiza um usuario
     * 
     * @param user
     * @return
     */
    public static boolean update(User user) {
        String sql = "UPDATE tbuser SET username=?, email=?, user_password=?, "
                + "typePrivilege=? WHERE id=?";

        PreparedStatement stmt = null;
        int linhasAft = 0;
        
        try (Connection con = ConnectionFactory.getConnection()){
            stmt = con.prepareStatement(sql);

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getPrivilege());
            stmt.setInt(5, user.getId());

            linhasAft = stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("ERRO: " + ex.toString());
        } finally {
            ConnectionFactory.closeConnection(null, stmt);
        }
        
        return linhasAft>0;
    }

    /**
     * Deleta um usuario pelo id
     * 
     * @param id
     * @return
     */
    public static boolean remove(int id) {
        String sql = "DELETE FROM tbuser WHERE id= ?";

        PreparedStatement stmt = null;
        int linhasAft = 0;
        
        try (Connection con = ConnectionFactory.getConnection()){
            stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, id);
            
            linhasAft = stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro: " + ex.toString());
        } finally {
            ConnectionFactory.closeConnection(null, stmt);
        }
        
        return linhasAft>0;
    }
    
    /**
     * Pega um usuario pelo id
     * 
     * @param id
     * @return
     */
    public static User getUser(int id){
        String sql="SELECT * FROM tbuser WHERE id= ?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User user = new User();
        
        try (Connection con = ConnectionFactory.getConnection()){
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            rs.next();
            
            //definindo o usuario
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setTsData(rs.getTimestamp("create_time"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("user_password"));
            user.setPrivilege(rs.getString("typePrivilege"));
         
        } catch (SQLException ex) {
            throw new RuntimeException("Erro: "+ex.toString());
        }finally{
            ConnectionFactory.closeConnection(null, stmt, rs);
        }
        
        return user;
    }
    
    
}
