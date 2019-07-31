package view.GUI;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.User;
import model.dao.UserDAO;
import model.util.Password;

public class GuiLogin extends javax.swing.JFrame {

    public GuiLogin() {
        initComponents();
    }

    @SuppressWarnings("checked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnPrincipal = new javax.swing.JPanel();
        lbLogin = new javax.swing.JLabel();
        lbSenha = new javax.swing.JLabel();
        tfLogin = new javax.swing.JTextField();
        btEntrar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        tfpSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("framePrincipal"); // NOI18N
        setResizable(false);
        setSize(getPreferredSize());

        pnPrincipal.setMinimumSize(getPreferredSize());

        lbLogin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbLogin.setText("LOGIN:");

        lbSenha.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbSenha.setText("SENHA:");

        btEntrar.setText("ENTRAR");
        btEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEntrarActionPerformed(evt);
            }
        });

        btLimpar.setText("LIMPAR");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnPrincipalLayout = new javax.swing.GroupLayout(pnPrincipal);
        pnPrincipal.setLayout(pnPrincipalLayout);
        pnPrincipalLayout.setHorizontalGroup(
            pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPrincipalLayout.createSequentialGroup()
                .addContainerGap(233, Short.MAX_VALUE)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnPrincipalLayout.createSequentialGroup()
                        .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfLogin)
                            .addComponent(tfpSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnPrincipalLayout.createSequentialGroup()
                        .addComponent(btLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btEntrar)))
                .addGap(23, 23, 23))
        );
        pnPrincipalLayout.setVerticalGroup(
            pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfpSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEntrar)
                    .addComponent(btLimpar))
                .addGap(40, 40, 40))
        );

        lbSenha.getAccessibleContext().setAccessibleName("lbSenha");
        tfLogin.getAccessibleContext().setAccessibleName("lbLogin");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
        );

        pnPrincipal.getAccessibleContext().setAccessibleName("pnPrincipal");

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEntrarActionPerformed
        String login = this.tfLogin.getText();
        Password senha = new Password(String.valueOf(this.tfpSenha.getPassword()));
        boolean statsLogin = false;
        
        List<User> users = new ArrayList<>(UserDAO.findALL());

        for (User u : users) {
            if (u.getUsername().equals(login) && u.getPassword().equals(senha.getPassword())) {
                JOptionPane.showMessageDialog(null, "Login Aprovado");
                
                statsLogin=true;
                setVisible(false);
                
                GuiPrincipal gp = new GuiPrincipal(u.getUsername());
                gp.setVisible(true);
            }
        }
        if(!statsLogin)
            JOptionPane.showMessageDialog(null, "Login/Senha: invalido", "Erro", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btEntrarActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        this.tfLogin.setText("");
        this.tfpSenha.setText("");
    }//GEN-LAST:event_btLimparActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEntrar;
    private javax.swing.JButton btLimpar;
    private javax.swing.JLabel lbLogin;
    private javax.swing.JLabel lbSenha;
    private javax.swing.JPanel pnPrincipal;
    private javax.swing.JTextField tfLogin;
    private javax.swing.JPasswordField tfpSenha;
    // End of variables declaration//GEN-END:variables
}
