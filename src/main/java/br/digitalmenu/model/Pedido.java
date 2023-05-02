package br.digitalmenu.model;

public class Pedido {

    private int idPedido;
    private int id_Mesa;
    private double total;
    private String data;
    private String horario;
    private String status;

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getId_Mesa() {
        return id_Mesa;
    }

    public void setId_Mesa(int id_Mesa) {
        this.id_Mesa = id_Mesa;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorarioPedido() {
        return horario;
    }

    public void setHorarioPedido(String horarioPedido) {
        this.horario = horarioPedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
