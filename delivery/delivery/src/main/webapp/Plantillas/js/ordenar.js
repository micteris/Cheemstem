(()=>{
	
	const ordenar = document.querySelector(".cart-btn")
	const mostrar = (event)=>{
		const ordenar = document.querySelector("#formulario-pago")
		ordenar.classList.remove("ocultar")
	}
	ordenar.addEventListener("click",mostrar)
	
})()