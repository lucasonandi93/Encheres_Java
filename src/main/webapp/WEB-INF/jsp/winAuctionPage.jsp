<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="winAuctionPage.js">  </script>
<title>Insert title here</title>
</head>
<body>
<header>ENI-Enchères</header>

<h3>Nouvelle vente</h3>

<fieldset>
			<form>
				<div class="form-group">
					<label for="usr">Article : </label> <input type="text"
						class="form-control" id="usr">
						<br>
						<div class="form-group">
					<label for="usr">Description : </label> <input type="text"
						class="form-control" id="usr">
		<label
					for="categories">Catégorie:</label> <select name="categories"
					id="categories" selected="0">
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

 <div class="form-group">
        <label>Quantity: </label>
        <div class="input-group">
            <div class="input-group-btn">
             
                <button id="down" class="btn btn-default" onclick=" down('0')"><span class="glyphicon glyphicon-minus"></span></button>
            </div>
            <input type="text" id="myNumber" class="form-control input-number" value="1" />
            <div class="input-group-btn">
                <button id="up" class="btn btn-default" onclick="up('10')"><span class="glyphicon glyphicon-plus"></span></button>
                
<label for="avatar">Photo de l'article</label>             
           <div class="avatar">RR<input type="file"
       id="avatar" name="avatar"
       accept="image/png, image/jpeg">
       
       </div>
            </div>
        </div> 
    </div>
 
</form>
</fieldset>				
</body>
</html>