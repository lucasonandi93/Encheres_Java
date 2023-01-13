<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="winAuctionPage.js">
	
</script>
<title>Nouvelle vente</title>
</head>
<body>
	<header>ENI-Enchères</header>

	<h3>Nouvelle vente</h3>

	<fieldset>
		<form>
			<div class="form-group">
				<label for="usr">Article : </label> <input type="text"
					class="form-control" id="article"> <br> <br>
				<div class="form-group">
					<label for="usr">Description : </label> <input type="text"
						class="form-control" id="description"
						onkeypress="this.style.width = ((this.value.length + 1) * 8) + 'px';">
					<label for="categories">Catégorie:</label> <select
						name="categories" id="categories" selected="0">
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
			
			<br><label for="avatar">Photo de l'article :</label>
			<form action="my-script.php" enctype="multipart/form-data"
				method="post">
				<div>
					<input type="file" onchange="handleFiles(files)" id="upload"
						multiple name="file" accept="image/png, image/jpeg">
				</div>
				<div>
					<label for="upload"><span id="preview"></span></label>
				</div>

			</form>
			<script>
 function handleFiles(files) {
   var imageType = /^image\//;
   for (var i = 0; i < files.length; i++) {
   var file = files[i];
   if (!imageType.test(file.type)) {
     alert("veuillez sélectionner une image");
   }else{
     if(i == 0){
       preview.innerHTML = '';
     }
     var img = document.createElement("img");
     img.classList.add("obj");
     img.file = file;
     preview.appendChild(img); 
     var reader = new FileReader();
     reader.onload = ( function(aImg) { 
     return function(e) { 
     aImg.src = e.target.result; 
   }; 
  })(img);

 reader.readAsDataURL(file);
 }
 
 }
}
 </script>
			<br>
			<div class="form-group">
				<label>Mise à prix :</label> <input type="number" step="1" value="1">
				<br><br><label for="beginAuction">Début de l'enchère :</label> <input
					type="date" name="beginAuction"> <label for="endAuction">Fin
					de l'enchère :</label> <input type="date" name="endAuction"> <br><br>
				<fieldset>
					<legend>Retrait</legend>
					Rue : <input type="text" name="street" size="25"> <br><br>
					Code postal : <input type="text" name="cp" size="18"> <br><br>
					Ville : <input type="text" name="city" size="25">
				</fieldset>

			</div>
			</div>
			</div>
			<br> <input type="submit" value="create">
			<button type="cancel"
				onclick="<%=request.getContextPath()%>/ServletListOfAuctions">Annuler</button>
			<button type="redirect"
				onclick="<%=request.getContextPath()%>/ServletListOfAuctions">Annuler
				la vente</button>
		</form>
	</fieldset>
</body>
</html>