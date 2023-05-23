package br.digitalmenu.dao;

import br.digitalmenu.connection.ConnectionFactory;
import br.digitalmenu.model.relatorio.ItemRelatorio;
import br.digitalmenu.model.relatorio.PedidoRelatorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RelatorioDao {

    private Connection connection;

    public List<ItemRelatorio> listarItensPorMaiorFaturamento() throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        List<ItemRelatorio> listaItem = new ArrayList<>();
        ItemRelatorio item = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql
                = "SELECT p.idproduto, p.nome, p.preco, SUM(i.qtde) AS qtdeTotal, SUM(i.subtotal) AS valorTotal "
                + "FROM item i "
                + "INNER JOIN produto p "
                + "ON i.id_produto = p.idproduto "
                + "GROUP BY p.nome "
                + "ORDER BY SUM(i.subtotal) DESC";

        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                item = new ItemRelatorio();
                item.getProduto().setIdProduto(rs.getInt("p.idproduto"));
                item.getProduto().setNome(rs.getString("p.nome"));
                item.getProduto().setPreco(rs.getDouble("p.preco"));
                item.setQtdeTotalVendida(rs.getInt("qtdeTotal"));
                item.setValorTotalVendido(rs.getDouble("valorTotal"));
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

    public List<ItemRelatorio> listarItensMaisVendidos() throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        List<ItemRelatorio> listaItem = new ArrayList<>();
        ItemRelatorio item = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql
                = "SELECT p.idproduto, p.nome, p.preco, SUM(i.qtde) AS qtdeTotal, SUM(i.subtotal) AS valorTotal "
                + "FROM item i "
                + "INNER JOIN produto p "
                + "ON i.id_produto = p.idproduto "
                + "GROUP BY p.nome "
                + "ORDER BY SUM(i.qtde) DESC";

        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                item = new ItemRelatorio();
                item.getProduto().setIdProduto(rs.getInt("p.idproduto"));
                item.getProduto().setNome(rs.getString("p.nome"));
                item.getProduto().setPreco(rs.getDouble("p.preco"));
                item.setQtdeTotalVendida(rs.getInt("qtdeTotal"));
                item.setValorTotalVendido(rs.getDouble("valorTotal"));
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

    public ItemRelatorio listarItemQtdeVendidaPorItem(int idProduto) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        ItemRelatorio item = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql
                = "SELECT IFNULL(p.idproduto,)), p.nome, p.preco, SUM(i.qtde) AS qtdeTotal, SUM(i.subtotal) AS valorTotal "
                + "FROM item i "
                + "INNER JOIN produto p "
                + "ON i.id_produto = p.idproduto "
                + "WHERE p.idproduto = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, idProduto);
            rs = ps.executeQuery();
            while (rs.next()) {
                item = new ItemRelatorio();
                item.getProduto().setIdProduto(rs.getInt("p.idproduto"));
                item.getProduto().setNome(rs.getString("p.nome"));
                item.getProduto().setPreco(rs.getDouble("p.preco"));
                item.setQtdeTotalVendida(rs.getInt("qtdeTotal"));
                item.setValorTotalVendido(rs.getDouble("valorTotal"));
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

    public PedidoRelatorio totalPedidos() throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PedidoRelatorio pedido = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql
                = "SELECT COUNT(*) AS Total_Pedidos, SUM(total) AS Total_Vendido, AVG(total) AS Media_Pedido "
                + "FROM pedido";

        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pedido = new PedidoRelatorio();
                pedido.setQtdeDePedidos(rs.getInt("Total_Pedidos"));
                pedido.setValorTotal(rs.getDouble("Total_Vendido"));
                pedido.setMediaTotal(rs.getDouble("Media_Pedido"));
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return pedido;
    }

    public PedidoRelatorio totalPedidosPorMes(int mes) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PedidoRelatorio pedido = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql
                = "SELECT COUNT(*) AS Total_Pedidos, SUM(total) AS Total_Vendido, AVG(total) AS Media_Pedido "
                + "FROM pedido "
                + "WHERE MONTH(data) = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, mes);
            rs = ps.executeQuery();
            while (rs.next()) {
                pedido = new PedidoRelatorio();
                pedido.setQtdeDePedidos(rs.getInt("Total_Pedidos"));
                pedido.setValorTotal(rs.getDouble("Total_Vendido"));
                pedido.setMediaTotal(rs.getDouble("Media_Pedido"));
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return pedido;
    }

    //testando trazer todos itens do pedido group by
    public List<ItemRelatorio> listarItensPorPedidoAgrupado(int idPedido) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        List<ItemRelatorio> listaItemRelatorio = new ArrayList<>();
        ItemRelatorio itemRelatorio = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql
                = "SELECT p.nome, p.preco, SUM(i.qtde) AS qtde, (p.preco*SUM(i.qtde)) AS subtotal "
                + "FROM item i "
                + "INNER JOIN produto p "
                + "ON p.idproduto = i.id_produto "
                + "WHERE i.id_pedido = ? "
                + "GROUP BY i.id_produto";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, idPedido);
            rs = ps.executeQuery();
            while (rs.next()) {
                itemRelatorio = new ItemRelatorio();
                itemRelatorio.getProduto().setNome(rs.getString("p.nome"));
                itemRelatorio.getProduto().setPreco(rs.getDouble("p.preco"));
                itemRelatorio.setQtde(rs.getInt("qtde"));
                itemRelatorio.setSubtotal(rs.getDouble("subtotal"));
                listaItemRelatorio.add(itemRelatorio);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return listaItemRelatorio;
    }
}
