package br.digitalmenu.model.relatorio;

import br.digitalmenu.model.Pedido;

public class PedidoRelatorio extends Pedido {

    private int qtdeDePedidos;
    private double mediaTotal;
    private double valorTotal;

    public int getQtdeDePedidos() {
        return qtdeDePedidos;
    }

    public void setQtdeDePedidos(int qtdeDePedidos) {
        this.qtdeDePedidos = qtdeDePedidos;
    }

    public double getMediaTotal() {
        return mediaTotal;
    }

    public void setMediaTotal(double mediaTotal) {
        this.mediaTotal = mediaTotal;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

}
