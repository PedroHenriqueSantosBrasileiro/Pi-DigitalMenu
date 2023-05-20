package br.digitalmenu.heuristicas;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.JTextComponent;

public abstract class Heuristica extends javax.swing.JFrame {

    Border bordaPadrao = new javax.swing.JTextField().getBorder();

    public boolean verificarSeCampoEstaEmBranco(JTextComponent componente, String nomeCampo) {

        if (componente.getText().equals("")) {
            componente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
            JOptionPane.showMessageDialog(null, "Campo " + nomeCampo + " em branco");

            return false;
        } else {
            componente.setBorder(bordaPadrao);
            return true;
        }

    }
    

    public void IniciaTabela(JTable tabela) throws SQLException {
        //centraliza o Header
        TableCellRenderer rendererFromHeader = tabela.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        tabela.setSelectionBackground(Color.DARK_GRAY);
        //tabela

        //Centraliza os campos
        DefaultTableCellRenderer centroRender = new DefaultTableCellRenderer();
        centroRender.setHorizontalAlignment(JLabel.CENTER); //Alinha ao centro
        TableModel modelo = tabela.getModel();
        tabela.setRowSorter(new TableRowSorter(modelo));

        for (int columnIndex = 0; columnIndex < modelo.getColumnCount(); columnIndex++) {
            tabela.getColumnModel().getColumn(columnIndex).setCellRenderer(centroRender);
        }
    }

    public class CorDoCabecalho extends DefaultTableCellRenderer {

        public CorDoCabecalho() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);

            setBackground(new java.awt.Color(227, 83, 53));//COR DO HEADER
            return this;
        }

    }

    public void letrasApenas(JTextComponent texto, KeyEvent evt) {
        char c = evt.getKeyChar();
        if (Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
            texto.setEditable(true);
        } else {
            texto.setEditable(false);
        }
    }

}
