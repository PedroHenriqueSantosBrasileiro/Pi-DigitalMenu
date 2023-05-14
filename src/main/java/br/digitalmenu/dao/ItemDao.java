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
            ps.setInt(1, item.getPedido().getIdPedido());
            ps.setInt(2, item.getProduto().getIdProduto());
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

        String sql = "SELECT p.idproduto, p.nome, p.preco, i.qtde, i.subtotal, TIME_FORMAT(horapedido, '%T') as horacomanda, i.status "
                + "FROM item i "
                + "INNER JOIN produto p "
                + "ON p.idproduto = i.id_produto "
                + "WHERE id_pedido = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, idPedido);
            rs = ps.executeQuery();

            while (rs.next()) {
                item = new Item();
                item.getProduto().setIdProduto(rs.getInt("p.idproduto"));
                item.getProduto().setNome(rs.getString("p.nome"));
                item.getProduto().setPreco(rs.getDouble("p.preco"));
                item.setQtde(rs.getInt("i.qtde"));
                item.setSubtotal(rs.getDouble("i.subtotal"));
                item.setHoraComanda(rs.getString("horacomanda"));
                item.setStatus(rs.getString("i.status"));
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
                item.getPedido().setIdPedido(rs.getInt("id_pedido"));
                item.getProduto().setIdProduto(rs.getInt("id_produto"));
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

}
