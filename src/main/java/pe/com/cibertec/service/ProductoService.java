package pe.com.cibertec.service;

import java.util.List;

import pe.com.cibertec.entity.ProductoEntity;

public interface ProductoService {

	
	List<ProductoEntity> listarProductos();
	void crearProducto(ProductoEntity productoEntity);
	ProductoEntity buscarPorId(Integer id);
	void actualizarProducto(Integer id, ProductoEntity productoEntity);
	void eliminarProducto(Integer id);


}

