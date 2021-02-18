
package com.ecommerce.controllers.produtos;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.controllers.login.LoginController;
import com.ecommerce.dao.ProdutoDAO;
import com.ecommerce.model.Produto;

@WebServlet(name = "Loja", urlPatterns = { "/" })
public class LojaController extends HttpServlet {

	private static final long serialVersionUID = -5023908975386990266L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (LoginController.logged) {
			request.setAttribute("logado", "sim");
			request.setAttribute("erroLogin", "");
		}
		
		if(LoginController.flagAdmin)
			request.setAttribute("admin", "sim");

		ProdutoDAO dao = new ProdutoDAO();
		ArrayList<Produto> listaDeProdutos = dao.procuraTodosProdutos();
		
		request.setAttribute("listaDeProdutos", listaDeProdutos);
		RequestDispatcher rd = request.getRequestDispatcher("/views/produtos/loja.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
