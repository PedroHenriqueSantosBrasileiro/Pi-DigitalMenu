package br.digitalmenu.view;

import br.digitalmenu.dao.ItemDao;
import br.digitalmenu.dao.PedidoDao;
import br.digitalmenu.dao.ProdutoDao;
import br.digitalmenu.heuristicas.Heuristica;
import br.digitalmenu.model.Item;
import br.digitalmenu.model.Produto;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Tela_ItensDoPedido extends Heuristica {

    public double valorTotal = 0;
    public int numeroPedido;
    public Tela_Listar_Pedido telaAnterior;

    public Tela_ItensDoPedido() {
        initComponents();
    }

    public Tela_ItensDoPedido(int numeroPedido, int numeroMesa, Tela_Listar_Pedido telaAnterior) throws SQLException {
        initComponents();
        this.numeroPedido = numeroPedido;
        lbl_NumeroPedido.setText(String.valueOf(numeroPedido));
        lbl_NumeroMesa.setText(String.valueOf(numeroMesa));
        jtItensDoPedido.getTableHeader().setDefaultRenderer(new CorDoCabecalho());//Muda cor do header na classe heuristica
        IniciaTabela(jtItensDoPedido);//Formata a tabela e centraliza pela classe heuristicas
        listarJTable(numeroPedido);
        lbl_ValorTotal.setText(String.valueOf(valorTotal));
        this.telaAnterior = telaAnterior;
    }

    //teste
    public void metodoAntesDeFechar() throws SQLException {
        telaAnterior.metodoAoVoltar();
        this.dispose();
    }

    public void listarJTable(int numeroPedido) throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jtItensDoPedido.getModel();
        modelo.setNumRows(0);
        ItemDao itensDao = new ItemDao();
        for (Item item : itensDao.listarItensPorPedido(numeroPedido)) {
            ProdutoDao produtoDao = new ProdutoDao();
            modelo.addRow(new Object[]{
                item.getIdItem(),
                item.getProduto().getIdProduto(),
                item.getProduto().getNome(),
                String.format("%.2f", item.getProduto().getPreco()),
                item.getQtde(),
                item.getSubtotal(),
                item.getHoraComanda(),
                item.getStatus()
            });
            valorTotal += Double.parseDouble(String.valueOf(item.getSubtotal()));
        }
    }

    public JComboBox listarProdutoNoComboBox(JComboBox cbox) throws SQLException {
        ProdutoDao prodDao = new ProdutoDao();
        for (Produto produto : prodDao.listarProduto()) {
            cbox.addItem(produto.getNome());
        }
        return cbox;
    }

    /*
        public void viewCategoria() throws SQLException {
        CategoriaDao catDao = new CategoriaDao();
        for (Categoria categoria : catDao.listarCategoria()) {
            cboxCategoria.addItem(categoria.getNomeCategoria());
        }
    }
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGlobal = new javax.swing.JPanel();
        pnlSuperior = new javax.swing.JPanel();
        lbl_FotoMesa = new javax.swing.JLabel();
        lbl_FotoPedido = new javax.swing.JLabel();
        lbl_NumeroPedido = new javax.swing.JLabel();
        lbl_NumeroMesa = new javax.swing.JLabel();
        lbl_Total = new javax.swing.JLabel();
        lbl_ValorTotal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtItensDoPedido = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btn_cancelarItem = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Itens do pedido");

        pnlGlobal.setBackground(new java.awt.Color(255, 255, 255));

        pnlSuperior.setBackground(new java.awt.Color(246, 242, 233));
        pnlSuperior.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Itens do pedido", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        lbl_FotoMesa.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\mesa.png"));
        lbl_FotoMesa.setText("jLabel1");

        lbl_FotoPedido.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\pedido.png"));
        lbl_FotoPedido.setText("jLabel1");

        lbl_NumeroPedido.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        lbl_NumeroPedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_NumeroPedido.setText("jLabel1");

        lbl_NumeroMesa.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        lbl_NumeroMesa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_NumeroMesa.setText("jLabel1");

        lbl_Total.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        lbl_Total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Total.setText("Total:");

        lbl_ValorTotal.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        lbl_ValorTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_ValorTotal.setText("jLabel1");

        javax.swing.GroupLayout pnlSuperiorLayout = new javax.swing.GroupLayout(pnlSuperior);
        pnlSuperior.setLayout(pnlSuperiorLayout);
        pnlSuperiorLayout.setHorizontalGroup(
            pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSuperiorLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lbl_FotoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_NumeroPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_FotoMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_NumeroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_Total)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_ValorTotal)
                .addContainerGap())
        );
        pnlSuperiorLayout.setVerticalGroup(
            pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSuperiorLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_NumeroMesa, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                    .addComponent(lbl_FotoMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_NumeroPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_FotoPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_Total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_ValorTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jtItensDoPedido.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtItensDoPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID item", "Pedido", "Produto", "Preço", "Qtde", "Subtotal", "Horário", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtItensDoPedido.setRowHeight(25);
        jScrollPane1.setViewportView(jtItensDoPedido);
        if (jtItensDoPedido.getColumnModel().getColumnCount() > 0) {
            jtItensDoPedido.getColumnModel().getColumn(1).setMinWidth(5);
            jtItensDoPedido.getColumnModel().getColumn(1).setPreferredWidth(5);
            jtItensDoPedido.getColumnModel().getColumn(2).setMinWidth(200);
            jtItensDoPedido.getColumnModel().getColumn(2).setPreferredWidth(200);
            jtItensDoPedido.getColumnModel().getColumn(3).setMinWidth(20);
            jtItensDoPedido.getColumnModel().getColumn(3).setPreferredWidth(20);
            jtItensDoPedido.getColumnModel().getColumn(4).setMinWidth(10);
            jtItensDoPedido.getColumnModel().getColumn(4).setPreferredWidth(10);
            jtItensDoPedido.getColumnModel().getColumn(5).setMinWidth(20);
            jtItensDoPedido.getColumnModel().getColumn(5).setPreferredWidth(20);
        }

        jButton1.setBackground(new java.awt.Color(255, 243, 198));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btn_cancelarItem.setText("Cancelar Item");
        btn_cancelarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarItemActionPerformed(evt);
            }
        });

        jButton2.setText("adicionar item");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlGlobalLayout = new javax.swing.GroupLayout(pnlGlobal);
        pnlGlobal.setLayout(pnlGlobalLayout);
        pnlGlobalLayout.setHorizontalGroup(
            pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGlobalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
                    .addGroup(pnlGlobalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(pnlGlobalLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(btn_cancelarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlGlobalLayout.setVerticalGroup(
            pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGlobalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancelarItem)
                    .addComponent(jButton2))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGlobal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGlobal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            //        this.dispose();
            metodoAntesDeFechar();
        } catch (SQLException ex) {
            Logger.getLogger(Tela_ItensDoPedido.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_cancelarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarItemActionPerformed
        // TODO add your handling code here:
        int confirma = JOptionPane.showConfirmDialog(null, "Deseja cancelar o item?");

        if (confirma == JOptionPane.YES_OPTION) {

            DefaultTableModel dtm = (DefaultTableModel) jtItensDoPedido.getModel();
            if (jtItensDoPedido.getSelectedRow() != -1) {
                ItemDao itemDao = new ItemDao();
                PedidoDao pedidoDao = new PedidoDao();
                try {
                    int id = Integer.parseInt(jtItensDoPedido.getValueAt(jtItensDoPedido.getSelectedRow(), 0).toString());
                    itemDao.atualizaItem(id);
                    pedidoDao.atualizaPedidoItemAlterado(numeroPedido);
                    listarJTable(numeroPedido);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", HEIGHT);
                }
            } else if (jtItensDoPedido.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Não há itens no pedido.", "ERRO", HEIGHT);
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um item.", "ERRO", HEIGHT);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Operação cancelada.", "ERRO", HEIGHT);
        }

    }//GEN-LAST:event_btn_cancelarItemActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        JPanel panel = new JPanel();
        JComboBox comboBox = new JComboBox();
        try {
            
            listarProdutoNoComboBox(comboBox);
            JLabel nome = new JLabel("Selecione o produto: ");
            JLabel lbl_qtde = new JLabel("Quantidade: ");
            JTextField digitarQtde = new JTextField(25);
            panel.add(nome);
            panel.add(Box.createHorizontalStrut(2));
            panel.add(comboBox);
            panel.add(Box.createHorizontalStrut(5));
            panel.add(lbl_qtde);
            panel.add(Box.createHorizontalStrut(5));
            panel.add(digitarQtde);

            int confirma = JOptionPane.showConfirmDialog(null, panel, "Item a add", JOptionPane.OK_CANCEL_OPTION);
            if (confirma == JOptionPane.OK_OPTION) {
                ItemDao itemDao = new ItemDao();
                Item item = new Item();

                item.getPedido().setIdPedido(numeroPedido);
                item.getProduto().setNome(comboBox.getSelectedItem().toString());
                item.setQtde(Integer.parseInt(digitarQtde.getText()));

                itemDao.adicionaItenAdmin(item);
                PedidoDao pedidoDao = new PedidoDao();
                pedidoDao.atualizaPedidoItemAlterado(numeroPedido);
                listarJTable(numeroPedido);

            } else {
                JOptionPane.showMessageDialog(null, "CANCELADO");
            }

            /*
            JTextField valorInicial = new JTextField(10);
            JTextField valorFinal = new JTextField(10);
            JPanel myPanel = new JPanel();
            myPanel.add(new JLabel("De:"));
            myPanel.add(valorInicial);
            myPanel.add(Box.createHorizontalStrut(10)); // a spacer
            myPanel.add(new JLabel("Até:"));
            myPanel.add(valorFinal);
            
            int result = JOptionPane.showConfirmDialog(null, myPanel,
            "Informe a faixa de preço", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
            try {
            double valor1 = Double.parseDouble(valorInicial.getText().replace(',', '.'));
            double valor2 = Double.parseDouble(valorFinal.getText().replace(',', '.'));
            listarJtablePorFaixaDePreco(valor1, valor2);
            if (jtProduto.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Faixa de preço não encontrada.");
            listarJTableProdutosAtivados();
            }
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
            }
             */
        } catch (SQLException ex) {
            Logger.getLogger(Tela_ItensDoPedido.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Tela_ItensDoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_ItensDoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_ItensDoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_ItensDoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_ItensDoPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelarItem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtItensDoPedido;
    private javax.swing.JLabel lbl_FotoMesa;
    private javax.swing.JLabel lbl_FotoPedido;
    private javax.swing.JLabel lbl_NumeroMesa;
    private javax.swing.JLabel lbl_NumeroPedido;
    private javax.swing.JLabel lbl_Total;
    private javax.swing.JLabel lbl_ValorTotal;
    private javax.swing.JPanel pnlGlobal;
    private javax.swing.JPanel pnlSuperior;
    // End of variables declaration//GEN-END:variables
}
