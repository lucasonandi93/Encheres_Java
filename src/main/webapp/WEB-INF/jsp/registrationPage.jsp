<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%-- <link href="<%=request.getContextPath() %>/css/styleProfilPage.css" rel="stylesheet"> --%>
<title>Insert title here</title>
</head>
<body>
<header><h3>ENI-Enchères</h3></header>
<br>
<h2>Mon profil</h2>
<br><br>
<form action="<%=request.getContextPath()%>/ServletListOfAuctionsPage" method="post">
<div>
	<label for="pseudo">Pseudo :</label>
	<input type="text" id="pseudo" name="pseudo" required maxlength="30">
	<label for="name">Nom :</label>
	<input type="text" id="name" name="name" required maxlength="30">
</div>
<br>       
<div >
	<label for="firstName">Prénom :</label>
	<input type="text" id="firstName" name="firstName" required maxlength="30">     
	<label for="email">Email :</label>
	<input type="email" id="email" name="email" required maxlength="50">
</div>
<br>       
<div >       
	<label for="phone">Téléphone :</label>
	<input type="tel" id="phone" name="tel" maxlength="15">      
	<label for="street">Rue :</label>
	<input type="text" id="street" name="street" required maxlength="30">
</div>       
<br>
<div >
	<label for="cp">Code postal :</label>
	<input type="text" id="cp" name="cp" required maxlength="5">
	<label for="city">Ville :</label>
	<input type="text" id="city" name="city" required maxlength="50">
</div>    
<br>   
<div >
	<label for="password">Mot de passe :</label>
	<input type="password" id="password" name="password" required maxlength="30">       
	<label for="password">Confirmation :</label>
	<input type="password" id="password" name="password" required maxlength="30">  
</div>
<br>
<input type="submit" value="Créer"> 
</form>
<form action="<%=request.getContextPath()%>/ServletListOfAuctionsPage" method="post">
	<input type="submit" value="Annuler">    
</form>
</body>
</html>