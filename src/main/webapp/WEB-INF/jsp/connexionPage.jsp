<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap core CSS -->

<link href="<%=request.getContextPath()%>/css/styleConnexion.css"
	rel="stylesheet">
<title>Connexion</title>
</head>
<body>
	<header>
		<h3>ENI-Enchères</h3>
		<div id="myMenu">
			<div class="myWrapper">
				<nav>
					<a href="Homepage.cshtml"><div class="logo"></div></a>
				</nav>
			</div>
		</div>
	</header>
	<main>
		<br>
		<fieldset>
			<form method="post" action="<%=request.getContextPath()%>/ServletListOfAuctionsPage">
				<div class="form-group">
					<label for="usr">Identifiant : </label> 
					<input type="text" name="pseudo" value="" class="form-control" id="usr">
				</div>
				<br>
				<div class="form-group">
					<label for="pwd">Mot de passe : </label>
					<input type="password" name="password" value="" class="form-control" id="pwd">
				</div>
					<input type="submit" value="Connexion"></input>
					<input type="checkbox" id="connexion" name="connexion" value="connexion"> 
				<label for="connexion" value="Se souvenir de moi"></label>
				
				
				
			</form>
	
			<br> <a
				href="<%=request.getContextPath()%>/ServletTestSelectForm"
				class="forgotPassword">Mot de passe oublié</a> <br>
			<br> <a
				href="<%=request.getContextPath()%>/ServletRegistrationPage">
				<button class="submit">Créer un compte</button>
			</a>
		</fieldset>
	</main>
</body>
</html>