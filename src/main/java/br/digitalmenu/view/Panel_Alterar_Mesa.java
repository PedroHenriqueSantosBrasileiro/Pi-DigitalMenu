package br.digitalmenu.view;

import br.digitalmenu.model.Mesa;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Panel_Alterar_Mesa extends javax.swing.JPanel {

    public Mesa mesa;

    public Panel_Alterar_Mesa(Mesa mesa) throws SQLException {
        initComponents();
        this.mesa = mesa;
        setDados();
    }

    public void setDados() {
        lbl_id_valor.setText(String.valueOf(mesa.getIdMesa()));
        lbl_numero_atual.setText(String.valueOf(mesa.getIdMesa()));
        txt_numero_novo.setText(String.valueOf(mesa.getIdMesa()));
        lbl_status_atual.setText(mesa.getStatus());
        comboBox_status_novo.setSelectedItem(mesa.getStatus());
        System.out.println(mesa.getStatus());

    }

    public JComboBox<String> getComboBox_status_novo() {
        return comboBox_status_novo;
    }

    public JTextField getTxt_numero_Novo() {
        return txt_numero_novo;
    }

    public JLabel getLbl_Id_Valor() {
        return lbl_id_valor;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_alterar_mesa = new javax.swing.JPanel();
        lbl_numero_mesa = new javax.swing.JLabel();
        lbl_numero_atual = new javax.swing.JLabel();
        txt_numero_novo = new javax.swing.JTextField();
        lbl_status = new javax.swing.JLabel();
        lbl_status_atual = new javax.swing.JLabel();
        filler18 = new javax.swing.Box.Filler(new java.awt.Dimension(500, 0), new java.awt.Dimension(500, 0), new java.awt.Dimension(500, 32767));
        filler19 = new javax.swing.Box.Filler(new java.awt.Dimension(500, 0), new java.awt.Dimension(500, 0), new java.awt.Dimension(500, 32767));
        lbl_dados_novos = new javax.swing.JLabel();
        lbl_dados_atuais = new javax.swing.JLabel();
        filler24 = new javax.swing.Box.Filler(new java.awt.Dimension(500, 0), new java.awt.Dimension(500, 0), new java.awt.Dimension(500, 32767));
        lbl_id = new javax.swing.JLabel();
        lbl_id_valor = new javax.swing.JLabel();
        comboBox_status_novo = new javax.swing.JComboBox<>();

        pnl_alterar_mesa.setBackground(new java.awt.Color(246, 242, 233));
        pnl_alterar_mesa.setBorder(javax.swing.BorderFactory.createTitledBorder("ATUALIZAR MESA"));

        lbl_numero_mesa.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_numero_mesa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_numero_mesa.setText("Número/Id:");

        lbl_numero_atual.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_numero_atual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_numero_atual.setText("jLabel1");

        txt_numero_novo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txt_numero_novo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_numero_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_numero_novoActionPerformed(evt);
            }
        });

        lbl_status.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_status.setText("Status:");

        lbl_status_atual.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_status_atual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_status_atual.setText("Status");

        filler18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        filler19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_dados_novos.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_dados_novos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_dados_novos.setText("Atualizações");

        lbl_dados_atuais.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_dados_atuais.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_dados_atuais.setText("Dados Atuais");

        filler24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_id.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_id.setText("ID : ");

        lbl_id_valor.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_id_valor.setText("ID : ");

        comboBox_status_novo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        comboBox_status_novo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ATIVADO", "DESATIVADO" }));
        comboBox_status_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBox_status_novoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_alterar_mesaLayout = new javax.swing.GroupLayout(pnl_alterar_mesa);
        pnl_alterar_mesa.setLayout(pnl_alterar_mesaLayout);
        pnl_alterar_mesaLayout.setHorizontalGroup(
            pnl_alterar_mesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_alterar_mesaLayout.createSequentialGroup()
                .addGroup(pnl_alterar_mesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_alterar_mesaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(filler24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnl_alterar_mesaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbl_id)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_id_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(lbl_dados_atuais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(46, 46, 46)
                        .addComponent(lbl_dados_novos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(pnl_alterar_mesaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnl_alterar_mesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filler18, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filler19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnl_alterar_mesaLayout.createSequentialGroup()
                                .addGroup(pnl_alterar_mesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnl_alterar_mesaLayout.createSequentialGroup()
                                        .addComponent(lbl_numero_mesa)
                                        .addGap(27, 27, 27)
                                        .addComponent(lbl_numero_atual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(73, 73, 73))
                                    .addGroup(pnl_alterar_mesaLayout.createSequentialGroup()
                                        .addComponent(lbl_status, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(47, 47, 47)
                                        .addComponent(lbl_status_atual, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(77, 77, 77)))
                                .addGroup(pnl_alterar_mesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnl_alterar_mesaLayout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(comboBox_status_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(77, 77, 77))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_alterar_mesaLayout.createSequentialGroup()
                                        .addComponent(txt_numero_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(76, 76, 76)))))))
                .addContainerGap())
        );
        pnl_alterar_mesaLayout.setVerticalGroup(
            pnl_alterar_mesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_alterar_mesaLayout.createSequentialGroup()
                .addGroup(pnl_alterar_mesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_alterar_mesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_dados_novos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_dados_atuais, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_id_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addComponent(filler24, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnl_alterar_mesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_numero_mesa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_numero_atual, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_numero_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler18, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnl_alterar_mesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_status, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_status_atual, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBox_status_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler19, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_alterar_mesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_alterar_mesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_numero_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_numero_novoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_numero_novoActionPerformed

    private void comboBox_status_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_status_novoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBox_status_novoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBox_status_novo;
    private javax.swing.Box.Filler filler18;
    private javax.swing.Box.Filler filler19;
    private javax.swing.Box.Filler filler24;
    private javax.swing.JLabel lbl_dados_atuais;
    private javax.swing.JLabel lbl_dados_novos;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_id_valor;
    private javax.swing.JLabel lbl_numero_atual;
    private javax.swing.JLabel lbl_numero_mesa;
    private javax.swing.JLabel lbl_status;
    private javax.swing.JLabel lbl_status_atual;
    private javax.swing.JPanel pnl_alterar_mesa;
    private javax.swing.JTextField txt_numero_novo;
    // End of variables declaration//GEN-END:variables
}
