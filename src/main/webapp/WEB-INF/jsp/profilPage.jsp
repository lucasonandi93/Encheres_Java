<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%-- <link href="<%=request.getContextPath() %>/css/styleProfilPage.css" rel="stylesheet"> --%>
<title>Profil</title>
</head>
<body>
<header><h3>ENI-Enchères</h3></header>

<h1>Mon profil</h1>
<br>
<form action="" method="post">
<label for="pseudo">Pseudo :</label>
<p id="pseudo" name="pseudo">${userProfil.getPseudo()}</p>
<br>
<label for="name">Nom :</label>
<p id="name" name="name"></p>
<br>
<label for="firstName">Prénom :</label>
<p id="firstName" name="firstName"></p>
<br>     
<label for="email">Email :</label>       
<p id="email" name="email"></p>
<br>     
<label for="phone">Téléphone :</label>
<p id="phone" name="phone"></p>
<br>     
<label for="street">Rue :</label>
<p id="street" name="street"></p>
<br>     
<label for="cp">Code postal :</label>
<p id="cp" name="cp"></p>
<br>
<label for="city">Ville :</label>
<p id="city" name="city"></p>
<br>
 
<input type="submit" value="Modifier"> 

</form>           
</body>
</html>