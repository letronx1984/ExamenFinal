package pe.com.cibertec.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductoEntity {

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_producto", nullable=false, unique=true)
	private Integer id;
	
	private String nombreProducto;
	
	private Double precio;
	
	private Integer stock;
	
	//category 
	@ManyToOne
	@JoinColumn(name="categoria_id", nullable=false)
	private CategoriaEntity categoriaEntity;
	
	
}
