<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap core CSS -->

<link href="<%=request.getContextPath() %>/css/styleConnexion.css" rel="stylesheet">
<title>Connexion</title>
<link href="${pageContext.request.contextPath}/vendor/bootstrap-5.2.3-dist/css/bootstrap.css" rel="stylesheet">
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
  	 <a class="btn btn-primary" role="button" href="<%=request.getContextPath() %>/ServletProfilPage">Connexion</a>
	
	<input type="radio" id="Se souvenir de moi" name="connexion" value="connexion">
    <label for="connexion">Se souvenir de moi</label>
    <br><br>
   <a href="<%=request.getContextPath() %>/ServletRegistrationPage" class="forgotPassword">Mot de passe oublié</a>
   <br><br>
   <form method="get" action="<%=request.getContextPath() %>/ServletRegistrationPage">
  <button class="submit">Créer un cooompte</button>
</form>
   </main>
</body>
</html>