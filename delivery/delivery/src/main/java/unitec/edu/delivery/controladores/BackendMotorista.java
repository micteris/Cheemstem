package unitec.edu.delivery.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import unitec.edu.delivery.dto.Recoger;
import unitec.edu.delivery.modelos.DetallePedido;
import unitec.edu.delivery.modelos.Pedido;
import unitec.edu.delivery.modelos.Usuario;
import unitec.edu.delivery.repositorio.DetallePedidoRepositorio;
import unitec.edu.delivery.repositorio.PedidoRepositorio;


@Controller
public class BackendMotorista {
	@Autowired
	DetallePedidoRepositorio detalledb;
	@Autowired
	PedidoRepositorio pedidodb;
	
	
	
	@GetMapping("/recolectar")
	public String recolectar(
			@SessionAttribute(name = "usuario",required = true) Usuario usuario
			,Model modal
			) {
		
		List<Recoger> recolecion = detalledb.findbyRecolectar(usuario.getId());
		
		
		modal.addAttribute("recolectar", recolecion);
		
		return "recolectar";
	}
	
	@GetMapping("/estadorecogido")
	@Transactional
	public String estadoRecolectar(
			@RequestParam("id") Integer id,
			@RequestParam("estado") Integer estado,
			@RequestParam("empresa") Integer empresa
			) {
		
		List<DetallePedido> detalle = detalledb.findbyRecogido(id,empresa);
		
		detalle.forEach(p->{
			p.setEstado(estado);
		});
		
		Integer cantidad = detalle.size();
		
		if (cantidad>0) {
			
			Pedido pedido = detalle.get(0).getPedido();
			
			Integer faltantes = detalledb.findByPedido(pedido, estado);
			
			if (faltantes<cantidad+1) {
				pedido.setEstado(estado);
			}
			
		}
		
		return "redirect:./recolectar";
	}
	
	@GetMapping("/entregar")
	public String getMethodName(
			@SessionAttribute("usuario") Usuario usuario
			,Model modal
			) {
		
		List<Pedido> pedido = pedidodb.findbyEntregar(usuario.getId());
		
		modal.addAttribute("entregables", pedido);
		
		return "listaEntregable";
	}
	
	@GetMapping("/estadoentregado")
	@Transactional
	public String estadoentregado(
			@RequestParam("id") Integer id,
			@RequestParam("estado")Integer estado
			) {
		
		Pedido pedido = pedidodb.findById(id).get();
		
		List<DetallePedido> detalle = detalledb.findByPedido(pedido);
		
		detalle.forEach(d->{
			d.setEstado(estado);
		});
		pedido.setEstado(estado);
		
		return "redirect:./entregar";
	}
	
	
	
	

}
