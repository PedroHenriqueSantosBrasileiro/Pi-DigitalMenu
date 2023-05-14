package br.digitalmenu.model;

public class Item {

    private Pedido pedido = new Pedido();
    private Produto produto = new Produto();
    private int qtde;
    private double subtotal;
    private String observacao;
    private String status;
    private String horaPedido;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHoraComanda() {
        return horaPedido;
    }

    public void setHoraComanda(String horaComanda) {
        this.horaPedido = horaComanda;
    }

}
