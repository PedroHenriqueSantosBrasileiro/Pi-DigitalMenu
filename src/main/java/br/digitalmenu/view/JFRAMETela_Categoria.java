package br.digitalmenu.view;

import br.digitalmenu.dao.CategoriaDao;
import br.digitalmenu.heuristicas.Heuristica;
import br.digitalmenu.model.Categoria;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JFRAMETela_Categoria extends Heuristica {

    int idCategoriaInicial = 0;
    String statusInicial = "";

    public JFRAMETela_Categoria() throws SQLException {
        initComponents();
        txt_Numero_IdCategoria.setEnabled(false);
        IniciaTabela(jtCategoria);
        listarJTableTodosAtivos();//Formata a tabela e centraliza pela classe heuristicas

    }

    public void listarJTableTodasCategorias() throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jtCategoria.getModel();
        modelo.setNumRows(0);
        CategoriaDao catDao = new CategoriaDao();
        for (Categoria categoria : catDao.listarCategoria()) {
            modelo.addRow(new Object[]{
                categoria.getIdCategoria(),
                categoria.getNomeCategoria(),
                categoria.getStatus()
            });
        }
    }

    public void listarJTableTodosAtivos() throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jtCategoria.getModel();
        modelo.setNumRows(0);
        CategoriaDao catDao = new CategoriaDao();
        for (Categoria categoria : catDao.listarCategoriasAtivas()) {
            modelo.addRow(new Object[]{
                categoria.getIdCategoria(),
                categoria.getNomeCategoria(),
                categoria.getStatus()
            });
        }
    }

    public void listarJTablePorId(int id) throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jtCategoria.getModel();
        modelo.setNumRows(0);
        CategoriaDao catDao = new CategoriaDao();
        Categoria categoria = catDao.listarCategoriaPorId(id);
        modelo.addRow(new Object[]{
            categoria.getIdCategoria(),
            categoria.getNomeCategoria(),
            categoria.getStatus()
        });
    }

    public void listarJTablePorNome(String texto) throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jtCategoria.getModel();
        modelo.setNumRows(0);
        CategoriaDao catDao = new CategoriaDao();
        for (Categoria categoria : catDao.listarCategoriaPorNome(texto)) {
            modelo.addRow(new Object[]{
                categoria.getIdCategoria(),
                categoria.getNomeCategoria(),
                categoria.getStatus()
            });
        }
    }

    public void listarJtablePorStatus(String status) throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jtCategoria.getModel();
        modelo.setNumRows(0);
        CategoriaDao categoriaDao = new CategoriaDao();
        for (Categoria categoria : categoriaDao.listarCategoriasPorStatus(status)) {
            modelo.addRow(new Object[]{
                categoria.getIdCategoria(),
                categoria.getNomeCategoria(),
                categoria.getStatus()
            });
        }
    }

    public void limparTxtFields() {
        txt_Numero_IdCategoria.setText("");
        txt_NomeCategoria.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        tableCategoria = new javax.swing.JScrollPane();
        jtCategoria = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btn_pesquisa_id = new javax.swing.JButton();
        btn_pesquisa_nome = new javax.swing.JButton();
        btn_pesquisa_status = new javax.swing.JButton();
        brn_pesquisa_todos = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lbl_IdCategoria = new javax.swing.JLabel();
        txt_Numero_IdCategoria = new javax.swing.JTextField();
        lbl_NomeCategoria = new javax.swing.JLabel();
        txt_NomeCategoria = new javax.swing.JTextField();
        btn_Cadastrar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btn_Atualizar = new javax.swing.JButton();
        btn_Deletar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Categoria");

        jtCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Categoria", "Nome", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jtCategoriaMouseReleased(evt);
            }
        });
        jtCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtCategoriaKeyReleased(evt);
            }
        });
        tableCategoria.setViewportView(jtCategoria);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("PESQUISAR"));

        btn_pesquisa_id.setText("Id");
        btn_pesquisa_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesquisa_idActionPerformed(evt);
            }
        });

        btn_pesquisa_nome.setText("Nome");
        btn_pesquisa_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesquisa_nomeActionPerformed(evt);
            }
        });

        btn_pesquisa_status.setText("Status");
        btn_pesquisa_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesquisa_statusActionPerformed(evt);
            }
        });

        brn_pesquisa_todos.setText("Todos");
        brn_pesquisa_todos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brn_pesquisa_todosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btn_pesquisa_id)
                .addGap(58, 58, 58)
                .addComponent(btn_pesquisa_nome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_pesquisa_status)
                .addGap(56, 56, 56)
                .addComponent(brn_pesquisa_todos)
                .addGap(22, 22, 22))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_pesquisa_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_pesquisa_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_pesquisa_status, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(brn_pesquisa_todos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tableCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("CADASTRAR"));
        jPanel3.setToolTipText("");

        lbl_IdCategoria.setText("Id da Categoria:");

        txt_Numero_IdCategoria.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lbl_NomeCategoria.setText("Nome categoria:");

        txt_NomeCategoria.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_NomeCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NomeCategoriaActionPerformed(evt);
            }
        });

        btn_Cadastrar.setText("Cadastrar");
        btn_Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_IdCategoria)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(35, Short.MAX_VALUE)
                        .addComponent(lbl_NomeCategoria)
                        .addGap(27, 27, 27))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_Numero_IdCategoria)
                            .addComponent(btn_Cadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_NomeCategoria))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbl_IdCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Numero_IdCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_NomeCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_NomeCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Cadastrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 192, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 237, Short.MAX_VALUE)
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("OPCÇÕES"));

        btn_Atualizar.setText("Atualizar");
        btn_Atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AtualizarActionPerformed(evt);
            }
        });

        btn_Deletar.setText("Deletar");
        btn_Deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_Deletar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Atualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btn_Atualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btn_Deletar)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(441, 441, 441))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(478, 587));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtCategoriaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCategoriaMouseReleased
        if (jtCategoria.getSelectedRow() != -1) {
            txt_Numero_IdCategoria.setText(jtCategoria.getValueAt(jtCategoria.getSelectedRow(), 0).toString());
            txt_NomeCategoria.setText(jtCategoria.getValueAt(jtCategoria.getSelectedRow(), 1).toString());
            idCategoriaInicial = Integer.parseInt(txt_Numero_IdCategoria.getText());
            statusInicial = txt_NomeCategoria.getText();
        }
    }//GEN-LAST:event_jtCategoriaMouseReleased

    private void jtCategoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCategoriaKeyReleased
        if (jtCategoria.getSelectedRow() != -1) {
            txt_Numero_IdCategoria.setText(jtCategoria.getValueAt(jtCategoria.getSelectedRow(), 0).toString());
            txt_NomeCategoria.setText(jtCategoria.getValueAt(jtCategoria.getSelectedRow(), 1).toString());
            idCategoriaInicial = Integer.parseInt(txt_Numero_IdCategoria.getText());
            statusInicial = txt_NomeCategoria.getText();
        }
    }//GEN-LAST:event_jtCategoriaKeyReleased

    private void btn_CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CadastrarActionPerformed

        if (verificarSeCampoEstaEmBranco(txt_NomeCategoria, "Categoria")) {
            Categoria categoria = new Categoria();
            categoria.setNomeCategoria(txt_NomeCategoria.getText());
            CategoriaDao catDao = new CategoriaDao();
            try {
                catDao.criarCategoria(categoria);
                listarJTableTodosAtivos();
                JOptionPane.showMessageDialog(this,
                        "Categoria adicionada com sucesso!\nNome: "
                        + categoria.getNomeCategoria());
                limparTxtFields();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
            }
        }

    }//GEN-LAST:event_btn_CadastrarActionPerformed

    private void btn_AtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AtualizarActionPerformed

        if (jtCategoria.getRowCount() != -1) {
            try {
                CategoriaDao categoriaDao = new CategoriaDao();
                Categoria categoria = categoriaDao.listarCategoriaPorId(Integer.parseInt(String.valueOf(jtCategoria.getValueAt(jtCategoria.getSelectedRow(), 0))));//trocar pelo TXT getTExt?
                Panel_Alterar_Categoria panel = new Panel_Alterar_Categoria(categoria);
                int resultado = JOptionPane.showConfirmDialog(null, panel, "ALTERAR CATEGORIA", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (resultado == JOptionPane.OK_OPTION) {
                    categoria.setIdCategoria(Integer.parseInt(panel.getTxt_id_novo().getText()));
                    categoria.setNomeCategoria(panel.getTxt_nome_novo().getText());
                    categoria.setStatus(panel.getComboBox_status_novo1().getSelectedItem().toString());
                    categoriaDao.updateCategoria(categoria, Integer.parseInt(String.valueOf(jtCategoria.getValueAt(jtCategoria.getSelectedRow(), 0))));
                    listarJTableTodosAtivos();
                    limparTxtFields();
                } else {
                    JOptionPane.showMessageDialog(null, "Operacao Cancelada!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha.");
        }

        /*if (jtCategoria.getSelectedRow() != -1) {
            int confirma = JOptionPane.showConfirmDialog(
                this,
                "Dados atuais:\nId: "
                + idCategoriaInicial
                + "\nNome: "
                + statusInicial
                + "\nDADOS ATUALIZADOS:"
                + "\nID: "
                + txt_Numero_IdCategoria.getText()
                + "\nNome: "
                + txt_NomeCategoria.getText(),
                "CONFIRMAR ALTERÃ‡ÃƒO(Ã•ES)",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );
            //
            if (confirma == JOptionPane.YES_OPTION) {
                //
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(Integer.parseInt(txt_Numero_IdCategoria.getText()));
                categoria.setNomeCategoria(txt_NomeCategoria.getText());
                CategoriaDao catDao = new CategoriaDao();
                try {
                    catDao.updateCategoria(categoria, idCategoriaInicial);
                    txt_Numero_IdCategoria.setText("");
                    txt_NomeCategoria.setText("");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
                }
                try {
                    listarJTableTodosAtivos();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
                }
            } else if (confirma == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "OperaÃ§Ã£o cancelada");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha!");
        } */
    }//GEN-LAST:event_btn_AtualizarActionPerformed

    private void btn_DeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeletarActionPerformed

        if (jtCategoria.getSelectedRow() != -1) {

            int confirma = JOptionPane.showConfirmDialog(this,
                    "Dados da categoria a deletar:\n ID: "
                    + txt_Numero_IdCategoria.getText()
                    + "\nNome: "
                    + txt_NomeCategoria.getText(),
                    "Confirmar deleÃ§Ã£o?",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (confirma == JOptionPane.YES_OPTION) {
                Categoria cat = new Categoria();
                cat.setIdCategoria(Integer.parseInt(txt_Numero_IdCategoria.getText()));
                cat.setNomeCategoria(txt_NomeCategoria.getText());
                CategoriaDao catDao = new CategoriaDao();
                try {
                    catDao.deleteCategoria(cat);
                    JOptionPane.showMessageDialog(null, "Categoria deletada com sucesso!");
                    listarJTableTodosAtivos();
                    limparTxtFields();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                }
            } else if (confirma == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Operacão cancelada");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha!");
        }
    }//GEN-LAST:event_btn_DeletarActionPerformed

    private void txt_NomeCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NomeCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NomeCategoriaActionPerformed

    private void btn_pesquisa_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesquisa_idActionPerformed
        JPanel painel = new JPanel();
        JLabel lbl_numeroId = new JLabel("Número: ");
        JTextField txt_numeroId = new JTextField(10);
        painel.add(lbl_numeroId);
        painel.add(txt_numeroId);
        int resultado = JOptionPane.showConfirmDialog(null, painel, "PESQUISA POR ID", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (resultado == JOptionPane.OK_OPTION) {
            int idPesquisar = Integer.parseInt(txt_numeroId.getText());
            try {
                listarJTablePorId(idPesquisar);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "op cancelada");
        }


    }//GEN-LAST:event_btn_pesquisa_idActionPerformed

    private void btn_pesquisa_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesquisa_nomeActionPerformed
        JPanel painel = new JPanel();
        JLabel nomeProduto = new JLabel("Palavra: ");
        JTextField digitarPalavra = new JTextField(25);
        painel.add(nomeProduto);
        painel.add(digitarPalavra);
        int result = JOptionPane.showConfirmDialog(null, painel, "Pesquisar categoria", JOptionPane.OK_CANCEL_OPTION);
        String palavraPesquisar = digitarPalavra.getText();
        if (result == JOptionPane.OK_OPTION) {
            try {
                listarJTablePorNome(palavraPesquisar);
                if (jtCategoria.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Palavra não encontrada.");
                    listarJTableTodosAtivos();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }

    }//GEN-LAST:event_btn_pesquisa_nomeActionPerformed

    private void brn_pesquisa_todosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brn_pesquisa_todosActionPerformed
        try {
            listarJTableTodasCategorias();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }

    }//GEN-LAST:event_brn_pesquisa_todosActionPerformed

    private void btn_pesquisa_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesquisa_statusActionPerformed
        JPanel painel = new JPanel();
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Ativado");
        comboBox.addItem("Desativado");
        painel.add(new JLabel("Status: "));
        painel.add(comboBox);
        int result = JOptionPane.showConfirmDialog(null, painel, "Pesquisar por Status", JOptionPane.OK_CANCEL_OPTION, -1);
        if (result == JOptionPane.OK_OPTION) {
            try {
                String status = String.valueOf(comboBox.getSelectedItem());
                listarJtablePorStatus(status);
                if (jtCategoria.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Não há produtos no status " + status);
                    listarJtablePorStatus("ativado");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }

        /*
                JPanel painel = new JPanel();
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Ativado");
        comboBox.addItem("Desativado");
        painel.add(new JLabel("Status: "));
        painel.add(comboBox);
        int result = JOptionPane.showConfirmDialog(null, painel, "ALTERAR MESA", JOptionPane.OK_CANCEL_OPTION, -1);
        if (result == JOptionPane.OK_OPTION) {
            try {
                String status = String.valueOf(comboBox.getSelectedItem());
                listarJtablePorStatus(status);
                if (jtMesa.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Não há produtos no status " + status);
                    listarJtablePorStatus("ativado");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }
         */
    }//GEN-LAST:event_btn_pesquisa_statusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brn_pesquisa_todos;
    private javax.swing.JButton btn_Atualizar;
    private javax.swing.JButton btn_Cadastrar;
    private javax.swing.JButton btn_Deletar;
    private javax.swing.JButton btn_pesquisa_id;
    private javax.swing.JButton btn_pesquisa_nome;
    private javax.swing.JButton btn_pesquisa_status;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTable jtCategoria;
    private javax.swing.JLabel lbl_IdCategoria;
    private javax.swing.JLabel lbl_NomeCategoria;
    private javax.swing.JScrollPane tableCategoria;
    private javax.swing.JTextField txt_NomeCategoria;
    private javax.swing.JTextField txt_Numero_IdCategoria;
    // End of variables declaration//GEN-END:variables
}
