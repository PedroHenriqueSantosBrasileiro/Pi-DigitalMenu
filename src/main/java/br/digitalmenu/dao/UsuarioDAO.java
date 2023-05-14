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

        String sql = "select * from usuario;";

        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Usuario user = new Usuario();

                user.setIdusuario(rs.getInt("idusuario")); // Define id do usuario
                user.setUsuario(rs.getString("usuario")); // Define login do usuario
                user.setSenha(rs.getString("senha")); // Define senha do usuario               
                user.setTipoacesso(rs.getString("tipoacesso"));
                user.setStatus(rs.getString("status"));
                // Insere o usuario na lista Local
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

        try {
            String sql = "";
            sql += "";
            sql += "INSERT INTO usuario"
                    + "(idusuario, usuario, senha, tipoacesso, status)" //5 VALORES
                    + "VALUES"
                    + "(?, ?, ?, ?, ?)"; //4 INTERROGAÇOES

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

    public boolean checkLogin(String usuario, String senha) throws SQLException {//obtem pizza pelo codigo do atendente

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;

        boolean check = false;

        try {
            // Comando SQL na base = tabela de usuario
            String sql = "select * from usuario WHERE usuario = ? AND senha = ? AND STATUS = 'ATIVADO';";

            //Executa a query (comando SQL)
            ps = connection.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, senha);

            rs = ps.executeQuery();

            //Para cada item retornado no comando (SQL) faça...
            if (rs.next()) {
                check = true;
            }

        } catch (SQLException e) { //Caso dê alguma exceção
            System.out.println(e.getMessage());
            return false;
        } finally {
            // Após terminar, fecha a conexão, stmt, rs
            rs.close();
            ps.close();
            connection.close();
        }
        return check;
    }

    public List<Usuario> buscaPorUsuario(String usuario) throws SQLException {//obtem pizza pelo codigo do atendente

        //Conecta ao banco de dados por meio da classe de conexão
        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;

        //Prepara a lista de carros para retornar
        List<Usuario> ListaDeUsuarios = new ArrayList<>();

        try {
            // Comando SQL na base = tabela de usuarios
            String sql = "select * from usuario WHERE usuario LIKE ?;";

            //Executa a query (comando SQL)
            ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + usuario + "%");
            rs = ps.executeQuery();

            //Para cada item retornado no comando (SQL) faça...
            while (rs.next()) {
                Usuario user = new Usuario(); //Criando uma instância, novo usuario na memória

                user.setIdusuario(rs.getInt("idusuario"));
                user.setUsuario(rs.getString("usuario"));
                user.setSenha(rs.getString("senha"));
                user.setTipoacesso(rs.getString("tipoacesso"));
                user.setStatus(rs.getString("status"));

                // Insere o usuario na lista Local
                ListaDeUsuarios.add(user);
            }

            // Retorna a lista de usuarios
            return ListaDeUsuarios;
        } catch (SQLException e) { //Caso dê alguma exceção
            System.out.println(e.getMessage());
            return null;
        } finally {
            // Após terminar, fecha a conexão, stmt, rs
            rs.close();
            ps.close();
            connection.close();
        }
    }

    public Usuario buscaPorID(int idusuario, Usuario user) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "";
            sql += "";
            sql += "SELECT * from usuario "
                    + "WHERE idusuario = ?";

            //define query sql
            ps = connection.prepareStatement(sql);

            //definindo o que foi recuperado da query, neste caso o id
            ps.setInt(1, idusuario);
            rs = ps.executeQuery();//Retorna os dados em modo de tabela

            if (rs.next()) { //testa se veio algum resultado

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

        try {
            String sql = "";
            sql += "";
            sql += "UPDATE usuario " //ATUALIZA PIZZA ONDE ID PIZZA FOR X
                    + "SET usuario = ?, senha = ?, tipoacesso = ?, status = ? "
                    + "WHERE idusuario = ?";

            //objeto de instrucao sql
            ps = connection.prepareStatement(sql);

            //definindo a parametrizacao dos objetos a serem alterados no banco
            ps.setString(1, user.getUsuario());
            ps.setString(2, user.getSenha());
            ps.setString(3, user.getTipoacesso());
            ps.setString(4, user.getStatus());
            ps.setInt(5, user.getIdusuario());

            //Executa a atualizacao
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            ps.close();
            connection.close();
        }

    }

}
