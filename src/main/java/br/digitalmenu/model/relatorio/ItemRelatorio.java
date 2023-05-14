package br.digitalmenu.model.relatorio;

import br.digitalmenu.model.Item;

public class ItemRelatorio extends Item {

    private int qtdeTotalVendida;
    private double valorTotalVendido;

    public int getQtdeTotalVendida() {
        return qtdeTotalVendida;
    }

    public void setQtdeTotalVendida(int qtdeTotalVendida) {
        this.qtdeTotalVendida = qtdeTotalVendida;
    }

    public double getValorTotalVendido() {
        return valorTotalVendido;
    }

    public void setValorTotalVendido(double valorTotalVendido) {
        this.valorTotalVendido = valorTotalVendido;
    }

}
