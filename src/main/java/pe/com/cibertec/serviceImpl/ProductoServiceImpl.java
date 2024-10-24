package pe.com.cibertec.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.cibertec.entity.ProductoEntity;
import pe.com.cibertec.repository.ProductoRepository;
import pe.com.cibertec.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{

	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public List<ProductoEntity> listarProductos() {
		
		return productoRepository.findAll();
	}

	@Override
	public void crearProducto(ProductoEntity productoEntity) {
		productoRepository.save(productoEntity);
	}

	@Override
	public ProductoEntity buscarPorId(Integer id) {
	
		return productoRepository.findById(id).get();
	}

	@Override
	public void actualizarProducto(Integer id, ProductoEntity productoActualizado) {
		ProductoEntity productoEncontrado = buscarPorId(id);
		if(productoEncontrado== null) {
			throw new RuntimeException("producto no encontrado");
		}
		try {
			productoEncontrado.setNombreProducto(productoActualizado.getNombreProducto());
			productoEncontrado.setPrecio(productoActualizado.getPrecio());
			productoEncontrado.setStock(productoActualizado.getStock());
			productoEncontrado.setCategoriaEntity(productoActualizado.getCategoriaEntity());
			
			productoRepository.save(productoEncontrado);
		} catch (Exception e) {
			throw new RuntimeException("Producto no encontrado ");
		}
		
	}

	@Override
	public void eliminarProducto(Integer id) {
		ProductoEntity productoEncontrado = buscarPorId(id);
		
		if(productoEncontrado==null) {
			throw new RuntimeException("Empleado no encontrado");
		}
		productoRepository.delete(productoEncontrado);
		
	}

}
