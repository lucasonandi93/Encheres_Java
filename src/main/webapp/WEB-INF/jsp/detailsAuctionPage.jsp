<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@page import="java.util.GregorianCalendar" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/styleDetailsAuction.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Détail vente</title>
</head>
<body>
	<header>
		<%@include file="headerFragment.jsp"%>
	</header>

	<c:if test="${!isAfterEndDate}">
		<h2>Détail Vente</h2>
		
	</c:if>
	<c:if test="${isAfterEndDate && isUserConnectedArticle}">
		<h2>${pseudoBestAuction} à remporté(e) l'enchère</h2>
	</c:if>
	<c:if test="${isAfterEndDate && !isUserConnectedArticle}">
		<h2>Vous avez remporté la vente</h2>
	</c:if>
<div id="profil">
<div>
	<p><b>${articleOngoing.getNameArticle()}</b></p><hr>

	<p><b>Description :</b> ${articleOngoing.getDescription()}</p>

	<p><b>Catégorie : </b>${articleOngoing.getCategory().getWording()}</p>

	<!-- afficher la meilleure enchère et le nom de l'utilisateur qui l'a faite -->
	<p><b>Meilleure offre :</b> ${articleOngoing.getSellingPrice()} pts par ${pseudoBestAuction}</p> 		

	<p><b>Mise à prix :</b> ${articleOngoing.getOriginalPrice()} pts</p>
	
	<p><b>Début de l'enchère :</b> ${articleOngoing.getAuctionStartDate()}</p>

	<p><b>Fin de l'enchère :</b> ${articleOngoing.getAuctionEndDate()}</p> 

	<p><b>Retrait :</b> ${articleOngoing.getWithdrawal().getStreet()}	${articleOngoing.getWithdrawal().getCp()}	${articleOngoing.getWithdrawal().getCity()}</p>

	<p><b>Vendeur :</b> ${articleOngoing.getUser().getPseudo()}</p>
	</div>
	<div>
	 <img class="img" src="<%=request.getContextPath()%>${articleOngoing.getImageName()}"
							alt="Image de l'article ${article.imageName}" id="photoArticle">
	</div>
	</div>
<c:if test="${!isUserConnectedArticle && sessionScope.user.getNoUser() != null && canMakeProposal}">
		<hr>
		<p>Ma proposition :</p>
		<form method="post" action="<%=request.getContextPath()%>/ServletListOfAuctionsPage?articleID=${articleOngoing.getNoArticle()}">
			<input type="number" min="0" step="10" value="0" name="auction">
			<input type="submit" name="proposal" value="Enchérir">
		</form>
		
</c:if>
<c:if test="${isUserConnectedArticle && !isAfterEndDate}">
	<hr>
	<div>
		<a href="<%=request.getContextPath()%>/ServletNewArticle?articleID=${articleOngoing.noArticle}" ><input type="button" value="Modifier"></a>
	</div>
</c:if>
<c:if test="${isAfterEndDate && isUserConnectedArticle}">
		<form method="post" action="<%=request.getContextPath()%>/ServletListOfAuctionsPage?articleID=${articleOngoing.getNoArticle()}">
			<input type="submit" name="deleteArticle" value="Retrait Effectué">
		</form>
</c:if>
</body>			
</html>
