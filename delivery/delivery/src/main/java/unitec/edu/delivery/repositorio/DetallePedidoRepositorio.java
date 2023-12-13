package unitec.edu.delivery.repositorio;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import unitec.edu.delivery.modelos.DetallePedido;


@Repository

public interface DetallePedidoRepositorio extends JpaRepository<DetallePedido, Integer> {


}
