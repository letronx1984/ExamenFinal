package pe.com.cibertec.service;

import org.springframework.web.multipart.MultipartFile;

import pe.com.cibertec.entity.UsuarioEntity;

public interface UsuarioService {

	//needed methods to logeo (lo escribo en inglés porque me da amsiedad ver las rayas en los comentarios)
	void crearUsuario(UsuarioEntity usuarioEntity, MultipartFile foto);
	boolean validarUsuario(UsuarioEntity usuarioEntity);
	
}
