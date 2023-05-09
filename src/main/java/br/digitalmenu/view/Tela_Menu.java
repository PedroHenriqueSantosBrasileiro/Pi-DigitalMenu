package br.digitalmenu.view;

import br.digitalmenu.dao.ItemDao;
import br.digitalmenu.dao.PedidoDao;
import br.digitalmenu.dao.ProdutoDao;
import br.digitalmenu.model.Item;
import br.digitalmenu.model.Pedido;
import br.digitalmenu.model.Produto;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Tela_Menu extends javax.swing.JFrame {

    private double total = 0.0;
    JLabel lblId[] = new JLabel[8];
    JLabel lblNomes[] = new JLabel[8];
    JTextArea txtAreaDescricoes[] = new JTextArea[8];
    JLabel lblPrecos[] = new JLabel[8];
    JLabel lblFotos[] = new JLabel[8];
    JLabel lblQtde[] = new JLabel[8];
    public DecimalFormat decimalFormat = new DecimalFormat("##.00");

    public Tela_Menu() {

    }

    public Tela_Menu(int numeroPedido, int numeroMesa) throws SQLException {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        lbl_NumeroDoPedido.setText(String.valueOf(numeroPedido));
        lbl_NumeroDaMesa.setText(String.valueOf(numeroMesa));
        
        setTodos();
        setCat(lblId, 1);
        setFotos(1);
        setPorCat(lblNomes, txtAreaDescricoes, lblPrecos, lblId);
        pnl_Labels_Id.setVisible(false);

    }

    public void setLblId() {
        lblId[0] = lbl_Id_1;
        lblId[1] = lbl_Id_2;
        lblId[2] = lbl_Id_3;
        lblId[3] = lbl_Id_4;
        lblId[4] = lbl_Id_5;
        lblId[5] = lbl_Id_6;
        lblId[6] = lbl_Id_7;
        lblId[7] = lbl_Id_8;
    }

    public void setLblNomes() {
        lblNomes[0] = lbl_Nome_1;
        lblNomes[1] = lbl_Nome_2;
        lblNomes[2] = lbl_Nome_3;
        lblNomes[3] = lbl_Nome_4;
        lblNomes[4] = lbl_Nome_5;
        lblNomes[5] = lbl_Nome_6;
        lblNomes[6] = lbl_Nome_7;
        lblNomes[7] = lbl_Nome_8;
    }

    public void setTxtAreaDescricoes() {
        txtAreaDescricoes[0] = txtarea_Desc_1;
        txtAreaDescricoes[1] = txtarea_Desc_2;
        txtAreaDescricoes[2] = txtarea_Desc_3;
        txtAreaDescricoes[3] = txtarea_Desc_4;
        txtAreaDescricoes[4] = txtarea_Desc_5;
        txtAreaDescricoes[5] = txtarea_Desc_6;
        txtAreaDescricoes[6] = txtarea_Desc_7;
        txtAreaDescricoes[7] = txtarea_Desc_8;
    }

    public void setLblPrecos() {
        lblPrecos[0] = lbl_Preco_1;
        lblPrecos[1] = lbl_Preco_2;
        lblPrecos[2] = lbl_Preco_3;
        lblPrecos[3] = lbl_Preco_4;
        lblPrecos[4] = lbl_Preco_5;
        lblPrecos[5] = lbl_Preco_6;
        lblPrecos[6] = lbl_Preco_7;
        lblPrecos[7] = lbl_Preco_8;
    }

    public void setLblFotos() {
        lblFotos[0] = lbl_Foto_1;
        lblFotos[1] = lbl_Foto_2;
        lblFotos[2] = lbl_Foto_3;
        lblFotos[3] = lbl_Foto_4;
        lblFotos[4] = lbl_Foto_5;
        lblFotos[5] = lbl_Foto_6;
        lblFotos[6] = lbl_Foto_7;
        lblFotos[7] = lbl_Foto_8;
    }

    public void setLblQtdes() {
        lblQtde[0] = lbl_QtdeItem_1;
        lblQtde[1] = lbl_QtdeItem_2;
        lblQtde[2] = lbl_QtdeItem_3;
        lblQtde[3] = lbl_QtdeItem_4;
        lblQtde[4] = lbl_QtdeItem_5;
        lblQtde[5] = lbl_QtdeItem_6;
        lblQtde[6] = lbl_QtdeItem_7;
        lblQtde[7] = lbl_QtdeItem_8;
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
            lblId[5].setText("6");
            lblId[6].setText("7");
            lblId[7].setText("8");
        } else if (cat == 2) {
            lblId[0].setText("11");
            lblId[1].setText("12");
            lblId[2].setText("13");
            lblId[3].setText("14");
            lblId[4].setText("15");
            lblId[5].setText("16");
            lblId[6].setText("17");
            lblId[7].setText("18");
        }
    }

    public void setPorCat(JLabel[] labelNomes, JTextArea[] txtAreaDescricoes, JLabel[] labelPrecos, JLabel[] labelIDs) throws SQLException {
        ProdutoDao prodDao = new ProdutoDao();
        for (int i = 0; i < labelNomes.length; i++) {
            labelNomes[i].setText(prodDao.listarProdutoPorId(Integer.parseInt(labelIDs[i].getText())).getNome());
            txtAreaDescricoes[i].setText(prodDao.listarProdutoPorId(Integer.parseInt(labelIDs[i].getText())).getDescricao());
            labelPrecos[i].setText(String.valueOf(prodDao.listarProdutoPorId(Integer.parseInt(labelIDs[i].getText())).getPreco()));
        }
    }

    public void setFotos(int cat) {
        if (cat == 1) {
            lbl_Foto_1.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\1.png"));
            lbl_Foto_2.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\2.png"));
            lbl_Foto_3.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\3.png"));
            lbl_Foto_4.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\4.png"));
            lbl_Foto_5.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\5.png"));
            lbl_Foto_6.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\6.png"));
            lbl_Foto_7.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\7.png"));
            lbl_Foto_8.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\8.png"));
        } else if (cat == 2) {
            lbl_Foto_1.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\9.png"));
            lbl_Foto_2.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\10.png"));
            lbl_Foto_3.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\11.png"));
            lbl_Foto_4.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\12.png"));
            lbl_Foto_5.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\13.png"));
            lbl_Foto_6.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\14.png"));
            lbl_Foto_7.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\15.png"));
            lbl_Foto_8.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\16.png"));
        }

    }

    public void calculaTotal() {

        int numDeItens = jtItens.getRowCount();
        for (int i = 0; i < numDeItens; i++) {
            double totalPorItem = Double.valueOf(jtItens.getValueAt(i, 4).toString());
            total += totalPorItem;
        }
        DecimalFormat df = new DecimalFormat(".##");
//        lblTotal.setText(df.format(total));

    }

    public void addPrato(Produto produto, int qtdeLbl, String desc) {

        DefaultTableModel dt = (DefaultTableModel) jtItens.getModel();

        for (int row = 0; row < jtItens.getRowCount(); row++) {
            if (produto.getNome().equalsIgnoreCase(jtItens.getValueAt(row, 1).toString())) {
                dt.removeRow(jtItens.convertRowIndexToModel(row));
            }
        }
        dt.addRow(new Object[]{
            produto.getIdProduto(),
            produto.getNome(),
            qtdeLbl,
            produto.getPreco(),
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

    public void adicionaNoPreCarrinho(JLabel lblQtde, JLabel lblId, JTextField txtObs) {
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
        DefaultTableModel dt = (DefaultTableModel) jtItens.getModel();
        dt.setNumRows(0);

    }

    public void limparQtde() {
        for (int i = 0; i < lblQtde.length; i++) {
            lblQtde[i].setText("0");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_PreCarrinho = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtItens = new javax.swing.JTable();
        btnRemonerLinha = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        pnl_DadosPedido = new javax.swing.JPanel();
        lbl_NumeroDoPedido = new javax.swing.JLabel();
        lbl_NumeroDaMesa = new javax.swing.JLabel();
        lbl_FotoPedido = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pnl_Labels_Id = new javax.swing.JPanel();
        lbl_Id_1 = new javax.swing.JLabel();
        lbl_Id_2 = new javax.swing.JLabel();
        lbl_Id_3 = new javax.swing.JLabel();
        lbl_Id_4 = new javax.swing.JLabel();
        lbl_Id_5 = new javax.swing.JLabel();
        lbl_Id_6 = new javax.swing.JLabel();
        lbl_Id_7 = new javax.swing.JLabel();
        lbl_Id_8 = new javax.swing.JLabel();
        pnl_Categoria = new javax.swing.JPanel();
        btn_Categoria_1 = new javax.swing.JButton();
        btn_Categoria_2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        pnl_Itens = new javax.swing.JPanel();
        pnl_Item_1 = new javax.swing.JPanel();
        lbl_Nome_1 = new javax.swing.JLabel();
        jScroll_Desc_1 = new javax.swing.JScrollPane();
        txtarea_Desc_1 = new javax.swing.JTextArea();
        lbl_Preco_1 = new javax.swing.JLabel();
        lbl_Obs_1 = new javax.swing.JLabel();
        txt_Obs_1 = new javax.swing.JTextField();
        lbl_Foto_1 = new javax.swing.JLabel();
        btn_RemoveQtde_1 = new javax.swing.JButton();
        lbl_QtdeItem_1 = new javax.swing.JLabel();
        btn_AdicionaQtde_1 = new javax.swing.JButton();
        filler_Top_1 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 32767));
        filler_Bot_1 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 32767));
        filler_Mid_1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 200), new java.awt.Dimension(0, 200), new java.awt.Dimension(32767, 200));
        filler_Right_1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 200), new java.awt.Dimension(0, 200), new java.awt.Dimension(32767, 200));
        filler_Left_1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 200), new java.awt.Dimension(0, 200), new java.awt.Dimension(32767, 200));
        pnl_Item_2 = new javax.swing.JPanel();
        lbl_Nome_2 = new javax.swing.JLabel();
        jScroll_Desc_2 = new javax.swing.JScrollPane();
        txtarea_Desc_2 = new javax.swing.JTextArea();
        lbl_Preco_2 = new javax.swing.JLabel();
        lbl_Obs_2 = new javax.swing.JLabel();
        txt_Obs_2 = new javax.swing.JTextField();
        lbl_Foto_2 = new javax.swing.JLabel();
        btn_RemoveQtde_2 = new javax.swing.JButton();
        lbl_QtdeItem_2 = new javax.swing.JLabel();
        btn_AdicionaQtde_2 = new javax.swing.JButton();
        filler_Top_2 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 32767));
        filler_Bot_2 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 32767));
        filler_Mid_2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 200), new java.awt.Dimension(0, 200), new java.awt.Dimension(32767, 200));
        filler_Right_2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 200), new java.awt.Dimension(0, 200), new java.awt.Dimension(32767, 200));
        filler_Left_2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 200), new java.awt.Dimension(0, 200), new java.awt.Dimension(32767, 200));
        pnl_Item_3 = new javax.swing.JPanel();
        lbl_Nome_3 = new javax.swing.JLabel();
        jScroll_Desc_3 = new javax.swing.JScrollPane();
        txtarea_Desc_3 = new javax.swing.JTextArea();
        lbl_Preco_3 = new javax.swing.JLabel();
        lbl_Obs_3 = new javax.swing.JLabel();
        txt_Obs_3 = new javax.swing.JTextField();
        lbl_Foto_3 = new javax.swing.JLabel();
        btn_RemoveQtde_3 = new javax.swing.JButton();
        lbl_QtdeItem_3 = new javax.swing.JLabel();
        btn_AdicionaQtde_3 = new javax.swing.JButton();
        filler_Top_3 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 32767));
        filler_Bot_3 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 32767));
        filler_Mid_3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 200), new java.awt.Dimension(0, 200), new java.awt.Dimension(32767, 200));
        filler_Right_3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 200), new java.awt.Dimension(0, 200), new java.awt.Dimension(32767, 200));
        filler_Left_3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 200), new java.awt.Dimension(0, 200), new java.awt.Dimension(32767, 200));
        pnl_Item_4 = new javax.swing.JPanel();
        lbl_Nome_4 = new javax.swing.JLabel();
        jScroll_Desc_4 = new javax.swing.JScrollPane();
        txtarea_Desc_4 = new javax.swing.JTextArea();
        lbl_Preco_4 = new javax.swing.JLabel();
        lbl_Obs_4 = new javax.swing.JLabel();
        txt_Obs_4 = new javax.swing.JTextField();
        lbl_Foto_4 = new javax.swing.JLabel();
        btn_RemoveQtde_4 = new javax.swing.JButton();
        lbl_QtdeItem_4 = new javax.swing.JLabel();
        btn_AdicionaQtde_4 = new javax.swing.JButton();
        filler_Top_4 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 32767));
        filler_Bot_4 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 32767));
        filler_Mid_4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 200), new java.awt.Dimension(0, 200), new java.awt.Dimension(32767, 200));
        filler_Right_4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 200), new java.awt.Dimension(0, 200), new java.awt.Dimension(32767, 200));
        filler_Left_4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 200), new java.awt.Dimension(0, 200), new java.awt.Dimension(32767, 200));
        pnl_Item_5 = new javax.swing.JPanel();
        lbl_Nome_5 = new javax.swing.JLabel();
        jScroll_Desc_5 = new javax.swing.JScrollPane();
        txtarea_Desc_5 = new javax.swing.JTextArea();
        lbl_Preco_5 = new javax.swing.JLabel();
        lbl_Obs_5 = new javax.swing.JLabel();
        txt_Obs_5 = new javax.swing.JTextField();
        lbl_Foto_5 = new javax.swing.JLabel();
        btn_RemoveQtde_5 = new javax.swing.JButton();
        lbl_QtdeItem_5 = new javax.swing.JLabel();
        btn_AdicionaQtde_5 = new javax.swing.JButton();
        filler_Top_5 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 32767));
        filler_Bot_5 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 32767));
        filler_Mid_5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 200), new java.awt.Dimension(0, 200), new java.awt.Dimension(32767, 200));
        filler_Right_5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 200), new java.awt.Dimension(0, 200), new java.awt.Dimension(32767, 200));
        filler_Left_5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 200), new java.awt.Dimension(0, 200), new java.awt.Dimension(32767, 200));
        pnl_Item_6 = new javax.swing.JPanel();
        lbl_Nome_6 = new javax.swing.JLabel();
        jScroll_Desc_6 = new javax.swing.JScrollPane();
        txtarea_Desc_6 = new javax.swing.JTextArea();
        lbl_Preco_6 = new javax.swing.JLabel();
        lbl_Obs_6 = new javax.swing.JLabel();
        txt_Obs_6 = new javax.swing.JTextField();
        lbl_Foto_6 = new javax.swing.JLabel();
        btn_RemoveQtde_6 = new javax.swing.JButton();
        lbl_QtdeItem_6 = new javax.swing.JLabel();
        btn_AdicionaQtde_6 = new javax.swing.JButton();
        filler_Top_6 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 32767));
        filler_Bot_6 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 32767));
        filler_Mid_6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 200), new java.awt.Dimension(0, 200), new java.awt.Dimension(32767, 200));
        filler_Right_6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 200), new java.awt.Dimension(0, 200), new java.awt.Dimension(32767, 200));
        filler_Left_6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 200), new java.awt.Dimension(0, 200), new java.awt.Dimension(32767, 200));
        pnl_Item_7 = new javax.swing.JPanel();
        lbl_Nome_7 = new javax.swing.JLabel();
        jScroll_Desc_7 = new javax.swing.JScrollPane();
        txtarea_Desc_7 = new javax.swing.JTextArea();
        lbl_Preco_7 = new javax.swing.JLabel();
        lbl_Obs_7 = new javax.swing.JLabel();
        txt_Obs_7 = new javax.swing.JTextField();
        lbl_Foto_7 = new javax.swing.JLabel();
        btn_RemoveQtde_7 = new javax.swing.JButton();
        lbl_QtdeItem_7 = new javax.swing.JLabel();
        btn_AdicionaQtde_7 = new javax.swing.JButton();
        filler_Top_7 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 32767));
        filler_Bot_7 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 32767));
        filler_Mid_7 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 200), new java.awt.Dimension(0, 200), new java.awt.Dimension(32767, 200));
        filler_Right_7 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 200), new java.awt.Dimension(0, 200), new java.awt.Dimension(32767, 200));
        filler_Left_7 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 200), new java.awt.Dimension(0, 200), new java.awt.Dimension(32767, 200));
        pnl_Item_8 = new javax.swing.JPanel();
        lbl_Nome_8 = new javax.swing.JLabel();
        jScroll_Desc_8 = new javax.swing.JScrollPane();
        txtarea_Desc_8 = new javax.swing.JTextArea();
        lbl_Preco_8 = new javax.swing.JLabel();
        lbl_Obs_8 = new javax.swing.JLabel();
        txt_Obs_8 = new javax.swing.JTextField();
        lbl_Foto_8 = new javax.swing.JLabel();
        btn_RemoveQtde_8 = new javax.swing.JButton();
        lbl_QtdeItem_8 = new javax.swing.JLabel();
        btn_AdicionaQtde_8 = new javax.swing.JButton();
        filler_Top_8 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 32767));
        filler_Bot_8 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 32767));
        filler_Mid_8 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 200), new java.awt.Dimension(0, 200), new java.awt.Dimension(32767, 200));
        filler_Right_8 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 200), new java.awt.Dimension(0, 200), new java.awt.Dimension(32767, 200));
        filler_Left_8 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 200), new java.awt.Dimension(0, 200), new java.awt.Dimension(32767, 200));

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        pnl_PreCarrinho.setBackground(new java.awt.Color(153, 153, 153));

        jtItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Qtde", "Preço", "Subtotal", "Observação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtItens);

        btnRemonerLinha.setText("Remover Linha");
        btnRemonerLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemonerLinhaActionPerformed(evt);
            }
        });

        jButton1.setText("Adicionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ver Pedido");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setText("Fechar Pedido");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_PreCarrinhoLayout = new javax.swing.GroupLayout(pnl_PreCarrinho);
        pnl_PreCarrinho.setLayout(pnl_PreCarrinhoLayout);
        pnl_PreCarrinhoLayout.setHorizontalGroup(
            pnl_PreCarrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_PreCarrinhoLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(pnl_PreCarrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_PreCarrinhoLayout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnRemonerLinha))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnl_PreCarrinhoLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnl_PreCarrinhoLayout.setVerticalGroup(
            pnl_PreCarrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_PreCarrinhoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btnRemonerLinha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_PreCarrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_PreCarrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbl_NumeroDoPedido.setBackground(new java.awt.Color(204, 204, 255));
        lbl_NumeroDoPedido.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        lbl_NumeroDoPedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbl_NumeroDaMesa.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        lbl_NumeroDaMesa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbl_FotoPedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_FotoPedido.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\pedido.png"));
        lbl_FotoPedido.setText("foto");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\mesa.png"));
        jLabel1.setText("foto");

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

        javax.swing.GroupLayout pnl_Labels_IdLayout = new javax.swing.GroupLayout(pnl_Labels_Id);
        pnl_Labels_Id.setLayout(pnl_Labels_IdLayout);
        pnl_Labels_IdLayout.setHorizontalGroup(
            pnl_Labels_IdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Labels_IdLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Id_1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbl_Id_2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbl_Id_3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbl_Id_4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbl_Id_5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbl_Id_6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbl_Id_7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_Id_8, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnl_Labels_IdLayout.setVerticalGroup(
            pnl_Labels_IdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Labels_IdLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(pnl_Labels_IdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Id_1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_6, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_7, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_8, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout pnl_DadosPedidoLayout = new javax.swing.GroupLayout(pnl_DadosPedido);
        pnl_DadosPedido.setLayout(pnl_DadosPedidoLayout);
        pnl_DadosPedidoLayout.setHorizontalGroup(
            pnl_DadosPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_DadosPedidoLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(lbl_FotoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnl_DadosPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_DadosPedidoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(pnl_Labels_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_DadosPedidoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_NumeroDoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lbl_NumeroDaMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnl_DadosPedidoLayout.setVerticalGroup(
            pnl_DadosPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_DadosPedidoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnl_DadosPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_NumeroDaMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_NumeroDoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_FotoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnl_Labels_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btn_Categoria_1.setText("PF");
        btn_Categoria_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Categoria_1ActionPerformed(evt);
            }
        });

        btn_Categoria_2.setText("Bebidas");
        btn_Categoria_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Categoria_2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_CategoriaLayout = new javax.swing.GroupLayout(pnl_Categoria);
        pnl_Categoria.setLayout(pnl_CategoriaLayout);
        pnl_CategoriaLayout.setHorizontalGroup(
            pnl_CategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_CategoriaLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(btn_Categoria_1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(btn_Categoria_2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnl_CategoriaLayout.setVerticalGroup(
            pnl_CategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_CategoriaLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnl_CategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Categoria_1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Categoria_2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setToolTipText("");
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        pnl_Item_1.setBackground(new java.awt.Color(51, 51, 51));
        pnl_Item_1.setPreferredSize(new java.awt.Dimension(500, 230));

        lbl_Nome_1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_Nome_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtarea_Desc_1.setEditable(false);
        txtarea_Desc_1.setColumns(20);
        txtarea_Desc_1.setForeground(new java.awt.Color(51, 51, 0));
        txtarea_Desc_1.setLineWrap(true);
        txtarea_Desc_1.setRows(5);
        txtarea_Desc_1.setEnabled(false);
        txtarea_Desc_1.setMaximumSize(new java.awt.Dimension(325, 80));
        txtarea_Desc_1.setMinimumSize(new java.awt.Dimension(325, 80));
        txtarea_Desc_1.setPreferredSize(new java.awt.Dimension(325, 80));
        jScroll_Desc_1.setViewportView(txtarea_Desc_1);

        lbl_Preco_1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_Preco_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Preco_1.setToolTipText("");
        lbl_Preco_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_Preco_1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lbl_Obs_1.setText("Observaçäo:");

        txt_Obs_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Obs_1txt_Obs_1ActionPerformed(evt);
            }
        });

        lbl_Foto_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Foto_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_Foto_1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lbl_Foto_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_Foto_1lbl_Foto_1MouseReleased(evt);
            }
        });

        btn_RemoveQtde_1.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\images\\btnREMOVE.png"));
        btn_RemoveQtde_1.setText("btn_RemoveQtde_1");
        btn_RemoveQtde_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RemoveQtde_1btn_RemoveQtde_1ActionPerformed(evt);
            }
        });

        lbl_QtdeItem_1.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        lbl_QtdeItem_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_QtdeItem_1.setText("0");

        btn_AdicionaQtde_1.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\images\\btnADD.png"));
        btn_AdicionaQtde_1.setText("btn_RemoveQtde_1");
        btn_AdicionaQtde_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AdicionaQtde_1btn_AdicionaQtde_1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_Item_1Layout = new javax.swing.GroupLayout(pnl_Item_1);
        pnl_Item_1.setLayout(pnl_Item_1Layout);
        pnl_Item_1Layout.setHorizontalGroup(
            pnl_Item_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Item_1Layout.createSequentialGroup()
                .addGroup(pnl_Item_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filler_Bot_1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_Item_1Layout.createSequentialGroup()
                        .addComponent(filler_Left_1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(pnl_Item_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Nome_1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScroll_Desc_1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Preco_1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl_Item_1Layout.createSequentialGroup()
                                .addComponent(lbl_Obs_1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(txt_Obs_1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addComponent(filler_Mid_1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(pnl_Item_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Foto_1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl_Item_1Layout.createSequentialGroup()
                                .addComponent(btn_RemoveQtde_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(lbl_QtdeItem_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(btn_AdicionaQtde_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addComponent(filler_Right_1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(filler_Top_1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        pnl_Item_1Layout.setVerticalGroup(
            pnl_Item_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Item_1Layout.createSequentialGroup()
                .addComponent(filler_Top_1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnl_Item_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_Item_1Layout.createSequentialGroup()
                        .addComponent(lbl_Nome_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jScroll_Desc_1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(lbl_Preco_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(pnl_Item_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_Obs_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Obs_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnl_Item_1Layout.createSequentialGroup()
                        .addComponent(lbl_Foto_1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(pnl_Item_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_RemoveQtde_1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_QtdeItem_1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_AdicionaQtde_1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(filler_Mid_1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filler_Right_1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filler_Left_1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(filler_Bot_1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(695, 695, 695))
        );

        pnl_Item_2.setBackground(new java.awt.Color(51, 51, 51));
        pnl_Item_2.setPreferredSize(new java.awt.Dimension(500, 230));

        lbl_Nome_2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_Nome_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtarea_Desc_2.setColumns(20);
        txtarea_Desc_2.setForeground(new java.awt.Color(51, 51, 0));
        txtarea_Desc_2.setLineWrap(true);
        txtarea_Desc_2.setRows(5);
        txtarea_Desc_2.setEnabled(false);
        txtarea_Desc_2.setMaximumSize(new java.awt.Dimension(325, 80));
        txtarea_Desc_2.setMinimumSize(new java.awt.Dimension(325, 80));
        txtarea_Desc_2.setPreferredSize(new java.awt.Dimension(325, 80));
        jScroll_Desc_2.setViewportView(txtarea_Desc_2);

        lbl_Preco_2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_Preco_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Preco_2.setToolTipText("");
        lbl_Preco_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_Preco_2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lbl_Obs_2.setText("Observaçäo:");

        txt_Obs_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Obs_2txt_Obs_1ActionPerformed(evt);
            }
        });

        lbl_Foto_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Foto_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_Foto_2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lbl_Foto_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_Foto_2lbl_Foto_1MouseReleased(evt);
            }
        });

        btn_RemoveQtde_2.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\images\\btnREMOVE.png"));
        btn_RemoveQtde_2.setText("btn_RemoveQtde_1");
        btn_RemoveQtde_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RemoveQtde_2btn_RemoveQtde_1ActionPerformed(evt);
            }
        });

        lbl_QtdeItem_2.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        lbl_QtdeItem_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_QtdeItem_2.setText("0");

        btn_AdicionaQtde_1.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\images\\btnADD.png"));
        btn_AdicionaQtde_2.setText("btn_RemoveQtde_1");
        btn_AdicionaQtde_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AdicionaQtde_2btn_AdicionaQtde_1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_Item_2Layout = new javax.swing.GroupLayout(pnl_Item_2);
        pnl_Item_2.setLayout(pnl_Item_2Layout);
        pnl_Item_2Layout.setHorizontalGroup(
            pnl_Item_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Item_2Layout.createSequentialGroup()
                .addGroup(pnl_Item_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filler_Bot_2, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_Item_2Layout.createSequentialGroup()
                        .addComponent(filler_Left_2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(pnl_Item_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Nome_2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScroll_Desc_2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Preco_2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl_Item_2Layout.createSequentialGroup()
                                .addComponent(lbl_Obs_2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(txt_Obs_2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addComponent(filler_Mid_2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(pnl_Item_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Foto_2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl_Item_2Layout.createSequentialGroup()
                                .addComponent(btn_RemoveQtde_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(lbl_QtdeItem_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(btn_AdicionaQtde_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addComponent(filler_Right_2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(filler_Top_2, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        pnl_Item_2Layout.setVerticalGroup(
            pnl_Item_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Item_2Layout.createSequentialGroup()
                .addComponent(filler_Top_2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnl_Item_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_Item_2Layout.createSequentialGroup()
                        .addComponent(lbl_Nome_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jScroll_Desc_2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(lbl_Preco_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(pnl_Item_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_Obs_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Obs_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnl_Item_2Layout.createSequentialGroup()
                        .addComponent(lbl_Foto_2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(pnl_Item_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_RemoveQtde_2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_QtdeItem_2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_AdicionaQtde_2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(filler_Mid_2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filler_Right_2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filler_Left_2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(filler_Bot_2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(695, 695, 695))
        );

        pnl_Item_3.setBackground(new java.awt.Color(51, 51, 51));
        pnl_Item_3.setPreferredSize(new java.awt.Dimension(500, 230));

        lbl_Nome_3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_Nome_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtarea_Desc_3.setColumns(20);
        txtarea_Desc_3.setForeground(new java.awt.Color(51, 51, 0));
        txtarea_Desc_3.setLineWrap(true);
        txtarea_Desc_3.setRows(5);
        txtarea_Desc_3.setEnabled(false);
        txtarea_Desc_3.setMaximumSize(new java.awt.Dimension(325, 80));
        txtarea_Desc_3.setMinimumSize(new java.awt.Dimension(325, 80));
        txtarea_Desc_3.setPreferredSize(new java.awt.Dimension(325, 80));
        jScroll_Desc_3.setViewportView(txtarea_Desc_3);

        lbl_Preco_3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_Preco_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Preco_3.setToolTipText("");
        lbl_Preco_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_Preco_3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lbl_Obs_3.setText("Observaçäo:");

        txt_Obs_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Obs_3txt_Obs_1ActionPerformed(evt);
            }
        });

        lbl_Foto_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Foto_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_Foto_3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lbl_Foto_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_Foto_3lbl_Foto_1MouseReleased(evt);
            }
        });

        btn_RemoveQtde_3.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\images\\btnREMOVE.png"));
        btn_RemoveQtde_3.setText("btn_RemoveQtde_1");
        btn_RemoveQtde_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RemoveQtde_3btn_RemoveQtde_1ActionPerformed(evt);
            }
        });

        lbl_QtdeItem_3.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        lbl_QtdeItem_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_QtdeItem_3.setText("0");

        btn_AdicionaQtde_1.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\images\\btnADD.png"));
        btn_AdicionaQtde_3.setText("btn_RemoveQtde_1");
        btn_AdicionaQtde_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AdicionaQtde_3btn_AdicionaQtde_1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_Item_3Layout = new javax.swing.GroupLayout(pnl_Item_3);
        pnl_Item_3.setLayout(pnl_Item_3Layout);
        pnl_Item_3Layout.setHorizontalGroup(
            pnl_Item_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Item_3Layout.createSequentialGroup()
                .addGroup(pnl_Item_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filler_Bot_3, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_Item_3Layout.createSequentialGroup()
                        .addComponent(filler_Left_3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(pnl_Item_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Nome_3, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScroll_Desc_3, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Preco_3, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl_Item_3Layout.createSequentialGroup()
                                .addComponent(lbl_Obs_3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(txt_Obs_3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addComponent(filler_Mid_3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(pnl_Item_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Foto_3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl_Item_3Layout.createSequentialGroup()
                                .addComponent(btn_RemoveQtde_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(lbl_QtdeItem_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(btn_AdicionaQtde_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addComponent(filler_Right_3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(filler_Top_3, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        pnl_Item_3Layout.setVerticalGroup(
            pnl_Item_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Item_3Layout.createSequentialGroup()
                .addComponent(filler_Top_3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnl_Item_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_Item_3Layout.createSequentialGroup()
                        .addComponent(lbl_Nome_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jScroll_Desc_3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(lbl_Preco_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(pnl_Item_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_Obs_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Obs_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnl_Item_3Layout.createSequentialGroup()
                        .addComponent(lbl_Foto_3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(pnl_Item_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_RemoveQtde_3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_QtdeItem_3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_AdicionaQtde_3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(filler_Mid_3, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filler_Right_3, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filler_Left_3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(filler_Bot_3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(695, 695, 695))
        );

        pnl_Item_4.setBackground(new java.awt.Color(51, 51, 51));
        pnl_Item_4.setPreferredSize(new java.awt.Dimension(500, 230));

        lbl_Nome_4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_Nome_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtarea_Desc_4.setColumns(20);
        txtarea_Desc_4.setForeground(new java.awt.Color(51, 51, 0));
        txtarea_Desc_4.setLineWrap(true);
        txtarea_Desc_4.setRows(5);
        txtarea_Desc_4.setEnabled(false);
        txtarea_Desc_4.setMaximumSize(new java.awt.Dimension(325, 80));
        txtarea_Desc_4.setMinimumSize(new java.awt.Dimension(325, 80));
        txtarea_Desc_4.setPreferredSize(new java.awt.Dimension(325, 80));
        jScroll_Desc_4.setViewportView(txtarea_Desc_4);

        lbl_Preco_4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_Preco_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Preco_4.setToolTipText("");
        lbl_Preco_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_Preco_4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lbl_Obs_4.setText("Observaçäo:");

        txt_Obs_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Obs_4txt_Obs_1ActionPerformed(evt);
            }
        });

        lbl_Foto_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Foto_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_Foto_4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lbl_Foto_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_Foto_4lbl_Foto_1MouseReleased(evt);
            }
        });

        btn_RemoveQtde_4.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\images\\btnREMOVE.png"));
        btn_RemoveQtde_4.setText("btn_RemoveQtde_1");
        btn_RemoveQtde_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RemoveQtde_4btn_RemoveQtde_1ActionPerformed(evt);
            }
        });

        lbl_QtdeItem_4.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        lbl_QtdeItem_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_QtdeItem_4.setText("0");

        btn_AdicionaQtde_1.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\images\\btnADD.png"));
        btn_AdicionaQtde_4.setText("btn_RemoveQtde_1");
        btn_AdicionaQtde_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AdicionaQtde_4btn_AdicionaQtde_1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_Item_4Layout = new javax.swing.GroupLayout(pnl_Item_4);
        pnl_Item_4.setLayout(pnl_Item_4Layout);
        pnl_Item_4Layout.setHorizontalGroup(
            pnl_Item_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Item_4Layout.createSequentialGroup()
                .addGroup(pnl_Item_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filler_Bot_4, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_Item_4Layout.createSequentialGroup()
                        .addComponent(filler_Left_4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(pnl_Item_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Nome_4, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScroll_Desc_4, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Preco_4, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl_Item_4Layout.createSequentialGroup()
                                .addComponent(lbl_Obs_4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(txt_Obs_4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addComponent(filler_Mid_4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(pnl_Item_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Foto_4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl_Item_4Layout.createSequentialGroup()
                                .addComponent(btn_RemoveQtde_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(lbl_QtdeItem_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(btn_AdicionaQtde_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addComponent(filler_Right_4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(filler_Top_4, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        pnl_Item_4Layout.setVerticalGroup(
            pnl_Item_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Item_4Layout.createSequentialGroup()
                .addComponent(filler_Top_4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnl_Item_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_Item_4Layout.createSequentialGroup()
                        .addComponent(lbl_Nome_4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jScroll_Desc_4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(lbl_Preco_4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(pnl_Item_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_Obs_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Obs_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnl_Item_4Layout.createSequentialGroup()
                        .addComponent(lbl_Foto_4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(pnl_Item_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_RemoveQtde_4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_QtdeItem_4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_AdicionaQtde_4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(filler_Mid_4, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filler_Right_4, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filler_Left_4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(filler_Bot_4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(695, 695, 695))
        );

        pnl_Item_5.setBackground(new java.awt.Color(51, 51, 51));
        pnl_Item_5.setPreferredSize(new java.awt.Dimension(500, 230));

        lbl_Nome_5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_Nome_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtarea_Desc_5.setColumns(20);
        txtarea_Desc_5.setForeground(new java.awt.Color(51, 51, 0));
        txtarea_Desc_5.setLineWrap(true);
        txtarea_Desc_5.setRows(5);
        txtarea_Desc_5.setEnabled(false);
        txtarea_Desc_5.setMaximumSize(new java.awt.Dimension(325, 80));
        txtarea_Desc_5.setMinimumSize(new java.awt.Dimension(325, 80));
        txtarea_Desc_5.setPreferredSize(new java.awt.Dimension(325, 80));
        jScroll_Desc_5.setViewportView(txtarea_Desc_5);

        lbl_Preco_5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_Preco_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Preco_5.setToolTipText("");
        lbl_Preco_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_Preco_5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lbl_Obs_5.setText("Observaçäo:");

        txt_Obs_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Obs_5txt_Obs_1ActionPerformed(evt);
            }
        });

        lbl_Foto_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Foto_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_Foto_5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lbl_Foto_5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_Foto_5lbl_Foto_1MouseReleased(evt);
            }
        });

        btn_RemoveQtde_5.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\images\\btnREMOVE.png"));
        btn_RemoveQtde_5.setText("btn_RemoveQtde_1");
        btn_RemoveQtde_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RemoveQtde_5btn_RemoveQtde_1ActionPerformed(evt);
            }
        });

        lbl_QtdeItem_5.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        lbl_QtdeItem_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_QtdeItem_5.setText("0");

        btn_AdicionaQtde_1.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\images\\btnADD.png"));
        btn_AdicionaQtde_5.setText("btn_RemoveQtde_1");
        btn_AdicionaQtde_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AdicionaQtde_5btn_AdicionaQtde_1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_Item_5Layout = new javax.swing.GroupLayout(pnl_Item_5);
        pnl_Item_5.setLayout(pnl_Item_5Layout);
        pnl_Item_5Layout.setHorizontalGroup(
            pnl_Item_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Item_5Layout.createSequentialGroup()
                .addGroup(pnl_Item_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filler_Bot_5, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_Item_5Layout.createSequentialGroup()
                        .addComponent(filler_Left_5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(pnl_Item_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Nome_5, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScroll_Desc_5, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Preco_5, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl_Item_5Layout.createSequentialGroup()
                                .addComponent(lbl_Obs_5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(txt_Obs_5, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addComponent(filler_Mid_5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(pnl_Item_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Foto_5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl_Item_5Layout.createSequentialGroup()
                                .addComponent(btn_RemoveQtde_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(lbl_QtdeItem_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(btn_AdicionaQtde_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addComponent(filler_Right_5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(filler_Top_5, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        pnl_Item_5Layout.setVerticalGroup(
            pnl_Item_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Item_5Layout.createSequentialGroup()
                .addComponent(filler_Top_5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnl_Item_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_Item_5Layout.createSequentialGroup()
                        .addComponent(lbl_Nome_5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jScroll_Desc_5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(lbl_Preco_5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(pnl_Item_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_Obs_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Obs_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnl_Item_5Layout.createSequentialGroup()
                        .addComponent(lbl_Foto_5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(pnl_Item_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_RemoveQtde_5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_QtdeItem_5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_AdicionaQtde_5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(filler_Mid_5, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filler_Right_5, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filler_Left_5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(filler_Bot_5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(695, 695, 695))
        );

        pnl_Item_6.setBackground(new java.awt.Color(51, 51, 51));
        pnl_Item_6.setPreferredSize(new java.awt.Dimension(500, 230));

        lbl_Nome_6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_Nome_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtarea_Desc_6.setColumns(20);
        txtarea_Desc_6.setForeground(new java.awt.Color(51, 51, 0));
        txtarea_Desc_6.setLineWrap(true);
        txtarea_Desc_6.setRows(5);
        txtarea_Desc_6.setEnabled(false);
        txtarea_Desc_6.setMaximumSize(new java.awt.Dimension(325, 80));
        txtarea_Desc_6.setMinimumSize(new java.awt.Dimension(325, 80));
        txtarea_Desc_6.setPreferredSize(new java.awt.Dimension(325, 80));
        jScroll_Desc_6.setViewportView(txtarea_Desc_6);

        lbl_Preco_6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_Preco_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Preco_6.setToolTipText("");
        lbl_Preco_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_Preco_6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lbl_Obs_6.setText("Observaçäo:");

        txt_Obs_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Obs_6txt_Obs_1ActionPerformed(evt);
            }
        });

        lbl_Foto_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Foto_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_Foto_6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lbl_Foto_6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_Foto_6lbl_Foto_1MouseReleased(evt);
            }
        });

        btn_RemoveQtde_6.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\images\\btnREMOVE.png"));
        btn_RemoveQtde_6.setText("btn_RemoveQtde_1");
        btn_RemoveQtde_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RemoveQtde_6btn_RemoveQtde_1ActionPerformed(evt);
            }
        });

        lbl_QtdeItem_6.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        lbl_QtdeItem_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_QtdeItem_6.setText("0");

        btn_AdicionaQtde_1.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\images\\btnADD.png"));
        btn_AdicionaQtde_6.setText("btn_RemoveQtde_1");
        btn_AdicionaQtde_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AdicionaQtde_6btn_AdicionaQtde_1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_Item_6Layout = new javax.swing.GroupLayout(pnl_Item_6);
        pnl_Item_6.setLayout(pnl_Item_6Layout);
        pnl_Item_6Layout.setHorizontalGroup(
            pnl_Item_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Item_6Layout.createSequentialGroup()
                .addGroup(pnl_Item_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filler_Bot_6, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_Item_6Layout.createSequentialGroup()
                        .addComponent(filler_Left_6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(pnl_Item_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Nome_6, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScroll_Desc_6, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Preco_6, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl_Item_6Layout.createSequentialGroup()
                                .addComponent(lbl_Obs_6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(txt_Obs_6, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addComponent(filler_Mid_6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(pnl_Item_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Foto_6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl_Item_6Layout.createSequentialGroup()
                                .addComponent(btn_RemoveQtde_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(lbl_QtdeItem_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(btn_AdicionaQtde_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addComponent(filler_Right_6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(filler_Top_6, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        pnl_Item_6Layout.setVerticalGroup(
            pnl_Item_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Item_6Layout.createSequentialGroup()
                .addComponent(filler_Top_6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnl_Item_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_Item_6Layout.createSequentialGroup()
                        .addComponent(lbl_Nome_6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jScroll_Desc_6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(lbl_Preco_6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(pnl_Item_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_Obs_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Obs_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnl_Item_6Layout.createSequentialGroup()
                        .addComponent(lbl_Foto_6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(pnl_Item_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_RemoveQtde_6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_QtdeItem_6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_AdicionaQtde_6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(filler_Mid_6, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filler_Right_6, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filler_Left_6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(filler_Bot_6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(695, 695, 695))
        );

        pnl_Item_7.setBackground(new java.awt.Color(51, 51, 51));
        pnl_Item_7.setPreferredSize(new java.awt.Dimension(500, 230));

        lbl_Nome_7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_Nome_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtarea_Desc_7.setColumns(20);
        txtarea_Desc_7.setForeground(new java.awt.Color(51, 51, 0));
        txtarea_Desc_7.setLineWrap(true);
        txtarea_Desc_7.setRows(5);
        txtarea_Desc_7.setEnabled(false);
        txtarea_Desc_7.setMaximumSize(new java.awt.Dimension(325, 80));
        txtarea_Desc_7.setMinimumSize(new java.awt.Dimension(325, 80));
        txtarea_Desc_7.setPreferredSize(new java.awt.Dimension(325, 80));
        jScroll_Desc_7.setViewportView(txtarea_Desc_7);

        lbl_Preco_7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_Preco_7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Preco_7.setToolTipText("");
        lbl_Preco_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_Preco_7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lbl_Obs_7.setText("Observaçäo:");

        txt_Obs_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Obs_7txt_Obs_1ActionPerformed(evt);
            }
        });

        lbl_Foto_7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Foto_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_Foto_7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lbl_Foto_7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_Foto_7lbl_Foto_1MouseReleased(evt);
            }
        });

        btn_RemoveQtde_7.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\images\\btnREMOVE.png"));
        btn_RemoveQtde_7.setText("btn_RemoveQtde_1");
        btn_RemoveQtde_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RemoveQtde_7btn_RemoveQtde_1ActionPerformed(evt);
            }
        });

        lbl_QtdeItem_7.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        lbl_QtdeItem_7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_QtdeItem_7.setText("0");

        btn_AdicionaQtde_1.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\images\\btnADD.png"));
        btn_AdicionaQtde_7.setText("btn_RemoveQtde_1");
        btn_AdicionaQtde_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AdicionaQtde_7btn_AdicionaQtde_1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_Item_7Layout = new javax.swing.GroupLayout(pnl_Item_7);
        pnl_Item_7.setLayout(pnl_Item_7Layout);
        pnl_Item_7Layout.setHorizontalGroup(
            pnl_Item_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Item_7Layout.createSequentialGroup()
                .addGroup(pnl_Item_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filler_Bot_7, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_Item_7Layout.createSequentialGroup()
                        .addComponent(filler_Left_7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(pnl_Item_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Nome_7, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScroll_Desc_7, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Preco_7, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl_Item_7Layout.createSequentialGroup()
                                .addComponent(lbl_Obs_7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(txt_Obs_7, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addComponent(filler_Mid_7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(pnl_Item_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Foto_7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl_Item_7Layout.createSequentialGroup()
                                .addComponent(btn_RemoveQtde_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(lbl_QtdeItem_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(btn_AdicionaQtde_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addComponent(filler_Right_7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(filler_Top_7, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        pnl_Item_7Layout.setVerticalGroup(
            pnl_Item_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Item_7Layout.createSequentialGroup()
                .addComponent(filler_Top_7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnl_Item_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_Item_7Layout.createSequentialGroup()
                        .addComponent(lbl_Nome_7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jScroll_Desc_7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(lbl_Preco_7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(pnl_Item_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_Obs_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Obs_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnl_Item_7Layout.createSequentialGroup()
                        .addComponent(lbl_Foto_7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(pnl_Item_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_RemoveQtde_7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_QtdeItem_7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_AdicionaQtde_7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(filler_Mid_7, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filler_Right_7, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filler_Left_7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(filler_Bot_7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(695, 695, 695))
        );

        pnl_Item_8.setBackground(new java.awt.Color(51, 51, 51));
        pnl_Item_8.setPreferredSize(new java.awt.Dimension(500, 230));

        lbl_Nome_8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_Nome_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtarea_Desc_8.setColumns(20);
        txtarea_Desc_8.setForeground(new java.awt.Color(51, 51, 0));
        txtarea_Desc_8.setLineWrap(true);
        txtarea_Desc_8.setRows(5);
        txtarea_Desc_8.setEnabled(false);
        txtarea_Desc_8.setMaximumSize(new java.awt.Dimension(325, 80));
        txtarea_Desc_8.setMinimumSize(new java.awt.Dimension(325, 80));
        txtarea_Desc_8.setPreferredSize(new java.awt.Dimension(325, 80));
        jScroll_Desc_8.setViewportView(txtarea_Desc_8);

        lbl_Preco_8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_Preco_8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Preco_8.setToolTipText("");
        lbl_Preco_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_Preco_8.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lbl_Obs_8.setText("Observaçäo:");

        txt_Obs_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Obs_1ActionPerformed(evt);
            }
        });

        lbl_Foto_8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Foto_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_Foto_8.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lbl_Foto_8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_Foto_1MouseReleased(evt);
            }
        });

        btn_RemoveQtde_8.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\images\\btnREMOVE.png"));
        btn_RemoveQtde_8.setText("btn_RemoveQtde_1");
        btn_RemoveQtde_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RemoveQtde_1ActionPerformed(evt);
            }
        });

        lbl_QtdeItem_8.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        lbl_QtdeItem_8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_QtdeItem_8.setText("0");

        btn_AdicionaQtde_1.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\images\\btnADD.png"));
        btn_AdicionaQtde_8.setText("btn_RemoveQtde_1");
        btn_AdicionaQtde_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AdicionaQtde_1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_Item_8Layout = new javax.swing.GroupLayout(pnl_Item_8);
        pnl_Item_8.setLayout(pnl_Item_8Layout);
        pnl_Item_8Layout.setHorizontalGroup(
            pnl_Item_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Item_8Layout.createSequentialGroup()
                .addGroup(pnl_Item_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filler_Bot_8, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_Item_8Layout.createSequentialGroup()
                        .addComponent(filler_Left_8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(pnl_Item_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Nome_8, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScroll_Desc_8, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Preco_8, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl_Item_8Layout.createSequentialGroup()
                                .addComponent(lbl_Obs_8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(txt_Obs_8, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addComponent(filler_Mid_8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(pnl_Item_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Foto_8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl_Item_8Layout.createSequentialGroup()
                                .addComponent(btn_RemoveQtde_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(lbl_QtdeItem_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(btn_AdicionaQtde_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addComponent(filler_Right_8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(filler_Top_8, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        pnl_Item_8Layout.setVerticalGroup(
            pnl_Item_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Item_8Layout.createSequentialGroup()
                .addComponent(filler_Top_8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnl_Item_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_Item_8Layout.createSequentialGroup()
                        .addComponent(lbl_Nome_8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jScroll_Desc_8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(lbl_Preco_8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(pnl_Item_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_Obs_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Obs_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnl_Item_8Layout.createSequentialGroup()
                        .addComponent(lbl_Foto_8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(pnl_Item_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_RemoveQtde_8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_QtdeItem_8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_AdicionaQtde_8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(filler_Mid_8, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filler_Right_8, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filler_Left_8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(filler_Bot_8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(695, 695, 695))
        );

        javax.swing.GroupLayout pnl_ItensLayout = new javax.swing.GroupLayout(pnl_Itens);
        pnl_Itens.setLayout(pnl_ItensLayout);
        pnl_ItensLayout.setHorizontalGroup(
            pnl_ItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ItensLayout.createSequentialGroup()
                .addComponent(pnl_Item_3, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(pnl_Item_4, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnl_ItensLayout.createSequentialGroup()
                .addGroup(pnl_ItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_ItensLayout.createSequentialGroup()
                        .addComponent(pnl_Item_7, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(pnl_Item_8, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_ItensLayout.createSequentialGroup()
                        .addComponent(pnl_Item_1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(pnl_Item_2, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_ItensLayout.createSequentialGroup()
                        .addComponent(pnl_Item_5, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(pnl_Item_6, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );
        pnl_ItensLayout.setVerticalGroup(
            pnl_ItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ItensLayout.createSequentialGroup()
                .addGroup(pnl_ItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_Item_2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_Item_1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(pnl_ItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_Item_3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_Item_4, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(pnl_ItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_Item_5, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_Item_6, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(pnl_ItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnl_Item_7, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_Item_8, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jScrollPane3.setViewportView(pnl_Itens);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1067, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnl_DadosPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(pnl_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130)))
                .addComponent(pnl_PreCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_PreCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(320, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_DadosPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1587, 804));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int numeroDeItensNaComanda = jtItens.getRowCount();
        Item car[] = new Item[numeroDeItensNaComanda];

        for (int i = 0; i < car.length; i++) {
            car[i] = new Item();
            car[i].setId_pedido(Integer.parseInt(lbl_NumeroDoPedido.getText()));
            car[i].setId_produto(Integer.parseInt(jtItens.getValueAt(i, 0).toString()));
            car[i].setQtde(Integer.parseInt(jtItens.getValueAt(i, 2).toString()));
            car[i].setSubtotal(Double.parseDouble(jtItens.getValueAt(i, 4).toString()));
            car[i].setObservacao(jtItens.getValueAt(i, 5).toString());
        }

        int confirma = JOptionPane.showConfirmDialog(
                this,
                "Deseja confirmar o pedido",
                "CONFIRMAR",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (confirma == JOptionPane.YES_OPTION) {

            ItemDao carrinhoDao = new ItemDao();
            for (Item carrinho : car) {
                try {
                    carrinhoDao.adicionaItens(carrinho);
                    limparQtde();
                    limparTabela();
                    calculaTotal();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "ERRO BOTAO: " + e.getMessage());
                }
            }
        } else if (confirma == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "pedido NAO enviado");
        } else {
            JOptionPane.showMessageDialog(null, "operacao cancelado");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnRemonerLinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemonerLinhaActionPerformed
        if (jtItens.getSelectedRow() != -1) {
            DefaultTableModel dt = (DefaultTableModel) jtItens.getModel();
            dt.removeRow(jtItens.getSelectedRow());
        }
    }//GEN-LAST:event_btnRemonerLinhaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {   
             this.dispose();//Fecha a tela menu
             new Tela_ResumoPedido(Integer.parseInt(lbl_NumeroDoPedido.getText()), Integer.parseInt(lbl_NumeroDaMesa.getText())).setVisible(true);
             
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_Categoria_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Categoria_2ActionPerformed
        try {
            setCat(lblId, 2);
            setPorCat(lblNomes, txtAreaDescricoes, lblPrecos, lblId);
            setFotos(2);
            limparQtde();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_Categoria_2ActionPerformed

    private void btn_Categoria_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Categoria_1ActionPerformed
        try {
            setCat(lblId, 1);
            setPorCat(lblNomes, txtAreaDescricoes, lblPrecos, lblId);
            setFotos(1);
            limparQtde();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_Categoria_1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
/*
        int confirma = JOptionPane.showConfirmDialog(
                this,
                "Deseja encerrar o pedido?",
                "Encerrar Pedido",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        if (confirma == JOptionPane.YES_OPTION) {
            try {
                //Fecha pedido
                Pedido pedido = new Pedido();
                pedido.setIdPedido(Integer.parseInt(lbl_NumeroPedido.getText()));
                pedido.setStatus("Encerrado");
                PedidoDao pedidoDao = new PedidoDao();
                pedidoDao.atualizaPedido(pedido);
                JOptionPane.showMessageDialog(null, "Pedido encerrado, um atendente levará a conta até voce");
                this.dispose();

                int novoPedido = JOptionPane.showConfirmDialog(
                        this,
                        "Deseja criar um novo pedido?",
                        "Novo Pedido",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );
                if (novoPedido == JOptionPane.YES_OPTION) {
                    //Cria novo pedido
                    pedido.setIdPedido(Integer.parseInt(lbl_NumeroMesa.getText()));//seta o id do pedido
                    pedidoDao.adicionarPedido(pedido);//cria pedido
                    new Tela_Menu(pedidoDao.numeroPedido, Integer.parseInt(lbl_NumeroMesa.getText())).setVisible(true);//abre a tela menu
                }else{
                    //Caso não crie outro pedido, volta para tela login
                    new Tela_Login().setVisible(true);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }

        }     */ 
this.dispose;
       
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btn_AdicionaQtde_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AdicionaQtde_1ActionPerformed
        adicionaQtde(lbl_QtdeItem_8);
    }//GEN-LAST:event_btn_AdicionaQtde_1ActionPerformed

    private void btn_RemoveQtde_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RemoveQtde_1ActionPerformed
        removeQtde(lbl_QtdeItem_8);
    }//GEN-LAST:event_btn_RemoveQtde_1ActionPerformed

    private void lbl_Foto_1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_Foto_1MouseReleased
        adicionaNoPreCarrinho(lbl_QtdeItem_8, lbl_Id_8, txt_Obs_8);
    }//GEN-LAST:event_lbl_Foto_1MouseReleased

    private void txt_Obs_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Obs_1ActionPerformed

    }//GEN-LAST:event_txt_Obs_1ActionPerformed

    private void txt_Obs_3txt_Obs_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Obs_3txt_Obs_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Obs_3txt_Obs_1ActionPerformed

    private void lbl_Foto_3lbl_Foto_1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_Foto_3lbl_Foto_1MouseReleased
        // TODO add your handling code here:
        adicionaNoPreCarrinho(lbl_QtdeItem_3, lbl_Id_3, txt_Obs_3);
    }//GEN-LAST:event_lbl_Foto_3lbl_Foto_1MouseReleased

    private void btn_RemoveQtde_3btn_RemoveQtde_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RemoveQtde_3btn_RemoveQtde_1ActionPerformed
        removeQtde(lbl_QtdeItem_3);
    }//GEN-LAST:event_btn_RemoveQtde_3btn_RemoveQtde_1ActionPerformed

    private void btn_AdicionaQtde_3btn_AdicionaQtde_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AdicionaQtde_3btn_AdicionaQtde_1ActionPerformed
        adicionaQtde(lbl_QtdeItem_3);
    }//GEN-LAST:event_btn_AdicionaQtde_3btn_AdicionaQtde_1ActionPerformed

    private void txt_Obs_5txt_Obs_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Obs_5txt_Obs_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Obs_5txt_Obs_1ActionPerformed

    private void lbl_Foto_5lbl_Foto_1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_Foto_5lbl_Foto_1MouseReleased
        // TODO add your handling code here:
        adicionaNoPreCarrinho(lbl_QtdeItem_5, lbl_Id_5, txt_Obs_5);
    }//GEN-LAST:event_lbl_Foto_5lbl_Foto_1MouseReleased

    private void btn_RemoveQtde_5btn_RemoveQtde_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RemoveQtde_5btn_RemoveQtde_1ActionPerformed
        removeQtde(lbl_QtdeItem_5);
    }//GEN-LAST:event_btn_RemoveQtde_5btn_RemoveQtde_1ActionPerformed

    private void btn_AdicionaQtde_5btn_AdicionaQtde_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AdicionaQtde_5btn_AdicionaQtde_1ActionPerformed
        adicionaQtde(lbl_QtdeItem_5);
    }//GEN-LAST:event_btn_AdicionaQtde_5btn_AdicionaQtde_1ActionPerformed

    private void txt_Obs_7txt_Obs_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Obs_7txt_Obs_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Obs_7txt_Obs_1ActionPerformed

    private void lbl_Foto_7lbl_Foto_1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_Foto_7lbl_Foto_1MouseReleased
        // TODO add your handling code here:
        adicionaNoPreCarrinho(lbl_QtdeItem_7, lbl_Id_7, txt_Obs_7);
    }//GEN-LAST:event_lbl_Foto_7lbl_Foto_1MouseReleased

    private void btn_RemoveQtde_7btn_RemoveQtde_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RemoveQtde_7btn_RemoveQtde_1ActionPerformed
        removeQtde(lbl_QtdeItem_7);
    }//GEN-LAST:event_btn_RemoveQtde_7btn_RemoveQtde_1ActionPerformed

    private void btn_AdicionaQtde_7btn_AdicionaQtde_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AdicionaQtde_7btn_AdicionaQtde_1ActionPerformed
        adicionaQtde(lbl_QtdeItem_7);
    }//GEN-LAST:event_btn_AdicionaQtde_7btn_AdicionaQtde_1ActionPerformed

    private void txt_Obs_4txt_Obs_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Obs_4txt_Obs_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Obs_4txt_Obs_1ActionPerformed

    private void lbl_Foto_4lbl_Foto_1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_Foto_4lbl_Foto_1MouseReleased
        // TODO add your handling code here:
        adicionaNoPreCarrinho(lbl_QtdeItem_4, lbl_Id_4, txt_Obs_4);
    }//GEN-LAST:event_lbl_Foto_4lbl_Foto_1MouseReleased

    private void btn_RemoveQtde_4btn_RemoveQtde_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RemoveQtde_4btn_RemoveQtde_1ActionPerformed
        removeQtde(lbl_QtdeItem_4);
    }//GEN-LAST:event_btn_RemoveQtde_4btn_RemoveQtde_1ActionPerformed

    private void btn_AdicionaQtde_4btn_AdicionaQtde_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AdicionaQtde_4btn_AdicionaQtde_1ActionPerformed
        adicionaQtde(lbl_QtdeItem_4);
    }//GEN-LAST:event_btn_AdicionaQtde_4btn_AdicionaQtde_1ActionPerformed

    private void txt_Obs_2txt_Obs_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Obs_2txt_Obs_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Obs_2txt_Obs_1ActionPerformed

    private void lbl_Foto_2lbl_Foto_1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_Foto_2lbl_Foto_1MouseReleased
        // TODO add your handling code here:
        adicionaNoPreCarrinho(lbl_QtdeItem_2, lbl_Id_2, txt_Obs_2);
    }//GEN-LAST:event_lbl_Foto_2lbl_Foto_1MouseReleased

    private void btn_RemoveQtde_2btn_RemoveQtde_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RemoveQtde_2btn_RemoveQtde_1ActionPerformed
        removeQtde(lbl_QtdeItem_2);
    }//GEN-LAST:event_btn_RemoveQtde_2btn_RemoveQtde_1ActionPerformed

    private void btn_AdicionaQtde_2btn_AdicionaQtde_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AdicionaQtde_2btn_AdicionaQtde_1ActionPerformed
        adicionaQtde(lbl_QtdeItem_2);
    }//GEN-LAST:event_btn_AdicionaQtde_2btn_AdicionaQtde_1ActionPerformed

    private void txt_Obs_6txt_Obs_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Obs_6txt_Obs_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Obs_6txt_Obs_1ActionPerformed

    private void lbl_Foto_6lbl_Foto_1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_Foto_6lbl_Foto_1MouseReleased
        // TODO add your handling code here:
        adicionaNoPreCarrinho(lbl_QtdeItem_6, lbl_Id_6, txt_Obs_6);
    }//GEN-LAST:event_lbl_Foto_6lbl_Foto_1MouseReleased

    private void btn_RemoveQtde_6btn_RemoveQtde_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RemoveQtde_6btn_RemoveQtde_1ActionPerformed
        removeQtde(lbl_QtdeItem_6);
    }//GEN-LAST:event_btn_RemoveQtde_6btn_RemoveQtde_1ActionPerformed

    private void btn_AdicionaQtde_6btn_AdicionaQtde_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AdicionaQtde_6btn_AdicionaQtde_1ActionPerformed
        adicionaQtde(lbl_QtdeItem_6);
    }//GEN-LAST:event_btn_AdicionaQtde_6btn_AdicionaQtde_1ActionPerformed

    private void txt_Obs_1txt_Obs_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Obs_1txt_Obs_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Obs_1txt_Obs_1ActionPerformed

    private void lbl_Foto_1lbl_Foto_1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_Foto_1lbl_Foto_1MouseReleased
        // TODO add your handling code here:
        adicionaNoPreCarrinho(lbl_QtdeItem_1, lbl_Id_1, txt_Obs_1);
    }//GEN-LAST:event_lbl_Foto_1lbl_Foto_1MouseReleased

    private void btn_RemoveQtde_1btn_RemoveQtde_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RemoveQtde_1btn_RemoveQtde_1ActionPerformed
        removeQtde(lbl_QtdeItem_1);
    }//GEN-LAST:event_btn_RemoveQtde_1btn_RemoveQtde_1ActionPerformed

    private void btn_AdicionaQtde_1btn_AdicionaQtde_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AdicionaQtde_1btn_AdicionaQtde_1ActionPerformed
        adicionaQtde(lbl_QtdeItem_1);
    }//GEN-LAST:event_btn_AdicionaQtde_1btn_AdicionaQtde_1ActionPerformed

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
    private javax.swing.JButton btnRemonerLinha;
    private javax.swing.JButton btn_AdicionaQtde_1;
    private javax.swing.JButton btn_AdicionaQtde_2;
    private javax.swing.JButton btn_AdicionaQtde_3;
    private javax.swing.JButton btn_AdicionaQtde_4;
    private javax.swing.JButton btn_AdicionaQtde_5;
    private javax.swing.JButton btn_AdicionaQtde_6;
    private javax.swing.JButton btn_AdicionaQtde_7;
    private javax.swing.JButton btn_AdicionaQtde_8;
    private javax.swing.JButton btn_Categoria_1;
    private javax.swing.JButton btn_Categoria_2;
    private javax.swing.JButton btn_RemoveQtde_1;
    private javax.swing.JButton btn_RemoveQtde_2;
    private javax.swing.JButton btn_RemoveQtde_3;
    private javax.swing.JButton btn_RemoveQtde_4;
    private javax.swing.JButton btn_RemoveQtde_5;
    private javax.swing.JButton btn_RemoveQtde_6;
    private javax.swing.JButton btn_RemoveQtde_7;
    private javax.swing.JButton btn_RemoveQtde_8;
    private javax.swing.Box.Filler filler_Bot_1;
    private javax.swing.Box.Filler filler_Bot_2;
    private javax.swing.Box.Filler filler_Bot_3;
    private javax.swing.Box.Filler filler_Bot_4;
    private javax.swing.Box.Filler filler_Bot_5;
    private javax.swing.Box.Filler filler_Bot_6;
    private javax.swing.Box.Filler filler_Bot_7;
    private javax.swing.Box.Filler filler_Bot_8;
    private javax.swing.Box.Filler filler_Left_1;
    private javax.swing.Box.Filler filler_Left_2;
    private javax.swing.Box.Filler filler_Left_3;
    private javax.swing.Box.Filler filler_Left_4;
    private javax.swing.Box.Filler filler_Left_5;
    private javax.swing.Box.Filler filler_Left_6;
    private javax.swing.Box.Filler filler_Left_7;
    private javax.swing.Box.Filler filler_Left_8;
    private javax.swing.Box.Filler filler_Mid_1;
    private javax.swing.Box.Filler filler_Mid_2;
    private javax.swing.Box.Filler filler_Mid_3;
    private javax.swing.Box.Filler filler_Mid_4;
    private javax.swing.Box.Filler filler_Mid_5;
    private javax.swing.Box.Filler filler_Mid_6;
    private javax.swing.Box.Filler filler_Mid_7;
    private javax.swing.Box.Filler filler_Mid_8;
    private javax.swing.Box.Filler filler_Right_1;
    private javax.swing.Box.Filler filler_Right_2;
    private javax.swing.Box.Filler filler_Right_3;
    private javax.swing.Box.Filler filler_Right_4;
    private javax.swing.Box.Filler filler_Right_5;
    private javax.swing.Box.Filler filler_Right_6;
    private javax.swing.Box.Filler filler_Right_7;
    private javax.swing.Box.Filler filler_Right_8;
    private javax.swing.Box.Filler filler_Top_1;
    private javax.swing.Box.Filler filler_Top_2;
    private javax.swing.Box.Filler filler_Top_3;
    private javax.swing.Box.Filler filler_Top_4;
    private javax.swing.Box.Filler filler_Top_5;
    private javax.swing.Box.Filler filler_Top_6;
    private javax.swing.Box.Filler filler_Top_7;
    private javax.swing.Box.Filler filler_Top_8;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScroll_Desc_1;
    private javax.swing.JScrollPane jScroll_Desc_2;
    private javax.swing.JScrollPane jScroll_Desc_3;
    private javax.swing.JScrollPane jScroll_Desc_4;
    private javax.swing.JScrollPane jScroll_Desc_5;
    private javax.swing.JScrollPane jScroll_Desc_6;
    private javax.swing.JScrollPane jScroll_Desc_7;
    private javax.swing.JScrollPane jScroll_Desc_8;
    private javax.swing.JTable jtItens;
    private javax.swing.JLabel lbl_FotoPedido;
    private javax.swing.JLabel lbl_Foto_1;
    private javax.swing.JLabel lbl_Foto_2;
    private javax.swing.JLabel lbl_Foto_3;
    private javax.swing.JLabel lbl_Foto_4;
    private javax.swing.JLabel lbl_Foto_5;
    private javax.swing.JLabel lbl_Foto_6;
    private javax.swing.JLabel lbl_Foto_7;
    private javax.swing.JLabel lbl_Foto_8;
    private javax.swing.JLabel lbl_Id_1;
    private javax.swing.JLabel lbl_Id_2;
    private javax.swing.JLabel lbl_Id_3;
    private javax.swing.JLabel lbl_Id_4;
    private javax.swing.JLabel lbl_Id_5;
    private javax.swing.JLabel lbl_Id_6;
    private javax.swing.JLabel lbl_Id_7;
    private javax.swing.JLabel lbl_Id_8;
    private javax.swing.JLabel lbl_Nome_1;
    private javax.swing.JLabel lbl_Nome_2;
    private javax.swing.JLabel lbl_Nome_3;
    private javax.swing.JLabel lbl_Nome_4;
    private javax.swing.JLabel lbl_Nome_5;
    private javax.swing.JLabel lbl_Nome_6;
    private javax.swing.JLabel lbl_Nome_7;
    private javax.swing.JLabel lbl_Nome_8;
    private javax.swing.JLabel lbl_NumeroDaMesa;
    private javax.swing.JLabel lbl_NumeroDoPedido;
    private javax.swing.JLabel lbl_Obs_1;
    private javax.swing.JLabel lbl_Obs_2;
    private javax.swing.JLabel lbl_Obs_3;
    private javax.swing.JLabel lbl_Obs_4;
    private javax.swing.JLabel lbl_Obs_5;
    private javax.swing.JLabel lbl_Obs_6;
    private javax.swing.JLabel lbl_Obs_7;
    private javax.swing.JLabel lbl_Obs_8;
    private javax.swing.JLabel lbl_Preco_1;
    private javax.swing.JLabel lbl_Preco_2;
    private javax.swing.JLabel lbl_Preco_3;
    private javax.swing.JLabel lbl_Preco_4;
    private javax.swing.JLabel lbl_Preco_5;
    private javax.swing.JLabel lbl_Preco_6;
    private javax.swing.JLabel lbl_Preco_7;
    private javax.swing.JLabel lbl_Preco_8;
    private javax.swing.JLabel lbl_QtdeItem_1;
    private javax.swing.JLabel lbl_QtdeItem_2;
    private javax.swing.JLabel lbl_QtdeItem_3;
    private javax.swing.JLabel lbl_QtdeItem_4;
    private javax.swing.JLabel lbl_QtdeItem_5;
    private javax.swing.JLabel lbl_QtdeItem_6;
    private javax.swing.JLabel lbl_QtdeItem_7;
    private javax.swing.JLabel lbl_QtdeItem_8;
    private javax.swing.JPanel pnl_Categoria;
    private javax.swing.JPanel pnl_DadosPedido;
    private javax.swing.JPanel pnl_Item_1;
    private javax.swing.JPanel pnl_Item_2;
    private javax.swing.JPanel pnl_Item_3;
    private javax.swing.JPanel pnl_Item_4;
    private javax.swing.JPanel pnl_Item_5;
    private javax.swing.JPanel pnl_Item_6;
    private javax.swing.JPanel pnl_Item_7;
    private javax.swing.JPanel pnl_Item_8;
    private javax.swing.JPanel pnl_Itens;
    private javax.swing.JPanel pnl_Labels_Id;
    private javax.swing.JPanel pnl_PreCarrinho;
    private javax.swing.JTextField txt_Obs_1;
    private javax.swing.JTextField txt_Obs_2;
    private javax.swing.JTextField txt_Obs_3;
    private javax.swing.JTextField txt_Obs_4;
    private javax.swing.JTextField txt_Obs_5;
    private javax.swing.JTextField txt_Obs_6;
    private javax.swing.JTextField txt_Obs_7;
    private javax.swing.JTextField txt_Obs_8;
    private javax.swing.JTextArea txtarea_Desc_1;
    private javax.swing.JTextArea txtarea_Desc_2;
    private javax.swing.JTextArea txtarea_Desc_3;
    private javax.swing.JTextArea txtarea_Desc_4;
    private javax.swing.JTextArea txtarea_Desc_5;
    private javax.swing.JTextArea txtarea_Desc_6;
    private javax.swing.JTextArea txtarea_Desc_7;
    private javax.swing.JTextArea txtarea_Desc_8;
    // End of variables declaration//GEN-END:variables
}
