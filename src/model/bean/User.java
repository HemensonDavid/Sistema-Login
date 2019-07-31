package model.bean;

import java.sql.Timestamp;
import model.util.Password;

import model.util.PrivilegeEnum;

public class User {

    private int id;
    private String username;
    private String email;
    private Password password;
    private Timestamp tsData;
    private String privilege;

    public User() {
        this.password=new Password("");
        this.privilege= PrivilegeEnum.USER.name();
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = new Password(password);
        this.privilege = PrivilegeEnum.USER.name();
    }

    public User(int id, String username, String email, String password, PrivilegeEnum privilege) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = new Password(password);
        this.privilege = privilege.name();
    }

    public User(String username, String email, String password, PrivilegeEnum privilege) {
        this.username = username;
        this.email = email;
        this.password = new Password(password);
        this.privilege = privilege.name();
    }
    
    public User(int id, String username, String email, String password, 
            Timestamp tsData, PrivilegeEnum privilege) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = new Password(password);
        this.tsData = tsData;
        this.privilege = privilege.name();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }
    
    public void setPrivilege(PrivilegeEnum privilege) {
        this.privilege = privilege.name();
    }

    /**
     * Gera um hash da senha passada
     * alterando a mesma
     * @param newPassword
     */
    public void setHashPassword(String newPassword) {
        this.password = new Password(newPassword);
    }
    
    public void setPassword(String password){
        this.password.setPassword(password);
    }

    public String getPassword() {
        return this.password.getPassword();
    }

    public String getTsData() {
        return tsData.toString();
    }

    public void setTsData(Timestamp tsData) {
        this.tsData = tsData;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", email=" + email + 
                ", password=" + password.getPassword() + ", tsData=" + tsData + 
                ", privilege=" + privilege + '}';
    }

}
