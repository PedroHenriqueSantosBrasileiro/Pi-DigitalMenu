package br.digitalmenu.view;

import br.digitalmenu.dao.MesaDao;
import br.digitalmenu.model.Mesa;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Tela_Mesa extends javax.swing.JInternalFrame {

    int idMesaParaAlterar = 0;
    String statusxAux = "ativado";

    public Tela_Mesa() throws SQLException {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jtMesa.getModel();
        jtMesa.setRowSorter(new TableRowSorter(modelo));
        listarJtable();
    }

    public void listarJtable() throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jtMesa.getModel();
        modelo.setNumRows(0);
        MesaDao mesaDAO = new MesaDao();
        for (Mesa mesa : mesaDAO.listarMesa()) {
            modelo.addRow(new Object[]{
                mesa.getIdMesa(),
                mesa.getStatus()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_NumeroMesa = new javax.swing.JLabel();
        txt_NumeroMesa = new javax.swing.JTextField();
        btn_CadastrarMesa = new javax.swing.JButton();
        btn_ExcluirMesa = new javax.swing.JButton();
        btn_AlterarMesa = new javax.swing.JButton();
        checkbox_Status = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        tableMesa = new javax.swing.JScrollPane();
        jtMesa = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();

        setClosable(true);
        setResizable(true);

        lbl_NumeroMesa.setText("Número da mesa");

        txt_NumeroMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NumeroMesaActionPerformed(evt);
            }
        });

        btn_CadastrarMesa.setText("Cadastrar");
        btn_CadastrarMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CadastrarMesaActionPerformed(evt);
            }
        });

        btn_ExcluirMesa.setText("Excluir");
        btn_ExcluirMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ExcluirMesaActionPerformed(evt);
            }
        });

        btn_AlterarMesa.setText("Atualizar");
        btn_AlterarMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AlterarMesaActionPerformed(evt);
            }
        });

        checkbox_Status.setText("ATIVADO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_NumeroMesa)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btn_CadastrarMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_NumeroMesa, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addComponent(checkbox_Status)
                                .addGap(32, 32, 32))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_AlterarMesa)
                                .addGap(67, 67, 67)))
                        .addComponent(btn_ExcluirMesa)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(lbl_NumeroMesa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_NumeroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkbox_Status))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_CadastrarMesa)
                    .addComponent(btn_ExcluirMesa)
                    .addComponent(btn_AlterarMesa))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        tableMesa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableMesaKeyReleased(evt);
            }
        });

        jtMesa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Número Mesa (id)", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtMesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtMesaMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jtMesaMouseReleased(evt);
            }
        });
        jtMesa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtMesaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtMesaKeyReleased(evt);
            }
        });
        tableMesa.setViewportView(jtMesa);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tableMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tableMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisar"));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_NumeroMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NumeroMesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NumeroMesaActionPerformed

    private void btn_CadastrarMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CadastrarMesaActionPerformed

        if (!txt_NumeroMesa.getText().equalsIgnoreCase("")) {
            Mesa mesa = new Mesa();
            mesa.setIdMesa(Integer.parseInt(txt_NumeroMesa.getText()));
//            String status = checkbox_Status.isSelected() ? "ATIVADO" : "DESATIVADO";
//            mesa.setStatus(status);
            MesaDao mesaDAO = new MesaDao();
            try {
                boolean criouMesa = mesaDAO.criarMesa(mesa) ? true : false;
                if (criouMesa == true) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Mesa criada com sucesso!\n"
                            + "Id/Número: "
                            + mesa.getIdMesa()
//                            + "\nStatus: "
//                            + mesa.getStatus()
                    );
                }
                txt_NumeroMesa.setText("");
                listarJtable();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Insira um número de mesa.");
        }
    }//GEN-LAST:event_btn_CadastrarMesaActionPerformed

    private void btn_ExcluirMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExcluirMesaActionPerformed
        if (jtMesa.getSelectedRow() != -1) {
            int confirma = JOptionPane.showConfirmDialog(
                    this,
                    "Deseja confirmar a deleção da mesa " + String.valueOf(jtMesa.getValueAt(jtMesa.getSelectedRow(), 0).toString()) + "?",
                    "CONFIRMAR DELEÇÃO",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
            if (confirma == JOptionPane.YES_OPTION) {
                try {
                    MesaDao mesaDAO = new MesaDao();
                    Mesa mesa = mesaDAO.listarMesaPorId(Integer.parseInt(jtMesa.getValueAt(jtMesa.getSelectedRow(), 0).toString()));
                    mesaDAO.deletaMesa(mesa.getIdMesa());
                    JOptionPane.showMessageDialog(null, "Mesa deletada com sucesso!");
                    txt_NumeroMesa.setText("");
                    listarJtable();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                }
            } else if (confirma == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Operacão cancelada.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma mesa para excluir.");
        }
    }//GEN-LAST:event_btn_ExcluirMesaActionPerformed

    private void btn_AlterarMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AlterarMesaActionPerformed
        if (jtMesa.getSelectedRow() != -1) {

            try {
                String status = checkbox_Status.isSelected() ? "ATIVADO" : "DESATIVADO";
                MesaDao mesaDAO = new MesaDao();
                Mesa mesaAtual = mesaDAO.listarMesaPorId(Integer.parseInt(jtMesa.getValueAt(jtMesa.getSelectedRow(), 0).toString()));
                Mesa mesaNova = new Mesa();
                mesaNova.setIdMesa(Integer.parseInt(txt_NumeroMesa.getText()));
                mesaNova.setStatus(status);

                int confirmar = JOptionPane.showConfirmDialog(
                        this,
                        "Dados atuais:\nMesa: "
                        + mesaAtual.getIdMesa()
                        + "\nStatus: "
                        + mesaAtual.getStatus()
                        + "\n\nDADO(S) ATUALIZADO(S):"
                        + "\nMesa: "
                        + mesaNova.getIdMesa()
                        + "\nStatus: "
                        + mesaNova.getStatus(),
                        "CONFIRMAR ALTERAÇÃO?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );
                if (confirmar == JOptionPane.YES_OPTION) {
                    mesaDAO.updateMesa(mesaNova, mesaAtual.getIdMesa());
                    JOptionPane.showMessageDialog(null, "Mesa atualizada com sucesso!");
                    listarJtable();
                    txt_NumeroMesa.setText("");
                } else if (confirmar == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "Operação cancelada!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha para alterar.");
        }
    }//GEN-LAST:event_btn_AlterarMesaActionPerformed

    private void jtMesaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtMesaMouseClicked
    }//GEN-LAST:event_jtMesaMouseClicked

    private void jtMesaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtMesaMouseReleased

        if (jtMesa.getSelectedRow() != -1) {
            txt_NumeroMesa.setText(jtMesa.getValueAt(jtMesa.getSelectedRow(), 0).toString());
            idMesaParaAlterar = Integer.parseInt(jtMesa.getValueAt(jtMesa.getSelectedRow(), 0).toString());
            checkbox_Status.setSelected(jtMesa.getValueAt(jtMesa.getSelectedRow(), 1).toString().equalsIgnoreCase("ativado"));
            statusxAux = checkbox_Status.isSelected() ? "ATIVADO" : "DESATIVADO";
        }
    }//GEN-LAST:event_jtMesaMouseReleased

    private void jtMesaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtMesaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtMesaKeyPressed

    private void jtMesaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtMesaKeyReleased

        if (jtMesa.getSelectedRow() != -1) {
            txt_NumeroMesa.setText(jtMesa.getValueAt(jtMesa.getSelectedRow(), 0).toString());
            idMesaParaAlterar = Integer.parseInt(jtMesa.getValueAt(jtMesa.getSelectedRow(), 0).toString());
            checkbox_Status.setSelected(jtMesa.getValueAt(jtMesa.getSelectedRow(), 1).toString().equalsIgnoreCase("ativado"));
            statusxAux = checkbox_Status.isSelected() ? "ATIVADO" : "DESATIVADO";
        }

    }//GEN-LAST:event_jtMesaKeyReleased

    private void tableMesaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableMesaKeyReleased

    }//GEN-LAST:event_tableMesaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_AlterarMesa;
    private javax.swing.JButton btn_CadastrarMesa;
    private javax.swing.JButton btn_ExcluirMesa;
    private javax.swing.JCheckBox checkbox_Status;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTable jtMesa;
    private javax.swing.JLabel lbl_NumeroMesa;
    private javax.swing.JScrollPane tableMesa;
    private javax.swing.JTextField txt_NumeroMesa;
    // End of variables declaration//GEN-END:variables
}
