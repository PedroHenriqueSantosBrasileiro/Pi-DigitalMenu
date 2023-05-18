package br.digitalmenu.view;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import br.digitalmenu.dao.MesaDao;
import br.digitalmenu.dao.PedidoDao;
import br.digitalmenu.dao.UsuarioDAO;
import br.digitalmenu.model.Mesa;
import br.digitalmenu.model.Pedido;
import br.digitalmenu.model.Usuario;
import javax.swing.JRootPane;

public class Tela_Login extends javax.swing.JFrame {

    public Tela_Login() throws SQLException {
        initComponents();
        //para popular o combobox
        listarMesa();

        //coloca o focu no botao ok
        this.getRootPane().setDefaultButton(btnOkUsuario);
        
        //Tira o minimizar/maximizar e fechar tela[testando]
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
    }

    public void listarMesa() throws SQLException {
        MesaDao mesaDao = new MesaDao();
        for (Mesa mesa : mesaDao.listarTodasMesasPorStatus("ATIVADO")) {//lista todas as mesas ativas
            cboMesa.addItem(String.valueOf(mesa.getIdMesa()));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnl = new javax.swing.JPanel();
        disable = new javax.swing.JLabel();
        show = new javax.swing.JLabel();
        cboMesa = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnOkMesa = new javax.swing.JButton();
        txtLogin = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        btnOkUsuario = new javax.swing.JButton();
        lblSenha = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        Fechar = new javax.swing.JButton();
        wallp = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 255, 102));
        setForeground(new java.awt.Color(204, 255, 51));

        pnl.setLayout(null);

