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
    public boolean foiAdm;
    private JFrame tela;

    public Tela_ResumoPedido() {
        initComponents();
    }

    public Tela_ResumoPedido(int numeroPedido, int numeroMesa, JFrame tela, boolean foiAdm) throws SQLException {
        initComponents();
        this.foiAdm = foiAdm;
        this.tela = tela;
        this.numeroPedido = numeroPedido;
        this.numeroMesa = numeroMesa;
        lbl_NumeroPedido.setText(String.valueOf(numeroPedido));
        lbl_NumeroMesa.setText(String.valueOf(numeroMesa));
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
                item.getProduto().getPreco(),
                item.getQtde(),
                item.getSubtotal(),
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

        jPanel1 = new javax.swing.JPanel();
        lbl_Pedido = new javax.swing.JLabel();
        lbl_Mesa = new javax.swing.JLabel();
        lbl_Total = new javax.swing.JLabel();
        lbl_NumeroPedido = new javax.swing.JLabel();
        lbl_NumeroMesa = new javax.swing.JLabel();
        lbl_ValorTotal = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtResumo = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btn_Voltar = new javax.swing.JButton();
        btn_Encerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        lbl_Pedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Pedido.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\pedido.png"));

        lbl_Mesa.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\mesa.png"));

        lbl_Total.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        lbl_Total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_Total.setText("TOTAL:");

        lbl_NumeroPedido.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        lbl_NumeroPedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_NumeroPedido.setText("nº");

        lbl_NumeroMesa.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        lbl_NumeroMesa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_NumeroMesa.setText("nº");

        lbl_ValorTotal.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lbl_ValorTotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_ValorTotal.setText("jLabel4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbl_Pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(lbl_NumeroPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(lbl_Mesa, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(lbl_NumeroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(200, 200, 200)
                .addComponent(lbl_Total)
                .addGap(15, 15, 15)
                .addComponent(lbl_ValorTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbl_NumeroMesa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_Total, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_Pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Mesa, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_ValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbl_NumeroPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btn_Voltar.setText("Voltar");
        btn_Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VoltarActionPerformed(evt);
            }
        });

        btn_Encerrar.setText("Encerrar Pedido");
        btn_Encerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EncerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(btn_Encerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(btn_Voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(250, 250, 250))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Encerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VoltarActionPerformed
        
        this.dispose();
        //Reabre a tela menu com os atributos mesa e pedido
       

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
            if (foiAdm == false) {

                TelaDeEspera telaDeEspera = new TelaDeEspera(numeroMesa);
                telaDeEspera.setVisible(true);
                this.dispose();
                tela.dispose();
                JOptionPane.showMessageDialog(null, "Pedido encerrado, um atendente levará a conta até voce");
            } else {
                try {
                    //Fecha pedido
                    Pedido pedido = new Pedido();
                    pedido.setIdPedido(Integer.parseInt(lbl_NumeroPedido.getText()));
                    pedido.setStatus("Encerrado");
                    PedidoDao pedidoDao = new PedidoDao();
                    pedidoDao.atualizaPedido(pedido);
                    JOptionPane.showMessageDialog(null, "Pedido encerrado, um atendente levará a conta até voce");
                    this.dispose();
                    tela.dispose();
                    new Tela_Login().setVisible(true);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                }
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtResumo;
    private javax.swing.JLabel lbl_Mesa;
    private javax.swing.JLabel lbl_NumeroMesa;
    private javax.swing.JLabel lbl_NumeroPedido;
    private javax.swing.JLabel lbl_Pedido;
    private javax.swing.JLabel lbl_Total;
    private javax.swing.JLabel lbl_ValorTotal;
    // End of variables declaration//GEN-END:variables
}
