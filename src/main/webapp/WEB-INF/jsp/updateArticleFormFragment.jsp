<h3>Modifier Article</h3>
	<!-- <input type="file" onchange="submitForm()" class="multiple" name="files" id="fileUploadBox" 
			value="Upload Files" multiple /> -->
	<fieldset>
		<form action="<%=request.getContextPath()%>/ServletNewArticle" method="post" enctype="multipart/form-data">
		<input name="articleID" value="${articleOngoing.noArticle}" hidden>
			<div class="form-group">
				<label for="usr">Article : </label> <input type="text"
					class="form-control" name="articleName" id="article" value="${articleOngoing.getNameArticle()}"> <br>
				<br>
				<div class="form-group">
					<label for="usr">Description : </label> <input type="text"
						class="form-control" id="description" name="articleDescription"  value="${articleOngoing.getDescription()}">
					<br> <label for="categories">Catégorie :</label> <select
						name="articleCategorie" id="categories" >
						<option value="${articleOngoing.category.wording}">${articleOngoing.category.wording}</option>
						<c:forEach var="category" items="${categoryList}"> 
							<option value="${category.getWording()}">${category.getWording()}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<br> <label for="avatar">Photo de l'article</label>
			<div class="avatar">
				<input type="file" id="photoArticle" name="photoArticle"
					accept="image/png, image/jpeg" onchange="onFileSelected(event)">
					<div id="imageDisplay">
						<img id="myimage" alt="imageEnchere" src="">
					</div>
			</div>
			<br>
			<div class="form-group">
				<label>Mise à prix :</label> 
				<input type="number" step="1" name="articleOriginalPrice" value="${articleOngoing.getOriginalPrice()}"> <br>
				<br> <label for="beginAuction">Début de l'enchère :</label> 
				<input type="date" name="articleStartDate" id="startDate" required value="${articleOngoing.getAuctionStartDate()}">
				<script>
					// Obtient la date actuelle
					var currentDate = new Date();
					// Prend la dâte actuelle et lui ajoute +1 (lendemain)
					currentDate.setDate(currentDate.getDate() + 1);
					// et la Défini en date minimum à rentrer sur le calendrier
					document.getElementById("startDate").min = currentDate
							.toISOString().slice(0, 10);
				</script>
				<br>
				<br> <label for="endAuction">Fin de l'enchère :</label> <input
					type="date" name="articleEndDate" value="${articleOngoing.getAuctionEndDate()}"> <br> <br>
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
				<br> 
				<input type="submit" value="Enregistrer" name="addArticle">
				<a href="<%=request.getContextPath() %>/ServletDetailsAuctionPage?articleID=${articleOngoing.noArticle}" >Annulé</a>
			</div>
		</form>
	</fieldset>
	<form action="<%=request.getContextPath() %>/ServleteDeleteArticle" method="post">
    	<input type="hidden" name="idArticle" value="${articleOngoing.noArticle}">
    	<input type="submit" value="Annuler vente" name="cancelSale">
	</form>
	
<script type="text/javascript">
const imageDisplay = document.getElementById("imageDisplay"); 
function onFileSelected(event) {
	var selectedFile = event.target.files[0];
	var reader = new FileReader();   
	var imgtag = document.getElementById("myimage");
	imgtag.title = selectedFile.name;   
	reader.onload = function(event) {
		imgtag.src = event.target.result;
	  };
	reader.readAsDataURL(selectedFile);
	displayImageOn();
	} function displayImageOn() {
	    imageDisplay.style.display = "block";
	}
</script>