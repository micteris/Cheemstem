package unitec.edu.delivery.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import unitec.edu.delivery.modelos.DetallePedido;
import unitec.edu.delivery.modelos.Pedido;


@Repository

public interface DetallePedidoRepositorio extends JpaRepository<DetallePedido, Integer> {
	
	@Query("select new  unitec.edu.delivery.modelos.DetallePedido(dp.id,p,pr,dp.Cantidad) from DetallePedido dp "
			+ " inner join Pedido p on dp.pedido=p "
			+ " inner join Producto pr on dp.Producto=pr"
			+ " inner join Usuario u on pr.usuario=u "
			+ " where u.id=:comercio and dp.estado=1")
	List<DetallePedido> FindByPendientes( @Param("comercio") Integer id);
	
	@Query("select count(dp) from DetallePedido dp where dp.pedido=:pedido and dp.estado<:estado")
	Integer findByPedido( @Param("pedido") Pedido pedido, @Param("estado")Integer estado);


}
