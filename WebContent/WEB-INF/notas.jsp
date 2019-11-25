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
		<form action="./notas" method="get">
			<select name="materia">
				<c:forEach var="disc" items="${disciplinas}">
					<option value="${disc.nome}-${disc.sigla}">${disc.nome}-
						${disc.sigla}</option>
				</c:forEach>
			</select>
			<button type="submit" name="cmd" value="Procurar"
				class="btn btn-primary">Procurar</button>
		</form>
		<form action="" id="form">
			<c:set var="alunosNotas" scope="request" value="${alunosNotas}" />
			<c:if test="${not empty alunosNotas}">
				<h1>Inserir notas</h1>
				<table class="table table-striped table-dark" id="myTable">
					<thead>
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Id Disciplina</th>
							<th scope="col">Nome</th>
							<th scope="col">N2</th>
							<th scope="col">N1</th>
							<th scope="col">N3</th>
						</tr>
					</thead>
					<tbody scope="row">
						<c:forEach items="${alunosNotas}" var="alunoNota">
							<tr id="corpo">
								<c:set var="value" value="1" scope="page" />
								<td id="texto">${alunoNota.ra}</td>
								<td id="texto">${alunoNota.idDisciplina}</td>
								<td id="texto">${alunoNota.alunoNome}</td>
								<td><input type="number" name="n1"
									class="form-control ${alunoNota.ra}"></td>
								<td><input type="number" name="n2"
									class="form-control ${alunoNota.ra}"></td>
								<td><input type="number" name="n3"
									class="form-control ${alunoNota.ra}"></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<button type="submit" name="cmd" value="Salvar"
					class="btn btn-primary" onclick="salvarJson()">Salvar</button>
			</c:if>
		</form>
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
	<script type="text/javascript">
		function salvarJson() {
			
			var finalArray = [];
			
			class AlunosNotas{
				ra;
				idDisciplina;
				alunoNome;
				nota1;
				nota2;
				nota3;
			}
			
			

			var meuArray = Array.prototype.map.call(document
					.querySelectorAll('#myTable #corpo'), function(tr) {
				return Array.prototype.map.call(tr.querySelectorAll('#texto'),
						function(td) {
							return td.innerHTML;
						});
			});

			for (var i = 0; i < meuArray.length; i++) {
				var element = document.getElementsByClassName(meuArray[i][0]);
				console.log(element);
				for (var j = 0; j < element.length; j++) {
					meuArray[i].push(element[j].value);
				}
			}
			
			
			
			for (var i = 0; i < meuArray.length; i++) {
				
				var alunosNotas = new AlunosNotas();
				alunosNotas.ra = meuArray[i][0];
				alunosNotas.idDisciplina = meuArray[i][1];
				alunosNotas.alunoNome = meuArray[i][2];
				alunosNotas.nota1 = meuArray[i][3];
				alunosNotas.nota2 = meuArray[i][4];
				alunosNotas.nota3 = meuArray[i][5];
				finalArray.push(alunosNotas)
			}
		
			
			var URL = 'http://localhost:8080/AV3Colevati/notas';

			$.ajax({
				type : 'post', // it's easier to read GET request parameters
				url : URL,
				dataType : 'JSON',
				data : {
					loadProds : 1,
					finalArray : JSON.stringify(finalArray)
				// look here!
				},
				success : function(data) {

				},
				error : function(data) {
					alert('fail');
				}
			});
		}
	</script>
</body>
</html>