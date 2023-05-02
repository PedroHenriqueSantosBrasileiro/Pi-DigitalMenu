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

        String sql = "INSERT INTO categoria (nome)"
                + "VALUES (?)";
        PreparedStatement ps = null;

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

        String sql = "SELECT * FROM categoria";

        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("idcategoria"));
                categoria.setNomeCategoria(rs.getString("nome"));
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

        String sql = "UPDATE categoria SET idcategoria = ?, nome = ?"
                + "WHERE idcategoria = ?";
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, categoria.getIdCategoria());
            ps.setString(2, categoria.getNomeCategoria());
            ps.setInt(3, idCategoriaInicial);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            connection.close();
        }
    }

    public void deleteCategoria(Categoria categoria) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;

        String sql = "DELETE FROM categoria WHERE idcategoria = ?";

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
