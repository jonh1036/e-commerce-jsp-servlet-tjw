package com.ecommerce.controllers.produtos;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.controllers.login.LoginController;
import com.ecommerce.dao.ProdutoDAO;
import com.ecommerce.model.Produto;

@WebServlet(name = "ExcluirProduto", urlPatterns = { "/excluirproduto" })
public class ExcluirProdutoController extends HttpServlet {

	private static final long serialVersionUID = -8901412593249429083L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (!LoginController.logged || !LoginController.flagAdmin) {
			redirectToLogin(request, response);
			return;
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/produtos/listarProdutos.jsp");
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

		Produto u = new Produto();
		u.setCodigo(Integer.parseInt(request.getParameter("idProduto")));

		ProdutoDAO dao = new ProdutoDAO();

		dao.excluiProduto(u.getCodigo());
		response.sendRedirect("listarprodutos");
	}

}
