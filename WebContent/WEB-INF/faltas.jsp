<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lançar Faltas</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<style type="text/css">
#fundo {
	background-color: #00CED1;
}
</style>
</head>
<body id="fundo">
	<div class="container">
		<form method="get" action="">
			<h2>Selecionar a Disciplina</h2>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<select name="materia">
							<c:forEach var="disc" items="${disciplinas}">
								<option value="${disc.nome}-${disc.sigla}">${disc.nome}
									- ${disc.sigla}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<!--  col-md-6   -->

				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label> Insira a Data__</label><input type="text" name="fname"
								value="" id="data">
						</div>
						<button type="submit" class="btn btn-primary" name="cmd"
							value="BuscarTurma">BUSCAR TURMA</button>
		</form>
	</div>
	<br>
	<br>
	<br>

	<div class="container">
		<h3>Lançar Faltas</h3>
		<table class="table table-dark" id="myTable">
			<thead>
				<tr>
					<th scope="col">RA</th>
					<th scope="col">ALUNO</th>
					<th scope="col">0</th>
					<th scope="col">1</th>
					<th scope="col">2</th>
					<th scope="col">3</th>
					<th scope="col">4</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${not empty alunosFaltas}">
					<c:forEach items="${alunosFaltas}" var="alunoFaltas">
						<tr id="#tr">
							<td scope="row" class="texto">${alunoFaltas.ra_aluno}</td>
							<td class="texto">${alunoFaltas.nome_aluno}</td>
							<td><input type="radio" name="${alunoFaltas.ra_aluno}"
								value="0"></td>
							<td><input type="radio" name="${alunoFaltas.ra_aluno}"
								value="1"></td>
							<td><input type="radio" name="${alunoFaltas.ra_aluno}"
								value="2"></td>
							<td><input type="radio" name="${alunoFaltas.ra_aluno}"
								value="3"></td>
							<td><input type="radio" name="${alunoFaltas.ra_aluno}"
								value="4"></td>
						</tr>
					</c:forEach>
					<button action="./faltas" method="post" type="submit"
						class="btn btn-primary" name="cmd" value="SalvarFaltas"
						onclick="salvarJson()">Salvar Presença</button>
				</c:if>
			</tbody>
		</table>



	</div>
	<br>
	<br>
	<br>

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
		
		class AlunosFaltas{
			ra_aluno;
			nome_aluno;
			presenca_aluno;
		}

		var meuArray = Array.prototype.map.call(document
				.querySelectorAll('#myTable tr'), function(tr) {
			return Array.prototype.map.call(tr.querySelectorAll('.texto'),
					function(td) {
						return td.innerHTML;
					});
		});

		for (var i = 1; i < meuArray.length; i++) {
			var elements = document.getElementsByName(meuArray[i][0]);
			for(var j = 0;j<elements.length;j++){
				var check = elements[i].checked;
				if(check == true){
					meuArray[i].push(element[j].value);
			    }
			}
		}
		
		
		
		for (var i = 0; i < meuArray.length; i++) {
			var alunoFalta = new AlunosFaltas();
			alunoFalta.ra_aluno = meuArray[i][0];
			alunoFalta.nome_aluno = meuArray[i][1];
			alunoFalta.presenca_aluno = meuArray[i][2];
			finalArray[i].push(alunoFalta);
		}
	
		
		var URL = 'http://localhost:8080/AV3Colevati/faltas';

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