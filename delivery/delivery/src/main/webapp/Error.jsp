<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="./Plantillas/css/plantilla-menus.css" />
<link rel="stylesheet" href="./Plantillas/css/error.css" />
</head>
<body>
	<c:if test="${usuario.getRol()==2}">
		<c:import url="./Plantillas/encabezado.jsp"></c:import>
	</c:if>
	<c:if test="${usuario.getRol()==1}">
		<c:import url="./Plantillas/encabezadocomercio.jsp"></c:import>
	</c:if>
	<c:if test="${usuario.getRol()==3}">
		<c:import url="./Plantillas/encabezadomotorista.jsp"></c:import>
	</c:if>


	<section>
		<img alt="" src="./Plantillas/recursos/fallo.png"/>
		<h2>Occurrio un Problema, Vuelve a recargar la pagina en unos
			minutos</h2>

	</section>
</body>
</html>