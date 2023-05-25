package br.digitalmenu.view;

import br.digitalmenu.dao.CategoriaDao;
import br.digitalmenu.heuristicas.Heuristica;
import br.digitalmenu.model.Categoria;
import java.sql.DataTruncation;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Tela_Categoria extends Heuristica {

    int idCategoriaInicial = 0;
    String statusInicial = "";

    public Tela_Categoria() throws SQLException {
        initComponents();
        txt_numero_id_categoria.setEnabled(false);
        jtCategoria.getTableHeader().setDefaultRenderer(new CorDoCabecalho());//Muda cor do header na classe heuristica
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
        txt_numero_id_categoria.setText("");
        txt_nome_categoria.setText("");
    }

    public void atualizarCategoria() {
        try {
            CategoriaDao categoriaDao = new CategoriaDao();
            Categoria categoria = categoriaDao.listarCategoriaPorId(Integer.parseInt(String.valueOf(jtCategoria.getValueAt(jtCategoria.getSelectedRow(), 0))));//trocar pelo TXT getTExt?
            Panel_Alterar_Categoria panel = new Panel_Alterar_Categoria(categoria);
            JOptionPane.showConfirmDialog(null, panel, "Atualizar categoria", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            categoria.setIdCategoria(Integer.parseInt(panel.getTxt_id_novo().getText()));
            categoria.setNomeCategoria(panel.getTxt_nome_novo().getText());
            categoria.setStatus(panel.getComboBox_status_novo1().getSelectedItem().toString());
            categoriaDao.updateCategoria(categoria, Integer.valueOf(String.valueOf(jtCategoria.getValueAt(jtCategoria.getSelectedRow(), 0))));
            JOptionPane.showMessageDialog(
                    this,
                    "Categoria atualizda com sucesso!");
            listarJTableTodosAtivos();
            limparTxtFields();
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "Categoria já existente!", "\t\tERRO", HEIGHT);
            atualizarCategoria(); //recursao
        } catch (DataTruncation ex) {
            JOptionPane.showMessageDialog(null, "Dado inválido, limite de 30 caracteres!", "\tErro", HEIGHT);
            atualizarCategoria(); //recursao
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_superior = new javax.swing.JPanel();
        pnl_cadastra_categoria = new javax.swing.JPanel();
        lbl_id_categoria = new javax.swing.JLabel();
        txt_numero_id_categoria = new javax.swing.JTextField();
        lbl_nome_categoria = new javax.swing.JLabel();
        txt_nome_categoria = new javax.swing.JTextField();
        btn_cadastrar_categoria = new javax.swing.JButton();
        pnl_opcoes = new javax.swing.JPanel();
        btn_atualizar_categoria = new javax.swing.JButton();
        btn_deletar_categoria = new javax.swing.JButton();
        pnl_filtros = new javax.swing.JPanel();
        btn_pesquisa_id = new javax.swing.JButton();
        btn_pesquisa_nome = new javax.swing.JButton();
        btn_pesquisa_status = new javax.swing.JButton();
        brn_pesquisa_todos = new javax.swing.JButton();
        pnl_inferior = new javax.swing.JPanel();
        tableCategoria = new javax.swing.JScrollPane();
        jtCategoria = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Categoria");

        pnl_superior.setBackground(new java.awt.Color(255, 255, 255));

        pnl_cadastra_categoria.setBackground(new java.awt.Color(246, 242, 233));
        pnl_cadastra_categoria.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastrar categoria", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24))); // NOI18N
        pnl_cadastra_categoria.setToolTipText("");
        pnl_cadastra_categoria.setPreferredSize(new java.awt.Dimension(670, 181));

        lbl_id_categoria.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_id_categoria.setText("ID da Categoria:");

        txt_numero_id_categoria.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_numero_id_categoria.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_numero_id_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_numero_id_categoriaActionPerformed(evt);
            }
        });

        lbl_nome_categoria.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_nome_categoria.setText("Nome categoria:");

        txt_nome_categoria.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txt_nome_categoria.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nome_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nome_categoriaActionPerformed(evt);
            }
        });
        txt_nome_categoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nome_categoriaKeyPressed(evt);
            }
        });

        btn_cadastrar_categoria.setBackground(new java.awt.Color(255, 243, 198));
        btn_cadastrar_categoria.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_cadastrar_categoria.setText("Cadastrar");
        btn_cadastrar_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrar_categoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_cadastra_categoriaLayout = new javax.swing.GroupLayout(pnl_cadastra_categoria);
        pnl_cadastra_categoria.setLayout(pnl_cadastra_categoriaLayout);
        pnl_cadastra_categoriaLayout.setHorizontalGroup(
            pnl_cadastra_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_cadastra_categoriaLayout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addGroup(pnl_cadastra_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txt_numero_id_categoria)
                    .addComponent(lbl_id_categoria)
                    .addComponent(lbl_nome_categoria)
                    .addComponent(txt_nome_categoria)
                    .addComponent(btn_cadastrar_categoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(230, 230, 230))
        );
        pnl_cadastra_categoriaLayout.setVerticalGroup(
            pnl_cadastra_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_cadastra_categoriaLayout.createSequentialGroup()
                .addComponent(lbl_id_categoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_numero_id_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_nome_categoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_nome_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cadastrar_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );

        pnl_opcoes.setBackground(new java.awt.Color(246, 242, 233));
        pnl_opcoes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opções", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24))); // NOI18N
        pnl_opcoes.setPreferredSize(new java.awt.Dimension(670, 181));

        btn_atualizar_categoria.setBackground(new java.awt.Color(204, 255, 204));
        btn_atualizar_categoria.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_atualizar_categoria.setText("Atualizar");
        btn_atualizar_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atualizar_categoriaActionPerformed(evt);
            }
        });

        btn_deletar_categoria.setBackground(new java.awt.Color(255, 153, 153));
        btn_deletar_categoria.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_deletar_categoria.setText("Deletar");
        btn_deletar_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deletar_categoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_opcoesLayout = new javax.swing.GroupLayout(pnl_opcoes);
        pnl_opcoes.setLayout(pnl_opcoesLayout);
        pnl_opcoesLayout.setHorizontalGroup(
            pnl_opcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_opcoesLayout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addGroup(pnl_opcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_deletar_categoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_atualizar_categoria, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))
                .addGap(210, 210, 210))
        );
        pnl_opcoesLayout.setVerticalGroup(
            pnl_opcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_opcoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_atualizar_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_deletar_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_filtros.setBackground(new java.awt.Color(246, 242, 233));
        pnl_filtros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        btn_pesquisa_id.setBackground(new java.awt.Color(255, 243, 198));
        btn_pesquisa_id.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_pesquisa_id.setText("ID");
        btn_pesquisa_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesquisa_idActionPerformed(evt);
            }
        });

        btn_pesquisa_nome.setBackground(new java.awt.Color(255, 243, 198));
        btn_pesquisa_nome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_pesquisa_nome.setText("Nome");
        btn_pesquisa_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesquisa_nomeActionPerformed(evt);
            }
        });

        btn_pesquisa_status.setBackground(new java.awt.Color(255, 243, 198));
        btn_pesquisa_status.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_pesquisa_status.setText("Status");
        btn_pesquisa_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesquisa_statusActionPerformed(evt);
            }
        });

        brn_pesquisa_todos.setBackground(new java.awt.Color(255, 243, 198));
        brn_pesquisa_todos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        brn_pesquisa_todos.setText("Todos");
        brn_pesquisa_todos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brn_pesquisa_todosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_filtrosLayout = new javax.swing.GroupLayout(pnl_filtros);
        pnl_filtros.setLayout(pnl_filtrosLayout);
        pnl_filtrosLayout.setHorizontalGroup(
            pnl_filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_filtrosLayout.createSequentialGroup()
                .addGap(405, 405, 405)
                .addComponent(btn_pesquisa_id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_pesquisa_nome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_pesquisa_status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(brn_pesquisa_todos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(427, 427, 427))
        );
        pnl_filtrosLayout.setVerticalGroup(
            pnl_filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_filtrosLayout.createSequentialGroup()
                .addGroup(pnl_filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(brn_pesquisa_todos, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_pesquisa_status, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_pesquisa_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_pesquisa_id, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_superiorLayout = new javax.swing.GroupLayout(pnl_superior);
        pnl_superior.setLayout(pnl_superiorLayout);
        pnl_superiorLayout.setHorizontalGroup(
            pnl_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_superiorLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pnl_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnl_filtros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnl_superiorLayout.createSequentialGroup()
                        .addComponent(pnl_cadastra_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 639, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl_opcoes, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)))
                .addGap(35, 35, 35))
        );
        pnl_superiorLayout.setVerticalGroup(
            pnl_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_superiorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnl_opcoes, javax.swing.GroupLayout.PREFERRED_SIZE, 263, Short.MAX_VALUE)
                    .addComponent(pnl_cadastra_categoria, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_filtros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnl_inferior.setBackground(new java.awt.Color(255, 255, 255));

        jtCategoria.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
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
        jtCategoria.setRowHeight(30);
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

        javax.swing.GroupLayout pnl_inferiorLayout = new javax.swing.GroupLayout(pnl_inferior);
        pnl_inferior.setLayout(pnl_inferiorLayout);
        pnl_inferiorLayout.setHorizontalGroup(
            pnl_inferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_inferiorLayout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(tableCategoria)
                .addGap(204, 204, 204))
        );
        pnl_inferiorLayout.setVerticalGroup(
            pnl_inferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tableCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_superior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_inferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_superior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnl_inferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1394, 807));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtCategoriaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCategoriaMouseReleased
        if (jtCategoria.getSelectedRow() != -1) {
            txt_numero_id_categoria.setText(jtCategoria.getValueAt(jtCategoria.getSelectedRow(), 0).toString());
            txt_nome_categoria.setText(jtCategoria.getValueAt(jtCategoria.getSelectedRow(), 1).toString());
            idCategoriaInicial = Integer.parseInt(txt_numero_id_categoria.getText());
            statusInicial = txt_nome_categoria.getText();
        }
    }//GEN-LAST:event_jtCategoriaMouseReleased

    private void jtCategoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCategoriaKeyReleased
        if (jtCategoria.getSelectedRow() != -1) {
            txt_numero_id_categoria.setText(jtCategoria.getValueAt(jtCategoria.getSelectedRow(), 0).toString());
            txt_nome_categoria.setText(jtCategoria.getValueAt(jtCategoria.getSelectedRow(), 1).toString());
            idCategoriaInicial = Integer.parseInt(txt_numero_id_categoria.getText());
            statusInicial = txt_nome_categoria.getText();
        }
    }//GEN-LAST:event_jtCategoriaKeyReleased

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
    }//GEN-LAST:event_btn_pesquisa_statusActionPerformed

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
                    JOptionPane.showMessageDialog(null, "Dados não encontrados.");
                    listarJTableTodosAtivos();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_pesquisa_nomeActionPerformed

    private void btn_pesquisa_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesquisa_idActionPerformed
        JPanel painel = new JPanel();
        JLabel lbl_numeroId = new JLabel("Número: ");
        JTextField txt_numeroId = new JTextField(10);
        painel.add(lbl_numeroId);
        painel.add(txt_numeroId);
        int resultado = JOptionPane.showConfirmDialog(null, painel, "PESQUISA POR ID", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (resultado == JOptionPane.OK_OPTION) {
            try {
                int idPesquisar = Integer.parseInt(txt_numeroId.getText());
                listarJTablePorId(idPesquisar);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Insira apenas números inteiros!", "Erro", HEIGHT);
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Erro: identificador não cadastrado!");
                try {
                    listarJTableTodosAtivos();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Operação cancelada!");
        }
    }//GEN-LAST:event_btn_pesquisa_idActionPerformed

    private void btn_deletar_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deletar_categoriaActionPerformed
        if (jtCategoria.getSelectedRow() != -1) {
            if (jtCategoria.getValueAt(jtCategoria.getSelectedRow(), 2).toString().equalsIgnoreCase("Desativado")) {
                JOptionPane.showMessageDialog(null, "Categoria já está desativada!", "Deletar categoria", HEIGHT);
            } else {
                int confirma = JOptionPane.showConfirmDialog(this,
                        "Dados da categoria a deletar:\nID: "
                        + txt_numero_id_categoria.getText()
                        + "\nNome: "
                        + txt_nome_categoria.getText(),
                        "Confirmar deleção?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );
                if (confirma == JOptionPane.YES_OPTION) {
                    Categoria cat = new Categoria();

                    cat.setIdCategoria(Integer.parseInt(txt_numero_id_categoria.getText()));
                    cat.setNomeCategoria(txt_nome_categoria.getText());
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
                    JOptionPane.showMessageDialog(null, "Operacão cancelada!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha!");
        }
    }//GEN-LAST:event_btn_deletar_categoriaActionPerformed

    private void btn_atualizar_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atualizar_categoriaActionPerformed

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
                    categoriaDao.updateCategoria(categoria, Integer.valueOf(String.valueOf(jtCategoria.getValueAt(jtCategoria.getSelectedRow(), 0))));
                    JOptionPane.showMessageDialog(this,
                            "Categoria atualizada com sucesso!");
                    listarJTableTodosAtivos();
                    limparTxtFields();
                } else {
                    JOptionPane.showMessageDialog(null, "Operação Cancelada!");
                }
            } catch (SQLIntegrityConstraintViolationException ex) {
                JOptionPane.showMessageDialog(null, "Categoria já existente!", "\t\tERRO", HEIGHT);
                atualizarCategoria();
            } catch (DataTruncation ex) {
                JOptionPane.showMessageDialog(null, "Dado inválido, limite de 30 caracteres!", "\tErro", HEIGHT);
                atualizarCategoria();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha.");
        }

    }//GEN-LAST:event_btn_atualizar_categoriaActionPerformed

    private void btn_cadastrar_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrar_categoriaActionPerformed

        if (verificarSeCampoEstaEmBranco(txt_nome_categoria, "Categoria")) {
            Categoria categoria = new Categoria();
            categoria.setNomeCategoria(txt_nome_categoria.getText());
            CategoriaDao catDao = new CategoriaDao();
            try {
                catDao.criarCategoria(categoria);
                listarJTableTodosAtivos();
                JOptionPane.showMessageDialog(this,
                        "Categoria adicionada com sucesso!\nCategoria: "
                        + categoria.getNomeCategoria());
                limparTxtFields();
            } catch (SQLIntegrityConstraintViolationException ex) {
                JOptionPane.showMessageDialog(null, "Categoria já existente!", "\t\tERRO", HEIGHT);
                txt_nome_categoria.setText("");
            } catch (DataTruncation ex) {
                JOptionPane.showMessageDialog(null, "Dado inválido, limite de 30 caracteres!", "\tErro", HEIGHT);
                txt_nome_categoria.setText("");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", HEIGHT);
            }
        }
    }//GEN-LAST:event_btn_cadastrar_categoriaActionPerformed

    private void txt_nome_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nome_categoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nome_categoriaActionPerformed

    private void txt_numero_id_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_numero_id_categoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_numero_id_categoriaActionPerformed

    private void txt_nome_categoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nome_categoriaKeyPressed
        // TODO add your handling code here:
        letrasApenas(txt_nome_categoria, evt);
    }//GEN-LAST:event_txt_nome_categoriaKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brn_pesquisa_todos;
    private javax.swing.JButton btn_atualizar_categoria;
    private javax.swing.JButton btn_cadastrar_categoria;
    private javax.swing.JButton btn_deletar_categoria;
    private javax.swing.JButton btn_pesquisa_id;
    private javax.swing.JButton btn_pesquisa_nome;
    private javax.swing.JButton btn_pesquisa_status;
    private javax.swing.JTable jtCategoria;
    private javax.swing.JLabel lbl_id_categoria;
    private javax.swing.JLabel lbl_nome_categoria;
    private javax.swing.JPanel pnl_cadastra_categoria;
    private javax.swing.JPanel pnl_filtros;
    private javax.swing.JPanel pnl_inferior;
    private javax.swing.JPanel pnl_opcoes;
    private javax.swing.JPanel pnl_superior;
    private javax.swing.JScrollPane tableCategoria;
    private javax.swing.JTextField txt_nome_categoria;
    private javax.swing.JTextField txt_numero_id_categoria;
    // End of variables declaration//GEN-END:variables
}
