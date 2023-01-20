<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/styleHomePage.css"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Accueil</title>
</head>
<body>
	<header>
		<%@include file="headerFragment.jsp"%>
		<c:choose>
			<c:when test="${ sessionScope.user !=null}">
				<a href="<%=request.getContextPath()%>/ServletListOfAuctionsPage">Enchères</a>
				<a href="<%=request.getContextPath()%>/ServletNewArticle">Vendre
					un article</a>
				<a
					href="<%=request.getContextPath()%>/ServletProfilPage?userProfil=${sessionScope.user.getNoUser()}">Mon
					profil</a>
				<a
					href="<%=request.getContextPath()%>/ServletListOfAuctionsPage?deconnexion=true">Déconnexion</a>
			</c:when>
			<c:otherwise>
				<a class="article-link-hover"
					href="<%=request.getContextPath()%>/ServletConnexionPage">S'inscrire
					- Se connecter</a>
			</c:otherwise>
		</c:choose>
	</header>
	<nav>
		<div class="space-evenly padding-top-bottom-20px">
			<form method="post"
				action="<%=request.getContextPath()%>/ServletListOfAuctionsPage"
				class="filter-form">
				<div class="justify-content-center margin-left-right-10px">
					<div class="margin-left-right-50px">
						<h2>Liste des enchères</h2>
					</div>
					<select name="categories" id="categories">
						<option value="Toutes" selected >Toutes</option>
						<c:forEach var="category" items="${categoryList}">
							<option value="${category.getWording()}">${category.getWording()}</option>
						</c:forEach>
					</select>
				</div>
				<div class="justify-content-center margin-left-right-10px">
					<input type="search" placeholder="Le nom de l'article contient"
						aria-label="Search" name="content" value="">
				</div>
				<c:if test="${ user !=null}">
					<%@include file="selectFormFragment.jsp"%>
				</c:if>
				<div class="justify-content-center">
					<button type="submit" class="width-100 margin-left-right-10px">Rechercher</button>
				</div>
			</form>
		</div>
	</nav>

	<div class="list-article margin-left-right-50px">
		<c:forEach var="article" items="${articleList}">
			<div>
				<form
					action="<%=request.getContextPath()%>/ServletDetailsAuctionPage"
					method="get">
					<input type="hidden" value="${article.getNoArticle()}"
						name="articleID">
					<button class="btn-article" type="submit">
						<img class="margin-top-10px" src="<%=request.getContextPath()%>${article.getImageName()}"
							alt="Image de l'article ${article.imageName}" id="photoArticle">
						<ul>
							<li>
								<h3>${article.getNameArticle()}</h3>
							</li>
							<li>Prix : ${article.getSellingPrice()} pts</li>
							<li>Début de l'enchère : ${article.getAuctionStartDate()}</li>
							<li>Fin de l'enchère : ${article.getAuctionEndDate()}</li>
						</ul>
					</button>
				</form>
				<form action="<%=request.getContextPath()%>/ServletProfilPage">
					<input type="hidden" name="userProfil"
						value="${article.getUser().getNoUser()}">
					<button class="btn-vendeur" type="submit">Vendeur :
						${article.getUser().getPseudo()}</button>
				</form>
			</div>
		</c:forEach>
	</div>
</body>
</html>