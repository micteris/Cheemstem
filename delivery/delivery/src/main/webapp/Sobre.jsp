<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sobre Nosotros</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="./Plantillas/css/plantilla-menus.css" />
<link rel="stylesheet" href="./Plantillas/css/sobrenosotros.css" />
</head>
<body>
	<c:if test="${usuario.getRol()==2}">
	<c:import url="./Plantillas/encabezado.jsp"></c:import>
	</c:if>
		<c:if test="${usuario.getRol()==1}">
	<c:import url="./Plantillas/encabezadocomercio.jsp"></c:import>
	</c:if>
	
	<header>
		<h1>Bienvenido a Cheemstem</h1>
	</header>
	<section id="about-us">
		<h2>Nuestra Historia</h2>
		<p>Somos una empresa dedicada a la venta en línea de alimentos
			frescos y deliciosos, fundada por un apasionado estudiante de la
			clase "Desarrollo de Aplicaciones de Vanguardia". Desde nuestros
			inicios, nos hemos comprometido a ofrecer productos de alta calidad y
			un servicio excepcional.</p>
	</section>

	<section id="mission">
		<h2>Nuestra Misión</h2>
		<p>En Cheemstem, nos esforzamos por proporcionar a nuestros
			clientes alimentos de distinta indole para todos los gustos.
			Respaldado por ingredientes frescos y de origen local siempre que sea
			posible.</p>
	</section>

	<section id="founder">
		<h2>Nuestro Fundador</h2>
		<p>La empresa fue fundada por Jose Claros, un estudiante de
			desarrollo de aplicaciones de vanguardia. Su visión de facilitar el
			acceso a alimentos de calidad se ha convertido en la piedra angular
			de nuestra empresa.</p>
	</section>


	<footer>
		<p>&copy; 2023 Cheemstem. Todos los derechos reservados.</p>
	</footer>
</body>
</html>