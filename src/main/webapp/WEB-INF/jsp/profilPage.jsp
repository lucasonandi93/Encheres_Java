<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/styleProfilPage.css"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Profil</title>
</head>
<body>
	<header>
		<%@include file="headerFragment.jsp"%>
	</header>

	<h1>Mon profil</h1>
	<br>
	<p>Pseudo : ${userProfil.getPseudo()}</p>
	<br>
	<p>Nom : ${userProfil.getName()}</p>
	<br>
	<p>Prénom : ${userProfil.getFirstName()}</p>
	<br>
	<p>Email : ${userProfil.getEmail()}</p>
	<br>
	<p>Téléphone : ${userProfil.getPhone()}</p>
	<br>
	<p>Rue : ${userProfil.getStreet()}</p>
	<br>
	<p>Code postale : ${userProfil.getCp()}</p>
	<br>
	<p>Ville : ${userProfil.getCity()}</p>
	<br>

	<c:if test="${user.getNoUser() == userProfil }">
		<form action="" method="get">
			<input type="submit" value="Modifier">
		</form>
	</c:if>
	

</body>
</html>