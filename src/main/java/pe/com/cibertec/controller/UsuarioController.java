package pe.com.cibertec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import pe.com.cibertec.entity.UsuarioEntity;
import pe.com.cibertec.service.UsuarioService;



@RequiredArgsConstructor
@Controller
public class UsuarioController {
	private final UsuarioService usuarioService;
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("usuario", new UsuarioEntity());
		return "login";
	}
	@PostMapping("/login")
	public String logeado(@ModelAttribute("usuario")UsuarioEntity usuarioFormulario, 
			Model model, HttpSession sesion){
		boolean validaAUsuario = usuarioService.validarUsuario(usuarioFormulario);
		if(validaAUsuario) {
			sesion.setAttribute("usuario", usuarioFormulario.getNombreUsuario());
			System.out.println("Ingresó con el correo: " + usuarioFormulario.getCorreo());
			return "redirect:/productos/menu";
			
		}
		model.addAttribute("loginInvalido", "credenciales erroneas");
		model.addAttribute("usuario", new UsuarioEntity());
		return "login";
		
	}
	@GetMapping("/registrarUsuario")
	public String registrarUsuario(Model model) {
		
		model.addAttribute("usuario", new UsuarioEntity());
		return "registrarUsuario";
	}
	@PostMapping("/registrarUsuario")
	public String registrarUsuario(@ModelAttribute("usuario")UsuarioEntity usuarioFormulario,
			Model model, @RequestParam("foto") MultipartFile foto) {
		usuarioService.crearUsuario(usuarioFormulario, foto);
		return "redirect:/login";
	}
}
