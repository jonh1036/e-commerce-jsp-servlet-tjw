package com.ecommerce.view.ProductModule;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.dao.ProdutoDAO;
import com.ecommerce.dao.VendasDAO;
import com.ecommerce.model.Produto;
import com.ecommerce.model.Venda;
import com.ecommerce.view.Login;

@WebServlet(name = "Comprar", urlPatterns = { "/comprar" })
public class Comprar extends HttpServlet {

	private static final long serialVersionUID = -712397674459957959L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProdutoDAO pdao = new ProdutoDAO();

		if (!Login.logged) {
			redirectToLogin(request, response);
			return;
		}

		Produto produto = pdao.procuraProdutoPeloID(Integer.parseInt(request.getParameter("idProduto")));
		
		request.setAttribute("produto", produto);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/comprar.jsp");
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

		Venda venda = new Venda();
		venda.setData(Calendar.getInstance().getTime().toString());
		venda.setNomeComprador(request.getParameter("nomeComprador"));
		venda.setCartaoComprador(request.getParameter("cartaoComprador"));
		venda.setCodSegurancaComprador(request.getParameter("codSegurancaComprador"));
		venda.setValor(Double.parseDouble(request.getParameter("valor")));
		venda.setIdProduto(Integer.parseInt(request.getParameter("idProduto")));

		VendasDAO dao = new VendasDAO();

		if (dao.cadastraVenda(venda)) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/compraFeitaComSucesso.jsp");
			dispatcher.forward(request, response);
		} else
			request.setAttribute("erro", "Produto não inserido.");
	}

}
