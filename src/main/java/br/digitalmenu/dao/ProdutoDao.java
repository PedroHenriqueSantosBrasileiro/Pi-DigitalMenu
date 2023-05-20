package br.digitalmenu.dao;

import br.digitalmenu.connection.ConnectionFactory;
import br.digitalmenu.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao {

    private Connection connection;

    public void createProduto(Produto p) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;

        String sql = "INSERT INTO produto (nome, preco, descricao, id_categoria, status)"
                + "VALUES (?, ?, ?, (SELECT idcategoria FROM categoria WHERE nome = ?), default)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, p.getNome());
            ps.setDouble(2, p.getPreco());
            ps.setString(3, p.getDescricao());
            ps.setString(4, p.getCategoria().getNomeCategoria());
            ps.execute();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            connection.close();
        }
    }

    public List<Produto> listarProduto() throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Produto> listaDeProdutos = new ArrayList<>();

        String sql = "SELECT p.idproduto, p.nome, c.nome, p.preco, p.descricao, p.status, p.id_categoria "
                + "FROM produto p "
                + "INNER JOIN categoria c "
                + "ON p.id_categoria = c.idcategoria";

        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setIdProduto(rs.getInt("p.idproduto"));
                p.setNome(rs.getString("p.nome"));
                p.setPreco(rs.getDouble("p.preco"));
                p.setDescricao(rs.getString("p.descricao"));
                p.getCategoria().setIdCategoria(rs.getInt("p.id_categoria"));
                p.setStatus(rs.getString("p.status"));
                p.getCategoria().setNomeCategoria(rs.getString("c.nome"));
                listaDeProdutos.add(p);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return listaDeProdutos;
    }

    public List<Produto> listarProdutosAtivos() throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Produto> listaDeProdutos = new ArrayList<>();

        String sql = "SELECT p.idproduto, p.nome, c.nome, p.preco, p.descricao, p.status, p.id_categoria "
                + "FROM produto p "
                + "INNER JOIN categoria c "
                + "ON p.id_categoria = c.idcategoria "
                + "WHERE p.status = 'ativado'";

        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setIdProduto(rs.getInt("p.idproduto"));
                p.setNome(rs.getString("p.nome"));
                p.setPreco(rs.getDouble("p.preco"));
                p.setDescricao(rs.getString("p.descricao"));
                p.getCategoria().setIdCategoria(rs.getInt("p.id_categoria"));
                p.setStatus(rs.getString("p.status"));
                p.getCategoria().setNomeCategoria(rs.getString("c.nome"));
                listaDeProdutos.add(p);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return listaDeProdutos;
    }

    public Produto listarProdutoPorId(Integer idProduto) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Produto p = null;
        String sql = "SELECT p.idproduto, p.nome, c.nome, p.preco, p.descricao, p.status, p.id_categoria "
                + "FROM produto p "
                + "INNER JOIN categoria c "
                + "ON p.id_categoria = c.idcategoria "
                + "WHERE p.idproduto = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, idProduto);
            rs = ps.executeQuery();
            while (rs.next()) {
                p = new Produto();
                p.setIdProduto(rs.getInt("p.idproduto"));
                p.setNome(rs.getString("p.nome"));
                p.setPreco(rs.getDouble("p.preco"));
                p.setDescricao(rs.getString("p.descricao"));
                p.getCategoria().setIdCategoria(rs.getInt("p.id_categoria"));
                p.setStatus(rs.getString("p.status"));
                p.getCategoria().setNomeCategoria(rs.getString("c.nome"));
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return p;
    }

    public void alterarProduto(Produto p) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;

        String sql = "UPDATE produto SET "
                + "nome = ?, "
                + "preco = ?, "
                + "descricao = ?, "
                + "id_categoria = (SELECT idcategoria FROM categoria WHERE nome = ?), "
                + "status = ? "
                + "WHERE idproduto = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, p.getNome());
            ps.setDouble(2, p.getPreco());
            ps.setString(3, p.getDescricao());
            ps.setString(4, p.getCategoria().getNomeCategoria());
            ps.setString(5, p.getStatus());
            ps.setInt(6, p.getIdProduto());
            ps.executeUpdate();

        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            connection.close();
        }
    }

    public void deletaProduto(Produto p) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;

        String sql = "UPDATE PRODUTO SET STATUS = 'desativado' where idproduto = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, p.getIdProduto());
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            connection.close();
        }
    }

    public List<Produto> listarProdutoPorNome(String texto) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Produto> listaDeProdutos = new ArrayList<>();

        String sql = "SELECT p.idproduto, p.nome, c.nome, p.preco, p.descricao, p.status, p.id_categoria "
                + "FROM produto p "
                + "INNER JOIN categoria c "
                + "ON p.id_categoria = c.idcategoria "
                + "WHERE p.nome LIKE CONCAT('%',?,'%')";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, texto);
            rs = ps.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setIdProduto(rs.getInt("p.idproduto"));
                p.setNome(rs.getString("p.nome"));
                p.setPreco(rs.getDouble("p.preco"));
                p.setDescricao(rs.getString("p.descricao"));
                p.setStatus(rs.getString("p.status"));
                p.getCategoria().setNomeCategoria(rs.getString("c.nome"));
                listaDeProdutos.add(p);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return listaDeProdutos;
    }

    public List<Produto> listarProdutoPorFaixaDePreco(double valorInicial, double valorFinal) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Produto> listaDeProdutos = new ArrayList<>();

        String sql = "SELECT p.idproduto, p.nome, c.nome, p.preco, p.descricao, p.status, p.id_categoria "
                + "FROM produto p "
                + "INNER JOIN categoria c "
                + "ON p.id_categoria = c.idcategoria "
                + "WHERE p.preco BETWEEN ? and ? order by p.preco";

        try {
            ps = connection.prepareStatement(sql);
            ps.setDouble(1, valorInicial);
            ps.setDouble(2, valorFinal);
            rs = ps.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setIdProduto(rs.getInt("p.idproduto"));
                p.setNome(rs.getString("p.nome"));
                p.setPreco(rs.getDouble("p.preco"));
                p.setDescricao(rs.getString("p.descricao"));
                p.getCategoria().setIdCategoria(rs.getInt("p.id_categoria"));
                p.setStatus(rs.getString("p.status"));
                p.getCategoria().setNomeCategoria(rs.getString("c.nome"));
                listaDeProdutos.add(p);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return listaDeProdutos;
    }

    public List<Produto> listarProdutoPorDescricacao(String palavra) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Produto> listaDeProdutos = new ArrayList<>();

        String sql = "SELECT p.idproduto, p.nome, c.nome, p.preco, p.descricao, p.status, p.id_categoria "
                + "FROM produto p "
                + "INNER JOIN categoria c "
                + "ON p.id_categoria = c.idcategoria "
                + "WHERE p.descricao LIKE CONCAT('%', ?, '%')";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, palavra);
            rs = ps.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setIdProduto(rs.getInt("p.idproduto"));
                p.setNome(rs.getString("p.nome"));
                p.setPreco(rs.getDouble("p.preco"));
                p.setDescricao(rs.getString("p.descricao"));
                p.getCategoria().setIdCategoria(rs.getInt("p.id_categoria"));
                p.setStatus(rs.getString("p.status"));
                p.getCategoria().setNomeCategoria(rs.getString("c.nome"));
                listaDeProdutos.add(p);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return listaDeProdutos;
    }

    public List<Produto> listarProdutoPorCategoria(String nomeCategoria) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Produto> listaDeProdutos = new ArrayList<>();

        String sql = "SELECT p.idproduto, p.nome, c.nome, p.preco, p.descricao, p.status, p.id_categoria "
                + "FROM produto p "
                + "INNER JOIN categoria c "
                + "ON p.id_categoria = c.idcategoria "
                + "WHERE c. nome = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, nomeCategoria);
            rs = ps.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setIdProduto(rs.getInt("p.idproduto"));
                p.setNome(rs.getString("p.nome"));
                p.setPreco(rs.getDouble("p.preco"));
                p.setDescricao(rs.getString("p.descricao"));
                p.getCategoria().setIdCategoria(rs.getInt("p.id_categoria"));
                p.setStatus(rs.getString("p.status"));
                p.getCategoria().setNomeCategoria(rs.getString("c.nome"));
                listaDeProdutos.add(p);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return listaDeProdutos;
    }

    public List<Produto> listarProdutoPorStatus(String status) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Produto> listaDeProdutos = new ArrayList<>();

        String sql = "SELECT p.idproduto, p.nome, c.nome, p.preco, p.descricao, p.status, p.id_categoria "
                + "FROM produto p "
                + "INNER JOIN categoria c "
                + "ON p.id_categoria = c.idcategoria "
                + "WHERE p.status = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, status);
            rs = ps.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setIdProduto(rs.getInt("p.idproduto"));
                p.setNome(rs.getString("p.nome"));
                p.setPreco(rs.getDouble("p.preco"));
                p.setDescricao(rs.getString("p.descricao"));
                p.getCategoria().setIdCategoria(rs.getInt("p.id_categoria"));
                p.setStatus(rs.getString("p.status"));
                p.getCategoria().setNomeCategoria(rs.getString("c.nome"));
                listaDeProdutos.add(p);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return listaDeProdutos;
    }
}
