<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Détail vente</title>
</head>
<body>
	<header>ENI-Enchères</header>

	<h3>Détail Vente</h3>

	<p>${articleOngoing.getNameArticle()}</p>

	<p>Description : ${articleOngoing.getDescription()}</p>

	<p>Catégorie : ${articleOngoing.getCategory().()}</p>

	<p>Meilleure offre : ${articleOngoing.getSellingPrice()}</p>

	<p>Mise à prix : ${articleOngoing.getOriginalPrice()}</p>

	<p>Fin de l'enchère : ${articleOngoing.getAuctionEndDate()}</p>

	<p>Retrait : </p>

	<p>Vendeur : </p>
<hr>
	<p>Ma proposition :</p>
	<input type="number" step="1" value="1">
	
	<button type="submit" name="auction">Enchérir</button>
</body>
</html>
