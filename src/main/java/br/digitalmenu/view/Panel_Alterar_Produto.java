package br.digitalmenu.view;

import br.digitalmenu.dao.CategoriaDao;
import br.digitalmenu.model.Categoria;
import br.digitalmenu.model.Produto;
import java.sql.SQLException;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Panel_Alterar_Produto extends javax.swing.JPanel {

    public Produto produto;

    public Panel_Alterar_Produto(Produto produto) throws SQLException {
        initComponents();
        this.produto = produto;
        viewCategoria();
        setDados();

    }

    public void viewCategoria() throws SQLException {
        CategoriaDao catDao = new CategoriaDao();
        for (Categoria categoria : catDao.listarCategoria()) {
            cbox_categoria_novo.addItem(categoria.getNomeCategoria());
        }
    }

    public void setDados() throws SQLException {
        lbl_id_valor.setText(String.valueOf(produto.getIdProduto()));
        lbl_nome_atual.setText(String.valueOf(produto.getNome()));
        txt_nome_novo.setText(String.valueOf(produto.getNome()));
        lbl_preco_atual.setText(String.valueOf(produto.getPreco()));
        txt_preco_novo.setText(String.valueOf(produto.getPreco()));
        lbl_categoria_atual.setText(String.valueOf(produto.getCategoria().getNomeCategoria()));
        cbox_categoria_novo.setSelectedItem(produto.getCategoria().getNomeCategoria());
        txtarea_descricao_atual.setText(String.valueOf(produto.getDescricao()));
        txtarea_descricao_novo.setText(String.valueOf(produto.getDescricao()));
        lbl_status_atual.setText(produto.getStatus());
        if (produto.getStatus().equalsIgnoreCase("Ativado")) {
            checkbox_status_novo.doClick();
        }
        txtarea_descricao_atual.setEditable(false);
    }

    public JComboBox<String> getCbox_Categoria_Novo() {
        return cbox_categoria_novo;
    }

    public JCheckBox getCheckbox_Status_Novo() {
        return checkbox_status_novo;
    }

    public JTextField getTxt_Nome_Novo() {
        return txt_nome_novo;
    }

    public JTextField getTxt_Preco_Novo() {
        return txt_preco_novo;
    }

    public JTextArea getTxtarea_Descricao_Novo() {
        return txtarea_descricao_novo;
    }

    public JLabel getLbl_IdProduto1() {
        return lbl_id_produto1;
    }

    public JLabel getLbl_Id_Valor() {
        return lbl_id_valor;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_alterar_produto = new javax.swing.JPanel();
        lbl_nome = new javax.swing.JLabel();
        lbl_nome_atual = new javax.swing.JLabel();
        txt_nome_novo = new javax.swing.JTextField();
        lbl_preco = new javax.swing.JLabel();
        lbl_preco_atual = new javax.swing.JLabel();
        txt_preco_novo = new javax.swing.JTextField();
        lbl_categoria = new javax.swing.JLabel();
        lbl_categoria_atual = new javax.swing.JLabel();
        cbox_categoria_novo = new javax.swing.JComboBox<>();
        lbl_descricao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtarea_descricao_atual = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtarea_descricao_novo = new javax.swing.JTextArea();
        lbl_status = new javax.swing.JLabel();
        checkbox_status_novo = new javax.swing.JCheckBox();
        filler18 = new javax.swing.Box.Filler(new java.awt.Dimension(500, 0), new java.awt.Dimension(500, 0), new java.awt.Dimension(500, 32767));
        filler19 = new javax.swing.Box.Filler(new java.awt.Dimension(500, 0), new java.awt.Dimension(500, 0), new java.awt.Dimension(500, 32767));
        filler21 = new javax.swing.Box.Filler(new java.awt.Dimension(500, 0), new java.awt.Dimension(500, 0), new java.awt.Dimension(500, 32767));
        filler22 = new javax.swing.Box.Filler(new java.awt.Dimension(500, 0), new java.awt.Dimension(500, 0), new java.awt.Dimension(500, 32767));
        lbl_id_produto = new javax.swing.JLabel();
        lbl_id_produto1 = new javax.swing.JLabel();
        filler24 = new javax.swing.Box.Filler(new java.awt.Dimension(500, 0), new java.awt.Dimension(500, 0), new java.awt.Dimension(500, 32767));
        lbl_id = new javax.swing.JLabel();
        lbl_id_valor = new javax.swing.JLabel();
        lbl_status_atual = new javax.swing.JLabel();

        pnl_alterar_produto.setBackground(new java.awt.Color(246, 242, 233));
        pnl_alterar_produto.setBorder(javax.swing.BorderFactory.createTitledBorder("ATUALIZAR PRODUTOS"));

        lbl_nome.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_nome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nome.setText("Nome:");

        lbl_nome_atual.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_nome_atual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nome_atual.setText("jLabel1");

        txt_nome_novo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txt_nome_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nome_novoActionPerformed(evt);
            }
        });

        lbl_preco.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_preco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_preco.setText("Preço:");

        lbl_preco_atual.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_preco_atual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_preco_atual.setText("jLabel1");

        txt_preco_novo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        lbl_categoria.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_categoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_categoria.setText("Categoria:");

        lbl_categoria_atual.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_categoria_atual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_categoria_atual.setText("jLabel1");

        cbox_categoria_novo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        lbl_descricao.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_descricao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_descricao.setText("Descrição:");

        txtarea_descricao_atual.setColumns(20);
        txtarea_descricao_atual.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtarea_descricao_atual.setRows(5);
        jScrollPane1.setViewportView(txtarea_descricao_atual);

        txtarea_descricao_novo.setColumns(20);
        txtarea_descricao_novo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtarea_descricao_novo.setRows(5);
        jScrollPane2.setViewportView(txtarea_descricao_novo);

        lbl_status.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_status.setText("Status:");

        checkbox_status_novo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        checkbox_status_novo.setText("Ativado");
        checkbox_status_novo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        filler18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        filler19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        filler21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        filler22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_id_produto.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_id_produto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_id_produto.setText("Atualizações");

        lbl_id_produto1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_id_produto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_id_produto1.setText("Dados Atuais");

        filler24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_id.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_id.setText("ID : ");

        lbl_id_valor.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_id_valor.setText("ID : ");

        lbl_status_atual.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_status_atual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_status_atual.setText("Status");

        javax.swing.GroupLayout pnl_alterar_produtoLayout = new javax.swing.GroupLayout(pnl_alterar_produto);
        pnl_alterar_produto.setLayout(pnl_alterar_produtoLayout);
        pnl_alterar_produtoLayout.setHorizontalGroup(
            pnl_alterar_produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_alterar_produtoLayout.createSequentialGroup()
                .addGroup(pnl_alterar_produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_alterar_produtoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(pnl_alterar_produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_alterar_produtoLayout.createSequentialGroup()
                                .addGroup(pnl_alterar_produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnl_alterar_produtoLayout.createSequentialGroup()
                                        .addGroup(pnl_alterar_produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(pnl_alterar_produtoLayout.createSequentialGroup()
                                                .addComponent(lbl_id)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbl_id_valor)))
                                        .addGroup(pnl_alterar_produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnl_alterar_produtoLayout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addComponent(lbl_id_produto1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(pnl_alterar_produtoLayout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addComponent(lbl_nome_atual, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(lbl_preco_atual, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_alterar_produtoLayout.createSequentialGroup()
                                        .addComponent(lbl_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl_categoria_atual, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(pnl_alterar_produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnl_alterar_produtoLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(pnl_alterar_produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_alterar_produtoLayout.createSequentialGroup()
                                                .addComponent(lbl_id_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(39, 39, 39))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_alterar_produtoLayout.createSequentialGroup()
                                                .addComponent(txt_nome_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(46, 46, 46))))
                                    .addGroup(pnl_alterar_produtoLayout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addComponent(cbox_categoria_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(pnl_alterar_produtoLayout.createSequentialGroup()
                                .addComponent(lbl_preco, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_preco_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_alterar_produtoLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lbl_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))
                            .addGroup(pnl_alterar_produtoLayout.createSequentialGroup()
                                .addGroup(pnl_alterar_produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnl_alterar_produtoLayout.createSequentialGroup()
                                        .addComponent(lbl_status, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addComponent(lbl_status_atual, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(44, 44, 44)
                                        .addComponent(checkbox_status_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(filler18, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(filler19, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(filler21, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(filler22, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(pnl_alterar_produtoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(filler24, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_alterar_produtoLayout.setVerticalGroup(
            pnl_alterar_produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_alterar_produtoLayout.createSequentialGroup()
                .addGroup(pnl_alterar_produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_alterar_produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_id_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_id_produto1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_id_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addComponent(filler24, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_alterar_produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_alterar_produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_nome_atual, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_nome_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler18, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(pnl_alterar_produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_preco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_preco_atual, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_preco_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addComponent(filler19, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(pnl_alterar_produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_categoria_atual, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_categoria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbox_categoria_novo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(filler21, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(pnl_alterar_produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_alterar_produtoLayout.createSequentialGroup()
                        .addComponent(lbl_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 68, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler22, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_alterar_produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkbox_status_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_status_atual, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_status, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_alterar_produto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_alterar_produto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nome_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nome_novoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nome_novoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbox_categoria_novo;
    private javax.swing.JCheckBox checkbox_status_novo;
    private javax.swing.Box.Filler filler18;
    private javax.swing.Box.Filler filler19;
    private javax.swing.Box.Filler filler21;
    private javax.swing.Box.Filler filler22;
    private javax.swing.Box.Filler filler24;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_categoria;
    private javax.swing.JLabel lbl_categoria_atual;
    private javax.swing.JLabel lbl_descricao;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_id_produto;
    private javax.swing.JLabel lbl_id_produto1;
    private javax.swing.JLabel lbl_id_valor;
    private javax.swing.JLabel lbl_nome;
    private javax.swing.JLabel lbl_nome_atual;
    private javax.swing.JLabel lbl_preco;
    private javax.swing.JLabel lbl_preco_atual;
    private javax.swing.JLabel lbl_status;
    private javax.swing.JLabel lbl_status_atual;
    private javax.swing.JPanel pnl_alterar_produto;
    private javax.swing.JTextField txt_nome_novo;
    private javax.swing.JTextField txt_preco_novo;
    private javax.swing.JTextArea txtarea_descricao_atual;
    private javax.swing.JTextArea txtarea_descricao_novo;
    // End of variables declaration//GEN-END:variables
}
