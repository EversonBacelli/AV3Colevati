<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html lang="pt-br">
<head>
<!-- Meta tags Obrigatórias -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="node_modules/bootstrap/compiler/bootstrap.css">
<link rel="stylesheet" href="node_modules/bootstrap/compiler/style.scss">

<!-- nesse trecho é criado o navbar, acrescentado as corres back-ground dele-->
<!-- navbar-dark: coloca as letras brancas navbar-light: letras pretas  -->
<!-- bg-primary: cor de fundo azul, bg-light: branca, bg-warning: laranja -->
<style type="text/css">
#imgSlide {
	width: 100%;
}

#carouselSite {
	width: 100%;
	height: 30%;
}

#imgCard {
	width: 80%;
	height: 30%;
}

nav {
	z-index: 10;
	background: #f2cb12;
}

#carouselSite {
	z-index: -1;
}
</style>
<title>AV3_LEANDRO COLEVATI</title>
</head>
<body>
	<div>
		<nav
			class="navbar navbar-expand-lg navbar-light    bg-gradient-warning">
			<div class="container">
				<!-- nome em destaque no navbar -->
				<a class="navbar-brand" href="./principal.html">AV3_Leandro Colevati</a>

				<!-- reconher o navbar -->
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSite">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSite">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link"
							href="av3Colevati.html">Tela Principal</a></li>
						<li class="nav-item"><a class="nav-link" href="./relatorios">Relatórios
								</a></li>
						<li class="nav-item"><a class="nav-link" href="./faltas">Faltas
							</a></li>
						<li class="nav-item"><a class="nav-link" href="./notas">Notas
							</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>


	<script src="node_modules/jquery/dist/jquery.js"></script>
	<script src="node_modules/popper.js/dist/umd/popper.js"></script>
	<script src="node_modules/bootstrap/dist/js/bootstrap.js"></script>
</body>
</html>