package unitec.edu.delivery.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Usuario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Usuario")
	Integer id;
	@Column(name = "Usuario_nombre")
	String nombre;
	@Column(name = "Usuario_Direccion")
	String direccion;
	@Column(name = "Usuario_Correo")
	String correo;
	@Column(name = "Usuario_Telefono")
	String telefono;
	@Column(name = "Usuario_Photo")
	String imagen;
	@Column(name = "Usuario_User")
	String usuario;
	@Column(name = "Usuario_pass")
	String pass;
	@Column(name = "Usuario_Rol")
	int rol;
	
	public Usuario(Integer id,String nombre,String direccion,String correo,String telefono,String imagen,int rol) {
		this.id=id;
		this.nombre=nombre;
		this.direccion=direccion;
		this.correo=correo;
		this.telefono=telefono;
		this.imagen=imagen;
		this.rol=rol;
	}
	

}
