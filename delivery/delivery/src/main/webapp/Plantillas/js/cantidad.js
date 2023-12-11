const orden = JSON.parse(sessionStorage.getItem("orden"))|| {};
const incrementales = document.querySelectorAll(".increase-item")
const descrementales = document.querySelectorAll(".decrease-item")
const add = document.querySelectorAll(".cart-btn")
const carrito = document.querySelector("#cart-plus")

let incrementar = (event)=>{
	const padre= event.target.parentElement
	const cantidad = padre.querySelector("span")
	cantidad.innerHTML=parseInt(cantidad.innerHTML)+1
}
let decrementar = (event)=>{
	const padre= event.target.parentElement
	const cantidad = padre.querySelector("span")
	const valor=parseInt(cantidad.innerHTML)
	if (valor>1){
		cantidad.innerHTML=valor-1
	}
	
}

let agregar = (event)=>{
	const padre= event.target.parentElement
	const cantidad = parseInt(padre.querySelector("span").innerHTML)
	const id = parseInt(padre.id)
	orden[id.toString()]=cantidad
	carrito.innerHTML=" " +Object.keys(orden).length + " Items"
	sessionStorage.setItem("orden",JSON.stringify(orden))
}
let compra = (event)=>{
	const sesion = document.querySelector("#sesion")
	sesion.value=sessionStorage.getItem("orden")
}

incrementales.forEach(i=>{
	i.addEventListener("click",incrementar)
	
})
descrementales.forEach(i=>{
	i.addEventListener("click",decrementar)
	
})
add.forEach(i=>{
	i.addEventListener("click",agregar)
})
carrito.addEventListener("click",compra)