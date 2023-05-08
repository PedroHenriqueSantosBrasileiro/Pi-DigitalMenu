package br.digitalmenu.heuristicas;

import javax.swing.JOptionPane;
import javax.swing.border.Border;
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

}
