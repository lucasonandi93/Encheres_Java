
<%@page import="fr.eni.enchere.bll.UserManager"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%-- <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet"> --%>
<title>Accueil</title>
</head>
<body>
	<header>
		<h3>ENI-Encheres</h3>
		<a href="<%=request.getContextPath()%>/ServletConnexionPage">S'inscrire
			- Se connecter</a>
	</header>

	<main>
		<div>
			<h3>Liste des enchères</h3>
		</div>
		<nav>
			<h4>Filtres :</h4>
			<form method="get" action="<%=request.getContextPath()%>/ServletListOfAuctionsPage">
				<input type="search" placeholder="Le nom de l'article contient"
					aria-label="Search" name="content" value=""> <label
					for="categories">Catégorie:</label> <select name="categories"
					id="categories" selected="Toutes">
					<option value="Toutes">Toutes</option>
					<c:forEach var="category" items="${categoryList}">
						<option value="${category.getWording()}">${category.getWording()}</option>
					</c:forEach>
				</select>
				<button type="submit">Rechercher</button>
			</form>
		</nav>
		<ul>
			<c:forEach var="article" items="${articleList}">
				<div>
					<li>
						<div>
							<img alt="IMAGE" src="" title="IMAGE">
							<ul>
								<li>${article.getNameArticle()}</li>
								<li>Prix : ${article.getSellingPrice()}</li>
								<li>Fin de l'enchère : ${article.getAuctionEndDate()}</li>
								<%
									UserManager userManager = new UserManager();
								%>
								<li>Vendeur : <a href="<%=request.getContextPath()%>/ServletProfilPage">${userManager.selectById(article.getNoUser).getPseudo()}</a></li>
							</ul>
						</div>
					</li>
				</div>
			</c:forEach>
		</ul>
</body>
</html>