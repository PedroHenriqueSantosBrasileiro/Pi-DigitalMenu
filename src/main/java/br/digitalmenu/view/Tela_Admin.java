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

public class Tela_Admin extends javax.swing.JFrame {

    public Tela_Admin(String usuario, String tipoAcesso) {
        initComponents();

        jDesktopPane1.enable(false);//Deixa a cor do fundo a mostra, deixa o jDesktop desativado

        //Casting para a primeira letra do tipoAcesso ficar em Maiusculo
        tipoAcesso = String.valueOf(tipoAcesso);
        String s1 = tipoAcesso.substring(0, 1).toUpperCase();
        String tipoAcessoMaisculo = s1 + tipoAcesso.substring(1);

        //Seta a label usuario e tipo de acesso
        lblUsuario.setText(String.valueOf(usuario));
        lblTipoAcesso.setText(String.valueOf(tipoAcessoMaisculo));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        pblBotoes = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnUsuarios = new javax.swing.JButton();
        btnListarPedidos = new javax.swing.JButton();
        btnProdutos = new javax.swing.JButton();
        btnMesas1 = new javax.swing.JButton();
        btnCategoria = new javax.swing.JButton();
        btnMesas = new javax.swing.JButton();
        pnlTopo = new javax.swing.JPanel();
        lblTipoAcesso = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnAbrirPedidoJFRAME = new javax.swing.JButton();
        btnRelatorio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
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

        jDesktopPane1.setBackground(new java.awt.Color(224, 222, 217));

        pblBotoes.setBackground(new java.awt.Color(246, 242, 233));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Gerenciar");

        btnUsuarios.setBackground(new java.awt.Color(171, 68, 35));
        btnUsuarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btnUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        btnUsuarios.setText("Usuários");
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });

        btnListarPedidos.setBackground(new java.awt.Color(171, 68, 35));
        btnListarPedidos.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btnListarPedidos.setForeground(new java.awt.Color(255, 255, 255));
        btnListarPedidos.setText("Pedidos");
        btnListarPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarPedidosActionPerformed(evt);
            }
        });

        btnProdutos.setBackground(new java.awt.Color(171, 68, 35));
        btnProdutos.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btnProdutos.setForeground(new java.awt.Color(255, 255, 255));
        btnProdutos.setText("Produtos");
        btnProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutosActionPerformed(evt);
            }
        });

        btnMesas1.setBackground(new java.awt.Color(234, 0, 44));
        btnMesas1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btnMesas1.setForeground(new java.awt.Color(255, 255, 255));
        btnMesas1.setText("Sair");
        btnMesas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesas1ActionPerformed(evt);
            }
        });

        btnCategoria.setBackground(new java.awt.Color(171, 68, 35));
        btnCategoria.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btnCategoria.setForeground(new java.awt.Color(255, 255, 255));
        btnCategoria.setText("<html> <html> <body> <h><div style=\"text-align:center\"> Categorias de produtos</h></center> </body> </html>");
        btnCategoria.setActionCommand("<html> <html> <body> <p> Categorias de produtos</p> </body> </html>");
        btnCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriaActionPerformed(evt);
            }
        });

        btnMesas.setBackground(new java.awt.Color(171, 68, 35));
        btnMesas.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btnMesas.setForeground(new java.awt.Color(255, 255, 255));
        btnMesas.setText("Mesas");
        btnMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pblBotoesLayout = new javax.swing.GroupLayout(pblBotoes);
        pblBotoes.setLayout(pblBotoesLayout);
        pblBotoesLayout.setHorizontalGroup(
            pblBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pblBotoesLayout.createSequentialGroup()
                .addGroup(pblBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pblBotoesLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pblBotoesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pblBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUsuarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnListarPedidos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnProdutos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMesas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pblBotoesLayout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(btnMesas1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        pblBotoesLayout.setVerticalGroup(
            pblBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pblBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListarPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMesas1)
                .addContainerGap())
        );

        pnlTopo.setBackground(new java.awt.Color(246, 242, 233));

        lblTipoAcesso.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblTipoAcesso.setForeground(new java.awt.Color(255, 102, 0));
        lblTipoAcesso.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTipoAcesso.setText("tipoAcesso");

        lblUsuario.setBackground(new java.awt.Color(0, 255, 204));
        lblUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUsuario.setText("usuario");

        jLabel2.setText("Icone");

        javax.swing.GroupLayout pnlTopoLayout = new javax.swing.GroupLayout(pnlTopo);
        pnlTopo.setLayout(pnlTopoLayout);
        pnlTopoLayout.setHorizontalGroup(
            pnlTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTipoAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 277, Short.MAX_VALUE)
                .addGroup(pnlTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlTopoLayout.setVerticalGroup(
            pnlTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTopoLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUsuario))
                    .addComponent(lblTipoAcesso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(246, 242, 233));

        btnAbrirPedidoJFRAME.setBackground(new java.awt.Color(171, 68, 35));
        btnAbrirPedidoJFRAME.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btnAbrirPedidoJFRAME.setForeground(new java.awt.Color(255, 255, 255));
        btnAbrirPedidoJFRAME.setText("Abrir pedido");
        btnAbrirPedidoJFRAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirPedidoJFRAMEActionPerformed(evt);
            }
        });

        btnRelatorio.setBackground(new java.awt.Color(171, 68, 35));
        btnRelatorio.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btnRelatorio.setForeground(new java.awt.Color(255, 255, 255));
        btnRelatorio.setText("<html> <html> <body> <p> Gerar relatório</p> </body> </html>");
        btnRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioActionPerformed(evt);
            }
        });

        jLabel1.setText("<html> <html> <body>  <h1>Aqui vai ter o relatório das vendas?</h1\n> <p>Texto HTML.</p>  </body> </html>");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAbrirPedidoJFRAME, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAbrirPedidoJFRAME, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jDesktopPane1.setLayer(pblBotoes, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(pnlTopo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(pnlTopo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDesktopPane1Layout.createSequentialGroup()
                .addComponent(pblBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(pnlTopo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pblBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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

        setSize(new java.awt.Dimension(935, 583));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        try {
            new JFRAMETela_Mesa().setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(Tela_Admin.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            new JFRAMETela_Categoria().setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(Tela_Admin.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void mnuitemProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuitemProdutoActionPerformed
        try {
            new JFRAMETela_Produto().setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(Tela_Admin.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_mnuitemProdutoActionPerformed

    private void mnuItemPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemPedidoActionPerformed

        try {
            new JFRAMETela_Listar_Pedido().setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(Tela_Admin.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_mnuItemPedidoActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed

        try {
            new TelaUsuarios().setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(Tela_Admin.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesasActionPerformed

        try {
            new JFRAMETela_Mesa().setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(Tela_Admin.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMesasActionPerformed

    private void btnAbrirPedidoJFRAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirPedidoJFRAMEActionPerformed
        Pedido pedido = new Pedido();

        MesaDao mesaDao = new MesaDao();
        JComboBox jcb = new JComboBox();//combo box do JOption pane
        try {
            for (Mesa mesa : mesaDao.listarTodasMesasPorStatus("ATIVADO")) {//lista todas as mesas ativas
                jcb.addItem(String.valueOf(mesa.getIdMesa()));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Admin.class.getName()).log(Level.SEVERE, null, ex);
        }

        JOptionPane.showMessageDialog(null, jcb, "Selecione a mesa:", JOptionPane.QUESTION_MESSAGE);

        int numeroMesa = Integer.parseInt(jcb.getSelectedItem().toString());

        try {
            if (mesaDao.checkMesa(numeroMesa)) {//Verifica se a mesa realmente existe e esta ativa
                //Cria pedido
                pedido.setIdPedido(Integer.parseInt(jcb.getSelectedItem().toString()));
                PedidoDao pedidoDao = new PedidoDao();
                pedidoDao.adicionarPedido(pedido);

                //Abre tela menu com o numero do pedido e mesa
                new Tela_Menu(pedidoDao.numeroPedido, numeroMesa).setVisible(true);
                //this.dispose();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO: " + ex.getMessage());
        }


    }//GEN-LAST:event_btnAbrirPedidoJFRAMEActionPerformed

    private void btnCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriaActionPerformed

        try {
            new JFRAMETela_Categoria().setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(Tela_Admin.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnCategoriaActionPerformed

    private void btnListarPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarPedidosActionPerformed

        try {
            new JFRAMETela_Listar_Pedido().setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(Tela_Admin.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnListarPedidosActionPerformed

    private void btnProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutosActionPerformed

        try {
            new JFRAMETela_Produto().setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(Tela_Admin.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnProdutosActionPerformed

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
        // TODO add your handling code here:
        TelaRelatorio telaRelatorio = new TelaRelatorio();
        telaRelatorio.setVisible(true);
    }//GEN-LAST:event_btnRelatorioActionPerformed

    private void btnMesas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesas1ActionPerformed
        //Sair
        this.dispose();
        try {
            new Tela_Login().setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(Tela_Admin.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnMesas1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirPedidoJFRAME;
    private javax.swing.JButton btnCategoria;
    private javax.swing.JButton btnListarPedidos;
    private javax.swing.JButton btnMesas;
    private javax.swing.JButton btnMesas1;
    private javax.swing.JButton btnProdutos;
    private javax.swing.JButton btnRelatorio;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
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
