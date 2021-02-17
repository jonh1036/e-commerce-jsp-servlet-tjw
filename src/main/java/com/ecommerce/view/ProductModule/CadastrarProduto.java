package com.ecommerce.view.ProductModule;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.dao.ProdutoDAO;
import com.ecommerce.model.Produto;
import com.ecommerce.view.Login;

@WebServlet(name = "CadastrarProduto", urlPatterns = { "/cadastrarproduto" })
public class CadastrarProduto extends HttpServlet {

	private static final long serialVersionUID = -3109363462853637763L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (!Login.logged || !Login.flagAdmin) {
			redirectToLogin(request, response);
			return;
		}
		
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/WEB-INF/ProductModule/cadastrarProduto.jsp");
		dispatcher.forward(request, response);
	}
	
	public void redirectToLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		Produto produto = new Produto();
		produto.setNome(request.getParameter("nome"));
		produto.setValor(Double.parseDouble(request.getParameter("valor")));
		produto.setDescricao(request.getParameter("descricao"));
		produto.setUrlImg("resources/images/" + request.getParameter("urlImg"));

		String page = "home.jsp";

		ProdutoDAO dao = new ProdutoDAO();
		if (dao.cadastraProduto(produto)) {
			page = "listarprodutos";
			response.sendRedirect(page);
		} else 
			request.setAttribute("erro", "Produto não inserido.");
	}

}
