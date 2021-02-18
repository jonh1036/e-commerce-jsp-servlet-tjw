
package com.ecommerce.controllers.usuario;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerce.dao.UsuarioDAO;
import com.ecommerce.model.Usuario;

@WebServlet(name = "CadastrarUsuario", urlPatterns = { "/cadastrarusuario" })
public class CadastrarUsuarioController extends HttpServlet {

	private static final long serialVersionUID = 2138284467617354432L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/produtos/cadastrarUsuario.jsp");
		dispatcher.forward(request, response);
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Usuario usuario = new Usuario();
		usuario.setLogin(request.getParameter("usuario"));
		usuario.setSenha(request.getParameter("senha"));
		usuario.setNome(request.getParameter("nome"));
		usuario.setCpf(request.getParameter("cpf"));
		usuario.setTelefone(request.getParameter("telefone"));
		usuario.setEndereco(request.getParameter("endereco"));

		UsuarioDAO dao = new UsuarioDAO();

		if (dao.cadastraUsuario(usuario)) {
			request.setAttribute("usuario", usuario);
			HttpSession ses = request.getSession();
			ses.setAttribute("usuario", usuario);
		} else 
			request.setAttribute("erro", "Usuário ou senha inválida!");

		response.sendRedirect("listarprodutos");

	}

}
