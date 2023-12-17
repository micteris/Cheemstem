<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Motorista</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="./Plantillas/css/plantilla-menus.css" />
<link rel="stylesheet" href="./Plantillas/css/cards.css" />
<link rel="stylesheet" href="./Plantillas/css/Pedidos.css" />
</head>
<body>
	<c:import url="./Plantillas/encabezadomotorista.jsp"></c:import>

		<main class="principal">
		
		<c:forEach items="${PedidosRepartir}" var="pendiente">
						<div class="item-card" id="${pendiente.getId()}">
							<img src="${pendiente.getRepartidor()}">
							<p class="item-name">${pendiente.getRepartidor().getNombre()}</p>
							<p class="item-name">Pedido Numero: ${pendiente.getId()}</p>
							<select disabled="disabled">
								 <option id="1" <c:if test="${pendiente.getEstado()==1 }">selected="selected"</c:if>  value="1">Solicitado</option>
								<option id="2" <c:if test="${pendiente.getEstado()==2 }">selected="selected"</c:if>   value="2">Preparado</option>
								<option id="3"  <c:if test="${pendiente.getEstado()==3 }">selected="selected"</c:if>  value="3">Recolectado</option>
								<option id="4" <c:if test="${pendiente.getEstado()==4 }">selected="selected"</c:if>  value="4">Entregado</option>
							</select>
							
						</div>
				</c:forEach>	
		
				
		</main>
	
	
</body>
</html>