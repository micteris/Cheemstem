<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="ftm"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agregar productos</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="./Plantillas/css/plantilla-menus.css" />
<link rel="stylesheet" href="./Plantillas/css/ordenar.css" />
</head>
<body>

<c:import url="./Plantillas/encabezadocomercio.jsp"></c:import>

	<main class="principal mostrar">
		
		<form action="/addProducto" method="post"  class="tarjeta">
			<h5>Vista Previa</h5>
			<div class="vistaPrevia">
			<img id="previa" src="" width="150">
			</div>
			
			<p class="cart-title"> Agregar producto</p>
			<label for="descripcion">Descripcion: </label>
			<input type="text" required="required" name="descripcion" id="descripcion">
			<label for="imagen">Imagen: </label>
			<input type="text" required="required" name="imagen" id="imagen">
			<label for="nombre">Nombre: </label>
			<input type="text" required="required" name="nombre" id="nombre">
			<label for="precio">Precio: </label>
			<input type="text" required="required" name="precio" id="precio">
			<button class="cart-btn" type="submit">Crear Producto</button>							
		</form>
		
		
		
	
	</main>
	<script type="text/javascript" src="./Plantillas/js/VistaPrevia.js"></script>
</body>
</html>