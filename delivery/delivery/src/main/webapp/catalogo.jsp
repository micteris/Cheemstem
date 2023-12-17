<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="ftm"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mis productos</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="./Plantillas/css/plantilla-menus.css" />
<link rel="stylesheet" href="./Plantillas/css/ordenar.css" />
</head>
<body>

	<c:import url="./Plantillas/encabezadocomercio.jsp"></c:import>

	<main class="principal">

		<div class="cart-page">

			<p class="cart-title">MIS PRODUCTOS</p>
			<a href="/AgregarProducto.jsp"><button class="cart-btn fa fa fa-plus fa-2x"> Agregar producto</button></a>
			<table>

				<thead>
					<tr>
						<th>Id</th>
						<th>Descripcion</th>
						<th>Imagen</th>
						<th>Nombre</th>
						<th>Precio</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody id="table-body">
				<c:forEach items="${productos }" var="p">
				<tr>
				
					<td>${p.getId() }</td>
					<td>${p.getDescripcon() }</td>
					<td><img alt="${p.getNombre() }" src="${p.getImagen() }"> </td>
					<td>${p.getNombre() }</td>
					<td><ftm:formatNumber type="CURRENCY" currencySymbol="lps ">
								 ${p.getPrecio()}
								 </ftm:formatNumber></td>
					<td>
					<a href="/ModificarProducto?id=${p.getId() }"><button class="cart-btn fa fa-pencil-square-o fa-5x"> Modificar</button></a>
					<a href="/EliminarProducto?id=${p.getId() }"><button class="cart-btn fa fa-trash fa-5x"> Eliminar</button></a>
					</td>
				
				</tr>
				
					
				
				</c:forEach>
				

			</table>



		</div>

	</main>

</body>
</html>