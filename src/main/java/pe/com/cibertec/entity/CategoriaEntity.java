package pe.com.cibertec.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class CategoriaEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_categoria", nullable=false, unique=true)
	private Integer idCategoria;
	
	@Column(name="nombre_categoria", nullable=false)
	private String nombreCategoria;
	
	
}
