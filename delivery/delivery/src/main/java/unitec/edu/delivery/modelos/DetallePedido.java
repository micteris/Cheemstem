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
@Table(name = "DetallePedido")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class DetallePedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_DetallePedido")
	Integer id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Pedido_ID")
	Pedido Pedido;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Producto_ID")
	Producto Producto;
	@Column(name = "Cantidad")
	Integer Cantidad;
	
	public DetallePedido(Producto producto,Integer cantidad) {
		this.Producto=producto;
		this.Cantidad=cantidad;
	}
	
	

}
