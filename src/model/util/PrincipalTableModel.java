package model.util;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.User;
import model.dao.UserDAO;

/**
 *
 * @author Hemenson
 */
public class PrincipalTableModel extends AbstractTableModel {
    
    private List<User> dados;
    private String[] colunas;
    
    public static final int ID = 0;
    public static final int USERNAME = 1;
    public static final int EMAIL = 2;
    public static final int SENHA = 3;
    public static final int CRIACAO = 4;
    public static final int PRIVILEGIO = 5;

    public PrincipalTableModel() {
        //pega os dados do banco de dados e insere na tabela
        atualizarDados();
        
        this.colunas = new String[]{"ID","Username","Email","Senha",
            "Data de Criação","Privilegio"};
    }
    
    @Override
    public int getRowCount() {
        return this.dados.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch(columnIndex){
            case ID:
                this.dados.get(rowIndex).setId(Integer.parseInt(
                        (String) aValue));
            case USERNAME:
                this.dados.get(rowIndex).setUsername((String) aValue);
            case EMAIL:
                this.dados.get(rowIndex).setEmail((String) aValue);
            case SENHA:
                this.dados.get(rowIndex).setHashPassword((String) aValue);
            case CRIACAO:
                this.dados.get(rowIndex).setTsData((Timestamp) aValue);
            case PRIVILEGIO:
                this.dados.get(rowIndex).setPrivilege((String) aValue);
            default:
                throw new IndexOutOfBoundsException("Index invalido!");
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        User u = this.dados.get(rowIndex);
        
        switch(columnIndex){
            case ID:
                return u.getId();
            case USERNAME:
                return u.getUsername();
            case EMAIL:
                return u.getEmail();
            case SENHA:
                return u.getPassword();
            case CRIACAO:
                return u.getTsData();
            case PRIVILEGIO:
                return u.getPrivilege();
            default:
                throw new IndexOutOfBoundsException("Index invalido!");
        }
    }

    @Override
    public String getColumnName(int column) {
        return this.colunas[column];
    }
    
    /**
     * Adiciona uma linha na tabela
     * 
     * @param u
     */
    public void addRow(User u){
        //adiciona no banco
        UserDAO.add(u);
        
        //atualiza o array da tabela
        atualizarDados();
        
        //manda a tabela atualizar
        fireTableDataChanged();
    }
    
    /**
     * Remove uma linha na tabela
     *
     * @param rowIndex
     */
    public void removeRow(int rowIndex){
        //remove do banco
        UserDAO.remove(this.dados.get(rowIndex).getId());
        
        //remove do array
        this.dados.remove(rowIndex);
        
        //remove da tabela
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
    
    /**
     * Metodo responsavel por atualizar o array de acordo com as 
     * informações do banco de dados
     * 
     */
    private void atualizarDados(){
        this.dados = new ArrayList<>(UserDAO.findALL());
    }
}
