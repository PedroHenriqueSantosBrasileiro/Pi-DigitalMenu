package br.digitalmenu.view;

import br.digitalmenu.dao.PedidoDao;
import br.digitalmenu.model.Pedido;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Tela_Listar_Pedido extends javax.swing.JInternalFrame {

    public int numeroPedido;
    public int numeroMesa;

    public Tela_Listar_Pedido() throws SQLException {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jtPedido.getModel();
        jtPedido.setRowSorter(new TableRowSorter(modelo));
        listarJTable();
    }

    public void setarCampos(JTable j) {
        if (j.getSelectedRow() != -1) {
            txt_IdPedido.setText(j.getValueAt(j.getSelectedRow(), 0).toString());
            txt_Mesa.setText(j.getValueAt(j.getSelectedRow(), 1).toString());
            txtformated_Total.setText(j.getValueAt(j.getSelectedRow(), 2).toString());
            txtformated_Data.setText(j.getValueAt(j.getSelectedRow(), 3).toString());
            txt_Status.setText(j.getValueAt(j.getSelectedRow(), 5).toString());
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha!");
        }
    }

    public void limparTodosCampos() {
        txt_IdPedido.setText("");
        txt_Mesa.setText("");
        txtformated_Total.setText("");
        txtformated_Data.setText("");
        txt_Status.setText("");
    }

    public void listarJTable() throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jtPedido.getModel();
        modelo.setNumRows(0);
        PedidoDao pedDao = new PedidoDao();
        for (Pedido pedido : pedDao.listarPedido()) {
            modelo.addRow(new Object[]{
                pedido.getIdPedido(),
                pedido.getId_Mesa(),
                pedido.getTotal(),
                pedido.getData(),
                pedido.getHorarioPedido(),
                pedido.getStatus()
            });
        }
    }

    public void listarJTablePorId(int numPedido) throws SQLException {
        DefaultTableModel modelo2 = (DefaultTableModel) jtPedidoUnico.getModel();
        modelo2.setNumRows(0);
        PedidoDao pedDao = new PedidoDao();
        Pedido p = pedDao.listarPedidoPorId(numPedido);
        modelo2.addRow(new Object[]{
            p.getIdPedido(),
            p.getId_Mesa(),
            p.getTotal(),
            p.getData(),
            p.getHorarioPedido(),
            p.getStatus()
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        txtformated_Data = new javax.swing.JFormattedTextField();
        lbl_IdPedido = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        lbl_Mesa = new javax.swing.JLabel();
        lbl_Total = new javax.swing.JLabel();
        lbl_Data = new javax.swing.JLabel();
        lbl_Status = new javax.swing.JLabel();
        txtformated_Total = new javax.swing.JFormattedTextField();
        txt_IdPedido = new javax.swing.JTextField();
        txt_Status = new javax.swing.JTextField();
        txt_Mesa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPedido = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btn_BuscaID = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtStatus1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtPedidoUnico = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        txtformated_Data.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        txtformated_Data.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtformated_Data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtformated_DataActionPerformed(evt);
            }
        });

        lbl_IdPedido.setText("ID Pedido");

        jButton2.setText("ver itens");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lbl_Mesa.setText("Mesa:");

        lbl_Total.setText("Total:");

        lbl_Data.setText("Data:");

        lbl_Status.setText("Status:");

        txtformated_Total.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txt_IdPedido.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txt_Status.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txt_Mesa.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jtPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mesa", "Total", "Data", "Horario", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jtPedidoMouseReleased(evt);
            }
        });
        jtPedido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtPedidoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtPedido);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_IdPedido)
                            .addComponent(lbl_Status))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_Status)
                            .addComponent(txt_IdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lbl_Mesa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_Mesa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_Data)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtformated_Data, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lbl_Total)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtformated_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_IdPedido)
                    .addComponent(lbl_Mesa)
                    .addComponent(lbl_Data)
                    .addComponent(txt_IdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Mesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtformated_Data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Status)
                    .addComponent(lbl_Total)
                    .addComponent(txtformated_Total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

        btn_BuscaID.setText("Buscar Por ID");
        btn_BuscaID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuscaIDActionPerformed(evt);
            }
        });

        jButton1.setText("ver itens");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jtPedidoUnico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mesa", "Total", "Data", "Horario", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtPedidoUnico);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_BuscaID)
                .addGap(18, 18, 18)
                .addComponent(txtStatus1)
                .addGap(37, 37, 37)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_BuscaID)
                    .addComponent(jButton1)
                    .addComponent(txtStatus1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_BuscaIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscaIDActionPerformed
        try {
            listarJTablePorId(Integer.parseInt(txtStatus1.getText()));
            limparTodosCampos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btn_BuscaIDActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        if (jtPedidoUnico.getRowCount() == 1) {
            numeroPedido = Integer.parseInt(String.valueOf(jtPedidoUnico.getValueAt(0, 0)));
            numeroMesa = Integer.parseInt(String.valueOf(jtPedidoUnico.getValueAt(0, 1)));
            try {
                Tela_ItensDoPedido telaItensDoPedido = new Tela_ItensDoPedido(numeroPedido, numeroMesa);
                telaItensDoPedido.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Digite um pedido.");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtPedidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPedidoKeyReleased
        setarCampos(jtPedido);
    }//GEN-LAST:event_jtPedidoKeyReleased

    private void jtPedidoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPedidoMouseReleased
        setarCampos(jtPedido);
    }//GEN-LAST:event_jtPedidoMouseReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (jtPedido.getSelectedRow() != -1) {
            numeroPedido = Integer.parseInt(txt_IdPedido.getText());
            numeroMesa = Integer.parseInt(txt_Mesa.getText());
            try {
                Tela_ItensDoPedido telaItensDoPedido = new Tela_ItensDoPedido(numeroPedido, numeroMesa);
                telaItensDoPedido.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Escolha um pedido!");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtformated_DataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtformated_DataActionPerformed

    }//GEN-LAST:event_txtformated_DataActionPerformed
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
            java.util.logging.Logger.getLogger(Tela_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Tela_Listar_Pedido().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Tela_Listar_Pedido.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_BuscaID;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtPedido;
    private javax.swing.JTable jtPedidoUnico;
    private javax.swing.JLabel lbl_Data;
    private javax.swing.JLabel lbl_IdPedido;
    private javax.swing.JLabel lbl_Mesa;
    private javax.swing.JLabel lbl_Status;
    private javax.swing.JLabel lbl_Total;
    private javax.swing.JTextField txtStatus1;
    private javax.swing.JTextField txt_IdPedido;
    private javax.swing.JTextField txt_Mesa;
    private javax.swing.JTextField txt_Status;
    private javax.swing.JFormattedTextField txtformated_Data;
    private javax.swing.JFormattedTextField txtformated_Total;
    // End of variables declaration//GEN-END:variables
}
