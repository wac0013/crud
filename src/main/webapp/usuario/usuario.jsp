<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="pw.usuario.Usuario"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Crud Usuario</title>
</head>
<body style="margin-top: 15px">
  <div class="container">
    <div class="row">
      <div class="col-md-offset-2 col-md-8">
        <ol class="breadcrumb">
          <li><a href="/">Menu</a></li>
          <li class="active">Usuario</li>
        </ol>
        <div class="panel panel-default">
          <div class="panel-body">
            <form>
              <div class="form-group">
                <input
                  name="login"
                  value="${param.login}"
                  type="text"
                  placeholder="Login"
                  class="form-control">
              </div>
              <div class="form-group">
                <input
                  name="email"
                  value="${param.email}"
                  type="text"
                  placeholder="Email"
                  class="form-control">
              </div>
              <div class="form-group">
                <input
                  name="nome"
                  value="${param.nome}"
                  type="text"
                  placeholder="Nome"
                  class="form-control">
              </div>
              <div class="form-group">
                <input
                  name="senha"
                  value="${param.senha}"
                  type="password"
                  placeholder="Senha"
                  class="form-control">
              </div>
              <div class="form-group">
                <input
                  name="senha-confirmar"
                  value="${param.senha-confirmar}"
                  type="password"
                  placeholder="Confirmar Senha"
                  class="form-control">
              </div>
              <button name="op" value="incluir" class="btn btn-default">Incluir</button>
              <button name="op" value="salvar" class="btn btn-default">Salvar</button>
              <button name="op" value="excluir" class="btn btn-default">Excluir</button>
            </form>
          </div>
        </div>
        <table class="table table-bordered table-striped">
          <tr>
            <td>Login</td>
            <td>Email</td>
            <td>Nome</td>
            <td>#</td>
          </tr>
          <%
          List<Usuario> vendas = (List<Usuario>) request.getAttribute("usuarios");
          for (Usuario u:usuarios) {
          %>
            <tr>
              <td><a href="usuario?login=<%=u.getLogin()%>&email=<%=u.getEmail()%>&nome=<%=u.getNome()%>"><%=u.getLogin()%></a></td>
              <td><%=u.getLogin()%></td>
              <td><%=u.getEmail()%></td>
              <td><%=u.getNome()%></td>
              <td><a href="venda?op=excluir&codigo=<%=u.getLogin()%>">Excluir</a></td>
            </tr>
          <%
          }
          %>
        </table>
      </div>
    </div>
  </div>
</body>
</html>