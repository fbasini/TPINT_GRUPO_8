package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoimpl.clienteDaoImpl;
import entidad.Cliente;

@WebServlet("/EliminarClientesServlet")
public class EliminarClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EliminarClientesServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idCliente = Integer.parseInt(request.getParameter("id"));
		clienteDaoImpl clienteDAO = new clienteDaoImpl();
		Cliente cliente = new Cliente();
		cliente.setIdCliente(idCliente);
		clienteDAO.eliminarCliente(cliente);
		response.sendRedirect("ListarClientesServlet");
	}

}
