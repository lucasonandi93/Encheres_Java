<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/styleProfil.css"
	rel="stylesheet">
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
		<p>Pseudo : <span>${userProfil.getPseudo()}</span></p>
		<br>
		<p>Nom : <span>${userProfil.getName()}</span></p>
		<br>
		<p>Prénom : <span>${userProfil.getFirstName()}</span></p>
		<br>
		<p>Email : <span>${userProfil.getEmail()}</span></p>
		<br>
		<p>Téléphone : <span>${userProfil.getPhone()}</span></p>
		<br>
		<p>Rue : <span>${userProfil.getStreet()}</span></p>
		<br>
		<p>Code postale : <span>${userProfil.getCp()}</span></p>
		<br>
		<p>Ville : <span>${userProfil.getCity()}</span></p>
		<br>
	</div>

	<c:if test="${sessionScope.user.getNoUser() == userProfil.getNoUser() }">
		<form action="<%=request.getContextPath()%>/ServletRegistrationPage" method="get">
			<input type="submit" value="Modifier">
		</form>
	</c:if>
</body>
</html>