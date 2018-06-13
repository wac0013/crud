package pw.usuario;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pw.usuario.Usuario;
import pw.usuario.UsuarioModel;

@WebServlet(value = "/usuario/venda")
public class UsuarioController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    String op = request.getParameter("op");
    op = (op == null ? "" : op);

    Usuario user = new Usuario();
    user.setLogin(request.getParameter("login"));
    user.setSenha(request.getParameter("senha"));
    user.setNome(request.getParameter("nome"));
    user.setEmail(request.getParameter("email"));
    

    List<Usuario> usuarios = null;
    
    try {
      if (op.equals("incluir")) {
        UsuarioModel.incluir(user);
      } else if (op.equals("salvar")) {
    	UsuarioModel.salvar(user);
      } else if (op.equals("excluir")) {
    	UsuarioModel.excluir(user);
      }

      usuarios = UsuarioModel.listar();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    
    //Adiciona a variável na requisição para o JSP trabalhar.
    request.setAttribute("usuarios", usuarios);

    //Redireciona requisição para o JSP.
    request.
      getRequestDispatcher("/usuario/usuario.jsp").
      forward(request, response);
  }
}

