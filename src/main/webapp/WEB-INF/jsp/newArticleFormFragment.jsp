<div class="flex">
<h2>Nouvelle vente</h2>
</div>
<!-- <input type="file" onchange="submitForm()" class="multiple" name="files" id="fileUploadBox" 
			value="Upload Files" multiple /> -->
		<!--
		<form action="<%=request.getContextPath()%>/ServletNewArticle" method="post" enctype="multipart/form-data">
			<label for="usr">Article : </label>
			<input type="text" class="form-control" name="articleName" id="article">
			<label for="usr">Description : </label>
			<input type="text" class="form-control" id="description" name="articleDescription">
			<label for="imgArticle">Photo de l'article</label>
			<input type="file" id="photoArticle" name="photoArticle" accept="image/png, image/jpeg" required>
			<input type="submit" value="Ajouter" name="addArticle">
		</form>-->
<div class="flex padding-top-bottom-20px centrer">
	<fieldset>
	<form action="<%=request.getContextPath()%>/ServletNewArticle" method="post" enctype="multipart/form-data">
		<div class="form-group">
			<label for="usr">Article : </label> <input type="text"
				class="form-control" name="articleName" id="article"> <br>
			<br>
			<div class="form-group">
				<label for="usr">Description : </label> <input type="text"
					class="form-control" id="description" name="articleDescription">
				<br> <label for="categories">Catégorie :</label><select
					name="articleCategorie" id="categories">
					<option value="Toutes">Toutes</option>
					<c:forEach var="category" items="${categoryList}">
						<option value="${category.getWording()}">${category.getWording()}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<br> <label for="imgArticle">Photo de l'article</label>
		<div class="photoArticle">
			<input type="file" id="photoArticle" name="photoArticle"
				accept="image/png, image/jpeg" required>
		</div>
		<br>
		<div class="form-group">
			<label>Mise à prix :</label> 
			<input type="number" step="1" value="0"	name="articleOriginalPrice"> <br> <br> 
			<label for="beginAuction">Début de l'enchère :</label> <input type="date"
				name="articleStartDate" id="startDate" required>
			<script>
				// Obtient la date actuelle
				var currentDate = new Date();
				// Prend la dâte actuelle et lui ajoute +1 (lendemain)
				currentDate.setDate(currentDate.getDate() + 1);
				// et la Défini en date minimum à rentrer sur le calendrier
				document.getElementById("startDate").min = currentDate
						.toISOString().slice(0, 10);
			</script>
			<br> <br> <label for="endAuction">Fin de l'enchère
				:</label> <input type="date" name="articleEndDate"> <br> <br>
			<fieldset>
				<legend>Retrait</legend>
				Rue : <input type="text" name="withdrawalStreet"
					value="${sessionScope.user.getStreet() }" size="25" maxlength="30">
				<br> Code postal : <input type="text" name="withdrawalCp"
					value="${sessionScope.user.getCp() }" size="18" maxlength="15">
				<br> Ville : <input type="text" name="withdrawalCity"
					value="${sessionScope.user.getCity() }" size="25" maxlength="30">
			</fieldset>

		</div>
		<div>
			<br> <input type="submit" value="Ajouter" name="addArticle">
			<a
				href="<%=request.getContextPath() %>/ServletListOfAuctionsPage">
					<input type="button" value="Annuler">
			</a>
		</div>
	</form>
	
</fieldset>
</div>