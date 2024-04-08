<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agenda de Contatos</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="background" href="imagens/agendaimg.jpg">
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<h1>Editar Contato</h1>
	<form name="frmContato" action="update">

		<table>
			<thead>
				<tr>
					<td><input type="text" name="idcon" id="Caixa3" size="1"
						readonly value="<%out.print(request.getAttribute("idcon"));%>"></td>
				</tr>
			</thead>
			<thead>
				<tr>
					<td><input type="text" name="nome" class="Caixa3" size="40"
						value="<%out.print(request.getAttribute("nome"));%>"> <br /></td>
				</tr>
				<tr>
					<td><input type="text" name="fone" class="Caixa3_00" size="1"
						value="<%out.print(request.getAttribute("fone"));%>"> - <input
						type="text" name="fone2" class="Caixa3_0" size="5"
						value="<%out.print(request.getAttribute("fone2"));%>"> - <input
						type="text" name="fone3" class="Caixa3_001" size="8"
						value="<%out.print(request.getAttribute("fone3"));%>"></td>
				</tr>
			</thead>
			<tr>
				<td><input type="text" name="email" class="Caixa3" size="40"
					value="<%out.print(request.getAttribute("email"));%>"> <br /></td>
			</tr>
		</table>
		<input type="submit" class="Botao1" value="Salvar" onclick="validar()">
	</form>
	<script type="text/javascript" src="scripts/validacao.js"></script>

</body>
</html>