<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="resources/js/jquery.js"></script>
<script src="resources/js/popper.js"></script>
<script src="resources/js/bootstrap.js"></script>

<link rel="stylesheet" href="resources/css/bootstrap.css" />
<link rel="stylesheet" href="resources/css/bootstrap-grid.css" />
<link rel="stylesheet" href="resources/css/style.css" />
<title>Lista de produtos cadastrados</title>
</head>
<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
	<a class="navbar-brand" href="loja">Lojinha</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarsExampleDefault"
		aria-controls="navbarsExampleDefault" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarsExampleDefault">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link"
				href="listarprodutos">Produtos <span class="sr-only">(current)</span></a>
			</li>
			<li class="nav-item"><a class="nav-link" href="cadastrarproduto">Novo
					produto</a></li>
			<li class="nav-item"><a class="nav-link"
				href="relatoriodevendas">Relatório de Vendas</a></li>
		</ul>
	</div>

	<div style="justify-content: flex-end;" class="collapse navbar-collapse" id="navbarsExampleDefault">
		<ul class="navbar-nav ">
			<li class="nav-item active"><a class="nav-link" href="logout">Sair<span
					class="sr-only">(current)</span></a></li>
		</ul>
	</div>
</nav>

<div class="centering" style="margin-top: 4%">
	<div class="col-md-12">
		<body>
			<h1>Cadastrar Produto</h1>

			<table class="table table-striped">
				<tr>
					<td>Nome do produto</td>
					<td>Valor</td>
					<td>Descrição do produto</td>
					<td style="text-align: center;">Produto</td>
					<td>Ações</td>

				</tr>

				<c:forEach var="produto" items="${listaDeProdutos}">
					<tr>
						<td>${produto.nome}</td>
						<td>R$ ${produto.valor}</td>
						<td>${produto.descricao}</td>
						<td style="display: flex; justify-content: center;"><img
							height="120" width="120" src="${produto.urlImg}"
							alt="${produto.nome}"></td>
						<td>
							<form action="excluirproduto" method="post">
								<input type="hidden" name="idProduto" value="${produto.codigo}" />
								<input type="submit" class="btn btn-danger" value="Excluir" />
							</form>
							<form action="alterarproduto" method="get">
								<input type="hidden" name="idProduto" value="${produto.codigo}" />
								<input type="submit" class="btn btn-warning" value="Alterar" />
							</form>
						</td>
					</tr>
				</c:forEach>

			</table>

			<p style="color: red">${erro}</p>

		</body>
	</div>
</div>
</html>
