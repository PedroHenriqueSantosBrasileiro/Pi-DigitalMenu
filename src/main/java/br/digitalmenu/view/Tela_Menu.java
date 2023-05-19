package br.digitalmenu.view;

import br.digitalmenu.dao.ItemDao;
import br.digitalmenu.dao.PedidoDao;
import br.digitalmenu.dao.ProdutoDao;
import br.digitalmenu.dao.RelatorioDao;
import br.digitalmenu.model.Item;
import br.digitalmenu.model.Pedido;
import br.digitalmenu.model.Produto;
import br.digitalmenu.model.relatorio.ItemRelatorio;
import java.awt.TextArea;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class Tela_Menu extends javax.swing.JFrame {

    private double total = 0.0;
    JLabel lblId[] = new JLabel[5];
    JLabel lblNomes[] = new JLabel[5];
    JTextArea txtDescricoes[] = new JTextArea[5];
    JLabel lblPrecos[] = new JLabel[5];
    JLabel lblFotos[] = new JLabel[5];
    JLabel lblQtde[] = new JLabel[5];
    public DecimalFormat decimalFormat = new DecimalFormat("##.00");
    private int numeroPedido;
    private int numeroMesa;

    public Tela_Menu() {
    }

    public Tela_Menu(int numeroPedido, int numeroMesa) throws SQLException {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.numeroPedido = numeroPedido;
        this.numeroMesa = numeroMesa;
        lbl_NumeroPedido.setText("Pedido: " + String.valueOf(numeroPedido));
        lbl_NumeroDaMesa.setText(String.valueOf("Mesa: " + numeroMesa));
        setTodos();
        setCat(lblId, 1);
        setFotos(1);
        setPorCat(lblNomes, txtDescricoes, lblPrecos, lblId);
        pnl_Labels_Id.setVisible(false);

    }

    public void setLblId() {
        lblId[0] = lbl_Id_1;
        lblId[1] = lbl_Id_2;
        lblId[2] = lbl_Id_3;
        lblId[3] = lbl_Id_4;
        lblId[4] = lbl_Id_5;
    }

    public void setLblNomes() {
        lblNomes[0] = lbl_nome_1;
        lblNomes[1] = lbl_nome_2;
        lblNomes[2] = lbl_nome_3;
        lblNomes[3] = lbl_nome_4;
        lblNomes[4] = lbl_nome_5;
    }

    public void setTxtAreaDescricoes() {
        txtDescricoes[0] = txt_descricao_1;
        txtDescricoes[1] = txt_descricao_2;
        txtDescricoes[2] = txt_descricao_3;
        txtDescricoes[3] = txt_descricao_4;
        txtDescricoes[4] = txt_descricao_5;
    }

    public void setLblPrecos() {
        lblPrecos[0] = lbl_preco_1;
        lblPrecos[1] = lbl_preco_2;
        lblPrecos[2] = lbl_preco_3;
        lblPrecos[3] = lbl_preco_4;
        lblPrecos[4] = lbl_preco_5;

    }

    public void setLblFotos() {
        lblFotos[0] = lbl_foto_1;
        lblFotos[1] = lbl_foto_2;
        lblFotos[2] = lbl_foto_3;
        lblFotos[3] = lbl_foto_4;
        lblFotos[4] = lbl_foto_5;

    }

    public void setLblQtdes() {
        lblQtde[0] = lbl_qtde_1;
        lblQtde[1] = lbl_qtde_2;
        lblQtde[2] = lbl_qtde_3;
        lblQtde[3] = lbl_qtde_4;
        lblQtde[4] = lbl_qtde_5;

    }

    public void setTodos() {
        setLblId();
        setLblNomes();
        setTxtAreaDescricoes();
        setLblPrecos();
        setLblFotos();
        setLblQtdes();
    }

    public void setCat(JLabel[] labelId, int cat) {
        if (cat == 1) {
            lblId[0].setText("1");
            lblId[1].setText("2");
            lblId[2].setText("3");
            lblId[3].setText("4");
            lblId[4].setText("5");
        } else if (cat == 2) {
            lblId[0].setText("6");
            lblId[1].setText("7");
            lblId[2].setText("8");
            lblId[3].setText("9");
            lblId[4].setText("10");
        } else if (cat == 3) {
            lblId[0].setText("11");
            lblId[1].setText("12");
            lblId[2].setText("13");
            lblId[3].setText("14");
            lblId[4].setText("15");
        } else if (cat == 4) {
            lblId[0].setText("16");
            lblId[1].setText("17");
            lblId[2].setText("18");
            lblId[3].setText("19");
            lblId[4].setText("20");
        } else if (cat == 5) {
            lblId[0].setText("21");
            lblId[1].setText("22");
            lblId[2].setText("23");
            lblId[3].setText("24");
            lblId[4].setText("25");
        } else {

        }
    }

    public void setPorCat(JLabel[] labelNomes, JTextArea[] txtDescricoes, JLabel[] labelPrecos, JLabel[] labelIDs) throws SQLException {
        ProdutoDao prodDao = new ProdutoDao();
        DecimalFormat df = new DecimalFormat("0.00");
        for (int i = 0; i < labelNomes.length; i++) {
            labelNomes[i].setText(prodDao.listarProdutoPorId(Integer.parseInt(labelIDs[i].getText())).getNome());
            txtDescricoes[i].setText(prodDao.listarProdutoPorId(Integer.parseInt(labelIDs[i].getText())).getDescricao());
            labelPrecos[i].setText("R$ " + String.valueOf(df.format(prodDao.listarProdutoPorId(Integer.parseInt(labelIDs[i].getText())).getPreco())));
        }
    }

    public void setFotos(int cat) {
        if (cat == 1) {
            lbl_foto_1.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Entrada1.png"));
            lbl_foto_2.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Entrada2.png"));
            lbl_foto_3.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Entrada3.png"));
            lbl_foto_4.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Entrada4.png"));
            lbl_foto_5.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Entrada5.png"));
        } else if (cat == 2) {
            lbl_foto_1.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Carne1.png"));
            lbl_foto_2.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Carne2.png"));
            lbl_foto_3.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Carne3.png"));
            lbl_foto_4.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Carne4.png"));
            lbl_foto_5.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Carne5.png"));
        } else if (cat == 3) {
            lbl_foto_1.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Burg1.png"));
            lbl_foto_2.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Burg2.png"));
            lbl_foto_3.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Burg3.png"));
            lbl_foto_4.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Burg4.png"));
            lbl_foto_5.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Burg5.png"));
        } else if (cat == 4) {
            lbl_foto_1.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Suco1.png"));
            lbl_foto_2.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Suco2.jpg"));
            lbl_foto_3.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Refri1.jpg"));
            lbl_foto_4.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Refri2.jpg"));
            lbl_foto_5.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Refri3.jpg"));
        } else if (cat == 5) {
            lbl_foto_1.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Sobremesa1.png"));
            lbl_foto_2.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Sobremesa2.png"));
            lbl_foto_3.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Sobremesa3.png"));
            lbl_foto_4.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Sobremesa4.png"));
            lbl_foto_5.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Sobremesa5.png"));
        } else {

        }

    }

    public void calculaTotal() {
        int numDeItens = jtResumo.getRowCount();
        for (int i = 0; i < numDeItens; i++) {
            double totalPorItem = Double.valueOf(jtResumo.getValueAt(i, 4).toString());
            total += totalPorItem;
        }
        DecimalFormat df = new DecimalFormat("0.00");
//        lblTotal.setText(df.format(total));

    }

    public void addPrato(Produto produto, int qtdeLbl, String desc) {

        DefaultTableModel dtm = (DefaultTableModel) jtResumo.getModel();

        for (int row = 0; row < jtResumo.getRowCount(); row++) {
            if (produto.getNome().equalsIgnoreCase(jtResumo.getValueAt(row, 1).toString())) {
                dtm.removeRow(jtResumo.convertRowIndexToModel(row));
            }
        }
        dtm.addRow(new Object[]{
            produto.getIdProduto(),
            produto.getNome(),
            produto.getPreco(),
            qtdeLbl,
            (qtdeLbl * produto.getPreco()),
            desc
        });

    }

    public void removeQtde(JLabel lblQtde) {
        int qtde = Integer.parseInt(lblQtde.getText());
        if (qtde > 0) {
            --qtde;
            lblQtde.setText(String.valueOf(qtde));
        }
    }

    public void adicionaQtde(JLabel lblQtde) {
        int qtde = Integer.parseInt(lblQtde.getText());
        ++qtde;
        lblQtde.setText(String.valueOf(qtde));
    }

    public void adicionaNoPreCarrinho(JLabel lblQtde, JLabel lblId, JTextArea txtObs) {
        int qtde = Integer.parseInt(lblQtde.getText());
        if (qtde > 0) {
            ProdutoDao produtoDao = new ProdutoDao();
            int numeroId = Integer.parseInt(lblId.getText());
            String desc = txtObs.getText();
            Produto p = null;
            try {
                p = produtoDao.listarProdutoPorId(numeroId);
                addPrato(p, qtde, desc);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "ERRO BOTAO: " + ex.getMessage());
            }
            txtObs.setText("");
        }

    }

    public void limparTabela() {
        DefaultTableModel dtm = (DefaultTableModel) jtResumo.getModel();
        dtm.setNumRows(0);

    }

    public void limparQtde() {
        for (int i = 0; i < lblQtde.length; i++) {
            lblQtde[i].setText("0");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnl_Categoria = new javax.swing.JPanel();
        btn_categoria_entradas = new javax.swing.JButton();
        btn_categoria_carnes = new javax.swing.JButton();
        btn_categoria_frutos = new javax.swing.JButton();
        btn_categoria_bebidas = new javax.swing.JButton();
        btn_categoria_sobremesas = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        pnl_ItensCardapio = new javax.swing.JPanel();
        pnl_Item1 = new javax.swing.JPanel();
        lbl_foto_1 = new javax.swing.JLabel();
        lbl_nome_1 = new javax.swing.JLabel();
        lbl_preco_1 = new javax.swing.JLabel();
        btn_remove_1 = new javax.swing.JButton();
        lbl_qtde_1 = new javax.swing.JLabel();
        btn_adiciona_1 = new javax.swing.JButton();
        lbl_obs_1 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        txt_obs_1 = new javax.swing.JTextArea();
        btn_adicionaCarrinho_1 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        txt_descricao_1 = new javax.swing.JTextArea();
        pnl_Item2 = new javax.swing.JPanel();
        lbl_foto_2 = new javax.swing.JLabel();
        lbl_nome_2 = new javax.swing.JLabel();
        lbl_preco_2 = new javax.swing.JLabel();
        btn_remove_2 = new javax.swing.JButton();
        lbl_qtde_2 = new javax.swing.JLabel();
        btn_adiciona_2 = new javax.swing.JButton();
        lbl_obs_2 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        txt_obs_2 = new javax.swing.JTextArea();
        btn_adicionaCarrinho_2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txt_descricao_2 = new javax.swing.JTextArea();
        pnl_Item3 = new javax.swing.JPanel();
        lbl_foto_3 = new javax.swing.JLabel();
        lbl_nome_3 = new javax.swing.JLabel();
        lbl_preco_3 = new javax.swing.JLabel();
        lbl_qtde_3 = new javax.swing.JLabel();
        btn_remove_3 = new javax.swing.JButton();
        btn_adiciona_3 = new javax.swing.JButton();
        lbl_obs_3 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        txt_obs_3 = new javax.swing.JTextArea();
        btn_adicionaCarrinho_3 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        txt_descricao_3 = new javax.swing.JTextArea();
        pnl_Item4 = new javax.swing.JPanel();
        lbl_foto_4 = new javax.swing.JLabel();
        lbl_nome_4 = new javax.swing.JLabel();
        lbl_preco_4 = new javax.swing.JLabel();
        btn_remove_4 = new javax.swing.JButton();
        lbl_qtde_4 = new javax.swing.JLabel();
        btn_adiciona_4 = new javax.swing.JButton();
        lbl_obs_4 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        txt_obs_4 = new javax.swing.JTextArea();
        btn_adicionaCarrinho_4 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        txt_descricao_4 = new javax.swing.JTextArea();
        pnl_Item5 = new javax.swing.JPanel();
        lbl_foto_5 = new javax.swing.JLabel();
        lbl_nome_5 = new javax.swing.JLabel();
        lbl_preco_5 = new javax.swing.JLabel();
        btn_remove_5 = new javax.swing.JButton();
        lbl_qtde_5 = new javax.swing.JLabel();
        btn_adiciona_5 = new javax.swing.JButton();
        lbl_obs_5 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        txt_obs_5 = new javax.swing.JTextArea();
        btn_adicionaCarrinho_5 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        txt_descricao_5 = new javax.swing.JTextArea();
        pnl_botoes_superior = new javax.swing.JPanel();
        lbl_EncerrarPedido = new javax.swing.JLabel();
        lbl_FotoCarrinho = new javax.swing.JLabel();
        lbl_Carrinho = new javax.swing.JLabel();
        lbl_Logo = new javax.swing.JLabel();
        pnl_separador1 = new javax.swing.JPanel();
        lbl_NumeroPedido = new javax.swing.JLabel();
        lbl_NumeroDaMesa = new javax.swing.JLabel();
        lbl_NumeroDaMesa1 = new javax.swing.JLabel();
        lbl_NumeroDaMesa2 = new javax.swing.JLabel();
        pnl_separador2 = new javax.swing.JPanel();
        pnl_separador4 = new javax.swing.JPanel();
        pnl_tabela = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtResumo = new javax.swing.JTable();
        btn_confirmarPedido = new javax.swing.JButton();
        pnl_Labels_Id = new javax.swing.JPanel();
        lbl_Id_1 = new javax.swing.JLabel();
        lbl_Id_2 = new javax.swing.JLabel();
        lbl_Id_3 = new javax.swing.JLabel();
        lbl_Id_4 = new javax.swing.JLabel();
        lbl_Id_5 = new javax.swing.JLabel();
        lbl_Id_6 = new javax.swing.JLabel();
        lbl_Id_7 = new javax.swing.JLabel();
        lbl_Id_8 = new javax.swing.JLabel();
        lbl_Id_9 = new javax.swing.JLabel();
        lbl_Id_10 = new javax.swing.JLabel();
        lbl_Id_11 = new javax.swing.JLabel();
        lbl_Id_12 = new javax.swing.JLabel();
        lbl_Id_13 = new javax.swing.JLabel();
        lbl_Id_14 = new javax.swing.JLabel();
        lbl_Id_15 = new javax.swing.JLabel();
        lbl_Id_16 = new javax.swing.JLabel();
        lbl_Id_17 = new javax.swing.JLabel();
        lbl_Id_18 = new javax.swing.JLabel();
        lbl_Id_19 = new javax.swing.JLabel();
        lbl_Id_20 = new javax.swing.JLabel();
        lbl_Id_21 = new javax.swing.JLabel();
        lbl_Id_22 = new javax.swing.JLabel();
        lbl_Id_23 = new javax.swing.JLabel();
        lbl_Id_24 = new javax.swing.JLabel();
        lbl_Id_25 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(202, 126, 40));

        jPanel1.setPreferredSize(new java.awt.Dimension(2100, 857));

        pnl_Categoria.setBackground(new java.awt.Color(176, 50, 39));

        btn_categoria_entradas.setBackground(new java.awt.Color(204, 204, 204));
        btn_categoria_entradas.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        btn_categoria_entradas.setText("Entradas");
        btn_categoria_entradas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_categoria_entradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_categoria_entradasActionPerformed(evt);
            }
        });

        btn_categoria_carnes.setBackground(new java.awt.Color(204, 204, 204));
        btn_categoria_carnes.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        btn_categoria_carnes.setText("Carnes");
        btn_categoria_carnes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_categoria_carnesActionPerformed(evt);
            }
        });

        btn_categoria_frutos.setBackground(new java.awt.Color(204, 204, 204));
        btn_categoria_frutos.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        btn_categoria_frutos.setText("Burguers");
        btn_categoria_frutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_categoria_frutosActionPerformed(evt);
            }
        });

        btn_categoria_bebidas.setBackground(new java.awt.Color(204, 204, 204));
        btn_categoria_bebidas.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        btn_categoria_bebidas.setText("Bebidas");
        btn_categoria_bebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_categoria_bebidasActionPerformed(evt);
            }
        });

        btn_categoria_sobremesas.setBackground(new java.awt.Color(204, 204, 204));
        btn_categoria_sobremesas.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        btn_categoria_sobremesas.setText("Sobremesas");
        btn_categoria_sobremesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_categoria_sobremesasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_CategoriaLayout = new javax.swing.GroupLayout(pnl_Categoria);
        pnl_Categoria.setLayout(pnl_CategoriaLayout);
        pnl_CategoriaLayout.setHorizontalGroup(
            pnl_CategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_CategoriaLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnl_CategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_categoria_sobremesas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_categoria_carnes, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_categoria_entradas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_categoria_frutos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_categoria_bebidas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );
        pnl_CategoriaLayout.setVerticalGroup(
            pnl_CategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_CategoriaLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btn_categoria_entradas, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btn_categoria_carnes, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btn_categoria_frutos, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btn_categoria_bebidas, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btn_categoria_sobremesas, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        jScrollPane3.setBackground(new java.awt.Color(102, 255, 204));
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setToolTipText("");
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setAutoscrolls(true);
        jScrollPane3.setPreferredSize(new java.awt.Dimension(1500, 1800));

        pnl_ItensCardapio.setBackground(new java.awt.Color(255, 255, 255));

        pnl_Item1.setBackground(new java.awt.Color(255, 255, 255));
        pnl_Item1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnl_Item1.setPreferredSize(new java.awt.Dimension(1350, 405));

        lbl_nome_1.setFont(new java.awt.Font("Cooper Black", 0, 36)); // NOI18N
        lbl_nome_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nome_1.setText("Bufallo Wings");

        lbl_preco_1.setFont(new java.awt.Font("Cooper Black", 0, 36)); // NOI18N
        lbl_preco_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_preco_1.setText("R$ 000,00");

        btn_remove_1.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        btn_remove_1.setForeground(new java.awt.Color(176, 50, 39));
        btn_remove_1.setText("-");
        btn_remove_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 248, 249)));
        btn_remove_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_remove_1ActionPerformed(evt);
            }
        });

        lbl_qtde_1.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        lbl_qtde_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_qtde_1.setText("0");

        btn_adiciona_1.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        btn_adiciona_1.setForeground(new java.awt.Color(176, 50, 39));
        btn_adiciona_1.setText("+");
        btn_adiciona_1.setBorder(null);
        btn_adiciona_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adiciona_1ActionPerformed(evt);
            }
        });

        lbl_obs_1.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        lbl_obs_1.setText("Observações");

        jScrollPane9.setForeground(new java.awt.Color(246, 242, 217));

        txt_obs_1.setBackground(new java.awt.Color(204, 204, 204));
        txt_obs_1.setColumns(20);
        txt_obs_1.setLineWrap(true);
        txt_obs_1.setRows(5);
        txt_obs_1.setAutoscrolls(false);
        txt_obs_1.setBorder(null);
        jScrollPane9.setViewportView(txt_obs_1);

        btn_adicionaCarrinho_1.setBackground(new java.awt.Color(176, 50, 39));
        btn_adicionaCarrinho_1.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        btn_adicionaCarrinho_1.setForeground(new java.awt.Color(246, 242, 217));
        btn_adicionaCarrinho_1.setText("Adicionar ao carrinho");
        btn_adicionaCarrinho_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adicionaCarrinho_1ActionPerformed(evt);
            }
        });

        txt_descricao_1.setColumns(20);
        txt_descricao_1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        txt_descricao_1.setLineWrap(true);
        txt_descricao_1.setRows(5);
        txt_descricao_1.setBorder(null);
        jScrollPane8.setViewportView(txt_descricao_1);

        javax.swing.GroupLayout pnl_Item1Layout = new javax.swing.GroupLayout(pnl_Item1);
        pnl_Item1.setLayout(pnl_Item1Layout);
        pnl_Item1Layout.setHorizontalGroup(
            pnl_Item1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Item1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lbl_foto_1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_Item1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_obs_1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_nome_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(jScrollPane9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_Item1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbl_preco_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_Item1Layout.createSequentialGroup()
                        .addComponent(btn_remove_1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_qtde_1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_adiciona_1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_adicionaCarrinho_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_Item1Layout.setVerticalGroup(
            pnl_Item1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Item1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnl_Item1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nome_1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_preco_1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnl_Item1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_Item1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(pnl_Item1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_qtde_1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_remove_1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_adiciona_1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnl_Item1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_Item1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnl_Item1Layout.createSequentialGroup()
                        .addComponent(lbl_obs_1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_adicionaCarrinho_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
            .addComponent(lbl_foto_1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        );

        pnl_Item2.setBackground(new java.awt.Color(255, 255, 255));
        pnl_Item2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnl_Item2.setPreferredSize(new java.awt.Dimension(1350, 405));

        lbl_nome_2.setFont(new java.awt.Font("Cooper Black", 0, 36)); // NOI18N
        lbl_nome_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nome_2.setText("Bufallo Wings");

        lbl_preco_2.setFont(new java.awt.Font("Cooper Black", 0, 36)); // NOI18N
        lbl_preco_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_preco_2.setText("R$ 000,00");

        btn_remove_2.setBackground(new java.awt.Color(244, 248, 249));
        btn_remove_2.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        btn_remove_2.setForeground(new java.awt.Color(176, 50, 39));
        btn_remove_2.setText("-");
        btn_remove_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_remove_2ActionPerformed(evt);
            }
        });

        lbl_qtde_2.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        lbl_qtde_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_qtde_2.setText("0");

        btn_adiciona_2.setBackground(new java.awt.Color(244, 248, 249));
        btn_adiciona_2.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        btn_adiciona_2.setForeground(new java.awt.Color(176, 50, 39));
        btn_adiciona_2.setText("+");
        btn_adiciona_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adiciona_2ActionPerformed(evt);
            }
        });

        lbl_obs_2.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        lbl_obs_2.setText("Observações");

        jScrollPane11.setForeground(new java.awt.Color(246, 242, 217));

        txt_obs_2.setBackground(new java.awt.Color(204, 204, 204));
        txt_obs_2.setColumns(20);
        txt_obs_2.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        txt_obs_2.setLineWrap(true);
        txt_obs_2.setRows(5);
        jScrollPane11.setViewportView(txt_obs_2);

        btn_adicionaCarrinho_2.setBackground(new java.awt.Color(176, 50, 39));
        btn_adicionaCarrinho_2.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        btn_adicionaCarrinho_2.setForeground(new java.awt.Color(246, 242, 217));
        btn_adicionaCarrinho_2.setText("Adicionar ao carrinho");
        btn_adicionaCarrinho_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adicionaCarrinho_2ActionPerformed(evt);
            }
        });

        txt_descricao_2.setColumns(20);
        txt_descricao_2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        txt_descricao_2.setLineWrap(true);
        txt_descricao_2.setRows(5);
        txt_descricao_2.setBorder(null);
        jScrollPane4.setViewportView(txt_descricao_2);

        javax.swing.GroupLayout pnl_Item2Layout = new javax.swing.GroupLayout(pnl_Item2);
        pnl_Item2.setLayout(pnl_Item2Layout);
        pnl_Item2Layout.setHorizontalGroup(
            pnl_Item2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Item2Layout.createSequentialGroup()
                .addComponent(lbl_foto_2, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(pnl_Item2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_obs_2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_nome_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_Item2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbl_preco_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_Item2Layout.createSequentialGroup()
                        .addComponent(btn_remove_2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_qtde_2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_adiciona_2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_adicionaCarrinho_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_Item2Layout.setVerticalGroup(
            pnl_Item2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Item2Layout.createSequentialGroup()
                .addGroup(pnl_Item2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_Item2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(pnl_Item2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_nome_2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_preco_2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnl_Item2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_Item2Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(pnl_Item2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_qtde_2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_remove_2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_adiciona_2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_Item2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(pnl_Item2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnl_Item2Layout.createSequentialGroup()
                                .addComponent(lbl_obs_2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_adicionaCarrinho_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(lbl_foto_2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_Item3.setBackground(new java.awt.Color(244, 248, 249));
        pnl_Item3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnl_Item3.setPreferredSize(new java.awt.Dimension(1350, 405));

        lbl_nome_3.setFont(new java.awt.Font("Cooper Black", 0, 36)); // NOI18N
        lbl_nome_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nome_3.setText("Bufallo Wings");

        lbl_preco_3.setFont(new java.awt.Font("Cooper Black", 0, 36)); // NOI18N
        lbl_preco_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_preco_3.setText("R$ 000,00");

        lbl_qtde_3.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        lbl_qtde_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_qtde_3.setText("0");

        btn_remove_3.setBackground(new java.awt.Color(176, 50, 39));
        btn_remove_3.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        btn_remove_3.setForeground(new java.awt.Color(246, 242, 217));
        btn_remove_3.setText("-");
        btn_remove_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_remove_3ActionPerformed(evt);
            }
        });

        btn_adiciona_3.setBackground(new java.awt.Color(102, 153, 0));
        btn_adiciona_3.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        btn_adiciona_3.setForeground(new java.awt.Color(246, 242, 217));
        btn_adiciona_3.setText("+");
        btn_adiciona_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adiciona_3ActionPerformed(evt);
            }
        });

        lbl_obs_3.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        lbl_obs_3.setText("Observações");

        jScrollPane15.setForeground(new java.awt.Color(246, 242, 217));

        txt_obs_3.setBackground(new java.awt.Color(204, 204, 204));
        txt_obs_3.setColumns(20);
        txt_obs_3.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        txt_obs_3.setLineWrap(true);
        txt_obs_3.setRows(5);
        txt_obs_3.setBorder(null);
        jScrollPane15.setViewportView(txt_obs_3);

        btn_adicionaCarrinho_3.setBackground(new java.awt.Color(176, 50, 39));
        btn_adicionaCarrinho_3.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        btn_adicionaCarrinho_3.setForeground(new java.awt.Color(246, 242, 217));
        btn_adicionaCarrinho_3.setText("Adicionar ao carrinho");
        btn_adicionaCarrinho_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adicionaCarrinho_3ActionPerformed(evt);
            }
        });

        txt_descricao_3.setColumns(20);
        txt_descricao_3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        txt_descricao_3.setLineWrap(true);
        txt_descricao_3.setRows(5);
        txt_descricao_3.setAutoscrolls(false);
        txt_descricao_3.setBorder(null);
        jScrollPane5.setViewportView(txt_descricao_3);

        javax.swing.GroupLayout pnl_Item3Layout = new javax.swing.GroupLayout(pnl_Item3);
        pnl_Item3.setLayout(pnl_Item3Layout);
        pnl_Item3Layout.setHorizontalGroup(
            pnl_Item3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Item3Layout.createSequentialGroup()
                .addComponent(lbl_foto_3, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(pnl_Item3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_obs_3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(lbl_nome_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_Item3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbl_preco_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_Item3Layout.createSequentialGroup()
                        .addComponent(btn_remove_3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_qtde_3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_adiciona_3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_adicionaCarrinho_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_Item3Layout.setVerticalGroup(
            pnl_Item3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Item3Layout.createSequentialGroup()
                .addGroup(pnl_Item3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_Item3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(pnl_Item3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_nome_3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_preco_3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnl_Item3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_Item3Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(pnl_Item3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_qtde_3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_remove_3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_adiciona_3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnl_Item3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_Item3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnl_Item3Layout.createSequentialGroup()
                                .addComponent(lbl_obs_3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_adicionaCarrinho_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(lbl_foto_3, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_Item4.setBackground(new java.awt.Color(244, 248, 249));
        pnl_Item4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnl_Item4.setPreferredSize(new java.awt.Dimension(1350, 405));

        lbl_nome_4.setFont(new java.awt.Font("Cooper Black", 0, 36)); // NOI18N
        lbl_nome_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nome_4.setText("Bufallo Wings");

        lbl_preco_4.setFont(new java.awt.Font("Cooper Black", 0, 36)); // NOI18N
        lbl_preco_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_preco_4.setText("R$ 000,00");

        btn_remove_4.setBackground(new java.awt.Color(176, 50, 39));
        btn_remove_4.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        btn_remove_4.setForeground(new java.awt.Color(246, 242, 217));
        btn_remove_4.setText("-");
        btn_remove_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_remove_4ActionPerformed(evt);
            }
        });

        lbl_qtde_4.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        lbl_qtde_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_qtde_4.setText("0");

        btn_adiciona_4.setBackground(new java.awt.Color(102, 153, 0));
        btn_adiciona_4.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        btn_adiciona_4.setForeground(new java.awt.Color(246, 242, 217));
        btn_adiciona_4.setText("+");
        btn_adiciona_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adiciona_4ActionPerformed(evt);
            }
        });

        lbl_obs_4.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        lbl_obs_4.setText("Observações");

        jScrollPane16.setForeground(new java.awt.Color(246, 242, 217));

        txt_obs_4.setBackground(new java.awt.Color(204, 204, 204));
        txt_obs_4.setColumns(20);
        txt_obs_4.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        txt_obs_4.setLineWrap(true);
        txt_obs_4.setRows(5);
        txt_obs_4.setAutoscrolls(false);
        txt_obs_4.setBorder(null);
        jScrollPane16.setViewportView(txt_obs_4);

        btn_adicionaCarrinho_4.setBackground(new java.awt.Color(234, 106, 64));
        btn_adicionaCarrinho_4.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        btn_adicionaCarrinho_4.setForeground(new java.awt.Color(246, 242, 217));
        btn_adicionaCarrinho_4.setText("Adicionar ao carrinho");
        btn_adicionaCarrinho_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adicionaCarrinho_4ActionPerformed(evt);
            }
        });

        txt_descricao_4.setColumns(20);
        txt_descricao_4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        txt_descricao_4.setLineWrap(true);
        txt_descricao_4.setRows(5);
        txt_descricao_4.setBorder(null);
        jScrollPane6.setViewportView(txt_descricao_4);

        javax.swing.GroupLayout pnl_Item4Layout = new javax.swing.GroupLayout(pnl_Item4);
        pnl_Item4.setLayout(pnl_Item4Layout);
        pnl_Item4Layout.setHorizontalGroup(
            pnl_Item4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Item4Layout.createSequentialGroup()
                .addComponent(lbl_foto_4, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(pnl_Item4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_obs_4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(lbl_nome_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_Item4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbl_preco_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_Item4Layout.createSequentialGroup()
                        .addComponent(btn_remove_4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_qtde_4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_adiciona_4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_adicionaCarrinho_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_Item4Layout.setVerticalGroup(
            pnl_Item4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Item4Layout.createSequentialGroup()
                .addGroup(pnl_Item4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_Item4Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(pnl_Item4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_nome_4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_preco_4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnl_Item4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_Item4Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(pnl_Item4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_qtde_4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_remove_4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_adiciona_4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_Item4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(pnl_Item4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnl_Item4Layout.createSequentialGroup()
                                .addComponent(lbl_obs_4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_adicionaCarrinho_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(lbl_foto_4, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_Item5.setBackground(new java.awt.Color(244, 248, 249));
        pnl_Item5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnl_Item5.setPreferredSize(new java.awt.Dimension(1350, 405));

        lbl_nome_5.setFont(new java.awt.Font("Cooper Black", 0, 36)); // NOI18N
        lbl_nome_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nome_5.setText("Bufallo Wings");

        lbl_preco_5.setFont(new java.awt.Font("Cooper Black", 0, 36)); // NOI18N
        lbl_preco_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_preco_5.setText("R$ 000,00");

        btn_remove_5.setBackground(new java.awt.Color(176, 50, 39));
        btn_remove_5.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        btn_remove_5.setForeground(new java.awt.Color(246, 242, 217));
        btn_remove_5.setText("-");
        btn_remove_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_remove_5ActionPerformed(evt);
            }
        });

        lbl_qtde_5.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        lbl_qtde_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_qtde_5.setText("0");

        btn_adiciona_5.setBackground(new java.awt.Color(102, 153, 0));
        btn_adiciona_5.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        btn_adiciona_5.setForeground(new java.awt.Color(246, 242, 217));
        btn_adiciona_5.setText("+");
        btn_adiciona_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adiciona_5ActionPerformed(evt);
            }
        });

        lbl_obs_5.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        lbl_obs_5.setText("Observações");

        jScrollPane17.setForeground(new java.awt.Color(246, 242, 217));

        txt_obs_5.setBackground(new java.awt.Color(204, 204, 204));
        txt_obs_5.setColumns(20);
        txt_obs_5.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        txt_obs_5.setLineWrap(true);
        txt_obs_5.setRows(5);
        txt_obs_5.setAutoscrolls(false);
        txt_obs_5.setBorder(null);
        jScrollPane17.setViewportView(txt_obs_5);

        btn_adicionaCarrinho_5.setBackground(new java.awt.Color(234, 106, 64));
        btn_adicionaCarrinho_5.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        btn_adicionaCarrinho_5.setForeground(new java.awt.Color(246, 242, 217));
        btn_adicionaCarrinho_5.setText("Adicionar ao carrinho");
        btn_adicionaCarrinho_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adicionaCarrinho_5ActionPerformed(evt);
            }
        });

        txt_descricao_5.setColumns(20);
        txt_descricao_5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        txt_descricao_5.setLineWrap(true);
        txt_descricao_5.setRows(5);
        txt_descricao_5.setBorder(null);
        jScrollPane7.setViewportView(txt_descricao_5);

        javax.swing.GroupLayout pnl_Item5Layout = new javax.swing.GroupLayout(pnl_Item5);
        pnl_Item5.setLayout(pnl_Item5Layout);
        pnl_Item5Layout.setHorizontalGroup(
            pnl_Item5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Item5Layout.createSequentialGroup()
                .addComponent(lbl_foto_5, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(pnl_Item5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_obs_5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(lbl_nome_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_Item5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbl_preco_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_Item5Layout.createSequentialGroup()
                        .addComponent(btn_remove_5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_qtde_5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_adiciona_5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_adicionaCarrinho_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_Item5Layout.setVerticalGroup(
            pnl_Item5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Item5Layout.createSequentialGroup()
                .addGroup(pnl_Item5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_Item5Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(pnl_Item5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_nome_5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_preco_5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnl_Item5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_Item5Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(pnl_Item5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_qtde_5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_remove_5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_adiciona_5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnl_Item5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_Item5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnl_Item5Layout.createSequentialGroup()
                                .addComponent(lbl_obs_5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_adicionaCarrinho_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(lbl_foto_5, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_ItensCardapioLayout = new javax.swing.GroupLayout(pnl_ItensCardapio);
        pnl_ItensCardapio.setLayout(pnl_ItensCardapioLayout);
        pnl_ItensCardapioLayout.setHorizontalGroup(
            pnl_ItensCardapioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ItensCardapioLayout.createSequentialGroup()
                .addGroup(pnl_ItensCardapioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_Item1, javax.swing.GroupLayout.PREFERRED_SIZE, 1225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_Item2, javax.swing.GroupLayout.PREFERRED_SIZE, 1225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_Item3, javax.swing.GroupLayout.PREFERRED_SIZE, 1225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_Item4, javax.swing.GroupLayout.PREFERRED_SIZE, 1225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_Item5, javax.swing.GroupLayout.PREFERRED_SIZE, 1225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        pnl_ItensCardapioLayout.setVerticalGroup(
            pnl_ItensCardapioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ItensCardapioLayout.createSequentialGroup()
                .addComponent(pnl_Item1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_Item2, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_Item3, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_Item4, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_Item5, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane3.setViewportView(pnl_ItensCardapio);

        pnl_botoes_superior.setBackground(new java.awt.Color(176, 50, 39));

        lbl_EncerrarPedido.setBackground(new java.awt.Color(255, 102, 51));
        lbl_EncerrarPedido.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        lbl_EncerrarPedido.setForeground(new java.awt.Color(246, 242, 217));
        lbl_EncerrarPedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_EncerrarPedido.setText("<html> <html> <body> <h><div style=\"text-align:center\"> Encerrar Pedido</h> </body> </html>");
        lbl_EncerrarPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_EncerrarPedidoMouseReleased(evt);
            }
        });

        lbl_FotoCarrinho.setBackground(new java.awt.Color(255, 102, 51));
        lbl_FotoCarrinho.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        lbl_FotoCarrinho.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_FotoCarrinho.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\CarrinhoPreto.png"));
        lbl_FotoCarrinho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_FotoCarrinhoMouseReleased(evt);
            }
        });

        lbl_Carrinho.setBackground(new java.awt.Color(255, 102, 51));
        lbl_Carrinho.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        lbl_Carrinho.setForeground(new java.awt.Color(246, 242, 217));
        lbl_Carrinho.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Carrinho.setText("Carrinho");
        lbl_Carrinho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_CarrinhoMouseReleased(evt);
            }
        });

        lbl_Logo.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\LogoMundo.png"));

        pnl_separador1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_separador1Layout = new javax.swing.GroupLayout(pnl_separador1);
        pnl_separador1.setLayout(pnl_separador1Layout);
        pnl_separador1Layout.setHorizontalGroup(
            pnl_separador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );
        pnl_separador1Layout.setVerticalGroup(
            pnl_separador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lbl_NumeroPedido.setBackground(new java.awt.Color(255, 102, 51));
        lbl_NumeroPedido.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        lbl_NumeroPedido.setForeground(new java.awt.Color(246, 242, 217));
        lbl_NumeroPedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_NumeroPedido.setText("Pedido");

        lbl_NumeroDaMesa.setBackground(new java.awt.Color(255, 102, 51));
        lbl_NumeroDaMesa.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        lbl_NumeroDaMesa.setForeground(new java.awt.Color(246, 242, 217));
        lbl_NumeroDaMesa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_NumeroDaMesa.setText("foto");

        lbl_NumeroDaMesa1.setBackground(new java.awt.Color(255, 102, 51));
        lbl_NumeroDaMesa1.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        lbl_NumeroDaMesa1.setForeground(new java.awt.Color(246, 242, 217));
        lbl_NumeroDaMesa1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_NumeroDaMesa1.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\mesa.png"));

        lbl_NumeroDaMesa2.setBackground(new java.awt.Color(255, 102, 51));
        lbl_NumeroDaMesa2.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        lbl_NumeroDaMesa2.setForeground(new java.awt.Color(246, 242, 217));
        lbl_NumeroDaMesa2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_NumeroDaMesa2.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\pedido.png"));

        pnl_separador2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_separador2Layout = new javax.swing.GroupLayout(pnl_separador2);
        pnl_separador2.setLayout(pnl_separador2Layout);
        pnl_separador2Layout.setHorizontalGroup(
            pnl_separador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pnl_separador2Layout.setVerticalGroup(
            pnl_separador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnl_separador4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_separador4Layout = new javax.swing.GroupLayout(pnl_separador4);
        pnl_separador4.setLayout(pnl_separador4Layout);
        pnl_separador4Layout.setHorizontalGroup(
            pnl_separador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );
        pnl_separador4Layout.setVerticalGroup(
            pnl_separador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnl_botoes_superiorLayout = new javax.swing.GroupLayout(pnl_botoes_superior);
        pnl_botoes_superior.setLayout(pnl_botoes_superiorLayout);
        pnl_botoes_superiorLayout.setHorizontalGroup(
            pnl_botoes_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_botoes_superiorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_separador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(lbl_NumeroDaMesa2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbl_NumeroPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150)
                .addComponent(lbl_NumeroDaMesa1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbl_NumeroDaMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(pnl_separador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_FotoCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbl_Carrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnl_separador4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbl_EncerrarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnl_botoes_superiorLayout.setVerticalGroup(
            pnl_botoes_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_botoes_superiorLayout.createSequentialGroup()
                .addGroup(pnl_botoes_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_botoes_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(pnl_separador1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnl_separador2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_FotoCarrinho, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_botoes_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_NumeroPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_NumeroDaMesa2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lbl_Carrinho, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_EncerrarPedido, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnl_separador4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_Logo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lbl_NumeroDaMesa1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_NumeroDaMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_tabela.setBackground(new java.awt.Color(255, 255, 255));
        pnl_tabela.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setBackground(new java.awt.Color(0, 102, 0));
        jLabel1.setFont(new java.awt.Font("Cooper Black", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Resumo do Pedido");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jtResumo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Preço", "Qtde", "Subtotal", "Obs"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtResumo);

        btn_confirmarPedido.setBackground(new java.awt.Color(102, 153, 0));
        btn_confirmarPedido.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        btn_confirmarPedido.setText("Enviar Pedido");
        btn_confirmarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confirmarPedidoActionPerformed(evt);
            }
        });

        pnl_Labels_Id.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_1.setText("1");
        lbl_Id_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_Id_1.setPreferredSize(new java.awt.Dimension(14, 18));

        lbl_Id_2.setText("2");
        lbl_Id_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_3.setText("3");
        lbl_Id_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_4.setText("4");
        lbl_Id_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_5.setText("5");
        lbl_Id_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_6.setText("6");
        lbl_Id_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_7.setText("7");
        lbl_Id_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_8.setText("8");
        lbl_Id_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_9.setText("9");
        lbl_Id_9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_10.setText("10");
        lbl_Id_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_11.setText("11");
        lbl_Id_11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_12.setText("12");
        lbl_Id_12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_13.setText("13");
        lbl_Id_13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_14.setText("14");
        lbl_Id_14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_15.setText("15");
        lbl_Id_15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_16.setText("16");
        lbl_Id_16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_17.setText("17");
        lbl_Id_17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_18.setText("18");
        lbl_Id_18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_19.setText("19");
        lbl_Id_19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_20.setText("20");
        lbl_Id_20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_21.setText("21");
        lbl_Id_21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_22.setText("22");
        lbl_Id_22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_23.setText("23");
        lbl_Id_23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_24.setText("24");
        lbl_Id_24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_25.setText("25");
        lbl_Id_25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnl_Labels_IdLayout = new javax.swing.GroupLayout(pnl_Labels_Id);
        pnl_Labels_Id.setLayout(pnl_Labels_IdLayout);
        pnl_Labels_IdLayout.setHorizontalGroup(
            pnl_Labels_IdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Labels_IdLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnl_Labels_IdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_Labels_IdLayout.createSequentialGroup()
                        .addGroup(pnl_Labels_IdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnl_Labels_IdLayout.createSequentialGroup()
                                .addComponent(lbl_Id_21, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_Id_22, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_Labels_IdLayout.createSequentialGroup()
                                .addComponent(lbl_Id_16, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_Id_17, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(pnl_Labels_IdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_Labels_IdLayout.createSequentialGroup()
                                .addComponent(lbl_Id_18, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_Id_19, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_Id_20, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnl_Labels_IdLayout.createSequentialGroup()
                                .addComponent(lbl_Id_23, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_Id_24, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_Id_25, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(pnl_Labels_IdLayout.createSequentialGroup()
                        .addGroup(pnl_Labels_IdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_Labels_IdLayout.createSequentialGroup()
                                .addComponent(lbl_Id_11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_Id_12, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_Id_13, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_Id_14, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_Id_15, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnl_Labels_IdLayout.createSequentialGroup()
                                .addComponent(lbl_Id_6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_Id_7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_Id_8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_Id_9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_Id_10)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnl_Labels_IdLayout.createSequentialGroup()
                        .addComponent(lbl_Id_1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_Id_2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_Id_3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_Id_4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_Id_5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        pnl_Labels_IdLayout.setVerticalGroup(
            pnl_Labels_IdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Labels_IdLayout.createSequentialGroup()
                .addGroup(pnl_Labels_IdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Id_1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_Labels_IdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Id_6, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_7, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_8, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_9, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_10, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_Labels_IdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Id_11, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_12, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_13, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_14, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_15, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_Labels_IdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Id_16, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_17, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_18, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_19, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_20, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_Labels_IdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Id_21, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_22, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_23, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_24, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_25, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_tabelaLayout = new javax.swing.GroupLayout(pnl_tabela);
        pnl_tabela.setLayout(pnl_tabelaLayout);
        pnl_tabelaLayout.setHorizontalGroup(
            pnl_tabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_tabelaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnl_Labels_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_confirmarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
            .addGroup(pnl_tabelaLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_tabelaLayout.setVerticalGroup(
            pnl_tabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tabelaLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnl_tabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_tabelaLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(btn_confirmarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_tabelaLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(pnl_Labels_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnl_botoes_superior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pnl_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(pnl_tabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(182, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnl_botoes_superior, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_Categoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(pnl_tabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1992, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 889, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(2006, 896));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_categoria_carnesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_categoria_carnesActionPerformed
        try {
            setCat(lblId, 2);
            setPorCat(lblNomes, txtDescricoes, lblPrecos, lblId);
            setFotos(2);
            limparQtde();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_categoria_carnesActionPerformed

    private void btn_categoria_entradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_categoria_entradasActionPerformed
        try {
            setCat(lblId, 1);
            setPorCat(lblNomes, txtDescricoes, lblPrecos, lblId);
            setFotos(1);
            limparQtde();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_categoria_entradasActionPerformed

    private void btn_categoria_sobremesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_categoria_sobremesasActionPerformed
        // TODO add your handling code here:
        try {
            setCat(lblId, 5);
            setPorCat(lblNomes, txtDescricoes, lblPrecos, lblId);
            setFotos(5);
            limparQtde();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_categoria_sobremesasActionPerformed

    private void btn_categoria_frutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_categoria_frutosActionPerformed
        // TODO add your handling code here:
        try {
            setCat(lblId, 3);
            setPorCat(lblNomes, txtDescricoes, lblPrecos, lblId);
            setFotos(3);
            limparQtde();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_categoria_frutosActionPerformed

    private void btn_categoria_bebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_categoria_bebidasActionPerformed
        // TODO add your handling code here:
        try {
            setCat(lblId, 4);
            setPorCat(lblNomes, txtDescricoes, lblPrecos, lblId);
            setFotos(4);
            limparQtde();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_categoria_bebidasActionPerformed

    private void btn_remove_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_remove_1ActionPerformed
        // TODO add your handling code here:
        removeQtde(lbl_qtde_1);
    }//GEN-LAST:event_btn_remove_1ActionPerformed

    private void btn_adicionaCarrinho_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adicionaCarrinho_1ActionPerformed
        // TODO add your handling code here:
        adicionaNoPreCarrinho(lbl_qtde_1, lbl_Id_1, txt_obs_1);
    }//GEN-LAST:event_btn_adicionaCarrinho_1ActionPerformed

    private void btn_adiciona_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adiciona_1ActionPerformed
        // TODO add your handling code here:
        adicionaQtde(lbl_qtde_1);
    }//GEN-LAST:event_btn_adiciona_1ActionPerformed

    private void btn_remove_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_remove_2ActionPerformed
        // TODO add your handling code here:
        removeQtde(lbl_qtde_2);
    }//GEN-LAST:event_btn_remove_2ActionPerformed

    private void btn_adiciona_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adiciona_2ActionPerformed
        // TODO add your handling code here:
        adicionaQtde(lbl_qtde_2);
    }//GEN-LAST:event_btn_adiciona_2ActionPerformed

    private void btn_adicionaCarrinho_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adicionaCarrinho_2ActionPerformed
        // TODO add your handling code here:
        adicionaNoPreCarrinho(lbl_qtde_2, lbl_Id_2, txt_obs_2);
    }//GEN-LAST:event_btn_adicionaCarrinho_2ActionPerformed

    private void btn_remove_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_remove_3ActionPerformed
        // TODO add your handling code here:
        removeQtde(lbl_qtde_3);
    }//GEN-LAST:event_btn_remove_3ActionPerformed

    private void btn_adiciona_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adiciona_3ActionPerformed
        // TODO add your handling code here:
        adicionaQtde(lbl_qtde_3);
    }//GEN-LAST:event_btn_adiciona_3ActionPerformed

    private void btn_adicionaCarrinho_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adicionaCarrinho_3ActionPerformed
        // TODO add your handling code here:
        adicionaNoPreCarrinho(lbl_qtde_3, lbl_Id_3, txt_obs_3);
    }//GEN-LAST:event_btn_adicionaCarrinho_3ActionPerformed

    private void btn_remove_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_remove_4ActionPerformed
        // TODO add your handling code here:
        removeQtde(lbl_qtde_4);
    }//GEN-LAST:event_btn_remove_4ActionPerformed

    private void btn_adiciona_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adiciona_4ActionPerformed
        // TODO add your handling code here:
        adicionaQtde(lbl_qtde_4);
    }//GEN-LAST:event_btn_adiciona_4ActionPerformed

    private void btn_adicionaCarrinho_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adicionaCarrinho_4ActionPerformed
        // TODO add your handling code here:
        adicionaNoPreCarrinho(lbl_qtde_4, lbl_Id_4, txt_obs_4);
    }//GEN-LAST:event_btn_adicionaCarrinho_4ActionPerformed

    private void btn_remove_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_remove_5ActionPerformed
        // TODO add your handling code here:
        removeQtde(lbl_qtde_5);
    }//GEN-LAST:event_btn_remove_5ActionPerformed

    private void btn_adiciona_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adiciona_5ActionPerformed
        // TODO add your handling code here:
        adicionaQtde(lbl_qtde_5);
    }//GEN-LAST:event_btn_adiciona_5ActionPerformed

    private void btn_adicionaCarrinho_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adicionaCarrinho_5ActionPerformed
        // TODO add your handling code here:
        adicionaNoPreCarrinho(lbl_qtde_5, lbl_Id_5, txt_obs_5);
    }//GEN-LAST:event_btn_adicionaCarrinho_5ActionPerformed

    private void btn_confirmarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confirmarPedidoActionPerformed
        // TODO add your handling code here:

        int numeroDeItensNaComanda = jtResumo.getRowCount();
        Item itensNaComanda[] = new Item[numeroDeItensNaComanda];

        for (int i = 0; i < itensNaComanda.length; i++) {
            itensNaComanda[i] = new Item();
            itensNaComanda[i].getPedido().setIdPedido(numeroPedido);
            itensNaComanda[i].getProduto().setIdProduto(Integer.parseInt(jtResumo.getValueAt(i, 0).toString()));
            itensNaComanda[i].setQtde(Integer.parseInt(jtResumo.getValueAt(i, 3).toString()));
            itensNaComanda[i].setSubtotal(Double.parseDouble(jtResumo.getValueAt(i, 4).toString()));
            itensNaComanda[i].setObservacao((jtResumo.getValueAt(i, 5).toString()));
        }

        int confirma = JOptionPane.showConfirmDialog(
                this,
                "Deseja confirmar o pedido?",
                "CONFIRMAR PEDIDO",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (confirma == JOptionPane.YES_OPTION) {
            ItemDao itemDao = new ItemDao();
            for (Item item : itensNaComanda) {
                try {
                    itemDao.adicionaItens(item);
                    limparQtde();
                    limparTabela();
                    calculaTotal();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                }
            }
        } else if (confirma == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Pedido não enviado!");
        } else {
            JOptionPane.showMessageDialog(null, "Operação cancelada.");
        }
    }//GEN-LAST:event_btn_confirmarPedidoActionPerformed

    private void lbl_CarrinhoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_CarrinhoMouseReleased

        try {
            Tela_ResumoPedido telaResumo = new Tela_ResumoPedido(numeroPedido, numeroMesa, this);
            telaResumo.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }


    }//GEN-LAST:event_lbl_CarrinhoMouseReleased

    private void lbl_FotoCarrinhoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_FotoCarrinhoMouseReleased
        // TODO add your handling code here:
        try {
            Tela_ResumoPedido telaResumo = new Tela_ResumoPedido(numeroPedido, numeroMesa, this);
            telaResumo.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_lbl_FotoCarrinhoMouseReleased

    private void lbl_EncerrarPedidoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_EncerrarPedidoMouseReleased

        int confirma = JOptionPane.showConfirmDialog(
                this,
                "Deseja encerrar o pedido?",
                "ENCERRAR PEDIDO",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        if (confirma == JOptionPane.YES_OPTION) {
            try {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(numeroPedido);
                pedido.setStatus("Encerrado");
                PedidoDao pedidoDao = new PedidoDao();
                pedidoDao.atualizaPedido(pedido);
                JOptionPane.showMessageDialog(null, "Pedido encerrado, um atendente levará a conta até voce"); //arrumar acentuacao
                this.dispose();

                int novoPedido = JOptionPane.showConfirmDialog(
                        this,
                        "Deseja criar um novo pedido?",
                        "Novo pedido",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );
                if (novoPedido == JOptionPane.YES_OPTION) {

                    // enviar para a nova tela de ver menu e abir pedido, msm assim essa ta com erro.
                    pedido.getMesa().setIdMesa(numeroMesa);
                    pedidoDao.adicionarPedido(pedido);
                    new Tela_Menu(pedidoDao.numeroPedido, numeroMesa).setVisible(true);
                } else {
                    this.dispose();
                    new Tela_Login().setVisible(true);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_lbl_EncerrarPedidoMouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JPanel comanda = new JPanel();
        TextArea textoComanda = new TextArea();
        textoComanda.setSize(400, 1800);
        comanda.add(textoComanda);
        Comanda test = new Comanda();
        String texto = ("\t\tPré-Conta\n\n");
        texto += "----------------------------------------------------------------------------------------------------------\n";
        texto += "Número do pedido: " + numeroPedido + "\n";
        texto += "Número da mesa: " + numeroMesa + "\n";
        texto += "----------------------------------------------------------------------------------------------------------\n";
        texto += "Nome\t\tPreco\tQtde\tSubtotal\n";
        texto += "----------------------------------------------------------------------------------------------------------\n";

        RelatorioDao relatorioDao = new RelatorioDao();
        DecimalFormat df = new DecimalFormat("R$ 0.00");
        try {
            total = 0.0;
            for (ItemRelatorio itemRelatorio : relatorioDao.listarItensPorPedidoAgrupado(numeroPedido)) {
                //  item = new Item();
                texto += itemRelatorio.getProduto().getNome();
                if (itemRelatorio.getProduto().getNome().length() >= 15) {
                    texto += "\t";
                } else {
                    texto += "\t\t";
                }

                texto += df.format(itemRelatorio.getProduto().getPreco())
                        + "\t   "
                        + itemRelatorio.getQtde()
                        + "\t"
                        + df.format(itemRelatorio.getSubtotal());
                texto += "\n";

                total += itemRelatorio.getSubtotal();

            }

            texto += "----------------------------------------------------------------------------------------------------------\n";
            texto += "Subtotal: " + df.format(total) + "\n";
            texto += "Taxa de serviço (10%): " + df.format(total * 0.1) + "\n";
            texto += "TOTAL: " + df.format(total * 1.1) + "\n";
            texto += "----------------------------------------------------------------------------------------------------------\n";
            test.getComanda().setText(texto);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }

        int opcao = JOptionPane.showConfirmDialog(null, test, "PRE-CONTA", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);


    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Tela_Menu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Menu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Menu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Menu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_adicionaCarrinho_1;
    private javax.swing.JButton btn_adicionaCarrinho_2;
    private javax.swing.JButton btn_adicionaCarrinho_3;
    private javax.swing.JButton btn_adicionaCarrinho_4;
    private javax.swing.JButton btn_adicionaCarrinho_5;
    private javax.swing.JButton btn_adiciona_1;
    private javax.swing.JButton btn_adiciona_2;
    private javax.swing.JButton btn_adiciona_3;
    private javax.swing.JButton btn_adiciona_4;
    private javax.swing.JButton btn_adiciona_5;
    private javax.swing.JButton btn_categoria_bebidas;
    private javax.swing.JButton btn_categoria_carnes;
    private javax.swing.JButton btn_categoria_entradas;
    private javax.swing.JButton btn_categoria_frutos;
    private javax.swing.JButton btn_categoria_sobremesas;
    private javax.swing.JButton btn_confirmarPedido;
    private javax.swing.JButton btn_remove_1;
    private javax.swing.JButton btn_remove_2;
    private javax.swing.JButton btn_remove_3;
    private javax.swing.JButton btn_remove_4;
    private javax.swing.JButton btn_remove_5;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jtResumo;
    private javax.swing.JLabel lbl_Carrinho;
    private javax.swing.JLabel lbl_EncerrarPedido;
    private javax.swing.JLabel lbl_FotoCarrinho;
    private javax.swing.JLabel lbl_Id_1;
    private javax.swing.JLabel lbl_Id_10;
    private javax.swing.JLabel lbl_Id_11;
    private javax.swing.JLabel lbl_Id_12;
    private javax.swing.JLabel lbl_Id_13;
    private javax.swing.JLabel lbl_Id_14;
    private javax.swing.JLabel lbl_Id_15;
    private javax.swing.JLabel lbl_Id_16;
    private javax.swing.JLabel lbl_Id_17;
    private javax.swing.JLabel lbl_Id_18;
    private javax.swing.JLabel lbl_Id_19;
    private javax.swing.JLabel lbl_Id_2;
    private javax.swing.JLabel lbl_Id_20;
    private javax.swing.JLabel lbl_Id_21;
    private javax.swing.JLabel lbl_Id_22;
    private javax.swing.JLabel lbl_Id_23;
    private javax.swing.JLabel lbl_Id_24;
    private javax.swing.JLabel lbl_Id_25;
    private javax.swing.JLabel lbl_Id_3;
    private javax.swing.JLabel lbl_Id_4;
    private javax.swing.JLabel lbl_Id_5;
    private javax.swing.JLabel lbl_Id_6;
    private javax.swing.JLabel lbl_Id_7;
    private javax.swing.JLabel lbl_Id_8;
    private javax.swing.JLabel lbl_Id_9;
    private javax.swing.JLabel lbl_Logo;
    private javax.swing.JLabel lbl_NumeroDaMesa;
    private javax.swing.JLabel lbl_NumeroDaMesa1;
    private javax.swing.JLabel lbl_NumeroDaMesa2;
    private javax.swing.JLabel lbl_NumeroPedido;
    private javax.swing.JLabel lbl_foto_1;
    private javax.swing.JLabel lbl_foto_2;
    private javax.swing.JLabel lbl_foto_3;
    private javax.swing.JLabel lbl_foto_4;
    private javax.swing.JLabel lbl_foto_5;
    private javax.swing.JLabel lbl_nome_1;
    private javax.swing.JLabel lbl_nome_2;
    private javax.swing.JLabel lbl_nome_3;
    private javax.swing.JLabel lbl_nome_4;
    private javax.swing.JLabel lbl_nome_5;
    private javax.swing.JLabel lbl_obs_1;
    private javax.swing.JLabel lbl_obs_2;
    private javax.swing.JLabel lbl_obs_3;
    private javax.swing.JLabel lbl_obs_4;
    private javax.swing.JLabel lbl_obs_5;
    private javax.swing.JLabel lbl_preco_1;
    private javax.swing.JLabel lbl_preco_2;
    private javax.swing.JLabel lbl_preco_3;
    private javax.swing.JLabel lbl_preco_4;
    private javax.swing.JLabel lbl_preco_5;
    private javax.swing.JLabel lbl_qtde_1;
    private javax.swing.JLabel lbl_qtde_2;
    private javax.swing.JLabel lbl_qtde_3;
    private javax.swing.JLabel lbl_qtde_4;
    private javax.swing.JLabel lbl_qtde_5;
    private javax.swing.JPanel pnl_Categoria;
    private javax.swing.JPanel pnl_Item1;
    private javax.swing.JPanel pnl_Item2;
    private javax.swing.JPanel pnl_Item3;
    private javax.swing.JPanel pnl_Item4;
    private javax.swing.JPanel pnl_Item5;
    private javax.swing.JPanel pnl_ItensCardapio;
    private javax.swing.JPanel pnl_Labels_Id;
    private javax.swing.JPanel pnl_botoes_superior;
    private javax.swing.JPanel pnl_separador1;
    private javax.swing.JPanel pnl_separador2;
    private javax.swing.JPanel pnl_separador4;
    private javax.swing.JPanel pnl_tabela;
    private javax.swing.JTextArea txt_descricao_1;
    private javax.swing.JTextArea txt_descricao_2;
    private javax.swing.JTextArea txt_descricao_3;
    private javax.swing.JTextArea txt_descricao_4;
    private javax.swing.JTextArea txt_descricao_5;
    private javax.swing.JTextArea txt_obs_1;
    private javax.swing.JTextArea txt_obs_2;
    private javax.swing.JTextArea txt_obs_3;
    private javax.swing.JTextArea txt_obs_4;
    private javax.swing.JTextArea txt_obs_5;
    // End of variables declaration//GEN-END:variables
}
