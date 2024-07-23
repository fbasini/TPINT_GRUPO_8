package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.Cliente;
import negocioImpl.clienteNegocioImpl;

@WebServlet("/manejarDatosServlet")
public class manejarDatosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public manejarDatosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		clienteNegocioImpl negCliente = new clienteNegocioImpl();
		HttpSession session = request.getSession();
		
		Cliente cliente = negCliente.obtenerClienteActual((int)session.getAttribute("idcliente"));
		session.setAttribute("clienteActual", cliente);
		
		response.sendRedirect("Cliente/MisDatos.jsp");
		
		
	}

	
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
