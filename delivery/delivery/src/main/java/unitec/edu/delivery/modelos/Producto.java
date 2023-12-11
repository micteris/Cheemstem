package unitec.edu.delivery.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Producto")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Producto")
	Integer id;
	@Column(name = "Producto_Descripcion")
	String  Descripcon;
	@Column(name = "Producto_Imagen")
	String  Imagen;
	@Column(name = "Producto_Nombre")
	String  Nombre;
	@Column(name = "Producto_Precio")
	Float  Precio;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_Comercio")
	Usuario  usuario;
	@Column(name = "Producto_Rating")
	Float Rating;
}
