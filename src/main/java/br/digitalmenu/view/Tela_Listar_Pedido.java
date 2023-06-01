package br.digitalmenu.view;

import br.digitalmenu.dao.PedidoDao;
import br.digitalmenu.heuristicas.Heuristica;
import br.digitalmenu.model.Pedido;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Tela_Listar_Pedido extends Heuristica {

    public int numeroPedido;
    public int numeroMesa;

    public Tela_Listar_Pedido() throws SQLException {
        initComponents();

        jtPedido.getTableHeader().setDefaultRenderer(new CorDoCabecalho());//Muda cor do header na classe heuristica
        IniciaTabela(jtPedido);//Formata a tabela e centraliza pela classe heuristicas
        listarJTable();
    }

    public void metodoAoVoltar() throws SQLException {
        this.listarJTable();
    }

    public void setarCampos(JTable j) {
        if (j.getSelectedRow() != -1) {
            txt_id_pedido.setText(j.getValueAt(j.getSelectedRow(), 0).toString());
            txt_mesa.setText(j.getValueAt(j.getSelectedRow(), 1).toString());
            txtformated_total.setText(j.getValueAt(j.getSelectedRow(), 2).toString());
            txtformated_data.setText(j.getValueAt(j.getSelectedRow(), 3).toString());
            txt_status.setText(j.getValueAt(j.getSelectedRow(), 5).toString());
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha!");
        }
    }

    public void limparTodosCampos() {
        txt_id_pedido.setText("");
        txt_mesa.setText("");
        txtformated_total.setText("");
        txtformated_data.setText("");
        txt_status.setText("");
    }

    public void listarJTable() throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jtPedido.getModel();
        modelo.setNumRows(0);
        PedidoDao pedDao = new PedidoDao();
        for (Pedido pedido : pedDao.listarPedido()) {
            modelo.addRow(new Object[]{
                pedido.getIdPedido(),
                pedido.getMesa().getIdMesa(),
                String.format("%.2f", pedido.getTotal()),
                pedido.getData(),
                pedido.getHorario(),
                pedido.getStatus()
            });
        }
    }

    public void listarJTablePorId(int numPedido) throws SQLException {
        DefaultTableModel modelo2 = (DefaultTableModel) jtPedido.getModel();
        modelo2.setNumRows(0);
        PedidoDao pedDao = new PedidoDao();
        Pedido p = pedDao.listarPedidoPorId(numPedido);
        modelo2.addRow(new Object[]{
            p.getIdPedido(),
            p.getMesa().getIdMesa(),
            String.format("%.2f", p.getTotal()),
            p.getData(),
            p.getHorario(),
            p.getStatus()
        });

    }

    public void listarJTablePorMesa(int numMesa) throws SQLException {
        DefaultTableModel modelo2 = (DefaultTableModel) jtPedido.getModel();
        modelo2.setNumRows(0);
        PedidoDao pedDao = new PedidoDao();
        for (Pedido pedido : pedDao.listarPedidoPorMesa(numMesa)) {
            modelo2.addRow(new Object[]{
                pedido.getIdPedido(),
                pedido.getMesa().getIdMesa(),
                String.format("%.2f", pedido.getTotal()),
                pedido.getData(),
                pedido.getHorario(),
                pedido.getStatus()
            });
        }
    }

    public void listarJTablePorStatus(String status) throws SQLException {
        DefaultTableModel modelo2 = (DefaultTableModel) jtPedido.getModel();
        modelo2.setNumRows(0);
        PedidoDao pedDao = new PedidoDao();
        for (Pedido pedido : pedDao.listarPedidoPorStatus(status)) {
            modelo2.addRow(new Object[]{
                pedido.getIdPedido(),
                pedido.getMesa().getIdMesa(),
                String.format("%.2f", pedido.getTotal()),
                pedido.getData(),
                pedido.getHorario(),
                pedido.getStatus()
            });
        }
    }

    public void listarJtablePorFaixaDePreco(double valor1, double valor2) throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jtPedido.getModel();
        modelo.setNumRows(0);
        PedidoDao pedidoDao = new PedidoDao();
        for (Pedido pedido : pedidoDao.listarProdutoPorFaixaDePreco(valor1, valor2)) {
            modelo.addRow(new Object[]{
                pedido.getIdPedido(),
                pedido.getMesa().getIdMesa(),
                String.format("%.2f", pedido.getTotal()),
                pedido.getData(),
                pedido.getHorario(),
                pedido.getStatus()
            });
        }
    }

    public void listarJtablePorDia(String valor1) throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jtPedido.getModel();
        modelo.setNumRows(0);
        PedidoDao pedidoDao = new PedidoDao();
        for (Pedido pedido : pedidoDao.listarProdutoPorDia(valor1)) {
            modelo.addRow(new Object[]{
                pedido.getIdPedido(),
                pedido.getMesa().getIdMesa(),
                String.format("%.2f", pedido.getTotal()),
                pedido.getData(),
                pedido.getHorario(),
                pedido.getStatus()
            });
        }
    }

    public void listarJtablePorFaixaDeData(String valor1, String valor2) throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jtPedido.getModel();
        modelo.setNumRows(0);
        PedidoDao pedidoDao = new PedidoDao();
        for (Pedido pedido : pedidoDao.listarProdutoPorFaixaDia(valor1, valor2)) {
            modelo.addRow(new Object[]{
                pedido.getIdPedido(),
                pedido.getMesa().getIdMesa(),
                String.format("%.2f", pedido.getTotal()),
                pedido.getData(),
                pedido.getHorario(),
                pedido.getStatus()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_listar_pedido = new javax.swing.JPanel();
        pnl_superior = new javax.swing.JPanel();
        lbl_IdPedido = new javax.swing.JLabel();
        txt_id_pedido = new javax.swing.JTextField();
        lbl_mesa = new javax.swing.JLabel();
        txt_mesa = new javax.swing.JTextField();
        lbl_data = new javax.swing.JLabel();
        txtformated_data = new javax.swing.JFormattedTextField();
        lbl_status = new javax.swing.JLabel();
        txt_status = new javax.swing.JTextField();
        lbl_total = new javax.swing.JLabel();
        txtformated_total = new javax.swing.JFormattedTextField();
        btn_ver_itens = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPedido = new javax.swing.JTable();
        pnl_filtros = new javax.swing.JPanel();
        btn_filtro_id = new javax.swing.JButton();
        btn_filtro_mesa = new javax.swing.JButton();
        btn_filtro_status = new javax.swing.JButton();
        btn_filtro_total = new javax.swing.JButton();
        btn_filtro_dia = new javax.swing.JButton();
        btn_filtro_periodo = new javax.swing.JButton();
        btn_filtro_todos = new javax.swing.JButton();
        pnl_opcoes = new javax.swing.JPanel();
        btn_mudar_status = new javax.swing.JButton();
        btn_AbrirPedido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listar Pedidos");

        pnl_listar_pedido.setBackground(new java.awt.Color(255, 255, 255));

        pnl_superior.setBackground(new java.awt.Color(246, 242, 233));
        pnl_superior.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        lbl_IdPedido.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_IdPedido.setText("ID Pedido");

        txt_id_pedido.setEditable(false);
        txt_id_pedido.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txt_id_pedido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_id_pedido.setMinimumSize(new java.awt.Dimension(165, 38));

        lbl_mesa.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_mesa.setText("Mesa:");

        txt_mesa.setEditable(false);
        txt_mesa.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txt_mesa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_mesa.setMinimumSize(new java.awt.Dimension(165, 38));

        lbl_data.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_data.setText("Data:");

        txtformated_data.setEditable(false);
        txtformated_data.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        txtformated_data.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtformated_data.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtformated_data.setMinimumSize(new java.awt.Dimension(165, 38));
        txtformated_data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtformated_dataActionPerformed(evt);
            }
        });

        lbl_status.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_status.setText("Status:");

        txt_status.setEditable(false);
        txt_status.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txt_status.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_status.setMinimumSize(new java.awt.Dimension(165, 38));

        lbl_total.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_total.setText("Total:");

        txtformated_total.setEditable(false);
        txtformated_total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtformated_total.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtformated_total.setMinimumSize(new java.awt.Dimension(165, 38));

        btn_ver_itens.setBackground(new java.awt.Color(255, 243, 198));
        btn_ver_itens.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        btn_ver_itens.setText("Ver itens");
        btn_ver_itens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ver_itensActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_superiorLayout = new javax.swing.GroupLayout(pnl_superior);
        pnl_superior.setLayout(pnl_superiorLayout);
        pnl_superiorLayout.setHorizontalGroup(
            pnl_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_superiorLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(pnl_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_status)
                    .addComponent(lbl_IdPedido)
                    .addComponent(lbl_mesa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_mesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_id_pedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_superiorLayout.createSequentialGroup()
                        .addComponent(lbl_total)
                        .addGap(1, 1, 1))
                    .addComponent(lbl_data, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtformated_data, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtformated_total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_ver_itens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(83, 83, 83))
        );
        pnl_superiorLayout.setVerticalGroup(
            pnl_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_superiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_superiorLayout.createSequentialGroup()
                        .addGroup(pnl_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_total)
                            .addComponent(txtformated_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnl_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_data)
                            .addComponent(txtformated_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_ver_itens)
                        .addContainerGap())
                    .addGroup(pnl_superiorLayout.createSequentialGroup()
                        .addGroup(pnl_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_id_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_IdPedido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnl_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_mesa)
                            .addComponent(txt_mesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnl_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_status)
                            .addComponent(txt_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))))
        );

        jtPedido.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jtPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Pedido", "Mesa", "Total", "Data", "Horario", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtPedido.setRowHeight(30);
        jtPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jtPedidoMouseReleased(evt);
            }
        });
        jtPedido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtPedidoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtPedido);

        pnl_filtros.setBackground(new java.awt.Color(246, 242, 233));
        pnl_filtros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisar pedido", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        btn_filtro_id.setBackground(new java.awt.Color(255, 243, 198));
        btn_filtro_id.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_filtro_id.setText("ID");
        btn_filtro_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_filtro_idActionPerformed(evt);
            }
        });

        btn_filtro_mesa.setBackground(new java.awt.Color(255, 243, 198));
        btn_filtro_mesa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_filtro_mesa.setText("Mesa");
        btn_filtro_mesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_filtro_mesaActionPerformed(evt);
            }
        });

        btn_filtro_status.setBackground(new java.awt.Color(255, 243, 198));
        btn_filtro_status.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_filtro_status.setText("Status");
        btn_filtro_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_filtro_statusActionPerformed(evt);
            }
        });

        btn_filtro_total.setBackground(new java.awt.Color(255, 243, 198));
        btn_filtro_total.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_filtro_total.setText("Total");
        btn_filtro_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_filtro_totalActionPerformed(evt);
            }
        });

        btn_filtro_dia.setBackground(new java.awt.Color(255, 243, 198));
        btn_filtro_dia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_filtro_dia.setText("Dia");
        btn_filtro_dia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_filtro_diaActionPerformed(evt);
            }
        });

        btn_filtro_periodo.setBackground(new java.awt.Color(255, 243, 198));
        btn_filtro_periodo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_filtro_periodo.setText("Data");
        btn_filtro_periodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_filtro_periodoActionPerformed(evt);
            }
        });

        btn_filtro_todos.setBackground(new java.awt.Color(255, 243, 198));
        btn_filtro_todos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_filtro_todos.setText("Todos");
        btn_filtro_todos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_filtro_todosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_filtrosLayout = new javax.swing.GroupLayout(pnl_filtros);
        pnl_filtros.setLayout(pnl_filtrosLayout);
        pnl_filtrosLayout.setHorizontalGroup(
            pnl_filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_filtrosLayout.createSequentialGroup()
                .addGap(364, 364, 364)
                .addComponent(btn_filtro_id, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_filtro_mesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_filtro_status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_filtro_total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_filtro_dia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_filtro_periodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_filtro_todos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(372, 372, 372))
        );
        pnl_filtrosLayout.setVerticalGroup(
            pnl_filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btn_filtro_id, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_filtro_mesa, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_filtro_status, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_filtro_todos, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_filtro_total, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_filtro_periodo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_filtro_dia, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnl_opcoes.setBackground(new java.awt.Color(246, 242, 233));
        pnl_opcoes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opções", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24))); // NOI18N
        pnl_opcoes.setPreferredSize(new java.awt.Dimension(670, 181));

        btn_mudar_status.setBackground(new java.awt.Color(204, 255, 204));
        btn_mudar_status.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        btn_mudar_status.setText("Alterar Status");
        btn_mudar_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mudar_statusActionPerformed(evt);
            }
        });

        btn_AbrirPedido.setBackground(new java.awt.Color(176, 50, 39));
        btn_AbrirPedido.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        btn_AbrirPedido.setForeground(new java.awt.Color(255, 255, 255));
        btn_AbrirPedido.setText("Abrir Pedido");
        btn_AbrirPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AbrirPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_opcoesLayout = new javax.swing.GroupLayout(pnl_opcoes);
        pnl_opcoes.setLayout(pnl_opcoesLayout);
        pnl_opcoesLayout.setHorizontalGroup(
            pnl_opcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_opcoesLayout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addGroup(pnl_opcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_AbrirPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_mudar_status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(211, 211, 211))
        );
        pnl_opcoesLayout.setVerticalGroup(
            pnl_opcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_opcoesLayout.createSequentialGroup()
                .addComponent(btn_mudar_status, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_AbrirPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnl_listar_pedidoLayout = new javax.swing.GroupLayout(pnl_listar_pedido);
        pnl_listar_pedido.setLayout(pnl_listar_pedidoLayout);
        pnl_listar_pedidoLayout.setHorizontalGroup(
            pnl_listar_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_listar_pedidoLayout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
                .addGap(193, 193, 193))
            .addGroup(pnl_listar_pedidoLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnl_listar_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_filtros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnl_listar_pedidoLayout.createSequentialGroup()
                        .addComponent(pnl_superior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl_opcoes, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
        );
        pnl_listar_pedidoLayout.setVerticalGroup(
            pnl_listar_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_listar_pedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_listar_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnl_superior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_opcoes, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_filtros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnl_listar_pedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_listar_pedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1416, 808));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtformated_dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtformated_dataActionPerformed

    }//GEN-LAST:event_txtformated_dataActionPerformed

    private void btn_ver_itensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ver_itensActionPerformed
        // TODO add your handling code here:
        if (jtPedido.getSelectedRow() != -1) {
            numeroPedido = Integer.parseInt(txt_id_pedido.getText());
            numeroMesa = Integer.parseInt(txt_mesa.getText());
            try {
                Tela_ItensDoPedido telaItensDoPedido = new Tela_ItensDoPedido(numeroPedido, numeroMesa, this);

                telaItensDoPedido.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Escolha um pedido!");
        }
    }//GEN-LAST:event_btn_ver_itensActionPerformed

    private void jtPedidoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPedidoMouseReleased
        setarCampos(jtPedido);
    }//GEN-LAST:event_jtPedidoMouseReleased

    private void jtPedidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPedidoKeyReleased
        setarCampos(jtPedido);
    }//GEN-LAST:event_jtPedidoKeyReleased

    private void btn_filtro_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_filtro_idActionPerformed
        try {
            JPanel painel = new JPanel();
            JLabel idPedido = new JLabel("Digite o ID: ");
            JTextField digitarNumero = new JTextField(10);
            painel.add(idPedido);
            painel.add(digitarNumero);

            int resultado = JOptionPane.showConfirmDialog(null, painel, "PESQUISAR POR ID", JOptionPane.OK_CANCEL_OPTION, -1);
            if (resultado == JOptionPane.OK_OPTION) {
                //tratar erro de entrada
                listarJTablePorId(Integer.parseInt(digitarNumero.getText()));
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Campo Id: Apenas números!", "ERRO", HEIGHT);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Pedido não encontrado!");
        }

    }//GEN-LAST:event_btn_filtro_idActionPerformed

    private void btn_filtro_todosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_filtro_todosActionPerformed
        try {
            listarJTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_filtro_todosActionPerformed

    private void btn_filtro_mesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_filtro_mesaActionPerformed
        try {
            JPanel painel = new JPanel();
            JLabel idMesa = new JLabel("Digite o número da mesa: ");
            JTextField digitarNumero = new JTextField(10);
            painel.add(idMesa);
            painel.add(digitarNumero);
            int resultado = JOptionPane.showConfirmDialog(null, painel, "PESQUISAR POR NÚMERO DA MESA", JOptionPane.OK_CANCEL_OPTION, -1);
            if (resultado == JOptionPane.OK_OPTION) {
                listarJTablePorMesa(Integer.parseInt(digitarNumero.getText()));
                if (jtPedido.getRowCount() < 1) {
                    //
                    // ERRO
                    //      MSG DE BORDAS (CENTRALIZADAS JTBLES)
                    //
                    //
                    JOptionPane.showMessageDialog(null, String.format("Pedido(s) não encontrado(s) na mesa %s", digitarNumero.getText()));
                    listarJTable();
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Campo Mesa: Apenas números!", "ERRO", HEIGHT);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Pedido(s) não encontrado(s)");
        }
    }//GEN-LAST:event_btn_filtro_mesaActionPerformed

    private void btn_filtro_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_filtro_statusActionPerformed
        JPanel painel = new JPanel();
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Aberto");
        comboBox.addItem("Cancelado");
        comboBox.addItem("Encerrado");
        painel.add(new JLabel("Status: "));
        painel.add(comboBox);
        int result = JOptionPane.showConfirmDialog(null, painel, "FILTRAR POR STATUS", JOptionPane.OK_CANCEL_OPTION, -1);
        if (result == JOptionPane.OK_OPTION) {
            try {
                String status = String.valueOf(comboBox.getSelectedItem());
                listarJTablePorStatus(status);
                if (jtPedido.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Nenhum pedido encontrado no status selecionado");
                    listarJTable();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_filtro_statusActionPerformed

    private void btn_filtro_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_filtro_totalActionPerformed
        JTextField valorInicial = new JTextField(10);
        JTextField valorFinal = new JTextField(10);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("De:"));
        myPanel.add(valorInicial);
        myPanel.add(Box.createHorizontalStrut(10)); // a spacer
        myPanel.add(new JLabel("Até:"));
        myPanel.add(valorFinal);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Informe a faixa de valor:", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                double valor1 = Double.parseDouble(valorInicial.getText().replace(',', '.'));
                double valor2 = Double.parseDouble(valorFinal.getText().replace(',', '.'));
                listarJtablePorFaixaDePreco(valor1, valor2);
                if (jtPedido.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Nenhum pedido encontrado!");
                    listarJTable();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valores: Apenas números!", "ERRO", HEIGHT);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_filtro_totalActionPerformed

    private void btn_filtro_periodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_filtro_periodoActionPerformed
        JTextField valorInicial = new JTextField(10);
        JTextField valorFinal = new JTextField(10);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("De: (dd/mm/aaaa)"));
        myPanel.add(valorInicial);
        myPanel.add(Box.createHorizontalStrut(10)); // a spacer
        myPanel.add(new JLabel("Até: (dd/mm/aaaa)"));
        myPanel.add(valorFinal);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Informe a data:", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                String valor1 = valorInicial.getText();
                String valor2 = valorFinal.getText();
                listarJtablePorFaixaDeData(valor1, valor2);
                if (jtPedido.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Nenhum pedido encontrado!");
                    listarJTable();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }

    }//GEN-LAST:event_btn_filtro_periodoActionPerformed

    private void btn_filtro_diaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_filtro_diaActionPerformed
        JTextField valorInicial = new JTextField(10);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Data: (dd/mm/aaaa)"));
        myPanel.add(valorInicial);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Informe a data:", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                String data = valorInicial.getText();
                listarJtablePorDia(data);
                if (jtPedido.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Nenhum pedido encontrado!");
                    listarJTable();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_filtro_diaActionPerformed

    private void btn_mudar_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mudar_statusActionPerformed
        if (jtPedido.getSelectedRow() != -1) {

            JPanel panel = new JPanel();
            panel.add(new JLabel("Selecione o status: "));
            JComboBox comboBox = new JComboBox();
            comboBox.addItem("ABERTO");
            comboBox.addItem("CANCELADO");
            comboBox.addItem("ENCERRADO");
            panel.add(comboBox);

            int confirma = JOptionPane.showConfirmDialog(null, panel, "Selecione o status.", JOptionPane.OK_CANCEL_OPTION);
            if (confirma == JOptionPane.YES_OPTION) {
                DefaultTableModel dtm = (DefaultTableModel) jtPedido.getModel();
                PedidoDao pedidoDao = new PedidoDao();
                try {
                    String status = String.valueOf(comboBox.getSelectedItem());
                    int id = Integer.parseInt(jtPedido.getValueAt(jtPedido.getSelectedRow(), 0).toString());
                    pedidoDao.cancelarPedido(id, status);
                    listarJTable();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", HEIGHT);
                }
            }
        } else if (jtPedido.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Não há itens no pedido.", "ERRO", HEIGHT);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um pedido.", "ERRO", HEIGHT);
        }
    }//GEN-LAST:event_btn_mudar_statusActionPerformed


    private void btn_AbrirPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AbrirPedidoActionPerformed
        if (jtPedido.getSelectedRow() != -1) {
            try {
                Tela_Menu telaMenu = new Tela_Menu(Integer.parseInt(txt_id_pedido.getText()), Integer.parseInt(txt_mesa.getText()), true);
                this.dispose();
                telaMenu.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Tela_Listar_Pedido.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um pedido.", "ERRO", HEIGHT);
        }
    }//GEN-LAST:event_btn_AbrirPedidoActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela_Listar_Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Listar_Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Listar_Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Listar_Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Tela_Listar_Pedido().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Tela_Listar_Pedido.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_AbrirPedido;
    private javax.swing.JButton btn_filtro_dia;
    private javax.swing.JButton btn_filtro_id;
    private javax.swing.JButton btn_filtro_mesa;
    private javax.swing.JButton btn_filtro_periodo;
    private javax.swing.JButton btn_filtro_status;
    private javax.swing.JButton btn_filtro_todos;
    private javax.swing.JButton btn_filtro_total;
    private javax.swing.JButton btn_mudar_status;
    private javax.swing.JButton btn_ver_itens;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtPedido;
    private javax.swing.JLabel lbl_IdPedido;
    private javax.swing.JLabel lbl_data;
    private javax.swing.JLabel lbl_mesa;
    private javax.swing.JLabel lbl_status;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JPanel pnl_filtros;
    private javax.swing.JPanel pnl_listar_pedido;
    private javax.swing.JPanel pnl_opcoes;
    private javax.swing.JPanel pnl_superior;
    private javax.swing.JTextField txt_id_pedido;
    private javax.swing.JTextField txt_mesa;
    private javax.swing.JTextField txt_status;
    private javax.swing.JFormattedTextField txtformated_data;
    private javax.swing.JFormattedTextField txtformated_total;
    // End of variables declaration//GEN-END:variables
}
