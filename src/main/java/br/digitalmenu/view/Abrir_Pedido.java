package br.digitalmenu.view;

import br.digitalmenu.dao.MesaDao;
import br.digitalmenu.dao.PedidoDao;
import br.digitalmenu.model.Mesa;
import br.digitalmenu.model.Pedido;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Abrir_Pedido extends javax.swing.JInternalFrame {

    public Abrir_Pedido() throws SQLException {
        initComponents();
        listarMesa();
    }

    public void listarMesa() throws SQLException {
        MesaDao mesaDao = new MesaDao();
        for (Mesa mesa : mesaDao.listarMesa()) {
            cbox_Mesas.addItem(String.valueOf(mesa.getIdMesa()));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbox_Mesas = new javax.swing.JComboBox<>();
        lbl_Cabecalho = new javax.swing.JLabel();
        btn_AbrirPedido = new javax.swing.JButton();
        lbl_Mesa = new javax.swing.JLabel();

        cbox_Mesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_MesasActionPerformed(evt);
            }
        });

        lbl_Cabecalho.setText("TELA ABRIR PEDIDO");

        btn_AbrirPedido.setText("Abrir Pedido");
        btn_AbrirPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AbrirPedidoActionPerformed(evt);
            }
        });

        lbl_Mesa.setText("MESA:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(lbl_Mesa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbox_Mesas, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Cabecalho)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(btn_AbrirPedido)))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbl_Cabecalho)
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbox_Mesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Mesa))
                .addGap(27, 27, 27)
                .addComponent(btn_AbrirPedido)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AbrirPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AbrirPedidoActionPerformed
        Pedido pedido = new Pedido();
        pedido.setIdPedido(Integer.parseInt(cbox_Mesas.getSelectedItem().toString()));
        PedidoDao pedidoDao = new PedidoDao();
        try {
            pedidoDao.adicionarPedido(pedido);
            int numeroMesa = Integer.parseInt(cbox_Mesas.getSelectedItem().toString());
            Tela_Menu telaMenu = null;
            telaMenu = new Tela_Menu(pedidoDao.numeroPedido, numeroMesa);
            this.dispose();
            telaMenu.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_AbrirPedidoActionPerformed

    private void cbox_MesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_MesasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_MesasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_AbrirPedido;
    private javax.swing.JComboBox<String> cbox_Mesas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_Cabecalho;
    private javax.swing.JLabel lbl_Mesa;
    // End of variables declaration//GEN-END:variables
}
