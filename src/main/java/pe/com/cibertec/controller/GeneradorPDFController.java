package pe.com.cibertec.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
public class GeneradorPDFController {
	
	@GetMapping("/generarPDF")
	public ResponseEntity<InputStreamResource>generarPDF(HttpSession sesion){

		List<Pedido> productoSesion = null; 
		if(sesion.getAttribute("pdf") ==null) {
			productoSesion = new ArrayList<Pedido>();
			
		} else {
			productoSesion = (List<Pedido>)sesion.getAttribute("pdf");
		}
		List<DetallePedidoEntity> detallePedidoEntity = new ArrayList<DetallePedidoEntity>();
		Double 	totalPedido = 0.0;
		
		for(Pedido ped : productoSesion{
			DetallePedidoEntity det = new DetallePedidoEntity();
			
		}
	}
	
}
