package br.digitalmenu.dao;

import br.digitalmenu.connection.ConnectionFactory;
import br.digitalmenu.model.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PedidoDao {

    private Connection connection;
    public int numeroPedido;
    public int numeroMesa;

    public void adicionarPedido(Pedido pedido) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "INSERT INTO pedido (idpedido, id_mesa, total, data, status) VALUES (null, ?, default, default, default)";

        try {
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pedido.getIdPedido());
            ps.execute();
            rs = ps.getGeneratedKeys();
            while (rs.next()) {
                numeroPedido = rs.getInt(1);
            }
            JOptionPane.showMessageDialog(null, "Pedido criado!, Nº: " + numeroPedido);
        } catch (SQLException ex) {
            throw ex;
        } finally {
            rs.close();
            ps.close();
            connection.close();
        }
    }

    public List<Pedido> listarPedido() throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        List<Pedido> listaDePedido = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT idpedido, id_mesa, total, DATE_FORMAT(data,'%d/%m/%Y') as data, DATE_FORMAT(data,'%H:%i:%s') as horario, status FROM PEDIDO";

        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idpedido"));
                pedido.getMesa().setIdMesa(rs.getInt("id_mesa"));
                pedido.setTotal(rs.getDouble("total"));
                pedido.setData(rs.getString("data"));
                pedido.setHorario(rs.getString("horario"));
                pedido.setStatus(rs.getString("status"));
                listaDePedido.add(pedido);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return listaDePedido;
    }

    public Pedido listarPedidoPorId(Integer p) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Pedido pedido = null;

        String sql = "SELECT idpedido, id_mesa, total, DATE_FORMAT(data,'%d/%m/%Y') as data, DATE_FORMAT(data,'%H:%i:%s') as horario, status FROM PEDIDO WHERE idpedido = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, p);
            rs = ps.executeQuery();

            while (rs.next()) {
                pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idpedido"));
                pedido.getMesa().setIdMesa(rs.getInt("id_mesa"));
                pedido.setTotal(rs.getDouble("total"));
                pedido.setData(rs.getString("data"));
                pedido.setHorario(rs.getString("horario"));
                pedido.setStatus(rs.getString("status"));
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

    public List<Pedido> listarPedidoPorMesa(Integer p) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Pedido> pedidos = new ArrayList<>();
        Pedido pedido = null;

        String sql = "SELECT idpedido, id_mesa, total, DATE_FORMAT(data,'%d/%m/%Y') as data, DATE_FORMAT(data,'%H:%i:%s') as horario, status FROM PEDIDO WHERE id_mesa = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, p);
            rs = ps.executeQuery();

            while (rs.next()) {
                pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idpedido"));
                pedido.getMesa().setIdMesa(rs.getInt("id_mesa"));
                pedido.setTotal(rs.getDouble("total"));
                pedido.setData(rs.getString("data"));
                pedido.setHorario(rs.getString("horario"));
                pedido.setStatus(rs.getString("status"));
                pedidos.add(pedido);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return pedidos;
    }

    public List<Pedido> listarPedidoPorStatus(String status) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Pedido> pedidos = new ArrayList<>();
        Pedido pedido = null;

        String sql = "SELECT idpedido, id_mesa, total, DATE_FORMAT(data,'%d/%m/%Y') as data, DATE_FORMAT(data,'%H:%i:%s') as horario, status FROM PEDIDO WHERE status = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, status);
            rs = ps.executeQuery();

            while (rs.next()) {
                pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idpedido"));
                pedido.getMesa().setIdMesa(rs.getInt("id_mesa"));
                pedido.setTotal(rs.getDouble("total"));
                pedido.setData(rs.getString("data"));
                pedido.setHorario(rs.getString("horario"));
                pedido.setStatus(rs.getString("status"));
                pedidos.add(pedido);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return pedidos;
    }

    public List<Pedido> listarProdutoPorFaixaDePreco(double valorInicial, double valorFinal) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Pedido> listaDePedidos = new ArrayList<>();

        String sql = "SELECT idpedido, id_mesa, total, DATE_FORMAT(data, '%d/%m/%Y') as data, DATE_FORMAT(data,'%H:%i:%s') as horario, status "
                + "FROM pedido "
                + "WHERE total BETWEEN ? and ? order by total";
        try {
            ps = connection.prepareStatement(sql);
            ps.setDouble(1, valorInicial);
            ps.setDouble(2, valorFinal);
            rs = ps.executeQuery();

            while (rs.next()) {
                Pedido p = new Pedido();
                p.setIdPedido(rs.getInt("idpedido"));
                p.getMesa().setIdMesa(rs.getInt("id_mesa"));
                p.setTotal(rs.getDouble("total"));
                p.setData(rs.getString("data"));
                p.setHorario(rs.getString("horario"));
                p.setStatus(rs.getString("status"));
                listaDePedidos.add(p);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return listaDePedidos;
    }

    public List<Pedido> listarProdutoPorDia(String data) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Pedido> listaDePedidos = new ArrayList<>();

        String sql = "SELECT idpedido, id_mesa, total, DATE_FORMAT(data, '%d/%m/%Y') as data, DATE_FORMAT(data,'%H:%i:%s') as horario, status "
                + "FROM pedido "
                + "WHERE DATE_FORMAT(data, '%d/%m/%Y') = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, data);
            rs = ps.executeQuery();

            while (rs.next()) {
                Pedido p = new Pedido();
                p.setIdPedido(rs.getInt("idpedido"));
                p.getMesa().setIdMesa(rs.getInt("id_mesa"));
                p.setTotal(rs.getDouble("total"));
                p.setData(rs.getString("data"));
                p.setHorario(rs.getString("horario"));
                p.setStatus(rs.getString("status"));
                listaDePedidos.add(p);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return listaDePedidos;
    }

    public List<Pedido> listarProdutoPorFaixaDia(String dataInicial, String dataFinal) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Pedido> listaDePedidos = new ArrayList<>();

        String sql = "SELECT idpedido, id_mesa, total, DATE_FORMAT(data, '%d/%m/%Y') as data, DATE_FORMAT(data,'%H:%i:%s') as horario, status "
                + "FROM pedido "
                + "WHERE DATE_FORMAT(data, '%d/%m/%Y') >= ? and DATE_FORMAT(data, '%d/%m/%Y') <= ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, dataInicial);
            ps.setString(2, dataFinal);
            rs = ps.executeQuery();

            while (rs.next()) {
                Pedido p = new Pedido();
                p.setIdPedido(rs.getInt("idpedido"));
                p.getMesa().setIdMesa(rs.getInt("id_mesa"));
                p.setTotal(rs.getDouble("total"));
                p.setData(rs.getString("data"));
                p.setHorario(rs.getString("horario"));
                p.setStatus(rs.getString("status"));
                listaDePedidos.add(p);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return listaDePedidos;
    }

    public void atualizaPedido(Pedido pedido) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;

        String sql = "UPDATE pedido p INNER JOIN item i "
                + "ON p.idpedido = i.id_pedido "
                + "SET p.total = (SELECT SUM(subtotal) FROM item WHERE id_pedido = ?), p.status = ? "
                + "WHERE p.idpedido = ? AND i.status = 'confirmado'";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, pedido.getIdPedido());
            ps.setString(2, pedido.getStatus());
            ps.setInt(3, pedido.getIdPedido());
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            connection.close();
        }
    }

    public boolean deletarPedido(int numeroMesaDeletar) throws SQLException {

        boolean deletado;
        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;

        String sql = "DELETE FROM pedido WHERE idpedido = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, numeroMesaDeletar);
            deletado = ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            connection.close();
        }
        return deletado;
    }

    public List<Pedido> vendasPorDia() {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        String sql = "select sum(total) as Total, date_format(data,'%d/%m/%Y')  as Data from pedido group by date_format(data,'%d/%m/%Y')";
        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement psmt = null;
        ResultSet rst = null;
        try {

            psmt = connection.prepareStatement(sql);
            psmt.execute();

            rst = psmt.getResultSet();

            while (rst.next()) {
                Pedido pedido = new Pedido();
                pedido.setTotal(rst.getDouble(1));
                pedido.setData(rst.getString(2));
                pedidos.add(pedido);
            }

            rst.close();
            psmt.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pedidos;
    }

}