        disable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        disable.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\eyeclose.png"));
        disable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        disable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                disableMouseClicked(evt);
            }
        });
        pnl.add(disable);
        disable.setBounds(280, 270, 27, 30);

        show.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        show.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\eyeopen.png"));
        show.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showMouseClicked(evt);
            }
        });
        pnl.add(show);
        show.setBounds(280, 270, 27, 30);

        cboMesa.setBackground(new java.awt.Color(255, 232, 142));
        cboMesa.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        cboMesa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar" }));
        cboMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMesaActionPerformed(evt);
            }
        });
        pnl.add(cboMesa);
        cboMesa.setBounds(110, 380, 120, 30);

        jLabel3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("N°Mesa");
        pnl.add(jLabel3);
        jLabel3.setBounds(60, 390, 45, 15);

        jLabel4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Logar como mesa");
        pnl.add(jLabel4);
        jLabel4.setBounds(90, 350, 170, 21);

        btnOkMesa.setBackground(new java.awt.Color(255, 243, 198));
        btnOkMesa.setText("Ok");
        btnOkMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkMesaActionPerformed(evt);
            }
        });
        pnl.add(btnOkMesa);
        btnOkMesa.setBounds(150, 420, 45, 30);
        pnl.add(txtLogin);
        txtLogin.setBounds(80, 230, 194, 30);
        pnl.add(txtSenha);
        txtSenha.setBounds(80, 270, 194, 30);

        btnOkUsuario.setBackground(new java.awt.Color(255, 227, 117));
        btnOkUsuario.setText("Ok");
        btnOkUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkUsuarioActionPerformed(evt);
            }
        });
        pnl.add(btnOkUsuario);
        btnOkUsuario.setBounds(150, 310, 45, 30);

        lblSenha.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        lblSenha.setForeground(new java.awt.Color(255, 255, 255));
        lblSenha.setText("Senha");
        lblSenha.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnl.add(lblSenha);
        lblSenha.setBounds(40, 270, 40, 30);

        jLabel9.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Logar como usuário");
        pnl.add(jLabel9);
        jLabel9.setBounds(90, 200, 190, 21);

        lblLogin.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        lblLogin.setForeground(new java.awt.Color(255, 255, 255));
        lblLogin.setText("Login");
        pnl.add(lblLogin);
        lblLogin.setBounds(40, 230, 40, 30);

        Fechar.setBackground(new java.awt.Color(255, 0, 51));
        Fechar.setText("X");
        Fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FecharActionPerformed(evt);
            }
        });
        pnl.add(Fechar);
        Fechar.setBounds(750, 0, 35, 28);

        wallp.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\fundo.png"));
        pnl.add(wallp);
        wallp.setBounds(0, 0, 790, 560);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(787, 547));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void disableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_disableMouseClicked
        txtSenha.setEchoChar((char) 0);
        disable.setVisible(false);
        disable.setEnabled(false);
        show.setEnabled(true);
        show.setEnabled(true);
        show.setEnabled(true);

        disable.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\eyeopen.png"));
    }//GEN-LAST:event_disableMouseClicked

    private void showMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMouseClicked
        txtSenha.setEchoChar((char) 8226);
        disable.setVisible(true);
        disable.setEnabled(true);
        show.setEnabled(false);
        show.setEnabled(false);

        disable.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\eyeclose.png"));
    }//GEN-LAST:event_showMouseClicked

    private void cboMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMesaActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_cboMesaActionPerformed

    private void btnOkMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkMesaActionPerformed
        MesaDao mDao = new MesaDao();
        if (cboMesa.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Escolha uma mesa! ", "Mesa não definida!", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                int numeroMesa = Integer.parseInt(cboMesa.getSelectedItem().toString());
                
                if (mDao.checkMesa(numeroMesa)) {//Verifica se a mesa realmente existe e esta ativa
                    
                    TelaDeEspera telaDeEspera = new TelaDeEspera(numeroMesa);
                    telaDeEspera.setVisible(true);
                    
                    this.dispose();
                    
                    JOptionPane.showMessageDialog(null, String.format("Bem-Vindo!: [Mesa: %d]",
                        numeroMesa), "Bem-Vindo!", JOptionPane.INFORMATION_MESSAGE);


                } else {
                    JOptionPane.showMessageDialog(null, "Mesa invalida! ", "Mesa não está em uso, ative o status da mesa!", JOptionPane.WARNING_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Tela_Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            

        }
    }//GEN-LAST:event_btnOkMesaActionPerformed

    private void btnOkUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkUsuarioActionPerformed
        UsuarioDAO userDAO = new UsuarioDAO();
        //Usuario user = new Usuario();

        String usuario = null;
        String tipoAcesso = null;//VARIAVEL TEMPORARIA DO TIPO DE ACESSO

        if (txtLogin.getText().length() < 1) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Login!");
        } else if (txtSenha.getText().length() < 1) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Senha!");
        } else {
            try {
                if (userDAO.checkLogin(txtLogin.getText(), txtSenha.getText())) {//pega login e senha e manda para checkar
                    String login = txtLogin.getText();

                    //JOptionPane.showMessageDialog(null, "usuario: " + userDAO.buscaPorId(login), "Bem-vindo!", JOptionPane.INFORMATION_MESSAGE);
                    for (Usuario user : userDAO.buscaPorUsuario(login)) {
                        System.out.println(user.getIdusuario());
                        System.out.println(user.getUsuario());
                        System.out.println(user.getSenha());
                        System.out.println(user.getTipoacesso());
                        System.out.println(user.getStatus());

                        tipoAcesso = user.getTipoacesso();
                        usuario = user.getUsuario();

                    }

                    System.out.println("acesso é:" + tipoAcesso);
                    if (tipoAcesso.equalsIgnoreCase("administrador")) {
                        JOptionPane.showMessageDialog(null, "[Administrador] " + login, "Bem-vindo!", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();//fecha a tela login
                        new Tela_Admin(usuario, tipoAcesso).setVisible(true);//abre a tela admin

                    } else if (tipoAcesso.equalsIgnoreCase("atendente")) {
                        JOptionPane.showMessageDialog(null, "[Atendente] " + login, "Bem-vindo!", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();//fecha a tela login
                        new Tela_Atendente(usuario, tipoAcesso).setVisible(true);//abre a tela atendente

                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario sem acesso! " + login, "Usuario não cadastrado!", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos! ", "Verifique os dados inseridos!", JOptionPane.WARNING_MESSAGE);
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERRO: " + ex.getMessage());
            }

        }
    }//GEN-LAST:event_btnOkUsuarioActionPerformed

    private void FecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FecharActionPerformed

        System.exit(0);
    }//GEN-LAST:event_FecharActionPerformed
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    //new TelaLogin().setVisible(true);
                    new Tela_Login().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Tela_Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Fechar;
    private javax.swing.JButton btnOkMesa;
    private javax.swing.JButton btnOkUsuario;
    public javax.swing.JComboBox cboMesa;
    private javax.swing.JLabel disable;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JPanel pnl;
    private javax.swing.JLabel show;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JLabel wallp;
    // End of variables declaration//GEN-END:variables
}
