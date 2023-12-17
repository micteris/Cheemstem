package unitec.edu.delivery.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import unitec.edu.delivery.dto.Recoger;
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
	
	@Query("select new unitec.edu.delivery.dto.Recoger(u.id,u.nombre,u.imagen,pe.id,u.direccion,dp.estado) from DetallePedido dp "
			+ " inner join Producto pr on dp.Producto=pr "
			+ " inner join Usuario u on pr.usuario=u "
			+ " inner join Pedido pe on dp.pedido=pe "
			+ " where pe.repartidor.id=:repartidor and dp.estado in (1,2) "
			+ " and dp.estado = (select min(dp2.estado) from  DetallePedido dp2 where dp2.pedido=pe"
			+ " and dp2.Producto.usuario=u)"
			+ " group by u.id,u.nombre,u.imagen,pe.id,u.direccion,dp.estado"
			)
	List<Recoger> findbyRecolectar(@Param("repartidor") Integer id);
	
	@Query("select dp from DetallePedido dp inner join Pedido p on dp.pedido=p "
			+ " inner join Producto pr on dp.Producto=pr "
			+ " inner join Usuario u on pr.usuario=u"
			+ " where p.id=:pedido and u.id=:empresa")
	List<DetallePedido> findbyRecogido(@Param("pedido") Integer id, @Param("empresa") Integer empresa);
	
	List<DetallePedido> findByPedido(Pedido pedido);


}
