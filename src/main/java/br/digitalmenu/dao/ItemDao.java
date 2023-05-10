package br.digitalmenu.dao;

import br.digitalmenu.connection.ConnectionFactory;
import br.digitalmenu.model.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDao {

    private Connection connection;

    public void adicionaItens(Item item) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;
        String sql = "INSERT INTO item (id_pedido, id_produto, qtde, subtotal, observacao) "
                + "VALUES (?, ?, ?, ?, ?)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, item.getId_pedido());
            ps.setInt(2, item.getId_produto());
            ps.setInt(3, item.getQtde());
            ps.setDouble(4, item.getSubtotal());
            ps.setString(5, item.getObservacao());
            ps.execute();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            connection.close();
        }

    }

    public List<Item> listarItensPorPedido(int idPedido) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        List<Item> listaItem = new ArrayList<>();
        Item item = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT id_pedido, id_produto, qtde, subtotal, TIME_FORMAT(horapedido, '%T') as horapedido, status FROM item WHERE id_pedido = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, idPedido);
            rs = ps.executeQuery();

            while (rs.next()) {
                item = new Item();
                item.setId_pedido(rs.getInt("id_pedido"));
                item.setId_produto(rs.getInt("id_produto"));
                item.setQtde(rs.getInt("qtde"));
                item.setSubtotal(rs.getDouble("subtotal"));
                item.setHoraComanda(rs.getString("horapedido"));
                item.setStatus(rs.getString("status"));
                listaItem.add(item);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return listaItem;
    }

    public Item listarItensPorId(int idPedido) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        Item item = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT id_pedido, id_produto, qtde, subtotal, horapedido, status FROM item WHERE id_pedido = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, idPedido);
            rs = ps.executeQuery();

            while (rs.next()) {
                item = new Item();
                item.setId_pedido(rs.getInt("id_pedido"));
                item.setId_produto(rs.getInt("id_produto"));
                item.setQtde(rs.getInt("qtde"));
                item.setSubtotal(rs.getDouble("subtotal"));
                item.setHoraComanda("horapedido");
                item.setStatus(rs.getString("status"));
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return item;
    }
/*
     TESTE- COLOCAR NO MODEL ITEM NOME, PRECO E TOTALQTDE
    public Item listarItensQtdeTotalVendidaPorId(int idProduto) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        Item item = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT i.id_produto, p.nome, p.preco, SUM(i.qtde) as qtdeTotal FROM item i "
                     +"INNER JOIN produto p "
                     +"ON i.id_produto = p.idproduto "
                     +"WHERE p.idproduto = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, idProduto);
            rs = ps.executeQuery();

            while (rs.next()) {
                item = new Item();
                //item.setId_pedido(rs.getInt("id_pedido"));
                item.setId_produto(rs.getInt("id_produto"));
                item.setNome(rs.getString("p.nome"));
                item.setPreco(rs.getDouble("p.preco"));
                item.setTotalVendido(rs.getInt("qtdeTotal"));
                // item.setSubtotal(rs.getDouble("subtotal"));
                //item.setHoraComanda("horapedido");
                //item.setStatus(rs.getString("status"));
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return item;
    }*/
    
}
