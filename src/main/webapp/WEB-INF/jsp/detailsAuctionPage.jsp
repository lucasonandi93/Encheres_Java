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
		<h3>${pseudoBestAuction + " à remporté(e) l'enchère"}</h3>
	</c:if>
	<c:if test="${isAfterEndDate && !isUserConnectedArticle}">
		<h3>Vous avez remporté la vente</h3>
	</c:if>
<div id="profil">
	<p>${articleOngoing.getNameArticle()}</p>

	<p>Description : ${articleOngoing.getDescription()}</p>

	<p>Catégorie : ${articleOngoing.getCategory().getWording()}</p>

	<!-- afficher la meilleure enchère et le nom de l'utilisateur qui l'a faite -->
	<p>Meilleure offre : ${articleOngoing.getSellingPrice()} pts par ${pseudoBestAuction}</p> 		

	<p>Mise à prix : ${articleOngoing.getOriginalPrice()}</p>
	
	<p>Début de l'enchère : ${articleOngoing.getAuctionStartDate()}</p>

	<p>Fin de l'enchère : ${articleOngoing.getAuctionEndDate()}</p> 

	<p>Retrait : ${articleOngoing.getWithdrawal().getStreet()}	${articleOngoing.getWithdrawal().getCp()}	${articleOngoing.getWithdrawal().getCity()}</p>

	<p>Vendeur : ${articleOngoing.getUser().getPseudo()}</p>
<c:if test="${!isUserConnectedArticle && sessionScope.user.getNoUser() != null && canMakeProposal}">
		<hr>
		</div>
		<p>Ma proposition :</p>
		<form method="post" action="<%=request.getContextPath()%>/ServletListOfAuctionsPage?articleID=${articleOngoing.getNoArticle()}">
			<input type="number" min="0" step="10" value="0" name="auction">
			<input type="submit" name="proposal" value="Enchérir">
		</form>
		
</c:if>
<c:if test="${isUserConnectedArticle && !isAfterEndDate}">
	<hr>
	<div class="btn-modifier">
		<a href="<%=request.getContextPath()%>/ServletNewArticle?articleID=${articleOngoing.noArticle}" >Modifier</a>
	</div>
</c:if>
<c:if test="${isAfterEndDate && isUserConnectedArticle}">
		<form method="post" action="<%=request.getContextPath()%>/ServletListOfAuctionsPage?articleID=${articleOngoing.getNoArticle()}">
			<input type="submit" name="deleteArticle" value="Retrait Effectué">
		</form>
</c:if>
</body>			
</html>
