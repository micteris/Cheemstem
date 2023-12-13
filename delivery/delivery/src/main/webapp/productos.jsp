<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="ftm" %>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Producto</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="./Plantillas/css/plantilla-menus.css" />
<link rel="stylesheet" href="./Plantillas/css/cards.css" />
</head>
<body>
	<c:import url="./Plantillas/encabezado.jsp"></c:import>

	<section class="lateral-flex">
		<!--  <div class="sidebar">
			<c:import url="./Plantillas/sidebar.html"></c:import>
		</div>-->
		<main class="principal">
				<c:forEach items="${productos}" var="producto">
						<div class="item-card item-card-producto" id="${producto.getId() }" >
							<div class="card-top">
							<i class="fa fa-star rating"> ${producto.getRating() }</i>
							</div>
							<img src="${producto.getImagen() }">
							<p class="item-name">${producto.getNombre() }</p>
							<p class="item-price">
								<ftm:formatNumber type="CURRENCY" currencySymbol="Precio : lps ">
								${producto.getPrecio()}</ftm:formatNumber> </p>
							<button class=" fa fa-cart-plus cart-btn">add</button>
							<button class="decrease-item">-</button>
							<span>1</span>
							<button class="increase-item">+</button>
						</div>
				</c:forEach>
				

		</main>

	</section>
	<script type="text/javascript" src="./Plantillas/js/cantidad.js"></script>
</body>
</html>