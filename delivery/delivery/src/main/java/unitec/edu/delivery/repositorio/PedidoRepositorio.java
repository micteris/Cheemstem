package unitec.edu.delivery.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unitec.edu.delivery.modelos.Pedido;


@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido, Integer> {
	

}
