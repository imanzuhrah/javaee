<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.JavaBeans"%>
<%@page import="java.util.ArrayList"%>
<%
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");
%>


<%--for (int i=0; i<lista.size(); i++){
    	out.println(lista.get(i).getIdcon());
    	out.println(lista.get(i).getNome());
    	out.println(lista.get(i).getFone());
    	out.println(lista.get(i).getFone2());
    	out.println(lista.get(i).getFone3());
    	out.println(lista.get(i).getEmail());
    }
   
    --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agenda de Contatos</title>
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="icon" href="imagens/favicon.png">
<link rel="icon2" href="imagens/casa-limpa.png">
</head>
<body>
	<h1>Agenda de Contatos</h1>
	<a href="teladecadastro.html" class="Botao1">Novo Contato</a>
	<a href="report" id="relatorioBotao">Relatório</a>
	<a href="index.html" class="Botao1">Voltar</a>
	<table class="Tabela">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>DDI</th>
				<th>DDD</th>
				<th>Telefone</th>
				<th>E-mail</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getIdcon()%></td>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getFone()%></td>
				<td><%=lista.get(i).getFone2()%></td>
				<td><%=lista.get(i).getFone3()%></td>
				<td><%=lista.get(i).getEmail()%></td>
				<td><a href="select?idcon=<%=lista.get(i).getIdcon()%>"
					class="Botao1">Editar</a> <a
					href="javascript:confirmar(<%=lista.get(i).getIdcon()%>)"
					id="excluir">Excluir</a></td>

				<%
				}
				%>
			
		</tbody>
	</table>
	<script type="text/javascript" src="scripts/confirmador.js"></script>
</body>
</html>