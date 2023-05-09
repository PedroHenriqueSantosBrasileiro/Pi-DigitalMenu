package br.digitalmenu.model;

public class Item {

    private int id_pedido;
    private int id_produto;
    private int qtde;
    private double subtotal;
    private String observacao;
    private String status;
    private String horaComanda;


    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
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
        return horaComanda;
    }

    public void setHoraComanda(String horaComanda) {
        this.horaComanda = horaComanda;
    }

 
       
    

}
