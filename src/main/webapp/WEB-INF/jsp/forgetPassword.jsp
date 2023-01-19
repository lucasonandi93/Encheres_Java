<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="<%=request.getContextPath()%>/css/styleForgetPassword.css" rel="stylesheet">
<title>Mot de passe oublié</title>
</head>
<body>
<h1>${error}</h1>

<header>
		<%@include file="headerFragment.jsp"%>
	</header>
 <h2>Récupèration du mot de passe</h2><br>
<form method="post" class="forgetPassword" name="forgetPassword" id="forgetPassword">
<input type="email" name="email" id="email" size="30" placeholder="Votre email :">
<input type="submit" value="send" value="Envoi du mot de passe">
</form>
 

</body>
</html>