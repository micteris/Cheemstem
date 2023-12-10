package unitec.edu.delivery.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;
import unitec.edu.delivery.modelos.Usuario;
import unitec.edu.delivery.repositorio.UsuarioRepositorio;

@Controller
public class BackendWeb {
	@Autowired
	UsuarioRepositorio usuariodb;
	
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
				List<Usuario> empresas = usuariodb.findByRol(1);
				sesion.setAttribute("listaEmpresa", empresas);
				return "redirect:index.jsp";
			}
			return "redirect:index.jsp";
			
		}else {
			return "redirect:login.jsp";
		}
		
		
	}
	
	@GetMapping("/productos")
	public String productos(@RequestParam(name = "empresa") int id) {
		
		System.out.println(id);
		
		return "productos";
		
	}
	

}
