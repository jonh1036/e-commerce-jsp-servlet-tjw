<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
        <title>Cadastrar Novo usuário</title>
    </head>
    <body style="background-color: #eee" >
        <div class="centralizar-pagina-cadastre-se">
            <div class="row ">
                <div style="margin-top: 5%" class="col-md-12">
                    <div class="col-md-12" style="text-align: center">  <form action="cadastrarusuario" method="post">
                            <fieldset>
                                <legend>Cadastre-se</legend>
                                <div class="form-group">
                                    <input class="form-control" type="text" name="usuario" placeholder="Digite seu usuário" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" type="password" name="senha" placeholder="Digite sua Senha">                        
                                </div>

                                <div class="form-group">
                                    <input class="form-control" type="nome" name="nome" placeholder="Digite seu nome">                        
                                    <div class="form-group">
                                    </div>

                                    <input class="form-control" type="cpf" name="cpf" placeholder="Digite seu CPF">                        
                                </div>
                                <div class="form-group">
                                    <input class="form-control" type="telefone" name="telefone" placeholder="Digite seu Telefone">                        
                                </div>

                                <div class="form-group">
                                    <input class="form-control" type="endereco" name="endereco" placeholder="Digite seu endereço">                        
                                </div>

                                <input type="submit" class="btn btn-success" name="btnEnviar" value="Enviar">
                            </fieldset>
                        </form>

                        <p style="color: red"> ${erro} </p>

                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
