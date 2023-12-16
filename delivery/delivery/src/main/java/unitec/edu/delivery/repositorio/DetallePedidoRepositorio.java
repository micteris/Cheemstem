package unitec.edu.delivery.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unitec.edu.delivery.modelos.DetallePedido;


@Repository

public interface DetallePedidoRepositorio extends JpaRepository<DetallePedido, Integer> {


}
