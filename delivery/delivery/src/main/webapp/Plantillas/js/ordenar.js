(()=>{
	
	const ordenar = document.querySelector("#desplegarFormaPago")
	
	const remover = document.querySelectorAll(".remover")
	const formularioSubmit =document.querySelector("#formularioPagar")
	
	formularioSubmit.addEventListener("submit",(event)=>{
		sessionStorage.removeItem("orden")
	})
	
	
	const mostrar = (event)=>{
		const ordenar = document.querySelector("#formulario-pago")
		ordenar.classList.remove("ocultar")
		ordenar.classList.add("mostrar")
	}
	const quitar = (event,id)=>{
		console.log(id)
		const orden = JSON.parse(sessionStorage.getItem("orden"))|| {};
		delete orden[id.toString()]
		sessionStorage.setItem("orden",JSON.stringify(orden))
		const input = document.querySelector("#sesion")
		input.value=sessionStorage.getItem("orden")
		const formulario = document.querySelector("#formularioCarrito")
		formulario.submit();
	}
	
	remover.forEach(r =>{
		
		r.addEventListener("click",(event)=> quitar(event,r.id))
	})
	
	
	ordenar.addEventListener("click",mostrar)
	
})()