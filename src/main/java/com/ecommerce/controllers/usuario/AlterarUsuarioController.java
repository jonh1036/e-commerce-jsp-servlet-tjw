
package com.ecommerce.controllers.usuario;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.controllers.login.LoginController;
import com.ecommerce.dao.UsuarioDAO;
import com.ecommerce.model.Usuario;

@WebServlet(name = "alterarusuario", urlPatterns = { "/alterarusuario" })
public class AlterarUsuarioController extends HttpServlet {

	private static final long serialVersionUID = -8599468510330717430L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (!LoginController.logged || !LoginController.flagAdmin) {
			redirectToLogin(request, response);
			return;
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/usuario/alterarUsuario.jsp");
		dispatcher.forward(request, response);
	}
	
	public void redirectToLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/login/login.jsp");
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
		String page = "index.jsp";

		UsuarioDAO dao = new UsuarioDAO();

		if (dao.alteraUsuario(usuario)) {
			page = "/views/home/home.jsp";
			request.setAttribute("usuario", usuario);
		} else 
			request.setAttribute("erro", "Usuário ou senha inválida!");

		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
