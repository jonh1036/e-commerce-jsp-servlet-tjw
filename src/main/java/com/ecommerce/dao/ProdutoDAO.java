package com.ecommerce.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ecommerce.model.Produto;

public class ProdutoDAO {

	public boolean cadastraProduto(Produto produto) {
		String insertTableSQL = "INSERT INTO produto" + "(nome, valor, descricao, urlImg) VALUES" + "(?,?,?,?) ;";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = DbConnect.getConexao().prepareStatement(insertTableSQL);
			preparedStatement.setString(1, produto.getNome());
			preparedStatement.setDouble(2, produto.getValor());
			preparedStatement.setString(3, produto.getDescricao());
			preparedStatement.setString(4, produto.getUrlImg());
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean alteraProduto(Produto produto) {
		String insertTableSQL = "UPDATE produto SET nome = ?, valor = ?, descricao = ?, urlImg = ?" + "WHERE idProduto = ? ;";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = DbConnect.getConexao().prepareStatement(insertTableSQL);
			preparedStatement.setString(1, produto.getNome());
			preparedStatement.setDouble(2, produto.getValor());
			preparedStatement.setString(3, produto.getDescricao());
			preparedStatement.setString(4, produto.getUrlImg());
			preparedStatement.setInt(5, produto.getCodigo());
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean excluiProduto(Integer toDelete) {
		String insertTableSQL = "DELETE FROM produto WHERE idProduto = ? ; ";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = DbConnect.getConexao().prepareStatement(insertTableSQL);
			preparedStatement.setInt(1, toDelete);
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Produto procuraProdutoPeloID(Integer idProduto) {

		try {
			String sql = "select * from produto where idProduto = ? ;";
			PreparedStatement con = DbConnect.getConexao().prepareStatement(sql);

			con.setInt(1, idProduto);
			ResultSet rs = con.executeQuery();
			Produto produto = new Produto();

			if (rs.next()) {
				produto.setCodigo(rs.getInt("idProduto"));
				produto.setNome(rs.getString("nome"));
				produto.setValor(rs.getDouble("valor"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setUrlImg(rs.getString("urlImg"));
			}
			rs.close();
			con.close();
			return produto;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Produto> procuraTodosProdutos() {

		try {
			String sql = "select * from produto;";
			PreparedStatement con = DbConnect.getConexao().prepareStatement(sql);

			ResultSet rs = con.executeQuery();

			ArrayList<Produto> listaProdutos = new ArrayList<>();
			while (rs.next()) {
				Produto produto = new Produto();

				produto.setCodigo(rs.getInt("idProduto"));
				produto.setNome(rs.getString("nome"));
				produto.setValor(rs.getDouble("valor"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setUrlImg(rs.getString("urlImg"));

				listaProdutos.add(produto);
			}
			rs.close();
			con.close();
			return listaProdutos;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
