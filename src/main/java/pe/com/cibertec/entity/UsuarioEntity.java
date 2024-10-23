package pe.com.cibertec.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

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
@Table(name="tb_usuario")
public class UsuarioEntity {

	@Id
	@Column(name="correo_usuario", nullable = false, unique=true, columnDefinition="VARCHAR(70)")
	private String correo;
	
	@Column(name="contrasenia_usuario", nullable=false)
	private String password;
	@Column(name="nombre_usuario", nullable =false,columnDefinition="VARCHAR(70)")
	private String nombreUsuario;
	@Column(name="apellido_usuario", nullable=false,columnDefinition="VARCHAR(70)")
	private String apellidoUsuario;
	@Column(name="fecha_nacimiento_usuario", nullable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	@Column(name="url_foto_usuario", nullable=false)
	private String urlFoto;
	
	
}
