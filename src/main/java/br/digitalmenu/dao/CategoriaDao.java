package br.digitalmenu.dao;

import br.digitalmenu.connection.ConnectionFactory;
import br.digitalmenu.model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDao {

    private Connection connection;

    public void criarCategoria(Categoria categoria) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;
        
        String sql
                = "INSERT INTO categoria (idcategoria, nome, status) "
                + "VALUES (NULL, ?, DEFAULT)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, categoria.getNomeCategoria());
            ps.execute();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            connection.close();
        }
    }

    public List<Categoria> listarCategoria() throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        List<Categoria> listaDeCategorias = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql 
                = "SELECT idcategoria, nome, status "
                + "FROM categoria";

        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("idcategoria"));
                categoria.setNomeCategoria(rs.getString("nome"));
                categoria.setStatus(rs.getString("status"));
                listaDeCategorias.add(categoria);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return listaDeCategorias;
    }

    public List<Categoria> listarCategoriasAtivas() throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        List<Categoria> listaDeCategorias = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql 
                = "SELECT idcategoria, nome, status "
                + "FROM categoria "
                + "WHERE status = 'ativado'";

        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("idcategoria"));
                categoria.setNomeCategoria(rs.getString("nome"));
                categoria.setStatus(rs.getString("status"));
                listaDeCategorias.add(categoria);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return listaDeCategorias;
    }

    public List<Categoria> listarCategoriasPorStatus(String status) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        List<Categoria> listaDeCategorias = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql 
                = "SELECT idcategoria, nome, status "
                + "FROM categoria "
                + "WHERE status = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, status);
            rs = ps.executeQuery();
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("idcategoria"));
                categoria.setNomeCategoria(rs.getString("nome"));
                categoria.setStatus(rs.getString("status"));
                listaDeCategorias.add(categoria);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return listaDeCategorias;
    }

    public void updateCategoria(Categoria categoria, Integer idCategoriaInicial) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;

        String sql
                = "UPDATE categoria "
                + "SET idcategoria = ?, nome = ?, status = ? "
                + "WHERE idcategoria = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, categoria.getIdCategoria());
            ps.setString(2, categoria.getNomeCategoria());
            ps.setString(3, categoria.getStatus());
            ps.setInt(4, idCategoriaInicial);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            connection.close();
        }
    }

    public Categoria listarCategoriaPorId(int id) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;
        Categoria categoria = null;
        ResultSet rs = null;

        String sql 
                = "SELECT idcategoria, nome, status "
                + "FROM categoria "
                + "WHERE idcategoria = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("idcategoria"));
                categoria.setNomeCategoria(rs.getString("nome"));
                categoria.setStatus(rs.getString("status"));
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return categoria;
    }

    public List<Categoria> listarCategoriaPorNome(String texto) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        List<Categoria> listaDeCategorias = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql 
                = "SELECT idcategoria, nome, status "
                + "FROM categoria "
                + "WHERE nome LIKE CONCAT('%',?,'%')";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, texto);
            rs = ps.executeQuery();
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("idcategoria"));
                categoria.setNomeCategoria(rs.getString("nome"));
                categoria.setStatus(rs.getString("status"));
                listaDeCategorias.add(categoria);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return listaDeCategorias;
    }

    public void deleteCategoria(Categoria categoria) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;

        String sql 
                = "UPDATE categoria "
                + "SET status = 'Desativado' "
                + "WHERE idcategoria = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, categoria.getIdCategoria());
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            connection.close();
        }
    }
}
