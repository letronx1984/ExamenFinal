package pe.com.cibertec.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import pe.com.cibertec.entity.UsuarioEntity;
import pe.com.cibertec.repository.UsuarioRepository;
import pe.com.cibertec.service.UsuarioService;
import pe.com.cibertec.utils.Utilitarios;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService{

	private final UsuarioRepository ur;
	
	@Override
	public void crearUsuario(UsuarioEntity usuarioEntity, MultipartFile foto) {
		
		String urlFoto = Utilitarios.guardarImagen(foto);
		usuarioEntity.setUrlFoto(urlFoto);
		String passwordHash = Utilitarios.hashearPassword(usuarioEntity.getPassword());
		usuarioEntity.setPassword(passwordHash);
		
		ur.save(usuarioEntity);
	}

	@Override
	public boolean validarUsuario(UsuarioEntity usuarioFormulario) {
		
		//search any email in database
		UsuarioEntity usuarioEncontrado = ur.findByCorreo
				(usuarioFormulario.getCorreo());
		
		if(!Utilitarios.checkPassword(usuarioFormulario.getPassword(),
				usuarioEncontrado.getPassword())) {
			return false;
		}
		return true;
	}

	
	
	
}
