package com.ecommerce.view;

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

@WebServlet(name = "LogoutServlet", urlPatterns = { "/logout" })
public class Logout extends HttpServlet {

	private static final long serialVersionUID = 556037066353419678L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Login.logged = false;
		Login.flagAdmin = false;

		ProdutoDAO dao = new ProdutoDAO();
		ArrayList<Produto> listaDeProdutos = dao.procuraTodosProdutos();
		
		request.setAttribute("listaDeProdutos", listaDeProdutos);
		RequestDispatcher rd = request.getRequestDispatcher("loja.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
