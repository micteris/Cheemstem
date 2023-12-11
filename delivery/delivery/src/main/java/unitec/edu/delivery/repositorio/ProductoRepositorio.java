package unitec.edu.delivery.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import unitec.edu.delivery.modelos.Producto;
import unitec.edu.delivery.modelos.Usuario;
@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer > {
	
	@Query("select p from Producto p inner join Usuario u on p.usuario=u where p.usuario.id=:id")
    List<Producto> findByUsuario( @Param("id") Integer id);
    
	
}
