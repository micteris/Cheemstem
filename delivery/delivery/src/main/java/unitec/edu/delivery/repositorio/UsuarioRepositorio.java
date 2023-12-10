package unitec.edu.delivery.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import unitec.edu.delivery.modelos.Usuario;
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>{
	
	@Query("select new unitec.edu.delivery.modelos.Usuario(u.id,u.nombre,u.direccion,u.correo,u.telefono,u.imagen,u.rol) "
			+ " from Usuario u where u.usuario=:usuario and u.pass=:pass")
	Optional<Usuario> findFirst1ByUsuarioAndPass(@Param("usuario") String usuario,
			@Param("pass") String pass);
	
	@Query("select new unitec.edu.delivery.modelos.Usuario(u.id,u.nombre,u.direccion,u.correo,u.telefono,u.imagen,u.rol) "
			+ "from Usuario u where u.rol=1")
	List<Usuario> findByRol1();

}
