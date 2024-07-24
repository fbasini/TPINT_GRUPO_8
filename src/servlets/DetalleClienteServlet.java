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
import negocioImpl.clienteNegocioImpl;


@WebServlet("/DetalleClienteServlet")
public class DetalleClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DetalleClienteServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		clienteNegocioImpl negCliente = new clienteNegocioImpl();
        HttpSession session = request.getSession();
        
        Object idClienteObj = request.getParameter("idCliente");
        if (idClienteObj == null) {
            System.out.println("Error");
            return;
        }
        
        int idCliente;
        try {
            idCliente = Integer.parseInt((String) idClienteObj);
        } catch (NumberFormatException e) {
        	System.out.println("Error");
            return;
        }
        
        Cliente cliente = negCliente.obtenerClienteActual(idCliente);
        if (cliente == null) {
        	System.out.println("Error");
            return;
        }
        
        session.setAttribute("clienteActual", cliente);
        response.sendRedirect("Cliente/DetalleCliente.jsp");
    }

}
