package br.digitalmenu.model;

public class Produto {

    private int idProduto;
    private String nome;
    private double preco;
    private String descricao;
    private int idCategoria;
    private String status;
    private String nomeCategoria;

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    @Override
    public String toString() {
        String a
                = this.idProduto + " " 
                + this.nome 
                + " " 
                + this.preco + " " 
                + this.descricao 
                + " " 
                + this.idCategoria 
                + " " + this.status 
                + " " + this.nomeCategoria;
        return a;
    }

}
