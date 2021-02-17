
package com.ecommerce.view.Vendas;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.dao.VendasDAO;
import com.ecommerce.model.Venda;
import com.ecommerce.view.Login;

@WebServlet(name = "RelatorioDeVendas", urlPatterns = { "/relatoriodevendas" })
public class RelatorioDeVendas extends HttpServlet {

	private static final long serialVersionUID = -4160148230382040986L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (!Login.logged || !Login.flagAdmin) {
			redirectToLogin(request, response);
			return;
		}
		
		VendasDAO dao = new VendasDAO();
		ArrayList<Venda> listaDeVendas = dao.procuraTodosVendas();
		
		request.setAttribute("listaDeVendas", listaDeVendas);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/VendasModule/relatorioDeVendas.jsp");
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
