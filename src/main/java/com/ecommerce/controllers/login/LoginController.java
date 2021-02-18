package com.ecommerce.controllers.login;

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

@WebServlet(name = "LoginServlet", urlPatterns = { "/login" })
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = -8467440139642965283L;
	public static boolean logged = false;
	public static boolean flagAdmin = false;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/login/login.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("erroLogin", "");
		
		Usuario usuario = new Usuario();
		usuario.setLogin(request.getParameter("usuario"));
		usuario.setSenha(request.getParameter("senha"));

		UsuarioDAO dao = new UsuarioDAO();

		if (dao.validar(usuario)) {
			usuario = dao.procuraUsuarioPeloID(usuario.getLogin());
			
			logged = true;
			if(usuario.isFlagAdmin())
				flagAdmin = true;
			
			request.setAttribute("usuario", usuario);
			
			HttpSession ses = request.getSession();
			ses.setAttribute("usuario", usuario);
			
			response.sendRedirect("/lojinha");
			
		} else {
			request.setAttribute("erroLogin", "Usuário e/ou senha inválido.");
			redirectToLogin(request, response);
		}
			
	}
	
	public void redirectToLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/login/login.jsp");
		dispatcher.forward(request, response);
	}
	
}
