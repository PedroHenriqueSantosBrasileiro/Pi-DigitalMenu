package br.digitalmenu.view;

import br.digitalmenu.dao.MesaDao;
import br.digitalmenu.dao.PedidoDao;
import br.digitalmenu.model.Mesa;
import br.digitalmenu.model.Pedido;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Tela_Atendente extends javax.swing.JFrame {

    public Tela_Atendente(String usuario, String tipoAcesso) {
        initComponents();

        lblUsuario.setText(String.valueOf(usuario));
        lblTipoAcesso.setText(String.valueOf(tipoAcesso));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        pblBotoes = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnAlteraProdutos = new javax.swing.JButton();
        btnPedidos = new javax.swing.JButton();
        btnResumoPedido = new javax.swing.JButton();
        btnUsuarios = new javax.swing.JButton();
        btnMesasJFRAME = new javax.swing.JButton();
        btnAbrirPedidoJFRAME = new javax.swing.JButton();
        btnListarPedidos = new javax.swing.JButton();
        btnCategoriaJFRAME = new javax.swing.JButton();
        btnProdutosJFRAME = new javax.swing.JButton();
        pnlTopo = new javax.swing.JPanel();
        lblTELAADMIN = new javax.swing.JLabel();
        lblTipoAcesso = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuMesa = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        mnuCategoria = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        mnuProduto = new javax.swing.JMenu();
        mnuitemProduto = new javax.swing.JMenuItem();
        mnuPedido = new javax.swing.JMenu();
        mnuItemPedido = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Telas JFrame SDI");

        btnAlteraProdutos.setText("Alterar Produto");
        btnAlteraProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlteraProdutosActionPerformed(evt);
            }
        });

        btnPedidos.setText("Itens pedido");
        btnPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidosActionPerformed(evt);
            }
        });

        btnResumoPedido.setText("Resumo pedido");
        btnResumoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResumoPedidoActionPerformed(evt);
            }
        });

        btnUsuarios.setText("Usuários");
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });

        btnMesasJFRAME.setText("Mesas JFrame");
        btnMesasJFRAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesasJFRAMEActionPerformed(evt);
            }
        });

        btnAbrirPedidoJFRAME.setText("Abrir pedido");
        btnAbrirPedidoJFRAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirPedidoJFRAMEActionPerformed(evt);
            }
        });

        btnListarPedidos.setText("Listar pedidos");
        btnListarPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarPedidosActionPerformed(evt);
            }
        });

        btnCategoriaJFRAME.setText("Categoria JFrame");
        btnCategoriaJFRAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriaJFRAMEActionPerformed(evt);
            }
        });

        btnProdutosJFRAME.setText("ProdutosJFrame");
        btnProdutosJFRAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutosJFRAMEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pblBotoesLayout = new javax.swing.GroupLayout(pblBotoes);
        pblBotoes.setLayout(pblBotoesLayout);
        pblBotoesLayout.setHorizontalGroup(
            pblBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pblBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pblBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pblBotoesLayout.createSequentialGroup()
                        .addGroup(pblBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAlteraProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMesasJFRAME, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pblBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pblBotoesLayout.createSequentialGroup()
                                .addComponent(btnAbrirPedidoJFRAME, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnProdutosJFRAME, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pblBotoesLayout.createSequentialGroup()
                                .addComponent(btnPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnListarPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pblBotoesLayout.createSequentialGroup()
                                .addComponent(btnResumoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCategoriaJFRAME, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel3))
                .addContainerGap(438, Short.MAX_VALUE))
        );
        pblBotoesLayout.setVerticalGroup(
            pblBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pblBotoesLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addGap(38, 38, 38)
                .addGroup(pblBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlteraProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListarPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pblBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnResumoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCategoriaJFRAME, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(pblBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMesasJFRAME, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAbrirPedidoJFRAME, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProdutosJFRAME, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );

        lblTELAADMIN.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTELAADMIN.setForeground(new java.awt.Color(255, 255, 255));
        lblTELAADMIN.setText("Tela admin");

        lblTipoAcesso.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTipoAcesso.setForeground(new java.awt.Color(255, 102, 0));
        lblTipoAcesso.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTipoAcesso.setText("tipoAcesso");

        lblUsuario.setBackground(new java.awt.Color(0, 255, 204));
        lblUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUsuario.setText("usuario");

        javax.swing.GroupLayout pnlTopoLayout = new javax.swing.GroupLayout(pnlTopo);
        pnlTopo.setLayout(pnlTopoLayout);
        pnlTopoLayout.setHorizontalGroup(
            pnlTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlTopoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblTipoAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlTopoLayout.createSequentialGroup()
                        .addComponent(lblTELAADMIN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlTopoLayout.setVerticalGroup(
            pnlTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTELAADMIN)
                    .addComponent(lblUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTipoAcesso)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jDesktopPane1.setLayer(pblBotoes, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(pnlTopo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTopo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pblBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(pnlTopo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pblBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mnuMesa.setText("Mesa");

        jMenuItem1.setText("MesaDAO");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnuMesa.add(jMenuItem1);

        jMenuBar1.add(mnuMesa);

        mnuCategoria.setText("Categoria");

        jMenuItem2.setText("Categoria DAO");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mnuCategoria.add(jMenuItem2);

        jMenuBar1.add(mnuCategoria);

        mnuProduto.setText("Produto");

        mnuitemProduto.setText("Produto DAO");
        mnuitemProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuitemProdutoActionPerformed(evt);
            }
        });
        mnuProduto.add(mnuitemProduto);

        jMenuBar1.add(mnuProduto);

        mnuPedido.setText("Pedido");

        mnuItemPedido.setText("Pedido");
        mnuItemPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemPedidoActionPerformed(evt);
            }
        });
        mnuPedido.add(mnuItemPedido);

        jMenuBar1.add(mnuPedido);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        try {
            new JFRAMETela_Mesa().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Atendente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            new JFRAMETela_Categoria().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Atendente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void mnuitemProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuitemProdutoActionPerformed
        try {
            new JFRAMETela_Produto().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Atendente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_mnuitemProdutoActionPerformed

    private void mnuItemPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemPedidoActionPerformed

        try {
            new JFRAMETela_Listar_Pedido().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Atendente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_mnuItemPedidoActionPerformed

    private void btnAlteraProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlteraProdutosActionPerformed

        new Tela_Alteração_Produto().setVisible(true);

    }//GEN-LAST:event_btnAlteraProdutosActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed

        try {
            new TelaUsuarios().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Atendente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnMesasJFRAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesasJFRAMEActionPerformed

        try {
            new JFRAMETela_Mesa().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Atendente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMesasJFRAMEActionPerformed

    private void btnAbrirPedidoJFRAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirPedidoJFRAMEActionPerformed
        Pedido pedido = new Pedido();

        MesaDao mesaDao = new MesaDao();
        JComboBox jcb = new JComboBox();//combo box do JOption pane
        try {
            for (Mesa mesa : mesaDao.listarTodasMesas()) {
                jcb.addItem(String.valueOf(mesa.getIdMesa()));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Atendente.class.getName()).log(Level.SEVERE, null, ex);
        }

        JOptionPane.showMessageDialog(null, jcb, "Selecione a mesa:", JOptionPane.QUESTION_MESSAGE);
        int mesa = Integer.parseInt(jcb.getSelectedItem().toString());

        if (jcb.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Escolha uma mesa! ", "Mesa não definida!", JOptionPane.WARNING_MESSAGE);
        } else {

            //SETA O ID DO PEDIDO
            pedido.setIdPedido(Integer.parseInt(jcb.getSelectedItem().toString()));

            PedidoDao pedidoDao = new PedidoDao();
            try {
                pedidoDao.adicionarPedido(pedido);
                new Tela_Menu(pedidoDao.numeroPedido, mesa).setVisible(true);
                //this.dispose();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
            }
        }


    }//GEN-LAST:event_btnAbrirPedidoJFRAMEActionPerformed

    private void btnResumoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResumoPedidoActionPerformed

        new Tela_ResumoPedido().setVisible(true);
    }//GEN-LAST:event_btnResumoPedidoActionPerformed

    private void btnPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidosActionPerformed

        new Tela_ItensDoPedido().setVisible(true);

    }//GEN-LAST:event_btnPedidosActionPerformed

    private void btnCategoriaJFRAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriaJFRAMEActionPerformed

        try {
            new JFRAMETela_Categoria().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Atendente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnCategoriaJFRAMEActionPerformed

    private void btnListarPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarPedidosActionPerformed

        try {
            new JFRAMETela_Listar_Pedido().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Atendente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnListarPedidosActionPerformed

    private void btnProdutosJFRAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutosJFRAMEActionPerformed

        try {
            new JFRAMETela_Produto().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Atendente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnProdutosJFRAMEActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirPedidoJFRAME;
    private javax.swing.JButton btnAlteraProdutos;
    private javax.swing.JButton btnCategoriaJFRAME;
    private javax.swing.JButton btnListarPedidos;
    private javax.swing.JButton btnMesasJFRAME;
    private javax.swing.JButton btnPedidos;
    private javax.swing.JButton btnProdutosJFRAME;
    private javax.swing.JButton btnResumoPedido;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JLabel lblTELAADMIN;
    private javax.swing.JLabel lblTipoAcesso;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JMenu mnuCategoria;
    private javax.swing.JMenuItem mnuItemPedido;
    private javax.swing.JMenu mnuMesa;
    private javax.swing.JMenu mnuPedido;
    private javax.swing.JMenu mnuProduto;
    private javax.swing.JMenuItem mnuitemProduto;
    private javax.swing.JPanel pblBotoes;
    private javax.swing.JPanel pnlTopo;
    // End of variables declaration//GEN-END:variables
}
