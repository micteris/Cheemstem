<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Empresa</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="./Plantillas/css/plantilla-menus.css" />
<link rel="stylesheet" href="./Plantillas/css/cards.css" />
<link rel="stylesheet" href="./Plantillas/css/Pedidos.css" />
</head>
<body>
	<c:import url="./Plantillas/encabezadomotorista.jsp"></c:import>

		<main class="principal">
		
		<c:forEach items="${recolectar}" var="r">
						<div class="item-card" id="${r.id_comercio()}">
							<img src="${r.fotoComercio()}">
							<p class="item-name">${r.nombre_Comercio()}</p>
							<p class="item-name">${r.Direccion()}</p>
							<p class="item-name">Pedido Numero: ${r.id_pedido()}</p>
							<select disabled="disabled">
								 <option id="1" <c:if test="${r.estado()==1 }">selected="selected"</c:if>  value="1">Solicitado</option>
								<option id="2" <c:if test="${r.estado()==2 }">selected="selected"</c:if>   value="2">Preparado</option>
								<option id="3"  <c:if test="${r.estado()==3 }">selected="selected"</c:if>  value="3">Recolectado</option>
								<option id="4" <c:if test="${r.estado()==4 }">selected="selected"</c:if>  value="4">Entregado</option>
							</select>
							
							<a href="<c:if test="${r.estado()==2 }">./estadorecogido?id=${r.id_pedido()}&estado=3&empresa=${r.id_comercio()}</c:if>"><button class="fa fa-hand-rock-o cart-btn"> Recogido</button></a>
							
						</div>
				</c:forEach>		
		
				
		</main>
	
	
</body>
</html>