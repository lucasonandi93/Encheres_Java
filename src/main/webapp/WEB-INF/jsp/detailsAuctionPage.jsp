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

	<h3>Détail Vente</h3>

	<p>${articleOngoing.getNameArticle()}</p>

	<p>Description : ${articleOngoing.getDescription()}</p>

	<p>Catégorie : ${articleOngoing.getCategory().getWording()}</p>

	<!-- afficher la meilleure enchère et le nom de l'utilisateur qui l'a faite -->
	<p>Meilleure offre : ${articleOngoing.getSellingPrice()} pts par ${userOngoing.getName()}</p>		

	<p>Mise à prix : ${articleOngoing.getOriginalPrice()}</p>

	<p>Fin de l'enchère : ${articleOngoing.getAuctionEndDate()}</p>

	<p>Retrait : ${articleOngoing.getWithdrawal().getStreet()}	${articleOngoing.getWithdrawal().getCp()}	${articleOngoing.getWithdrawal().getCity()}</p>

	<p>Vendeur : ${articleOngoing.getUser().getPseudo()}</p>
<hr>
	<p>Ma proposition :</p>
		<form method="post" action="<%=request.getContextPath()%>/ServletDetailsAuctionPage">
			<input type="number" min="0" step="1" value="1">
			<button type="submit" name="auction">Enchérir</button>
		</form>
</body>			
</html>
