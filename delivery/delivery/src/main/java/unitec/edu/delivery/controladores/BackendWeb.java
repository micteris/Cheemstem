package unitec.edu.delivery.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.google.gson.Gson;

import jakarta.servlet.http.HttpSession;
import unitec.edu.delivery.modelos.DetallePedido;
import unitec.edu.delivery.modelos.Pedido;
import unitec.edu.delivery.modelos.Producto;
import unitec.edu.delivery.modelos.Usuario;
import unitec.edu.delivery.repositorio.DetallePedidoRepositorio;
import unitec.edu.delivery.repositorio.PedidoRepositorio;
import unitec.edu.delivery.repositorio.ProductoRepositorio;
import unitec.edu.delivery.repositorio.UsuarioRepositorio;

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

	@GetMapping("/index")
	public String index(@SessionAttribute("usuario") Optional<Usuario> usuario, HttpSession sesion) {

		if (usuario.get().getRol() == 2) {
			List<Usuario> empresas = usuariodb.findByRol1();
			sesion.setAttribute("listaEmpresa", empresas);
			return "index";
		} else if (usuario.get().getRol() == 1) {

			List<DetallePedido> pendientes = detallepedidodb.FindByPendientes(usuario.get().getId());

			sesion.setAttribute("pendientes", pendientes);

			return "indexcomercio";

		} else if (usuario.get().getRol() == 3) {

			return "indexmotorista";

		}
		return "";

	}

	@PostMapping("/ingresar")
	public String ingresar(

			@RequestParam("Usuario") String usuario, @RequestParam("Password") String pass, HttpSession sesion) {
		Optional<Usuario> existe = usuariodb.findFirst1ByUsuarioAndPass(usuario, pass);

		if (existe.isPresent()) {
			sesion.setAttribute("usuario", existe.get());
		} else {
			return "redirect:login.jsp";
		}

		return "redirect:./index";
	}

	@GetMapping("/productos")
	public String productos(@RequestParam(name = "empresa") Integer id, Model modal) {

		List<Producto> prod = productodb.findByUsuario(id);
		modal.addAttribute("productos", prod);
		return "productos";

	}

	@SuppressWarnings("unchecked")
	@PostMapping("/carrito")
	public String carrito(@RequestParam(name = "sesion") String orden, HttpSession session, Model modal) {
		Gson gson = new Gson();
		Map<String, Double> ordenCantidad = gson.fromJson(orden, Map.class);

		if (ordenCantidad != null) {
			List<DetallePedido> detalle = new ArrayList<DetallePedido>();
			ordenCantidad.forEach((k, v) -> {
				detalle.add(new DetallePedido(productodb.findById(Integer.valueOf(k)).get(), (int) Math.round(v)));
			});

			session.setAttribute("pedido", detalle);
			return "redirect:./ordenar.jsp?cantidad=" + ordenCantidad.keySet().size();
		} else {
			modal.addAttribute("carrito", 0);
			return "index";
		}

	}

	@GetMapping("/Logout")
	public String LogOut(HttpSession LogOut) {
		LogOut.invalidate();
		return "/login";
	}

	@PostMapping("/Crearusuario")
	public String CrearUsuario(@RequestParam(name = "Nombre") String Nombre,
			@RequestParam(name = "Direccion") String Direccion, @RequestParam(name = "Usuario") String Usuario,
			@RequestParam(name = "Password") String Password, @RequestParam(name = "Rol") Integer Rol,
			@RequestParam(name = "Correo") String Correo, @RequestParam(name = "Telefono") String Telefono,
			@RequestParam(name = "Foto") String Foto) {
		usuariodb.save(new Usuario(null, Nombre, Direccion, Correo, Telefono, Foto, Usuario, Password, Rol));
		// TODO: process POST request

		return "login";
	}

	@PostMapping("/Procesar")
	public String ProcesarOrden(@RequestParam(name = "subtotal") float subtotal,
			@RequestParam(name = "total") float total, @SessionAttribute(name = "pedido") List<DetallePedido> detalle,
			@SessionAttribute(name = "usuario") Usuario usuario, HttpSession session) {

		Usuario repartidor = usuariodb.findbyRepartidor(PageRequest.of(0, 1));

		Pedido pedido = new Pedido(null, subtotal, total, usuario, repartidor, usuario.getDireccion(), 1);

		pedido = pedidodb.save(pedido);

		System.out.println("Creo el pedido");

		for (DetallePedido detallePedido : detalle) {

			detallePedido.setPedido(pedido);
			detallePedido = detallepedidodb.save(detallePedido);

		}

		session.removeAttribute("pedido");

		// TODO: process POST request

		return "redirect:./index";
	}

	@GetMapping("ListarPedido")
	public String ListarPedido(Model modal, @SessionAttribute(name = "usuario") Usuario usuario) {

		List<Pedido> pedido = pedidodb.findByCliente(usuario);
		modal.addAttribute("listaPedido", pedido);

		return "listarPedidos";

	}

	@GetMapping("Sobre")
	public String Sobre() {

		return Sobre();
	}

}
