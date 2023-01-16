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
<title>Registration</title>
</head>
<body>
	<header>
		<%@include file="headerFragment.jsp"%>
	</header>
	<br>
	<h2>Mon profil</h2>
	<br>
	<br>
	<form action="<%=request.getContextPath()%>/ServletListOfAuctionsPage"
		method="post">

		<div>
			<label for="pseudo">Pseudo :</label> <input type="text" id="pseudo"
				name="pseudo" required maxlength="30" value="${sessionScope.user.getPseudo()}"> <br> <br> <label
				for="name">Nom :</label> <input type="text" id="name" name="name"
				required maxlength="30" value="${sessionScope.user.getName()}">
		</div>
		<br>
		<div>
			<label for="firstName">Prénom :</label> <input type="text"
				id="firstName" name="firstName" required maxlength="30" value="${sessionScope.user.getFirstName()}"> <br>
			<br> <label for="email">Email :</label> <input type="email"
				id="email" name="email" required maxlength="50" value="${sessionScope.user.getEmail()}">
		</div>
		<br>
		<div>
			<label for="phone">Téléphone :</label> <input type="tel" id="phone"
				name="tel" maxlength="15" value="${sessionScope.user.getPhone()}"> <br> <br> <label
				for="street">Rue :</label> <input type="text" id="street"
				name="street" required maxlength="30" value="${sessionScope.user.getStreet()}">
		</div>
		<br>
		<div>
			<label for="cp">Code postal :</label> <input type="text" id="cp"
				name="cp" required maxlength="5" value="${sessionScope.user.getCp()}"> <br> <br> <label
				for="city">Ville :</label> <input type="text" id="city" name="city"
				required maxlength="50" value="${sessionScope.user.getCity()}">
		</div>
		<br>
		<div>
			<label for="password">Mot de passe :</label> <input type="password"
				id="password" name="password" required maxlength="30" value="${sessionScope.user.getPassword()}"> <br>
			<br> <label for="password">Confirmation :</label> <input
				type="password" id="password" name="password" required
				maxlength="30" value="${sessionScope.user.getPassword()}">
		</div>
		<div>
		<c:if test="${sessionScope.user.getNoUser() != null }">
			<p>Crédit ${sessionScope.user.getCredit()}</p>
		</c:if>
		</div>
		<br>
		<c:if test="${sessionScope.user.getNoUser() == null }">
			<input type="submit" value="Valider" name="validate">
			<br>
			<input type="submit" value="Annuler" name="cancel">
		</c:if>
		<c:if test="${sessionScope.user.getNoUser() != null }">
			<input type="submit" value="Enregistrer" name="save">
			<br>
			<input type="submit" value="Supprimer mon compte" name="delete">
		</c:if>
	</form>

</body>
</html>