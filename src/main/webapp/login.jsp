

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>Login</title>
</head>
<body style="background-color: #eee">
	<div class="centralizar-pagina">
		<div class="col-md-12">
			<form action="login" method="post">
				<fieldset>
					<legend>Acessar o Sistema</legend>
					<c:choose>
						<c:when test="${!erroLogin.equals('')}">
							<c:out value="${erroLogin}" />
						</c:when>
					</c:choose>
					<input class="form-control" type="text" name="usuario"
						value="${param.usuario}" placeholder="Usuário" autofocus>
					<br /> <input class="form-control" type="password" name="senha"
						placeholder="Senha"> <br /> <input class="btn btn-success"
						type="submit" name="btnEnviar" value="Enviar"> <a
						class="btn btn-primary" href="cadastrarusuario">Cadastrar</a>

				</fieldset>
			</form>
		</div>
	</div>
	<p style="color: red">${erro}</p>

</body>
</html>
