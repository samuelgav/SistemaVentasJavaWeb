package test;

import java.util.List;

import dao.ClienteDao;
import dao.ProductoDao;
import dao.UsuarioDao;
import dao.impl.ClienteDaoImpl;
import dao.impl.ProductoDaoImpl;
import dao.impl.UsuarioDaoImpl;
import model.Cliente;
import model.Producto;
import model.Usuario;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*ClienteDao dao=new ClienteDaoImpl();
		List<Cliente> list=dao.ConsultarClientes();
		for (Cliente cliente : list) {
			System.out.println("id: "+ cliente.getCodCliente()+ " nombres: "+cliente.getNombres());
		}*/
		
		/*String user="wcurasis";
		String pass="123";
		UsuarioDao dao=new UsuarioDaoImpl();
		Usuario usuario=dao.validarUsuario(user, pass);
		if(usuario !=null) {
		System.out.println(usuario.getNombreCompleto());
		}else {
			System.out.println("no hay datos");
		}*/
		
		Test test=new Test();
		test.insertProduct();
	}
	
	public void insertProduct() {
		Producto producto=new Producto();
		//producto.setNombreProducto("sandalias");
		producto.setCodProducto(1L);
		/*producto.setPrecioVenta(100);
		producto.setStockActual(100);
		producto.setStockMinimo(100);
		producto.setCodBarra("003");*/
		ProductoDao dao=new ProductoDaoImpl();
		dao.manageProduct(producto, 0);
	} 

}
