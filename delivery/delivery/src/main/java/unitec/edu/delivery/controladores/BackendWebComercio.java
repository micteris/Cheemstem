package unitec.edu.delivery.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import unitec.edu.delivery.modelos.DetallePedido;
import unitec.edu.delivery.modelos.Pedido;
import unitec.edu.delivery.modelos.Producto;
import unitec.edu.delivery.modelos.Usuario;
import unitec.edu.delivery.repositorio.DetallePedidoRepositorio;
import unitec.edu.delivery.repositorio.ProductoRepositorio;

@Controller
public class BackendWebComercio {
	@Autowired
	ProductoRepositorio productodb;
	@Autowired
	DetallePedidoRepositorio detalledb;
	
	
	@GetMapping("/catalogo")
	public String catalogo(
			@SessionAttribute("usuario") Usuario usuario
			,Model modal
			) {
		
			List<Producto> productos = productodb.findByUsuario(usuario.getId());
			modal.addAttribute("productos", productos);
			
		
		return "catalogo";
	}
	@GetMapping("/EliminarProducto")
	public String EliminarProducto(
			@RequestParam("id") Integer id
			) {			
		
		productodb.deleteById(id);
		
		return "redirect:/catalogo";
	}
	
	@PostMapping("/addProducto")
	public String addProducto(
			@RequestParam("descripcion") String descripcion,
			@RequestParam("imagen") String imagen,
			@RequestParam("nombre") String nombre,
			@RequestParam("precio") Float precio,
			@SessionAttribute("usuario") Usuario usuario
			) {
		
		productodb.save(new Producto(null, descripcion, imagen, nombre, precio, usuario, (float) 5.0));
		
		
		
		return "redirect:/catalogo";
	}
	
	@GetMapping("/ModificarProducto")
	public String ModificarProducto(
			@RequestParam("id") Integer id
			,Model modal
			) {
		modal.addAttribute("producto", productodb.findById(id).get());
		return "ModificarProducto";
		
	}
	
	@PostMapping("/modProducto")
	@Transactional
	public String modProducto(
			@RequestParam("descripcion") String descripcion,
			@RequestParam("imagen") String imagen,
			@RequestParam("nombre") String nombre,
			@RequestParam("precio") Float precio,
			@RequestParam("id") Integer id
			) {
		
			Producto producto = productodb.findById(id).get();
			
			producto.setDescripcon(descripcion);
			producto.setNombre(nombre);
			producto.setImagen(imagen);
			producto.setPrecio(precio);
		return "redirect:/catalogo";
	}
	
	@GetMapping("/estado")
	@Transactional
	public String estado(
			@RequestParam("id") Integer id,
			@RequestParam("estado") Integer estado
			) {
		
		DetallePedido detalle = detalledb.findById(id).get();
		
		detalle.setEstado(estado);
		
		Pedido pedido = detalle.getPedido();
		
		 Integer Pendientes = detalledb.findByPedido(pedido,estado);
		 
		 if (Pendientes<2) {
			 pedido.setEstado(estado);
		 }
		 
		
		
		
		return "redirect:./index";
	}

}
