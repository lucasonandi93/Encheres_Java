<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath() %>/css/styleConnexion.css" rel="stylesheet">
<title>Connexion</title>
</head>
<body>
<header><h3>ENI-Enchères</h3></header>
	<main>
	<br>
	<form>
    <div class="form-group">
      <label for="usr">Identifiant : </label>
      <input type="text" class="form-control" id="usr">
    </div>
    <br>
    <div class="form-group">
      <label for="pwd">Mot de passe : </label>
      <input type="password" class="form-control" id="pwd">
    </div>
  </form>
  <br>
	 <button class="button" formaction="<%=request.getContextPath() %>/ServletRegistrationPage">Connexion</button>
	<input type="radio" id="Se souvenir de moi" name="connexion" value="connexion">
    <label for="connexion">Se souvenir de moi</label>
    <br><br>
   <a href="<%=request.getContextPath() %>/ServletInnexistantePourLinstant" class="forgotPassword">Mot de passe oublié</a>
   <br><br>
   <form>
  <button class="button" formaction="<%=request.getContextPath() %>/ServletRegistrationPage">Créer un compte</button>
</form>
   </main>
</body>
</html>