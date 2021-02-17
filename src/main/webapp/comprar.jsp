<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="resources/js/jquery.js"></script>
        <script src="resources/js/popper.js"></script>
        <script src="resources/js/bootstrap.js"></script>

        <link rel="stylesheet" href="resources/css/bootstrap.css">
        <link rel="stylesheet" href="resources/css/bootstrap-grid.css">
        <link rel="stylesheet" href="resources/css/style.css">
        <title>Cadastrar novo produto</title>
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
    <body style="background-color: #eee" >
        <div class="centralizar-pagina">
            <div class="row ">
                <div style="margin-top: 5%" class="col-md-12">
                    <div class="col-md-12">
                        <h4 > Comprar produto</h4>
                        
                        <div class="box-produtos alert-info ">
                            <h6>Nome do produto: ${produto.nome}</h6>
                            <div>Valor: ${produto.valor}</div>
                            <div>Descrição: ${produto.descricao}</div>
                        </div>
                        <form action="comprar" method="post">
                            <input type="hidden" name="idProduto" value="${produto.codigo}" />
                            <input type="hidden" name="valor" value="${produto.valor}"/>
                            <div class="form-group">
                                <input class="form-control" type="text" name="nomeComprador" placeholder="Digite o seu nome" autofocus/>
                            </div>
                            <div class="form-group">
                                <input class="form-control" type="text" name="cartaoComprador" placeholder="Digite o seu cartão de crédito"/>                        
                            </div>
                            <div class="form-group">
                                <input class="form-control" type="text" maxlength="3" name="codSegurancaComprador" placeholder="Digite o código de segurança"/>                        
                            </div>
                            <input  type="submit" class="btn btn-success" name="btnEnviar" value="Finalizar compra">
                        </form>
                        <p style="color: red"> ${erro} </p>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
