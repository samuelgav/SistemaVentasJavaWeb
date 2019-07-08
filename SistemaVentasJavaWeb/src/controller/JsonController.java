package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.ClienteDao;
import dao.ProductoDao;
import dao.VendedorDao;
import dao.impl.ClienteDaoImpl;
import dao.impl.ProductoDaoImpl;
import dao.impl.VendedorDaoImpl;
import model.Cliente;
import model.Producto;
import model.Vendedor;

/**
 * Servlet implementation class JsonController
 */
@WebServlet("/JsonController")
public class JsonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private Gson gson = new Gson();
	
	ClienteDao clienteDao=new ClienteDaoImpl();
	VendedorDao vendedorDao=new VendedorDaoImpl();
	ProductoDao productoDao=new ProductoDaoImpl();
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void proccessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String json=request.getParameter("tabla");
		switch (json) {
		case "cliente":
			List<Cliente> list=clienteDao.ConsultarClientes();
			String clienteJsonString = this.gson.toJson(list);
			PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        out.print(clienteJsonString);
	        out.flush();
			break;
		case "vendedor":
			List<Vendedor> list2=vendedorDao.listVendedor();
			String vendedorJsonString = this.gson.toJson(list2);
			PrintWriter out2 = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        out2.print(vendedorJsonString);
	        out2.flush();
			break;
		case "producto":
			List<Producto> list3=productoDao.listProduct();
			String productoJsonString = this.gson.toJson(list3);
			PrintWriter out3 = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        out3.print(productoJsonString);
	        out3.flush();
			break;
		default:
			throw new AssertionError();
		}
	
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
		// TODO Auto-generated method stub
		proccessRequest(request, response);
	}

}
