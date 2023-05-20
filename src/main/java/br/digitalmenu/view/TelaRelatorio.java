package br.digitalmenu.view;

import br.digitalmenu.dao.RelatorioDao;
import br.digitalmenu.heuristicas.Heuristica;
import br.digitalmenu.model.relatorio.ItemRelatorio;
import br.digitalmenu.model.relatorio.PedidoRelatorio;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class TelaRelatorio extends Heuristica {

    public TelaRelatorio() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRelatorio = new javax.swing.JTable();
        btnTopFaturamentoPorProduto = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnTopQtdeVendida = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableRelatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableRelatorio);

        btnTopFaturamentoPorProduto.setText("Top faturamento por produto");
        btnTopFaturamentoPorProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTopFaturamentoPorProdutoActionPerformed(evt);
            }
        });

        jButton2.setText("Total Pedidos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnTopQtdeVendida.setText("Top Qtde Vendidas");
        btnTopQtdeVendida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTopQtdeVendidaActionPerformed(evt);
            }
        });

        jButton1.setText("Total Pedidos por Mês");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTopFaturamentoPorProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                    .addComponent(btnTopQtdeVendida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(41, 41, 41)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 71, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTopFaturamentoPorProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTopQtdeVendida)
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        setSize(new java.awt.Dimension(693, 553));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTopFaturamentoPorProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTopFaturamentoPorProdutoActionPerformed
        apagarTodasColunas(jTableRelatorio);

        DefaultTableModel modelo = (DefaultTableModel) jTableRelatorio.getModel();
        modelo.setNumRows(0);
        modelo.addColumn("Id");
        modelo.addColumn("Produto");
        modelo.addColumn("Preço");
        modelo.addColumn("Qtde Total");
        modelo.addColumn("Total vendas");

        RelatorioDao relatorioDao = new RelatorioDao();
        try {
            for (ItemRelatorio itemRelatorio : relatorioDao.listarItensPorMaiorFaturamento()) {
                modelo.addRow(new Object[]{
                    itemRelatorio.getProduto().getIdProduto(),
                    itemRelatorio.getProduto().getNome(),
                    itemRelatorio.getProduto().getPreco(),
                    itemRelatorio.getQtdeTotalVendida(),
                    itemRelatorio.getValorTotalVendido()
                });
            }

            IniciaTabela(jTableRelatorio);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btnTopFaturamentoPorProdutoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        apagarTodasColunas(jTableRelatorio);
        DefaultTableModel modelo = (DefaultTableModel) jTableRelatorio.getModel();
        modelo.setNumRows(0);
        modelo.addColumn("Total de pedidos");
        modelo.addColumn("Total vendas R$");
        modelo.addColumn("Media por pedido R$");

        RelatorioDao relatorioDao = new RelatorioDao();
        try {
            PedidoRelatorio pedidoRelatorio = relatorioDao.totalPedidos();
            modelo.addRow(new Object[]{
                pedidoRelatorio.getQtdeDePedidos(),
                pedidoRelatorio.getValorTotal(),
                pedidoRelatorio.getMediaTotal() // formatar 2 casas decimais
            });

            IniciaTabela(jTableRelatorio);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnTopQtdeVendidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTopQtdeVendidaActionPerformed
        apagarTodasColunas(jTableRelatorio);

        DefaultTableModel modelo = (DefaultTableModel) jTableRelatorio.getModel();
        modelo.setNumRows(0);

        modelo.addColumn("Id");
        modelo.addColumn("Produto");
        modelo.addColumn("Preço");
        modelo.addColumn("Qtde Total");
        modelo.addColumn("Total vendas");

        RelatorioDao relatorioDao = new RelatorioDao();
        try {
            for (ItemRelatorio itemRelatorio : relatorioDao.listarItensMaisVendidos()) {
                modelo.addRow(new Object[]{
                    itemRelatorio.getProduto().getIdProduto(),
                    itemRelatorio.getProduto().getNome(),
                    itemRelatorio.getProduto().getPreco(),
                    itemRelatorio.getQtdeTotalVendida(),
                    itemRelatorio.getValorTotalVendido()
                });
            }

            IniciaTabela(jTableRelatorio);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btnTopQtdeVendidaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JPanel painel = new JPanel();
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("1");
        comboBox.addItem("2");
        comboBox.addItem("3");
        comboBox.addItem("4");
        comboBox.addItem("5");
        comboBox.addItem("6");
        comboBox.addItem("7");
        comboBox.addItem("8");
        comboBox.addItem("9");
        comboBox.addItem("10");
        comboBox.addItem("11");
        comboBox.addItem("12");
        painel.add(new JLabel("Mês: "));
        painel.add(comboBox);
        int result = JOptionPane.showConfirmDialog(null, painel, "Selecione o Mês.", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                int mes = Integer.parseInt(comboBox.getSelectedItem().toString());
                apagarTodasColunas(jTableRelatorio);
                DefaultTableModel modelo = (DefaultTableModel) jTableRelatorio.getModel();
                modelo.setNumRows(0);
                modelo.addColumn("Total de pedidos");
                modelo.addColumn("Total vendas R$");
                modelo.addColumn("Media por pedido R$");

                RelatorioDao relatorioDao = new RelatorioDao();
                PedidoRelatorio pedidoRelatorio = relatorioDao.totalPedidosPorMes(mes);
                modelo.addRow(new Object[]{
                    pedidoRelatorio.getQtdeDePedidos(),
                    pedidoRelatorio.getValorTotal(),
                    pedidoRelatorio.getMediaTotal() // formatar 2 casas decimais
                });

                IniciaTabela(jTableRelatorio);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void apagarTodasColunas(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableColumnModel columnModel = table.getColumnModel();

        int columnCount = columnModel.getColumnCount();
        for (int i = columnCount - 1; i >= 0; i--) {
            TableColumn column = columnModel.getColumn(i);
            columnModel.removeColumn(column);
            model.setColumnCount(model.getColumnCount() - 1);
        }
    }

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRelatorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTopFaturamentoPorProduto;
    private javax.swing.JButton btnTopQtdeVendida;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableRelatorio;
    // End of variables declaration//GEN-END:variables
}
