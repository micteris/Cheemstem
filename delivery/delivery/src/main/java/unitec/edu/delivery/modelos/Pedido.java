package unitec.edu.delivery.modelos;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Pedido")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Pedido")
	Integer id;
	@Column(name = "Pedido_Precio")
	float  Subtotal;
	@Column(name = "Pedido_Total")
	float Total;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Cliente_ID")
	Usuario cliente;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Repartidor_ID")
	Usuario repartidor;
	@Column(name = "Ubicacion")
	String Ubicacion;
	
	@OneToMany(mappedBy = "Pedido",cascade = CascadeType.ALL)
	List<DetallePedido> detalle;
	

}
