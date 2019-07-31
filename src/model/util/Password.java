package model.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Classe responsavel pela criptografia da senha
 * 
 * @author Hemenson
 */
public class Password {

    private String password;
    private String typeHash;
    private String passHash;
    
    public Password(String password) {
        this.password = password;
        this.typeHash="SHA-256";
        this.passHash=getHashPassword();
    }

    /**
     * metodo de gerar hash do password armazenado
     *
     * @return o codigo hash do password
     */
    private byte[] getHash() {
        try {
            MessageDigest md = MessageDigest.getInstance(this.typeHash);
            md.update(this.password.getBytes());
            return md.digest();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    /**
     * Metodo de pegar o Hash gerado
     * caso não adicionado uma senha ele retorna null
     * @return o hash
     */
    private String getHashPassword() {
        byte[] bytes= getHash();
        StringBuilder s = new StringBuilder();
        
        if(bytes==null){
            return null;
        }
        
        for (int i = 0; i < bytes.length; i++) {
            int parteAlta = ((bytes[i] >> 4) & 0xf) << 4;
            int parteBaixa = bytes[i] & 0xf;
            if (parteAlta == 0) {
                s.append('0');
            }
            s.append(Integer.toHexString(parteAlta | parteBaixa));
        }
        return s.toString();
    }
    
    public String getPassword(){
        return this.passHash;
    }
    
    /**
     * seta o hash do password
     * @Warning usado apenas em DAO no banco de dados
     * @param password 
     */
    public void setPassword(String password){
        this.passHash= password;
    }
    
}
