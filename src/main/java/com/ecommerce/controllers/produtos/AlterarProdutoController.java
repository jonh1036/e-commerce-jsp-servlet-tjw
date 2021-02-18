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

@WebServlet(name = "AlterarProduto", urlPatterns = {"/alterarproduto"})
public class AlterarProdutoController extends HttpServlet {

	private static final long serialVersionUID = 5381167687249417671L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        
		if (!LoginController.logged || !LoginController.flagAdmin) {
			redirectToLogin(request, response);
			return;
		}
		
        ProdutoDAO pDao = new ProdutoDAO();
        Integer idProduto = Integer.parseInt(request.getParameter("idProduto"));
        
        Produto p = pDao.procuraProdutoPeloID(idProduto);
        
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("produto", p);

        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/views/produtos/alterarProduto.jsp");
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
        
        int idProduto = Integer.parseInt(request.getParameter("idProduto"));
        
        request.setCharacterEncoding("UTF-8");
        
        Produto produto = new Produto();
        produto.setCodigo(idProduto);
        produto.setNome(request.getParameter("nome"));
        produto.setValor(Double.parseDouble(request.getParameter("valor")));
        produto.setDescricao(request.getParameter("descricao"));
        produto.setUrlImg(request.getParameter("urlImg"));

        ProdutoDAO dao = new ProdutoDAO();

        if (dao.alteraProduto(produto)) 
            response.sendRedirect("listarprodutos");
        else 
            request.setAttribute("erro", "Erro ao alterar");
    }

}
