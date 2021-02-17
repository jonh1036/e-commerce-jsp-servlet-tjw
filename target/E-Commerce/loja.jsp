<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="resources/js/jquery.js"></script>
        <script src="resources/js/popper.js"></script>
        <script src="resources/js/bootstrap.js"></script>

        <link rel="stylesheet" href="resources/css/bootstrap.css"/>
        <link rel="stylesheet" href="resources/css/bootstrap-grid.css"/>
        <link rel="stylesheet" href="resources/css/style.css"/>
        <title>Lista de produtos cadastrados</title>
    </head>
    <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
        <a class="navbar-brand" href="loja">Lojinha</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarsExampleDefault">
            <ul class="navbar-nav mr-auto">
            </ul>
            <ul class="navbar-nav ">
                <c:choose>
				    <c:when test="${admin.equals('sim')}">
				        <li class="nav-item active">
                	    	<a class="nav-link" href="listarprodutos">Administração<span class="sr-only">(current)</span></a>
                		</li>
				    </c:when>    
				</c:choose>
            </ul>
            <ul class="navbar-nav ">
                <c:choose>
				    <c:when test="${!logado.equals('sim')}">
				        <li class="nav-item active">
                	    	<a class="nav-link" href="login">Entrar<span class="sr-only">(current)</span></a>
                		</li>
				    </c:when>    
				    <c:otherwise>
				        <li class="nav-item active">
                	        <a class="nav-link" href="logout">Sair<span class="sr-only">(current)</span></a>
                		</li>
				    </c:otherwise>
				</c:choose>
            </ul>
        </div>
    </nav>
    <body>
        <div class="row">
            <div class="col-md-12">
                <h3 style="margin-top: 5%; text-align: center">Produtos da lojinha</h3>

                <div class="col-md-10 centering">
                    <div class="row">
                        <c:forEach var="produto" items="${listaDeProdutos}">
                            <div class="produto-thumb">
                                <div>
                                    <a href="#" class="thumbnail">
                                        <img height="200" width="200" src="${produto.urlImg}" alt="${produto.nome}"></td>
                                    </a>
                                    <h5>${produto.nome}</h5>
                                    <div class="preco">R$ ${produto.valor}</div>
                                    <div class="descricao">${produto.descricao}</div>
                                    <form method="GET" action="comprar">
                                        <div class="center">
                                            <input type="hidden" name="idProduto" value="${produto.codigo}"/>
                                            <input type="submit" class="btn btn-success comprar" value="Comprar"/>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <p style="color: red"> ${erro} </p>


            </div>
        </div>
    </body>
</html>
