<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap core CSS -->

<%-- <link href="<%=request.getContextPath()%>/css/styleConnexion.css"
	rel="stylesheet"> --%>
<title>Connexion</title>
</head>
<body>
	<header>
		<h3>ENI-Enchères</h3>
	</header>
	<main>
		<form method="post" action="<%=request.getContextPath()%>/ServletListOfAuctionsPage">
			<div class="form-group">
				<label for="usr">Identifiant : </label> 
				<input type="text" name="pseudo" value="" class="form-control" id="usr" maxlength="30">
			</div>
			<div class="form-group">
				<label for="pwd">Mot de passe : </label>
				<input type="password" name="password" value="" class="form-control" id="pwd" maxlength="30">
			</div>
				<input type="checkbox" id="connexion" name="session"> 
				<label for="connexion">Se souvenir de moi</label>
				<input type="submit" name="connexion" value="Connexion"></input>
		</form>
		<a href="<%=request.getContextPath()%>/ServletTestSelectForm" class="forgotPassword">Mot de passe oublié</a> <br>
		<form action="<%=request.getContextPath()%>/ServletRegistrationPage">
			<input type="submit" value="Créer un compte">
		</form>
	</main>
</body>
</html>