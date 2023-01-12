<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet">
<title>Encheres une fois connecté</title>
</head>
<body>

<fieldset>
	  <div class="shopping">
<input type="radio" id="shopping" name="shopping" value="shopping">
</div>
   <label for="shopping">Achats :</label>
    <div><input type="radio" name="check" value="check" id="check">
      <label for="check">Enchères ouvertes</label></div>
    <div><input type="radio" name="check" value="check" id="check">
      <label for="check">Mes enchères</label></div>
    <div><input type="radio" name="check" value="check" id="check">
      <label for="check">Mes enchères remportées</label></div>
<div class="shopping">
<input type="radio" id="shopping" name="shopping" value="shopping">
</div>
   <label for="shopping">Mes ventes :</label>
    <div><input type="radio" name="check" value="check" id="check">
      <label for="check">Mes ventes en cours</label></div>
    <div><input type="radio" name="check" value="check" id="check">
      <label for="check">Ventes non débutées</label></div>
    <div><input type="radio" name="check" value="check" id="check">
      <label for="check">Ventes terminées</label></div>


</fieldset>
</body>