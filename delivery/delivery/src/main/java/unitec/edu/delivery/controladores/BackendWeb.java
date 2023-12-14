package unitec.edu.delivery.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.google.gson.Gson;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import unitec.edu.delivery.modelos.DetallePedido;
import unitec.edu.delivery.modelos.Producto;
import unitec.edu.delivery.modelos.Usuario;
import unitec.edu.delivery.repositorio.DetallePedidoRepositorio;
import unitec.edu.delivery.repositorio.PedidoRepositorio;
import unitec.edu.delivery.repositorio.ProductoRepositorio;
import unitec.edu.delivery.repositorio.UsuarioRepositorio;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class BackendWeb {
	@Autowired
	UsuarioRepositorio usuariodb;
	@Autowired
	ProductoRepositorio productodb;
	@Autowired
	PedidoRepositorio pedidodb;
	@Autowired
	DetallePedidoRepositorio detallepedidodb;
	
	@GetMapping("/")
	public String login() {
		
		return "login";
		
	}
	@PostMapping("/ingresar")
	public String ingresar(
			
			@RequestParam("Usuario") String usuario,
			@RequestParam("Password") String pass,
			 HttpSession sesion,
			 Model model
			) {
		Optional<Usuario> existe = usuariodb.findFirst1ByUsuarioAndPass(usuario,pass);
		
		if (existe.isPresent()) {
			sesion.setAttribute("usuario", existe.get());
			
			if (existe.get().getRol()==2) {
				List<Usuario> empresas = usuariodb.findByRol1();
				sesion.setAttribute("listaEmpresa", empresas);
				return "redirect:index.jsp";
			}
			return "redirect:index.jsp";
			
		}else {
			return "redirect:login.jsp";
		}
		
		
	}
	
	@GetMapping("/productos")
	public String productos(@RequestParam(name = "empresa") Integer id
			,Model modal) {
		
		List<Producto> prod = productodb.findByUsuario(id);
		modal.addAttribute("productos", prod);
		return "productos";
		
	}
	

	@SuppressWarnings("unchecked")
	@PostMapping("/carrito")
	public String carrito (
			@RequestParam (name = "sesion") String orden
			,HttpSession session
			) {
		Gson gson = new Gson();
		Map<String, Double> ordenCantidad = gson.fromJson(orden, Map.class);
		
		List<DetallePedido> detalle = new ArrayList<DetallePedido>();
		ordenCantidad.forEach((k,v)->{
			detalle.add(new DetallePedido(productodb.findById(Integer.valueOf(k)).get(),(int) Math.round(v)));
		});
		
		session.setAttribute("pedido", detalle);
		System.out.println("Terminamos");
		return "redirect:./ordenar.jsp?cantidad=" + ordenCantidad.keySet().size();
		
	}
			
	@GetMapping("/Logout")
	public String LogOut(HttpSession LogOut) {
		LogOut.invalidate();
		return "/login";
	}
	
	@PostMapping("/Crearusuario")
	public String postMethodName(@RequestParam (name = "Nombre") String Nombre,
			@RequestParam (name = "Direccion") String Direccion,
			@RequestParam (name = "Usuario") String Usuario,
			@RequestParam (name = "Password") String Password,
			@RequestParam (name = "Rol") Integer Rol,
			@RequestParam (name = "Correo") String Correo,
			@RequestParam (name = "Telefono") String Telefono,
			@RequestParam (name = "Foto") String Foto) {
		usuariodb.save(new Usuario(null, Nombre, Direccion, Correo, Telefono, Foto, Usuario, Password, Rol));
		//TODO: process POST request
		
		return "login";
	}
	

}
