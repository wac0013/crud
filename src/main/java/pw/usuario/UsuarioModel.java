package pw.usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioModel {

  private static Connection obterConexao() throws SQLException {
    //Estabelecer uma conexão com o banco de dados.
    String url = "jdbc:derby://localhost:1527/vendadb;create=true";
    String user = "app";
    String password = "app";
    return DriverManager.getConnection(url, user, password);
  }

  public static void incluir(Usuario venda) throws SQLException {
    Connection conn = obterConexao();
    
    //Obter sentença SQL.
    String sql = "insert into venda (codigo, produto, quantidade) values (?, ?, ?)";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, venda.getLogin());
    pstmt.setString(2, venda.getSenha());
    pstmt.setString(3, venda.getNome());
    pstmt.setString(3, venda.getEmail());
    pstmt.execute();
  }

  public static void salvar(Usuario user) throws SQLException {
    Connection conn = obterConexao();

    //Obter sentença SQL.
    String sql = "update venda set nome = ?, senha = ?, email = ? where login = ?";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, user.getNome());
    pstmt.setString(2, user.getSenha());
    pstmt.setString(3, user.getEmail());
    pstmt.setString(4, user.getLogin());
    pstmt.execute();
  }

  public static List<Usuario> listar() throws SQLException {
    Connection conn = obterConexao();
    
    Statement stmt = conn.createStatement();
    String sql = "select codigo, produto, quantidade from venda order by codigo";
    ResultSet rs = stmt.executeQuery(sql);
  
    List<Usuario> listaDeUsuarios = new ArrayList<Usuario>();
    while (rs.next()) {
      // Cria um venda para o registro.
      Usuario user = new Usuario();
      user.setLogin(rs.getString("login"));
      user.setSenha(rs.getString("senha"));
      user.setNome(rs.getString("nome"));
      user.setEmail(rs.getString("email"));
      // Adiciona o venda na lista de vendas.
      listaDeUsuarios.add(user);
    }
    return listaDeUsuarios;
  }

  public static void excluir(Usuario user) throws SQLException {
    Connection conn = obterConexao();
    
    //Obter sentença SQL.
    String sql = "delete from venda where codigo = ?";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, user.getLogin());
    pstmt.execute();
  }

}
