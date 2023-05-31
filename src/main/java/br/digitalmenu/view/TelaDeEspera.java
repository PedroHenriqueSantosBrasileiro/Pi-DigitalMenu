package br.digitalmenu.view;

import br.digitalmenu.dao.PedidoDao;
import br.digitalmenu.model.Pedido;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class TelaDeEspera extends javax.swing.JFrame {

    private int numeroMesa;

    public TelaDeEspera(int numeroMesa) {
        initComponents();
        this.numeroMesa = numeroMesa;
        this.lblNumeroMesa.setText(String.valueOf(this.numeroMesa));
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnIniciarPedido = new javax.swing.JButton();
        lblNumeroMesa = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnIniciarPedido.setBackground(new java.awt.Color(176, 50, 39));
        btnIniciarPedido.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        btnIniciarPedido.setForeground(new java.awt.Color(246, 242, 217));
        btnIniciarPedido.setText("Iniciar Pedido");
        btnIniciarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarPedidoActionPerformed(evt);
            }
        });

        lblNumeroMesa.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblNumeroMesa.setText("nº mesa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(247, Short.MAX_VALUE)
                .addComponent(btnIniciarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(236, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(lblNumeroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(lblNumeroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                .addComponent(btnIniciarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(262, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarPedidoActionPerformed

        PedidoDao pedidoDao = new PedidoDao();
        Pedido pedido = new Pedido();
        pedido.getMesa().setIdMesa(numeroMesa);
        try {
            pedidoDao.adicionarPedido(pedido);
            Tela_Menu telaMenu = new Tela_Menu(pedidoDao.numeroPedido, numeroMesa, false);
            telaMenu.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(TelaDeEspera.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnIniciarPedidoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaDeEspera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDeEspera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDeEspera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDeEspera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarPedido;
    private javax.swing.JLabel lblNumeroMesa;
    // End of variables declaration//GEN-END:variables
}
