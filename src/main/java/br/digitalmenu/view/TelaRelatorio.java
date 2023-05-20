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

        pnlGlobal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRelatorio = new javax.swing.JTable();
        pnlPesquisar = new javax.swing.JPanel();
        btnTotalPedidos = new javax.swing.JButton();
        btnTopQtdeVendida = new javax.swing.JButton();
        btnTopFaturamentoPorProduto = new javax.swing.JButton();
        btnTotalMes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlGlobal.setBackground(new java.awt.Color(255, 255, 255));

        jTableRelatorio.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTableRelatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableRelatorio.setRowHeight(30);
        jScrollPane1.setViewportView(jTableRelatorio);

        pnlPesquisar.setBackground(new java.awt.Color(246, 242, 233));
        pnlPesquisar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Relatório", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24))); // NOI18N

        btnTotalPedidos.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnTotalPedidos.setText("Total Pedidos");
        btnTotalPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalPedidosActionPerformed(evt);
            }
        });

        btnTopQtdeVendida.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnTopQtdeVendida.setText("Top Qtde Vendidas");
        btnTopQtdeVendida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTopQtdeVendidaActionPerformed(evt);
            }
        });

        btnTopFaturamentoPorProduto.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnTopFaturamentoPorProduto.setText("Top Faturamento por Produto");
        btnTopFaturamentoPorProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTopFaturamentoPorProdutoActionPerformed(evt);
            }
        });

        btnTotalMes.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnTotalMes.setText("Total Pedidos por Mês");
        btnTotalMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalMesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPesquisarLayout = new javax.swing.GroupLayout(pnlPesquisar);
        pnlPesquisar.setLayout(pnlPesquisarLayout);
        pnlPesquisarLayout.setHorizontalGroup(
            pnlPesquisarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPesquisarLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(btnTotalPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTopQtdeVendida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTopFaturamentoPorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTotalMes, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        pnlPesquisarLayout.setVerticalGroup(
            pnlPesquisarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPesquisarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPesquisarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTotalPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(btnTopQtdeVendida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTopFaturamentoPorProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTotalMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlGlobalLayout = new javax.swing.GroupLayout(pnlGlobal);
        pnlGlobal.setLayout(pnlGlobalLayout);
        pnlGlobalLayout.setHorizontalGroup(
            pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGlobalLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        pnlGlobalLayout.setVerticalGroup(
            pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGlobalLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(pnlPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                .addGap(193, 193, 193))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGlobal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGlobal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1414, 807));
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
                    String.format("%.2f", itemRelatorio.getProduto().getPreco()),
                    itemRelatorio.getQtdeTotalVendida(),
                    String.format("%.2f", itemRelatorio.getValorTotalVendido()),});
            }

            jTableRelatorio.getTableHeader().setDefaultRenderer(new CorDoCabecalho());//Muda cor do header na classe heuristica
            IniciaTabela(jTableRelatorio);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btnTopFaturamentoPorProdutoActionPerformed

    private void btnTotalPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalPedidosActionPerformed
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
                String.format("%.2f", pedidoRelatorio.getValorTotal()),
                String.format("%.2f", pedidoRelatorio.getMediaTotal()),
            });

            jTableRelatorio.getTableHeader().setDefaultRenderer(new CorDoCabecalho());//Muda cor do header na classe heuristica
            IniciaTabela(jTableRelatorio);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btnTotalPedidosActionPerformed

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
                    String.format("%.2f", itemRelatorio.getProduto().getPreco()),
                    itemRelatorio.getQtdeTotalVendida(),
                    String.format("%.2f", itemRelatorio.getValorTotalVendido()),});
            }

            jTableRelatorio.getTableHeader().setDefaultRenderer(new CorDoCabecalho());//Muda cor do header na classe heuristica
            IniciaTabela(jTableRelatorio);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btnTopQtdeVendidaActionPerformed

    private void btnTotalMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalMesActionPerformed
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
                    String.format("%.2f", pedidoRelatorio.getValorTotal()),
                    String.format("%.2f", pedidoRelatorio.getMediaTotal()), //pedidoRelatorio.getMediaTotal() // formatar 2 casas decimais
                });

                jTableRelatorio.getTableHeader().setDefaultRenderer(new CorDoCabecalho());//Muda cor do header na classe heuristica
                IniciaTabela(jTableRelatorio);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnTotalMesActionPerformed

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
    private javax.swing.JButton btnTotalMes;
    private javax.swing.JButton btnTotalPedidos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableRelatorio;
    private javax.swing.JPanel pnlGlobal;
    private javax.swing.JPanel pnlPesquisar;
    // End of variables declaration//GEN-END:variables
}
