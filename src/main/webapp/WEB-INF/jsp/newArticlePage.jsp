<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/styleNewArticle.css" rel="stylesheet"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script type="text/javascript" src="winAuctionPage.js">
</script>
<title>Nouvelle vente</title>
</head>
<body>
	<header>
		<%@include file="headerFragment.jsp"%>
	</header>

	<h3>Nouvelle vente</h3>
	<!-- <input type="file" onchange="submitForm()" class="multiple" name="files" id="fileUploadBox" 
			value="Upload Files" multiple /> -->
	<fieldset>
		<form action="<%=request.getContextPath()%>/ServletListOfAuctionsPage" method="post">
			<div class="form-group">
				<label for="usr">Article : </label> <input type="text" class="form-control" id="article"> <br>
				<br>
				<div class="form-group">
					<label for="usr">Description : </label> <input type="text" class="form-control" id="description"
						onkeypress="this.style.width = ((this.value.length + 1) * 8) + 'px';">
					<br><label for="categories">Catégorie :</label> 
						<select name="categories" id="categories" selected="0">
							<option value="0"></option>
							<option value="1">Informatique</option>
							<option value="2">Ameublement</option>
							<option value="3">Vêtement</option>
							<option value="4">Sport&Loisirs</option>
							<c:forEach var="category" items="${categoryList}">
								<option value="${category.getWording()}">${category.getWording()}</option>
							</c:forEach>
						</select>
				</div>
			</div>
			<br> <label for="avatar">Photo de l'article</label>
			<div class="avatar">
				<input type="file" id="photoArticle" name="photoArticle" accept="image/png, image/jpeg">
				<img src="dossier/nom_image.jpg alt="Nom de image" />
			</div>
			<br>
			<div class="form-group">
				<label>Mise à prix :</label> <input type="number" step="1" value="1">
				<br><br> <label for="beginAuction">Début de l'enchère :</label> <input
					type="date" name="beginAuction"> <br><br><label for="endAuction">Fin
					de l'enchère :</label> <input type="date" name="endAuction"> <br>
				<br><fieldset>
					<legend>Retrait</legend>
					Rue : <input type="text" name="street" size="25"> <br>
					Code postal : <input type="text" name="cp" size="18"> <br>
					Ville : <input type="text" name="city" size="25">
				</fieldset>

			</div>
			<div><br>
				<input type="submit" value="Ajouter" name="addArticle"> 
				<input type="submit" value="Annuler">
			</div>
		</form>
	</fieldset>
</body>
</html>