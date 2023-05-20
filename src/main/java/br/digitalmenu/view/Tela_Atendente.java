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
        pnlTopo = new javax.swing.JPanel();
        lblTipoAcesso = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnAbrirPedidoJFRAME = new javax.swing.JButton();
        btnListarPedidos = new javax.swing.JButton();
        btnMesas = new javax.swing.JButton();
        btnProdutos = new javax.swing.JButton();
        btnMesas1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
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

        pnlTopo.setBackground(new java.awt.Color(246, 242, 233));

        lblTipoAcesso.setFont(new java.awt.Font("Segoe UI", 1, 70)); // NOI18N
        lblTipoAcesso.setForeground(new java.awt.Color(176, 50, 39));
        lblTipoAcesso.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTipoAcesso.setText("tipoAcesso");

        lblUsuario.setBackground(new java.awt.Color(0, 255, 204));
        lblUsuario.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUsuario.setText("usuario");

        jLabel2.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\garcom.png"));
        jLabel2.setText("Icone");

        javax.swing.GroupLayout pnlTopoLayout = new javax.swing.GroupLayout(pnlTopo);
        pnlTopo.setLayout(pnlTopoLayout);
        pnlTopoLayout.setHorizontalGroup(
            pnlTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTipoAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 888, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlTopoLayout.setVerticalGroup(
            pnlTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTipoAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlTopoLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(246, 242, 233));

        btnAbrirPedidoJFRAME.setBackground(new java.awt.Color(176, 50, 39));
        btnAbrirPedidoJFRAME.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        btnAbrirPedidoJFRAME.setForeground(new java.awt.Color(255, 255, 255));
        btnAbrirPedidoJFRAME.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\waiter.png"));
        btnAbrirPedidoJFRAME.setText("Abrir pedido");
        btnAbrirPedidoJFRAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirPedidoJFRAMEActionPerformed(evt);
            }
        });

        btnListarPedidos.setBackground(new java.awt.Color(176, 50, 39));
        btnListarPedidos.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        btnListarPedidos.setForeground(new java.awt.Color(255, 255, 255));
        btnListarPedidos.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\pedido.png"));
        btnListarPedidos.setText("Pedidos");
        btnListarPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarPedidosActionPerformed(evt);
            }
        });

        btnMesas.setBackground(new java.awt.Color(176, 50, 39));
        btnMesas.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        btnMesas.setForeground(new java.awt.Color(255, 255, 255));
        btnMesas.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\table.png"));
        btnMesas.setText("Mesas");
        btnMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesasActionPerformed(evt);
            }
        });

        btnProdutos.setBackground(new java.awt.Color(176, 50, 39));
        btnProdutos.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        btnProdutos.setForeground(new java.awt.Color(255, 255, 255));
        btnProdutos.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\burguersoda.png"));
        btnProdutos.setText("Produtos");
        btnProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutosActionPerformed(evt);
            }
        });

        btnMesas1.setBackground(new java.awt.Color(234, 0, 44));
        btnMesas1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        btnMesas1.setForeground(new java.awt.Color(255, 255, 255));
        btnMesas1.setText("Sair");
        btnMesas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesas1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 48)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Menu Atendente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(317, 317, 317)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAbrirPedidoJFRAME, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnListarPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMesas, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)))
                .addGap(337, 337, 337))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(598, 598, 598)
                .addComponent(btnMesas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(612, 612, 612))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(470, 470, 470)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(488, 488, 488))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMesas, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(btnListarPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAbrirPedidoJFRAME, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(btnProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(93, 93, 93)
                .addComponent(btnMesas1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jDesktopPane1.setLayer(pnlTopo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(pnlTopo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(pnlTopo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        setSize(new java.awt.Dimension(1414, 762));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        try {
            new Tela_Mesa().setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(Tela_Atendente.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            new Tela_Categoria().setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(Tela_Atendente.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void mnuitemProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuitemProdutoActionPerformed
        try {
            new Tela_Produto().setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(Tela_Atendente.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_mnuitemProdutoActionPerformed

    private void mnuItemPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemPedidoActionPerformed

        try {
            new Tela_Listar_Pedido().setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(Tela_Atendente.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_mnuItemPedidoActionPerformed

    private void btnMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesasActionPerformed

        try {
            new Tela_Mesa().setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(Tela_Atendente.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMesasActionPerformed

    private void btnAbrirPedidoJFRAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirPedidoJFRAMEActionPerformed
        try {
            new Tela_EscolherMesa().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Admin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnAbrirPedidoJFRAMEActionPerformed

    private void btnListarPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarPedidosActionPerformed

        try {
            new Tela_Listar_Pedido().setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(Tela_Atendente.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnListarPedidosActionPerformed

    private void btnProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutosActionPerformed

        try {
            new Tela_Produto().setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(Tela_Atendente.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnProdutosActionPerformed

    private void btnMesas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesas1ActionPerformed
        //Sair
        this.dispose();
        try {
            new Tela_Login().setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(Tela_Atendente.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnMesas1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirPedidoJFRAME;
    private javax.swing.JButton btnListarPedidos;
    private javax.swing.JButton btnMesas;
    private javax.swing.JButton btnMesas1;
    private javax.swing.JButton btnProdutos;
    private javax.swing.JDesktopPane jDesktopPane1;
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
    private javax.swing.JPanel pnlTopo;
    // End of variables declaration//GEN-END:variables
}
