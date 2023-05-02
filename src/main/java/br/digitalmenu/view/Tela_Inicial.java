package br.digitalmenu.view;

import javax.swing.JOptionPane;

public class Tela_Inicial extends javax.swing.JFrame {

    public Tela_Inicial() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        btn_AbrirPedido = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuMesa = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        mnuCategoria = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        mnuProduto = new javax.swing.JMenu();
        mnuitemProduto = new javax.swing.JMenuItem();
        mnuPedido = new javax.swing.JMenu();
        mnuItemPedido = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_AbrirPedido.setText("ABRIR PEDIDO");
        btn_AbrirPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AbrirPedidoActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(btn_AbrirPedido, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(btn_AbrirPedido)
                .addContainerGap(496, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(btn_AbrirPedido)
                .addContainerGap(327, Short.MAX_VALUE))
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        mnuMesa.setText("Mesa");

        jMenuItem1.setText("MesaDAO");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnuMesa.add(jMenuItem1);

        jMenuBar1.add(mnuMesa);

        mnuCategoria.setText("Categoria");

        jMenuItem2.setText("Categoria DAO");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mnuCategoria.add(jMenuItem2);

        jMenuBar1.add(mnuCategoria);

        mnuProduto.setText("Produto");

        mnuitemProduto.setText("Produto DAO");
        mnuitemProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuitemProdutoActionPerformed(evt);
            }
        });
        mnuProduto.add(mnuitemProduto);

        jMenuBar1.add(mnuProduto);

        mnuPedido.setText("Pedido");

        mnuItemPedido.setText("Pedido");
        mnuItemPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemPedidoActionPerformed(evt);
            }
        });
        mnuPedido.add(mnuItemPedido);

        jMenuBar1.add(mnuPedido);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Tela_Mesa telaMesa = null;
        try {
            telaMesa = new Tela_Mesa();
            jDesktopPane1.add(telaMesa);
            telaMesa.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Tela_Categoria telaCategoria = null;
        try {
            telaCategoria = new Tela_Categoria();
            jDesktopPane1.add(telaCategoria);
            telaCategoria.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btn_AbrirPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AbrirPedidoActionPerformed
        Abrir_Pedido abrirPedido = null;
        try {
            abrirPedido = new Abrir_Pedido();
            jDesktopPane1.add(abrirPedido);
            abrirPedido.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_AbrirPedidoActionPerformed

    private void mnuitemProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuitemProdutoActionPerformed
        Tela_Produto telaProduto = null;
        try {
            telaProduto = new Tela_Produto();
            jDesktopPane1.add(telaProduto);
            telaProduto.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
        }
    }//GEN-LAST:event_mnuitemProdutoActionPerformed

    private void mnuItemPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemPedidoActionPerformed
        Tela_Listar_Pedido telaPedido = null;
        try {
            telaPedido = new Tela_Listar_Pedido();
            jDesktopPane1.add(telaPedido);
            telaPedido.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
        }

    }//GEN-LAST:event_mnuItemPedidoActionPerformed

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
            java.util.logging.Logger.getLogger(Tela_Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_Inicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_AbrirPedido;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenu mnuCategoria;
    private javax.swing.JMenuItem mnuItemPedido;
    private javax.swing.JMenu mnuMesa;
    private javax.swing.JMenu mnuPedido;
    private javax.swing.JMenu mnuProduto;
    private javax.swing.JMenuItem mnuitemProduto;
    // End of variables declaration//GEN-END:variables
}
