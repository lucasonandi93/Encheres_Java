
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/style.css"
	rel="stylesheet">
<title>Accueil</title>
</head>
<body>
	<header>
		<h3>ENI-Encheres</h3>
		<a href="<%=request.getContextPath()%>/ServletConnexionPage"
			class="connexion">S'inscrire - Se connecter</a>
	</header>

	<main>
		<div class="title">
			<h3>Liste des enchères</h3>
		</div>
		<nav class="navbar navbar-light bg-light">
			<h4>Filtres :</h4>
			<form class="form-inline" method="post"
				action="<%=request.getContextPath()%>/ServletListOfAuctionsPage">
				<input class="form-control mr-sm-2" type="search" placeholder="Le nom de l'article contient" aria-label="Search" name="content" value=""> 
				<label for="categories">Catégorie:</label> 
				<select name="categories" id="categories">
					<c:forEach var="category" items="${categoryList}">
						<option>Toutes</option>
			  			<option value="${category.getWording()}">${category.getWording()}>
					</c:forEach>
				</select>
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Rechercher</button>
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
								<li>Prix : ${article.getSellingPrice}</li>
								<li>Fin de l'enchère : ${article.getAuctionEndDate()}</li>
								<li>Vendeur : <a href="<%=request.getContextPath()%>/ServletProfilPage">${article.getNoUser()}</a></li>
							</ul>
						</div>
					</li>
				</div>
			</c:forEach>
		</ul>


	</main>
</body>
</html>