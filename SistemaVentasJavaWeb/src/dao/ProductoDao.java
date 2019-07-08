package dao;

import java.util.List;

import model.Producto;

public interface ProductoDao {

	public List<Producto> listProduct();
	public Producto getProductById(Long id);
	public Producto getProductByCodBarra(String codBarra);
	public boolean manageProduct(Producto producto,Integer modo);
	public boolean deleteProduct(Long id);
	
}
