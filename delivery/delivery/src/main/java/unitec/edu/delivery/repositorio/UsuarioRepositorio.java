package unitec.edu.delivery.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import unitec.edu.delivery.modelos.Usuario;
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>{
	
	Optional<Usuario> findFirst1ByUsuarioAndPass(String usuario,String pass);
	
	List<Usuario> findByRol(int rol);

}
