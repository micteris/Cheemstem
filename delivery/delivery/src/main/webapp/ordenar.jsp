<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="ftm"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Producto</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="./Plantillas/css/plantilla-menus.css" />
<link rel="stylesheet" href="./Plantillas/css/ordenar.css" />
</head>
<body>
	<c:import url="./Plantillas/encabezado.jsp"></c:import>

	<section class="lateral-flex">
		<!--  <div class="sidebar">
			<c:import url="./Plantillas/sidebar.html"></c:import>
		</div>-->
		<main class="principal">

			<div class="cart-page">

				<p class="cart-title">DETALLE DEL PEDIDO</p>
				<table>

					<thead>
						<tr>
							<th>Item</th>
							<th>Nombre</th>
							<th>Cantidad</th>
							<th>Precio</th>
							<th>Remover Elemento</th>
						</tr>
					</thead>
					<tbody id="table-body">
						<c:set var="cantidad" value="${0 }" />
						<c:set var="subtotal" value="${0.0 }" />
						<c:set var="importe" value="${0.0 }" />
						<c:set var="total" value="${0.0 }" />

						<c:forEach items="${pedido }" var="p">
							<tr>
								<td><img src="${p.getProducto().getImagen() }"></td>
								<td>${p.getProducto().getNombre() }</td>
								<td><span>${p.getCantidad() }</span></td>
								<td><ftm:formatNumber type="CURRENCY" currencySymbol="lps ">
								 ${p.getProducto().getPrecio()*p.getCantidad()}
								 </ftm:formatNumber></td>
								<c:set var="cantidad" value="${cantidad+1 }" />
								<c:set var="subtotal"
									value="${subtotal+p.getProducto().getPrecio()*p.getCantidad() }" />
								<td><button class="decrease-item fa fa-trash fa-5x"></button>
								<td>
							</tr>
						</c:forEach>
						<c:set var="importe" value="${subtotal*0.15 }" />
						<c:set var="total" value="${subtotal+importe }" />
					</tbody>

				</table>
				<div class="checkout">
					<p class="total-item">Total Item : ${cantidad }</p>
					<p class="total-price">
						SubTotal:
						<ftm:formatNumber type="CURRENCY" currencySymbol="lps ">${subtotal }</ftm:formatNumber>
					</p>
					<p class="total-item">
						Impuesto:
						<ftm:formatNumber type="CURRENCY" currencySymbol="lps ">${importe }</ftm:formatNumber>
					</p>
					<p class="total-price">
						Total:
						<ftm:formatNumber type="CURRENCY" currencySymbol="lps ">${total }</ftm:formatNumber>
					</p>
					<button class="cart-btn">ORDENAR</button>
				</div>

			</div>

			<section class="ocultar" id="formulario-pago">
				<form action="/Procesar" method="post">	<span class="card-title"> Datos de tarjeta</span>
				<br> <br> 
				<label for="Titular">Titular de la tarjeta</label> <br> 
				<input placeholder="Nombre del titular de la tarjeta" id="Titular" type="text" class="validate" name="Titular"> <br> 
				
				<label for="Fecha">Fecha de caducidad</label> <br> 
				<input placeholder="mm/yyyy" id="Fecha" type="text" class="validate" name="Fecha" pattern="\d{1,2}/\d{4}"> <br> 
				
				<label for="Codigo">Codigo De Seguridad CVV2</label><br>
				<input placeholder="* * *" id="Codigo" type="text" class="validate" name="Codigo" pattern="[0-9]{3}"> <br>
				
				<label for=""></label>
				<input placeholder="" id="" type="text" class="" name="" pattern="">
				
			




					<button class="cart-btn" type="submit">Procesar Orden</button>
				</form>
				formulario de pago

			</section>

		</main>

	</section>
	<script type="text/javascript" src="./Plantillas/js/ordenar.js"></script>
</body>
</html>