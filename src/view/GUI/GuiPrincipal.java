package view.GUI;

import model.bean.User;
import model.util.PrincipalTableModel;

public class GuiPrincipal extends javax.swing.JFrame {
    
    private PrincipalTableModel tableModel;
    private String nameUserAtivo;
    
    public GuiPrincipal(String usuario) {
        this.tableModel= new PrincipalTableModel();
        this.nameUserAtivo = usuario;
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbLogin = new javax.swing.JTable();
        tfUsername = new javax.swing.JTextField();
        btSalvar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btRemover = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        lbUsername = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        lbSenha = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        lbBemVindo = new javax.swing.JLabel();
        pfSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(0, 0));
        setMinimumSize(new java.awt.Dimension(568, 418));

        tbLogin.setModel(this.tableModel);
        jScrollPane1.setViewportView(tbLogin);

        tfUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btRemover.setText("Remover");
        btRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverActionPerformed(evt);
            }
        });

        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        lbUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbUsername.setText("Username");
        lbUsername.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEmail.setText("Email");

        lbSenha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSenha.setText("Senha");

        tfEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lbBemVindo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbBemVindo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBemVindo.setText("BEM VINDO, " + this.nameUserAtivo);
        lbBemVindo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        pfSenha.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btRemover)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btLimpar)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(lbBemVindo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(80, 80, 80))
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfUsername))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfEmail))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pfSenha))
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbBemVindo, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(lbEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEmail)
                    .addComponent(tfUsername)
                    .addComponent(pfSenha))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar)
                    .addComponent(btAlterar)
                    .addComponent(btRemover)
                    .addComponent(btLimpar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        this.tfEmail.setText("");
        this.pfSenha.setText("");
        this.tfUsername.setText("");
    }//GEN-LAST:event_btLimparActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        User user = new User();
        
        user.setUsername(this.tfUsername.getText());
        user.setEmail(this.tfEmail.getText());
        user.setHashPassword(String.valueOf(this.pfSenha.getPassword()));
        
        this.tableModel.addRow(user);
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        int indexSelected = this.tbLogin.getSelectedRow();
        
        //se for diferente de -1 então nenhuma linha está selecionada
        if(indexSelected != -1){
            this.tableModel.setValueAt(tfUsername.getText(), indexSelected, 
                    PrincipalTableModel.USERNAME);
            this.tableModel.setValueAt(tfEmail.getText(), indexSelected,
                    PrincipalTableModel.EMAIL);
            this.tableModel.setValueAt(String.valueOf(pfSenha.getPassword()), 
                    indexSelected, PrincipalTableModel.SENHA);
        }
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverActionPerformed
        int indexSelected = this.tbLogin.getSelectedRow();
        
        //se for diferente de -1 então nenhuma linha está selecionada
        if(indexSelected != -1){
            this.tableModel.removeRow(indexSelected);
        }
    }//GEN-LAST:event_btRemoverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btRemover;
    private javax.swing.JButton btSalvar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbBemVindo;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbSenha;
    private javax.swing.JLabel lbUsername;
    private javax.swing.JPasswordField pfSenha;
    private javax.swing.JTable tbLogin;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}
