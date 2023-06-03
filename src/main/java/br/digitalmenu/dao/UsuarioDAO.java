package br.digitalmenu.dao;

import br.digitalmenu.connection.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import br.digitalmenu.model.Usuario;
import java.sql.Connection;

public class UsuarioDAO {

    private Connection connection;

    public List<Usuario> listaTodosOsUsuarios() throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Usuario> listaDeUsuarios = new ArrayList<>();

        String sql
                = "SELECT idusuario, usuario, senha, tipoacesso, status "
                + "FROM usuario;";

        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario user = new Usuario();
                user.setIdusuario(rs.getInt("idusuario"));
                user.setUsuario(rs.getString("usuario"));
                user.setSenha(rs.getString("senha"));
                user.setTipoacesso(rs.getString("tipoacesso"));
                user.setStatus(rs.getString("status"));
                listaDeUsuarios.add(user);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return listaDeUsuarios;
    }

    public void insereUsuario(Usuario user) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;

        String sql
                = "INSERT INTO usuario "
                + "(idusuario, usuario, senha, tipoacesso, status) "
                + "VALUES "
                + "(?, ?, ?, ?, ?)";

        try {
            ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, user.getIdusuario());
            ps.setString(2, user.getUsuario());
            ps.setString(3, user.getSenha());
            ps.setString(4, user.getTipoacesso());
            ps.setString(5, user.getStatus());
            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    user.setIdusuario(id);
                }
                rs.close();
            } else {
                throw new SQLException("Erro inesperado! Nenhuma linha afetada!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuário não foi criado!");
            System.out.println(e.getMessage());
        } finally {
            ps.close();
            connection.close();
        }
    }

    public boolean checkLogin(String usuario, String senha) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean check = false;

        String sql
                = "SELECT idusuario, usuario, senha, tipoacesso, status "
                + "FROM usuario "
                + "WHERE usuario = ? AND senha = ? AND status = 'ativado';";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, senha);
            rs = ps.executeQuery();
            if (rs.next()) {
                check = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            rs.close();
            ps.close();
            connection.close();
        }
        return check;
    }

    public Usuario buscaPorUsuario(String usuario, String senha) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Usuario user = null;

        String sql
                = "SELECT idusuario, usuario, senha, tipoacesso, status "
                + "FROM usuario "
                + "WHERE usuario = ? AND senha = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, senha);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new Usuario();
                user.setIdusuario(rs.getInt("idusuario"));
                user.setUsuario(rs.getString("usuario"));
                user.setSenha(rs.getString("senha"));
                user.setTipoacesso(rs.getString("tipoacesso"));
                user.setStatus(rs.getString("status"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            rs.close();
            ps.close();
            connection.close();
        }
        return user;
    }

    public Usuario buscaPorID(int idusuario, Usuario user) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql
                = "SELECT idusuario, usuario, senha, tipoacesso, status "
                + "FROM usuario "
                + "WHERE idusuario = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, idusuario);
            rs = ps.executeQuery();
            if (rs.next()) {
                user.setIdusuario(rs.getInt("idusuario"));
                user.setUsuario(rs.getString("usuario"));
                user.setSenha(rs.getString("senha"));
                user.setTipoacesso(rs.getString("tipoacesso"));
                user.setStatus(rs.getString("status"));
                return user;
            }
            return null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            rs.close();
            ps.close();
            connection.close();
        }
        return null;
    }

    public void atualizaUsuario(Usuario user) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;

        String sql
                = "UPDATE usuario "
                + "SET usuario = ?, senha = ?, tipoacesso = ?, status = ? "
                + "WHERE idusuario = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUsuario());
            ps.setString(2, user.getSenha());
            ps.setString(3, user.getTipoacesso());
            ps.setString(4, user.getStatus());
            ps.setInt(5, user.getIdusuario());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            ps.close();
            connection.close();
        }

    }

    public List<Usuario> listarUsuariosAtivos() throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        List<Usuario> listaDeUsuarios = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql
                = "SELECT idusuario, usuario, senha, tipoacesso, status "
                + "FROM  usuario "
                + "WHERE status = 'ativado'";

        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario user = new Usuario();
                user.setIdusuario(rs.getInt("idusuario"));
                user.setUsuario(rs.getString("usuario"));
                user.setSenha(rs.getString("senha"));
                user.setTipoacesso(rs.getString("tipoacesso"));
                user.setStatus(rs.getString("status"));
                listaDeUsuarios.add(user);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return listaDeUsuarios;
    }

    public List<Usuario> listarUsuariosPorStatus(String status) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        List<Usuario> listaDeUsuarios = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql
                = "SELECT idusuario, usuario, senha, tipoacesso, status "
                + "FROM  usuario "
                + "WHERE status = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, status);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario user = new Usuario();
                user.setIdusuario(rs.getInt("idusuario"));
                user.setUsuario(rs.getString("usuario"));
                user.setSenha(rs.getString("senha"));
                user.setTipoacesso(rs.getString("tipoacesso"));
                user.setStatus(rs.getString("status"));
                listaDeUsuarios.add(user);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return listaDeUsuarios;
    }

    public Usuario listarUsuariosPorId(int id) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;
        Usuario user = null;
        ResultSet rs = null;

        String sql
                = "SELECT idusuario, usuario, senha, tipoacesso, status "
                + "FROM  usuario "
                + "WHERE idusuario = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new Usuario();
                user.setIdusuario(rs.getInt("idusuario"));
                user.setUsuario(rs.getString("usuario"));
                user.setSenha(rs.getString("senha"));
                user.setTipoacesso(rs.getString("tipoacesso"));
                user.setStatus(rs.getString("status"));
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return user;
    }

    public List<Usuario> listarCategoriaPorNome(String texto) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        List<Usuario> listaDeUsuarios = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql
                = "SELECT idusuario, usuario, senha, tipoacesso, status "
                + "FROM  usuario "
                + "WHERE usuario LIKE CONCAT('%',?,'%')";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, texto);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario user = new Usuario();
                user.setIdusuario(rs.getInt("idusuario"));
                user.setUsuario(rs.getString("usuario"));
                user.setSenha(rs.getString("senha"));
                user.setTipoacesso(rs.getString("tipoacesso"));
                user.setStatus(rs.getString("status"));
                listaDeUsuarios.add(user);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return listaDeUsuarios;
    }

}
