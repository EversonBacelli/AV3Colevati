<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Notas</title>
<style type="text/css">
.main {
	text-align: center;
}

<!--
-->
@import url(http://fonts.googleapis.com/css?family=Roboto:400,300);

@import
	url(http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css)
	;

body {
	padding: 70px 0px;
}
</style>
</head>
<body>
	<div class="container main">
		<form action="">
			<select name="materia">
				<c:forEach var="disc" items="${disciplinas}">
					<option value="${disc}">${disc.nome} - ${disc.sigla}</option>
				</c:forEach>
			</select>
			<button type="submit" class="btn btn-primary">Procurar</button>
		</form>
		
		<c:if test="${not empty alunos}">
			<h1>Inserir notas</h1>
			<table class="table table-striped table-dark">
				<thead>
					<tr>
						<th scope="col">Nome</th>
						<th scope="col">N2</th>
						<th scope="col">N1</th>
						<th scope="col">N3</th>
					</tr>
				</thead>
				<tbody scope="row">
					<c:set var="value" value="1" scope="page" />
					<tr>
						<td class="${value}">Bruno Cardoso</td>
						<td>
							<div class="col-xs-6">
								<div class="range">
									<input type="range" name="range" min="1" max="10" value="5"
										onchange="range.value=value">
									<output id="range">5</output>
								</div>
							</div>
						</td>
						<td>
							<div class="col-xs-6">
								<div class="range range-success">
									<input type="range" name="range" min="1" max="10" value="5"
										onchange="rangeSuccess.value=value">
									<output id="rangeSuccess">5</output>
								</div>
							</div>
						</td>
						<td>
							<div class="col-xs-6">
								<div class="range range-primary">
									<input type="range" name="range" min="1" max="10" value="5"
										onchange="rangePrimary.value=value">
									<output id="rangePrimary">5</output>
								</div>
							</div>
						</td>
						<c:set var="value" value="${value + 1}" scope="page" />
					</tr>
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
	<script type="text/javascript">
		function alteraValor(valor) {
			var element = document
		}
	</script>
</body>
</html>