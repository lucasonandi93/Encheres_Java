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
<div class="formProfil">
<label for="pseudo">Pseudo :</label>
<input type="text" id="pseudo" name="pseudo" required
       minlength="4" maxlength="12" size="12">
<label for="name">Nom :</label>
<input type="text" id="name" name="name" size="12">
</div>
       
<div class="formProfil">
<label for="firstName">Prénom :</label>
<input type="text" id="firstName" name="firstName">     
<label for="email">Email :</label>
<input type="text" id="email" name="email" required
       minlength="4" maxlength="8" size="12">
</div>
       
<div class="formProfil">       
<label for="phone">Téléphone :</label>
<input type="tel" id="phone" name="tel" required
       minlength="10" maxlength="10" size="12">      
<label for="street">Rue :</label>
<input type="text" id="street" name="street" size="12">
</div>       

<div class="formProfil">
<label for="cp">Code postal :</label>
<input type="text" id="cp" name="cp" required
       minlength="5" maxlength="5" size="12">
<label for="city">Ville :</label>
<input type="text" id="city" name="city" size="12">
</div>    
   
<div class="formProfil">
<label for="password">Mot de passe :</label>
<input type="password" id="password" name="password" required
       minlength="4" size="12">       
<label for="password">Confirmation mot de passe:</label>
<input type="password" id="password" name="password" required
       minlength="4" size="12">  
</div>
<div class="formProfil">
<input type="submit" value="Créer"> 
<button type="cancel" onclick="<%=request.getContextPath() %>/ServletProfilPage">Annuler</button>

</div>      
</form>           
</body>
</html>