package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.ClienteDao;
import dao.ProductoDao;
import dao.impl.ClienteDaoImpl;
import dao.impl.ProductoDaoImpl;
import model.Cliente;
import model.DetalleFactura;
import model.Producto;
import model.Response;

/**
 * Servlet implementation class ManageController
 */
@WebServlet("/ManageController")
public class ManageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Producto producto=new Producto();
	ProductoDao productoDao=new ProductoDaoImpl();
	ClienteDao dao=new ClienteDaoImpl();
	private String json = null;
	float totalPagar=0;
	
	List<DetalleFactura> list=new ArrayList<>();
	
    public List<DetalleFactura> getList() {
		return list;
	}


	/**
     * @see HttpServlet#HttpServlet()
     */
    public ManageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
  
    protected void proccessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("op");
		switch (op) {
		/*case "add":
			String codBarra=request.getParameter("codBarra");
			producto=productoDao.getProductByCodBarra(codBarra);			
			list.add(new DetalleFactura(null, null, null, producto.getCodBarra(), producto.getNombreProducto(), 0, producto.getPrecioVenta(), new BigDecimal(0)));			
			request.getRequestDispatcher("/ManageController?op=show").forward(request, response);
			break;
		case "show":
			request.setAttribute("detalleproductos", getList());
			request.setAttribute("title", "Factura");
			request.getRequestDispatcher("views/insertVenta.jsp").forward(request, response);
			break;*/
		case "Buscar":
			String codbarra=request.getParameter("codbarra");
			producto=productoDao.getProductByCodBarra(codbarra);
			String selCliente=request.getParameter("selClientes");			
			request.setAttribute("listCliente", dao.ConsultarClientes());
			request.setAttribute("selectedClienteId", selCliente);
			request.setAttribute("title", "Factura");
			request.setAttribute("producto", producto);
			request.setAttribute("detalleproductos", list);
			request.setAttribute("totalPagar", totalPagar);
			request.getRequestDispatcher("views/insertVenta.jsp").forward(request, response);
			break;
		case "Agregar":
			DetalleFactura detalleFactura=new DetalleFactura();
			String codCliente=request.getParameter("selClientes");
			String codBarra=request.getParameter("codbarra");
			System.out.println(validar(codCliente, codBarra));
			if(validar(codCliente, codBarra).equals("")) {
				Integer cantidad=Integer.parseInt(request.getParameter("cantidad"));
				float precio=Float.parseFloat(request.getParameter("precio"));
				float subtotal=cantidad*precio;				
				detalleFactura.setCodBarra(codBarra);
				detalleFactura.setNombreProducto(request.getParameter("producto"));
				detalleFactura.setCantidad(cantidad);
				detalleFactura.setPrecioVenta(precio);			
				detalleFactura.setTotal(subtotal);
				list.add(detalleFactura);
				for(int i=0;i<list.size();i++) {
					totalPagar=totalPagar+list.get(i).getTotal();
				}
				request.setAttribute("totalPagar", totalPagar);
				request.setAttribute("detalleproductos", list);
			}else {
				request.setAttribute("message", validar(codCliente, codBarra));
			}
			request.setAttribute("listCliente", dao.ConsultarClientes());			
			request.setAttribute("title", "Factura");
			request.getRequestDispatcher("views/insertVenta.jsp").forward(request, response);
			break;
		case "edit":
			Long codProducto=Long.valueOf(request.getParameter("id"));
			producto=productoDao.getProductById(codProducto);			
			request.setAttribute("title", "Producto");
			request.setAttribute("formtitle", "Actualizacion de Productos");
			request.setAttribute("producto", producto);
			request.setAttribute("btnSave", "Actualizar");
			request.getRequestDispatcher("views/manageProduct.jsp").forward(request, response);
			break;
		case "delete":
			Long productoId=Long.valueOf(request.getParameter("productoId"));
			Response res=null;
			if(productoDao.deleteProduct(productoId)) {
				res=new Response("success", "Producto eliminado correctamente!!");
			}else {
				res=new Response("error", "Error al eliminar Producto!!");
			}
			json = new Gson().toJson(res);
            response.setContentType("application/json");
            response.getWriter().write(json);
			break;
		case "Registrar":
			request.setAttribute("title", "Home");
			boolean Resultado=false;
            String Mensaje="";
            try{
            Long id=Long.parseLong(request.getParameter("txtId"));
            String nombre=request.getParameter("nombre");
            float precioProducto=Float.parseFloat(request.getParameter("precio"));
            Integer stockminimo=Integer.parseInt(request.getParameter("stockminimo"));
            Integer stockactual=Integer.parseInt(request.getParameter("stockactual"));
            String cbarra=request.getParameter("cbarra");                      
            producto.setCodProducto(id);
            producto.setNombreProducto(nombre);
            producto.setPrecioVenta(precioProducto);
            producto.setStockMinimo(stockminimo);
            producto.setStockActual(stockactual);
            producto.setCodBarra(cbarra);
            
            if(producto.getCodProducto() == 0) {            	
            	Resultado=productoDao.manageProduct(producto, 1);
            }else {            	
            	Resultado=productoDao.manageProduct(producto, 2);
            }
            
            if(Resultado)
            {
                Mensaje="Operacion Exitosa";
            }else
            {
                Mensaje="Operacion Fallida al registrar";
            }
            json = new Gson().toJson(Mensaje);
            response.setContentType("application/json");
            response.getWriter().write(json);                                
            }catch(Exception ex)
            {
                Mensaje=ex.getMessage();
                json = new Gson().toJson("Error => "+ Mensaje);
                response.setContentType("application/json");
                response.getWriter().write(json);
            }

			break;		
		default:
			throw new AssertionError();
		}
	}
    
    public String validar(String codCliente,String codBarra) {
    	String msg="";
    	if(codCliente.equals("-1")) {
    		msg="Debe seleccionar a un cliente<br>";
    	}
    	if(codBarra.equals("") || codBarra==null) {
    		msg +="Debe ingresar el codigo de barra";
    	}
    	return msg;
    }
    
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		proccessRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proccessRequest(request, response);
	}
	
	
}
