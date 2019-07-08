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
import dao.impl.ClienteDaoImpl;
import dao.impl.ProductoDaoImpl;
import model.Cliente;
import model.Producto;

/**
 * Servlet implementation class PageController
 */
@WebServlet("/PageController")
public class PageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    ProductoDao productoDao=new ProductoDaoImpl();
    private Gson gson = new Gson();
    

    protected void proccessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ruta=request.getParameter("ruta");
		switch (ruta) {
		case "home":
			request.setAttribute("title", "Home");
			request.getRequestDispatcher("views/home.jsp").forward(request, response);
			break;
		case "listProduct":
			request.setAttribute("title", "Producto");
			request.getRequestDispatcher("views/listProducts.jsp").forward(request, response);
			break;
		case "insertProduct":
			request.setAttribute("title", "Producto");				
			request.setAttribute("formtitle", "Registro de Productos");
			request.setAttribute("btnSave", "Insertar");
			request.getRequestDispatcher("views/manageProduct.jsp").forward(request, response);
			break;
		case "listCliente":
			request.setAttribute("title", "Cliente");
			request.getRequestDispatcher("views/listCliente.jsp").forward(request, response);
			break;
		case "listVendedor":
			request.setAttribute("title", "Vendedor");
			request.getRequestDispatcher("views/listVendedor.jsp").forward(request, response);
			break;
		case "listVenta":
			request.setAttribute("title", "Factura");
			request.getRequestDispatcher("views/venta.jsp").forward(request, response);
			break;
		case "insertVenta":
			ClienteDao dao = new ClienteDaoImpl();
			List<Cliente> listCliente = dao.ConsultarClientes();
			request.setAttribute("title", "Factura");
			request.setAttribute("listCliente", listCliente);
			request.getRequestDispatcher("views/insertVenta.jsp").forward(request, response);
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
