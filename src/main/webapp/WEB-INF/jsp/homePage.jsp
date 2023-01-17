<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/styleTest.css"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Accueil</title>
</head>
<body>
	<header>
		<%@include file="headerFragment.jsp"%>
		<c:choose>
			<c:when test="${ sessionScope.user !=null}">
				<a href="<%=request.getContextPath()%>/ServletDetailsAuctionPage">Enchères</a>
				<a href="<%=request.getContextPath()%>/ServletNewArticle">Vendre
					un article</a>
				<a
					href="<%=request.getContextPath()%>/ServletProfilPage?userProfil=${sessionScope.user.getNoUser()}">Mon
					profil</a>
				<a
					href="<%=request.getContextPath()%>/ServletListOfAuctionsPage?deconnexion=true">Déconnexion</a>
			</c:when>
			<c:otherwise>
				<a href="<%=request.getContextPath()%>/ServletConnexionPage">S'inscrire
					- Se connecter</a>
			</c:otherwise>
		</c:choose>
	</header>
	<div>
		<h3>Liste des enchères</h3>
	</div>
	<nav>
		<h4>Filtres :</h4><br>
		<form method="post"
			action="<%=request.getContextPath()%>/ServletListOfAuctionsPage">
			<input type="search" placeholder="Le nom de l'article contient"
				aria-label="Search" name="content" value="">
			<br><br><br><br>
			<label for="categories">Catégorie :   </label><select
				name="categories" id="categories">
				<option value="Toutes">Toutes</option>
				<c:forEach var="category" items="${categoryList}">
					<option value="${category.getWording()}">${category.getWording()}</option>
				</c:forEach>
			</select>

			<c:if test="${ user !=null}">
				<%@include file="selectFormFragment.jsp"%>
			</c:if>

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
							<li><a
								href="<%=request.getContextPath()%>/ServletDetailsAuctionPage?articleID=${article.getNoArticle()}">${article.getNameArticle()}</a></li>
							<li>Prix : ${article.getSellingPrice()}</li>
							<li>Fin de l'enchère : ${article.getAuctionEndDate()}</li>
							<!-- ${article.getUser().getPseudo()} -->
							<li>Vendeur : <a
								href="<%=request.getContextPath()%>/ServletProfilPage?userProfil=${article.getUser().getNoUser()}">${article.getUser().getPseudo()}</a></li>
						</ul>
						<br><hr>
					</div>
				</li>
			</div>
		</c:forEach>
	</ul>
</body>
</html>