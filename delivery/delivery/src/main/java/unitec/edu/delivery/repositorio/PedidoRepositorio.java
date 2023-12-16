package unitec.edu.delivery.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import unitec.edu.delivery.modelos.Pedido;
import unitec.edu.delivery.modelos.Usuario;


@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido, Integer> {
	
	List<Pedido> findByCliente(Usuario cliente);
	

}
