<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>index</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="./Plantillas/css/plantilla-menus.css" />
<link rel="stylesheet" href="./Plantillas/css/cards.css" />
</head>
<body>
	<c:import url="./Plantillas/encabezado.html"></c:import>

	<section class="lateral-flex">
		<div class="sidebar">
			<c:import url="./Plantillas/sidebar.html"></c:import>
		</div>
		<main class="principal">
				<c:forEach items="${listaEmpresa}" var="empresa">
					<a href="/productos?empresa=${empresa.id }" >
						<div class="item-card item-card-producto">
							<div class="card-top">
							<i class="fa fa-star rating"> 4.3</i>
							</div>
							<img src="${empresa.imagen }">
							<p class="item-name">${empresa.nombre }</p>
							<p class="item-price">Precio : $ 13</p>
						</div>
					</a>
				</c:forEach>
				

		</main>

	</section>
</body>
</html>