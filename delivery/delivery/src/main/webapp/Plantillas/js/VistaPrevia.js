const imagen = document.querySelector("#imagen")
const previa = document.querySelector("#previa")
const actualizarFoto = (event)=>{
	previa.src= event.target.value 
	console.log("Si se ejecuto")
}

imagen.addEventListener("change",actualizarFoto)