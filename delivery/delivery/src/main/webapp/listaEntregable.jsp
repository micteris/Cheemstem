<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="ftm"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Pedidos</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="./Plantillas/css/plantilla-menus.css" />
<link rel="stylesheet" href="./Plantillas/css/cards.css" />
<link rel="stylesheet" href="./Plantillas/css/Pedidos.css" />
</head>
<body>
	<c:import url="./Plantillas/encabezadomotorista.jsp"></c:import>

	<section class="lateral-flex">
		<!--<div class="sidebar">-->
			<!--<c:import url="./Plantillas/sidebar.html"></c:import>-->
		<!--</div>-->
		<main class="principal">
				<c:forEach items="${entregables}" var="entrega">
						<div class="item-card">
							<img src="${entrega.getCliente().getImagen()}">
							<p class="item-name">Cliente: ${entrega.getCliente().getNombre()}</p>
							<p class="item-name">Tel: ${entrega.getCliente().getTelefono()}</p>
							<p class="item-name">Pedido Numero: ${entrega.getId()}</p>
							<p class="item-name">Ubicacion: ${entrega.getUbicacion()}</p>
							<select disabled="disabled">
								 <option id="1" <c:if test="${entrega.getEstado()==1 }">selected="selected"</c:if>  value="1">Solicitado</option>
								<option id="2" <c:if test="${entrega.getEstado()==2 }">selected="selected"</c:if>   value="2">Preparado</option>
								<option id="3"  <c:if test="${entrega.getEstado()==3 }">selected="selected"</c:if>  value="3">Recolectado</option>
								<option id="4" <c:if test="${entrega.getEstado()==4 }">selected="selected"</c:if>  value="4">Entregado</option>
							</select>
							<a href="./estadoentregado?id=${entrega.getId()}&estado=4"><button class="fa fa-handshake-o cart-btn"> Entregado</button></a>
							
						</div>
				</c:forEach>
				

		</main>

	</section>
</body>
</html>