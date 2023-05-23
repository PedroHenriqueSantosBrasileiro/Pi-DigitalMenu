package br.digitalmenu.view;

import br.digitalmenu.dao.ItemDao;
import br.digitalmenu.dao.PedidoDao;
import br.digitalmenu.dao.ProdutoDao;
import br.digitalmenu.heuristicas.Heuristica;
import br.digitalmenu.model.Item;
import br.digitalmenu.model.Pedido;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Tela_ResumoPedido extends Heuristica {

    public double valorTotal = 0;
    public DecimalFormat decimalFormat = new DecimalFormat("R$ 0.00");
    public int numeroPedido;
    public int numeroMesa;
    private JFrame tela;

    public Tela_ResumoPedido() {
        initComponents();
    }

    public Tela_ResumoPedido(int numeroPedido, int numeroMesa, JFrame tela) throws SQLException {
        initComponents();
        this.tela = tela;
        this.numeroPedido = numeroPedido;
        this.numeroMesa = numeroMesa;
        lbl_numero_pedido.setText(String.valueOf(numeroPedido));
        lbl_numero_mesa.setText(String.valueOf(numeroMesa));
        IniciaTabela(jtResumo);//Formata a tabela e centraliza pela classe heuristicas
        listarJTable(Integer.parseInt(lbl_numero_pedido.getText()));
    }

    public void listarJTable(int numeroPedido) throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jtResumo.getModel();
        modelo.setNumRows(0);
        ItemDao itensDao = new ItemDao();
        for (Item item : itensDao.listarItensPorPedido(numeroPedido)) {
            ProdutoDao prodDao = new ProdutoDao();
            modelo.addRow(new Object[]{
                item.getProduto().getIdProduto(),
                item.getProduto().getNome(),
                item.getProduto().getPreco(),
                item.getQtde(),
                item.getSubtotal(),
                item.getHoraComanda(),
                item.getStatus()
            }
            );
            valorTotal += item.getSubtotal();
        }

        lbl_valor_total.setText(String.valueOf(decimalFormat.format(valorTotal)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_resumo_pedido = new javax.swing.JPanel();
        pnl_superior = new javax.swing.JPanel();
        lbl_Pedido = new javax.swing.JLabel();
        lbl_numero_pedido = new javax.swing.JLabel();
        lbl_Mesa = new javax.swing.JLabel();
        lbl_numero_mesa = new javax.swing.JLabel();
        lbl_Total = new javax.swing.JLabel();
        lbl_valor_total = new javax.swing.JLabel();
        pnl_tabela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtResumo = new javax.swing.JTable();
        pnl_inferior = new javax.swing.JPanel();
        btn_voltar = new javax.swing.JButton();
        btn_encerrar_pedido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        pnl_resumo_pedido.setBackground(new java.awt.Color(255, 255, 255));

        pnl_superior.setBackground(new java.awt.Color(176, 50, 39));

        lbl_Pedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Pedido.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\pedido.png"));

        lbl_numero_pedido.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        lbl_numero_pedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_numero_pedido.setText("nº");

        lbl_Mesa.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\mesa.png"));

        lbl_numero_mesa.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        lbl_numero_mesa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_numero_mesa.setText("nº");

        lbl_Total.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        lbl_Total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_Total.setText("TOTAL:");

        lbl_valor_total.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        lbl_valor_total.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_valor_total.setText("jLabel4");

        javax.swing.GroupLayout pnl_superiorLayout = new javax.swing.GroupLayout(pnl_superior);
        pnl_superior.setLayout(pnl_superiorLayout);
        pnl_superiorLayout.setHorizontalGroup(
            pnl_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_superiorLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbl_Pedido, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addGap(15, 15, 15)
                .addComponent(lbl_numero_pedido, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addGap(50, 50, 50)
                .addComponent(lbl_Mesa, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addGap(15, 15, 15)
                .addComponent(lbl_numero_mesa, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addGap(155, 155, 155)
                .addComponent(lbl_Total, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_valor_total, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addGap(42, 42, 42))
        );
        pnl_superiorLayout.setVerticalGroup(
            pnl_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_superiorLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnl_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_numero_mesa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                    .addComponent(lbl_Mesa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                    .addComponent(lbl_numero_pedido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                    .addComponent(lbl_Pedido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Total, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                    .addComponent(lbl_valor_total, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );

        jtResumo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Produto", "Preco", "Qtde", "Subtotal", "Hora Pedido", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtResumo);

        javax.swing.GroupLayout pnl_tabelaLayout = new javax.swing.GroupLayout(pnl_tabela);
        pnl_tabela.setLayout(pnl_tabelaLayout);
        pnl_tabelaLayout.setHorizontalGroup(
            pnl_tabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl_tabelaLayout.setVerticalGroup(
            pnl_tabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_tabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnl_inferior.setBackground(new java.awt.Color(176, 50, 39));

        btn_voltar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_voltar.setText("Voltar");
        btn_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltarActionPerformed(evt);
            }
        });

        btn_encerrar_pedido.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_encerrar_pedido.setText("Encerrar Pedido");
        btn_encerrar_pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_encerrar_pedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_inferiorLayout = new javax.swing.GroupLayout(pnl_inferior);
        pnl_inferior.setLayout(pnl_inferiorLayout);
        pnl_inferiorLayout.setHorizontalGroup(
            pnl_inferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_inferiorLayout.createSequentialGroup()
                .addGap(262, 262, 262)
                .addComponent(btn_encerrar_pedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_voltar, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addGap(250, 250, 250))
        );
        pnl_inferiorLayout.setVerticalGroup(
            pnl_inferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_inferiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_inferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_voltar, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(btn_encerrar_pedido, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnl_resumo_pedidoLayout = new javax.swing.GroupLayout(pnl_resumo_pedido);
        pnl_resumo_pedido.setLayout(pnl_resumo_pedidoLayout);
        pnl_resumo_pedidoLayout.setHorizontalGroup(
            pnl_resumo_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
            .addGroup(pnl_resumo_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_resumo_pedidoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pnl_resumo_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnl_superior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnl_tabela, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnl_inferior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        pnl_resumo_pedidoLayout.setVerticalGroup(
            pnl_resumo_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
            .addGroup(pnl_resumo_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_resumo_pedidoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnl_superior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(pnl_tabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(pnl_inferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_resumo_pedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_resumo_pedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        this.dispose();
        try {
            new Tela_Menu(Integer.parseInt(lbl_numero_pedido.getText()), Integer.parseInt(lbl_numero_mesa.getText())).setVisible(true);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }

    }//GEN-LAST:event_btn_voltarActionPerformed

    private void btn_encerrar_pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_encerrar_pedidoActionPerformed

        int confirma = JOptionPane.showConfirmDialog(
                this,
                "Deseja encerrar o pedido?",
                "Encerrar Pedido",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        if (confirma == JOptionPane.YES_OPTION) {
            try {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(Integer.parseInt(lbl_numero_pedido.getText()));
                pedido.setStatus("Encerrado");
                PedidoDao pedidoDao = new PedidoDao();
                pedidoDao.atualizaPedido(pedido);
                JOptionPane.showMessageDialog(null, "Pedido encerrado, um atendente levará a conta até voce");
                this.dispose();
                int novoPedido = JOptionPane.showConfirmDialog(
                        this,
                        "Deseja criar um novo pedido?",
                        "Novo Pedido",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );
                if (novoPedido == JOptionPane.YES_OPTION) {
                    pedido.getMesa().setIdMesa(numeroMesa);
                    pedidoDao.adicionarPedido(pedido);
                    new Tela_Menu(pedidoDao.numeroPedido, numeroMesa).setVisible(true);
                    this.tela.dispose();
                } else {
                    this.dispose();
                    new Tela_Login().setVisible(true);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }

        }
    }//GEN-LAST:event_btn_encerrar_pedidoActionPerformed

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
            java.util.logging.Logger.getLogger(Tela_ResumoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_ResumoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_ResumoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_ResumoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_ResumoPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_encerrar_pedido;
    private javax.swing.JButton btn_voltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtResumo;
    private javax.swing.JLabel lbl_Mesa;
    private javax.swing.JLabel lbl_Pedido;
    private javax.swing.JLabel lbl_Total;
    private javax.swing.JLabel lbl_numero_mesa;
    private javax.swing.JLabel lbl_numero_pedido;
    private javax.swing.JLabel lbl_valor_total;
    private javax.swing.JPanel pnl_inferior;
    private javax.swing.JPanel pnl_resumo_pedido;
    private javax.swing.JPanel pnl_superior;
    private javax.swing.JPanel pnl_tabela;
    // End of variables declaration//GEN-END:variables
}
