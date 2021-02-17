
package com.ecommerce.view.ProductModule;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.dao.ProdutoDAO;
import com.ecommerce.model.Produto;
import com.ecommerce.view.Login;

@WebServlet(name = "ListarProdutos", urlPatterns = { "/listarprodutos" })
public class ListarProdutos extends HttpServlet {

	private static final long serialVersionUID = -7742782838219863606L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (!Login.logged || !Login.flagAdmin) {
			redirectToLogin(request, response);
			return;
		}
		
		ProdutoDAO dao = new ProdutoDAO();
		ArrayList<Produto> listaDeProdutos = dao.procuraTodosProdutos();
		
		request.setAttribute("listaDeProdutos", listaDeProdutos);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/ProductModule/listarProdutos.jsp");
		rd.forward(request, response);
	}
	
	public void redirectToLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
