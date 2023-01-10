<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet">
<title>Liste des enchères</title>
</head>
<body>
<header>
<form action="<%=request.getContextPath() %>/ServletConnexionPage">S'inscrire
<a href="<%=request.getContextPath() %>/ServletConnexionPage" class="connexion">S'inscrire - Se connecter</a>
</form></header>

ENI-Encheres
	<div class="title"><h2>Liste des enchères</h2></div>

<nav class="navbar navbar-light bg-light">
  <form class="form-inline">
  
  Filtres :
  <br>
    <input class="form-control mr-sm-2" type="search" placeholder="Le nom de l'article contient" aria-label="Search">
    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Rechercher</button>
  </form>
</nav>
 <div class="bloc">
<div class="select">
<br>
Catégorie :
<select name="nom_select" onchange="loadImg(this.value);">
<option>Toutes</option>
<option value= "1">Informatique</option>
<option value= "2">Ameublement</option>
<option value= "3">Vêtements</option>
<option value= "4">Sport&Loisirs</option>
</select>
</div>
</div>

<br>
<div class="boiteArticle">Test
<img src="nom_select.png" id="id_img" />
<script type="text/javascript">
function loadImg(key) {
    var arr = [
        '1_10',
        '2_10',
        '3_10',
        '1_30',
        '2_30',
        '3_30',
        //.....
    ];
    document.getElementById('id_img').src = 'img/productImage/' + arr[key] + '.png';
}
</script>
</div>

</body>
</html>