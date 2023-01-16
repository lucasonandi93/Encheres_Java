<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt"%>
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

	<p>Meilleure offre : 
		<%-- si auction > enchère articleOngoing.getSellingPrice()
		<c:if test="">
			${articleOngoing.getSellingPrice()}</p>
		</c:if> --%>
			

	<p>Mise à prix : ${articleOngoing.getOriginalPrice()}</p>

	<p>Fin de l'enchère : ${articleOngoing.getAuctionEndDate()}</p>

	<p>Retrait : ${articleOngoing.getWithdrawal().getStreet()}	${articleOngoing.getWithdrawal().getCp()}	${articleOngoing.getWithdrawal().getCity()}</p>

	<p>Vendeur : ${articleOngoing.getUser().getPseudo()}</p>
<hr>
	<p>Ma proposition :</p>
	<input type="number" min="0" step="1" value="1">
	
	<button type="submit" name="auction">Enchérir</button>
</body>
</html>
