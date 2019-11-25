<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Relatorios Nota</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="container main">
		<form action="./relatoriosNotas" method="get">
			<select name="materia">
				<c:forEach var="disc" items="${disciplinas}">
					<option value="${disc.codigo}">${disc.nome}-${disc.sigla}</option>
				</c:forEach>
			</select>
			<button type="submit" name="cmd" value="Procurar"
				class="btn btn-primary">Procurar</button>
		</form>

		<c:if test="${not empty relatoriosNotas}">
			<h1>Relatorio de notas</h1>
			<table class="table table-striped table-dark" id="myTable">
				<thead>
					<tr>
						<th scope="col">RA Aluno</th>
						<th scope="col">Nome</th>
						<th scope="col">Nota1</th>
						<th scope="col">Nota2</th>
						<th scope="col">Nota3</th>
						<th scope="col">Nota4</th>
					</tr>
				</thead>
				<tbody scope="row">
					<c:forEach items="${relatoriosNotas}" var="alunoNota">
						<tr id="corpo">
							<c:set var="value" value="1" scope="page" />
							<td id="texto">${alunoNota.ra_aluno}</td>
							<td id="texto">${alunoNota.nome_aluno}</td>
							<td id="texto">${alunoNota.nota1}</td>
							<td id="texto">${alunoNota.nota2}</td>
							<td id="texto">${alunoNota.nota3}</td>
							<td id="texto">${alunoNota.media_final}</td>
							<td id="texto">${alunoNota.situacao}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
	<script
		src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</body>
</html>