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
        lbl_NumeroPedido.setText(String.valueOf(numeroPedido));
        lbl_NumeroMesa.setText(String.valueOf(numeroMesa));
        
        jtResumo.getTableHeader().setDefaultRenderer(new CorDoCabecalho());//Muda cor do header na classe heuristica
        IniciaTabela(jtResumo);//Formata a tabela e centraliza pela classe heuristicas
        listarJTable(Integer.parseInt(lbl_NumeroPedido.getText()));
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
                String.format("%.2f", item.getProduto().getPreco()),
                item.getQtde(),
                String.format("%.2f", item.getSubtotal()),
                item.getHoraComanda(),
                item.getStatus()
            }
            );
            valorTotal += item.getSubtotal();
        }

        lbl_ValorTotal.setText(String.valueOf(decimalFormat.format(valorTotal)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGlobal = new javax.swing.JPanel();
        pnlSuperior = new javax.swing.JPanel();
        lbl_Pedido = new javax.swing.JLabel();
        lbl_Mesa = new javax.swing.JLabel();
        lbl_Total = new javax.swing.JLabel();
        lbl_NumeroPedido = new javax.swing.JLabel();
        lbl_NumeroMesa = new javax.swing.JLabel();
        lbl_ValorTotal = new javax.swing.JLabel();
        pnlTabela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtResumo = new javax.swing.JTable();
        pnlInferior = new javax.swing.JPanel();
        btn_Voltar = new javax.swing.JButton();
        btn_Encerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        pnlGlobal.setBackground(new java.awt.Color(255, 255, 255));

        pnlSuperior.setBackground(new java.awt.Color(176, 50, 39));

        lbl_Pedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Pedido.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\pedido.png"));

        lbl_Mesa.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\mesa.png"));

        lbl_Total.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        lbl_Total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_Total.setText("TOTAL:");

        lbl_NumeroPedido.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        lbl_NumeroPedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_NumeroPedido.setText("nº");

        lbl_NumeroMesa.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        lbl_NumeroMesa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_NumeroMesa.setText("nº");

        lbl_ValorTotal.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        lbl_ValorTotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_ValorTotal.setText("jLabel4");

        javax.swing.GroupLayout pnlSuperiorLayout = new javax.swing.GroupLayout(pnlSuperior);
        pnlSuperior.setLayout(pnlSuperiorLayout);
        pnlSuperiorLayout.setHorizontalGroup(
            pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSuperiorLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbl_Pedido, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addGap(15, 15, 15)
                .addComponent(lbl_NumeroPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addGap(50, 50, 50)
                .addComponent(lbl_Mesa, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addGap(15, 15, 15)
                .addComponent(lbl_NumeroMesa, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addGap(155, 155, 155)
                .addComponent(lbl_Total, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_ValorTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addGap(42, 42, 42))
        );
        pnlSuperiorLayout.setVerticalGroup(
            pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSuperiorLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_NumeroMesa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                    .addComponent(lbl_Mesa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                    .addComponent(lbl_NumeroPedido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                    .addComponent(lbl_Pedido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Total, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                    .addComponent(lbl_ValorTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );

        jtResumo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
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
        jtResumo.setRowHeight(25);
        jScrollPane1.setViewportView(jtResumo);
        if (jtResumo.getColumnModel().getColumnCount() > 0) {
            jtResumo.getColumnModel().getColumn(0).setMinWidth(5);
            jtResumo.getColumnModel().getColumn(0).setPreferredWidth(5);
            jtResumo.getColumnModel().getColumn(1).setMinWidth(200);
            jtResumo.getColumnModel().getColumn(1).setPreferredWidth(200);
            jtResumo.getColumnModel().getColumn(6).setMinWidth(100);
            jtResumo.getColumnModel().getColumn(6).setPreferredWidth(100);
        }

        javax.swing.GroupLayout pnlTabelaLayout = new javax.swing.GroupLayout(pnlTabela);
        pnlTabela.setLayout(pnlTabelaLayout);
        pnlTabelaLayout.setHorizontalGroup(
            pnlTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlTabelaLayout.setVerticalGroup(
            pnlTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlInferior.setBackground(new java.awt.Color(176, 50, 39));

        btn_Voltar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_Voltar.setText("Voltar");
        btn_Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VoltarActionPerformed(evt);
            }
        });

        btn_Encerrar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_Encerrar.setText("Encerrar Pedido");
        btn_Encerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EncerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInferiorLayout = new javax.swing.GroupLayout(pnlInferior);
        pnlInferior.setLayout(pnlInferiorLayout);
        pnlInferiorLayout.setHorizontalGroup(
            pnlInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInferiorLayout.createSequentialGroup()
                .addGap(262, 262, 262)
                .addComponent(btn_Encerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Voltar, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addGap(250, 250, 250))
        );
        pnlInferiorLayout.setVerticalGroup(
            pnlInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInferiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Voltar, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(btn_Encerrar, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlGlobalLayout = new javax.swing.GroupLayout(pnlGlobal);
        pnlGlobal.setLayout(pnlGlobalLayout);
        pnlGlobalLayout.setHorizontalGroup(
            pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
            .addGroup(pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGlobalLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlTabela, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlInferior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        pnlGlobalLayout.setVerticalGroup(
            pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
            .addGroup(pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlGlobalLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnlSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(pnlTabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(pnlInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
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

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VoltarActionPerformed

        this.dispose();
        //Reabre a tela menu com os atributos mesa e pedido
        try {
            new Tela_Menu(Integer.parseInt(lbl_NumeroPedido.getText()), Integer.parseInt(lbl_NumeroMesa.getText())).setVisible(true);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }

    }//GEN-LAST:event_btn_VoltarActionPerformed

    private void btn_EncerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EncerrarActionPerformed

        int confirma = JOptionPane.showConfirmDialog(
                this,
                "Deseja encerrar o pedido?",
                "Encerrar Pedido",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        if (confirma == JOptionPane.YES_OPTION) {
            try {
                //Fecha pedido
                Pedido pedido = new Pedido();
                pedido.setIdPedido(Integer.parseInt(lbl_NumeroPedido.getText()));
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

                    // enviar para a nova tela de ver menu e abir pedido, msm assim essa ta com erro.
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
    }//GEN-LAST:event_btn_EncerrarActionPerformed

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
    private javax.swing.JButton btn_Encerrar;
    private javax.swing.JButton btn_Voltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtResumo;
    private javax.swing.JLabel lbl_Mesa;
    private javax.swing.JLabel lbl_NumeroMesa;
    private javax.swing.JLabel lbl_NumeroPedido;
    private javax.swing.JLabel lbl_Pedido;
    private javax.swing.JLabel lbl_Total;
    private javax.swing.JLabel lbl_ValorTotal;
    private javax.swing.JPanel pnlGlobal;
    private javax.swing.JPanel pnlInferior;
    private javax.swing.JPanel pnlSuperior;
    private javax.swing.JPanel pnlTabela;
    // End of variables declaration//GEN-END:variables
}
