package unitec.edu.delivery.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import unitec.edu.delivery.modelos.Pedido;
import unitec.edu.delivery.modelos.Usuario;


@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido, Integer> {
	
	List<Pedido> findByCliente(Usuario cliente);
	
	@Query("select p from Pedido p inner join Usuario u on p.repartidor=u"
			+ " where u.id=:usuario and p.estado!=4")
	List<Pedido> findbyRepartidor(@Param("usuario") Integer usuario);
	
	@Query("select p from Pedido p inner join Usuario u on p.repartidor=u "
			+ " inner join Usuario u2 on p.cliente=u2"
			+ " where u.id=:usuario and p.estado=3")
	List<Pedido> findbyEntregar(@Param("usuario") Integer id);
	

}
