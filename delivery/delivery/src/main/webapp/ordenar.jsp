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
								<td><button class="cart-btn fa fa-trash fa-5x remover" id="${p.getProducto().getId()}"></button>
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
					<button class="cart-btn" id="desplegarFormaPago">ORDENAR</button>
				</div>
			</div>

			<section class="ocultar" id="formulario-pago" >
				<form action="/Procesar" method="post"  class="tarjeta" id="formularioPagar">	<p class="cart-title"> Datos de tarjeta</p>
				<label for="Titular">Titular de la tarjeta</label> 
				<input placeholder="Nombre del titular de la tarjeta" id="Titular" type="text" class="validate" name="Titular" required="required"> <br> 
				
				<label for="Fecha">Fecha de caducidad</label> 
				<input placeholder="mm/yyyy" id="Fecha" type="month" class="validate" name="Fecha" required="required"> <br> 
				
				<label for="Codigo">Codigo De Seguridad CVV2</label>
				<input placeholder="* * *" id="Codigo" type="text" class="validate" name="Codigo" pattern="[0-9]{3}" required="required"> <br>
				<input type="hidden" name="subtotal" value="${subtotal }">
				<input type="hidden" name="importe" value="${importe }">
				<input type="hidden" name="total" value="${total }">
				<button class="cart-btn" type="submit">Procesar Orden</button>
				</form>

			</section>

		</main>

	</section>
	<script type="text/javascript" src="./Plantillas/js/ordenar.js"></script>
</body>
</html>