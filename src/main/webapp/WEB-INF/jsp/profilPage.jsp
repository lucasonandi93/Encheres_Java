<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath() %>/css/styleProfilPage.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<header><h3>ENI-Enchères</h3></header>
<br>
Mon profil
<br><br>
<form action="" method="post" class="formProfil">

<label for="pseudo">Pseudo :</label>

<label for="name">Nom :</label>
       
<label for="firstName">Prénom :</label>
     
<label for="email">Email :</label>       
     
<label for="phone">Téléphone :</label>
     
<label for="street">Rue :</label>
     
<label for="cp">Code postal :</label>

<label for="city">Ville :</label>

<label for="password">Mot de passe :</label>
       
<label for="password">Confirmation mot de passe:</label>
 
<input type="submit" value="Modifier"> 

    
</form>           
</body>
</html>