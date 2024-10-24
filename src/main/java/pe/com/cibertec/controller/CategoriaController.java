package pe.com.cibertec.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import pe.com.cibertec.entity.CategoriaEntity;
import pe.com.cibertec.service.CategoriaService;

@Controller
@RequiredArgsConstructor
public class CategoriaController {
	
	private final CategoriaService categoriaService;

	
	
	
	
	@PostMapping("/agregarCategoria")
	public String agregarCategoria(@ModelAttribute("categoria") CategoriaEntity categoria,
			Model model) {
		categoriaService.crearCategoria(categoria);
		return "redirect:/productos/menu";
	}
}
