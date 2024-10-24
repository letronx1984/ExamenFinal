package pe.com.cibertec.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import pe.com.cibertec.entity.CategoriaEntity;
import pe.com.cibertec.entity.ProductoEntity;
import pe.com.cibertec.service.CategoriaService;
import pe.com.cibertec.service.ProductoService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/productos")
public class ProductosController {
	
	private final CategoriaService categoriaService;
	private final ProductoService productoService;
	
	
	@GetMapping("/menu")
	public String menu(Model model, HttpSession sesion) {
		
		List<CategoriaEntity> listadoCategoria= categoriaService.listarCategoria();
		List<ProductoEntity> listadoProductos = productoService.listarProductos();
		model.addAttribute("listaCategoria",listadoCategoria);
		model.addAttribute("listaProductos",listadoProductos);
		return "listadoProductos";
	}
	
	@PostMapping("/registroProducto")
	public String registroProductos(@ModelAttribute("producto") ProductoEntity productoEntity, Model model) {
		List<CategoriaEntity> listaCategoria =  categoriaService.listarCategoria();
		model.addAttribute("categorias",listaCategoria);
		model.addAttribute("producto", new ProductoEntity());
		productoService.crearProducto(productoEntity);
		return "redirect:/productos/menu";
	}
	
	@GetMapping("/eliminarProducto/{id}")
	public String eliminarProducto(@PathVariable("id") Integer id) {
		productoService.eliminarProducto(id);
		
		return "redirect:/productos/menu";
	}
	
	@GetMapping("/editarProducto/{id}")
	public String editarProducto(@PathVariable("id")Integer id,Model model) {
		ProductoEntity productoEncontrado = productoService.buscarPorId(id);
		List<CategoriaEntity> listarCategoria = categoriaService.listarCategoria();
		model.addAttribute("categoria", listarCategoria);
		model.addAttribute("producto",productoEncontrado);
		
		return "editarProducto";
	}
	@PostMapping("/editarProducto/{id}")
	public String editarProducto(@PathVariable("id")Integer id,
			@ModelAttribute("producto") ProductoEntity producto, Model model) {
		productoService.actualizarProducto(id, producto);
		
		return "redirect:/productos/menu";
	}
}