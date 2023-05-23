package br.digitalmenu.dao;

import br.digitalmenu.connection.ConnectionFactory;
import br.digitalmenu.model.Mesa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MesaDao {

    private Connection connection;

    public boolean criarMesa(Mesa mesa) throws SQLException {

        boolean criouMesa;
        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;

        String sql
                = "INSERT INTO mesa (idmesa, status) "
                + "VALUES (?, DEFAULT)";

        try {
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, mesa.getIdMesa());
            ps.execute();
            criouMesa = true;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            connection.close();
        }
        return criouMesa;
    }

    public List<Mesa> listarTodasMesas() throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        ResultSet rs = null;
        List<Mesa> mesas = new ArrayList<>();
        PreparedStatement ps = null;

        String sql 
                = "SELECT idmesa, status "
                + "FROM MESA";

        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mesa mesa = new Mesa();
                mesa.setIdMesa(rs.getInt("IDMESA"));
                mesa.setStatus(rs.getString("STATUS"));
                mesas.add(mesa);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return mesas;
    }

    public List<Mesa> listarTodasMesasPorStatus(String status) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        ResultSet rs = null;
        List<Mesa> mesas = new ArrayList<>();
        PreparedStatement ps = null;

        String sql 
                = "SELECT idmesa, status "
                + "FROM mesa "
                + "WHERE status = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, status);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mesa mesa = new Mesa();
                mesa.setIdMesa(rs.getInt("IDMESA"));
                mesa.setStatus(rs.getString("STATUS"));
                mesas.add(mesa);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return mesas;
    }

    public Mesa listarMesaPorId(int numeroMesa) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        ResultSet rs = null;
        Mesa mesa = null;
        PreparedStatement ps = null;

        String sql 
                = "SELECT idmesa, status "
                + "FROM MESA "
                + "WHERE idmesa = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, numeroMesa);
            rs = ps.executeQuery();
            while (rs.next()) {
                mesa = new Mesa();
                mesa.setIdMesa(rs.getInt("IDMESA"));
                mesa.setStatus(rs.getString("STATUS"));
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return mesa;
    }

    public void updateMesa(Mesa mesa, Integer idMesaParaAlterar) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;

        String sql
                = "UPDATE mesa "
                + "SET IDMESA = ?, STATUS = ? "
                + "WHERE IDMESA = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, mesa.getIdMesa());
            ps.setString(2, mesa.getStatus());
            ps.setInt(3, idMesaParaAlterar);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            connection.close();
        }
    }

    public void deletaMesa(int idMesa) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;

        String sql 
                = "UPDATE mesa "
                + "SET status = 'desativado' "
                + "WHERE IDMESA = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, idMesa);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            connection.close();
        }
    }

    public boolean checkMesa(int idMesa) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        ResultSet resultado = null;
        PreparedStatement ps = null;
        boolean check = false;

        String sql 
                = "SELECT idmesa, status "
                + "FROM mesa "
                + "WHERE idmesa = ? AND status = 'ativado'";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, idMesa);
            resultado = ps.executeQuery();
            if (resultado.next()) {
                check = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            resultado.close();
            ps.close();
            connection.close();
        }
        return check;
    }
}
