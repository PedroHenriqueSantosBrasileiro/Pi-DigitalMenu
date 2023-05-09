package br.digitalmenu.view;

import br.digitalmenu.dao.PedidoDao;
import br.digitalmenu.model.Pedido;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class JFRAMETela_Listar_Pedido extends javax.swing.JFrame {

    public int numeroPedido;
    public int numeroMesa;

    public JFRAMETela_Listar_Pedido() throws SQLException {
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
        DefaultTableModel modelo2 = (DefaultTableModel) jtPedido.getModel();
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

    public void listarJTablePorMesa(int numMesa) throws SQLException {
        DefaultTableModel modelo2 = (DefaultTableModel) jtPedido.getModel();
        modelo2.setNumRows(0);
        PedidoDao pedDao = new PedidoDao();
        for (Pedido pedido : pedDao.listarPedidoPorMesa(numMesa)) {
            modelo2.addRow(new Object[]{
                pedido.getIdPedido(),
                pedido.getId_Mesa(),
                pedido.getTotal(),
                pedido.getData(),
                pedido.getHorarioPedido(),
                pedido.getStatus()
            });
        }
    }

    public void listarJTablePorStatus(String status) throws SQLException {
        DefaultTableModel modelo2 = (DefaultTableModel) jtPedido.getModel();
        modelo2.setNumRows(0);
        PedidoDao pedDao = new PedidoDao();
        for (Pedido pedido : pedDao.listarPedidoPorStatus(status)) {
            modelo2.addRow(new Object[]{
                pedido.getIdPedido(),
                pedido.getId_Mesa(),
                pedido.getTotal(),
                pedido.getData(),
                pedido.getHorarioPedido(),
                pedido.getStatus()
            });
        }
    }

    public void listarJtablePorFaixaDePreco(double valor1, double valor2) throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jtPedido.getModel();
        modelo.setNumRows(0);
        PedidoDao pedidoDao = new PedidoDao();
        for (Pedido pedido : pedidoDao.listarProdutoPorFaixaDePreco(valor1, valor2)) {
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

    public void listarJtablePorDia(String valor1) throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jtPedido.getModel();
        modelo.setNumRows(0);
        PedidoDao pedidoDao = new PedidoDao();
        for (Pedido pedido : pedidoDao.listarProdutoPorDia(valor1)) {
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

    public void listarJtablePorFaixaDeData(String valor1, String valor2) throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jtPedido.getModel();
        modelo.setNumRows(0);
        PedidoDao pedidoDao = new PedidoDao();
        for (Pedido pedido : pedidoDao.listarProdutoPorFaixaDia(valor1, valor2)) {
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

    /*
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
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listar Pedidos");

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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("PESQUISAR"));

        jButton3.setText("ID");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("MESA");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("STATUS");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Todos");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Total");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Data");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Dia");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addGap(33, 33, 33)
                .addComponent(jButton4)
                .addGap(31, 31, 31)
                .addComponent(jButton5)
                .addGap(44, 44, 44)
                .addComponent(jButton7)
                .addGap(31, 31, 31)
                .addComponent(jButton9)
                .addGap(18, 18, 18)
                .addComponent(jButton8)
                .addGap(41, 41, 41)
                .addComponent(jButton6)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton7)
                    .addComponent(jButton8)
                    .addComponent(jButton9))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addComponent(lbl_Data))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lbl_Total)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtformated_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtformated_Data, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
                    .addComponent(txt_Status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(119, 119, 119))
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

        setSize(new java.awt.Dimension(798, 563));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtformated_DataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtformated_DataActionPerformed

    }//GEN-LAST:event_txtformated_DataActionPerformed

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

    private void jtPedidoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPedidoMouseReleased
        setarCampos(jtPedido);
    }//GEN-LAST:event_jtPedidoMouseReleased

    private void jtPedidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPedidoKeyReleased
        setarCampos(jtPedido);
    }//GEN-LAST:event_jtPedidoKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            JPanel painel = new JPanel();
            JLabel idPedido = new JLabel("Digite o ID: ");
            JTextField digitarNumero = new JTextField(10);
            painel.add(idPedido);
            painel.add(digitarNumero);
            int resultado = JOptionPane.showConfirmDialog(null, painel, "PESQUISAR POR ID", JOptionPane.OK_CANCEL_OPTION, -1);
            if (resultado == JOptionPane.OK_OPTION) {
                //tratar erro de entrada
                listarJTablePorId(Integer.parseInt(digitarNumero.getText()));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            // TODO add your handling code here:
            listarJTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try {
            JPanel painel = new JPanel();
            JLabel idMesa = new JLabel("Digite o número da mesa: ");
            JTextField digitarNumero = new JTextField(10);
            painel.add(idMesa);
            painel.add(digitarNumero);
            int resultado = JOptionPane.showConfirmDialog(null, painel, "PESQUISAR POR NÚMERO DA MESA", JOptionPane.OK_CANCEL_OPTION, -1);
            if (resultado == JOptionPane.OK_OPTION) {
                listarJTablePorMesa(Integer.parseInt(digitarNumero.getText()));
                if (jtPedido.getRowCount() < 1) {
                    //
                    // ERRO
                    //      MSG DE BORDAS (CENTRALIZADAS JTBLES)
                    //
                    //
                    JOptionPane.showMessageDialog(null, String.format("Não existem pedidos na mesa %s",digitarNumero.getText()));
                    listarJTable();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        JPanel painel = new JPanel();
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Aberto");
        comboBox.addItem("Cancelado");
        comboBox.addItem("Encerrado");
        painel.add(new JLabel("Status: "));
        painel.add(comboBox);
        int result = JOptionPane.showConfirmDialog(null, painel, "FILTRAR POR STATUS", JOptionPane.OK_CANCEL_OPTION, -1);
        if (result == JOptionPane.OK_OPTION) {
            try {
                String status = String.valueOf(comboBox.getSelectedItem());
                listarJTablePorStatus(status);
                if (jtPedido.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Não há produtos no status " + status);
                    listarJTable();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        JTextField valorInicial = new JTextField(10);
        JTextField valorFinal = new JTextField(10);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("De:"));
        myPanel.add(valorInicial);
        myPanel.add(Box.createHorizontalStrut(10)); // a spacer
        myPanel.add(new JLabel("Até:"));
        myPanel.add(valorFinal);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Informe a faixa de valor:", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                double valor1 = Double.parseDouble(valorInicial.getText().replace(',', '.'));
                double valor2 = Double.parseDouble(valorFinal.getText().replace(',', '.'));
                listarJtablePorFaixaDePreco(valor1, valor2);
                if (jtPedido.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Faixa de preço não encontrada.");
                    listarJTable();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        JTextField valorInicial = new JTextField(10);
        JTextField valorFinal = new JTextField(10);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("De: (dd//mm/aaa)"));
        myPanel.add(valorInicial);
        myPanel.add(Box.createHorizontalStrut(10)); // a spacer
        myPanel.add(new JLabel("Até: (dd//mm/aaa)"));
        myPanel.add(valorFinal);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Informe a data:", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                String valor1 = valorInicial.getText();
                String valor2 = valorFinal.getText();
                listarJtablePorFaixaDeData(valor1, valor2);
                if (jtPedido.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Faixa de data não encontrada.");
                    listarJTable();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        JTextField valorInicial = new JTextField(10);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Data: (dd//mm/aaa)"));
        myPanel.add(valorInicial);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Informe a data:", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                String data = valorInicial.getText();
                listarJtablePorDia(data);
                if (jtPedido.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Nao existem pedido na data informada.");
                    listarJTable();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton9ActionPerformed

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
            java.util.logging.Logger.getLogger(JFRAMETela_Listar_Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFRAMETela_Listar_Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFRAMETela_Listar_Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFRAMETela_Listar_Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFRAMETela_Listar_Pedido().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(JFRAMETela_Listar_Pedido.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtPedido;
    private javax.swing.JLabel lbl_Data;
    private javax.swing.JLabel lbl_IdPedido;
    private javax.swing.JLabel lbl_Mesa;
    private javax.swing.JLabel lbl_Status;
    private javax.swing.JLabel lbl_Total;
    private javax.swing.JTextField txt_IdPedido;
    private javax.swing.JTextField txt_Mesa;
    private javax.swing.JTextField txt_Status;
    private javax.swing.JFormattedTextField txtformated_Data;
    private javax.swing.JFormattedTextField txtformated_Total;
    // End of variables declaration//GEN-END:variables
}
