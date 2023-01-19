<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/styleProfilPage.css"
	type="text/css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Profil</title>
</head>
<body>
	<header>
		<%@include file="headerFragment.jsp"%>
	</header>

	<h2>Mon profil</h2>
	<div id="profil">	
		<br>
		<p><strong>Pseudo : </strong><span>${userProfil.getPseudo()}</span></p>
		<br>
		<p><strong>Nom : </strong><span>${userProfil.getName()}</span></p>
		<br>
		<p><strong>Prénom : </strong><span>${userProfil.getFirstName()}</span></p>
		<br>
		<p><strong>Email : </strong><span>${userProfil.getEmail()}</span></p>
		<br>
		<p><strong>Téléphone : </strong><span>${userProfil.getPhone()}</span></p>
		<br>
		<p><strong>Rue : </strong><span>${userProfil.getStreet()}</span></p>
		<br>
		<p><strong>Code postale : </strong><span>${userProfil.getCp()}</span></p>
		<br>
		<p><strong>Ville : </strong><span>${userProfil.getCity()}</span></p>
		<br>
	</div>

	<c:if test="${sessionScope.user.getNoUser() == userProfil.getNoUser() }">
		<form action="<%=request.getContextPath()%>/ServletRegistrationPage" method="get">
			<input type="submit" value="Modifier">
		</form>
	</c:if>
</body>
</html>