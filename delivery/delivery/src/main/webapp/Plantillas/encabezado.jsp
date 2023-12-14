<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div class="fijo">
	<header class="encabezado">
	<div class="titulo">
		<a href="/index.jsp"><img src="./Plantillas/recursos/foodie hunter.png" alt="Logo" /></a>
	</div>
	<div class="caja">
		<a href="">
			<i class="fa fa-map-marker direccion" id="direccion">${usuario.getDireccion()}</i>
		</a>

	</div>
	<form class="util" action="/carrito" method="post">
		<a href=""><i class="fa fa-info-circle">Acerca de</i></a>
		<button type="submit" class="fa fa-cart-plus" id="cart-plus" >0 Items</button>
		<input type="hidden"  value="" name="sesion" id="sesion">
	</form>
	<div class="usuario">
		<a href="/Logout"><i class="fa fa-user-circle" id="usuario"> Log Out</i></a>

	</div>
	
	<script type="text/javascript">
	(()=>{
	let orden = JSON.parse(sessionStorage.getItem("orden"))|| {}
	const carrito = document.querySelector("#cart-plus")
	const sesion = document.querySelector("#sesion")
	sesion.value=sessionStorage.getItem("orden")
	console.log(sesion.value)
	carrito.innerHTML=" "+Object.keys(orden).length + " Items"
	const LogOut = document.querySelector("#usuario")
	let salir = (event)=>{
		console.log("test");
		sessionStorage.removeItem("orden")
	}
	LogOut.addEventListener("click",salir)
	})()
	
	</script>
	
</header>
</div>