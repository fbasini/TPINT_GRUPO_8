package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.Cliente;
import entidad.Provincias;
import negocioImpl.clienteNegocioImpl;

@WebServlet("/primerIngresoServlet")
public class primerIngresoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public primerIngresoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		clienteNegocioImpl negCliente = new clienteNegocioImpl();
		HttpSession session = request.getSession();
						
		ArrayList<Provincias> listaProvincias = negCliente.obtenerProvincias();
		session.setAttribute("listaProvincias", listaProvincias);
		
		response.sendRedirect("Cliente/MiPrimerIngreso.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
