package br.digitalmenu.view;

import br.digitalmenu.model.Categoria;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class Panel_Alterar_Categoria extends javax.swing.JPanel {

    public Categoria categoria;

    public Panel_Alterar_Categoria(Categoria categoria) throws SQLException {
        initComponents();
        this.categoria = categoria;
        setDados();
    }

    public void setDados() {
        lbl_id_valor.setText(String.valueOf(categoria.getIdCategoria()));
        lbl_id_atual.setText(String.valueOf(categoria.getIdCategoria()));
        txt_id_novo.setText(String.valueOf(categoria.getIdCategoria()));
        lbl_nome_atual.setText(categoria.getNomeCategoria());
        txt_nome_novo.setText(categoria.getNomeCategoria());
        lbl_status_atual.setText(categoria.getStatus());
        comboBox_status_novo.setSelectedItem(categoria.getStatus());
    }

    public JComboBox<String> getComboBox_status_novo1() {
        return comboBox_status_novo;
    }

    public JTextField getTxt_id_novo() {
        return txt_id_novo;
    }

    public JTextField getTxt_nome_novo() {
        return txt_nome_novo;
    }

    // CODE SMELL TEM NA CLASSE HEURISTICA
    public void letrasApenas(JTextComponent texto, KeyEvent evt) {
        char c = evt.getKeyChar();
        if (Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
            texto.setEditable(true);
        } else {
            texto.setEditable(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_alterar_categoria = new javax.swing.JPanel();
        lbl_id = new javax.swing.JLabel();
        lbl_id_valor = new javax.swing.JLabel();
        lbl_dados_atuais = new javax.swing.JLabel();
        lbl_dados_novos = new javax.swing.JLabel();
        lbl_numero_id = new javax.swing.JLabel();
        lbl_id_atual = new javax.swing.JLabel();
        txt_id_novo = new javax.swing.JTextField();
        lbl_nome = new javax.swing.JLabel();
        lbl_nome_atual = new javax.swing.JLabel();
        txt_nome_novo = new javax.swing.JTextField();
        lbl_status = new javax.swing.JLabel();
        lbl_status_atual = new javax.swing.JLabel();
        comboBox_status_novo = new javax.swing.JComboBox<>();
        filler18 = new javax.swing.Box.Filler(new java.awt.Dimension(500, 0), new java.awt.Dimension(500, 0), new java.awt.Dimension(500, 32767));
        filler19 = new javax.swing.Box.Filler(new java.awt.Dimension(500, 0), new java.awt.Dimension(500, 0), new java.awt.Dimension(500, 32767));
        filler24 = new javax.swing.Box.Filler(new java.awt.Dimension(500, 0), new java.awt.Dimension(500, 0), new java.awt.Dimension(500, 32767));

        pnl_alterar_categoria.setBackground(new java.awt.Color(246, 242, 233));
        pnl_alterar_categoria.setBorder(javax.swing.BorderFactory.createTitledBorder("ATUALIZAR CATEGORIA"));

        lbl_id.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_id.setText("ID : ");

        lbl_id_valor.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_id_valor.setText("n.Id");

        lbl_dados_atuais.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_dados_atuais.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_dados_atuais.setText("Dados Atuais");

        lbl_dados_novos.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_dados_novos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_dados_novos.setText("Atualizações");

        lbl_numero_id.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_numero_id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_numero_id.setText("Número/Id");

        lbl_id_atual.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_id_atual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_id_atual.setText("num/id");

        txt_id_novo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txt_id_novo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_id_novo.setEnabled(false);
        txt_id_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_novoActionPerformed(evt);
            }
        });

        lbl_nome.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_nome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nome.setText("Nome");

        lbl_nome_atual.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_nome_atual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nome_atual.setText("Nome");

        txt_nome_novo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txt_nome_novo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nome_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nome_novoActionPerformed(evt);
            }
        });
        txt_nome_novo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nome_novoKeyPressed(evt);
            }
        });

        lbl_status.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_status.setText("Status");

        lbl_status_atual.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_status_atual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_status_atual.setText("Status");

        comboBox_status_novo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        comboBox_status_novo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativado", "Desativado" }));

        filler18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        filler19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        filler24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnl_alterar_categoriaLayout = new javax.swing.GroupLayout(pnl_alterar_categoria);
        pnl_alterar_categoria.setLayout(pnl_alterar_categoriaLayout);
        pnl_alterar_categoriaLayout.setHorizontalGroup(
            pnl_alterar_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_alterar_categoriaLayout.createSequentialGroup()
                .addGroup(pnl_alterar_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnl_alterar_categoriaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(pnl_alterar_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_alterar_categoriaLayout.createSequentialGroup()
                                .addGroup(pnl_alterar_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnl_alterar_categoriaLayout.createSequentialGroup()
                                        .addComponent(lbl_id)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl_id_valor))
                                    .addGroup(pnl_alterar_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl_nome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbl_status, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lbl_numero_id))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnl_alterar_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnl_alterar_categoriaLayout.createSequentialGroup()
                                        .addGroup(pnl_alterar_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnl_alterar_categoriaLayout.createSequentialGroup()
                                                .addGroup(pnl_alterar_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(lbl_nome_atual, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbl_id_atual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(pnl_alterar_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(pnl_alterar_categoriaLayout.createSequentialGroup()
                                                        .addGap(71, 71, 71)
                                                        .addComponent(txt_id_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(pnl_alterar_categoriaLayout.createSequentialGroup()
                                                        .addGap(72, 72, 72)
                                                        .addComponent(txt_nome_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(pnl_alterar_categoriaLayout.createSequentialGroup()
                                                .addComponent(lbl_dados_atuais, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(38, 38, 38)
                                                .addComponent(lbl_dados_novos, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(pnl_alterar_categoriaLayout.createSequentialGroup()
                                        .addComponent(lbl_status_atual, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(comboBox_status_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(71, 71, 71))))
                            .addGroup(pnl_alterar_categoriaLayout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addGroup(pnl_alterar_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(filler18, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                                    .addComponent(filler19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(pnl_alterar_categoriaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(filler24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_alterar_categoriaLayout.setVerticalGroup(
            pnl_alterar_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_alterar_categoriaLayout.createSequentialGroup()
                .addGroup(pnl_alterar_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_alterar_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_dados_novos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_dados_atuais, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_id_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addComponent(filler24, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(pnl_alterar_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_alterar_categoriaLayout.createSequentialGroup()
                        .addComponent(lbl_numero_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(filler18, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(lbl_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filler19, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(lbl_status, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_alterar_categoriaLayout.createSequentialGroup()
                        .addGroup(pnl_alterar_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_alterar_categoriaLayout.createSequentialGroup()
                                .addComponent(lbl_id_atual, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4))
                            .addComponent(txt_id_novo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(pnl_alterar_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_nome_atual, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nome_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(pnl_alterar_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_status_atual, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBox_status_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnl_alterar_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_alterar_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_id_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_novoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_novoActionPerformed

    private void txt_nome_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nome_novoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nome_novoActionPerformed

    private void txt_nome_novoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nome_novoKeyPressed
        letrasApenas(txt_nome_novo, evt);

    }//GEN-LAST:event_txt_nome_novoKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBox_status_novo;
    private javax.swing.Box.Filler filler18;
    private javax.swing.Box.Filler filler19;
    private javax.swing.Box.Filler filler24;
    private javax.swing.JLabel lbl_dados_atuais;
    private javax.swing.JLabel lbl_dados_novos;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_id_atual;
    private javax.swing.JLabel lbl_id_valor;
    private javax.swing.JLabel lbl_nome;
    private javax.swing.JLabel lbl_nome_atual;
    private javax.swing.JLabel lbl_numero_id;
    private javax.swing.JLabel lbl_status;
    private javax.swing.JLabel lbl_status_atual;
    private javax.swing.JPanel pnl_alterar_categoria;
    private javax.swing.JTextField txt_id_novo;
    private javax.swing.JTextField txt_nome_novo;
    // End of variables declaration//GEN-END:variables
}
