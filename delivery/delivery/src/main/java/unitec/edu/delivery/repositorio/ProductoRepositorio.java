package unitec.edu.delivery.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import unitec.edu.delivery.modelos.Producto;
import unitec.edu.delivery.modelos.Usuario;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer > {
	
    List<Producto> findByUsuario(Usuario usuario);
    
	
}
