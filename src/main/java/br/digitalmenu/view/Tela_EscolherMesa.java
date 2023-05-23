package br.digitalmenu.view;

import br.digitalmenu.dao.MesaDao;
import br.digitalmenu.dao.PedidoDao;
import br.digitalmenu.model.Mesa;
import br.digitalmenu.model.Pedido;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Tela_EscolherMesa extends javax.swing.JFrame {

    public Tela_EscolherMesa() throws SQLException {
        initComponents();
        listarMesa();//popula o combobox
    }

    public void listarMesa() throws SQLException {
        MesaDao mesaDao = new MesaDao();
        for (Mesa mesa : mesaDao.listarTodasMesasPorStatus("ATIVADO")) {//lista todas as mesas ativas
            cbo_mesa.addItem(String.valueOf(mesa.getIdMesa()));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_logar_como_mesa = new javax.swing.JPanel();
        lbl_logarComoMesa = new javax.swing.JLabel();
        cbo_mesa = new javax.swing.JComboBox();
        lbl_numeroMesa = new javax.swing.JLabel();
        btn_ok = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Logar como mesa");

        pnl_logar_como_mesa.setBackground(new java.awt.Color(246, 242, 233));

        lbl_logarComoMesa.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        lbl_logarComoMesa.setForeground(new java.awt.Color(51, 51, 51));
        lbl_logarComoMesa.setText("Logar como mesa");

        cbo_mesa.setBackground(new java.awt.Color(255, 232, 142));
        cbo_mesa.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        cbo_mesa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar" }));
        cbo_mesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_mesaActionPerformed(evt);
            }
        });

        lbl_numeroMesa.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        lbl_numeroMesa.setText("N°Mesa");

        btn_ok.setBackground(new java.awt.Color(255, 243, 198));
        btn_ok.setText("Ok");
        btn_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_okActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_logar_como_mesaLayout = new javax.swing.GroupLayout(pnl_logar_como_mesa);
        pnl_logar_como_mesa.setLayout(pnl_logar_como_mesaLayout);
        pnl_logar_como_mesaLayout.setHorizontalGroup(
            pnl_logar_como_mesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_logar_como_mesaLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(pnl_logar_como_mesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_logarComoMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_logar_como_mesaLayout.createSequentialGroup()
                        .addComponent(lbl_numeroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(cbo_mesa, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_logar_como_mesaLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(btn_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        pnl_logar_como_mesaLayout.setVerticalGroup(
            pnl_logar_como_mesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_logar_como_mesaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbl_logarComoMesa)
                .addGap(18, 18, 18)
                .addGroup(pnl_logar_como_mesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_logar_como_mesaLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lbl_numeroMesa))
                    .addComponent(cbo_mesa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(btn_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_logar_como_mesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_logar_como_mesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(364, 203));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbo_mesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_mesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_mesaActionPerformed

    private void btn_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_okActionPerformed
        MesaDao mDao = new MesaDao();
        if (cbo_mesa.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Escolha uma mesa! ", "Mesa não definida!", JOptionPane.WARNING_MESSAGE);
        } else {
            int numeroMesa = Integer.parseInt(cbo_mesa.getSelectedItem().toString());
            try {
                if (mDao.checkMesa(numeroMesa)) {//Verifica se a mesa realmente existe e esta ativa
                    Pedido pedido = new Pedido();
                    pedido.getMesa().setIdMesa(numeroMesa);
                    PedidoDao pedidoDao = new PedidoDao();
                    pedidoDao.adicionarPedido(pedido);
                    Tela_Menu telaMenu = null;
                    telaMenu = new Tela_Menu(pedidoDao.numeroPedido, numeroMesa);
                    this.dispose();
                    telaMenu.setVisible(true);
                    JOptionPane.showMessageDialog(null, String.format("Bem-Vindo!: [Mesa: %d]",
                            numeroMesa), "Bem-Vindo!", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Mesa invalida! ", "Mesa não está em uso, ative o status da mesa!", JOptionPane.WARNING_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERRO: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btn_okActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ok;
    public javax.swing.JComboBox cbo_mesa;
    private javax.swing.JLabel lbl_logarComoMesa;
    private javax.swing.JLabel lbl_numeroMesa;
    private javax.swing.JPanel pnl_logar_como_mesa;
    // End of variables declaration//GEN-END:variables
}
