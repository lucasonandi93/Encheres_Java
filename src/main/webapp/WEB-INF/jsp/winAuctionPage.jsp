<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="winAuctionPage.js"></script>
<title>Insert title here</title>
</head>
<body>
	<header>
		<%@include file="headerFragment.jsp"%>
	</header>

	<h3>Nouvelle vente</h3>

	<fieldset>
		<form>
			<div class="form-group">
				<label for="usr">Article : </label> <input type="text"
					class="form-control" id="article"> <br><br>
				<div class="form-group">
					<label for="usr">Description : </label> <input type="text"
						class="form-control" id="description" onkeypress="this.style.width = ((this.value.length + 1) * 8) + 'px';"> 
						<label for="categories">Catégorie:</label>
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
			<br>
			<label for="avatar">Photo de l'article</label>
			<div class="avatar">
				<input type="file" id="avatar" name="avatar"
					accept="image/png, image/jpeg">
			</div>
			<br>
			<div class="form-group">
				<label>Mise à prix :</label>
				<div class="input-group">
					<div class="input-group-btn">

						<button id="down" class="btn btn-default" onclick=" down('0')">
							<span class="glyphicon glyphicon-minus"></span>
						</button>
					</div>
					<input type="text" id="myNumber" class="form-control input-number"
						value="1" />
					<div class="input-group-btn">
						<button id="up" class="btn btn-default" onclick="up('10')">
							<span class="glyphicon glyphicon-plus"></span>
						</button>
						<br>
	<label for="beginAuction">Début de l'enchère :</label>
	<input type="date" name="beginAuction">
	<label for="endAuction">Fin de l'enchère :</label>
	<input type="date" name="endAuction">
<br>
	<fieldset><legend>Retrait</legend>
	Rue : <input type="text" name="street" size="25">
	<br>
	Code postal : <input type="text" name="cp" size="18">
	<br>
	Ville : <input type="text" name="city" size="25">
	</fieldset>

					</div>
				</div>
			</div>
			<br>
	<input type="submit" value="create"> 
<button type="cancel" onclick="<%=request.getContextPath() %>/ServletListOfAuctions">Annuler</button>
		</form>
	</fieldset>
</body>
</html>