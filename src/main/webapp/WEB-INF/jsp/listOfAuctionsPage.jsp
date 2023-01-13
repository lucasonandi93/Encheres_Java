<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<%-- <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet"> --%>
<title>Accueil</title>
</head>
<body>
	<header>
		<h3>ENI-Encheres</h3>
		<c:choose>
			<c:when test="${ user !=null}">
				<a href="<%=request.getContextPath()%>/ServletDetailsAuctionPage">Enchères</a>
				<a href="<%=request.getContextPath()%>/ServletNewArticle">Vendre
					un article</a>
				<a href="<%=request.getContextPath()%>/ServletProfilPage">Mon
					profil</a>
				<a href="<%=request.getContextPath()%>/ServletListOfAuctionsPage?deconnexion=true" >${article.getUser().getPseudo()}</a>
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
			<h4>Filtres :</h4>
			<form method="post"
				action="<%=request.getContextPath()%>/ServletListOfAuctionsPage">
				<input type="search" placeholder="Le nom de l'article contient"
					aria-label="Search" name="content" value=""> <label
					for="categories">Catégorie:</label> <select name="categories"
					id="categories" selected="Toutes">
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
								<li>${article.getNameArticle()}</li>
								<li>Prix : ${article.getSellingPrice()}</li>
								<li>Fin de l'enchère : ${article.getAuctionEndDate()}</li>
								<li>Vendeur : ${article.getUser().getPseudo()}
								
									<%-- <a href="<%=request.getContextPath()%>/ServletProfilPage?userProfil=${article.getUser().getPseudo()}">${article.getUser().getPseudo()}</a> --%>
								</li>
							</ul>
						</div>
					</li>
				</div>
			</c:forEach>
		</ul>
</body>
</html>